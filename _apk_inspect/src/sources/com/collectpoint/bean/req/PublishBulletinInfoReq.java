package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PublishBulletinInfoReq {
    private String AccessToken;
    private String userCode;

    public PublishBulletinInfoReq(String str, String str2) {
        this.AccessToken = str;
        this.userCode = str2;
    }

    public String getAccessToken() {
        return this.AccessToken;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setAccessToken(String str) {
        this.AccessToken = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
