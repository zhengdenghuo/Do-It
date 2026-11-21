package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class HighwayPatrolTaskDataApiReq {
    private String patrolDate;
    private String patrolEndDate;
    private String patrolStartDate;
    private String patrolStatus = "YXC";
    private String patrolUserCode;
    private String projectOrgCode;
    private String searchName;

    public HighwayPatrolTaskDataApiReq(String str, String str2, String str3, String str4, String str5, String str6) {
        this.patrolUserCode = str;
        this.projectOrgCode = str2;
        this.patrolDate = str3;
        this.patrolStartDate = str4;
        this.patrolEndDate = str5;
        this.searchName = str6;
    }
}
