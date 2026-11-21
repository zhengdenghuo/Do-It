package com.collectpoint.utils;

import com.blankj.utilcode.util.CacheDiskUtils;
import com.blankj.utilcode.util.CacheDoubleUtils;
import com.blankj.utilcode.util.CacheMemoryUtils;
import com.collectpoint.MyApp;
import com.collectpoint.bean.UserBean;
import com.collectpoint.constants.Constants;
import com.liuwq.base.util.FileTool;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class CacheUtils {
    private static CacheDiskUtils mDiskUtils;
    private static CacheDoubleUtils mDoubleCacheUtils;
    private static CacheUtils mInstance;
    private static CacheMemoryUtils mMemoryUtils;

    public static CacheUtils getInstance() {
        if (EmptyUtils.isEmpty(mInstance)) {
            mInstance = new CacheUtils();
            mDiskUtils = CacheDiskUtils.getInstance(FileTool.getDiskCacheDir(MyApp.getContext(), Constants.DISK_CACHE_DIR_NAME));
            CacheMemoryUtils cacheMemoryUtils = CacheMemoryUtils.getInstance();
            mMemoryUtils = cacheMemoryUtils;
            mDoubleCacheUtils = CacheDoubleUtils.getInstance(cacheMemoryUtils, mDiskUtils);
        }
        return mInstance;
    }

    public CacheDoubleUtils getCacheDoubleUtils() {
        return mDoubleCacheUtils;
    }

    public String getToken() {
        try {
            UserBean userBean = getUserBean();
            return EmptyUtils.isNotEmpty(userBean) ? userBean.getToken() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public UserBean getUserBean() {
        return (UserBean) CacheDoubleUtils.getInstance(CacheMemoryUtils.getInstance(), CacheDiskUtils.getInstance(FileTool.getDiskCacheDir(MyApp.getContext(), Constants.DISK_CACHE_DIR_NAME))).getParcelable(Constants.KEY_PARCELABLE_LOGGED_IN_USER, UserBean.CREATOR);
    }
}
