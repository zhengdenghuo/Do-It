package com.collectpoint.net.remote;

import com.collectpoint.bean.UserBean;
import com.collectpoint.bean.item.AchieveModeListItem;
import com.collectpoint.bean.item.CachedCollectPointListItem;
import com.collectpoint.bean.item.CollectObjectParameterListItem;
import com.collectpoint.bean.item.CollectObjectTypeListItem;
import com.collectpoint.bean.req.AddAppSoftUpdateNumberReq;
import com.collectpoint.bean.req.ApiLoginReq;
import com.collectpoint.bean.req.AppDownloadQRCodeReq;
import com.collectpoint.bean.req.BulletinListReq;
import com.collectpoint.bean.req.CollectObjectReq;
import com.collectpoint.bean.req.CollectPointReq;
import com.collectpoint.bean.req.InsertBulletinReq;
import com.collectpoint.bean.req.InsertCollectPointReq;
import com.collectpoint.bean.req.InsertFeedBackApiReq;
import com.collectpoint.bean.req.LocationUploadIntervalReq;
import com.collectpoint.bean.req.MobileLoginReq;
import com.collectpoint.bean.req.PublishBulletinInfoReq;
import com.collectpoint.bean.req.SendSmsReq;
import com.collectpoint.bean.req.SoftWareNewestVersionApiReq;
import com.collectpoint.bean.req.UpdateUserProjectOrgCodeReq;
import com.collectpoint.bean.req.UpdateUserPwdReq;
import com.collectpoint.bean.req.UpdateUserReq;
import com.collectpoint.bean.req.UpdateUserRoleCodeReq;
import com.collectpoint.bean.req.UserInfoReq;
import com.collectpoint.bean.res.AppDownloadQRCodeRes;
import com.collectpoint.bean.res.BaseResponse;
import com.collectpoint.bean.res.CachedCollectObjectInfoRes;
import com.collectpoint.bean.res.CollectObjectListRes;
import com.collectpoint.bean.res.CollectRecordListRes;
import com.collectpoint.bean.res.GraphicCodeRes;
import com.collectpoint.bean.res.LocationUploadIntervalRes;
import com.collectpoint.bean.res.SoftWareNewestVersionApiRes;
import com.collectpoint.bean.res.UpdateUserProjectOrgCodRes;
import com.collectpoint.bean.res.UpdateUserRoleCodeRes;
import io.reactivex.Single;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes10.dex */
public interface IUserApi {
    @POST("api/softWare/addAppSoftUpdateNumber")
    Single<BaseResponse<String>> addAppSoftUpdateNumber(@Body AddAppSoftUpdateNumberReq addAppSoftUpdateNumberReq);

    @POST("wxApi/collectPoint/deleteCollectPoint")
    Single<BaseResponse<String>> deleteCollectPoint(@Body CollectPointReq collectPointReq);

    @POST("wxApi/collectPoint/getAchieveModeList")
    Single<BaseResponse<List<AchieveModeListItem>>> getAchieveModeList(@Body CollectObjectReq collectObjectReq);

    @POST("api/appDownloadQRCode/getAppDownloadQRCode")
    Single<BaseResponse<AppDownloadQRCodeRes>> getAppDownloadQRCode(@Body AppDownloadQRCodeReq appDownloadQRCodeReq);

    @POST("api/bulletin/getBulletinList")
    Single<BaseResponse<String>> getBulletinList(@Body BulletinListReq bulletinListReq);

    @POST("wxApi/collectPoint/getCachedCollectObjectInfo")
    Single<BaseResponse<CachedCollectObjectInfoRes>> getCachedCollectObjectInfo(@Body CollectObjectReq collectObjectReq);

    @POST("wxApi/collectPoint/getCachedCollectPointList")
    Single<BaseResponse<List<CachedCollectPointListItem>>> getCachedCollectPointList(@Body CollectObjectReq collectObjectReq);

    @POST("wxApi/collectObject/getCollectObjectInfo")
    Single<BaseResponse<CachedCollectObjectInfoRes>> getCollectObjectInfo(@Body CollectObjectReq collectObjectReq);

