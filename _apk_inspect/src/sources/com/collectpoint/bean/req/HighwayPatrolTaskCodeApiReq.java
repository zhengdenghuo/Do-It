package com.collectpoint.bean.req;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class HighwayPatrolTaskCodeApiReq {
    private List<String> highwayPatrolTaskCodeList;
    private double latitude;
    private double longitude;
    private String relevanceCode;
    private String userCode;

    public HighwayPatrolTaskCodeApiReq(String str, String str2, double d, double d2) {
        this.userCode = str;
        this.relevanceCode = str2;
        this.latitude = d;
        this.longitude = d2;
    }

    public HighwayPatrolTaskCodeApiReq(String str, List<String> list, double d, double d2) {
        this.userCode = str;
        this.highwayPatrolTaskCodeList = list;
        this.latitude = d;
        this.longitude = d2;
    }
}
