package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class PatrolMapPatrolDataListItem implements Parcelable {
    public static final Parcelable.Creator<PatrolMapPatrolDataListItem> CREATOR = new Parcelable.Creator<PatrolMapPatrolDataListItem>() { // from class: com.collectpoint.bean.item.PatrolMapPatrolDataListItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PatrolMapPatrolDataListItem createFromParcel(Parcel parcel) {
            return new PatrolMapPatrolDataListItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PatrolMapPatrolDataListItem[] newArray(int i) {
            return new PatrolMapPatrolDataListItem[i];
        }
    };
    private String code;
    private String createTime;
    private String createTimeName;
    private String imgPath;
    private String latitude;
    private String longitude;
    private String objectType;
    private String orgCode;
    private String specificLocation;
    private String typeName;
    private String typeSort;

    public PatrolMapPatrolDataListItem() {
    }

    protected PatrolMapPatrolDataListItem(Parcel parcel) {
        this.code = parcel.readString();
        this.createTime = parcel.readString();
        this.orgCode = parcel.readString();
        this.latitude = parcel.readString();
        this.imgPath = parcel.readString();
        this.typeSort = parcel.readString();
        this.specificLocation = parcel.readString();
        this.createTimeName = parcel.readString();
        this.objectType = parcel.readString();
        this.longitude = parcel.readString();
        this.typeName = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return this.code;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getCreateTimeName() {
        return this.createTimeName;
    }

    public String getImgPath() {
        return this.imgPath;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getObjectType() {
        return this.objectType;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public String getSpecificLocation() {
        return this.specificLocation;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public String getTypeSort() {
        return this.typeSort;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setCreateTimeName(String str) {
        this.createTimeName = str;
    }

    public void setImgPath(String str) {
        this.imgPath = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setObjectType(String str) {
        this.objectType = str;
    }

    public void setOrgCode(String str) {
        this.orgCode = str;
    }

    public void setSpecificLocation(String str) {
        this.specificLocation = str;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }

    public void setTypeSort(String str) {
        this.typeSort = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.code);
        parcel.writeString(this.createTime);
        parcel.writeString(this.orgCode);
        parcel.writeString(this.latitude);
        parcel.writeString(this.imgPath);
        parcel.writeString(this.typeSort);
        parcel.writeString(this.specificLocation);
        parcel.writeString(this.createTimeName);
        parcel.writeString(this.objectType);
        parcel.writeString(this.longitude);
        parcel.writeString(this.typeName);
    }
}
