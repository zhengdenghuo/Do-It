package com.collectpoint.moudle.login;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.blankj.utilcode.util.ToastUtils;
import com.chenenyu.router.Router;
import com.collectpoint.constants.Constants;
import com.collectpoint.moudle.BaseMyActivity;
import com.collectpoint.net.factory.MainVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.LoginVm;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.SharedPreManager;
import com.google.common.base.Preconditions;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes15.dex */
public class SplashActivity extends BaseMyActivity implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private LoginVm mViewModel;

    private void getResult() {
        this.mViewModel.pLoginResponse.observe(this, new Observer() { // from class: com.collectpoint.moudle.login.SplashActivity$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m167lambda$getResult$0$comcollectpointmoudleloginSplashActivity((Resource) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$getResult$0$com-collectpoint-moudle-login-SplashActivity, reason: not valid java name */
    /* synthetic */ void m167lambda$getResult$0$comcollectpointmoudleloginSplashActivity(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                ToastUtils.showShort((CharSequence) resource.data);
                SharedPreManager.getShared().setDay();
                Router.build(Constants.MAIN).go(this.mContext);
                finish();
                break;
            case 2:
                Router.build(Constants.LOGIN).go(this);
                finish();
                break;
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mViewModel = ViewModelProviders.of(this, MainVmFactory.getInstance(getApplication())).get(LoginVm.class);
        getResult();
        String string = CacheUtils.getInstance().getCacheDoubleUtils().getString(Constants.KEY_PRE_ACCOUNT);
        String string2 = CacheUtils.getInstance().getCacheDoubleUtils().getString(Constants.KEY_PRE_PWD);
        if (EmptyUtils.isNotEmpty(string) && EmptyUtils.isNotEmpty(string2)) {
            this.mViewModel.onLoginBtnClick(string, string2);
        } else {
            Router.build(Constants.LOGIN).go(this);
            finish();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
    }
}
