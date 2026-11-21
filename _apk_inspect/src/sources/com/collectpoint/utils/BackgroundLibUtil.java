package com.collectpoint.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.collectpoint.MyApp;
import com.noober.background.drawable.DrawableCreator;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class BackgroundLibUtil {
    public static Drawable get333333Stroke(int i) {
        return getDrawable(i, 2131100231, 2131099824, 2131165362);
    }

    public static Drawable get999999(int i) {
        return getDrawable(i, 2131099725, 2131099725, 2131165361);
    }

    public static Drawable getBlue(int i) {
        return getDrawable(i, 2131099738, 2131099738, 2131165361);
    }

    public static Drawable getBlueW(int i) {
        return getDrawable(i, 2131100237, 2131099736, 2131165362);
    }

    public static Drawable getBlueWw(int i) {
        return getDrawable(i, 2131100231, 2131099736, 2131165362);
    }

    public static int getColor(int i) {
        return getResources().getColor(i);
    }

    public static Context getContext() {
        MyApp.getInstance();
        return MyApp.getContext();
    }

    public static float getDimension(int i) {
        return getResources().getDimension(i);
    }

    public static Drawable getDrawable(int i, int i2) {
        return getDrawable(i, i, i, i, i2, i2, 2131165361);
    }

    public static Drawable getDrawable(int i, int i2, int i3, int i4) {
        return getDrawable(i, i, i, i, i2, i3, i4);
    }

    public static Drawable getDrawable(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new DrawableCreator.Builder().setCornersRadius(getDimension(i), getDimension(i2), getDimension(i3), getDimension(i4)).setSolidColor(getColor(i5)).setStrokeColor(getColor(i6)).setStrokeWidth(getDimension(i7)).build();
    }

    public static Drawable getDrawableColorInt(int i, int i2, int i3, int i4) {
        return getDrawableColorInt(i, i, i, i, i2, i3, i4);
    }

    public static Drawable getDrawableColorInt(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new DrawableCreator.Builder().setCornersRadius(getDimension(i), getDimension(i2), getDimension(i3), getDimension(i4)).setSolidColor(i5).setStrokeColor(i6).setStrokeWidth(getDimension(i7)).build();
    }

    public static Drawable getDrawableColorStr(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new DrawableCreator.Builder().setCornersRadius(getDimension(i), getDimension(i2), getDimension(i3), getDimension(i4)).setSolidColor(i5).setStrokeColor(i6).setStrokeWidth(getDimension(i7)).build();
    }

    public static Drawable getDrawableGradient(int i, int i2, int i3, int i4) {
        return new DrawableCreator.Builder().setCornersRadius(getDimension(i)).setGradientAngle(i4).setGradientColor(getColor(i2), getColor(i3)).build();
    }

    public static Drawable getDrawableGradient(int i, int i2, int i3, int i4, int i5) {
        return new DrawableCreator.Builder().setCornersRadius(getDimension(i)).setGradientAngle(i5).setGradientColor(getColor(i2), getColor(i3), getColor(i4)).build();
    }

    public static Drawable getDrawableGradient(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new DrawableCreator.Builder().setCornersRadius(getDimension(i), getDimension(i2), getDimension(i3), getDimension(i4)).setGradientAngle(i7).setGradientColor(getColor(i5), getColor(i6)).build();
    }

    public static Drawable getDrawableGradientInt(int i, int i2, int i3, int i4) {
        return getDrawableGradientInt(i, i, i, i, i2, i3, i4);
    }

    public static Drawable getDrawableGradientInt(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new DrawableCreator.Builder().setCornersRadius(getDimension(i), getDimension(i2), getDimension(i3), getDimension(i4)).setGradientAngle(i7).setGradientColor(i5, i6).build();
    }

    public static Drawable getFF5D2B(int i) {
        return getDrawable(i, 2131100173, 2131100173, 2131165361);
    }

    public static Drawable getGreen(int i) {
        return getDrawable(i, 2131099734, 2131099734, 2131165361);
    }

    public static Drawable getGreenW(int i) {
        return getDrawable(i, 2131100237, 2131099734, 2131165673);
    }

    public static Drawable getOriginW(int i) {
        return getDrawable(i, 2131100237, 2131099756, 2131165362);
    }

    public static Resources getResources() {
        return getContext().getResources();
    }

    public static Drawable getWhiteAll(int i) {
        return getDrawable(i, 2131100237, 2131100237, 2131165361);
    }

    public static Drawable getWhiteAll12() {
        return getWhiteAll(2131165274);
    }

    public static Drawable getWhiteAll8() {
        return getWhiteAll(2131165272);
    }

    public static Drawable getWhiteStroke(int i) {
        return getDrawable(i, 2131100231, 2131100237, 2131165362);
    }

    public static Drawable getf0f0f0Stroke(int i) {
        return getDrawable(i, 2131100231, 2131099825, 2131165362);
    }

    public static void setBackgroundEnable(View view, int i, int i2, int i3) {
        Drawable drawableBuild = new DrawableCreator.Builder().setCornersRadius(getDimension(i)).setEnabledDrawable(getDrawable(i, i2, i2, 2131165361)).setUnEnabledDrawable(getDrawable(i, i3, i3, 2131165361)).build();
        view.setClickable(true);
        view.setBackground(drawableBuild);
    }

    public static void setBackgroundSelect(View view, int i, int i2, int i3, int i4, int i5, int i6) {
        Drawable drawableBuild = new DrawableCreator.Builder().setCornersRadius(getDimension(i)).setSelectedDrawable(getDrawable(i, i3, i4, i2)).setUnSelectedDrawable(getDrawable(i, i5, i6, i2)).build();
        view.setClickable(true);
        view.setBackground(drawableBuild);
    }

    public static void setTextColorEnable(TextView textView, int i, int i2) {
        DrawableCreator.Builder builder = new DrawableCreator.Builder();
        MyApp.getInstance();
        DrawableCreator.Builder enabledTextColor = builder.setEnabledTextColor(MyApp.getContext().getResources().getColor(i));
        MyApp.getInstance();
        ColorStateList colorStateListBuildTextColor = enabledTextColor.setUnEnabledTextColor(MyApp.getContext().getResources().getColor(i2)).buildTextColor();
        textView.setClickable(true);
        textView.setTextColor(colorStateListBuildTextColor);
    }

    public static void setTextColorSelect(TextView textView, int i, int i2) {
        DrawableCreator.Builder builder = new DrawableCreator.Builder();
        MyApp.getInstance();
        DrawableCreator.Builder selectedTextColor = builder.setSelectedTextColor(MyApp.getContext().getResources().getColor(i));
        MyApp.getInstance();
        ColorStateList colorStateListBuildTextColor = selectedTextColor.setUnSelectedTextColor(MyApp.getContext().getResources().getColor(i2)).buildTextColor();
        textView.setClickable(true);
        textView.setTextColor(colorStateListBuildTextColor);
    }
}
