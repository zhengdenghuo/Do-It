package com.collectpoint.global.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public final class GlideOptions extends RequestOptions implements Cloneable {
    private static GlideOptions centerCropTransform2;
    private static GlideOptions centerInsideTransform1;
    private static GlideOptions circleCropTransform3;
    private static GlideOptions fitCenterTransform0;
    private static GlideOptions noAnimation5;
    private static GlideOptions noTransformation4;

    public static GlideOptions bitmapTransform(Transformation<Bitmap> transformation) {
        return new GlideOptions().m42transform(transformation);
    }

    public static GlideOptions centerCropTransform() {
        if (centerCropTransform2 == null) {
            centerCropTransform2 = new GlideOptions().centerCrop().autoClone();
        }
        return centerCropTransform2;
    }

    public static GlideOptions centerInsideTransform() {
        if (centerInsideTransform1 == null) {
            centerInsideTransform1 = new GlideOptions().centerInside().autoClone();
        }
        return centerInsideTransform1;
    }

    public static GlideOptions circleCropTransform() {
        if (circleCropTransform3 == null) {
            circleCropTransform3 = new GlideOptions().circleCrop().autoClone();
        }
        return circleCropTransform3;
    }

    public static GlideOptions decodeTypeOf(Class<?> cls) {
        return new GlideOptions().m8decode(cls);
    }

    public static GlideOptions diskCacheStrategyOf(DiskCacheStrategy diskCacheStrategy) {
        return new GlideOptions().diskCacheStrategy(diskCacheStrategy);
    }

    public static GlideOptions downsampleOf(DownsampleStrategy downsampleStrategy) {
        return new GlideOptions().downsample(downsampleStrategy);
    }

    public static GlideOptions encodeFormatOf(Bitmap.CompressFormat compressFormat) {
        return new GlideOptions().encodeFormat(compressFormat);
    }

    public static GlideOptions encodeQualityOf(int i) {
        return new GlideOptions().encodeQuality(i);
    }

    public static GlideOptions errorOf(int i) {
        return new GlideOptions().error(i);
    }

    public static GlideOptions errorOf(Drawable drawable) {
        return new GlideOptions().error(drawable);
    }

    public static GlideOptions fitCenterTransform() {
        if (fitCenterTransform0 == null) {
            fitCenterTransform0 = new GlideOptions().fitCenter().autoClone();
        }
        return fitCenterTransform0;
    }

    public static GlideOptions formatOf(DecodeFormat decodeFormat) {
        return new GlideOptions().format(decodeFormat);
    }

    public static GlideOptions frameOf(long j) {
        return new GlideOptions().frame(j);
    }

    public static GlideOptions noAnimation() {
        if (noAnimation5 == null) {
            noAnimation5 = new GlideOptions().dontAnimate().autoClone();
        }
        return noAnimation5;
    }

    public static GlideOptions noTransformation() {
        if (noTransformation4 == null) {
            noTransformation4 = new GlideOptions().dontTransform().autoClone();
        }
        return noTransformation4;
    }

    public static <T> GlideOptions option(Option<T> option, T t) {
        return new GlideOptions().m36set((Option<Option<T>>) option, (Option<T>) t);
    }

    public static GlideOptions overrideOf(int i) {
        return new GlideOptions().override(i);
    }

    public static GlideOptions overrideOf(int i, int i2) {
        return new GlideOptions().override(i, i2);
    }

    public static GlideOptions placeholderOf(int i) {
        return new GlideOptions().placeholder(i);
    }

    public static GlideOptions placeholderOf(Drawable drawable) {
        return new GlideOptions().placeholder(drawable);
    }

    public static GlideOptions priorityOf(Priority priority) {
        return new GlideOptions().priority(priority);
    }

    public static GlideOptions signatureOf(Key key) {
        return new GlideOptions().signature(key);
    }

    public static GlideOptions sizeMultiplierOf(float f) {
        return new GlideOptions().sizeMultiplier(f);
    }

    public static GlideOptions skipMemoryCacheOf(boolean z) {
        return new GlideOptions().skipMemoryCache(z);
    }

    public static GlideOptions timeoutOf(int i) {
        return new GlideOptions().timeout(i);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions apply(BaseRequestOptions baseRequestOptions) {
        return m1apply((BaseRequestOptions<?>) baseRequestOptions);
    }

    /* renamed from: apply, reason: collision with other method in class */
    public GlideOptions m1apply(BaseRequestOptions<?> baseRequestOptions) {
        return super.apply(baseRequestOptions);
    }

    public GlideOptions autoClone() {
        return super.autoClone();
    }

    public GlideOptions centerCrop() {
        return super.centerCrop();
    }

    public GlideOptions centerInside() {
        return super.centerInside();
    }

    public GlideOptions circleCrop() {
        return super.circleCrop();
    }

    /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideOptions m7clone() {
        return super.clone();
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions decode(Class cls) {
        return m8decode((Class<?>) cls);
    }

    /* renamed from: decode, reason: collision with other method in class */
    public GlideOptions m8decode(Class<?> cls) {
        return super.decode(cls);
    }

    public GlideOptions disallowHardwareConfig() {
        return super.disallowHardwareConfig();
    }

    public GlideOptions diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        return super.diskCacheStrategy(diskCacheStrategy);
    }

    public GlideOptions dontAnimate() {
        return super.dontAnimate();
    }

    public GlideOptions dontTransform() {
        return super.dontTransform();
    }

    public GlideOptions downsample(DownsampleStrategy downsampleStrategy) {
        return super.downsample(downsampleStrategy);
    }

    public GlideOptions encodeFormat(Bitmap.CompressFormat compressFormat) {
        return super.encodeFormat(compressFormat);
    }

    public GlideOptions encodeQuality(int i) {
        return super.encodeQuality(i);
    }

    public GlideOptions error(int i) {
        return super.error(i);
    }

    public GlideOptions error(Drawable drawable) {
        return super.error(drawable);
    }

    public GlideOptions fallback(int i) {
        return super.fallback(i);
    }

    public GlideOptions fallback(Drawable drawable) {
        return super.fallback(drawable);
    }

    public GlideOptions fitCenter() {
        return super.fitCenter();
    }

    public GlideOptions format(DecodeFormat decodeFormat) {
        return super.format(decodeFormat);
    }

    public GlideOptions frame(long j) {
        return super.frame(j);
    }

    public GlideOptions lock() {
        return super.lock();
    }

    public GlideOptions onlyRetrieveFromCache(boolean z) {
        return super.onlyRetrieveFromCache(z);
    }

    public GlideOptions optionalCenterCrop() {
        return super.optionalCenterCrop();
    }

    public GlideOptions optionalCenterInside() {
        return super.optionalCenterInside();
    }

    public GlideOptions optionalCircleCrop() {
        return super.optionalCircleCrop();
    }

    public GlideOptions optionalFitCenter() {
        return super.optionalFitCenter();
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions optionalTransform(Transformation transformation) {
        return m29optionalTransform((Transformation<Bitmap>) transformation);
    }

    /* renamed from: optionalTransform, reason: collision with other method in class */
    public GlideOptions m29optionalTransform(Transformation<Bitmap> transformation) {
        return super.optionalTransform(transformation);
    }

    public <Y> GlideOptions optionalTransform(Class<Y> cls, Transformation<Y> transformation) {
        return super.optionalTransform(cls, transformation);
    }

    public GlideOptions override(int i) {
        return super.override(i);
    }

    public GlideOptions override(int i, int i2) {
        return super.override(i, i2);
    }

    public GlideOptions placeholder(int i) {
        return super.placeholder(i);
    }

    public GlideOptions placeholder(Drawable drawable) {
        return super.placeholder(drawable);
    }

    public GlideOptions priority(Priority priority) {
        return super.priority(priority);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions set(Option option, Object obj) {
        return m36set((Option<Option>) option, (Option) obj);
    }

    /* renamed from: set, reason: collision with other method in class */
    public <Y> GlideOptions m36set(Option<Y> option, Y y) {
        return super.set(option, y);
    }

    public GlideOptions signature(Key key) {
        return super.signature(key);
    }

    public GlideOptions sizeMultiplier(float f) {
        return super.sizeMultiplier(f);
    }

    public GlideOptions skipMemoryCache(boolean z) {
        return super.skipMemoryCache(z);
    }

    public GlideOptions theme(Resources.Theme theme) {
        return super.theme(theme);
    }

    public GlideOptions timeout(int i) {
        return super.timeout(i);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions transform(Transformation transformation) {
        return m42transform((Transformation<Bitmap>) transformation);
    }

    @SafeVarargs
    public /* bridge */ /* synthetic */ BaseRequestOptions transform(Transformation[] transformationArr) {
        return m44transform((Transformation<Bitmap>[]) transformationArr);
    }

    /* renamed from: transform, reason: collision with other method in class */
    public GlideOptions m42transform(Transformation<Bitmap> transformation) {
        return super.transform(transformation);
    }

    public <Y> GlideOptions transform(Class<Y> cls, Transformation<Y> transformation) {
        return super.transform(cls, transformation);
    }

    @SafeVarargs
    /* renamed from: transform, reason: collision with other method in class */
    public final GlideOptions m44transform(Transformation<Bitmap>... transformationArr) {
        return super.transform(transformationArr);
    }

    @SafeVarargs
    @Deprecated
    public /* bridge */ /* synthetic */ BaseRequestOptions transforms(Transformation[] transformationArr) {
        return m45transforms((Transformation<Bitmap>[]) transformationArr);
    }

    @SafeVarargs
    @Deprecated
    /* renamed from: transforms, reason: collision with other method in class */
    public final GlideOptions m45transforms(Transformation<Bitmap>... transformationArr) {
        return super.transforms(transformationArr);
    }

    public GlideOptions useAnimationPool(boolean z) {
        return super.useAnimationPool(z);
    }

    public GlideOptions useUnlimitedSourceGeneratorsPool(boolean z) {
        return super.useUnlimitedSourceGeneratorsPool(z);
    }
}
