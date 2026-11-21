package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PatrolMapPatrolTypeListReq {
    private String projectOrgCode;
    private String userCode;

    public PatrolMapPatrolTypeListReq(String str, String str2) {
        this.userCode = str;
        this.projectOrgCode = str2;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