    @POST("wxApi/collectObject/getCollectObjectList")
    Single<CollectObjectListRes> getCollectObjectList(@Body CollectObjectReq collectObjectReq);

    @POST("wxApi/collectObject/getCollectObjectParameterList")
    Single<BaseResponse<List<CollectObjectParameterListItem>>> getCollectObjectParameterList(@Body CollectObjectReq collectObjectReq);

    @POST("wxApi/collectObject/getCollectObjectTypeList")
    Single<BaseResponse<List<CollectObjectTypeListItem>>> getCollectObjectTypeList(@Body CollectObjectReq collectObjectReq);

    @POST("wxApi/collectPoint/getCollectPointInfo")
    Single<BaseResponse<CachedCollectPointListItem>> getCollectPointInfo(@Body CollectPointReq collectPointReq);

    @POST("wxApi/collectPoint/getCollectRecordList")
    Single<CollectRecordListRes> getCollectRecordList(@Body CollectObjectReq collectObjectReq);

    @POST("wxApi/collectPoint/getFrequencyList")
    Single<BaseResponse<List<AchieveModeListItem>>> getFrequencyList(@Body CollectObjectReq collectObjectReq);

    @POST("api/login/getGraphicCode")
    Single<BaseResponse<GraphicCodeRes>> getGraphicCode();

    @POST("api/locationUploadConfig/getLocationUploadInterval")
    Single<LocationUploadIntervalRes> getLocationUploadInterval(@Body LocationUploadIntervalReq locationUploadIntervalReq);

    @POST("api/bulletin/getPublishBulletinInfo")
    Single<BaseResponse<String>> getPublishBulletinInfo(@Body PublishBulletinInfoReq publishBulletinInfoReq);

    @POST("api/softWare/getSoftWareNewestVersionApi")
    Single<BaseResponse<SoftWareNewestVersionApiRes>> getSoftWareNewestVersionApi(@Body SoftWareNewestVersionApiReq softWareNewestVersionApiReq);

    @POST("api/user/getUserInfo")
    Single<BaseResponse<UserBean>> getUserInfo(@Body UserInfoReq userInfoReq);

    @POST("api/bulletin/insertBulletin")
    Single<BaseResponse<String>> insertBulletin(@Body InsertBulletinReq insertBulletinReq);

    @POST("wxApi/collectPoint/insertCollectPoint")
    Single<BaseResponse<String>> insertCollectPoint(@Body InsertCollectPointReq insertCollectPointReq);

    @POST("api/feeBack/insertFeedBackApi")
    Single<BaseResponse<String>> insertFeedBackApi(@Body InsertFeedBackApiReq insertFeedBackApiReq);

    @POST("index.php/cashier/passport/login")
    Single<BaseResponse<UserBean>> login(@Body ApiLoginReq apiLoginReq);

    @POST("api/login/mobileLogin")
    Single<BaseResponse<UserBean>> mobileLogin(@Body MobileLoginReq mobileLoginReq);

    @POST("api/sendSms/sendSms")
    Single<BaseResponse<String>> sendSms(@Body SendSmsReq sendSmsReq);

    @POST("wxApi/collectPoint/submitCollectObject")
    Single<BaseResponse<String>> submitCollectObject(@Body CollectObjectReq collectObjectReq);

    @POST("api/user/updateUser")
    Single<BaseResponse<String>> updateUser(@Body UpdateUserReq updateUserReq);

    @POST("api/user/updateUserProjectOrgCode")
    Single<BaseResponse<UpdateUserProjectOrgCodRes>> updateUserProjectOrgCode(@Body UpdateUserProjectOrgCodeReq updateUserProjectOrgCodeReq);

    @POST("api/login/updateUserPwd")
    Single<BaseResponse<UserBean>> updateUserPwd(@Body UpdateUserPwdReq updateUserPwdReq);

    @POST("api/user/updateUserRoleCode")
    Single<BaseResponse<UpdateUserRoleCodeRes>> updateUserRoleCode(@Body UpdateUserRoleCodeReq updateUserRoleCodeReq);
}
