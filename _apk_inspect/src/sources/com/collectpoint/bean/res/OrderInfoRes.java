package com.collectpoint.bean.res;

import com.collectpoint.bean.item.CouponItem;
import com.collectpoint.utils.EmptyUtils;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class OrderInfoRes {
    private String app_id;
    private String discount_money;
    private String giveChange;
    private String meal_num;
    private String order_id;
    private String order_no;
    private String order_price;
    private OrderStatusRes order_status;
    private String order_type_text;
    private String pay_price;
    private PayStatusRes pay_status;
    private List<ProductRes> product;
    private String product_num;
    private String real_money;
    private String reduce_num;
    private SettleInfoRes settleInfo;
    private String shop_supplier_id;
    private String should_pay_price;
    private SupplierRes supplier;
    private String tip;
    private String total_price;

    public static class OrderStatusRes {
        private String text;
        private String value;
    }

    public static class PayStatusRes {
        private String text;
        private String value;
    }

    public static class ProductRes {
    }

    public static class SettleInfoRes {
        private List<CouponItem> coupon;
        private String plat_source_id;
        private List<CouponItem> settle;
        private String shop_supplier_id;
        private String table_id;
        private String user_id;

        public List<CouponItem> getCoupon() {
            if (EmptyUtils.isEmpty(this.coupon)) {
                return null;
            }
            return this.coupon;
        }

        public String getPlat_source_id() {
            return this.plat_source_id;
        }

        public List<CouponItem> getSettle() {
            if (EmptyUtils.isEmpty(this.settle)) {
                return null;
            }
            return this.settle;
        }

        public String getShop_supplier_id() {
            return this.shop_supplier_id;
        }

        public String getTable_id() {
            return this.table_id;
        }

        public String getUser_id() {
            return this.user_id;
        }
    }

    public static class SupplierRes {
        private String address;
        private String name;
    }

    public String getApp_id() {
        return this.app_id;
    }

    public String getDiscount_money() {
        return this.discount_money;
    }

    public String getGiveChange() {
        return this.giveChange;
    }

    public String getMeal_num() {
        return this.meal_num;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public String getOrder_no() {
        return this.order_no;
    }

    public String getOrder_price() {
        return this.order_price;
    }

    public OrderStatusRes getOrder_status() {
        return this.order_status;
    }

    public String getOrder_type_text() {
        return this.order_type_text;
    }

    public String getPay_price() {
        return this.pay_price;
    }

    public PayStatusRes getPay_status() {
        return this.pay_status;
    }

    public List<ProductRes> getProduct() {
        return this.product;
    }

    public String getProduct_num() {
        return this.product_num;
    }

    public String getReal_money() {
        return this.real_money;
    }

    public String getReduce_num() {
        return this.reduce_num;
    }

    public SettleInfoRes getSettleInfo() {
        return EmptyUtils.isEmpty(this.settleInfo) ? new SettleInfoRes() : this.settleInfo;
    }

    public String getShop_supplier_id() {
        return this.shop_supplier_id;
    }

    public String getShould_pay_price() {
        return this.should_pay_price;
    }

    public SupplierRes getSupplier() {
        return this.supplier;
    }

    public String getTip() {
        return this.tip;
    }

    public String getTotal_price() {
        return this.total_price;
    }
}
