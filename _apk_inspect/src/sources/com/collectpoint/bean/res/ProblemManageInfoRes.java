package com.collectpoint.bean.res;

import com.collectpoint.bean.CurrentUserManageRecordBean;
import com.collectpoint.bean.IssueOpinionInfoBean;
import com.collectpoint.bean.item.AlbumItem;
import com.collectpoint.bean.item.PatrolCommentListItem;
import com.collectpoint.bean.item.ProjectTypeFieldListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class ProblemManageInfoRes {
    private String assignOpion;
    private String auditTime;
    private String auditTimeStr;
    private String auditUnit;
    private String auditUnitCode;
    private String auditUnitName;
    private String bridgeInspectRecordCode;
    private String checkTypeCode;
    private String checkTypeName;
    private String cityCode;
    private String cityName;
    private String completeTime;
    private String completeTimeStr;
    private String contentCode;
    private String contentName;
    private String createCode;
    private String createName;
    private String createTime;
    private String createTimeStr;
    private CurrentUserManageRecordBean currentUserManageRecord;
    private String deadline;
    private String decisionConclusion;
    private String decomposeOpinion;
    private List<DecomposeRecordListRes> decomposeRecordList;
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
    private List<AlbumItem> eventPhotoList;
    private String eventSource;
    private String eventStatus;
    private String eventStatusName;
    private String eventStatusStr;
    private List<?> eventVideoList;
    private String id;
    public String ifIssueOpinion;
    private String ifSelfProcess;
    private String ifSetAsSpecialProblem;
    private IssueOpinionInfoBean issueOpinionInfo;
    private double latitude;
    private String lineCode;
    private String lineName;
    private double longitude;
    private String manageCode;
    private String manageDetail;
    private String managePeriod;
    private List<CurrentUserManageRecordBean> manageRecordList;
    private String manageTime;
    private String manageTimeStr;
    private String manageUnitCode;
    private String manageUnitName;
    private String measure;
    private String measureUnit;
    private String measuresAndProposal;
    private String measuresOpinion;
    private String mileagePileNumber;
    private String minorRepairStatus;
    private String objectCode;
    private String objectName;
    private String objectTypeCode;
    private List<OperationRecordListRes> operationRecordList;
    private String orgCode;
    private String orgName;
    private List<PatrolCommentListItem> patrolCommentList;
    private String patrolObjectCode;
    private String patrolObjectName;
    private String positionPileNumber;
    private String problemCode;
    private String problemDesc;
    private List<AlbumItem> problemPhotoList;
    private String problemStatus;
    private String problemStatusName;
    private List<AlbumItem> problemVideoList;
    private String processType;
    private String processTypeName;
    private String projectOrgCode;
    private String projectOrgName;
    private List<ProjectTypeFieldListItem> projectTypeFieldList;
    private String provinceCode;
    private String provinceName;
    private String realReportUserCode;
    private String realReportUserName;
    private String regionName;
    private String relatedProblemCode;
    private String reportTime;
    private String reportTimeStr;
    private String researchDirection;
    private String researchDirectionName;
    private String shamReportUserCode;
    private String shamReportUserName;
    private String sortCode;
    private String sortName;
    private String specificLocation;
    private String status;
    private String timeLimitName;
    private String timeLimitType;
    private String townCode;
    private Object townName;
    private String typeCode;
    private String typeName;
    private String updateCode;
    private String updateTime;
    private String urgentLevel;
    private String urgentLevelName;
    private String villageCode;
    private String villageName;

    public static class DecomposeRecordListRes {
        private String decomposeCode;
        private String decomposeName;
        private String decomposeTime;
        private String decomposeTimeStr;
        private String eventCode;
        private String opinion;
    }

    public static class OperationRecordListRes {
        private String content;
        private String createTimeStr;
        private String eventCode;
        private String operationType;
        private String operationTypeName;
        private String userCode;
        private String userName;
    }

    public String getAssignOpion() {
        return this.assignOpion;
    }

    public String getAuditTime() {
        return this.auditTime;
    }

    public String getAuditTimeStr() {
        return this.auditTimeStr;
    }

    public String getAuditUnit() {
        return this.auditUnit;
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

    public String getContentCode() {
        return this.contentCode;
    }

    public String getContentName() {
        return this.contentName;
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

    public CurrentUserManageRecordBean getCurrentUserManageRecord() {
        return this.currentUserManageRecord;
    }

    public String getDeadline() {
        return this.deadline;
    }

    public String getDecisionConclusion() {
        return this.decisionConclusion;
    }

    public String getDecomposeOpinion() {
        return this.decomposeOpinion;
    }

    public List<DecomposeRecordListRes> getDecomposeRecordList() {
        return this.decomposeRecordList;
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

    public String getEventStatusStr() {
        return this.eventStatusStr;
    }

    public List<?> getEventVideoList() {
        return this.eventVideoList;
    }

    public String getId() {
        return this.id;
    }

    public String getIfIssueOpinion() {
        return this.ifIssueOpinion;
    }

    public String getIfSelfProcess() {
        return this.ifSelfProcess;
    }

    public String getIfSetAsSpecialProblem() {
        return this.ifSetAsSpecialProblem;
    }

    public IssueOpinionInfoBean getIssueOpinionInfo() {
        return this.issueOpinionInfo;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getLineCode() {
        return this.lineCode;
    }

    public String getLineName() {
        return this.lineName;
    }

    public double getLongitude() {
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

    public List<CurrentUserManageRecordBean> getManageRecordList() {
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

    public String getMeasuresAndProposal() {
        return this.measuresAndProposal;
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

    public String getObjectCode() {
        return this.objectCode;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public String getObjectTypeCode() {
        return this.objectTypeCode;
    }

    public List<OperationRecordListRes> getOperationRecordList() {
        return this.operationRecordList;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public String getOrgName() {
        return this.orgName;
    }

    public List<PatrolCommentListItem> getPatrolCommentList() {
        return this.patrolCommentList;
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

    public String getProblemCode() {
        return this.problemCode;
    }

    public String getProblemDesc() {
        return this.problemDesc;
    }

    public List<AlbumItem> getProblemPhotoList() {
        return this.problemPhotoList;
    }

    public String getProblemStatus() {
        return this.problemStatus;
    }

    public String getProblemStatusName() {
        return this.problemStatusName;
    }

    public List<AlbumItem> getProblemVideoList() {
        return this.problemVideoList;
    }

    public String getProcessType() {
        return this.processType;
    }

    public String getProcessTypeName() {
        return this.processTypeName;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getProjectOrgName() {
        return this.projectOrgName;
    }

    public List<ProjectTypeFieldListItem> getProjectTypeFieldList() {
        return this.projectTypeFieldList;
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

    public String getRegionName() {
        return this.regionName;
    }

    public String getRelatedProblemCode() {
        return this.relatedProblemCode;
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

    public String getResearchDirectionName() {
        return this.researchDirectionName;
    }

    public String getShamReportUserCode() {
        return this.shamReportUserCode;
    }

    public String getShamReportUserName() {
        return this.shamReportUserName;
    }

    public String getSortCode() {
        return this.sortCode;
    }

    public String getSortName() {
        return this.sortName;
    }

    public String getSpecificLocation() {
        return this.specificLocation;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTimeLimitName() {
        return this.timeLimitName;
    }

    public String getTimeLimitType() {
        return this.timeLimitType;
    }

    public String getTownCode() {
        return this.townCode;
    }

    public Object getTownName() {
        return this.townName;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public String getUpdateCode() {
        return this.updateCode;
    }

    public String getUpdateTime() {
        return this.updateTime;
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

    public void setAssignOpion(String str) {
        this.assignOpion = str;
    }

    public void setAuditUnit(String str) {
        this.auditUnit = str;
    }

    public void setAuditUnitName(String str) {
        this.auditUnitName = str;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public void setContentCode(String str) {
        this.contentCode = str;
    }

    public void setContentName(String str) {
        this.contentName = str;
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

    public void setCurrentUserManageRecord(CurrentUserManageRecordBean currentUserManageRecordBean) {
        this.currentUserManageRecord = currentUserManageRecordBean;
    }

    public void setDeadline(String str) {
        this.deadline = str;
    }

    public void setDistrictCode(String str) {
        this.districtCode = str;
    }

    public void setIfIssueOpinion(String str) {
        this.ifIssueOpinion = str;
    }

    public void setIfSetAsSpecialProblem(String str) {
        this.ifSetAsSpecialProblem = str;
    }

    public void setIssueOpinionInfo(IssueOpinionInfoBean issueOpinionInfoBean) {
        this.issueOpinionInfo = issueOpinionInfoBean;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setManagePeriod(String str) {
        this.managePeriod = str;
    }

    public void setManageRecordList(List<CurrentUserManageRecordBean> list) {
        this.manageRecordList = list;
    }

    public void setManageUnitCode(String str) {
        this.manageUnitCode = str;
    }

    public void setManageUnitName(String str) {
        this.manageUnitName = str;
    }

    public void setMeasuresAndProposal(String str) {
        this.measuresAndProposal = str;
    }

    public void setObjectCode(String str) {
        this.objectCode = str;
    }

    public void setObjectName(String str) {
        this.objectName = str;
    }

    public void setOrgCode(String str) {
        this.orgCode = str;
    }

    public void setOrgName(String str) {
        this.orgName = str;
    }

    public void setPatrolCommentList(List<PatrolCommentListItem> list) {
        this.patrolCommentList = list;
    }

    public void setProblemCode(String str) {
        this.problemCode = str;
    }

    public void setProblemDesc(String str) {
        this.problemDesc = str;
    }

    public void setProblemPhotoList(List<AlbumItem> list) {
        this.problemPhotoList = list;
    }

    public void setProblemStatus(String str) {
        this.problemStatus = str;
    }

    public void setProblemStatusName(String str) {
        this.problemStatusName = str;
    }

    public void setProblemVideoList(List<AlbumItem> list) {
        this.problemVideoList = list;
    }

    public void setProcessType(String str) {
        this.processType = str;
    }

    public void setProcessTypeName(String str) {
        this.processTypeName = str;
    }

    public void setProjectTypeFieldList(List<ProjectTypeFieldListItem> list) {
        this.projectTypeFieldList = list;
    }

    public void setProvinceCode(String str) {
        this.provinceCode = str;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public void setRelatedProblemCode(String str) {
        this.relatedProblemCode = str;
    }

    public void setSortCode(String str) {
        this.sortCode = str;
    }

    public void setSortName(String str) {
        this.sortName = str;
    }

    public void setSpecificLocation(String str) {
        this.specificLocation = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTimeLimitName(String str) {
        this.timeLimitName = str;
    }

    public void setTimeLimitType(String str) {
        this.timeLimitType = str;
    }

    public void setTownCode(String str) {
        this.townCode = str;
    }

    public void setTownName(Object obj) {
        this.townName = obj;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }

    public void setUpdateCode(String str) {
        this.updateCode = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
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
}
