package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class SortContentByMapReq {
    private String sortCode;
    private String userCode;

    public SortContentByMapReq(String str, String str2) {
        this.userCode = str;
        this.sortCode = str2;
    }

    public String getSortCode() {
        return this.sortCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setSortCode(String str) {
        this.sortCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
