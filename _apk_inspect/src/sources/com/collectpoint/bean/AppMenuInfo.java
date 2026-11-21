package com.collectpoint.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.collectpoint.bean.item.MenuItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class AppMenuInfo implements Parcelable {
    public static final Parcelable.Creator<AppMenuInfo> CREATOR = new Parcelable.Creator<AppMenuInfo>() { // from class: com.collectpoint.bean.AppMenuInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppMenuInfo createFromParcel(Parcel parcel) {
            return new AppMenuInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppMenuInfo[] newArray(int i) {
            return new AppMenuInfo[i];
        }
    };
    private List<PatrolModule> commonFunctionMenu;
    private List<MenuItem> manageHighway;
    private List<MenuItem> waitMatters;

    public AppMenuInfo() {
    }

    protected AppMenuInfo(Parcel parcel) {
        this.commonFunctionMenu = parcel.createTypedArrayList(PatrolModule.CREATOR);
        this.manageHighway = parcel.createTypedArrayList(MenuItem.CREATOR);
        this.waitMatters = parcel.createTypedArrayList(MenuItem.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PatrolModule> getCommonFunctionMenu() {
        return this.commonFunctionMenu;
    }

    public List<MenuItem> getManageHighway() {
        return this.manageHighway;
    }

    public List<MenuItem> getWaitMatters() {
        return this.waitMatters;
    }

    public void readFromParcel(Parcel parcel) {
        this.commonFunctionMenu = parcel.createTypedArrayList(PatrolModule.CREATOR);
        this.manageHighway = parcel.createTypedArrayList(MenuItem.CREATOR);
        this.waitMatters = parcel.createTypedArrayList(MenuItem.CREATOR);
    }

    public void setCommonFunctionMenu(List<PatrolModule> list) {
        this.commonFunctionMenu = list;
    }

    public void setManageHighway(List<MenuItem> list) {
        this.manageHighway = list;
    }

    public void setWaitMatters(List<MenuItem> list) {
        this.waitMatters = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.commonFunctionMenu);
        parcel.writeTypedList(this.manageHighway);
        parcel.writeTypedList(this.waitMatters);
    }
}
