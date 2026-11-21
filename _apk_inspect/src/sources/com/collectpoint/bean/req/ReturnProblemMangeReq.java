package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class ReturnProblemMangeReq {
    private String manageOpion;
    private String problemCode;
    private String userCode;

    public ReturnProblemMangeReq(String str, String str2, String str3) {
        this.userCode = str;
        this.problemCode = str2;
        this.manageOpion = str3;
    }

    public String getManageOpion() {
        return this.manageOpion;
    }

    public String getProblemCode() {
        return this.problemCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setManageOpion(String str) {
        this.manageOpion = str;
    }

    public void setProblemCode(String str) {
        this.problemCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
