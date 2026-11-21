package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class NewsInformationListItem implements Parcelable {
    public static final Parcelable.Creator<NewsInformationListItem> CREATOR = new Parcelable.Creator<NewsInformationListItem>() { // from class: com.collectpoint.bean.item.NewsInformationListItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewsInformationListItem createFromParcel(Parcel parcel) {
            return new NewsInformationListItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewsInformationListItem[] newArray(int i) {
            return new NewsInformationListItem[i];
        }
    };
    private int ID;
    private String createCode;
    private String createName;
    private String createTime;
    private String createTimeStr;
    private String ifShow;
    private String imgPath;
    private String informationCode;
    private String informationContent;
    private String informationTitle;
    private String informationType;
    private String informationTypeName;
    private String newsOrder;
    private String orgAreaCode;
    private String orgAreaName;
    private String status;
    private String updateCode;
    private String updateTime;

    public NewsInformationListItem() {
    }

    protected NewsInformationListItem(Parcel parcel) {
        this.informationContent = parcel.readString();
        this.updateCode = parcel.readString();
        this.updateTime = parcel.readString();
        this.ifShow = parcel.readString();
        this.informationTypeName = parcel.readString();
        this.informationType = parcel.readString();
        this.orgAreaName = parcel.readString();
        this.newsOrder = parcel.readString();
        this.createTime = parcel.readString();
        this.imgPath = parcel.readString();
        this.orgAreaCode = parcel.readString();
        this.informationCode = parcel.readString();
        this.ID = parcel.readInt();
        this.informationTitle = parcel.readString();
        this.createCode = parcel.readString();
        this.createName = parcel.readString();
        this.createTimeStr = parcel.readString();
        this.status = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCreateCode() {
        return this.createCode;
    }

    public String getCreateName() {
        return this.createName;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getCreateTimeStr() {
        return this.createTimeStr;
    }

    public int getID() {
        return this.ID;
    }

    public String getIfShow() {
        return this.ifShow;
    }

    public String getImgPath() {
        return this.imgPath;
    }

    public String getInformationCode() {
        return this.informationCode;
    }

    public String getInformationContent() {
        return this.informationContent;
    }

    public String getInformationTitle() {
        return this.informationTitle;
    }

    public String getInformationType() {
        return this.informationType;
    }

    public String getInformationTypeName() {
        return this.informationTypeName;
    }

    public String getNewsOrder() {
        return this.newsOrder;
    }

    public String getOrgAreaCode() {
        return this.orgAreaCode;
    }

    public String getOrgAreaName() {
        return this.orgAreaName;
    }

    public String getStatus() {
        return this.status;
    }

    public String getUpdateCode() {
        return this.updateCode;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setCreateCode(String str) {
        this.createCode = str;
    }

    public void setCreateName(String str) {
        this.createName = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setCreateTimeStr(String str) {
        this.createTimeStr = str;
    }

    public void setID(int i) {
        this.ID = i;
    }

    public void setIfShow(String str) {
        this.ifShow = str;
    }

    public void setImgPath(String str) {
        this.imgPath = str;
    }

    public void setInformationCode(String str) {
        this.informationCode = str;
    }

    public void setInformationContent(String str) {
        this.informationContent = str;
    }

    public void setInformationTitle(String str) {
        this.informationTitle = str;
    }

    public void setInformationType(String str) {
        this.informationType = str;
    }

    public void setInformationTypeName(String str) {
        this.informationTypeName = str;
    }

    public void setNewsOrder(String str) {
        this.newsOrder = str;
    }

    public void setOrgAreaCode(String str) {
        this.orgAreaCode = str;
    }

    public void setOrgAreaName(String str) {
        this.orgAreaName = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setUpdateCode(String str) {
        this.updateCode = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.informationContent);
        parcel.writeString(this.updateCode);
        parcel.writeString(this.updateTime);
        parcel.writeString(this.ifShow);
        parcel.writeString(this.informationTypeName);
        parcel.writeString(this.informationType);
        parcel.writeString(this.orgAreaName);
        parcel.writeString(this.newsOrder);
        parcel.writeString(this.createTime);
        parcel.writeString(this.imgPath);
        parcel.writeString(this.orgAreaCode);
        parcel.writeString(this.informationCode);
        parcel.writeInt(this.ID);
        parcel.writeString(this.informationTitle);
        parcel.writeString(this.createCode);
        parcel.writeString(this.createName);
        parcel.writeString(this.createTimeStr);
        parcel.writeString(this.status);
    }
}
