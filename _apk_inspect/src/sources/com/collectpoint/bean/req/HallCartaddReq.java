package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class HallCartaddReq {
    private String gift_remark;
    private String is_print;
    private String meal_num;
    private String order_id;
    private String remark;
    private String table_id;
    private String user_id;

    public HallCartaddReq(String str, String str2) {
        this.table_id = str;
        this.order_id = str2;
    }

    public HallCartaddReq(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        this.table_id = str;
        if (z) {
            this.gift_remark = str2;
        } else {
            this.remark = str2;
        }
        this.order_id = str3;
        this.is_print = str6;
        this.meal_num = str4;
        this.user_id = str5;
    }
}
