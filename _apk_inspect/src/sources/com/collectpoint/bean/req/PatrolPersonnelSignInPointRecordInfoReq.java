package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PatrolPersonnelSignInPointRecordInfoReq {
    private double latitude;
    private double longitude;
    private String projectOrgCode;
    private String signInRecordCode;
    private String userCode;

    public PatrolPersonnelSignInPointRecordInfoReq(String str, String str2, String str3, double d, double d2) {
        this.userCode = str;
        this.projectOrgCode = str2;
        this.signInRecordCode = str3;
        this.longitude = d;
        this.latitude = d2;
    }
}
