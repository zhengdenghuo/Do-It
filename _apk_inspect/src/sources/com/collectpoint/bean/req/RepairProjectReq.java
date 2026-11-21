package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class RepairProjectReq {
    private String projectCode;
    private String projectOrgCode;
    private String projectStatus;
    private String projectStatusStr;

    public RepairProjectReq() {
    }

    public RepairProjectReq(String str) {
        this.projectCode = str;
    }

    public RepairProjectReq(String str, String str2) {
        this.projectOrgCode = str;
        this.projectStatus = str2;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setProjectStatusStr(String str) {
        this.projectStatusStr = str;
    }
}
