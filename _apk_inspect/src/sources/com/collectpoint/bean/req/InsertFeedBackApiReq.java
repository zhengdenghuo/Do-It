package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class InsertFeedBackApiReq {
    private String createCode;
    private String opinionContent;
    private String opinionImage;
    private String opinionType = "YJ";

    public InsertFeedBackApiReq(String str, String str2) {
        this.createCode = str;
        this.opinionContent = str2;
    }

    public String getCreateCode() {
        return this.createCode;
    }

    public String getOpinionContent() {
        return this.opinionContent;
    }

    public String getOpinionImage() {
        return this.opinionImage;
    }

    public String getOpinionType() {
        return this.opinionType;
    }

    public void setCreateCode(String str) {
        this.createCode = str;
    }

    public void setOpinionContent(String str) {
        this.opinionContent = str;
    }

    public void setOpinionImage(String str) {
        this.opinionImage = str;
    }

    public void setOpinionType(String str) {
        this.opinionType = str;
    }
}
