package com.collectpoint.bean.item;

import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class AchieveModeListItem implements IPickerViewData {
    private String dictKey;
    private String dictOrder;
    private String dictValue;
    private String fieldExplain;
    private String fieldName;
    private String id;
    private String key;
    private String status;
    private String tableExplain;
    private String tableName;
    private String title;
    private String value;

    public String getDictKey() {
        return this.dictKey;
    }

    public String getDictOrder() {
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

    public String getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
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

    public String getValue() {
        return this.value;
    }
}
