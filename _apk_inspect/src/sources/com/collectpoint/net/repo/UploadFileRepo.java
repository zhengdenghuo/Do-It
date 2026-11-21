package com.collectpoint.net.repo;

import android.app.Application;
import android.content.Context;
import com.blankj.utilcode.util.CacheDiskUtils;
import com.blankj.utilcode.util.CacheDoubleUtils;
import com.blankj.utilcode.util.CacheMemoryUtils;
import com.collectpoint.bean.UserBean;
import com.collectpoint.bean.res.BaseResponse;
import com.collectpoint.bean.res.UploadRes;
import com.collectpoint.bean.res.UploadWxRes;
import com.collectpoint.constants.Constants;
import com.collectpoint.net.remote.IUploadFileApi;
import com.collectpoint.utils.EmptyUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.liuwq.base.util.FileTool;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class UploadFileRepo {
    private static UploadFileRepo sInstance;
    private IUploadFileApi mApi;
    private final CacheDoubleUtils mDoubleCacheUtils;
    private final RxHandler mRxHandler;
    private String upUrl = "http://114.55.219.79//wxApi/file/upload?folder=";

    @Retention(RetentionPolicy.SOURCE)
    public @interface UploadModule {
        public static final int ALL = 1;
    }

    private UploadFileRepo(Application application, IUploadFileApi iUploadFileApi) {
        this.mApi = (IUploadFileApi) Preconditions.checkNotNull(iUploadFileApi);
        Context applicationContext = ((Application) Preconditions.checkNotNull(application)).getApplicationContext();
        this.mDoubleCacheUtils = CacheDoubleUtils.getInstance(CacheMemoryUtils.getInstance(), CacheDiskUtils.getInstance(FileTool.getDiskCacheDir(applicationContext, Constants.DISK_CACHE_DIR_NAME)));
        this.mRxHandler = RxHandler.getInstance(applicationContext);
    }

    public static MultipartBody.Builder addTextPart(MultipartBody.Builder builder, String str, String str2) {
        builder.addFormDataPart(str, (String) null, RequestBody.create(MediaType.parse("text_minorrepair/plain"), str2));
        return builder;
    }

    public static void addTextPart(List<MultipartBody.Part> list, String str, String str2, int i) {
        list.add(i, MultipartBody.Part.createFormData(str, (String) null, RequestBody.create(MediaType.parse("text_minorrepair/plain"), str2)));
    }

    private MultipartBody.Builder filesToMultipartBodyBuilder(String str, List<String> list, MediaType mediaType) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            builder.addFormDataPart(str, file.getName(), RequestBody.create(mediaType, file));
        }
        builder.setType(MultipartBody.FORM);
        return builder;
    }

    private MultipartBody.Builder filesToMultipartBodyBuilder(String str, MediaType mediaType, String... strArr) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        for (String str2 : strArr) {
            File file = new File(str2);
            builder.addFormDataPart(str, file.getName(), RequestBody.create(mediaType, file));
        }
        builder.setType(MultipartBody.FORM);
        return builder;
    }

    private List<MultipartBody.Part> filesToParts(String str, MediaType mediaType, List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            arrayList.add(MultipartBody.Part.createFormData(str, file.getName(), RequestBody.create(mediaType, file)));
        }
        return arrayList;
    }

    public static UploadFileRepo getInstance(Application application, IUploadFileApi iUploadFileApi) {
        if (sInstance == null) {
            synchronized (UploadFileRepo.class) {
                if (sInstance == null) {
                    sInstance = new UploadFileRepo(application, iUploadFileApi);
                }
            }
        }
        return sInstance;
    }

    private Single<UserBean> getRxCachedUser() {
        return Single.fromCallable(new Callable() { // from class: com.collectpoint.net.repo.UploadFileRepo$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m388x8a95c45();
            }
        });
    }

    static /* synthetic */ SingleSource lambda$rxUploadSingleFile$3(BaseResponse baseResponse) throws Exception {
        return !baseResponse.isOk() ? Single.error(new IllegalStateException(baseResponse.getMsg())) : Single.just(baseResponse);
    }

    static /* synthetic */ SingleSource lambda$rxUploadSingleImg$1(BaseResponse baseResponse) throws Exception {
        return !baseResponse.isOk() ? Single.error(new IllegalStateException(baseResponse.getMsg())) : Single.just(baseResponse);
    }

    static /* synthetic */ SingleSource lambda$rxUploadSingleWxImg$5(BaseResponse baseResponse) throws Exception {
        return !baseResponse.isOk() ? Single.error(new IllegalStateException(baseResponse.getMsg())) : Single.just(baseResponse);
    }

    private Single<BaseResponse<UploadRes>> rxUploadSingleFile(final String str, final int i, final int i2) {
        return getRxCachedUser().observeOn(Schedulers.io()).flatMap(new Function() { // from class: com.collectpoint.net.repo.UploadFileRepo$$ExternalSyntheticLambda0
            public final Object apply(Object obj) {
                return this.f$0.m389x6c6557ad(i2, str, i, (UserBean) obj);
            }
        }).flatMap(new Function() { // from class: com.collectpoint.net.repo.UploadFileRepo$$ExternalSyntheticLambda3
            public final Object apply(Object obj) {
                return UploadFileRepo.lambda$rxUploadSingleFile$3((BaseResponse) obj);
            }
        }).subscribeOn(Schedulers.io());
    }

    private Single<BaseResponse<UploadRes>> rxUploadSingleImg(final String str, final int i, final String str2) {
        return getRxCachedUser().observeOn(Schedulers.io()).flatMap(new Function() { // from class: com.collectpoint.net.repo.UploadFileRepo$$ExternalSyntheticLambda1
            public final Object apply(Object obj) {
                return this.f$0.m390xd99650a0(str, i, str2, (UserBean) obj);
            }
        }).flatMap(new Function() { // from class: com.collectpoint.net.repo.UploadFileRepo$$ExternalSyntheticLambda4
            public final Object apply(Object obj) {
                return UploadFileRepo.lambda$rxUploadSingleImg$1((BaseResponse) obj);
            }
        }).subscribeOn(Schedulers.io());
    }

    private Single<BaseResponse<UploadWxRes>> rxUploadSingleWxImg(final String str, final int i, final String str2) {
        return getRxCachedUser().observeOn(Schedulers.io()).flatMap(new Function() { // from class: com.collectpoint.net.repo.UploadFileRepo$$ExternalSyntheticLambda2
            public final Object apply(Object obj) {
                return this.f$0.m391x710b235d(str, i, str2, (UserBean) obj);
            }
        }).flatMap(new Function() { // from class: com.collectpoint.net.repo.UploadFileRepo$$ExternalSyntheticLambda5
            public final Object apply(Object obj) {
                return UploadFileRepo.lambda$rxUploadSingleWxImg$5((BaseResponse) obj);
            }
        }).subscribeOn(Schedulers.io());
    }

    /* renamed from: lambda$getRxCachedUser$6$com-collectpoint-net-repo-UploadFileRepo, reason: not valid java name */
    /* synthetic */ UserBean m388x8a95c45() throws Exception {
        return (UserBean) this.mDoubleCacheUtils.getParcelable(Constants.KEY_PARCELABLE_LOGGED_IN_USER, UserBean.CREATOR);
    }

    /* renamed from: lambda$rxUploadSingleFile$2$com-collectpoint-net-repo-UploadFileRepo, reason: not valid java name */
    /* synthetic */ SingleSource m389x6c6557ad(int i, String str, int i2, UserBean userBean) throws Exception {
        userBean.getFileUploadUrl();
        MultipartBody.Builder builderFilesToMultipartBodyBuilder = filesToMultipartBodyBuilder("file", MediaType.parse(i == 1 ? "image/*" : i == 2 ? "video/*" : "audio/*"), str);
        String str2 = null;
        switch (i2) {
            case 1:
                str2 = "snowpaApp";
                break;
        }
        addTextPart(builderFilesToMultipartBodyBuilder, "folder", str2);
        return this.mApi.uploadFile(this.upUrl, builderFilesToMultipartBodyBuilder.build());
    }

    /* renamed from: lambda$rxUploadSingleImg$0$com-collectpoint-net-repo-UploadFileRepo, reason: not valid java name */
    /* synthetic */ SingleSource m390xd99650a0(String str, int i, String str2, UserBean userBean) throws Exception {
        userBean.getFileUploadUrl();
        MultipartBody.Builder builderFilesToMultipartBodyBuilder = filesToMultipartBodyBuilder("file", MediaType.parse("image/*"), str);
        String str3 = null;
        switch (i) {
            case 1:
                str3 = "snowpa/collect";
                break;
        }
        addTextPart(builderFilesToMultipartBodyBuilder, "folder", str3);
        addTextPart(builderFilesToMultipartBodyBuilder, "timeLimete", str2);
        return this.mApi.uploadFile(this.upUrl, builderFilesToMultipartBodyBuilder.build());
    }

    /* renamed from: lambda$rxUploadSingleWxImg$4$com-collectpoint-net-repo-UploadFileRepo, reason: not valid java name */
    /* synthetic */ SingleSource m391x710b235d(String str, int i, String str2, UserBean userBean) throws Exception {
        MultipartBody.Builder builderFilesToMultipartBodyBuilder = filesToMultipartBodyBuilder("file", MediaType.parse("image/*"), str);
        String str3 = null;
        switch (i) {
            case 1:
                str3 = "snowpa/collect";
                break;
        }
        addTextPart(builderFilesToMultipartBodyBuilder, "folder", str3);
        addTextPart(builderFilesToMultipartBodyBuilder, "timeLimete", str2);
        return this.mApi.uploadWxFile("http://114.55.219.79/wxApi/file/upload?folder=", builderFilesToMultipartBodyBuilder.build());
    }

    public Single<List<BaseResponse<UploadRes>>> rxUploadFile(List<String> list, int i, int i2) {
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayListNewArrayList.add(rxUploadSingleFile(it.next(), i, i2));
        }
        return Single.concat(arrayListNewArrayList).toList();
    }

    public Single<List<BaseResponse<UploadRes>>> rxUploadImgs(List<String> list, int i) {
        return rxUploadImgs(list, i, "");
    }

    public Single<List<BaseResponse<UploadRes>>> rxUploadImgs(List<String> list, int i, String str) {
        if (EmptyUtils.isEmpty(str)) {
            str = "";
        }
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayListNewArrayList.add(rxUploadSingleImg(it.next(), i, str));
        }
        return Single.concat(arrayListNewArrayList).toList();
    }

    public Single<List<BaseResponse<UploadWxRes>>> rxUploadWxImgs(List<String> list, int i, String str) {
        if (EmptyUtils.isEmpty(str)) {
            str = "";
        }
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayListNewArrayList.add(rxUploadSingleWxImg(it.next(), i, str));
        }
        return Single.concat(arrayListNewArrayList).toList();
    }
}
