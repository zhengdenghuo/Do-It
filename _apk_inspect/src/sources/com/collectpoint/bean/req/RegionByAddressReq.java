package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class RegionByAddressReq {
    private double latitude;
    private double longitude;
    private String orgCode;

    public RegionByAddressReq(String str, double d, double d2) {
        this.orgCode = str;
        this.longitude = d;
        this.latitude = d2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setOrgCode(String str) {
        this.orgCode = str;
    }
}
