package com.collectpoint.bean.res;

import com.collectpoint.bean.item.HallCartItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class HallCartlistRes {
    private CartInfoRes cartInfo;
    private List<ProductListRes> productList;

    public static class CartInfoRes {
        private String cart_total_num;
        private String total_pay_price;

        public String getCart_total_num() {
            return this.cart_total_num;
        }

        public String getTotal_pay_price() {
            return this.total_pay_price;
        }
    }

    public static class ProductListRes {
        private String cart_id;
        private String describe;
        private String feed;
        private String pay_price;
        private HallCartItem product;
        private String product_num;
        private String product_price;
        private String user_id;

        public String getCart_id() {
            return this.cart_id;
        }

        public String getDescribe() {
            return this.describe;
        }

        public String getFeed() {
            return this.feed;
        }

        public String getPay_price() {
            return this.pay_price;
        }

        public HallCartItem getProduct() {
            return this.product;
        }

        public String getProduct_num() {
            return this.product_num;
        }

        public String getProduct_price() {
            return this.product_price;
        }

        public String getUser_id() {
            return this.user_id;
        }

        public void setProduct_num(String str) {
            this.product_num = str;
        }
    }

    public CartInfoRes getCartInfo() {
        return this.cartInfo;
    }

    public List<ProductListRes> getProductList() {
        return this.productList;
    }
}
