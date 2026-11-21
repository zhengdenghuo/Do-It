package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.collectpoint.global.image.CloudPlatformGlideModule;
import java.util.Collections;
import java.util.Set;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    private final CloudPlatformGlideModule appGlideModule = new CloudPlatformGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.collectpoint.global.image.CloudPlatformGlideModule");
        }
    }

    public void applyOptions(Context context, GlideBuilder builder) {
        this.appGlideModule.applyOptions(context, builder);
    }

    public void registerComponents(Context context, Glide glide, Registry registry) {
        this.appGlideModule.registerComponents(context, glide, registry);
    }

    public boolean isManifestParsingEnabled() {
        return this.appGlideModule.isManifestParsingEnabled();
    }

    public Set<Class<?>> getExcludedModuleClasses() {
        return Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: getRequestManagerFactory, reason: merged with bridge method [inline-methods] */
    public GeneratedRequestManagerFactory m0getRequestManagerFactory() {
        return new GeneratedRequestManagerFactory();
    }
}
