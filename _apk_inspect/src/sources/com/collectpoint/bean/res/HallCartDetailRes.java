package com.collectpoint.bean.res;

import com.collectpoint.bean.item.ProductItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class HallCartDetailRes {
    private HallCartDetailProRes detail;

    public class HallCartDetailProRes {
        private String meal_num;
        private String order_id;
        private String order_price;
        private String pay_price;
        private List<ProductItem> product;
        private String product_num;
        private String shop_supplier_id;
        private String table_no;
        private String user_id;

        public HallCartDetailProRes() {
        }

        public String getMeal_num() {
            return this.meal_num;
        }

        public String getOrder_id() {
            return this.order_id;
        }

        public String getOrder_price() {
            return this.order_price;
        }

        public String getPay_price() {
            return this.pay_price;
        }

        public List<ProductItem> getProduct() {
            return this.product;
        }

        public String getProduct_num() {
            return this.product_num;
        }

        public String getShop_supplier_id() {
            return this.shop_supplier_id;
        }

        public String getTable_no() {
            return this.table_no;
        }

        public String getUser_id() {
            return this.user_id;
        }

        public void setProduct(List<ProductItem> list) {
            this.product = list;
        }
    }

    public HallCartDetailProRes getDetail() {
        return this.detail;
    }
}
