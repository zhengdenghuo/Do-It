package com.collectpoint.bean.item;

import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class SortListItem implements IPickerViewData {
    private String createTime;
    private String id;
    private String name;
    private String parentId;
    private String projectOrgCode;
    private String sortCode;
    private String sortName;
    private String status;
    private String title;
    private String typeCode;

    public String getCreateTime() {
        return this.createTime;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getPickerViewText() {
        return this.sortName;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getSortCode() {
        return this.sortCode;
    }

    public String getSortName() {
        return this.sortName;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setSortCode(String str) {
        this.sortCode = str;
    }

    public void setSortName(String str) {
        this.sortName = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }
}
