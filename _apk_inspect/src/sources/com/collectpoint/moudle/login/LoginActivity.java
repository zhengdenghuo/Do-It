package com.collectpoint.moudle.login;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.blankj.utilcode.util.ToastUtils;
import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.Route;
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.ActLoginBinding;
import com.collectpoint.moudle.BaseMyActivity;
import com.collectpoint.net.factory.MainVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.LoginVm;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.SharedPreManager;
import com.collectpoint.utils.StatusBarUtil;
import com.google.common.base.Preconditions;
import com.liuwq.base.MyActivityManager;
import com.liuwq.base.util.SystemUtil;
import com.liuwq.base.widget.CustomDialogFragCompat;

@Route({Constants.LOGIN})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes15.dex */
public class LoginActivity extends BaseMyActivity implements View.OnClickListener {
    private ActLoginBinding mBinding;
    private LoginVm mViewModel;

    private void getResult() {
        this.mViewModel.pLoginResponse.observe(this, new Observer() { // from class: com.collectpoint.moudle.login.LoginActivity$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m163lambda$getResult$0$comcollectpointmoudleloginLoginActivity((Resource) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setOnClickListener() {
        this.mBinding.viewBar.getLayoutParams().height = SystemUtil.getStatusBarHeight(this);
        this.mBinding.btnLogin.setOnClickListener(this);
        this.mBinding.tvTextLogin.setOnClickListener(this);
        this.mBinding.tvForgetPwd.setOnClickListener(this);
        String string = CacheUtils.getInstance().getCacheDoubleUtils().getString(Constants.KEY_PRE_ACCOUNT);
        String string2 = CacheUtils.getInstance().getCacheDoubleUtils().getString(Constants.KEY_PRE_PWD);
        if (EmptyUtils.isNotEmpty(string)) {
            this.mBinding.etUserIdentity.setText(string);
        }
        if (EmptyUtils.isNotEmpty(string2)) {
            this.mBinding.etUserPwd.setText(string2);
        }
    }

    /* renamed from: lambda$getResult$0$com-collectpoint-moudle-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m163lambda$getResult$0$comcollectpointmoudleloginLoginActivity(Resource resource) {
        Preconditions.checkNotNull(resource);
        CustomDialogFragCompat customDialogFragCompatFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(Constants.TAG_LOADING_DIALOG);
        if (customDialogFragCompatFindFragmentByTag == null) {
            customDialogFragCompatFindFragmentByTag = CustomDialogFragCompat.newTransparentLoadingDialog((String) null);
        }
        switch (resource.status) {
            case 0:
                if (!customDialogFragCompatFindFragmentByTag.isAdded()) {
                    customDialogFragCompatFindFragmentByTag.show(getSupportFragmentManager(), Constants.TAG_LOADING_DIALOG);
                    break;
                }
                break;
            case 1:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showShort((CharSequence) resource.data);
                SharedPreManager.getShared().setDay();
                MyActivityManager.destroyAllActivity();
                Router.build(Constants.MAIN).go(this.mContext);
                finish();
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showShort(resource.message);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296376:
                this.mViewModel.onLoginBtnClick(this.mBinding.etUserIdentity.getText().toString(), this.mBinding.etUserPwd.getText().toString());
                break;
            case 2131297013:
                Router.build(Constants.RESET_PWD_ACT).go(this);
                break;
            case 2131297131:
                Router.build(Constants.TEXT_LOGIN_ACT).go(this);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mBinding = (ActLoginBinding) DataBindingUtil.setContentView(this, 2131492892);
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
        StatusBarUtil.setTranslucentStatus(this);
        getWindow().setFlags(8192, 8192);
        this.mViewModel = ViewModelProviders.of(this, MainVmFactory.getInstance(getApplication())).get(LoginVm.class);
        com.jaeger.library.StatusBarUtil.setLightMode(this);
        setOnClickListener();
        getResult();
        this.mBinding.tvVersion.setText("version:1.0.3.9");
    }
}
