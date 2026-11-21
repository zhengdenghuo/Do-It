package com.collectpoint.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class WaveProgressView extends View {
    private static final float DEFAULT_AMPLITUDE_RATIO = 0.05f;
    private static final float DEFAULT_WATER_LEVEL_RATIO = 0.5f;
    private static final float DEFAULT_WAVE_LENGTH_RATIO = 1.0f;
    private static final float DEFAULT_WAVE_SHIFT_RATIO = 0.0f;
    private float mAmplitudeRatio;
    private int mBehindWaveColor;
    private Paint mBgPaint;
    private Paint mBorderPaint;
    private float mDefaultAmplitude;
    private double mDefaultAngularFrequency;
    private float mDefaultWaterLevel;
    private float mDefaultWaveLength;
    private int mFrontWaveColor;
    private Matrix mShaderMatrix;
    private ShapeType mShapeType;
    private boolean mShowWave;
    private Paint mViewPaint;
    private float mWaterLevelRatio;
    private float mWaveLengthRatio;
    private BitmapShader mWaveShader;
    private float mWaveShiftRatio;
    private boolean showBehindLine;
    public static final int DEFAULT_BEHIND_WAVE_COLOR = Color.parseColor("#28FFFFFF");
    public static final int DEFAULT_FRONT_WAVE_COLOR = Color.parseColor("#3CFFFFFF");
    public static final ShapeType DEFAULT_WAVE_SHAPE = ShapeType.CIRCLE;

    /* renamed from: com.collectpoint.widget.WaveProgressView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$collectpoint$widget$WaveProgressView$ShapeType;

        static {
            int[] iArr = new int[ShapeType.values().length];
            $SwitchMap$com$collectpoint$widget$WaveProgressView$ShapeType = iArr;
            try {
                iArr[ShapeType.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$collectpoint$widget$WaveProgressView$ShapeType[ShapeType.SQUARE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum ShapeType {
        CIRCLE,
        SQUARE
    }

    public WaveProgressView(Context context) {
        super(context);
        this.showBehindLine = true;
        this.mAmplitudeRatio = DEFAULT_AMPLITUDE_RATIO;
        this.mWaveLengthRatio = DEFAULT_WAVE_LENGTH_RATIO;
        this.mWaterLevelRatio = DEFAULT_WATER_LEVEL_RATIO;
        this.mWaveShiftRatio = 0.0f;
        this.mBehindWaveColor = DEFAULT_BEHIND_WAVE_COLOR;
        this.mFrontWaveColor = DEFAULT_FRONT_WAVE_COLOR;
        this.mShapeType = DEFAULT_WAVE_SHAPE;
        init();
    }

    public WaveProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.showBehindLine = true;
        this.mAmplitudeRatio = DEFAULT_AMPLITUDE_RATIO;
        this.mWaveLengthRatio = DEFAULT_WAVE_LENGTH_RATIO;
        this.mWaterLevelRatio = DEFAULT_WATER_LEVEL_RATIO;
        this.mWaveShiftRatio = 0.0f;
        this.mBehindWaveColor = DEFAULT_BEHIND_WAVE_COLOR;
        this.mFrontWaveColor = DEFAULT_FRONT_WAVE_COLOR;
        this.mShapeType = DEFAULT_WAVE_SHAPE;
        init();
    }

    public WaveProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.showBehindLine = true;
        this.mAmplitudeRatio = DEFAULT_AMPLITUDE_RATIO;
        this.mWaveLengthRatio = DEFAULT_WAVE_LENGTH_RATIO;
        this.mWaterLevelRatio = DEFAULT_WATER_LEVEL_RATIO;
        this.mWaveShiftRatio = 0.0f;
        this.mBehindWaveColor = DEFAULT_BEHIND_WAVE_COLOR;
        this.mFrontWaveColor = DEFAULT_FRONT_WAVE_COLOR;
        this.mShapeType = DEFAULT_WAVE_SHAPE;
        init();
    }

    private void createShader() {
        this.mDefaultAngularFrequency = 6.283185307179586d / getWidth();
        this.mDefaultAmplitude = getHeight() * DEFAULT_AMPLITUDE_RATIO;
        this.mDefaultWaterLevel = getHeight() * DEFAULT_WATER_LEVEL_RATIO;
        this.mDefaultWaveLength = getWidth();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setStrokeWidth(2.0f);
        paint.setAntiAlias(true);
        int width = getWidth() + 1;
        int height = getHeight() + 1;
        float[] fArr = new float[width];
        paint.setColor(this.mBehindWaveColor);
        for (int i = 0; i < width; i++) {
            float fSin = (float) (this.mDefaultWaterLevel + (this.mDefaultAmplitude * Math.sin(i * this.mDefaultAngularFrequency)));
            if (this.showBehindLine) {
                canvas.drawLine(i, fSin, i, height, paint);
            }
            fArr[i] = fSin;
        }
        paint.setColor(this.mFrontWaveColor);
        int i2 = (int) (this.mDefaultWaveLength / 4.0f);
        for (int i3 = 0; i3 < width; i3++) {
            canvas.drawLine(i3, fArr[(i3 + i2) % width], i3, height, paint);
        }
        BitmapShader bitmapShader = new BitmapShader(bitmapCreateBitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
        this.mWaveShader = bitmapShader;
        this.mViewPaint.setShader(bitmapShader);
    }

    private void init() {
        this.mShaderMatrix = new Matrix();
        Paint paint = new Paint();
        this.mViewPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mBgPaint = paint2;
        paint2.setAntiAlias(true);
        this.mBgPaint.setColor(-14145496);
    }

    public float getAmplitudeRatio() {
        return this.mAmplitudeRatio;
    }

    public float getWaterLevelRatio() {
        return this.mWaterLevelRatio;
    }

    public float getWaveLengthRatio() {
        return this.mWaveLengthRatio;
    }

    public float getWaveShiftRatio() {
        return this.mWaveShiftRatio;
    }

    public boolean isShowWave() {
        return this.mShowWave;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mShowWave || this.mWaveShader == null) {
            this.mViewPaint.setShader(null);
        }
        if (this.mViewPaint.getShader() == null) {
            this.mViewPaint.setShader(this.mWaveShader);
        }
        this.mShaderMatrix.setScale(this.mWaveLengthRatio / DEFAULT_WAVE_LENGTH_RATIO, this.mAmplitudeRatio / DEFAULT_AMPLITUDE_RATIO, 0.0f, this.mDefaultWaterLevel);
        this.mShaderMatrix.postTranslate(this.mWaveShiftRatio * getWidth(), (DEFAULT_WATER_LEVEL_RATIO - this.mWaterLevelRatio) * getHeight());
        this.mWaveShader.setLocalMatrix(this.mShaderMatrix);
        Paint paint = this.mBorderPaint;
        float strokeWidth = paint == null ? 0.0f : paint.getStrokeWidth();
        switch (AnonymousClass1.$SwitchMap$com$collectpoint$widget$WaveProgressView$ShapeType[this.mShapeType.ordinal()]) {
            case 1:
                if (strokeWidth > 0.0f) {
                    canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((getWidth() - strokeWidth) / 2.0f) - DEFAULT_WAVE_LENGTH_RATIO, this.mBorderPaint);
                }
                float width = (getWidth() / 2.0f) - strokeWidth;
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, width, this.mBgPaint);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, width, this.mViewPaint);
                break;
            case 2:
                if (strokeWidth > 0.0f) {
                    canvas.drawRect(strokeWidth / 2.0f, strokeWidth / 2.0f, (getWidth() - (strokeWidth / 2.0f)) - DEFAULT_WATER_LEVEL_RATIO, (getHeight() - (strokeWidth / 2.0f)) - DEFAULT_WATER_LEVEL_RATIO, this.mBorderPaint);
                }
                canvas.drawRect(strokeWidth, strokeWidth, getWidth() - strokeWidth, getHeight() - strokeWidth, this.mViewPaint);
                break;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        createShader();
    }

    public void setAmplitudeRatio(float f) {
        if (this.mAmplitudeRatio != f) {
            this.mAmplitudeRatio = f;
            invalidate();
        }
    }

    public void setBorder(int i, int i2) {
        if (this.mBorderPaint == null) {
            Paint paint = new Paint();
            this.mBorderPaint = paint;
            paint.setAntiAlias(true);
            this.mBorderPaint.setStyle(Paint.Style.STROKE);
        }
        this.mBorderPaint.setColor(i2);
        this.mBorderPaint.setStrokeWidth(i);
        invalidate();
    }

    public void setShapeType(ShapeType shapeType) {
        this.mShapeType = shapeType;
        invalidate();
    }

    public void setShowBehindLine(boolean z) {
        this.showBehindLine = z;
        invalidate();
    }

    public void setShowWave(boolean z) {
        this.mShowWave = z;
    }

    public void setWaterLevelRatio(float f) {
        if (this.mWaterLevelRatio != f) {
            this.mWaterLevelRatio = f;
            invalidate();
        }
    }

    public void setWaveColor(int i, int i2) {
        this.mBehindWaveColor = i;
        this.mFrontWaveColor = i2;
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        this.mWaveShader = null;
        createShader();
        invalidate();
    }

    public void setWaveLengthRatio(float f) {
        this.mWaveLengthRatio = f;
    }

    public void setWaveShiftRatio(float f) {
        if (this.mWaveShiftRatio != f) {
            this.mWaveShiftRatio = f;
            invalidate();
        }
    }
}
