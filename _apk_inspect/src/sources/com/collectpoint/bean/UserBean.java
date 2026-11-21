package com.collectpoint.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.collectpoint.bean.item.AuthorityListItem;
import com.collectpoint.bean.item.MenuItem;
import com.collectpoint.bean.item.NewsInformationListItem;
import com.collectpoint.bean.item.RotationListItem;
import com.collectpoint.bean.item.StatisticListItem;
import com.collectpoint.bean.item.UserOrgListItem;
import com.collectpoint.bean.item.UserRoleListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class UserBean implements Parcelable {
    public static final Parcelable.Creator<UserBean> CREATOR = new Parcelable.Creator<UserBean>() { // from class: com.collectpoint.bean.UserBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserBean createFromParcel(Parcel parcel) {
            return new UserBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserBean[] newArray(int i) {
            return new UserBean[i];
        }
    };
    private String account;
    private String appMake;
    private AppMenuInfo appMenuInfo;
    private String app_id;
    private List<AuthorityListItem> authorityList;
    private String bottomMenu;
    private List<MenuItem> businessModuleList;
    private String cashier_id;
    private List<PatrolModule> commonFunctionMenuList;
    private List<StatisticsModule> commonStatisticsMenuList;
    private List<String> defaultRoleMenuButtonList;
    private String deleteFileUrl;
    private String fileDownloadUrl;
    private String fileUploadUrl;
    private List<WorkingFeature> hostList;
    private String hwMeetingApiUrl;
    private String hwMeetingAppId;
    private String hwMeetingAppKey;
    private String mobile;
    private String name;
    private List<NewsInformationListItem> newsInformationList;
    private String nickName;
    private OrgCodeBean orgCode;
    private String ossPath;
    private String patrolApiUrl;
    private List<CommonModule> patrolList;
    private String projectOrgCode;
    private RoleInfoBean roleInfo;
    private List<RotationListItem> rotationList;
    private String shop_supplier_id;
    private String showImgUrl;
    private String showVideoUrl;
    private List<StatisticListItem> statisticList;
    private String token;
    private String userCode;
    private String userImg;
    private List<UserOrgListItem> userOrgList;
    private String userPhone;
    private List<UserRoleListItem> userRoleList;
    private String userType;
    private String user_name;
    private List<MenuItem> waitMattersList;

    public UserBean() {
    }

    protected UserBean(Parcel parcel) {
        this.fileUploadUrl = parcel.readString();
        this.userImg = parcel.readString();
        this.nickName = parcel.readString();
        this.userPhone = parcel.readString();
        this.userType = parcel.readString();
        this.patrolApiUrl = parcel.readString();
        this.userCode = parcel.readString();
        this.token = parcel.readString();
        this.hostList = parcel.createTypedArrayList(WorkingFeature.CREATOR);
        this.patrolList = parcel.createTypedArrayList(CommonModule.CREATOR);
        this.showImgUrl = parcel.readString();
        this.showVideoUrl = parcel.readString();
        this.deleteFileUrl = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.userOrgList = parcel.createTypedArrayList(UserOrgListItem.CREATOR);
        this.orgCode = (OrgCodeBean) parcel.readParcelable(OrgCodeBean.class.getClassLoader());
        this.fileDownloadUrl = parcel.readString();
        this.newsInformationList = parcel.createTypedArrayList(NewsInformationListItem.CREATOR);
        this.roleInfo = (RoleInfoBean) parcel.readParcelable(RoleInfoBean.class.getClassLoader());
        this.userRoleList = parcel.createTypedArrayList(UserRoleListItem.CREATOR);
        this.statisticList = parcel.createTypedArrayList(StatisticListItem.CREATOR);
        this.rotationList = parcel.createTypedArrayList(RotationListItem.CREATOR);
        this.commonFunctionMenuList = parcel.createTypedArrayList(PatrolModule.CREATOR);
        this.commonStatisticsMenuList = parcel.createTypedArrayList(StatisticsModule.CREATOR);
        this.waitMattersList = parcel.createTypedArrayList(MenuItem.CREATOR);
        this.businessModuleList = parcel.createTypedArrayList(MenuItem.CREATOR);
        this.bottomMenu = parcel.readString();
        this.authorityList = parcel.createTypedArrayList(AuthorityListItem.CREATOR);
        this.appMake = parcel.readString();
        this.ossPath = parcel.readString();
        this.appMenuInfo = (AppMenuInfo) parcel.readParcelable(AppMenuInfo.class.getClassLoader());
        this.hwMeetingAppId = parcel.readString();
        this.hwMeetingAppKey = parcel.readString();
        this.hwMeetingApiUrl = parcel.readString();
        this.defaultRoleMenuButtonList = parcel.createStringArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccount() {
        return this.account;
    }

    public String getAppMake() {
        return this.appMake;
    }

    public AppMenuInfo getAppMenuInfo() {
        return this.appMenuInfo;
    }

    public String getApp_id() {
        return this.app_id;
    }

    public List<AuthorityListItem> getAuthorityList() {
        return this.authorityList;
    }

    public String getBottomMenu() {
        return this.bottomMenu;
    }

    public List<MenuItem> getBusinessModuleList() {
        return this.businessModuleList;
    }

    public String getCashier_id() {
        return this.cashier_id;
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

    public String getDeleteFileUrl() {
        return this.deleteFileUrl;
    }

    public String getFileDownloadUrl() {
        return this.fileDownloadUrl;
    }

    public String getFileUploadUrl() {
        return this.fileUploadUrl;
    }

    public List<WorkingFeature> getHostList() {
        return this.hostList;
    }

    public String getHwMeetingApiUrl() {
        return this.hwMeetingApiUrl;
    }

    public String getHwMeetingAppId() {
        return this.hwMeetingAppId;
    }

    public String getHwMeetingAppKey() {
        return this.hwMeetingAppKey;
    }

    public List<String> getMenuButtonList() {
        return this.defaultRoleMenuButtonList;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getName() {
        return this.name;
    }

    public List<NewsInformationListItem> getNewsInformationList() {
        return this.newsInformationList;
    }

    public String getNickName() {
        return this.nickName;
    }

    public OrgCodeBean getOrgCode() {
        return this.orgCode;
    }

    public String getOssPath() {
        return this.ossPath;
    }

    public String getPatrolApiUrl() {
        return this.patrolApiUrl;
    }

    public List<CommonModule> getPatrolList() {
        return this.patrolList;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public RoleInfoBean getRoleInfo() {
        return this.roleInfo;
    }

    public List<RotationListItem> getRotationList() {
        return this.rotationList;
    }

    public String getShop_supplier_id() {
        return this.shop_supplier_id;
    }

    public String getShowImgUrl() {
        return this.showImgUrl;
    }

    public String getShowVideoUrl() {
        return this.showVideoUrl;
    }

    public List<StatisticListItem> getStatisticList() {
        return this.statisticList;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public String getUserImg() {
        return this.userImg;
    }

    public List<UserOrgListItem> getUserOrgList() {
        return this.userOrgList;
    }

    public String getUserPhone() {
        return this.userPhone;
    }

    public List<UserRoleListItem> getUserRoleList() {
        return this.userRoleList;
    }

    public String getUserType() {
        return this.userType;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public List<MenuItem> getWaitMattersList() {
        return this.waitMattersList;
    }

    public void readFromParcel(Parcel parcel) {
        this.fileUploadUrl = parcel.readString();
        this.userImg = parcel.readString();
        this.nickName = parcel.readString();
        this.userPhone = parcel.readString();
        this.userType = parcel.readString();
        this.patrolApiUrl = parcel.readString();
        this.userCode = parcel.readString();
        this.token = parcel.readString();
        this.hostList = parcel.createTypedArrayList(WorkingFeature.CREATOR);
        this.patrolList = parcel.createTypedArrayList(CommonModule.CREATOR);
        this.showImgUrl = parcel.readString();
        this.showVideoUrl = parcel.readString();
        this.deleteFileUrl = parcel.readString();
        this.projectOrgCode = parcel.readString();
        this.userOrgList = parcel.createTypedArrayList(UserOrgListItem.CREATOR);
        this.orgCode = (OrgCodeBean) parcel.readParcelable(OrgCodeBean.class.getClassLoader());
        this.fileDownloadUrl = parcel.readString();
        this.newsInformationList = parcel.createTypedArrayList(NewsInformationListItem.CREATOR);
        this.roleInfo = (RoleInfoBean) parcel.readParcelable(RoleInfoBean.class.getClassLoader());
        this.userRoleList = parcel.createTypedArrayList(UserRoleListItem.CREATOR);
        this.statisticList = parcel.createTypedArrayList(StatisticListItem.CREATOR);
        this.rotationList = parcel.createTypedArrayList(RotationListItem.CREATOR);
        this.commonFunctionMenuList = parcel.createTypedArrayList(PatrolModule.CREATOR);
        this.commonStatisticsMenuList = parcel.createTypedArrayList(StatisticsModule.CREATOR);
        this.waitMattersList = parcel.createTypedArrayList(MenuItem.CREATOR);
        this.businessModuleList = parcel.createTypedArrayList(MenuItem.CREATOR);
        this.bottomMenu = parcel.readString();
        this.authorityList = parcel.createTypedArrayList(AuthorityListItem.CREATOR);
        this.appMake = parcel.readString();
        this.ossPath = parcel.readString();
        this.appMenuInfo = (AppMenuInfo) parcel.readParcelable(AppMenuInfo.class.getClassLoader());
        this.hwMeetingAppId = parcel.readString();
        this.hwMeetingAppKey = parcel.readString();
        this.hwMeetingApiUrl = parcel.readString();
        this.defaultRoleMenuButtonList = parcel.createStringArrayList();
    }

    public void setAppMake(String str) {
        this.appMake = str;
    }

    public void setAppMenuInfo(AppMenuInfo appMenuInfo) {
        this.appMenuInfo = appMenuInfo;
    }

    public void setAuthorityList(List<AuthorityListItem> list) {
        this.authorityList = list;
    }

    public void setBottomMenu(String str) {
        this.bottomMenu = str;
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

    public void setDeleteFileUrl(String str) {
        this.deleteFileUrl = str;
    }

    public void setFileDownloadUrl(String str) {
        this.fileDownloadUrl = str;
    }

    public void setFileUploadUrl(String str) {
        this.fileUploadUrl = str;
    }

    public void setHostList(List<WorkingFeature> list) {
        this.hostList = list;
    }

    public void setNewsInformationList(List<NewsInformationListItem> list) {
        this.newsInformationList = list;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setOrgCode(OrgCodeBean orgCodeBean) {
        this.orgCode = orgCodeBean;
    }

    public void setPatrolApiUrl(String str) {
        this.patrolApiUrl = str;
    }

    public void setPatrolList(List<CommonModule> list) {
        this.patrolList = list;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setRoleInfo(RoleInfoBean roleInfoBean) {
        this.roleInfo = roleInfoBean;
    }

    public void setRotationList(List<RotationListItem> list) {
        this.rotationList = list;
    }

    public void setShowImgUrl(String str) {
        this.showImgUrl = str;
    }

    public void setShowVideoUrl(String str) {
        this.showVideoUrl = str;
    }

    public void setStatisticList(List<StatisticListItem> list) {
        this.statisticList = list;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public void setUserImg(String str) {
        this.userImg = str;
    }

    public void setUserOrgList(List<UserOrgListItem> list) {
        this.userOrgList = list;
    }

    public void setUserPhone(String str) {
        this.userPhone = str;
    }

    public void setUserRoleList(List<UserRoleListItem> list) {
        this.userRoleList = list;
    }

    public void setUserType(String str) {
        this.userType = str;
    }

    public void setWaitMattersList(List<MenuItem> list) {
        this.waitMattersList = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fileUploadUrl);
        parcel.writeString(this.userImg);
        parcel.writeString(this.nickName);
        parcel.writeString(this.userPhone);
        parcel.writeString(this.userType);
        parcel.writeString(this.patrolApiUrl);
        parcel.writeString(this.userCode);
        parcel.writeString(this.token);
        parcel.writeTypedList(this.hostList);
        parcel.writeTypedList(this.patrolList);
        parcel.writeString(this.showImgUrl);
        parcel.writeString(this.showVideoUrl);
        parcel.writeString(this.deleteFileUrl);
        parcel.writeString(this.projectOrgCode);
        parcel.writeTypedList(this.userOrgList);
        parcel.writeParcelable(this.orgCode, i);
        parcel.writeString(this.fileDownloadUrl);
        parcel.writeTypedList(this.newsInformationList);
        parcel.writeParcelable(this.roleInfo, i);
        parcel.writeTypedList(this.userRoleList);
        parcel.writeTypedList(this.statisticList);
        parcel.writeTypedList(this.rotationList);
        parcel.writeTypedList(this.commonFunctionMenuList);
        parcel.writeTypedList(this.commonStatisticsMenuList);
        parcel.writeTypedList(this.waitMattersList);
        parcel.writeTypedList(this.businessModuleList);
        parcel.writeString(this.bottomMenu);
        parcel.writeTypedList(this.authorityList);
        parcel.writeString(this.appMake);
        parcel.writeString(this.ossPath);
        parcel.writeParcelable(this.appMenuInfo, i);
        parcel.writeString(this.hwMeetingAppId);
        parcel.writeString(this.hwMeetingAppKey);
        parcel.writeString(this.hwMeetingApiUrl);
        parcel.writeStringList(this.defaultRoleMenuButtonList);
    }
}
