package com.collectpoint.bean.req;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class ManagePatrolEventReq {
    private String eventCode;
    private String manageDetail;
    private List<String> managePhotoList;
    private String manageUserCode;
    private String manageUserName;

    public ManagePatrolEventReq(String str) {
        this.eventCode = str;
    }

    public ManagePatrolEventReq(String str, String str2, String str3) {
        this.eventCode = str;
        this.manageUserCode = str2;
        this.manageUserName = str3;
    }

    public void setManagePhotoList(List<String> list) {
        this.managePhotoList = list;
    }
}
