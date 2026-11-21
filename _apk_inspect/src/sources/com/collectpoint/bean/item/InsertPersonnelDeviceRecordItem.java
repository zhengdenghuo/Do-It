package com.collectpoint.bean.item;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class InsertPersonnelDeviceRecordItem {
    private String operateStatus;
    private String operateTime;
    private String operateType;
    private String personnelUserCode;
    private String personnelUserName;
    private String projectOrgCode;
    private String projectOrgName;

    public InsertPersonnelDeviceRecordItem(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.operateType = str5;
        this.operateStatus = str6;
        this.operateTime = str7;
        this.projectOrgCode = str;
        this.projectOrgName = str2;
        this.personnelUserCode = str3;
        this.personnelUserName = str4;
    }
}
