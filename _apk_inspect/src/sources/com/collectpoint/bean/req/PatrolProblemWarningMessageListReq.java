package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PatrolProblemWarningMessageListReq {
    private int page;
    private int rows;
    private String userCode;

    public PatrolProblemWarningMessageListReq(String str, int i, int i2) {
        this.userCode = str;
        this.page = i;
        this.rows = i2;
    }

    public int getPage() {
        return this.page;
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

    public void setRows(int i) {
        this.rows = i;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
