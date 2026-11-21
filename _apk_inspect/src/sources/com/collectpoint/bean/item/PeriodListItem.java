package com.collectpoint.bean.item;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class PeriodListItem {
    private String attendanceCode;
    private String attendanceStatus;
    private String attendanceStatusStr;
    private String attendanceTime;
    private boolean isChecked = false;
    private String periodCode;
    private String periodStatus;
    private String signInTime;
    private String signInType;

    public String getAttendanceCode() {
        return this.attendanceCode;
    }

    public String getAttendanceStatus() {
        return this.attendanceStatus;
    }

    public String getAttendanceStatusStr() {
        return this.attendanceStatusStr;
    }

    public String getAttendanceTime() {
        return this.attendanceTime;
    }

    public String getPeriodCode() {
        return this.periodCode;
    }

    public String getPeriodStatus() {
        return this.periodStatus;
    }

    public String getSignInTime() {
        return this.signInTime;
    }

    public String getSignInType() {
        return this.signInType;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setAttendanceCode(String str) {
        this.attendanceCode = str;
    }

    public void setAttendanceStatus(String str) {
        this.attendanceStatus = str;
    }

    public void setAttendanceStatusStr(String str) {
        this.attendanceStatusStr = str;
    }

    public void setAttendanceTime(String str) {
        this.attendanceTime = str;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public void setPeriodCode(String str) {
        this.periodCode = str;
    }

    public void setPeriodStatus(String str) {
        this.periodStatus = str;
    }

    public void setSignInTime(String str) {
        this.signInTime = str;
    }

    public void setSignInType(String str) {
        this.signInType = str;
    }
}
