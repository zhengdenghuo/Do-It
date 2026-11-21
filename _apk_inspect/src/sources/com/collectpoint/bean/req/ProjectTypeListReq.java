package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class ProjectTypeListReq {
    private String checkWayList;
    private String projectOrgCode;
    private String userCode;

    public ProjectTypeListReq(String str, String str2) {
        this.userCode = str;
        this.projectOrgCode = str2;
    }

    public ProjectTypeListReq(String str, String str2, String str3) {
        this.userCode = str;
        this.projectOrgCode = str2;
        this.checkWayList = str3;
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
