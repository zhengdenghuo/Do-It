package com.collectpoint.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class RoleInfoBean implements Parcelable {
    public static final Parcelable.Creator<RoleInfoBean> CREATOR = new Parcelable.Creator<RoleInfoBean>() { // from class: com.collectpoint.bean.RoleInfoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RoleInfoBean createFromParcel(Parcel parcel) {
            return new RoleInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RoleInfoBean[] newArray(int i) {
            return new RoleInfoBean[i];
        }
    };
    private String createCode;
    private String createTime;
    private String description;
    private int id;
    private String roleCode;
    private String roleGradeCode;
    private String roleLevel;
    private String roleName;
    private String roleType;
    private String status;
    private String updateCode;
    private String updateTime;

    public RoleInfoBean() {
    }

    protected RoleInfoBean(Parcel parcel) {
        this.id = parcel.readInt();
        this.roleCode = parcel.readString();
        this.roleName = parcel.readString();
        this.roleLevel = parcel.readString();
        this.roleType = parcel.readString();
        this.roleGradeCode = parcel.readString();
        this.status = parcel.readString();
        this.createCode = parcel.readString();
        this.createTime = parcel.readString();
        this.updateCode = parcel.readString();
        this.updateTime = parcel.readString();
        this.description = parcel.readString();
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

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return this.id;
    }

    public String getRoleCode() {
        return this.roleCode;
    }

    public String getRoleGradeCode() {
        return this.roleGradeCode;
    }

    public String getRoleLevel() {
        return this.roleLevel;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public String getRoleType() {
        return this.roleType;
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

    public void setDescription(String str) {
        this.description = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setRoleCode(String str) {
        this.roleCode = str;
    }

    public void setRoleGradeCode(String str) {
        this.roleGradeCode = str;
    }

    public void setRoleLevel(String str) {
        this.roleLevel = str;
    }

    public void setRoleName(String str) {
        this.roleName = str;
    }

    public void setRoleType(String str) {
        this.roleType = str;
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
        parcel.writeString(this.roleCode);
        parcel.writeString(this.roleName);
        parcel.writeString(this.roleLevel);
        parcel.writeString(this.roleType);
        parcel.writeString(this.roleGradeCode);
        parcel.writeString(this.status);
        parcel.writeString(this.createCode);
        parcel.writeString(this.createTime);
        parcel.writeString(this.updateCode);
        parcel.writeString(this.updateTime);
        parcel.writeString(this.description);
    }
}
