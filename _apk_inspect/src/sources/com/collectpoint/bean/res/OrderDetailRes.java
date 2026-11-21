package com.collectpoint.bean.res;

import com.collectpoint.bean.item.OrderDetailListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class OrderDetailRes {
    private String area_name;
    private String cashier_id;
    private String cashier_name;
    private String create_time;
    private List<DiscountListRes> discount_list;
    private String discount_money;
    private String meal_num;
    private String order_id;
    private String order_no;
    private String order_remark;
    private String pay_status;
    private String pay_time;
    private String present_remark;
    private List<OrderDetailListItem> productList;
    private String real_receivable_money;
    private String receivable_money;
    private String refund_money;
    private String refund_remark;
    private List<SettleListRes> settle_list;
    private String settle_remark;
    private String should_pay_price;
    private String table_no;
    private String total_price;
    private String type_name;
    private String user_id;
    private UserInfoRes user_info;

    public static class DiscountListRes {
        private String discount_money;
        private String name;
        private String settle_type;

        public String getDiscount_money() {
            return this.discount_money;
        }

        public String getName() {
            return this.name;
        }

        public String getSettle_type() {
            return this.settle_type;
        }
    }

    public static class ProductListRes {
        private List<CanpinArrRes> canpin_arr;
        private String name;
        private String num;
        private String tip;
        private String total_pay_price;
        private String total_price;

        public static class CanpinArrRes {
            private String name;
            private String total_num;
            private String total_pay_price;
            private String total_price;

            public String getName() {
                return this.name;
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

        public List<CanpinArrRes> getCanpin_arr() {
            return this.canpin_arr;
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

    public static class SettleListRes {
        private String name;
        private String num;
        private String real_money;
        private String settle_money;

        public String getName() {
            return this.name;
        }

        public String getNum() {
            return this.num;
        }

        public String getReal_money() {
            return this.real_money;
        }

        public String getSettle_money() {
            return this.settle_money;
        }
    }

    public static class UserInfoRes {
        private String mobile;
        private String name;
        private String reg_name;

        public String getMobile() {
            return this.mobile;
        }

        public String getName() {
            return this.name;
        }

        public String getReg_name() {
            return this.reg_name;
        }
    }

    public String getArea_name() {
        return this.area_name;
    }

    public String getCashier_id() {
        return this.cashier_id;
    }

    public String getCashier_name() {
        return this.cashier_name;
    }

    public String getCreate_time() {
        return this.create_time;
    }

    public List<DiscountListRes> getDiscount_list() {
        return this.discount_list;
    }

    public String getDiscount_money() {
        return this.discount_money;
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

    public String getOrder_remark() {
        return this.order_remark;
    }

    public String getPay_status() {
        return this.pay_status;
    }

    public String getPay_time() {
        return this.pay_time;
    }

    public String getPresent_remark() {
        return this.present_remark;
    }

    public List<OrderDetailListItem> getProductList() {
        return this.productList;
    }

    public String getReal_receivable_money() {
        return this.real_receivable_money;
    }

    public String getReceivable_money() {
        return this.receivable_money;
    }

    public String getRefund_money() {
        return this.refund_money;
    }

    public String getRefund_remark() {
        return this.refund_remark;
    }

    public List<SettleListRes> getSettle_list() {
        return this.settle_list;
    }

    public String getSettle_remark() {
        return this.settle_remark;
    }

    public String getShould_pay_price() {
        return this.should_pay_price;
    }

    public String getTable_no() {
        return this.table_no;
    }

    public String getTotal_price() {
        return this.total_price;
    }

    public String getType_name() {
        return this.type_name;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public UserInfoRes getUser_info() {
        return this.user_info;
    }
}
