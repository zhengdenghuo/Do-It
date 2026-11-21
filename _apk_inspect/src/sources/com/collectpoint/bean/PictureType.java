package com.collectpoint.bean;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class PictureType {
    private String fileSource;
    private String fileType;
    private String path;

    public PictureType() {
    }

    public PictureType(String str, String str2, String str3) {
        this.path = str;
        this.fileSource = str2;
        this.fileType = str3;
    }

    public String getFileSource() {
        return this.fileSource;
    }

    public String getFileType() {
        return this.fileType;
    }

    public String getPath() {
        return this.path;
    }

    public void setFileSource(String str) {
        this.fileSource = str;
    }

    public void setFileType(String str) {
        this.fileType = str;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
