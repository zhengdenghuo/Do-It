package com.collectpoint.bean.req;

import com.collectpoint.bean.item.FilePathItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class InsertPatrolProblemReq {
    private String contentCode;
    private double latitude;
    private double longitude;
    private String manageUnitCode;
    private String measuresAndProposal;
    private String objectCode;
    private List<FilePathItem> photoList;
    private String problemDesc;
    private String regionCode;
    private String sortCode;
    private String specificLocation;
    private String typeCode;
    private String urgentLevel;
    private String userCode;
    private List<FilePathItem> videoList;
    private String villageCode;

    public InsertPatrolProblemReq(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, double d, double d2) {
        this.userCode = str;
        this.regionCode = str2;
        this.villageCode = str3;
        this.typeCode = str4;
        this.sortCode = str5;
        this.contentCode = str6;
        this.objectCode = str7;
        this.urgentLevel = str8;
        this.problemDesc = str9;
        this.manageUnitCode = str10;
        this.specificLocation = str11;
        this.measuresAndProposal = str12;
        this.longitude = d;
        this.latitude = d2;
    }

    public String getContentCode() {
        return this.contentCode;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getManageUnitCode() {
        return this.manageUnitCode;
    }

    public String getMeasuresAndProposal() {
        return this.measuresAndProposal;
    }

    public String getObjectCode() {
        return this.objectCode;
    }

    public List<FilePathItem> getPhotoList() {
        return this.photoList;
    }

    public String getProblemDesc() {
        return this.problemDesc;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public String getSortCode() {
        return this.sortCode;
    }

    public String getSpecificLocation() {
        return this.specificLocation;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public String getUrgentLevel() {
        return this.urgentLevel;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public List<FilePathItem> getVideoList() {
        return this.videoList;
    }

    public String getVillageCode() {
        return this.villageCode;
    }

    public void setContentCode(String str) {
        this.contentCode = str;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setManageUnitCode(String str) {
        this.manageUnitCode = str;
    }

    public void setMeasuresAndProposal(String str) {
        this.measuresAndProposal = str;
    }

    public void setObjectCode(String str) {
        this.objectCode = str;
    }

    public void setPhotoList(List<FilePathItem> list) {
        this.photoList = list;
    }

    public void setProblemDesc(String str) {
        this.problemDesc = str;
    }

    public void setRegionCode(String str) {
        this.regionCode = str;
    }

    public void setSortCode(String str) {
        this.sortCode = str;
    }

    public void setSpecificLocation(String str) {
        this.specificLocation = str;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }

    public void setUrgentLevel(String str) {
        this.urgentLevel = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public void setVideoList(List<FilePathItem> list) {
        this.videoList = list;
    }

    public void setVillageCode(String str) {
        this.villageCode = str;
    }
}
