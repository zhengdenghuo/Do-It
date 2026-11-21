package com.collectpoint.bean.item;

import android.text.TextUtils;
import com.collectpoint.utils.BitmapMemoryCache;
import com.collectpoint.widget.recycler.SSelectable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class HighwayPatrolTaskTreeApiItem extends SSelectable {
    private String canInspectDate;
    private String canInspectNumber;
    private boolean checked = false;
    private String getHighwayPatrolTaskList;
    private String highwayPatrolTaskCode;
    private List<HighwayPatrolTaskTreeApiItem> highwayPatrolTaskList;
    private String ifCanInspect;
    private String lineCode;
    private String lineName;
    private String numberDayCanInspect;
    private String numberDayOverdue;
    private List<HighwayPatrolTaskListApiItem> objectList;
    private String patrolEndDate;
    private String patrolMileage;
    private String patrolStartDate;
    private String patrolStatus;
    private String patrolStatusName;
    private String patrolTimeLengthStr;
    private String patrolUserCode;
    private String patrolUserName;
    private String planMileage;
    private String planTaskEndDate;
    private String planTaskStartDate;
    private String relevanceCode;
    private String roadLineCode;
    private String roadLineName;
    private String taskGroupCode;
    private String taskGroupMileage;
    private String taskGroupName;
    private List<HighwayPatrolTaskListApiItem> taskList;
    private String taskNumber;
    private String taskRecordCode;
    private String taskRecordMileage;
    private String taskRecordName;
    private String taskRecordStatus;

    public String getCanInspectDate() {
        return this.canInspectDate;
    }

    public String getCanInspectNumber() {
        return this.canInspectNumber;
    }

    public String getHighwayPatrolTaskCode() {
        return this.highwayPatrolTaskCode;
    }

    public List<HighwayPatrolTaskTreeApiItem> getHighwayPatrolTaskList() {
        return this.highwayPatrolTaskList;
    }

    public String getIfCanInspect() {
        return this.ifCanInspect;
    }

    public String getLineCode() {
        return this.lineCode;
    }

    public String getLineName() {
        return this.lineName;
    }

    public String getNumberDayCanInspect() {
        return this.numberDayCanInspect;
    }

    public String getNumberDayOverdue() {
        return this.numberDayOverdue;
    }

    public List<HighwayPatrolTaskListApiItem> getObjectList() {
        return this.objectList;
    }

    public String getPatrolEndDate() {
        return this.patrolEndDate;
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
        return this.planTaskEndDate;
    }

    public String getPlanMileage() {
        return TextUtils.isEmpty(this.planMileage) ? BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO : this.planMileage;
    }

    public String getPlanStartDate() {
        return this.planTaskStartDate;
    }

    public String getRelevanceCode() {
        return this.relevanceCode;
    }

    public String getRoadLineCode() {
        return this.roadLineCode;
    }

    public String getRoadLineName() {
        return this.roadLineName;
    }

    public String getTaskGroupCode() {
        return this.taskGroupCode;
    }

    public String getTaskGroupMileage() {
        return TextUtils.isEmpty(this.taskGroupMileage) ? BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO : this.taskGroupMileage;
    }

    public String getTaskGroupName() {
        return this.taskGroupName;
    }

    public List<HighwayPatrolTaskListApiItem> getTaskList() {
        return this.taskList;
    }

    public String getTaskNumber() {
        return this.taskNumber;
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

    public String getTaskRecordStatus() {
        return this.taskRecordStatus;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setHighwayPatrolTaskCode(String str) {
        this.highwayPatrolTaskCode = str;
    }

    public void setPatrolEndDate(String str) {
        this.patrolEndDate = str;
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

    public void setPlanEndDate(String str) {
        this.planTaskEndDate = str;
    }

    public void setPlanMileage(String str) {
        this.planMileage = str;
    }

    public void setPlanStartDate(String str) {
        this.planTaskStartDate = str;
    }

    public void setRelevanceCode(String str) {
        this.relevanceCode = str;
    }

    public void setTaskList(List<HighwayPatrolTaskListApiItem> list) {
        this.taskList = list;
    }
}
