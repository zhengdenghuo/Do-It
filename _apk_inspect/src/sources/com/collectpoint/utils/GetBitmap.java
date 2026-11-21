package com.collectpoint.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class GetBitmap {
    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int iRound = Math.round(i3 / i2);
        int iRound2 = Math.round(i4 / i);
        return iRound < iRound2 ? iRound : iRound2;
    }

    public static Bitmap getSmallBitmap(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, 720, 1280);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static String saveImage(Bitmap bitmap) throws IOException {
        String str = "";
        try {
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "etPath");
            if (!file.exists()) {
                file.mkdirs();
            }
            str = file.getPath() + File.separator + (Calendar.getInstance().getTimeInMillis() + ".jpg");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return str;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return str;
        } catch (IOException e2) {
            e2.printStackTrace();
            return str;
        }
    }
}
