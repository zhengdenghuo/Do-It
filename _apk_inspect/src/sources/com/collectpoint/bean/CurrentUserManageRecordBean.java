package com.collectpoint.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.collectpoint.bean.item.AlbumItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class CurrentUserManageRecordBean implements Parcelable {
    public static final Parcelable.Creator<CurrentUserManageRecordBean> CREATOR = new Parcelable.Creator<CurrentUserManageRecordBean>() { // from class: com.collectpoint.bean.CurrentUserManageRecordBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CurrentUserManageRecordBean createFromParcel(Parcel parcel) {
            return new CurrentUserManageRecordBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CurrentUserManageRecordBean[] newArray(int i) {
            return new CurrentUserManageRecordBean[i];
        }
    };
    private String ID;
    private String auditRemark;
    private String auditStatus;
    private String auditStatusName;
    private String auditTime;
    private boolean compile;
    private String createCode;
    private String manageCode;
    private String manageDetail;
    private String manageOpion;
    private String manageRemark;
    private String manageStatus;
    private String manageStatusName;
    private String manageTime;
    private String manageTimeStr;
    private String manageUserCode;
    private String manageUserName;
    private List<AlbumItem> photoList;
    private String problemCode;
    private String status;
    private String submitStatus;
    private String updateTime;
    private List<AlbumItem> videoList;

    public CurrentUserManageRecordBean() {
        this.compile = false;
    }

    protected CurrentUserManageRecordBean(Parcel parcel) {
        this.compile = false;
        this.problemCode = parcel.readString();
        this.manageCode = parcel.readString();
        this.manageDetail = parcel.readString();
        this.manageStatusName = parcel.readString();
        this.manageTimeStr = parcel.readString();
        this.manageOpion = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.videoList = arrayList;
        parcel.readList(arrayList, AlbumItem.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.photoList = arrayList2;
        parcel.readList(arrayList2, AlbumItem.class.getClassLoader());
        this.manageRemark = parcel.readString();
        this.manageUserName = parcel.readString();
        this.manageUserCode = parcel.readString();
        this.manageTime = parcel.readString();
        this.ID = parcel.readString();
        this.createCode = parcel.readString();
        this.manageStatus = parcel.readString();
        this.status = parcel.readString();
        this.compile = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAuditRemark() {
        return this.auditRemark;
    }

    public String getAuditStatus() {
        return this.auditStatus;
    }

    public String getAuditStatusName() {
        return this.auditStatusName;
    }

    public String getAuditTime() {
        return this.auditTime;
    }

    public String getCreateCode() {
        return this.createCode;
    }

    public String getID() {
        return this.ID;
    }

    public String getManageCode() {
        return this.manageCode;
    }

    public String getManageDetail() {
        return this.manageDetail;
    }

    public String getManageOpion() {
        return this.manageOpion;
    }

    public String getManageRemark() {
        return this.manageRemark;
    }

    public String getManageStatus() {
        return this.manageStatus;
    }

    public String getManageStatusName() {
        return this.manageStatusName;
    }

    public String getManageTime() {
        return this.manageTime;
    }

    public String getManageTimeStr() {
        return this.manageTimeStr;
    }

    public String getManageUserCode() {
        return this.manageUserCode;
    }

    public String getManageUserName() {
        return this.manageUserName;
    }

    public List<AlbumItem> getPhotoList() {
        return this.photoList;
    }

    public String getProblemCode() {
        return this.problemCode;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSubmitStatus() {
        return this.submitStatus;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public List<AlbumItem> getVideoList() {
        return this.videoList;
    }

    public boolean isCompile() {
        return this.compile;
    }

    public void setCompile(boolean z) {
        this.compile = z;
    }

    public void setCreateCode(String str) {
        this.createCode = str;
    }

    public void setID(String str) {
        this.ID = str;
    }

    public void setManageCode(String str) {
        this.manageCode = str;
    }

    public void setManageDetail(String str) {
        this.manageDetail = str;
    }

    public void setManageOpion(String str) {
        this.manageOpion = str;
    }

    public void setManageRemark(String str) {
        this.manageRemark = str;
    }

    public void setManageStatus(String str) {
        this.manageStatus = str;
    }

    public void setManageStatusName(String str) {
        this.manageStatusName = str;
    }

    public void setManageTime(String str) {
        this.manageTime = str;
    }

    public void setManageTimeStr(String str) {
        this.manageTimeStr = str;
    }

    public void setManageUserCode(String str) {
        this.manageUserCode = str;
    }

    public void setManageUserName(String str) {
        this.manageUserName = str;
    }

    public void setPhotoList(List<AlbumItem> list) {
        this.photoList = list;
    }

    public void setProblemCode(String str) {
        this.problemCode = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setVideoList(List<AlbumItem> list) {
        this.videoList = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.problemCode);
        parcel.writeString(this.manageCode);
        parcel.writeString(this.manageDetail);
        parcel.writeString(this.manageStatusName);
        parcel.writeString(this.manageTimeStr);
        parcel.writeString(this.manageOpion);
        parcel.writeList(this.videoList);
        parcel.writeList(this.photoList);
        parcel.writeString(this.manageRemark);
        parcel.writeString(this.manageUserName);
        parcel.writeString(this.manageUserCode);
        parcel.writeString(this.manageTime);
        parcel.writeString(this.ID);
        parcel.writeString(this.createCode);
        parcel.writeString(this.manageStatus);
        parcel.writeString(this.status);
        parcel.writeByte(this.compile ? (byte) 1 : (byte) 0);
    }
}
