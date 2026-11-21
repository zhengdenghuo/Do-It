package com.collectpoint.global.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.liuwq.base.image.ImgLoaderOption;
import com.liuwq.base.image.ImgLoaderStrategy;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumLoader;
import com.yanzhenjie.album.task.DefaultAlbumLoader;
import com.youth.banner.loader.ImageLoader;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class GlideStrategy extends ImageLoader implements ImgLoaderStrategy, AlbumLoader {
    private <T> GlideRequest loadOption(GlideRequest<T> glideRequest, ImgLoaderOption imgLoaderOption) {
        if (imgLoaderOption == null) {
            return glideRequest;
        }
        glideRequest.fallback(imgLoaderOption.getFallback()).error(imgLoaderOption.getError()).placeholder(imgLoaderOption.getPlaceholder());
        ImgLoaderOption.ImgSize imgSize = imgLoaderOption.getImgSize();
        if (imgSize != null) {
            glideRequest.override(imgSize.width, imgSize.height);
        }
        return glideRequest;
    }

    public void displayImage(Context context, Object obj, ImageView imageView) {
        load(imageView, obj, 2131100231);
    }

    public void load(ImageView imageView, Object obj, int i) {
        GlideApp.with(imageView).m144load(obj).placeholder(i).into(imageView);
    }

    public void load(ImageView imageView, Object obj, ImgLoaderOption imgLoaderOption) {
        GlideRequest<Drawable> glideRequestM144load = GlideApp.with(imageView).m144load(obj);
        loadOption(glideRequestM144load, imgLoaderOption);
        if (imageView instanceof CircleImageView) {
            glideRequestM144load.dontAnimate();
        } else {
            glideRequestM144load.transition((TransitionOptions<?, ? super Drawable>) new DrawableTransitionOptions().crossFade());
        }
        glideRequestM144load.into(imageView);
    }

    public void load(ImageView imageView, Object obj, Object obj2) {
        GlideRequest<Drawable> glideRequestError = null;
        if (obj2 instanceof Drawable) {
            glideRequestError = GlideApp.with(imageView).m144load(obj).error((Drawable) obj2);
        } else if (obj2 instanceof Integer) {
            glideRequestError = GlideApp.with(imageView).m144load(obj).error(((Integer) obj2).intValue());
        }
        if (glideRequestError == null) {
            return;
        }
        glideRequestError.into(imageView);
    }

    public void load(ImageView imageView, Object obj, Object obj2, Object obj3) {
        GlideRequest<Drawable> glideRequestFallback = null;
        if (obj2 instanceof Drawable) {
            glideRequestFallback = GlideApp.with(imageView).m144load(obj).fallback((Drawable) obj2);
        } else if (obj2 instanceof Integer) {
            glideRequestFallback = GlideApp.with(imageView).m144load(obj).fallback(((Integer) obj2).intValue());
        }
        if (glideRequestFallback == null) {
            return;
        }
        if (obj3 instanceof Drawable) {
            glideRequestFallback.error((Drawable) obj3);
        } else if (obj3 instanceof Integer) {
            glideRequestFallback.error(((Integer) obj3).intValue());
        }
        glideRequestFallback.into(imageView);
    }

    public void loadAlbumFile(ImageView imageView, AlbumFile albumFile, int i, int i2) {
        int mediaType = albumFile.getMediaType();
        if (mediaType == 1) {
            load(imageView, (Object) albumFile.getPath(), new ImgLoaderOption.Builder().setImgSize(new ImgLoaderOption.ImgSize(i, i2)).build());
        } else if (mediaType == 2) {
            DefaultAlbumLoader.getInstance().loadAlbumFile(imageView, albumFile, i, i2);
        }
    }

    public void loadDrawable(ImageView imageView, Object obj) {
        GlideApp.with(imageView).asDrawable().m89load(obj).transition((TransitionOptions<?, ? super Drawable>) new DrawableTransitionOptions().crossFade()).into(imageView);
    }

    public void loadImage(ImageView imageView, String str, int i, int i2) {
        load(imageView, (Object) str, new ImgLoaderOption.Builder().setImgSize(new ImgLoaderOption.ImgSize(i, i2)).build());
    }
}
