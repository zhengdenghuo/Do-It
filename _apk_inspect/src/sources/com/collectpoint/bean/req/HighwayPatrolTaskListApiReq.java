package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class HighwayPatrolTaskListApiReq {
    private String ifCanInspect;
    private String patrolDate;
    private String patrolEndDate;
    private String patrolStartDate;
    private String patrolStatus;
    private String patrolUserCode;
    private String planEndDate;
    private String planStartDate;
    private String projectOrgCode;
    private String searchName;

    public HighwayPatrolTaskListApiReq(String str, String str2, String str3) {
        this.patrolUserCode = str;
        this.projectOrgCode = str2;
        this.patrolStatus = "YXC";
        this.patrolDate = str3;
    }

    public HighwayPatrolTaskListApiReq(String str, String str2, String str3, String str4) {
        this.patrolUserCode = str;
        this.projectOrgCode = str2;
        this.patrolStatus = str4;
        this.ifCanInspect = str3;
    }

    public HighwayPatrolTaskListApiReq(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.patrolUserCode = str;
        this.projectOrgCode = str2;
        this.patrolStatus = str3;
        this.planStartDate = str4;
        this.planEndDate = str5;
        this.patrolStartDate = str6;
        this.patrolEndDate = str7;
        this.searchName = str8;
    }
}
