package com.collectpoint.bean.req;

import com.collectpoint.BuildConfig;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class UpdateUserProjectOrgCodeReq {
    private String projectOrgCode;
    private String systemCode = BuildConfig.SYSTEM_CODE;
    private String userCode;
    private String userRoleCode;

    public UpdateUserProjectOrgCodeReq(String str, String str2, String str3) {
        this.userCode = str;
        this.projectOrgCode = str2;
        this.userRoleCode = str3;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getSystemCode() {
        return this.systemCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public String getUserRoleCode() {
        return this.userRoleCode;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setSystemCode(String str) {
        this.systemCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public void setUserRoleCode(String str) {
        this.userRoleCode = str;
    }
}
