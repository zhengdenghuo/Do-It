package com.collectpoint.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import com.collectpoint.moudle.product.category.utils.AnimationUtil;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class ImageUtil {
    private static Bitmap createWaterMaskBitmap(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, i, i2, (Paint) null);
        canvas.save();
        canvas.restore();
        return bitmapCreateBitmap;
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static Bitmap drawTextToBitmap(Context context, Bitmap bitmap, String str, String str2, String str3, String str4, String str5, String str6, Paint paint, Rect rect, int i, int i2) {
        Bitmap.Config config = bitmap.getConfig();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCopy = bitmap.copy(config, true);
        Canvas canvas = new Canvas(bitmapCopy);
        try {
            canvas.drawText(str, i, i2, paint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            canvas.drawText(str2, i, i2 + 60, paint);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            canvas.drawText(str3, i, i2 + 120, paint);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            canvas.drawText(str4, i, i2 + 180, paint);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            canvas.drawText(str5, i, i2 + 240, paint);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            canvas.drawText(str6, i, i2 + AnimationUtil.ANIMATION_OUT_TIME, paint);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return bitmapCopy;
    }

    public static Bitmap drawTextToRightBottom(Context context, Bitmap bitmap, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3, int i4) {
        Paint paint = new Paint(1);
        paint.setColor(i2);
        Rect rect = new Rect();
        for (int i5 = i; i5 > 2; i5--) {
            paint.setTextSize(dp2px(context, i5));
            paint.getTextBounds(str, 0, str.length(), rect);
            if (Math.abs(rect.right - rect.left) < (bitmap.getWidth() * 2) / 3) {
                break;
            }
        }
        return drawTextToBitmap(context, bitmap, str, str2, str3, str4, str5, str6, paint, rect, (bitmap.getWidth() - rect.width()) - dp2px(context, i3), bitmap.getHeight() - dp2px(context, i4));
    }

    public static Bitmap scaleWithWH(Bitmap bitmap, double d, double d2) {
        if (d == 0.0d || d2 == 0.0d || bitmap == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale((float) (d / width), (float) (d2 / height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
