package com.collectpoint.bean.item;

import com.contrarywind.interfaces.IPickerViewData;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class ProjectOrgProcessAreaItem implements IPickerViewData {
    private List<ProjectOrgProcessAreaItem> children;
    private String id;
    private String parentId;
    private String regionType;
    private String title;

    public List<ProjectOrgProcessAreaItem> getChildren() {
        return this.children;
    }

    public String getId() {
        return this.id;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getPickerViewText() {
        return this.title;
    }

    public String getRegionType() {
        return this.regionType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setChildren(List<ProjectOrgProcessAreaItem> list) {
        this.children = list;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setRegionType(String str) {
        this.regionType = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
