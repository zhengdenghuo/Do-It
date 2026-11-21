package com.collectpoint.net.vm;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.collectpoint.bean.PatrolEventBean;
import com.collectpoint.bean.PersonnelItem;
import com.collectpoint.bean.item.AddDeviceItem;
import com.collectpoint.bean.item.ApiRepairIncidentListItem;
import com.collectpoint.bean.item.ApiRepairProjectListItem;
import com.collectpoint.bean.item.BridgeInspectTaskListItem;
import com.collectpoint.bean.item.CategoryItem;
import com.collectpoint.bean.item.CollectionTodaItem;
import com.collectpoint.bean.item.CouponItem;
import com.collectpoint.bean.item.CouponPayItem;
import com.collectpoint.bean.item.CurrentDatePatrolPersonnelSignInTaskListItem;
import com.collectpoint.bean.item.DeptPatrolReportListItem;
import com.collectpoint.bean.item.DeviceCodeItem;
import com.collectpoint.bean.item.DictionaryListItem;
import com.collectpoint.bean.item.ExamineObjectListItem;
import com.collectpoint.bean.item.ExamineQuarterListItem;
import com.collectpoint.bean.item.ExamineReportListItem;
import com.collectpoint.bean.item.FieldListItem;
import com.collectpoint.bean.item.FiveColorWarningReportItem;
import com.collectpoint.bean.item.GetObjectListItem;
import com.collectpoint.bean.item.GroupTypeItem;
import com.collectpoint.bean.item.HighwayPatrolTaskTreeApiItem;
import com.collectpoint.bean.item.InsertPersonnelDeviceRecordItem;
import com.collectpoint.bean.item.MenuItem;
import com.collectpoint.bean.item.NeedToCheckPartListItem;
import com.collectpoint.bean.item.ObjectRoadListItem;
import com.collectpoint.bean.item.OrderDetailListItem;
import com.collectpoint.bean.item.OrgCodeItem;
import com.collectpoint.bean.item.PartsDiseaseListItem;
import com.collectpoint.bean.item.PartsDiseaseResultsItem;
import com.collectpoint.bean.item.PatrolEventListApiItem;
import com.collectpoint.bean.item.PatrolEventListItem;
import com.collectpoint.bean.item.PatrolEventStatusListItem;
import com.collectpoint.bean.item.PatrolManageReportListItem;
import com.collectpoint.bean.item.PatrolMapPatrolDataListItem;
import com.collectpoint.bean.item.PatrolMapPatrolTypeListItem;
import com.collectpoint.bean.item.PatrolObjectByMapItem;
import com.collectpoint.bean.item.PatrolObjectTreeByMapItem;
import com.collectpoint.bean.item.PatrolPersonnelRealTimeInfoListItem;
import com.collectpoint.bean.item.PatrolPersonnelReportListItem;
import com.collectpoint.bean.item.PatrolProblemIssueOpinionListItem;
import com.collectpoint.bean.item.PatrolProblemPatrolTypeReportListItem;
import com.collectpoint.bean.item.PatrolProblemRecordListItem;
import com.collectpoint.bean.item.PermissionItem;
import com.collectpoint.bean.item.PersonnelLocationListItem;
import com.collectpoint.bean.item.PersonnelTrajectoryListItem;
import com.collectpoint.bean.item.PointItem;
import com.collectpoint.bean.item.ProblemManageListItem;
import com.collectpoint.bean.item.ProblemOperationRecordListItem;
import com.collectpoint.bean.item.ProblemStatusListItem;
import com.collectpoint.bean.item.ProjectObjectFirstListItem;
import com.collectpoint.bean.item.ProjectOrgProcessAreaItem;
import com.collectpoint.bean.item.ProjectTypeFieldListItem;
import com.collectpoint.bean.item.ProjectTypeListItem;
import com.collectpoint.bean.item.ProvinceListItem;
import com.collectpoint.bean.item.RegionListByMapItem;
import com.collectpoint.bean.item.SelectAttendancePersonnelFenceListByDateItem;
import com.collectpoint.bean.item.SortContentByMapItem;
import com.collectpoint.bean.item.SortContentTreeByMapItem;
import com.collectpoint.bean.item.TableAreaItem;
import com.collectpoint.bean.item.TownPatrolReportListItem;
import com.collectpoint.bean.req.AddOrderCouponReq;
import com.collectpoint.bean.req.CollectionObjectInfoReq;
import com.collectpoint.bean.req.HighwayPatrolTaskTrajectoryApiReq;
import com.collectpoint.bean.req.InsertPatrolTrajectoryReq;
import com.collectpoint.bean.req.OrderInfo2Req;
import com.collectpoint.bean.req.TableStatusReq;
import com.collectpoint.bean.res.ApiRepairIncidentInfoRes;
import com.collectpoint.bean.res.ApiRepairProjectInfoRes;
import com.collectpoint.bean.res.AutoPatrolSignInRes;
import com.collectpoint.bean.res.BaseDataRes;
import com.collectpoint.bean.res.BaseListDataRes;
import com.collectpoint.bean.res.BaseListRes;
import com.collectpoint.bean.res.BaseResponse;
import com.collectpoint.bean.res.BaseResuleRes;
import com.collectpoint.bean.res.BridgeInspectNumberRes;
import com.collectpoint.bean.res.BridgeInspectRecordInfoRes;
import com.collectpoint.bean.res.CoupomRes;
import com.collectpoint.bean.res.Coupon2Res;
import com.collectpoint.bean.res.EndHighwayPatrolTaskRes;
import com.collectpoint.bean.res.HallCartDetailRes;
import com.collectpoint.bean.res.HallCartRes;
import com.collectpoint.bean.res.HallCartlistRes;
import com.collectpoint.bean.res.HighwayPatrolConfigRes;
import com.collectpoint.bean.res.HighwayPatrolTaskDataApiRes;
import com.collectpoint.bean.res.HighwayPatrolTaskInfoApiRes;
import com.collectpoint.bean.res.HighwayPatrolTaskStatusNumberRes;
import com.collectpoint.bean.res.HighwayPatrolTaskingApiRes;
import com.collectpoint.bean.res.IndexIndexRes;
import com.collectpoint.bean.res.InsertPointInfoRes;
import com.collectpoint.bean.res.ObjectRoadInfoRes;
import com.collectpoint.bean.res.OnlineStatusRes;
import com.collectpoint.bean.res.OrderDetailRes;
import com.collectpoint.bean.res.OrderInfoRes;
import com.collectpoint.bean.res.PatrolPersonnelSignInPointRecordInfoRes;
import com.collectpoint.bean.res.PatrolProblemWarningMessageListRes;
import com.collectpoint.bean.res.PersonnelAttendanceRecordRes;
import com.collectpoint.bean.res.ProblemManageInfoRes;
import com.collectpoint.bean.res.RecentlyObjectRes;
import com.collectpoint.bean.res.RegionByAddressRes;
import com.collectpoint.bean.res.RepairProjectCheckInfoRes;
import com.collectpoint.bean.res.RestartPatrolTaskRes;
import com.collectpoint.bean.res.ScanPayRes;
import com.collectpoint.bean.res.SelectAttendancePersonnelFenceListRes;
import com.collectpoint.bean.res.SubmitProblemInfoRes;
import com.collectpoint.bean.res.UploadRes;
import com.collectpoint.bean.res.UploadWxRes;
import com.collectpoint.bean.res.VersionRes;
import com.collectpoint.bean.res.WeatherInfoRes;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.repo.PatrolRepo;
import com.collectpoint.net.repo.RxHandler;
import com.collectpoint.net.repo.UploadFileRepo;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.TimeUtil;
import com.google.common.base.Preconditions;
import com.liuwq.base.databinding.BaseRequestViewModel;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class PatrolVm extends BaseRequestViewModel {
    public MediatorLiveData<Resource<String>> decomposePatrolPersonnelManage;
    public MediatorLiveData<Resource<Object>> mAddDeviceOrder;
    public MediatorLiveData<Resource<Object>> mAddMeal;
    public MediatorLiveData<Resource<String>> mAddOrUpdateProblemManageRecord;
    public MediatorLiveData<Resource<Object>> mAddOrderCoupon;
    public MediatorLiveData<Resource<String>> mAffirmHighwayPatrolTaskApi;
    public MediatorLiveData<Resource<ApiRepairIncidentInfoRes>> mApiRepairIncidentInfo;
    public MediatorLiveData<Resource<List<ApiRepairIncidentListItem>>> mApiRepairIncidentList;
    public MediatorLiveData<Resource<List<ApiRepairProjectListItem>>> mApiRepairProjectIncidentAcceptanceList;
    public MediatorLiveData<Resource<ApiRepairProjectInfoRes>> mApiRepairProjectInfo;
    public MediatorLiveData<Resource<List<ApiRepairProjectListItem>>> mApiRepairProjectList;
    public MediatorLiveData<Resource<List<ProblemStatusListItem>>> mAssignTypeList;
    public MediatorLiveData<Resource<AutoPatrolSignInRes>> mAutoPatrolSignIn;
    public MediatorLiveData<Resource<List<ProblemManageListItem>>> mAwaitDecomposePatrolProblemList;
    public MediatorLiveData<Resource<BridgeInspectNumberRes>> mBridgeInspectHisNumber;
    public MediatorLiveData<Resource<BridgeInspectNumberRes>> mBridgeInspectNumber;
    public MediatorLiveData<Resource<BridgeInspectRecordInfoRes>> mBridgeInspectRecordInfo;
    public MediatorLiveData<Resource<List<BridgeInspectTaskListItem>>> mBridgeInspectRecordList;
    public MediatorLiveData<Resource<List<BridgeInspectTaskListItem>>> mBridgeInspectTaskHisList;
    public MediatorLiveData<Resource<List<BridgeInspectTaskListItem>>> mBridgeInspectTaskList;
    public MediatorLiveData<Resource<BaseListDataRes<List<CategoryItem>>>> mCategoryIndex;
    public MediatorLiveData<Resource<Object>> mChangeNum;
    public MediatorLiveData<Resource<Object>> mChangeTable;
    public MediatorLiveData<Resource<BaseListDataRes<List<TableAreaItem>>>> mChangeTableList;
    public MediatorLiveData<Resource<String>> mClosePatrolProblem;
    public MediatorLiveData<Resource<List<CollectionObjectInfoReq>>> mCollectionObjectInfoApi;
    public MediatorLiveData<Resource<List<ProjectObjectFirstListItem>>> mCollectionObjectListApi;
    public MediatorLiveData<Resource<InsertPointInfoRes>> mCollectionRecordInfoApi;
    public MediatorLiveData<Resource<List<CollectionTodaItem>>> mCollectionRecordListApi;
    public MediatorLiveData<Resource<List<InsertPointInfoRes>>> mCollectionRecordTrackInfoApi;
    public MediatorLiveData<Resource<List<CollectionTodaItem>>> mCollectionTodayApi;
    public MediatorLiveData<Resource<List<CollectionTodaItem>>> mCollectionTodayPointApi;
    public MediatorLiveData<Resource<List<List<CollectionTodaItem>>>> mCollectionTodayTrackApi;
    public MediatorLiveData<Resource<String>> mCompletedPatrolProblem;
    public MediatorLiveData<Resource<BaseDataRes<Coupon2Res>>> mCouponInfo2;
    public MediatorLiveData<Resource<BaseDataRes<List<CoupomRes>>>> mCouponList;
    public MediatorLiveData<Resource<BaseDataRes<List<CouponItem>>>> mCouponListDyMt;
    public MediatorLiveData<Resource<String>> mCreateGroup;
    public MediatorLiveData<Resource<List<CurrentDatePatrolPersonnelSignInTaskListItem>>> mCurrentDatePatrolPersonnelSignInTaskList;
    public MediatorLiveData<Resource<String>> mDeleteGroup;
    public MediatorLiveData<Resource<String>> mDeleteTrackListApi;
    public MediatorLiveData<Resource<List<DeptPatrolReportListItem>>> mDeptPatrolReportList;
    public MediatorLiveData<Resource<BaseListRes<DeviceCodeItem>>> mDeviceCode;
    public MediatorLiveData<Resource<List<DictionaryListItem>>> mDictionaryList;
    public MediatorLiveData<Resource<List<DictionaryListItem>>> mDictionaryListMySelf;
    public MediatorLiveData<Resource<EndHighwayPatrolTaskRes>> mEndHighwayPatrolTaskApi;
    public MediatorLiveData<Resource<List<ExamineObjectListItem>>> mExamineObjectList;
    public MediatorLiveData<Resource<List<ExamineQuarterListItem>>> mExamineQuarterList;
    public MediatorLiveData<Resource<List<ExamineReportListItem>>> mExamineReportList;
    public MediatorLiveData<Resource<List<ExamineObjectListItem>>> mExamineTypeList;
    public MediatorLiveData<Resource<List<FiveColorWarningReportItem>>> mFiveColorWarningReport;
    public MediatorLiveData<Resource<List<GetObjectListItem>>> mGetObjectList;
    public MediatorLiveData<Resource<List<GetObjectListItem>>> mGetObjectListMySelf;
    public MediatorLiveData<Resource<BaseDataRes<List<CouponItem>>>> mGroupCouponList;
    public MediatorLiveData<Resource<BaseListRes<GroupTypeItem>>> mGroupTypeList;
    public MediatorLiveData<Resource<Object>> mHallCartAdd;
    public MediatorLiveData<Resource<Object>> mHallCartDelete;
    public MediatorLiveData<Resource<HallCartlistRes>> mHallCartList;
    public MediatorLiveData<Resource<Object>> mHallCartSub;
    public MediatorLiveData<Resource<HighwayPatrolConfigRes>> mHighwayPatrolConfig;
    public MediatorLiveData<Resource<String>> mHighwayPatrolTaskCodeApi;
    public MediatorLiveData<Resource<HighwayPatrolTaskDataApiRes>> mHighwayPatrolTaskDataApi;
    public MediatorLiveData<Resource<List<HighwayPatrolTaskTreeApiItem>>> mHighwayPatrolTaskGroupListApi;
    public MediatorLiveData<Resource<HighwayPatrolTaskInfoApiRes>> mHighwayPatrolTaskInfoApi;
    public MediatorLiveData<Resource<List<HighwayPatrolTaskTreeApiItem>>> mHighwayPatrolTaskListApi;
    public MediatorLiveData<Resource<List<HighwayPatrolTaskTreeApiItem>>> mHighwayPatrolTaskListToadyApi;
    public MediatorLiveData<Resource<List<HighwayPatrolTaskTreeApiItem>>> mHighwayPatrolTaskRecordListApi;
    public MediatorLiveData<Resource<HighwayPatrolTaskStatusNumberRes>> mHighwayPatrolTaskStatusNumber;
    public MediatorLiveData<Resource<BridgeInspectTaskListItem>> mHighwayPatrolTaskTimeJudge;
    public MediatorLiveData<Resource<BridgeInspectTaskListItem>> mHighwayPatrolTaskTimeJudge2;
    public MediatorLiveData<Resource<List<HighwayPatrolTaskTreeApiItem>>> mHighwayPatrolTaskTreeApi;
    public MediatorLiveData<Resource<HighwayPatrolTaskingApiRes>> mHighwayPatrolTaskingApi;
    public MediatorLiveData<Resource<HighwayPatrolTaskingApiRes>> mHighwayPatrolTaskingDataApi;
    public MediatorLiveData<Resource<List<HighwayPatrolTaskTreeApiItem>>> mHistoricalHighwayPatrolTaskTreeApi;
    public MediatorLiveData<Resource<List<ProblemManageListItem>>> mHistoryPatrolProblemList;
    private final RxHandler mHttpHandler;
    public MediatorLiveData<Resource<IndexIndexRes>> mIndexIndex;
    public MediatorLiveData<Resource<String>> mInsertBridgeInspectEvent;
    public MediatorLiveData<Resource<String>> mInsertHighwayPatrolTaskRecord;
    public MediatorLiveData<Resource<InsertPatrolTrajectoryReq>> mInsertHighwayPatrolTaskTrajectoryListApi;
    public MediatorLiveData<Resource<String>> mInsertPatrolEvent;
    public MediatorLiveData<Resource<String>> mInsertPatrolEventProcessByMySelf;
    public MediatorLiveData<Resource<String>> mInsertPatrolProblem;
    public MediatorLiveData<Resource<String>> mInsertPatrolProblemComment;
    public MediatorLiveData<Resource<String>> mInsertPatrolProblemManageByMyself;
    public MediatorLiveData<Resource<String>> mInsertPersonnelDeviceRecord;
    public MediatorLiveData<Resource<String>> mInsertPointInfoApi;
    public MediatorLiveData<Resource<String>> mInsertRepairProjectCheckRectification;
    public MediatorLiveData<Resource<String>> mInsertRepairProjectIncidentManageRecord;
    public MediatorLiveData<Resource<String>> mInsertRepairProjectIncidentTailRecord;
    public MediatorLiveData<Resource<String>> mInsertTrackListApi;
    public MediatorLiveData<Resource<String>> mIssuePatrolProblemOpinion;
    public MediatorLiveData<Resource<RegionByAddressRes>> mLocationInfo;
    public MediatorLiveData<Resource<String>> mLocationStation;
    public MediatorLiveData<Resource<List<OrgCodeItem>>> mManageUnitList;
    public MediatorLiveData<Resource<List<CurrentDatePatrolPersonnelSignInTaskListItem>>> mMapPatrolPersonnelSignInTaskList;
    public MediatorLiveData<Resource<Object>> mMergeTable;
    public MediatorLiveData<Resource<Object>> mMicroRefund;
    public MediatorLiveData<Resource<Object>> mMoveProduct;
    public MediatorLiveData<Resource<List<NeedToCheckPartListItem>>> mNeedToCheckPartListItem;
    public MediatorLiveData<Resource<Object>> mNewPay;
    public MediatorLiveData<Resource<ObjectRoadInfoRes>> mObjectRoadInfo;
    public MediatorLiveData<Resource<List<ObjectRoadListItem>>> mObjectRoadList;
    public MediatorLiveData<Resource<List<ObjectRoadListItem>>> mObjectRoadMapList;
    public MediatorLiveData<Resource<OnlineStatusRes>> mOnlineStatus;
    public MediatorLiveData<Resource<Object>> mOpen;
    public MediatorLiveData<Resource<Object>> mOpenScan;
    public MediatorLiveData<Resource<Object>> mOrderCancel;
    public MediatorLiveData<Resource<HallCartDetailRes>> mOrderDetail;
    public MediatorLiveData<Resource<BaseDataRes<OrderDetailRes>>> mOrderDetailHome;
    public MediatorLiveData<Resource<BaseListDataRes<BaseDataRes<List<OrderDetailListItem>>>>> mOrderDetailList;
    public MediatorLiveData<Resource<BaseDataRes<OrderInfoRes>>> mOrderInfo;
    public MediatorLiveData<Resource<BaseDataRes<List<CoupomRes>>>> mPackCouponList;
    public MediatorLiveData<Resource<List<PartsDiseaseListItem>>> mPartsDiseaseList;
    public MediatorLiveData<Resource<List<PartsDiseaseResultsItem>>> mPartsDiseaseResults;
    public MediatorLiveData<Resource<List<PatrolEventListItem>>> mPatrolEventList;
    public MediatorLiveData<Resource<List<PatrolEventListApiItem>>> mPatrolEventListApi;
    public MediatorLiveData<Resource<List<PatrolEventStatusListItem>>> mPatrolEventStatusList;
    public MediatorLiveData<Resource<List<PatrolManageReportListItem>>> mPatrolManageReportList;
    public MediatorLiveData<Resource<List<PatrolMapPatrolDataListItem>>> mPatrolMapPatrolDataList;
    public MediatorLiveData<Resource<List<PatrolMapPatrolTypeListItem>>> mPatrolMapPatrolTypeList;
    public MediatorLiveData<Resource<List<PatrolObjectByMapItem>>> mPatrolObjectByMap;
    public MediatorLiveData<Resource<List<PatrolObjectTreeByMapItem>>> mPatrolObjectTreeByMap;
    public MediatorLiveData<Resource<String>> mPatrolPersonnelLocationGroupList;
    public MediatorLiveData<Resource<List<PatrolPersonnelRealTimeInfoListItem>>> mPatrolPersonnelRealTimeInfoList;
    public MediatorLiveData<Resource<List<PatrolPersonnelReportListItem>>> mPatrolPersonnelReportList;
    public MediatorLiveData<Resource<String>> mPatrolPersonnelSignIn;
    public MediatorLiveData<Resource<PatrolPersonnelSignInPointRecordInfoRes>> mPatrolPersonnelSignInPointRecordInfo;
    public MediatorLiveData<Resource<String>> mPatrolPersonnelSignInSavePhoto;
    public MediatorLiveData<Resource<List<PatrolProblemIssueOpinionListItem>>> mPatrolProblemIssueOpinionList;
    public MediatorLiveData<Resource<List<PatrolProblemPatrolTypeReportListItem>>> mPatrolProblemPatrolTypeReportList;
    public MediatorLiveData<Resource<List<PatrolProblemRecordListItem>>> mPatrolProblemRecordList;
    public MediatorLiveData<Resource<PatrolProblemWarningMessageListRes>> mPatrolProblemWarningMessageList;
    public MediatorLiveData<Resource<BaseDataRes<List<CouponItem>>>> mPaymentMethod;
    public MediatorLiveData<Resource<BaseListRes<PermissionItem>>> mPermissionList;
    public MediatorLiveData<Resource<PersonnelAttendanceRecordRes>> mPersonnelAttendanceRecord;
    public MediatorLiveData<Resource<List<PersonnelLocationListItem>>> mPersonnelLocationList;
    public MediatorLiveData<Resource<List<PersonnelItem>>> mPersonnelResList;
    public MediatorLiveData<Resource<List<CurrentDatePatrolPersonnelSignInTaskListItem>>> mPersonnelSignInRecordList;
    public MediatorLiveData<Resource<List<PersonnelTrajectoryListItem>>> mPersonnelTrajectoryList;
    public MediatorLiveData<Resource<String>> mPreClosurePatrolProblem;
    public MediatorLiveData<Resource<HighwayPatrolTaskInfoApiRes>> mPreviewHighwayPatrolTaskListApi;
    public MediatorLiveData<Resource<Object>> mPrintBill;
    public MediatorLiveData<Resource<Object>> mPrintOrder;
    public MediatorLiveData<Resource<ProblemManageInfoRes>> mProblemManageInfo;
    public MediatorLiveData<Resource<List<ProblemManageListItem>>> mProblemManageList;
    public MediatorLiveData<Resource<List<ProblemOperationRecordListItem>>> mProblemOperationRecordList;
    public MediatorLiveData<Resource<List<ProblemStatusListItem>>> mProblemStatusList;
    public MediatorLiveData<Resource<List<PartsDiseaseListItem>>> mProcessingDiseaseList;
    public MediatorLiveData<Resource<List<PartsDiseaseResultsItem>>> mProcessingDiseaseResults;
    public MediatorLiveData<Resource<List<GetObjectListItem>>> mProcessingGetObjectListMySelf;
    public MediatorLiveData<Resource<String>> mProcessingHighwayPatrolTaskCodeApi;
    public MediatorLiveData<Resource<List<ProjectOrgProcessAreaItem>>> mProcessingProjectOrgProcessArea;
    public MediatorLiveData<Resource<RegionByAddressRes>> mProcessingRegionByAddress;
    public MediatorLiveData<Resource<List<RegionListByMapItem>>> mProcessingRegionListByMap;
    public MediatorLiveData<Resource<SubmitProblemInfoRes>> mProcessingSubmitProblemInfo;
    public MediatorLiveData<Resource<List<ProjectTypeFieldListItem>>> mProcessingTypeFieldList;
    public MediatorLiveData<Resource<PatrolEventBean>> mProcessingUploadVideo;
    public MediatorLiveData<Resource<List<RegionListByMapItem>>> mProcessingVillageRegionListByMap;
    public MediatorLiveData<Resource<HallCartRes>> mProductIndex;
    public MediatorLiveData<Resource<Object>> mProductPassRollback;
    public MediatorLiveData<Resource<List<ProjectObjectFirstListItem>>> mProjectObjectFirstListApi;
    public MediatorLiveData<Resource<List<ProjectObjectFirstListItem>>> mProjectObjectListApi;
    public MediatorLiveData<Resource<List<ProjectOrgProcessAreaItem>>> mProjectOrgProcessArea;
    public MediatorLiveData<Resource<List<ProjectTypeFieldListItem>>> mProjectTypeFieldList;
    public MediatorLiveData<Resource<List<ProjectTypeListItem>>> mProjectTypeList;
    public MediatorLiveData<Resource<List<MenuItem>>> mProjectTypeMenuList;
    public MediatorLiveData<Resource<List<CollectionTodaItem>>> mRecaptureApi;
    public MediatorLiveData<Resource<RecentlyObjectRes>> mRecentlyObjectApi;
    public MediatorLiveData<Resource<Object>> mRefundCoupon;
    public MediatorLiveData<Resource<RegionByAddressRes>> mRegionByAddress;
    public MediatorLiveData<Resource<List<RegionListByMapItem>>> mRegionListByMap;
    public MediatorLiveData<Resource<List<ProvinceListItem>>> mRegionTreeByMap;
    public MediatorLiveData<Resource<RepairProjectCheckInfoRes>> mRepairProjectCheckInfoRes;
    private PatrolRepo mRepository;
    public MediatorLiveData<Resource<RestartPatrolTaskRes>> mRestartHighwayPatrolTaskApi;
    public MediatorLiveData<Resource<String>> mReturnProblemMange;
    public MediatorLiveData<Resource<Object>> mSaveScanInfo;
    public MediatorLiveData<Resource<BaseDataRes<ScanPayRes>>> mScanPay;
    public MediatorLiveData<Resource<BaseResuleRes<ScanPayRes>>> mScanPayQuery;
    public MediatorLiveData<Resource<SelectAttendancePersonnelFenceListRes>> mSelectAttendancePersonnelFenceList;
    public MediatorLiveData<Resource<List<SelectAttendancePersonnelFenceListByDateItem>>> mSelectAttendancePersonnelFenceListByDate;
    public MediatorLiveData<Resource<List<CurrentDatePatrolPersonnelSignInTaskListItem>>> mSignInPointSignInRecordList;
    public MediatorLiveData<Resource<List<SortContentByMapItem>>> mSortContentByMap;
    public MediatorLiveData<Resource<List<SortContentTreeByMapItem>>> mSortContentTreeByMap;
    public MediatorLiveData<Resource<String>> mStartHighwayPatrolTaskApi;
    public MediatorLiveData<Resource<String>> mStopHighwayPatrolTaskApi;
    public MediatorLiveData<Resource<String>> mSubmitPersonnelAttendance;
    public MediatorLiveData<Resource<SubmitProblemInfoRes>> mSubmitProblemInfo;
    public MediatorLiveData<Resource<String>> mSubmitProblemMange;
    public MediatorLiveData<Resource<BaseListDataRes<List<TableAreaItem>>>> mTableArea;
    public MediatorLiveData<Resource<BaseListDataRes<List<TableAreaItem>>>> mTableList;
    public MediatorLiveData<Resource<BaseDataRes<TableStatusReq>>> mTableStatusNum;
    public MediatorLiveData<Resource<List<ProblemManageListItem>>> mToCompletedPatrolProblemList;
    public MediatorLiveData<Resource<List<TownPatrolReportListItem>>> mTownPatrolReportList;
    public MediatorLiveData<Resource<String>> mUpdateGroup;
    public MediatorLiveData<Resource<String>> mUpdatePatrolProblemAsSpecialProblem;
    private final UploadFileRepo mUploadRepo;
    public MediatorLiveData<Resource<Object>> mUrgedishes;
    public MediatorLiveData<Resource<BaseDataRes<VersionRes>>> mVensionInfo;
    public MediatorLiveData<Resource<Object>> mVerifyCoupon;
    public MediatorLiveData<Resource<List<RegionListByMapItem>>> mVillageRegionListByMap;
    public MediatorLiveData<Resource<WeatherInfoRes>> mWeatherInfoApi;
    public MutableLiveData<Integer> pMldLocateAdd;
    public MediatorLiveData<Resource<List<UploadRes>>> pProcessingUploadVideo;
    public MediatorLiveData<Resource<List<UploadRes>>> pUploadVideo;
    public MediatorLiveData<Resource<String>> repairProjectIncidentAcceptanceAudit;
    public MediatorLiveData<Resource<String>> submitManagePatrolEvent;

    public PatrolVm(Application application, PatrolRepo patrolRepo, UploadFileRepo uploadFileRepo) {
        super(application);
        this.pMldLocateAdd = new MutableLiveData<>();
        this.mSubmitProblemInfo = new MediatorLiveData<>();
        this.mProcessingSubmitProblemInfo = new MediatorLiveData<>();
        this.mProjectOrgProcessArea = new MediatorLiveData<>();
        this.mProcessingProjectOrgProcessArea = new MediatorLiveData<>();
        this.mRegionListByMap = new MediatorLiveData<>();
        this.mProcessingRegionListByMap = new MediatorLiveData<>();
        this.mSortContentByMap = new MediatorLiveData<>();
        this.mInsertPatrolProblem = new MediatorLiveData<>();
        this.pUploadVideo = new MediatorLiveData<>();
        this.pProcessingUploadVideo = new MediatorLiveData<>();
        this.mProcessingUploadVideo = new MediatorLiveData<>();
        this.mPatrolObjectByMap = new MediatorLiveData<>();
        this.mProjectTypeList = new MediatorLiveData<>();
        this.mProblemManageList = new MediatorLiveData<>();
        this.mProblemManageInfo = new MediatorLiveData<>();
        this.mAddOrUpdateProblemManageRecord = new MediatorLiveData<>();
        this.mReturnProblemMange = new MediatorLiveData<>();
        this.mSubmitProblemMange = new MediatorLiveData<>();
        this.mProblemOperationRecordList = new MediatorLiveData<>();
        this.mSortContentTreeByMap = new MediatorLiveData<>();
        this.mPatrolObjectTreeByMap = new MediatorLiveData<>();
        this.mInsertPatrolProblemManageByMyself = new MediatorLiveData<>();
        this.mDeptPatrolReportList = new MediatorLiveData<>();
        this.mTownPatrolReportList = new MediatorLiveData<>();
        this.mPatrolProblemWarningMessageList = new MediatorLiveData<>();
        this.mRegionByAddress = new MediatorLiveData<>();
        this.mProcessingRegionByAddress = new MediatorLiveData<>();
        this.mVillageRegionListByMap = new MediatorLiveData<>();
        this.mProcessingVillageRegionListByMap = new MediatorLiveData<>();
        this.mProblemStatusList = new MediatorLiveData<>();
        this.mPatrolProblemRecordList = new MediatorLiveData<>();
        this.mFiveColorWarningReport = new MediatorLiveData<>();
        this.mToCompletedPatrolProblemList = new MediatorLiveData<>();
        this.mCompletedPatrolProblem = new MediatorLiveData<>();
        this.mPatrolProblemPatrolTypeReportList = new MediatorLiveData<>();
        this.mPatrolProblemIssueOpinionList = new MediatorLiveData<>();
        this.mIssuePatrolProblemOpinion = new MediatorLiveData<>();
        this.mPreClosurePatrolProblem = new MediatorLiveData<>();
        this.mInsertPatrolProblemComment = new MediatorLiveData<>();
        this.mUpdatePatrolProblemAsSpecialProblem = new MediatorLiveData<>();
        this.mPatrolManageReportList = new MediatorLiveData<>();
        this.mPatrolPersonnelReportList = new MediatorLiveData<>();
        this.mPatrolPersonnelRealTimeInfoList = new MediatorLiveData<>();
        this.mPatrolMapPatrolTypeList = new MediatorLiveData<>();
        this.mPatrolMapPatrolDataList = new MediatorLiveData<>();
        this.mSelectAttendancePersonnelFenceList = new MediatorLiveData<>();
        this.mSubmitPersonnelAttendance = new MediatorLiveData<>();
        this.mPersonnelAttendanceRecord = new MediatorLiveData<>();
        this.mSelectAttendancePersonnelFenceListByDate = new MediatorLiveData<>();
        this.mCurrentDatePatrolPersonnelSignInTaskList = new MediatorLiveData<>();
        this.mPatrolPersonnelSignIn = new MediatorLiveData<>();
        this.mPatrolPersonnelSignInSavePhoto = new MediatorLiveData<>();
        this.mAutoPatrolSignIn = new MediatorLiveData<>();
        this.mMapPatrolPersonnelSignInTaskList = new MediatorLiveData<>();
        this.mSignInPointSignInRecordList = new MediatorLiveData<>();
        this.mPersonnelSignInRecordList = new MediatorLiveData<>();
        this.mPatrolPersonnelSignInPointRecordInfo = new MediatorLiveData<>();
        this.mApiRepairIncidentList = new MediatorLiveData<>();
        this.mApiRepairProjectIncidentAcceptanceList = new MediatorLiveData<>();
        this.mApiRepairProjectList = new MediatorLiveData<>();
        this.mApiRepairIncidentInfo = new MediatorLiveData<>();
        this.mApiRepairProjectInfo = new MediatorLiveData<>();
        this.mRepairProjectCheckInfoRes = new MediatorLiveData<>();
        this.mInsertRepairProjectCheckRectification = new MediatorLiveData<>();
        this.mProjectTypeMenuList = new MediatorLiveData<>();
        this.mPatrolEventListApi = new MediatorLiveData<>();
        this.mPartsDiseaseList = new MediatorLiveData<>();
        this.mPartsDiseaseResults = new MediatorLiveData<>();
        this.mProjectTypeFieldList = new MediatorLiveData<>();
        this.mProcessingDiseaseList = new MediatorLiveData<>();
        this.mProcessingDiseaseResults = new MediatorLiveData<>();
        this.mProcessingTypeFieldList = new MediatorLiveData<>();
        this.mInsertPatrolEvent = new MediatorLiveData<>();
        this.mInsertPatrolEventProcessByMySelf = new MediatorLiveData<>();
        this.mInsertBridgeInspectEvent = new MediatorLiveData<>();
        this.submitManagePatrolEvent = new MediatorLiveData<>();
        this.mInsertRepairProjectIncidentTailRecord = new MediatorLiveData<>();
        this.mInsertRepairProjectIncidentManageRecord = new MediatorLiveData<>();
        this.repairProjectIncidentAcceptanceAudit = new MediatorLiveData<>();
        this.mDictionaryList = new MediatorLiveData<>();
        this.mGetObjectList = new MediatorLiveData<>();
        this.mDictionaryListMySelf = new MediatorLiveData<>();
        this.mGetObjectListMySelf = new MediatorLiveData<>();
        this.mProcessingGetObjectListMySelf = new MediatorLiveData<>();
        this.mAwaitDecomposePatrolProblemList = new MediatorLiveData<>();
        this.mHistoryPatrolProblemList = new MediatorLiveData<>();
        this.mClosePatrolProblem = new MediatorLiveData<>();
        this.mAssignTypeList = new MediatorLiveData<>();
        this.mBridgeInspectTaskList = new MediatorLiveData<>();
        this.mBridgeInspectTaskHisList = new MediatorLiveData<>();
        this.mBridgeInspectNumber = new MediatorLiveData<>();
        this.mBridgeInspectHisNumber = new MediatorLiveData<>();
        this.mBridgeInspectRecordList = new MediatorLiveData<>();
        this.mBridgeInspectRecordInfo = new MediatorLiveData<>();
        this.mManageUnitList = new MediatorLiveData<>();
        this.mPersonnelResList = new MediatorLiveData<>();
        this.mNeedToCheckPartListItem = new MediatorLiveData<>();
        this.decomposePatrolPersonnelManage = new MediatorLiveData<>();
        this.mLocationStation = new MediatorLiveData<>();
        this.mHighwayPatrolTaskListApi = new MediatorLiveData<>();
        this.mHighwayPatrolTaskListToadyApi = new MediatorLiveData<>();
        this.mHighwayPatrolTaskInfoApi = new MediatorLiveData<>();
        this.mPreviewHighwayPatrolTaskListApi = new MediatorLiveData<>();
        this.mStartHighwayPatrolTaskApi = new MediatorLiveData<>();
        this.mInsertHighwayPatrolTaskTrajectoryListApi = new MediatorLiveData<>();
        this.mInsertPersonnelDeviceRecord = new MediatorLiveData<>();
        this.mHighwayPatrolConfig = new MediatorLiveData<>();
        this.mAffirmHighwayPatrolTaskApi = new MediatorLiveData<>();
        this.mEndHighwayPatrolTaskApi = new MediatorLiveData<>();
        this.mRestartHighwayPatrolTaskApi = new MediatorLiveData<>();
        this.mStopHighwayPatrolTaskApi = new MediatorLiveData<>();
        this.mCreateGroup = new MediatorLiveData<>();
        this.mUpdateGroup = new MediatorLiveData<>();
        this.mDeleteGroup = new MediatorLiveData<>();
        this.mInsertHighwayPatrolTaskRecord = new MediatorLiveData<>();
        this.mHighwayPatrolTaskTimeJudge = new MediatorLiveData<>();
        this.mHighwayPatrolTaskTimeJudge2 = new MediatorLiveData<>();
        this.mHighwayPatrolTaskDataApi = new MediatorLiveData<>();
        this.mHighwayPatrolTaskingApi = new MediatorLiveData<>();
        this.mHighwayPatrolTaskingDataApi = new MediatorLiveData<>();
        this.mRecentlyObjectApi = new MediatorLiveData<>();
        this.mHighwayPatrolTaskStatusNumber = new MediatorLiveData<>();
        this.mHighwayPatrolTaskTreeApi = new MediatorLiveData<>();
        this.mHighwayPatrolTaskRecordListApi = new MediatorLiveData<>();
        this.mHighwayPatrolTaskGroupListApi = new MediatorLiveData<>();
        this.mHistoricalHighwayPatrolTaskTreeApi = new MediatorLiveData<>();
        this.mHighwayPatrolTaskCodeApi = new MediatorLiveData<>();
        this.mProcessingHighwayPatrolTaskCodeApi = new MediatorLiveData<>();
        this.mPersonnelLocationList = new MediatorLiveData<>();
        this.mPersonnelTrajectoryList = new MediatorLiveData<>();
        this.mPatrolPersonnelLocationGroupList = new MediatorLiveData<>();
        this.mPatrolEventList = new MediatorLiveData<>();
        this.mPatrolEventStatusList = new MediatorLiveData<>();
        this.mExamineObjectList = new MediatorLiveData<>();
        this.mExamineTypeList = new MediatorLiveData<>();
        this.mExamineQuarterList = new MediatorLiveData<>();
        this.mExamineReportList = new MediatorLiveData<>();
        this.mObjectRoadList = new MediatorLiveData<>();
        this.mObjectRoadMapList = new MediatorLiveData<>();
        this.mObjectRoadInfo = new MediatorLiveData<>();
        this.mOnlineStatus = new MediatorLiveData<>();
        this.mCollectionObjectInfoApi = new MediatorLiveData<>();
        this.mInsertPointInfoApi = new MediatorLiveData<>();
        this.mCollectionTodayPointApi = new MediatorLiveData<>();
        this.mCollectionTodayApi = new MediatorLiveData<>();
        this.mCollectionTodayTrackApi = new MediatorLiveData<>();
        this.mRecaptureApi = new MediatorLiveData<>();
        this.mCollectionRecordInfoApi = new MediatorLiveData<>();
        this.mCollectionRecordTrackInfoApi = new MediatorLiveData<>();
        this.mDeleteTrackListApi = new MediatorLiveData<>();
        this.mInsertTrackListApi = new MediatorLiveData<>();
        this.mRegionTreeByMap = new MediatorLiveData<>();
        this.mCollectionRecordListApi = new MediatorLiveData<>();
        this.mCollectionObjectListApi = new MediatorLiveData<>();
        this.mWeatherInfoApi = new MediatorLiveData<>();
        this.mProjectObjectFirstListApi = new MediatorLiveData<>();
        this.mProjectObjectListApi = new MediatorLiveData<>();
        this.mLocationInfo = new MediatorLiveData<>();
        this.mTableArea = new MediatorLiveData<>();
        this.mTableList = new MediatorLiveData<>();
        this.mCategoryIndex = new MediatorLiveData<>();
        this.mProductIndex = new MediatorLiveData<>();
        this.mOrderDetail = new MediatorLiveData<>();
        this.mHallCartList = new MediatorLiveData<>();
        this.mHallCartAdd = new MediatorLiveData<>();
        this.mAddMeal = new MediatorLiveData<>();
        this.mHallCartSub = new MediatorLiveData<>();
        this.mOrderCancel = new MediatorLiveData<>();
        this.mChangeTableList = new MediatorLiveData<>();
        this.mChangeTable = new MediatorLiveData<>();
        this.mMoveProduct = new MediatorLiveData<>();
        this.mOrderInfo = new MediatorLiveData<>();
        this.mPaymentMethod = new MediatorLiveData<>();
        this.mScanPayQuery = new MediatorLiveData<>();
        this.mScanPay = new MediatorLiveData<>();
        this.mCouponList = new MediatorLiveData<>();
        this.mPackCouponList = new MediatorLiveData<>();
        this.mGroupCouponList = new MediatorLiveData<>();
        this.mDeviceCode = new MediatorLiveData<>();
        this.mAddDeviceOrder = new MediatorLiveData<>();
        this.mTableStatusNum = new MediatorLiveData<>();
        this.mNewPay = new MediatorLiveData<>();
        this.mOrderDetailList = new MediatorLiveData<>();
        this.mPrintOrder = new MediatorLiveData<>();
        this.mUrgedishes = new MediatorLiveData<>();
        this.mPrintBill = new MediatorLiveData<>();
        this.mOrderDetailHome = new MediatorLiveData<>();
        this.mHallCartDelete = new MediatorLiveData<>();
        this.mMicroRefund = new MediatorLiveData<>();
        this.mIndexIndex = new MediatorLiveData<>();
        this.mChangeNum = new MediatorLiveData<>();
        this.mCouponListDyMt = new MediatorLiveData<>();
        this.mCouponInfo2 = new MediatorLiveData<>();
        this.mVerifyCoupon = new MediatorLiveData<>();
        this.mRefundCoupon = new MediatorLiveData<>();
        this.mVensionInfo = new MediatorLiveData<>();
        this.mOpen = new MediatorLiveData<>();
        this.mMergeTable = new MediatorLiveData<>();
        this.mPermissionList = new MediatorLiveData<>();
        this.mGroupTypeList = new MediatorLiveData<>();
        this.mAddOrderCoupon = new MediatorLiveData<>();
        this.mOpenScan = new MediatorLiveData<>();
        this.mSaveScanInfo = new MediatorLiveData<>();
        this.mProductPassRollback = new MediatorLiveData<>();
        this.mRepository = (PatrolRepo) Preconditions.checkNotNull(patrolRepo);
        this.mUploadRepo = (UploadFileRepo) Preconditions.checkNotNull(uploadFileRepo);
        this.mHttpHandler = RxHandler.getInstance(this.mContext);
    }

    public void OrderDetailHome(String str) {
        this.mDisposable = this.mRepository.OrderDetailHome(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda389
            public final void accept(Object obj) throws Exception {
                this.f$0.m537lambda$OrderDetailHome$371$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda390
            public final void accept(Object obj) throws Exception {
                this.f$0.m538lambda$OrderDetailHome$372$comcollectpointnetvmPatrolVm((BaseDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda123
            public final void accept(Object obj) throws Exception {
                this.f$0.m539lambda$OrderDetailHome$373$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void PrintBill(String str) {
        this.mDisposable = this.mRepository.PrintBill(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda391
            public final void accept(Object obj) throws Exception {
                this.f$0.m540lambda$PrintBill$368$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda345
            public final void accept(Object obj) throws Exception {
                this.f$0.m541lambda$PrintBill$369$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda124
            public final void accept(Object obj) throws Exception {
                this.f$0.m542lambda$PrintBill$370$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void addDeviceOrder(List<AddDeviceItem> list) {
        this.mDisposable = this.mRepository.addDeviceOrder(list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda392
            public final void accept(Object obj) throws Exception {
                this.f$0.m543lambda$addDeviceOrder$353$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda346
            public final void accept(Object obj) throws Exception {
                this.f$0.m544lambda$addDeviceOrder$354$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda125
            public final void accept(Object obj) throws Exception {
                this.f$0.m545lambda$addDeviceOrder$355$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void addMeal(String str, String str2, String str3, String str4, boolean z, String str5) {
        this.mDisposable = this.mRepository.addMeal(str, str2, str3, str4, z, str5).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda393
            public final void accept(Object obj) throws Exception {
                this.f$0.m546lambda$addMeal$308$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda347
            public final void accept(Object obj) throws Exception {
                this.f$0.m547lambda$addMeal$309$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda126
            public final void accept(Object obj) throws Exception {
                this.f$0.m548lambda$addMeal$310$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void addOrderCoupon(AddOrderCouponReq addOrderCouponReq) {
        this.mDisposable = this.mRepository.addOrderCoupon(addOrderCouponReq).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda394
            public final void accept(Object obj) throws Exception {
                this.f$0.m549lambda$addOrderCoupon$422$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda348
            public final void accept(Object obj) throws Exception {
                this.f$0.m550lambda$addOrderCoupon$423$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda127
            public final void accept(Object obj) throws Exception {
                this.f$0.m551lambda$addOrderCoupon$424$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void categoryIndex() {
        this.mDisposable = this.mRepository.categoryIndex().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda395
            public final void accept(Object obj) throws Exception {
                this.f$0.m552lambda$categoryIndex$293$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda77
            public final void accept(Object obj) throws Exception {
                this.f$0.m553lambda$categoryIndex$294$comcollectpointnetvmPatrolVm((BaseListDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda128
            public final void accept(Object obj) throws Exception {
                this.f$0.m554lambda$categoryIndex$295$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void changeNum(String str, String str2) {
        this.mDisposable = this.mRepository.changeNum(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda396
            public final void accept(Object obj) throws Exception {
                this.f$0.m555lambda$changeNum$383$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda349
            public final void accept(Object obj) throws Exception {
                this.f$0.m556lambda$changeNum$384$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda129
            public final void accept(Object obj) throws Exception {
                this.f$0.m557lambda$changeNum$385$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void changeTable(String str, String str2) {
        this.mDisposable = this.mRepository.changeTable(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda397
            public final void accept(Object obj) throws Exception {
                this.f$0.m558lambda$changeTable$323$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda350
            public final void accept(Object obj) throws Exception {
                this.f$0.m559lambda$changeTable$324$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda130
            public final void accept(Object obj) throws Exception {
                this.f$0.m560lambda$changeTable$325$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void changeTableList(String str) {
        this.mDisposable = this.mRepository.changeTableList(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda398
            public final void accept(Object obj) throws Exception {
                this.f$0.m561lambda$changeTableList$320$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda88
            public final void accept(Object obj) throws Exception {
                this.f$0.m562lambda$changeTableList$321$comcollectpointnetvmPatrolVm((BaseListDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda131
            public final void accept(Object obj) throws Exception {
                this.f$0.m563lambda$changeTableList$322$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void closePatrolProblem(String str, String str2) {
        this.mDisposable = this.mRepository.closePatrolProblem(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda399
            public final void accept(Object obj) throws Exception {
                this.f$0.m564lambda$closePatrolProblem$78$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda107
            public final void accept(Object obj) throws Exception {
                this.f$0.m565lambda$closePatrolProblem$79$comcollectpointnetvmPatrolVm((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda132
            public final void accept(Object obj) throws Exception {
                this.f$0.m566lambda$closePatrolProblem$80$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void closePatrolProblem(String str, String str2, String str3) {
        this.mDisposable = this.mRepository.auditPatrolEvent(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda400
            public final void accept(Object obj) throws Exception {
                this.f$0.m567lambda$closePatrolProblem$81$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda108
            public final void accept(Object obj) throws Exception {
                this.f$0.m568lambda$closePatrolProblem$82$comcollectpointnetvmPatrolVm((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda134
            public final void accept(Object obj) throws Exception {
                this.f$0.m569lambda$closePatrolProblem$83$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void closeScan(String str) {
        this.mDisposable = this.mRepository.closeScan(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda402
            public final void accept(Object obj) throws Exception {
                this.f$0.m570lambda$closeScan$431$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda351
            public final void accept(Object obj) throws Exception {
                this.f$0.m571lambda$closeScan$432$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda135
            public final void accept(Object obj) throws Exception {
                this.f$0.m572lambda$closeScan$433$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void collectionObjectInfoApi(String str) {
        this.mDisposable = this.mRepository.collectionObjectInfoApi(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda403
            public final void accept(Object obj) throws Exception {
                this.f$0.m573xc58aef14((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda286
            public final void accept(Object obj) throws Exception {
                this.f$0.m574x2aab333((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda136
            public final void accept(Object obj) throws Exception {
                this.f$0.m575x3fca7752((Throwable) obj);
            }
        });
    }

    public void collectionObjectListApi() {
        this.mDisposable = this.mRepository.collectionObjectListApi().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda404
            public final void accept(Object obj) throws Exception {
                this.f$0.m576x8bd04e27((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda287
            public final void accept(Object obj) throws Exception {
                this.f$0.m577xc8f01246((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda137
            public final void accept(Object obj) throws Exception {
                this.f$0.m578x60fd665((Throwable) obj);
            }
        });
    }

    public void collectionRecordInfoApi(String str) {
        this.mDisposable = this.mRepository.collectionRecordInfoApi(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda405
            public final void accept(Object obj) throws Exception {
                this.f$0.m579xc6bf604a((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda344
            public final void accept(Object obj) throws Exception {
                this.f$0.m580x3df2469((InsertPointInfoRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda138
            public final void accept(Object obj) throws Exception {
                this.f$0.m581x40fee888((Throwable) obj);
            }
        });
    }

    public void collectionRecordListApi(String str, String str2, String str3) {
        this.mDisposable = this.mRepository.collectionRecordListApi(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda406
            public final void accept(Object obj) throws Exception {
                this.f$0.m582x458dcf3((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda289
            public final void accept(Object obj) throws Exception {
                this.f$0.m583x4178a112((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda139
            public final void accept(Object obj) throws Exception {
                this.f$0.m584x82337bbc((Throwable) obj);
            }
        });
    }

    public void collectionRecordTrackInfoApi(String str) {
        this.mDisposable = this.mRepository.collectionRecordTrackInfoApi(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda407
            public final void accept(Object obj) throws Exception {
                this.f$0.m585x2c22d53a((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda290
            public final void accept(Object obj) throws Exception {
                this.f$0.m586x69429959((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda140
            public final void accept(Object obj) throws Exception {
                this.f$0.m587xa6625d78((Throwable) obj);
            }
        });
    }

    public void collectionTodayApi(String str, String str2, String str3) {
        this.mDisposable = this.mRepository.collectionTodayApi(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda408
            public final void accept(Object obj) throws Exception {
                this.f$0.m588lambda$collectionTodayApi$251$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda291
            public final void accept(Object obj) throws Exception {
                this.f$0.m589lambda$collectionTodayApi$252$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda141
            public final void accept(Object obj) throws Exception {
                this.f$0.m590lambda$collectionTodayApi$253$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void collectionTodayPointApi() {
        this.mDisposable = this.mRepository.collectionTodayPointApi().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda409
            public final void accept(Object obj) throws Exception {
                this.f$0.m591xfaac83f0((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda292
            public final void accept(Object obj) throws Exception {
                this.f$0.m592x37cc480f((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda142
            public final void accept(Object obj) throws Exception {
                this.f$0.m593x788722b9((Throwable) obj);
            }
        });
    }

    public void collectionTodayTrackApi() {
        this.mDisposable = this.mRepository.collectionTodayTrackApi().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda410
            public final void accept(Object obj) throws Exception {
                this.f$0.m594xb34837f0((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda293
            public final void accept(Object obj) throws Exception {
                this.f$0.m595xf067fc0f((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda143
            public final void accept(Object obj) throws Exception {
                this.f$0.m596x2d87c02e((Throwable) obj);
            }
        });
    }

    public void createGroup(String str, List<String> list) {
        this.mDisposable = this.mRepository.createGroup(str, list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda411
            public final void accept(Object obj) throws Exception {
                this.f$0.m597lambda$createGroup$144$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda109
            public final void accept(Object obj) throws Exception {
                this.f$0.m598lambda$createGroup$145$comcollectpointnetvmPatrolVm((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda145
            public final void accept(Object obj) throws Exception {
                this.f$0.m599lambda$createGroup$146$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void decomposePatrolPersonnelManage(String str, String str2, String str3, String str4, String str5) {
        this.mDisposable = this.mRepository.decomposePatrolPersonnelManage(str, str2, str3, str4, str5, "").observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda413
            public final void accept(Object obj) throws Exception {
                this.f$0.m600x2b9deeb5((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda112
            public final void accept(Object obj) throws Exception {
                this.f$0.m601x68bdb2d4((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda146
            public final void accept(Object obj) throws Exception {
                this.f$0.m602xa5dd76f3((Throwable) obj);
            }
        });
    }

    public void deleteGroup(List<String> list) {
        this.mDisposable = this.mRepository.deleteGroup(list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda414
            public final void accept(Object obj) throws Exception {
                this.f$0.m603lambda$deleteGroup$150$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda113
            public final void accept(Object obj) throws Exception {
                this.f$0.m604lambda$deleteGroup$151$comcollectpointnetvmPatrolVm((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda147
            public final void accept(Object obj) throws Exception {
                this.f$0.m605lambda$deleteGroup$152$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void deleteTrackListApi(String str, String str2) {
        this.mDisposable = this.mRepository.deleteTrackListApi(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda415
            public final void accept(Object obj) throws Exception {
                this.f$0.m606lambda$deleteTrackListApi$266$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda114
            public final void accept(Object obj) throws Exception {
                this.f$0.m607lambda$deleteTrackListApi$267$comcollectpointnetvmPatrolVm((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda148
            public final void accept(Object obj) throws Exception {
                this.f$0.m608lambda$deleteTrackListApi$268$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void endHighwayPatrolTaskApi(String str, String str2, String str3, String str4, List<HighwayPatrolTaskTrajectoryApiReq> list) {
        this.mDisposable = this.mRepository.endHighwayPatrolTaskApi(str, str2, str3, str4, list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda416
            public final void accept(Object obj) throws Exception {
                this.f$0.m609xe7ada207((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda210
            public final void accept(Object obj) throws Exception {
                this.f$0.m610x24cd6626((EndHighwayPatrolTaskRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda149
            public final void accept(Object obj) throws Exception {
                this.f$0.m611x61ed2a45((Throwable) obj);
            }
        });
    }

    public void getApiRepairProjectIncidentAcceptanceInfo(String str) {
        this.mDisposable = this.mRepository.getApiRepairProjectIncidentAcceptanceInfo(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda417
            public final void accept(Object obj) throws Exception {
                this.f$0.m612x83f99c29((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda333
            public final void accept(Object obj) throws Exception {
                this.f$0.m613xc1196048((ApiRepairIncidentInfoRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda150
            public final void accept(Object obj) throws Exception {
                this.f$0.m614x1d43af2((Throwable) obj);
            }
        });
    }

    public void getApiRepairProjectIncidentAcceptanceList(String str, String str2) {
        this.mDisposable = this.mRepository.getApiRepairProjectIncidentAcceptanceList(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda418
            public final void accept(Object obj) throws Exception {
                this.f$0.m615x386863bc((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda294
            public final void accept(Object obj) throws Exception {
                this.f$0.m616x758827db((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda151
            public final void accept(Object obj) throws Exception {
                this.f$0.m617xb2a7ebfa((Throwable) obj);
            }
        });
    }

    public void getAssignTypeList(String str) {
        this.mDisposable = this.mRepository.getAssignTypeList(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda419
            public final void accept(Object obj) throws Exception {
                this.f$0.m618lambda$getAssignTypeList$66$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda295
            public final void accept(Object obj) throws Exception {
                this.f$0.m619lambda$getAssignTypeList$67$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda152
            public final void accept(Object obj) throws Exception {
                this.f$0.m620lambda$getAssignTypeList$68$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getAwaitDecomposePatrolProblemList(String str) {
        this.mDisposable = this.mRepository.getAwaitDecomposePatrolProblemList(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda420
            public final void accept(Object obj) throws Exception {
                this.f$0.m621x3c663151((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda296
            public final void accept(Object obj) throws Exception {
                this.f$0.m622x7985f570((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda153
            public final void accept(Object obj) throws Exception {
                this.f$0.m623xb6a5b98f((Throwable) obj);
            }
        });
    }

    public void getBridgeInspectHisNumber(String str) {
        this.mDisposable = this.mRepository.getBridgeInspectNumber(str, "").observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda421
            public final void accept(Object obj) throws Exception {
                this.f$0.m624x9f2930fd((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda177
            public final void accept(Object obj) throws Exception {
                this.f$0.m625xdc48f51c((BridgeInspectNumberRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda154
            public final void accept(Object obj) throws Exception {
                this.f$0.m626x1968b93b((Throwable) obj);
            }
        });
    }

    public void getBridgeInspectNumber(String str, String str2) {
        this.mDisposable = this.mRepository.getBridgeInspectNumber(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda422
            public final void accept(Object obj) throws Exception {
                this.f$0.m627x52608792((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda188
            public final void accept(Object obj) throws Exception {
                this.f$0.m628x8f804bb1((BridgeInspectNumberRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda156
            public final void accept(Object obj) throws Exception {
                this.f$0.m629xcca00fd0((Throwable) obj);
            }
        });
    }

    public void getBridgeInspectRecordInfo(String str) {
        this.mDisposable = this.mRepository.getBridgeInspectRecordInfo(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda424
            public final void accept(Object obj) throws Exception {
                this.f$0.m632x8ca9c9ff((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda199
            public final void accept(Object obj) throws Exception {
                this.f$0.m630x1d393514((BridgeInspectRecordInfoRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda157
            public final void accept(Object obj) throws Exception {
                this.f$0.m631x5a58f933((Throwable) obj);
            }
        });
    }

    public void getBridgeInspectRecordList(String str, String str2, String str3, String str4, String str5, String str6) {
        getBridgeInspectRecordList(str, str2, str3, str4, str5, str6, "");
    }

    public void getBridgeInspectRecordList(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.mDisposable = this.mRepository.getBridgeInspectRecordList(str, str2, str3, str4, str5, str6, str7).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda425
            public final void accept(Object obj) throws Exception {
                this.f$0.m633x41189192((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda297
            public final void accept(Object obj) throws Exception {
                this.f$0.m634x7e3855b1((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda158
            public final void accept(Object obj) throws Exception {
                this.f$0.m635xbb5819d0((Throwable) obj);
            }
        });
    }

    public void getBridgeInspectTaskHisList(String str) {
        this.mDisposable = this.mRepository.getBridgeInspectTaskList(str, "").observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda426
            public final void accept(Object obj) throws Exception {
                this.f$0.m636xc962aac8((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda298
            public final void accept(Object obj) throws Exception {
                this.f$0.m637x6826ee7((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda159
            public final void accept(Object obj) throws Exception {
                this.f$0.m638x43a23306((Throwable) obj);
            }
        });
    }

    public void getBridgeInspectTaskList(String str, String str2) {
        this.mDisposable = this.mRepository.getBridgeInspectTaskList(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda427
            public final void accept(Object obj) throws Exception {
                this.f$0.m639x4098c347((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda300
            public final void accept(Object obj) throws Exception {
                this.f$0.m640x7db88766((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda160
            public final void accept(Object obj) throws Exception {
                this.f$0.m641xbad84b85((Throwable) obj);
            }
        });
    }

    public void getCouponInfo2(String str, String str2) {
        this.mDisposable = this.mRepository.getCouponInfo2(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda428
            public final void accept(Object obj) throws Exception {
                this.f$0.m642lambda$getCouponInfo2$392$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda401
            public final void accept(Object obj) throws Exception {
                this.f$0.m643lambda$getCouponInfo2$393$comcollectpointnetvmPatrolVm((BaseDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda161
            public final void accept(Object obj) throws Exception {
                this.f$0.m644lambda$getCouponInfo2$394$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getCouponList(String str, String str2, String str3, String str4, List<CouponPayItem> list, List<CouponPayItem> list2) {
        this.mDisposable = this.mRepository.getCouponList(str, str2, str3, str4, list, list2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda429
            public final void accept(Object obj) throws Exception {
                this.f$0.m645lambda$getCouponList$341$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda412
            public final void accept(Object obj) throws Exception {
                this.f$0.m646lambda$getCouponList$342$comcollectpointnetvmPatrolVm((BaseDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda162
            public final void accept(Object obj) throws Exception {
                this.f$0.m647lambda$getCouponList$343$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getCouponListDyMt(String str, String str2) {
        this.mDisposable = this.mRepository.getCouponListDy(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda430
            public final void accept(Object obj) throws Exception {
                this.f$0.m648lambda$getCouponListDyMt$395$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda423
            public final void accept(Object obj) throws Exception {
                this.f$0.m649lambda$getCouponListDyMt$396$comcollectpointnetvmPatrolVm((BaseDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda163
            public final void accept(Object obj) throws Exception {
                this.f$0.m650lambda$getCouponListDyMt$397$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getDeviceCode(String str) {
        this.mDisposable = this.mRepository.getDeviceCode(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda431
            public final void accept(Object obj) throws Exception {
                this.f$0.m651lambda$getDeviceCode$350$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda133
            public final void accept(Object obj) throws Exception {
                this.f$0.m652lambda$getDeviceCode$351$comcollectpointnetvmPatrolVm((BaseListRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda164
            public final void accept(Object obj) throws Exception {
                this.f$0.m653lambda$getDeviceCode$352$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getDictionaryList(String str, String str2) {
        this.mDisposable = this.mRepository.getDictionaryList(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda432
            public final void accept(Object obj) throws Exception {
                this.f$0.m654lambda$getDictionaryList$39$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda301
            public final void accept(Object obj) throws Exception {
                this.f$0.m655lambda$getDictionaryList$40$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda165
            public final void accept(Object obj) throws Exception {
                this.f$0.m656lambda$getDictionaryList$41$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getDictionaryListMySelf() {
        this.mDisposable = this.mRepository.getDictionaryList().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda433
            public final void accept(Object obj) throws Exception {
                this.f$0.m657x6031d575((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda302
            public final void accept(Object obj) throws Exception {
                this.f$0.m658x9d519994((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda167
            public final void accept(Object obj) throws Exception {
                this.f$0.m659xda715db3((Throwable) obj);
            }
        });
    }

    public void getExamineObjectList() {
        this.mDisposable = this.mRepository.getExamineObjectList().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda435
            public final void accept(Object obj) throws Exception {
                this.f$0.m660lambda$getExamineObjectList$198$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda303
            public final void accept(Object obj) throws Exception {
                this.f$0.m661lambda$getExamineObjectList$199$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda168
            public final void accept(Object obj) throws Exception {
                this.f$0.m662lambda$getExamineObjectList$200$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getExamineQuarterList() {
        this.mDisposable = this.mRepository.getExamineQuarterList().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda436
            public final void accept(Object obj) throws Exception {
                this.f$0.m663x5f21b87e((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda304
            public final void accept(Object obj) throws Exception {
                this.f$0.m664x9c417c9d((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda169
            public final void accept(Object obj) throws Exception {
                this.f$0.m665xd96140bc((Throwable) obj);
            }
        });
    }

    public void getExamineReportList(String str, String str2, String str3, String str4, int i, int i2) {
        this.mDisposable = this.mRepository.getExamineReportList(str, str2, str3, str4, i, i2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda437
            public final void accept(Object obj) throws Exception {
                this.f$0.m666lambda$getExamineReportList$207$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda305
            public final void accept(Object obj) throws Exception {
                this.f$0.m667lambda$getExamineReportList$208$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda170
            public final void accept(Object obj) throws Exception {
                this.f$0.m668lambda$getExamineReportList$209$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getExamineTypeList() {
        this.mDisposable = this.mRepository.getExamineTypeList().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda438
            public final void accept(Object obj) throws Exception {
                this.f$0.m669lambda$getExamineTypeList$201$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda306
            public final void accept(Object obj) throws Exception {
                this.f$0.m670lambda$getExamineTypeList$202$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda171
            public final void accept(Object obj) throws Exception {
                this.f$0.m671lambda$getExamineTypeList$203$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getGroupCouponList(String str, String str2, String str3, String str4, String str5, List<CouponPayItem> list, List<CouponPayItem> list2) {
        this.mDisposable = this.mRepository.getGroupCouponList(str, str2, str3, str4, str5, list, list2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda439
            public final void accept(Object obj) throws Exception {
                this.f$0.m672lambda$getGroupCouponList$347$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda434
            public final void accept(Object obj) throws Exception {
                this.f$0.m673lambda$getGroupCouponList$348$comcollectpointnetvmPatrolVm((BaseDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda172
            public final void accept(Object obj) throws Exception {
                this.f$0.m674lambda$getGroupCouponList$349$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getGroupTypeList() {
        this.mDisposable = this.mRepository.getGroupTypeList().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda440
            public final void accept(Object obj) throws Exception {
                this.f$0.m675lambda$getGroupTypeList$419$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda144
            public final void accept(Object obj) throws Exception {
                this.f$0.m676lambda$getGroupTypeList$420$comcollectpointnetvmPatrolVm((BaseListRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda173
            public final void accept(Object obj) throws Exception {
                this.f$0.m677lambda$getGroupTypeList$421$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getHighwayPatrolConfig(String str) {
        this.mDisposable = this.mRepository.getHighwayPatrolConfig(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda441
            public final void accept(Object obj) throws Exception {
                this.f$0.m678x235a0202((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda255
            public final void accept(Object obj) throws Exception {
                this.f$0.m679x6079c621((HighwayPatrolConfigRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda174
            public final void accept(Object obj) throws Exception {
                this.f$0.m680x9d998a40((Throwable) obj);
            }
        });
    }

    public void getHighwayPatrolTaskCodeApi(List<String> list, double d, double d2) {
        this.mDisposable = this.mRepository.getHighwayPatrolTaskCodeApi(list, d, d2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda442
            public final void accept(Object obj) throws Exception {
                this.f$0.m681xbb9c515d((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda115
            public final void accept(Object obj) throws Exception {
                this.f$0.m682xf8bc157c((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda175
            public final void accept(Object obj) throws Exception {
                this.f$0.m683x35dbd99b((Throwable) obj);
            }
        });
    }

    public void getHighwayPatrolTaskDataApi(String str, String str2) {
        getHighwayPatrolTaskDataApi(str, str2, "", "", "");
    }

    public void getHighwayPatrolTaskDataApi(String str, String str2, String str3, String str4) {
        getHighwayPatrolTaskDataApi(str, "", str2, str3, str4);
    }

    public void getHighwayPatrolTaskDataApi(String str, String str2, String str3, String str4, String str5) {
        this.mDisposable = this.mRepository.getHighwayPatrolTaskDataApi(str, str2, str3, str4, str5).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda443
            public final void accept(Object obj) throws Exception {
                this.f$0.m684x2324cad8((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda266
            public final void accept(Object obj) throws Exception {
                this.f$0.m685x60448ef7((HighwayPatrolTaskDataApiRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda176
            public final void accept(Object obj) throws Exception {
                this.f$0.m686x9d645316((Throwable) obj);
            }
        });
    }

    public void getHighwayPatrolTaskGroupListApi(String str, String str2) {
        this.mDisposable = this.mRepository.getHighwayPatrolTaskGroupListApi(str, str2, "DXC").observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda444
            public final void accept(Object obj) throws Exception {
                this.f$0.m687x8463cce6((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda307
            public final void accept(Object obj) throws Exception {
                this.f$0.m688xc1839105((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda178
            public final void accept(Object obj) throws Exception {
                this.f$0.m689xfea35524((Throwable) obj);
            }
        });
    }

    public void getHighwayPatrolTaskInfoApi(String str) {
        this.mDisposable = this.mRepository.getHighwayPatrolTaskInfoApi(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda1
            public final void accept(Object obj) throws Exception {
                this.f$0.m690x1d1e5bde((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda277
            public final void accept(Object obj) throws Exception {
                this.f$0.m691x5a3e1ffd((HighwayPatrolTaskInfoApiRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda179
            public final void accept(Object obj) throws Exception {
                this.f$0.m692x975de41c((Throwable) obj);
            }
        });
    }

    public void getHighwayPatrolTaskListApi(String str, String str2) {
        this.mDisposable = this.mRepository.getHighwayPatrolTaskListApi(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda4
            public final void accept(Object obj) throws Exception {
                this.f$0.m699x4fe694e6((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda311
            public final void accept(Object obj) throws Exception {
                this.f$0.m700x8d065905((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda182
            public final void accept(Object obj) throws Exception {
                this.f$0.m701xcdc133af((Throwable) obj);
            }
        });
    }

    public void getHighwayPatrolTaskListApi(String str, String str2, String str3) {
        this.mDisposable = this.mRepository.getHighwayPatrolTaskListApi(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda3
            public final void accept(Object obj) throws Exception {
                this.f$0.m696x98874889((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda309
            public final void accept(Object obj) throws Exception {
                this.f$0.m697xd5a70ca8((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda181
            public final void accept(Object obj) throws Exception {
                this.f$0.m698x12c6d0c7((Throwable) obj);
            }
        });
    }

    public void getHighwayPatrolTaskListApi(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.mDisposable = this.mRepository.getHighwayPatrolTaskListApi(str, str2, str3, str4, str5, str6, str7).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda2
            public final void accept(Object obj) throws Exception {
                this.f$0.m693xe127fc2c((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda308
            public final void accept(Object obj) throws Exception {
                this.f$0.m694x1e47c04b((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda180
            public final void accept(Object obj) throws Exception {
                this.f$0.m695x5b67846a((Throwable) obj);
            }
        });
    }

    public void getHighwayPatrolTaskRecordListApi() {
        this.mDisposable = this.mRepository.getHighwayPatrolTaskRecordListApi().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda5
            public final void accept(Object obj) throws Exception {
                this.f$0.m702xa7ec0985((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda312
            public final void accept(Object obj) throws Exception {
                this.f$0.m703xe50bcda4((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda183
            public final void accept(Object obj) throws Exception {
                this.f$0.m704x222b91c3((Throwable) obj);
            }
        });
    }

    public void getHighwayPatrolTaskStatusNumber() {
        this.mDisposable = this.mRepository.getHighwayPatrolTaskStatusNumber().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda6
            public final void accept(Object obj) throws Exception {
                this.f$0.m705x1d504ba3((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda299
            public final void accept(Object obj) throws Exception {
                this.f$0.m706x5a700fc2((HighwayPatrolTaskStatusNumberRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda184
            public final void accept(Object obj) throws Exception {
                this.f$0.m707x9b2aea6c((Throwable) obj);
            }
        });
    }

    public void getHighwayPatrolTaskTreeApi(String str, String str2) {
        this.mDisposable = this.mRepository.getHighwayPatrolTaskTreeApi(str, str2, "DXC").observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda7
            public final void accept(Object obj) throws Exception {
                this.f$0.m708x83608a0f((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda313
            public final void accept(Object obj) throws Exception {
                this.f$0.m709xc0804e2e((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda185
            public final void accept(Object obj) throws Exception {
                this.f$0.m710xfda0124d((Throwable) obj);
            }
        });
    }

    public void getHighwayPatrolTaskingApi() {
        getHighwayPatrolTaskingApi("");
    }

    public void getHighwayPatrolTaskingApi(String str) {
        this.mDisposable = this.mRepository.getHighwayPatrolTaskingApi(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda8
            public final void accept(Object obj) throws Exception {
                this.f$0.m711xeca591e3((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda310
            public final void accept(Object obj) throws Exception {
                this.f$0.m712x29c55602((HighwayPatrolTaskingApiRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda186
            public final void accept(Object obj) throws Exception {
                this.f$0.m713x6a8030ac((Throwable) obj);
            }
        });
    }

    public void getHighwayPatrolTaskingDataApi() {
        this.mDisposable = this.mRepository.getHighwayPatrolTaskingDataApi().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda9
            public final void accept(Object obj) throws Exception {
                this.f$0.m714x3ebf9015((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda321
            public final void accept(Object obj) throws Exception {
                this.f$0.m715x7bdf5434((HighwayPatrolTaskingApiRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda187
            public final void accept(Object obj) throws Exception {
                this.f$0.m716xb8ff1853((Throwable) obj);
            }
        });
    }

    public void getHistoryPatrolProblemList(String str) {
        this.mDisposable = this.mRepository.getHistoryPatrolProblemList(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda10
            public final void accept(Object obj) throws Exception {
                this.f$0.m717x3b6a0147((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda314
            public final void accept(Object obj) throws Exception {
                this.f$0.m718x7889c566((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda189
            public final void accept(Object obj) throws Exception {
                this.f$0.m719xb5a98985((Throwable) obj);
            }
        });
    }

    public void getLocationInfo(double d, double d2) {
        this.mDisposable = this.mRepository.getLocationInfo(d, d2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda12
            public final void accept(Object obj) throws Exception {
                this.f$0.m720lambda$getLocationInfo$281$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda384
            public final void accept(Object obj) throws Exception {
                this.f$0.m721lambda$getLocationInfo$282$comcollectpointnetvmPatrolVm((RegionByAddressRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda190
            public final void accept(Object obj) throws Exception {
                this.f$0.m722lambda$getLocationInfo$283$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getManageUnitList(String str, String str2) {
        this.mDisposable = this.mRepository.getManageUnitList(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda13
            public final void accept(Object obj) throws Exception {
                this.f$0.m723lambda$getManageUnitList$69$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda315
            public final void accept(Object obj) throws Exception {
                this.f$0.m724lambda$getManageUnitList$70$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda191
            public final void accept(Object obj) throws Exception {
                this.f$0.m725lambda$getManageUnitList$71$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getMeiTuanCouponInfo(String str, String str2) {
        this.mDisposable = this.mRepository.getMeiTuanCouponInfo(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda14
            public final void accept(Object obj) throws Exception {
                this.f$0.m726lambda$getMeiTuanCouponInfo$404$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda445
            public final void accept(Object obj) throws Exception {
                this.f$0.m727lambda$getMeiTuanCouponInfo$405$comcollectpointnetvmPatrolVm((BaseDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda192
            public final void accept(Object obj) throws Exception {
                this.f$0.m728lambda$getMeiTuanCouponInfo$406$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getNearByPatrolPersonnelList(String str, Double d, Double d2, String str2) {
        this.mDisposable = this.mRepository.getNearByPatrolPersonnelList(str, d.doubleValue(), d2.doubleValue(), str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda15
            public final void accept(Object obj) throws Exception {
                this.f$0.m729xfd7a94ed((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda316
            public final void accept(Object obj) throws Exception {
                this.f$0.m730x3a9a590c((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda193
            public final void accept(Object obj) throws Exception {
                this.f$0.m731x77ba1d2b((Throwable) obj);
            }
        });
    }

    public void getObjectList(String str, String str2, String str3) {
        this.mDisposable = this.mRepository.getObjectList(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda16
            public final void accept(Object obj) throws Exception {
                this.f$0.m732lambda$getObjectList$45$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda317
            public final void accept(Object obj) throws Exception {
                this.f$0.m733lambda$getObjectList$46$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda194
            public final void accept(Object obj) throws Exception {
                this.f$0.m734lambda$getObjectList$47$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getObjectListMySelf(String str, String str2) {
        this.mDisposable = this.mRepository.getObjectList(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda17
            public final void accept(Object obj) throws Exception {
                this.f$0.m735lambda$getObjectListMySelf$54$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda318
            public final void accept(Object obj) throws Exception {
                this.f$0.m736lambda$getObjectListMySelf$55$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda195
            public final void accept(Object obj) throws Exception {
                this.f$0.m737lambda$getObjectListMySelf$56$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getObjectListQL(String str, String str2, List<String> list) {
        this.mDisposable = this.mRepository.getObjectListQl(str, str2, list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda18
            public final void accept(Object obj) throws Exception {
                this.f$0.m738lambda$getObjectListQL$48$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda319
            public final void accept(Object obj) throws Exception {
                this.f$0.m739lambda$getObjectListQL$49$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda196
            public final void accept(Object obj) throws Exception {
                this.f$0.m740lambda$getObjectListQL$50$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getObjectListQL11(String str, String str2, String str3) {
        this.mDisposable = this.mRepository.getObjectListQl11(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda19
            public final void accept(Object obj) throws Exception {
                this.f$0.m741lambda$getObjectListQL11$51$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda320
            public final void accept(Object obj) throws Exception {
                this.f$0.m742lambda$getObjectListQL11$52$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda197
            public final void accept(Object obj) throws Exception {
                this.f$0.m743lambda$getObjectListQL11$53$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getObjectRoadInfo(String str) {
        this.mDisposable = this.mRepository.getObjectRoadInfo(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda20
            public final void accept(Object obj) throws Exception {
                this.f$0.m744lambda$getObjectRoadInfo$216$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda355
            public final void accept(Object obj) throws Exception {
                this.f$0.m745lambda$getObjectRoadInfo$217$comcollectpointnetvmPatrolVm((ObjectRoadInfoRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda198
            public final void accept(Object obj) throws Exception {
                this.f$0.m746lambda$getObjectRoadInfo$218$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getObjectRoadList(String str, String str2, String str3) {
        this.mDisposable = this.mRepository.getObjectRoadList(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda21
            public final void accept(Object obj) throws Exception {
                this.f$0.m747lambda$getObjectRoadList$210$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda322
            public final void accept(Object obj) throws Exception {
                this.f$0.m748lambda$getObjectRoadList$211$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda200
            public final void accept(Object obj) throws Exception {
                this.f$0.m749lambda$getObjectRoadList$212$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getObjectRoadMapList(String str, String str2, String str3) {
        this.mDisposable = this.mRepository.getObjectRoadList(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda23
            public final void accept(Object obj) throws Exception {
                this.f$0.m750lambda$getObjectRoadMapList$213$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda323
            public final void accept(Object obj) throws Exception {
                this.f$0.m751lambda$getObjectRoadMapList$214$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda201
            public final void accept(Object obj) throws Exception {
                this.f$0.m752lambda$getObjectRoadMapList$215$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getOnlineStatus(String str) {
        this.mDisposable = this.mRepository.getOnlineStatus(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda24
            public final void accept(Object obj) throws Exception {
                this.f$0.m753lambda$getOnlineStatus$219$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda366
            public final void accept(Object obj) throws Exception {
                this.f$0.m754lambda$getOnlineStatus$220$comcollectpointnetvmPatrolVm((OnlineStatusRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda202
            public final void accept(Object obj) throws Exception {
                this.f$0.m755lambda$getOnlineStatus$221$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getOrderInfo(String str, String str2, String str3) {
        this.mDisposable = this.mRepository.getOrderInfo(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda25
            public final void accept(Object obj) throws Exception {
                this.f$0.m756lambda$getOrderInfo$329$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda11
            public final void accept(Object obj) throws Exception {
                this.f$0.m757lambda$getOrderInfo$330$comcollectpointnetvmPatrolVm((BaseDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda203
            public final void accept(Object obj) throws Exception {
                this.f$0.m758lambda$getOrderInfo$331$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getPackCouponList(String str, String str2, String str3, String str4, List<CouponPayItem> list, List<CouponPayItem> list2) {
        this.mDisposable = this.mRepository.getPackCouponList(str, str2, str3, str4, list, list2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda26
            public final void accept(Object obj) throws Exception {
                this.f$0.m759lambda$getPackCouponList$344$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda22
            public final void accept(Object obj) throws Exception {
                this.f$0.m760lambda$getPackCouponList$345$comcollectpointnetvmPatrolVm((BaseDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda204
            public final void accept(Object obj) throws Exception {
                this.f$0.m761lambda$getPackCouponList$346$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getPartsDiseaseList(String str, String str2) {
        this.mDisposable = this.mRepository.getPartsDiseaseList(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda27
            public final void accept(Object obj) throws Exception {
                this.f$0.m762lambda$getPartsDiseaseList$21$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda324
            public final void accept(Object obj) throws Exception {
                this.f$0.m763lambda$getPartsDiseaseList$22$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda205
            public final void accept(Object obj) throws Exception {
                this.f$0.m764lambda$getPartsDiseaseList$23$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getPartsDiseaseResults(String str, String str2) {
        this.mDisposable = this.mRepository.getPartsDiseaseResults(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda28
            public final void accept(Object obj) throws Exception {
                this.f$0.m765xc8172b8a((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda325
            public final void accept(Object obj) throws Exception {
                this.f$0.m766x536efa9((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda206
            public final void accept(Object obj) throws Exception {
                this.f$0.m767x4256b3c8((Throwable) obj);
            }
        });
    }

    public void getPatrolEventList(String str, String str2, String str3, String str4, String str5) {
        this.mDisposable = this.mRepository.getPatrolEventList(str, str2, str3, str4, str5).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda29
            public final void accept(Object obj) throws Exception {
                this.f$0.m768lambda$getPatrolEventList$192$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda326
            public final void accept(Object obj) throws Exception {
                this.f$0.m769lambda$getPatrolEventList$193$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda207
            public final void accept(Object obj) throws Exception {
                this.f$0.m770lambda$getPatrolEventList$194$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getPatrolEventStatusList(String str) {
        this.mDisposable = this.mRepository.getPatrolEventStatusList(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda30
            public final void accept(Object obj) throws Exception {
                this.f$0.m771xf1a92d84((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda327
            public final void accept(Object obj) throws Exception {
                this.f$0.m772x2ec8f1a3((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda208
            public final void accept(Object obj) throws Exception {
                this.f$0.m773x6be8b5c2((Throwable) obj);
            }
        });
    }

    public void getPatrolPersonnelLocationGroupList(String str) {
        this.mDisposable = this.mRepository.getPatrolPersonnelLocationGroupList(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda31
            public final void accept(Object obj) throws Exception {
                this.f$0.m774x9c4043f7((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda116
            public final void accept(Object obj) throws Exception {
                this.f$0.m775xdcfb1ea1((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda209
            public final void accept(Object obj) throws Exception {
                this.f$0.m776x1a1ae2c0((Throwable) obj);
            }
        });
    }

    public void getPaymentMethod(String str) {
        this.mDisposable = this.mRepository.getPaymentMethod(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda32
            public final void accept(Object obj) throws Exception {
                this.f$0.m777lambda$getPaymentMethod$332$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda33
            public final void accept(Object obj) throws Exception {
                this.f$0.m778lambda$getPaymentMethod$333$comcollectpointnetvmPatrolVm((BaseDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda211
            public final void accept(Object obj) throws Exception {
                this.f$0.m779lambda$getPaymentMethod$334$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getPersonnelLocationList(String str, String str2) {
        this.mDisposable = this.mRepository.getPersonnelLocationList(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda34
            public final void accept(Object obj) throws Exception {
                this.f$0.m780x771ff070((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda328
            public final void accept(Object obj) throws Exception {
                this.f$0.m781xb43fb48f((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda212
            public final void accept(Object obj) throws Exception {
                this.f$0.m782xf15f78ae((Throwable) obj);
            }
        });
    }

    public void getPersonnelTrajectoryList(String str, String str2, String str3) {
        this.mDisposable = this.mRepository.getPersonnelTrajectoryList(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda35
            public final void accept(Object obj) throws Exception {
                this.f$0.m783x45d95cfb((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda329
            public final void accept(Object obj) throws Exception {
                this.f$0.m784x82f9211a((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda213
            public final void accept(Object obj) throws Exception {
                this.f$0.m785xc018e539((Throwable) obj);
            }
        });
    }

    public void getProcessingDiseaseList(String str, String str2, String str3) {
        this.mDisposable = this.mRepository.getPartsDiseaseList(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda36
            public final void accept(Object obj) throws Exception {
                this.f$0.m786xc0f0e03a((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda330
            public final void accept(Object obj) throws Exception {
                this.f$0.m787xfe10a459((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda214
            public final void accept(Object obj) throws Exception {
                this.f$0.m788x3b306878((Throwable) obj);
            }
        });
    }

    public void getProcessingDiseaseResults(String str, String str2) {
        this.mDisposable = this.mRepository.getPartsDiseaseResults(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda37
            public final void accept(Object obj) throws Exception {
                this.f$0.m789x647bd6b7((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda331
            public final void accept(Object obj) throws Exception {
                this.f$0.m790xa19b9ad6((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda215
            public final void accept(Object obj) throws Exception {
                this.f$0.m791xdebb5ef5((Throwable) obj);
            }
        });
    }

    public void getProcessingHighwayPatrolTaskCodeApi(List<String> list, double d, double d2) {
        this.mDisposable = this.mRepository.getHighwayPatrolTaskCodeApi(list, d, d2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda38
            public final void accept(Object obj) throws Exception {
                this.f$0.m792x7adb2132((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda117
            public final void accept(Object obj) throws Exception {
                this.f$0.m793xb7fae551((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda216
            public final void accept(Object obj) throws Exception {
                this.f$0.m794xf51aa970((Throwable) obj);
            }
        });
    }

    public void getProcessingObjectListMySelf(String str, String str2) {
        this.mDisposable = this.mRepository.getObjectList(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda39
            public final void accept(Object obj) throws Exception {
                this.f$0.m795xe4ed35ad((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda334
            public final void accept(Object obj) throws Exception {
                this.f$0.m796x220cf9cc((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda217
            public final void accept(Object obj) throws Exception {
                this.f$0.m797x5f2cbdeb((Throwable) obj);
            }
        });
    }

    public void getProcessingProjectOrgProcessArea(String str) {
        this.mDisposable = this.mRepository.getProjectOrgProcessArea(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda40
            public final void accept(Object obj) throws Exception {
                this.f$0.m800xdd5bc018((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda335
            public final void accept(Object obj) throws Exception {
                this.f$0.m798xeb9884d4((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda218
            public final void accept(Object obj) throws Exception {
                this.f$0.m799x28b848f3((Throwable) obj);
            }
        });
    }

    public void getProcessingSubmitProblemInfo(String str) {
        this.mDisposable = this.mRepository.getSubmitProblemInfo(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda41
            public final void accept(Object obj) throws Exception {
                this.f$0.m801x62904bba((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda386
            public final void accept(Object obj) throws Exception {
                this.f$0.m802x9fb00fd9((SubmitProblemInfoRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda219
            public final void accept(Object obj) throws Exception {
                this.f$0.m803xdccfd3f8((Throwable) obj);
            }
        });
    }

    public void getProcessingTypeFieldList(String str) {
        this.mDisposable = this.mRepository.getProjectTypeFieldList(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda42
            public final void accept(Object obj) throws Exception {
                this.f$0.m804xd72a0b9d((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda336
            public final void accept(Object obj) throws Exception {
                this.f$0.m805x1449cfbc((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda220
            public final void accept(Object obj) throws Exception {
                this.f$0.m806x516993db((Throwable) obj);
            }
        });
    }

    public void getProjectOrgProcessArea(String str) {
        this.mDisposable = this.mRepository.getProjectOrgProcessArea(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda43
            public final void accept(Object obj) throws Exception {
                this.f$0.m807xa9a000c8((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda337
            public final void accept(Object obj) throws Exception {
                this.f$0.m808xe6bfc4e7((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda223
            public final void accept(Object obj) throws Exception {
                this.f$0.m809x23df8906((Throwable) obj);
            }
        });
    }

    public void getProjectTypeFieldList(String str) {
        this.mDisposable = this.mRepository.getProjectTypeFieldList(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda45
            public final void accept(Object obj) throws Exception {
                this.f$0.m810x76afbecc((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda338
            public final void accept(Object obj) throws Exception {
                this.f$0.m811xb3cf82eb((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda224
            public final void accept(Object obj) throws Exception {
                this.f$0.m812xf0ef470a((Throwable) obj);
            }
        });
    }

    public void getRecentlyObjectApi(String str, double d, double d2) {
        this.mDisposable = this.mRepository.getRecentlyObjectApi(str, d, d2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda46
            public final void accept(Object obj) throws Exception {
                this.f$0.m813lambda$getRecentlyObjectApi$162$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda377
            public final void accept(Object obj) throws Exception {
                this.f$0.m814lambda$getRecentlyObjectApi$163$comcollectpointnetvmPatrolVm((RecentlyObjectRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda225
            public final void accept(Object obj) throws Exception {
                this.f$0.m815lambda$getRecentlyObjectApi$164$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getRegionListByMap(String str, String str2) {
        this.mDisposable = this.mRepository.getRegionListByMap(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda47
            public final void accept(Object obj) throws Exception {
                this.f$0.m816lambda$getRegionListByMap$12$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda339
            public final void accept(Object obj) throws Exception {
                this.f$0.m817lambda$getRegionListByMap$13$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda226
            public final void accept(Object obj) throws Exception {
                this.f$0.m818lambda$getRegionListByMap$14$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getRegionTreeByMap(String str) {
        this.mDisposable = this.mRepository.getRegionTreeByMap(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda48
            public final void accept(Object obj) throws Exception {
                this.f$0.m819lambda$getRegionTreeByMap$275$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda340
            public final void accept(Object obj) throws Exception {
                this.f$0.m820lambda$getRegionTreeByMap$276$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda227
            public final void accept(Object obj) throws Exception {
                this.f$0.m821lambda$getRegionTreeByMap$277$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getSubmitProblemInfo(String str) {
        this.mDisposable = this.mRepository.getSubmitProblemInfo(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda49
            public final void accept(Object obj) throws Exception {
                this.f$0.m822lambda$getSubmitProblemInfo$0$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda387
            public final void accept(Object obj) throws Exception {
                this.f$0.m823lambda$getSubmitProblemInfo$1$comcollectpointnetvmPatrolVm((SubmitProblemInfoRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda228
            public final void accept(Object obj) throws Exception {
                this.f$0.m824lambda$getSubmitProblemInfo$2$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getTableStatusNum() {
        this.mDisposable = this.mRepository.getTableStatusNum().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda50
            public final void accept(Object obj) throws Exception {
                this.f$0.m825lambda$getTableStatusNum$284$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda44
            public final void accept(Object obj) throws Exception {
                this.f$0.m826lambda$getTableStatusNum$285$comcollectpointnetvmPatrolVm((BaseDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda229
            public final void accept(Object obj) throws Exception {
                this.f$0.m827lambda$getTableStatusNum$286$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void getVensionInfo(String str) {
        this.mDisposable = this.mRepository.getVensionInfo(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda51
            public final void accept(Object obj) throws Exception {
                this.f$0.m828lambda$getVensionInfo$407$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda55
            public final void accept(Object obj) throws Exception {
                this.f$0.m829lambda$getVensionInfo$408$comcollectpointnetvmPatrolVm((BaseDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda230
            public final void accept(Object obj) throws Exception {
                this.f$0.m830lambda$getVensionInfo$409$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void hallCartAdd(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.mDisposable = this.mRepository.hallCartAdd(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda52
            public final void accept(Object obj) throws Exception {
                this.f$0.m831lambda$hallCartAdd$305$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda352
            public final void accept(Object obj) throws Exception {
                this.f$0.m832lambda$hallCartAdd$306$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda231
            public final void accept(Object obj) throws Exception {
                this.f$0.m833lambda$hallCartAdd$307$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void hallCartCancel(String str) {
        this.mDisposable = this.mRepository.hallCartCancel(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda53
            public final void accept(Object obj) throws Exception {
                this.f$0.m834lambda$hallCartCancel$443$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda353
            public final void accept(Object obj) throws Exception {
                this.f$0.m835lambda$hallCartCancel$444$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda232
            public final void accept(Object obj) throws Exception {
                this.f$0.m836lambda$hallCartCancel$445$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void hallCartDelete(String str) {
        this.mDisposable = this.mRepository.hallCartDelete(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda54
            public final void accept(Object obj) throws Exception {
                this.f$0.m837lambda$hallCartDelete$374$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda354
            public final void accept(Object obj) throws Exception {
                this.f$0.m838lambda$hallCartDelete$375$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda234
            public final void accept(Object obj) throws Exception {
                this.f$0.m839lambda$hallCartDelete$376$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void hallCartList(String str) {
        this.mDisposable = this.mRepository.hallCartList(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda56
            public final void accept(Object obj) throws Exception {
                this.f$0.m840lambda$hallCartList$299$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda244
            public final void accept(Object obj) throws Exception {
                this.f$0.m841lambda$hallCartList$300$comcollectpointnetvmPatrolVm((HallCartlistRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda235
            public final void accept(Object obj) throws Exception {
                this.f$0.m842lambda$hallCartList$301$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void hallCartSub(String str, String str2) {
        this.mDisposable = this.mRepository.hallCartSub(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda57
            public final void accept(Object obj) throws Exception {
                this.f$0.m843lambda$hallCartSub$302$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda356
            public final void accept(Object obj) throws Exception {
                this.f$0.m844lambda$hallCartSub$303$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda236
            public final void accept(Object obj) throws Exception {
                this.f$0.m845lambda$hallCartSub$304$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void highwayPatrolTaskTimeJudge(List<String> list) {
        this.mDisposable = this.mRepository.highwayPatrolTaskTimeJudge(list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda58
            public final void accept(Object obj) throws Exception {
                this.f$0.m846x61138ef8((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda0
            public final void accept(Object obj) throws Exception {
                this.f$0.m847xa1ce69a2((BridgeInspectTaskListItem) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda237
            public final void accept(Object obj) throws Exception {
                this.f$0.m848xdeee2dc1((Throwable) obj);
            }
        });
    }

    public void highwayPatrolTaskTimeJudge2(List<String> list) {
        this.mDisposable = this.mRepository.highwayPatrolTaskTimeJudge(list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda59
            public final void accept(Object obj) throws Exception {
                this.f$0.m849x6afe1b5b((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda111
            public final void accept(Object obj) throws Exception {
                this.f$0.m850xa81ddf7a((BridgeInspectTaskListItem) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda238
            public final void accept(Object obj) throws Exception {
                this.f$0.m851xe53da399((Throwable) obj);
            }
        });
    }

    public void indexIndex() {
        this.mDisposable = this.mRepository.indexIndex().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda60
            public final void accept(Object obj) throws Exception {
                this.f$0.m852lambda$indexIndex$380$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda332
            public final void accept(Object obj) throws Exception {
                this.f$0.m853lambda$indexIndex$381$comcollectpointnetvmPatrolVm((IndexIndexRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda239
            public final void accept(Object obj) throws Exception {
                this.f$0.m854lambda$indexIndex$382$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void insertHighwayPatrolTaskRecord(String str, String str2, String str3, List<String> list) {
        this.mDisposable = this.mRepository.insertHighwayPatrolTaskRecord(str, str2, str3, list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda61
            public final void accept(Object obj) throws Exception {
                this.f$0.m855x914de68e((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda118
            public final void accept(Object obj) throws Exception {
                this.f$0.m856xce6daaad((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda240
            public final void accept(Object obj) throws Exception {
                this.f$0.m857xb8d6ecc((Throwable) obj);
            }
        });
    }

    public void insertHighwayPatrolTaskTrajectoryListApi(String str, String str2, List<HighwayPatrolTaskTrajectoryApiReq> list) {
        this.mDisposable = this.mRepository.insertHighwayPatrolTaskTrajectoryListApi(str, str2, list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda62
            public final void accept(Object obj) throws Exception {
                this.f$0.m858x83cda07a((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda222
            public final void accept(Object obj) throws Exception {
                this.f$0.m859xc0ed6499((InsertPatrolTrajectoryReq) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda241
            public final void accept(Object obj) throws Exception {
                this.f$0.m860xfe0d28b8((Throwable) obj);
            }
        });
    }

    public void insertPersonnelDeviceRecord(List<InsertPersonnelDeviceRecordItem> list) {
        this.mDisposable = this.mRepository.insertPersonnelDeviceRecord(list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda63
            public final void accept(Object obj) throws Exception {
                this.f$0.m861x5f2475ce((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda119
            public final void accept(Object obj) throws Exception {
                this.f$0.m862x9c4439ed((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda242
            public final void accept(Object obj) throws Exception {
                this.f$0.m863xd963fe0c((Throwable) obj);
            }
        });
    }

    public void insertPointInfoApi(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final List<FieldListItem> list) {
        ArrayList arrayList = new ArrayList();
        if (EmptyUtils.isNotEmpty(list)) {
            for (FieldListItem fieldListItem : list) {
                if (TextUtils.equals(fieldListItem.getFieldType(), "upload") && EmptyUtils.isNotEmpty(fieldListItem.getFieldValue())) {
                    String[] strArrSplit = fieldListItem.getFieldValue().split(",");
                    if (EmptyUtils.isNotEmpty(strArrSplit)) {
                        arrayList.addAll(Arrays.asList(strArrSplit));
                    }
                }
            }
        }
        if (EmptyUtils.isNotEmpty(arrayList)) {
            this.mDisposable = this.mUploadRepo.rxUploadWxImgs(arrayList, 1, "").flatMap(new Function() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda382
                public final Object apply(Object obj) {
                    return this.f$0.m864lambda$insertPointInfoApi$234$comcollectpointnetvmPatrolVm(list, str, str2, str3, str4, str5, str6, str7, str8, str9, (List) obj);
                }
            }).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda64
                public final void accept(Object obj) throws Exception {
                    this.f$0.m865lambda$insertPointInfoApi$235$comcollectpointnetvmPatrolVm((Disposable) obj);
                }
            }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda376
                public final void accept(Object obj) throws Exception {
                    this.f$0.m866lambda$insertPointInfoApi$236$comcollectpointnetvmPatrolVm(str9, (String) obj);
                }
            }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda243
                public final void accept(Object obj) throws Exception {
                    this.f$0.m867lambda$insertPointInfoApi$237$comcollectpointnetvmPatrolVm((Throwable) obj);
                }
            });
        } else {
            this.mDisposable = this.mRepository.insertPointInfoApi(str, str2, str3, str4, str5, str6, str7, str8, str9, list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda65
                public final void accept(Object obj) throws Exception {
                    this.f$0.m868lambda$insertPointInfoApi$238$comcollectpointnetvmPatrolVm((Disposable) obj);
                }
            }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda378
                public final void accept(Object obj) throws Exception {
                    this.f$0.m869lambda$insertPointInfoApi$239$comcollectpointnetvmPatrolVm(str9, (String) obj);
                }
            }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda245
                public final void accept(Object obj) throws Exception {
                    this.f$0.m870lambda$insertPointInfoApi$240$comcollectpointnetvmPatrolVm((Throwable) obj);
                }
            });
        }
    }

    public void insertTrackListApi(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List<PointItem> list, final String str9) {
        this.mDisposable = this.mRepository.insertTrackListApi(str, str2, str3, str4, str5, str6, str7, str8, list, str9).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda67
            public final void accept(Object obj) throws Exception {
                this.f$0.m871lambda$insertTrackListApi$269$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda379
            public final void accept(Object obj) throws Exception {
                this.f$0.m872lambda$insertTrackListApi$270$comcollectpointnetvmPatrolVm(str9, (String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda246
            public final void accept(Object obj) throws Exception {
                this.f$0.m873lambda$insertTrackListApi$271$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    /* renamed from: lambda$OrderDetailHome$371$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m537lambda$OrderDetailHome$371$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mOrderDetailHome.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$OrderDetailHome$372$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m538lambda$OrderDetailHome$372$comcollectpointnetvmPatrolVm(BaseDataRes baseDataRes) throws Exception {
        this.mOrderDetailHome.setValue(Resource.success(baseDataRes));
    }

    /* renamed from: lambda$OrderDetailHome$373$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m539lambda$OrderDetailHome$373$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mOrderDetailHome.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$PrintBill$368$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m540lambda$PrintBill$368$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mPrintBill.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$PrintBill$369$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m541lambda$PrintBill$369$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mPrintBill.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$PrintBill$370$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m542lambda$PrintBill$370$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mPrintBill.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$addDeviceOrder$353$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m543lambda$addDeviceOrder$353$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mAddDeviceOrder.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$addDeviceOrder$354$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m544lambda$addDeviceOrder$354$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mAddDeviceOrder.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$addDeviceOrder$355$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m545lambda$addDeviceOrder$355$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mAddDeviceOrder.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$addMeal$308$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m546lambda$addMeal$308$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mAddMeal.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$addMeal$309$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m547lambda$addMeal$309$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mAddMeal.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$addMeal$310$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m548lambda$addMeal$310$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mAddMeal.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$addOrderCoupon$422$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m549lambda$addOrderCoupon$422$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mAddOrderCoupon.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$addOrderCoupon$423$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m550lambda$addOrderCoupon$423$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mAddOrderCoupon.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$addOrderCoupon$424$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m551lambda$addOrderCoupon$424$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mAddOrderCoupon.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$categoryIndex$293$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m552lambda$categoryIndex$293$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mCategoryIndex.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$categoryIndex$294$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m553lambda$categoryIndex$294$comcollectpointnetvmPatrolVm(BaseListDataRes baseListDataRes) throws Exception {
        this.mCategoryIndex.setValue(Resource.success(baseListDataRes));
    }

    /* renamed from: lambda$categoryIndex$295$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m554lambda$categoryIndex$295$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mCategoryIndex.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$changeNum$383$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m555lambda$changeNum$383$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mChangeNum.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$changeNum$384$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m556lambda$changeNum$384$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mChangeNum.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$changeNum$385$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m557lambda$changeNum$385$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mChangeNum.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$changeTable$323$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m558lambda$changeTable$323$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mChangeTable.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$changeTable$324$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m559lambda$changeTable$324$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mChangeTable.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$changeTable$325$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m560lambda$changeTable$325$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mChangeTable.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$changeTableList$320$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m561lambda$changeTableList$320$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mChangeTableList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$changeTableList$321$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m562lambda$changeTableList$321$comcollectpointnetvmPatrolVm(BaseListDataRes baseListDataRes) throws Exception {
        this.mChangeTableList.setValue(Resource.success(baseListDataRes));
    }

    /* renamed from: lambda$changeTableList$322$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m563lambda$changeTableList$322$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mChangeTableList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$closePatrolProblem$78$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m564lambda$closePatrolProblem$78$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mClosePatrolProblem.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$closePatrolProblem$79$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m565lambda$closePatrolProblem$79$comcollectpointnetvmPatrolVm(String str) throws Exception {
        this.mClosePatrolProblem.setValue(Resource.success(str));
    }

    /* renamed from: lambda$closePatrolProblem$80$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m566lambda$closePatrolProblem$80$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mClosePatrolProblem.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$closePatrolProblem$81$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m567lambda$closePatrolProblem$81$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mClosePatrolProblem.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$closePatrolProblem$82$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m568lambda$closePatrolProblem$82$comcollectpointnetvmPatrolVm(String str) throws Exception {
        this.mClosePatrolProblem.setValue(Resource.success(str));
    }

    /* renamed from: lambda$closePatrolProblem$83$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m569lambda$closePatrolProblem$83$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mClosePatrolProblem.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$closeScan$431$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m570lambda$closeScan$431$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mOpenScan.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$closeScan$432$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m571lambda$closeScan$432$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mOpenScan.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$closeScan$433$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m572lambda$closeScan$433$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mOpenScan.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$collectionObjectInfoApi$231$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m573xc58aef14(Disposable disposable) throws Exception {
        this.mCollectionObjectInfoApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$collectionObjectInfoApi$232$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m574x2aab333(List list) throws Exception {
        this.mCollectionObjectInfoApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$collectionObjectInfoApi$233$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m575x3fca7752(Throwable th) throws Exception {
        this.mCollectionObjectInfoApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$collectionObjectListApi$272$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m576x8bd04e27(Disposable disposable) throws Exception {
        this.mCollectionObjectListApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$collectionObjectListApi$273$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m577xc8f01246(List list) throws Exception {
        this.mCollectionObjectListApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$collectionObjectListApi$274$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m578x60fd665(Throwable th) throws Exception {
        this.mCollectionObjectListApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$collectionRecordInfoApi$260$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m579xc6bf604a(Disposable disposable) throws Exception {
        this.mCollectionRecordInfoApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$collectionRecordInfoApi$261$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m580x3df2469(InsertPointInfoRes insertPointInfoRes) throws Exception {
        this.mCollectionRecordInfoApi.setValue(Resource.success(insertPointInfoRes));
    }

    /* renamed from: lambda$collectionRecordInfoApi$262$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m581x40fee888(Throwable th) throws Exception {
        this.mCollectionRecordInfoApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$collectionRecordListApi$278$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m582x458dcf3(Disposable disposable) throws Exception {
        this.mCollectionRecordListApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$collectionRecordListApi$279$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m583x4178a112(List list) throws Exception {
        this.mCollectionRecordListApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$collectionRecordListApi$280$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m584x82337bbc(Throwable th) throws Exception {
        this.mCollectionRecordListApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$collectionRecordTrackInfoApi$263$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m585x2c22d53a(Disposable disposable) throws Exception {
        this.mCollectionRecordTrackInfoApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$collectionRecordTrackInfoApi$264$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m586x69429959(List list) throws Exception {
        this.mCollectionRecordTrackInfoApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$collectionRecordTrackInfoApi$265$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m587xa6625d78(Throwable th) throws Exception {
        this.mCollectionRecordTrackInfoApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$collectionTodayApi$251$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m588lambda$collectionTodayApi$251$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mCollectionTodayApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$collectionTodayApi$252$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m589lambda$collectionTodayApi$252$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mCollectionTodayApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$collectionTodayApi$253$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m590lambda$collectionTodayApi$253$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mCollectionTodayApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$collectionTodayPointApi$248$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m591xfaac83f0(Disposable disposable) throws Exception {
        this.mCollectionTodayPointApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$collectionTodayPointApi$249$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m592x37cc480f(List list) throws Exception {
        this.mCollectionTodayPointApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$collectionTodayPointApi$250$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m593x788722b9(Throwable th) throws Exception {
        this.mCollectionTodayPointApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$collectionTodayTrackApi$254$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m594xb34837f0(Disposable disposable) throws Exception {
        this.mCollectionTodayTrackApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$collectionTodayTrackApi$255$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m595xf067fc0f(List list) throws Exception {
        this.mCollectionTodayTrackApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$collectionTodayTrackApi$256$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m596x2d87c02e(Throwable th) throws Exception {
        this.mCollectionTodayTrackApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$createGroup$144$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m597lambda$createGroup$144$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mCreateGroup.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$createGroup$145$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m598lambda$createGroup$145$comcollectpointnetvmPatrolVm(String str) throws Exception {
        this.mCreateGroup.setValue(Resource.success(str));
    }

    /* renamed from: lambda$createGroup$146$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m599lambda$createGroup$146$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mCreateGroup.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$decomposePatrolPersonnelManage$75$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m600x2b9deeb5(Disposable disposable) throws Exception {
        this.decomposePatrolPersonnelManage.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$decomposePatrolPersonnelManage$76$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m601x68bdb2d4(String str) throws Exception {
        this.decomposePatrolPersonnelManage.setValue(Resource.success(str));
    }

    /* renamed from: lambda$decomposePatrolPersonnelManage$77$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m602xa5dd76f3(Throwable th) throws Exception {
        this.decomposePatrolPersonnelManage.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$deleteGroup$150$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m603lambda$deleteGroup$150$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mDeleteGroup.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$deleteGroup$151$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m604lambda$deleteGroup$151$comcollectpointnetvmPatrolVm(String str) throws Exception {
        this.mDeleteGroup.setValue(Resource.success(str));
    }

    /* renamed from: lambda$deleteGroup$152$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m605lambda$deleteGroup$152$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mDeleteGroup.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$deleteTrackListApi$266$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m606lambda$deleteTrackListApi$266$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mDeleteTrackListApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$deleteTrackListApi$267$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m607lambda$deleteTrackListApi$267$comcollectpointnetvmPatrolVm(String str) throws Exception {
        this.mDeleteTrackListApi.setValue(Resource.success(str));
    }

    /* renamed from: lambda$deleteTrackListApi$268$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m608lambda$deleteTrackListApi$268$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mDeleteTrackListApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$endHighwayPatrolTaskApi$126$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m609xe7ada207(Disposable disposable) throws Exception {
        this.mEndHighwayPatrolTaskApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$endHighwayPatrolTaskApi$127$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m610x24cd6626(EndHighwayPatrolTaskRes endHighwayPatrolTaskRes) throws Exception {
        this.mEndHighwayPatrolTaskApi.setValue(Resource.success(endHighwayPatrolTaskRes));
    }

    /* renamed from: lambda$endHighwayPatrolTaskApi$128$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m611x61ed2a45(Throwable th) throws Exception {
        this.mEndHighwayPatrolTaskApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getApiRepairProjectIncidentAcceptanceInfo$18$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m612x83f99c29(Disposable disposable) throws Exception {
        this.mApiRepairIncidentInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getApiRepairProjectIncidentAcceptanceInfo$19$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m613xc1196048(ApiRepairIncidentInfoRes apiRepairIncidentInfoRes) throws Exception {
        this.mApiRepairIncidentInfo.setValue(Resource.success(apiRepairIncidentInfoRes));
    }

    /* renamed from: lambda$getApiRepairProjectIncidentAcceptanceInfo$20$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m614x1d43af2(Throwable th) throws Exception {
        this.mApiRepairIncidentInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getApiRepairProjectIncidentAcceptanceList$15$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m615x386863bc(Disposable disposable) throws Exception {
        this.mApiRepairProjectIncidentAcceptanceList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getApiRepairProjectIncidentAcceptanceList$16$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m616x758827db(List list) throws Exception {
        this.mApiRepairProjectIncidentAcceptanceList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getApiRepairProjectIncidentAcceptanceList$17$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m617xb2a7ebfa(Throwable th) throws Exception {
        this.mApiRepairProjectIncidentAcceptanceList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getAssignTypeList$66$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m618lambda$getAssignTypeList$66$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mAssignTypeList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getAssignTypeList$67$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m619lambda$getAssignTypeList$67$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mAssignTypeList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getAssignTypeList$68$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m620lambda$getAssignTypeList$68$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mAssignTypeList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getAwaitDecomposePatrolProblemList$60$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m621x3c663151(Disposable disposable) throws Exception {
        this.mAwaitDecomposePatrolProblemList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getAwaitDecomposePatrolProblemList$61$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m622x7985f570(List list) throws Exception {
        this.mAwaitDecomposePatrolProblemList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getAwaitDecomposePatrolProblemList$62$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m623xb6a5b98f(Throwable th) throws Exception {
        this.mAwaitDecomposePatrolProblemList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getBridgeInspectHisNumber$93$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m624x9f2930fd(Disposable disposable) throws Exception {
        this.mBridgeInspectHisNumber.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getBridgeInspectHisNumber$94$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m625xdc48f51c(BridgeInspectNumberRes bridgeInspectNumberRes) throws Exception {
        this.mBridgeInspectHisNumber.setValue(Resource.success(bridgeInspectNumberRes));
    }

    /* renamed from: lambda$getBridgeInspectHisNumber$95$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m626x1968b93b(Throwable th) throws Exception {
        this.mBridgeInspectHisNumber.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getBridgeInspectNumber$90$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m627x52608792(Disposable disposable) throws Exception {
        this.mBridgeInspectNumber.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getBridgeInspectNumber$91$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m628x8f804bb1(BridgeInspectNumberRes bridgeInspectNumberRes) throws Exception {
        this.mBridgeInspectNumber.setValue(Resource.success(bridgeInspectNumberRes));
    }

    /* renamed from: lambda$getBridgeInspectNumber$92$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m629xcca00fd0(Throwable th) throws Exception {
        this.mBridgeInspectNumber.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getBridgeInspectRecordInfo$100$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m630x1d393514(BridgeInspectRecordInfoRes bridgeInspectRecordInfoRes) throws Exception {
        this.mBridgeInspectRecordInfo.setValue(Resource.success(bridgeInspectRecordInfoRes));
    }

    /* renamed from: lambda$getBridgeInspectRecordInfo$101$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m631x5a58f933(Throwable th) throws Exception {
        this.mBridgeInspectRecordInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getBridgeInspectRecordInfo$99$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m632x8ca9c9ff(Disposable disposable) throws Exception {
        this.mBridgeInspectRecordInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getBridgeInspectRecordList$96$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m633x41189192(Disposable disposable) throws Exception {
        this.mBridgeInspectRecordList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getBridgeInspectRecordList$97$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m634x7e3855b1(List list) throws Exception {
        this.mBridgeInspectRecordList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getBridgeInspectRecordList$98$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m635xbb5819d0(Throwable th) throws Exception {
        this.mBridgeInspectRecordList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getBridgeInspectTaskHisList$87$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m636xc962aac8(Disposable disposable) throws Exception {
        this.mBridgeInspectTaskHisList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getBridgeInspectTaskHisList$88$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m637x6826ee7(List list) throws Exception {
        this.mBridgeInspectTaskHisList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getBridgeInspectTaskHisList$89$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m638x43a23306(Throwable th) throws Exception {
        this.mBridgeInspectTaskHisList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getBridgeInspectTaskList$84$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m639x4098c347(Disposable disposable) throws Exception {
        this.mBridgeInspectTaskList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getBridgeInspectTaskList$85$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m640x7db88766(List list) throws Exception {
        this.mBridgeInspectTaskList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getBridgeInspectTaskList$86$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m641xbad84b85(Throwable th) throws Exception {
        this.mBridgeInspectTaskList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getCouponInfo2$392$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m642lambda$getCouponInfo2$392$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mCouponInfo2.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getCouponInfo2$393$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m643lambda$getCouponInfo2$393$comcollectpointnetvmPatrolVm(BaseDataRes baseDataRes) throws Exception {
        this.mCouponInfo2.setValue(Resource.success(baseDataRes));
    }

    /* renamed from: lambda$getCouponInfo2$394$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m644lambda$getCouponInfo2$394$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mCouponInfo2.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getCouponList$341$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m645lambda$getCouponList$341$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mCouponList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getCouponList$342$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m646lambda$getCouponList$342$comcollectpointnetvmPatrolVm(BaseDataRes baseDataRes) throws Exception {
        this.mCouponList.setValue(Resource.success(baseDataRes));
    }

    /* renamed from: lambda$getCouponList$343$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m647lambda$getCouponList$343$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mCouponList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getCouponListDyMt$395$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m648lambda$getCouponListDyMt$395$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mCouponListDyMt.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getCouponListDyMt$396$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m649lambda$getCouponListDyMt$396$comcollectpointnetvmPatrolVm(BaseDataRes baseDataRes) throws Exception {
        this.mCouponListDyMt.setValue(Resource.success(baseDataRes));
    }

    /* renamed from: lambda$getCouponListDyMt$397$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m650lambda$getCouponListDyMt$397$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mCouponListDyMt.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getDeviceCode$350$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m651lambda$getDeviceCode$350$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mDeviceCode.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getDeviceCode$351$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m652lambda$getDeviceCode$351$comcollectpointnetvmPatrolVm(BaseListRes baseListRes) throws Exception {
        this.mDeviceCode.setValue(Resource.success(baseListRes));
    }

    /* renamed from: lambda$getDeviceCode$352$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m653lambda$getDeviceCode$352$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mDeviceCode.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getDictionaryList$39$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m654lambda$getDictionaryList$39$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mDictionaryList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getDictionaryList$40$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m655lambda$getDictionaryList$40$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mDictionaryList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getDictionaryList$41$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m656lambda$getDictionaryList$41$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mDictionaryList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getDictionaryListMySelf$42$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m657x6031d575(Disposable disposable) throws Exception {
        this.mDictionaryListMySelf.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getDictionaryListMySelf$43$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m658x9d519994(List list) throws Exception {
        this.mDictionaryListMySelf.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getDictionaryListMySelf$44$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m659xda715db3(Throwable th) throws Exception {
        this.mDictionaryListMySelf.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getExamineObjectList$198$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m660lambda$getExamineObjectList$198$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mExamineObjectList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getExamineObjectList$199$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m661lambda$getExamineObjectList$199$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mExamineObjectList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getExamineObjectList$200$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m662lambda$getExamineObjectList$200$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mExamineObjectList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getExamineQuarterList$204$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m663x5f21b87e(Disposable disposable) throws Exception {
        this.mExamineQuarterList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getExamineQuarterList$205$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m664x9c417c9d(List list) throws Exception {
        this.mExamineQuarterList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getExamineQuarterList$206$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m665xd96140bc(Throwable th) throws Exception {
        this.mExamineQuarterList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getExamineReportList$207$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m666lambda$getExamineReportList$207$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mExamineReportList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getExamineReportList$208$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m667lambda$getExamineReportList$208$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mExamineReportList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getExamineReportList$209$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m668lambda$getExamineReportList$209$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mExamineReportList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getExamineTypeList$201$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m669lambda$getExamineTypeList$201$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mExamineTypeList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getExamineTypeList$202$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m670lambda$getExamineTypeList$202$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mExamineTypeList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getExamineTypeList$203$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m671lambda$getExamineTypeList$203$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mExamineTypeList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getGroupCouponList$347$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m672lambda$getGroupCouponList$347$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mGroupCouponList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getGroupCouponList$348$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m673lambda$getGroupCouponList$348$comcollectpointnetvmPatrolVm(BaseDataRes baseDataRes) throws Exception {
        this.mGroupCouponList.setValue(Resource.success(baseDataRes));
    }

    /* renamed from: lambda$getGroupCouponList$349$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m674lambda$getGroupCouponList$349$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mGroupCouponList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getGroupTypeList$419$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m675lambda$getGroupTypeList$419$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mGroupTypeList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getGroupTypeList$420$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m676lambda$getGroupTypeList$420$comcollectpointnetvmPatrolVm(BaseListRes baseListRes) throws Exception {
        this.mGroupTypeList.setValue(Resource.success(baseListRes));
    }

    /* renamed from: lambda$getGroupTypeList$421$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m677lambda$getGroupTypeList$421$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mGroupTypeList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHighwayPatrolConfig$123$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m678x235a0202(Disposable disposable) throws Exception {
        this.mHighwayPatrolConfig.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHighwayPatrolConfig$124$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m679x6079c621(HighwayPatrolConfigRes highwayPatrolConfigRes) throws Exception {
        this.mHighwayPatrolConfig.setValue(Resource.success(highwayPatrolConfigRes));
    }

    /* renamed from: lambda$getHighwayPatrolConfig$125$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m680x9d998a40(Throwable th) throws Exception {
        this.mHighwayPatrolConfig.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskCodeApi$177$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m681xbb9c515d(Disposable disposable) throws Exception {
        this.mHighwayPatrolTaskCodeApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskCodeApi$178$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m682xf8bc157c(String str) throws Exception {
        this.mHighwayPatrolTaskCodeApi.setValue(Resource.success(str));
    }

    /* renamed from: lambda$getHighwayPatrolTaskCodeApi$179$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m683x35dbd99b(Throwable th) throws Exception {
        this.mHighwayPatrolTaskCodeApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskDataApi$135$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m684x2324cad8(Disposable disposable) throws Exception {
        this.mHighwayPatrolTaskDataApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskDataApi$136$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m685x60448ef7(HighwayPatrolTaskDataApiRes highwayPatrolTaskDataApiRes) throws Exception {
        this.mHighwayPatrolTaskDataApi.setValue(Resource.success(highwayPatrolTaskDataApiRes));
    }

    /* renamed from: lambda$getHighwayPatrolTaskDataApi$137$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m686x9d645316(Throwable th) throws Exception {
        this.mHighwayPatrolTaskDataApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskGroupListApi$174$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m687x8463cce6(Disposable disposable) throws Exception {
        this.mHighwayPatrolTaskGroupListApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskGroupListApi$175$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m688xc1839105(List list) throws Exception {
        this.mHighwayPatrolTaskGroupListApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getHighwayPatrolTaskGroupListApi$176$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m689xfea35524(Throwable th) throws Exception {
        this.mHighwayPatrolTaskGroupListApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskInfoApi$111$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m690x1d1e5bde(Disposable disposable) throws Exception {
        this.mHighwayPatrolTaskInfoApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskInfoApi$112$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m691x5a3e1ffd(HighwayPatrolTaskInfoApiRes highwayPatrolTaskInfoApiRes) throws Exception {
        this.mHighwayPatrolTaskInfoApi.setValue(Resource.success(highwayPatrolTaskInfoApiRes));
    }

    /* renamed from: lambda$getHighwayPatrolTaskInfoApi$113$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m692x975de41c(Throwable th) throws Exception {
        this.mHighwayPatrolTaskInfoApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskListApi$102$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m693xe127fc2c(Disposable disposable) throws Exception {
        this.mHighwayPatrolTaskListApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskListApi$103$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m694x1e47c04b(List list) throws Exception {
        this.mHighwayPatrolTaskListApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getHighwayPatrolTaskListApi$104$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m695x5b67846a(Throwable th) throws Exception {
        this.mHighwayPatrolTaskListApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskListApi$105$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m696x98874889(Disposable disposable) throws Exception {
        this.mHighwayPatrolTaskListApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskListApi$106$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m697xd5a70ca8(List list) throws Exception {
        this.mHighwayPatrolTaskListApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getHighwayPatrolTaskListApi$107$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m698x12c6d0c7(Throwable th) throws Exception {
        this.mHighwayPatrolTaskListApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskListApi$108$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m699x4fe694e6(Disposable disposable) throws Exception {
        this.mHighwayPatrolTaskListToadyApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskListApi$109$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m700x8d065905(List list) throws Exception {
        this.mHighwayPatrolTaskListToadyApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getHighwayPatrolTaskListApi$110$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m701xcdc133af(Throwable th) throws Exception {
        this.mHighwayPatrolTaskListToadyApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskRecordListApi$171$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m702xa7ec0985(Disposable disposable) throws Exception {
        this.mHighwayPatrolTaskRecordListApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskRecordListApi$172$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m703xe50bcda4(List list) throws Exception {
        this.mHighwayPatrolTaskRecordListApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getHighwayPatrolTaskRecordListApi$173$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m704x222b91c3(Throwable th) throws Exception {
        this.mHighwayPatrolTaskRecordListApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskStatusNumber$168$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m705x1d504ba3(Disposable disposable) throws Exception {
        this.mHighwayPatrolTaskStatusNumber.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskStatusNumber$169$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m706x5a700fc2(HighwayPatrolTaskStatusNumberRes highwayPatrolTaskStatusNumberRes) throws Exception {
        this.mHighwayPatrolTaskStatusNumber.setValue(Resource.success(highwayPatrolTaskStatusNumberRes));
    }

    /* renamed from: lambda$getHighwayPatrolTaskStatusNumber$170$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m707x9b2aea6c(Throwable th) throws Exception {
        this.mHighwayPatrolTaskStatusNumber.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskTreeApi$165$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m708x83608a0f(Disposable disposable) throws Exception {
        this.mHighwayPatrolTaskTreeApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskTreeApi$166$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m709xc0804e2e(List list) throws Exception {
        this.mHighwayPatrolTaskTreeApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getHighwayPatrolTaskTreeApi$167$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m710xfda0124d(Throwable th) throws Exception {
        this.mHighwayPatrolTaskTreeApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskingApi$138$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m711xeca591e3(Disposable disposable) throws Exception {
        this.mHighwayPatrolTaskingApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskingApi$139$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m712x29c55602(HighwayPatrolTaskingApiRes highwayPatrolTaskingApiRes) throws Exception {
        this.mHighwayPatrolTaskingApi.setValue(Resource.success(highwayPatrolTaskingApiRes));
    }

    /* renamed from: lambda$getHighwayPatrolTaskingApi$140$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m713x6a8030ac(Throwable th) throws Exception {
        this.mHighwayPatrolTaskingApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskingDataApi$141$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m714x3ebf9015(Disposable disposable) throws Exception {
        this.mHighwayPatrolTaskingDataApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHighwayPatrolTaskingDataApi$142$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m715x7bdf5434(HighwayPatrolTaskingApiRes highwayPatrolTaskingApiRes) throws Exception {
        this.mHighwayPatrolTaskingDataApi.setValue(Resource.success(highwayPatrolTaskingApiRes));
    }

    /* renamed from: lambda$getHighwayPatrolTaskingDataApi$143$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m716xb8ff1853(Throwable th) throws Exception {
        this.mHighwayPatrolTaskingDataApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHistoryPatrolProblemList$63$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m717x3b6a0147(Disposable disposable) throws Exception {
        this.mHistoryPatrolProblemList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHistoryPatrolProblemList$64$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m718x7889c566(List list) throws Exception {
        this.mHistoryPatrolProblemList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getHistoryPatrolProblemList$65$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m719xb5a98985(Throwable th) throws Exception {
        this.mHistoryPatrolProblemList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getLocationInfo$281$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m720lambda$getLocationInfo$281$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mLocationInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getLocationInfo$282$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m721lambda$getLocationInfo$282$comcollectpointnetvmPatrolVm(RegionByAddressRes regionByAddressRes) throws Exception {
        this.mLocationInfo.setValue(Resource.success(regionByAddressRes));
    }

    /* renamed from: lambda$getLocationInfo$283$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m722lambda$getLocationInfo$283$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mLocationInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getManageUnitList$69$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m723lambda$getManageUnitList$69$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mManageUnitList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getManageUnitList$70$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m724lambda$getManageUnitList$70$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mManageUnitList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getManageUnitList$71$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m725lambda$getManageUnitList$71$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mManageUnitList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getMeiTuanCouponInfo$404$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m726lambda$getMeiTuanCouponInfo$404$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mCouponInfo2.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getMeiTuanCouponInfo$405$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m727lambda$getMeiTuanCouponInfo$405$comcollectpointnetvmPatrolVm(BaseDataRes baseDataRes) throws Exception {
        this.mCouponInfo2.setValue(Resource.success(baseDataRes));
    }

    /* renamed from: lambda$getMeiTuanCouponInfo$406$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m728lambda$getMeiTuanCouponInfo$406$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mCouponInfo2.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getNearByPatrolPersonnelList$72$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m729xfd7a94ed(Disposable disposable) throws Exception {
        this.mPersonnelResList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getNearByPatrolPersonnelList$73$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m730x3a9a590c(List list) throws Exception {
        this.mPersonnelResList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getNearByPatrolPersonnelList$74$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m731x77ba1d2b(Throwable th) throws Exception {
        this.mPersonnelResList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getObjectList$45$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m732lambda$getObjectList$45$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mGetObjectList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getObjectList$46$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m733lambda$getObjectList$46$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mGetObjectList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getObjectList$47$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m734lambda$getObjectList$47$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mGetObjectList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getObjectListMySelf$54$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m735lambda$getObjectListMySelf$54$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mGetObjectListMySelf.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getObjectListMySelf$55$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m736lambda$getObjectListMySelf$55$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mGetObjectListMySelf.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getObjectListMySelf$56$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m737lambda$getObjectListMySelf$56$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mGetObjectListMySelf.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getObjectListQL$48$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m738lambda$getObjectListQL$48$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mGetObjectList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getObjectListQL$49$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m739lambda$getObjectListQL$49$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mGetObjectList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getObjectListQL$50$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m740lambda$getObjectListQL$50$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mGetObjectList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getObjectListQL11$51$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m741lambda$getObjectListQL11$51$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mGetObjectList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getObjectListQL11$52$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m742lambda$getObjectListQL11$52$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mGetObjectList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getObjectListQL11$53$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m743lambda$getObjectListQL11$53$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mGetObjectList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getObjectRoadInfo$216$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m744lambda$getObjectRoadInfo$216$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mObjectRoadInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getObjectRoadInfo$217$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m745lambda$getObjectRoadInfo$217$comcollectpointnetvmPatrolVm(ObjectRoadInfoRes objectRoadInfoRes) throws Exception {
        this.mObjectRoadInfo.setValue(Resource.success(objectRoadInfoRes));
    }

    /* renamed from: lambda$getObjectRoadInfo$218$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m746lambda$getObjectRoadInfo$218$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mObjectRoadInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getObjectRoadList$210$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m747lambda$getObjectRoadList$210$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mObjectRoadList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getObjectRoadList$211$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m748lambda$getObjectRoadList$211$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mObjectRoadList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getObjectRoadList$212$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m749lambda$getObjectRoadList$212$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mObjectRoadList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getObjectRoadMapList$213$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m750lambda$getObjectRoadMapList$213$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mObjectRoadMapList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getObjectRoadMapList$214$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m751lambda$getObjectRoadMapList$214$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mObjectRoadMapList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getObjectRoadMapList$215$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m752lambda$getObjectRoadMapList$215$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mObjectRoadMapList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getOnlineStatus$219$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m753lambda$getOnlineStatus$219$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mOnlineStatus.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getOnlineStatus$220$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m754lambda$getOnlineStatus$220$comcollectpointnetvmPatrolVm(OnlineStatusRes onlineStatusRes) throws Exception {
        this.mOnlineStatus.setValue(Resource.success(onlineStatusRes));
    }

    /* renamed from: lambda$getOnlineStatus$221$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m755lambda$getOnlineStatus$221$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mOnlineStatus.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getOrderInfo$329$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m756lambda$getOrderInfo$329$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mOrderInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getOrderInfo$330$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m757lambda$getOrderInfo$330$comcollectpointnetvmPatrolVm(BaseDataRes baseDataRes) throws Exception {
        this.mOrderInfo.setValue(Resource.success(baseDataRes));
    }

    /* renamed from: lambda$getOrderInfo$331$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m758lambda$getOrderInfo$331$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mOrderInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getPackCouponList$344$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m759lambda$getPackCouponList$344$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mPackCouponList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getPackCouponList$345$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m760lambda$getPackCouponList$345$comcollectpointnetvmPatrolVm(BaseDataRes baseDataRes) throws Exception {
        this.mPackCouponList.setValue(Resource.success(baseDataRes));
    }

    /* renamed from: lambda$getPackCouponList$346$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m761lambda$getPackCouponList$346$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mPackCouponList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getPartsDiseaseList$21$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m762lambda$getPartsDiseaseList$21$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mPartsDiseaseList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getPartsDiseaseList$22$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m763lambda$getPartsDiseaseList$22$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mPartsDiseaseList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getPartsDiseaseList$23$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m764lambda$getPartsDiseaseList$23$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mPartsDiseaseList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getPartsDiseaseResults$27$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m765xc8172b8a(Disposable disposable) throws Exception {
        this.mPartsDiseaseResults.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getPartsDiseaseResults$28$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m766x536efa9(List list) throws Exception {
        this.mPartsDiseaseResults.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getPartsDiseaseResults$29$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m767x4256b3c8(Throwable th) throws Exception {
        this.mPartsDiseaseResults.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getPatrolEventList$192$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m768lambda$getPatrolEventList$192$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mPatrolEventList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getPatrolEventList$193$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m769lambda$getPatrolEventList$193$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mPatrolEventList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getPatrolEventList$194$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m770lambda$getPatrolEventList$194$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mPatrolEventList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getPatrolEventStatusList$195$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m771xf1a92d84(Disposable disposable) throws Exception {
        this.mPatrolEventStatusList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getPatrolEventStatusList$196$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m772x2ec8f1a3(List list) throws Exception {
        this.mPatrolEventStatusList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getPatrolEventStatusList$197$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m773x6be8b5c2(Throwable th) throws Exception {
        this.mPatrolEventStatusList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getPatrolPersonnelLocationGroupList$189$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m774x9c4043f7(Disposable disposable) throws Exception {
        this.mPatrolPersonnelLocationGroupList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getPatrolPersonnelLocationGroupList$190$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m775xdcfb1ea1(String str) throws Exception {
        this.mPatrolPersonnelLocationGroupList.setValue(Resource.success(str));
    }

    /* renamed from: lambda$getPatrolPersonnelLocationGroupList$191$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m776x1a1ae2c0(Throwable th) throws Exception {
        this.mPatrolPersonnelLocationGroupList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getPaymentMethod$332$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m777lambda$getPaymentMethod$332$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mPaymentMethod.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getPaymentMethod$333$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m778lambda$getPaymentMethod$333$comcollectpointnetvmPatrolVm(BaseDataRes baseDataRes) throws Exception {
        this.mPaymentMethod.setValue(Resource.success(baseDataRes));
    }

    /* renamed from: lambda$getPaymentMethod$334$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m779lambda$getPaymentMethod$334$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mPaymentMethod.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getPersonnelLocationList$183$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m780x771ff070(Disposable disposable) throws Exception {
        this.mPersonnelLocationList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getPersonnelLocationList$184$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m781xb43fb48f(List list) throws Exception {
        this.mPersonnelLocationList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getPersonnelLocationList$185$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m782xf15f78ae(Throwable th) throws Exception {
        this.mPersonnelLocationList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getPersonnelTrajectoryList$186$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m783x45d95cfb(Disposable disposable) throws Exception {
        this.mPersonnelTrajectoryList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getPersonnelTrajectoryList$187$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m784x82f9211a(List list) throws Exception {
        this.mPersonnelTrajectoryList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getPersonnelTrajectoryList$188$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m785xc018e539(Throwable th) throws Exception {
        this.mPersonnelTrajectoryList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getProcessingDiseaseList$24$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m786xc0f0e03a(Disposable disposable) throws Exception {
        this.mProcessingDiseaseList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getProcessingDiseaseList$25$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m787xfe10a459(List list) throws Exception {
        this.mProcessingDiseaseList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getProcessingDiseaseList$26$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m788x3b306878(Throwable th) throws Exception {
        this.mProcessingDiseaseList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getProcessingDiseaseResults$30$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m789x647bd6b7(Disposable disposable) throws Exception {
        this.mProcessingDiseaseResults.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getProcessingDiseaseResults$31$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m790xa19b9ad6(List list) throws Exception {
        this.mProcessingDiseaseResults.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getProcessingDiseaseResults$32$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m791xdebb5ef5(Throwable th) throws Exception {
        this.mProcessingDiseaseResults.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getProcessingHighwayPatrolTaskCodeApi$180$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m792x7adb2132(Disposable disposable) throws Exception {
        this.mProcessingHighwayPatrolTaskCodeApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getProcessingHighwayPatrolTaskCodeApi$181$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m793xb7fae551(String str) throws Exception {
        this.mProcessingHighwayPatrolTaskCodeApi.setValue(Resource.success(str));
    }

    /* renamed from: lambda$getProcessingHighwayPatrolTaskCodeApi$182$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m794xf51aa970(Throwable th) throws Exception {
        this.mProcessingHighwayPatrolTaskCodeApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getProcessingObjectListMySelf$57$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m795xe4ed35ad(Disposable disposable) throws Exception {
        this.mProcessingGetObjectListMySelf.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getProcessingObjectListMySelf$58$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m796x220cf9cc(List list) throws Exception {
        this.mProcessingGetObjectListMySelf.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getProcessingObjectListMySelf$59$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m797x5f2cbdeb(Throwable th) throws Exception {
        this.mProcessingGetObjectListMySelf.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getProcessingProjectOrgProcessArea$10$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m798xeb9884d4(List list) throws Exception {
        this.mProcessingProjectOrgProcessArea.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getProcessingProjectOrgProcessArea$11$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m799x28b848f3(Throwable th) throws Exception {
        this.mProcessingProjectOrgProcessArea.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getProcessingProjectOrgProcessArea$9$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m800xdd5bc018(Disposable disposable) throws Exception {
        this.mProcessingProjectOrgProcessArea.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getProcessingSubmitProblemInfo$3$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m801x62904bba(Disposable disposable) throws Exception {
        this.mProcessingSubmitProblemInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getProcessingSubmitProblemInfo$4$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m802x9fb00fd9(SubmitProblemInfoRes submitProblemInfoRes) throws Exception {
        this.mProcessingSubmitProblemInfo.setValue(Resource.success(submitProblemInfoRes));
    }

    /* renamed from: lambda$getProcessingSubmitProblemInfo$5$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m803xdccfd3f8(Throwable th) throws Exception {
        this.mProcessingSubmitProblemInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getProcessingTypeFieldList$36$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m804xd72a0b9d(Disposable disposable) throws Exception {
        this.mProcessingTypeFieldList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getProcessingTypeFieldList$37$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m805x1449cfbc(List list) throws Exception {
        this.mProcessingTypeFieldList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getProcessingTypeFieldList$38$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m806x516993db(Throwable th) throws Exception {
        this.mProcessingTypeFieldList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getProjectOrgProcessArea$6$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m807xa9a000c8(Disposable disposable) throws Exception {
        this.mProjectOrgProcessArea.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getProjectOrgProcessArea$7$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m808xe6bfc4e7(List list) throws Exception {
        this.mProjectOrgProcessArea.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getProjectOrgProcessArea$8$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m809x23df8906(Throwable th) throws Exception {
        this.mProjectOrgProcessArea.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getProjectTypeFieldList$33$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m810x76afbecc(Disposable disposable) throws Exception {
        this.mProjectTypeFieldList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getProjectTypeFieldList$34$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m811xb3cf82eb(List list) throws Exception {
        this.mProjectTypeFieldList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getProjectTypeFieldList$35$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m812xf0ef470a(Throwable th) throws Exception {
        this.mProjectTypeFieldList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getRecentlyObjectApi$162$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m813lambda$getRecentlyObjectApi$162$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mRecentlyObjectApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getRecentlyObjectApi$163$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m814lambda$getRecentlyObjectApi$163$comcollectpointnetvmPatrolVm(RecentlyObjectRes recentlyObjectRes) throws Exception {
        this.mRecentlyObjectApi.setValue(Resource.success(recentlyObjectRes));
    }

    /* renamed from: lambda$getRecentlyObjectApi$164$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m815lambda$getRecentlyObjectApi$164$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mRecentlyObjectApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getRegionListByMap$12$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m816lambda$getRegionListByMap$12$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mRegionListByMap.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getRegionListByMap$13$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m817lambda$getRegionListByMap$13$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mRegionListByMap.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getRegionListByMap$14$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m818lambda$getRegionListByMap$14$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mRegionListByMap.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getRegionTreeByMap$275$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m819lambda$getRegionTreeByMap$275$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mRegionTreeByMap.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getRegionTreeByMap$276$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m820lambda$getRegionTreeByMap$276$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mRegionTreeByMap.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getRegionTreeByMap$277$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m821lambda$getRegionTreeByMap$277$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mRegionTreeByMap.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getSubmitProblemInfo$0$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m822lambda$getSubmitProblemInfo$0$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mSubmitProblemInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getSubmitProblemInfo$1$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m823lambda$getSubmitProblemInfo$1$comcollectpointnetvmPatrolVm(SubmitProblemInfoRes submitProblemInfoRes) throws Exception {
        this.mSubmitProblemInfo.setValue(Resource.success(submitProblemInfoRes));
    }

    /* renamed from: lambda$getSubmitProblemInfo$2$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m824lambda$getSubmitProblemInfo$2$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mSubmitProblemInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getTableStatusNum$284$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m825lambda$getTableStatusNum$284$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mTableStatusNum.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getTableStatusNum$285$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m826lambda$getTableStatusNum$285$comcollectpointnetvmPatrolVm(BaseDataRes baseDataRes) throws Exception {
        this.mTableStatusNum.setValue(Resource.success(baseDataRes));
    }

    /* renamed from: lambda$getTableStatusNum$286$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m827lambda$getTableStatusNum$286$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mTableStatusNum.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getVensionInfo$407$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m828lambda$getVensionInfo$407$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mVensionInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getVensionInfo$408$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m829lambda$getVensionInfo$408$comcollectpointnetvmPatrolVm(BaseDataRes baseDataRes) throws Exception {
        this.mVensionInfo.setValue(Resource.success(baseDataRes));
    }

    /* renamed from: lambda$getVensionInfo$409$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m830lambda$getVensionInfo$409$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mVensionInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$hallCartAdd$305$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m831lambda$hallCartAdd$305$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mHallCartAdd.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$hallCartAdd$306$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m832lambda$hallCartAdd$306$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mHallCartAdd.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$hallCartAdd$307$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m833lambda$hallCartAdd$307$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mHallCartAdd.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$hallCartCancel$443$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m834lambda$hallCartCancel$443$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mOpen.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$hallCartCancel$444$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m835lambda$hallCartCancel$444$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mOpen.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$hallCartCancel$445$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m836lambda$hallCartCancel$445$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mOpen.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$hallCartDelete$374$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m837lambda$hallCartDelete$374$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mHallCartDelete.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$hallCartDelete$375$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m838lambda$hallCartDelete$375$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mHallCartDelete.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$hallCartDelete$376$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m839lambda$hallCartDelete$376$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mHallCartDelete.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$hallCartList$299$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m840lambda$hallCartList$299$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mHallCartList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$hallCartList$300$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m841lambda$hallCartList$300$comcollectpointnetvmPatrolVm(HallCartlistRes hallCartlistRes) throws Exception {
        this.mHallCartList.setValue(Resource.success(hallCartlistRes));
    }

    /* renamed from: lambda$hallCartList$301$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m842lambda$hallCartList$301$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mHallCartList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$hallCartSub$302$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m843lambda$hallCartSub$302$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mHallCartSub.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$hallCartSub$303$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m844lambda$hallCartSub$303$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mHallCartSub.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$hallCartSub$304$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m845lambda$hallCartSub$304$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mHallCartSub.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$highwayPatrolTaskTimeJudge$159$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m846x61138ef8(Disposable disposable) throws Exception {
        this.mHighwayPatrolTaskTimeJudge.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$highwayPatrolTaskTimeJudge$160$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m847xa1ce69a2(BridgeInspectTaskListItem bridgeInspectTaskListItem) throws Exception {
        this.mHighwayPatrolTaskTimeJudge.setValue(Resource.success(bridgeInspectTaskListItem));
    }

    /* renamed from: lambda$highwayPatrolTaskTimeJudge$161$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m848xdeee2dc1(Throwable th) throws Exception {
        this.mHighwayPatrolTaskTimeJudge.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$highwayPatrolTaskTimeJudge2$156$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m849x6afe1b5b(Disposable disposable) throws Exception {
        this.mHighwayPatrolTaskTimeJudge2.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$highwayPatrolTaskTimeJudge2$157$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m850xa81ddf7a(BridgeInspectTaskListItem bridgeInspectTaskListItem) throws Exception {
        this.mHighwayPatrolTaskTimeJudge2.setValue(Resource.success(bridgeInspectTaskListItem));
    }

    /* renamed from: lambda$highwayPatrolTaskTimeJudge2$158$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m851xe53da399(Throwable th) throws Exception {
        this.mHighwayPatrolTaskTimeJudge2.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$indexIndex$380$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m852lambda$indexIndex$380$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mIndexIndex.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$indexIndex$381$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m853lambda$indexIndex$381$comcollectpointnetvmPatrolVm(IndexIndexRes indexIndexRes) throws Exception {
        this.mIndexIndex.setValue(Resource.success(indexIndexRes));
    }

    /* renamed from: lambda$indexIndex$382$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m854lambda$indexIndex$382$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mIndexIndex.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$insertHighwayPatrolTaskRecord$153$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m855x914de68e(Disposable disposable) throws Exception {
        this.mStartHighwayPatrolTaskApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$insertHighwayPatrolTaskRecord$154$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m856xce6daaad(String str) throws Exception {
        this.mStartHighwayPatrolTaskApi.setValue(Resource.success(str));
    }

    /* renamed from: lambda$insertHighwayPatrolTaskRecord$155$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m857xb8d6ecc(Throwable th) throws Exception {
        this.mStartHighwayPatrolTaskApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$insertHighwayPatrolTaskTrajectoryListApi$120$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m858x83cda07a(Disposable disposable) throws Exception {
        this.mInsertHighwayPatrolTaskTrajectoryListApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$insertHighwayPatrolTaskTrajectoryListApi$121$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m859xc0ed6499(InsertPatrolTrajectoryReq insertPatrolTrajectoryReq) throws Exception {
        this.mInsertHighwayPatrolTaskTrajectoryListApi.setValue(Resource.success(insertPatrolTrajectoryReq));
    }

    /* renamed from: lambda$insertHighwayPatrolTaskTrajectoryListApi$122$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m860xfe0d28b8(Throwable th) throws Exception {
        this.mInsertHighwayPatrolTaskTrajectoryListApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$insertPersonnelDeviceRecord$117$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m861x5f2475ce(Disposable disposable) throws Exception {
        this.mInsertPersonnelDeviceRecord.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$insertPersonnelDeviceRecord$118$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m862x9c4439ed(String str) throws Exception {
        this.mInsertPersonnelDeviceRecord.setValue(Resource.success(str));
    }

    /* renamed from: lambda$insertPersonnelDeviceRecord$119$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m863xd963fe0c(Throwable th) throws Exception {
        this.mInsertPersonnelDeviceRecord.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$insertPointInfoApi$234$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ SingleSource m864lambda$insertPointInfoApi$234$comcollectpointnetvmPatrolVm(List list, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list2) throws Exception {
        ArrayList arrayList = new ArrayList(list2);
        if (EmptyUtils.isNotEmpty(list)) {
            int length = 0;
            for (int i = 0; i < list.size(); i++) {
                if (TextUtils.equals(((FieldListItem) list.get(i)).getFieldType(), "upload")) {
                    if (EmptyUtils.isNotEmpty(((FieldListItem) list.get(i)).getFieldValue())) {
                        String[] strArrSplit = ((FieldListItem) list.get(i)).getFieldValue().split(",");
                        if (EmptyUtils.isNotEmpty(strArrSplit)) {
                            if (EmptyUtils.isNotEmpty(arrayList)) {
                                StringBuilder sb = new StringBuilder();
                                for (int i2 = length; i2 < arrayList.size(); i2++) {
                                    sb.append(((UploadWxRes) ((BaseResponse) arrayList.get(i2)).getObject()).getObject()).append(",");
                                }
                                if (EmptyUtils.isNotEmpty(((FieldListItem) list.get(i)).getNetPic())) {
                                    sb.append(((FieldListItem) list.get(i)).getNetPic()).append(",");
                                }
                                ((FieldListItem) list.get(i)).setFieldValue(sb.substring(0, sb.length() - 1));
                            }
                            length += strArrSplit.length;
                        }
                    } else if (EmptyUtils.isNotEmpty(((FieldListItem) list.get(i)).getNetPic())) {
                        ((FieldListItem) list.get(i)).setFieldValue(((FieldListItem) list.get(i)).getNetPic());
                    }
                }
            }
        }
        return this.mRepository.insertPointInfoApi(str, str2, str3, str4, str5, str6, str7, str8, str9, list);
    }

    /* renamed from: lambda$insertPointInfoApi$235$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m865lambda$insertPointInfoApi$235$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mInsertPointInfoApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$insertPointInfoApi$236$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m866lambda$insertPointInfoApi$236$comcollectpointnetvmPatrolVm(String str, String str2) throws Exception {
        this.mInsertPointInfoApi.setValue(Resource.success(str));
    }

    /* renamed from: lambda$insertPointInfoApi$237$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m867lambda$insertPointInfoApi$237$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mInsertPointInfoApi.setValue(Resource.error(this.mHttpHandler.getThrowableHCMsg(th, 4), null));
    }

    /* renamed from: lambda$insertPointInfoApi$238$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m868lambda$insertPointInfoApi$238$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mInsertPointInfoApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$insertPointInfoApi$239$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m869lambda$insertPointInfoApi$239$comcollectpointnetvmPatrolVm(String str, String str2) throws Exception {
        this.mInsertPointInfoApi.setValue(Resource.success(str));
    }

    /* renamed from: lambda$insertPointInfoApi$240$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m870lambda$insertPointInfoApi$240$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mInsertPointInfoApi.setValue(Resource.error(this.mHttpHandler.getThrowableHCMsg(th, 4), null));
    }

    /* renamed from: lambda$insertTrackListApi$269$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m871lambda$insertTrackListApi$269$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mInsertTrackListApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$insertTrackListApi$270$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m872lambda$insertTrackListApi$270$comcollectpointnetvmPatrolVm(String str, String str2) throws Exception {
        this.mInsertTrackListApi.setValue(Resource.success(str));
    }

    /* renamed from: lambda$insertTrackListApi$271$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m873lambda$insertTrackListApi$271$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mInsertTrackListApi.setValue(Resource.error(this.mHttpHandler.getThrowableHCMsg(th, 4), null));
    }

    /* renamed from: lambda$mergeTable$413$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m874lambda$mergeTable$413$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mChangeTable.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$mergeTable$414$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m875lambda$mergeTable$414$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mChangeTable.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$mergeTable$415$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m876lambda$mergeTable$415$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mChangeTable.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$microRefund$377$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m877lambda$microRefund$377$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mMicroRefund.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$microRefund$378$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m878lambda$microRefund$378$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mMicroRefund.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$microRefund$379$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m879lambda$microRefund$379$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mMicroRefund.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$moveProduct$326$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m880lambda$moveProduct$326$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mMoveProduct.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$moveProduct$327$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m881lambda$moveProduct$327$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mMoveProduct.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$moveProduct$328$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m882lambda$moveProduct$328$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mMoveProduct.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$newPay$356$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m883lambda$newPay$356$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mNewPay.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$newPay$357$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m884lambda$newPay$357$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mNewPay.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$newPay$358$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m885lambda$newPay$358$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mNewPay.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$open$410$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m886lambda$open$410$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mOpen.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$open$411$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m887lambda$open$411$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mOpen.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$open$412$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m888lambda$open$412$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mOpen.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$openScan$428$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m889lambda$openScan$428$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mOpenScan.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$openScan$429$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m890lambda$openScan$429$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mOpenScan.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$openScan$430$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m891lambda$openScan$430$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mOpenScan.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$orderCancel$317$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m892lambda$orderCancel$317$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mOrderCancel.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$orderCancel$318$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m893lambda$orderCancel$318$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mOrderCancel.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$orderCancel$319$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m894lambda$orderCancel$319$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mOrderCancel.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$orderDetail$314$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m895lambda$orderDetail$314$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mOrderDetail.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$orderDetail$315$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m896lambda$orderDetail$315$comcollectpointnetvmPatrolVm(HallCartDetailRes hallCartDetailRes) throws Exception {
        this.mOrderDetail.setValue(Resource.success(hallCartDetailRes));
    }

    /* renamed from: lambda$orderDetail$316$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m897lambda$orderDetail$316$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mOrderDetail.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$orderDetailList$359$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m898lambda$orderDetailList$359$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mOrderDetailList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$orderDetailList$360$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m899lambda$orderDetailList$360$comcollectpointnetvmPatrolVm(BaseListDataRes baseListDataRes) throws Exception {
        this.mOrderDetailList.setValue(Resource.success(baseListDataRes));
    }

    /* renamed from: lambda$orderDetailList$361$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m900lambda$orderDetailList$361$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mOrderDetailList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$permissionList$416$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m901lambda$permissionList$416$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mPermissionList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$permissionList$417$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m902lambda$permissionList$417$comcollectpointnetvmPatrolVm(BaseListRes baseListRes) throws Exception {
        this.mPermissionList.setValue(Resource.success(baseListRes));
    }

    /* renamed from: lambda$permissionList$418$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m903lambda$permissionList$418$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mPermissionList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$previewHighwayPatrolTaskListApi$114$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m904x27bc3e79(Disposable disposable) throws Exception {
        this.mPreviewHighwayPatrolTaskListApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$previewHighwayPatrolTaskListApi$115$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m905x64dc0298(HighwayPatrolTaskInfoApiRes highwayPatrolTaskInfoApiRes) throws Exception {
        this.mPreviewHighwayPatrolTaskListApi.setValue(Resource.success(highwayPatrolTaskInfoApiRes));
    }

    /* renamed from: lambda$previewHighwayPatrolTaskListApi$116$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m906xa1fbc6b7(Throwable th) throws Exception {
        this.mPreviewHighwayPatrolTaskListApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$printOrder$362$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m907lambda$printOrder$362$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mPrintOrder.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$printOrder$363$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m908lambda$printOrder$363$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mPrintOrder.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$printOrder$364$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m909lambda$printOrder$364$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mPrintOrder.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$productIndex$296$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m910lambda$productIndex$296$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mProductIndex.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$productIndex$297$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m911lambda$productIndex$297$comcollectpointnetvmPatrolVm(HallCartRes hallCartRes) throws Exception {
        this.mProductIndex.setValue(Resource.success(hallCartRes));
    }

    /* renamed from: lambda$productIndex$298$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m912lambda$productIndex$298$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mProductIndex.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$productPass$437$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m913lambda$productPass$437$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mProductPassRollback.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$productPass$438$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m914lambda$productPass$438$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mProductPassRollback.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$productPass$439$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m915lambda$productPass$439$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mProductPassRollback.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$productPassRollback$440$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m916lambda$productPassRollback$440$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mProductPassRollback.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$productPassRollback$441$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m917lambda$productPassRollback$441$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mProductPassRollback.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$productPassRollback$442$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m918lambda$productPassRollback$442$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mProductPassRollback.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$projectObjectFirstListApi$225$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m919xf13ac65a(Disposable disposable) throws Exception {
        this.mProjectObjectFirstListApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$projectObjectFirstListApi$226$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m920x2e5a8a79(List list) throws Exception {
        this.mProjectObjectFirstListApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$projectObjectFirstListApi$227$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m921x6b7a4e98(Throwable th) throws Exception {
        this.mProjectObjectFirstListApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$projectObjectListApi$228$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m922lambda$projectObjectListApi$228$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mProjectObjectListApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$projectObjectListApi$229$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m923lambda$projectObjectListApi$229$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mProjectObjectListApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$projectObjectListApi$230$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m924lambda$projectObjectListApi$230$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mProjectObjectListApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$recaptureApi$257$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m925lambda$recaptureApi$257$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mRecaptureApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$recaptureApi$258$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m926lambda$recaptureApi$258$comcollectpointnetvmPatrolVm(List list) throws Exception {
        this.mRecaptureApi.setValue(Resource.success(list));
    }

    /* renamed from: lambda$recaptureApi$259$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m927lambda$recaptureApi$259$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mRecaptureApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$refundCoupon$386$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m928lambda$refundCoupon$386$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mVerifyCoupon.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$refundCoupon$387$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m929lambda$refundCoupon$387$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mVerifyCoupon.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$refundCoupon$388$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m930lambda$refundCoupon$388$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mVerifyCoupon.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$refundMeituanCoupon$398$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m931lambda$refundMeituanCoupon$398$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mVerifyCoupon.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$refundMeituanCoupon$399$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m932lambda$refundMeituanCoupon$399$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mVerifyCoupon.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$refundMeituanCoupon$400$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m933lambda$refundMeituanCoupon$400$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mVerifyCoupon.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$refundOrderCoupon$425$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m934lambda$refundOrderCoupon$425$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mAddOrderCoupon.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$refundOrderCoupon$426$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m935lambda$refundOrderCoupon$426$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mAddOrderCoupon.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$refundOrderCoupon$427$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m936lambda$refundOrderCoupon$427$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mAddOrderCoupon.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$restartHighwayPatrolTaskApi$132$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m937xda0a6818(Disposable disposable) throws Exception {
        this.mRestartHighwayPatrolTaskApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$restartHighwayPatrolTaskApi$133$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m938x172a2c37(RestartPatrolTaskRes restartPatrolTaskRes) throws Exception {
        this.mRestartHighwayPatrolTaskApi.setValue(Resource.success(restartPatrolTaskRes));
    }

    /* renamed from: lambda$restartHighwayPatrolTaskApi$134$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m939x5449f056(Throwable th) throws Exception {
        this.mRestartHighwayPatrolTaskApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$saveScanInfo$434$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m940lambda$saveScanInfo$434$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mSaveScanInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$saveScanInfo$435$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m941lambda$saveScanInfo$435$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mSaveScanInfo.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$saveScanInfo$436$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m942lambda$saveScanInfo$436$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mSaveScanInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$scanPayQuery$338$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m943lambda$scanPayQuery$338$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mScanPayQuery.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$scanPayQuery$339$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m944lambda$scanPayQuery$339$comcollectpointnetvmPatrolVm(BaseResuleRes baseResuleRes) throws Exception {
        this.mScanPayQuery.setValue(Resource.success(baseResuleRes));
    }

    /* renamed from: lambda$scanPayQuery$340$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m945lambda$scanPayQuery$340$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mScanPayQuery.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$sscanPay$335$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m946lambda$sscanPay$335$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mScanPay.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$sscanPay$336$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m947lambda$sscanPay$336$comcollectpointnetvmPatrolVm(BaseDataRes baseDataRes) throws Exception {
        this.mScanPay.setValue(Resource.success(baseDataRes));
    }

    /* renamed from: lambda$sscanPay$337$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m948lambda$sscanPay$337$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mScanPay.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$stopHighwayPatrolTaskApi$129$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m949x2eae8543(Disposable disposable) throws Exception {
        this.mStopHighwayPatrolTaskApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$stopHighwayPatrolTaskApi$130$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m950x6f695fed(String str) throws Exception {
        this.mStopHighwayPatrolTaskApi.setValue(Resource.success(str));
    }

    /* renamed from: lambda$stopHighwayPatrolTaskApi$131$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m951xac89240c(Throwable th) throws Exception {
        this.mStopHighwayPatrolTaskApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$tableArea$287$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m952lambda$tableArea$287$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mTableArea.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$tableArea$288$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m953lambda$tableArea$288$comcollectpointnetvmPatrolVm(BaseListDataRes baseListDataRes) throws Exception {
        this.mTableArea.setValue(Resource.success(baseListDataRes));
    }

    /* renamed from: lambda$tableArea$289$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m954lambda$tableArea$289$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mTableArea.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$tableBuy$311$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m955lambda$tableBuy$311$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mAddMeal.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$tableBuy$312$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m956lambda$tableBuy$312$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mAddMeal.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$tableBuy$313$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m957lambda$tableBuy$313$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mAddMeal.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$tableList$290$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m958lambda$tableList$290$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mTableList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$tableList$291$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m959lambda$tableList$291$comcollectpointnetvmPatrolVm(BaseListDataRes baseListDataRes) throws Exception {
        this.mTableList.setValue(Resource.success(baseListDataRes));
    }

    /* renamed from: lambda$tableList$292$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m960lambda$tableList$292$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mTableList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$updateGroup$147$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m961lambda$updateGroup$147$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mUpdateGroup.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$updateGroup$148$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m962lambda$updateGroup$148$comcollectpointnetvmPatrolVm(String str) throws Exception {
        this.mUpdateGroup.setValue(Resource.success(str));
    }

    /* renamed from: lambda$updateGroup$149$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m963lambda$updateGroup$149$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mUpdateGroup.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$updatePointInfoApi$241$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ SingleSource m964lambda$updatePointInfoApi$241$comcollectpointnetvmPatrolVm(List list, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List list2) throws Exception {
        ArrayList arrayList = new ArrayList(list2);
        if (EmptyUtils.isNotEmpty(list)) {
            int length = 0;
            for (int i = 0; i < list.size(); i++) {
                if (TextUtils.equals(((FieldListItem) list.get(i)).getFieldType(), "upload")) {
                    StringBuilder sb = new StringBuilder();
                    if (EmptyUtils.isNotEmpty(((FieldListItem) list.get(i)).getFieldValue())) {
                        String[] strArrSplit = ((FieldListItem) list.get(i)).getFieldValue().split(",");
                        if (EmptyUtils.isNotEmpty(strArrSplit)) {
                            if (EmptyUtils.isNotEmpty(arrayList)) {
                                for (int i2 = length; i2 < arrayList.size(); i2++) {
                                    sb.append(((UploadWxRes) ((BaseResponse) arrayList.get(i2)).getObject()).getObject()).append(",");
                                }
                                if (EmptyUtils.isNotEmpty(((FieldListItem) list.get(i)).getNetPic())) {
                                    sb.append(((FieldListItem) list.get(i)).getNetPic()).append(",");
                                }
                                ((FieldListItem) list.get(i)).setFieldValue(sb.substring(0, sb.length() - 1));
                            }
                            length += strArrSplit.length;
                        }
                    } else if (EmptyUtils.isNotEmpty(((FieldListItem) list.get(i)).getNetPic())) {
                        ((FieldListItem) list.get(i)).setFieldValue(((FieldListItem) list.get(i)).getNetPic());
                    }
                }
            }
        }
        return this.mRepository.updatePointInfoApi(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, list);
    }

    /* renamed from: lambda$updatePointInfoApi$242$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m965lambda$updatePointInfoApi$242$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mInsertPointInfoApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$updatePointInfoApi$243$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m966lambda$updatePointInfoApi$243$comcollectpointnetvmPatrolVm(String str, String str2) throws Exception {
        this.mInsertPointInfoApi.setValue(Resource.success(str));
    }

    /* renamed from: lambda$updatePointInfoApi$244$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m967lambda$updatePointInfoApi$244$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mInsertPointInfoApi.setValue(Resource.error(this.mHttpHandler.getThrowableHCMsg(th, 4), null));
    }

    /* renamed from: lambda$updatePointInfoApi$245$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m968lambda$updatePointInfoApi$245$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mInsertPointInfoApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$updatePointInfoApi$246$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m969lambda$updatePointInfoApi$246$comcollectpointnetvmPatrolVm(String str, String str2) throws Exception {
        this.mInsertPointInfoApi.setValue(Resource.success(str));
    }

    /* renamed from: lambda$updatePointInfoApi$247$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m970lambda$updatePointInfoApi$247$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mInsertPointInfoApi.setValue(Resource.error(this.mHttpHandler.getThrowableHCMsg(th, 4), null));
    }

    /* renamed from: lambda$urgedishes$365$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m971lambda$urgedishes$365$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mUrgedishes.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$urgedishes$366$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m972lambda$urgedishes$366$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mUrgedishes.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$urgedishes$367$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m973lambda$urgedishes$367$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mUrgedishes.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$verifyCoupon$389$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m974lambda$verifyCoupon$389$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mVerifyCoupon.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$verifyCoupon$390$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m975lambda$verifyCoupon$390$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mVerifyCoupon.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$verifyCoupon$391$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m976lambda$verifyCoupon$391$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mVerifyCoupon.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$verifyMeituanCoupon$401$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m977lambda$verifyMeituanCoupon$401$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mVerifyCoupon.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$verifyMeituanCoupon$402$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m978lambda$verifyMeituanCoupon$402$comcollectpointnetvmPatrolVm(Object obj) throws Exception {
        this.mVerifyCoupon.setValue(Resource.success(obj));
    }

    /* renamed from: lambda$verifyMeituanCoupon$403$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m979lambda$verifyMeituanCoupon$403$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mVerifyCoupon.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$weatherInfoApi$222$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m980lambda$weatherInfoApi$222$comcollectpointnetvmPatrolVm(Disposable disposable) throws Exception {
        this.mWeatherInfoApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$weatherInfoApi$223$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m981lambda$weatherInfoApi$223$comcollectpointnetvmPatrolVm(WeatherInfoRes weatherInfoRes) throws Exception {
        this.mWeatherInfoApi.setValue(Resource.success(weatherInfoRes));
    }

    /* renamed from: lambda$weatherInfoApi$224$com-collectpoint-net-vm-PatrolVm, reason: not valid java name */
    /* synthetic */ void m982lambda$weatherInfoApi$224$comcollectpointnetvmPatrolVm(Throwable th) throws Exception {
        this.mWeatherInfoApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    public void mergeTable(String str, String str2) {
        this.mDisposable = this.mRepository.mergeTable(str2, str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda68
            public final void accept(Object obj) throws Exception {
                this.f$0.m874lambda$mergeTable$413$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda357
            public final void accept(Object obj) throws Exception {
                this.f$0.m875lambda$mergeTable$414$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda247
            public final void accept(Object obj) throws Exception {
                this.f$0.m876lambda$mergeTable$415$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void microRefund(String str) {
        this.mDisposable = this.mRepository.microRefund(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda69
            public final void accept(Object obj) throws Exception {
                this.f$0.m877lambda$microRefund$377$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda358
            public final void accept(Object obj) throws Exception {
                this.f$0.m878lambda$microRefund$378$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda248
            public final void accept(Object obj) throws Exception {
                this.f$0.m879lambda$microRefund$379$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void moveProduct(String str, String str2, String str3, String str4) {
        this.mDisposable = this.mRepository.moveProduct(str, str2, str3, str4).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda70
            public final void accept(Object obj) throws Exception {
                this.f$0.m880lambda$moveProduct$326$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda359
            public final void accept(Object obj) throws Exception {
                this.f$0.m881lambda$moveProduct$327$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda249
            public final void accept(Object obj) throws Exception {
                this.f$0.m882lambda$moveProduct$328$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void newPay(OrderInfo2Req orderInfo2Req) {
        this.mDisposable = this.mRepository.newPay(orderInfo2Req).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda71
            public final void accept(Object obj) throws Exception {
                this.f$0.m883lambda$newPay$356$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda360
            public final void accept(Object obj) throws Exception {
                this.f$0.m884lambda$newPay$357$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda250
            public final void accept(Object obj) throws Exception {
                this.f$0.m885lambda$newPay$358$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void open(String str) {
        this.mDisposable = this.mRepository.open(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda72
            public final void accept(Object obj) throws Exception {
                this.f$0.m886lambda$open$410$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda361
            public final void accept(Object obj) throws Exception {
                this.f$0.m887lambda$open$411$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda251
            public final void accept(Object obj) throws Exception {
                this.f$0.m888lambda$open$412$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void openScan(String str) {
        this.mDisposable = this.mRepository.openScan(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda73
            public final void accept(Object obj) throws Exception {
                this.f$0.m889lambda$openScan$428$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda362
            public final void accept(Object obj) throws Exception {
                this.f$0.m890lambda$openScan$429$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda252
            public final void accept(Object obj) throws Exception {
                this.f$0.m891lambda$openScan$430$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void orderCancel(String str) {
        this.mDisposable = this.mRepository.orderCancel(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda74
            public final void accept(Object obj) throws Exception {
                this.f$0.m892lambda$orderCancel$317$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda363
            public final void accept(Object obj) throws Exception {
                this.f$0.m893lambda$orderCancel$318$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda253
            public final void accept(Object obj) throws Exception {
                this.f$0.m894lambda$orderCancel$319$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void orderDetail(String str) {
        this.mDisposable = this.mRepository.orderDetail(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda75
            public final void accept(Object obj) throws Exception {
                this.f$0.m895lambda$orderDetail$314$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda221
            public final void accept(Object obj) throws Exception {
                this.f$0.m896lambda$orderDetail$315$comcollectpointnetvmPatrolVm((HallCartDetailRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda254
            public final void accept(Object obj) throws Exception {
                this.f$0.m897lambda$orderDetail$316$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void orderDetailList(OrderInfo2Req orderInfo2Req) {
        this.mDisposable = this.mRepository.orderDetailList(orderInfo2Req).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda76
            public final void accept(Object obj) throws Exception {
                this.f$0.m898lambda$orderDetailList$359$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda99
            public final void accept(Object obj) throws Exception {
                this.f$0.m899lambda$orderDetailList$360$comcollectpointnetvmPatrolVm((BaseListDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda256
            public final void accept(Object obj) throws Exception {
                this.f$0.m900lambda$orderDetailList$361$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void permissionList() {
        this.mDisposable = this.mRepository.permissionList().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda78
            public final void accept(Object obj) throws Exception {
                this.f$0.m901lambda$permissionList$416$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda155
            public final void accept(Object obj) throws Exception {
                this.f$0.m902lambda$permissionList$417$comcollectpointnetvmPatrolVm((BaseListRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda257
            public final void accept(Object obj) throws Exception {
                this.f$0.m903lambda$permissionList$418$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void previewHighwayPatrolTaskListApi(List<String> list) {
        this.mDisposable = this.mRepository.previewHighwayPatrolTaskListApi(list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda79
            public final void accept(Object obj) throws Exception {
                this.f$0.m904x27bc3e79((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda288
            public final void accept(Object obj) throws Exception {
                this.f$0.m905x64dc0298((HighwayPatrolTaskInfoApiRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda258
            public final void accept(Object obj) throws Exception {
                this.f$0.m906xa1fbc6b7((Throwable) obj);
            }
        });
    }

    public void printOrder(OrderInfo2Req orderInfo2Req) {
        this.mDisposable = this.mRepository.printOrder(orderInfo2Req).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda80
            public final void accept(Object obj) throws Exception {
                this.f$0.m907lambda$printOrder$362$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda364
            public final void accept(Object obj) throws Exception {
                this.f$0.m908lambda$printOrder$363$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda259
            public final void accept(Object obj) throws Exception {
                this.f$0.m909lambda$printOrder$364$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void productIndex(String str, String str2, String str3, String str4) {
        this.mDisposable = this.mRepository.productIndex(str, str2, str3, str4).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda81
            public final void accept(Object obj) throws Exception {
                this.f$0.m910lambda$productIndex$296$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda233
            public final void accept(Object obj) throws Exception {
                this.f$0.m911lambda$productIndex$297$comcollectpointnetvmPatrolVm((HallCartRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda260
            public final void accept(Object obj) throws Exception {
                this.f$0.m912lambda$productIndex$298$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void productPass(String str) {
        this.mDisposable = this.mRepository.productPass(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda82
            public final void accept(Object obj) throws Exception {
                this.f$0.m913lambda$productPass$437$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda365
            public final void accept(Object obj) throws Exception {
                this.f$0.m914lambda$productPass$438$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda261
            public final void accept(Object obj) throws Exception {
                this.f$0.m915lambda$productPass$439$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void productPassRollback(String str) {
        this.mDisposable = this.mRepository.productPassRollback(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda83
            public final void accept(Object obj) throws Exception {
                this.f$0.m916lambda$productPassRollback$440$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda367
            public final void accept(Object obj) throws Exception {
                this.f$0.m917lambda$productPassRollback$441$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda262
            public final void accept(Object obj) throws Exception {
                this.f$0.m918lambda$productPassRollback$442$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void projectObjectFirstListApi(String str) {
        this.mDisposable = this.mRepository.projectObjectFirstListApi(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda84
            public final void accept(Object obj) throws Exception {
                this.f$0.m919xf13ac65a((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda341
            public final void accept(Object obj) throws Exception {
                this.f$0.m920x2e5a8a79((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda263
            public final void accept(Object obj) throws Exception {
                this.f$0.m921x6b7a4e98((Throwable) obj);
            }
        });
    }

    public void projectObjectListApi(String str, String str2) {
        projectObjectListApi(str, str2, "");
    }

    public void projectObjectListApi(String str, String str2, String str3) {
        this.mDisposable = this.mRepository.projectObjectListApi(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda85
            public final void accept(Object obj) throws Exception {
                this.f$0.m922lambda$projectObjectListApi$228$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda342
            public final void accept(Object obj) throws Exception {
                this.f$0.m923lambda$projectObjectListApi$229$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda264
            public final void accept(Object obj) throws Exception {
                this.f$0.m924lambda$projectObjectListApi$230$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void recaptureApi() {
        this.mDisposable = this.mRepository.recaptureApi().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda86
            public final void accept(Object obj) throws Exception {
                this.f$0.m925lambda$recaptureApi$257$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda343
            public final void accept(Object obj) throws Exception {
                this.f$0.m926lambda$recaptureApi$258$comcollectpointnetvmPatrolVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda265
            public final void accept(Object obj) throws Exception {
                this.f$0.m927lambda$recaptureApi$259$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void refundCoupon(String str) {
        this.mDisposable = this.mRepository.refundCoupon(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda87
            public final void accept(Object obj) throws Exception {
                this.f$0.m928lambda$refundCoupon$386$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda368
            public final void accept(Object obj) throws Exception {
                this.f$0.m929lambda$refundCoupon$387$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda267
            public final void accept(Object obj) throws Exception {
                this.f$0.m930lambda$refundCoupon$388$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void refundMeituanCoupon(String str) {
        this.mDisposable = this.mRepository.refundMeituanCoupon(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda89
            public final void accept(Object obj) throws Exception {
                this.f$0.m931lambda$refundMeituanCoupon$398$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda369
            public final void accept(Object obj) throws Exception {
                this.f$0.m932lambda$refundMeituanCoupon$399$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda268
            public final void accept(Object obj) throws Exception {
                this.f$0.m933lambda$refundMeituanCoupon$400$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void refundOrderCoupon(String str) {
        this.mDisposable = this.mRepository.refundOrderCoupon(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda90
            public final void accept(Object obj) throws Exception {
                this.f$0.m934lambda$refundOrderCoupon$425$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda370
            public final void accept(Object obj) throws Exception {
                this.f$0.m935lambda$refundOrderCoupon$426$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda269
            public final void accept(Object obj) throws Exception {
                this.f$0.m936lambda$refundOrderCoupon$427$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void restartHighwayPatrolTaskApi(String str, String str2) {
        this.mDisposable = this.mRepository.restartHighwayPatrolTaskApi(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda91
            public final void accept(Object obj) throws Exception {
                this.f$0.m937xda0a6818((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda385
            public final void accept(Object obj) throws Exception {
                this.f$0.m938x172a2c37((RestartPatrolTaskRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda270
            public final void accept(Object obj) throws Exception {
                this.f$0.m939x5449f056((Throwable) obj);
            }
        });
    }

    public void saveScanInfo(String str, String str2) {
        this.mDisposable = this.mRepository.saveScanInfo(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda92
            public final void accept(Object obj) throws Exception {
                this.f$0.m940lambda$saveScanInfo$434$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda371
            public final void accept(Object obj) throws Exception {
                this.f$0.m941lambda$saveScanInfo$435$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda271
            public final void accept(Object obj) throws Exception {
                this.f$0.m942lambda$saveScanInfo$436$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void scanPayQuery(String str) {
        this.mDisposable = this.mRepository.scanPayQuery(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda93
            public final void accept(Object obj) throws Exception {
                this.f$0.m943lambda$scanPayQuery$338$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda166
            public final void accept(Object obj) throws Exception {
                this.f$0.m944lambda$scanPayQuery$339$comcollectpointnetvmPatrolVm((BaseResuleRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda272
            public final void accept(Object obj) throws Exception {
                this.f$0.m945lambda$scanPayQuery$340$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void sscanPay(String str, String str2, String str3) {
        this.mDisposable = this.mRepository.scanPay(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda94
            public final void accept(Object obj) throws Exception {
                this.f$0.m946lambda$sscanPay$335$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda66
            public final void accept(Object obj) throws Exception {
                this.f$0.m947lambda$sscanPay$336$comcollectpointnetvmPatrolVm((BaseDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda273
            public final void accept(Object obj) throws Exception {
                this.f$0.m948lambda$sscanPay$337$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void stopHighwayPatrolTaskApi(String str, String str2, String str3, List<HighwayPatrolTaskTrajectoryApiReq> list) {
        this.mDisposable = this.mRepository.stopHighwayPatrolTaskApi(str, str2, str3, list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda95
            public final void accept(Object obj) throws Exception {
                this.f$0.m949x2eae8543((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda120
            public final void accept(Object obj) throws Exception {
                this.f$0.m950x6f695fed((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda274
            public final void accept(Object obj) throws Exception {
                this.f$0.m951xac89240c((Throwable) obj);
            }
        });
    }

    public void tableArea(String str) {
        this.mDisposable = this.mRepository.tableArea(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda96
            public final void accept(Object obj) throws Exception {
                this.f$0.m952lambda$tableArea$287$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda110
            public final void accept(Object obj) throws Exception {
                this.f$0.m953lambda$tableArea$288$comcollectpointnetvmPatrolVm((BaseListDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda275
            public final void accept(Object obj) throws Exception {
                this.f$0.m954lambda$tableArea$289$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void tableBuy(String str, String str2, String str3, String str4, boolean z, String str5) {
        this.mDisposable = this.mRepository.tableBuy(str, str2, str3, str4, z, str5).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda97
            public final void accept(Object obj) throws Exception {
                this.f$0.m955lambda$tableBuy$311$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda372
            public final void accept(Object obj) throws Exception {
                this.f$0.m956lambda$tableBuy$312$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda276
            public final void accept(Object obj) throws Exception {
                this.f$0.m957lambda$tableBuy$313$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void tableList(String str) {
        tableList("", "", "", str, "1", TimeUtil.MILLISECONDS_OF_ONE_SECOND, 1);
    }

    public void tableList(String str, String str2, String str3, String str4, int i, int i2) {
        tableList(str, str2, str3, str4, "", i, i2);
    }

    public void tableList(String str, String str2, String str3, String str4, String str5, int i, int i2) {
        this.mDisposable = this.mRepository.tableList(str, str2, str3, str4, str5, i, i2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda98
            public final void accept(Object obj) throws Exception {
                this.f$0.m958lambda$tableList$290$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda122
            public final void accept(Object obj) throws Exception {
                this.f$0.m959lambda$tableList$291$comcollectpointnetvmPatrolVm((BaseListDataRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda278
            public final void accept(Object obj) throws Exception {
                this.f$0.m960lambda$tableList$292$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void updateGroup(String str, String str2, List<String> list) {
        this.mDisposable = this.mRepository.updateGroup(str, str2, list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda100
            public final void accept(Object obj) throws Exception {
                this.f$0.m961lambda$updateGroup$147$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda121
            public final void accept(Object obj) throws Exception {
                this.f$0.m962lambda$updateGroup$148$comcollectpointnetvmPatrolVm((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda279
            public final void accept(Object obj) throws Exception {
                this.f$0.m963lambda$updateGroup$149$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void updatePointInfoApi(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final List<FieldListItem> list) {
        ArrayList arrayList = new ArrayList();
        if (EmptyUtils.isNotEmpty(list)) {
            for (FieldListItem fieldListItem : list) {
                if (TextUtils.equals(fieldListItem.getFieldType(), "upload") && EmptyUtils.isNotEmpty(fieldListItem.getFieldValue())) {
                    String[] strArrSplit = fieldListItem.getFieldValue().split(",");
                    if (EmptyUtils.isNotEmpty(strArrSplit)) {
                        arrayList.addAll(Arrays.asList(strArrSplit));
                    }
                }
            }
        }
        if (EmptyUtils.isNotEmpty(arrayList)) {
            this.mDisposable = this.mUploadRepo.rxUploadWxImgs(arrayList, 1, "").flatMap(new Function() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda383
                public final Object apply(Object obj) {
                    return this.f$0.m964lambda$updatePointInfoApi$241$comcollectpointnetvmPatrolVm(list, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, (List) obj);
                }
            }).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda101
                public final void accept(Object obj) throws Exception {
                    this.f$0.m965lambda$updatePointInfoApi$242$comcollectpointnetvmPatrolVm((Disposable) obj);
                }
            }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda380
                public final void accept(Object obj) throws Exception {
                    this.f$0.m966lambda$updatePointInfoApi$243$comcollectpointnetvmPatrolVm(str10, (String) obj);
                }
            }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda280
                public final void accept(Object obj) throws Exception {
                    this.f$0.m967lambda$updatePointInfoApi$244$comcollectpointnetvmPatrolVm((Throwable) obj);
                }
            });
            return;
        }
        if (EmptyUtils.isNotEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                if (TextUtils.equals(list.get(i).getFieldType(), "upload") && EmptyUtils.isNotEmpty(list.get(i).getNetPic())) {
                    list.get(i).setFieldValue(list.get(i).getNetPic());
                }
            }
        }
        this.mDisposable = this.mRepository.updatePointInfoApi(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda102
            public final void accept(Object obj) throws Exception {
                this.f$0.m968lambda$updatePointInfoApi$245$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda381
            public final void accept(Object obj) throws Exception {
                this.f$0.m969lambda$updatePointInfoApi$246$comcollectpointnetvmPatrolVm(str10, (String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda281
            public final void accept(Object obj) throws Exception {
                this.f$0.m970lambda$updatePointInfoApi$247$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void urgedishes(String str, String str2) {
        this.mDisposable = this.mRepository.urgedishes(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda103
            public final void accept(Object obj) throws Exception {
                this.f$0.m971lambda$urgedishes$365$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda373
            public final void accept(Object obj) throws Exception {
                this.f$0.m972lambda$urgedishes$366$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda282
            public final void accept(Object obj) throws Exception {
                this.f$0.m973lambda$urgedishes$367$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void verifyCoupon(Coupon2Res coupon2Res) {
        this.mDisposable = this.mRepository.verifyCoupon(coupon2Res).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda104
            public final void accept(Object obj) throws Exception {
                this.f$0.m974lambda$verifyCoupon$389$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda374
            public final void accept(Object obj) throws Exception {
                this.f$0.m975lambda$verifyCoupon$390$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda283
            public final void accept(Object obj) throws Exception {
                this.f$0.m976lambda$verifyCoupon$391$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void verifyMeituanCoupon(Coupon2Res coupon2Res) {
        this.mDisposable = this.mRepository.verifyMeituanCoupon(coupon2Res).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda105
            public final void accept(Object obj) throws Exception {
                this.f$0.m977lambda$verifyMeituanCoupon$401$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda375
            public final void accept(Object obj) throws Exception {
                this.f$0.m978lambda$verifyMeituanCoupon$402$comcollectpointnetvmPatrolVm(obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda284
            public final void accept(Object obj) throws Exception {
                this.f$0.m979lambda$verifyMeituanCoupon$403$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }

    public void weatherInfoApi(double d, double d2) {
        this.mDisposable = this.mRepository.weatherInfoApi(d, d2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda106
            public final void accept(Object obj) throws Exception {
                this.f$0.m980lambda$weatherInfoApi$222$comcollectpointnetvmPatrolVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda388
            public final void accept(Object obj) throws Exception {
                this.f$0.m981lambda$weatherInfoApi$223$comcollectpointnetvmPatrolVm((WeatherInfoRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.PatrolVm$$ExternalSyntheticLambda285
            public final void accept(Object obj) throws Exception {
                this.f$0.m982lambda$weatherInfoApi$224$comcollectpointnetvmPatrolVm((Throwable) obj);
            }
        });
    }
}
