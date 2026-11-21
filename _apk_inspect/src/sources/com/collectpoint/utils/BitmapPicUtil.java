package com.collectpoint.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.constants.Constants;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class BitmapPicUtil {
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

    public static int changeAlpha(int i, float f) {
        return Color.argb((int) (Color.alpha(i) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public static String compressImage(Bitmap bitmap, String str) throws IOException {
        File file = new File(str);
        if (EmptyUtils.isEmpty(str) || !str.contains("/")) {
            return "";
        }
        String str2 = file.getParentFile().getPath() + "/" + file.getName().substring(0, file.getName().indexOf(".")) + System.currentTimeMillis() + ".jpg";
        File file2 = new File(str2);
        if (file2.exists()) {
            file2.delete();
        } else {
            file2.getParentFile().mkdirs();
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (getFileOrFilesSize(str2) < 5242880) {
            return file2.getPath();
        }
        int rotateAngle = getRotateAngle(str);
        if (rotateAngle != 0) {
            bitmap = setRotateAngle(rotateAngle, bitmap);
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            int i = 100;
            LogUtils.e(new Object[]{"quality1:" + byteArrayOutputStream.toByteArray().length + "-100"});
            while (byteArrayOutputStream.toByteArray().length > 5242880) {
                i -= 5;
                byteArrayOutputStream.reset();
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                LogUtils.e(new Object[]{"quality:" + byteArrayOutputStream.toByteArray().length + "-" + i});
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
            fileOutputStream.close();
            LogUtils.e(new Object[]{"quality2:" + getFileOrFilesSize(file2.getPath())});
            return file2.getPath();
        } catch (Exception e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static String compressImage(String str) throws IOException {
        File file = new File(str);
        if (EmptyUtils.isEmpty(str) || !str.contains("/")) {
            return "";
        }
        String str2 = file.getParentFile().getPath() + "/" + file.getName().substring(0, file.getName().indexOf(".")) + System.currentTimeMillis() + ".jpg";
        if (getFileOrFilesSize(str) < 5242880) {
            return file.getPath();
        }
        Bitmap smallBitmap = getSmallBitmap(str);
        int rotateAngle = getRotateAngle(str);
        if (rotateAngle != 0) {
            smallBitmap = setRotateAngle(rotateAngle, smallBitmap);
        }
        File file2 = new File(str2);
        try {
            if (file2.exists()) {
                file2.delete();
            } else {
                file2.getParentFile().mkdirs();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            smallBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            int i = 100;
            LogUtils.e(new Object[]{"quality1:" + byteArrayOutputStream.toByteArray().length + "-100"});
            while (byteArrayOutputStream.toByteArray().length > 5242880) {
                i -= 5;
                byteArrayOutputStream.reset();
                smallBitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                LogUtils.e(new Object[]{"quality:" + byteArrayOutputStream.toByteArray().length + "-" + i});
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            smallBitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
            fileOutputStream.close();
            LogUtils.e(new Object[]{"quality2:" + getFileOrFilesSize(file2.getPath())});
            return file2.getPath();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static Bitmap createCircleImage(Bitmap bitmap) {
        int width = bitmap.getWidth() < bitmap.getHeight() ? bitmap.getWidth() : bitmap.getHeight();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawCircle(width / 2, width / 2, width / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    public static Bitmap cropBitmap(Bitmap bitmap, int i, int i2) {
        bitmap.getWidth();
        return Bitmap.createBitmap(bitmap, 0, bitmap.getHeight() - i, i2, i, (Matrix) null, false);
    }

    private static String formatFileSize_(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j == 0) {
            return "0B";
        }
        String str = j < 1024 ? decimalFormat.format(j) + "B" : j < 1048576 ? decimalFormat.format(j / 1024.0d) + "KB" : j < 1073741824 ? decimalFormat.format(j / 1048576.0d) + "MB" : decimalFormat.format(j / 1.073741824E9d) + "GB";
        if (j < 2097152) {
            return str;
        }
        return null;
    }

    public static Bitmap getBigBitmap(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, 1600, 1600);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap getBitmapByView(ConstraintLayout constraintLayout) {
        if (constraintLayout == null || constraintLayout.getWidth() == 0 || constraintLayout.getHeight() == 0) {
            return null;
        }
        int height = 0;
        for (int i = 0; i < constraintLayout.getChildCount(); i++) {
            height += constraintLayout.getChildAt(i).getHeight();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(constraintLayout.getWidth(), constraintLayout.getHeight(), Bitmap.Config.ARGB_8888);
        constraintLayout.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public static Bitmap getBitmapByView0(View view) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public static long getFileOrFilesSize(String str) {
        File file = new File(str);
        long fileSizes = 0;
        try {
            fileSizes = file.isDirectory() ? getFileSizes(file) : getFileSize(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileSizes;
    }

    private static long getFileSize(File file) throws Exception {
        return file.length();
    }

    private static long getFileSizes(File file) throws Exception {
        long fileSizes = 0;
        File[] fileArrListFiles = file.listFiles();
        for (int i = 0; i < fileArrListFiles.length; i++) {
            fileSizes += fileArrListFiles[i].isDirectory() ? getFileSizes(fileArrListFiles[i]) : getFileSize(fileArrListFiles[i]);
        }
        return fileSizes;
    }

    private long getFolderSize(File file) throws Exception {
        long folderSize = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            for (int i = 0; i < fileArrListFiles.length; i++) {
                folderSize = fileArrListFiles[i].isDirectory() ? folderSize + getFolderSize(fileArrListFiles[i]) : folderSize + fileArrListFiles[i].length();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return folderSize;
    }

    public static int getRotateAngle(String str) {
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

    public static Bitmap getSmallBitmap(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, 480, 800);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap imageCrop(Bitmap bitmap, float f, float f2, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            int i5 = (int) ((width * f2) / f);
            i = width;
            i2 = i5;
            i3 = 0;
            i4 = (height - i5) / 2;
        } else if (height > (width * f2) / f) {
            int i6 = (int) ((width * f2) / f);
            i = width;
            i2 = i6;
            i3 = 0;
            i4 = (height - i6) / 2;
        } else {
            int i7 = (int) ((height * f) / f2);
            i = i7;
            i2 = height;
            i3 = (width - i7) / 2;
            i4 = 0;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i3, i4, i, i2, (Matrix) null, false);
        if (z && bitmap != null && !bitmap.equals(bitmapCreateBitmap) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap mergeBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap.isRecycled() || bitmap2 == null || bitmap2.isRecycled()) {
            return null;
        }
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(bitmapCopy).drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), (Paint) null);
        return bitmapCopy;
    }

    private static void saveBitmap(Bitmap bitmap, Activity activity) throws IOException {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        activity.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
        ToastUtils.showShort("保存本地成功 " + file.getPath());
    }

    public static void screenShort(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(decorView.getDrawingCache());
        if (bitmapCreateBitmap != null) {
            try {
                saveBitmap(bitmapCreateBitmap, activity);
            } catch (Exception e) {
            }
        }
    }

    public static Bitmap setRotateAngle(int i, Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
