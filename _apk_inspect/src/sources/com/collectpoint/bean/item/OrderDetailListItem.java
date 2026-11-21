package com.collectpoint.bean.item;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class OrderDetailListItem {
    private List<CanpinRes> canpin;
    private List<CanpinRes> canpin_arr;
    private String is_coupon;
    private String name;
    private String num;
    private String tip;
    private String total_pay_price;
    private String total_price;

    public static class CanpinRes {
        private String is_gift;
        private String is_promotion;
        private String product_name;
        private String total_num;
        private String total_pay_price;
        private String total_price;

        public String getIs_gift() {
            return this.is_gift;
        }

        public String getIs_promotion() {
            return this.is_promotion;
        }

        public String getProduct_name() {
            return this.product_name;
        }

        public String getTotal_num() {
            return this.total_num;
        }

        public String getTotal_pay_price() {
            return this.total_pay_price;
        }

        public String getTotal_price() {
            return this.total_price;
        }
    }

    public List<CanpinRes> getCanpin() {
        return this.canpin;
    }

    public List<CanpinRes> getCanpin_arr() {
        return this.canpin_arr;
    }

    public String getIs_coupon() {
        return this.is_coupon;
    }

    public String getName() {
        return this.name;
    }

    public String getNum() {
        return this.num;
    }

    public String getTip() {
        return this.tip;
    }

    public String getTotal_pay_price() {
        return this.total_pay_price;
    }

    public String getTotal_price() {
        return this.total_price;
    }
}
