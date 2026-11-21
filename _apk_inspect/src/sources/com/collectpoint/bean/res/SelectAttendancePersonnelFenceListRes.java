package com.collectpoint.bean.res;

import com.collectpoint.bean.item.AttendanceFencePathListItem;
import com.collectpoint.bean.item.AttendanceTypePeriodListItem;
import com.collectpoint.bean.item.PeriodListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class SelectAttendancePersonnelFenceListRes {
    private String attendanceCode;
    private List<AttendanceFencePathListItem> attendanceFencePathList;
    private String attendanceName;
    private List<AttendanceTypePeriodListItem> attendanceTypePeriodList;
    private String deviationRange;
    private String fenceCode;
    private String fenceName;
    private String fenceType;
    private int id;
    private String ifInAttendanceFence;
    private String periodCode;
    private List<PeriodListItem> periodList;
    private String personnelCode;
    private String signInType;
    private String status;

    public String getAttendanceCode() {
        return this.attendanceCode;
    }

    public List<AttendanceFencePathListItem> getAttendanceFencePathList() {
        return this.attendanceFencePathList;
    }

    public String getAttendanceName() {
        return this.attendanceName;
    }

    public List<AttendanceTypePeriodListItem> getAttendanceTypePeriodList() {
        return this.attendanceTypePeriodList;
    }

    public String getDeviationRange() {
        return this.deviationRange;
    }

    public String getFenceCode() {
        return this.fenceCode;
    }

    public String getFenceName() {
        return this.fenceName;
    }

    public String getFenceType() {
        return this.fenceType;
    }

    public int getId() {
        return this.id;
    }

    public String getIfInAttendanceFence() {
        return this.ifInAttendanceFence;
    }

    public String getPeriodCode() {
        return this.periodCode;
    }

    public List<PeriodListItem> getPeriodList() {
        return this.periodList;
    }

    public String getPersonnelCode() {
        return this.personnelCode;
    }

    public String getSignInType() {
        return this.signInType;
    }

    public String getStatus() {
        return this.status;
    }

    public void setAttendanceCode(String str) {
        this.attendanceCode = str;
    }

    public void setAttendanceFencePathList(List<AttendanceFencePathListItem> list) {
        this.attendanceFencePathList = list;
    }

    public void setAttendanceName(String str) {
        this.attendanceName = str;
    }

    public void setAttendanceTypePeriodList(List<AttendanceTypePeriodListItem> list) {
        this.attendanceTypePeriodList = list;
    }

    public void setDeviationRange(String str) {
        this.deviationRange = str;
    }

    public void setFenceCode(String str) {
        this.fenceCode = str;
    }

    public void setFenceName(String str) {
        this.fenceName = str;
    }

    public void setFenceType(String str) {
        this.fenceType = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIfInAttendanceFence(String str) {
        this.ifInAttendanceFence = str;
    }

    public void setPeriodCode(String str) {
        this.periodCode = str;
    }

    public void setPeriodList(List<PeriodListItem> list) {
        this.periodList = list;
    }

    public void setPersonnelCode(String str) {
        this.personnelCode = str;
    }

    public void setSignInType(String str) {
        this.signInType = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
