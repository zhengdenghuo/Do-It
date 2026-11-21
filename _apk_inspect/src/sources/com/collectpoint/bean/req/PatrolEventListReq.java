package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PatrolEventListReq {
    private String endDate;
    private String eventStatus;
    private String projectOrgCode;
    private String startDate;
    private String townCode;

    public PatrolEventListReq(String str, String str2, String str3, String str4, String str5) {
        this.projectOrgCode = str;
        this.eventStatus = str2;
        this.townCode = str3;
        this.startDate = str4;
        this.endDate = str5;
    }
}
