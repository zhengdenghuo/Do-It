package com.collectpoint.bean.res;

import com.collectpoint.bean.req.RepairProjectCheckRectificationReq;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class RepairProjectCheckInfoRes {
    private String auditRemark;
    private List<String> carPhotoList;
    private String checkStatus;
    private String checkStatusStr;
    private String checkTimeStr;
    private List<String> constructionPhotoList;
    private String constructionUnitName;
    private String eventDescription;
    private double latitude;
    private double longitude;
    private List<String> materielPhotoList;
    private String personnelName;
    private List<String> personnelPhotoList;
    private String positionAddress;
    private String projectCode;
    private String projectName;
    private List<RepairProjectCheckRectificationReq> repairProjectCheckRectificationList;

    public String getAuditRemark() {
        return this.auditRemark;
    }

    public List<String> getCarPhotoList() {
        return this.carPhotoList;
    }

    public String getCheckStatus() {
        return this.checkStatus;
    }

    public String getCheckStatusStr() {
        return this.checkStatusStr;
    }

    public String getCheckTime() {
        return this.checkTimeStr;
    }

    public List<String> getConstructionPhotoList() {
        return this.constructionPhotoList;
    }

    public String getConstructionUnitName() {
        return this.constructionUnitName;
    }

    public String getEventDescription() {
        return this.eventDescription;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public List<String> getMaterielPhotoList() {
        return this.materielPhotoList;
    }

    public String getPersonnelName() {
        return this.personnelName;
    }

    public List<String> getPersonnelPhotoList() {
        return this.personnelPhotoList;
    }

    public String getProjectCode() {
        return this.projectCode;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public List<RepairProjectCheckRectificationReq> getRepairProjectCheckRectificationList() {
        return this.repairProjectCheckRectificationList;
    }

    public String getSpecificLocation() {
        return this.positionAddress;
    }

    public void setCheckStatus(String str) {
        this.checkStatus = str;
    }

    public void setCheckStatusStr(String str) {
        this.checkStatusStr = str;
    }

    public void setConstructionUnitName(String str) {
        this.constructionUnitName = str;
    }

    public void setEventDescription(String str) {
        this.eventDescription = str;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setProjectCode(String str) {
        this.projectCode = str;
    }

    public void setProjectName(String str) {
        this.projectName = str;
    }

    public void setRepairProjectCheckRectificationList(List<RepairProjectCheckRectificationReq> list) {
        this.repairProjectCheckRectificationList = list;
    }

    public void setSpecificLocation(String str) {
        this.positionAddress = str;
    }
}
