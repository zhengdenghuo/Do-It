package com.collectpoint.bean.item;

import com.collectpoint.utils.BitmapMemoryCache;
import com.collectpoint.utils.EmptyUtils;
import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class ApiRepairProjectListItem implements IPickerViewData {
    private String DSGNumber;
    private String DZGNumber;
    private String acceptanceStatus;
    private String acceptanceStatusStr;
    private String checkTypeName;
    private String constructionStatus;
    private String constructionStatusStr;
    private String constructionUnitName;
    private String createName;
    private String createTime;
    private String diseaseComponentsName;
    private String diseaseNumber;
    private String diseaseTypeName;
    private String endPileNo;
    private String endTime;
    private String eventCode;
    private String incidentNumber;
    private String measure;
    private String measureUnit;
    private String patrolObjectName;
    private String positionPileNumber;
    private String projectCode;
    private String projectName;
    private String projectStatus;
    private String projectStatusStr;
    private String startEndTime;
    private String startPileNo;
    private String startTime;
    private String townName;

    public String getAcceptanceStatus() {
        return this.acceptanceStatus;
    }

    public String getAcceptanceStatusStr() {
        return this.acceptanceStatusStr;
    }

    public String getCheckTypeName() {
        return this.checkTypeName;
    }

    public String getConstructionStatus() {
        return this.constructionStatus;
    }

    public String getConstructionStatusStr() {
        return this.constructionStatusStr;
    }

    public String getConstructionUnitName() {
        return this.constructionUnitName;
    }

    public String getCreateName() {
        return this.createName;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getDSGNumber() {
        return EmptyUtils.isEmpty(this.DSGNumber) ? BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO : this.DSGNumber;
    }

    public String getDZGNumber() {
        return EmptyUtils.isEmpty(this.DZGNumber) ? BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO : this.DZGNumber;
    }

    public String getDiseaseComponentsName() {
        return this.diseaseComponentsName;
    }

    public String getDiseaseNumber() {
        return this.diseaseNumber;
    }

    public String getDiseaseTypeName() {
        return this.diseaseTypeName;
    }

    public String getEndPileNo() {
        return this.endPileNo;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public String getIncidentNumber() {
        return EmptyUtils.isEmpty(this.incidentNumber) ? BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO : this.incidentNumber;
    }

    public String getMeasure() {
        return this.measure;
    }

    public String getMeasureUnit() {
        return this.measureUnit;
    }

    public String getPatrolObjectName() {
        return this.patrolObjectName;
    }

    public String getPickerViewText() {
        return this.projectName;
    }

    public String getPositionPileNumber() {
        return this.positionPileNumber;
    }

    public String getProjectCode() {
        return this.projectCode;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public String getProjectStatus() {
        return this.projectStatus;
    }

    public String getProjectStatusStr() {
        return this.projectStatusStr;
    }

    public String getStartEndTime() {
        return this.startEndTime;
    }

    public String getStartPileNo() {
        return this.startPileNo;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getTownName() {
        return this.townName;
    }
}
