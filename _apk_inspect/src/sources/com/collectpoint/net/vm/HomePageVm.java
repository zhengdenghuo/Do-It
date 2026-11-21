package com.collectpoint.net.vm;

import android.app.Application;
import androidx.lifecycle.MediatorLiveData;
import com.collectpoint.bean.UserBean;
import com.collectpoint.bean.res.SoftWareNewestVersionApiRes;
import com.collectpoint.bean.res.UpdateUserProjectOrgCodRes;
import com.collectpoint.bean.res.UpdateUserRoleCodeRes;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.repo.RxHandler;
import com.collectpoint.net.repo.UploadFileRepo;
import com.collectpoint.net.repo.UserRepo;
import com.collectpoint.utils.SystemUtils;
import com.google.common.base.Preconditions;
import com.liuwq.base.databinding.BaseRequestViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class HomePageVm extends BaseRequestViewModel {
    private final RxHandler mHttpHandler;
    private UserRepo mRepository;
    public MediatorLiveData<Resource<SoftWareNewestVersionApiRes>> mSoftWareNewestVersionApi;
    public MediatorLiveData<Resource<UpdateUserProjectOrgCodRes>> mUpdateUserProjectOrgCode;
    public MediatorLiveData<Resource<UpdateUserRoleCodeRes>> mUpdateUserRoleCode;
    public MediatorLiveData<Resource<UpdateUserRoleCodeRes>> mUpdateUserRoleCodeM;
    private final UploadFileRepo mUploadRepo;
    public MediatorLiveData<Resource<UserBean>> mUserInfo;

    public HomePageVm(Application application, UserRepo userRepo, UploadFileRepo uploadFileRepo) {
        super(application);
        this.mUpdateUserProjectOrgCode = new MediatorLiveData<>();
        this.mUserInfo = new MediatorLiveData<>();
        this.mSoftWareNewestVersionApi = new MediatorLiveData<>();
        this.mUpdateUserRoleCode = new MediatorLiveData<>();
        this.mUpdateUserRoleCodeM = new MediatorLiveData<>();
        this.mRepository = (UserRepo) Preconditions.checkNotNull(userRepo);
        this.mUploadRepo = (UploadFileRepo) Preconditions.checkNotNull(uploadFileRepo);
        this.mHttpHandler = RxHandler.getInstance(this.mContext);
    }

    public void getSoftWareNewestVersionApi() {
        this.mDisposable = this.mRepository.getSoftWareNewestVersionApi(SystemUtils.getVersionName(this.mContext)).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda10
            public final void accept(Object obj) throws Exception {
                this.f$0.m422x21669c3a((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda6
            public final void accept(Object obj) throws Exception {
                this.f$0.m423x95a5d499((SoftWareNewestVersionApiRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda1
            public final void accept(Object obj) throws Exception {
                this.f$0.m424x9e50cf8((Throwable) obj);
            }
        });
    }

    public void getUserInfo(String str, String str2) {
        this.mDisposable = this.mRepository.getUserInfo(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda11
            public final void accept(Object obj) throws Exception {
                this.f$0.m425lambda$getUserInfo$3$comcollectpointnetvmHomePageVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda0
            public final void accept(Object obj) throws Exception {
                this.f$0.m426lambda$getUserInfo$4$comcollectpointnetvmHomePageVm((UserBean) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda2
            public final void accept(Object obj) throws Exception {
                this.f$0.m427lambda$getUserInfo$5$comcollectpointnetvmHomePageVm((Throwable) obj);
            }
        });
    }

    /* renamed from: lambda$getSoftWareNewestVersionApi$6$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m422x21669c3a(Disposable disposable) throws Exception {
        this.mSoftWareNewestVersionApi.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getSoftWareNewestVersionApi$7$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m423x95a5d499(SoftWareNewestVersionApiRes softWareNewestVersionApiRes) throws Exception {
        this.mSoftWareNewestVersionApi.setValue(Resource.success(softWareNewestVersionApiRes));
    }

    /* renamed from: lambda$getSoftWareNewestVersionApi$8$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m424x9e50cf8(Throwable th) throws Exception {
        this.mSoftWareNewestVersionApi.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getUserInfo$3$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m425lambda$getUserInfo$3$comcollectpointnetvmHomePageVm(Disposable disposable) throws Exception {
        this.mUserInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getUserInfo$4$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m426lambda$getUserInfo$4$comcollectpointnetvmHomePageVm(UserBean userBean) throws Exception {
        this.mUserInfo.setValue(Resource.success(userBean));
    }

    /* renamed from: lambda$getUserInfo$5$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m427lambda$getUserInfo$5$comcollectpointnetvmHomePageVm(Throwable th) throws Exception {
        this.mUserInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$updateUserProjectOrgCode$0$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m428x1dce3e1f(Disposable disposable) throws Exception {
        this.mUpdateUserProjectOrgCode.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$updateUserProjectOrgCode$1$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m429x920d767e(UpdateUserProjectOrgCodRes updateUserProjectOrgCodRes) throws Exception {
        this.mUpdateUserProjectOrgCode.setValue(Resource.success(updateUserProjectOrgCodRes));
    }

    /* renamed from: lambda$updateUserProjectOrgCode$2$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m430x64caedd(Throwable th) throws Exception {
        this.mUpdateUserProjectOrgCode.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$updateUserRoleCode$10$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m431lambda$updateUserRoleCode$10$comcollectpointnetvmHomePageVm(UpdateUserRoleCodeRes updateUserRoleCodeRes) throws Exception {
        this.mUpdateUserRoleCode.setValue(Resource.success(updateUserRoleCodeRes));
    }

    /* renamed from: lambda$updateUserRoleCode$11$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m432lambda$updateUserRoleCode$11$comcollectpointnetvmHomePageVm(Throwable th) throws Exception {
        this.mUpdateUserRoleCode.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$updateUserRoleCode$9$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m433lambda$updateUserRoleCode$9$comcollectpointnetvmHomePageVm(Disposable disposable) throws Exception {
        this.mUpdateUserRoleCode.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$updateUserRoleCodeM$12$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m434lambda$updateUserRoleCodeM$12$comcollectpointnetvmHomePageVm(Disposable disposable) throws Exception {
        this.mUpdateUserRoleCodeM.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$updateUserRoleCodeM$13$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m435lambda$updateUserRoleCodeM$13$comcollectpointnetvmHomePageVm(UpdateUserRoleCodeRes updateUserRoleCodeRes) throws Exception {
        this.mUpdateUserRoleCodeM.setValue(Resource.success(updateUserRoleCodeRes));
    }

    /* renamed from: lambda$updateUserRoleCodeM$14$com-collectpoint-net-vm-HomePageVm, reason: not valid java name */
    /* synthetic */ void m436lambda$updateUserRoleCodeM$14$comcollectpointnetvmHomePageVm(Throwable th) throws Exception {
        this.mUpdateUserRoleCodeM.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    public void updateUserProjectOrgCode(String str, String str2) {
        this.mDisposable = this.mRepository.updateUserProjectOrgCode(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda12
            public final void accept(Object obj) throws Exception {
                this.f$0.m428x1dce3e1f((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda7
            public final void accept(Object obj) throws Exception {
                this.f$0.m429x920d767e((UpdateUserProjectOrgCodRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda3
            public final void accept(Object obj) throws Exception {
                this.f$0.m430x64caedd((Throwable) obj);
            }
        });
    }

    public void updateUserRoleCode(String str, String str2) {
        this.mDisposable = this.mRepository.updateUserRoleCode(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda13
            public final void accept(Object obj) throws Exception {
                this.f$0.m433lambda$updateUserRoleCode$9$comcollectpointnetvmHomePageVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda8
            public final void accept(Object obj) throws Exception {
                this.f$0.m431lambda$updateUserRoleCode$10$comcollectpointnetvmHomePageVm((UpdateUserRoleCodeRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda4
            public final void accept(Object obj) throws Exception {
                this.f$0.m432lambda$updateUserRoleCode$11$comcollectpointnetvmHomePageVm((Throwable) obj);
            }
        });
    }

    public void updateUserRoleCodeM(String str, String str2) {
        this.mDisposable = this.mRepository.updateUserRoleCode(str, str2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda14
            public final void accept(Object obj) throws Exception {
                this.f$0.m434lambda$updateUserRoleCodeM$12$comcollectpointnetvmHomePageVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda9
            public final void accept(Object obj) throws Exception {
                this.f$0.m435lambda$updateUserRoleCodeM$13$comcollectpointnetvmHomePageVm((UpdateUserRoleCodeRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.HomePageVm$$ExternalSyntheticLambda5
            public final void accept(Object obj) throws Exception {
                this.f$0.m436lambda$updateUserRoleCodeM$14$comcollectpointnetvmHomePageVm((Throwable) obj);
            }
        });
    }
}
