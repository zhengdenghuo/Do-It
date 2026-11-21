package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class RepairAcceptanceReq {
    private String acceptanceCode;
    private String acceptanceStatus;
    private String projectOrgCode;

    public RepairAcceptanceReq(String str) {
        this.acceptanceCode = str;
    }

    public RepairAcceptanceReq(String str, String str2) {
        this.projectOrgCode = str;
        this.acceptanceStatus = str2;
    }
}
