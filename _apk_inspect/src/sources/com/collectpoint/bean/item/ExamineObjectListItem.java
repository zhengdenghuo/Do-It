package com.collectpoint.bean.item;

import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class ExamineObjectListItem implements IPickerViewData {
    private String dictKey;
    private int dictOrder;
    private String dictValue;
    private String fieldExplain;
    private String fieldName;
    private int id;
    private String status;
    private String tableExplain;
    private String tableName;
    private String title;

    public String getDictKey() {
        return this.dictKey;
    }

    public int getDictOrder() {
        return this.dictOrder;
    }

    public String getDictValue() {
        return this.dictValue;
    }

    public String getFieldExplain() {
        return this.fieldExplain;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public int getId() {
        return this.id;
    }

    public String getPickerViewText() {
        return this.dictValue;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTableExplain() {
        return this.tableExplain;
    }

    public String getTableName() {
        return this.tableName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDictKey(String str) {
        this.dictKey = str;
    }

    public void setDictOrder(int i) {
        this.dictOrder = i;
    }

    public void setDictValue(String str) {
        this.dictValue = str;
    }

    public void setFieldExplain(String str) {
        this.fieldExplain = str;
    }

    public void setFieldName(String str) {
        this.fieldName = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTableExplain(String str) {
        this.tableExplain = str;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
