package com.collectpoint.bean.item;

import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class RegionListByMapItem implements IPickerViewData {
    private int id;
    private String parentCode;
    private String regionCode;
    private String regionName;
    private String sort;
    private String status;

    public int getId() {
        return this.id;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public String getPickerViewText() {
        return this.regionName;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public String getSort() {
        return this.sort;
    }

    public String getStatus() {
        return this.status;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setParentCode(String str) {
        this.parentCode = str;
    }

    public void setRegionCode(String str) {
        this.regionCode = str;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public void setSort(String str) {
        this.sort = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
