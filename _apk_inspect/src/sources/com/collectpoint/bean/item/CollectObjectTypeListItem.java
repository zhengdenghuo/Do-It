package com.collectpoint.bean.item;

import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class CollectObjectTypeListItem implements IPickerViewData {
    private String collectLevel;
    private String collectObjectCode;
    private String collectObjectName;
    private String createCode;
    private String createTime;
    private String createTimeStr;
    private String id;
    private String isFrequencyRequired;
    private String parentCollectObjectCode;
    private String projectOrgCode;
    private String projectOrgName;
    private String status;

    public String getCollectLevel() {
        return this.collectLevel;
    }

    public String getCollectObjectCode() {
        return this.collectObjectCode;
    }

    public String getCollectObjectName() {
        return this.collectObjectName;
    }

    public String getCreateCode() {
        return this.createCode;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getCreateTimeStr() {
        return this.createTimeStr;
    }

    public String getId() {
        return this.id;
    }

    public String getIsFrequencyRequired() {
        return this.isFrequencyRequired;
    }

    public String getParentCollectObjectCode() {
        return this.parentCollectObjectCode;
    }

    public String getPickerViewText() {
        return this.collectObjectName;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getProjectOrgName() {
        return this.projectOrgName;
    }

    public String getStatus() {
        return this.status;
    }

    public void setCollectLevel(String str) {
        this.collectLevel = str;
    }

    public void setCollectObjectCode(String str) {
        this.collectObjectCode = str;
    }

    public void setCollectObjectName(String str) {
        this.collectObjectName = str;
    }

    public void setCreateCode(String str) {
        this.createCode = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setCreateTimeStr(String str) {
        this.createTimeStr = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setParentCollectObjectCode(String str) {
        this.parentCollectObjectCode = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setProjectOrgName(String str) {
        this.projectOrgName = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
