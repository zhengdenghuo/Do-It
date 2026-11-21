package com.collectpoint.bean.req;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class GetObjectListReq {
    private String objectCode;
    private String objectTypeCode;
    private String patrolUserCode;
    private String projectOrgCode;
    private List<String> roadLineCodeList;
    private String searchName;

    public GetObjectListReq() {
    }

    public GetObjectListReq(String str, String str2, String str3) {
        this.objectTypeCode = str2;
        this.objectCode = str3;
        this.projectOrgCode = str;
    }

    public GetObjectListReq(String str, String str2, String str3, String str4) {
        this.patrolUserCode = str;
        this.projectOrgCode = str2;
        this.objectTypeCode = str3;
        this.searchName = str4;
    }

    public GetObjectListReq(String str, List<String> list) {
        this.objectTypeCode = str;
        this.roadLineCodeList = list;
    }

    public void setObjectTypeCode(String str) {
        this.objectTypeCode = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }
}
