package com.collectpoint.widget;

import android.content.Context;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class CircleImageView extends AppCompatImageView {
    private float height;
    private Matrix matrix;
    private Paint paint;
    private float radius;
    private float width;

    public CircleImageView(Context context) {
        this(context, null);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.matrix = new Matrix();
    }

    private BitmapShader initBitmapShader(BitmapDrawable bitmapDrawable) {
        BitmapShader bitmapShader = new BitmapShader(bitmapDrawable.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        float fMax = Math.max(this.width / r0.getWidth(), this.height / r0.getHeight());
        this.matrix.setScale(fMax, fMax);
        bitmapShader.setLocalMatrix(this.matrix);
        return bitmapShader;
    }

    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
        } else if (!(drawable instanceof BitmapDrawable)) {
            super.onDraw(canvas);
        } else {
            this.paint.setShader(initBitmapShader((BitmapDrawable) drawable));
            canvas.drawCircle(this.width / 2.0f, this.height / 2.0f, this.radius, this.paint);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.width = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        this.height = measuredHeight;
        this.radius = Math.min(this.width, measuredHeight) / 2.0f;
    }
}
