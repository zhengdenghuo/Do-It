package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class ProblemOperationRecordListReq {
    private int page;
    private String problemCode;
    private int rows;
    private String userCode;

    public ProblemOperationRecordListReq(String str, String str2, int i, int i2) {
        this.userCode = str;
        this.problemCode = str2;
        this.page = i;
        this.rows = i2;
    }

    public int getPage() {
        return this.page;
    }

    public String getProblemCode() {
        return this.problemCode;
    }

    public int getRows() {
        return this.rows;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setPage(int i) {
        this.page = i;
    }

    public void setProblemCode(String str) {
        this.problemCode = str;
    }

    public void setRows(int i) {
        this.rows = i;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
