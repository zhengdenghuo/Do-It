package com.collectpoint.global.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class GlideRequests extends RequestManager {
    public GlideRequests(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    public /* bridge */ /* synthetic */ RequestManager addDefaultRequestListener(RequestListener requestListener) {
        return m121addDefaultRequestListener((RequestListener<Object>) requestListener);
    }

    /* renamed from: addDefaultRequestListener, reason: collision with other method in class */
    public GlideRequests m121addDefaultRequestListener(RequestListener<Object> requestListener) {
        return (GlideRequests) super.addDefaultRequestListener(requestListener);
    }

    public synchronized GlideRequests applyDefaultRequestOptions(RequestOptions requestOptions) {
        return (GlideRequests) super.applyDefaultRequestOptions(requestOptions);
    }

    public <ResourceType> GlideRequest<ResourceType> as(Class<ResourceType> cls) {
        return new GlideRequest<>(this.glide, this, cls, this.context);
    }

    public GlideRequest<Bitmap> asBitmap() {
        return (GlideRequest) super.asBitmap();
    }

    public GlideRequest<Drawable> asDrawable() {
        return (GlideRequest) super.asDrawable();
    }

    public GlideRequest<File> asFile() {
        return (GlideRequest) super.asFile();
    }

    public GlideRequest<GifDrawable> asGif() {
        return (GlideRequest) super.asGif();
    }

    public GlideRequest<File> download(Object obj) {
        return (GlideRequest) super.download(obj);
    }

    public GlideRequest<File> downloadOnly() {
        return (GlideRequest) super.downloadOnly();
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m139load(Bitmap bitmap) {
        return (GlideRequest) super.load(bitmap);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m140load(Drawable drawable) {
        return (GlideRequest) super.load(drawable);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m141load(Uri uri) {
        return (GlideRequest) super.load(uri);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m142load(File file) {
        return (GlideRequest) super.load(file);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m143load(Integer num) {
        return (GlideRequest) super.load(num);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m144load(Object obj) {
        return (GlideRequest) super.load(obj);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m145load(String str) {
        return (GlideRequest) super.load(str);
    }

    @Deprecated
    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m146load(URL url) {
        return (GlideRequest) super.load(url);
    }

    /* renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m147load(byte[] bArr) {
        return (GlideRequest) super.load(bArr);
    }

    public synchronized GlideRequests setDefaultRequestOptions(RequestOptions requestOptions) {
        return (GlideRequests) super.setDefaultRequestOptions(requestOptions);
    }

    protected void setRequestOptions(RequestOptions requestOptions) {
        if (requestOptions instanceof GlideOptions) {
            super.setRequestOptions(requestOptions);
        } else {
            super.setRequestOptions(new GlideOptions().m1apply((BaseRequestOptions<?>) requestOptions));
        }
    }
}
