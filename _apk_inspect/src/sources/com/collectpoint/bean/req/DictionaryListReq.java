package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class DictionaryListReq {
    private String fieldName;
    private String tableName;

    public DictionaryListReq() {
        this.fieldName = "researchDirection";
        this.tableName = "patrol_event";
    }

    public DictionaryListReq(String str) {
        this.fieldName = "researchDirection";
        this.tableName = "patrol_event";
        this.fieldName = str;
    }

    public DictionaryListReq(String str, String str2) {
        this.fieldName = "researchDirection";
        this.tableName = "patrol_event";
        this.fieldName = str;
        this.tableName = str2;
    }
}
