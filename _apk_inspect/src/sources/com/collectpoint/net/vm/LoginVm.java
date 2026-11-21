package com.collectpoint.net.vm;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.collectpoint.bean.UserBean;
import com.collectpoint.bean.item.AchieveModeListItem;
import com.collectpoint.bean.item.CachedCollectPointListItem;
import com.collectpoint.bean.item.CollectObjectParameterListItem;
import com.collectpoint.bean.item.CollectObjectTypeListItem;
import com.collectpoint.bean.item.FilePathItem;
import com.collectpoint.bean.req.AuxiliaryListReq;
import com.collectpoint.bean.req.InsertCollectPointReq;
import com.collectpoint.bean.res.BaseResponse;
import com.collectpoint.bean.res.CachedCollectObjectInfoRes;
import com.collectpoint.bean.res.GraphicCodeRes;
import com.collectpoint.bean.res.UploadWxRes;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.repo.RxHandler;
import com.collectpoint.net.repo.UploadFileRepo;
import com.collectpoint.net.repo.UserRepo;
import com.collectpoint.utils.EmptyUtils;
import com.google.common.base.Preconditions;
import com.liuwq.base.databinding.BaseRequestViewModel;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class LoginVm extends BaseRequestViewModel {
    public MediatorLiveData<Resource<List<AchieveModeListItem>>> mAchieveModeList;
    public MediatorLiveData<Resource<CachedCollectObjectInfoRes>> mCachedCollectObjectInfo;
    public MediatorLiveData<Resource<List<CachedCollectPointListItem>>> mCachedCollectPointList;
    public MediatorLiveData<Resource<CachedCollectObjectInfoRes>> mCollectObjectInfo;
    public MediatorLiveData<Resource<List<CollectObjectTypeListItem>>> mCollectObjectList;
    public MediatorLiveData<Resource<List<CollectObjectParameterListItem>>> mCollectObjectParameterList;
    public MediatorLiveData<Resource<List<CollectObjectTypeListItem>>> mCollectObjectTypeList;
    public MediatorLiveData<Resource<CachedCollectPointListItem>> mCollectPointInfo;
    public MediatorLiveData<Resource<List<CachedCollectObjectInfoRes>>> mCollectRecordList;
    public MediatorLiveData<Resource<String>> mDeleteCollectPoint;
    public MediatorLiveData<Resource<List<AchieveModeListItem>>> mFrequencyList;
    public MediatorLiveData<Resource<GraphicCodeRes>> mGraphicCode;
    private final RxHandler mHttpHandler;
    public MediatorLiveData<Resource<String>> mInsertCollectPoint;
    public MediatorLiveData<Resource<String>> mMobileLogin;
    public MediatorLiveData<Resource<String>> mSendSms;
    public MediatorLiveData<Resource<String>> mSubmitCollectObject;
    public MediatorLiveData<Resource<String>> mUpdateCollectPoint;
    public MediatorLiveData<Resource<UserBean>> mUpdateUserPwd;
    private final UploadFileRepo mUploadRepo;
    private final UserRepo mUserRepo;
    public MediatorLiveData<Resource<String>> pLoginResponse;

    public LoginVm(Application application, UserRepo userRepo, UploadFileRepo uploadFileRepo) {
        super(application);
        this.pLoginResponse = new MediatorLiveData<>();
        this.mGraphicCode = new MediatorLiveData<>();
        this.mMobileLogin = new MediatorLiveData<>();
        this.mUpdateUserPwd = new MediatorLiveData<>();
        this.mSendSms = new MediatorLiveData<>();
        this.mCollectObjectTypeList = new MediatorLiveData<>();
        this.mCollectObjectList = new MediatorLiveData<>();
        this.mAchieveModeList = new MediatorLiveData<>();
        this.mFrequencyList = new MediatorLiveData<>();
        this.mCachedCollectObjectInfo = new MediatorLiveData<>();
        this.mCachedCollectPointList = new MediatorLiveData<>();
        this.mCollectObjectParameterList = new MediatorLiveData<>();
        this.mInsertCollectPoint = new MediatorLiveData<>();
        this.mUpdateCollectPoint = new MediatorLiveData<>();
        this.mSubmitCollectObject = new MediatorLiveData<>();
        this.mDeleteCollectPoint = new MediatorLiveData<>();
        this.mCollectRecordList = new MediatorLiveData<>();
        this.mCollectObjectInfo = new MediatorLiveData<>();
        this.mCollectPointInfo = new MediatorLiveData<>();
        this.mUserRepo = (UserRepo) Preconditions.checkNotNull(userRepo);
        this.mUploadRepo = (UploadFileRepo) Preconditions.checkNotNull(uploadFileRepo);
        this.mHttpHandler = RxHandler.getInstance(this.mContext);
    }

    public void deleteCollectPoint(String str) {
        this.mDisposable = this.mUserRepo.deleteCollectPoint(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda51
            public final void accept(Object obj) throws Exception {
                this.f$0.m437lambda$deleteCollectPoint$42$comcollectpointnetvmLoginVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda16
            public final void accept(Object obj) throws Exception {
                this.f$0.m438lambda$deleteCollectPoint$43$comcollectpointnetvmLoginVm((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda19
            public final void accept(Object obj) throws Exception {
                this.f$0.m439lambda$deleteCollectPoint$44$comcollectpointnetvmLoginVm((Throwable) obj);
            }
        });
    }

    public void getAchieveModeList() {
        this.mDisposable = this.mUserRepo.getAchieveModeList().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda52
            public final void accept(Object obj) throws Exception {
                this.f$0.m440lambda$getAchieveModeList$17$comcollectpointnetvmLoginVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda38
            public final void accept(Object obj) throws Exception {
                this.f$0.m441lambda$getAchieveModeList$18$comcollectpointnetvmLoginVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda20
            public final void accept(Object obj) throws Exception {
                this.f$0.m442lambda$getAchieveModeList$19$comcollectpointnetvmLoginVm((Throwable) obj);
            }
        });
    }

    public void getCachedCollectObjectInfo() {
        this.mDisposable = this.mUserRepo.getCachedCollectObjectInfo().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda53
            public final void accept(Object obj) throws Exception {
                this.f$0.m443x51bb4cda((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda44
            public final void accept(Object obj) throws Exception {
                this.f$0.m444xcf9308db((CachedCollectObjectInfoRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda21
            public final void accept(Object obj) throws Exception {
                this.f$0.m445x4d6ac4dc((Throwable) obj);
            }
        });
    }

    public void getCachedCollectPointList(String str) {
        this.mDisposable = this.mUserRepo.getCachedCollectPointList(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda1
            public final void accept(Object obj) throws Exception {
                this.f$0.m446xfe24573a((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda39
            public final void accept(Object obj) throws Exception {
                this.f$0.m447x7bfc133b((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda23
            public final void accept(Object obj) throws Exception {
                this.f$0.m448xf9d3cf3c((Throwable) obj);
            }
        });
    }

    public void getCollectObjectInfo(String str) {
        this.mDisposable = this.mUserRepo.getCollectObjectInfo(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda2
            public final void accept(Object obj) throws Exception {
                this.f$0.m449lambda$getCollectObjectInfo$48$comcollectpointnetvmLoginVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda49
            public final void accept(Object obj) throws Exception {
                this.f$0.m450lambda$getCollectObjectInfo$49$comcollectpointnetvmLoginVm((CachedCollectObjectInfoRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda24
            public final void accept(Object obj) throws Exception {
                this.f$0.m451lambda$getCollectObjectInfo$50$comcollectpointnetvmLoginVm((Throwable) obj);
            }
        });
    }

    public void getCollectObjectList(String str, String str2, int i, int i2) {
        this.mDisposable = this.mUserRepo.getCollectObjectList(str, str2, i, i2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda3
            public final void accept(Object obj) throws Exception {
                this.f$0.m452lambda$getCollectObjectList$14$comcollectpointnetvmLoginVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda40
            public final void accept(Object obj) throws Exception {
                this.f$0.m453lambda$getCollectObjectList$15$comcollectpointnetvmLoginVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda25
            public final void accept(Object obj) throws Exception {
                this.f$0.m454lambda$getCollectObjectList$16$comcollectpointnetvmLoginVm((Throwable) obj);
            }
        });
    }

    public void getCollectObjectParameterList(String str) {
        this.mDisposable = this.mUserRepo.getCollectObjectParameterList(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda4
            public final void accept(Object obj) throws Exception {
                this.f$0.m455xfd3fa8e5((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda41
            public final void accept(Object obj) throws Exception {
                this.f$0.m456xcdc9d0fb((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda26
            public final void accept(Object obj) throws Exception {
                this.f$0.m457x4ba18cfc((Throwable) obj);
            }
        });
    }

    public void getCollectObjectTypeList() {
        this.mDisposable = this.mUserRepo.getCollectObjectTypeList().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda5
            public final void accept(Object obj) throws Exception {
                this.f$0.m458xe66e0ad((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda42
            public final void accept(Object obj) throws Exception {
                this.f$0.m459x8c3e9cae((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda27
            public final void accept(Object obj) throws Exception {
                this.f$0.m460xa1658af((Throwable) obj);
            }
        });
    }

    public void getCollectPointInfo(String str) {
        this.mDisposable = this.mUserRepo.getCollectPointInfo(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda6
            public final void accept(Object obj) throws Exception {
                this.f$0.m461lambda$getCollectPointInfo$51$comcollectpointnetvmLoginVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda33
            public final void accept(Object obj) throws Exception {
                this.f$0.m462lambda$getCollectPointInfo$52$comcollectpointnetvmLoginVm((CachedCollectPointListItem) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda28
            public final void accept(Object obj) throws Exception {
                this.f$0.m463lambda$getCollectPointInfo$53$comcollectpointnetvmLoginVm((Throwable) obj);
            }
        });
    }

    public void getCollectRecordList(int i, int i2) {
        this.mDisposable = this.mUserRepo.getCollectRecordList(i, i2).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda7
            public final void accept(Object obj) throws Exception {
                this.f$0.m464lambda$getCollectRecordList$45$comcollectpointnetvmLoginVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda43
            public final void accept(Object obj) throws Exception {
                this.f$0.m465lambda$getCollectRecordList$46$comcollectpointnetvmLoginVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda29
            public final void accept(Object obj) throws Exception {
                this.f$0.m466lambda$getCollectRecordList$47$comcollectpointnetvmLoginVm((Throwable) obj);
            }
        });
    }

    public void getFrequencyList() {
        this.mDisposable = this.mUserRepo.getFrequencyList().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda8
            public final void accept(Object obj) throws Exception {
                this.f$0.m467lambda$getFrequencyList$20$comcollectpointnetvmLoginVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda45
            public final void accept(Object obj) throws Exception {
                this.f$0.m468lambda$getFrequencyList$21$comcollectpointnetvmLoginVm((List) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda30
            public final void accept(Object obj) throws Exception {
                this.f$0.m469lambda$getFrequencyList$22$comcollectpointnetvmLoginVm((Throwable) obj);
            }
        });
    }

    public void getGraphicCode() {
        this.mDisposable = this.mUserRepo.getGraphicCode().observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda9
            public final void accept(Object obj) throws Exception {
                this.f$0.m470lambda$getGraphicCode$1$comcollectpointnetvmLoginVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda50
            public final void accept(Object obj) throws Exception {
                this.f$0.m471lambda$getGraphicCode$2$comcollectpointnetvmLoginVm((GraphicCodeRes) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda31
            public final void accept(Object obj) throws Exception {
                this.f$0.m472lambda$getGraphicCode$3$comcollectpointnetvmLoginVm((Throwable) obj);
            }
        });
    }

    public void insertCollectPoint(final InsertCollectPointReq insertCollectPointReq) {
        ArrayList arrayList = new ArrayList();
        if (EmptyUtils.isNotEmpty(insertCollectPointReq.getAuxiliaryList())) {
            for (AuxiliaryListReq auxiliaryListReq : insertCollectPointReq.getAuxiliaryList()) {
                if (EmptyUtils.isNotEmpty(auxiliaryListReq.getPicList())) {
                    arrayList.addAll(auxiliaryListReq.getPicList());
                }
            }
        }
        if (EmptyUtils.isNotEmpty(arrayList)) {
            this.mDisposable = this.mUploadRepo.rxUploadWxImgs(arrayList, 1, "").flatMap(new Function() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda48
                public final Object apply(Object obj) {
                    return this.f$0.m473lambda$insertCollectPoint$32$comcollectpointnetvmLoginVm(insertCollectPointReq, (List) obj);
                }
            }).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda10
                public final void accept(Object obj) throws Exception {
                    this.f$0.m474lambda$insertCollectPoint$33$comcollectpointnetvmLoginVm((Disposable) obj);
                }
            }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda46
                public final void accept(Object obj) throws Exception {
                    this.f$0.m475lambda$insertCollectPoint$34$comcollectpointnetvmLoginVm(insertCollectPointReq, (String) obj);
                }
            }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda32
                public final void accept(Object obj) throws Exception {
                    this.f$0.m476lambda$insertCollectPoint$35$comcollectpointnetvmLoginVm((Throwable) obj);
                }
            });
        } else {
            this.mDisposable = this.mUserRepo.insertCollectPoint(insertCollectPointReq).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda12
                public final void accept(Object obj) throws Exception {
                    this.f$0.m477lambda$insertCollectPoint$36$comcollectpointnetvmLoginVm((Disposable) obj);
                }
            }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda47
                public final void accept(Object obj) throws Exception {
                    this.f$0.m478lambda$insertCollectPoint$37$comcollectpointnetvmLoginVm(insertCollectPointReq, (String) obj);
                }
            }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda34
                public final void accept(Object obj) throws Exception {
                    this.f$0.m479lambda$insertCollectPoint$38$comcollectpointnetvmLoginVm((Throwable) obj);
                }
            });
        }
    }

    /* renamed from: lambda$deleteCollectPoint$42$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m437lambda$deleteCollectPoint$42$comcollectpointnetvmLoginVm(Disposable disposable) throws Exception {
        this.mDeleteCollectPoint.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$deleteCollectPoint$43$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m438lambda$deleteCollectPoint$43$comcollectpointnetvmLoginVm(String str) throws Exception {
        this.mDeleteCollectPoint.setValue(Resource.success(str));
    }

    /* renamed from: lambda$deleteCollectPoint$44$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m439lambda$deleteCollectPoint$44$comcollectpointnetvmLoginVm(Throwable th) throws Exception {
        this.mDeleteCollectPoint.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getAchieveModeList$17$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m440lambda$getAchieveModeList$17$comcollectpointnetvmLoginVm(Disposable disposable) throws Exception {
        this.mAchieveModeList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getAchieveModeList$18$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m441lambda$getAchieveModeList$18$comcollectpointnetvmLoginVm(List list) throws Exception {
        this.mAchieveModeList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getAchieveModeList$19$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m442lambda$getAchieveModeList$19$comcollectpointnetvmLoginVm(Throwable th) throws Exception {
        this.mAchieveModeList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getCachedCollectObjectInfo$23$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m443x51bb4cda(Disposable disposable) throws Exception {
        this.mCachedCollectObjectInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getCachedCollectObjectInfo$24$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m444xcf9308db(CachedCollectObjectInfoRes cachedCollectObjectInfoRes) throws Exception {
        this.mCachedCollectObjectInfo.setValue(Resource.success(cachedCollectObjectInfoRes));
    }

    /* renamed from: lambda$getCachedCollectObjectInfo$25$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m445x4d6ac4dc(Throwable th) throws Exception {
        this.mCachedCollectObjectInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getCachedCollectPointList$26$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m446xfe24573a(Disposable disposable) throws Exception {
        this.mCachedCollectPointList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getCachedCollectPointList$27$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m447x7bfc133b(List list) throws Exception {
        this.mCachedCollectPointList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getCachedCollectPointList$28$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m448xf9d3cf3c(Throwable th) throws Exception {
        this.mCachedCollectPointList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getCollectObjectInfo$48$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m449lambda$getCollectObjectInfo$48$comcollectpointnetvmLoginVm(Disposable disposable) throws Exception {
        this.mCollectObjectInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getCollectObjectInfo$49$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m450lambda$getCollectObjectInfo$49$comcollectpointnetvmLoginVm(CachedCollectObjectInfoRes cachedCollectObjectInfoRes) throws Exception {
        this.mCollectObjectInfo.setValue(Resource.success(cachedCollectObjectInfoRes));
    }

    /* renamed from: lambda$getCollectObjectInfo$50$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m451lambda$getCollectObjectInfo$50$comcollectpointnetvmLoginVm(Throwable th) throws Exception {
        this.mCollectObjectInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getCollectObjectList$14$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m452lambda$getCollectObjectList$14$comcollectpointnetvmLoginVm(Disposable disposable) throws Exception {
        this.mCollectObjectList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getCollectObjectList$15$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m453lambda$getCollectObjectList$15$comcollectpointnetvmLoginVm(List list) throws Exception {
        this.mCollectObjectList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getCollectObjectList$16$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m454lambda$getCollectObjectList$16$comcollectpointnetvmLoginVm(Throwable th) throws Exception {
        this.mCollectObjectList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getCollectObjectParameterList$29$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m455xfd3fa8e5(Disposable disposable) throws Exception {
        this.mCollectObjectParameterList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getCollectObjectParameterList$30$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m456xcdc9d0fb(List list) throws Exception {
        this.mCollectObjectParameterList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getCollectObjectParameterList$31$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m457x4ba18cfc(Throwable th) throws Exception {
        this.mCollectObjectParameterList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getCollectObjectTypeList$11$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m458xe66e0ad(Disposable disposable) throws Exception {
        this.mCollectObjectTypeList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getCollectObjectTypeList$12$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m459x8c3e9cae(List list) throws Exception {
        this.mCollectObjectTypeList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getCollectObjectTypeList$13$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m460xa1658af(Throwable th) throws Exception {
        this.mCollectObjectTypeList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getCollectPointInfo$51$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m461lambda$getCollectPointInfo$51$comcollectpointnetvmLoginVm(Disposable disposable) throws Exception {
        this.mCollectPointInfo.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getCollectPointInfo$52$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m462lambda$getCollectPointInfo$52$comcollectpointnetvmLoginVm(CachedCollectPointListItem cachedCollectPointListItem) throws Exception {
        this.mCollectPointInfo.setValue(Resource.success(cachedCollectPointListItem));
    }

    /* renamed from: lambda$getCollectPointInfo$53$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m463lambda$getCollectPointInfo$53$comcollectpointnetvmLoginVm(Throwable th) throws Exception {
        this.mCollectPointInfo.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getCollectRecordList$45$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m464lambda$getCollectRecordList$45$comcollectpointnetvmLoginVm(Disposable disposable) throws Exception {
        this.mCollectRecordList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getCollectRecordList$46$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m465lambda$getCollectRecordList$46$comcollectpointnetvmLoginVm(List list) throws Exception {
        this.mCollectRecordList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getCollectRecordList$47$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m466lambda$getCollectRecordList$47$comcollectpointnetvmLoginVm(Throwable th) throws Exception {
        this.mCollectRecordList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getFrequencyList$20$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m467lambda$getFrequencyList$20$comcollectpointnetvmLoginVm(Disposable disposable) throws Exception {
        this.mFrequencyList.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getFrequencyList$21$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m468lambda$getFrequencyList$21$comcollectpointnetvmLoginVm(List list) throws Exception {
        this.mFrequencyList.setValue(Resource.success(list));
    }

    /* renamed from: lambda$getFrequencyList$22$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m469lambda$getFrequencyList$22$comcollectpointnetvmLoginVm(Throwable th) throws Exception {
        this.mFrequencyList.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$getGraphicCode$1$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m470lambda$getGraphicCode$1$comcollectpointnetvmLoginVm(Disposable disposable) throws Exception {
        this.mGraphicCode.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$getGraphicCode$2$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m471lambda$getGraphicCode$2$comcollectpointnetvmLoginVm(GraphicCodeRes graphicCodeRes) throws Exception {
        this.mGraphicCode.setValue(Resource.success(graphicCodeRes));
    }

    /* renamed from: lambda$getGraphicCode$3$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m472lambda$getGraphicCode$3$comcollectpointnetvmLoginVm(Throwable th) throws Exception {
        this.mGraphicCode.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$insertCollectPoint$32$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ SingleSource m473lambda$insertCollectPoint$32$comcollectpointnetvmLoginVm(InsertCollectPointReq insertCollectPointReq, List list) throws Exception {
        ArrayList arrayList = new ArrayList(list);
        if (EmptyUtils.isNotEmpty(insertCollectPointReq.getAuxiliaryList())) {
            for (int i = 0; i < insertCollectPointReq.getAuxiliaryList().size(); i++) {
                if (EmptyUtils.isNotEmpty(insertCollectPointReq.getAuxiliaryList().get(i).getPicList())) {
                    ArrayList arrayList2 = new ArrayList();
                    if (EmptyUtils.isNotEmpty(arrayList)) {
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            arrayList2.add(new FilePathItem(((UploadWxRes) ((BaseResponse) arrayList.get(i2)).getObject()).getObject()));
                        }
                    }
                    insertCollectPointReq.getAuxiliaryList().get(i).setPhotoList(arrayList2);
                }
            }
        }
        return this.mUserRepo.insertCollectPoint(insertCollectPointReq);
    }

    /* renamed from: lambda$insertCollectPoint$33$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m474lambda$insertCollectPoint$33$comcollectpointnetvmLoginVm(Disposable disposable) throws Exception {
        this.mInsertCollectPoint.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$insertCollectPoint$34$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m475lambda$insertCollectPoint$34$comcollectpointnetvmLoginVm(InsertCollectPointReq insertCollectPointReq, String str) throws Exception {
        this.mInsertCollectPoint.setValue(Resource.success(insertCollectPointReq.getCollectTimeStamp() + "-" + str));
    }

    /* renamed from: lambda$insertCollectPoint$35$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m476lambda$insertCollectPoint$35$comcollectpointnetvmLoginVm(Throwable th) throws Exception {
        this.mInsertCollectPoint.setValue(Resource.error(this.mHttpHandler.getThrowableHCMsg(th, 4), null));
    }

    /* renamed from: lambda$insertCollectPoint$36$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m477lambda$insertCollectPoint$36$comcollectpointnetvmLoginVm(Disposable disposable) throws Exception {
        this.mInsertCollectPoint.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$insertCollectPoint$37$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m478lambda$insertCollectPoint$37$comcollectpointnetvmLoginVm(InsertCollectPointReq insertCollectPointReq, String str) throws Exception {
        this.mInsertCollectPoint.setValue(Resource.success(insertCollectPointReq.getCollectTimeStamp() + "-" + str));
    }

    /* renamed from: lambda$insertCollectPoint$38$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m479lambda$insertCollectPoint$38$comcollectpointnetvmLoginVm(Throwable th) throws Exception {
        this.mInsertCollectPoint.setValue(Resource.error(this.mHttpHandler.getThrowableHCMsg(th, 4), null));
    }

    /* renamed from: lambda$mobileLogin$4$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m480lambda$mobileLogin$4$comcollectpointnetvmLoginVm(Resource resource) {
        this.mMobileLogin.setValue(resource);
    }

    /* renamed from: lambda$onLoginBtnClick$0$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m481lambda$onLoginBtnClick$0$comcollectpointnetvmLoginVm(Resource resource) {
        this.pLoginResponse.setValue(resource);
    }

    /* renamed from: lambda$sendSms$10$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m482lambda$sendSms$10$comcollectpointnetvmLoginVm(Throwable th) throws Exception {
        this.mSendSms.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$sendSms$8$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m483lambda$sendSms$8$comcollectpointnetvmLoginVm(Disposable disposable) throws Exception {
        this.mSendSms.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$sendSms$9$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m484lambda$sendSms$9$comcollectpointnetvmLoginVm(String str) throws Exception {
        this.mSendSms.setValue(Resource.success(str));
    }

    /* renamed from: lambda$submitCollectObject$39$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m485lambda$submitCollectObject$39$comcollectpointnetvmLoginVm(Disposable disposable) throws Exception {
        this.mSubmitCollectObject.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$submitCollectObject$40$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m486lambda$submitCollectObject$40$comcollectpointnetvmLoginVm(String str) throws Exception {
        this.mSubmitCollectObject.setValue(Resource.success(str));
    }

    /* renamed from: lambda$submitCollectObject$41$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m487lambda$submitCollectObject$41$comcollectpointnetvmLoginVm(Throwable th) throws Exception {
        this.mSubmitCollectObject.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    /* renamed from: lambda$updateUserPwd$5$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m488lambda$updateUserPwd$5$comcollectpointnetvmLoginVm(Disposable disposable) throws Exception {
        this.mUpdateUserPwd.setValue(Resource.loading(null));
    }

    /* renamed from: lambda$updateUserPwd$6$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m489lambda$updateUserPwd$6$comcollectpointnetvmLoginVm(UserBean userBean) throws Exception {
        this.mUpdateUserPwd.setValue(Resource.success(userBean));
    }

    /* renamed from: lambda$updateUserPwd$7$com-collectpoint-net-vm-LoginVm, reason: not valid java name */
    /* synthetic */ void m490lambda$updateUserPwd$7$comcollectpointnetvmLoginVm(Throwable th) throws Exception {
        this.mUpdateUserPwd.setValue(Resource.error(this.mHttpHandler.getThrowableMsg(th), null));
    }

    public void mobileLogin(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.mMobileLogin.setValue(Resource.error("请输入手机号码"));
        } else if (TextUtils.isEmpty(str2)) {
            this.mMobileLogin.setValue(Resource.error("请输入验证码"));
        } else {
            this.mMobileLogin.addSource(this.mUserRepo.mobileLogin(str, str2), new Observer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda0
                public final void onChanged(Object obj) {
                    this.f$0.m480lambda$mobileLogin$4$comcollectpointnetvmLoginVm((Resource) obj);
                }
            });
        }
    }

    public void onLoginBtnClick(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.pLoginResponse.setValue(Resource.error("请输入登录账号"));
        } else if (TextUtils.isEmpty(str2)) {
            this.pLoginResponse.setValue(Resource.error("请输入输入密码"));
        } else {
            this.pLoginResponse.addSource(this.mUserRepo.login(str, str2, ""), new Observer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda11
                public final void onChanged(Object obj) {
                    this.f$0.m481lambda$onLoginBtnClick$0$comcollectpointnetvmLoginVm((Resource) obj);
                }
            });
        }
    }

    public void sendSms(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            this.mSendSms.setValue(Resource.error("请输入手机号码"));
        } else if (TextUtils.isEmpty(str4)) {
            this.mSendSms.setValue(Resource.error("请输入图形验证码"));
        } else {
            this.mDisposable = this.mUserRepo.sendSms(str, str2, str3, str4).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda13
                public final void accept(Object obj) throws Exception {
                    this.f$0.m483lambda$sendSms$8$comcollectpointnetvmLoginVm((Disposable) obj);
                }
            }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda17
                public final void accept(Object obj) throws Exception {
                    this.f$0.m484lambda$sendSms$9$comcollectpointnetvmLoginVm((String) obj);
                }
            }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda35
                public final void accept(Object obj) throws Exception {
                    this.f$0.m482lambda$sendSms$10$comcollectpointnetvmLoginVm((Throwable) obj);
                }
            });
        }
    }

    public void submitCollectObject(String str) {
        this.mDisposable = this.mUserRepo.submitCollectObject(str).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda14
            public final void accept(Object obj) throws Exception {
                this.f$0.m485lambda$submitCollectObject$39$comcollectpointnetvmLoginVm((Disposable) obj);
            }
        }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda18
            public final void accept(Object obj) throws Exception {
                this.f$0.m486lambda$submitCollectObject$40$comcollectpointnetvmLoginVm((String) obj);
            }
        }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda36
            public final void accept(Object obj) throws Exception {
                this.f$0.m487lambda$submitCollectObject$41$comcollectpointnetvmLoginVm((Throwable) obj);
            }
        });
    }

    public void updateUserPwd(String str, String str2, String str3, String str4) {
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
            this.mDisposable = this.mUserRepo.updateUserPwd("", str, str2, str4).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda15
                public final void accept(Object obj) throws Exception {
                    this.f$0.m488lambda$updateUserPwd$5$comcollectpointnetvmLoginVm((Disposable) obj);
                }
            }).subscribe(new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda22
                public final void accept(Object obj) throws Exception {
                    this.f$0.m489lambda$updateUserPwd$6$comcollectpointnetvmLoginVm((UserBean) obj);
                }
            }, new Consumer() { // from class: com.collectpoint.net.vm.LoginVm$$ExternalSyntheticLambda37
                public final void accept(Object obj) throws Exception {
                    this.f$0.m490lambda$updateUserPwd$7$comcollectpointnetvmLoginVm((Throwable) obj);
                }
            });
        } else {
            this.mUpdateUserPwd.setValue(Resource.error("修改密码和确认密码不一致"));
        }
    }
}
