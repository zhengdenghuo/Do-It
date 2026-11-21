package com.collectpoint.bean.req;

import com.collectpoint.BuildConfig;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class AppDownloadQRCodeReq {
    private String userCode;
    private String softType = "android";
    private String softSort = BuildConfig.SOFT_SORT;

    public AppDownloadQRCodeReq(String str) {
        this.userCode = str;
    }

    public String getSoftSort() {
        return this.softSort;
    }

    public String getSoftType() {
        return this.softType;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setSoftSort(String str) {
        this.softSort = str;
    }

    public void setSoftType(String str) {
        this.softType = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
