package com.collectpoint.moudle.product.category.utils;

import android.content.Context;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class AnimationUtil {
    public static final int ANIMATION_IN_TIME = 400;
    public static final int ANIMATION_OUT_TIME = 300;

    public static Animation createInAnimation(Context context, int i) {
        AnimationSet animationSet = new AnimationSet(context, null);
        animationSet.setFillAfter(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i, 0.0f);
        translateAnimation.setDuration(400L);
        animationSet.addAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
        alphaAnimation.setDuration(400L);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    public static Animation createOutAnimation(Context context, int i) {
        AnimationSet animationSet = new AnimationSet(context, null);
        animationSet.setFillAfter(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, i);
        translateAnimation.setDuration(300L);
        animationSet.addAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }
}
