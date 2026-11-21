package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class SortContentTreeByMapItem implements Parcelable {
    public static final Parcelable.Creator<SortContentTreeByMapItem> CREATOR = new Parcelable.Creator<SortContentTreeByMapItem>() { // from class: com.collectpoint.bean.item.SortContentTreeByMapItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SortContentTreeByMapItem createFromParcel(Parcel parcel) {
            return new SortContentTreeByMapItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SortContentTreeByMapItem[] newArray(int i) {
            return new SortContentTreeByMapItem[i];
        }
    };
    private boolean checked;
    private List<SortContentTreeByMapItem> children;
    private String content;
    private String contentCode;
    private String createTime;
    private String id;
    private String name;
    private String parentId;
    private String projectOrgCode;
    private String sortCode;
    private String sortName;
    private String status;
    private String title;
    private String typeCode;
    private String updateCode;
    private String updateTime;

    public SortContentTreeByMapItem() {
        this.checked = false;
    }

    protected SortContentTreeByMapItem(Parcel parcel) {
        this.checked = false;
        this.sortName = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.contentCode = parcel.readString();
        this.updateCode = parcel.readString();
        this.createTime = parcel.readString();
        this.name = parcel.readString();
        this.updateTime = parcel.readString();
        this.id = parcel.readString();
        this.title = parcel.readString();
        this.sortCode = parcel.readString();
        this.parentId = parcel.readString();
        this.content = parcel.readString();
        this.status = parcel.readString();
        this.children = parcel.createTypedArrayList(CREATOR);
        this.typeCode = parcel.readString();
        this.checked = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<SortContentTreeByMapItem> getChildren() {
        return this.children;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentCode() {
        return this.contentCode;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getSortCode() {
        return this.sortCode;
    }

    public String getSortName() {
        return this.sortName;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public String getUpdateCode() {
        return this.updateCode;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setChildren(List<SortContentTreeByMapItem> list) {
        this.children = list;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContentCode(String str) {
        this.contentCode = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setSortCode(String str) {
        this.sortCode = str;
    }

    public void setSortName(String str) {
        this.sortName = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }

    public void setUpdateCode(String str) {
        this.updateCode = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sortName);
        parcel.writeString(this.projectOrgCode);
        parcel.writeString(this.contentCode);
        parcel.writeString(this.updateCode);
        parcel.writeString(this.createTime);
        parcel.writeString(this.name);
        parcel.writeString(this.updateTime);
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.sortCode);
        parcel.writeString(this.parentId);
        parcel.writeString(this.content);
        parcel.writeString(this.status);
        parcel.writeTypedList(this.children);
        parcel.writeString(this.typeCode);
        parcel.writeByte(this.checked ? (byte) 1 : (byte) 0);
    }
}
