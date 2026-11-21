package com.collectpoint.bean;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class StatisticsPatrolModule {
    private List<PatrolModule> commonFunctionMenuList;
    private List<StatisticsModule> commonStatisticsMenuList;

    public List<PatrolModule> getCommonFunctionMenuList() {
        return this.commonFunctionMenuList;
    }

    public List<StatisticsModule> getCommonStatisticsMenuList() {
        return this.commonStatisticsMenuList;
    }

    public StatisticsPatrolModule setCommonFunctionMenuList(List<PatrolModule> list) {
        this.commonFunctionMenuList = list;
        return this;
    }

    public StatisticsPatrolModule setCommonStatisticsMenuList(List<StatisticsModule> list) {
        this.commonStatisticsMenuList = list;
        return this;
    }
}
