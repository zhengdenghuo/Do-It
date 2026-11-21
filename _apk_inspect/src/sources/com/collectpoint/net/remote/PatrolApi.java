package com.collectpoint.net.remote;

import com.collectpoint.bean.PersonnelItem;
import com.collectpoint.bean.item.ApiRepairIncidentListItem;
import com.collectpoint.bean.item.ApiRepairProjectListItem;
import com.collectpoint.bean.item.BridgeInspectTaskListItem;
import com.collectpoint.bean.item.CategoryItem;
import com.collectpoint.bean.item.CollectionTodaItem;
import com.collectpoint.bean.item.CouponItem;
import com.collectpoint.bean.item.CurrentDatePatrolPersonnelSignInTaskListItem;
import com.collectpoint.bean.item.DeptPatrolReportListItem;
import com.collectpoint.bean.item.DeviceCodeItem;
import com.collectpoint.bean.item.DictionaryListItem;
import com.collectpoint.bean.item.ExamineObjectListItem;
import com.collectpoint.bean.item.ExamineQuarterListItem;
import com.collectpoint.bean.item.FiveColorWarningReportItem;
import com.collectpoint.bean.item.GetObjectListItem;
import com.collectpoint.bean.item.GroupTypeItem;
import com.collectpoint.bean.item.HighwayPatrolTaskTreeApiItem;
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
import com.collectpoint.bean.item.PatrolProblemPatrolTypeReportListItem;
import com.collectpoint.bean.item.PermissionItem;
import com.collectpoint.bean.item.PersonnelLocationListItem;
import com.collectpoint.bean.item.PersonnelTrajectoryListItem;
import com.collectpoint.bean.item.ProblemManageListItem;
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
import com.collectpoint.bean.res.BaseResponse;
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
import com.collectpoint.bean.res.PatrolProblemRecordListRes;
import com.collectpoint.bean.res.PatrolProblemWarningMessageListRes;
import com.collectpoint.bean.res.PatrolSignInPointRecordListRes;
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
import com.collectpoint.bean.res.VersionRes;
import com.collectpoint.bean.res.WeatherInfoRes;
import io.reactivex.Single;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes10.dex */
public interface PatrolApi {
    @POST("/index.php/cashier/order.OrderDetail/OrderDetail")
    Single<BaseResponse<BaseDataRes<OrderDetailRes>>> OrderDetailHome(@Body MoveProductReq moveProductReq);

    @POST("index.php/cashier/order.OrderDetail/PrintBill")
    Single<BaseResponse<Object>> PrintBill(@Body MoveProductReq moveProductReq);

    @POST("index.php/cashier/order.Cart/addDeviceOrder")
    Single<BaseResponse<Object>> addDeviceOrder(@Body AddDeviceOrderReq addDeviceOrderReq);

    @POST("index.php/cashier/order.Order/addMeal")
    Single<BaseResponse<Object>> addMeal(@Body HallCartaddReq hallCartaddReq);

    @POST("apis/patrolProblem/addOrUpdateProblemManageRecord")
    Single<BaseResponse<String>> addOrUpdateProblemManageRecord(@Body ProblemManageRecordReq problemManageRecordReq);

    @POST("index.php/cashier/order.OrderCoupon/addOrderCoupon")
    Single<BaseResponse<Object>> addOrderCoupon(@Body AddOrderCouponReq addOrderCouponReq);

    @POST("api/repairProject/apiRepairProjectCheckAudit")
    Single<BaseResponse<String>> apiRepairProjectCheckAudit(@Body RepairCheckReq repairCheckReq);

    @POST("api/repairProject/apiRepairProjectIncidentAcceptanceAudit")
    Single<BaseResponse<String>> apiRepairProjectIncidentAcceptanceAudit(@Body IncidentAcceptanceAuditReq incidentAcceptanceAuditReq);

    @POST("api/patrolEvent/auditPatrolEvent")
    Single<BaseResponse<String>> auditPatrolEvent(@Body ClosePatrolEventReq closePatrolEventReq);

    @POST("api/personnelSignIn/autoPatrolSignIn")
    Single<BaseResponse<AutoPatrolSignInRes>> autoPatrolSignIn(@Body AutoPatrolSignInReq autoPatrolSignInReq);

    @POST("index.php/cashier/product.category/index")
    Single<BaseResponse<BaseListDataRes<List<CategoryItem>>>> categoryIndex(@Body ApiTableReq apiTableReq);

    @POST("index.php/cashier/order.HallCart/changeMoney")
    Single<BaseResponse<BaseDataRes<List<CoupomRes>>>> changeMoney(@Body OrderInfo2Req orderInfo2Req);

    @POST("index.php/cashier/order.Order/changeNum")
    Single<BaseResponse<Object>> changeNum(@Body ChangeNumReq changeNumReq);

    @POST("index.php/cashier/order.Order/changeTable")
    Single<BaseResponse<Object>> changeTable(@Body HallCartaddReq hallCartaddReq);

    @POST("index.php/cashier/store.table/changeTable")
    Single<BaseResponse<BaseListDataRes<List<TableAreaItem>>>> changeTableList(@Body HallCartReq hallCartReq);

    @POST("api/patrolEvent/closePatrolEvent")
    Single<BaseResponse<String>> closePatrolProblem(@Body ClosePatrolEventReq closePatrolEventReq);

    @POST("index.php/cashier/order.Cart/closeScan")
    Single<BaseResponse<Object>> closeScan(@Body HallCartReq hallCartReq);

    @POST("apis/collection/collectionObjectInfoApi")
    Single<BaseResponse<List<CollectionObjectInfoReq>>> collectionObjectInfoApi(@Body CollectionObjectReq collectionObjectReq);

    @POST("apis/collection/collectionObjectListApi")
    Single<BaseResponse<List<ProjectObjectFirstListItem>>> collectionObjectListApi(@Body InsertPointInfoRes insertPointInfoRes);

    @POST("apis/collection/collectionRecordInfoApi")
    Single<BaseResponse<InsertPointInfoRes>> collectionRecordInfoApi(@Body SubmitPersonnelAttendanceReq submitPersonnelAttendanceReq);

