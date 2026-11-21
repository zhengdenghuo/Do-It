package com.collectpoint.bean.res;

import android.os.Parcel;
import android.os.Parcelable;
import com.collectpoint.bean.item.FieldListItem;
import com.collectpoint.bean.item.PointItem;
import com.collectpoint.widget.recycler.SSelectable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class InsertPointInfoRes extends SSelectable implements Parcelable {
    public static final Parcelable.Creator<InsertPointInfoRes> CREATOR = new Parcelable.Creator<InsertPointInfoRes>() { // from class: com.collectpoint.bean.res.InsertPointInfoRes.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InsertPointInfoRes createFromParcel(Parcel parcel) {
            return new InsertPointInfoRes(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InsertPointInfoRes[] newArray(int i) {
            return new InsertPointInfoRes[i];
        }
    };
    private String address;
    private String appHomeIcon;
    private String appMapIcon;
    private String collectionCode;
    private String collectionName;
    private String collectionPointName;
    private String collectionTime;
    private String collectionType;
    private List<FieldListItem> fieldList;
    private String firstCollectionCode;
    private String firstCollectionName;
    private String latitude;
    private String longitude;
    private List<PointItem> pointList;
    private String projectCollectionCode;
    private String projectOrgCode;
    private String projectOrgName;
    private String recordCode;
    private int timePer;

    public InsertPointInfoRes() {
    }

    protected InsertPointInfoRes(Parcel parcel) {
        this.projectOrgCode = parcel.readString();
        this.projectOrgName = parcel.readString();
        this.collectionPointName = parcel.readString();
        this.collectionCode = parcel.readString();
        this.address = parcel.readString();
        this.appHomeIcon = parcel.readString();
        this.appMapIcon = parcel.readString();
        this.collectionTime = parcel.readString();
        this.longitude = parcel.readString();
        this.latitude = parcel.readString();
        this.recordCode = parcel.readString();
        this.collectionType = parcel.readString();
        this.collectionName = parcel.readString();
        this.projectCollectionCode = parcel.readString();
        this.firstCollectionCode = parcel.readString();
        this.firstCollectionName = parcel.readString();
        this.timePer = parcel.readInt();
        this.fieldList = parcel.createTypedArrayList(FieldListItem.CREATOR);
        this.pointList = parcel.createTypedArrayList(PointItem.CREATOR);
    }

    public InsertPointInfoRes(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10, String str11, String str12) {
        this.projectOrgCode = str;
        this.projectOrgName = str2;
        this.collectionPointName = str3;
        this.collectionCode = str4;
        this.projectCollectionCode = str6;
        this.address = str9;
        this.firstCollectionName = str8;
        this.firstCollectionCode = str7;
        this.collectionName = str5;
        this.timePer = i;
        this.longitude = str10;
        this.latitude = str11;
        this.collectionTime = str12;
    }

    public InsertPointInfoRes(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.projectOrgCode = str;
        this.projectOrgName = str2;
        this.collectionPointName = str3;
        this.collectionCode = str4;
        this.projectCollectionCode = str5;
        this.address = str6;
        this.longitude = str7;
        this.latitude = str8;
        this.collectionTime = str9;
    }

    public InsertPointInfoRes(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, List<FieldListItem> list) {
        this.recordCode = str;
        this.projectOrgCode = str2;
        this.projectOrgName = str3;
        this.collectionName = str6;
        this.collectionPointName = str4;
        this.collectionTime = str13;
        this.collectionCode = str5;
        this.projectCollectionCode = str7;
        this.firstCollectionCode = str8;
        this.firstCollectionName = str9;
        this.address = str10;
        this.longitude = str11;
        this.latitude = str12;
        this.fieldList = list;
    }

    public InsertPointInfoRes(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, List<FieldListItem> list) {
        this.projectOrgCode = str;
        this.projectOrgName = str2;
        this.collectionTime = str12;
        this.collectionPointName = str3;
        this.collectionCode = str4;
        this.firstCollectionCode = str7;
        this.firstCollectionName = str8;
        this.address = str9;
        this.projectCollectionCode = str6;
        this.longitude = str10;
        this.collectionName = str5;
        this.latitude = str11;
        this.fieldList = list;
    }

    public InsertPointInfoRes(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<FieldListItem> list) {
        this.recordCode = str;
        this.projectOrgCode = str2;
        this.projectOrgName = str3;
        this.collectionPointName = str4;
        this.collectionTime = str10;
        this.collectionCode = str5;
        this.projectCollectionCode = str6;
        this.address = str7;
        this.longitude = str8;
        this.latitude = str9;
        this.fieldList = list;
    }

    public InsertPointInfoRes(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<FieldListItem> list) {
        this.projectOrgCode = str;
        this.projectOrgName = str2;
        this.collectionTime = str9;
        this.projectCollectionCode = str5;
        this.collectionPointName = str3;
        this.collectionCode = str4;
        this.address = str6;
        this.longitude = str7;
        this.latitude = str8;
        this.fieldList = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public String getAppHomeIcon() {
        return this.appHomeIcon;
    }

    public String getAppMapIcon() {
        return this.appMapIcon;
    }

    public String getCollectionCode() {
        return this.collectionCode;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    public String getCollectionPointName() {
        return this.collectionPointName;
    }

    public String getCollectionTime() {
        return this.collectionTime;
    }

    public String getCollectionType() {
        return this.collectionType;
    }

    public List<FieldListItem> getFieldList() {
        return this.fieldList;
    }

    public String getFirstCollectionCode() {
        return this.firstCollectionCode;
    }

    public String getFirstCollectionName() {
        return this.firstCollectionName;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public List<PointItem> getPointList() {
        return this.pointList;
    }

    public String getProjectCollectionCode() {
        return this.projectCollectionCode;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getProjectOrgName() {
        return this.projectOrgName;
    }

    public String getRecordCode() {
        return this.recordCode;
    }

    public int getTimePer() {
        return this.timePer;
    }

    public void readFromParcel(Parcel parcel) {
        this.projectOrgCode = parcel.readString();
        this.projectOrgName = parcel.readString();
        this.collectionPointName = parcel.readString();
        this.collectionCode = parcel.readString();
        this.address = parcel.readString();
        this.appHomeIcon = parcel.readString();
        this.appMapIcon = parcel.readString();
        this.collectionTime = parcel.readString();
        this.longitude = parcel.readString();
        this.latitude = parcel.readString();
        this.recordCode = parcel.readString();
        this.collectionType = parcel.readString();
        this.collectionName = parcel.readString();
        this.projectCollectionCode = parcel.readString();
        this.firstCollectionCode = parcel.readString();
        this.firstCollectionName = parcel.readString();
        this.timePer = parcel.readInt();
        this.fieldList = parcel.createTypedArrayList(FieldListItem.CREATOR);
        this.pointList = parcel.createTypedArrayList(PointItem.CREATOR);
    }

    public void setCollectionName(String str) {
        this.collectionName = str;
    }

    public void setCollectionType(String str) {
        this.collectionType = str;
    }

    public void setPointList(List<PointItem> list) {
        this.pointList = list;
    }

    public void setTimePer(int i) {
        this.timePer = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.projectOrgCode);
        parcel.writeString(this.projectOrgName);
        parcel.writeString(this.collectionPointName);
        parcel.writeString(this.collectionCode);
        parcel.writeString(this.address);
        parcel.writeString(this.appHomeIcon);
        parcel.writeString(this.appMapIcon);
        parcel.writeString(this.collectionTime);
        parcel.writeString(this.longitude);
        parcel.writeString(this.latitude);
        parcel.writeString(this.recordCode);
        parcel.writeString(this.collectionType);
        parcel.writeString(this.collectionName);
        parcel.writeString(this.projectCollectionCode);
        parcel.writeString(this.firstCollectionCode);
        parcel.writeString(this.firstCollectionName);
        parcel.writeInt(this.timePer);
        parcel.writeTypedList(this.fieldList);
        parcel.writeTypedList(this.pointList);
    }
}
