package com.collectpoint.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Environment;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.constants.Constants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class LoadBitmapHelper {
    public static final String APP_CACHE_DIR;
    private static final int COMPRESS_BITMAP_READ_HEIGHT = 800;
    private static final int COMPRESS_BITMAP_READ_WIDTH = 800;
    private static final int GET_URL_IMAGE_TIME_OUT = 15000;
    private static final int LOAD_IMAGE_FAILED_ID = 2131230964;
    private static final int NOT_LOADED_IMAGE_ID = 2131230964;
    private static final String TAG = "LoadImageHelper";
    public static final String TEMP_CACHE_DIR;
    public static final String TEMP_CACHE_LEVEL_1_CACHE;
    public static final String TEMP_CACHE_LEVEL_2_CACHE;
    private static final int THREAD_COUNT = 5;
    private static LoadBitmapHelper instance;
    private final BitmapFactory.Options OPTION_DECODE;
    private final BitmapFactory.Options OPTION_GET_SIZE;
    private final Size ZERO_SIZE = new Size(0, 0);
    private BitmapMemoryCache bitmapCache;
    private ExecutorService executorService;
    private HashMap<String, HashSet<NetImageShowData>> mRequestUrlMap;

    private class ImageDisplayer implements Runnable {
        String dir;
        int height;
        ImageView imageView;
        String url;
        String usedUI;
        int width;

        public ImageDisplayer(String str, String str2, int i, int i2, String str3, ImageView imageView) {
            this.url = str;
            this.dir = str2;
            this.width = i;
            this.height = i2;
            this.usedUI = str3;
            this.imageView = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = this.imageView;
            if (imageView == null || imageView.getTag() == null || !this.imageView.getTag().equals(this.url)) {
                return;
            }
            LoadBitmapHelper.this.DisplayImage(this.url, this.dir, this.width, this.height, this.usedUI, this.imageView);
        }
    }

    private class ImageLoadFailedDisplay implements Runnable {
        ImageView imageView;

        public ImageLoadFailedDisplay(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = this.imageView;
            if (imageView != null) {
                imageView.setImageResource(2131230964);
            }
        }
    }

    private class ImageLoader implements Runnable {
        ImageToLoad imageToLoad;

        public ImageLoader(ImageToLoad imageToLoad) {
            this.imageToLoad = imageToLoad;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            Bitmap bitmapByUrl = LoadBitmapHelper.this.getBitmapByUrl(this.imageToLoad.url);
            if (bitmapByUrl == null) {
                HashSet hashSet = (HashSet) LoadBitmapHelper.this.mRequestUrlMap.get(this.imageToLoad.url);
                if (hashSet == null) {
                    return;
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    NetImageShowData netImageShowData = (NetImageShowData) it.next();
                    if (netImageShowData.imageView != null) {
                        ((Activity) netImageShowData.imageView.getContext()).runOnUiThread(LoadBitmapHelper.this.new ImageLoadFailedDisplay(netImageShowData.imageView));
                    }
                }
                if (this.imageToLoad.imgLoadListener != null) {
                    this.imageToLoad.imgLoadListener.onFailed();
                }
                LoadBitmapHelper.this.mRequestUrlMap.remove(this.imageToLoad.url);
                return;
            }
            String strSubstring = "";
            if (this.imageToLoad.dir != null && !this.imageToLoad.dir.isEmpty()) {
                if (this.imageToLoad.nameType == 1) {
                    strSubstring = (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() + ((int) (Math.floor(Math.random() * 9000.0d) + 1000.0d))) + this.imageToLoad.url.substring(this.imageToLoad.url.lastIndexOf("."));
                } else {
                    strSubstring = this.imageToLoad.url.substring(this.imageToLoad.url.lastIndexOf("/") + 1);
                }
                try {
                    LoadBitmapHelper.this.saveBitmap(bitmapByUrl, this.imageToLoad.dir, strSubstring);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            bitmapByUrl.recycle();
            if (this.imageToLoad.imgLoadListener != null) {
                this.imageToLoad.imgLoadListener.onSuccess(strSubstring, this.imageToLoad.param);
            }
            HashSet hashSet2 = (HashSet) LoadBitmapHelper.this.mRequestUrlMap.get(this.imageToLoad.url);
            if (hashSet2 == null) {
                return;
            }
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                NetImageShowData netImageShowData2 = (NetImageShowData) it2.next();
                if (netImageShowData2.imageView != null) {
                    ((Activity) netImageShowData2.imageView.getContext()).runOnUiThread(LoadBitmapHelper.this.new ImageDisplayer(this.imageToLoad.url, this.imageToLoad.dir, netImageShowData2.width, netImageShowData2.height, netImageShowData2.usedUI, netImageShowData2.imageView));
                }
            }
            LoadBitmapHelper.this.mRequestUrlMap.remove(this.imageToLoad.url);
        }
    }

    private class ImageToLoad {
        public static final int NAME_TYPE_FILE_NAME = 0;
        public static final int NAME_TYPE_TIME = 1;
        public String dir;
        public onImgLoadResultListener imgLoadListener;
        public int nameType;
        private int param;
        public String url;

        public ImageToLoad(String str, String str2) {
            this.nameType = 0;
            this.imgLoadListener = null;
            this.param = 0;
            this.url = str;
            this.dir = str2;
        }

        public ImageToLoad(String str, String str2, int i, onImgLoadResultListener onimgloadresultlistener, int i2) {
            this.nameType = 0;
            this.imgLoadListener = null;
            this.param = 0;
            this.url = str;
            this.dir = str2;
            this.nameType = i;
            this.imgLoadListener = onimgloadresultlistener;
            this.param = i2;
        }
    }

    private class NetImageShowData {
        public int height;
        public ImageView imageView;
        public String usedUI;
        public int width;

        public NetImageShowData(int i, int i2, String str, ImageView imageView) {
            this.width = i;
            this.height = i2;
            this.usedUI = str;
            this.imageView = imageView;
        }
    }

    private class Size {
        private int height;
        private int width;

        Size(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }
    }

    public interface onImgLoadResultListener {
        void onFailed();

        void onSuccess(String str, int i);
    }

    static {
        String str = Environment.getExternalStorageDirectory() + "/etPath/";
        APP_CACHE_DIR = str;
        TEMP_CACHE_DIR = str + "Temp/";
        TEMP_CACHE_LEVEL_1_CACHE = str + "TempLevel1/";
        TEMP_CACHE_LEVEL_2_CACHE = str + "TempLevel2/";
        instance = new LoadBitmapHelper();
    }

    public LoadBitmapHelper() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.OPTION_GET_SIZE = options;
        this.OPTION_DECODE = new BitmapFactory.Options();
        this.bitmapCache = new BitmapMemoryCache();
        this.executorService = null;
        options.inJustDecodeBounds = true;
        this.executorService = Executors.newFixedThreadPool(5);
        this.mRequestUrlMap = new HashMap<>();
    }

    private void closeInputStream(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                Log.v(TAG, "closeInputStream==" + e.toString());
            }
        }
    }

    private Bitmap createBitmap(String str, int i, int i2) throws IOException {
        Bitmap bitmapDecodeStream;
        File file = new File(str);
        if (file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                Size bitmapSize = getBitmapSize(str);
                if (bitmapSize.equals(this.ZERO_SIZE)) {
                    return null;
                }
                int width = 1;
                int height = 1;
                if (i > 0) {
                    width = bitmapSize.getWidth() / i;
                    if (bitmapSize.getWidth() % i != 0) {
                        width++;
                    }
                }
                if (i2 > 0) {
                    height = bitmapSize.getHeight() / i2;
                    if (bitmapSize.getHeight() % i2 != 0) {
                        height++;
                    }
                }
                int iMax = Math.max(width, height);
                synchronized (this.OPTION_DECODE) {
                    this.OPTION_DECODE.inSampleSize = iMax;
                    bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream, null, this.OPTION_DECODE);
                    int imageDegree = getImageDegree(str);
                    if (imageDegree != 0) {
                        bitmapDecodeStream = rotateBitmap(imageDegree, bitmapDecodeStream);
                    }
                }
                return bitmapDecodeStream;
            } catch (FileNotFoundException e) {
                Log.v(TAG, "createBitmap==" + e.toString());
            } finally {
                closeInputStream(fileInputStream);
            }
        }
        return null;
    }

    private String createKey(String str, int i, int i2, String str2, String str3) {
        return (str == null || str.isEmpty()) ? "" : (str3 == BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO || str3 == "1") ? str + "_" + i + "_" + i2 + "_" + str2 + str3 : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getBitmapByUrl(String str) throws IOException {
        Bitmap bitmapDecodeStream = null;
        InputStream inputStream = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(GET_URL_IMAGE_TIME_OUT);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmapDecodeStream;
        } finally {
            closeInputStream(inputStream);
        }
    }

    private Size getBitmapSize(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            return this.ZERO_SIZE;
        }
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            BitmapFactory.decodeStream(fileInputStream, null, this.OPTION_GET_SIZE);
            return new Size(this.OPTION_GET_SIZE.outWidth, this.OPTION_GET_SIZE.outHeight);
        } catch (FileNotFoundException e) {
            return this.ZERO_SIZE;
        } finally {
            closeInputStream(fileInputStream);
        }
    }

    private int getImageDegree(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
                case 3:
                    break;
                case Constants.RED_PAGE /* 6 */:
                    break;
                case Constants.RED_MAP_LOCATE /* 8 */:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static LoadBitmapHelper getInstance() {
        return instance;
    }

    public static Bitmap getViewBitmap(View view) {
        view.clearFocus();
        view.setPressed(false);
        boolean zWillNotCacheDrawing = view.willNotCacheDrawing();
        view.setWillNotCacheDrawing(false);
        int drawingCacheBackgroundColor = view.getDrawingCacheBackgroundColor();
        view.setDrawingCacheBackgroundColor(0);
        if (drawingCacheBackgroundColor != 0) {
            view.destroyDrawingCache();
        }
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawingCache);
        view.destroyDrawingCache();
        view.setWillNotCacheDrawing(zWillNotCacheDrawing);
        view.setDrawingCacheBackgroundColor(drawingCacheBackgroundColor);
        return bitmapCreateBitmap;
    }

    private void queueImageLoad(String str, String str2) {
        this.executorService.submit(new ImageLoader(new ImageToLoad(str, str2)));
    }

    private void queueImageLoad(String str, String str2, int i, onImgLoadResultListener onimgloadresultlistener, int i2) {
        this.executorService.submit(new ImageLoader(new ImageToLoad(str, str2, i, onimgloadresultlistener, i2)));
    }

    private Bitmap rotateBitmap(int i, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (i == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    public void DisplayImage(String str, String str2, int i, int i2, String str3, ImageView imageView) {
        if (str == null || str.isEmpty() || imageView == null) {
            return;
        }
        imageView.setTag(str);
        if (str2 == null || str2.isEmpty()) {
            Bitmap bitmap = this.bitmapCache.get(createKey(str, i, i2, str3, BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO));
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
        } else if (DisplayLocalImage(str.substring(str.lastIndexOf("/") + 1), str2, i, i2, str3, imageView)) {
            return;
        }
        HashSet<NetImageShowData> hashSet = this.mRequestUrlMap.get(str);
        if (hashSet == null) {
            HashSet<NetImageShowData> hashSet2 = new HashSet<>();
            hashSet2.add(new NetImageShowData(i, i2, str3, imageView));
            this.mRequestUrlMap.put(str, hashSet2);
            queueImageLoad(str, str2);
        } else {
            hashSet.add(new NetImageShowData(i, i2, str3, imageView));
        }
        imageView.setImageResource(2131230964);
    }

    public void DisplayImage(String str, String str2, int i, int i2, String str3, ImageView imageView, int i3) {
        if (str == null || str.isEmpty() || imageView == null) {
            return;
        }
        imageView.setTag(str);
        if (str2 == null || str2.isEmpty()) {
            Bitmap bitmap = this.bitmapCache.get(createKey(str, i, i2, str3, BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO));
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
        } else if (DisplayLocalImage(str.substring(str.lastIndexOf("/") + 1), str2, i, i2, str3, imageView)) {
            return;
        }
        HashSet<NetImageShowData> hashSet = this.mRequestUrlMap.get(str);
        if (hashSet == null) {
            HashSet<NetImageShowData> hashSet2 = new HashSet<>();
            hashSet2.add(new NetImageShowData(i, i2, str3, imageView));
            this.mRequestUrlMap.put(str, hashSet2);
            queueImageLoad(str, str2);
        } else {
            hashSet.add(new NetImageShowData(i, i2, str3, imageView));
        }
        imageView.setImageResource(i3);
    }

    public void DisplayImageManual(String str, String str2, int i, int i2, String str3, ImageView imageView) {
        if (str == null || str.isEmpty() || imageView == null) {
            return;
        }
        imageView.setTag(str);
        if (str2 == null || str2.isEmpty()) {
            Bitmap bitmap = this.bitmapCache.get(createKey(str, i, i2, str3, "1"));
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
        } else if (DisplayLocalImageManual(str.substring(str.lastIndexOf("/") + 1), str2, i, i2, str3, imageView)) {
            return;
        }
        HashSet<NetImageShowData> hashSet = this.mRequestUrlMap.get(str);
        if (hashSet == null) {
            HashSet<NetImageShowData> hashSet2 = new HashSet<>();
            hashSet2.add(new NetImageShowData(i, i2, str3, imageView));
            this.mRequestUrlMap.put(str, hashSet2);
            queueImageLoad(str, str2);
        } else {
            hashSet.add(new NetImageShowData(i, i2, str3, imageView));
        }
        imageView.setImageResource(2131230964);
    }

    public boolean DisplayLocalImage(String str, String str2, int i, int i2, String str3, ImageView imageView) {
        Bitmap bitmap;
        if (imageView == null || (bitmap = getBitmap(str, str2, i, i2, str3)) == null) {
            return false;
        }
        imageView.setImageBitmap(bitmap);
        return true;
    }

    public boolean DisplayLocalImageManual(String str, String str2, int i, int i2, String str3, ImageView imageView) {
        Bitmap bitmapManual;
        if (imageView == null || (bitmapManual = getBitmapManual(str, str2, i, i2, str3)) == null) {
            return false;
        }
        imageView.setImageBitmap(bitmapManual);
        return true;
    }

    public void clearCache() {
        this.bitmapCache.clear();
    }

    public void clearCacheByUsedUI(String str) {
        this.bitmapCache.clearCacheByUsedUI(str);
    }

    public boolean compressBitmapSave(String str, int i, int i2, String str2, String str3) throws IOException {
        Bitmap bitmapCreateScaledBitmap;
        Bitmap bitmapCreateBitmap = createBitmap(str, 800, 800);
        if (bitmapCreateBitmap == null) {
            if (str.equals(TEMP_CACHE_LEVEL_2_CACHE)) {
                bitmapCreateBitmap = createBitmap(TEMP_CACHE_DIR, 800, 800);
                if (bitmapCreateBitmap == null) {
                    bitmapCreateBitmap = createBitmap(TEMP_CACHE_LEVEL_1_CACHE, 800, 800);
                }
            } else if (str.equals(TEMP_CACHE_LEVEL_1_CACHE)) {
                bitmapCreateBitmap = createBitmap(TEMP_CACHE_DIR, 800, 800);
            }
        }
        if (bitmapCreateBitmap == null) {
            return false;
        }
        int width = bitmapCreateBitmap.getWidth();
        int height = bitmapCreateBitmap.getHeight();
        if (width > i || height > i2) {
            float f = width / i;
            float f2 = height / i2;
            if (f > f2) {
                i2 = (int) (height / f);
            } else if (f2 > f) {
                i = (int) (width / f2);
            }
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, i, i2, true);
            bitmapCreateBitmap.recycle();
        } else {
            bitmapCreateScaledBitmap = bitmapCreateBitmap;
        }
        try {
            saveBitmap(bitmapCreateScaledBitmap, str2, str3);
            bitmapCreateScaledBitmap.recycle();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Bitmap getBitmap(String str, String str2, int i, int i2, String str3) throws IOException {
        Bitmap bitmapCreateBitmap;
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return null;
        }
        String str4 = str2 + str;
        String strCreateKey = createKey(str4, i, i2, str3, BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
        Bitmap bitmap = this.bitmapCache.get(strCreateKey);
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap2 = createBitmap(str4, i, i2);
        if (bitmapCreateBitmap2 != null) {
            return this.bitmapCache.put(strCreateKey, bitmapCreateBitmap2);
        }
        if (str2.equals(TEMP_CACHE_LEVEL_2_CACHE)) {
            Bitmap bitmapCreateBitmap3 = createBitmap(TEMP_CACHE_DIR + str, i, i2);
            if (bitmapCreateBitmap3 != null) {
                return this.bitmapCache.put(strCreateKey, bitmapCreateBitmap3);
            }
            Bitmap bitmapCreateBitmap4 = createBitmap(TEMP_CACHE_LEVEL_1_CACHE + str, i, i2);
            if (bitmapCreateBitmap4 != null) {
                return this.bitmapCache.put(strCreateKey, bitmapCreateBitmap4);
            }
        } else if (str2.equals(TEMP_CACHE_LEVEL_1_CACHE) && (bitmapCreateBitmap = createBitmap(TEMP_CACHE_DIR + str, i, i2)) != null) {
            return this.bitmapCache.put(strCreateKey, bitmapCreateBitmap);
        }
        return null;
    }

    public Bitmap getBitmapManual(String str, String str2, int i, int i2, String str3) throws IOException {
        Bitmap bitmapCreateBitmap;
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return null;
        }
        String str4 = str2 + str;
        String strCreateKey = createKey(str4, i, i2, str3, "1");
        Bitmap bitmap = this.bitmapCache.get(strCreateKey);
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap2 = createBitmap(str4, i, i2);
        if (bitmapCreateBitmap2 != null) {
            return this.bitmapCache.put(strCreateKey, bitmapCreateBitmap2);
        }
        if (str2.equals(TEMP_CACHE_LEVEL_2_CACHE)) {
            Bitmap bitmapCreateBitmap3 = createBitmap(TEMP_CACHE_DIR + str, i, i2);
            if (bitmapCreateBitmap3 != null) {
                return this.bitmapCache.put(strCreateKey, bitmapCreateBitmap3);
            }
            Bitmap bitmapCreateBitmap4 = createBitmap(TEMP_CACHE_LEVEL_1_CACHE + str, i, i2);
            if (bitmapCreateBitmap4 != null) {
                return this.bitmapCache.put(strCreateKey, bitmapCreateBitmap4);
            }
        } else if (str2.equals(TEMP_CACHE_LEVEL_1_CACHE) && (bitmapCreateBitmap = createBitmap(TEMP_CACHE_DIR + str, i, i2)) != null) {
            return this.bitmapCache.put(strCreateKey, bitmapCreateBitmap);
        }
        return null;
    }

    public Bitmap getNetBitmap(String str, String str2, int i, int i2, String str3) throws IOException {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return null;
        }
        Bitmap bitmap = getBitmap(str.substring(str.lastIndexOf("/") + 1), str2, i, i2, str3);
        if (bitmap != null) {
            return bitmap;
        }
        HashSet<NetImageShowData> hashSet = this.mRequestUrlMap.get(str);
        if (hashSet == null) {
            HashSet<NetImageShowData> hashSet2 = new HashSet<>();
            hashSet2.add(new NetImageShowData(i, i2, str3, null));
            this.mRequestUrlMap.put(str, hashSet2);
            queueImageLoad(str, str2);
        } else {
            hashSet.add(new NetImageShowData(i, i2, str3, null));
        }
        return null;
    }

    public void loadNetImageByFile(String str, String str2, onImgLoadResultListener onimgloadresultlistener, int i) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return;
        }
        queueImageLoad(str, str2, 0, onimgloadresultlistener, i);
    }

    public void loadNetImageByTime(String str, String str2, onImgLoadResultListener onimgloadresultlistener) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return;
        }
        queueImageLoad(str, str2, 1, onimgloadresultlistener, 0);
    }

    public void saveBitmap(Bitmap bitmap, String str, String str2) throws IOException {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str + str2)));
            if (str2.endsWith(".png") || str2.endsWith(".PNG")) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            } else {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }
    }

    public void showAvailMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        ToastUtils.showShort("当前可用内存为：" + Formatter.formatFileSize(context, memoryInfo.availMem));
    }
}
