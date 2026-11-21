package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class UserOrgListItem implements Parcelable, IPickerViewData {
    public static final Parcelable.Creator<UserOrgListItem> CREATOR = new Parcelable.Creator<UserOrgListItem>() { // from class: com.collectpoint.bean.item.UserOrgListItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserOrgListItem createFromParcel(Parcel parcel) {
            return new UserOrgListItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserOrgListItem[] newArray(int i) {
            return new UserOrgListItem[i];
        }
    };
    private String categoryNames;
    private String categorys;
    private String createCode;
    private String createTime;
    private String id;
    private boolean isChecked;
    private String name;
    private String orgAddress;
    private String orgCode;
    private String orgContacts;
    private String orgLevel;
    private String orgName;
    private String orgNickName;
    private String orgPhone;
    private String orgStatus;
    private String orgType;
    private String pOrgCode;
    private String parentId;
    private String projectOrgCode;
    private String status;
    private String title;

    public UserOrgListItem() {
        this.isChecked = false;
    }

    protected UserOrgListItem(Parcel parcel) {
        this.isChecked = false;
        this.categorys = parcel.readString();
        this.pOrgCode = parcel.readString();
        this.orgName = parcel.readString();
        this.orgLevel = parcel.readString();
        this.orgAddress = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.title = parcel.readString();
        this.parentId = parcel.readString();
        this.orgPhone = parcel.readString();
        this.categoryNames = parcel.readString();
        this.orgStatus = parcel.readString();
        this.orgType = parcel.readString();
        this.createTime = parcel.readString();
        this.orgCode = parcel.readString();
        this.name = parcel.readString();
        this.orgContacts = parcel.readString();
        this.id = parcel.readString();
        this.orgNickName = parcel.readString();
        this.createCode = parcel.readString();
        this.status = parcel.readString();
        this.isChecked = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCategoryNames() {
        return this.categoryNames;
    }

    public String getCategorys() {
        return this.categorys;
    }

    public String getCreateCode() {
        return this.createCode;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
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

    public String getParentId() {
        return this.parentId;
    }

    public String getPickerViewText() {
        return this.orgNickName;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public String getpOrgCode() {
        return this.pOrgCode;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setCategoryNames(String str) {
        this.categoryNames = str;
    }

    public void setCategorys(String str) {
        this.categorys = str;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public void setCreateCode(String str) {
        this.createCode = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
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

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setpOrgCode(String str) {
        this.pOrgCode = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.categorys);
        parcel.writeString(this.pOrgCode);
        parcel.writeString(this.orgName);
        parcel.writeString(this.orgLevel);
        parcel.writeString(this.orgAddress);
        parcel.writeString(this.projectOrgCode);
        parcel.writeString(this.title);
        parcel.writeString(this.parentId);
        parcel.writeString(this.orgPhone);
        parcel.writeString(this.categoryNames);
        parcel.writeString(this.orgStatus);
        parcel.writeString(this.orgType);
        parcel.writeString(this.createTime);
        parcel.writeString(this.orgCode);
        parcel.writeString(this.name);
        parcel.writeString(this.orgContacts);
        parcel.writeString(this.id);
        parcel.writeString(this.orgNickName);
        parcel.writeString(this.createCode);
        parcel.writeString(this.status);
        parcel.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
    }
}
