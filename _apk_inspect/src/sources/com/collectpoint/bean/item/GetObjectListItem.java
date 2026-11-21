package com.collectpoint.bean.item;

import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class GetObjectListItem implements IPickerViewData {
    private String createName;
    private String createTime;
    private int id;
    private double latitude;
    private String locationPileNo;
    private double longitude;
    private String objectCode;
    private String objectName;
    private String objectNumber;
    private String objectTypeCode;
    private String objectTypeName;
    private String projectOrgCode;
    private String projectOrgName;
    private String roadLineCode;
    private String roadLineName;
    private String roadSegmentCode;
    private String status;
    private String typeCode;

    public String getCreateName() {
        return this.createName;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public int getId() {
        return this.id;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getLocationPileNo() {
        return this.locationPileNo;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getObjectCode() {
        return this.objectCode;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public String getObjectNumber() {
        return this.objectNumber;
    }

    public String getObjectTypeCode() {
        return this.objectTypeCode;
    }

    public String getObjectTypeName() {
        return this.objectTypeName;
    }

    public String getPickerViewText() {
        return this.objectName;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getProjectOrgName() {
        return this.projectOrgName;
    }

    public String getRoadLineCode() {
        return this.roadLineCode;
    }

    public String getRoadLineName() {
        return this.roadLineName;
    }

    public String getRoadSegmentCode() {
        return this.roadSegmentCode;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setObjectCode(String str) {
        this.objectCode = str;
    }

    public void setObjectName(String str) {
        this.objectName = str;
    }

    public void setObjectNumber(String str) {
        this.objectNumber = str;
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

    public void setProjectOrgName(String str) {
        this.projectOrgName = str;
    }

    public void setRoadLineCode(String str) {
        this.roadLineCode = str;
    }

    public void setRoadLineName(String str) {
        this.roadLineName = str;
    }

    public void setRoadSegmentCode(String str) {
        this.roadSegmentCode = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
