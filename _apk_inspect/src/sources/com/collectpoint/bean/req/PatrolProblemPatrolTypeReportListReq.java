package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PatrolProblemPatrolTypeReportListReq {
    private String endMonth;
    private String orgCode;
    private String startMonth;
    private String userCode;

    public PatrolProblemPatrolTypeReportListReq(String str, String str2, String str3, String str4) {
        this.userCode = str;
        this.orgCode = str2;
        this.startMonth = str3;
        this.endMonth = str4;
    }

    public String getEndMonth() {
        return this.endMonth;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public String getStartMonth() {
        return this.startMonth;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setEndMonth(String str) {
        this.endMonth = str;
    }

    public void setOrgCode(String str) {
        this.orgCode = str;
    }

    public void setStartMonth(String str) {
        this.startMonth = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
