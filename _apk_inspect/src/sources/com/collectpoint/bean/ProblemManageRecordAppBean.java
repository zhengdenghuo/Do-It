package com.collectpoint.bean;

import com.collectpoint.bean.item.FilePathItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class ProblemManageRecordAppBean {
    private String manageDetail;
    private String manageOpion;
    private List<FilePathItem> photoList;
    private String userCode;
    private List<FilePathItem> videoList;

    public ProblemManageRecordAppBean(String str, String str2) {
        this.userCode = str;
        this.manageDetail = str2;
    }

    public String getManageDetail() {
        return this.manageDetail;
    }

    public String getManageOpion() {
        return this.manageOpion;
    }

    public List<FilePathItem> getPhotoList() {
        return this.photoList;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public List<FilePathItem> getVideoList() {
        return this.videoList;
    }

    public void setManageDetail(String str) {
        this.manageDetail = str;
    }

    public void setManageOpion(String str) {
        this.manageOpion = str;
    }

    public void setPhotoList(List<FilePathItem> list) {
        this.photoList = list;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public void setVideoList(List<FilePathItem> list) {
        this.videoList = list;
    }
}
