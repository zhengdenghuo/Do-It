package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class HighwayPatrolTaskTreeApiReq {
    private String ifCanInspect;
    private String patrolStatus;
    private String patrolUserCode;
    private String projectOrgCode;

    public HighwayPatrolTaskTreeApiReq(String str) {
        this.patrolUserCode = str;
    }

    public HighwayPatrolTaskTreeApiReq(String str, String str2, String str3, String str4) {
        this.patrolUserCode = str;
        this.projectOrgCode = str2;
        this.ifCanInspect = str3;
        this.patrolStatus = str4;
    }
}