    @POST("apis/collection/collectionRecordListApi")
    Single<BaseResponse<List<CollectionTodaItem>>> collectionRecordListApi(@Body CollectionObjectReq collectionObjectReq);

    @POST("apis/collection/collectionRecordTrackInfoApi")
    Single<BaseResponse<List<InsertPointInfoRes>>> collectionRecordTrackInfoApi(@Body SubmitPersonnelAttendanceReq submitPersonnelAttendanceReq);

    @POST("apis/collection/collectionTodayApi")
    Single<BaseResponse<List<CollectionTodaItem>>> collectionTodayApi(@Body CollectionTodayApiRes collectionTodayApiRes);

    @POST("apis/collection/collectionTodayPointApi")
    Single<BaseResponse<List<CollectionTodaItem>>> collectionTodayPointApi(@Body InsertPointInfoRes insertPointInfoRes);

    @POST("apis/collection/collectionTodayTrackApi")
    Single<BaseResponse<List<List<CollectionTodaItem>>>> collectionTodayTrackApi(@Body InsertPointInfoRes insertPointInfoRes);

    @POST("api/patrolProblem/completedPatrolProblem")
    Single<BaseResponse<String>> completedPatrolProblem(@Body CompletedPatrolProblemReq completedPatrolProblemReq);

    @POST("api/highwayPatrolTask/createGroup")
    Single<BaseResponse<String>> createGroup(@Body CreateGroupReq createGroupReq);

    @POST("api/patrolEvent/decomposePatrolEvent")
    Single<BaseResponse<String>> decomposePatrolPersonnelManage(@Body ApiRepairIncidentListItem apiRepairIncidentListItem);

    @POST("api/highwayPatrolTask/deleteGroup")
    Single<BaseResponse<String>> deleteGroup(@Body CreateGroupReq createGroupReq);

    @POST("apis/collection/deleteTrackListApi")
    Single<BaseResponse<String>> deleteTrackListApi(@Body SubmitPersonnelAttendanceReq submitPersonnelAttendanceReq);

    @POST("api/highwayPatrolTask/endHighwayPatrolTaskApi")
    Single<BaseResponse<EndHighwayPatrolTaskRes>> endHighwayPatrolTaskApi(@Body HighwayPatrolTaskApiReq highwayPatrolTaskApiReq);

    @POST("api/repairProject/getApiRepairIncidentInfo")
    Single<BaseResponse<ApiRepairIncidentInfoRes>> getApiRepairIncidentInfo(@Body RepairIncidentReq repairIncidentReq);

    @POST("api/repairProject/getApiRepairIncidentList")
    Single<BaseResponse<List<ApiRepairIncidentListItem>>> getApiRepairIncidentList(@Body RepairIncidentReq repairIncidentReq);

    @POST("api/repairProject/getApiRepairProjectCheckInfo")
    Single<BaseResponse<RepairProjectCheckInfoRes>> getApiRepairProjectCheckInfo(@Body RepairCheckReq repairCheckReq);

    @POST("api/repairProject/getApiRepairProjectCheckList")
    Single<BaseResponse<List<RepairProjectCheckListItem>>> getApiRepairProjectCheckList(@Body RepairCheckReq repairCheckReq);

    @POST("api/repairProject/getApiRepairProjectIncidentAcceptanceInfo")
    Single<BaseResponse<ApiRepairIncidentInfoRes>> getApiRepairProjectIncidentAcceptanceInfo(@Body RepairAcceptanceReq repairAcceptanceReq);

    @POST("api/repairProject/getApiRepairProjectIncidentAcceptanceList")
    Single<BaseResponse<List<ApiRepairProjectListItem>>> getApiRepairProjectIncidentAcceptanceList(@Body RepairAcceptanceReq repairAcceptanceReq);

    @POST("api/repairProject/getApiRepairProjectIncidentInfo")
    Single<BaseResponse<ApiRepairIncidentInfoRes>> getApiRepairProjectIncidentInfo(@Body RepairIncidentReq repairIncidentReq);

    @POST("api/repairProject/getApiRepairProjectInfo")
    Single<BaseResponse<ApiRepairProjectInfoRes>> getApiRepairProjectInfo(@Body RepairProjectReq repairProjectReq);

    @POST("api/repairProject/getApiRepairProjectList")
    Single<BaseResponse<List<ApiRepairProjectListItem>>> getApiRepairProjectList(@Body RepairProjectReq repairProjectReq);

    @POST("apis/patrolProblem/getAssignTypeList")
    Single<BaseResponse<List<ProblemStatusListItem>>> getAssignTypeList(@Body ProjectTypeListReq projectTypeListReq);

    @POST("api/patrolEvent/getDecomposedPatrolEventList")
    Single<BaseResponse<List<ProblemManageListItem>>> getAwaitDecomposePatrolProblemList(@Body ProblemManageListReq problemManageListReq);

    @POST("api/bridgeInspect/getBridgeInspectNumber")
    Single<BaseResponse<BridgeInspectNumberRes>> getBridgeInspectNumber(@Body BridgeReq bridgeReq);

    @POST("api/bridgeInspect/getBridgeInspectRecordInfo")
    Single<BaseResponse<BridgeInspectRecordInfoRes>> getBridgeInspectRecordInfo(@Body ClosePatrolEventReq closePatrolEventReq);

    @POST("api/bridgeInspect/getBridgeInspectRecordList")
    Single<BaseResponse<List<BridgeInspectTaskListItem>>> getBridgeInspectRecordList(@Body BridgeReq bridgeReq);

    @POST("api/bridgeInspect/getBridgeInspectTaskList")
    Single<BaseResponse<List<BridgeInspectTaskListItem>>> getBridgeInspectTaskList(@Body BridgeReq bridgeReq);

    @POST("api/patrolProblemComment/getCommentPatrolProblemList")
    Single<PatrolProblemRecordListRes> getCommentPatrolProblemList(@Body CommentPatrolProblemListReq commentPatrolProblemListReq);

