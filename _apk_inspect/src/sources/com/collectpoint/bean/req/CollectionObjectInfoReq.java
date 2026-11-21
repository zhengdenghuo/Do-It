package com.collectpoint.bean.req;

import com.collectpoint.bean.item.InfoNameListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class CollectionObjectInfoReq {
    private String appHomeIcon;
    private String appMapIcon;
    private String collectionCode;
    private String ifRequired;
    private String infoName;
    private String inputType;
    private String inputTypeName;
    private List<InfoNameListItem> maintainList;

    public String getAppHomeIcon() {
        return this.appHomeIcon;
    }

    public String getAppMapIcon() {
        return this.appMapIcon;
    }

    public String getCollectionCode() {
        return this.collectionCode;
    }

    public String getIfRequired() {
        return this.ifRequired;
    }

    public String getInfoName() {
        return this.infoName;
    }

    public List<InfoNameListItem> getInfoNameList() {
        return this.maintainList;
    }

    public String getInputType() {
        return this.inputType;
    }

    public String getInputTypeName() {
        return this.inputTypeName;
    }
}
