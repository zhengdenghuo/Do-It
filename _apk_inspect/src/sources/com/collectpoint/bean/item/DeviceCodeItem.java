package com.collectpoint.bean.item;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class DeviceCodeItem {
    private List<String> deviceNo;
    private String device_rule_no;
    private String icon;
    private int num;
    private String product_id;
    private String product_name;
    private String product_price;
    private String product_sku_id;

    public List<String> getDeviceNo() {
        return this.deviceNo;
    }

    public String getDevice_rule_no() {
        return this.device_rule_no;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getNum() {
        return this.num;
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

    public String getProduct_sku_id() {
        return this.product_sku_id;
    }

    public void setDeviceNo(List<String> list) {
        this.deviceNo = list;
    }

    public void setNum(int i) {
        this.num = i;
    }
}
