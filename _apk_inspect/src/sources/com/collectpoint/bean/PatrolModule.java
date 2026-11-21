package com.collectpoint.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class PatrolModule implements Parcelable, Serializable {
    public static final Parcelable.Creator<PatrolModule> CREATOR = new Parcelable.Creator<PatrolModule>() { // from class: com.collectpoint.bean.PatrolModule.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PatrolModule createFromParcel(Parcel parcel) {
            return new PatrolModule(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PatrolModule[] newArray(int i) {
            return new PatrolModule[i];
        }
    };
    private String appMenuShowType;
    private String businessModule;
    private List<PatrolModule> children;
    private String id;
    private String menuCode;
    private String menuIcon;
    private String menuLevel;
    private String menuName;
    private int menuOrder;
    private String menuPath;
    private String menuType;
    public int nameId;
    private String parentCode;
    private String parentId;
    public int resId;
    private String roleCode;
    private String systemCodes;
    private String title;

    public PatrolModule() {
    }

    public PatrolModule(int i, int i2) {
        this.resId = i;
        this.nameId = i2;
    }

    protected PatrolModule(Parcel parcel) {
        this.resId = parcel.readInt();
        this.nameId = parcel.readInt();
        this.systemCodes = parcel.readString();
        this.menuIcon = parcel.readString();
        this.menuPath = parcel.readString();
        this.menuLevel = parcel.readString();
        this.menuName = parcel.readString();
        this.title = parcel.readString();
        this.parentId = parcel.readString();
        this.appMenuShowType = parcel.readString();
        this.menuOrder = parcel.readInt();
        this.parentCode = parcel.readString();
        this.roleCode = parcel.readString();
        this.menuCode = parcel.readString();
        this.menuType = parcel.readString();
        this.businessModule = parcel.readString();
        this.id = parcel.readString();
        this.children = parcel.createTypedArrayList(CREATOR);
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

    public List<PatrolModule> getChildren() {
        return this.children;
    }

    public String getId() {
        return this.id;
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

    public int getNameId() {
        return this.nameId;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public String getParentId() {
        return this.parentId;
    }

    public int getResId() {
        return this.resId;
    }

    public String getRoleCode() {
        return this.roleCode;
    }

    public String getSystemCodes() {
        return this.systemCodes;
    }

    public String getTitle() {
        return this.title;
    }

    public void readFromParcel(Parcel parcel) {
        this.resId = parcel.readInt();
        this.nameId = parcel.readInt();
        this.systemCodes = parcel.readString();
        this.menuIcon = parcel.readString();
        this.menuPath = parcel.readString();
        this.menuLevel = parcel.readString();
        this.menuName = parcel.readString();
        this.title = parcel.readString();
        this.parentId = parcel.readString();
        this.appMenuShowType = parcel.readString();
        this.menuOrder = parcel.readInt();
        this.parentCode = parcel.readString();
        this.roleCode = parcel.readString();
        this.menuCode = parcel.readString();
        this.menuType = parcel.readString();
        this.businessModule = parcel.readString();
        this.id = parcel.readString();
        this.children = parcel.createTypedArrayList(CREATOR);
    }

    public void setAppMenuShowType(String str) {
        this.appMenuShowType = str;
    }

    public void setBusinessModule(String str) {
        this.businessModule = str;
    }

    public void setChildren(List<PatrolModule> list) {
        this.children = list;
    }

    public void setId(String str) {
        this.id = str;
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

    public void setNameId(int i) {
        this.nameId = i;
    }

    public void setParentCode(String str) {
        this.parentCode = str;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setResId(int i) {
        this.resId = i;
    }

    public void setRoleCode(String str) {
        this.roleCode = str;
    }

    public void setSystemCodes(String str) {
        this.systemCodes = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.resId);
        parcel.writeInt(this.nameId);
        parcel.writeString(this.systemCodes);
        parcel.writeString(this.menuIcon);
        parcel.writeString(this.menuPath);
        parcel.writeString(this.menuLevel);
        parcel.writeString(this.menuName);
        parcel.writeString(this.title);
        parcel.writeString(this.parentId);
        parcel.writeString(this.appMenuShowType);
        parcel.writeInt(this.menuOrder);
        parcel.writeString(this.parentCode);
        parcel.writeString(this.roleCode);
        parcel.writeString(this.menuCode);
        parcel.writeString(this.menuType);
        parcel.writeString(this.businessModule);
        parcel.writeString(this.id);
        parcel.writeTypedList(this.children);
    }
}
