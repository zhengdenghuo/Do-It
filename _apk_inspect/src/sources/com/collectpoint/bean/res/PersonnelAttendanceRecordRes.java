package com.collectpoint.bean.res;

import com.collectpoint.bean.item.AttendanceStatusListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class PersonnelAttendanceRecordRes {
    private double attendanceDurationTotal;
    private List<AttendanceStatusListItem> attendanceStatusList;
    private int attendanceStatus_CD;
    private int attendanceStatus_ZT;

    public double getAttendanceDurationTotal() {
        return this.attendanceDurationTotal;
    }

    public List<AttendanceStatusListItem> getAttendanceStatusList() {
        return this.attendanceStatusList;
    }

    public int getAttendanceStatus_CD() {
        return this.attendanceStatus_CD;
    }

    public int getAttendanceStatus_ZT() {
        return this.attendanceStatus_ZT;
    }

    public void setAttendanceDurationTotal(double d) {
        this.attendanceDurationTotal = d;
    }

    public void setAttendanceStatusList(List<AttendanceStatusListItem> list) {
        this.attendanceStatusList = list;
    }

    public void setAttendanceStatus_CD(int i) {
        this.attendanceStatus_CD = i;
    }

    public void setAttendanceStatus_ZT(int i) {
        this.attendanceStatus_ZT = i;
    }
}
