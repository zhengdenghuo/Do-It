package com.collectpoint.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class SlidingDeleteView extends HorizontalScrollView {
    private static final String TAG = "SlidingDeleteView";
    public boolean deleteViewVisibile;
    private float downX;
    private float downY;
    public boolean isEnable;
    private boolean isFirst;
    private OnDeleteViewStateChangedListener onStateChangedListener;
    private LinearLayout slidingParent;

    public interface OnDeleteViewStateChangedListener {
        void onDownOrMove();

        void onGone();

        void onVisibile();
    }

    public SlidingDeleteView(Context context) {
        this(context, null);
    }

    public SlidingDeleteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingDeleteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isEnable = true;
        this.deleteViewVisibile = false;
        this.isFirst = true;
    }

    private void init() {
        this.slidingParent = (LinearLayout) findViewById(2131296636);
    }

    private void measureScrollX() {
        System.out.println("______onDownOrMove" + getScrollX());
        if (getScrollX() < this.slidingParent.getWidth() / 3) {
            setDeleteViewGone();
        } else {
            setDeleteViewVisibile();
        }
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.isFirst) {
            init();
            this.isFirst = false;
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    @Override // android.widget.HorizontalScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            switch(r0) {
                case 0: goto L38;
                case 1: goto Le;
                case 2: goto L8;
                case 3: goto Le;
                default: goto L7;
            }
        L7:
            goto L4b
        L8:
            boolean r1 = r5.isEnable
            if (r1 != 0) goto L38
            r1 = 0
            return r1
        Le:
            float r1 = r6.getX()
            float r2 = r5.downX
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
            float r2 = r6.getY()
            float r3 = r5.downY
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            r3 = 1073741824(0x40000000, float:2.0)
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L33
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L33
            boolean r3 = super.onTouchEvent(r6)
            return r3
        L33:
            r5.measureScrollX()
            r3 = 1
            return r3
        L38:
            float r1 = r6.getX()
            r5.downX = r1
            float r1 = r6.getY()
            r5.downY = r1
            com.collectpoint.widget.SlidingDeleteView$OnDeleteViewStateChangedListener r1 = r5.onStateChangedListener
            if (r1 == 0) goto L4b
            r1.onDownOrMove()
        L4b:
            boolean r1 = super.onTouchEvent(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.collectpoint.widget.SlidingDeleteView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setDeleteViewGone() {
        this.deleteViewVisibile = false;
        smoothScrollTo(0, 0);
        OnDeleteViewStateChangedListener onDeleteViewStateChangedListener = this.onStateChangedListener;
        if (onDeleteViewStateChangedListener != null) {
            onDeleteViewStateChangedListener.onGone();
        }
    }

    public void setDeleteViewVisibile() {
        Log.d(TAG, "抽屉的固定宽度为 == " + this.slidingParent.getWidth());
        this.deleteViewVisibile = true;
        smoothScrollTo(this.slidingParent.getWidth(), 0);
        OnDeleteViewStateChangedListener onDeleteViewStateChangedListener = this.onStateChangedListener;
        if (onDeleteViewStateChangedListener != null) {
            onDeleteViewStateChangedListener.onVisibile();
        }
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
    }

    public void setOnDeleteViewStateChangedListener(OnDeleteViewStateChangedListener onDeleteViewStateChangedListener) {
        this.onStateChangedListener = onDeleteViewStateChangedListener;
    }
}
