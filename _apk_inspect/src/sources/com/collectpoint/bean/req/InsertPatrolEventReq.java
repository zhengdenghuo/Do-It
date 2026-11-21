package com.collectpoint.bean.req;

import com.collectpoint.bean.TimeOutBean;
import com.collectpoint.bean.item.DiseaseListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class InsertPatrolEventReq extends TimeOutBean {
    private String checkTypeCode;
    private List<DiseaseListItem> diseaseList;
    private String highwayPatrolTaskCode;
    private double latitude;
    private double longitude;
    private String objectCode;
    private String positionPileNumber;
    private String projectOrgCode;
    private String projectOrgName;
    private String regionCode;
    private String researchDirection;
    private String specificLocation;
    private String timeReport;
    private String urgentLevel;
    private String villageCode;

    public InsertPatrolEventReq(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, double d, double d2, String str9, String str10, String str11) {
        this.projectOrgCode = str;
        this.projectOrgName = str2;
        this.checkTypeCode = str3;
        this.regionCode = str4;
        this.villageCode = str5;
        this.specificLocation = str6;
        this.objectCode = str7;
        this.urgentLevel = str8;
        this.longitude = d;
        this.latitude = d2;
        this.researchDirection = str9;
        this.highwayPatrolTaskCode = str10;
        this.positionPileNumber = str11;
    }

    public String getCheckTypeCode() {
        return this.checkTypeCode;
    }

    public List<DiseaseListItem> getDiseaseList() {
        return this.diseaseList;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getObjectCode() {
        return this.objectCode;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getProjectOrgName() {
        return this.projectOrgName;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public String getSpecificLocation() {
        return this.specificLocation;
    }

    public String getUrgentLevel() {
        return this.urgentLevel;
    }

    public String getVillageCode() {
        return this.villageCode;
    }

    public void setCheckTypeCode(String str) {
        this.checkTypeCode = str;
    }

    public void setDiseaseList(List<DiseaseListItem> list) {
        this.diseaseList = list;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setObjectCode(String str) {
        this.objectCode = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setProjectOrgName(String str) {
        this.projectOrgName = str;
    }

    public void setRegionCode(String str) {
        this.regionCode = str;
    }

    public void setSpecificLocation(String str) {
        this.specificLocation = str;
    }

    public void setTimeReport(String str) {
        this.timeReport = str;
    }

    public void setUrgentLevel(String str) {
        this.urgentLevel = str;
    }

    public void setVillageCode(String str) {
        this.villageCode = str;
    }
}
