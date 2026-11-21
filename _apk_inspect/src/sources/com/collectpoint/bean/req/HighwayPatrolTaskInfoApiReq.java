package com.collectpoint.bean.req;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class HighwayPatrolTaskInfoApiReq {
    private String highwayPatrolTaskCode;
    private List<String> highwayPatrolTaskCodeList;
    private String patrolUserCode;

    public HighwayPatrolTaskInfoApiReq(String str) {
        this.highwayPatrolTaskCode = str;
    }

    public HighwayPatrolTaskInfoApiReq(String str, List<String> list) {
        this.patrolUserCode = str;
        this.highwayPatrolTaskCodeList = list;
    }

    public HighwayPatrolTaskInfoApiReq(List<String> list) {
        this.highwayPatrolTaskCodeList = list;
    }
}
