package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class ExamineReportListReq {
    private String examineDate;
    private String examineTypeCode;
    private int limit;
    private String objectTypeCode;
    private int page;
    private String projectOrgCode;

    public ExamineReportListReq(String str, String str2, String str3, String str4, int i, int i2) {
        this.projectOrgCode = str;
        this.objectTypeCode = str2;
        this.examineTypeCode = str3;
        this.examineDate = str4;
        this.page = i;
        this.limit = i2;
    }
}
