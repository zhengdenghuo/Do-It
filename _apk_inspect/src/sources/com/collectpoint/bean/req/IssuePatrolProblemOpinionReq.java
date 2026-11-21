package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class IssuePatrolProblemOpinionReq {
    private String opinionContent;
    private String problemCode;
    private String submitUserCode;
    private String submitUserName;

    public IssuePatrolProblemOpinionReq(String str, String str2, String str3, String str4) {
        this.submitUserCode = str;
        this.submitUserName = str2;
        this.problemCode = str3;
        this.opinionContent = str4;
    }

    public String getOpinionContent() {
        return this.opinionContent;
    }

    public String getProblemCode() {
        return this.problemCode;
    }

    public String getSubmitUserCode() {
        return this.submitUserCode;
    }

    public String getSubmitUserName() {
        return this.submitUserName;
    }

    public void setOpinionContent(String str) {
        this.opinionContent = str;
    }

    public void setProblemCode(String str) {
        this.problemCode = str;
    }

    public void setSubmitUserCode(String str) {
        this.submitUserCode = str;
    }

    public void setSubmitUserName(String str) {
        this.submitUserName = str;
    }
}
