package com.collectpoint.bean.res;

import com.google.gson.annotations.SerializedName;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class UploadWxRes {

    @SerializedName("originalFilename")
    private String localFileName;
    private String object;

    public String getLocalFileName() {
        return this.localFileName;
    }

    public String getObject() {
        return this.object;
    }

    public UploadWxRes setLocalFileName(String str) {
        this.localFileName = str;
        return this;
    }
}
