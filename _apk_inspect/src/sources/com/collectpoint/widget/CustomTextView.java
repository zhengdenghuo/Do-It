package com.collectpoint.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class CustomTextView extends TextView {
    private float maxTextSize;
    private float minTextSize;
    private Paint testPaint;
    private static float DEFAULT_MIN_TEXT_SIZE = 1.0f;
    private static float DEFAULT_MAX_TEXT_SIZE = 20.0f;

    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialise();
    }

    private void initialise() {
        Paint paint = new Paint();
        this.testPaint = paint;
        paint.set(getPaint());
        float textSize = getTextSize();
        this.maxTextSize = textSize;
        float f = DEFAULT_MIN_TEXT_SIZE;
        if (textSize <= f) {
            this.maxTextSize = DEFAULT_MAX_TEXT_SIZE;
        }
        this.minTextSize = f;
    }

    private void refitText(String str, int i) {
        if (i > 0) {
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            float f = this.maxTextSize;
            this.testPaint.setTextSize(f);
            while (true) {
                if (f <= this.minTextSize || this.testPaint.measureText(str) <= paddingLeft) {
                    break;
                }
                f -= 1.0f;
                if (f <= this.minTextSize) {
                    f = this.minTextSize;
                    break;
                }
                this.testPaint.setTextSize(f);
            }
            setTextSize(f);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i != i3) {
            refitText(getText().toString(), i);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        refitText(charSequence.toString(), getWidth());
    }

    public void setMaxTextSize(float f) {
        this.maxTextSize = f;
    }
}
