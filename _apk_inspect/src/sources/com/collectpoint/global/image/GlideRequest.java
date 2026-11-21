package com.collectpoint.global.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import java.io.File;
import java.net.URL;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class GlideRequest<TranscodeType> extends RequestBuilder<TranscodeType> implements Cloneable {
    GlideRequest(Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        super(glide, requestManager, cls, context);
    }

    GlideRequest(Class<TranscodeType> cls, RequestBuilder<?> requestBuilder) {
        super(cls, requestBuilder);
    }

    public GlideRequest<TranscodeType> addListener(RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.addListener(requestListener);
    }

    public /* bridge */ /* synthetic */ RequestBuilder apply(BaseRequestOptions baseRequestOptions) {
        return m50apply((BaseRequestOptions<?>) baseRequestOptions);
    }

    /* renamed from: apply, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ BaseRequestOptions m49apply(BaseRequestOptions baseRequestOptions) {
        return m50apply((BaseRequestOptions<?>) baseRequestOptions);
    }

    /* renamed from: apply, reason: collision with other method in class */
    public GlideRequest<TranscodeType> m50apply(BaseRequestOptions<?> baseRequestOptions) {
        return (GlideRequest) super.apply(baseRequestOptions);
    }

    public GlideRequest<TranscodeType> centerCrop() {
        return super.centerCrop();
    }

    public GlideRequest<TranscodeType> centerInside() {
        return super.centerInside();
    }

    public GlideRequest<TranscodeType> circleCrop() {
        return super.circleCrop();
    }

    /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m56clone() {
        return (GlideRequest) super.clone();
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions decode(Class cls) {
        return m57decode((Class<?>) cls);
    }

    /* renamed from: decode, reason: collision with other method in class */
    public GlideRequest<TranscodeType> m57decode(Class<?> cls) {
        return super.decode(cls);
    }

    public GlideRequest<TranscodeType> disallowHardwareConfig() {
        return super.disallowHardwareConfig();
    }

    public GlideRequest<TranscodeType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        return super.diskCacheStrategy(diskCacheStrategy);
    }

    public GlideRequest<TranscodeType> dontAnimate() {
        return super.dontAnimate();
    }

    public GlideRequest<TranscodeType> dontTransform() {
        return super.dontTransform();
    }

    public GlideRequest<TranscodeType> downsample(DownsampleStrategy downsampleStrategy) {
        return super.downsample(downsampleStrategy);
    }

    public GlideRequest<TranscodeType> encodeFormat(Bitmap.CompressFormat compressFormat) {
        return super.encodeFormat(compressFormat);
    }

    public GlideRequest<TranscodeType> encodeQuality(int i) {
        return super.encodeQuality(i);
    }

    public GlideRequest<TranscodeType> error(int i) {
        return super.error(i);
    }

    public GlideRequest<TranscodeType> error(Drawable drawable) {
        return super.error(drawable);
    }

    public GlideRequest<TranscodeType> error(RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest) super.error(requestBuilder);
    }

    public GlideRequest<TranscodeType> fallback(int i) {
        return super.fallback(i);
    }

    public GlideRequest<TranscodeType> fallback(Drawable drawable) {
        return super.fallback(drawable);
    }

    public GlideRequest<TranscodeType> fitCenter() {
        return super.fitCenter();
    }

    public GlideRequest<TranscodeType> format(DecodeFormat decodeFormat) {
        return super.format(decodeFormat);
    }

    public GlideRequest<TranscodeType> frame(long j) {
        return super.frame(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GlideRequest<File> getDownloadOnlyRequest() {
        return new GlideRequest(File.class, this).m50apply((BaseRequestOptions<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    public GlideRequest<TranscodeType> listener(RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.listener(requestListener);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m84load(Bitmap bitmap) {
        return (GlideRequest) super.load(bitmap);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m85load(Drawable drawable) {
        return (GlideRequest) super.load(drawable);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m86load(Uri uri) {
        return (GlideRequest) super.load(uri);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m87load(File file) {
        return (GlideRequest) super.load(file);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m88load(Integer num) {
        return (GlideRequest) super.load(num);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m89load(Object obj) {
        return (GlideRequest) super.load(obj);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m90load(String str) {
        return (GlideRequest) super.load(str);
    }

    @Deprecated
    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m91load(URL url) {
        return (GlideRequest) super.load(url);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m92load(byte[] bArr) {
        return (GlideRequest) super.load(bArr);
    }

    public GlideRequest<TranscodeType> onlyRetrieveFromCache(boolean z) {
        return super.onlyRetrieveFromCache(z);
    }

    public GlideRequest<TranscodeType> optionalCenterCrop() {
        return super.optionalCenterCrop();
    }

    public GlideRequest<TranscodeType> optionalCenterInside() {
        return super.optionalCenterInside();
    }

    public GlideRequest<TranscodeType> optionalCircleCrop() {
        return super.optionalCircleCrop();
    }

    public GlideRequest<TranscodeType> optionalFitCenter() {
        return super.optionalFitCenter();
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions optionalTransform(Transformation transformation) {
        return m98optionalTransform((Transformation<Bitmap>) transformation);
    }

    /* renamed from: optionalTransform, reason: collision with other method in class */
    public GlideRequest<TranscodeType> m98optionalTransform(Transformation<Bitmap> transformation) {
        return super.optionalTransform(transformation);
    }

    public <Y> GlideRequest<TranscodeType> optionalTransform(Class<Y> cls, Transformation<Y> transformation) {
        return super.optionalTransform(cls, transformation);
    }

    public GlideRequest<TranscodeType> override(int i) {
        return super.override(i);
    }

    public GlideRequest<TranscodeType> override(int i, int i2) {
        return super.override(i, i2);
    }

    public GlideRequest<TranscodeType> placeholder(int i) {
        return super.placeholder(i);
    }

    public GlideRequest<TranscodeType> placeholder(Drawable drawable) {
        return super.placeholder(drawable);
    }

    public GlideRequest<TranscodeType> priority(Priority priority) {
        return super.priority(priority);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions set(Option option, Object obj) {
        return m105set((Option<Option>) option, (Option) obj);
    }

    /* renamed from: set, reason: collision with other method in class */
    public <Y> GlideRequest<TranscodeType> m105set(Option<Y> option, Y y) {
        return super.set(option, y);
    }

    public GlideRequest<TranscodeType> signature(Key key) {
        return super.signature(key);
    }

    public GlideRequest<TranscodeType> sizeMultiplier(float f) {
        return super.sizeMultiplier(f);
    }

    public GlideRequest<TranscodeType> skipMemoryCache(boolean z) {
        return super.skipMemoryCache(z);
    }

    public GlideRequest<TranscodeType> theme(Resources.Theme theme) {
        return super.theme(theme);
    }

    public GlideRequest<TranscodeType> thumbnail(float f) {
        return (GlideRequest) super.thumbnail(f);
    }

    public GlideRequest<TranscodeType> thumbnail(RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest) super.thumbnail(requestBuilder);
    }

    @SafeVarargs
    public final GlideRequest<TranscodeType> thumbnail(RequestBuilder<TranscodeType>... requestBuilderArr) {
        return (GlideRequest) super.thumbnail(requestBuilderArr);
    }

    public GlideRequest<TranscodeType> timeout(int i) {
        return super.timeout(i);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions transform(Transformation transformation) {
        return m114transform((Transformation<Bitmap>) transformation);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions transform(Transformation[] transformationArr) {
        return m116transform((Transformation<Bitmap>[]) transformationArr);
    }

    /* renamed from: transform, reason: collision with other method in class */
    public GlideRequest<TranscodeType> m114transform(Transformation<Bitmap> transformation) {
        return super.transform(transformation);
    }

    public <Y> GlideRequest<TranscodeType> transform(Class<Y> cls, Transformation<Y> transformation) {
        return super.transform(cls, transformation);
    }

    /* renamed from: transform, reason: collision with other method in class */
    public GlideRequest<TranscodeType> m116transform(Transformation<Bitmap>... transformationArr) {
        return super.transform(transformationArr);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ BaseRequestOptions transforms(Transformation[] transformationArr) {
        return m117transforms((Transformation<Bitmap>[]) transformationArr);
    }

    @Deprecated
    /* renamed from: transforms, reason: collision with other method in class */
    public GlideRequest<TranscodeType> m117transforms(Transformation<Bitmap>... transformationArr) {
        return super.transforms(transformationArr);
    }

    public GlideRequest<TranscodeType> transition(TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        return (GlideRequest) super.transition(transitionOptions);
    }

    public GlideRequest<TranscodeType> useAnimationPool(boolean z) {
        return super.useAnimationPool(z);
    }

    public GlideRequest<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean z) {
        return super.useUnlimitedSourceGeneratorsPool(z);
    }
}
