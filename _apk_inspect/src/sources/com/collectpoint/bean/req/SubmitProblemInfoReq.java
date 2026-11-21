package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class SubmitProblemInfoReq {
    private String typeCode;
    private String userCode;

    public SubmitProblemInfoReq(String str, String str2) {
        this.userCode = str;
        this.typeCode = str2;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