    @POST("index.php/cashier/order.ThirdParty/getCouponInfo")
    Single<BaseResponse<BaseDataRes<Coupon2Res>>> getCouponInfo2(@Body CouponDyReq couponDyReq);

    @POST("index.php/cashier/order.HallCart/getCouponList")
    Single<BaseResponse<BaseDataRes<List<CoupomRes>>>> getCouponList(@Body OrderInfo2Req orderInfo2Req);

    @POST("index.php/cashier/order.ThirdParty/getCouponList")
    Single<BaseResponse<BaseDataRes<List<CouponItem>>>> getCouponListDyMt(@Body MoveProductReq moveProductReq);

    @POST("api/personnelSignIn/getCurrentDatePatrolPersonnelSignInTaskList")
    Single<BaseResponse<List<CurrentDatePatrolPersonnelSignInTaskListItem>>> getCurrentDatePatrolPersonnelSignInTaskList(@Body CurrentDatePatrolPersonnelSignInTaskListReq currentDatePatrolPersonnelSignInTaskListReq);

    @POST("api/report/getDeptPatrolReportList")
    Single<BaseResponse<List<DeptPatrolReportListItem>>> getDeptPatrolReportList(@Body PatrolReportListReq patrolReportListReq);

    @POST("api/report/getDeptReportPatrolRecordList")
    Single<PatrolProblemRecordListRes> getDeptReportPatrolRecordList(@Body PatrolProblemRecordListReq patrolProblemRecordListReq);

    @POST("index.php/cashier/product.product/getDeviceCode")
    Single<BaseResponse<BaseListRes<DeviceCodeItem>>> getDeviceCode(@Body HallCartReq hallCartReq);

    @POST("api/dict/getDictionaryList")
    Single<BaseResponse<List<DictionaryListItem>>> getDictionaryList(@Body DictionaryListReq dictionaryListReq);

    @POST("api/examineLeaderboard/getExamineObjectList")
    Single<BaseResponse<List<ExamineObjectListItem>>> getExamineObjectList(@Body ExamineObjectListReq examineObjectListReq);

    @POST("api/examineLeaderboard/getExamineQuarterList")
    Single<BaseResponse<List<ExamineQuarterListItem>>> getExamineQuarterList(@Body ExamineObjectListReq examineObjectListReq);

    @POST("api/examineLeaderboard/getExamineReportList")
    Single<ExamineReportListRes> getExamineReportList(@Body ExamineReportListReq examineReportListReq);

    @POST("api/examineLeaderboard/getExamineTypeList")
    Single<BaseResponse<List<ExamineObjectListItem>>> getExamineTypeList(@Body ExamineObjectListReq examineObjectListReq);

    @POST("api/report/getFiveColorWarningReport")
    Single<BaseResponse<List<FiveColorWarningReportItem>>> getFiveColorWarningReport(@Body FiveColorWarningReportReq fiveColorWarningReportReq);

    @POST("api/report/getFiveColorWarningWorkOrderList")
    Single<PatrolProblemRecordListRes> getFiveColorWarningWorkOrderList(@Body FiveColorWarningWorkOrderListReq fiveColorWarningWorkOrderListReq);

    @POST("index.php/cashier/order.HallCart/getGroupCouponList")
    Single<BaseResponse<BaseDataRes<List<CouponItem>>>> getGroupCouponList(@Body OrderInfo2Req orderInfo2Req);

    @POST("index.php/cashier/order.ThirdParty/getGroupTypeList")
    Single<BaseResponse<BaseListRes<GroupTypeItem>>> getGroupTypeList();

    @POST("api/highwayPatrol/getHighwayPatrolConfig")
    Single<BaseResponse<HighwayPatrolConfigRes>> getHighwayPatrolConfig(@Body ProjectOrgProcessAreaReq projectOrgProcessAreaReq);

    @POST("api/highwayPatrolTask/getHighwayPatrolTaskCodeApi")
    Single<BaseResponse<String>> getHighwayPatrolTaskCodeApi(@Body HighwayPatrolTaskCodeApiReq highwayPatrolTaskCodeApiReq);

    @POST("api/highwayPatrolTask/getHighwayPatrolTaskDataApi")
    Single<BaseResponse<HighwayPatrolTaskDataApiRes>> getHighwayPatrolTaskDataApi(@Body HighwayPatrolTaskDataApiReq highwayPatrolTaskDataApiReq);

    @POST("api/highwayPatrolTask/getHighwayPatrolTaskGroupListApi")
    Single<BaseResponse<List<HighwayPatrolTaskTreeApiItem>>> getHighwayPatrolTaskGroupListApi(@Body HighwayPatrolTaskTreeApiReq highwayPatrolTaskTreeApiReq);

    @POST("api/highwayPatrolTask/getHighwayPatrolTaskInfoApi")
    Single<BaseResponse<HighwayPatrolTaskInfoApiRes>> getHighwayPatrolTaskInfoApi(@Body HighwayPatrolTaskInfoApiReq highwayPatrolTaskInfoApiReq);

    @POST("api/highwayPatrolTask/getHighwayPatrolTaskListApi")
    Single<BaseResponse<List<HighwayPatrolTaskTreeApiItem>>> getHighwayPatrolTaskListApi(@Body HighwayPatrolTaskListApiReq highwayPatrolTaskListApiReq);

    @POST("api/highwayPatrolTask/getHighwayPatrolTaskRecordListApi")
    Single<BaseResponse<List<HighwayPatrolTaskTreeApiItem>>> getHighwayPatrolTaskRecordListApi(@Body PatrolTaskRecordListApiReq patrolTaskRecordListApiReq);

    @POST("api/highwayPatrolTask/getHighwayPatrolTaskStatusNumber")
    Single<BaseResponse<HighwayPatrolTaskStatusNumberRes>> getHighwayPatrolTaskStatusNumber(@Body HighwayPatrolTaskTreeApiReq highwayPatrolTaskTreeApiReq);

