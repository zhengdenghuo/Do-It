package com.collectpoint.bean.item;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class FilePathItem {
    private String filePath;
    private String fileSource;
    private String fileType;

    public FilePathItem() {
    }

    public FilePathItem(String str) {
        this.filePath = str;
    }

    public FilePathItem(String str, String str2, String str3) {
        this.filePath = str;
        this.fileSource = str2;
        this.fileType = str3;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFileSource() {
        return this.fileSource;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileSource(String str) {
        this.fileSource = str;
    }

    public void setFileType(String str) {
        this.fileType = str;
    }
}
