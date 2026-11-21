package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PatrolObjectTreeByMapReq {
    private String objectName;
    private String regionCode;
    private String typeCode;
    private String userCode;
    private String villageCode;

    public PatrolObjectTreeByMapReq(String str, String str2, String str3, String str4, String str5) {
        this.userCode = str;
        this.typeCode = str2;
        this.regionCode = str3;
        this.villageCode = str4;
        this.objectName = str5;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public String getVillageCode() {
        return this.villageCode;
    }

    public void setObjectName(String str) {
        this.objectName = str;
    }

    public void setRegionCode(String str) {
        this.regionCode = str;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public void setVillageCode(String str) {
        this.villageCode = str;
    }
}
