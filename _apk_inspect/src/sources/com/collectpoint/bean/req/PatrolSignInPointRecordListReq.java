package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PatrolSignInPointRecordListReq {
    private double latitude;
    private double longitude;
    private int page;
    private String projectOrgCode;
    private int rows;
    private String signInDate;
    private String signInPointCode;
    private String userCode;

    public PatrolSignInPointRecordListReq(String str, String str2, String str3, String str4, double d, double d2, int i, int i2) {
        this.userCode = str;
        this.projectOrgCode = str2;
        this.signInDate = str3;
        this.signInPointCode = str4;
        this.longitude = d;
        this.latitude = d2;
        this.page = i;
        this.rows = i2;
    }
}
