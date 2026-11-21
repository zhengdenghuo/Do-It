package com.collectpoint.bean.item;

import com.collectpoint.widget.recycler.SSelectable;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class HighwayPatrolTaskListApiItem extends SSelectable implements Serializable {
    private String beginPoint;
    private String checkTypeCodes;
    private String checkTypeNames;
    private boolean childChecked = false;
    private String dataSort;
    private String endPoint;
    private String highwayPatrolPlanCode;
    private String highwayPatrolTaskCode;
    private int id;
    private String mileage;
    private String objectCode;
    private String objectName;
    private String objectTypeCode;
    private String objectTypeName;
    private String patrolEndDate;
    private int patrolEventNumber;
    private String patrolMileage;
    private String patrolStartDate;
    private String patrolStatus;
    private String patrolStatusName;
    private String patrolTimeLengthStr;
    private String patrolUserCode;
    private String patrolUserName;
    private String planEndDate;
    private String planMileage;
    private String planStartDate;
    private String planStartEndTime;
    private String projectOrgCode;
    private String projectOrgName;
    private String roadLineCode;
    private String roadLineName;
    private String roadSegmentCode;
    private List<RoadSegmentDataListItem> roadSegmentDataList;
    private String roadSegmentName;
    private String status;

    public String getBeginPoint() {
        return this.beginPoint;
    }

    public String getCheckTypeCodes() {
        return this.checkTypeCodes;
    }

    public String getCheckTypeNames() {
        return this.checkTypeNames;
    }

    public String getDataSort() {
        return this.dataSort;
    }

    public String getEndPoint() {
        return this.endPoint;
    }

    public String getHighwayPatrolPlanCode() {
        return this.highwayPatrolPlanCode;
    }

    public String getHighwayPatrolTaskCode() {
        return this.highwayPatrolTaskCode;
    }

    public int getId() {
        return this.id;
    }

    public String getMileage() {
        return this.mileage;
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

    public String getObjectTypeName() {
        return this.objectTypeName;
    }

    public String getPatrolEndDate() {
        return this.patrolEndDate;
    }

    public int getPatrolEventNumber() {
        return this.patrolEventNumber;
    }

    public String getPatrolMileage() {
        return this.patrolMileage;
    }

    public String getPatrolStartDate() {
        return this.patrolStartDate;
    }

    public String getPatrolStatus() {
        return this.patrolStatus;
    }

    public String getPatrolStatusName() {
        return this.patrolStatusName;
    }

    public String getPatrolTimeLengthStr() {
        return this.patrolTimeLengthStr;
    }

    public String getPatrolUserCode() {
        return this.patrolUserCode;
    }

    public String getPatrolUserName() {
        return this.patrolUserName;
    }

    public String getPlanEndDate() {
        return this.planEndDate;
    }

    public String getPlanMileage() {
        return this.planMileage;
    }

    public String getPlanStartDate() {
        return this.planStartDate;
    }

    public String getPlanStartEndTime() {
        return this.planStartEndTime;
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

    public String getRoadSegmentCode() {
        return this.roadSegmentCode;
    }

    public List<RoadSegmentDataListItem> getRoadSegmentDataList() {
        return this.roadSegmentDataList;
    }

    public String getRoadSegmentName() {
        return this.roadSegmentName;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isChildChecked() {
        return this.childChecked;
    }

    public void setBeginPoint(String str) {
        this.beginPoint = str;
    }

    public void setCheckTypeCodes(String str) {
        this.checkTypeCodes = str;
    }

    public void setCheckTypeNames(String str) {
        this.checkTypeNames = str;
    }

    public void setChildChecked(boolean z) {
        this.childChecked = z;
    }

    public void setEndPoint(String str) {
        this.endPoint = str;
    }

    public void setHighwayPatrolPlanCode(String str) {
        this.highwayPatrolPlanCode = str;
    }

    public void setHighwayPatrolTaskCode(String str) {
        this.highwayPatrolTaskCode = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setMileage(String str) {
        this.mileage = str;
    }

    public void setObjectCode(String str) {
        this.objectCode = str;
    }

    public void setObjectName(String str) {
        this.objectName = str;
    }

    public void setObjectTypeCode(String str) {
        this.objectTypeCode = str;
    }

    public void setObjectTypeName(String str) {
        this.objectTypeName = str;
    }

    public void setPatrolEndDate(String str) {
        this.patrolEndDate = str;
    }

    public void setPatrolEventNumber(int i) {
        this.patrolEventNumber = i;
    }

    public void setPatrolMileage(String str) {
        this.patrolMileage = str;
    }

    public void setPatrolStartDate(String str) {
        this.patrolStartDate = str;
    }

    public void setPatrolStatus(String str) {
        this.patrolStatus = str;
    }

    public void setPatrolStatusName(String str) {
        this.patrolStatusName = str;
    }

    public void setPatrolTimeLengthStr(String str) {
        this.patrolTimeLengthStr = str;
    }

    public void setPatrolUserCode(String str) {
        this.patrolUserCode = str;
    }

    public void setPatrolUserName(String str) {
        this.patrolUserName = str;
    }

    public void setPlanEndDate(String str) {
        this.planEndDate = str;
    }

    public void setPlanStartDate(String str) {
        this.planStartDate = str;
    }

    public void setPlanStartEndTime(String str) {
        this.planStartEndTime = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setProjectOrgName(String str) {
        this.projectOrgName = str;
    }

    public void setRoadLineCode(String str) {
        this.roadLineCode = str;
    }

    public void setRoadLineName(String str) {
        this.roadLineName = str;
    }

    public void setRoadSegmentCode(String str) {
        this.roadSegmentCode = str;
    }

    public void setRoadSegmentDataList(List<RoadSegmentDataListItem> list) {
        this.roadSegmentDataList = list;
    }

    public void setRoadSegmentName(String str) {
        this.roadSegmentName = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
