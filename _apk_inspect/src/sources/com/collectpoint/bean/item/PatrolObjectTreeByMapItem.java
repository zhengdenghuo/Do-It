package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class PatrolObjectTreeByMapItem implements Parcelable {
    public static final Parcelable.Creator<PatrolObjectTreeByMapItem> CREATOR = new Parcelable.Creator<PatrolObjectTreeByMapItem>() { // from class: com.collectpoint.bean.item.PatrolObjectTreeByMapItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PatrolObjectTreeByMapItem createFromParcel(Parcel parcel) {
            return new PatrolObjectTreeByMapItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PatrolObjectTreeByMapItem[] newArray(int i) {
            return new PatrolObjectTreeByMapItem[i];
        }
    };
    private boolean checked;
    private String cityCode;
    private String createCode;
    private String createTime;
    private String districtCode;
    private String id;
    private String name;
    private String objectCode;
    private String objectName;
    private String orgCode;
    private String parentCode;
    private String parentId;
    private String provinceCode;
    private String status;
    private String title;
    private String townVillageCodes;
    private String typeCode;
    private String typeName;

    public PatrolObjectTreeByMapItem() {
        this.checked = false;
    }

    protected PatrolObjectTreeByMapItem(Parcel parcel) {
        this.checked = false;
        this.objectCode = parcel.readString();
        this.districtCode = parcel.readString();
        this.provinceCode = parcel.readString();
        this.cityCode = parcel.readString();
        this.typeName = parcel.readString();
        this.townVillageCodes = parcel.readString();
        this.title = parcel.readString();
        this.parentId = parcel.readString();
        this.typeCode = parcel.readString();
        this.parentCode = parcel.readString();
        this.createTime = parcel.readString();
        this.orgCode = parcel.readString();
        this.name = parcel.readString();
        this.objectName = parcel.readString();
        this.id = parcel.readString();
        this.createCode = parcel.readString();
        this.status = parcel.readString();
        this.checked = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getCreateCode() {
        return this.createCode;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getDistrictCode() {
        return this.districtCode;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getObjectCode() {
        return this.objectCode;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getProvinceCode() {
        return this.provinceCode;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTownVillageCodes() {
        return this.townVillageCodes;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public void setCreateCode(String str) {
        this.createCode = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setDistrictCode(String str) {
        this.districtCode = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setObjectCode(String str) {
        this.objectCode = str;
    }

    public void setObjectName(String str) {
        this.objectName = str;
    }

    public void setOrgCode(String str) {
        this.orgCode = str;
    }

    public void setParentCode(String str) {
        this.parentCode = str;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setProvinceCode(String str) {
        this.provinceCode = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTownVillageCodes(String str) {
        this.townVillageCodes = str;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.objectCode);
        parcel.writeString(this.districtCode);
        parcel.writeString(this.provinceCode);
        parcel.writeString(this.cityCode);
        parcel.writeString(this.typeName);
        parcel.writeString(this.townVillageCodes);
        parcel.writeString(this.title);
        parcel.writeString(this.parentId);
        parcel.writeString(this.typeCode);
        parcel.writeString(this.parentCode);
        parcel.writeString(this.createTime);
        parcel.writeString(this.orgCode);
        parcel.writeString(this.name);
        parcel.writeString(this.objectName);
        parcel.writeString(this.id);
        parcel.writeString(this.createCode);
        parcel.writeString(this.status);
        parcel.writeByte(this.checked ? (byte) 1 : (byte) 0);
    }
}
