package com.collectpoint.bean.res;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class AccountTreeRes {
    private String groupCode;
    private String latitude;
    private String longitude;
    private String searchName;
    private String userCode;
    private String userName;
    private String userType;

    public AccountTreeRes(String str, String str2, String str3) {
        this.userCode = str;
        this.userName = str2;
        this.groupCode = str3;
    }

    public AccountTreeRes(String str, String str2, String str3, String str4) {
        this.userCode = str;
        this.userName = str2;
        this.userType = str3;
        this.searchName = str4;
    }

    public AccountTreeRes(String str, String str2, String str3, String str4, String str5, String str6) {
        this.userCode = str;
        this.userName = str2;
        this.userType = str3;
        this.longitude = str4;
        this.latitude = str5;
        this.searchName = str6;
    }
}
