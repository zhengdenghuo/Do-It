package com.collectpoint.bean.item;

import com.collectpoint.widget.recycler.SSelectable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class TableAreaItem extends SSelectable {
    private String area_id;
    private String area_name;
    private String max_num;
    private String meal_num;
    private String service_status;
    private String sort;
    private String status;
    private List<TableAreaItem> tableList;
    private String tableNum;
    private String table_id;
    private String table_no;
    private String table_status;
    private String table_status_name;
    private List<TableAreaItem> typeList;
    private String type_id;
    private String type_name;
    private String use_time;

    public String getArea_id() {
        return this.area_id;
    }

    public String getArea_name() {
        return this.area_name;
    }

    public String getMax_num() {
        return this.max_num;
    }

    public String getMeal_num() {
        return this.meal_num;
    }

    public String getService_status() {
        return this.service_status;
    }

    public String getSort() {
        return this.sort;
    }

    public String getStatus() {
        return this.status;
    }

    public List<TableAreaItem> getTableList() {
        return this.tableList;
    }

    public String getTableNum() {
        return this.tableNum;
    }

    public String getTable_id() {
        return this.table_id;
    }

    public String getTable_no() {
        return this.table_no;
    }

    public String getTable_status() {
        return this.table_status;
    }

    public String getTable_status_name() {
        return this.table_status_name;
    }

    public List<TableAreaItem> getTypeList() {
        return this.typeList;
    }

    public String getType_id() {
        return this.type_id;
    }

    public String getType_name() {
        return this.type_name;
    }

    public String getUse_time() {
        return this.use_time;
    }
}
