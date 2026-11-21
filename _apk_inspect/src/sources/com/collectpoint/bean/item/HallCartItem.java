package com.collectpoint.bean.item;

import com.collectpoint.widget.recycler.SSelectable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class HallCartItem {
    private String agent_money_type;
    private String alone_grade_type;
    private String app_id;
    private String bag_price;
    private CategoryRes category;
    private String category_id;
    private String content;
    private String content_poster_id;
    private String content_video_id;
    private String cost_price;
    private String create_time;
    private String day_limit;
    private String deduct_stock_type;
    public int headId;
    public int headIndex;
    private List<ImageRes> image;
    private String is_agent;
    private String is_alone_grade;
    private String is_delete;
    private String is_double_portion;
    private String is_enable_card;
    private String is_enable_grade;
    private String is_group;
    private String is_ind_agent;
    private String is_picture;
    private String is_points_discount;
    private String is_points_gift;
    private String is_promotion;
    private String label_id;
    private String limit_num;
    private String line_price;
    private String max_points_discount;
    private String min_buy;
    private String order_limit;
    private String pay_price;
    private List<ProductAttrRes> product_attr;
    private List<FeedRes> product_feed;
    private List<ProductFeedDoubleRes> product_feed_double;
    private String product_id;
    private String product_name;
    private String product_no;
    private String product_price;
    private String product_sales;
    private String product_sort;
    private String product_stock;
    private String product_type;
    private String product_unit;
    private String sales_actual;
    private String sales_initial;
    private String selectData;
    private String selling_point;
    private String shop_supplier_id;
    private List<SkuRes> sku;
    private String spec_type;
    private String special_id;
    private String supplier_price;
    private String syn_product_id;
    private String title;
    private String update_time;
    private String view_times;

    public static class CategoryRes {
        private String app_id;
        private String category_id;
        private String create_time;
        private String image_id;
        private String is_special;
        private String name;
        private String parent_id;
        private String shop_supplier_id;
        private String sort;
        private String status;
        private String type;
        private String update_time;

        public String getName() {
            return this.name;
        }
    }

    public static class FeedRes extends SSelectable {
        private String feed_name;
        private String is_select;
        private String price;
        private String product_id;
        private String stock_num;

        public String getFeed_name() {
            return this.feed_name;
        }

        public String getIs_select() {
            return this.is_select;
        }

        public String getPrice() {
            return this.price;
        }

        public String getProduct_id() {
            return this.product_id;
        }

        public String getStock_num() {
            return this.stock_num;
        }
    }

    public static class ImageRes {
        private String app_id;
        private String create_time;
        private String file_name;
        private String file_path;
        private String file_url;
        private String id;
        private String image_id;
        private String image_type;
        private String product_id;

        public String getFile_path() {
            return this.file_path;
        }
    }

    public static class ProductAttrRes extends SSelectable {
        private String attribute_name;
        private List<String> attribute_value;

        public String getAttribute_name() {
            return this.attribute_name;
        }

        public List<String> getAttribute_value() {
            return this.attribute_value;
        }
    }

    public static class ProductFeedDoubleRes {
        private List<FeedRes> children;
        private String name;

        public List<FeedRes> getChildren() {
            return this.children;
        }

        public String getName() {
            return this.name;
        }
    }

    public static class SkuRes extends SSelectable {
        private String app_id;
        private String bag_price;
        private String base_stock_num;
        private String cost_price;
        private String image_id;
        private String is_full;
        private String is_select;
        private String line_price;
        private String low_price;
        private String product_id;
        private String product_no;
        private String product_price;
        private String product_sales;
        private String product_sku_id;
        private String product_weight;
        private String spec_name;
        private String spec_sku_id;
        private String stock_num;
        private String supplier_price;

        public String getIs_select() {
            return this.is_select;
        }

        public String getProduct_price() {
            return this.product_price;
        }

        public String getProduct_sku_id() {
            return this.product_sku_id;
        }

        public String getSpec_name() {
            return this.spec_name;
        }

        public String getStock_num() {
            return this.stock_num;
        }
    }

    public String getBag_price() {
        return this.bag_price;
    }

    public CategoryRes getCategory() {
        return this.category;
    }

    public List<ImageRes> getImage() {
        return this.image;
    }

    public String getIs_double_portion() {
        return this.is_double_portion;
    }

    public String getIs_promotion() {
        return this.is_promotion;
    }

    public String getLine_price() {
        return this.line_price;
    }

    public String getMin_buy() {
        return this.min_buy;
    }

    public String getPay_price() {
        return this.pay_price;
    }

    public List<ProductAttrRes> getProduct_attr() {
        return this.product_attr;
    }

    public List<FeedRes> getProduct_feed() {
        return this.product_feed;
    }

    public List<ProductFeedDoubleRes> getProduct_feed_double() {
        return this.product_feed_double;
    }

    public String getProduct_id() {
        return this.product_id;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public String getProduct_price() {
        return this.product_price;
    }

    public String getProduct_unit() {
        return this.product_unit;
    }

    public String getSelling_point() {
        return this.selling_point;
    }

    public List<SkuRes> getSku() {
        return this.sku;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
