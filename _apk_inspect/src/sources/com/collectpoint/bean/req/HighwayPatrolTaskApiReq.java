package com.collectpoint.bean.req;

import com.collectpoint.BuildConfig;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class HighwayPatrolTaskApiReq {
    private String collectionTime;
    private String highwayPatrolTaskCode;
    private String ifCoerceEnd;
    private List<HighwayPatrolTaskTrajectoryApiReq> lonLatList;
    private String patrolMileage;
    private String patrolTimeLength;
    private String patrolUserCode;
    private String relevanceCode;
    private String teleCurTime;
    private String userCode;
    private boolean ifJudgeTime = false;
    private String versions = BuildConfig.VERSION_NAME;

    public HighwayPatrolTaskApiReq(String str, String str2, String str3) {
        this.teleCurTime = str2;
        this.patrolUserCode = str;
        this.relevanceCode = str3;
    }

    public HighwayPatrolTaskApiReq(String str, String str2, String str3, String str4, String str5, List<HighwayPatrolTaskTrajectoryApiReq> list) {
        this.userCode = str3;
        this.patrolTimeLength = str;
        this.patrolMileage = str2;
        this.patrolUserCode = str3;
        this.relevanceCode = str4;
        this.ifCoerceEnd = str5;
        this.lonLatList = list;
    }

    public HighwayPatrolTaskApiReq(String str, String str2, String str3, String str4, List<HighwayPatrolTaskTrajectoryApiReq> list) {
        this.userCode = str;
        this.patrolTimeLength = str2;
        this.patrolMileage = str3;
        this.patrolUserCode = str;
        this.relevanceCode = str4;
        this.lonLatList = list;
    }

    public HighwayPatrolTaskApiReq(String str, List<HighwayPatrolTaskTrajectoryApiReq> list) {
        this.relevanceCode = str;
        this.lonLatList = list;
    }
}
