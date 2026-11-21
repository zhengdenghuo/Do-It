package com.collectpoint.bean.req;

import com.collectpoint.BuildConfig;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class SendSmsReq {
    private String appType = BuildConfig.SOFT_SORT;
    private String graphicCode;
    private String graphicKey;
    private String phone;
    private String smsType;

    public SendSmsReq(String str, String str2, String str3, String str4) {
        this.phone = str;
        this.smsType = str2;
        this.graphicKey = str3;
        this.graphicCode = str4;
    }

    public String getGraphicCode() {
        return this.graphicCode;
    }

    public String getGraphicKey() {
        return this.graphicKey;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getSmsType() {
        return this.smsType;
    }

    public void setGraphicCode(String str) {
        this.graphicCode = str;
    }

    public void setGraphicKey(String str) {
        this.graphicKey = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setSmsType(String str) {
        this.smsType = str;
    }
}
