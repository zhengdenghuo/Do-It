package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class SelectAttendancePersonnelFenceListReq {
    private String dateTime;
    private double latitude;
    private double longitude;
    private String userCode;

    public SelectAttendancePersonnelFenceListReq(String str, String str2, double d, double d2) {
        this.userCode = str;
        this.dateTime = str2;
        this.longitude = d;
        this.latitude = d2;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setDateTime(String str) {
        this.dateTime = str;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
