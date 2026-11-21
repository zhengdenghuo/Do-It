package com.collectpoint.bean.req;

import com.collectpoint.BuildConfig;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class InsertPatrolTrajectoryReq {
    private List<HighwayPatrolTaskTrajectoryApiReq> lonLatList;
    private String patrolMileage;
    private String patrolTimeLength;
    private String userCode;
    private String versions = BuildConfig.VERSION_NAME;

    public List<HighwayPatrolTaskTrajectoryApiReq> getLonLatList() {
        return this.lonLatList;
    }

    public void setTrajectoryApiReqs(String str, String str2, String str3, List<HighwayPatrolTaskTrajectoryApiReq> list) {
        this.userCode = str;
        this.patrolTimeLength = str2;
        this.patrolMileage = str3;
        this.lonLatList = list;
    }
}
