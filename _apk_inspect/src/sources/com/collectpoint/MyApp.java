package com.collectpoint;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import com.amap.api.location.AMapLocationClient;
import com.chenenyu.router.Router;
import com.collectpoint.constants.Constants;
import com.collectpoint.global.image.GlideStrategy;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.CrashHandler;
import com.collectpoint.utils.SharedPreManager;
import com.liuwq.base.MyActivityManager;
import com.liuwq.base.fragment.BaseTitleFragment;
import com.liuwq.base.image.ImgLoaderManager;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;
import timber.log.Timber;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class MyApp extends MultiDexApplication {
    private static Context mContext;
    private static MyApp singleton;
    private int countActivity = 0;
    private boolean isBackground;

    static /* synthetic */ int access$008(MyApp myApp) {
        int i = myApp.countActivity;
        myApp.countActivity = i + 1;
        return i;
    }

    static /* synthetic */ int access$010(MyApp myApp) {
        int i = myApp.countActivity;
        myApp.countActivity = i - 1;
        return i;
    }

    public static Context getContext() {
        return mContext;
    }

    public static MyApp getInstance() {
        return singleton;
    }

    private void initBackgroundCallBack() {
        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.collectpoint.MyApp.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                MyApp.access$008(MyApp.this);
                if (MyApp.this.countActivity == 1 && MyApp.this.isBackground) {
                    Log.e("MyApplication", "onActivityStarted: 应用进入前台");
                    MyApp.this.isBackground = false;
                    if (SharedPreManager.getShared().isNewDay().booleanValue()) {
                        MyApp.this.logout();
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MyApp.access$010(MyApp.this);
                if (MyApp.this.countActivity > 0 || MyApp.this.isBackground) {
                    return;
                }
                Log.e("MyApplication", "onActivityStarted: 应用进入后台");
                MyApp.this.isBackground = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void logout() {
        Router.build(Constants.LOGIN).go(this);
        MyActivityManager.destroyAllActivity();
        CacheUtils.getInstance().getCacheDoubleUtils().remove(Constants.KEY_PARCELABLE_LOGGED_IN_USER);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        mContext = getApplicationContext();
        singleton = this;
        CrashHandler.getInstance().init(this);
        BaseTitleFragment.setDefaultLeftIconRes(2131231067);
        GlideStrategy glideStrategy = new GlideStrategy();
        ImgLoaderManager.get().setImgLoader(glideStrategy);
        Album.initialize(AlbumConfig.newBuilder(this).setAlbumLoader(glideStrategy).build());
        initBackgroundCallBack();
        AMapLocationClient.updatePrivacyAgree(getApplicationContext(), true);
        AMapLocationClient.updatePrivacyShow(getApplicationContext(), true, true);
    }
}
