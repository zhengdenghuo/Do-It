package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class UpdateUserPwdReq {
    private String password;
    private String userCode;
    private String userPhone;
    private String verifyCode;

    public UpdateUserPwdReq(String str, String str2, String str3, String str4) {
        this.userCode = str;
        this.userPhone = str2;
        this.password = str3;
        this.verifyCode = str4;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public String getUserPhone() {
        return this.userPhone;
    }

    public String getVerifyCode() {
        return this.verifyCode;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public void setUserPhone(String str) {
        this.userPhone = str;
    }

    public void setVerifyCode(String str) {
        this.verifyCode = str;
    }
}
