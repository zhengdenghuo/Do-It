package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class CurrentDatePatrolPersonnelSignInTaskListItem implements Parcelable {
    public static final Parcelable.Creator<CurrentDatePatrolPersonnelSignInTaskListItem> CREATOR = new Parcelable.Creator<CurrentDatePatrolPersonnelSignInTaskListItem>() { // from class: com.collectpoint.bean.item.CurrentDatePatrolPersonnelSignInTaskListItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CurrentDatePatrolPersonnelSignInTaskListItem createFromParcel(Parcel parcel) {
            return new CurrentDatePatrolPersonnelSignInTaskListItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CurrentDatePatrolPersonnelSignInTaskListItem[] newArray(int i) {
            return new CurrentDatePatrolPersonnelSignInTaskListItem[i];
        }
    };
    private String address;
    private String createTime;
    private double distance;
    private String distanceStr;
    private int hasSignInFrequency;
    private String ifUploadPhoto;
    private double latitude;
    private double longitude;
    private String nextSignTimeStr;
    private String personnelCode;
    private String personnelName;
    private String planSignInDateStr;
    private String planSignInEndDate;
    private String planSignInStartDate;
    private String planSignInStr;
    private String projectOrgCode;
    private String projectOrgName;
    private double radius;
    private String signInDate;
    private int signInFrequency;
    private int signInNumber;
    private String signInPeriodType;
    private String signInPlanCode;
    private String signInPointCode;
    private String signInPointName;
    private String signInProgress;
    private String signInRecordCode;
    private String signInStatus;
    private String signInStatusStr;
    private String signInTaskCode;
    private List<String> signInTimeList;
    private String signInTimeStr;
    private String status;
    private String temporarySignIn;

    public CurrentDatePatrolPersonnelSignInTaskListItem() {
    }

    protected CurrentDatePatrolPersonnelSignInTaskListItem(Parcel parcel) {
        this.planSignInEndDate = parcel.readString();
        this.projectOrgName = parcel.readString();
        this.signInNumber = parcel.readInt();
        this.distance = parcel.readDouble();
        this.ifUploadPhoto = parcel.readString();
        this.latitude = parcel.readDouble();
        this.signInPeriodType = parcel.readString();
        this.signInPointName = parcel.readString();
        this.signInFrequency = parcel.readInt();
        this.signInStatusStr = parcel.readString();
        this.hasSignInFrequency = parcel.readInt();
        this.radius = parcel.readDouble();
        this.temporarySignIn = parcel.readString();
        this.longitude = parcel.readDouble();
        this.planSignInDateStr = parcel.readString();
        this.signInTaskCode = parcel.readString();
        this.address = parcel.readString();
        this.personnelCode = parcel.readString();
        this.signInProgress = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.planSignInStartDate = parcel.readString();
        this.signInStatus = parcel.readString();
        this.signInPlanCode = parcel.readString();
        this.planSignInStr = parcel.readString();
        this.distanceStr = parcel.readString();
        this.createTime = parcel.readString();
        this.signInPointCode = parcel.readString();
        this.status = parcel.readString();
        this.signInTimeList = parcel.createStringArrayList();
        this.nextSignTimeStr = parcel.readString();
        this.signInTimeStr = parcel.readString();
        this.signInRecordCode = parcel.readString();
        this.signInDate = parcel.readString();
        this.personnelName = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public double getDistance() {
        return this.distance;
    }

    public String getDistanceStr() {
        return this.distanceStr;
    }

    public int getHasSignInFrequency() {
        return this.hasSignInFrequency;
    }

    public String getIfUploadPhoto() {
        return this.ifUploadPhoto;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getNextSignTimeStr() {
        return this.nextSignTimeStr;
    }

    public String getPersonnelCode() {
        return this.personnelCode;
    }

    public String getPersonnelName() {
        return this.personnelName;
    }

    public String getPlanSignInDateStr() {
        return this.planSignInDateStr;
    }

    public String getPlanSignInEndDate() {
        return this.planSignInEndDate;
    }

    public String getPlanSignInStartDate() {
        return this.planSignInStartDate;
    }

    public String getPlanSignInStr() {
        return this.planSignInStr;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getProjectOrgName() {
        return this.projectOrgName;
    }

    public double getRadius() {
        return this.radius;
    }

    public String getSignInDate() {
        return this.signInDate;
    }

    public int getSignInFrequency() {
        return this.signInFrequency;
    }

    public int getSignInNumber() {
        return this.signInNumber;
    }

    public String getSignInPeriodType() {
        return this.signInPeriodType;
    }

    public String getSignInPlanCode() {
        return this.signInPlanCode;
    }

    public String getSignInPointCode() {
        return this.signInPointCode;
    }

    public String getSignInPointName() {
        return this.signInPointName;
    }

    public String getSignInProgress() {
        return this.signInProgress;
    }

    public String getSignInRecordCode() {
        return this.signInRecordCode;
    }

    public String getSignInStatus() {
        return this.signInStatus;
    }

    public String getSignInStatusStr() {
        return this.signInStatusStr;
    }

    public String getSignInTaskCode() {
        return this.signInTaskCode;
    }

    public List<String> getSignInTimeList() {
        return this.signInTimeList;
    }

    public String getSignInTimeStr() {
        return this.signInTimeStr;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTemporarySignIn() {
        return this.temporarySignIn;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setDistance(double d) {
        this.distance = d;
    }

    public void setDistanceStr(String str) {
        this.distanceStr = str;
    }

    public void setHasSignInFrequency(int i) {
        this.hasSignInFrequency = i;
    }

    public void setIfUploadPhoto(String str) {
        this.ifUploadPhoto = str;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setNextSignTimeStr(String str) {
        this.nextSignTimeStr = str;
    }

    public void setPersonnelCode(String str) {
        this.personnelCode = str;
    }

    public void setPersonnelName(String str) {
        this.personnelName = str;
    }

    public void setPlanSignInDateStr(String str) {
        this.planSignInDateStr = str;
    }

    public void setPlanSignInEndDate(String str) {
        this.planSignInEndDate = str;
    }

    public void setPlanSignInStartDate(String str) {
        this.planSignInStartDate = str;
    }

    public void setPlanSignInStr(String str) {
        this.planSignInStr = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setProjectOrgName(String str) {
        this.projectOrgName = str;
    }

    public void setRadius(double d) {
        this.radius = d;
    }

    public void setSignInDate(String str) {
        this.signInDate = str;
    }

    public void setSignInFrequency(int i) {
        this.signInFrequency = i;
    }

    public void setSignInNumber(int i) {
        this.signInNumber = i;
    }

    public void setSignInPeriodType(String str) {
        this.signInPeriodType = str;
    }

    public void setSignInPlanCode(String str) {
        this.signInPlanCode = str;
    }

    public void setSignInPointCode(String str) {
        this.signInPointCode = str;
    }

    public void setSignInPointName(String str) {
        this.signInPointName = str;
    }

    public void setSignInProgress(String str) {
        this.signInProgress = str;
    }

    public void setSignInRecordCode(String str) {
        this.signInRecordCode = str;
    }

    public void setSignInStatus(String str) {
        this.signInStatus = str;
    }

    public void setSignInStatusStr(String str) {
        this.signInStatusStr = str;
    }

    public void setSignInTaskCode(String str) {
        this.signInTaskCode = str;
    }

    public void setSignInTimeList(List<String> list) {
        this.signInTimeList = list;
    }

    public void setSignInTimeStr(String str) {
        this.signInTimeStr = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTemporarySignIn(String str) {
        this.temporarySignIn = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.planSignInEndDate);
        parcel.writeString(this.projectOrgName);
        parcel.writeInt(this.signInNumber);
        parcel.writeDouble(this.distance);
        parcel.writeString(this.ifUploadPhoto);
        parcel.writeDouble(this.latitude);
        parcel.writeString(this.signInPeriodType);
        parcel.writeString(this.signInPointName);
        parcel.writeInt(this.signInFrequency);
        parcel.writeString(this.signInStatusStr);
        parcel.writeInt(this.hasSignInFrequency);
        parcel.writeDouble(this.radius);
        parcel.writeString(this.temporarySignIn);
        parcel.writeDouble(this.longitude);
        parcel.writeString(this.planSignInDateStr);
        parcel.writeString(this.signInTaskCode);
        parcel.writeString(this.address);
        parcel.writeString(this.personnelCode);
        parcel.writeString(this.signInProgress);
        parcel.writeString(this.projectOrgCode);
        parcel.writeString(this.planSignInStartDate);
        parcel.writeString(this.signInStatus);
        parcel.writeString(this.signInPlanCode);
        parcel.writeString(this.planSignInStr);
        parcel.writeString(this.distanceStr);
        parcel.writeString(this.createTime);
        parcel.writeString(this.signInPointCode);
        parcel.writeString(this.status);
        parcel.writeStringList(this.signInTimeList);
        parcel.writeString(this.nextSignTimeStr);
        parcel.writeString(this.signInTimeStr);
        parcel.writeString(this.signInRecordCode);
        parcel.writeString(this.signInDate);
        parcel.writeString(this.personnelName);
    }
}
