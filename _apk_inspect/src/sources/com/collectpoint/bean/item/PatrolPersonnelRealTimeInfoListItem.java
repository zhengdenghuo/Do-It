package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class PatrolPersonnelRealTimeInfoListItem implements Parcelable {
    public static final Parcelable.Creator<PatrolPersonnelRealTimeInfoListItem> CREATOR = new Parcelable.Creator<PatrolPersonnelRealTimeInfoListItem>() { // from class: com.collectpoint.bean.item.PatrolPersonnelRealTimeInfoListItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PatrolPersonnelRealTimeInfoListItem createFromParcel(Parcel parcel) {
            return new PatrolPersonnelRealTimeInfoListItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PatrolPersonnelRealTimeInfoListItem[] newArray(int i) {
            return new PatrolPersonnelRealTimeInfoListItem[i];
        }
    };
    private String bindVehicle;
    private String deviceNo;
    private String lastLocationAddressName;
    private String lastLocationTime;
    private String lastLocationTimeName;
    private double latitude;
    private String loginAccount;
    private double longitude;
    private String onlineStatus;
    private String onlineStatusName;
    private String orgCode;
    private String projectOrgCode;
    private String userCode;
    private String userName;

    public PatrolPersonnelRealTimeInfoListItem() {
    }

    protected PatrolPersonnelRealTimeInfoListItem(Parcel parcel) {
        this.lastLocationTimeName = parcel.readString();
        this.loginAccount = parcel.readString();
        this.latitude = parcel.readDouble();
        this.onlineStatus = parcel.readString();
        this.lastLocationTime = parcel.readString();
        this.bindVehicle = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.deviceNo = parcel.readString();
        this.userName = parcel.readString();
        this.userCode = parcel.readString();
        this.lastLocationAddressName = parcel.readString();
        this.orgCode = parcel.readString();
        this.longitude = parcel.readDouble();
        this.onlineStatusName = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBindVehicle() {
        return this.bindVehicle;
    }

    public String getDeviceNo() {
        return this.deviceNo;
    }

    public String getLastLocationAddressName() {
        return this.lastLocationAddressName;
    }

    public String getLastLocationTime() {
        return this.lastLocationTime;
    }

    public String getLastLocationTimeName() {
        return this.lastLocationTimeName;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getLoginAccount() {
        return this.loginAccount;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getOnlineStatus() {
        return this.onlineStatus;
    }

    public String getOnlineStatusName() {
        return this.onlineStatusName;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setBindVehicle(String str) {
        this.bindVehicle = str;
    }

    public void setDeviceNo(String str) {
        this.deviceNo = str;
    }

    public void setLastLocationAddressName(String str) {
        this.lastLocationAddressName = str;
    }

    public void setLastLocationTime(String str) {
        this.lastLocationTime = str;
    }

    public void setLastLocationTimeName(String str) {
        this.lastLocationTimeName = str;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLoginAccount(String str) {
        this.loginAccount = str;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setOnlineStatus(String str) {
        this.onlineStatus = str;
    }

    public void setOnlineStatusName(String str) {
        this.onlineStatusName = str;
    }

    public void setOrgCode(String str) {
        this.orgCode = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.lastLocationTimeName);
        parcel.writeString(this.loginAccount);
        parcel.writeDouble(this.latitude);
        parcel.writeString(this.onlineStatus);
        parcel.writeString(this.lastLocationTime);
        parcel.writeString(this.bindVehicle);
        parcel.writeString(this.projectOrgCode);
        parcel.writeString(this.deviceNo);
        parcel.writeString(this.userName);
        parcel.writeString(this.userCode);
        parcel.writeString(this.lastLocationAddressName);
        parcel.writeString(this.orgCode);
        parcel.writeDouble(this.longitude);
        parcel.writeString(this.onlineStatusName);
    }
}
