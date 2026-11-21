package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class RepairCheckReq {
    private String acceptanceStatus;
    private String checkCode;
    private String checkRemark;
    private String checkStatus;
    private String personnelCode;
    private String personnelName;
    private String projectOrgCode;

    public RepairCheckReq(String str) {
        this.checkCode = str;
    }

    public RepairCheckReq(String str, String str2) {
        this.projectOrgCode = str;
        this.checkStatus = str2;
    }

    public RepairCheckReq(String str, String str2, String str3, String str4, String str5) {
        this.acceptanceStatus = str;
        this.checkCode = str2;
        this.personnelCode = str3;
        this.personnelName = str4;
        this.checkRemark = str5;
    }
}
