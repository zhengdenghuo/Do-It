package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.contrarywind.interfaces.IPickerViewData;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class MenuItem implements Parcelable, Serializable, IPickerViewData {
    public static final Parcelable.Creator<MenuItem> CREATOR = new Parcelable.Creator<MenuItem>() { // from class: com.collectpoint.bean.item.MenuItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MenuItem createFromParcel(Parcel parcel) {
            return new MenuItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MenuItem[] newArray(int i) {
            return new MenuItem[i];
        }
    };
    private String appMenuShowType;
    private String businessModule;
    private List<MenuItem> children;
    private String id;
    private String ifSelfProcess;
    private String menuCode;
    private String menuIcon;
    private String menuLevel;
    private String menuName;
    private int menuOrder;
    private String menuPath;
    private String menuType;
    public int nameId;
    private String objectTypeCode;
    private String parentCode;
    private String parentId;
    public int resId;
    private String roleCode;
    private String systemCodes;
    private String title;
    private String typeCode;

    public MenuItem() {
    }

    public MenuItem(int i, int i2) {
        this.resId = i;
        this.nameId = i2;
    }

    public MenuItem(int i, String str, String str2) {
        this.resId = i;
        this.menuName = str;
        this.menuCode = str2;
    }

    protected MenuItem(Parcel parcel) {
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
        this.typeCode = parcel.readString();
        this.ifSelfProcess = parcel.readString();
        this.objectTypeCode = parcel.readString();
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

    public List<MenuItem> getChildren() {
        return this.children;
    }

    public String getId() {
        return this.id;
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

    public String getObjectTypeCode() {
        return this.objectTypeCode;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getPickerViewText() {
        return this.menuName;
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

    public String getTypeCode() {
        return this.typeCode;
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
        this.typeCode = parcel.readString();
        this.ifSelfProcess = parcel.readString();
        this.objectTypeCode = parcel.readString();
    }

    public void setAppMenuShowType(String str) {
        this.appMenuShowType = str;
    }

    public void setBusinessModule(String str) {
        this.businessModule = str;
    }

    public void setChildren(List<MenuItem> list) {
        this.children = list;
    }

    public void setId(String str) {
        this.id = str;
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

    public void setObjectTypeCode(String str) {
        this.objectTypeCode = str;
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

    public void setTypeCode(String str) {
        this.typeCode = str;
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
        parcel.writeString(this.typeCode);
        parcel.writeString(this.ifSelfProcess);
        parcel.writeString(this.objectTypeCode);
    }
}
