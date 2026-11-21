package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class CurrentDatePatrolPersonnelSignInTaskListReq {
    private double latitude;
    private double longitude;
    private String projectOrgCode;
    private String userCode;

    public CurrentDatePatrolPersonnelSignInTaskListReq(String str, String str2, double d, double d2) {
        this.userCode = str;
        this.projectOrgCode = str2;
        this.longitude = d;
        this.latitude = d2;
    }
}
