package com.collectpoint.bean.item;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class AttendanceTypePeriodListItem {
    private String attendanceCode;
    private String attendanceStatus;
    private String endPeriod;
    private int id;
    private boolean isChecked = false;
    private String periodCode;
    private String periodStatus;
    private String starPeriod;
    private String status;

    public String getAttendanceCode() {
        return this.attendanceCode;
    }

    public String getAttendanceStatus() {
        return this.attendanceStatus;
    }

    public String getEndPeriod() {
        return this.endPeriod;
    }

    public int getId() {
        return this.id;
    }

    public String getPeriodCode() {
        return this.periodCode;
    }

    public String getPeriodStatus() {
        return this.periodStatus;
    }

    public String getStarPeriod() {
        return this.starPeriod;
    }

    public String getStatus() {
        return this.status;
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

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public void setEndPeriod(String str) {
        this.endPeriod = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setPeriodCode(String str) {
        this.periodCode = str;
    }

    public void setPeriodStatus(String str) {
        this.periodStatus = str;
    }

    public void setStarPeriod(String str) {
        this.starPeriod = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
