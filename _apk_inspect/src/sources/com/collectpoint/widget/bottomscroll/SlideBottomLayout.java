package com.collectpoint.widget.bottomscroll;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.collectpoint.R;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class SlideBottomLayout extends LinearLayout {
    private boolean arriveTop;
    private View childView;
    private int downY;
    private float hideWeight;
    private Scroller mScroller;
    private int moveY;
    private int movedDis;
    private int movedMaxDis;
    private ShortSlideListener shortSlideListener;
    private float visibilityHeight;

    public SlideBottomLayout(Context context) {
        super(context);
        this.hideWeight = 0.25f;
        this.arriveTop = false;
    }

    public SlideBottomLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hideWeight = 0.25f;
        this.arriveTop = false;
        initAttrs(context, attributeSet);
    }

    public SlideBottomLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hideWeight = 0.25f;
        this.arriveTop = false;
        initAttrs(context, attributeSet);
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlideBottomLayout);
        this.visibilityHeight = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        initConfig(context);
    }

    private void initConfig(Context context) {
        if (this.mScroller == null) {
            this.mScroller = new Scroller(context);
        }
        setBackgroundColor(0);
    }

    public boolean arriveTop() {
        return this.arriveTop;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller == null) {
            this.mScroller = new Scroller(getContext());
        }
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(0, this.mScroller.getCurrY());
            postInvalidate();
        }
    }

    public void hide() {
        scroll2BottomImmediate();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 0 || getChildAt(0) == null) {
            throw new RuntimeException("there have no child-View in the SlideBottomLayout！");
        }
        if (getChildCount() > 1) {
            throw new RuntimeException("there just alow one child-View in the SlideBottomLayout!");
        }
        this.childView = getChildAt(0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View view = this.childView;
        view.layout(0, this.movedMaxDis, view.getMeasuredWidth(), this.childView.getMeasuredHeight() + this.movedMaxDis);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.movedMaxDis = (int) (this.childView.getMeasuredHeight() - this.visibilityHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (touchActionDown(y)) {
                    return true;
                }
                break;
            case 1:
                if (touchActionUp(y)) {
                    return true;
                }
                break;
            case 2:
                if (touchActionMove(y)) {
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void scroll2BottomImmediate() {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY());
        postInvalidate();
        this.movedDis = 0;
        this.arriveTop = false;
    }

    public void scroll2TopImmediate() {
        this.mScroller.startScroll(0, getScrollY(), 0, this.movedMaxDis - getScrollY());
        invalidate();
        this.movedDis = this.movedMaxDis;
        this.arriveTop = true;
    }

    public void setHideWeight(float f) {
        if (f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("hideWeight should belong (0f,1f]");
        }
        this.hideWeight = f;
    }

    public void setShortSlideListener(ShortSlideListener shortSlideListener) {
        this.shortSlideListener = shortSlideListener;
    }

    public void setVisibilityHeight(float f) {
        this.visibilityHeight = f;
    }

    public void show() {
        scroll2TopImmediate();
    }

    public boolean switchVisible() {
        if (arriveTop()) {
            hide();
        } else {
            show();
        }
        ShortSlideListener shortSlideListener = this.shortSlideListener;
        if (shortSlideListener != null) {
            shortSlideListener.onShortSlide(this.arriveTop);
        }
        return arriveTop();
    }

    public boolean touchActionDown(float f) {
        int i = (int) f;
        this.downY = i;
        return this.arriveTop || i >= this.movedMaxDis;
    }

    public boolean touchActionMove(float f) {
        int i = (int) f;
        this.moveY = i;
        int i2 = this.downY - i;
        if (i2 <= 0) {
            int i3 = this.movedDis + i2;
            this.movedDis = i3;
            if (i3 < 0) {
                this.movedDis = 0;
            }
            if (this.movedDis > 0) {
                scrollBy(0, i2);
            }
            this.downY = this.moveY;
            return true;
        }
        int i4 = this.movedDis + i2;
        this.movedDis = i4;
        int i5 = this.movedMaxDis;
        if (i4 > i5) {
            this.movedDis = i5;
        }
        if (this.movedDis >= i5) {
            return false;
        }
        scrollBy(0, i2);
        this.downY = this.moveY;
        return true;
    }

    public boolean touchActionUp(float f) {
        if (this.movedDis > this.movedMaxDis * this.hideWeight) {
            switchVisible();
            return true;
        }
        if (this.shortSlideListener != null) {
            return true;
        }
        hide();
        return true;
    }
}
