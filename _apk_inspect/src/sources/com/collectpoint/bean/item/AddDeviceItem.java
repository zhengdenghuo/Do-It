package com.collectpoint.bean.item;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class AddDeviceItem {
    private List<String> device_no;
    private String icon;
    private String product_id;
    private String product_name;
    private int product_num;
    private String product_price;
    private String product_sku_id;
    private String table_id;

    public AddDeviceItem(String str, int i, String str2, String str3, String str4, List<String> list, String str5, String str6) {
        this.product_id = str;
        this.product_num = i;
        this.product_sku_id = str2;
        this.product_price = str3;
        this.table_id = str4;
        this.device_no = list;
        this.product_name = str5;
        this.icon = str6;
    }

    public List<String> getDevice_no() {
        return this.device_no;
    }

    public String getProduct_id() {
        return this.product_id;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public int getProduct_num() {
        return this.product_num;
    }

    public String getProduct_price() {
        return this.product_price;
    }

    public String getProduct_sku_id() {
        return this.product_sku_id;
    }

    public String getTable_id() {
        return this.table_id;
    }

    public void setDevice_no(List<String> list) {
        this.device_no = list;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setProduct_id(String str) {
        this.product_id = str;
    }

    public void setProduct_num(int i) {
        this.product_num = i;
    }

    public void setProduct_price(String str) {
        this.product_price = str;
    }

    public void setProduct_sku_id(String str) {
        this.product_sku_id = str;
    }

    public void setTable_id(String str) {
        this.table_id = str;
    }
}
