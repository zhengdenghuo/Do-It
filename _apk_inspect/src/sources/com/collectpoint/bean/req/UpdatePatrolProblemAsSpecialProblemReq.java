package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class UpdatePatrolProblemAsSpecialProblemReq {
    private String problemCode;
    private String userCode;
    private String userName;

    public UpdatePatrolProblemAsSpecialProblemReq(String str, String str2, String str3) {
        this.userCode = str;
        this.userName = str2;
        this.problemCode = str3;
    }

    public String getProblemCode() {
        return this.problemCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setProblemCode(String str) {
        this.problemCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
