package com.collectpoint.bean.item;

import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class PatrolMapPatrolTypeListItem implements IPickerViewData {
    private String imgPath;
    private String objectTypeCode;
    private String objectTypeName;
    private String projectOrgCode;
    private String typeCode;
    private String typeIcon;
    private String typeName;

    public String getImgPath() {
        return this.imgPath;
    }

    public String getObjectTypeCode() {
        return this.objectTypeCode;
    }

    public String getObjectTypeName() {
        return this.objectTypeName;
    }

    public String getPickerViewText() {
        return this.typeName;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public String getTypeIcon() {
        return this.typeIcon;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setImgPath(String str) {
        this.imgPath = str;
    }

    public void setObjectTypeCode(String str) {
        this.objectTypeCode = str;
    }

    public void setObjectTypeName(String str) {
        this.objectTypeName = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }

    public void setTypeIcon(String str) {
        this.typeIcon = str;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }
}
