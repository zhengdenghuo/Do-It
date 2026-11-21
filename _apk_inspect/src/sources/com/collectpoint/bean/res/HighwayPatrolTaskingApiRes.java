package com.collectpoint.bean.res;

import com.collectpoint.bean.item.HighwayPatrolTaskListApiItem;
import com.collectpoint.bean.item.RoadSegmentDataListItem;
import com.collectpoint.bean.item.TaskTrajectoryListItem;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class HighwayPatrolTaskingApiRes implements Serializable {
    private String endTime;
    private String highwayPatrolTaskCode;
    private double mileageSum;
    private List<HighwayPatrolTaskListApiItem> objectList;
    private double patrolMileage;
    private double patrolSpeed;
    private long patrolStart;
    private long patrolStartDate;
    private String patrolStatus;
    private long patrolTimeLength;
    private String patrolTimeLengthStr;
    private double planMileage;
    private String planTaskEndDate;
    private String planTaskStartDate;
    private String relevanceCode;
    private String roadLineCode;
    private String roadLineName;
    private List<RoadSegmentDataListItem> roadSegmentDataList;
    private int speedPerHour;
    private String startTime;
    private String systemDateTime;
    private long systemTime;
    private List<HighwayPatrolTaskListApiItem> taskList;
    private String taskRecordCode;
    private String taskRecordMileage;
    private String taskRecordName;
    private List<List<TaskTrajectoryListItem>> taskTrajectoryList;

    public String getEndTime() {
        return this.endTime;
    }

    public String getHighwayPatrolTaskCode() {
        return this.highwayPatrolTaskCode;
    }

    public String getLineCode() {
        return this.roadLineCode;
    }

    public String getLineName() {
        return this.roadLineName;
    }

    public double getMileageSum() {
        return this.mileageSum;
    }

    public List<HighwayPatrolTaskListApiItem> getObejctList() {
        return this.objectList;
    }

    public double getPatrolMileage() {
        return this.patrolMileage;
    }

    public double getPatrolSpeed() {
        return this.patrolSpeed;
    }

    public long getPatrolStartDate() {
        return this.patrolStartDate;
    }

    public String getPatrolStatus() {
        return this.patrolStatus;
    }

    public long getPatrolTimeLength() {
        return this.patrolTimeLength;
    }

    public String getPatrolTimeLengthStr() {
        return this.patrolTimeLengthStr;
    }

    public String getPlanEndDate() {
        return this.planTaskEndDate;
    }

    public double getPlanMileage() {
        return this.planMileage;
    }

    public String getPlanStartDate() {
        return this.planTaskStartDate;
    }

    public List<RoadSegmentDataListItem> getRoadSegmentDataList() {
        return this.roadSegmentDataList;
    }

    public int getSpeedPerHour() {
        return this.speedPerHour;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getSystemDateTime() {
        return this.systemDateTime;
    }

    public long getSystemTime() {
        return this.systemTime;
    }

    public List<HighwayPatrolTaskListApiItem> getTaskList() {
        return this.taskList;
    }

    public String getTaskRecordCode() {
        return this.taskRecordCode;
    }

    public String getTaskRecordMileage() {
        return this.taskRecordMileage;
    }

    public String getTaskRecordName() {
        return this.taskRecordName;
    }

    public List<List<TaskTrajectoryListItem>> getTaskTrajectoryList() {
        return this.taskTrajectoryList;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setMileageSum(double d) {
        this.mileageSum = d;
    }

    public void setObejctList(List<HighwayPatrolTaskListApiItem> list) {
        this.objectList = list;
    }

    public void setPatrolMileage(double d) {
        this.patrolMileage = d;
    }

    public void setPatrolTimeLength(long j) {
        this.patrolTimeLength = j;
    }

    public void setRelevanceCode(String str) {
        this.relevanceCode = str;
    }

    public void setRoadSegmentDataList(List<RoadSegmentDataListItem> list) {
        this.roadSegmentDataList = list;
    }

    public void setSpeedPerHour(int i) {
        this.speedPerHour = i;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setSystemDateTime(String str) {
        this.systemDateTime = str;
    }

    public void setTaskList(List<HighwayPatrolTaskListApiItem> list) {
        this.taskList = list;
    }
}
