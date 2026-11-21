package com.collectpoint.global.image;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import java.io.File;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public final class GlideApp {
    private GlideApp() {
    }

    public static Glide get(Context context) {
        return Glide.get(context);
    }

    public static File getPhotoCacheDir(Context context) {
        return Glide.getPhotoCacheDir(context);
    }

    public static File getPhotoCacheDir(Context context, String str) {
        return Glide.getPhotoCacheDir(context, str);
    }

    public static void init(Context context, GlideBuilder glideBuilder) {
        Glide.init(context, glideBuilder);
    }

    @Deprecated
    public static void init(Glide glide) {
        Glide.init(glide);
    }

    public static void tearDown() {
        Glide.tearDown();
    }

    public static GlideRequests with(Activity activity) {
        return (GlideRequests) Glide.with(activity);
    }

    @Deprecated
    public static GlideRequests with(Fragment fragment) {
        return (GlideRequests) Glide.with(fragment);
    }

    public static GlideRequests with(Context context) {
        return (GlideRequests) Glide.with(context);
    }

    public static GlideRequests with(View view) {
        return (GlideRequests) Glide.with(view);
    }

    public static GlideRequests with(androidx.fragment.app.Fragment fragment) {
        return (GlideRequests) Glide.with(fragment);
    }

    public static GlideRequests with(FragmentActivity fragmentActivity) {
        return (GlideRequests) Glide.with(fragmentActivity);
    }
}
