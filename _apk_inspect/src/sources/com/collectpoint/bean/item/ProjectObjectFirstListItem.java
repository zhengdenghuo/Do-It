package com.collectpoint.bean.item;

import com.collectpoint.utils.EmptyUtils;
import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class ProjectObjectFirstListItem implements IPickerViewData {
    private String appHomeIcon;
    private String appMapIcon;
    private String collectionCode;
    private String collectionName;
    private String firstCollectionCode;
    private String firstCollectionName;
    private String parentCollectionName;
    private String projectCollectionCode;

    public ProjectObjectFirstListItem(String str) {
        this.projectCollectionCode = str;
    }

    public ProjectObjectFirstListItem(String str, String str2, String str3) {
        this.projectCollectionCode = str;
        this.firstCollectionCode = str2;
        this.collectionName = str3;
    }

    public String getAppHomeIcon() {
        return this.appHomeIcon;
    }

    public String getAppMapIcon() {
        return this.appMapIcon;
    }

    public String getCollectionCode() {
        return this.collectionCode;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    public String getFirstCollectionCode() {
        return this.firstCollectionCode;
    }

    public String getFirstCollectionName() {
        return this.firstCollectionName;
    }

    public String getParentCollectionName() {
        return this.parentCollectionName;
    }

    public String getPickerViewText() {
        return EmptyUtils.isEmpty(this.parentCollectionName) ? this.collectionName : this.parentCollectionName + "-" + this.collectionName;
    }

    public String getProjectCollectionCode() {
        return this.projectCollectionCode;
    }
}
