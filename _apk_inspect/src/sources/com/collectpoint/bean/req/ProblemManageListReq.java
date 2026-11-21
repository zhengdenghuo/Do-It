package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class ProblemManageListReq {
    private String decomposeTypes;
    private String manageProblemType;
    private String orgCode;
    private int page;
    private String projectOrgCode;
    private String regionCode;
    private int rows;
    private String typeCode;
    private String userCode;

    public ProblemManageListReq(String str) {
        this.projectOrgCode = str;
    }

    public ProblemManageListReq(String str, String str2, String str3, int i, String str4) {
        this.userCode = str;
        this.orgCode = str2;
        this.regionCode = str3;
        this.manageProblemType = str4;
        this.page = i;
        this.rows = 10;
    }

    public ProblemManageListReq(String str, String str2, String str3, String str4, int i, int i2) {
        this.userCode = str;
        this.orgCode = str2;
        this.typeCode = str3;
        this.regionCode = str4;
        this.page = i;
        this.rows = i2;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public int getPage() {
        return this.page;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public int getRows() {
        return this.rows;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setDecomposeTypes(String str) {
        this.decomposeTypes = str;
    }

    public void setOrgCode(String str) {
        this.orgCode = str;
    }

    public void setPage(int i) {
        this.page = i;
    }

    public void setRegionCode(String str) {
        this.regionCode = str;
    }

    public void setRows(int i) {
        this.rows = i;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
