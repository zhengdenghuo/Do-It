package com.collectpoint.bean.req;

import android.os.Build;
import com.collectpoint.BuildConfig;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class ApiLoginReq {
    private String deviceToken;
    private String password;
    private String user_name;
    private String systemCode = BuildConfig.SYSTEM_CODE;
    private String versionNo = BuildConfig.VERSION_NAME;
    private String softSort = BuildConfig.SOFT_SORT;
    private String deviceModel = Build.MODEL;

    public ApiLoginReq(String str, String str2, String str3) {
        this.user_name = str;
        this.password = str2;
        this.deviceToken = str3;
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSystemCode() {
        return this.systemCode;
    }

    public String getUserName() {
        return this.user_name;
    }

    public void setDeviceToken(String str) {
        this.deviceToken = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setSystemCode(String str) {
        this.systemCode = str;
    }

    public void setUserName(String str) {
        this.user_name = str;
    }
}
