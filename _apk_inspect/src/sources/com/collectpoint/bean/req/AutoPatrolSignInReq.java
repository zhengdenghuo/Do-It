package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class AutoPatrolSignInReq {
    private String latitude;
    private String longitude;
    private String projectOrgCode;
    private String userCode;

    public AutoPatrolSignInReq(double d, double d2) {
        this.longitude = String.valueOf(d);
        this.latitude = String.valueOf(d2);
    }

    public AutoPatrolSignInReq(String str, String str2, double d, double d2) {
        this.userCode = str;
        this.projectOrgCode = str2;
        this.longitude = String.valueOf(d);
        this.latitude = String.valueOf(d2);
    }
}
