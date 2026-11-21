package com.collectpoint.net.repo;

import android.app.Application;
import android.content.Context;
import com.blankj.utilcode.util.CacheDiskUtils;
import com.blankj.utilcode.util.CacheDoubleUtils;
import com.blankj.utilcode.util.CacheMemoryUtils;
import com.collectpoint.bean.AccountTreeItem;
import com.collectpoint.bean.DispatchGroupItem;
import com.collectpoint.bean.LongitudeLatitude;
import com.collectpoint.bean.QuickLinkAccountTreeItem;
import com.collectpoint.bean.UserBean;
import com.collectpoint.bean.item.ContactsItem;
import com.collectpoint.bean.item.HWMeetingConfigInfo;
import com.collectpoint.bean.req.Attendees;
import com.collectpoint.bean.req.CreateMeetingReq;
import com.collectpoint.bean.req.PatrolPersonnelRealTimeInfoListReq;
import com.collectpoint.bean.req.UpdateUserReq;
import com.collectpoint.bean.res.AccountTreeRes;
import com.collectpoint.bean.res.CreateMeetingRes;
import com.collectpoint.constants.Constants;
import com.collectpoint.net.remote.MeetingApi;
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
public class MeetingRepo {
    private static MeetingRepo sInstance;
    private MeetingApi mApi;
    private CacheDoubleUtils mDoubleCacheUtils;
    private RxHandler mRxHandler;

    private MeetingRepo(MeetingApi meetingApi, Application application) {
        this.mApi = (MeetingApi) Preconditions.checkNotNull(meetingApi);
        Context applicationContext = ((Application) Preconditions.checkNotNull(application)).getApplicationContext();
        this.mRxHandler = RxHandler.getInstance(applicationContext);
        this.mDoubleCacheUtils = CacheDoubleUtils.getInstance(CacheMemoryUtils.getInstance(), CacheDiskUtils.getInstance(FileTool.getDiskCacheDir(applicationContext, Constants.DISK_CACHE_DIR_NAME)));
    }

    public static MeetingRepo getInstance(MeetingApi meetingApi, Application application) {
        if (sInstance == null) {
            synchronized (MeetingRepo.class) {
                if (sInstance == null) {
                    sInstance = new MeetingRepo(meetingApi, application);
                }
            }
        }
        return sInstance;
    }

