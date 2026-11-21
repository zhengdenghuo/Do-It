package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class DiseaseListItem implements Parcelable {
    public static final Parcelable.Creator<DiseaseListItem> CREATOR = new Parcelable.Creator<DiseaseListItem>() { // from class: com.collectpoint.bean.item.DiseaseListItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DiseaseListItem createFromParcel(Parcel parcel) {
            return new DiseaseListItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DiseaseListItem[] newArray(int i) {
            return new DiseaseListItem[i];
        }
    };
    private String DiseaseName;
    private String checkPartName;
    private String decisionConclusion;
    private String diseaseComponentsCode;
    private String diseaseComponentsName;
    private String diseaseNumber;
    private String diseaseSortCode;
    private String diseaseSortName;
    private String diseaseTypeCode;
    private String diseaseTypeName;
    private String eventDesc;
    private int id;
    private List<String> imageList;
    private List<AlbumItem> imgList;
    private boolean isBottom;
    private List<PartsDiseaseResultsItem> list;
    private String measure;
    private String measureUnit;
    private String measuresOpinion;
    private String mileagePileNumber;
    private List<FilePathItem> photoList;
    private List<String> photoLists;
    private String urgentLevel;
    private String urgentName;

    public DiseaseListItem() {
    }

    protected DiseaseListItem(Parcel parcel) {
        this.diseaseComponentsCode = parcel.readString();
        this.diseaseComponentsName = parcel.readString();
        this.diseaseSortCode = parcel.readString();
        this.diseaseSortName = parcel.readString();
        this.diseaseTypeCode = parcel.readString();
        this.diseaseTypeName = parcel.readString();
        this.measure = parcel.readString();
        this.diseaseNumber = parcel.readString();
        this.mileagePileNumber = parcel.readString();
        this.decisionConclusion = parcel.readString();
        this.eventDesc = parcel.readString();
        this.urgentLevel = parcel.readString();
        this.urgentName = parcel.readString();
        this.measuresOpinion = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.photoList = arrayList;
        parcel.readList(arrayList, FilePathItem.class.getClassLoader());
        this.photoLists = parcel.createStringArrayList();
        this.checkPartName = parcel.readString();
        this.DiseaseName = parcel.readString();
        this.isBottom = parcel.readByte() != 0;
        ArrayList arrayList2 = new ArrayList();
        this.list = arrayList2;
        parcel.readList(arrayList2, PartsDiseaseResultsItem.class.getClassLoader());
        this.id = parcel.readInt();
        this.imageList = parcel.createStringArrayList();
        this.imgList = parcel.createTypedArrayList(AlbumItem.CREATOR);
        this.measureUnit = parcel.readString();
    }

    public DiseaseListItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.diseaseComponentsCode = str;
        this.diseaseComponentsName = str2;
        this.diseaseSortCode = str3;
        this.diseaseSortName = str4;
        this.diseaseTypeCode = str5;
        this.diseaseTypeName = str6;
        this.measure = str7;
        this.diseaseNumber = str8;
        this.mileagePileNumber = str9;
        this.decisionConclusion = str10;
        this.eventDesc = str11;
        this.measuresOpinion = str12;
    }

    public DiseaseListItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, List<String> list, String str15) {
        this.diseaseComponentsCode = str;
        this.diseaseComponentsName = str2;
        this.diseaseSortCode = str3;
        this.diseaseSortName = str4;
        this.diseaseTypeCode = str5;
        this.diseaseTypeName = str6;
        this.measure = str7;
        this.diseaseNumber = str8;
        this.mileagePileNumber = str9;
        this.decisionConclusion = str10;
        this.eventDesc = str11;
        this.urgentLevel = str13;
        this.urgentName = str14;
        this.measuresOpinion = str12;
        this.measureUnit = str15;
        this.photoLists = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCheckPartName() {
        return this.checkPartName;
    }

    public String getDecisionConclusion() {
        return this.decisionConclusion;
    }

    public String getDiseaseComponentsCode() {
        return this.diseaseComponentsCode;
    }

    public String getDiseaseComponentsName() {
        return this.diseaseComponentsName;
    }

    public String getDiseaseName() {
        return this.DiseaseName;
    }

    public String getDiseaseNumber() {
        return this.diseaseNumber;
    }

    public String getDiseaseSortCode() {
        return this.diseaseSortCode;
    }

    public String getDiseaseSortName() {
        return this.diseaseSortName;
    }

    public String getDiseaseTypeCode() {
        return this.diseaseTypeCode;
    }

    public String getDiseaseTypeName() {
        return this.diseaseTypeName;
    }

    public String getEventDesc() {
        return this.eventDesc;
    }

    public int getId() {
        return this.id;
    }

    public List<String> getImageList() {
        return this.imageList;
    }

    public List<AlbumItem> getImgList() {
        return this.imgList;
    }

    public List<PartsDiseaseResultsItem> getList() {
        return this.list;
    }

    public String getMeasure() {
        return this.measure;
    }

    public String getMeasureUnit() {
        return this.measureUnit;
    }

    public String getMeasuresOpinion() {
        return this.measuresOpinion;
    }

    public String getMileagePileNumber() {
        return this.mileagePileNumber;
    }

    public List<FilePathItem> getPhotoList() {
        return this.photoList;
    }

    public List<String> getPhotoLists() {
        return this.photoLists;
    }

    public String getUrgentLevel() {
        return this.urgentLevel;
    }

    public String getUrgentName() {
        return this.urgentName;
    }

    public boolean isBottom() {
        return this.isBottom;
    }

    public void readFromParcel(Parcel parcel) {
        this.diseaseComponentsCode = parcel.readString();
        this.diseaseComponentsName = parcel.readString();
        this.diseaseSortCode = parcel.readString();
        this.diseaseSortName = parcel.readString();
        this.diseaseTypeCode = parcel.readString();
        this.diseaseTypeName = parcel.readString();
        this.measure = parcel.readString();
        this.diseaseNumber = parcel.readString();
        this.mileagePileNumber = parcel.readString();
        this.decisionConclusion = parcel.readString();
        this.eventDesc = parcel.readString();
        this.urgentLevel = parcel.readString();
        this.urgentName = parcel.readString();
        this.measuresOpinion = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.photoList = arrayList;
        parcel.readList(arrayList, FilePathItem.class.getClassLoader());
        this.photoLists = parcel.createStringArrayList();
        this.checkPartName = parcel.readString();
        this.DiseaseName = parcel.readString();
        this.isBottom = parcel.readByte() != 0;
        ArrayList arrayList2 = new ArrayList();
        this.list = arrayList2;
        parcel.readList(arrayList2, PartsDiseaseResultsItem.class.getClassLoader());
        this.id = parcel.readInt();
        this.imageList = parcel.createStringArrayList();
        this.imgList = parcel.createTypedArrayList(AlbumItem.CREATOR);
        this.measureUnit = parcel.readString();
    }

    public void setBottom(boolean z) {
        this.isBottom = z;
    }

    public void setCheckPartName(String str) {
        this.checkPartName = str;
    }

    public void setDecisionConclusion(String str) {
        this.decisionConclusion = str;
    }

    public void setDiseaseComponentsCode(String str) {
        this.diseaseComponentsCode = str;
    }

    public void setDiseaseComponentsName(String str) {
        this.diseaseComponentsName = str;
    }

    public void setDiseaseName(String str) {
        this.DiseaseName = str;
    }

    public void setDiseaseNumber(String str) {
        this.diseaseNumber = str;
    }

    public void setDiseaseSortCode(String str) {
        this.diseaseSortCode = str;
    }

    public void setDiseaseSortName(String str) {
        this.diseaseSortName = str;
    }

    public void setDiseaseTypeCode(String str) {
        this.diseaseTypeCode = str;
    }

    public void setDiseaseTypeName(String str) {
        this.diseaseTypeName = str;
    }

    public void setEventDesc(String str) {
        this.eventDesc = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setImageList(List<String> list) {
        this.imageList = list;
    }

    public void setImgList(List<AlbumItem> list) {
        this.imgList = list;
    }

    public void setList(List<PartsDiseaseResultsItem> list) {
        this.list = list;
    }

    public void setMeasure(String str) {
        this.measure = str;
    }

    public void setMeasureUnit(String str) {
        this.measureUnit = str;
    }

    public void setMeasuresOpinion(String str) {
        this.measuresOpinion = str;
    }

    public void setMileagePileNumber(String str) {
        this.mileagePileNumber = str;
    }

    public void setPhotoList(List<FilePathItem> list) {
        this.photoList = list;
    }

    public void setPhotoLists(List<String> list) {
        this.photoLists = list;
    }

    public void setUrgentLevel(String str) {
        this.urgentLevel = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.diseaseComponentsCode);
        parcel.writeString(this.diseaseComponentsName);
        parcel.writeString(this.diseaseSortCode);
        parcel.writeString(this.diseaseSortName);
        parcel.writeString(this.diseaseTypeCode);
        parcel.writeString(this.diseaseTypeName);
        parcel.writeString(this.measure);
        parcel.writeString(this.diseaseNumber);
        parcel.writeString(this.mileagePileNumber);
        parcel.writeString(this.decisionConclusion);
        parcel.writeString(this.eventDesc);
        parcel.writeString(this.urgentLevel);
        parcel.writeString(this.urgentName);
        parcel.writeString(this.measuresOpinion);
        parcel.writeList(this.photoList);
        parcel.writeStringList(this.photoLists);
        parcel.writeString(this.checkPartName);
        parcel.writeString(this.DiseaseName);
        parcel.writeByte(this.isBottom ? (byte) 1 : (byte) 0);
        parcel.writeList(this.list);
        parcel.writeInt(this.id);
        parcel.writeStringList(this.imageList);
        parcel.writeTypedList(this.imgList);
        parcel.writeString(this.measureUnit);
    }
}
