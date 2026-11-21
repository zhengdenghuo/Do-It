package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class RepairIncidentReq {
    private String eventCode;
    private String projectOrgCode;
    private String repairStatus;

    public RepairIncidentReq(String str) {
        this.eventCode = str;
    }

    public RepairIncidentReq(String str, String str2) {
        this.projectOrgCode = str;
        this.repairStatus = str2;
    }

    public void setRepairStatus(String str) {
        this.repairStatus = str;
    }
}
