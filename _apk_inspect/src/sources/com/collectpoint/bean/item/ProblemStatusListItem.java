package com.collectpoint.bean.item;

import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class ProblemStatusListItem implements IPickerViewData {
    private String dictKey;
    private String dictValue;
    private String fieldName;
    private String status;
    private String systemCode;
    private String tableName;

    public String getDictKey() {
        return this.dictKey;
    }

    public String getDictValue() {
        return this.dictValue;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String getPickerViewText() {
        return this.dictValue;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSystemCode() {
        return this.systemCode;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setDictKey(String str) {
        this.dictKey = str;
    }

    public void setDictValue(String str) {
        this.dictValue = str;
    }

    public void setFieldName(String str) {
        this.fieldName = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSystemCode(String str) {
        this.systemCode = str;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }
}
