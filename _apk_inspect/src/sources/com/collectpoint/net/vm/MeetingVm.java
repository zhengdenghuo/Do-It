package com.collectpoint.net.vm;

import android.app.Application;
import androidx.lifecycle.MediatorLiveData;
import com.collectpoint.bean.AccountTreeItem;
import com.collectpoint.bean.DispatchGroupItem;
import com.collectpoint.bean.QuickLinkAccountTreeItem;
import com.collectpoint.bean.item.ContactsItem;
import com.collectpoint.bean.item.HWMeetingConfigInfo;
import com.collectpoint.bean.res.CreateMeetingRes;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.repo.MeetingRepo;
import com.collectpoint.net.repo.RxHandler;
import com.collectpoint.net.repo.UploadFileRepo;
import com.google.common.base.Preconditions;
import com.liuwq.base.databinding.BaseRequestViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class MeetingVm extends BaseRequestViewModel {
    public MediatorLiveData<Resource<List<AccountTreeItem>>> mAccountTreeItem;
    public MediatorLiveData<Resource<CreateMeetingRes>> mCreateMeeting;
    public MediatorLiveData<Resource<List<AccountTreeItem>>> mDispatchAccountTree;
    public MediatorLiveData<Resource<DispatchGroupItem>> mDispatchGroupInfo;
    public MediatorLiveData<Resource<List<DispatchGroupItem>>> mDispatchGroupList;
    public MediatorLiveData<Resource<String>> mDoGroupInfo;
    public MediatorLiveData<Resource<HWMeetingConfigInfo>> mHWMeetingConfigInfo;
    private final RxHandler mHttpHandler;
    public MediatorLiveData<Resource<String>> mMeetingApiAccessToken;
    public MediatorLiveData<Resource<List<QuickLinkAccountTreeItem>>> mQuickLinkAccountTreeList;
    private MeetingRepo mRepository;
    private final UploadFileRepo mUploadRepo;

    public MeetingVm(Application application, MeetingRepo meetingRepo, UploadFileRepo uploadFileRepo) {
        super(application);
        this.mMeetingApiAccessToken = new MediatorLiveData<>();
        this.mQuickLinkAccountTreeList = new MediatorLiveData<>();
        this.mHWMeetingConfigInfo = new MediatorLiveData<>();
        this.mAccountTreeItem = new MediatorLiveData<>();
        this.mDispatchAccountTree = new MediatorLiveData<>();
        this.mDispatchGroupList = new MediatorLiveData<>();
        this.mDispatchGroupInfo = new MediatorLiveData<>();
        this.mDoGroupInfo = new MediatorLiveData<>();
        this.mCreateMeeting = new MediatorLiveData<>();
        this.mRepository = (MeetingRepo) Preconditions.checkNotNull(meetingRepo);
        this.mUploadRepo = (UploadFileRepo) Preconditions.checkNotNull(uploadFileRepo);
        this.mHttpHandler = RxHandler.getInstance(this.mContext);
    }

    public void createMeeting(String str, String str2, String str3, boolean z, List<ContactsItem> list) {
        this.mDisposable = this.mRepository.createMeeting(str, str2, str3, z, list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda26
            public final void accept(Object obj) throws Exception {
                this.f$0.m491lambda$createMeeting$30$comcollectpointnetvmMeetingVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda22
            public final void accept(Object obj) throws Exception {
                this.f$0.m492lambda$createMeeting$31$comcollectpointnetvmMeetingVm((CreateMeetingRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda9
            public final void accept(Object obj) throws Exception {
                this.f$0.m493lambda$createMeeting$32$comcollectpointnetvmMeetingVm((Throwable) obj);
            }
        });
    }

    public void dispatchGroupDelete(String str) {
        this.mDisposable = this.mRepository.dispatchGroupDelete(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda27
            public final void accept(Object obj) throws Exception {
                this.f$0.m494lambda$dispatchGroupDelete$27$comcollectpointnetvmMeetingVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda5
            public final void accept(Object obj) throws Exception {
                this.f$0.m495lambda$dispatchGroupDelete$28$comcollectpointnetvmMeetingVm((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda10
            public final void accept(Object obj) throws Exception {
                this.f$0.m496lambda$dispatchGroupDelete$29$comcollectpointnetvmMeetingVm((Throwable) obj);
            }
        });
    }

    public void dispatchGroupInsert(String str, String str2, String str3, String str4, List<ContactsItem> list) {
        this.mDisposable = this.mRepository.dispatchGroupInsert(str, str2, str3, str4, list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda28
            public final void accept(Object obj) throws Exception {
                this.f$0.m497lambda$dispatchGroupInsert$21$comcollectpointnetvmMeetingVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda6
            public final void accept(Object obj) throws Exception {
                this.f$0.m498lambda$dispatchGroupInsert$22$comcollectpointnetvmMeetingVm((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda12
            public final void accept(Object obj) throws Exception {
                this.f$0.m499lambda$dispatchGroupInsert$23$comcollectpointnetvmMeetingVm((Throwable) obj);
            }
        });
    }

    public void dispatchGroupUpdate(String str, String str2, String str3, List<ContactsItem> list) {
        this.mDisposable = this.mRepository.dispatchGroupUpdate(str, str2, str3, list).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda29
            public final void accept(Object obj) throws Exception {
                this.f$0.m500lambda$dispatchGroupUpdate$24$comcollectpointnetvmMeetingVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda7
            public final void accept(Object obj) throws Exception {
                this.f$0.m501lambda$dispatchGroupUpdate$25$comcollectpointnetvmMeetingVm((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda13
            public final void accept(Object obj) throws Exception {
                this.f$0.m502lambda$dispatchGroupUpdate$26$comcollectpointnetvmMeetingVm((Throwable) obj);
            }
        });
    }

    public void getDispatchAccountTree(String str) {
        this.mDisposable = this.mRepository.getDispatchAccountTree(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda30
            public final void accept(Object obj) throws Exception {
                this.f$0.m503x48a61450((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda21
            public final void accept(Object obj) throws Exception {
                this.f$0.m504xaf7ed411((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda14
            public final void accept(Object obj) throws Exception {
                this.f$0.m505x165793d2((Throwable) obj);
            }
        });
    }

    public void getDispatchGroupInfo(String str) {
        this.mDisposable = this.mRepository.getDispatchGroupInfo(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda31
            public final void accept(Object obj) throws Exception {
                this.f$0.m506lambda$getDispatchGroupInfo$18$comcollectpointnetvmMeetingVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda0
            public final void accept(Object obj) throws Exception {
                this.f$0.m507lambda$getDispatchGroupInfo$19$comcollectpointnetvmMeetingVm((DispatchGroupItem) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda15
            public final void accept(Object obj) throws Exception {
                this.f$0.m508lambda$getDispatchGroupInfo$20$comcollectpointnetvmMeetingVm((Throwable) obj);
            }
        });
    }

    public void getDispatchGroupList(String str) {
        this.mDisposable = this.mRepository.getDispatchGroupList(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda32
            public final void accept(Object obj) throws Exception {
                this.f$0.m509lambda$getDispatchGroupList$15$comcollectpointnetvmMeetingVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda23
            public final void accept(Object obj) throws Exception {
                this.f$0.m510lambda$getDispatchGroupList$16$comcollectpointnetvmMeetingVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda16
            public final void accept(Object obj) throws Exception {
                this.f$0.m511lambda$getDispatchGroupList$17$comcollectpointnetvmMeetingVm((Throwable) obj);
            }
        });
    }

    public void getHWMeetingConfigInfo() {
        this.mDisposable = this.mRepository.getHWMeetingConfigInfo().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda1
            public final void accept(Object obj) throws Exception {
                this.f$0.m512x49ac5178((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda11
            public final void accept(Object obj) throws Exception {
                this.f$0.m513xb0851139((HWMeetingConfigInfo) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda17
            public final void accept(Object obj) throws Exception {
                this.f$0.m514x175dd0fa((Throwable) obj);
            }
        });
    }

    public void getManageUnitList() {
        this.mDisposable = this.mRepository.getMeetingApiAccessToken().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda2
            public final void accept(Object obj) throws Exception {
                this.f$0.m515lambda$getManageUnitList$0$comcollectpointnetvmMeetingVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda8
            public final void accept(Object obj) throws Exception {
                this.f$0.m516lambda$getManageUnitList$1$comcollectpointnetvmMeetingVm((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda18
            public final void accept(Object obj) throws Exception {
                this.f$0.m517lambda$getManageUnitList$2$comcollectpointnetvmMeetingVm((Throwable) obj);
            }
        });
    }

    public void getQuickLinkAccountTree(String str) {
        this.mDisposable = this.mRepository.getQuickLinkAccountTree(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda3
            public final void accept(Object obj) throws Exception {
                this.f$0.m520x34672c6f((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda25
            public final void accept(Object obj) throws Exception {
                this.f$0.m521x9b3fec30((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda20
            public final void accept(Object obj) throws Exception {
                this.f$0.m522x218abf1((Throwable) obj);
            }
        });
    }

    public void getQuickLinkAccountTree(String str, String str2, String str3) {
        this.mDisposable = this.mRepository.getQuickLinkAccountTree(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda4
            public final void accept(Object obj) throws Exception {
                this.f$0.m523x9d7baaf5((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda24
            public final void accept(Object obj) throws Exception {
                this.f$0.m518xb29f1cc9((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.MeetingVm$$ExternalSyntheticLambda19
            public final void accept(Object obj) throws Exception {
                this.f$0.m519x1977dc8a((Throwable) obj);
            }
        });
    }

    /* renamed from: lambda$createMeeting$30$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m491lambda$createMeeting$30$comcollectpointnetvmMeetingVm(Disposable disposable) throws Exception {
        this.mCreateMeeting.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$createMeeting$31$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m492lambda$createMeeting$31$comcollectpointnetvmMeetingVm(CreateMeetingRes createMeetingRes) throws Exception {
        this.mCreateMeeting.setValue(Resource.success(createMeetingRes));
    }

    /* renamed from: lambda$createMeeting$32$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m493lambda$createMeeting$32$comcollectpointnetvmMeetingVm(Throwable th) throws Exception {
        this.mCreateMeeting.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$dispatchGroupDelete$27$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m494lambda$dispatchGroupDelete$27$comcollectpointnetvmMeetingVm(Disposable disposable) throws Exception {
        this.mDoGroupInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$dispatchGroupDelete$28$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m495lambda$dispatchGroupDelete$28$comcollectpointnetvmMeetingVm(String str) throws Exception {
        this.mDoGroupInfo.setValue(Resource.success(str));
    }

    /* renamed from: lambda$dispatchGroupDelete$29$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m496lambda$dispatchGroupDelete$29$comcollectpointnetvmMeetingVm(Throwable th) throws Exception {
        this.mDoGroupInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$dispatchGroupInsert$21$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m497lambda$dispatchGroupInsert$21$comcollectpointnetvmMeetingVm(Disposable disposable) throws Exception {
        this.mDoGroupInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$dispatchGroupInsert$22$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m498lambda$dispatchGroupInsert$22$comcollectpointnetvmMeetingVm(String str) throws Exception {
        this.mDoGroupInfo.setValue(Resource.success(str));
    }

    /* renamed from: lambda$dispatchGroupInsert$23$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m499lambda$dispatchGroupInsert$23$comcollectpointnetvmMeetingVm(Throwable th) throws Exception {
        this.mDoGroupInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$dispatchGroupUpdate$24$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m500lambda$dispatchGroupUpdate$24$comcollectpointnetvmMeetingVm(Disposable disposable) throws Exception {
        this.mDoGroupInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$dispatchGroupUpdate$25$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m501lambda$dispatchGroupUpdate$25$comcollectpointnetvmMeetingVm(String str) throws Exception {
        this.mDoGroupInfo.setValue(Resource.success(str));
    }

    /* renamed from: lambda$dispatchGroupUpdate$26$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m502lambda$dispatchGroupUpdate$26$comcollectpointnetvmMeetingVm(Throwable th) throws Exception {
        this.mDoGroupInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getDispatchAccountTree$12$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m503x48a61450(Disposable disposable) throws Exception {
        this.mDispatchAccountTree.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getDispatchAccountTree$13$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m504xaf7ed411(List list) throws Exception {
        this.mDispatchAccountTree.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getDispatchAccountTree$14$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m505x165793d2(Throwable th) throws Exception {
        this.mDispatchAccountTree.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getDispatchGroupInfo$18$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m506lambda$getDispatchGroupInfo$18$comcollectpointnetvmMeetingVm(Disposable disposable) throws Exception {
        this.mDispatchGroupInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getDispatchGroupInfo$19$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m507lambda$getDispatchGroupInfo$19$comcollectpointnetvmMeetingVm(DispatchGroupItem dispatchGroupItem) throws Exception {
        this.mDispatchGroupInfo.setValue(Resource.success(dispatchGroupItem));
    }

    /* renamed from: lambda$getDispatchGroupInfo$20$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m508lambda$getDispatchGroupInfo$20$comcollectpointnetvmMeetingVm(Throwable th) throws Exception {
        this.mDispatchGroupInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getDispatchGroupList$15$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m509lambda$getDispatchGroupList$15$comcollectpointnetvmMeetingVm(Disposable disposable) throws Exception {
        this.mDispatchGroupList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getDispatchGroupList$16$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m510lambda$getDispatchGroupList$16$comcollectpointnetvmMeetingVm(List list) throws Exception {
        this.mDispatchGroupList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getDispatchGroupList$17$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m511lambda$getDispatchGroupList$17$comcollectpointnetvmMeetingVm(Throwable th) throws Exception {
        this.mDispatchGroupList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getHWMeetingConfigInfo$6$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m512x49ac5178(Disposable disposable) throws Exception {
        this.mHWMeetingConfigInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getHWMeetingConfigInfo$7$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m513xb0851139(HWMeetingConfigInfo hWMeetingConfigInfo) throws Exception {
        this.mHWMeetingConfigInfo.setValue(Resource.success(hWMeetingConfigInfo));
    }

    /* renamed from: lambda$getHWMeetingConfigInfo$8$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m514x175dd0fa(Throwable th) throws Exception {
        this.mHWMeetingConfigInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getManageUnitList$0$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m515lambda$getManageUnitList$0$comcollectpointnetvmMeetingVm(Disposable disposable) throws Exception {
        this.mMeetingApiAccessToken.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getManageUnitList$1$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m516lambda$getManageUnitList$1$comcollectpointnetvmMeetingVm(String str) throws Exception {
        this.mMeetingApiAccessToken.setValue(Resource.success(str));
    }

    /* renamed from: lambda$getManageUnitList$2$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m517lambda$getManageUnitList$2$comcollectpointnetvmMeetingVm(Throwable th) throws Exception {
        this.mMeetingApiAccessToken.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getQuickLinkAccountTree$10$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m518xb29f1cc9(List list) throws Exception {
        this.mAccountTreeItem.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getQuickLinkAccountTree$11$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m519x1977dc8a(Throwable th) throws Exception {
        this.mAccountTreeItem.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getQuickLinkAccountTree$3$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m520x34672c6f(Disposable disposable) throws Exception {
        this.mQuickLinkAccountTreeList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getQuickLinkAccountTree$4$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m521x9b3fec30(List list) throws Exception {
        this.mQuickLinkAccountTreeList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getQuickLinkAccountTree$5$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m522x218abf1(Throwable th) throws Exception {
        this.mQuickLinkAccountTreeList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getQuickLinkAccountTree$9$com-collectpoint-net-vm-MeetingVm, reason: not valid java name */
    /* synthetic */ void m523x9d7baaf5(Disposable disposable) throws Exception {
        this.mAccountTreeItem.setValue(Resource.loading(null));
    }
}
