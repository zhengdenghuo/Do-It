package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class ApiTableReq {
    private String area_id;
    private String is_merge;
    public String table_no;
    public String table_status;
    private String type_id;

    public ApiTableReq() {
    }

    public ApiTableReq(String str) {
        this.table_status = str;
    }

    public ApiTableReq(String str, String str2, String str3, String str4, String str5, int i, int i2) {
        this.is_merge = str5;
        this.area_id = str;
        this.type_id = str2;
        this.table_no = str4;
        this.table_status = str3;
    }
}
