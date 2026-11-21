package com.collectpoint.bean.req;

import com.collectpoint.bean.item.CouponItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class AddOrderCouponReq {
    private List<CouponItem> data;
    private String order_id;
    private String settle_value;

    public AddOrderCouponReq(List<CouponItem> list, String str, String str2) {
        this.data = list;
        this.order_id = str;
        this.settle_value = str2;
    }
}
