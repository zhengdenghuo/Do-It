package com.collectpoint.bean.res;

import android.os.Parcel;
import android.os.Parcelable;
import com.collectpoint.bean.item.CachedCollectPointListItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class CachedCollectObjectInfoRes implements Parcelable {
    public static final Parcelable.Creator<CachedCollectObjectInfoRes> CREATOR = new Parcelable.Creator<CachedCollectObjectInfoRes>() { // from class: com.collectpoint.bean.res.CachedCollectObjectInfoRes.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CachedCollectObjectInfoRes createFromParcel(Parcel parcel) {
            return new CachedCollectObjectInfoRes(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CachedCollectObjectInfoRes[] newArray(int i) {
            return new CachedCollectObjectInfoRes[i];
        }
    };
    private String achieveMode;
    private String achieveModeName;
    private String collectObjectCode;
    private String collectObjectName;
    private String collectObjectStr;
    private List<CachedCollectPointListItem> collectPointList;
    private String collectPointNumber;
    private String collectUserCode;
    private String collectUserName;
    private String createTimeStr;
    private String frequency;
    private String frequencyName;
    private String parentCollectObjectCode;
    private String parentCollectObjectName;
    private String projectOrgCode;
    private String projectOrgName;

    public CachedCollectObjectInfoRes() {
    }

    protected CachedCollectObjectInfoRes(Parcel parcel) {
        this.projectOrgName = parcel.readString();
        this.achieveModeName = parcel.readString();
        this.collectObjectStr = parcel.readString();
        this.collectPointNumber = parcel.readString();
        this.achieveMode = parcel.readString();
        this.frequency = parcel.readString();
        this.frequencyName = parcel.readString();
        this.collectObjectName = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.parentCollectObjectName = parcel.readString();
        this.collectObjectCode = parcel.readString();
        this.parentCollectObjectCode = parcel.readString();
        this.collectUserCode = parcel.readString();
        this.collectUserName = parcel.readString();
        this.createTimeStr = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.collectPointList = arrayList;
        parcel.readList(arrayList, CachedCollectPointListItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAchieveMode() {
        return this.achieveMode;
    }

    public String getAchieveModeName() {
        return this.achieveModeName;
    }

    public String getCollectObjectCode() {
        return this.collectObjectCode;
    }

    public String getCollectObjectName() {
        return this.collectObjectName;
    }

    public String getCollectObjectStr() {
        return this.collectObjectStr;
    }

    public List<CachedCollectPointListItem> getCollectPointList() {
        return this.collectPointList;
    }

    public String getCollectPointNumber() {
        return this.collectPointNumber;
    }

    public String getCollectUserCode() {
        return this.collectUserCode;
    }

    public String getCollectUserName() {
        return this.collectUserName;
    }

    public String getCreateTimeStr() {
        return this.createTimeStr;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public String getFrequencyName() {
        return this.frequencyName;
    }

    public String getParentCollectObjectCode() {
        return this.parentCollectObjectCode;
    }

    public String getParentCollectObjectName() {
        return this.parentCollectObjectName;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getProjectOrgName() {
        return this.projectOrgName;
    }

    public void readFromParcel(Parcel parcel) {
        this.projectOrgName = parcel.readString();
        this.achieveModeName = parcel.readString();
        this.collectObjectStr = parcel.readString();
        this.collectPointNumber = parcel.readString();
        this.achieveMode = parcel.readString();
        this.frequency = parcel.readString();
        this.frequencyName = parcel.readString();
        this.collectObjectName = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.parentCollectObjectName = parcel.readString();
        this.collectObjectCode = parcel.readString();
        this.parentCollectObjectCode = parcel.readString();
        this.collectUserCode = parcel.readString();
        this.collectUserName = parcel.readString();
        this.createTimeStr = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.collectPointList = arrayList;
        parcel.readList(arrayList, CachedCollectPointListItem.class.getClassLoader());
    }

    public void setAchieveMode(String str) {
        this.achieveMode = str;
    }

    public void setAchieveModeName(String str) {
        this.achieveModeName = str;
    }

    public void setCollectObjectCode(String str) {
        this.collectObjectCode = str;
    }

    public void setCollectObjectName(String str) {
        this.collectObjectName = str;
    }

    public void setCollectObjectStr(String str) {
        this.collectObjectStr = str;
    }

    public void setCollectPointList(List<CachedCollectPointListItem> list) {
        this.collectPointList = list;
    }

    public void setCollectPointNumber(String str) {
        this.collectPointNumber = str;
    }

    public void setCollectUserCode(String str) {
        this.collectUserCode = str;
    }

    public void setCollectUserName(String str) {
        this.collectUserName = str;
    }

    public void setCreateTimeStr(String str) {
        this.createTimeStr = str;
    }

    public void setFrequency(String str) {
        this.frequency = str;
    }

    public void setFrequencyName(String str) {
        this.frequencyName = str;
    }

    public void setParentCollectObjectCode(String str) {
        this.parentCollectObjectCode = str;
    }

    public void setParentCollectObjectName(String str) {
        this.parentCollectObjectName = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setProjectOrgName(String str) {
        this.projectOrgName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.projectOrgName);
        parcel.writeString(this.achieveModeName);
        parcel.writeString(this.collectObjectStr);
        parcel.writeString(this.collectPointNumber);
        parcel.writeString(this.achieveMode);
        parcel.writeString(this.frequency);
        parcel.writeString(this.frequencyName);
        parcel.writeString(this.collectObjectName);
        parcel.writeString(this.projectOrgCode);
        parcel.writeString(this.parentCollectObjectName);
        parcel.writeString(this.collectObjectCode);
        parcel.writeString(this.parentCollectObjectCode);
        parcel.writeString(this.collectUserCode);
        parcel.writeString(this.collectUserName);
        parcel.writeString(this.createTimeStr);
        parcel.writeList(this.collectPointList);
    }
}
