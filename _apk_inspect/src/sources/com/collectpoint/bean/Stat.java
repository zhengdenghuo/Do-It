package com.collectpoint.bean;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class Stat {
    private List<WorkingFeature> list;
    private String name;
    private int resId;

    public Stat() {
    }

    public Stat(String str, int i) {
        this.name = str;
        this.resId = i;
    }

    public List<WorkingFeature> getList() {
        return this.list;
    }

    public String getName() {
        return this.name;
    }

    public int getResId() {
        return this.resId;
    }

    public Stat setList(List<WorkingFeature> list) {
        this.list = list;
        return this;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setResId(int i) {
        this.resId = i;
    }
}
