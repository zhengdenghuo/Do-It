package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class RegionListByMapReq {
    private String parentCode;
    private String regionType;
    private String userCode;

    public RegionListByMapReq(String str, String str2, String str3) {
        this.userCode = str;
        this.regionType = str2;
        this.parentCode = str3;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public String getRegionType() {
        return this.regionType;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setParentCode(String str) {
        this.parentCode = str;
    }

    public void setRegionType(String str) {
        this.regionType = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
