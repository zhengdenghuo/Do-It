package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class SortContentTreeByMapReq {
    private String contentName;
    private String typeCode;
    private String userCode;

    public SortContentTreeByMapReq(String str, String str2, String str3) {
        this.userCode = str;
        this.typeCode = str2;
        this.contentName = str3;
    }

    public String getContentName() {
        return this.contentName;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setContentName(String str) {
        this.contentName = str;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
