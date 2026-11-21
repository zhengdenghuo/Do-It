package com.collectpoint.bean.req;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class RepairProjectCheckReq {
    private List<String> carPhotoList;
    private List<String> constructionPhotoList;
    private String eventDescription;
    private String ifEvent;
    private double latitude;
    private double longitude;
    private List<String> materielPhotoList;
    private String personnelCode;
    private String personnelName;
    private List<String> personnelPhotoList;
    private String positionAddress;
    private String projectCode;

    public RepairProjectCheckReq(String str, String str2, String str3, String str4, String str5, String str6, double d, double d2) {
        this.projectCode = str;
        this.personnelCode = str2;
        this.personnelName = str3;
        this.ifEvent = str4;
        this.eventDescription = str5;
        this.positionAddress = str6;
        this.latitude = d;
        this.longitude = d2;
    }

    public void setCarPhotoList(List<String> list) {
        this.carPhotoList = list;
    }

    public void setConstructionPhotoList(List<String> list) {
        this.constructionPhotoList = list;
    }

    public void setMaterielPhotoList(List<String> list) {
        this.materielPhotoList = list;
    }

    public void setPersonnelPhotoList(List<String> list) {
        this.personnelPhotoList = list;
    }
}
