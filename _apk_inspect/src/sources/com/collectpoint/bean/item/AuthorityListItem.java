package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class AuthorityListItem implements Parcelable {
    public static final Parcelable.Creator<AuthorityListItem> CREATOR = new Parcelable.Creator<AuthorityListItem>() { // from class: com.collectpoint.bean.item.AuthorityListItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthorityListItem createFromParcel(Parcel parcel) {
            return new AuthorityListItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthorityListItem[] newArray(int i) {
            return new AuthorityListItem[i];
        }
    };
    private String appMenuShowType;
    private String businessModule;
    private String menuCode;
    private String menuIcon;
    private String menuLevel;
    private String menuName;
    private int menuOrder;
    private String menuPath;
    private String menuType;
    private String roleCode;
    private String systemCodes;

    public AuthorityListItem() {
    }

    protected AuthorityListItem(Parcel parcel) {
        this.appMenuShowType = parcel.readString();
        this.menuOrder = parcel.readInt();
        this.systemCodes = parcel.readString();
        this.menuIcon = parcel.readString();
        this.menuPath = parcel.readString();
        this.roleCode = parcel.readString();
        this.menuCode = parcel.readString();
        this.menuLevel = parcel.readString();
        this.menuName = parcel.readString();
        this.menuType = parcel.readString();
        this.businessModule = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppMenuShowType() {
        return this.appMenuShowType;
    }

    public String getBusinessModule() {
        return this.businessModule;
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

    public String getMenuPath() {
        return this.menuPath;
    }

    public String getMenuType() {
        return this.menuType;
    }

    public String getRoleCode() {
        return this.roleCode;
    }

    public String getSystemCodes() {
        return this.systemCodes;
    }

    public void setAppMenuShowType(String str) {
        this.appMenuShowType = str;
    }

    public void setBusinessModule(String str) {
        this.businessModule = str;
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

    public void setMenuPath(String str) {
        this.menuPath = str;
    }

    public void setMenuType(String str) {
        this.menuType = str;
    }

    public void setRoleCode(String str) {
        this.roleCode = str;
    }

    public void setSystemCodes(String str) {
        this.systemCodes = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appMenuShowType);
        parcel.writeInt(this.menuOrder);
        parcel.writeString(this.systemCodes);
        parcel.writeString(this.menuIcon);
        parcel.writeString(this.menuPath);
        parcel.writeString(this.roleCode);
        parcel.writeString(this.menuCode);
        parcel.writeString(this.menuLevel);
        parcel.writeString(this.menuName);
        parcel.writeString(this.menuType);
        parcel.writeString(this.businessModule);
    }
}
