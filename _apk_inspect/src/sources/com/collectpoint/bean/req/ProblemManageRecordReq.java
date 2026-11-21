package com.collectpoint.bean.req;

import com.collectpoint.bean.item.FilePathItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class ProblemManageRecordReq {
    private String manageCode;
    private String manageDetail;
    private String manageOpion;
    private List<FilePathItem> photoList;
    private String problemCode;
    private String userCode;
    private List<FilePathItem> videoList;

    public ProblemManageRecordReq(String str, String str2, String str3, String str4) {
        this.userCode = str;
        this.problemCode = str2;
        this.manageCode = str3;
        this.manageDetail = str4;
    }

    public String getManageCode() {
        return this.manageCode;
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

    public String getProblemCode() {
        return this.problemCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public List<FilePathItem> getVideoList() {
        return this.videoList;
    }

    public void setManageCode(String str) {
        this.manageCode = str;
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

    public void setProblemCode(String str) {
        this.problemCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public void setVideoList(List<FilePathItem> list) {
        this.videoList = list;
    }
}