    @POST("api/highwayPatrolTask/getHighwayPatrolTaskTreeApi")
    Single<BaseResponse<List<HighwayPatrolTaskTreeApiItem>>> getHighwayPatrolTaskTreeApi(@Body HighwayPatrolTaskTreeApiReq highwayPatrolTaskTreeApiReq);

    @POST("api/highwayPatrolTask/getHighwayPatrolTaskingApi")
    Single<BaseResponse<HighwayPatrolTaskingApiRes>> getHighwayPatrolTaskingApi(@Body HighwayPatrolTaskingApiReq highwayPatrolTaskingApiReq);

    @POST("api/highwayPatrolTask/getHighwayPatrolTaskingDataApi")
    Single<BaseResponse<HighwayPatrolTaskingApiRes>> getHighwayPatrolTaskingDataApi(@Body HighwayPatrolTaskingApiReq highwayPatrolTaskingApiReq);

    @POST("api/patrolEvent/getHistoryPatrolEventList")
    Single<ProblemManageListRes> getHistoryPatrolProblemList(@Body ProblemManageListReq problemManageListReq);

    @POST("apis/region/getLocationInfo")
    Single<BaseResponse<RegionByAddressRes>> getLocationInfo(@Body AutoPatrolSignInReq autoPatrolSignInReq);

    @POST("api/object/getLocationStation")
    Single<BaseResponse<String>> getLocationStation(@Body InsertPatrolEventProcessByMySelfReq insertPatrolEventProcessByMySelfReq);

    @POST("api/patrolEvent/getManageUnitList")
    Single<BaseResponse<List<OrgCodeItem>>> getManageUnitList(@Body ManageUnitListReq manageUnitListReq);

    @POST("api/personnelSignIn/getMapPatrolPersonnelSignInTaskList")
    Single<BaseResponse<List<CurrentDatePatrolPersonnelSignInTaskListItem>>> getMapPatrolPersonnelSignInTaskList(@Body MapPatrolPersonnelSignInTaskListReq mapPatrolPersonnelSignInTaskListReq);

    @POST("index.php/cashier/order.ThirdParty/getMeiTuanCouponInfo")
    Single<BaseResponse<BaseDataRes<Coupon2Res>>> getMeiTuanCouponInfo(@Body CouponDyReq couponDyReq);

    @POST("apis/patrolProblem/getNearByPatrolPersonnelList")
    Single<BaseResponse<List<PersonnelItem>>> getNearByPatrolPersonnelList(@Body PatrolPersonneReq patrolPersonneReq);

    @POST("api/bridgeInspect/getNeedToCheckPartList")
    Single<BaseResponse<List<NeedToCheckPartListItem>>> getNeedToCheckPartList(@Body BridgeInspectRecordInfoReq bridgeInspectRecordInfoReq);

    @POST("api/object/getObjectList")
    Single<BaseResponse<List<GetObjectListItem>>> getObjectList(@Body GetObjectListReq getObjectListReq);

    @POST("api/objectRoad/getObjectRoadInfo")
    Single<BaseResponse<ObjectRoadInfoRes>> getObjectRoadInfo(@Body ObjectRoadInfoReq objectRoadInfoReq);

    @POST("api/objectRoad/getObjectRoadList")
    Single<BaseResponse<List<ObjectRoadListItem>>> getObjectRoadList(@Body ObjectRoadListReq objectRoadListReq);

    @POST("api/patrolPersonnel/getOnlineStatus")
    Single<BaseResponse<OnlineStatusRes>> getOnlineStatus(@Body ProjectTypeListReq projectTypeListReq);

    @POST("index.php/cashier/order.HallCart/getOrderInfo")
    Single<BaseResponse<BaseDataRes<OrderInfoRes>>> getOrderInfo(@Body OrderInfo2Req orderInfo2Req);

    @POST("index.php/cashier/order.HallCart/getPackCouponList")
    Single<BaseResponse<BaseDataRes<List<CoupomRes>>>> getPackCouponList(@Body OrderInfo2Req orderInfo2Req);

    @POST("api/partsDisease/getPartsDiseaseList")
    Single<BaseResponse<List<PartsDiseaseListItem>>> getPartsDiseaseList(@Body PartsDiseaseListReq partsDiseaseListReq);

    @POST("api/partsDisease/getPartsDiseaseResults")
    Single<BaseResponse<List<PartsDiseaseResultsItem>>> getPartsDiseaseResults(@Body PartsDiseaseResultsreq partsDiseaseResultsreq);

    @POST("api/patrolEvent/getPatrolEventList")
    Single<BaseResponse<List<PatrolEventListItem>>> getPatrolEventList(@Body PatrolEventListReq patrolEventListReq);

    @POST("api/diseaseEventReport/getPatrolEventListApi")
    Single<BaseResponse<List<PatrolEventListApiItem>>> getPatrolEventListApi(@Body PatrolEventListApiReq patrolEventListApiReq);

    @POST("api/patrolEvent/getPatrolEventStatusList")
    Single<BaseResponse<List<PatrolEventStatusListItem>>> getPatrolEventStatusList(@Body PatrolEventStatusListReq patrolEventStatusListReq);

    @POST("api/report/getPatrolManageReportList")
    Single<BaseResponse<List<PatrolManageReportListItem>>> getPatrolManageReportList(@Body PatrolManageReportListReq patrolManageReportListReq);

    @POST("api/patrolMap/getPatrolMapPatrolDataList")
    Single<BaseResponse<List<PatrolMapPatrolDataListItem>>> getPatrolMapPatrolDataList(@Body PatrolMapPatrolDataListReq patrolMapPatrolDataListReq);

    @POST("api/patrolMap/getPatrolMapPatrolTypeList")
    Single<BaseResponse<List<PatrolMapPatrolTypeListItem>>> getPatrolMapPatrolTypeList(@Body PatrolMapPatrolTypeListReq patrolMapPatrolTypeListReq);

    @POST("api/patrolobject/getPatrolObjectByMap")
    Single<BaseResponse<List<PatrolObjectByMapItem>>> getPatrolObjectByMap(@Body PatrolObjectByMapReq patrolObjectByMapReq);

