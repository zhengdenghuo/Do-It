package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class FieldListItem implements Parcelable {
    public static final Parcelable.Creator<FieldListItem> CREATOR = new Parcelable.Creator<FieldListItem>() { // from class: com.collectpoint.bean.item.FieldListItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FieldListItem createFromParcel(Parcel parcel) {
            return new FieldListItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FieldListItem[] newArray(int i) {
            return new FieldListItem[i];
        }
    };
    private String fieldName;
    private String fieldType;
    private String fieldValue;
    private String ifRequired;
    private String infoName;
    private String infoValue;
    private String inputType;
    private String netPic;

    protected FieldListItem(Parcel parcel) {
        this.fieldName = parcel.readString();
        this.fieldValue = parcel.readString();
        this.fieldType = parcel.readString();
        this.infoValue = parcel.readString();
        this.infoName = parcel.readString();
        this.inputType = parcel.readString();
        this.netPic = parcel.readString();
    }

    public FieldListItem(String str, String str2, String str3) {
        this.fieldName = str;
        this.fieldValue = str2;
        this.fieldType = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String getFieldType() {
        return this.fieldType;
    }

    public String getFieldValue() {
        return this.fieldValue;
    }

    public String getIfRequired() {
        return this.ifRequired;
    }

    public String getInfoName() {
        return this.infoName;
    }

    public String getInfoValue() {
        return this.infoValue;
    }

    public String getInputType() {
        return this.inputType;
    }

    public String getNetPic() {
        return this.netPic;
    }

    public void setFieldName(String str) {
        this.fieldName = str;
    }

    public void setFieldType(String str) {
        this.fieldType = str;
    }

    public void setFieldValue(String str) {
        this.fieldValue = str;
    }

    public void setIfRequired(String str) {
        this.ifRequired = str;
    }

    public void setNetPic(String str) {
        this.netPic = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fieldName);
        parcel.writeString(this.fieldValue);
        parcel.writeString(this.fieldType);
        parcel.writeString(this.infoValue);
        parcel.writeString(this.infoName);
        parcel.writeString(this.inputType);
        parcel.writeString(this.netPic);
    }
}
