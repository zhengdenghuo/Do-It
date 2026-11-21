package com.collectpoint.bean.res;

import com.collectpoint.bean.item.HighwayPatrolTaskListApiItem;
import com.collectpoint.bean.item.TaskTrajectoryListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class HighwayPatrolTaskInfoApiRes {
    private String beginPoint;
    private String endPoint;
    private String highwayPatrolPlanCode;
    private String highwayPatrolTaskCode;
    private int id;
    private String objectCode;
    private List<HighwayPatrolTaskListApiItem> objectList;
    private String objectName;
    private String objectTypeCode;
    private String objectTypeName;
    private String patrolEndDate;
    private double patrolMileage;
    private String patrolStartDate;
    private String patrolStatus;
    private int patrolTimeLength;
    private String patrolTimeLengthStr;
    private String patrolUserCode;
    private String patrolUserName;
    private String planEndDate;
    private String planStartDate;
    private String projectOrgCode;
    private String projectOrgName;
    private String roadLineCode;
    private String roadLineName;
    private String roadSegmentCode;
    private String roadSegmentName;
    private String status;
    private List<List<TaskTrajectoryListItem>> taskTrajectoryList;

    public String getBeginPoint() {
        return this.beginPoint;
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

    public List<HighwayPatrolTaskListApiItem> getObejctList() {
        return this.objectList;
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

    public double getPatrolMileage() {
        return this.patrolMileage;
    }

    public String getPatrolStartDate() {
        return this.patrolStartDate;
    }

    public String getPatrolStatus() {
        return this.patrolStatus;
    }

    public int getPatrolTimeLength() {
        return this.patrolTimeLength;
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

    public String getPlanStartDate() {
        return this.planStartDate;
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

    public String getRoadSegmentName() {
        return this.roadSegmentName;
    }

    public String getStatus() {
        return this.status;
    }

    public List<List<TaskTrajectoryListItem>> getTaskTrajectoryList() {
        return this.taskTrajectoryList;
    }

    public void setBeginPoint(String str) {
        this.beginPoint = str;
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

    public void setPatrolMileage(double d) {
        this.patrolMileage = d;
    }

    public void setPatrolStartDate(String str) {
        this.patrolStartDate = str;
    }

    public void setPatrolStatus(String str) {
        this.patrolStatus = str;
    }

    public void setPatrolTimeLength(int i) {
        this.patrolTimeLength = i;
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

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setProjectOrgName(String str) {
        this.projectOrgName = str;
    }

    public void setRoadSegmentCode(String str) {
        this.roadSegmentCode = str;
    }

    public void setRoadSegmentName(String str) {
        this.roadSegmentName = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
