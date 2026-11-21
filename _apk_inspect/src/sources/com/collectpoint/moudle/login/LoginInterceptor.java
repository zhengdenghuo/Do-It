package com.collectpoint.moudle.login;

import android.app.Activity;
import android.content.Context;
import com.blankj.utilcode.util.CacheDiskUtils;
import com.blankj.utilcode.util.CacheDoubleUtils;
import com.blankj.utilcode.util.CacheMemoryUtils;
import com.chenenyu.router.RouteInterceptor;
import com.chenenyu.router.RouteResponse;
import com.chenenyu.router.Router;
import com.collectpoint.bean.UserBean;
import com.collectpoint.constants.Constants;
import com.liuwq.base.util.FileTool;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes15.dex */
public class LoginInterceptor implements RouteInterceptor {
    public RouteResponse intercept(RouteInterceptor.Chain chain) {
        Context context = chain.getContext();
        Object source = chain.getSource();
        if (((UserBean) CacheDoubleUtils.getInstance(CacheMemoryUtils.getInstance(), CacheDiskUtils.getInstance(FileTool.getDiskCacheDir(context, Constants.DISK_CACHE_DIR_NAME))).getParcelable(Constants.KEY_PARCELABLE_LOGGED_IN_USER, UserBean.CREATOR)) != null) {
            if ((source instanceof LoginActivity) || (source instanceof SplashActivity)) {
                ((Activity) source).finish();
            }
            return chain.process();
        }
        Router.build(Constants.LOGIN).go(context);
        if (source instanceof SplashActivity) {
            ((Activity) source).finish();
        }
        return chain.intercept();
    }
}
