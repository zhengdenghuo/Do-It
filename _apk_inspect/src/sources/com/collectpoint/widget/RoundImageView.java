package com.collectpoint.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class RoundImageView extends AppCompatImageView {
    float height;
    float width;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.width > 12.0f && this.height > 12.0f) {
            Path path = new Path();
            path.moveTo(12.0f, 0.0f);
            path.lineTo(this.width - 12.0f, 0.0f);
            float f = this.width;
            path.quadTo(f, 0.0f, f, 12.0f);
            path.lineTo(this.width, this.height - 12.0f);
            float f2 = this.width;
            float f3 = this.height;
            path.quadTo(f2, f3, f2 - 12.0f, f3);
            path.lineTo(12.0f, this.height);
            float f4 = this.height;
            path.quadTo(0.0f, f4, 0.0f, f4 - 12.0f);
            path.lineTo(0.0f, 12.0f);
            path.quadTo(0.0f, 0.0f, 12.0f, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
    }
}
