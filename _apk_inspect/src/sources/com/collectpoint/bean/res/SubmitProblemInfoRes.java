package com.collectpoint.bean.res;

import com.collectpoint.bean.item.ProvinceListItem;
import com.collectpoint.bean.item.SortListItem;
import com.collectpoint.bean.item.TypeFieldListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class SubmitProblemInfoRes {
    private String manageUnitCode;
    private String manageUnitName;
    private int photoMinNumber;
    private String photoTips;
    private List<ProvinceListItem> provinceList;
    private String selfProcessOrgCode;
    private String selfProcessOrgName;
    private List<SortListItem> sortList;
    private String typeCode;
    private List<TypeFieldListItem> typeFieldList;
    private String typeName;

    public String getManageUnitCode() {
        return this.manageUnitCode;
    }

    public String getManageUnitName() {
        return this.manageUnitName;
    }

    public int getPhotoMinNumber() {
        return this.photoMinNumber;
    }

    public String getPhotoTips() {
        return this.photoTips;
    }

    public List<ProvinceListItem> getProvinceList() {
        return this.provinceList;
    }

    public String getSelfProcessOrgCode() {
        return this.selfProcessOrgCode;
    }

    public String getSelfProcessOrgName() {
        return this.selfProcessOrgName;
    }

    public List<SortListItem> getSortList() {
        return this.sortList;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public List<TypeFieldListItem> getTypeFieldList() {
        return this.typeFieldList;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setManageUnitCode(String str) {
        this.manageUnitCode = str;
    }

    public void setManageUnitName(String str) {
        this.manageUnitName = str;
    }

    public void setPhotoMinNumber(int i) {
        this.photoMinNumber = i;
    }

    public void setPhotoTips(String str) {
        this.photoTips = str;
    }

    public void setProvinceList(List<ProvinceListItem> list) {
        this.provinceList = list;
    }

    public void setSelfProcessOrgCode(String str) {
        this.selfProcessOrgCode = str;
    }

    public void setSelfProcessOrgName(String str) {
        this.selfProcessOrgName = str;
    }

    public void setSortList(List<SortListItem> list) {
        this.sortList = list;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }

    public void setTypeFieldList(List<TypeFieldListItem> list) {
        this.typeFieldList = list;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }
}
