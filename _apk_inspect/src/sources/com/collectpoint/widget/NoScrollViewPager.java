package com.collectpoint.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class NoScrollViewPager extends ViewPager {
    private boolean noScroll;

    public NoScrollViewPager(Context context) {
        super(context);
        this.noScroll = false;
    }

    public NoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.noScroll = false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.noScroll) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.noScroll) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
    }

    public void setCurrentItem(int i) {
        super.setCurrentItem(i);
    }

    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(i, z);
    }

    public void setNoScroll(boolean z) {
        this.noScroll = z;
    }
}