    @POST("api/patrolobject/getPatrolObjectTreeByMap")
    Single<BaseResponse<List<PatrolObjectTreeByMapItem>>> getPatrolObjectTreeByMap(@Body PatrolObjectTreeByMapReq patrolObjectTreeByMapReq);

    @POST("api/patrolPersonnelMap/getPatrolPersonnelLocationGroupList")
    Single<BaseResponse<String>> getPatrolPersonnelLocationGroupList(@Body PatrolPersonnelLocationGroupListReq patrolPersonnelLocationGroupListReq);

    @POST("api/patrolPersonnel/getPatrolPersonnelRealTimeInfoList")
    Single<BaseResponse<List<PatrolPersonnelRealTimeInfoListItem>>> getPatrolPersonnelRealTimeInfoList(@Body PatrolPersonnelRealTimeInfoListReq patrolPersonnelRealTimeInfoListReq);

    @POST("api/patrolPersonnel/getPatrolPersonnelReportList")
    Single<PatrolPersonnelReportListRes> getPatrolPersonnelReportList(@Body PatrolPersonnelReportListReq patrolPersonnelReportListReq);

    @POST("api/personnelSignInPointRecord/getPatrolPersonnelSignInPointRecordInfo")
    Single<BaseResponse<PatrolPersonnelSignInPointRecordInfoRes>> getPatrolPersonnelSignInPointRecordInfo(@Body PatrolPersonnelSignInPointRecordInfoReq patrolPersonnelSignInPointRecordInfoReq);

    @POST("api/patrolProblem/getPatrolProblemIssueOpinionList")
    Single<PatrolProblemIssueOpinionListRes> getPatrolProblemIssueOpinionList(@Body PatrolProblemIssueOpinionListReq patrolProblemIssueOpinionListReq);

    @POST("api/report/getPatrolProblemPatrolTypeReportList")
    Single<BaseResponse<List<PatrolProblemPatrolTypeReportListItem>>> getPatrolProblemPatrolTypeReportList(@Body PatrolProblemPatrolTypeReportListReq patrolProblemPatrolTypeReportListReq);

    @POST("apis/patrolProblem/getPatrolProblemRecordList")
    Single<PatrolProblemRecordListRes> getPatrolProblemRecordList(@Body PatrolProblemRecordListReq patrolProblemRecordListReq);

    @POST("api/messageWarning/getPatrolProblemWarningMessageList")
    Single<BaseResponse<PatrolProblemWarningMessageListRes>> getPatrolProblemWarningMessageList(@Body PatrolProblemWarningMessageListReq patrolProblemWarningMessageListReq);

    @POST("api/report/getPatrolTypeReportPatrolRecordList")
    Single<PatrolProblemRecordListRes> getPatrolTypeReportPatrolRecordList(@Body ReportPatrolProblemRecordListReq reportPatrolProblemRecordListReq);

    @POST("index.php/cashier/order.HallCart/getPaymentMethod")
    Single<BaseResponse<BaseDataRes<List<CouponItem>>>> getPaymentMethod(@Body HallCartReq hallCartReq);

    @POST("api/personnelAttendance/getPersonnelAttendanceRecord")
    Single<BaseResponse<PersonnelAttendanceRecordRes>> getPersonnelAttendanceRecord(@Body PersonnelAttendanceRecordReq personnelAttendanceRecordReq);

    @POST("api/patrolPersonnelMap/getPersonnelLocationList")
    Single<BaseResponse<List<PersonnelLocationListItem>>> getPersonnelLocationList(@Body PersonnelLocationListReq personnelLocationListReq);

    @POST("api/personnelSignInPointRecord/getPersonnelSignInRecordList")
    Single<PatrolSignInPointRecordListRes> getPersonnelSignInRecordList(@Body PatrolSignInPointRecordListReq patrolSignInPointRecordListReq);

    @POST("api/patrolPersonnelMap/getPersonnelTrajectoryList")
    Single<BaseResponse<List<PersonnelTrajectoryListItem>>> getPersonnelTrajectoryList(@Body PersonnelTrajectoryListReq personnelTrajectoryListReq);

    @POST("api/patrolEvent/getPatrolEventInfo")
    Single<BaseResponse<ProblemManageInfoRes>> getProblemManageInfo(@Body ManagePatrolEventReq managePatrolEventReq);

    @POST("api/patrolEvent/getPatrolEventManageList")
    Single<BaseResponse<List<ProblemManageListItem>>> getProblemManageList(@Body ProblemManageListReq problemManageListReq);

    @POST("apis/patrolProblem/getProblemOperationRecordList")
    Single<ProblemOperationRecordListRes> getProblemOperationRecordList(@Body ProblemOperationRecordListReq problemOperationRecordListReq);

    @POST("apis/patrolProblem/getProblemStatusList")
    Single<BaseResponse<List<ProblemStatusListItem>>> getProblemStatusList(@Body ProblemStatusListReq problemStatusListReq);

    @POST("api/projectOrg/getProjectOrgProcessArea")
    Single<BaseResponse<List<ProjectOrgProcessAreaItem>>> getProjectOrgProcessArea(@Body ProjectOrgProcessAreaReq projectOrgProcessAreaReq);

    @POST("api/patrolProjectType/getProjectTypeFieldList")
    Single<BaseResponse<List<ProjectTypeFieldListItem>>> getProjectTypeFieldList(@Body ProjectTypeFieldListReq projectTypeFieldListReq);

    @POST("api/patrolProjectType/getProjectTypeList")
    Single<BaseResponse<List<ProjectTypeListItem>>> getProjectTypeList(@Body ProjectTypeListReq projectTypeListReq);

    @POST("api/patrolProjectType/getProjectTypeMenuList")
    Single<BaseResponse<List<MenuItem>>> getProjectTypeMenuList(@Body ProjectTypeMenuListReq projectTypeMenuListReq);

    @POST("api/highwayPatrolTask/getRecentlyObjectApi")
    Single<BaseResponse<RecentlyObjectRes>> getRecentlyObjectApi(@Body HighwayPatrolTaskCodeApiReq highwayPatrolTaskCodeApiReq);

