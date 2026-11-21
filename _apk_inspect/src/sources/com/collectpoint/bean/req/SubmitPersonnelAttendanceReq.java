package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class SubmitPersonnelAttendanceReq {
    private String attendanceCode;
    private String attendanceStatus;
    private String collectionPointName;
    private String fenceCode;
    private String ifInFence;
    private double latitude;
    private double longitude;
    private String periodCode;
    private String personnelCode;
    private String recordCode;
    private String signInAddress;
    private String signInTime;
    private String signInType;

    public SubmitPersonnelAttendanceReq(String str) {
        this.recordCode = str;
    }

    public SubmitPersonnelAttendanceReq(String str, String str2) {
        this.recordCode = str;
        this.collectionPointName = str2;
    }

    public SubmitPersonnelAttendanceReq(String str, String str2, String str3, String str4, double d, double d2, String str5, String str6, String str7, String str8) {
        this.personnelCode = str;
        this.attendanceCode = str2;
        this.ifInFence = str3;
        this.fenceCode = str4;
        this.longitude = d;
        this.latitude = d2;
        this.periodCode = str5;
        this.signInAddress = str6;
        this.signInType = str7;
        this.attendanceStatus = str8;
    }

    public String getAttendanceCode() {
        return this.attendanceCode;
    }

    public String getAttendanceStatus() {
        return this.attendanceStatus;
    }

    public String getFenceCode() {
        return this.fenceCode;
    }

    public String getIfInFence() {
        return this.ifInFence;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getPeriodCode() {
        return this.periodCode;
    }

    public String getPersonnelCode() {
        return this.personnelCode;
    }

    public String getRecordCode() {
        return this.recordCode;
    }

    public String getSignInAddress() {
        return this.signInAddress;
    }

    public String getSignInTime() {
        return this.signInTime;
    }

    public String getSignInType() {
        return this.signInType;
    }

    public void setAttendanceCode(String str) {
        this.attendanceCode = str;
    }

    public void setAttendanceStatus(String str) {
        this.attendanceStatus = str;
    }

    public void setFenceCode(String str) {
        this.fenceCode = str;
    }

    public void setIfInFence(String str) {
        this.ifInFence = str;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setPeriodCode(String str) {
        this.periodCode = str;
    }

    public void setPersonnelCode(String str) {
        this.personnelCode = str;
    }

    public void setRecordCode(String str) {
        this.recordCode = str;
    }

    public void setSignInAddress(String str) {
        this.signInAddress = str;
    }

    public void setSignInTime(String str) {
        this.signInTime = str;
    }

    public void setSignInType(String str) {
        this.signInType = str;
    }
}
