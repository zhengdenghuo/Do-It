package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class OrgCodeItem implements Parcelable, IPickerViewData {
    public static final Parcelable.Creator<OrgCodeItem> CREATOR = new Parcelable.Creator<OrgCodeItem>() { // from class: com.collectpoint.bean.item.OrgCodeItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrgCodeItem createFromParcel(Parcel parcel) {
            return new OrgCodeItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrgCodeItem[] newArray(int i) {
            return new OrgCodeItem[i];
        }
    };
    private String orgCode;
    private String orgNickName;

    public OrgCodeItem() {
    }

    protected OrgCodeItem(Parcel parcel) {
        this.orgCode = parcel.readString();
        this.orgNickName = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public String getOrgNickName() {
        return this.orgNickName;
    }

    public String getPickerViewText() {
        return this.orgNickName;
    }

    public void readFromParcel(Parcel parcel) {
        this.orgCode = parcel.readString();
        this.orgNickName = parcel.readString();
    }

    public void setOrgCode(String str) {
        this.orgCode = str;
    }

    public void setOrgNickName(String str) {
        this.orgNickName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.orgCode);
        parcel.writeString(this.orgNickName);
    }
}