    @POST("api/region/getRegionByAddress")
    Single<BaseResponse<RegionByAddressRes>> getRegionByAddress(@Body RegionByAddressReq regionByAddressReq);

    @POST("api/region/getRegionListByMap")
    Single<BaseResponse<List<RegionListByMapItem>>> getRegionListByMap(@Body RegionListByMapReq regionListByMapReq);

    @POST("apis/projectOrg/getProjectOrgProcessArea")
    Single<BaseResponse<List<ProvinceListItem>>> getRegionTreeByMap(@Body PatrolEventStatusListReq patrolEventStatusListReq);

    @POST("api/report/getManageReportPatrolRecordList")
    Single<PatrolProblemRecordListRes> getReportPatrolProblemRecordList(@Body ReportPatrolProblemRecordListReq reportPatrolProblemRecordListReq);

    @POST("api/personnelSignInPointRecord/getSignInPointSignInRecordList")
    Single<PatrolSignInPointRecordListRes> getSignInPointSignInRecordList(@Body PatrolSignInPointRecordListReq patrolSignInPointRecordListReq);

    @POST("api/patrolSortContent/getSortContentByMap")
    Single<BaseResponse<List<SortContentByMapItem>>> getSortContentByMap(@Body SortContentByMapReq sortContentByMapReq);

    @POST("api/patrolSortContent/getSortContentTreeByMap")
    Single<BaseResponse<List<SortContentTreeByMapItem>>> getSortContentTreeByMap(@Body SortContentTreeByMapReq sortContentTreeByMapReq);

    @POST("apis/patrolProblem/getSpecialPatrolProblemRecordList")
    Single<PatrolProblemRecordListRes> getSpecialPatrolProblemRecordList(@Body SpecialPatrolProblemRecordListReq specialPatrolProblemRecordListReq);

    @POST("apis/patrolProblem/getSubmitProblemInfo")
    Single<BaseResponse<SubmitProblemInfoRes>> getSubmitProblemInfo(@Body SubmitProblemInfoReq submitProblemInfoReq);

    @POST("index.php/cashier/store.table/getTableStatusNum")
    Single<BaseResponse<BaseDataRes<TableStatusReq>>> getTableStatusNum(@Body ApiTableReq apiTableReq);

    @POST("api/patrolEvent/getAuditUnitPatrolEventList")
    Single<BaseResponse<List<ProblemManageListItem>>> getToCompletedPatrolProblemList(@Body ProblemManageListReq problemManageListReq);

    @POST("api/report/getTownPatrolReportList")
    Single<BaseResponse<List<TownPatrolReportListItem>>> getTownPatrolReportList(@Body PatrolReportListReq patrolReportListReq);

    @POST("api/report/getTownReportPatrolRecordList")
    Single<PatrolProblemRecordListRes> getTownReportPatrolRecordList(@Body PatrolProblemRecordListReq patrolProblemRecordListReq);

    @POST("index.php/device/tableDevice.tableDevice/getVensionInfo")
    Single<BaseResponse<BaseDataRes<VersionRes>>> getVensionInfo(@Body VersionReq versionReq);

    @POST("api/region/getVillageRegionListByMap")
    Single<BaseResponse<List<RegionListByMapItem>>> getVillageRegionListByMap(@Body VillageRegionListByMapReq villageRegionListByMapReq);

    @POST("index.php/cashier/order.HallCart/add")
    Single<BaseResponse<Object>> hallCartAdd(@Body HallCart3Req hallCart3Req);

    @POST("index.php/cashier/order.HallCart/cancel")
    Single<BaseResponse<Object>> hallCartCancel(@Body HallCartReq hallCartReq);

    @POST("index.php/cashier/order.HallCart/delete")
    Single<BaseResponse<Object>> hallCartDelete(@Body HallCartReq hallCartReq);

    @POST("index.php/cashier/order.HallCart/list")
    Single<BaseResponse<HallCartlistRes>> hallCartList(@Body HallCartReq hallCartReq);

    @POST("index.php/cashier/order.HallCart/sub")
    Single<BaseResponse<Object>> hallCartSub(@Body HallCartReq hallCartReq);

    @POST("api/highwayPatrolTask/highwayPatrolTaskTimeJudge")
    Single<BaseResponse<BridgeInspectTaskListItem>> highwayPatrolTaskTimeJudge(@Body HighwayPatrolTaskInfoApiReq highwayPatrolTaskInfoApiReq);

    @POST("index.php/cashier/index/index")
    Single<BaseResponse<IndexIndexRes>> indexIndex(@Body HallCartReq hallCartReq);

    @POST("api/bridgeInspect/insertBridgeInspectEvent")
    Single<BaseResponse<String>> insertBridgeInspectEvent(@Body InsertPatrolEventProcessByMySelfReq insertPatrolEventProcessByMySelfReq);

    @POST("api/highwayPatrolTask/insertHighwayPatrolTaskRecord")
    Single<BaseResponse<String>> insertHighwayPatrolTaskRecord(@Body InsertPatrolTaskRecordReq insertPatrolTaskRecordReq);

    @POST("api/highwayPatrolTask/insertHighwayPatrolTaskTrajectoryApi")
    Single<BaseResponse<String>> insertHighwayPatrolTaskTrajectoryApi(@Body HighwayPatrolTaskTrajectoryApiReq highwayPatrolTaskTrajectoryApiReq);

    @POST("api/highwayPatrolTask/insertHighwayPatrolTaskTrajectoryListApi")
    Single<BaseResponse<InsertPatrolTrajectoryReq>> insertHighwayPatrolTaskTrajectoryListApi(@Body InsertPatrolTrajectoryReq insertPatrolTrajectoryReq);

    @POST("api/diseaseEventReport/insertPatrolEvent")
    Single<BaseResponse<String>> insertPatrolEvent(@Body InsertPatrolEventReq insertPatrolEventReq);

    @POST("api/diseaseEventReport/insertPatrolEventProcessByMySelf")
    Single<BaseResponse<String>> insertPatrolEventProcessByMySelf(@Body InsertPatrolEventProcessByMySelfReq insertPatrolEventProcessByMySelfReq);

