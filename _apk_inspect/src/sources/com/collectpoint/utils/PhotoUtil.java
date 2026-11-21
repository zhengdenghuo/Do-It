package com.collectpoint.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class PhotoUtil {
    public static String compress(String str) {
        if (new File(str).length() <= 102400) {
            return str;
        }
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "etPath");
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = file.getPath() + File.separator + (Calendar.getInstance().getTimeInMillis() + ".jpg");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(str2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        GetBitmap.getSmallBitmap(str).compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
        return str2;
    }

    public static boolean compressScanCode(Context context, Bitmap bitmap) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        FileOutputStream fileOutputStream = null;
        File file = new File(Environment.getExternalStorageDirectory() + "/DCIM/Camera/scanCode_" + System.currentTimeMillis());
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(byteArray);
                try {
                    if (EmptyUtils.isNotEmpty(fileOutputStream)) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                    context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file.getPath())));
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    if (EmptyUtils.isNotEmpty(fileOutputStream)) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                    return false;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return false;
                }
            }
        } catch (Throwable th) {
            try {
                if (EmptyUtils.isNotEmpty(fileOutputStream)) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
                throw th;
            } catch (IOException e4) {
                e4.printStackTrace();
                return false;
            }
        }
    }

    public static void deletePhotoFile(List<File> list) {
        if (EmptyUtils.isEmpty(list)) {
            return;
        }
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }
}
