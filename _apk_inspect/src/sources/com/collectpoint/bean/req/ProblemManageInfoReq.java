package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class ProblemManageInfoReq {
    private String problemCode;
    private String userCode;

    public ProblemManageInfoReq(String str, String str2) {
        this.userCode = str;
        this.problemCode = str2;
    }

    public String getProblemCode() {
        return this.problemCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setProblemCode(String str) {
        this.problemCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