    @POST("apis/patrolProblem/insertPatrolProblem")
    Single<BaseResponse<String>> insertPatrolProblem(@Body InsertPatrolProblemReq insertPatrolProblemReq);

    @POST("api/patrolProblemComment/insertPatrolProblemComment")
    Single<BaseResponse<String>> insertPatrolProblemComment(@Body InsertPatrolProblemCommentReq insertPatrolProblemCommentReq);

    @POST("apis/patrolProblem/insertPatrolProblemManageByMyself")
    Single<BaseResponse<String>> insertPatrolProblemManageByMyself(@Body InsertPatrolProblemManageByMyselfReq insertPatrolProblemManageByMyselfReq);

    @POST("api/patrolPersonnel/insertPersonnelDeviceRecord")
    Single<BaseResponse<String>> insertPersonnelDeviceRecord(@Body InsertPersonnelDeviceRecordReq insertPersonnelDeviceRecordReq);

    @POST("apis/collection/insertPointInfoApi")
    Single<BaseResponse<String>> insertPointInfoApi(@Body InsertPointInfoRes insertPointInfoRes);

    @POST("api/repairProject/insertRepairProjectCheck")
    Single<BaseResponse<String>> insertRepairProjectCheck(@Body RepairProjectCheckReq repairProjectCheckReq);

    @POST("api/repairProject/insertRepairProjectCheckRectification")
    Single<BaseResponse<String>> insertRepairProjectCheckRectification(@Body RepairProjectCheckRectificationReq repairProjectCheckRectificationReq);

    @POST("api/repairProject/insertRepairProjectIncidentAcceptanceManage")
    Single<BaseResponse<String>> insertRepairProjectIncidentAcceptanceManage(@Body ManagePatrolEventReq managePatrolEventReq);

    @POST("api/repairProject/insertRepairProjectIncidentManageRecord")
    Single<BaseResponse<String>> insertRepairProjectIncidentManageRecord(@Body ManagePatrolEventReq managePatrolEventReq);

    @POST("api/repairProject/insertRepairProjectIncidentTailRecord")
    Single<BaseResponse<String>> insertRepairProjectIncidentTailRecord(@Body IncidentTailRecordReq incidentTailRecordReq);

    @POST("apis/collection/insertTrackListApi")
    Single<BaseResponse<String>> insertTrackListApi(@Body InsertPointInfoRes insertPointInfoRes);

    @POST("api/patrolProblem/issuePatrolProblemOpinion")
    Single<BaseResponse<String>> issuePatrolProblemOpinion(@Body IssuePatrolProblemOpinionReq issuePatrolProblemOpinionReq);

    @POST("index.php/cashier/order.Order/mergeTable")
    Single<BaseResponse<Object>> mergeTable(@Body MergeTableReq mergeTableReq);

    @POST("index.php/cashier/order.Order/microRefund")
    Single<BaseResponse<Object>> microRefund(@Body ScanPayReq scanPayReq);

    @POST("index.php/cashier/order.order/moveProduct")
    Single<BaseResponse<Object>> moveProduct(@Body MoveProductReq moveProductReq);

    @POST("index.php/cashier/order.Order/newPay")
    Single<BaseResponse<Object>> newPay(@Body OrderInfo2Req orderInfo2Req);

    @POST("index.php/cashier/order.HallCart/open")
    Single<BaseResponse<Object>> open(@Body HallCartReq hallCartReq);

    @POST("index.php/cashier/order.Cart/openScan")
    Single<BaseResponse<Object>> openScan(@Body HallCartReq hallCartReq);

    @POST("index.php/cashier/order.HallCart/cancel")
    Single<BaseResponse<Object>> orderCancel(@Body HallCartReq hallCartReq);

    @POST("index.php/cashier/order.HallCart/detail")
    Single<BaseResponse<HallCartDetailRes>> orderDetail(@Body HallCartReq hallCartReq);

    @POST("index.php/cashier/order.OrderDetail/OrderProductDetail")
    Single<BaseResponse<BaseListDataRes<BaseDataRes<List<OrderDetailListItem>>>>> orderDetailList(@Body OrderInfo2Req orderInfo2Req);

    @POST("index.php/cashier/order.OrderDetail/OrderList")
    Single<BaseResponse<BaseDataRes<BaseListDataRes<BaseDataListRes<OrderListItem>>>>> orderList(@Body OrderListReq orderListReq);

    @POST("api/personnelSignIn/patrolPersonnelSignIn")
    Single<BaseResponse<String>> patrolPersonnelSignIn(@Body PatrolPersonnelSignInReq patrolPersonnelSignInReq);

    @POST("api/personnelSignIn/patrolPersonnelSignInSavePhoto")
    Single<BaseResponse<String>> patrolPersonnelSignInSavePhoto(@Body PatrolPersonnelSignInSavePhotoReq patrolPersonnelSignInSavePhotoReq);

    @POST("index.php/cashier/order.OrderDetail/permissionList")
    Single<BaseResponse<BaseListRes<PermissionItem>>> permissionList();

    @POST("api/patrolProblem/preClosurePatrolProblem")
    Single<BaseResponse<String>> preClosurePatrolProblem(@Body PreClosurePatrolProblemReq preClosurePatrolProblemReq);

    @POST("api/highwayPatrolTask/previewHighwayPatrolTaskListApi")
    Single<BaseResponse<HighwayPatrolTaskInfoApiRes>> previewHighwayPatrolTaskListApi(@Body HighwayPatrolTaskInfoApiReq highwayPatrolTaskInfoApiReq);

    @POST("index.php/cashier/order.OrderDetail/printOrder")
    Single<BaseResponse<Object>> printOrder(@Body OrderInfo2Req orderInfo2Req);

    @POST("index.php/cashier/product.product/index")
    Single<BaseResponse<HallCartRes>> productIndex(@Body ProductReq productReq);

    @POST("index.php/cashier/order.HallCart/productPass")
    Single<BaseResponse<Object>> productPass(@Body MoveProductReq moveProductReq);

