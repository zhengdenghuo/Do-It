package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class OrderListReq {
    private String list_rows;
    private String page;
    private String status;
    private String table_order_no;

    public OrderListReq(String str, String str2, String str3, String str4) {
        this.status = str;
        this.table_order_no = str2;
        this.list_rows = str3;
        this.page = str4;
    }
}
