package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class MoveProductReq {
    private String is_print;
    private String num;
    private String order_id;
    private String order_product_id;
    private String type;

    public MoveProductReq() {
    }

    public MoveProductReq(String str) {
        this.order_id = str;
    }

    public MoveProductReq(String str, String str2) {
        this.order_product_id = str;
        this.order_id = str2;
    }

    public MoveProductReq(String str, String str2, String str3, String str4) {
        this.order_product_id = str;
        this.is_print = str4;
        this.order_id = str2;
        this.num = str3;
    }

    public void setOrder_product_id(String str) {
        this.order_product_id = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
