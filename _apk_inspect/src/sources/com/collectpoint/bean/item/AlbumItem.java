package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class AlbumItem implements Parcelable {
    public static final Parcelable.Creator<AlbumItem> CREATOR = new Parcelable.Creator<AlbumItem>() { // from class: com.collectpoint.bean.item.AlbumItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumItem createFromParcel(Parcel parcel) {
            return new AlbumItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumItem[] newArray(int i) {
            return new AlbumItem[i];
        }
    };
    private String CompressedPath;
    private String ID;
    private String createCode;
    private String createTime;
    private String fileSource;
    private String fileType;
    private boolean isAdd;
    private String localUrl;
    private int mState;
    private String manageCode;
    private String problemCode;
    private String smallFilePath;
    private String status;
    private int type;

    @SerializedName("filePath")
    private String url;

    public AlbumItem() {
        this.isAdd = false;
    }

    public AlbumItem(int i, String str) {
        this.isAdd = false;
        this.type = i;
        this.localUrl = str;
    }

    public AlbumItem(int i, String str, int i2) {
        this.isAdd = false;
        this.type = i;
        this.localUrl = str;
        this.mState = i2;
    }

    protected AlbumItem(Parcel parcel) {
        this.isAdd = false;
        this.localUrl = parcel.readString();
        this.url = parcel.readString();
        this.isAdd = parcel.readByte() != 0;
        this.type = parcel.readInt();
        this.mState = parcel.readInt();
        this.CompressedPath = parcel.readString();
        this.ID = parcel.readString();
        this.problemCode = parcel.readString();
        this.status = parcel.readString();
        this.createCode = parcel.readString();
        this.createTime = parcel.readString();
        this.manageCode = parcel.readString();
        this.smallFilePath = parcel.readString();
        this.fileSource = parcel.readString();
        this.fileType = parcel.readString();
    }

    public AlbumItem(String str, int i, int i2) {
        this.isAdd = false;
        this.type = i;
        this.url = str;
        this.mState = i2;
    }

    public AlbumItem(boolean z, int i) {
        this.isAdd = false;
        this.type = i;
        this.isAdd = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCompressedPath() {
        return this.CompressedPath;
    }

    public String getCreateCode() {
        return this.createCode;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getFileSource() {
        return this.fileSource;
    }

    public String getFileType() {
        return this.fileType;
    }

    public String getID() {
        return this.ID;
    }

    public String getLocalUrl() {
        return this.localUrl;
    }

    public String getManageCode() {
        return this.manageCode;
    }

    public String getProblemCode() {
        return this.problemCode;
    }

    public String getSmallFilePath() {
        return this.smallFilePath;
    }

    public String getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int getmState() {
        return this.mState;
    }

    public boolean isAdd() {
        return this.isAdd;
    }

    public void setAdd(boolean z) {
        this.isAdd = z;
    }

    public void setCompressedPath(String str) {
        this.CompressedPath = str;
    }

    public void setCreateCode(String str) {
        this.createCode = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setFileSource(String str) {
        this.fileSource = str;
    }

    public void setFileType(String str) {
        this.fileType = str;
    }

    public void setID(String str) {
        this.ID = str;
    }

    public void setLocalUrl(String str) {
        this.localUrl = str;
    }

    public void setManageCode(String str) {
        this.manageCode = str;
    }

    public void setProblemCode(String str) {
        this.problemCode = str;
    }

    public void setSmallFilePath(String str) {
        this.smallFilePath = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setmState(int i) {
        this.mState = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.localUrl);
        parcel.writeString(this.url);
        parcel.writeByte(this.isAdd ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.type);
        parcel.writeInt(this.mState);
        parcel.writeString(this.CompressedPath);
        parcel.writeString(this.ID);
        parcel.writeString(this.problemCode);
        parcel.writeString(this.status);
        parcel.writeString(this.createCode);
        parcel.writeString(this.createTime);
        parcel.writeString(this.manageCode);
        parcel.writeString(this.smallFilePath);
        parcel.writeString(this.fileSource);
        parcel.writeString(this.fileType);
    }
}
