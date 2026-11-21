package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class CollectionTodaItem implements Parcelable {
    public static final Parcelable.Creator<CollectionTodaItem> CREATOR = new Parcelable.Creator<CollectionTodaItem>() { // from class: com.collectpoint.bean.item.CollectionTodaItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CollectionTodaItem createFromParcel(Parcel parcel) {
            return new CollectionTodaItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CollectionTodaItem[] newArray(int i) {
            return new CollectionTodaItem[i];
        }
    };
    private String address;
    private String appMapIcon;
    private String collectionCode;
    private String collectionName;
    private String collectionPointCode;
    private String collectionPointName;
    private String collectionTime;
    private String collectionType;
    private String collectionTypeName;
    private String createTime;
    private List<FieldListItem> fieldList;
    private String firstCollectionCode;
    private String firstCollectionName;
    private String gatherer;
    private String isGoing;
    private String latitude;
    private String longitude;
    private String originalPointName;
    private List<PointItem> pointList;
    private String pointNumber;
    private String projectCollectionCode;
    private String projectOrgCode;
    private String recaptureReason;
    private String recordCode;
    private String recordStatus;
    private String recordStatusName;
    private String regionName;
    private String showCloud;

    public CollectionTodaItem() {
    }

    protected CollectionTodaItem(Parcel parcel) {
        this.collectionTypeName = parcel.readString();
        this.recordStatusName = parcel.readString();
        this.regionName = parcel.readString();
        this.gatherer = parcel.readString();
        this.collectionPointName = parcel.readString();
        this.collectionPointCode = parcel.readString();
        this.collectionTime = parcel.readString();
        this.createTime = parcel.readString();
        this.recaptureReason = parcel.readString();
        this.address = parcel.readString();
        this.recordStatus = parcel.readString();
        this.longitude = parcel.readString();
        this.latitude = parcel.readString();
        this.appMapIcon = parcel.readString();
        this.recordCode = parcel.readString();
        this.collectionType = parcel.readString();
        this.collectionCode = parcel.readString();
        this.pointNumber = parcel.readString();
        this.projectCollectionCode = parcel.readString();
        this.firstCollectionCode = parcel.readString();
        this.firstCollectionName = parcel.readString();
        this.fieldList = parcel.createTypedArrayList(FieldListItem.CREATOR);
        this.pointList = parcel.createTypedArrayList(PointItem.CREATOR);
    }

    public CollectionTodaItem(String str, String str2, String str3, String str4) {
        this.collectionTime = str;
        this.address = str2;
        this.longitude = str3;
        this.latitude = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
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

    public String getCollectionPointCode() {
        return this.collectionPointCode;
    }

    public String getCollectionPointName() {
        return this.collectionPointName;
    }

    public String getCollectionTime() {
        return this.collectionTime;
    }

    public String getCollectionType() {
        return this.collectionType;
    }

    public String getCollectionTypeName() {
        return this.collectionTypeName;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public List<FieldListItem> getFieldList() {
        return this.fieldList;
    }

    public String getFirstCollectionCode() {
        return this.firstCollectionCode;
    }

    public String getFirstCollectionName() {
        return this.firstCollectionName;
    }

    public String getGatherer() {
        return this.gatherer;
    }

    public String getIsGoing() {
        return this.isGoing;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getOriginalPointName() {
        return this.originalPointName;
    }

    public List<PointItem> getPointList() {
        return this.pointList;
    }

    public String getPointNumber() {
        return this.pointNumber;
    }

    public String getProjectCollectionCode() {
        return this.projectCollectionCode;
    }

    public String getRecaptureReason() {
        return this.recaptureReason;
    }

    public String getRecordCode() {
        return this.recordCode;
    }

    public String getRecordStatus() {
        return this.recordStatus;
    }

    public String getRecordStatusName() {
        return this.recordStatusName;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public String getShowCloud() {
        return this.showCloud;
    }

    public void readFromParcel(Parcel parcel) {
        this.collectionTypeName = parcel.readString();
        this.recordStatusName = parcel.readString();
        this.regionName = parcel.readString();
        this.gatherer = parcel.readString();
        this.collectionPointName = parcel.readString();
        this.collectionPointCode = parcel.readString();
        this.collectionTime = parcel.readString();
        this.createTime = parcel.readString();
        this.recaptureReason = parcel.readString();
        this.address = parcel.readString();
        this.recordStatus = parcel.readString();
        this.longitude = parcel.readString();
        this.latitude = parcel.readString();
        this.appMapIcon = parcel.readString();
        this.recordCode = parcel.readString();
        this.collectionType = parcel.readString();
        this.collectionCode = parcel.readString();
        this.pointNumber = parcel.readString();
        this.projectCollectionCode = parcel.readString();
        this.firstCollectionCode = parcel.readString();
        this.firstCollectionName = parcel.readString();
        this.fieldList = parcel.createTypedArrayList(FieldListItem.CREATOR);
        this.pointList = parcel.createTypedArrayList(PointItem.CREATOR);
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAppMapIcon(String str) {
        this.appMapIcon = str;
    }

    public void setCollectionCode(String str) {
        this.collectionCode = str;
    }

    public void setCollectionName(String str) {
        this.collectionName = str;
    }

    public void setCollectionPointCode(String str) {
        this.collectionPointCode = str;
    }

    public void setCollectionPointName(String str) {
        this.collectionPointName = str;
    }

    public void setCollectionTime(String str) {
        this.collectionTime = str;
    }

    public void setCollectionType(String str) {
        this.collectionType = str;
    }

    public void setCollectionTypeName(String str) {
        this.collectionTypeName = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setFieldList(List<FieldListItem> list) {
        this.fieldList = list;
    }

    public void setFirstCollectionCode(String str) {
        this.firstCollectionCode = str;
    }

    public void setFirstCollectionName(String str) {
        this.firstCollectionName = str;
    }

    public void setGatherer(String str) {
        this.gatherer = str;
    }

    public void setIsGoing(String str) {
        this.isGoing = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setPointList(List<PointItem> list) {
        this.pointList = list;
    }

    public void setPointNumber(String str) {
        this.pointNumber = str;
    }

    public void setProjectCollectionCode(String str) {
        this.projectCollectionCode = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setRecaptureReason(String str) {
        this.recaptureReason = str;
    }

    public void setRecordCode(String str) {
        this.recordCode = str;
    }

    public void setRecordStatus(String str) {
        this.recordStatus = str;
    }

    public void setRecordStatusName(String str) {
        this.recordStatusName = str;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public void setShowCloud(String str) {
        this.showCloud = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.collectionTypeName);
        parcel.writeString(this.recordStatusName);
        parcel.writeString(this.regionName);
        parcel.writeString(this.gatherer);
        parcel.writeString(this.collectionPointName);
        parcel.writeString(this.collectionPointCode);
        parcel.writeString(this.collectionTime);
        parcel.writeString(this.createTime);
        parcel.writeString(this.recaptureReason);
        parcel.writeString(this.address);
        parcel.writeString(this.recordStatus);
        parcel.writeString(this.longitude);
        parcel.writeString(this.latitude);
        parcel.writeString(this.appMapIcon);
        parcel.writeString(this.recordCode);
        parcel.writeString(this.collectionType);
        parcel.writeString(this.collectionCode);
        parcel.writeString(this.pointNumber);
        parcel.writeString(this.projectCollectionCode);
        parcel.writeString(this.firstCollectionCode);
        parcel.writeString(this.firstCollectionName);
        parcel.writeTypedList(this.fieldList);
        parcel.writeList(this.pointList);
    }
}
