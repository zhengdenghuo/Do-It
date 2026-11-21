package com.collectpoint.bean;

import com.collectpoint.bean.item.RotationListItem;
import com.collectpoint.bean.item.StatisticListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class FeatureList {
    private List<Integer> banners;
    private List<String> bannerss;
    private List<String> list;
    private List<RotationListItem> rotationList;
    private List<StatisticListItem> work;

    public List<Integer> getBanners() {
        return this.banners;
    }

    public List<String> getBannerss() {
        return this.bannerss;
    }

    public List<String> getList() {
        return this.list;
    }

    public List<RotationListItem> getRotationList() {
        return this.rotationList;
    }

    public List<StatisticListItem> getWork() {
        return this.work;
    }

    public FeatureList setBanners(List<Integer> list) {
        this.banners = list;
        return this;
    }

    public FeatureList setBannerss(List<String> list) {
        this.bannerss = list;
        return this;
    }

    public FeatureList setList(List<String> list) {
        this.list = list;
        return this;
    }

    public FeatureList setRotationList(List<RotationListItem> list) {
        this.rotationList = list;
        return this;
    }

    public FeatureList setWork(List<StatisticListItem> list) {
        this.work = list;
        return this;
    }
}
