package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class ReportPatrolProblemRecordListReq {
    private String endMonth;
    private String manageUnitCode;
    private String orgCode;
    private int page;
    private String problemStatus;
    private String reportType;
    private int rows;
    private String startMonth;
    private String typeCode;
    private String userCode;

    public ReportPatrolProblemRecordListReq(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2) {
        this.userCode = str;
        this.orgCode = str2;
        this.problemStatus = str3;
        this.typeCode = str4;
        this.manageUnitCode = str5;
        this.startMonth = str6;
        this.endMonth = str7;
        this.page = i;
        this.rows = i2;
        this.reportType = str8;
    }

    public String getEndMonth() {
        return this.endMonth;
    }

    public String getManageUnitCode() {
        return this.manageUnitCode;
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

    public String getReportType() {
        return this.reportType;
    }

    public int getRows() {
        return this.rows;
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

    public void setEndMonth(String str) {
        this.endMonth = str;
    }

    public void setManageUnitCode(String str) {
        this.manageUnitCode = str;
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

    public void setReportType(String str) {
        this.reportType = str;
    }

    public void setRows(int i) {
        this.rows = i;
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
