package com.collectpoint.bean.item;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class FoodItem {
    private int count = 0;
    private String description;
    private String id;
    private String imageUrl;
    private int monthlySales;
    private String name;
    private double price;

    public FoodItem(String str, String str2, String str3, double d, String str4, int i) {
        this.id = str;
        this.name = str2;
        this.description = str3;
        this.price = d;
        this.imageUrl = str4;
        this.monthlySales = i;
    }

    public int getCount() {
        return this.count;
    }

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getMonthlySales() {
        return this.monthlySales;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setMonthlySales(int i) {
        this.monthlySales = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPrice(double d) {
        this.price = d;
    }
}
