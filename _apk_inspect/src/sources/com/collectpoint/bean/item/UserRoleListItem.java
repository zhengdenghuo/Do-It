package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class UserRoleListItem implements Parcelable {
    public static final Parcelable.Creator<UserRoleListItem> CREATOR = new Parcelable.Creator<UserRoleListItem>() { // from class: com.collectpoint.bean.item.UserRoleListItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserRoleListItem createFromParcel(Parcel parcel) {
            return new UserRoleListItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserRoleListItem[] newArray(int i) {
            return new UserRoleListItem[i];
        }
    };
    private boolean isChecked;
    private String roleCode;
    private String roleName;
    private String roleType;
    private String userCode;

    public UserRoleListItem() {
        this.isChecked = false;
    }

    protected UserRoleListItem(Parcel parcel) {
        this.isChecked = false;
        this.roleCode = parcel.readString();
        this.roleName = parcel.readString();
        this.roleType = parcel.readString();
        this.userCode = parcel.readString();
        this.isChecked = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getRoleCode() {
        return this.roleCode;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public String getRoleType() {
        return this.roleType;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public void setRoleCode(String str) {
        this.roleCode = str;
    }

    public void setRoleName(String str) {
        this.roleName = str;
    }

    public void setRoleType(String str) {
        this.roleType = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.roleCode);
        parcel.writeString(this.roleName);
        parcel.writeString(this.roleType);
        parcel.writeString(this.userCode);
        parcel.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
    }
}
