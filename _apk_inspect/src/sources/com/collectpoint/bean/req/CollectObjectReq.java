package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class CollectObjectReq {
    private String collectObjectCode;
    private String collectObjectName;
    private int page;
    private int rows;
    private String userCode;

    public CollectObjectReq(String str) {
        this.userCode = str;
    }

    public CollectObjectReq(String str, int i, int i2) {
        this.userCode = str;
        this.page = i;
        this.rows = i2;
    }

    public CollectObjectReq(String str, String str2) {
        this.userCode = str;
        this.collectObjectCode = str2;
    }

    public CollectObjectReq(String str, String str2, String str3, int i, int i2) {
        this.userCode = str;
        this.collectObjectCode = str2;
        this.collectObjectName = str3;
        this.page = i;
        this.rows = i2;
    }
}
