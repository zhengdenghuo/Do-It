package com.collectpoint.bean.req;

import com.collectpoint.bean.item.FilePathItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class AuxiliaryListReq {
    private String collectCustomCode;
    private String collectCustomMust;
    private String collectCustomName;
    private String collectCustomType;
    private String collectCustomValue;
    private List<FilePathItem> photoList;
    private List<String> picList;

    public AuxiliaryListReq(String str, String str2, String str3, String str4, String str5) {
        this.collectCustomCode = str;
        this.collectCustomName = str2;
        this.collectCustomMust = str3;
        this.collectCustomValue = str4;
        this.collectCustomType = str5;
    }

    public String getCollectCustomCode() {
        return this.collectCustomCode;
    }

    public String getCollectCustomMust() {
        return this.collectCustomMust;
    }

    public String getCollectCustomName() {
        return this.collectCustomName;
    }

    public String getCollectCustomType() {
        return this.collectCustomType;
    }

    public String getCollectCustomValue() {
        return this.collectCustomValue;
    }

    public List<FilePathItem> getPhotoList() {
        return this.photoList;
    }

    public List<String> getPicList() {
        return this.picList;
    }

    public void setCollectCustomCode(String str) {
        this.collectCustomCode = str;
    }

    public void setCollectCustomMust(String str) {
        this.collectCustomMust = str;
    }

    public void setCollectCustomName(String str) {
        this.collectCustomName = str;
    }

    public void setCollectCustomType(String str) {
        this.collectCustomType = str;
    }

    public void setCollectCustomValue(String str) {
        this.collectCustomValue = str;
    }

    public void setPhotoList(List<FilePathItem> list) {
        this.photoList = list;
    }

    public void setPicList(List<String> list) {
        this.picList = list;
    }
}
