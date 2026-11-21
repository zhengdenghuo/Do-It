package com.collectpoint.bean.item;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class WorkingItem {
    private String content;
    private int resId;
    private String title;

    public WorkingItem(String str, String str2, int i) {
        this.title = str;
        this.content = str2;
        this.resId = i;
    }

    public String getContent() {
        return this.content;
    }

    public int getResId() {
        return this.resId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setResId(int i) {
        this.resId = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
