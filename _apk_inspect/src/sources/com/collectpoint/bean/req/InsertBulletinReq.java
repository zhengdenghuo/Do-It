package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class InsertBulletinReq {
    private String AccessToken;
    private String bulletinContent;
    private String bulletinFile;
    private String bulletinTitle;
    private String bulletinType;
    private String userCode;

    public InsertBulletinReq(String str, String str2, String str3, String str4, String str5, String str6) {
        this.AccessToken = str;
        this.userCode = str2;
        this.bulletinTitle = str3;
        this.bulletinContent = str4;
        this.bulletinType = str5;
        this.bulletinFile = str6;
    }

    public String getAccessToken() {
        return this.AccessToken;
    }

    public String getBulletinContent() {
        return this.bulletinContent;
    }

    public String getBulletinFile() {
        return this.bulletinFile;
    }

    public String getBulletinTitle() {
        return this.bulletinTitle;
    }

    public String getBulletinType() {
        return this.bulletinType;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setAccessToken(String str) {
        this.AccessToken = str;
    }

    public void setBulletinContent(String str) {
        this.bulletinContent = str;
    }

    public void setBulletinFile(String str) {
        this.bulletinFile = str;
    }

    public void setBulletinTitle(String str) {
        this.bulletinTitle = str;
    }

    public void setBulletinType(String str) {
        this.bulletinType = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
