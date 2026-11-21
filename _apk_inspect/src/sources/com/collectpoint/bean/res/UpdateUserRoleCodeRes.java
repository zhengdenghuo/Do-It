package com.collectpoint.bean.res;

import com.collectpoint.bean.AppMenuInfo;
import com.collectpoint.bean.CommonModule;
import com.collectpoint.bean.PatrolModule;
import com.collectpoint.bean.StatisticsModule;
import com.collectpoint.bean.WorkingFeature;
import com.collectpoint.bean.item.AuthorityListItem;
import com.collectpoint.bean.item.MenuItem;
import com.collectpoint.bean.item.NewsInformationListItem;
import com.collectpoint.bean.item.RotationListItem;
import com.collectpoint.bean.item.StatisticListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class UpdateUserRoleCodeRes {
    private AppMenuInfo appMenuInfo;
    private List<AuthorityListItem> authorityList;
    private List<MenuItem> businessModuleList;
    private List<PatrolModule> commonFunctionMenuList;
    private List<StatisticsModule> commonStatisticsMenuList;
    private List<String> defaultRoleMenuButtonList;
    private List<WorkingFeature> hostList;
    private List<NewsInformationListItem> newsInformationList;
    private List<CommonModule> patrolList;
    private List<RotationListItem> rotationList;
    private List<StatisticListItem> statisticList;
    private List<MenuItem> waitMattersList;

    public AppMenuInfo getAppMenuInfo() {
        return this.appMenuInfo;
    }

    public List<AuthorityListItem> getAuthorityList() {
        return this.authorityList;
    }

    public List<MenuItem> getBusinessModuleList() {
        return this.businessModuleList;
    }

    public List<PatrolModule> getCommonFunctionMenuList() {
        return this.commonFunctionMenuList;
    }

    public List<StatisticsModule> getCommonStatisticsMenuList() {
        return this.commonStatisticsMenuList;
    }

    public List<String> getDefaultRoleMenuButtonList() {
        return this.defaultRoleMenuButtonList;
    }

    public List<WorkingFeature> getHostList() {
        return this.hostList;
    }

    public List<NewsInformationListItem> getNewsInformationList() {
        return this.newsInformationList;
    }

    public List<CommonModule> getPatrolList() {
        return this.patrolList;
    }

    public List<RotationListItem> getRotationList() {
        return this.rotationList;
    }

    public List<StatisticListItem> getStatisticList() {
        return this.statisticList;
    }

    public List<MenuItem> getWaitMattersList() {
        return this.waitMattersList;
    }

    public void setAppMenuInfo(AppMenuInfo appMenuInfo) {
        this.appMenuInfo = appMenuInfo;
    }

    public void setAuthorityList(List<AuthorityListItem> list) {
        this.authorityList = list;
    }

    public void setBusinessModuleList(List<MenuItem> list) {
        this.businessModuleList = list;
    }

    public void setCommonFunctionMenuList(List<PatrolModule> list) {
        this.commonFunctionMenuList = list;
    }

    public void setCommonStatisticsMenuList(List<StatisticsModule> list) {
        this.commonStatisticsMenuList = list;
    }

    public void setDefaultRoleMenuButtonList(List<String> list) {
        this.defaultRoleMenuButtonList = list;
    }

    public void setHostList(List<WorkingFeature> list) {
        this.hostList = list;
    }

    public void setNewsInformationList(List<NewsInformationListItem> list) {
        this.newsInformationList = list;
    }

    public void setPatrolList(List<CommonModule> list) {
        this.patrolList = list;
    }

    public void setRotationList(List<RotationListItem> list) {
        this.rotationList = list;
    }

    public void setStatisticList(List<StatisticListItem> list) {
        this.statisticList = list;
    }

    public void setWaitMattersList(List<MenuItem> list) {
        this.waitMattersList = list;
    }
}
