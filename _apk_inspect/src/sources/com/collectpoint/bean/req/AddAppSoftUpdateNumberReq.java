package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class AddAppSoftUpdateNumberReq {
    private int id;
    private String userCode;

    public AddAppSoftUpdateNumberReq(String str, int i) {
        this.userCode = str;
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
