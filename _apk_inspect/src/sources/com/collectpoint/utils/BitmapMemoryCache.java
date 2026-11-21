package com.collectpoint.utils;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class BitmapMemoryCache {
    public static final String BITMAP_CLEAR_STATUS_AUTO = "0";
    public static final String BITMAP_CLEAR_STATUS_MANUAL = "1";
    private static final String TAG = "BitmapMemoryCache";
    private Map<String, Bitmap> mMapBitmap = Collections.synchronizedMap(new LinkedHashMap(10, 1.5f, true));
    private long mHeapSize = 0;
    private long mMaxHeapSize = 1000000;

    public BitmapMemoryCache() {
        setMaxHeapSize(Runtime.getRuntime().maxMemory() / 4);
    }

    private void checkSize() {
        if (this.mHeapSize > this.mMaxHeapSize) {
            Log.i(TAG, "cache size=" + this.mHeapSize + ", length=" + this.mMapBitmap.size());
            Iterator<Map.Entry<String, Bitmap>> it = this.mMapBitmap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Bitmap> next = it.next();
                if (next.getKey().endsWith(BITMAP_CLEAR_STATUS_AUTO)) {
                    Bitmap value = next.getValue();
                    this.mHeapSize -= getSizeInBytes(value);
                    if (value != null && !value.isRecycled()) {
                        value.recycle();
                    }
                    it.remove();
                    if (this.mHeapSize <= this.mMaxHeapSize) {
                        break;
                    }
                }
            }
            Log.i(TAG, "Clean cache. New size=" + this.mHeapSize + ",length=" + this.mMapBitmap.size());
        }
    }

    private long getSizeInBytes(Bitmap bitmap) {
        if (bitmap == null) {
            return 0L;
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    private String getUsedUIByKey(String str) {
        int iLastIndexOf = str.lastIndexOf("_");
        int length = str.length();
        return (iLastIndexOf < 0 || iLastIndexOf >= length) ? "" : str.substring(iLastIndexOf + 1, length - 1);
    }

    public void clear() {
        Iterator<Map.Entry<String, Bitmap>> it = this.mMapBitmap.entrySet().iterator();
        while (it.hasNext()) {
            Bitmap value = it.next().getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.mMapBitmap.clear();
        this.mHeapSize = 0L;
    }

    public void clearCacheByUsedUI(String str) {
        if (str == null || str.isEmpty()) {
            clear();
            return;
        }
        Iterator<Map.Entry<String, Bitmap>> it = this.mMapBitmap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Bitmap> next = it.next();
            if (str.equals(getUsedUIByKey(next.getKey()))) {
                Bitmap value = next.getValue();
                if (value != null && !value.isRecycled()) {
                    this.mHeapSize -= getSizeInBytes(value);
                    value.recycle();
                }
                it.remove();
            }
        }
    }

    public void destroyBitmap(String str) {
        if (this.mMapBitmap.containsKey(str)) {
            Bitmap bitmap = this.mMapBitmap.get(str);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            this.mMapBitmap.remove(str);
        }
    }

    public Bitmap get(String str) {
        if (this.mMapBitmap.containsKey(str)) {
            return this.mMapBitmap.get(str);
        }
        return null;
    }

    public Bitmap put(String str, Bitmap bitmap) {
        Bitmap bitmap2;
        if (!this.mMapBitmap.containsKey(str) || (bitmap2 = this.mMapBitmap.get(str)) == null) {
            this.mMapBitmap.put(str, bitmap);
            this.mHeapSize += getSizeInBytes(bitmap);
            checkSize();
            return bitmap;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    public Bitmap putNetBitmap(String str, Bitmap bitmap) {
        if (!this.mMapBitmap.containsKey(str)) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return null;
        }
        for (Map.Entry<String, Bitmap> entry : this.mMapBitmap.entrySet()) {
            if (entry.getKey().equals(str)) {
                Bitmap value = entry.getValue();
                if (value != null) {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    return value;
                }
                entry.setValue(bitmap);
                this.mHeapSize += getSizeInBytes(bitmap);
                checkSize();
                return bitmap;
            }
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return null;
    }

    public void setMaxHeapSize(long j) {
        this.mMaxHeapSize = j;
        Log.i(TAG, "BitmapMemoryCache will use up to " + ((this.mMaxHeapSize / 1024) / 1024) + "MB");
    }
}
