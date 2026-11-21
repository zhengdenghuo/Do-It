package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class ScanPayReq {
    private String auth_code;
    private String money;
    private String order_id;
    private String out_trade_no;

    public ScanPayReq(String str) {
        this.out_trade_no = str;
    }

    public ScanPayReq(String str, String str2, String str3) {
        this.order_id = str;
        this.money = str2;
        this.auth_code = str3;
    }
}
