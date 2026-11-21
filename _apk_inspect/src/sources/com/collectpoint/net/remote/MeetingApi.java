package com.collectpoint.net.remote;

import com.collectpoint.bean.AccountTreeItem;
import com.collectpoint.bean.DispatchGroupItem;
import com.collectpoint.bean.QuickLinkAccountTreeItem;
import com.collectpoint.bean.item.HWMeetingConfigInfo;
import com.collectpoint.bean.item.OrgCodeItem;
import com.collectpoint.bean.req.CreateMeetingReq;
import com.collectpoint.bean.req.ManageUnitListReq;
import com.collectpoint.bean.req.PatrolPersonnelRealTimeInfoListReq;
import com.collectpoint.bean.req.UpdateUserReq;
import com.collectpoint.bean.res.AccountTreeRes;
import com.collectpoint.bean.res.BaseResponse;
import com.collectpoint.bean.res.CreateMeetingRes;
import io.reactivex.Single;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes10.dex */
public interface MeetingApi {
    @POST("api/meeting/createMeeting")
    Single<BaseResponse<CreateMeetingRes>> createMeeting(@Body CreateMeetingReq createMeetingReq);

    @POST("api/dispatchGroup/dispatchGroupDelete")
    Single<BaseResponse<String>> dispatchGroupDelete(@Body DispatchGroupItem dispatchGroupItem);

    @POST("api/dispatchGroup/dispatchGroupInsert")
    Single<BaseResponse<String>> dispatchGroupInsert(@Body DispatchGroupItem dispatchGroupItem);

    @POST("api/dispatchGroup/dispatchGroupUpdate")
    Single<BaseResponse<String>> dispatchGroupUpdate(@Body DispatchGroupItem dispatchGroupItem);

    @POST("api/dispatchAccount/getDispatchAccountTree")
    Single<BaseResponse<List<AccountTreeItem>>> getDispatchAccountTree(@Body AccountTreeRes accountTreeRes);

    @POST("api/dispatchGroup/getDispatchGroupInfo")
    Single<BaseResponse<DispatchGroupItem>> getDispatchGroupInfo(@Body AccountTreeRes accountTreeRes);

    @POST("api/dispatchGroup/getDispatchGroupList")
    Single<BaseResponse<List<DispatchGroupItem>>> getDispatchGroupList(@Body AccountTreeRes accountTreeRes);

    @POST("api/hwMeeting/getHWMeetingConfigInfo")
    Single<BaseResponse<HWMeetingConfigInfo>> getHWMeetingConfigInfo(@Body UpdateUserReq updateUserReq);

    @POST("apis/patrolProblem/getManageUnitList")
    Single<BaseResponse<List<OrgCodeItem>>> getManageUnitList(@Body ManageUnitListReq manageUnitListReq);

    @POST("api/meeting/getMeetingApiAccessToken")
    Single<BaseResponse<String>> getMeetingApiAccessToken(@Body UpdateUserReq updateUserReq);

    @POST("api/meeting/getMeetingAttendeeList")
    Single<BaseResponse<CreateMeetingRes>> getMeetingAttendeeList(@Body CreateMeetingReq createMeetingReq);

    @POST("api/meeting/getOnlineMeetingList")
    Single<BaseResponse<List<CreateMeetingRes>>> getOnlineMeetingList(@Body CreateMeetingReq createMeetingReq);

    @POST("api/dispatchAccount/getQuickLinkAccountTree")
    Single<BaseResponse<List<QuickLinkAccountTreeItem>>> getQuickLinkAccountTree(@Body UpdateUserReq updateUserReq);

    @POST("api/dispatchAccount/getQuickLinkAccountTree")
    Single<BaseResponse<List<AccountTreeItem>>> getQuickLinkAccountTree(@Body AccountTreeRes accountTreeRes);

    @POST("api/meeting/inviteParticipants")
    Single<BaseResponse<String>> inviteParticipants(@Body CreateMeetingReq createMeetingReq);

    @POST("api/dispatchAccount/updateDispatchAccountOnLineStatus")
    Single<BaseResponse<String>> updateDispatchAccountOnLineStatust(@Body PatrolPersonnelRealTimeInfoListReq patrolPersonnelRealTimeInfoListReq);
}
