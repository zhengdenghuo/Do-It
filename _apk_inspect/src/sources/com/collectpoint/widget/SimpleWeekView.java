package com.collectpoint.widget;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.WeekView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class SimpleWeekView extends WeekView {
    private int mRadius;

    public SimpleWeekView(Context context) {
        super(context);
        setLayerType(1, this.mSelectedPaint);
        this.mSelectedPaint.setMaskFilter(new BlurMaskFilter(25.0f, BlurMaskFilter.Blur.SOLID));
    }

    protected void onDrawScheme(Canvas canvas, Calendar calendar, int i) {
        canvas.drawCircle((this.mItemWidth / 2) + i, this.mItemHeight / 2, this.mRadius, this.mSchemePaint);
    }

    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int i, boolean z) {
        canvas.drawCircle((this.mItemWidth / 2) + i, this.mItemHeight / 2, this.mRadius, this.mSelectedPaint);
        return false;
    }

    protected void onDrawText(Canvas canvas, Calendar calendar, int i, boolean z, boolean z2) {
        Paint paint;
        Paint paint2;
        float f = this.mTextBaseLine;
        int i2 = (this.mItemWidth / 2) + i;
        if (z2) {
            canvas.drawText(String.valueOf(calendar.getDay()), i2, f, this.mSelectTextPaint);
            return;
        }
        if (z) {
            String strValueOf = String.valueOf(calendar.getDay());
            float f2 = i2;
            if (calendar.isCurrentDay()) {
                paint2 = this.mCurDayTextPaint;
            } else {
                calendar.isCurrentMonth();
                paint2 = this.mSchemeTextPaint;
            }
            canvas.drawText(strValueOf, f2, f, paint2);
            return;
        }
        String strValueOf2 = String.valueOf(calendar.getDay());
        float f3 = i2;
        if (calendar.isCurrentDay()) {
            paint = this.mCurDayTextPaint;
        } else {
            calendar.isCurrentMonth();
            paint = this.mCurMonthTextPaint;
        }
        canvas.drawText(strValueOf2, f3, f, paint);
    }

    protected void onPreviewHook() {
        this.mRadius = (Math.min(this.mItemWidth, this.mItemHeight) / 5) * 2;
        this.mSchemePaint.setStyle(Paint.Style.STROKE);
    }
}
