package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class FiveColorWarningWorkOrderListReq {
    private String colorStatus;
    private String endMonth;
    private String orgCode;
    private int page;
    private String problemStatus;
    private int rows;
    private String startMonth;
    private String userCode;

    public FiveColorWarningWorkOrderListReq(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        this.userCode = str;
        this.orgCode = str2;
        this.problemStatus = str3;
        this.colorStatus = str4;
        this.startMonth = str5;
        this.endMonth = str6;
        this.page = i;
        this.rows = i2;
    }

    public String getColorStatus() {
        return this.colorStatus;
    }

    public String getEndMonth() {
        return this.endMonth;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public int getPage() {
        return this.page;
    }

    public String getProblemStatus() {
        return this.problemStatus;
    }

    public int getRows() {
        return this.rows;
    }

    public String getStartMonth() {
        return this.startMonth;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setColorStatus(String str) {
        this.colorStatus = str;
    }

    public void setEndMonth(String str) {
        this.endMonth = str;
    }

    public void setOrgCode(String str) {
        this.orgCode = str;
    }

    public void setPage(int i) {
        this.page = i;
    }

    public void setProblemStatus(String str) {
        this.problemStatus = str;
    }

    public void setRows(int i) {
        this.rows = i;
    }

    public void setStartMonth(String str) {
        this.startMonth = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
