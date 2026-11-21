package com.collectpoint.bean.item;

import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class ProvinceListItem implements IPickerViewData {
    private String id;
    private String parentCode;
    private String parentName;
    private String regionCode;
    private String regionName;
    private String regionType;
    private String sort;
    private String status;
    private String title;

    public String getId() {
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

    public String getRegionType() {
        return this.regionType;
    }

    public String getSort() {
        return this.sort;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public void setId(String str) {
        this.id = str;
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

    public void setRegionType(String str) {
        this.regionType = str;
    }

    public void setSort(String str) {
        this.sort = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
