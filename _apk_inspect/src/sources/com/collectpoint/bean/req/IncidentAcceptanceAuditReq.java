package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class IncidentAcceptanceAuditReq {
    private String acceptanceRemark;
    private String acceptanceStatus;
    private String incidentCode;
    private String personnelCode;
    private String personnelName;

    public IncidentAcceptanceAuditReq(String str, String str2, String str3, String str4, String str5) {
        this.incidentCode = str;
        this.personnelCode = str2;
        this.personnelName = str3;
        this.acceptanceStatus = str4;
        this.acceptanceRemark = str5;
    }
}
