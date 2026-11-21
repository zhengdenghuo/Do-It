package com.collectpoint.widget;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.MonthView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class SimpleMonthView extends MonthView {
    private int mRadius;

    public SimpleMonthView(Context context) {
        super(context);
        setLayerType(1, this.mSelectedPaint);
        this.mSelectedPaint.setMaskFilter(new BlurMaskFilter(25.0f, BlurMaskFilter.Blur.SOLID));
    }

    protected void onDrawScheme(Canvas canvas, Calendar calendar, int i, int i2) {
        canvas.drawCircle((this.mItemWidth / 2) + i, (this.mItemHeight / 2) + i2, this.mRadius, this.mSchemePaint);
    }

    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int i, int i2, boolean z) {
        canvas.drawCircle((this.mItemWidth / 2) + i, (this.mItemHeight / 2) + i2, this.mRadius, this.mSelectedPaint);
        return false;
    }

    protected void onDrawText(Canvas canvas, Calendar calendar, int i, int i2, boolean z, boolean z2) {
        float f = this.mTextBaseLine + i2;
        int i3 = (this.mItemWidth / 2) + i;
        if (z2) {
            canvas.drawText(String.valueOf(calendar.getDay()), i3, f, this.mSelectTextPaint);
        } else if (z) {
            canvas.drawText(String.valueOf(calendar.getDay()), i3, f, calendar.isCurrentDay() ? this.mCurDayTextPaint : calendar.isCurrentMonth() ? this.mSchemeTextPaint : this.mOtherMonthTextPaint);
        } else {
            canvas.drawText(String.valueOf(calendar.getDay()), i3, f, calendar.isCurrentDay() ? this.mCurDayTextPaint : calendar.isCurrentMonth() ? this.mCurMonthTextPaint : this.mOtherMonthTextPaint);
        }
    }

    protected void onLoopStart(int i, int i2) {
    }

    protected void onPreviewHook() {
        this.mRadius = (Math.min(this.mItemWidth, this.mItemHeight) / 5) * 2;
        this.mSchemePaint.setStyle(Paint.Style.STROKE);
    }
}
