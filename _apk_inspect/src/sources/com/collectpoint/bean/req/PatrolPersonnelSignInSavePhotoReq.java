package com.collectpoint.bean.req;

import com.collectpoint.bean.item.FilePathItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PatrolPersonnelSignInSavePhotoReq {
    private List<FilePathItem> photoList;
    private String signInRecordCode;
    private String userCode;

    public PatrolPersonnelSignInSavePhotoReq(String str, String str2) {
        this.userCode = str;
        this.signInRecordCode = str2;
    }

    public List<FilePathItem> getPhotoList() {
        return this.photoList;
    }

    public void setPhotoList(List<FilePathItem> list) {
        this.photoList = list;
    }
}
