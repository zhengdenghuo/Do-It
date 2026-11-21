package com.collectpoint.global.image;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumLoader;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class MediaLoader implements AlbumLoader {
    public void loadAlbumFile(ImageView imageView, AlbumFile albumFile, int i, int i2) {
        Glide.with(imageView.getContext()).load(albumFile.getPath()).apply(new RequestOptions()).into(imageView);
    }

    public void loadImage(ImageView imageView, String str, int i, int i2) {
        Glide.with(imageView.getContext()).load(str).apply(new RequestOptions()).into(imageView);
    }
}
