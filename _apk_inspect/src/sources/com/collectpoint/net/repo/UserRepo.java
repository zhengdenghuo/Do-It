package com.collectpoint.net.repo;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.blankj.utilcode.util.CacheDiskUtils;
import com.blankj.utilcode.util.CacheDoubleUtils;
import com.blankj.utilcode.util.CacheMemoryUtils;
import com.collectpoint.bean.UserBean;
import com.collectpoint.bean.item.AchieveModeListItem;
import com.collectpoint.bean.item.CachedCollectPointListItem;
import com.collectpoint.bean.item.CollectObjectParameterListItem;
import com.collectpoint.bean.item.CollectObjectTypeListItem;
import com.collectpoint.bean.req.AddAppSoftUpdateNumberReq;
import com.collectpoint.bean.req.ApiLoginReq;
import com.collectpoint.bean.req.AppDownloadQRCodeReq;
import com.collectpoint.bean.req.CollectObjectReq;
import com.collectpoint.bean.req.CollectPointReq;
import com.collectpoint.bean.req.InsertCollectPointReq;
import com.collectpoint.bean.req.InsertFeedBackApiReq;
import com.collectpoint.bean.req.LocationUploadIntervalReq;
import com.collectpoint.bean.req.MobileLoginReq;
import com.collectpoint.bean.req.SendSmsReq;
import com.collectpoint.bean.req.SoftWareNewestVersionApiReq;
import com.collectpoint.bean.req.UpdateUserProjectOrgCodeReq;
import com.collectpoint.bean.req.UpdateUserPwdReq;
import com.collectpoint.bean.req.UpdateUserReq;
import com.collectpoint.bean.req.UpdateUserRoleCodeReq;
import com.collectpoint.bean.req.UserInfoReq;
import com.collectpoint.bean.res.AppDownloadQRCodeRes;
import com.collectpoint.bean.res.CachedCollectObjectInfoRes;
import com.collectpoint.bean.res.CollectObjectListRes;
import com.collectpoint.bean.res.GraphicCodeRes;
import com.collectpoint.bean.res.LocationUploadIntervalRes;
import com.collectpoint.bean.res.SoftWareNewestVersionApiRes;
import com.collectpoint.bean.res.UpdateUserProjectOrgCodRes;
import com.collectpoint.bean.res.UpdateUserRoleCodeRes;
import com.collectpoint.bean.res.UploadRes;
import com.collectpoint.constants.Constants;
import com.collectpoint.net.remote.IUserApi;
import com.collectpoint.net.remote.Resource;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.liuwq.base.util.FileTool;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class UserRepo {
    private static UserRepo sInstance;
    private IUserApi mApi;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private CacheDiskUtils mDiskUtils;
    private CacheDoubleUtils mDoubleCacheUtils;
    private CacheMemoryUtils mMemoryUtils;
    private RxHandler mRxHandler;

    private UserRepo(IUserApi iUserApi, Application application) {
        this.mApi = (IUserApi) Preconditions.checkNotNull(iUserApi);
        Context applicationContext = ((Application) Preconditions.checkNotNull(application)).getApplicationContext();
        this.mDiskUtils = CacheDiskUtils.getInstance(FileTool.getDiskCacheDir(applicationContext, Constants.DISK_CACHE_DIR_NAME));
        CacheMemoryUtils cacheMemoryUtils = CacheMemoryUtils.getInstance();
        this.mMemoryUtils = cacheMemoryUtils;
        this.mDoubleCacheUtils = CacheDoubleUtils.getInstance(cacheMemoryUtils, this.mDiskUtils);
        this.mRxHandler = RxHandler.getInstance(applicationContext);
    }

    public static UserRepo getInstance(IUserApi iUserApi, Application application) {
        if (sInstance == null) {
            synchronized (UserRepo.class) {
                if (sInstance == null) {
                    sInstance = new UserRepo(iUserApi, application);
                }
            }
        }
        return sInstance;
    }

    public Single<String> addAppSoftUpdateNumber(final int i) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda8
            public final Object apply(Object obj) {
                return this.f$0.m392xd6979745(i, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public void cleanLoggedInUser() {
        this.mDoubleCacheUtils.remove(Constants.KEY_PARCELABLE_LOGGED_IN_USER);
    }

    public Single<List<CachedCollectObjectInfoRes>> collectionRecordInfoApi(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda12
            public final Object apply(Object obj) {
                return this.f$0.m393x41083f26(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(UserRepo$$ExternalSyntheticLambda27.INSTANCE).subscribeOn(Schedulers.io());
    }

    public Single<String> deleteCollectPoint(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda13
            public final Object apply(Object obj) {
                return this.f$0.m394lambda$deleteCollectPoint$25$comcollectpointnetrepoUserRepo(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public void dispose() {
        if (this.mCompositeDisposable.isDisposed()) {
            return;
        }
        this.mCompositeDisposable.dispose();
    }

    public Single<List<AchieveModeListItem>> getAchieveModeList() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda2
            public final Object apply(Object obj) {
                return this.f$0.m395lambda$getAchieveModeList$18$comcollectpointnetrepoUserRepo((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<AppDownloadQRCodeRes> getAppDownloadQRCode() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda3
            public final Object apply(Object obj) {
                return this.f$0.m396xe14c8089((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<CachedCollectObjectInfoRes> getCachedCollectObjectInfo() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda4
            public final Object apply(Object obj) {
                return this.f$0.m397xb88b60cb((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<CachedCollectPointListItem>> getCachedCollectPointList(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda14
            public final Object apply(Object obj) {
                return this.f$0.m398x63bb49ad(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public UserBean getCachedUser() {
        return (UserBean) this.mDoubleCacheUtils.getParcelable(Constants.KEY_PARCELABLE_LOGGED_IN_USER, UserBean.CREATOR);
    }

    public Single<CachedCollectObjectInfoRes> getCollectObjectInfo(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda15
            public final Object apply(Object obj) {
                return this.f$0.m399xe3b72bc7(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<CollectObjectTypeListItem>> getCollectObjectList(final String str, final String str2, final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda24
            public final Object apply(Object obj) {
                return this.f$0.m400xf4e76895(str, str2, i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda26
            public final Object apply(Object obj) {
                return ((CollectObjectListRes.Content) obj).getRows();
            }
        }).subscribeOn(Schedulers.io());
    }

    public Single<List<CollectObjectParameterListItem>> getCollectObjectParameterList(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda16
            public final Object apply(Object obj) {
                return this.f$0.m401x8761a364(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<CollectObjectTypeListItem>> getCollectObjectTypeList() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda5
            public final Object apply(Object obj) {
                return this.f$0.m402x1d2c9b10((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<CachedCollectPointListItem> getCollectPointInfo(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda17
            public final Object apply(Object obj) {
                return this.f$0.m403lambda$getCollectPointInfo$27$comcollectpointnetrepoUserRepo(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<CachedCollectObjectInfoRes>> getCollectRecordList(final int i, final int i2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda9
            public final Object apply(Object obj) {
                return this.f$0.m404x9a62c707(i, i2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(UserRepo$$ExternalSyntheticLambda27.INSTANCE).subscribeOn(Schedulers.io());
    }

    public Single<List<AchieveModeListItem>> getFrequencyList() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda6
            public final Object apply(Object obj) {
                return this.f$0.m405lambda$getFrequencyList$19$comcollectpointnetrepoUserRepo((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<GraphicCodeRes> getGraphicCode() {
        return this.mApi.getGraphicCode().compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<Integer> getLocationUploadInterval() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda7
            public final Object apply(Object obj) {
                return this.f$0.m406xe8d8875d((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).map(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda28
            public final Object apply(Object obj) {
                return Integer.valueOf(((LocationUploadIntervalRes.Content) obj).getUploadInterval());
            }
        }).subscribeOn(Schedulers.io());
    }

    public MutableLiveData<Resource<UserBean>> getLoggedInUser() {
        final MutableLiveData<Resource<UserBean>> mutableLiveData = new MutableLiveData<>();
        getRxCachedUser().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda11
            public final void accept(Object obj) {
                mutableLiveData.setValue(Resource.success((UserBean) obj));
            }
        }, new Consumer() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda34
            public final void accept(Object obj) throws Exception {
                this.f$0.m407lambda$getLoggedInUser$31$comcollectpointnetrepoUserRepo(mutableLiveData, (Throwable) obj);
            }
        });
        return mutableLiveData;
    }

    public Single<UserBean> getRxCachedUser() {
        return Single.fromCallable(new Callable() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda29
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m408lambda$getRxCachedUser$32$comcollectpointnetrepoUserRepo();
            }
        });
    }

    public Single<SoftWareNewestVersionApiRes> getSoftWareNewestVersionApi(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda18
            public final Object apply(Object obj) {
                return this.f$0.m409xdfa9ca36(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<UserBean> getUserInfo(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda20
            public final Object apply(Object obj) {
                return this.f$0.m410lambda$getUserInfo$5$comcollectpointnetrepoUserRepo(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertCollectPoint(final InsertCollectPointReq insertCollectPointReq) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda10
            public final Object apply(Object obj) {
                return this.f$0.m411lambda$insertCollectPoint$23$comcollectpointnetrepoUserRepo(insertCollectPointReq, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> insertFeedBackApi(final String str, final List<UploadRes> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda25
            public final Object apply(Object obj) {
                return this.f$0.m412lambda$insertFeedBackApi$6$comcollectpointnetrepoUserRepo(str, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    /* renamed from: lambda$addAppSoftUpdateNumber$12$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m392xd6979745(int i, UserBean userBean) throws Exception {
        return this.mApi.addAppSoftUpdateNumber(new AddAppSoftUpdateNumberReq(userBean.getUserCode(), i));
    }

    /* renamed from: lambda$collectionRecordInfoApi$29$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m393x41083f26(String str, UserBean userBean) throws Exception {
        return this.mApi.getCollectRecordList(new CollectObjectReq(str));
    }

    /* renamed from: lambda$deleteCollectPoint$25$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m394lambda$deleteCollectPoint$25$comcollectpointnetrepoUserRepo(String str, UserBean userBean) throws Exception {
        return this.mApi.deleteCollectPoint(new CollectPointReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$getAchieveModeList$18$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m395lambda$getAchieveModeList$18$comcollectpointnetrepoUserRepo(UserBean userBean) throws Exception {
        return this.mApi.getAchieveModeList(new CollectObjectReq(userBean.getUserCode()));
    }

    /* renamed from: lambda$getAppDownloadQRCode$13$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m396xe14c8089(UserBean userBean) throws Exception {
        return this.mApi.getAppDownloadQRCode(new AppDownloadQRCodeReq(userBean.getUserCode()));
    }

    /* renamed from: lambda$getCachedCollectObjectInfo$20$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m397xb88b60cb(UserBean userBean) throws Exception {
        return this.mApi.getCachedCollectObjectInfo(new CollectObjectReq(userBean.getUserCode()));
    }

    /* renamed from: lambda$getCachedCollectPointList$21$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m398x63bb49ad(String str, UserBean userBean) throws Exception {
        return this.mApi.getCachedCollectPointList(new CollectObjectReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$getCollectObjectInfo$26$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m399xe3b72bc7(String str, UserBean userBean) throws Exception {
        return this.mApi.getCollectObjectInfo(new CollectObjectReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$getCollectObjectList$17$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m400xf4e76895(String str, String str2, int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getCollectObjectList(new CollectObjectReq(userBean.getUserCode(), str, str2, i, i2));
    }

    /* renamed from: lambda$getCollectObjectParameterList$22$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m401x8761a364(String str, UserBean userBean) throws Exception {
        return this.mApi.getCollectObjectParameterList(new CollectObjectReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$getCollectObjectTypeList$16$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m402x1d2c9b10(UserBean userBean) throws Exception {
        return this.mApi.getCollectObjectTypeList(new CollectObjectReq(userBean.getUserCode()));
    }

    /* renamed from: lambda$getCollectPointInfo$27$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m403lambda$getCollectPointInfo$27$comcollectpointnetrepoUserRepo(String str, UserBean userBean) throws Exception {
        return this.mApi.getCollectPointInfo(new CollectPointReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$getCollectRecordList$28$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m404x9a62c707(int i, int i2, UserBean userBean) throws Exception {
        return this.mApi.getCollectRecordList(new CollectObjectReq(userBean.getUserCode(), i, i2));
    }

    /* renamed from: lambda$getFrequencyList$19$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m405lambda$getFrequencyList$19$comcollectpointnetrepoUserRepo(UserBean userBean) throws Exception {
        return this.mApi.getFrequencyList(new CollectObjectReq(userBean.getUserCode()));
    }

    /* renamed from: lambda$getLocationUploadInterval$15$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m406xe8d8875d(UserBean userBean) throws Exception {
        return this.mApi.getLocationUploadInterval(new LocationUploadIntervalReq(userBean.getUserCode()));
    }

    /* renamed from: lambda$getLoggedInUser$31$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ void m407lambda$getLoggedInUser$31$comcollectpointnetrepoUserRepo(MutableLiveData mutableLiveData, Throwable th) throws Exception {
        mutableLiveData.setValue(Resource.error(this.mRxHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getRxCachedUser$32$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ UserBean m408lambda$getRxCachedUser$32$comcollectpointnetrepoUserRepo() throws Exception {
        return (UserBean) this.mDoubleCacheUtils.getParcelable(Constants.KEY_PARCELABLE_LOGGED_IN_USER, UserBean.CREATOR);
    }

    /* renamed from: lambda$getSoftWareNewestVersionApi$7$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m409xdfa9ca36(String str, UserBean userBean) throws Exception {
        return this.mApi.getSoftWareNewestVersionApi(new SoftWareNewestVersionApiReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$getUserInfo$5$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m410lambda$getUserInfo$5$comcollectpointnetrepoUserRepo(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.getUserInfo(new UserInfoReq(userBean.getUserCode(), str, str2));
    }

    /* renamed from: lambda$insertCollectPoint$23$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m411lambda$insertCollectPoint$23$comcollectpointnetrepoUserRepo(InsertCollectPointReq insertCollectPointReq, UserBean userBean) throws Exception {
        InsertCollectPointReq insertCollectPointReq2 = new InsertCollectPointReq(userBean.getUserCode(), insertCollectPointReq.getCollectObjectCode(), insertCollectPointReq.getAchieveMode(), insertCollectPointReq.getFrequency(), insertCollectPointReq.getAmapLon(), insertCollectPointReq.getAmapLat(), insertCollectPointReq.getAddress(), userBean.getNickName(), userBean.getUserCode(), insertCollectPointReq.getCollectPointName());
        insertCollectPointReq2.setAuxiliaryList(insertCollectPointReq.getAuxiliaryList());
        return this.mApi.insertCollectPoint(insertCollectPointReq2);
    }

    /* renamed from: lambda$insertFeedBackApi$6$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m412lambda$insertFeedBackApi$6$comcollectpointnetrepoUserRepo(String str, List list, UserBean userBean) throws Exception {
        InsertFeedBackApiReq insertFeedBackApiReq = new InsertFeedBackApiReq(userBean.getUserCode(), str);
        if (list != null && !list.isEmpty()) {
            insertFeedBackApiReq.setOpinionImage(Joiner.on(',').skipNulls().join(Lists.transform(list, new com.google.common.base.Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda0
                public final Object apply(Object obj) {
                    return ((UploadRes) obj).getObject();
                }
            })));
        }
        return this.mApi.insertFeedBackApi(insertFeedBackApiReq);
    }

    /* renamed from: lambda$login$1$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ void m413lambda$login$1$comcollectpointnetrepoUserRepo(String str, String str2, UserBean userBean) throws Exception {
        this.mDoubleCacheUtils.put(Constants.KEY_PRE_ACCOUNT, str);
        this.mDoubleCacheUtils.put(Constants.KEY_PRE_PWD, str2);
        this.mDoubleCacheUtils.put(Constants.KEY_PARCELABLE_LOGGED_IN_USER, userBean);
    }

    /* renamed from: lambda$login$2$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ void m414lambda$login$2$comcollectpointnetrepoUserRepo(MutableLiveData mutableLiveData, UserBean userBean) throws Exception {
        mutableLiveData.setValue(Resource.success(this.mRxHandler.getSuccessMsg(userBean)));
    }

    /* renamed from: lambda$login$3$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ void m415lambda$login$3$comcollectpointnetrepoUserRepo(MutableLiveData mutableLiveData, Throwable th) throws Exception {
        mutableLiveData.setValue(Resource.error(this.mRxHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$mobileLogin$10$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ void m416lambda$mobileLogin$10$comcollectpointnetrepoUserRepo(MutableLiveData mutableLiveData, UserBean userBean) throws Exception {
        mutableLiveData.setValue(Resource.success(this.mRxHandler.getSuccessMsg(userBean)));
    }

    /* renamed from: lambda$mobileLogin$11$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ void m417lambda$mobileLogin$11$comcollectpointnetrepoUserRepo(MutableLiveData mutableLiveData, Throwable th) throws Exception {
        mutableLiveData.setValue(Resource.error(this.mRxHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$mobileLogin$9$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ void m418lambda$mobileLogin$9$comcollectpointnetrepoUserRepo(UserBean userBean) throws Exception {
        this.mDoubleCacheUtils.put(Constants.KEY_PARCELABLE_LOGGED_IN_USER, userBean);
    }

    /* renamed from: lambda$submitCollectObject$24$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m419lambda$submitCollectObject$24$comcollectpointnetrepoUserRepo(String str, UserBean userBean) throws Exception {
        return this.mApi.submitCollectObject(new CollectObjectReq(userBean.getUserCode(), str));
    }

    /* renamed from: lambda$updateUserProjectOrgCode$4$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m420x38cf1538(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.updateUserProjectOrgCode(new UpdateUserProjectOrgCodeReq(userBean.getUserCode(), str, str2));
    }

    /* renamed from: lambda$updateUserRoleCode$14$com-collectpoint-net-repo-UserRepo, reason: not valid java name */
    /* synthetic */ SingleSource m421lambda$updateUserRoleCode$14$comcollectpointnetrepoUserRepo(String str, String str2, UserBean userBean) throws Exception {
        return this.mApi.updateUserRoleCode(new UpdateUserRoleCodeReq(userBean.getUserCode(), str, str2));
    }

    public MutableLiveData<Resource<String>> login(final String str, final String str2, String str3) {
        final MutableLiveData<Resource<String>> mutableLiveData = new MutableLiveData<>();
        this.mCompositeDisposable.add(this.mApi.login(new ApiLoginReq(str, str2, str3)).subscribeOn(Schedulers.io()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda22
            public final void accept(Object obj) {
                mutableLiveData.setValue(Resource.loading(null));
            }
        }).observeOn(Schedulers.io()).compose(this.mRxHandler.handleSingleRes()).doOnSuccess(new Consumer() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda1
            public final void accept(Object obj) throws Exception {
                this.f$0.m413lambda$login$1$comcollectpointnetrepoUserRepo(str, str2, (UserBean) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda32
            public final void accept(Object obj) throws Exception {
                this.f$0.m414lambda$login$2$comcollectpointnetrepoUserRepo(mutableLiveData, (UserBean) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda35
            public final void accept(Object obj) throws Exception {
                this.f$0.m415lambda$login$3$comcollectpointnetrepoUserRepo(mutableLiveData, (Throwable) obj);
            }
        }));
        return mutableLiveData;
    }

    public MutableLiveData<Resource<String>> mobileLogin(String str, String str2) {
        final MutableLiveData<Resource<String>> mutableLiveData = new MutableLiveData<>();
        this.mCompositeDisposable.add(this.mApi.mobileLogin(new MobileLoginReq(str, str2)).subscribeOn(Schedulers.io()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda30
            public final void accept(Object obj) {
                mutableLiveData.setValue(Resource.loading(null));
            }
        }).observeOn(Schedulers.io()).compose(this.mRxHandler.handleSingleRes()).doOnSuccess(new Consumer() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda31
            public final void accept(Object obj) throws Exception {
                this.f$0.m418lambda$mobileLogin$9$comcollectpointnetrepoUserRepo((UserBean) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda33
            public final void accept(Object obj) throws Exception {
                this.f$0.m416lambda$mobileLogin$10$comcollectpointnetrepoUserRepo(mutableLiveData, (UserBean) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda36
            public final void accept(Object obj) throws Exception {
                this.f$0.m417lambda$mobileLogin$11$comcollectpointnetrepoUserRepo(mutableLiveData, (Throwable) obj);
            }
        }));
        return mutableLiveData;
    }

    public Single<String> sendSms(String str, String str2, String str3, String str4) {
        return this.mApi.sendSms(new SendSmsReq(str, str2, str3, str4)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> submitCollectObject(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda19
            public final Object apply(Object obj) {
                return this.f$0.m419lambda$submitCollectObject$24$comcollectpointnetrepoUserRepo(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> updateUser(UpdateUserReq updateUserReq) {
        return this.mApi.updateUser(updateUserReq).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<UpdateUserProjectOrgCodRes> updateUserProjectOrgCode(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda21
            public final Object apply(Object obj) {
                return this.f$0.m420x38cf1538(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<UserBean> updateUserPwd(String str, String str2, String str3, String str4) {
        return this.mApi.updateUserPwd(new UpdateUserPwdReq(str, str2, str3, str4)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<UpdateUserRoleCodeRes> updateUserRoleCode(final String str, final String str2) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.UserRepo$$ExternalSyntheticLambda23
            public final Object apply(Object obj) {
                return this.f$0.m421lambda$updateUserRoleCode$14$comcollectpointnetrepoUserRepo(str, str2, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }
}
