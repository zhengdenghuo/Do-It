package com.collectpoint.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class WorkingFeature implements Parcelable {
    public static final Parcelable.Creator<WorkingFeature> CREATOR = new Parcelable.Creator<WorkingFeature>() { // from class: com.collectpoint.bean.WorkingFeature.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkingFeature createFromParcel(Parcel parcel) {
            return new WorkingFeature(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkingFeature[] newArray(int i) {
            return new WorkingFeature[i];
        }
    };
    private String appMenuShowType;
    private String featureName;
    private String menuCode;
    private String menuIcon;
    private String menuName;
    private String menuPath;
    private String menuType;
    private String num;
    private String parentCode;
    private int resId;

    public WorkingFeature() {
    }

    protected WorkingFeature(Parcel parcel) {
        this.featureName = parcel.readString();
        this.resId = parcel.readInt();
        this.num = parcel.readString();
        this.menuCode = parcel.readString();
        this.menuName = parcel.readString();
        this.parentCode = parcel.readString();
        this.menuIcon = parcel.readString();
        this.menuPath = parcel.readString();
        this.menuType = parcel.readString();
        this.appMenuShowType = parcel.readString();
    }

    public WorkingFeature(String str) {
        this.featureName = str;
    }

    public WorkingFeature(String str, int i) {
        this.featureName = str;
        this.resId = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppMenuShowType() {
        return this.appMenuShowType;
    }

    public String getFeatureName() {
        return this.featureName;
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

    public String getNum() {
        return this.num;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public int getResId() {
        return this.resId;
    }

    public void setAppMenuShowType(String str) {
        this.appMenuShowType = str;
    }

    public WorkingFeature setFeatureName(String str) {
        this.featureName = str;
        return this;
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

    public void setNum(String str) {
        this.num = str;
    }

    public void setParentCode(String str) {
        this.parentCode = str;
    }

    public WorkingFeature setResId(int i) {
        this.resId = i;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.featureName);
        parcel.writeInt(this.resId);
        parcel.writeString(this.num);
        parcel.writeString(this.menuCode);
        parcel.writeString(this.menuName);
        parcel.writeString(this.parentCode);
        parcel.writeString(this.menuIcon);
        parcel.writeString(this.menuPath);
        parcel.writeString(this.menuType);
        parcel.writeString(this.appMenuShowType);
    }
}
