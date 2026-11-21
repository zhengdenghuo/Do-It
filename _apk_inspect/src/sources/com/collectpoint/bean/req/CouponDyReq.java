package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class CouponDyReq {
    private String code;
    private String order_id;
    private String pay_method_id;

    public CouponDyReq(String str) {
        this.pay_method_id = str;
    }

    public CouponDyReq(String str, String str2) {
        this.code = str;
        this.order_id = str2;
    }
}
