package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PatrolPersonneReq {
    private String fuzzySearch;
    private Double latitude;
    private Double longitude;
    private String projectOrgCode;

    public PatrolPersonneReq(String str, Double d, Double d2, String str2) {
        this.projectOrgCode = str;
        this.longitude = d;
        this.latitude = d2;
        this.fuzzySearch = str2;
    }
}
