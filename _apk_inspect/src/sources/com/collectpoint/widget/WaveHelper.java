package com.collectpoint.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class WaveHelper {
    private AnimatorSet mAnimatorSet;
    private WaveProgressView mWaveView;

    public WaveHelper(WaveProgressView waveProgressView) {
        this.mWaveView = waveProgressView;
        initAnimation();
    }

    private void initAnimation() {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mWaveView, "waveShiftRatio", 0.0f, 1.0f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.mWaveView, "amplitudeRatio", 1.0E-4f, 0.05f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setDuration(5000L);
        objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        arrayList.add(objectAnimatorOfFloat2);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mAnimatorSet = animatorSet;
        animatorSet.playTogether(arrayList);
    }

    public void cancel() {
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet != null) {
            animatorSet.end();
        }
    }

    public void start() {
        this.mWaveView.setShowWave(true);
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }
}
