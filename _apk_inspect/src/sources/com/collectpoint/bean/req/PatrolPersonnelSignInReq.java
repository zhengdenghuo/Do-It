package com.collectpoint.bean.req;

import com.collectpoint.bean.item.FilePathItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PatrolPersonnelSignInReq {
    private String address;
    private double latitude;
    private double longitude;
    private String personnelCode;
    private List<FilePathItem> photoList;
    private String projectOrgCode;
    private String projectOrgName;
    private String relatedProblemCode;
    private String signInPointCode;
    private String signInTaskCode;
    private String userCode;

    public PatrolPersonnelSignInReq(String str, String str2, String str3, String str4, String str5, String str6, String str7, double d, double d2, String str8) {
        this.userCode = str;
        this.projectOrgCode = str2;
        this.projectOrgName = str3;
        this.signInTaskCode = str4;
        this.personnelCode = str5;
        this.relatedProblemCode = str6;
        this.signInPointCode = str7;
        this.longitude = d;
        this.latitude = d2;
        this.address = str8;
    }

    public List<FilePathItem> getPhotoList() {
        return this.photoList;
    }

    public void setPhotoList(List<FilePathItem> list) {
        this.photoList = list;
    }
}
