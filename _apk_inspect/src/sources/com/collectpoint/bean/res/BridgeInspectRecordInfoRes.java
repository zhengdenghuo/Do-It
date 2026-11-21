package com.collectpoint.bean.res;

import com.collectpoint.bean.item.AlbumItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class BridgeInspectRecordInfoRes {
    private String bridgeInspectRecordCode;
    private String bridgeInspectTaskCode;
    private String checkTypeName;
    private String id;
    private String inspectStatus;
    private String inspectStatusStr;
    private String inspectTime;
    private String inspectUserName;
    private double latitude;
    private String locationPileNo;
    private double longitude;
    private List<DiseaseFieldListRes> needToCheckPartsList;
    private String objectCode;
    private String objectName;
    private String objectTypeCode;
    private List<AlbumItem> photoList;
    private String projectOrgCode;
    private String projectOrgName;
    private String roadLineCode;
    private String roadLineName;
    private String specificLocation;
    private String status;
    private String typeCode;
    private List<TypeFieldListRes> typeFieldList;

    public static class DiseaseFieldListRes {
        private String attributeName;
        private String createCode;
        private String createTime;
        private List<EventListRes> eventList;
        private String fieldCode;
        private String fieldName;
        private String fieldTypeCode;
        private String fieldValues;
        private String id;
        private String status;
        private String typeCode;

        public String getAttributeName() {
            return this.attributeName;
        }

        public String getCreateCode() {
            return this.createCode;
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public List<EventListRes> getEventList() {
            return this.eventList;
        }

        public String getFieldCode() {
            return this.fieldCode;
        }

        public String getFieldName() {
            return this.fieldName;
        }

        public String getFieldTypeCode() {
            return this.fieldTypeCode;
        }

        public String getFieldValues() {
            return this.fieldValues;
        }

        public String getId() {
            return this.id;
        }

        public String getStatus() {
            return this.status;
        }

        public String getTypeCode() {
            return this.typeCode;
        }

        public void setAttributeName(String str) {
            this.attributeName = str;
        }
    }

    public static class EventListRes {
        private String auditTime;
        private String auditTimeStr;
        private String auditUnitCode;
        private String auditUnitName;
        private String bridgeInspectRecordCode;
        private String checkPartName;
        private String checkTypeCode;
        private String checkTypeName;
        private String cityCode;
        private String cityName;
        private String completeTime;
        private String completeTimeStr;
        private String createTime;
        private String decisionConclusion;
        private String decomposeOpinion;
        private String decomposeTime;
        private String decomposeTimeStr;
        private String decomposeType;
        private String diseaseComponentsCode;
        private String diseaseComponentsName;
        private String diseaseName;
        private String diseaseNumber;
        private String diseaseSortCode;
        private String diseaseSortName;
        private String diseaseTypeCode;
        private String diseaseTypeName;
        private String districtCode;
        private String districtName;
        private String eventCode;
        private String eventDesc;
        private String eventSource;
        private String eventStatus;
        private String eventStatusStr;
        private String id;
        private String ifSelfProcess;
        private String latitude;
        private String lineCode;
        private String lineName;
        private String longitude;
        private String manageCode;
        private String manageDetail;
        private String managePeriod;
        private String manageTime;
        private String manageTimeStr;
        private String manageUnitCode;
        private String manageUnitName;
        private String measure;
        private String measuresOpinion;
        private String mileagePileNumber;
        private String minorRepairStatus;
        private String objectTypeCode;
        private String patrolObjectCode;
        private String patrolObjectName;
        private List<AlbumItem> photoList;
        private String positionPileNumber;
        private String processType;
        private String projectOrgCode;
        private String projectOrgName;
        private String provinceCode;
        private String provinceName;
        private String realReportUserCode;
        private String realReportUserName;
        private String reportTime;
        private String reportTimeStr;
        private String researchDirection;
        private String shamReportUserCode;
        private String shamReportUserName;
        private String specificLocation;
        private String townCode;
        private String townName;
        private String urgentLevel;
        private String villageCode;
        private String villageName;

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

        public String getCheckPartName() {
            return this.checkPartName;
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

        public String getDiseaseName() {
            return this.diseaseName;
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

        public String getEventSource() {
            return this.eventSource;
        }

        public String getEventStatus() {
            return this.eventStatus;
        }

        public String getEventStatusStr() {
            return this.eventStatusStr;
        }

        public String getId() {
            return this.id;
        }

        public String getIfSelfProcess() {
            return this.ifSelfProcess;
        }

        public String getLatitude() {
            return this.latitude;
        }

        public String getLineCode() {
            return this.lineCode;
        }

        public String getLineName() {
            return this.lineName;
        }

        public String getLongitude() {
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

        public List<AlbumItem> getPhotoList() {
            return this.photoList;
        }

        public String getPositionPileNumber() {
            return this.positionPileNumber;
        }

        public String getProcessType() {
            return this.processType;
        }

        public String getProjectOrgCode() {
            return this.projectOrgCode;
        }

        public String getProjectOrgName() {
            return this.projectOrgName;
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

        public String getReportTime() {
            return this.reportTime;
        }

        public String getReportTimeStr() {
            return this.reportTimeStr;
        }

        public String getResearchDirection() {
            return this.researchDirection;
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

        public String getTownCode() {
            return this.townCode;
        }

        public String getTownName() {
            return this.townName;
        }

        public String getUrgentLevel() {
            return this.urgentLevel;
        }

        public String getVillageCode() {
            return this.villageCode;
        }

        public String getVillageName() {
            return this.villageName;
        }

        public void setCheckPartName(String str) {
            this.checkPartName = str;
        }

        public void setDiseaseName(String str) {
            this.diseaseName = str;
        }
    }

    public static class TypeFieldListRes {
        private String fieldCode;
        private String fieldShow;
        private String id;
        private String status;
        private String typeCode;
        private String typeName;
    }

    public String getBridgeInspectRecordCode() {
        return this.bridgeInspectRecordCode;
    }

    public String getBridgeInspectTaskCode() {
        return this.bridgeInspectTaskCode;
    }

    public String getCheckTypeName() {
        return this.checkTypeName;
    }

    public String getId() {
        return this.id;
    }

    public String getInspectStatus() {
        return this.inspectStatus;
    }

    public String getInspectStatusStr() {
        return this.inspectStatusStr;
    }

    public String getInspectTime() {
        return this.inspectTime;
    }

    public String getInspectUserName() {
        return this.inspectUserName;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getLocationPileNo() {
        return this.locationPileNo;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public List<DiseaseFieldListRes> getNeedToCheckPartsList() {
        return this.needToCheckPartsList;
    }

    public String getObjectCode() {
        return this.objectCode;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public String getObjectTypeCode() {
        return this.objectTypeCode;
    }

    public List<AlbumItem> getPhotoList() {
        return this.photoList;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getProjectOrgName() {
        return this.projectOrgName;
    }

    public String getRoadLineCode() {
        return this.roadLineCode;
    }

    public String getRoadLineName() {
        return this.roadLineName;
    }

    public String getSpecificLocation() {
        return this.specificLocation;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public List<TypeFieldListRes> getTypeFieldList() {
        return this.typeFieldList;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setSpecificLocation(String str) {
        this.specificLocation = str;
    }
}
