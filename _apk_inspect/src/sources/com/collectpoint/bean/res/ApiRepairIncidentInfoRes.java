package com.collectpoint.bean.res;

import android.os.Parcel;
import android.os.Parcelable;
import com.collectpoint.bean.item.AlbumItem;
import com.collectpoint.bean.item.TailRecordListItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class ApiRepairIncidentInfoRes implements Parcelable {
    public static final Parcelable.Creator<ApiRepairIncidentInfoRes> CREATOR = new Parcelable.Creator<ApiRepairIncidentInfoRes>() { // from class: com.collectpoint.bean.res.ApiRepairIncidentInfoRes.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApiRepairIncidentInfoRes createFromParcel(Parcel parcel) {
            return new ApiRepairIncidentInfoRes(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApiRepairIncidentInfoRes[] newArray(int i) {
            return new ApiRepairIncidentInfoRes[i];
        }
    };
    private String acceptanceRemark;
    private String acceptanceStatus;
    private String acceptanceStatusStr;
    private String auditTime;
    private String auditTimeStr;
    private String auditUnitCode;
    private String auditUnitName;
    private String bridgeInspectRecordCode;
    private String checkTypeCode;
    private String checkTypeName;
    private String cityCode;
    private String cityName;
    private String completeTime;
    private String completeTimeStr;
    private String constructionStatus;
    private String constructionStatusStr;
    private String createTime;
    private String decisionConclusion;
    private String decomposeOpinion;
    private String decomposeTime;
    private String decomposeTimeStr;
    private String decomposeType;
    private String diseaseComponentsCode;
    private String diseaseComponentsName;
    private String diseaseNumber;
    private String diseaseSortCode;
    private String diseaseSortName;
    private String diseaseTypeCode;
    private String diseaseTypeName;
    private String districtCode;
    private String districtName;
    private String eventCode;
    private String eventDesc;
    private List<AlbumItem> eventManagePhotoList;
    private List<AlbumItem> eventPhotoList;
    private String eventSource;
    private String eventStatus;
    private String eventStatusName;
    private List<AlbumItem> eventVideoList;
    private String expiredDate;
    private String id;
    private String ifSelfProcess;
    private Double latitude;
    private String lineCode;
    private String lineName;
    private Double longitude;
    private String manageCode;
    private String manageDetail;
    private String managePeriod;
    private List<ManageRecordListRes> manageRecordList;
    private String manageTime;
    private String manageTimeStr;
    private String manageUnitCode;
    private String manageUnitName;
    private String measure;
    private String measureUnit;
    private String measuresOpinion;
    private String mileagePileNumber;
    private String minorRepairStatus;
    private String objectTypeCode;
    private String patrolObjectCode;
    private String patrolObjectName;
    private String positionPileNumber;
    private String processType;
    private String processTypeName;
    private String projectCode;
    private String projectName;
    private String projectOrgCode;
    private String projectOrgName;
    private String projectStatus;
    private String projectStatusName;
    private String provinceCode;
    private String provinceName;
    private String realReportUserCode;
    private String realReportUserName;
    private String repairStatus;
    private String reportTime;
    private String reportTimeStr;
    private String researchDirection;
    private String researchDirectionStr;
    private String shamReportUserCode;
    private String shamReportUserName;
    private String specificLocation;
    private List<TailRecordListItem> tailRecordList;
    private String townCode;
    private String townName;
    private String urgentLevel;
    private String urgentLevelName;
    private String villageCode;
    private String villageName;

    public static class EventPhotoListRes implements Parcelable {
        public static final Parcelable.Creator<EventPhotoListRes> CREATOR = new Parcelable.Creator<EventPhotoListRes>() { // from class: com.collectpoint.bean.res.ApiRepairIncidentInfoRes.EventPhotoListRes.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public EventPhotoListRes createFromParcel(Parcel parcel) {
                return new EventPhotoListRes(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public EventPhotoListRes[] newArray(int i) {
                return new EventPhotoListRes[i];
            }
        };
        private String eventCode;
        private String filePath;
        private String fileSource;
        private String fileType;
        private String smallFilePath;

        public EventPhotoListRes() {
        }

        protected EventPhotoListRes(Parcel parcel) {
            this.eventCode = parcel.readString();
            this.filePath = parcel.readString();
            this.fileSource = parcel.readString();
            this.smallFilePath = parcel.readString();
            this.fileType = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getEventCode() {
            return this.eventCode;
        }

        public String getFilePath() {
            return this.filePath;
        }

        public String getFileSource() {
            return this.fileSource;
        }

        public String getFileType() {
            return this.fileType;
        }

        public String getSmallFilePath() {
            return this.smallFilePath;
        }

        public void readFromParcel(Parcel parcel) {
            this.eventCode = parcel.readString();
            this.filePath = parcel.readString();
            this.fileSource = parcel.readString();
            this.smallFilePath = parcel.readString();
            this.fileType = parcel.readString();
        }

        public void setEventCode(String str) {
            this.eventCode = str;
        }

        public void setFilePath(String str) {
            this.filePath = str;
        }

        public void setFileSource(String str) {
            this.fileSource = str;
        }

        public void setFileType(String str) {
            this.fileType = str;
        }

        public void setSmallFilePath(String str) {
            this.smallFilePath = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.eventCode);
            parcel.writeString(this.filePath);
            parcel.writeString(this.fileSource);
            parcel.writeString(this.smallFilePath);
            parcel.writeString(this.fileType);
        }
    }

    public static class EventVideoListRes implements Parcelable {
        public static final Parcelable.Creator<EventVideoListRes> CREATOR = new Parcelable.Creator<EventVideoListRes>() { // from class: com.collectpoint.bean.res.ApiRepairIncidentInfoRes.EventVideoListRes.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public EventVideoListRes createFromParcel(Parcel parcel) {
                return new EventVideoListRes(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public EventVideoListRes[] newArray(int i) {
                return new EventVideoListRes[i];
            }
        };
        private String eventCode;
        private String filePath;

        public EventVideoListRes() {
        }

        protected EventVideoListRes(Parcel parcel) {
            this.eventCode = parcel.readString();
            this.filePath = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            this.eventCode = parcel.readString();
            this.filePath = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.eventCode);
            parcel.writeString(this.filePath);
        }
    }

    public static class ManageRecordListRes implements Parcelable {
        public static final Parcelable.Creator<ManageRecordListRes> CREATOR = new Parcelable.Creator<ManageRecordListRes>() { // from class: com.collectpoint.bean.res.ApiRepairIncidentInfoRes.ManageRecordListRes.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ManageRecordListRes createFromParcel(Parcel parcel) {
                return new ManageRecordListRes(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ManageRecordListRes[] newArray(int i) {
                return new ManageRecordListRes[i];
            }
        };
        private String auditRemark;
        private String auditStatus;
        private String auditStatusName;
        private String auditTime;
        private String manageDetail;
        private String manageTime;
        private String manageUserName;
        private List<String> photoList;

        public ManageRecordListRes() {
        }

        protected ManageRecordListRes(Parcel parcel) {
            this.manageUserName = parcel.readString();
            this.auditTime = parcel.readString();
            this.manageTime = parcel.readString();
            this.auditStatus = parcel.readString();
            this.auditStatusName = parcel.readString();
            this.auditRemark = parcel.readString();
            this.photoList = parcel.createStringArrayList();
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

        public String getManageDetail() {
            return this.manageDetail;
        }

        public String getManageTime() {
            return this.manageTime;
        }

        public String getManageUserName() {
            return this.manageUserName;
        }

        public List<String> getPhotoList() {
            return this.photoList;
        }

        public void readFromParcel(Parcel parcel) {
            this.manageUserName = parcel.readString();
            this.manageTime = parcel.readString();
            this.auditStatus = parcel.readString();
            this.auditStatusName = parcel.readString();
            this.auditRemark = parcel.readString();
            ArrayList arrayList = new ArrayList();
            this.photoList = arrayList;
            parcel.readList(arrayList, AlbumItem.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.manageUserName);
            parcel.writeString(this.auditTime);
            parcel.writeString(this.manageTime);
            parcel.writeString(this.auditStatus);
            parcel.writeString(this.auditStatusName);
            parcel.writeString(this.auditRemark);
            parcel.writeStringList(this.photoList);
        }
    }

    public ApiRepairIncidentInfoRes() {
    }

    protected ApiRepairIncidentInfoRes(Parcel parcel) {
        this.townCode = parcel.readString();
        this.manageTimeStr = parcel.readString();
        this.measuresOpinion = parcel.readString();
        this.diseaseNumber = parcel.readString();
        this.acceptanceRemark = parcel.readString();
        this.acceptanceStatus = parcel.readString();
        this.constructionStatus = parcel.readString();
        this.constructionStatusStr = parcel.readString();
        this.projectStatusName = parcel.readString();
        this.acceptanceStatusStr = parcel.readString();
        this.minorRepairStatus = parcel.readString();
        this.eventDesc = parcel.readString();
        this.manageDetail = parcel.readString();
        this.realReportUserName = parcel.readString();
        this.urgentLevel = parcel.readString();
        this.checkTypeName = parcel.readString();
        this.patrolObjectCode = parcel.readString();
        this.completeTimeStr = parcel.readString();
        this.auditUnitName = parcel.readString();
        this.diseaseComponentsCode = parcel.readString();
        this.id = parcel.readString();
        this.eventPhotoList = parcel.createTypedArrayList(AlbumItem.CREATOR);
        this.eventManagePhotoList = parcel.createTypedArrayList(AlbumItem.CREATOR);
        this.manageRecordList = parcel.createTypedArrayList(ManageRecordListRes.CREATOR);
        this.longitude = (Double) parcel.readValue(Double.class.getClassLoader());
        this.objectTypeCode = parcel.readString();
        this.auditUnitCode = parcel.readString();
        this.decomposeTime = parcel.readString();
        this.townName = parcel.readString();
        this.diseaseTypeCode = parcel.readString();
        this.repairStatus = parcel.readString();
        this.ifSelfProcess = parcel.readString();
        this.decisionConclusion = parcel.readString();
        this.completeTime = parcel.readString();
        this.mileagePileNumber = parcel.readString();
        this.villageCode = parcel.readString();
        this.measure = parcel.readString();
        this.decomposeOpinion = parcel.readString();
        this.auditTime = parcel.readString();
        this.decomposeType = parcel.readString();
        this.processTypeName = parcel.readString();
        this.manageUnitName = parcel.readString();
        this.positionPileNumber = parcel.readString();
        this.provinceName = parcel.readString();
        this.reportTime = parcel.readString();
        this.projectOrgName = parcel.readString();
        this.districtCode = parcel.readString();
        this.cityCode = parcel.readString();
        this.latitude = (Double) parcel.readValue(Double.class.getClassLoader());
        this.eventSource = parcel.readString();
        this.lineName = parcel.readString();
        this.expiredDate = parcel.readString();
        this.diseaseSortName = parcel.readString();
        this.villageName = parcel.readString();
        this.shamReportUserCode = parcel.readString();
        this.diseaseTypeName = parcel.readString();
        this.auditTimeStr = parcel.readString();
        this.lineCode = parcel.readString();
        this.manageCode = parcel.readString();
        this.cityName = parcel.readString();
        this.decomposeTimeStr = parcel.readString();
        this.eventVideoList = parcel.createTypedArrayList(AlbumItem.CREATOR);
        this.processType = parcel.readString();
        this.eventStatusName = parcel.readString();
        this.patrolObjectName = parcel.readString();
        this.diseaseSortCode = parcel.readString();
        this.bridgeInspectRecordCode = parcel.readString();
        this.districtName = parcel.readString();
        this.provinceCode = parcel.readString();
        this.manageUnitCode = parcel.readString();
        this.specificLocation = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.projectCode = parcel.readString();
        this.projectName = parcel.readString();
        this.shamReportUserName = parcel.readString();
        this.reportTimeStr = parcel.readString();
        this.eventCode = parcel.readString();
        this.urgentLevelName = parcel.readString();
        this.createTime = parcel.readString();
        this.diseaseComponentsName = parcel.readString();
        this.eventStatus = parcel.readString();
        this.managePeriod = parcel.readString();
        this.researchDirection = parcel.readString();
        this.researchDirectionStr = parcel.readString();
        this.manageTime = parcel.readString();
        this.checkTypeCode = parcel.readString();
        this.realReportUserCode = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAcceptanceRemark() {
        return this.acceptanceRemark;
    }

    public String getAcceptanceStatus() {
        return this.acceptanceStatus;
    }

    public String getAcceptanceStatusStr() {
        return this.acceptanceStatusStr;
    }

    public String getAuditTime() {
        return this.auditTime;
    }

    public String getAuditTimeStr() {
        return this.auditTimeStr;
    }

    public String getAuditUnitCode() {
        return this.auditUnitCode;
    }

    public String getAuditUnitName() {
        return this.auditUnitName;
    }

    public String getBridgeInspectRecordCode() {
        return this.bridgeInspectRecordCode;
    }

    public String getCheckTypeCode() {
        return this.checkTypeCode;
    }

    public String getCheckTypeName() {
        return this.checkTypeName;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getCompleteTime() {
        return this.completeTime;
    }

    public String getCompleteTimeStr() {
        return this.completeTimeStr;
    }

    public String getConstructionStatus() {
        return this.constructionStatus;
    }

    public String getConstructionStatusStr() {
        return this.constructionStatusStr;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getDecisionConclusion() {
        return this.decisionConclusion;
    }

    public String getDecomposeOpinion() {
        return this.decomposeOpinion;
    }

    public String getDecomposeTime() {
        return this.decomposeTime;
    }

    public String getDecomposeTimeStr() {
        return this.decomposeTimeStr;
    }

    public String getDecomposeType() {
        return this.decomposeType;
    }

    public String getDiseaseComponentsCode() {
        return this.diseaseComponentsCode;
    }

    public String getDiseaseComponentsName() {
        return this.diseaseComponentsName;
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

    public String getDistrictCode() {
        return this.districtCode;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public String getEventDesc() {
        return this.eventDesc;
    }

    public List<AlbumItem> getEventManagePhotoList() {
        return this.eventManagePhotoList;
    }

    public List<AlbumItem> getEventPhotoList() {
        return this.eventPhotoList;
    }

    public String getEventSource() {
        return this.eventSource;
    }

    public String getEventStatus() {
        return this.eventStatus;
    }

    public String getEventStatusName() {
        return this.eventStatusName;
    }

    public List<AlbumItem> getEventVideoList() {
        return this.eventVideoList;
    }

    public String getExpiredDate() {
        return this.expiredDate;
    }

    public String getId() {
        return this.id;
    }

    public String getIfSelfProcess() {
        return this.ifSelfProcess;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public String getLineCode() {
        return this.lineCode;
    }

    public String getLineName() {
        return this.lineName;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public String getManageCode() {
        return this.manageCode;
    }

    public String getManageDetail() {
        return this.manageDetail;
    }

    public String getManagePeriod() {
        return this.managePeriod;
    }

    public List<ManageRecordListRes> getManageRecordList() {
        return this.manageRecordList;
    }

    public String getManageTime() {
        return this.manageTime;
    }

    public String getManageTimeStr() {
        return this.manageTimeStr;
    }

    public String getManageUnitCode() {
        return this.manageUnitCode;
    }

    public String getManageUnitName() {
        return this.manageUnitName;
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

    public String getMinorRepairStatus() {
        return this.minorRepairStatus;
    }

    public String getObjectTypeCode() {
        return this.objectTypeCode;
    }

    public String getPatrolObjectCode() {
        return this.patrolObjectCode;
    }

    public String getPatrolObjectName() {
        return this.patrolObjectName;
    }

    public String getPositionPileNumber() {
        return this.positionPileNumber;
    }

    public String getProcessType() {
        return this.processType;
    }

    public String getProcessTypeName() {
        return this.processTypeName;
    }

    public String getProjectCode() {
        return this.projectCode;
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

    public String getProjectStatusName() {
        return this.projectStatusName;
    }

    public String getProvinceCode() {
        return this.provinceCode;
    }

    public String getProvinceName() {
        return this.provinceName;
    }

    public String getRealReportUserCode() {
        return this.realReportUserCode;
    }

    public String getRealReportUserName() {
        return this.realReportUserName;
    }

    public String getRepairStatus() {
        return this.repairStatus;
    }

    public String getReportTime() {
        return this.reportTime;
    }

    public String getReportTimeStr() {
        return this.reportTimeStr;
    }

    public String getResearchDirection() {
        return this.researchDirection;
    }

    public String getResearchDirectionStr() {
        return this.researchDirectionStr;
    }

    public String getShamReportUserCode() {
        return this.shamReportUserCode;
    }

    public String getShamReportUserName() {
        return this.shamReportUserName;
    }

    public String getSpecificLocation() {
        return this.specificLocation;
    }

    public List<TailRecordListItem> getTailRecordList() {
        return this.tailRecordList;
    }

    public String getTownCode() {
        return this.townCode;
    }

    public String getTownName() {
        return this.townName;
    }

    public String getUrgentLevel() {
        return this.urgentLevel;
    }

    public String getUrgentLevelName() {
        return this.urgentLevelName;
    }

    public String getVillageCode() {
        return this.villageCode;
    }

    public String getVillageName() {
        return this.villageName;
    }

    public void readFromParcel(Parcel parcel) {
        this.townCode = parcel.readString();
        this.manageTimeStr = parcel.readString();
        this.measuresOpinion = parcel.readString();
        this.diseaseNumber = parcel.readString();
        this.minorRepairStatus = parcel.readString();
        this.eventDesc = parcel.readString();
        this.manageDetail = parcel.readString();
        this.realReportUserName = parcel.readString();
        this.urgentLevel = parcel.readString();
        this.checkTypeName = parcel.readString();
        this.patrolObjectCode = parcel.readString();
        this.completeTimeStr = parcel.readString();
        this.auditUnitName = parcel.readString();
        this.diseaseComponentsCode = parcel.readString();
        this.id = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.eventPhotoList = arrayList;
        parcel.readList(arrayList, AlbumItem.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.eventManagePhotoList = arrayList2;
        parcel.readList(arrayList2, AlbumItem.class.getClassLoader());
        this.longitude = (Double) parcel.readValue(Double.class.getClassLoader());
        this.objectTypeCode = parcel.readString();
        this.auditUnitCode = parcel.readString();
        this.decomposeTime = parcel.readString();
        this.townName = parcel.readString();
        this.diseaseTypeCode = parcel.readString();
        this.repairStatus = parcel.readString();
        this.ifSelfProcess = parcel.readString();
        this.decisionConclusion = parcel.readString();
        this.completeTime = parcel.readString();
        this.mileagePileNumber = parcel.readString();
        this.villageCode = parcel.readString();
        this.measure = parcel.readString();
        this.decomposeOpinion = parcel.readString();
        this.auditTime = parcel.readString();
        this.decomposeType = parcel.readString();
        this.processTypeName = parcel.readString();
        this.manageUnitName = parcel.readString();
        this.positionPileNumber = parcel.readString();
        this.provinceName = parcel.readString();
        this.reportTime = parcel.readString();
        this.projectOrgName = parcel.readString();
        this.districtCode = parcel.readString();
        this.cityCode = parcel.readString();
        this.latitude = (Double) parcel.readValue(Double.class.getClassLoader());
        this.eventSource = parcel.readString();
        this.lineName = parcel.readString();
        this.diseaseSortName = parcel.readString();
        this.villageName = parcel.readString();
        this.shamReportUserCode = parcel.readString();
        this.diseaseTypeName = parcel.readString();
        this.auditTimeStr = parcel.readString();
        this.lineCode = parcel.readString();
        this.manageCode = parcel.readString();
        this.cityName = parcel.readString();
        this.decomposeTimeStr = parcel.readString();
        ArrayList arrayList3 = new ArrayList();
        this.eventVideoList = arrayList3;
        parcel.readList(arrayList3, AlbumItem.class.getClassLoader());
        this.processType = parcel.readString();
        this.eventStatusName = parcel.readString();
        this.patrolObjectName = parcel.readString();
        this.diseaseSortCode = parcel.readString();
        this.bridgeInspectRecordCode = parcel.readString();
        this.districtName = parcel.readString();
        this.provinceCode = parcel.readString();
        this.manageUnitCode = parcel.readString();
        this.specificLocation = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.shamReportUserName = parcel.readString();
        this.reportTimeStr = parcel.readString();
        this.eventCode = parcel.readString();
        this.urgentLevelName = parcel.readString();
        this.createTime = parcel.readString();
        this.diseaseComponentsName = parcel.readString();
        this.eventStatus = parcel.readString();
        this.managePeriod = parcel.readString();
        this.researchDirection = parcel.readString();
        this.manageTime = parcel.readString();
        this.checkTypeCode = parcel.readString();
        this.realReportUserCode = parcel.readString();
    }

    public void setAuditTime(String str) {
        this.auditTime = str;
    }

    public void setAuditTimeStr(String str) {
        this.auditTimeStr = str;
    }

    public void setAuditUnitCode(String str) {
        this.auditUnitCode = str;
    }

    public void setAuditUnitName(String str) {
        this.auditUnitName = str;
    }

    public void setBridgeInspectRecordCode(String str) {
        this.bridgeInspectRecordCode = str;
    }

    public void setCheckTypeCode(String str) {
        this.checkTypeCode = str;
    }

    public void setCheckTypeName(String str) {
        this.checkTypeName = str;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public void setCompleteTime(String str) {
        this.completeTime = str;
    }

    public void setCompleteTimeStr(String str) {
        this.completeTimeStr = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setDecisionConclusion(String str) {
        this.decisionConclusion = str;
    }

    public void setDecomposeOpinion(String str) {
        this.decomposeOpinion = str;
    }

    public void setDecomposeTime(String str) {
        this.decomposeTime = str;
    }

    public void setDecomposeTimeStr(String str) {
        this.decomposeTimeStr = str;
    }

    public void setDecomposeType(String str) {
        this.decomposeType = str;
    }

    public void setDiseaseComponentsCode(String str) {
        this.diseaseComponentsCode = str;
    }

    public void setDiseaseComponentsName(String str) {
        this.diseaseComponentsName = str;
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

    public void setDistrictCode(String str) {
        this.districtCode = str;
    }

    public void setDistrictName(String str) {
        this.districtName = str;
    }

    public void setEventCode(String str) {
        this.eventCode = str;
    }

    public void setEventDesc(String str) {
        this.eventDesc = str;
    }

    public void setEventManagePhotoList(List<AlbumItem> list) {
        this.eventManagePhotoList = list;
    }

    public void setEventPhotoList(List<AlbumItem> list) {
        this.eventPhotoList = list;
    }

    public void setEventSource(String str) {
        this.eventSource = str;
    }

    public void setEventStatus(String str) {
        this.eventStatus = str;
    }

    public void setEventStatusName(String str) {
        this.eventStatusName = str;
    }

    public void setEventVideoList(List<AlbumItem> list) {
        this.eventVideoList = list;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIfSelfProcess(String str) {
        this.ifSelfProcess = str;
    }

    public void setLatitude(Double d) {
        this.latitude = d;
    }

    public void setLineCode(String str) {
        this.lineCode = str;
    }

    public void setLineName(String str) {
        this.lineName = str;
    }

    public void setLongitude(Double d) {
        this.longitude = d;
    }

    public void setManageCode(String str) {
        this.manageCode = str;
    }

    public void setManageDetail(String str) {
        this.manageDetail = str;
    }

    public void setManagePeriod(String str) {
        this.managePeriod = str;
    }

    public void setManageTime(String str) {
        this.manageTime = str;
    }

    public void setManageTimeStr(String str) {
        this.manageTimeStr = str;
    }

    public void setManageUnitCode(String str) {
        this.manageUnitCode = str;
    }

    public void setManageUnitName(String str) {
        this.manageUnitName = str;
    }

    public void setMeasure(String str) {
        this.measure = str;
    }

    public void setMeasuresOpinion(String str) {
        this.measuresOpinion = str;
    }

    public void setMileagePileNumber(String str) {
        this.mileagePileNumber = str;
    }

    public void setMinorRepairStatus(String str) {
        this.minorRepairStatus = str;
    }

    public void setObjectTypeCode(String str) {
        this.objectTypeCode = str;
    }

    public void setPatrolObjectCode(String str) {
        this.patrolObjectCode = str;
    }

    public void setPatrolObjectName(String str) {
        this.patrolObjectName = str;
    }

    public void setPositionPileNumber(String str) {
        this.positionPileNumber = str;
    }

    public void setProcessType(String str) {
        this.processType = str;
    }

    public void setProcessTypeName(String str) {
        this.processTypeName = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setProjectOrgName(String str) {
        this.projectOrgName = str;
    }

    public void setProvinceCode(String str) {
        this.provinceCode = str;
    }

    public void setProvinceName(String str) {
        this.provinceName = str;
    }

    public void setRealReportUserCode(String str) {
        this.realReportUserCode = str;
    }

    public void setRealReportUserName(String str) {
        this.realReportUserName = str;
    }

    public void setRepairStatus(String str) {
        this.repairStatus = str;
    }

    public void setReportTime(String str) {
        this.reportTime = str;
    }

    public void setReportTimeStr(String str) {
        this.reportTimeStr = str;
    }

    public void setResearchDirection(String str) {
        this.researchDirection = str;
    }

    public void setShamReportUserCode(String str) {
        this.shamReportUserCode = str;
    }

    public void setShamReportUserName(String str) {
        this.shamReportUserName = str;
    }

    public void setSpecificLocation(String str) {
        this.specificLocation = str;
    }

    public void setTownCode(String str) {
        this.townCode = str;
    }

    public void setTownName(String str) {
        this.townName = str;
    }

    public void setUrgentLevel(String str) {
        this.urgentLevel = str;
    }

    public void setUrgentLevelName(String str) {
        this.urgentLevelName = str;
    }

    public void setVillageCode(String str) {
        this.villageCode = str;
    }

    public void setVillageName(String str) {
        this.villageName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.townCode);
        parcel.writeString(this.manageTimeStr);
        parcel.writeString(this.measuresOpinion);
        parcel.writeString(this.diseaseNumber);
        parcel.writeString(this.acceptanceRemark);
        parcel.writeString(this.acceptanceStatus);
        parcel.writeString(this.constructionStatus);
        parcel.writeString(this.constructionStatusStr);
        parcel.writeString(this.projectStatusName);
        parcel.writeString(this.acceptanceStatusStr);
        parcel.writeString(this.minorRepairStatus);
        parcel.writeString(this.eventDesc);
        parcel.writeString(this.manageDetail);
        parcel.writeString(this.realReportUserName);
        parcel.writeString(this.urgentLevel);
        parcel.writeString(this.checkTypeName);
        parcel.writeString(this.patrolObjectCode);
        parcel.writeString(this.completeTimeStr);
        parcel.writeString(this.auditUnitName);
        parcel.writeString(this.diseaseComponentsCode);
        parcel.writeString(this.id);
        parcel.writeTypedList(this.eventPhotoList);
        parcel.writeTypedList(this.eventManagePhotoList);
        parcel.writeTypedList(this.manageRecordList);
        parcel.writeValue(this.longitude);
        parcel.writeString(this.objectTypeCode);
        parcel.writeString(this.auditUnitCode);
        parcel.writeString(this.decomposeTime);
        parcel.writeString(this.townName);
        parcel.writeString(this.diseaseTypeCode);
        parcel.writeString(this.repairStatus);
        parcel.writeString(this.ifSelfProcess);
        parcel.writeString(this.decisionConclusion);
        parcel.writeString(this.completeTime);
        parcel.writeString(this.mileagePileNumber);
        parcel.writeString(this.villageCode);
        parcel.writeString(this.measure);
        parcel.writeString(this.decomposeOpinion);
        parcel.writeString(this.auditTime);
        parcel.writeString(this.decomposeType);
        parcel.writeString(this.processTypeName);
        parcel.writeString(this.manageUnitName);
        parcel.writeString(this.positionPileNumber);
        parcel.writeString(this.provinceName);
        parcel.writeString(this.reportTime);
        parcel.writeString(this.projectOrgName);
        parcel.writeString(this.districtCode);
        parcel.writeString(this.cityCode);
        parcel.writeValue(this.latitude);
        parcel.writeString(this.eventSource);
        parcel.writeString(this.lineName);
        parcel.writeString(this.expiredDate);
        parcel.writeString(this.diseaseSortName);
        parcel.writeString(this.villageName);
        parcel.writeString(this.shamReportUserCode);
        parcel.writeString(this.diseaseTypeName);
        parcel.writeString(this.auditTimeStr);
        parcel.writeString(this.lineCode);
        parcel.writeString(this.manageCode);
        parcel.writeString(this.cityName);
        parcel.writeString(this.decomposeTimeStr);
        parcel.writeTypedList(this.eventVideoList);
        parcel.writeString(this.processType);
        parcel.writeString(this.eventStatusName);
        parcel.writeString(this.patrolObjectName);
        parcel.writeString(this.diseaseSortCode);
        parcel.writeString(this.bridgeInspectRecordCode);
        parcel.writeString(this.districtName);
        parcel.writeString(this.provinceCode);
        parcel.writeString(this.manageUnitCode);
        parcel.writeString(this.specificLocation);
        parcel.writeString(this.projectOrgCode);
        parcel.writeString(this.projectCode);
        parcel.writeString(this.projectName);
        parcel.writeString(this.shamReportUserName);
        parcel.writeString(this.reportTimeStr);
        parcel.writeString(this.eventCode);
        parcel.writeString(this.urgentLevelName);
        parcel.writeString(this.createTime);
        parcel.writeString(this.diseaseComponentsName);
        parcel.writeString(this.eventStatus);
        parcel.writeString(this.managePeriod);
        parcel.writeString(this.researchDirection);
        parcel.writeString(this.researchDirectionStr);
        parcel.writeString(this.manageTime);
        parcel.writeString(this.checkTypeCode);
        parcel.writeString(this.realReportUserCode);
    }
}
