package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PartsDiseaseListReq {
    private String parentCode;
    private String projectOrgCode;
    private String topCode;
    private String typeCode;

    public PartsDiseaseListReq(String str, String str2) {
        this.typeCode = str;
        this.parentCode = str2;
    }

    public PartsDiseaseListReq(String str, String str2, String str3) {
        this.projectOrgCode = str;
        this.typeCode = str2;
        this.topCode = str3;
    }
}
