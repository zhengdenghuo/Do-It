package com.collectpoint.bean.req;

import com.collectpoint.BuildConfig;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class LocationUploadIntervalReq {
    private String systemCode = BuildConfig.SYSTEM_CODE;
    private String userCode;

    public LocationUploadIntervalReq(String str) {
        this.userCode = str;
    }
}