    private Single<UserBean> getRxCachedUser() {
        return Single.fromCallable(new Callable() { // from class: com.collectpoint.net.repo.MeetingRepo$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m248lambda$getRxCachedUser$0$comcollectpointnetrepoMeetingRepo();
            }
        });
    }

    public Single<CreateMeetingRes> createMeeting(final String str, final String str2, final String str3, final boolean z, final List<ContactsItem> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.MeetingRepo$$ExternalSyntheticLambda3
            public final Object apply(Object obj) {
                return this.f$0.m236lambda$createMeeting$13$comcollectpointnetrepoMeetingRepo(str, str2, str3, z, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> dispatchGroupDelete(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.MeetingRepo$$ExternalSyntheticLambda7
            public final Object apply(Object obj) {
                return this.f$0.m237x3dcfb2e9(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> dispatchGroupInsert(final String str, final String str2, final String str3, final String str4, final List<ContactsItem> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.MeetingRepo$$ExternalSyntheticLambda1
            public final Object apply(Object obj) {
                return this.f$0.m238x48e223ce(str, str2, str3, str4, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> dispatchGroupUpdate(final String str, final String str2, final String str3, final List<ContactsItem> list) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.MeetingRepo$$ExternalSyntheticLambda2
            public final Object apply(Object obj) {
                return this.f$0.m239xc947411f(str, str2, str3, list, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<AccountTreeItem>> getDispatchAccountTree(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.MeetingRepo$$ExternalSyntheticLambda8
            public final Object apply(Object obj) {
                return this.f$0.m240xf0a6bb02(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<DispatchGroupItem> getDispatchGroupInfo(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.MeetingRepo$$ExternalSyntheticLambda9
            public final Object apply(Object obj) {
                return this.f$0.m241xdbbc3b26(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<DispatchGroupItem>> getDispatchGroupList(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.MeetingRepo$$ExternalSyntheticLambda10
            public final Object apply(Object obj) {
                return this.f$0.m242x7ddfd5(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<HWMeetingConfigInfo> getHWMeetingConfigInfo() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.MeetingRepo$$ExternalSyntheticLambda0
            public final Object apply(Object obj) {
                return this.f$0.m243xe631916b((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> getMeetingApiAccessToken() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.MeetingRepo$$ExternalSyntheticLambda5
            public final Object apply(Object obj) {
                return this.f$0.m244xdd815843((UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<CreateMeetingRes>> getOnlineMeetingList() {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.MeetingRepo$$ExternalSyntheticLambda6
            public final Object apply(Object obj) {
                return this.f$0.m245x95fa6951((UserBean) obj);
            }
        }).subscribeOn(Schedulers.io());
    }

    public Single<List<QuickLinkAccountTreeItem>> getQuickLinkAccountTree(final String str) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.MeetingRepo$$ExternalSyntheticLambda11
            public final Object apply(Object obj) {
                return this.f$0.m246x838a0764(str, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<List<AccountTreeItem>> getQuickLinkAccountTree(final String str, final String str2, final String str3) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.MeetingRepo$$ExternalSyntheticLambda13
            public final Object apply(Object obj) {
                return this.f$0.m247x158bf5e6(str, str2, str3, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    /* renamed from: lambda$createMeeting$13$com-collectpoint-net-repo-MeetingRepo, reason: not valid java name */
    /* synthetic */ SingleSource m236lambda$createMeeting$13$comcollectpointnetrepoMeetingRepo(String str, String str2, String str3, boolean z, List list, UserBean userBean) throws Exception {
        CreateMeetingReq createMeetingReq = new CreateMeetingReq(userBean.getUserCode(), userBean.getNickName(), str, str2, str3, z);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ContactsItem contactsItem = (ContactsItem) it.next();
                Attendees attendees = new Attendees();
                attendees.setName(contactsItem.getNickName());
                attendees.setUserUUID(contactsItem.getUserCode());
                arrayList.add(attendees);
            }
        }
        createMeetingReq.setAttendees(arrayList);
        return this.mApi.createMeeting(createMeetingReq);
    }

    /* renamed from: lambda$dispatchGroupDelete$10$com-collectpoint-net-repo-MeetingRepo, reason: not valid java name */
    /* synthetic */ SingleSource m237x3dcfb2e9(String str, UserBean userBean) throws Exception {
        return this.mApi.dispatchGroupDelete(new DispatchGroupItem(str, userBean.getUserCode(), userBean.getNickName(), userBean.getUserType()));
    }

    /* renamed from: lambda$dispatchGroupInsert$8$com-collectpoint-net-repo-MeetingRepo, reason: not valid java name */
    /* synthetic */ SingleSource m238x48e223ce(String str, String str2, String str3, String str4, List list, UserBean userBean) throws Exception {
        return this.mApi.dispatchGroupInsert(new DispatchGroupItem(userBean.getUserCode(), userBean.getNickName(), userBean.getUserType(), str, str2, str3, str4, list));
    }

    /* renamed from: lambda$dispatchGroupUpdate$9$com-collectpoint-net-repo-MeetingRepo, reason: not valid java name */
    /* synthetic */ SingleSource m239xc947411f(String str, String str2, String str3, List list, UserBean userBean) throws Exception {
        return this.mApi.dispatchGroupUpdate(new DispatchGroupItem(userBean.getUserCode(), userBean.getNickName(), userBean.getUserType(), str, str2, str3, list));
    }

    /* renamed from: lambda$getDispatchAccountTree$5$com-collectpoint-net-repo-MeetingRepo, reason: not valid java name */
    /* synthetic */ SingleSource m240xf0a6bb02(String str, UserBean userBean) throws Exception {
        return this.mApi.getDispatchAccountTree(new AccountTreeRes(userBean.getUserCode(), userBean.getNickName(), userBean.getUserType(), str));
    }

    /* renamed from: lambda$getDispatchGroupInfo$7$com-collectpoint-net-repo-MeetingRepo, reason: not valid java name */
    /* synthetic */ SingleSource m241xdbbc3b26(String str, UserBean userBean) throws Exception {
        return this.mApi.getDispatchGroupInfo(new AccountTreeRes(userBean.getUserCode(), userBean.getNickName(), str));
    }

    /* renamed from: lambda$getDispatchGroupList$6$com-collectpoint-net-repo-MeetingRepo, reason: not valid java name */
    /* synthetic */ SingleSource m242x7ddfd5(String str, UserBean userBean) throws Exception {
        return this.mApi.getDispatchGroupList(new AccountTreeRes(userBean.getUserCode(), userBean.getNickName(), userBean.getUserType(), str));
    }

    /* renamed from: lambda$getHWMeetingConfigInfo$3$com-collectpoint-net-repo-MeetingRepo, reason: not valid java name */
    /* synthetic */ SingleSource m243xe631916b(UserBean userBean) throws Exception {
        UpdateUserReq updateUserReq = new UpdateUserReq();
        updateUserReq.setUserCode(userBean.getUserCode());
        updateUserReq.setNickName(userBean.getNickName());
        return this.mApi.getHWMeetingConfigInfo(updateUserReq);
    }

    /* renamed from: lambda$getMeetingApiAccessToken$1$com-collectpoint-net-repo-MeetingRepo, reason: not valid java name */
    /* synthetic */ SingleSource m244xdd815843(UserBean userBean) throws Exception {
        UpdateUserReq updateUserReq = new UpdateUserReq();
        updateUserReq.setUserCode(userBean.getUserCode());
        updateUserReq.setNickName(userBean.getNickName());
        return this.mApi.getMeetingApiAccessToken(updateUserReq);
    }

    /* renamed from: lambda$getOnlineMeetingList$12$com-collectpoint-net-repo-MeetingRepo, reason: not valid java name */
    /* synthetic */ SingleSource m245x95fa6951(UserBean userBean) throws Exception {
        return this.mApi.getOnlineMeetingList(new CreateMeetingReq(userBean.getUserCode(), userBean.getNickName())).compose(this.mRxHandler.handleSingleRes());
    }

    /* renamed from: lambda$getQuickLinkAccountTree$2$com-collectpoint-net-repo-MeetingRepo, reason: not valid java name */
    /* synthetic */ SingleSource m246x838a0764(String str, UserBean userBean) throws Exception {
        UpdateUserReq updateUserReq = new UpdateUserReq();
        updateUserReq.setUserCode(userBean.getUserCode());
        updateUserReq.setNickName(userBean.getNickName());
        updateUserReq.setUserType(str);
        return this.mApi.getQuickLinkAccountTree(updateUserReq);
    }

    /* renamed from: lambda$getQuickLinkAccountTree$4$com-collectpoint-net-repo-MeetingRepo, reason: not valid java name */
    /* synthetic */ SingleSource m247x158bf5e6(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mApi.getQuickLinkAccountTree(new AccountTreeRes(userBean.getUserCode(), userBean.getNickName(), userBean.getUserType(), str, str2, str3));
    }

    /* renamed from: lambda$getRxCachedUser$0$com-collectpoint-net-repo-MeetingRepo, reason: not valid java name */
    /* synthetic */ UserBean m248lambda$getRxCachedUser$0$comcollectpointnetrepoMeetingRepo() throws Exception {
        return (UserBean) this.mDoubleCacheUtils.getParcelable(Constants.KEY_PARCELABLE_LOGGED_IN_USER, UserBean.CREATOR);
    }

    /* renamed from: lambda$updateDispatchAccountOnLineStatus$11$com-collectpoint-net-repo-MeetingRepo, reason: not valid java name */
    /* synthetic */ SingleSource m249x825928cb(String str, LongitudeLatitude longitudeLatitude, UserBean userBean) throws Exception {
        return this.mApi.updateDispatchAccountOnLineStatust(new PatrolPersonnelRealTimeInfoListReq(userBean.getUserCode(), userBean.getNickName(), str, longitudeLatitude));
    }

    public Single<String> updateDispatchAccountOnLineStatus(final String str, final LongitudeLatitude longitudeLatitude) {
        return getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.repo.MeetingRepo$$ExternalSyntheticLambda12
            public final Object apply(Object obj) {
                return this.f$0.m249x825928cb(str, longitudeLatitude, (UserBean) obj);
            }
        }).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }

    public Single<String> updateDispatchAccountOnLineStatus(String str, String str2, String str3, LongitudeLatitude longitudeLatitude) {
        return this.mApi.updateDispatchAccountOnLineStatust(new PatrolPersonnelRealTimeInfoListReq(str, str2, str3, longitudeLatitude)).compose(this.mRxHandler.handleSingleRes()).subscribeOn(Schedulers.io());
    }
}
