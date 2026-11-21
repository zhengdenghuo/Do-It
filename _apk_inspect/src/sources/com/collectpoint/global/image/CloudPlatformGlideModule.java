package com.collectpoint.global.image;

import android.content.Context;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.collectpoint.BuildConfig;
import java.io.File;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class CloudPlatformGlideModule extends AppGlideModule {
    public static final String GLIDE_DISK_CACHE_DIR_NAME = "glide";
    public static final int GLIDE_DISK_CACHE_SIZE = 52428800;

    public void applyOptions(Context context, GlideBuilder glideBuilder) {
        File file = new File(context.getCacheDir(), "image_manager_disk_cache");
        if (file.exists()) {
            file.delete();
        }
        if (BuildConfig.DEBUG) {
            glideBuilder.setLogLevel(3);
        }
        glideBuilder.setDiskCache(new InternalCacheDiskCacheFactory(context, GLIDE_DISK_CACHE_DIR_NAME, 52428800L));
        glideBuilder.setDefaultRequestOptions(new RequestOptions().error(2131230964).placeholder(2131100231));
    }
}
