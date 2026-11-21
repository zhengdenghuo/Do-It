package com.collectpoint.bean.req;

import android.os.Build;
import com.collectpoint.BuildConfig;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class MobileLoginReq {
    private String phone;
    private String verifyCode;
    private String deviceModel = Build.MODEL;
    private String systemCode = BuildConfig.SYSTEM_CODE;
    private String versionNo = BuildConfig.VERSION_NAME;
    private String softSort = BuildConfig.SOFT_SORT;

    public MobileLoginReq(String str, String str2) {
        this.phone = str;
        this.verifyCode = str2;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getVerifyCode() {
        return this.verifyCode;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setVerifyCode(String str) {
        this.verifyCode = str;
    }
}
