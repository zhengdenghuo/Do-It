package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class PointItem implements Parcelable {
    public static final Parcelable.Creator<PointItem> CREATOR = new Parcelable.Creator<PointItem>() { // from class: com.collectpoint.bean.item.PointItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PointItem createFromParcel(Parcel parcel) {
            return new PointItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PointItem[] newArray(int i) {
            return new PointItem[i];
        }
    };
    private String address;
    private String collectionTime;
    private String latitude;
    private String longitude;

    protected PointItem(Parcel parcel) {
        this.address = parcel.readString();
        this.longitude = parcel.readString();
        this.latitude = parcel.readString();
        this.collectionTime = parcel.readString();
    }

    public PointItem(String str, String str2, String str3, String str4) {
        this.address = str2;
        this.longitude = str3;
        this.latitude = str4;
        this.collectionTime = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCollectionTime() {
        return this.collectionTime;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void readFromParcel(Parcel parcel) {
        this.address = parcel.readString();
        this.longitude = parcel.readString();
        this.latitude = parcel.readString();
        this.collectionTime = parcel.readString();
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCollectionTime(String str) {
        this.collectionTime = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.address);
        parcel.writeString(this.longitude);
        parcel.writeString(this.latitude);
        parcel.writeString(this.collectionTime);
    }
}
