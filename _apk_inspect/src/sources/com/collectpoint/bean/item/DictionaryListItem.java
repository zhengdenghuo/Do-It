package com.collectpoint.bean.item;

import com.collectpoint.widget.recycler.SSelectable;
import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class DictionaryListItem extends SSelectable implements IPickerViewData {
    private String dictKey;
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
