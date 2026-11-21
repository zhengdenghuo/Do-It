package com.collectpoint.bean.req;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class InsertPatrolTaskRecordReq {
    private List<String> highwayPatrolTaskCodeList;
    private String patrolUserCode;
    private String planEndDate;
    private String planStartDate;
    private String taskType = "Double";
    private String teleCurTime;

    public InsertPatrolTaskRecordReq(String str, String str2, String str3, String str4, List<String> list) {
        this.teleCurTime = str2;
        this.patrolUserCode = str;
        this.planStartDate = str3;
        this.planEndDate = str4;
        this.highwayPatrolTaskCodeList = list;
    }
}
