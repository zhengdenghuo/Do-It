package com.collectpoint.bean.item;

import com.collectpoint.widget.recycler.SSelectable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class InfoNameListItem extends SSelectable {
    private String infoName;
    private String maintainName;
    private String maintainType;
    private String maintainUrl;
    private String sort;

    public String getInfoName() {
        return this.infoName;
    }

    public String getMaintainName() {
        return this.maintainName;
    }

    public String getMaintainType() {
        return this.maintainType;
    }

    public String getMaintainUrl() {
        return this.maintainUrl;
    }

    public String getSort() {
        return this.sort;
    }

    public void setInfoName(String str) {
        this.infoName = str;
    }

    public void setMaintainName(String str) {
        this.maintainName = str;
    }

    public void setMaintainType(String str) {
        this.maintainType = str;
    }

    public void setMaintainUrl(String str) {
        this.maintainUrl = str;
    }

    public void setSort(String str) {
        this.sort = str;
    }
}
