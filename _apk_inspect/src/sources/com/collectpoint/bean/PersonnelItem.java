package com.collectpoint.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class PersonnelItem implements Parcelable {
    public static final Parcelable.Creator<PersonnelItem> CREATOR = new Parcelable.Creator<PersonnelItem>() { // from class: com.collectpoint.bean.PersonnelItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PersonnelItem createFromParcel(Parcel parcel) {
            return new PersonnelItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PersonnelItem[] newArray(int i) {
            return new PersonnelItem[i];
        }
    };
    private String isChoice;
    private String userCode;
    private String userName;
    private String userPhone;

    public PersonnelItem() {
    }

    protected PersonnelItem(Parcel parcel) {
        this.userName = parcel.readString();
        this.userCode = parcel.readString();
        this.userPhone = parcel.readString();
        this.isChoice = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getIsChoice() {
        return this.isChoice;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserPhone() {
        return this.userPhone;
    }

    public void readFromParcel(Parcel parcel) {
        this.userName = parcel.readString();
        this.userCode = parcel.readString();
        this.userPhone = parcel.readString();
        this.isChoice = parcel.readString();
    }

    public void setIsChoice(String str) {
        this.isChoice = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setUserPhone(String str) {
        this.userPhone = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userName);
        parcel.writeString(this.userCode);
        parcel.writeString(this.userPhone);
        parcel.writeString(this.isChoice);
    }
}
