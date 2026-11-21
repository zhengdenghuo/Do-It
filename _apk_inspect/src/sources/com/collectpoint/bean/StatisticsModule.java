package com.collectpoint.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class StatisticsModule implements Parcelable {
    public static final Parcelable.Creator<StatisticsModule> CREATOR = new Parcelable.Creator<StatisticsModule>() { // from class: com.collectpoint.bean.StatisticsModule.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatisticsModule createFromParcel(Parcel parcel) {
            return new StatisticsModule(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatisticsModule[] newArray(int i) {
            return new StatisticsModule[i];
        }
    };
    private String appMenuShowType;
    private String menuCode;
    private String menuIcon;
    private String menuLevel;
    private String menuName;
    private int menuOrder;
    private String menuType;
    private String roleCode;
    private int totalNumber;

    public StatisticsModule() {
    }

    protected StatisticsModule(Parcel parcel) {
        this.totalNumber = parcel.readInt();
        this.menuOrder = parcel.readInt();
        this.appMenuShowType = parcel.readString();
        this.menuIcon = parcel.readString();
        this.roleCode = parcel.readString();
        this.menuCode = parcel.readString();
        this.menuLevel = parcel.readString();
        this.menuName = parcel.readString();
        this.menuType = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppMenuShowType() {
        return this.appMenuShowType;
    }

    public String getMenuCode() {
        return this.menuCode;
    }

    public String getMenuIcon() {
        return this.menuIcon;
    }

    public String getMenuLevel() {
        return this.menuLevel;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public int getMenuOrder() {
        return this.menuOrder;
    }

    public String getMenuType() {
        return this.menuType;
    }

    public String getRoleCode() {
        return this.roleCode;
    }

    public int getTotalNumber() {
        return this.totalNumber;
    }

    public void setAppMenuShowType(String str) {
        this.appMenuShowType = str;
    }

    public void setMenuCode(String str) {
        this.menuCode = str;
    }

    public void setMenuIcon(String str) {
        this.menuIcon = str;
    }

    public void setMenuLevel(String str) {
        this.menuLevel = str;
    }

    public void setMenuName(String str) {
        this.menuName = str;
    }

    public void setMenuOrder(int i) {
        this.menuOrder = i;
    }

    public void setMenuType(String str) {
        this.menuType = str;
    }

    public void setRoleCode(String str) {
        this.roleCode = str;
    }

    public void setTotalNumber(int i) {
        this.totalNumber = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.totalNumber);
        parcel.writeInt(this.menuOrder);
        parcel.writeString(this.appMenuShowType);
        parcel.writeString(this.menuIcon);
        parcel.writeString(this.roleCode);
        parcel.writeString(this.menuCode);
        parcel.writeString(this.menuLevel);
        parcel.writeString(this.menuName);
        parcel.writeString(this.menuType);
    }
}
