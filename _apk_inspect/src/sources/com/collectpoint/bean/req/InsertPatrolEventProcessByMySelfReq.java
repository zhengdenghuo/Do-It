package com.collectpoint.bean.req;

import com.collectpoint.BuildConfig;
import com.collectpoint.bean.TimeOutBean;
import com.collectpoint.bean.item.DiseaseListItem;
import com.collectpoint.bean.item.FilePathItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class InsertPatrolEventProcessByMySelfReq extends TimeOutBean {
    private String bridgeInspectTaskCode;
    private String checkTypeCode;
    private DiseaseListItem disease;
    private List<DiseaseListItem> diseaseList;
    private String highwayPatrolTaskCode;
    private double latitude;
    private double longitude;
    private String objectCode;
    private List<FilePathItem> photoList;
    private String positionPileNumber;
    private String processDesc;
    private List<FilePathItem> processPhotoList;
    private List<FilePathItem> processVideoList;
    private String projectOrgCode;
    private String projectOrgName;
    private String regionCode;
    private String researchDirection;
    private String specificLocation;
    private String timeReport;
    private String urgentLevel;
    private String userCode;
    private String userName;
    private String versions = BuildConfig.VERSION_NAME;
    private String villageCode;

    public InsertPatrolEventProcessByMySelfReq(String str, double d, double d2) {
        this.objectCode = str;
        this.longitude = d;
        this.latitude = d2;
    }

    public InsertPatrolEventProcessByMySelfReq(String str, String str2, String str3, String str4, String str5, String str6, String str7, double d, double d2, String str8, List<DiseaseListItem> list, String str9) {
        this.userCode = str;
        this.userName = str2;
        this.projectOrgCode = str3;
        this.projectOrgName = str4;
        this.checkTypeCode = str5;
        this.specificLocation = str6;
        this.objectCode = str7;
        this.longitude = d;
        this.latitude = d2;
        this.bridgeInspectTaskCode = str8;
        this.positionPileNumber = str9;
        this.diseaseList = list;
    }

    public InsertPatrolEventProcessByMySelfReq(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, double d, double d2, String str9, String str10, String str11, String str12) {
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
        this.processDesc = str9;
        this.researchDirection = str10;
        this.highwayPatrolTaskCode = str11;
        this.positionPileNumber = str12;
    }

    public DiseaseListItem getDisease() {
        return this.disease;
    }

    public List<FilePathItem> getProcessPhotoList() {
        return this.processPhotoList;
    }

    public List<FilePathItem> getProcessVideoList() {
        return this.processVideoList;
    }

    public void setDisease(DiseaseListItem diseaseListItem) {
        this.disease = diseaseListItem;
    }

    public void setPhotoList(List<FilePathItem> list) {
        this.photoList = list;
    }

    public void setProcessPhotoList(List<FilePathItem> list) {
        this.processPhotoList = list;
    }

    public void setProcessVideoList(List<FilePathItem> list) {
        this.processVideoList = list;
    }

    public void setTimeReport(String str) {
        this.timeReport = str;
    }
}
