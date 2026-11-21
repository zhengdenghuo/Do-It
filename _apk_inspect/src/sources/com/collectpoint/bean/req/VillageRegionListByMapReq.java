package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class VillageRegionListByMapReq {
    private String objectCode;
    private String parentCode;
    private String userCode;

    public VillageRegionListByMapReq(String str, String str2, String str3) {
        this.userCode = str;
        this.parentCode = str2;
        this.objectCode = str3;
    }

    public String getObjectCode() {
        return this.objectCode;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setObjectCode(String str) {
        this.objectCode = str;
    }

    public void setParentCode(String str) {
        this.parentCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
