package com.collectpoint.net.vm;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.collectpoint.bean.UserBean;
import com.collectpoint.bean.res.AppDownloadQRCodeRes;
import com.collectpoint.bean.res.GraphicCodeRes;
import com.collectpoint.bean.res.SoftWareNewestVersionApiRes;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.repo.RxHandler;
import com.collectpoint.net.repo.UploadFileRepo;
import com.collectpoint.net.repo.UserRepo;
import com.google.common.base.Preconditions;
import com.liuwq.base.databinding.BaseRequestViewModel;
import com.liuwq.base.databinding.SingleLiveEvent;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class MineVm extends BaseRequestViewModel {
    public MediatorLiveData<Resource<AppDownloadQRCodeRes>> mAppDownloadQRCode;
    public MediatorLiveData<Resource<GraphicCodeRes>> mGraphicCode;
    private final RxHandler mHttpHandler;
    public MediatorLiveData<Resource<String>> mInsertFeedBackApi;
    public MediatorLiveData<Resource<String>> mSendSms;
    public MediatorLiveData<Resource<SoftWareNewestVersionApiRes>> mSoftWareNewestVersionApi;
    public MediatorLiveData<Resource<String>> mUpdateUser;
    public MediatorLiveData<Resource<UserBean>> mUpdateUserPwd;
    private final UploadFileRepo mUploadRepo;
    private UserRepo mUserRepo;
    public SingleLiveEvent<Void> pLogoutEvent;

    public MineVm(Application application, UserRepo userRepo, UploadFileRepo uploadFileRepo) {
        super(application);
        this.mUpdateUser = new MediatorLiveData<>();
        this.mInsertFeedBackApi = new MediatorLiveData<>();
        this.mSoftWareNewestVersionApi = new MediatorLiveData<>();
        this.mGraphicCode = new MediatorLiveData<>();
        this.mUpdateUserPwd = new MediatorLiveData<>();
        this.mSendSms = new MediatorLiveData<>();
        this.mAppDownloadQRCode = new MediatorLiveData<>();
        this.mUserRepo = (UserRepo) Preconditions.checkNotNull(userRepo);
        this.mHttpHandler = RxHandler.getInstance(this.mContext);
        this.mUploadRepo = (UploadFileRepo) Preconditions.checkNotNull(uploadFileRepo);
        this.pLogoutEvent = new SingleLiveEvent<>();
    }

    public void getAppDownloadQRCode() {
        this.mDisposable = this.mUserRepo.getAppDownloadQRCode().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MineVm$$ExternalSyntheticLambda6
            public final void accept(Object obj) throws Exception {
                this.f$0.m524lambda$getAppDownloadQRCode$10$comcollectpointnetvmMineVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MineVm$$ExternalSyntheticLambda4
            public final void accept(Object obj) throws Exception {
                this.f$0.m525lambda$getAppDownloadQRCode$11$comcollectpointnetvmMineVm((AppDownloadQRCodeRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.MineVm$$ExternalSyntheticLambda11
            public final void accept(Object obj) throws Exception {
                this.f$0.m526lambda$getAppDownloadQRCode$12$comcollectpointnetvmMineVm((Throwable) obj);
            }
        });
    }

    public void getGraphicCode() {
        this.mDisposable = this.mUserRepo.getGraphicCode().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MineVm$$ExternalSyntheticLambda7
            public final void accept(Object obj) throws Exception {
                this.f$0.m527lambda$getGraphicCode$0$comcollectpointnetvmMineVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MineVm$$ExternalSyntheticLambda5
            public final void accept(Object obj) throws Exception {
                this.f$0.m528lambda$getGraphicCode$1$comcollectpointnetvmMineVm((GraphicCodeRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.MineVm$$ExternalSyntheticLambda12
            public final void accept(Object obj) throws Exception {
                this.f$0.m529lambda$getGraphicCode$2$comcollectpointnetvmMineVm((Throwable) obj);
            }
        });
    }

    public MutableLiveData<Resource<UserBean>> getLoggedInUser() {
        return this.mUserRepo.getLoggedInUser();
    }

    /* renamed from: lambda$getAppDownloadQRCode$10$com-collectpoint-net-vm-MineVm, reason: not valid java name */
    /* synthetic */ void m524lambda$getAppDownloadQRCode$10$comcollectpointnetvmMineVm(Disposable disposable) throws Exception {
        this.mAppDownloadQRCode.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getAppDownloadQRCode$11$com-collectpoint-net-vm-MineVm, reason: not valid java name */
    /* synthetic */ void m525lambda$getAppDownloadQRCode$11$comcollectpointnetvmMineVm(AppDownloadQRCodeRes appDownloadQRCodeRes) throws Exception {
        this.mAppDownloadQRCode.setValue(Resource.success(appDownloadQRCodeRes));
    }

    /* renamed from: lambda$getAppDownloadQRCode$12$com-collectpoint-net-vm-MineVm, reason: not valid java name */
    /* synthetic */ void m526lambda$getAppDownloadQRCode$12$comcollectpointnetvmMineVm(Throwable th) throws Exception {
        this.mAppDownloadQRCode.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getGraphicCode$0$com-collectpoint-net-vm-MineVm, reason: not valid java name */
    /* synthetic */ void m527lambda$getGraphicCode$0$comcollectpointnetvmMineVm(Disposable disposable) throws Exception {
        this.mGraphicCode.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getGraphicCode$1$com-collectpoint-net-vm-MineVm, reason: not valid java name */
    /* synthetic */ void m528lambda$getGraphicCode$1$comcollectpointnetvmMineVm(GraphicCodeRes graphicCodeRes) throws Exception {
        this.mGraphicCode.setValue(Resource.success(graphicCodeRes));
    }

    /* renamed from: lambda$getGraphicCode$2$com-collectpoint-net-vm-MineVm, reason: not valid java name */
    /* synthetic */ void m529lambda$getGraphicCode$2$comcollectpointnetvmMineVm(Throwable th) throws Exception {
        this.mGraphicCode.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$sendSms$7$com-collectpoint-net-vm-MineVm, reason: not valid java name */
    /* synthetic */ void m530lambda$sendSms$7$comcollectpointnetvmMineVm(Disposable disposable) throws Exception {
        this.mSendSms.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$sendSms$8$com-collectpoint-net-vm-MineVm, reason: not valid java name */
    /* synthetic */ void m531lambda$sendSms$8$comcollectpointnetvmMineVm(String str) throws Exception {
        this.mSendSms.setValue(Resource.success(str));
    }

    /* renamed from: lambda$sendSms$9$com-collectpoint-net-vm-MineVm, reason: not valid java name */
    /* synthetic */ void m532lambda$sendSms$9$comcollectpointnetvmMineVm(Throwable th) throws Exception {
        this.mSendSms.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$updateUserPwd$3$com-collectpoint-net-vm-MineVm, reason: not valid java name */
    /* synthetic */ SingleSource m533lambda$updateUserPwd$3$comcollectpointnetvmMineVm(String str, String str2, String str3, UserBean userBean) throws Exception {
        return this.mUserRepo.updateUserPwd(userBean.getUserCode(), str, str2, str3);
    }

    /* renamed from: lambda$updateUserPwd$4$com-collectpoint-net-vm-MineVm, reason: not valid java name */
    /* synthetic */ void m534lambda$updateUserPwd$4$comcollectpointnetvmMineVm(Disposable disposable) throws Exception {
        this.mUpdateUserPwd.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$updateUserPwd$5$com-collectpoint-net-vm-MineVm, reason: not valid java name */
    /* synthetic */ void m535lambda$updateUserPwd$5$comcollectpointnetvmMineVm(UserBean userBean) throws Exception {
        this.mUpdateUserPwd.setValue(Resource.success(userBean));
    }

    /* renamed from: lambda$updateUserPwd$6$com-collectpoint-net-vm-MineVm, reason: not valid java name */
    /* synthetic */ void m536lambda$updateUserPwd$6$comcollectpointnetvmMineVm(Throwable th) throws Exception {
        this.mUpdateUserPwd.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    public void logout() {
        this.mUserRepo.cleanLoggedInUser();
        this.pLogoutEvent.call();
    }

    public void sendSms(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            this.mSendSms.setValue(Resource.error("请输入手机号码"));
        } else if (TextUtils.isEmpty(str4)) {
            this.mSendSms.setValue(Resource.error("请输入图形验证码"));
        } else {
            this.mDisposable = this.mUserRepo.sendSms(str, str2, str3, str4).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MineVm$$ExternalSyntheticLambda8
                public final void accept(Object obj) throws Exception {
                    this.f$0.m530lambda$sendSms$7$comcollectpointnetvmMineVm((Disposable) obj);
                }
            }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MineVm$$ExternalSyntheticLambda10
                public final void accept(Object obj) throws Exception {
                    this.f$0.m531lambda$sendSms$8$comcollectpointnetvmMineVm((String) obj);
                }
            }, new Consumer() { // from class: com.collectpoint.net.vm.MineVm$$ExternalSyntheticLambda1
                public final void accept(Object obj) throws Exception {
                    this.f$0.m532lambda$sendSms$9$comcollectpointnetvmMineVm((Throwable) obj);
                }
            });
        }
    }

    public void updateUserPwd(final String str, final String str2, String str3, final String str4) {
        if (TextUtils.isEmpty(str)) {
            this.mUpdateUserPwd.setValue(Resource.error("请输入手机号码"));
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            this.mUpdateUserPwd.setValue(Resource.error("请输入验证码"));
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            this.mUpdateUserPwd.setValue(Resource.error("请输入修改密码"));
        } else if (TextUtils.equals(str2, str3)) {
            this.mDisposable = this.mUserRepo.getRxCachedUser().flatMap(new Function() { // from class: com.collectpoint.net.vm.MineVm$$ExternalSyntheticLambda3
                public final Object apply(Object obj) {
                    return this.f$0.m533lambda$updateUserPwd$3$comcollectpointnetvmMineVm(str, str2, str4, (UserBean) obj);
                }
            }).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.MineVm$$ExternalSyntheticLambda9
                public final void accept(Object obj) throws Exception {
                    this.f$0.m534lambda$updateUserPwd$4$comcollectpointnetvmMineVm((Disposable) obj);
                }
            }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.MineVm$$ExternalSyntheticLambda0
                public final void accept(Object obj) throws Exception {
                    this.f$0.m535lambda$updateUserPwd$5$comcollectpointnetvmMineVm((UserBean) obj);
                }
            }, new Consumer() { // from class: com.collectpoint.net.vm.MineVm$$ExternalSyntheticLambda2
                public final void accept(Object obj) throws Exception {
                    this.f$0.m536lambda$updateUserPwd$6$comcollectpointnetvmMineVm((Throwable) obj);
                }
            });
        } else {
            this.mUpdateUserPwd.setValue(Resource.error("修改密码和确认密码不一致"));
        }
    }
}
