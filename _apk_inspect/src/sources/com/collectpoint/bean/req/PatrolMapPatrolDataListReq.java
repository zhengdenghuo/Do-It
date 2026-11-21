package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PatrolMapPatrolDataListReq {
    private String projectOrgCode;
    private String townCode;
    private String typeCodeArray;
    private String userCode;

    public PatrolMapPatrolDataListReq(String str, String str2, String str3, String str4) {
        this.userCode = str;
        this.projectOrgCode = str2;
        this.typeCodeArray = str3;
        this.townCode = str4;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getTownCode() {
        return this.townCode;
    }

    public String getTypeCodeArray() {
        return this.typeCodeArray;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setTownCode(String str) {
        this.townCode = str;
    }

    public void setTypeCodeArray(String str) {
        this.typeCodeArray = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
