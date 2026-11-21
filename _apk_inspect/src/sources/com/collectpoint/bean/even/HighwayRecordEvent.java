package com.collectpoint.bean.even;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class HighwayRecordEvent {
    private String areaCode;
    private String searchName;

    public HighwayRecordEvent(String str, String str2) {
        this.areaCode = "";
        this.searchName = "";
        this.areaCode = str;
        this.searchName = str2;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public String getSearchName() {
        return this.searchName;
    }

    public void setAreaCode(String str) {
        this.areaCode = str;
    }

    public void setSearchName(String str) {
        this.searchName = str;
    }
}
