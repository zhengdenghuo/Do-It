package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class PersonnelLocationListItem implements Parcelable {
    public static final Parcelable.Creator<PersonnelLocationListItem> CREATOR = new Parcelable.Creator<PersonnelLocationListItem>() { // from class: com.collectpoint.bean.item.PersonnelLocationListItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PersonnelLocationListItem createFromParcel(Parcel parcel) {
            return new PersonnelLocationListItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PersonnelLocationListItem[] newArray(int i) {
            return new PersonnelLocationListItem[i];
        }
    };
    private String address;
    private String battery;
    private String bindVehicle;
    private String collectionTimeStr;
    private String createCode;
    private String createTime;
    private String createTimeStr;
    private String deviceNo;
    private String deviceSequence;
    private String fullName;
    private String gpsStatus;
    private String gpsStatusIcon;
    private String gpsStatusStr;
    private String icon;
    private String iconColor;
    private int id;
    private String intervalTimeStr;
    private String lat;
    private String lng;
    private String loginAccount;
    private String mileageSumStr;
    private String orgCode;
    private String orgName;
    private String projectOrgCode;
    private String projectOrgName;
    private String roleTypeCode;
    private String roleTypeName;
    private int speed;
    private String status;
    private String stayTimeLengthStr;
    private String totalLengthTimeStr;
    private String townNames;
    private String updateCode;
    private String updateTime;
    private String userCode;
    private String userName;
    private String userPhone;
    private String userPhoto;
    private String workStatus;

    public PersonnelLocationListItem() {
    }

    protected PersonnelLocationListItem(Parcel parcel) {
        this.projectOrgName = parcel.readString();
        this.loginAccount = parcel.readString();
        this.updateCode = parcel.readString();
        this.deviceSequence = parcel.readString();
        this.userPhoto = parcel.readString();
        this.userPhone = parcel.readString();
        this.gpsStatusStr = parcel.readString();
        this.icon = parcel.readString();
        this.bindVehicle = parcel.readString();
        this.battery = parcel.readString();
        this.userCode = parcel.readString();
        this.townNames = parcel.readString();
        this.speed = parcel.readInt();
        this.gpsStatusIcon = parcel.readString();
        this.orgCode = parcel.readString();
        this.gpsStatus = parcel.readString();
        this.intervalTimeStr = parcel.readString();
        this.id = parcel.readInt();
        this.createCode = parcel.readString();
        this.roleTypeCode = parcel.readString();
        this.createTimeStr = parcel.readString();
        this.lat = parcel.readString();
        this.workStatus = parcel.readString();
        this.orgName = parcel.readString();
        this.address = parcel.readString();
        this.lng = parcel.readString();
        this.fullName = parcel.readString();
        this.updateTime = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.deviceNo = parcel.readString();
        this.userName = parcel.readString();
        this.collectionTimeStr = parcel.readString();
        this.mileageSumStr = parcel.readString();
        this.roleTypeName = parcel.readString();
        this.createTime = parcel.readString();
        this.iconColor = parcel.readString();
        this.totalLengthTimeStr = parcel.readString();
        this.stayTimeLengthStr = parcel.readString();
        this.status = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public String getBattery() {
        return this.battery;
    }

    public String getBindVehicle() {
        return this.bindVehicle;
    }

    public String getCollectionTimeStr() {
        return this.collectionTimeStr;
    }

    public String getCreateCode() {
        return this.createCode;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getCreateTimeStr() {
        return this.createTimeStr;
    }

    public String getDeviceNo() {
        return this.deviceNo;
    }

    public String getDeviceSequence() {
        return this.deviceSequence;
    }

    public String getFullName() {
        return this.fullName;
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

    public int getId() {
        return this.id;
    }

    public String getIntervalTimeStr() {
        return this.intervalTimeStr;
    }

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
    }

    public String getLoginAccount() {
        return this.loginAccount;
    }

    public String getMileageSumStr() {
        return this.mileageSumStr;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public String getOrgName() {
        return this.orgName;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getProjectOrgName() {
        return this.projectOrgName;
    }

    public String getRoleTypeCode() {
        return this.roleTypeCode;
    }

    public String getRoleTypeName() {
        return this.roleTypeName;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStayTimeLengthStr() {
        return this.stayTimeLengthStr;
    }

    public String getTotalLengthTimeStr() {
        return this.totalLengthTimeStr;
    }

    public String getTownNames() {
        return this.townNames;
    }

    public String getUpdateCode() {
        return this.updateCode;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserPhone() {
        return this.userPhone;
    }

    public String getUserPhoto() {
        return this.userPhoto;
    }

    public String getWorkStatus() {
        return this.workStatus;
    }

    public void readFromParcel(Parcel parcel) {
        this.projectOrgName = parcel.readString();
        this.loginAccount = parcel.readString();
        this.updateCode = parcel.readString();
        this.deviceSequence = parcel.readString();
        this.userPhoto = parcel.readString();
        this.userPhone = parcel.readString();
        this.gpsStatusStr = parcel.readString();
        this.icon = parcel.readString();
        this.bindVehicle = parcel.readString();
        this.battery = parcel.readString();
        this.userCode = parcel.readString();
        this.townNames = parcel.readString();
        this.speed = parcel.readInt();
        this.gpsStatusIcon = parcel.readString();
        this.orgCode = parcel.readString();
        this.gpsStatus = parcel.readString();
        this.intervalTimeStr = parcel.readString();
        this.id = parcel.readInt();
        this.createCode = parcel.readString();
        this.roleTypeCode = parcel.readString();
        this.createTimeStr = parcel.readString();
        this.lat = parcel.readString();
        this.workStatus = parcel.readString();
        this.orgName = parcel.readString();
        this.address = parcel.readString();
        this.lng = parcel.readString();
        this.fullName = parcel.readString();
        this.updateTime = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.deviceNo = parcel.readString();
        this.userName = parcel.readString();
        this.collectionTimeStr = parcel.readString();
        this.mileageSumStr = parcel.readString();
        this.roleTypeName = parcel.readString();
        this.createTime = parcel.readString();
        this.iconColor = parcel.readString();
        this.totalLengthTimeStr = parcel.readString();
        this.stayTimeLengthStr = parcel.readString();
        this.status = parcel.readString();
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setBattery(String str) {
        this.battery = str;
    }

    public void setBindVehicle(String str) {
        this.bindVehicle = str;
    }

    public void setCollectionTimeStr(String str) {
        this.collectionTimeStr = str;
    }

    public void setCreateCode(String str) {
        this.createCode = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setCreateTimeStr(String str) {
        this.createTimeStr = str;
    }

    public void setDeviceNo(String str) {
        this.deviceNo = str;
    }

    public void setDeviceSequence(String str) {
        this.deviceSequence = str;
    }

    public void setFullName(String str) {
        this.fullName = str;
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

    public void setId(int i) {
        this.id = i;
    }

    public void setIntervalTimeStr(String str) {
        this.intervalTimeStr = str;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public void setLoginAccount(String str) {
        this.loginAccount = str;
    }

    public void setMileageSumStr(String str) {
        this.mileageSumStr = str;
    }

    public void setOrgCode(String str) {
        this.orgCode = str;
    }

    public void setOrgName(String str) {
        this.orgName = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setProjectOrgName(String str) {
        this.projectOrgName = str;
    }

    public void setRoleTypeCode(String str) {
        this.roleTypeCode = str;
    }

    public void setRoleTypeName(String str) {
        this.roleTypeName = str;
    }

    public void setSpeed(int i) {
        this.speed = i;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setStayTimeLengthStr(String str) {
        this.stayTimeLengthStr = str;
    }

    public void setTotalLengthTimeStr(String str) {
        this.totalLengthTimeStr = str;
    }

    public void setTownNames(String str) {
        this.townNames = str;
    }

    public void setUpdateCode(String str) {
        this.updateCode = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setUserPhone(String str) {
        this.userPhone = str;
    }

    public void setUserPhoto(String str) {
        this.userPhoto = str;
    }

    public void setWorkStatus(String str) {
        this.workStatus = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.projectOrgName);
        parcel.writeString(this.loginAccount);
        parcel.writeString(this.updateCode);
        parcel.writeString(this.deviceSequence);
        parcel.writeString(this.userPhoto);
        parcel.writeString(this.userPhone);
        parcel.writeString(this.gpsStatusStr);
        parcel.writeString(this.icon);
        parcel.writeString(this.bindVehicle);
        parcel.writeString(this.battery);
        parcel.writeString(this.userCode);
        parcel.writeString(this.townNames);
        parcel.writeInt(this.speed);
        parcel.writeString(this.gpsStatusIcon);
        parcel.writeString(this.orgCode);
        parcel.writeString(this.gpsStatus);
        parcel.writeString(this.intervalTimeStr);
        parcel.writeInt(this.id);
        parcel.writeString(this.createCode);
        parcel.writeString(this.roleTypeCode);
        parcel.writeString(this.createTimeStr);
        parcel.writeString(this.lat);
        parcel.writeString(this.workStatus);
        parcel.writeString(this.orgName);
        parcel.writeString(this.address);
        parcel.writeString(this.lng);
        parcel.writeString(this.fullName);
        parcel.writeString(this.updateTime);
        parcel.writeString(this.projectOrgCode);
        parcel.writeString(this.deviceNo);
        parcel.writeString(this.userName);
        parcel.writeString(this.collectionTimeStr);
        parcel.writeString(this.mileageSumStr);
        parcel.writeString(this.roleTypeName);
        parcel.writeString(this.createTime);
        parcel.writeString(this.iconColor);
        parcel.writeString(this.totalLengthTimeStr);
        parcel.writeString(this.stayTimeLengthStr);
        parcel.writeString(this.status);
    }
}
