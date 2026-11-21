package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class StatisticListItem implements Parcelable {
    public static final Parcelable.Creator<StatisticListItem> CREATOR = new Parcelable.Creator<StatisticListItem>() { // from class: com.collectpoint.bean.item.StatisticListItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatisticListItem createFromParcel(Parcel parcel) {
            return new StatisticListItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatisticListItem[] newArray(int i) {
            return new StatisticListItem[i];
        }
    };
    private String menuCode;
    private String menuIcon;
    private String menuLevel;
    private String menuName;
    private int menuOrder;
    private String menuType;
    private int resId;
    private String roleCode;
    private String totalNumber;

    public StatisticListItem() {
    }

    protected StatisticListItem(Parcel parcel) {
        this.totalNumber = parcel.readString();
        this.menuOrder = parcel.readInt();
        this.menuIcon = parcel.readString();
        this.roleCode = parcel.readString();
        this.menuCode = parcel.readString();
        this.menuLevel = parcel.readString();
        this.menuName = parcel.readString();
        this.menuType = parcel.readString();
        this.resId = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    public int getResId() {
        return this.resId;
    }

    public String getRoleCode() {
        return this.roleCode;
    }

    public String getTotalNumber() {
        return this.totalNumber;
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

    public void setResId(int i) {
        this.resId = i;
    }

    public void setRoleCode(String str) {
        this.roleCode = str;
    }

    public void setTotalNumber(String str) {
        this.totalNumber = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.totalNumber);
        parcel.writeInt(this.menuOrder);
        parcel.writeString(this.menuIcon);
        parcel.writeString(this.roleCode);
        parcel.writeString(this.menuCode);
        parcel.writeString(this.menuLevel);
        parcel.writeString(this.menuName);
        parcel.writeString(this.menuType);
        parcel.writeInt(this.resId);
    }
}
