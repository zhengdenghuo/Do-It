package com.collectpoint.bean.res;

import com.collectpoint.utils.BitmapMemoryCache;
import com.collectpoint.utils.EmptyUtils;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class HighwayPatrolTaskDataApiRes {
    private String inspectionNumber;
    private String invalid_sum;
    private String overSpeed_sum;
    private String patrolMileage_sum;
    private String patrolTimeLength_sum;
    private String planMileage_sum;

    public String getInspectionNumber() {
        return this.inspectionNumber;
    }

    public String getInvalid_sum() {
        return EmptyUtils.isEmpty(this.invalid_sum) ? BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO : this.invalid_sum;
    }

    public String getOverSpeed_sum() {
        return this.overSpeed_sum;
    }

    public String getPatrolMileage_sum() {
        return this.patrolMileage_sum;
    }

    public String getPatrolTimeLength_sum() {
        return this.patrolTimeLength_sum;
    }

    public String getPlanMileage_sum() {
        return this.planMileage_sum;
    }

    public void setInspectionNumber(String str) {
        this.inspectionNumber = str;
    }

    public void setPatrolMileage_sum(String str) {
        this.patrolMileage_sum = str;
    }

    public void setPatrolTimeLength_sum(String str) {
        this.patrolTimeLength_sum = str;
    }
}
