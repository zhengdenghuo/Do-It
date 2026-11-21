package com.collectpoint.net.repo;

import android.app.Application;
import android.content.Context;
import com.blankj.utilcode.util.CacheDiskUtils;
import com.blankj.utilcode.util.CacheDoubleUtils;
import com.blankj.utilcode.util.CacheMemoryUtils;
import com.collectpoint.bean.PersonnelItem;
import com.collectpoint.bean.PictureType;
import com.collectpoint.bean.ProblemManageRecordAppBean;
import com.collectpoint.bean.UserBean;
import com.collectpoint.bean.item.AddDeviceItem;
import com.collectpoint.bean.item.AlbumItem;
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
import com.collectpoint.bean.item.DiseaseListItem;
import com.collectpoint.bean.item.ExamineObjectListItem;
import com.collectpoint.bean.item.ExamineQuarterListItem;
import com.collectpoint.bean.item.ExamineReportListItem;
import com.collectpoint.bean.item.FieldListItem;
import com.collectpoint.bean.item.FilePathItem;
import com.collectpoint.bean.item.FiveColorWarningReportItem;
import com.collectpoint.bean.item.GetObjectListItem;
import com.collectpoint.bean.item.GroupTypeItem;
import com.collectpoint.bean.item.HighwayPatrolTaskTreeApiItem;
import com.collectpoint.bean.item.InsertPersonnelDeviceRecordItem;
import com.collectpoint.bean.item.MenuItem;
import com.collectpoint.bean.item.NeedToCheckPartListItem;
import com.collectpoint.bean.item.ObjectRoadListItem;
import com.collectpoint.bean.item.OrderDetailListItem;
import com.collectpoint.bean.item.OrderListItem;
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
import com.collectpoint.bean.item.RepairProjectCheckListItem;
import com.collectpoint.bean.item.SelectAttendancePersonnelFenceListByDateItem;
import com.collectpoint.bean.item.SortContentByMapItem;
import com.collectpoint.bean.item.SortContentTreeByMapItem;
import com.collectpoint.bean.item.TableAreaItem;
import com.collectpoint.bean.item.TownPatrolReportListItem;
import com.collectpoint.bean.req.AddDeviceOrderReq;
import com.collectpoint.bean.req.AddOrderCouponReq;
import com.collectpoint.bean.req.ApiTableReq;
import com.collectpoint.bean.req.AutoPatrolSignInReq;
import com.collectpoint.bean.req.BridgeInspectRecordInfoReq;
import com.collectpoint.bean.req.BridgeReq;
import com.collectpoint.bean.req.ChangeNumReq;
import com.collectpoint.bean.req.ClosePatrolEventReq;
import com.collectpoint.bean.req.CollectionObjectInfoReq;
import com.collectpoint.bean.req.CollectionObjectReq;
import com.collectpoint.bean.req.CommentPatrolProblemListReq;
import com.collectpoint.bean.req.CompletedPatrolProblemReq;
import com.collectpoint.bean.req.CouponDyReq;
import com.collectpoint.bean.req.CreateGroupReq;
import com.collectpoint.bean.req.CurrentDatePatrolPersonnelSignInTaskListReq;
import com.collectpoint.bean.req.DictionaryListReq;
import com.collectpoint.bean.req.ExamineObjectListReq;
import com.collectpoint.bean.req.ExamineReportListReq;
import com.collectpoint.bean.req.FiveColorWarningReportReq;
import com.collectpoint.bean.req.FiveColorWarningWorkOrderListReq;
import com.collectpoint.bean.req.GetObjectListReq;
import com.collectpoint.bean.req.HallCart3Req;
import com.collectpoint.bean.req.HallCartReq;
import com.collectpoint.bean.req.HallCartaddReq;
import com.collectpoint.bean.req.HighwayPatrolTaskApiReq;
import com.collectpoint.bean.req.HighwayPatrolTaskCodeApiReq;
import com.collectpoint.bean.req.HighwayPatrolTaskDataApiReq;
import com.collectpoint.bean.req.HighwayPatrolTaskInfoApiReq;
import com.collectpoint.bean.req.HighwayPatrolTaskListApiReq;
import com.collectpoint.bean.req.HighwayPatrolTaskTrajectoryApiReq;
import com.collectpoint.bean.req.HighwayPatrolTaskTreeApiReq;
import com.collectpoint.bean.req.HighwayPatrolTaskingApiReq;
import com.collectpoint.bean.req.IncidentAcceptanceAuditReq;
import com.collectpoint.bean.req.IncidentTailRecordReq;
import com.collectpoint.bean.req.InsertPatrolEventProcessByMySelfReq;
import com.collectpoint.bean.req.InsertPatrolEventReq;
import com.collectpoint.bean.req.InsertPatrolProblemCommentReq;
import com.collectpoint.bean.req.InsertPatrolProblemManageByMyselfReq;
import com.collectpoint.bean.req.InsertPatrolProblemReq;
import com.collectpoint.bean.req.InsertPatrolTaskRecordReq;
import com.collectpoint.bean.req.InsertPatrolTrajectoryReq;
import com.collectpoint.bean.req.InsertPersonnelDeviceRecordReq;
import com.collectpoint.bean.req.IssuePatrolProblemOpinionReq;
import com.collectpoint.bean.req.ManagePatrolEventReq;
import com.collectpoint.bean.req.ManageUnitListReq;
import com.collectpoint.bean.req.MapPatrolPersonnelSignInTaskListReq;
import com.collectpoint.bean.req.MergeTableReq;
import com.collectpoint.bean.req.MoveProductReq;
import com.collectpoint.bean.req.ObjectRoadInfoReq;
import com.collectpoint.bean.req.ObjectRoadListReq;
import com.collectpoint.bean.req.OrderInfo2Req;
import com.collectpoint.bean.req.OrderListReq;
import com.collectpoint.bean.req.PartsDiseaseListReq;
import com.collectpoint.bean.req.PartsDiseaseResultsreq;
import com.collectpoint.bean.req.PatrolEventListApiReq;
import com.collectpoint.bean.req.PatrolEventListReq;
import com.collectpoint.bean.req.PatrolEventStatusListReq;
import com.collectpoint.bean.req.PatrolManageReportListReq;
import com.collectpoint.bean.req.PatrolMapPatrolDataListReq;
import com.collectpoint.bean.req.PatrolMapPatrolTypeListReq;
import com.collectpoint.bean.req.PatrolObjectByMapReq;
import com.collectpoint.bean.req.PatrolObjectTreeByMapReq;
import com.collectpoint.bean.req.PatrolPersonneReq;
import com.collectpoint.bean.req.PatrolPersonnelLocationGroupListReq;
import com.collectpoint.bean.req.PatrolPersonnelRealTimeInfoListReq;
import com.collectpoint.bean.req.PatrolPersonnelReportListReq;
import com.collectpoint.bean.req.PatrolPersonnelSignInPointRecordInfoReq;
import com.collectpoint.bean.req.PatrolPersonnelSignInReq;
import com.collectpoint.bean.req.PatrolPersonnelSignInSavePhotoReq;
import com.collectpoint.bean.req.PatrolProblemIssueOpinionListReq;
import com.collectpoint.bean.req.PatrolProblemPatrolTypeReportListReq;
import com.collectpoint.bean.req.PatrolProblemRecordListReq;
import com.collectpoint.bean.req.PatrolProblemWarningMessageListReq;
import com.collectpoint.bean.req.PatrolReportListReq;
import com.collectpoint.bean.req.PatrolSignInPointRecordListReq;
import com.collectpoint.bean.req.PatrolTaskRecordListApiReq;
import com.collectpoint.bean.req.PersonnelAttendanceRecordReq;
import com.collectpoint.bean.req.PersonnelLocationListReq;
import com.collectpoint.bean.req.PersonnelTrajectoryListReq;
import com.collectpoint.bean.req.PreClosurePatrolProblemReq;
import com.collectpoint.bean.req.ProblemManageListReq;
import com.collectpoint.bean.req.ProblemManageRecordReq;
import com.collectpoint.bean.req.ProblemOperationRecordListReq;
import com.collectpoint.bean.req.ProblemStatusListReq;
import com.collectpoint.bean.req.ProductReq;
import com.collectpoint.bean.req.ProjectOrgProcessAreaReq;
import com.collectpoint.bean.req.ProjectTypeFieldListReq;
import com.collectpoint.bean.req.ProjectTypeListReq;
import com.collectpoint.bean.req.ProjectTypeMenuListReq;
import com.collectpoint.bean.req.RegionByAddressReq;
import com.collectpoint.bean.req.RegionListByMapReq;
import com.collectpoint.bean.req.RepairAcceptanceReq;
import com.collectpoint.bean.req.RepairCheckReq;
import com.collectpoint.bean.req.RepairIncidentReq;
import com.collectpoint.bean.req.RepairProjectCheckRectificationReq;
import com.collectpoint.bean.req.RepairProjectCheckReq;
import com.collectpoint.bean.req.RepairProjectReq;
import com.collectpoint.bean.req.ReportPatrolProblemRecordListReq;
import com.collectpoint.bean.req.ReturnProblemMangeReq;
import com.collectpoint.bean.req.ScanPayReq;
import com.collectpoint.bean.req.SelectAttendancePersonnelFenceListByDateReq;
import com.collectpoint.bean.req.SelectAttendancePersonnelFenceListReq;
import com.collectpoint.bean.req.SortContentByMapReq;
import com.collectpoint.bean.req.SortContentTreeByMapReq;
import com.collectpoint.bean.req.SpecialPatrolProblemRecordListReq;
import com.collectpoint.bean.req.SubmitPersonnelAttendanceReq;
import com.collectpoint.bean.req.SubmitProblemInfoReq;
import com.collectpoint.bean.req.SubmitProblemMangeReq;
import com.collectpoint.bean.req.TableStatusReq;
import com.collectpoint.bean.req.UpdatePatrolProblemAsSpecialProblemReq;
import com.collectpoint.bean.req.VersionReq;
import com.collectpoint.bean.req.VillageRegionListByMapReq;
import com.collectpoint.bean.res.ApiRepairIncidentInfoRes;
import com.collectpoint.bean.res.ApiRepairProjectInfoRes;
import com.collectpoint.bean.res.AutoPatrolSignInRes;
import com.collectpoint.bean.res.BaseDataListRes;
import com.collectpoint.bean.res.BaseDataRes;
import com.collectpoint.bean.res.BaseListDataRes;
import com.collectpoint.bean.res.BaseListRes;
import com.collectpoint.bean.res.BaseResuleRes;
import com.collectpoint.bean.res.BridgeInspectNumberRes;
import com.collectpoint.bean.res.BridgeInspectRecordInfoRes;
import com.collectpoint.bean.res.CollectionTodayApiRes;
import com.collectpoint.bean.res.CoupomRes;
import com.collectpoint.bean.res.Coupon2Res;
import com.collectpoint.bean.res.EndHighwayPatrolTaskRes;
import com.collectpoint.bean.res.ExamineReportListRes;
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
import com.collectpoint.bean.res.PatrolPersonnelReportListRes;
import com.collectpoint.bean.res.PatrolPersonnelSignInPointRecordInfoRes;
import com.collectpoint.bean.res.PatrolProblemIssueOpinionListRes;
import com.collectpoint.bean.res.PatrolProblemWarningMessageListRes;
import com.collectpoint.bean.res.PersonnelAttendanceRecordRes;
import com.collectpoint.bean.res.ProblemManageInfoRes;
import com.collectpoint.bean.res.ProblemManageListRes;
import com.collectpoint.bean.res.ProblemOperationRecordListRes;
import com.collectpoint.bean.res.RecentlyObjectRes;
import com.collectpoint.bean.res.RegionByAddressRes;
import com.collectpoint.bean.res.RepairProjectCheckInfoRes;
import com.collectpoint.bean.res.RestartPatrolTaskRes;
import com.collectpoint.bean.res.ScanPayRes;
import com.collectpoint.bean.res.SelectAttendancePersonnelFenceListRes;
import com.collectpoint.bean.res.SubmitProblemInfoRes;
import com.collectpoint.bean.res.UploadRes;
import com.collectpoint.bean.res.VersionRes;
import com.collectpoint.bean.res.WeatherInfoRes;
import com.collectpoint.constants.Constants;
import com.collectpoint.net.remote.PatrolApi;
import com.collectpoint.utils.EmptyUtils;
import com.google.common.base.Preconditions;
import com.liuwq.base.util.FileTool;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class PatrolRepo {
    private static PatrolRepo sInstance;
    private PatrolApi mApi;
    private CacheDoubleUtils mDoubleCacheUtils;
    private RxHandler mRxHandler;

    private PatrolRepo(PatrolApi patrolApi, Application application) {
        this.mApi = (PatrolApi) Preconditions.checkNotNull(patrolApi);
        Context applicationContext = ((Application) Preconditions.checkNotNull(application)).getApplicationContext();
        this.mRxHandler = RxHandler.getInstance(applicationContext);
        this.mDoubleCacheUtils = CacheDoubleUtils.getInstance(CacheMemoryUtils.getInstance(), CacheDiskUtils.getInstance(FileTool.getDiskCacheDir(applicationContext, Constants.DISK_CACHE_DIR_NAME)));
    }

    public static PatrolRepo getInstance(PatrolApi patrolApi, Application application) {
        if (sInstance == null) {
            synchronized (PatrolRepo.class) {
                if (sInstance == null) {
                    sInstance = new PatrolRepo(patrolApi, application);
                }
            }
        }
        return sInstance;
    }

    private Single<UserBean> getRxCachedUser() {
        return Single.fromCallable(new Callable() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda49
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m339lambda$getRxCachedUser$108$comcollectpointnetrepoPatrolRepo();
            }
        });
    }

    public Single<BaseDataRes<OrderDetailRes>> OrderDetailHome(String str) {
        return this.mApi.OrderDetailHome(new MoveProductReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> PrintBill(String str) {
        return this.mApi.PrintBill(new MoveProductReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> addDeviceOrder(List<AddDeviceItem> list) {
        AddDeviceOrderReq addDeviceOrderReq = new AddDeviceOrderReq();
        addDeviceOrderReq.setProducts(list);
        return this.mApi.addDeviceOrder(addDeviceOrderReq).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> addMeal(final String str, final String str2, final String str3, final String str4, final boolean z, final String str5) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda19
            public final Object apply(Object obj) {
                return this.f$0.m250lambda$addMeal$121$comcollectpointnetrepoPatrolRepo(str, str2, str3, str4, z, str5, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> addOrUpdateProblemManageRecord(final String str, final String str2, final String str3, final List<UploadRes> list, final List<UploadRes> list2, final List<String> list3, final List<String> list4) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda27
            public final Object apply(Object obj) {
                return this.f$0.m251x98d2bf8(str, str2, str3, list, list3, list2, list4, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> addOrderCoupon(AddOrderCouponReq addOrderCouponReq) {
        return this.mApi.addOrderCoupon(addOrderCouponReq).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> apiRepairProjectCheckAudit(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda105
            public final Object apply(Object obj) {
                return this.f$0.m252x1ea5a2af(str2, str, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> apiRepairProjectIncidentAcceptanceAudit(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda106
            public final Object apply(Object obj) {
                return this.f$0.m253x710be771(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> auditPatrolEvent(String str, String str2, String str3) {
        return this.mApi.auditPatrolEvent(new ClosePatrolEventReq(str, str2, str3)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<AutoPatrolSignInRes> autoPatrolSignIn(final String str, final double d, final double d2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda74
            public final Object apply(Object obj) {
                return this.f$0.m254lambda$autoPatrolSignIn$49$comcollectpointnetrepoPatrolRepo(str, d, d2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseListDataRes<List<CategoryItem>>> categoryIndex() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda0
            public final Object apply(Object obj) {
                return this.f$0.m255lambda$categoryIndex$118$comcollectpointnetrepoPatrolRepo((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> changeNum(String str, String str2) {
        return this.mApi.changeNum(new ChangeNumReq(str, str2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> changeTable(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda82
            public final Object apply(Object obj) {
                return this.f$0.m256lambda$changeTable$128$comcollectpointnetrepoPatrolRepo(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseListDataRes<List<TableAreaItem>>> changeTableList(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda22
            public final Object apply(Object obj) {
                return this.f$0.m257lambda$changeTableList$127$comcollectpointnetrepoPatrolRepo(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> closePatrolProblem(String str, String str2) {
        return this.mApi.closePatrolProblem(new ClosePatrolEventReq(str, str2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> closeScan(String str) {
        return this.mApi.closeScan(new HallCartReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<CollectionObjectInfoReq>> collectionObjectInfoApi(String str) {
        return this.mApi.collectionObjectInfoApi(new CollectionObjectReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ProjectObjectFirstListItem>> collectionObjectListApi() {
        return this.mApi.collectionObjectListApi(new InsertPointInfoRes()).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<InsertPointInfoRes> collectionRecordInfoApi(String str) {
        return this.mApi.collectionRecordInfoApi(new SubmitPersonnelAttendanceReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<CollectionTodaItem>> collectionRecordListApi(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda107
            public final Object apply(Object obj) {
                return this.f$0.m258xf37aea51(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<InsertPointInfoRes>> collectionRecordTrackInfoApi(String str) {
        return this.mApi.collectionRecordTrackInfoApi(new SubmitPersonnelAttendanceReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<CollectionTodaItem>> collectionTodayApi(String str, String str2, String str3) {
        return this.mApi.collectionTodayApi(new CollectionTodayApiRes(str, str2, str3)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<CollectionTodaItem>> collectionTodayPointApi() {
        return this.mApi.collectionTodayPointApi(new InsertPointInfoRes()).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<List<CollectionTodaItem>>> collectionTodayTrackApi() {
        return this.mApi.collectionTodayTrackApi(new InsertPointInfoRes()).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> completedPatrolProblem(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda33
            public final Object apply(Object obj) {
                return this.f$0.m259x4d6fd28f(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> createGroup(final String str, final List<String> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda30
            public final Object apply(Object obj) {
                return this.f$0.m260lambda$createGroup$86$comcollectpointnetrepoPatrolRepo(str, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> decomposePatrolPersonnelManage(final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda143
            public final Object apply(Object obj) {
                return this.f$0.m261x24177997(str, str2, str3, str4, str5, str6, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> deleteGroup(final List<String> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda37
            public final Object apply(Object obj) {
                return this.f$0.m262lambda$deleteGroup$88$comcollectpointnetrepoPatrolRepo(list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> deleteTrackListApi(String str, String str2) {
        return this.mApi.deleteTrackListApi(new SubmitPersonnelAttendanceReq(str, str2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<EndHighwayPatrolTaskRes> endHighwayPatrolTaskApi(final String str, final String str2, final String str3, final String str4, final List<HighwayPatrolTaskTrajectoryApiReq> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda15
            public final Object apply(Object obj) {
                return this.f$0.m263x8667e6b0(str, str2, str3, str4, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<ApiRepairIncidentInfoRes> getApiRepairIncidentInfo(String str, String str2) {
        RepairIncidentReq repairIncidentReq = new RepairIncidentReq(str);
        repairIncidentReq.setRepairStatus(str2);
        return this.mApi.getApiRepairIncidentInfo(repairIncidentReq).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ApiRepairIncidentListItem>> getApiRepairIncidentList(String str, String str2) {
        return this.mApi.getApiRepairIncidentList(new RepairIncidentReq(str, str2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<RepairProjectCheckInfoRes> getApiRepairProjectCheckInfo(String str) {
        return this.mApi.getApiRepairProjectCheckInfo(new RepairCheckReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<RepairProjectCheckListItem>> getApiRepairProjectCheckList(String str, String str2) {
        return this.mApi.getApiRepairProjectCheckList(new RepairCheckReq(str, str2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<ApiRepairIncidentInfoRes> getApiRepairProjectIncidentAcceptanceInfo(String str) {
        return this.mApi.getApiRepairProjectIncidentAcceptanceInfo(new RepairAcceptanceReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ApiRepairProjectListItem>> getApiRepairProjectIncidentAcceptanceList(String str, String str2) {
        return this.mApi.getApiRepairProjectIncidentAcceptanceList(new RepairAcceptanceReq(str, str2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<ApiRepairIncidentInfoRes> getApiRepairProjectIncidentInfo(String str, String str2) {
        RepairIncidentReq repairIncidentReq = new RepairIncidentReq(str);
        repairIncidentReq.setRepairStatus(str2);
        return this.mApi.getApiRepairProjectIncidentInfo(repairIncidentReq).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<ApiRepairProjectInfoRes> getApiRepairProjectInfo(String str) {
        return this.mApi.getApiRepairProjectInfo(new RepairProjectReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ApiRepairProjectListItem>> getApiRepairProjectList(String str, String str2) {
        return this.mApi.getApiRepairProjectList(new RepairProjectReq(str, str2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ApiRepairProjectListItem>> getApiRepairProjectList2(String str, String str2) {
        RepairProjectReq repairProjectReq = new RepairProjectReq();
        repairProjectReq.setProjectOrgCode(str);
        repairProjectReq.setProjectStatusStr(str2);
        return this.mApi.getApiRepairProjectList(repairProjectReq).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ProblemStatusListItem>> getAssignTypeList(String str) {
        return this.mApi.getAssignTypeList(new ProjectTypeListReq("", str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ProblemManageListItem>> getAwaitDecomposePatrolProblemList(String str) {
        return this.mApi.getAwaitDecomposePatrolProblemList(new ProblemManageListReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BridgeInspectNumberRes> getBridgeInspectNumber(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda83
            public final Object apply(Object obj) {
                return this.f$0.m264x1eda8449(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BridgeInspectRecordInfoRes> getBridgeInspectRecordInfo(String str) {
        return this.mApi.getBridgeInspectRecordInfo(new ClosePatrolEventReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<BridgeInspectTaskListItem>> getBridgeInspectRecordList(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda7
            public final Object apply(Object obj) {
                return this.f$0.m265x9c405224(str, str2, str3, str4, str5, str6, str7, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<BridgeInspectTaskListItem>> getBridgeInspectTaskList(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda84
            public final Object apply(Object obj) {
                return this.f$0.m266xa6e12c51(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolProblemRecordListItem>> getCommentPatrolProblemList(final String str, final String str2, final String str3, final String str4, final String str5, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda140
            public final Object apply(Object obj) {
                return this.f$0.m267x7b3dddb9(str, str2, str3, str4, str5, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(PatrolRepo$$ExternalSyntheticLambda45.INSTANCE).subscribeOn(Schedulers.io());
    }

    public Single<BaseDataRes<Coupon2Res>> getCouponInfo2(String str, String str2) {
        return this.mApi.getCouponInfo2(new CouponDyReq(str, str2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseDataRes<List<CoupomRes>>> getCouponList(final String str, final String str2, final String str3, final String str4, final List<CouponPayItem> list, final List<CouponPayItem> list2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda16
            public final Object apply(Object obj) {
                return this.f$0.m268lambda$getCouponList$134$comcollectpointnetrepoPatrolRepo(str, str2, str3, str4, list, list2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseDataRes<List<CouponItem>>> getCouponListDy(String str, String str2) {
        MoveProductReq moveProductReq = new MoveProductReq(str);
        moveProductReq.setType(str2);
        return this.mApi.getCouponListDyMt(moveProductReq).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<CurrentDatePatrolPersonnelSignInTaskListItem>> getCurrentDatePatrolPersonnelSignInTaskList(final String str, final double d, final double d2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda75
            public final Object apply(Object obj) {
                return this.f$0.m269x5d6bbff7(str, d, d2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<DeptPatrolReportListItem>> getDeptPatrolReportList(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda108
            public final Object apply(Object obj) {
                return this.f$0.m270xd825c305(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolProblemRecordListItem>> getDeptReportPatrolRecordList(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda2
            public final Object apply(Object obj) {
                return this.f$0.m271x4fe27e3b(str, str2, str3, str4, str5, str6, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(PatrolRepo$$ExternalSyntheticLambda45.INSTANCE).subscribeOn(Schedulers.io());
    }

    public Single<BaseListRes<DeviceCodeItem>> getDeviceCode(String str) {
        return this.mApi.getDeviceCode(new HallCartReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<DictionaryListItem>> getDictionaryList() {
        return this.mApi.getDictionaryList(new DictionaryListReq()).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<DictionaryListItem>> getDictionaryList(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda85
            public final Object apply(Object obj) {
                return this.f$0.m272lambda$getDictionaryList$61$comcollectpointnetrepoPatrolRepo(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ExamineObjectListItem>> getExamineObjectList() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda56
            public final Object apply(Object obj) {
                return this.f$0.m273x4e55593e((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ExamineQuarterListItem>> getExamineQuarterList() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda67
            public final Object apply(Object obj) {
                return this.f$0.m274x9a02a9bf((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ExamineReportListItem>> getExamineReportList(final String str, final String str2, final String str3, final String str4, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda136
            public final Object apply(Object obj) {
                return this.f$0.m275x3337a746(str, str2, str3, str4, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda41
            public final Object apply(Object obj) {
                return ((ExamineReportListRes.Content) obj).getRows();
            }
        }).subscribeOn(Schedulers.io());
    }

    public Single<List<ExamineObjectListItem>> getExamineTypeList() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda78
            public final Object apply(Object obj) {
                return this.f$0.m276x19fa13c2((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<FiveColorWarningReportItem>> getFiveColorWarningReport(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda109
            public final Object apply(Object obj) {
                return this.f$0.m277x57205aa4(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolProblemRecordListItem>> getFiveColorWarningWorkOrderList(final String str, final String str2, final String str3, final String str4, final String str5, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda141
            public final Object apply(Object obj) {
                return this.f$0.m278x81516e02(str, str2, str3, str4, str5, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(PatrolRepo$$ExternalSyntheticLambda45.INSTANCE).subscribeOn(Schedulers.io());
    }

    public Single<BaseDataRes<List<CouponItem>>> getGroupCouponList(final String str, final String str2, final String str3, final String str4, final String str5, final List<CouponPayItem> list, final List<CouponPayItem> list2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda18
            public final Object apply(Object obj) {
                return this.f$0.m279xcc43a258(str, str2, str3, str4, list, list2, str5, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseListRes<GroupTypeItem>> getGroupTypeList() {
        return this.mApi.getGroupTypeList().compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<HighwayPatrolConfigRes> getHighwayPatrolConfig(String str) {
        return this.mApi.getHighwayPatrolConfig(new ProjectOrgProcessAreaReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> getHighwayPatrolTaskCodeApi(final List<String> list, final double d, final double d2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda40
            public final Object apply(Object obj) {
                return this.f$0.m280x6a19aff9(list, d, d2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<HighwayPatrolTaskDataApiRes> getHighwayPatrolTaskDataApi(final String str, final String str2, final String str3, final String str4, final String str5) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda137
            public final Object apply(Object obj) {
                return this.f$0.m281x6c6bccfe(str, str2, str3, str4, str5, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<HighwayPatrolTaskTreeApiItem>> getHighwayPatrolTaskGroupListApi(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda110
            public final Object apply(Object obj) {
                return this.f$0.m282x5c7a3d7(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<HighwayPatrolTaskInfoApiRes> getHighwayPatrolTaskInfoApi(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda44
            public final Object apply(Object obj) {
                return this.f$0.m283x134d58b5(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<HighwayPatrolTaskTreeApiItem>> getHighwayPatrolTaskListApi(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda86
            public final Object apply(Object obj) {
                return this.f$0.m286x1bdb5a26(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<HighwayPatrolTaskTreeApiItem>> getHighwayPatrolTaskListApi(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda112
            public final Object apply(Object obj) {
                return this.f$0.m285xba88bd87(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<HighwayPatrolTaskTreeApiItem>> getHighwayPatrolTaskListApi(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda8
            public final Object apply(Object obj) {
                return this.f$0.m284x593620e8(str, str2, str3, str4, str5, str6, str7, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<HighwayPatrolTaskTreeApiItem>> getHighwayPatrolTaskRecordListApi() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda89
            public final Object apply(Object obj) {
                return this.f$0.m287x4fbd7f38((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<HighwayPatrolTaskStatusNumberRes> getHighwayPatrolTaskStatusNumber() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda100
            public final Object apply(Object obj) {
                return this.f$0.m288xc450d7d3((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<HighwayPatrolTaskTreeApiItem>> getHighwayPatrolTaskTreeApi(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda113
            public final Object apply(Object obj) {
                return this.f$0.m289xda45cfcb(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<HighwayPatrolTaskingApiRes> getHighwayPatrolTaskingApi(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda50
            public final Object apply(Object obj) {
                return this.f$0.m290xb3c1c82f(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<HighwayPatrolTaskingApiRes> getHighwayPatrolTaskingDataApi() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda111
            public final Object apply(Object obj) {
                return this.f$0.m291x7c2c8d44((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ProblemManageListItem>> getHistoryPatrolProblemList(String str) {
        return this.mApi.getHistoryPatrolProblemList(new ProblemManageListReq(str)).compose(this.mRxHandler.handleSingleRes()).map(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda47
            public final Object apply(Object obj) {
                return ((ProblemManageListRes.Content) obj).getRows();
            }
        }).subscribeOn(Schedulers.io());
    }

    public Single<RegionByAddressRes> getLocationInfo(final double d, final double d2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda144
            public final Object apply(Object obj) {
                return this.f$0.m292lambda$getLocationInfo$116$comcollectpointnetrepoPatrolRepo(d, d2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> getLocationStation(String str, double d, double d2) {
        return this.mApi.getLocationStation(new InsertPatrolEventProcessByMySelfReq(str, d, d2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<OrgCodeItem>> getManageUnitList(String str, String str2) {
        return this.mApi.getManageUnitList(new ManageUnitListReq(str, str2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<CurrentDatePatrolPersonnelSignInTaskListItem>> getMapPatrolPersonnelSignInTaskList(final String str, final double d, final double d2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda76
            public final Object apply(Object obj) {
                return this.f$0.m293x719c8909(str, d, d2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseDataRes<Coupon2Res>> getMeiTuanCouponInfo(String str, String str2) {
        return this.mApi.getMeiTuanCouponInfo(new CouponDyReq(str, str2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PersonnelItem>> getNearByPatrolPersonnelList(String str, double d, double d2, String str2) {
        return this.mApi.getNearByPatrolPersonnelList(new PatrolPersonneReq(str, Double.valueOf(d), Double.valueOf(d2), str2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<NeedToCheckPartListItem>> getNeedToCheckPartList(String str, String str2, String str3) {
        return this.mApi.getNeedToCheckPartList(new BridgeInspectRecordInfoReq(str, str2, str3)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<GetObjectListItem>> getObjectList(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda87
            public final Object apply(Object obj) {
                return this.f$0.m295lambda$getObjectList$63$comcollectpointnetrepoPatrolRepo(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<GetObjectListItem>> getObjectList(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda114
            public final Object apply(Object obj) {
                return this.f$0.m294lambda$getObjectList$62$comcollectpointnetrepoPatrolRepo(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<GetObjectListItem>> getObjectListQl(final String str, final String str2, final List<String> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda35
            public final Object apply(Object obj) {
                return this.f$0.m296lambda$getObjectListQl$65$comcollectpointnetrepoPatrolRepo(str2, list, str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<GetObjectListItem>> getObjectListQl11(String str, String str2, String str3) {
        GetObjectListReq getObjectListReq = new GetObjectListReq(str, str2, str3);
        getObjectListReq.setProjectOrgCode(str);
        return this.mApi.getObjectList(getObjectListReq).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<GetObjectListItem>> getObjectListSj(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda115
            public final Object apply(Object obj) {
                return this.f$0.m297lambda$getObjectListSj$64$comcollectpointnetrepoPatrolRepo(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<ObjectRoadInfoRes> getObjectRoadInfo(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda51
            public final Object apply(Object obj) {
                return this.f$0.m298xa1bd1a98(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ObjectRoadListItem>> getObjectRoadList(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda116
            public final Object apply(Object obj) {
                return this.f$0.m299xafb6009(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<OnlineStatusRes> getOnlineStatus(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda52
            public final Object apply(Object obj) {
                return this.f$0.m300lambda$getOnlineStatus$114$comcollectpointnetrepoPatrolRepo(str, (UserBean) obj);
            }
        }).subscribeOn(Schedulers.io());
    }

    public Single<BaseDataRes<OrderInfoRes>> getOrderInfo(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda117
            public final Object apply(Object obj) {
                return this.f$0.m301lambda$getOrderInfo$130$comcollectpointnetrepoPatrolRepo(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseDataRes<List<CoupomRes>>> getPackCouponList(final String str, final String str2, final String str3, final String str4, final List<CouponPayItem> list, final List<CouponPayItem> list2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda17
            public final Object apply(Object obj) {
                return this.f$0.m302xf59d9c8d(str, str2, str3, str4, list, list2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PartsDiseaseListItem>> getPartsDiseaseList(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda88
            public final Object apply(Object obj) {
                return this.f$0.m303xd526e300(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PartsDiseaseListItem>> getPartsDiseaseList(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda118
            public final Object apply(Object obj) {
                return this.f$0.m304x36797f9f(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PartsDiseaseResultsItem>> getPartsDiseaseResults(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda90
            public final Object apply(Object obj) {
                return this.f$0.m305xe9232a0c(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolEventListItem>> getPatrolEventList(final String str, final String str2, final String str3, final String str4, final String str5) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda138
            public final Object apply(Object obj) {
                return this.f$0.m306xb53b6f52(str, str2, str3, str4, str5, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolEventListApiItem>> getPatrolEventListApi() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda122
            public final Object apply(Object obj) {
                return this.f$0.m307x390733f5((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolEventStatusListItem>> getPatrolEventStatusList(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda53
            public final Object apply(Object obj) {
                return this.f$0.m308xc2e6f8df(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolManageReportListItem>> getPatrolManageReportList(final String str, final String str2, final String str3, final String str4) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda130
            public final Object apply(Object obj) {
                return this.f$0.m309x587051c6(str, str2, str3, str4, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolMapPatrolDataListItem>> getPatrolMapPatrolDataList(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda119
            public final Object apply(Object obj) {
                return this.f$0.m310xe2ee487c(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolMapPatrolTypeListItem>> getPatrolMapPatrolTypeList(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda54
            public final Object apply(Object obj) {
                return this.f$0.m311xa65e336d(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolObjectByMapItem>> getPatrolObjectByMap(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda120
            public final Object apply(Object obj) {
                return this.f$0.m312x9fd48701(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolObjectTreeByMapItem>> getPatrolObjectTreeByMap(final String str, final String str2, final String str3, final String str4) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda131
            public final Object apply(Object obj) {
                return this.f$0.m313xb6e33dad(str, str2, str3, str4, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> getPatrolPersonnelLocationGroupList(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda55
            public final Object apply(Object obj) {
                return this.f$0.m314xac34115b(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolPersonnelRealTimeInfoListItem>> getPatrolPersonnelRealTimeInfoList(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda91
            public final Object apply(Object obj) {
                return this.f$0.m315x49f7f13a(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolPersonnelReportListItem>> getPatrolPersonnelReportList(final String str, final String str2, final String str3, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda129
            public final Object apply(Object obj) {
                return this.f$0.m316x345200b6(str, str2, str3, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda42
            public final Object apply(Object obj) {
                return ((PatrolPersonnelReportListRes.Content) obj).getRows();
            }
        }).subscribeOn(Schedulers.io());
    }

    public Single<PatrolPersonnelSignInPointRecordInfoRes> getPatrolPersonnelSignInPointRecordInfo(final String str, final String str2, final double d, final double d2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda104
            public final Object apply(Object obj) {
                return this.f$0.m317xc05537c2(str, str2, d, d2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolProblemIssueOpinionListItem>> getPatrolProblemIssueOpinionList(final String str, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda80
            public final Object apply(Object obj) {
                return this.f$0.m318x5e5a6972(str, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda43
            public final Object apply(Object obj) {
                return ((PatrolProblemIssueOpinionListRes.Content) obj).getRows();
            }
        }).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolProblemPatrolTypeReportListItem>> getPatrolProblemPatrolTypeReportList(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda121
            public final Object apply(Object obj) {
                return this.f$0.m319x547cc81b(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolProblemRecordListItem>> getPatrolProblemRecordList(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda9
            public final Object apply(Object obj) {
                return this.f$0.m320xff2b5e38(str, str2, str3, str4, str5, str6, str7, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(PatrolRepo$$ExternalSyntheticLambda45.INSTANCE).subscribeOn(Schedulers.io());
    }

    public Single<PatrolProblemWarningMessageListRes> getPatrolProblemWarningMessageList(final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda11
            public final Object apply(Object obj) {
                return this.f$0.m321x6f92daca(i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolProblemRecordListItem>> getPatrolTypeReportPatrolRecordList(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda3
            public final Object apply(Object obj) {
                return this.f$0.m322x1a1c60d6(str, str2, str3, str4, str5, str6, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(PatrolRepo$$ExternalSyntheticLambda45.INSTANCE).subscribeOn(Schedulers.io());
    }

    public Single<BaseDataRes<List<CouponItem>>> getPaymentMethod(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda57
            public final Object apply(Object obj) {
                return this.f$0.m323lambda$getPaymentMethod$131$comcollectpointnetrepoPatrolRepo(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<PersonnelAttendanceRecordRes> getPersonnelAttendanceRecord(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda58
            public final Object apply(Object obj) {
                return this.f$0.m324x6824900f(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PersonnelLocationListItem>> getPersonnelLocationList(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda92
            public final Object apply(Object obj) {
                return this.f$0.m325xf2a5a20a(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<CurrentDatePatrolPersonnelSignInTaskListItem>> getPersonnelSignInRecordList(final String str, final String str2, final String str3, final double d, final double d2, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda126
            public final Object apply(Object obj) {
                return this.f$0.m326x596f4069(str, str2, str3, d, d2, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(PatrolRepo$$ExternalSyntheticLambda46.INSTANCE).subscribeOn(Schedulers.io());
    }

    public Single<List<PersonnelTrajectoryListItem>> getPersonnelTrajectoryList(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda123
            public final Object apply(Object obj) {
                return this.f$0.m327xd4ff07bb(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<ProblemManageInfoRes> getProblemManageInfo(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda59
            public final Object apply(Object obj) {
                return this.f$0.m328x58f35665(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ProblemManageListItem>> getProblemManageList(String str) {
        ProblemManageListReq problemManageListReq = new ProblemManageListReq(str);
        problemManageListReq.setDecomposeTypes("YHGS,ZF,QT");
        return this.mApi.getProblemManageList(problemManageListReq).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ProblemOperationRecordListItem>> getProblemOperationRecordList(final String str, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda81
            public final Object apply(Object obj) {
                return this.f$0.m329x26a5563d(str, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda48
            public final Object apply(Object obj) {
                return ((ProblemOperationRecordListRes.Content) obj).getRows();
            }
        }).subscribeOn(Schedulers.io());
    }

    public Single<List<ProblemStatusListItem>> getProblemStatusList() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda133
            public final Object apply(Object obj) {
                return this.f$0.m330x58e53de6((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ProjectOrgProcessAreaItem>> getProjectOrgProcessArea(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda60
            public final Object apply(Object obj) {
                return this.f$0.m331xe0b09ecd(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ProjectTypeListItem>> getProjectQSTypeList(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda93
            public final Object apply(Object obj) {
                return this.f$0.m332x511f4b45(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ProjectTypeFieldListItem>> getProjectTypeFieldList(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda61
            public final Object apply(Object obj) {
                return this.f$0.m333xc4786428(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ProjectTypeListItem>> getProjectTypeList(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda62
            public final Object apply(Object obj) {
                return this.f$0.m334lambda$getProjectTypeList$6$comcollectpointnetrepoPatrolRepo(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<MenuItem>> getProjectTypeMenuList(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda94
            public final Object apply(Object obj) {
                return this.f$0.m335xc9281966(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<RecentlyObjectRes> getRecentlyObjectApi(final String str, final double d, final double d2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda77
            public final Object apply(Object obj) {
                return this.f$0.m336x2d0f7fb0(str, d, d2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<RegionByAddressRes> getRegionByAddress(String str, double d, double d2) {
        return this.mApi.getRegionByAddress(new RegionByAddressReq(str, d, d2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<RegionListByMapItem>> getRegionListByMap(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda95
            public final Object apply(Object obj) {
                return this.f$0.m337lambda$getRegionListByMap$2$comcollectpointnetrepoPatrolRepo(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ProvinceListItem>> getRegionTreeByMap(String str) {
        return this.mApi.getRegionTreeByMap(new PatrolEventStatusListReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolProblemRecordListItem>> getReportPatrolProblemRecordList(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda4
            public final Object apply(Object obj) {
                return this.f$0.m338x56945e1c(str, str2, str3, str4, str5, str6, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(PatrolRepo$$ExternalSyntheticLambda45.INSTANCE).subscribeOn(Schedulers.io());
    }

    public Single<List<CurrentDatePatrolPersonnelSignInTaskListItem>> getSignInPointSignInRecordList(final String str, final String str2, final String str3, final double d, final double d2, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda127
            public final Object apply(Object obj) {
                return this.f$0.m340xa9fdacd8(str, str2, str3, d, d2, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(PatrolRepo$$ExternalSyntheticLambda46.INSTANCE).subscribeOn(Schedulers.io());
    }

    public Single<List<SortContentByMapItem>> getSortContentByMap(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda63
            public final Object apply(Object obj) {
                return this.f$0.m341x34d7d760(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<SortContentTreeByMapItem>> getSortContentTreeByMap(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda96
            public final Object apply(Object obj) {
                return this.f$0.m342x142a8631(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolProblemRecordListItem>> getSpecialPatrolProblemRecordList(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda5
            public final Object apply(Object obj) {
                return this.f$0.m343x1cb388b1(str, str2, str3, str4, str5, str6, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(PatrolRepo$$ExternalSyntheticLambda45.INSTANCE).subscribeOn(Schedulers.io());
    }

    public Single<SubmitProblemInfoRes> getSubmitProblemInfo(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda64
            public final Object apply(Object obj) {
                return this.f$0.m344x806e70a(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseDataRes<TableStatusReq>> getTableStatusNum() {
        return this.mApi.getTableStatusNum(new ApiTableReq()).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ProblemManageListItem>> getToCompletedPatrolProblemList(String str) {
        ProblemManageListReq problemManageListReq = new ProblemManageListReq(str);
        problemManageListReq.setDecomposeTypes("YHGS,ZF,QT");
        return this.mApi.getToCompletedPatrolProblemList(problemManageListReq).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<TownPatrolReportListItem>> getTownPatrolReportList(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda124
            public final Object apply(Object obj) {
                return this.f$0.m345x39d280f1(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<PatrolProblemRecordListItem>> getTownReportPatrolRecordList(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda6
            public final Object apply(Object obj) {
                return this.f$0.m346x1cf24e67(str, str2, str3, str4, str5, str6, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(PatrolRepo$$ExternalSyntheticLambda45.INSTANCE).subscribeOn(Schedulers.io());
    }

    public Single<BaseDataRes<VersionRes>> getVensionInfo(String str) {
        return this.mApi.getVensionInfo(new VersionReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<RegionListByMapItem>> getVillageRegionListByMap(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda97
            public final Object apply(Object obj) {
                return this.f$0.m347x5977eb86(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> hallCartAdd(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda12
            public final Object apply(Object obj) {
                return this.f$0.m348lambda$hallCartAdd$120$comcollectpointnetrepoPatrolRepo(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> hallCartCancel(String str) {
        return this.mApi.hallCartCancel(new HallCartReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> hallCartDelete(String str) {
        return this.mApi.hallCartDelete(new HallCartReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<HallCartlistRes> hallCartList(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda65
            public final Object apply(Object obj) {
                return this.f$0.m349lambda$hallCartList$123$comcollectpointnetrepoPatrolRepo(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> hallCartSub(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda98
            public final Object apply(Object obj) {
                return this.f$0.m350lambda$hallCartSub$124$comcollectpointnetrepoPatrolRepo(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BridgeInspectTaskListItem> highwayPatrolTaskTimeJudge(final List<String> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda38
            public final Object apply(Object obj) {
                return this.f$0.m351x2ca9af00(list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<IndexIndexRes> indexIndex() {
        return this.mApi.indexIndex(new HallCartReq()).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertBridgeInspectEvent(final String str, final String str2, final String str3, final String str4, final String str5, final double d, final double d2, final String str6, final List<DiseaseListItem> list, final List<FilePathItem> list2, final String str7, final String str8) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda139
            public final Object apply(Object obj) {
                return this.f$0.m352x25bd5bfe(str, str2, str3, str4, str5, d, d2, str6, list, str7, list2, str8, (UserBean) obj);
            }
        }).subscribeOn(Schedulers.io());
    }

    public Single<String> insertHighwayPatrolTaskRecord(final String str, final String str2, final String str3, final List<String> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda21
            public final Object apply(Object obj) {
                return this.f$0.m353x9ad5a706(str, str2, str3, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<InsertPatrolTrajectoryReq> insertHighwayPatrolTaskTrajectoryListApi(final String str, final String str2, final List<HighwayPatrolTaskTrajectoryApiReq> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda28
            public final Object apply(Object obj) {
                return this.f$0.m354xe68eeb9(str, str2, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertPatrolEvent(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final double d, final double d2, final String str9, final List<DiseaseListItem> list, final List<UploadRes> list2, final String str10, final String str11, final String str12) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda10
            public final Object apply(Object obj) {
                return this.f$0.m355lambda$insertPatrolEvent$60$comcollectpointnetrepoPatrolRepo(str, str2, str3, str4, str5, str6, str7, str8, d, d2, str9, str10, str11, list2, list, str12, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertPatrolEventProcessByMySelf(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, double d, double d2, String str9, String str10, DiseaseListItem diseaseListItem, List<String> list, List<String> list2, List<String> list3, List<UploadRes> list4, List<UploadRes> list5, String str11, String str12, String str13) {
        InsertPatrolEventProcessByMySelfReq insertPatrolEventProcessByMySelfReq = new InsertPatrolEventProcessByMySelfReq(str, str2, str3, str4, str5, str6, str7, str8, d, d2, str9, str10, str11, str12);
        if (list4 != null && !list4.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (EmptyUtils.isNotEmpty(list)) {
                for (String str14 : list) {
                    String strSubstring = str14.substring(str14.lastIndexOf("/") + 1);
                    for (UploadRes uploadRes : list4) {
                        if (strSubstring.equals(uploadRes.getLocalFileName())) {
                            arrayList.add(new FilePathItem(uploadRes.getObject()));
                        }
                    }
                }
                diseaseListItem.setPhotoList(arrayList);
            }
            if (EmptyUtils.isNotEmpty(list2)) {
                for (String str15 : list2) {
                    String strSubstring2 = str15.substring(str15.lastIndexOf("/") + 1);
                    for (UploadRes uploadRes2 : list4) {
                        if (strSubstring2.equals(uploadRes2.getLocalFileName())) {
                            arrayList2.add(new FilePathItem(uploadRes2.getObject()));
                        }
                    }
                }
                insertPatrolEventProcessByMySelfReq.setProcessPhotoList(arrayList2);
            }
        }
        if (list5 != null && !list5.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<UploadRes> it = list5.iterator();
            while (it.hasNext()) {
                arrayList3.add(new FilePathItem(it.next().getObject()));
            }
            insertPatrolEventProcessByMySelfReq.setProcessVideoList(arrayList3);
        }
        insertPatrolEventProcessByMySelfReq.setDisease(diseaseListItem);
        insertPatrolEventProcessByMySelfReq.setTimeLimete(str13);
        return this.mApi.insertPatrolEventProcessByMySelf(insertPatrolEventProcessByMySelfReq).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertPatrolProblem(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, final List<UploadRes> list, final List<UploadRes> list2, final double d, final double d2, final List<PictureType> list3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda14
            public final Object apply(Object obj) {
                return this.f$0.m356xc28d27a4(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, d, d2, list, list3, list2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertPatrolProblemComment(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda99
            public final Object apply(Object obj) {
                return this.f$0.m357x3e8ac0e(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertPatrolProblemManageByMyself(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, final String str12, final List<String> list, final List<String> list2, final List<String> list3, final List<String> list4, final List<UploadRes> list5, final List<UploadRes> list6, final double d, final double d2, final List<PictureType> list7, final List<PictureType> list8) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda13
            public final Object apply(Object obj) {
                return this.f$0.m358xddad469c(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, d, d2, str12, list5, list, list7, list2, list8, list6, list3, list4, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertPersonnelDeviceRecord(List<InsertPersonnelDeviceRecordItem> list) {
        return this.mApi.insertPersonnelDeviceRecord(new InsertPersonnelDeviceRecordReq(list)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertPointInfoApi(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<FieldListItem> list) {
        return this.mApi.insertPointInfoApi(new InsertPointInfoRes(str, str2, str3, str4, str5, str6, str7, str8, str9, list)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertRepairProjectCheck(final String str, final String str2, final String str3, final String str4, final double d, final double d2, final List<String> list, final List<String> list2, final List<String> list3, final List<String> list4) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda135
            public final Object apply(Object obj) {
                return this.f$0.m359x54a9729e(str, str2, str3, str4, d, d2, list, list2, list3, list4, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertRepairProjectCheckRectification(final String str, final String str2, final String str3, final List<UploadRes> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda23
            public final Object apply(Object obj) {
                return this.f$0.m360xefb6e273(str, str2, str3, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertRepairProjectIncidentAcceptanceManage(final String str, final List<UploadRes> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda31
            public final Object apply(Object obj) {
                return this.f$0.m361xd0930259(str, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertRepairProjectIncidentManageRecord(final String str, final List<UploadRes> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda32
            public final Object apply(Object obj) {
                return this.f$0.m362x1c305511(str, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertRepairProjectIncidentTailRecord(final String str, final String str2, final String str3, final List<UploadRes> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda24
            public final Object apply(Object obj) {
                return this.f$0.m363xabcf1e1d(str, str2, str3, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertTrackListApi(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List<PointItem> list, String str9) {
        InsertPointInfoRes insertPointInfoRes = new InsertPointInfoRes(str, str2, str3, str4, str5, str6, str7, str8, str9);
        insertPointInfoRes.setPointList(list);
        return this.mApi.insertTrackListApi(insertPointInfoRes).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> issuePatrolProblemOpinion(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda101
            public final Object apply(Object obj) {
                return this.f$0.m364x1c8f5e3b(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    /* renamed from: lambda$addMeal$121$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m250lambda$addMeal$121$comcollectpointnetrepoPatrolRepo(String str, String str2, String str3, String str4, boolean z, String str5, UserBean userBean) throws Exception {
        return this.mApi.addMeal(new HallCartaddReq(str, str2, str3, "", str4, z, str5));
    }

    /* renamed from: lambda$addOrUpdateProblemManageRecord$9$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m251x98d2bf8(String str, String str2, String str3, List list, List list2, List list3, List list4, UserBean userBean) throws Exception {
        ProblemManageRecordReq problemManageRecordReq = new ProblemManageRecordReq(userBean.getUserCode(), str, str2, str3);
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new FilePathItem(((UploadRes) it.next()).getObject()));
            }
        }
        if (EmptyUtils.isNotEmpty(list2)) {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(new FilePathItem((String) it2.next()));
            }
        }
        problemManageRecordReq.setPhotoList(arrayList);
        ArrayList arrayList2 = new ArrayList();
        if (list3 != null && !list3.isEmpty()) {
            Iterator it3 = list3.iterator();
            while (it3.hasNext()) {
                arrayList2.add(new FilePathItem(((UploadRes) it3.next()).getObject()));
            }
        }
        if (EmptyUtils.isNotEmpty(list4)) {
            Iterator it4 = list4.iterator();
            while (it4.hasNext()) {
                arrayList2.add(new FilePathItem((String) it4.next()));
            }
        }
        problemManageRecordReq.setVideoList(arrayList2);
        return this.mApi.addOrUpdateProblemManageRecord(problemManageRecordReq);
    }

    /* renamed from: lambda$apiRepairProjectCheckAudit$67$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m252x1ea5a2af(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.apiRepairProjectCheckAudit(new RepairCheckReq(str, str2, userBean.getUserCode(), userBean.getNickName(), str3));
    }

    /* renamed from: lambda$apiRepairProjectIncidentAcceptanceAudit$66$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m253x710be771(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.apiRepairProjectIncidentAcceptanceAudit(new IncidentAcceptanceAuditReq(str, userBean.getUserCode(), userBean.getNickName(), str2, str3));
    }

    /* renamed from: lambda$autoPatrolSignIn$49$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m254lambda$autoPatrolSignIn$49$comcollectpointnetrepoPatrolRepo(String str, double d, double d2, UserBean userBean) throws Exception {
        return this.mApi.autoPatrolSignIn(new AutoPatrolSignInReq(userBean.getUserCode(), str, d, d2));
    }

    /* renamed from: lambda$categoryIndex$118$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m255lambda$categoryIndex$118$comcollectpointnetrepoPatrolRepo(UserBean userBean) throws Exception {
        return this.mApi.categoryIndex(new ApiTableReq());
    }

    /* renamed from: lambda$changeTable$128$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m256lambda$changeTable$128$comcollectpointnetrepoPatrolRepo(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.changeTable(new HallCartaddReq(str, str2));
    }

    /* renamed from: lambda$changeTableList$127$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m257lambda$changeTableList$127$comcollectpointnetrepoPatrolRepo(String str, UserBean userBean) throws Exception {
        return this.mApi.changeTableList(new HallCartReq(str));
    }

    /* renamed from: lambda$collectionRecordListApi$115$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m258xf37aea51(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.collectionRecordListApi(new CollectionObjectReq(str, str2, str3));
    }

    /* renamed from: lambda$completedPatrolProblem$26$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m259x4d6fd28f(String str, UserBean userBean) throws Exception {
        return this.mApi.completedPatrolProblem(new CompletedPatrolProblemReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$createGroup$86$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m260lambda$createGroup$86$comcollectpointnetrepoPatrolRepo(String str, List list, UserBean userBean) throws Exception {
        return this.mApi.createGroup(new CreateGroupReq(userBean.getUserCode(), str, list));
    }

    /* renamed from: lambda$decomposePatrolPersonnelManage$109$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m261x24177997(String str, String str2, String str3, String str4, String str5, String str6, UserBean userBean) throws Exception {
        return this.mApi.decomposePatrolPersonnelManage(new ApiRepairIncidentListItem(str, str2, str3, str4, str5, str6));
    }

    /* renamed from: lambda$deleteGroup$88$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m262lambda$deleteGroup$88$comcollectpointnetrepoPatrolRepo(List list, UserBean userBean) throws Exception {
        return this.mApi.deleteGroup(new CreateGroupReq(userBean.getUserCode(), list));
    }

    /* renamed from: lambda$endHighwayPatrolTaskApi$80$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m263x8667e6b0(String str, String str2, String str3, String str4, List list, UserBean userBean) throws Exception {
        return this.mApi.endHighwayPatrolTaskApi(new HighwayPatrolTaskApiReq(str, str2, userBean.getUserCode(), str3, str4, list));
    }

    /* renamed from: lambda$getBridgeInspectNumber$112$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m264x1eda8449(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getBridgeInspectNumber(new BridgeReq(userBean.getUserCode(), str, str2));
    }

    /* renamed from: lambda$getBridgeInspectRecordList$111$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m265x9c405224(String str, String str2, String str3, String str4, String str5, String str6, String str7, UserBean userBean) throws Exception {
        return this.mApi.getBridgeInspectRecordList(new BridgeReq(userBean.getUserCode(), str, str2, str3, str4, str5, str6, str7));
    }

    /* renamed from: lambda$getBridgeInspectTaskList$110$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m266xa6e12c51(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getBridgeInspectTaskList(new BridgeReq(userBean.getUserCode(), str, str2));
    }

    /* renamed from: lambda$getCommentPatrolProblemList$33$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m267x7b3dddb9(String str, String str2, String str3, String str4, String str5, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getCommentPatrolProblemList(new CommentPatrolProblemListReq(userBean.getUserCode(), str, str2, str3, str4, str5, i, i2));
    }

    /* renamed from: lambda$getCouponList$134$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m268lambda$getCouponList$134$comcollectpointnetrepoPatrolRepo(String str, String str2, String str3, String str4, List list, List list2, UserBean userBean) throws Exception {
        return this.mApi.getCouponList(new OrderInfo2Req(str, str2, str3, "", str4, list, list2));
    }

    /* renamed from: lambda$getCurrentDatePatrolPersonnelSignInTaskList$46$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m269x5d6bbff7(String str, double d, double d2, UserBean userBean) throws Exception {
        return this.mApi.getCurrentDatePatrolPersonnelSignInTaskList(new CurrentDatePatrolPersonnelSignInTaskListReq(userBean.getUserCode(), str, d, d2));
    }

    /* renamed from: lambda$getDeptPatrolReportList$16$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m270xd825c305(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getDeptPatrolReportList(new PatrolReportListReq(userBean.getUserCode(), str, str2, str3));
    }

    /* renamed from: lambda$getDeptReportPatrolRecordList$22$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m271x4fe27e3b(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getDeptReportPatrolRecordList(new PatrolProblemRecordListReq(userBean.getUserCode(), str, str2, str3, str4, str5, str6, i, i2));
    }

    /* renamed from: lambda$getDictionaryList$61$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m272lambda$getDictionaryList$61$comcollectpointnetrepoPatrolRepo(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getDictionaryList(new DictionaryListReq(str, str2));
    }

    /* renamed from: lambda$getExamineObjectList$102$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m273x4e55593e(UserBean userBean) throws Exception {
        return this.mApi.getExamineObjectList(new ExamineObjectListReq(userBean.getUserCode()));
    }

    /* renamed from: lambda$getExamineQuarterList$104$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m274x9a02a9bf(UserBean userBean) throws Exception {
        return this.mApi.getExamineQuarterList(new ExamineObjectListReq(userBean.getUserCode()));
    }

    /* renamed from: lambda$getExamineReportList$105$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m275x3337a746(String str, String str2, String str3, String str4, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getExamineReportList(new ExamineReportListReq(str, str2, str3, str4, i, i2));
    }

    /* renamed from: lambda$getExamineTypeList$103$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m276x19fa13c2(UserBean userBean) throws Exception {
        return this.mApi.getExamineTypeList(new ExamineObjectListReq(userBean.getUserCode()));
    }

    /* renamed from: lambda$getFiveColorWarningReport$24$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m277x57205aa4(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getFiveColorWarningReport(new FiveColorWarningReportReq(userBean.getUserCode(), str, str2, str3));
    }

    /* renamed from: lambda$getFiveColorWarningWorkOrderList$25$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m278x81516e02(String str, String str2, String str3, String str4, String str5, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getFiveColorWarningWorkOrderList(new FiveColorWarningWorkOrderListReq(userBean.getUserCode(), str, str2, str3, str4, str5, i, i2));
    }

    /* renamed from: lambda$getGroupCouponList$136$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m279xcc43a258(String str, String str2, String str3, String str4, List list, List list2, String str5, UserBean userBean) throws Exception {
        OrderInfo2Req orderInfo2Req = new OrderInfo2Req(str, str2, str3, str4, "", list, list2);
        orderInfo2Req.setPlat_source_id(str5);
        return this.mApi.getGroupCouponList(orderInfo2Req);
    }

    /* renamed from: lambda$getHighwayPatrolTaskCodeApi$96$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m280x6a19aff9(List list, double d, double d2, UserBean userBean) throws Exception {
        return this.mApi.getHighwayPatrolTaskCodeApi(new HighwayPatrolTaskCodeApiReq(userBean.getUserCode(), (List<String>) list, d, d2));
    }

    /* renamed from: lambda$getHighwayPatrolTaskDataApi$83$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m281x6c6bccfe(String str, String str2, String str3, String str4, String str5, UserBean userBean) throws Exception {
        return this.mApi.getHighwayPatrolTaskDataApi(new HighwayPatrolTaskDataApiReq(userBean.getUserCode(), str, str2, str3, str4, str5));
    }

    /* renamed from: lambda$getHighwayPatrolTaskGroupListApi$92$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m282x5c7a3d7(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getHighwayPatrolTaskGroupListApi(new HighwayPatrolTaskTreeApiReq(userBean.getUserCode(), str, str2, str3));
    }

    /* renamed from: lambda$getHighwayPatrolTaskInfoApi$77$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m283x134d58b5(String str, UserBean userBean) throws Exception {
        return this.mApi.getHighwayPatrolTaskInfoApi(new HighwayPatrolTaskInfoApiReq(str));
    }

    /* renamed from: lambda$getHighwayPatrolTaskListApi$74$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m284x593620e8(String str, String str2, String str3, String str4, String str5, String str6, String str7, UserBean userBean) throws Exception {
        return this.mApi.getHighwayPatrolTaskListApi(new HighwayPatrolTaskListApiReq(userBean.getUserCode(), str, str2, str3, str4, str5, str6, str7));
    }

    /* renamed from: lambda$getHighwayPatrolTaskListApi$75$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m285xba88bd87(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getHighwayPatrolTaskListApi(new HighwayPatrolTaskListApiReq(userBean.getUserCode(), str, str2, str3));
    }

    /* renamed from: lambda$getHighwayPatrolTaskListApi$76$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m286x1bdb5a26(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getHighwayPatrolTaskListApi(new HighwayPatrolTaskListApiReq(userBean.getUserCode(), str, str2));
    }

    /* renamed from: lambda$getHighwayPatrolTaskRecordListApi$95$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m287x4fbd7f38(UserBean userBean) throws Exception {
        return this.mApi.getHighwayPatrolTaskRecordListApi(new PatrolTaskRecordListApiReq(userBean.getUserCode()));
    }

    /* renamed from: lambda$getHighwayPatrolTaskStatusNumber$94$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m288xc450d7d3(UserBean userBean) throws Exception {
        return this.mApi.getHighwayPatrolTaskStatusNumber(new HighwayPatrolTaskTreeApiReq(userBean.getUserCode()));
    }

    /* renamed from: lambda$getHighwayPatrolTaskTreeApi$93$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m289xda45cfcb(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getHighwayPatrolTaskTreeApi(new HighwayPatrolTaskTreeApiReq(userBean.getUserCode(), str, str2, str3));
    }

    /* renamed from: lambda$getHighwayPatrolTaskingApi$84$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m290xb3c1c82f(String str, UserBean userBean) throws Exception {
        return this.mApi.getHighwayPatrolTaskingApi(new HighwayPatrolTaskingApiReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$getHighwayPatrolTaskingDataApi$85$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m291x7c2c8d44(UserBean userBean) throws Exception {
        return this.mApi.getHighwayPatrolTaskingDataApi(new HighwayPatrolTaskingApiReq(userBean.getUserCode()));
    }

    /* renamed from: lambda$getLocationInfo$116$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m292lambda$getLocationInfo$116$comcollectpointnetrepoPatrolRepo(double d, double d2, UserBean userBean) throws Exception {
        return this.mApi.getLocationInfo(new AutoPatrolSignInReq(d, d2));
    }

    /* renamed from: lambda$getMapPatrolPersonnelSignInTaskList$50$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m293x719c8909(String str, double d, double d2, UserBean userBean) throws Exception {
        return this.mApi.getMapPatrolPersonnelSignInTaskList(new MapPatrolPersonnelSignInTaskListReq(userBean.getUserCode(), str, d, d2));
    }

    /* renamed from: lambda$getObjectList$62$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m294lambda$getObjectList$62$comcollectpointnetrepoPatrolRepo(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getObjectList(new GetObjectListReq(userBean.getUserCode(), str, str2, str3));
    }

    /* renamed from: lambda$getObjectList$63$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m295lambda$getObjectList$63$comcollectpointnetrepoPatrolRepo(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getObjectList(new GetObjectListReq(userBean.getUserCode(), str, str2, ""));
    }

    /* renamed from: lambda$getObjectListQl$65$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m296lambda$getObjectListQl$65$comcollectpointnetrepoPatrolRepo(String str, List list, String str2, UserBean userBean) throws Exception {
        GetObjectListReq getObjectListReq = new GetObjectListReq(str, list);
        getObjectListReq.setProjectOrgCode(str2);
        return this.mApi.getObjectList(getObjectListReq);
    }

    /* renamed from: lambda$getObjectListSj$64$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m297lambda$getObjectListSj$64$comcollectpointnetrepoPatrolRepo(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getObjectList(new GetObjectListReq(userBean.getUserCode(), str, str2, str3));
    }

    /* renamed from: lambda$getObjectRoadInfo$107$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m298xa1bd1a98(String str, UserBean userBean) throws Exception {
        return this.mApi.getObjectRoadInfo(new ObjectRoadInfoReq(str));
    }

    /* renamed from: lambda$getObjectRoadList$106$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m299xafb6009(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getObjectRoadList(new ObjectRoadListReq(str, str2, str3));
    }

    /* renamed from: lambda$getOnlineStatus$114$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m300lambda$getOnlineStatus$114$comcollectpointnetrepoPatrolRepo(String str, UserBean userBean) throws Exception {
        return this.mApi.getOnlineStatus(new ProjectTypeListReq(userBean.getUserCode(), str)).compose(this.mRxHandler.handleSingleRes());
    }

    /* renamed from: lambda$getOrderInfo$130$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m301lambda$getOrderInfo$130$comcollectpointnetrepoPatrolRepo(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getOrderInfo(new OrderInfo2Req(str, str2, str3));
    }

    /* renamed from: lambda$getPackCouponList$135$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m302xf59d9c8d(String str, String str2, String str3, String str4, List list, List list2, UserBean userBean) throws Exception {
        return this.mApi.getPackCouponList(new OrderInfo2Req(str, str2, str3, "", str4, list, list2));
    }

    /* renamed from: lambda$getPartsDiseaseList$56$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m303xd526e300(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getPartsDiseaseList(new PartsDiseaseListReq(str, str2));
    }

    /* renamed from: lambda$getPartsDiseaseList$57$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m304x36797f9f(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getPartsDiseaseList(new PartsDiseaseListReq(str, str2, str3));
    }

    /* renamed from: lambda$getPartsDiseaseResults$58$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m305xe9232a0c(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getPartsDiseaseResults(new PartsDiseaseResultsreq(str, str2));
    }

    /* renamed from: lambda$getPatrolEventList$100$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m306xb53b6f52(String str, String str2, String str3, String str4, String str5, UserBean userBean) throws Exception {
        return this.mApi.getPatrolEventList(new PatrolEventListReq(str, str2, str3, str4, str5));
    }

    /* renamed from: lambda$getPatrolEventListApi$55$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m307x390733f5(UserBean userBean) throws Exception {
        return this.mApi.getPatrolEventListApi(new PatrolEventListApiReq(userBean.getUserCode()));
    }

    /* renamed from: lambda$getPatrolEventStatusList$101$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m308xc2e6f8df(String str, UserBean userBean) throws Exception {
        return this.mApi.getPatrolEventStatusList(new PatrolEventStatusListReq(str));
    }

    /* renamed from: lambda$getPatrolManageReportList$37$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m309x587051c6(String str, String str2, String str3, String str4, UserBean userBean) throws Exception {
        return this.mApi.getPatrolManageReportList(new PatrolManageReportListReq(userBean.getUserCode(), str, str2, str3, str4));
    }

    /* renamed from: lambda$getPatrolMapPatrolDataList$41$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m310xe2ee487c(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getPatrolMapPatrolDataList(new PatrolMapPatrolDataListReq(userBean.getUserCode(), str, str2, str3));
    }

    /* renamed from: lambda$getPatrolMapPatrolTypeList$40$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m311xa65e336d(String str, UserBean userBean) throws Exception {
        return this.mApi.getPatrolMapPatrolTypeList(new PatrolMapPatrolTypeListReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$getPatrolObjectByMap$4$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m312x9fd48701(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getPatrolObjectByMap(new PatrolObjectByMapReq(userBean.getUserCode(), str, str2, str3));
    }

    /* renamed from: lambda$getPatrolObjectTreeByMap$15$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m313xb6e33dad(String str, String str2, String str3, String str4, UserBean userBean) throws Exception {
        return this.mApi.getPatrolObjectTreeByMap(new PatrolObjectTreeByMapReq(userBean.getUserCode(), str, str2, str3, str4));
    }

    /* renamed from: lambda$getPatrolPersonnelLocationGroupList$99$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m314xac34115b(String str, UserBean userBean) throws Exception {
        return this.mApi.getPatrolPersonnelLocationGroupList(new PatrolPersonnelLocationGroupListReq(str));
    }

    /* renamed from: lambda$getPatrolPersonnelRealTimeInfoList$39$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m315x49f7f13a(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getPatrolPersonnelRealTimeInfoList(new PatrolPersonnelRealTimeInfoListReq(userBean.getUserCode(), str, str2));
    }

    /* renamed from: lambda$getPatrolPersonnelReportList$38$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m316x345200b6(String str, String str2, String str3, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getPatrolPersonnelReportList(new PatrolPersonnelReportListReq(userBean.getUserCode(), str, str2, str3, i, i2));
    }

    /* renamed from: lambda$getPatrolPersonnelSignInPointRecordInfo$53$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m317xc05537c2(String str, String str2, double d, double d2, UserBean userBean) throws Exception {
        return this.mApi.getPatrolPersonnelSignInPointRecordInfo(new PatrolPersonnelSignInPointRecordInfoReq(userBean.getUserCode(), str, str2, d, d2));
    }

    /* renamed from: lambda$getPatrolProblemIssueOpinionList$30$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m318x5e5a6972(String str, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getPatrolProblemIssueOpinionList(new PatrolProblemIssueOpinionListReq(userBean.getUserCode(), str, i, i2));
    }

    /* renamed from: lambda$getPatrolProblemPatrolTypeReportList$27$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m319x547cc81b(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getPatrolProblemPatrolTypeReportList(new PatrolProblemPatrolTypeReportListReq(userBean.getUserCode(), str, str2, str3));
    }

    /* renamed from: lambda$getPatrolProblemRecordList$21$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m320xff2b5e38(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getPatrolProblemRecordList(new PatrolProblemRecordListReq(userBean.getUserCode(), str, str2, str3, str4, str5, str6, str7, i, i2));
    }

    /* renamed from: lambda$getPatrolProblemWarningMessageList$18$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m321x6f92daca(int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getPatrolProblemWarningMessageList(new PatrolProblemWarningMessageListReq(userBean.getUserCode(), i, i2));
    }

    /* renamed from: lambda$getPatrolTypeReportPatrolRecordList$28$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m322x1a1c60d6(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getPatrolTypeReportPatrolRecordList(new ReportPatrolProblemRecordListReq(userBean.getUserCode(), str, str2, str3, "", str4, str5, str6, i, i2));
    }

    /* renamed from: lambda$getPaymentMethod$131$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m323lambda$getPaymentMethod$131$comcollectpointnetrepoPatrolRepo(String str, UserBean userBean) throws Exception {
        return this.mApi.getPaymentMethod(new HallCartReq(str));
    }

    /* renamed from: lambda$getPersonnelAttendanceRecord$44$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m324x6824900f(String str, UserBean userBean) throws Exception {
        return this.mApi.getPersonnelAttendanceRecord(new PersonnelAttendanceRecordReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$getPersonnelLocationList$97$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m325xf2a5a20a(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getPersonnelLocationList(new PersonnelLocationListReq(userBean.getUserCode(), str, str2));
    }

    /* renamed from: lambda$getPersonnelSignInRecordList$52$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m326x596f4069(String str, String str2, String str3, double d, double d2, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getPersonnelSignInRecordList(new PatrolSignInPointRecordListReq(userBean.getUserCode(), str, str2, str3, d, d2, i, i2));
    }

    /* renamed from: lambda$getPersonnelTrajectoryList$98$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m327xd4ff07bb(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getPersonnelTrajectoryList(new PersonnelTrajectoryListReq(str, str2, str3));
    }

    /* renamed from: lambda$getProblemManageInfo$8$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m328x58f35665(String str, UserBean userBean) throws Exception {
        return this.mApi.getProblemManageInfo(new ManagePatrolEventReq(str));
    }

    /* renamed from: lambda$getProblemOperationRecordList$12$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m329x26a5563d(String str, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getProblemOperationRecordList(new ProblemOperationRecordListReq(userBean.getUserCode(), str, i, i2));
    }

    /* renamed from: lambda$getProblemStatusList$20$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m330x58e53de6(UserBean userBean) throws Exception {
        return this.mApi.getProblemStatusList(new ProblemStatusListReq(userBean.getUserCode()));
    }

    /* renamed from: lambda$getProjectOrgProcessArea$1$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m331xe0b09ecd(String str, UserBean userBean) throws Exception {
        return this.mApi.getProjectOrgProcessArea(new ProjectOrgProcessAreaReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$getProjectQSTypeList$7$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m332x511f4b45(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getProjectTypeList(new ProjectTypeListReq(userBean.getUserCode(), str, str2));
    }

    /* renamed from: lambda$getProjectTypeFieldList$59$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m333xc4786428(String str, UserBean userBean) throws Exception {
        return this.mApi.getProjectTypeFieldList(new ProjectTypeFieldListReq(str));
    }

    /* renamed from: lambda$getProjectTypeList$6$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m334lambda$getProjectTypeList$6$comcollectpointnetrepoPatrolRepo(String str, UserBean userBean) throws Exception {
        return this.mApi.getProjectTypeList(new ProjectTypeListReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$getProjectTypeMenuList$54$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m335xc9281966(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getProjectTypeMenuList(new ProjectTypeMenuListReq(str, str2));
    }

    /* renamed from: lambda$getRecentlyObjectApi$91$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m336x2d0f7fb0(String str, double d, double d2, UserBean userBean) throws Exception {
        return this.mApi.getRecentlyObjectApi(new HighwayPatrolTaskCodeApiReq(userBean.getUserCode(), str, d, d2));
    }

    /* renamed from: lambda$getRegionListByMap$2$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m337lambda$getRegionListByMap$2$comcollectpointnetrepoPatrolRepo(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getRegionListByMap(new RegionListByMapReq(userBean.getUserCode(), str, str2));
    }

    /* renamed from: lambda$getReportPatrolProblemRecordList$29$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m338x56945e1c(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getReportPatrolProblemRecordList(new ReportPatrolProblemRecordListReq(userBean.getUserCode(), str, str2, "", str3, str4, str5, str6, i, i2));
    }

    /* renamed from: lambda$getRxCachedUser$108$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ UserBean m339lambda$getRxCachedUser$108$comcollectpointnetrepoPatrolRepo() throws Exception {
        return (UserBean) this.mDoubleCacheUtils.getParcelable(Constants.KEY_PARCELABLE_LOGGED_IN_USER, UserBean.CREATOR);
    }

    /* renamed from: lambda$getSignInPointSignInRecordList$51$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m340xa9fdacd8(String str, String str2, String str3, double d, double d2, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getSignInPointSignInRecordList(new PatrolSignInPointRecordListReq(userBean.getUserCode(), str, str2, str3, d, d2, i, i2));
    }

    /* renamed from: lambda$getSortContentByMap$3$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m341x34d7d760(String str, UserBean userBean) throws Exception {
        return this.mApi.getSortContentByMap(new SortContentByMapReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$getSortContentTreeByMap$13$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m342x142a8631(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getSortContentTreeByMap(new SortContentTreeByMapReq(userBean.getUserCode(), str, str2));
    }

    /* renamed from: lambda$getSpecialPatrolProblemRecordList$32$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m343x1cb388b1(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getSpecialPatrolProblemRecordList(new SpecialPatrolProblemRecordListReq(userBean.getUserCode(), str, str2, str3, str4, str5, str6, i, i2));
    }

    /* renamed from: lambda$getSubmitProblemInfo$0$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m344x806e70a(String str, UserBean userBean) throws Exception {
        return this.mApi.getSubmitProblemInfo(new SubmitProblemInfoReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$getTownPatrolReportList$17$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m345x39d280f1(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getTownPatrolReportList(new PatrolReportListReq(userBean.getUserCode(), str, str2, str3));
    }

    /* renamed from: lambda$getTownReportPatrolRecordList$23$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m346x1cf24e67(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getTownReportPatrolRecordList(new PatrolProblemRecordListReq(userBean.getUserCode(), str, str2, str3, str4, str5, str6, i, i2));
    }

    /* renamed from: lambda$getVillageRegionListByMap$19$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m347x5977eb86(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getVillageRegionListByMap(new VillageRegionListByMapReq(userBean.getUserCode(), str, str2));
    }

    /* renamed from: lambda$hallCartAdd$120$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m348lambda$hallCartAdd$120$comcollectpointnetrepoPatrolRepo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, UserBean userBean) throws Exception {
        return this.mApi.hallCartAdd(new HallCart3Req(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11));
    }

    /* renamed from: lambda$hallCartList$123$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m349lambda$hallCartList$123$comcollectpointnetrepoPatrolRepo(String str, UserBean userBean) throws Exception {
        return this.mApi.hallCartList(new HallCartReq(str));
    }

    /* renamed from: lambda$hallCartSub$124$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m350lambda$hallCartSub$124$comcollectpointnetrepoPatrolRepo(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.hallCartSub(new HallCartReq(str, str2, "mid"));
    }

    /* renamed from: lambda$highwayPatrolTaskTimeJudge$90$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m351x2ca9af00(List list, UserBean userBean) throws Exception {
        return this.mApi.highwayPatrolTaskTimeJudge(new HighwayPatrolTaskInfoApiReq(userBean.getUserCode(), list));
    }

    /* renamed from: lambda$insertBridgeInspectEvent$113$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m352x25bd5bfe(String str, String str2, String str3, String str4, String str5, double d, double d2, String str6, List list, String str7, List list2, String str8, UserBean userBean) throws Exception {
        InsertPatrolEventProcessByMySelfReq insertPatrolEventProcessByMySelfReq = new InsertPatrolEventProcessByMySelfReq(userBean.getUserCode(), userBean.getNickName(), str, str2, str3, str4, str5, d, d2, str6, list, str7);
        insertPatrolEventProcessByMySelfReq.setPhotoList(list2);
        insertPatrolEventProcessByMySelfReq.setTimeLimete(str8);
        return this.mApi.insertBridgeInspectEvent(insertPatrolEventProcessByMySelfReq).compose(this.mRxHandler.handleSingleRes());
    }

    /* renamed from: lambda$insertHighwayPatrolTaskRecord$89$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m353x9ad5a706(String str, String str2, String str3, List list, UserBean userBean) throws Exception {
        return this.mApi.insertHighwayPatrolTaskRecord(new InsertPatrolTaskRecordReq(userBean.getUserCode(), str, str2, str3, list));
    }

    /* renamed from: lambda$insertHighwayPatrolTaskTrajectoryListApi$79$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m354xe68eeb9(String str, String str2, List list, UserBean userBean) throws Exception {
        InsertPatrolTrajectoryReq insertPatrolTrajectoryReq = new InsertPatrolTrajectoryReq();
        insertPatrolTrajectoryReq.setTrajectoryApiReqs(userBean.getUserCode(), str, str2, list);
        return this.mApi.insertHighwayPatrolTaskTrajectoryListApi(insertPatrolTrajectoryReq);
    }

    /* renamed from: lambda$insertPatrolEvent$60$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m355lambda$insertPatrolEvent$60$comcollectpointnetrepoPatrolRepo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, double d, double d2, String str9, String str10, String str11, List list, List list2, String str12, UserBean userBean) throws Exception {
        InsertPatrolEventReq insertPatrolEventReq = new InsertPatrolEventReq(str, str2, str3, str4, str5, str6, str7, str8, d, d2, str9, str10, str11);
        if (list != null && !list.isEmpty()) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                DiseaseListItem diseaseListItem = (DiseaseListItem) it.next();
                if (EmptyUtils.isNotEmpty(diseaseListItem.getImageList())) {
                    ArrayList arrayList = new ArrayList();
                    for (String str13 : diseaseListItem.getImageList()) {
                        String strSubstring = str13.substring(str13.lastIndexOf("/") + 1);
                        Iterator it2 = list.iterator();
                        while (it2.hasNext()) {
                            UploadRes uploadRes = (UploadRes) it2.next();
                            if (strSubstring.equals(uploadRes.getLocalFileName())) {
                                arrayList.add(new FilePathItem(uploadRes.getObject()));
                            }
                        }
                    }
                    diseaseListItem.setPhotoList(arrayList);
                }
            }
            insertPatrolEventReq.setDiseaseList(list2);
        }
        insertPatrolEventReq.setTimeLimete(str12);
        return this.mApi.insertPatrolEvent(insertPatrolEventReq);
    }

    /* renamed from: lambda$insertPatrolProblem$5$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m356xc28d27a4(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, double d, double d2, List list, List list2, List list3, UserBean userBean) throws Exception {
        InsertPatrolProblemReq insertPatrolProblemReq = new InsertPatrolProblemReq(userBean.getUserCode(), str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, d, d2);
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                PictureType pictureType = (PictureType) it.next();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    UploadRes uploadRes = (UploadRes) it2.next();
                    if (pictureType.getPath().substring(pictureType.getPath().lastIndexOf("/") + 1).equals(uploadRes.getLocalFileName())) {
                        arrayList.add(new FilePathItem(uploadRes.getObject(), pictureType.getFileSource(), pictureType.getFileType()));
                    }
                }
            }
            insertPatrolProblemReq.setPhotoList(arrayList);
        }
        if (list3 != null && !list3.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = list3.iterator();
            while (it3.hasNext()) {
                arrayList2.add(new FilePathItem(((UploadRes) it3.next()).getObject()));
            }
            insertPatrolProblemReq.setVideoList(arrayList2);
        }
        return this.mApi.insertPatrolProblem(insertPatrolProblemReq);
    }

    /* renamed from: lambda$insertPatrolProblemComment$35$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m357x3e8ac0e(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.insertPatrolProblemComment(new InsertPatrolProblemCommentReq(userBean.getUserCode(), userBean.getNickName(), str, str2));
    }

    /* renamed from: lambda$insertPatrolProblemManageByMyself$14$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m358xddad469c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, double d, double d2, String str12, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, UserBean userBean) throws Exception {
        InsertPatrolProblemManageByMyselfReq insertPatrolProblemManageByMyselfReq = new InsertPatrolProblemManageByMyselfReq(userBean.getUserCode(), str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, d, d2);
        ProblemManageRecordAppBean problemManageRecordAppBean = new ProblemManageRecordAppBean(userBean.getUserCode(), str12);
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (EmptyUtils.isNotEmpty(list2)) {
                Iterator it = list3.iterator();
                while (it.hasNext()) {
                    PictureType pictureType = (PictureType) it.next();
                    String strSubstring = pictureType.getPath().substring(pictureType.getPath().lastIndexOf("/") + 1);
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        UploadRes uploadRes = (UploadRes) it2.next();
                        if (strSubstring.equals(uploadRes.getLocalFileName())) {
                            arrayList.add(new FilePathItem(uploadRes.getObject(), pictureType.getFileSource(), pictureType.getFileType()));
                        }
                    }
                }
                insertPatrolProblemManageByMyselfReq.setPhotoList(arrayList);
            }
            if (EmptyUtils.isNotEmpty(list4)) {
                Iterator it3 = list5.iterator();
                while (it3.hasNext()) {
                    PictureType pictureType2 = (PictureType) it3.next();
                    String strSubstring2 = pictureType2.getPath().substring(pictureType2.getPath().lastIndexOf("/") + 1);
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        UploadRes uploadRes2 = (UploadRes) it4.next();
                        if (strSubstring2.equals(uploadRes2.getLocalFileName())) {
                            arrayList2.add(new FilePathItem(uploadRes2.getObject(), pictureType2.getFileSource(), pictureType2.getFileType()));
                        }
                    }
                }
                problemManageRecordAppBean.setPhotoList(arrayList2);
            }
        }
        if (list6 != null && !list6.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            if (EmptyUtils.isNotEmpty(list7)) {
                Iterator it5 = list7.iterator();
                while (it5.hasNext()) {
                    String str13 = (String) it5.next();
                    String strSubstring3 = str13.substring(str13.lastIndexOf("/") + 1);
                    Iterator it6 = list6.iterator();
                    while (it6.hasNext()) {
                        UploadRes uploadRes3 = (UploadRes) it6.next();
                        if (strSubstring3.equals(uploadRes3.getLocalFileName())) {
                            arrayList3.add(new FilePathItem(uploadRes3.getObject()));
                        }
                    }
                }
                insertPatrolProblemManageByMyselfReq.setVideoList(arrayList3);
            }
            if (EmptyUtils.isNotEmpty(list8)) {
                Iterator it7 = list8.iterator();
                while (it7.hasNext()) {
                    String str14 = (String) it7.next();
                    String strSubstring4 = str14.substring(str14.lastIndexOf("/") + 1);
                    Iterator it8 = list6.iterator();
                    while (it8.hasNext()) {
                        UploadRes uploadRes4 = (UploadRes) it8.next();
                        if (strSubstring4.equals(uploadRes4.getLocalFileName())) {
                            arrayList4.add(new FilePathItem(uploadRes4.getObject()));
                        }
                    }
                }
                problemManageRecordAppBean.setVideoList(arrayList4);
            }
        }
        insertPatrolProblemManageByMyselfReq.setProblemManageRecordApp(problemManageRecordAppBean);
        return this.mApi.insertPatrolProblemManageByMyself(insertPatrolProblemManageByMyselfReq);
    }

    /* renamed from: lambda$insertRepairProjectCheck$68$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m359x54a9729e(String str, String str2, String str3, String str4, double d, double d2, List list, List list2, List list3, List list4, UserBean userBean) throws Exception {
        RepairProjectCheckReq repairProjectCheckReq = new RepairProjectCheckReq(str, userBean.getUserCode(), userBean.getNickName(), str2, str3, str4, d, d2);
        repairProjectCheckReq.setCarPhotoList(list);
        repairProjectCheckReq.setPersonnelPhotoList(list2);
        repairProjectCheckReq.setConstructionPhotoList(list3);
        repairProjectCheckReq.setMaterielPhotoList(list4);
        return this.mApi.insertRepairProjectCheck(repairProjectCheckReq);
    }

    /* renamed from: lambda$insertRepairProjectCheckRectification$69$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m360xefb6e273(String str, String str2, String str3, List list, UserBean userBean) throws Exception {
        RepairProjectCheckRectificationReq repairProjectCheckRectificationReq = new RepairProjectCheckRectificationReq(str, str2, userBean.getUserCode(), userBean.getNickName(), str3);
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((UploadRes) it.next()).getObject());
            }
            repairProjectCheckRectificationReq.setRectificationPhotoList(arrayList);
        }
        return this.mApi.insertRepairProjectCheckRectification(repairProjectCheckRectificationReq);
    }

    /* renamed from: lambda$insertRepairProjectIncidentAcceptanceManage$70$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m361xd0930259(String str, List list, UserBean userBean) throws Exception {
        ManagePatrolEventReq managePatrolEventReq = new ManagePatrolEventReq(str, userBean.getUserCode(), userBean.getNickName());
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((UploadRes) it.next()).getObject());
            }
            managePatrolEventReq.setManagePhotoList(arrayList);
        }
        return this.mApi.insertRepairProjectIncidentAcceptanceManage(managePatrolEventReq);
    }

    /* renamed from: lambda$insertRepairProjectIncidentManageRecord$72$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m362x1c305511(String str, List list, UserBean userBean) throws Exception {
        ManagePatrolEventReq managePatrolEventReq = new ManagePatrolEventReq(str, userBean.getUserCode(), userBean.getNickName());
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((UploadRes) it.next()).getObject());
            }
            managePatrolEventReq.setManagePhotoList(arrayList);
        }
        return this.mApi.insertRepairProjectIncidentManageRecord(managePatrolEventReq);
    }

    /* renamed from: lambda$insertRepairProjectIncidentTailRecord$71$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m363xabcf1e1d(String str, String str2, String str3, List list, UserBean userBean) throws Exception {
        IncidentTailRecordReq incidentTailRecordReq = new IncidentTailRecordReq(str, userBean.getNickName(), str2, userBean.getUserCode(), str3);
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((UploadRes) it.next()).getObject());
            }
            incidentTailRecordReq.setRecordPhotos(arrayList);
        }
        return this.mApi.insertRepairProjectIncidentTailRecord(incidentTailRecordReq);
    }

    /* renamed from: lambda$issuePatrolProblemOpinion$31$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m364x1c8f5e3b(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.issuePatrolProblemOpinion(new IssuePatrolProblemOpinionReq(userBean.getUserCode(), userBean.getNickName(), str, str2));
    }

    /* renamed from: lambda$microRefund$137$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m365lambda$microRefund$137$comcollectpointnetrepoPatrolRepo(String str, UserBean userBean) throws Exception {
        return this.mApi.microRefund(new ScanPayReq(str));
    }

    /* renamed from: lambda$moveProduct$129$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m366lambda$moveProduct$129$comcollectpointnetrepoPatrolRepo(String str, String str2, String str3, String str4, UserBean userBean) throws Exception {
        return this.mApi.moveProduct(new MoveProductReq(str, str2, str3, str4));
    }

    /* renamed from: lambda$orderCancel$126$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m367lambda$orderCancel$126$comcollectpointnetrepoPatrolRepo(String str, UserBean userBean) throws Exception {
        return this.mApi.orderCancel(new HallCartReq(str));
    }

    /* renamed from: lambda$orderDetail$125$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m368lambda$orderDetail$125$comcollectpointnetrepoPatrolRepo(String str, UserBean userBean) throws Exception {
        return this.mApi.orderDetail(new HallCartReq(str));
    }

    /* renamed from: lambda$patrolPersonnelSignIn$47$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m369x6bdcf304(String str, String str2, String str3, String str4, String str5, String str6, double d, double d2, String str7, List list, List list2, UserBean userBean) throws Exception {
        PatrolPersonnelSignInReq patrolPersonnelSignInReq = new PatrolPersonnelSignInReq(userBean.getUserCode(), str, str2, str3, str4, str5, str6, d, d2, str7);
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                PictureType pictureType = (PictureType) it.next();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    UploadRes uploadRes = (UploadRes) it2.next();
                    if (pictureType.getPath().substring(pictureType.getPath().lastIndexOf("/") + 1).equals(uploadRes.getLocalFileName())) {
                        arrayList.add(new FilePathItem(uploadRes.getObject(), pictureType.getFileSource(), pictureType.getFileType()));
                    }
                }
            }
            patrolPersonnelSignInReq.setPhotoList(arrayList);
        }
        return this.mApi.patrolPersonnelSignIn(patrolPersonnelSignInReq);
    }

    /* renamed from: lambda$patrolPersonnelSignInSavePhoto$48$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m370x9feff966(String str, List list, List list2, UserBean userBean) throws Exception {
        PatrolPersonnelSignInSavePhotoReq patrolPersonnelSignInSavePhotoReq = new PatrolPersonnelSignInSavePhotoReq(userBean.getUserCode(), str);
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                PictureType pictureType = (PictureType) it.next();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    UploadRes uploadRes = (UploadRes) it2.next();
                    if (pictureType.getPath().substring(pictureType.getPath().lastIndexOf("/") + 1).equals(uploadRes.getLocalFileName())) {
                        arrayList.add(new FilePathItem(uploadRes.getObject(), pictureType.getFileSource(), pictureType.getFileType()));
                    }
                }
            }
            patrolPersonnelSignInSavePhotoReq.setPhotoList(arrayList);
        }
        return this.mApi.patrolPersonnelSignInSavePhoto(patrolPersonnelSignInSavePhotoReq);
    }

    /* renamed from: lambda$preClosurePatrolProblem$34$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m371x57c498b(String str, UserBean userBean) throws Exception {
        return this.mApi.preClosurePatrolProblem(new PreClosurePatrolProblemReq(userBean.getUserCode(), userBean.getNickName(), str));
    }

    /* renamed from: lambda$previewHighwayPatrolTaskListApi$78$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m372xb4edce56(List list, UserBean userBean) throws Exception {
        return this.mApi.previewHighwayPatrolTaskListApi(new HighwayPatrolTaskInfoApiReq((List<String>) list));
    }

    /* renamed from: lambda$productIndex$119$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m373lambda$productIndex$119$comcollectpointnetrepoPatrolRepo(String str, String str2, String str3, String str4, UserBean userBean) throws Exception {
        return this.mApi.productIndex(new ProductReq(str, str2, str3, str4));
    }

    /* renamed from: lambda$restartHighwayPatrolTaskApi$82$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m374x308705a2(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.restartHighwayPatrolTaskApi(new HighwayPatrolTaskApiReq(userBean.getUserCode(), str, str2));
    }

    /* renamed from: lambda$returnProblemMange$10$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m375xa4c47095(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.returnProblemMange(new ReturnProblemMangeReq(userBean.getUserCode(), str, str2));
    }

    /* renamed from: lambda$scanPay$132$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m376lambda$scanPay$132$comcollectpointnetrepoPatrolRepo(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.scanPay(new ScanPayReq(str, str2, str3));
    }

    /* renamed from: lambda$scanPayQuery$133$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m377lambda$scanPayQuery$133$comcollectpointnetrepoPatrolRepo(String str, UserBean userBean) throws Exception {
        return this.mApi.scanPayQuery(new ScanPayReq(str));
    }

    /* renamed from: lambda$selectAttendancePersonnelFenceList$42$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m378x1f05d01(String str, double d, double d2, UserBean userBean) throws Exception {
        return this.mApi.selectAttendancePersonnelFenceList(new SelectAttendancePersonnelFenceListReq(userBean.getUserCode(), str, d, d2));
    }

    /* renamed from: lambda$selectAttendancePersonnelFenceListByDate$45$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m379x678cd1e3(String str, UserBean userBean) throws Exception {
        return this.mApi.selectAttendancePersonnelFenceListByDate(new SelectAttendancePersonnelFenceListByDateReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$stopHighwayPatrolTaskApi$81$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m380x6d0e8c10(String str, String str2, String str3, List list, UserBean userBean) throws Exception {
        return this.mApi.stopHighwayPatrolTaskApi(new HighwayPatrolTaskApiReq(userBean.getUserCode(), str, str2, str3, list));
    }

    /* renamed from: lambda$submitManagePatrolEvent$73$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m381xc8de6846(String str, List list, UserBean userBean) throws Exception {
        ManagePatrolEventReq managePatrolEventReq = new ManagePatrolEventReq(str, userBean.getUserCode(), userBean.getNickName());
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((UploadRes) it.next()).getObject());
            }
            managePatrolEventReq.setManagePhotoList(arrayList);
        }
        return this.mApi.submitManagePatrolEvent(managePatrolEventReq);
    }

    /* renamed from: lambda$submitPersonnelAttendance$43$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m382x58ea63e3(String str, String str2, String str3, double d, double d2, String str4, String str5, String str6, String str7, UserBean userBean) throws Exception {
        return this.mApi.submitPersonnelAttendance(new SubmitPersonnelAttendanceReq(userBean.getUserCode(), str, str2, str3, d, d2, str4, str5, str6, str7));
    }

    /* renamed from: lambda$submitProblemMange$11$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m383xf038ec1c(String str, String str2, String str3, List list, List list2, UserBean userBean) throws Exception {
        return this.mApi.submitProblemMange(new SubmitProblemMangeReq(userBean.getUserCode(), str, str2, str3, list, list2));
    }

    /* renamed from: lambda$tableBuy$122$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m384lambda$tableBuy$122$comcollectpointnetrepoPatrolRepo(String str, String str2, String str3, String str4, boolean z, String str5, UserBean userBean) throws Exception {
        return this.mApi.tableBuy(new HallCartaddReq(str, str2, "", str3, str4, z, str5));
    }

    /* renamed from: lambda$tableList$117$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m385lambda$tableList$117$comcollectpointnetrepoPatrolRepo(String str, String str2, String str3, String str4, String str5, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.tableList(new ApiTableReq(str, str2, str3, str4, str5, i, i2));
    }

    /* renamed from: lambda$updateGroup$87$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m386lambda$updateGroup$87$comcollectpointnetrepoPatrolRepo(String str, String str2, List list, UserBean userBean) throws Exception {
        return this.mApi.updateGroup(new CreateGroupReq(userBean.getUserCode(), str, str2, list));
    }

    /* renamed from: lambda$updatePatrolProblemAsSpecialProblem$36$com-collectpoint-net-repo-PatrolRepo, reason: not valid java name */
    /* synthetic */ SingleSource m387x350794d0(String str, UserBean userBean) throws Exception {
        return this.mApi.updatePatrolProblemAsSpecialProblem(new UpdatePatrolProblemAsSpecialProblemReq(userBean.getUserCode(), userBean.getNickName(), str));
    }

    public Single<Object> mergeTable(String str, String str2) {
        return this.mApi.mergeTable(new MergeTableReq(str, str2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> microRefund(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda66
            public final Object apply(Object obj) {
                return this.f$0.m365lambda$microRefund$137$comcollectpointnetrepoPatrolRepo(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> moveProduct(final String str, final String str2, final String str3, final String str4) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda132
            public final Object apply(Object obj) {
                return this.f$0.m366lambda$moveProduct$129$comcollectpointnetrepoPatrolRepo(str, str2, str3, str4, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> newPay(OrderInfo2Req orderInfo2Req) {
        return this.mApi.newPay(orderInfo2Req).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> open(String str) {
        return this.mApi.open(new HallCartReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> openScan(String str) {
        return this.mApi.openScan(new HallCartReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> orderCancel(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda68
            public final Object apply(Object obj) {
                return this.f$0.m367lambda$orderCancel$126$comcollectpointnetrepoPatrolRepo(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<HallCartDetailRes> orderDetail(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda69
            public final Object apply(Object obj) {
                return this.f$0.m368lambda$orderDetail$125$comcollectpointnetrepoPatrolRepo(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseListDataRes<BaseDataRes<List<OrderDetailListItem>>>> orderDetailList(OrderInfo2Req orderInfo2Req) {
        return this.mApi.orderDetailList(orderInfo2Req).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseDataRes<BaseListDataRes<BaseDataListRes<OrderListItem>>>> orderList(String str, String str2, String str3, String str4) {
        return this.mApi.orderList(new OrderListReq(str, str2, str3, str4)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> patrolPersonnelSignIn(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final double d, final double d2, final String str7, final List<UploadRes> list, final List<PictureType> list2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda1
            public final Object apply(Object obj) {
                return this.f$0.m369x6bdcf304(str, str2, str3, str4, str5, str6, d, d2, str7, list, list2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> patrolPersonnelSignInSavePhoto(final String str, final List<UploadRes> list, final List<PictureType> list2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda36
            public final Object apply(Object obj) {
                return this.f$0.m370x9feff966(str, list, list2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseListRes<PermissionItem>> permissionList() {
        return this.mApi.permissionList().compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> preClosurePatrolProblem(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda70
            public final Object apply(Object obj) {
                return this.f$0.m371x57c498b(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<HighwayPatrolTaskInfoApiRes> previewHighwayPatrolTaskListApi(final List<String> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda39
            public final Object apply(Object obj) {
                return this.f$0.m372xb4edce56(list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> printOrder(OrderInfo2Req orderInfo2Req) {
        return this.mApi.printOrder(orderInfo2Req).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<HallCartRes> productIndex(final String str, final String str2, final String str3, final String str4) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda134
            public final Object apply(Object obj) {
                return this.f$0.m373lambda$productIndex$119$comcollectpointnetrepoPatrolRepo(str, str2, str3, str4, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> productPass(String str) {
        MoveProductReq moveProductReq = new MoveProductReq();
        moveProductReq.setOrder_product_id(str);
        return this.mApi.productPass(moveProductReq).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> productPassRollback(String str) {
        MoveProductReq moveProductReq = new MoveProductReq();
        moveProductReq.setOrder_product_id(str);
        return this.mApi.productPassRollback(moveProductReq).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ProjectObjectFirstListItem>> projectObjectFirstListApi(String str) {
        return this.mApi.projectObjectFirstListApi(new RepairProjectCheckRectificationReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<ProjectObjectFirstListItem>> projectObjectListApi(String str, String str2, String str3) {
        return this.mApi.projectObjectListApi(new ProjectObjectFirstListItem(str, str2, str3)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<CollectionTodaItem>> recaptureApi() {
        return this.mApi.recaptureApi(new InsertPointInfoRes()).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> refundCoupon(String str) {
        return this.mApi.refundCoupon(new CouponDyReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> refundMeituanCoupon(String str) {
        return this.mApi.refundMeituanCoupon(new CouponDyReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> refundOrderCoupon(String str) {
        return this.mApi.refundOrderCoupon(new CouponDyReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<RestartPatrolTaskRes> restartHighwayPatrolTaskApi(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda102
            public final Object apply(Object obj) {
                return this.f$0.m374x308705a2(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> returnProblemMange(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda103
            public final Object apply(Object obj) {
                return this.f$0.m375xa4c47095(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> saveScanInfo(String str, String str2) {
        return this.mApi.saveScanInfo(new HallCartReq(str, str2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseDataRes<ScanPayRes>> scanPay(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda125
            public final Object apply(Object obj) {
                return this.f$0.m376lambda$scanPay$132$comcollectpointnetrepoPatrolRepo(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseResuleRes<ScanPayRes>> scanPayQuery(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda71
            public final Object apply(Object obj) {
                return this.f$0.m377lambda$scanPayQuery$133$comcollectpointnetrepoPatrolRepo(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<SelectAttendancePersonnelFenceListRes> selectAttendancePersonnelFenceList(final String str, final double d, final double d2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda79
            public final Object apply(Object obj) {
                return this.f$0.m378x1f05d01(str, d, d2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<SelectAttendancePersonnelFenceListByDateItem>> selectAttendancePersonnelFenceListByDate(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda72
            public final Object apply(Object obj) {
                return this.f$0.m379x678cd1e3(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> stopHighwayPatrolTaskApi(final String str, final String str2, final String str3, final List<HighwayPatrolTaskTrajectoryApiReq> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda25
            public final Object apply(Object obj) {
                return this.f$0.m380x6d0e8c10(str, str2, str3, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> submitManagePatrolEvent(final String str, final List<UploadRes> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda34
            public final Object apply(Object obj) {
                return this.f$0.m381xc8de6846(str, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> submitPersonnelAttendance(final String str, final String str2, final String str3, final double d, final double d2, final String str4, final String str5, final String str6, final String str7) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda128
            public final Object apply(Object obj) {
                return this.f$0.m382x58ea63e3(str, str2, str3, d, d2, str4, str5, str6, str7, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> submitProblemMange(final String str, final String str2, final String str3, final List<AlbumItem> list, final List<AlbumItem> list2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda26
            public final Object apply(Object obj) {
                return this.f$0.m383xf038ec1c(str, str2, str3, list, list2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseListDataRes<List<TableAreaItem>>> tableArea(String str) {
        return this.mApi.tableArea(new ApiTableReq(str)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> tableBuy(final String str, final String str2, final String str3, final String str4, final boolean z, final String str5) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda20
            public final Object apply(Object obj) {
                return this.f$0.m384lambda$tableBuy$122$comcollectpointnetrepoPatrolRepo(str, str2, str3, str4, z, str5, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<BaseListDataRes<List<TableAreaItem>>> tableList(final String str, final String str2, final String str3, final String str4, final String str5, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda142
            public final Object apply(Object obj) {
                return this.f$0.m385lambda$tableList$117$comcollectpointnetrepoPatrolRepo(str, str2, str3, str4, str5, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> updateGroup(final String str, final String str2, final List<String> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda29
            public final Object apply(Object obj) {
                return this.f$0.m386lambda$updateGroup$87$comcollectpointnetrepoPatrolRepo(str, str2, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> updatePatrolProblemAsSpecialProblem(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.PatrolRepo$$ExternalSyntheticLambda73
            public final Object apply(Object obj) {
                return this.f$0.m387x350794d0(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> updatePointInfoApi(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<FieldListItem> list) {
        return this.mApi.updatePointInfoApi(new InsertPointInfoRes(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, list)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> urgedishes(String str, String str2) {
        return this.mApi.urgedishes(new MoveProductReq(str, str2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> verifyCoupon(Coupon2Res coupon2Res) {
        return this.mApi.verifyCoupon(coupon2Res).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Object> verifyMeituanCoupon(Coupon2Res coupon2Res) {
        return this.mApi.verifyMeituanCoupon(coupon2Res).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<WeatherInfoRes> weatherInfoApi(double d, double d2) {
        return this.mApi.weatherInfoApi(new AutoPatrolSignInReq(d, d2)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }
}
