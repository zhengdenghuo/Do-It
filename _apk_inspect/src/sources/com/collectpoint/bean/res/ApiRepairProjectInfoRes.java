package com.collectpoint.bean.res;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class ApiRepairProjectInfoRes implements Parcelable {
    public static final Parcelable.Creator<ApiRepairProjectInfoRes> CREATOR = new Parcelable.Creator<ApiRepairProjectInfoRes>() { // from class: com.collectpoint.bean.res.ApiRepairProjectInfoRes.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApiRepairProjectInfoRes createFromParcel(Parcel parcel) {
            return new ApiRepairProjectInfoRes(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApiRepairProjectInfoRes[] newArray(int i) {
            return new ApiRepairProjectInfoRes[i];
        }
    };
    private String budgetSum;
    private String constructionStatus;
    private String constructionStatusStr;
    private String constructionUnitCode;
    private String constructionUnitName;
    private String diseaseNumber;
    private String endPile;
    private String endPileNumber;
    private String endTime;
    private String examineUnitCode;
    private String examineUnitName;
    private String id;
    private String projectCode;
    private String projectCost;
    private List<ApiRepairIncidentInfoRes> projectIncidentList;
    private String projectName;
    private String projectOrgCode;
    private String projectOrgName;
    private String projectStatus;
    private String projectStatusStr;
    private String remark;
    private String settleAccountsUnitCode;
    private String settleAccountsUnitName;
    private String startPile;
    private String startPileNumber;
    private String startTime;
    private String status;
    private String townName;

    public ApiRepairProjectInfoRes() {
    }

    protected ApiRepairProjectInfoRes(Parcel parcel) {
        this.endPile = parcel.readString();
        this.projectOrgName = parcel.readString();
        this.examineUnitName = parcel.readString();
        this.endPileNumber = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.diseaseNumber = parcel.readString();
        this.projectStatus = parcel.readString();
        this.startPileNumber = parcel.readString();
        this.projectCode = parcel.readString();
        this.projectStatusStr = parcel.readString();
        this.projectCost = parcel.readString();
        this.constructionUnitCode = parcel.readString();
        this.settleAccountsUnitCode = parcel.readString();
        this.startTime = parcel.readString();
        this.id = parcel.readString();
        this.endTime = parcel.readString();
        this.projectName = parcel.readString();
        this.constructionUnitName = parcel.readString();
        this.startPile = parcel.readString();
        this.settleAccountsUnitName = parcel.readString();
        this.remark = parcel.readString();
        this.examineUnitCode = parcel.readString();
        this.status = parcel.readString();
        this.constructionStatus = parcel.readString();
        this.constructionStatusStr = parcel.readString();
        this.projectIncidentList = parcel.createTypedArrayList(ApiRepairIncidentInfoRes.CREATOR);
        this.budgetSum = parcel.readString();
        this.townName = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBudgetSum() {
        return this.budgetSum;
    }

    public String getConstructionStatus() {
        return this.constructionStatus;
    }

    public String getConstructionStatusStr() {
        return this.constructionStatusStr;
    }

    public String getConstructionUnitCode() {
        return this.constructionUnitCode;
    }

    public String getConstructionUnitName() {
        return this.constructionUnitName;
    }

    public String getDiseaseNumber() {
        return this.diseaseNumber;
    }

    public String getEndPile() {
        return this.endPile;
    }

    public String getEndPileNumber() {
        return this.endPileNumber;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getExamineUnitCode() {
        return this.examineUnitCode;
    }

    public String getExamineUnitName() {
        return this.examineUnitName;
    }

    public String getId() {
        return this.id;
    }

    public String getProjectCode() {
        return this.projectCode;
    }

    public String getProjectCost() {
        return this.projectCost;
    }

    public List<ApiRepairIncidentInfoRes> getProjectIncidentList() {
        return this.projectIncidentList;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getProjectOrgName() {
        return this.projectOrgName;
    }

    public String getProjectStatus() {
        return this.projectStatus;
    }

    public String getProjectStatusStr() {
        return this.projectStatusStr;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getSettleAccountsUnitCode() {
        return this.settleAccountsUnitCode;
    }

    public String getSettleAccountsUnitName() {
        return this.settleAccountsUnitName;
    }

    public String getStartPile() {
        return this.startPile;
    }

    public String getStartPileNumber() {
        return this.startPileNumber;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTownName() {
        return this.townName;
    }

    public void readFromParcel(Parcel parcel) {
        this.endPile = parcel.readString();
        this.projectOrgName = parcel.readString();
        this.examineUnitName = parcel.readString();
        this.endPileNumber = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.diseaseNumber = parcel.readString();
        this.projectStatus = parcel.readString();
        this.startPileNumber = parcel.readString();
        this.projectCode = parcel.readString();
        this.projectCost = parcel.readString();
        this.constructionUnitCode = parcel.readString();
        this.settleAccountsUnitCode = parcel.readString();
        this.startTime = parcel.readString();
        this.id = parcel.readString();
        this.endTime = parcel.readString();
        this.projectName = parcel.readString();
        this.constructionUnitName = parcel.readString();
        this.startPile = parcel.readString();
        this.settleAccountsUnitName = parcel.readString();
        this.examineUnitCode = parcel.readString();
        this.status = parcel.readString();
        this.projectIncidentList = new ArrayList();
        this.budgetSum = parcel.readString();
        this.townName = parcel.readString();
        parcel.readList(this.projectIncidentList, ApiRepairIncidentInfoRes.class.getClassLoader());
    }

    public void setConstructionUnitCode(String str) {
        this.constructionUnitCode = str;
    }

    public void setConstructionUnitName(String str) {
        this.constructionUnitName = str;
    }

    public void setDiseaseNumber(String str) {
        this.diseaseNumber = str;
    }

    public void setEndPile(String str) {
        this.endPile = str;
    }

    public void setEndPileNumber(String str) {
        this.endPileNumber = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setExamineUnitCode(String str) {
        this.examineUnitCode = str;
    }

    public void setExamineUnitName(String str) {
        this.examineUnitName = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setProjectCode(String str) {
        this.projectCode = str;
    }

    public void setProjectCost(String str) {
        this.projectCost = str;
    }

    public void setProjectIncidentList(List<ApiRepairIncidentInfoRes> list) {
        this.projectIncidentList = list;
    }

    public void setProjectName(String str) {
        this.projectName = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setProjectOrgName(String str) {
        this.projectOrgName = str;
    }

    public void setProjectStatus(String str) {
        this.projectStatus = str;
    }

    public void setSettleAccountsUnitCode(String str) {
        this.settleAccountsUnitCode = str;
    }

    public void setSettleAccountsUnitName(String str) {
        this.settleAccountsUnitName = str;
    }

    public void setStartPileNo(String str) {
        this.startPile = str;
    }

    public void setStartPileNumber(String str) {
        this.startPileNumber = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.endPile);
        parcel.writeString(this.projectOrgName);
        parcel.writeString(this.examineUnitName);
        parcel.writeString(this.endPileNumber);
        parcel.writeString(this.projectOrgCode);
        parcel.writeString(this.diseaseNumber);
        parcel.writeString(this.projectStatus);
        parcel.writeString(this.startPileNumber);
        parcel.writeString(this.projectCode);
        parcel.writeString(this.projectStatusStr);
        parcel.writeString(this.projectCost);
        parcel.writeString(this.constructionUnitCode);
        parcel.writeString(this.settleAccountsUnitCode);
        parcel.writeString(this.startTime);
        parcel.writeString(this.id);
        parcel.writeString(this.endTime);
        parcel.writeString(this.projectName);
        parcel.writeString(this.constructionUnitName);
        parcel.writeString(this.startPile);
        parcel.writeString(this.settleAccountsUnitName);
        parcel.writeString(this.remark);
        parcel.writeString(this.examineUnitCode);
        parcel.writeString(this.status);
        parcel.writeString(this.constructionStatus);
        parcel.writeString(this.constructionStatusStr);
        parcel.writeTypedList(this.projectIncidentList);
        parcel.writeString(this.budgetSum);
        parcel.writeString(this.townName);
    }
}
