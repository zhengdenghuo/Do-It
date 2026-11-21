package com.collectpoint.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class CommonModule implements Parcelable {
    public static final Parcelable.Creator<CommonModule> CREATOR = new Parcelable.Creator<CommonModule>() { // from class: com.collectpoint.bean.CommonModule.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommonModule createFromParcel(Parcel parcel) {
            return new CommonModule(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommonModule[] newArray(int i) {
            return new CommonModule[i];
        }
    };
    private String ifSelfProcess;
    private String menuCode;
    private String menuIcon;
    private String menuName;
    private String menuPath;
    private String menuType;
    public int nameId;
    private String parentCode;
    public int resId;

    public CommonModule() {
    }

    public CommonModule(int i, int i2) {
        this.resId = i;
        this.nameId = i2;
    }

    protected CommonModule(Parcel parcel) {
        this.resId = parcel.readInt();
        this.nameId = parcel.readInt();
        this.menuCode = parcel.readString();
        this.menuName = parcel.readString();
        this.parentCode = parcel.readString();
        this.menuIcon = parcel.readString();
        this.menuPath = parcel.readString();
        this.menuType = parcel.readString();
        this.ifSelfProcess = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getIfSelfProcess() {
        return this.ifSelfProcess;
    }

    public String getMenuCode() {
        return this.menuCode;
    }

    public String getMenuIcon() {
        return this.menuIcon;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public String getMenuPath() {
        return this.menuPath;
    }

    public String getMenuType() {
        return this.menuType;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public void setIfSelfProcess(String str) {
        this.ifSelfProcess = str;
    }

    public void setMenuCode(String str) {
        this.menuCode = str;
    }

    public void setMenuIcon(String str) {
        this.menuIcon = str;
    }

    public void setMenuName(String str) {
        this.menuName = str;
    }

    public void setMenuPath(String str) {
        this.menuPath = str;
    }

    public void setMenuType(String str) {
        this.menuType = str;
    }

    public void setParentCode(String str) {
        this.parentCode = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.resId);
        parcel.writeInt(this.nameId);
        parcel.writeString(this.menuCode);
        parcel.writeString(this.menuName);
        parcel.writeString(this.parentCode);
        parcel.writeString(this.menuIcon);
        parcel.writeString(this.menuPath);
        parcel.writeString(this.menuType);
        parcel.writeString(this.ifSelfProcess);
    }
}
