package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class PersonnelTrajectoryListItem implements Serializable, Parcelable {
    public static final Parcelable.Creator<PersonnelTrajectoryListItem> CREATOR = new Parcelable.Creator<PersonnelTrajectoryListItem>() { // from class: com.collectpoint.bean.item.PersonnelTrajectoryListItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PersonnelTrajectoryListItem createFromParcel(Parcel parcel) {
            return new PersonnelTrajectoryListItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PersonnelTrajectoryListItem[] newArray(int i) {
            return new PersonnelTrajectoryListItem[i];
        }
    };
    private String address;
    private int battery;
    private String collectionDateTime;
    private String collectionTime;
    private String collectionTimeStr;
    private String deviceSequence;
    private int direction;
    private String fullName;
    private String gpsLat;
    private String gpsLng;
    private String gpsStatus;
    private String gpsStatusIcon;
    private String gpsStatusStr;
    private String icon;
    private String iconColor;
    private double lat;
    private String lengthTime;
    private double lng;
    private String mileage;
    private String mileageStr;
    private String mileageSum;
    private String mileageSumStr;
    private String projectOrgName;
    private int speed;
    private long startDateTime;
    private String startTime;
    private String startTimeStr;
    private String stateStr;
    private int stayTimeLength;
    private String stayTimeLengthStr;
    private int totalLengthTime;
    private String totalTimeLengthStr;
    private String userName;

    public PersonnelTrajectoryListItem() {
    }

    protected PersonnelTrajectoryListItem(Parcel parcel) {
        this.collectionDateTime = parcel.readString();
        this.projectOrgName = parcel.readString();
        this.deviceSequence = parcel.readString();
        this.collectionTime = parcel.readString();
        this.gpsStatusStr = parcel.readString();
        this.icon = parcel.readString();
        this.startTimeStr = parcel.readString();
        this.battery = parcel.readInt();
        this.mileageStr = parcel.readString();
        this.speed = parcel.readInt();
        this.totalTimeLengthStr = parcel.readString();
        this.gpsStatusIcon = parcel.readString();
        this.gpsStatus = parcel.readString();
        this.startTime = parcel.readString();
        this.lat = parcel.readDouble();
        this.mileage = parcel.readString();
        this.direction = parcel.readInt();
        this.lengthTime = parcel.readString();
        this.address = parcel.readString();
        this.lng = parcel.readDouble();
        this.fullName = parcel.readString();
        this.mileageSum = parcel.readString();
        this.userName = parcel.readString();
        this.collectionTimeStr = parcel.readString();
        this.mileageSumStr = parcel.readString();
        this.stateStr = parcel.readString();
        this.totalLengthTime = parcel.readInt();
        this.startDateTime = parcel.readLong();
        this.stayTimeLength = parcel.readInt();
        this.gpsLat = parcel.readString();
        this.iconColor = parcel.readString();
        this.gpsLng = parcel.readString();
        this.stayTimeLengthStr = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public int getBattery() {
        return this.battery;
    }

    public String getCollectionDateTime() {
        return this.collectionDateTime;
    }

    public String getCollectionTime() {
        return this.collectionTime;
    }

    public String getCollectionTimeStr() {
        return this.collectionTimeStr;
    }

    public String getDeviceSequence() {
        return this.deviceSequence;
    }

    public int getDirection() {
        return this.direction;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getGpsLat() {
        return this.gpsLat;
    }

    public String getGpsLng() {
        return this.gpsLng;
    }

    public String getGpsStatus() {
        return this.gpsStatus;
    }

    public String getGpsStatusIcon() {
        return this.gpsStatusIcon;
    }

    public String getGpsStatusStr() {
        return this.gpsStatusStr;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getIconColor() {
        return this.iconColor;
    }

    public double getLat() {
        return this.lat;
    }

    public String getLengthTime() {
        return this.lengthTime;
    }

    public double getLng() {
        return this.lng;
    }

    public String getMileage() {
        return this.mileage;
    }

    public String getMileageStr() {
        return this.mileageStr;
    }

    public String getMileageSum() {
        return this.mileageSum;
    }

    public String getMileageSumStr() {
        return this.mileageSumStr;
    }

    public String getProjectOrgName() {
        return this.projectOrgName;
    }

    public int getSpeed() {
        return this.speed;
    }

    public long getStartDateTime() {
        return this.startDateTime;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getStartTimeStr() {
        return this.startTimeStr;
    }

    public String getStateStr() {
        return this.stateStr;
    }

    public int getStayTimeLength() {
        return this.stayTimeLength;
    }

    public String getStayTimeLengthStr() {
        return this.stayTimeLengthStr;
    }

    public int getTotalLengthTime() {
        return this.totalLengthTime;
    }

    public String getTotalTimeLengthStr() {
        return this.totalTimeLengthStr;
    }

    public String getUserName() {
        return this.userName;
    }

    public void readFromParcel(Parcel parcel) {
        this.collectionDateTime = parcel.readString();
        this.projectOrgName = parcel.readString();
        this.deviceSequence = parcel.readString();
        this.collectionTime = parcel.readString();
        this.gpsStatusStr = parcel.readString();
        this.icon = parcel.readString();
        this.startTimeStr = parcel.readString();
        this.battery = parcel.readInt();
        this.mileageStr = parcel.readString();
        this.speed = parcel.readInt();
        this.totalTimeLengthStr = parcel.readString();
        this.gpsStatusIcon = parcel.readString();
        this.gpsStatus = parcel.readString();
        this.startTime = parcel.readString();
        this.lat = parcel.readDouble();
        this.mileage = parcel.readString();
        this.direction = parcel.readInt();
        this.lengthTime = parcel.readString();
        this.address = parcel.readString();
        this.lng = parcel.readDouble();
        this.fullName = parcel.readString();
        this.mileageSum = parcel.readString();
        this.userName = parcel.readString();
        this.collectionTimeStr = parcel.readString();
        this.mileageSumStr = parcel.readString();
        this.stateStr = parcel.readString();
        this.totalLengthTime = parcel.readInt();
        this.startDateTime = parcel.readLong();
        this.stayTimeLength = parcel.readInt();
        this.gpsLat = parcel.readString();
        this.iconColor = parcel.readString();
        this.gpsLng = parcel.readString();
        this.stayTimeLengthStr = parcel.readString();
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setBattery(int i) {
        this.battery = i;
    }

    public void setCollectionDateTime(String str) {
        this.collectionDateTime = str;
    }

    public void setCollectionTime(String str) {
        this.collectionTime = str;
    }

    public void setCollectionTimeStr(String str) {
        this.collectionTimeStr = str;
    }

    public void setDeviceSequence(String str) {
        this.deviceSequence = str;
    }

    public void setDirection(int i) {
        this.direction = i;
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public void setGpsLat(String str) {
        this.gpsLat = str;
    }

    public void setGpsLng(String str) {
        this.gpsLng = str;
    }

    public void setGpsStatus(String str) {
        this.gpsStatus = str;
    }

    public void setGpsStatusIcon(String str) {
        this.gpsStatusIcon = str;
    }

    public void setGpsStatusStr(String str) {
        this.gpsStatusStr = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIconColor(String str) {
        this.iconColor = str;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLengthTime(String str) {
        this.lengthTime = str;
    }

    public void setLng(double d) {
        this.lng = d;
    }

    public void setMileage(String str) {
        this.mileage = str;
    }

    public void setMileageStr(String str) {
        this.mileageStr = str;
    }

    public void setMileageSum(String str) {
        this.mileageSum = str;
    }

    public void setMileageSumStr(String str) {
        this.mileageSumStr = str;
    }

    public void setProjectOrgName(String str) {
        this.projectOrgName = str;
    }

    public void setSpeed(int i) {
        this.speed = i;
    }

    public void setStartDateTime(long j) {
        this.startDateTime = j;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setStartTimeStr(String str) {
        this.startTimeStr = str;
    }

    public void setStateStr(String str) {
        this.stateStr = str;
    }

    public void setStayTimeLength(int i) {
        this.stayTimeLength = i;
    }

    public void setStayTimeLengthStr(String str) {
        this.stayTimeLengthStr = str;
    }

    public void setTotalLengthTime(int i) {
        this.totalLengthTime = i;
    }

    public void setTotalTimeLengthStr(String str) {
        this.totalTimeLengthStr = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.collectionDateTime);
        parcel.writeString(this.projectOrgName);
        parcel.writeString(this.deviceSequence);
        parcel.writeString(this.collectionTime);
        parcel.writeString(this.gpsStatusStr);
        parcel.writeString(this.icon);
        parcel.writeString(this.startTimeStr);
        parcel.writeInt(this.battery);
        parcel.writeString(this.mileageStr);
        parcel.writeInt(this.speed);
        parcel.writeString(this.totalTimeLengthStr);
        parcel.writeString(this.gpsStatusIcon);
        parcel.writeString(this.gpsStatus);
        parcel.writeString(this.startTime);
        parcel.writeDouble(this.lat);
        parcel.writeString(this.mileage);
        parcel.writeInt(this.direction);
        parcel.writeString(this.lengthTime);
        parcel.writeString(this.address);
        parcel.writeDouble(this.lng);
        parcel.writeString(this.fullName);
        parcel.writeString(this.mileageSum);
        parcel.writeString(this.userName);
        parcel.writeString(this.collectionTimeStr);
        parcel.writeString(this.mileageSumStr);
        parcel.writeString(this.stateStr);
        parcel.writeInt(this.totalLengthTime);
        parcel.writeLong(this.startDateTime);
        parcel.writeInt(this.stayTimeLength);
        parcel.writeString(this.gpsLat);
        parcel.writeString(this.iconColor);
        parcel.writeString(this.gpsLng);
        parcel.writeString(this.stayTimeLengthStr);
    }
}
