package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PatrolManageReportListReq {
    private String endMonth;
    private String orgCode;
    private String reportType;
    private String startMonth;
    private String userCode;

    public PatrolManageReportListReq(String str, String str2, String str3, String str4, String str5) {
        this.userCode = str;
        this.orgCode = str2;
        this.reportType = str3;
        this.startMonth = str4;
        this.endMonth = str5;
    }

    public String getEndMonth() {
        return this.endMonth;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public String getReportType() {
        return this.reportType;
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

    public void setReportType(String str) {
        this.reportType = str;
    }

    public void setStartMonth(String str) {
        this.startMonth = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