    @POST("index.php/cashier/order.HallCart/productPassRollback")
    Single<BaseResponse<Object>> productPassRollback(@Body MoveProductReq moveProductReq);

    @POST("apis/collection/projectObjectFirstListApi")
    Single<BaseResponse<List<ProjectObjectFirstListItem>>> projectObjectFirstListApi(@Body RepairProjectCheckRectificationReq repairProjectCheckRectificationReq);

    @POST("apis/collection/projectObjectListApi")
    Single<BaseResponse<List<ProjectObjectFirstListItem>>> projectObjectListApi(@Body ProjectObjectFirstListItem projectObjectFirstListItem);

    @POST("apis/collection/recaptureApi")
    Single<BaseResponse<List<CollectionTodaItem>>> recaptureApi(@Body InsertPointInfoRes insertPointInfoRes);

    @POST("index.php/cashier/order.ThirdParty/refundCouponNew")
    Single<BaseResponse<Object>> refundCoupon(@Body CouponDyReq couponDyReq);

    @POST("index.php/cashier/order.ThirdParty/refundMeituanCoupon")
    Single<BaseResponse<Object>> refundMeituanCoupon(@Body CouponDyReq couponDyReq);

    @POST("index.php/cashier/order.OrderCoupon/refundOrderCoupon")
    Single<BaseResponse<Object>> refundOrderCoupon(@Body CouponDyReq couponDyReq);

    @POST("api/highwayPatrolTask/restartHighwayPatrolTaskApi")
    Single<BaseResponse<RestartPatrolTaskRes>> restartHighwayPatrolTaskApi(@Body HighwayPatrolTaskApiReq highwayPatrolTaskApiReq);

    @POST("apis/patrolProblem/returnProblemMange")
    Single<BaseResponse<String>> returnProblemMange(@Body ReturnProblemMangeReq returnProblemMangeReq);

    @POST("index.php/cashier/order.Cart/saveScanInfo")
    Single<BaseResponse<Object>> saveScanInfo(@Body HallCartReq hallCartReq);

    @POST("index.php/cashier/order.Order/ScanPay")
    Single<BaseResponse<BaseDataRes<ScanPayRes>>> scanPay(@Body ScanPayReq scanPayReq);

    @POST("index.php/cashier/order.Order/ScanPayQuery")
    Single<BaseResponse<BaseResuleRes<ScanPayRes>>> scanPayQuery(@Body ScanPayReq scanPayReq);

    @POST("api/personnelAttendance/selectAttendancePersonnelFenceList")
    Single<BaseResponse<SelectAttendancePersonnelFenceListRes>> selectAttendancePersonnelFenceList(@Body SelectAttendancePersonnelFenceListReq selectAttendancePersonnelFenceListReq);

    @POST("api/personnelAttendance/selectAttendancePersonnelFenceListByDate")
    Single<BaseResponse<List<SelectAttendancePersonnelFenceListByDateItem>>> selectAttendancePersonnelFenceListByDate(@Body SelectAttendancePersonnelFenceListByDateReq selectAttendancePersonnelFenceListByDateReq);

    @POST("api/highwayPatrolTask/startHighwayPatrolTaskApi")
    Single<BaseResponse<String>> startHighwayPatrolTaskApi(@Body HighwayPatrolTaskApiReq highwayPatrolTaskApiReq);

    @POST("api/highwayPatrolTask/stopHighwayPatrolTaskApi")
    Single<BaseResponse<String>> stopHighwayPatrolTaskApi(@Body HighwayPatrolTaskApiReq highwayPatrolTaskApiReq);

    @POST("api/patrolEvent/submitManagePatrolEvent")
    Single<BaseResponse<String>> submitManagePatrolEvent(@Body ManagePatrolEventReq managePatrolEventReq);

    @POST("api/personnelAttendance/submitPersonnelAttendance")
    Single<BaseResponse<String>> submitPersonnelAttendance(@Body SubmitPersonnelAttendanceReq submitPersonnelAttendanceReq);

    @POST("apis/patrolProblem/submitProblemMange")
    Single<BaseResponse<String>> submitProblemMange(@Body SubmitProblemMangeReq submitProblemMangeReq);

    @POST("index.php/cashier/store.table/area")
    Single<BaseResponse<BaseListDataRes<List<TableAreaItem>>>> tableArea(@Body ApiTableReq apiTableReq);

    @POST("index.php/cashier/order.Order/tableBuy")
    Single<BaseResponse<Object>> tableBuy(@Body HallCartaddReq hallCartaddReq);

    @POST("index.php/cashier/store.table/table")
    Single<BaseResponse<BaseListDataRes<List<TableAreaItem>>>> tableList(@Body ApiTableReq apiTableReq);

    @POST("api/highwayPatrolTask/updateGroup")
    Single<BaseResponse<String>> updateGroup(@Body CreateGroupReq createGroupReq);

    @POST("api/patrolProblem/updatePatrolProblemAsSpecialProblem")
    Single<BaseResponse<String>> updatePatrolProblemAsSpecialProblem(@Body UpdatePatrolProblemAsSpecialProblemReq updatePatrolProblemAsSpecialProblemReq);

    @POST("apis/collection/updatePointInfoApi")
    Single<BaseResponse<String>> updatePointInfoApi(@Body InsertPointInfoRes insertPointInfoRes);

    @POST("/index.php/cashier/order.HallCart/urgedishes")
    Single<BaseResponse<Object>> urgedishes(@Body MoveProductReq moveProductReq);

    @POST("index.php/cashier/order.ThirdParty/verifyCouponNew")
    Single<BaseResponse<Object>> verifyCoupon(@Body Coupon2Res coupon2Res);

    @POST("/index.php/cashier/order.ThirdParty/verifyMeituanCoupon")
    Single<BaseResponse<Object>> verifyMeituanCoupon(@Body Coupon2Res coupon2Res);

    @POST("apis/collection/weatherInfoApi")
    Single<BaseResponse<WeatherInfoRes>> weatherInfoApi(@Body AutoPatrolSignInReq autoPatrolSignInReq);
}
