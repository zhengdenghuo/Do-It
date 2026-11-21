package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class BridgeReq {
    private String bridgePlanCode;
    private String currentMonth;
    private String endTime;
    private String objectCode;
    private String patrolUserCode;
    private String projectOrgCode;
    private String searchName;
    private String startTime;
    private String typeCode;

    public BridgeReq(String str, String str2, String str3) {
        this.projectOrgCode = str2;
        this.currentMonth = str3;
        this.patrolUserCode = str;
    }

    public BridgeReq(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.patrolUserCode = str;
        this.projectOrgCode = str2;
        this.searchName = str7;
        this.typeCode = str4;
        this.objectCode = str8;
        this.bridgePlanCode = str3;
        this.objectCode = str8;
        this.startTime = str5;
        this.endTime = str6;
    }
}
