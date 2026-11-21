package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class HallCartReq {
    private String attr;
    private String bag_price;
    private String cart_id;
    private String describe;
    private String feed;
    private String is_gift;
    private String price;
    private String product_id;
    private String product_num;
    private String product_price;
    private String product_sku_id;
    private String scan_info;
    private String table_id;
    private String type;

    public HallCartReq() {
    }

    public HallCartReq(String str) {
        this.table_id = str;
    }

    public HallCartReq(String str, String str2) {
        this.table_id = str;
        this.scan_info = str2;
    }

    public HallCartReq(String str, String str2, String str3) {
        this.product_num = str;
        this.cart_id = str2;
        this.type = str3;
    }

    public HallCartReq(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.product_id = str;
        this.product_num = str2;
        this.product_sku_id = str3;
        this.price = str5;
        this.product_price = str6;
        this.bag_price = str7;
        this.table_id = str8;
        this.attr = str4;
        this.feed = str9;
        this.describe = str10;
        this.is_gift = str11;
    }
}
