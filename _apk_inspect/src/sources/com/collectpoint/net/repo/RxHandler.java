package com.collectpoint.net.repo;

import android.app.Activity;
import android.content.Context;
import com.blankj.utilcode.util.ToastUtils;
import com.chenenyu.router.Router;
import com.collectpoint.bean.UserBean;
import com.collectpoint.bean.res.BaseResponse;
import com.collectpoint.constants.Constants;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.SharedPreManager;
import com.google.common.base.Preconditions;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.functions.Function;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Map;
import retrofit2.HttpException;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class RxHandler {
    private static RxHandler sInstance;
    private long exitTime = 0;
    private Context mContext;

    private RxHandler(Context context) {
        this.mContext = (Context) Preconditions.checkNotNull(context);
    }

    public static Context getCurrentActivity() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(objInvoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        return null;
    }

    public static RxHandler getInstance(Context context) {
        if (sInstance == null) {
            synchronized (RxHandler.class) {
                if (sInstance == null) {
                    sInstance = new RxHandler(context);
                }
            }
        }
        return sInstance;
    }

    static /* synthetic */ Single lambda$SingleRes$4(BaseResponse baseResponse) throws Exception {
        Object object = baseResponse.getObject();
        return !baseResponse.isOk() ? Single.error(new IllegalStateException("" + baseResponse.getResultCode())) : object == null ? Single.error(new IllegalArgumentException("" + baseResponse.getResultCode())) : Single.just(object);
    }

    static /* synthetic */ Observable lambda$handleObservableRes$0(BaseResponse baseResponse) throws Exception {
        if (!baseResponse.isOk()) {
            return Observable.error(new IllegalStateException(baseResponse.getMsg()));
        }
        Object object = baseResponse.getObject();
        return object == null ? Observable.empty() : Observable.just(object);
    }

    static /* synthetic */ Single lambda$handleSingleRes$2(BaseResponse baseResponse) throws Exception {
        if (!baseResponse.isOk()) {
            return Single.error(new IllegalStateException(baseResponse.getMsg()));
        }
        Object object = baseResponse.getObject();
        return object == null ? Single.error(new IllegalArgumentException(baseResponse.getMsg())) : Single.just(object);
    }

    public <Res extends BaseResponse<Content>, Content> SingleTransformer<Res, Content> SingleRes() {
        return new SingleTransformer() { // from class: com.collectpoint.net.repo.RxHandler$$ExternalSyntheticLambda1
            public final SingleSource apply(Single single) {
                return single.flatMap(new Function() { // from class: com.collectpoint.net.repo.RxHandler$$ExternalSyntheticLambda3
                    public final Object apply(Object obj) {
                        return RxHandler.lambda$SingleRes$4((BaseResponse) obj);
                    }
                });
            }
        };
    }

    public String getSuccessMsg(Object obj) {
        Preconditions.checkNotNull(obj);
        if (obj instanceof UserBean) {
            return this.mContext.getString(2131820809);
        }
        return null;
    }

    public String getThrowableHCMsg(Throwable th, int i) {
        Preconditions.checkNotNull(th);
        String message = th.getMessage();
        if (!(th instanceof HttpException)) {
            return ((th instanceof SocketTimeoutException) || (th instanceof UnknownHostException) || (th instanceof ConnectException)) ? i == 2 ? this.mContext.getString(2131820931) : i == 3 ? this.mContext.getString(2131820729) : i == 4 ? this.mContext.getString(2131820893) : i == 5 ? this.mContext.getString(2131820729) : this.mContext.getString(2131820779) : th instanceof FileNotFoundException ? this.mContext.getString(2131820742) : th instanceof IOException ? this.mContext.getString(2131820728) : message;
        }
        switch (((HttpException) th).code()) {
            case 401:
                if (System.currentTimeMillis() - this.exitTime > 2000) {
                    ToastUtils.showLong("登陆已过期");
                    Router.build(Constants.LOGIN).with(Constants.KEY_STATUS, true).go(getCurrentActivity());
                    CacheUtils.getInstance().getCacheDoubleUtils().remove(Constants.KEY_PARCELABLE_LOGGED_IN_USER);
                    SharedPreManager.getShared().setMeetingStaute("N");
                }
                this.exitTime = System.currentTimeMillis();
                return message;
            default:
                return message;
        }
    }

    public String getThrowableMsg(Throwable th) {
        Preconditions.checkNotNull(th);
        String message = th.getMessage();
        if (!(th instanceof HttpException)) {
            return ((th instanceof SocketTimeoutException) || (th instanceof ConnectException)) ? this.mContext.getString(2131820649) : th instanceof FileNotFoundException ? this.mContext.getString(2131820742) : th instanceof IOException ? this.mContext.getString(2131820728) : message;
        }
        switch (((HttpException) th).code()) {
            case 401:
                Router.build(Constants.DIALOG_ACT).go(getCurrentActivity());
                return message;
            default:
                return message;
        }
    }

    public String getThrowableOtherMsg(Throwable th) {
        Preconditions.checkNotNull(th);
        String message = th.getMessage();
        if (!(th instanceof HttpException)) {
            return ((th instanceof SocketTimeoutException) || (th instanceof ConnectException)) ? this.mContext.getString(2131820649) : th instanceof FileNotFoundException ? this.mContext.getString(2131820742) : th instanceof IOException ? this.mContext.getString(2131820728) : th instanceof IllegalStateException ? "code:500-" + message : message;
        }
        switch (((HttpException) th).code()) {
            case 401:
                Router.build(Constants.DIALOG_ACT).go(getCurrentActivity());
                return message;
            default:
                return message;
        }
    }

    public <Res extends BaseResponse<Content>, Content> ObservableTransformer<Res, Content> handleObservableRes() {
        return new ObservableTransformer() { // from class: com.collectpoint.net.repo.RxHandler$$ExternalSyntheticLambda0
            public final ObservableSource apply(Observable observable) {
                return observable.flatMap(new Function() { // from class: com.collectpoint.net.repo.RxHandler$$ExternalSyntheticLambda4
                    public final Object apply(Object obj) {
                        return RxHandler.lambda$handleObservableRes$0((BaseResponse) obj);
                    }
                });
            }
        };
    }

    public <Res extends BaseResponse<Content>, Content> SingleTransformer<Res, Content> handleSingleRes() {
        return new SingleTransformer() { // from class: com.collectpoint.net.repo.RxHandler$$ExternalSyntheticLambda2
            public final SingleSource apply(Single single) {
                return single.flatMap(new Function() { // from class: com.collectpoint.net.repo.RxHandler$$ExternalSyntheticLambda5
                    public final Object apply(Object obj) {
                        return RxHandler.lambda$handleSingleRes$2((BaseResponse) obj);
                    }
                });
            }
        };
    }
}
