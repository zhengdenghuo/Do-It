package com.collectpoint.utils.adapter;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class BaseCompany implements Serializable, Parcelable {
    public static final Parcelable.Creator<BaseCompany> CREATOR = new Parcelable.Creator<BaseCompany>() { // from class: com.collectpoint.utils.adapter.BaseCompany.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseCompany createFromParcel(Parcel parcel) {
            return new BaseCompany(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseCompany[] newArray(int i) {
            return new BaseCompany[i];
        }
    };
    private static final long serialVersionUID = 1825913344212097269L;
    private int Id;
    private String attributeCode;
    private String companyID;
    private int companyLevel;
    private String companyName;
    private boolean hasChildCompany;
    private String level;
    private String measureUnit;
    private String name;
    private String parentCompanyID;
    private String parentId;
    private String parentName;
    private String value;

    public BaseCompany() {
        this.hasChildCompany = false;
    }

    protected BaseCompany(Parcel parcel) {
        this.companyID = parcel.readString();
        this.companyName = parcel.readString();
        this.parentId = parcel.readString();
        this.parentName = parcel.readString();
        this.companyLevel = parcel.readInt();
        this.parentCompanyID = parcel.readString();
        this.hasChildCompany = parcel.readByte() != 0;
        this.attributeCode = parcel.readString();
        this.name = parcel.readString();
        this.value = parcel.readString();
        this.level = parcel.readString();
        this.Id = parcel.readInt();
        this.measureUnit = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.companyID, ((BaseCompany) obj).companyID);
    }

    public String getAttributeCode() {
        return this.attributeCode;
    }

    public String getCompanyID() {
        return this.companyID;
    }

    public int getCompanyLevel() {
        return this.companyLevel;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public int getId() {
        return this.Id;
    }

    public String getLevel() {
        return this.level;
    }

    public String getMeasureUnit() {
        return this.measureUnit;
    }

    public String getName() {
        return this.name;
    }

    public String getParentCompanyID() {
        return this.parentCompanyID;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getParentName() {
        return this.parentName;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isHasChildCompany() {
        return this.hasChildCompany;
    }

    public void readFromParcel(Parcel parcel) {
        this.companyID = parcel.readString();
        this.companyName = parcel.readString();
        this.parentId = parcel.readString();
        this.parentName = parcel.readString();
        this.companyLevel = parcel.readInt();
        this.parentCompanyID = parcel.readString();
        this.hasChildCompany = parcel.readByte() != 0;
        this.attributeCode = parcel.readString();
        this.name = parcel.readString();
        this.value = parcel.readString();
        this.level = parcel.readString();
        this.Id = parcel.readInt();
        this.measureUnit = parcel.readString();
    }

    public void setAttributeCode(String str) {
        this.attributeCode = str;
    }

    public void setCompanyID(String str) {
        this.companyID = str;
    }

    public void setCompanyLevel(int i) {
        this.companyLevel = i;
    }

    public void setCompanyName(String str) {
        this.companyName = str;
    }

    public void setHasChildCompany(boolean z) {
        this.hasChildCompany = z;
    }

    public void setId(int i) {
        this.Id = i;
    }

    public void setLevel(String str) {
        this.level = str;
    }

    public void setMeasureUnit(String str) {
        this.measureUnit = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParentCompanyID(String str) {
        this.parentCompanyID = str;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setParentName(String str) {
        this.parentName = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.companyID);
        parcel.writeString(this.companyName);
        parcel.writeString(this.parentId);
        parcel.writeString(this.parentName);
        parcel.writeInt(this.companyLevel);
        parcel.writeString(this.parentCompanyID);
        parcel.writeByte(this.hasChildCompany ? (byte) 1 : (byte) 0);
        parcel.writeString(this.attributeCode);
        parcel.writeString(this.name);
        parcel.writeString(this.value);
        parcel.writeString(this.level);
        parcel.writeInt(this.Id);
        parcel.writeString(this.measureUnit);
    }
}
