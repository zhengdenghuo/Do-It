package com.collectpoint.bean.item;

import com.contrarywind.interfaces.IPickerViewData;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class PartsDiseaseListItem implements Serializable, IPickerViewData {
    private String attributeCode;
    private String attributeName;
    private List<PartsDiseaseListItem> children;
    private int id;
    private String isSystem;
    private String level;
    private String measureUnit;
    private String name;
    private String objectTypeCode;
    private String objectTypeName;
    private String oneLevelCode;
    private String parentId;
    private String parentName;
    private String projectOrgCode;
    private String projectOrgName;
    private String status;
    private String value;

    public String getAttributeCode() {
        return this.attributeCode;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public List<PartsDiseaseListItem> getChildren() {
        return this.children;
    }

    public int getId() {
        return this.id;
    }

    public String getIsSystem() {
        return this.isSystem;
    }

    public String getLevel() {
        return this.level;
    }

    public String getMeasureUnit() {
        return this.measureUnit;
    }

    public String getName() {
        return this.name;
    }

    public String getObjectTypeCode() {
        return this.objectTypeCode;
    }

    public String getObjectTypeName() {
        return this.objectTypeName;
    }

    public String getOneLevelCode() {
        return this.oneLevelCode;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getParentName() {
        return this.parentName;
    }

    public String getPickerViewText() {
        return this.name;
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

    public String getValue() {
        return this.value;
    }

    public void setAttributeCode(String str) {
        this.attributeCode = str;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public void setChildren(List<PartsDiseaseListItem> list) {
        this.children = list;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsSystem(String str) {
        this.isSystem = str;
    }

    public void setLevel(String str) {
        this.level = str;
    }

    public void setMeasureUnit(String str) {
        this.measureUnit = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setObjectTypeCode(String str) {
        this.objectTypeCode = str;
    }

    public void setObjectTypeName(String str) {
        this.objectTypeName = str;
    }

    public void setOneLevelCode(String str) {
        this.oneLevelCode = str;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setParentName(String str) {
        this.parentName = str;
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

    public void setValue(String str) {
        this.value = str;
    }
}
