package com.collectpoint.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.collectpoint.R;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class TimelineLayout extends LinearLayout {
    private Context mContext;
    private int mFirstX;
    private int mFirstY;
    private Bitmap mIcon;
    private int mLastX;
    private int mLastY;
    private int mLineColor;
    private int mLineMarginLeft;
    private int mLineMarginTop;
    private Paint mLinePaint;
    private int mLineStrokeWidth;
    private int mPointColor;
    private Paint mPointPaint;
    private int mPointSize;

    public TimelineLayout(Context context) {
        this(context, null);
    }

    public TimelineLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimelineLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TimelineLayout);
        this.mLineMarginLeft = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 10);
        this.mLineMarginTop = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0);
        this.mLineStrokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(4, 2);
        this.mLineColor = typedArrayObtainStyledAttributes.getColor(1, -12725851);
        this.mPointSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 8);
        this.mPointColor = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, -12725851);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) context.getResources().getDrawable(typedArrayObtainStyledAttributes.getResourceId(0, 2131230963));
        if (bitmapDrawable != null) {
            this.mIcon = bitmapDrawable.getBitmap();
        }
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        initView(context);
    }

    private void drawBetweenLine(Canvas canvas) {
        canvas.drawLine(this.mFirstX, this.mFirstY, this.mLastX, this.mLastY, this.mLinePaint);
        for (int i = 0; i < getChildCount() - 1; i++) {
            canvas.drawCircle(this.mFirstX, getChildAt(i).getPaddingTop() + getChildAt(i).getTop() + this.mLineMarginTop, this.mPointSize, this.mPointPaint);
        }
    }

    private void drawFirstPoint(Canvas canvas) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            int top = childAt.getTop();
            this.mFirstX = this.mLineMarginLeft;
            int paddingTop = childAt.getPaddingTop() + top + this.mLineMarginTop;
            this.mFirstY = paddingTop;
            canvas.drawCircle(this.mFirstX, paddingTop, this.mPointSize, this.mPointPaint);
        }
    }

    private void drawLastIcon(Canvas canvas) {
        View childAt = getChildAt(getChildCount() - 1);
        if (childAt != null) {
            int top = childAt.getTop();
            this.mLastX = this.mLineMarginLeft;
            this.mLastY = childAt.getPaddingTop() + top + this.mLineMarginTop;
            canvas.drawBitmap(this.mIcon, this.mLastX - (r2.getWidth() >> 1), this.mLastY, (Paint) null);
        }
    }

    private void drawTimeline(Canvas canvas) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (childCount <= 1) {
                drawFirstPoint(canvas);
                return;
            }
            drawFirstPoint(canvas);
            drawLastIcon(canvas);
            drawBetweenLine(canvas);
        }
    }

    private void initView(Context context) {
        this.mContext = context;
        Paint paint = new Paint();
        this.mLinePaint = paint;
        paint.setAntiAlias(true);
        this.mLinePaint.setDither(true);
        this.mLinePaint.setColor(this.mLineColor);
        this.mLinePaint.setStrokeWidth(this.mLineStrokeWidth);
        this.mLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint2 = new Paint();
        this.mPointPaint = paint2;
        paint2.setAntiAlias(true);
        this.mPointPaint.setDither(true);
        this.mPointPaint.setColor(this.mPointColor);
        this.mPointPaint.setStyle(Paint.Style.FILL);
    }

    public int getLineMarginLeft() {
        return this.mLineMarginLeft;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawTimeline(canvas);
    }

    public void setLineMarginLeft(int i) {
        this.mLineMarginLeft = i;
        invalidate();
    }
}
