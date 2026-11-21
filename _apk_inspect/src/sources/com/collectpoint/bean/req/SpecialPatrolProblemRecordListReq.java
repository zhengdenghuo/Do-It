package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class SpecialPatrolProblemRecordListReq {
    private String endDate;
    private String endMonth;
    private String orgCode;
    private int page;
    private int rows;
    private String startDate;
    private String startMonth;
    private String typeCode;
    private String userCode;

    public SpecialPatrolProblemRecordListReq(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2) {
        this.userCode = str;
        this.orgCode = str2;
        this.typeCode = str3;
        this.startDate = str4;
        this.endDate = str5;
        this.startMonth = str6;
        this.endMonth = str7;
        this.page = i;
        this.rows = i2;
    }

    public String getEndDate() {
        return this.endDate;
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

    public int getRows() {
        return this.rows;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getStartMonth() {
        return this.startMonth;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setEndDate(String str) {
        this.endDate = str;
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

    public void setRows(int i) {
        this.rows = i;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public void setStartMonth(String str) {
        this.startMonth = str;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
