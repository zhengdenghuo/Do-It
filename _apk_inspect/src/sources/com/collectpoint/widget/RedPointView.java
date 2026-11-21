package com.collectpoint.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class RedPointView extends TextView {
    private static final int DEFAULT_MARGIN_DIP = 5;
    private static final int DEFAULT_PADDING_DIP = 5;
    private int colorBg;
    private int colorContent;
    private int content;
    private Context context;
    private boolean isShown;
    private int left_right;
    private View orginView;
    private int paddingPixels;
    private ShapeDrawable pointBg;
    private int pointMargin;
    private int sizeBg;
    private int sizeContent;
    private int top_bottom;

    public RedPointView(Context context, View view) {
        super(context);
        this.content = 0;
        this.colorBg = -65536;
        this.colorContent = -1;
        this.left_right = 5;
        this.top_bottom = 48;
        this.sizeContent = 15;
        this.sizeBg = (int) (15 * 1.5d);
        this.context = context;
        this.orginView = view;
        init();
    }

    private int dipToPixels(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    private ShapeDrawable getDefaultBackground() {
        int i = this.sizeBg;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{i, i, i, i, i, i, i, i}, null, null));
        shapeDrawable.getPaint().setColor(this.colorBg);
        return shapeDrawable;
    }

    private void init() {
        this.pointMargin = dipToPixels(5);
        setTypeface(Typeface.DEFAULT_BOLD);
        int iDipToPixels = dipToPixels(5);
        this.paddingPixels = iDipToPixels;
        setPadding(iDipToPixels, 0, iDipToPixels, 0);
        setContent(this.content);
        setColorContent(this.colorContent);
        setSizeContent(this.sizeContent);
        setPosition(this.left_right, this.top_bottom);
        setColorBg(this.colorBg);
        this.isShown = false;
        View view = this.orginView;
        if (view != null) {
            restartDraw(view);
        }
    }

    private void restartDraw(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewParent parent = view.getParent();
        FrameLayout frameLayout = new FrameLayout(this.context);
        ViewGroup viewGroup = (ViewGroup) parent;
        int iIndexOfChild = viewGroup.indexOfChild(view);
        viewGroup.removeView(view);
        viewGroup.addView(frameLayout, iIndexOfChild, layoutParams);
        frameLayout.addView(view);
        frameLayout.addView(this);
        viewGroup.invalidate();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setPositionParams(int r4, int r5) {
        /*
            r3 = this;
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = -2
            r0.<init>(r1, r1)
            r1 = r4 | r5
            r0.gravity = r1
            r1 = 0
            switch(r4) {
                case 3: goto Lf;
                case 4: goto Le;
                case 5: goto L1f;
                default: goto Le;
            }
        Le:
            goto L30
        Lf:
            switch(r5) {
                case 48: goto L19;
                case 80: goto L13;
                default: goto L12;
            }
        L12:
            goto L1f
        L13:
            int r2 = r3.pointMargin
            r0.setMargins(r2, r1, r1, r2)
            goto L1f
        L19:
            int r2 = r3.pointMargin
            r0.setMargins(r2, r2, r1, r1)
        L1f:
            switch(r5) {
                case 48: goto L29;
                case 80: goto L23;
                default: goto L22;
            }
        L22:
            goto L2f
        L23:
            int r2 = r3.pointMargin
            r0.setMargins(r1, r1, r2, r2)
            goto L2f
        L29:
            int r2 = r3.pointMargin
            r0.setMargins(r1, r2, r1, r1)
            goto L30
        L2f:
        L30:
            r3.setLayoutParams(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.collectpoint.widget.RedPointView.setPositionParams(int, int):void");
    }

    public void hide() {
        setVisibility(8);
        this.isShown = false;
    }

    public void setColorBg(int i) {
        this.colorBg = i;
        ShapeDrawable defaultBackground = getDefaultBackground();
        this.pointBg = defaultBackground;
        setBackgroundDrawable(defaultBackground);
    }

    public void setColorContent(int i) {
        this.colorContent = i;
        setTextColor(i);
    }

    public void setContent(int i) {
        this.content = i;
        if (i > 99) {
            setText("99+");
        } else {
            setText(i + "");
        }
    }

    public void setPosition(int i, int i2) {
        this.left_right = i;
        this.top_bottom = i2;
        setPositionParams(i, i2);
    }

    public void setSizeContent(int i) {
        this.sizeContent = i;
        setTextSize(i);
        this.sizeBg = (int) (i * 1.5d);
    }

    public void show() {
        setVisibility(0);
        this.isShown = true;
    }
}
