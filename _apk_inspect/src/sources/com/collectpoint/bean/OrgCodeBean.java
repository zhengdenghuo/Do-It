package com.collectpoint.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class OrgCodeBean implements Parcelable {
    public static final Parcelable.Creator<OrgCodeBean> CREATOR = new Parcelable.Creator<OrgCodeBean>() { // from class: com.collectpoint.bean.OrgCodeBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrgCodeBean createFromParcel(Parcel parcel) {
            return new OrgCodeBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrgCodeBean[] newArray(int i) {
            return new OrgCodeBean[i];
        }
    };
    private String createCode;
    private String createTime;
    private int id;
    private String orgAddress;
    private String orgCode;
    private String orgContacts;
    private String orgDescribe;
    private String orgLevel;
    private String orgName;
    private String orgNickName;
    private String orgPhone;
    private String orgStatus;
    private String orgType;
    private String porgCode;
    private String projectOrgCode;
    private String status;
    private String updateCode;
    private String updateTime;

    public OrgCodeBean() {
    }

    protected OrgCodeBean(Parcel parcel) {
        this.id = parcel.readInt();
        this.orgCode = parcel.readString();
        this.orgType = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.orgLevel = parcel.readString();
        this.orgNickName = parcel.readString();
        this.orgName = parcel.readString();
        this.orgDescribe = parcel.readString();
        this.orgPhone = parcel.readString();
        this.orgContacts = parcel.readString();
        this.orgAddress = parcel.readString();
        this.orgStatus = parcel.readString();
        this.status = parcel.readString();
        this.createCode = parcel.readString();
        this.createTime = parcel.readString();
        this.updateCode = parcel.readString();
        this.updateTime = parcel.readString();
        this.porgCode = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCreateCode() {
        return this.createCode;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public int getId() {
        return this.id;
    }

    public String getOrgAddress() {
        return this.orgAddress;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public String getOrgContacts() {
        return this.orgContacts;
    }

    public String getOrgDescribe() {
        return this.orgDescribe;
    }

    public String getOrgLevel() {
        return this.orgLevel;
    }

    public String getOrgName() {
        return this.orgName;
    }

    public String getOrgNickName() {
        return this.orgNickName;
    }

    public String getOrgPhone() {
        return this.orgPhone;
    }

    public String getOrgStatus() {
        return this.orgStatus;
    }

    public String getOrgType() {
        return this.orgType;
    }

    public String getPorgCode() {
        return this.porgCode;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getStatus() {
        return this.status;
    }

    public String getUpdateCode() {
        return this.updateCode;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setCreateCode(String str) {
        this.createCode = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setOrgAddress(String str) {
        this.orgAddress = str;
    }

    public void setOrgCode(String str) {
        this.orgCode = str;
    }

    public void setOrgContacts(String str) {
        this.orgContacts = str;
    }

    public void setOrgDescribe(String str) {
        this.orgDescribe = str;
    }

    public void setOrgLevel(String str) {
        this.orgLevel = str;
    }

    public void setOrgName(String str) {
        this.orgName = str;
    }

    public void setOrgNickName(String str) {
        this.orgNickName = str;
    }

    public void setOrgPhone(String str) {
        this.orgPhone = str;
    }

    public void setOrgStatus(String str) {
        this.orgStatus = str;
    }

    public void setOrgType(String str) {
        this.orgType = str;
    }

    public void setPorgCode(String str) {
        this.porgCode = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setUpdateCode(String str) {
        this.updateCode = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.orgCode);
        parcel.writeString(this.orgType);
        parcel.writeString(this.projectOrgCode);
        parcel.writeString(this.orgLevel);
        parcel.writeString(this.orgNickName);
        parcel.writeString(this.orgName);
        parcel.writeString(this.orgDescribe);
        parcel.writeString(this.orgPhone);
        parcel.writeString(this.orgContacts);
        parcel.writeString(this.orgAddress);
        parcel.writeString(this.orgStatus);
        parcel.writeString(this.status);
        parcel.writeString(this.createCode);
        parcel.writeString(this.createTime);
        parcel.writeString(this.updateCode);
        parcel.writeString(this.updateTime);
        parcel.writeString(this.porgCode);
    }
}
