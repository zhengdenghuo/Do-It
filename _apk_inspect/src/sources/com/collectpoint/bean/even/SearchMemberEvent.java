package com.collectpoint.bean.even;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class SearchMemberEvent {
    private String content;
    private int type;

    public SearchMemberEvent(String str, int i) {
        this.content = str;
        this.type = i;
    }

    public String getContent() {
        return this.content;
    }

    public int getType() {
        return this.type;
    }
}
