package com.collectpoint.bean.req;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class InsertCollectPointReq implements Parcelable {
    public static final Parcelable.Creator<InsertCollectPointReq> CREATOR = new Parcelable.Creator<InsertCollectPointReq>() { // from class: com.collectpoint.bean.req.InsertCollectPointReq.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InsertCollectPointReq createFromParcel(Parcel parcel) {
            return new InsertCollectPointReq(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InsertCollectPointReq[] newArray(int i) {
            return new InsertCollectPointReq[i];
        }
    };
    private String achieveMode;
    private String address;
    private double amapLat;
    private double amapLon;
    private List<AuxiliaryListReq> auxiliaryList;
    private String collectObjectCode;
    private String collectPointCode;
    private String collectPointName;
    private String collectTimeStamp;
    private String collectUserCode;
    private String collectUserName;
    private String frequency;
    private String userCode;

    protected InsertCollectPointReq(Parcel parcel) {
        this.userCode = parcel.readString();
        this.collectObjectCode = parcel.readString();
        this.achieveMode = parcel.readString();
        this.frequency = parcel.readString();
        this.amapLon = parcel.readDouble();
        this.amapLat = parcel.readDouble();
        this.address = parcel.readString();
        this.collectUserName = parcel.readString();
        this.collectUserCode = parcel.readString();
        this.collectTimeStamp = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.auxiliaryList = arrayList;
        parcel.readList(arrayList, AuxiliaryListReq.class.getClassLoader());
    }

    public InsertCollectPointReq(String str, String str2, String str3) {
        this.collectObjectCode = str;
        this.achieveMode = str2;
        this.frequency = str3;
    }

    public InsertCollectPointReq(String str, String str2, String str3, double d, double d2, String str4, String str5) {
        this.collectObjectCode = str;
        this.achieveMode = str2;
        this.collectPointName = str5;
        this.frequency = str3;
        this.amapLon = d;
        this.amapLat = d2;
        this.address = str4;
    }

    public InsertCollectPointReq(String str, String str2, String str3, String str4, double d, double d2, String str5, String str6, String str7, String str8) {
        this.userCode = str;
        this.collectObjectCode = str2;
        this.achieveMode = str3;
        this.collectPointName = str8;
        this.frequency = str4;
        this.amapLon = d;
        this.amapLat = d2;
        this.address = str5;
        this.collectUserName = str6;
        this.collectUserCode = str7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAchieveMode() {
        return this.achieveMode;
    }

    public String getAddress() {
        return this.address;
    }

    public double getAmapLat() {
        return this.amapLat;
    }

    public double getAmapLon() {
        return this.amapLon;
    }

    public List<AuxiliaryListReq> getAuxiliaryList() {
        return this.auxiliaryList;
    }

    public String getCollectObjectCode() {
        return this.collectObjectCode;
    }

    public String getCollectPointCode() {
        return this.collectPointCode;
    }

    public String getCollectPointName() {
        return this.collectPointName;
    }

    public String getCollectTimeStamp() {
        return this.collectTimeStamp;
    }

    public String getCollectUserCode() {
        return this.collectUserCode;
    }

    public String getCollectUserName() {
        return this.collectUserName;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void readFromParcel(Parcel parcel) {
        this.userCode = parcel.readString();
        this.collectObjectCode = parcel.readString();
        this.achieveMode = parcel.readString();
        this.frequency = parcel.readString();
        this.amapLon = parcel.readDouble();
        this.amapLat = parcel.readDouble();
        this.address = parcel.readString();
        this.collectUserName = parcel.readString();
        this.collectUserCode = parcel.readString();
        this.collectTimeStamp = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.auxiliaryList = arrayList;
        parcel.readList(arrayList, AuxiliaryListReq.class.getClassLoader());
    }

    public void setAchieveMode(String str) {
        this.achieveMode = str;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAmapLat(double d) {
        this.amapLat = d;
    }

    public void setAmapLon(double d) {
        this.amapLon = d;
    }

    public void setAuxiliaryList(List<AuxiliaryListReq> list) {
        this.auxiliaryList = list;
    }

    public void setCollectObjectCode(String str) {
        this.collectObjectCode = str;
    }

    public void setCollectPointCode(String str) {
        this.collectPointCode = str;
    }

    public void setCollectPointName(String str) {
        this.collectPointName = str;
    }

    public void setCollectTimeStamp(String str) {
        this.collectTimeStamp = str;
    }

    public void setCollectUserCode(String str) {
        this.collectUserCode = str;
    }

    public void setCollectUserName(String str) {
        this.collectUserName = str;
    }

    public void setFrequency(String str) {
        this.frequency = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userCode);
        parcel.writeString(this.collectObjectCode);
        parcel.writeString(this.achieveMode);
        parcel.writeString(this.frequency);
        parcel.writeDouble(this.amapLon);
        parcel.writeDouble(this.amapLat);
        parcel.writeString(this.address);
        parcel.writeString(this.collectUserName);
        parcel.writeString(this.collectUserCode);
        parcel.writeString(this.collectTimeStamp);
        parcel.writeList(this.auxiliaryList);
    }
}
