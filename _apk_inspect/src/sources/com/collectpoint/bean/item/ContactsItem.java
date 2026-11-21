package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class ContactsItem implements Parcelable {
    public static final Parcelable.Creator<ContactsItem> CREATOR = new Parcelable.Creator<ContactsItem>() { // from class: com.collectpoint.bean.item.ContactsItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactsItem createFromParcel(Parcel parcel) {
            return new ContactsItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactsItem[] newArray(int i) {
            return new ContactsItem[i];
        }
    };
    private String appOnLineStatus;
    private boolean isAdd;
    private String nickName;
    private String tele;
    private String title;
    private String userCode;
    private String userId;
    private String webOnLineStatus;

    public ContactsItem() {
    }

    protected ContactsItem(Parcel parcel) {
        this.nickName = parcel.readString();
        this.userCode = parcel.readString();
        this.appOnLineStatus = parcel.readString();
        this.webOnLineStatus = parcel.readString();
        this.userId = parcel.readString();
        this.tele = parcel.readString();
        this.title = parcel.readString();
        this.isAdd = parcel.readByte() != 0;
    }

    public ContactsItem(String str, String str2) {
        this.nickName = str;
        this.userCode = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppOnLineStatus() {
        return this.appOnLineStatus;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getTele() {
        return this.tele;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getWebOnLineStatus() {
        return this.webOnLineStatus;
    }

    public boolean isAdd() {
        return this.isAdd;
    }

    public void readFromParcel(Parcel parcel) {
        this.nickName = parcel.readString();
        this.userCode = parcel.readString();
        this.appOnLineStatus = parcel.readString();
        this.webOnLineStatus = parcel.readString();
        this.userId = parcel.readString();
        this.tele = parcel.readString();
        this.title = parcel.readString();
    }

    public void setAdd(boolean z) {
        this.isAdd = z;
    }

    public void setAppOnLineStatus(String str) {
        this.appOnLineStatus = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setTele(String str) {
        this.tele = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setWebOnLineStatus(String str) {
        this.webOnLineStatus = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nickName);
        parcel.writeString(this.userCode);
        parcel.writeString(this.appOnLineStatus);
        parcel.writeString(this.webOnLineStatus);
        parcel.writeString(this.userId);
        parcel.writeString(this.tele);
        parcel.writeString(this.title);
        parcel.writeByte(this.isAdd ? (byte) 1 : (byte) 0);
    }
}
