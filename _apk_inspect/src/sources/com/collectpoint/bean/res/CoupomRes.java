package com.collectpoint.bean.res;

import com.collectpoint.bean.item.CouponItem;
import com.collectpoint.widget.recycler.SSelectable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class CoupomRes extends SSelectable {
    private List<CouponItem> coupon;
    private String equity;
    private String gride_id;
    private String mobile;
    private String name;
    private List<CouponItem> notUseCoupon;
    private String user_id;

    public List<CouponItem> getCoupon() {
        return this.coupon;
    }

    public String getEquity() {
        return this.equity;
    }

    public String getGride_id() {
        return this.gride_id;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getName() {
        return this.name;
    }

    public List<CouponItem> getNotUseCoupon() {
        return this.notUseCoupon;
    }

    public String getUser_id() {
        return this.user_id;
    }
}
