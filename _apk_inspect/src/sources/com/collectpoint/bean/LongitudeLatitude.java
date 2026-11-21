package com.collectpoint.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class LongitudeLatitude implements Parcelable {
    public static final Parcelable.Creator<LongitudeLatitude> CREATOR = new Parcelable.Creator<LongitudeLatitude>() { // from class: com.collectpoint.bean.LongitudeLatitude.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LongitudeLatitude createFromParcel(Parcel parcel) {
            return new LongitudeLatitude(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LongitudeLatitude[] newArray(int i) {
            return new LongitudeLatitude[i];
        }
    };
    private double latitude;
    private double longitude;

    public LongitudeLatitude(double d, double d2) {
        this.longitude = d;
        this.latitude = d2;
    }

    protected LongitudeLatitude(Parcel parcel) {
        this.longitude = parcel.readDouble();
        this.latitude = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
    }
}
