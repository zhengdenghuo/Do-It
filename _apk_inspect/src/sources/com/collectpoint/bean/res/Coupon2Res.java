package com.collectpoint.bean.res;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class Coupon2Res {
    private List<CertificatesRes> certificates;
    private String code;
    private String content;
    private String coupon_money;
    private String dealId;
    private String description;
    private String error_code;
    private String in_order_id;
    private String num;
    private String order_id;
    private String pay_amount;
    private String receipt_amount;
    private String title;
    private String verify_token;

    public static class CertificatesRes {
        private AmountRes amount;
        private BookInfoRes book_info;
        private String certificate_id;
        private String encrypted_code;
        private String expire_time;
        private SkuRes sku;
        private String start_time;
        private UseTimeInfoRes use_time_info;

        public static class AmountRes {
            private String brand_ticket_amount;
            private String coupon_pay_amount;
            private String list_market_amount;
            private String merchant_ticket_amount;
            private String original_amount;
            private String pay_amount;
            private String payment_discount_amount;
            private String platform_discount_amount;

            public String getBrand_ticket_amount() {
                return this.brand_ticket_amount;
            }

            public String getCoupon_pay_amount() {
                return this.coupon_pay_amount;
            }

            public String getList_market_amount() {
                return this.list_market_amount;
            }

            public String getOriginal_amount() {
                return this.original_amount;
            }

            public String getPay_amount() {
                return this.pay_amount;
            }

            public String getPayment_discount_amount() {
                return this.payment_discount_amount;
            }

            public String getPlatform_discount_amount() {
                return this.platform_discount_amount;
            }
        }

        public static class BookInfoRes {
            private String book_poi_id;

            public String getBook_poi_id() {
                return this.book_poi_id;
            }
        }

        public static class SkuRes {
            private String account_id;
            private String groupon_type;
            private String market_price;
            private String sku_id;
            private String sold_start_time;
            private String third_sku_id;
            private String title;

            public String getAccount_id() {
                return this.account_id;
            }

            public String getGroupon_type() {
                return this.groupon_type;
            }

            public String getMarket_price() {
                return this.market_price;
            }

            public String getSku_id() {
                return this.sku_id;
            }

            public String getSold_start_time() {
                return this.sold_start_time;
            }

            public String getThird_sku_id() {
                return this.third_sku_id;
            }

            public String getTitle() {
                return this.title;
            }
        }

        public static class UseTimeInfoRes {
            private String use_time_type;

            public String getUse_time_type() {
                return this.use_time_type;
            }
        }

        public AmountRes getAmount() {
            return this.amount;
        }

        public BookInfoRes getBook_info() {
            return this.book_info;
        }

        public String getCertificate_id() {
            return this.certificate_id;
        }

        public String getEncrypted_code() {
            return this.encrypted_code;
        }

        public String getExpire_time() {
            return this.expire_time;
        }

        public SkuRes getSku() {
            return this.sku;
        }

        public String getStart_time() {
            return this.start_time;
        }

        public UseTimeInfoRes getUse_time_info() {
            return this.use_time_info;
        }
    }

    public List<CertificatesRes> getCertificates() {
        return this.certificates;
    }

    public String getContent() {
        return this.content;
    }

    public String getCoupon_money() {
        return this.coupon_money;
    }

    public String getDescription() {
        return this.description;
    }

    public String getError_code() {
        return this.error_code;
    }

    public String getIn_order_id() {
        return this.in_order_id;
    }

    public String getNum() {
        return this.num;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVerify_token() {
        return this.verify_token;
    }

    public void setIn_order_id(String str) {
        this.in_order_id = str;
    }

    public void setNum(String str) {
        this.num = str;
    }
}
