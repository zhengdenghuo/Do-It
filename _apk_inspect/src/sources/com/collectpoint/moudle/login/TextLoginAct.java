package com.collectpoint.moudle.login;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.Route;
import com.collectpoint.constants.Constants;
import com.collectpoint.moudle.BaseMyActivity;
import com.collectpoint.net.factory.MainVmFactory;
import com.collectpoint.net.vm.LoginVm;
import com.collectpoint.utils.StatusBarUtil;
import com.google.common.base.Preconditions;

@Route({Constants.TEXT_LOGIN_ACT})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes15.dex */
public class TextLoginAct extends BaseMyActivity {
    public static LoginVm getViewModel(FragmentActivity fragmentActivity) {
        Preconditions.checkNotNull(fragmentActivity);
        return ViewModelProviders.of(fragmentActivity, MainVmFactory.getInstance(fragmentActivity.getApplication())).get(LoginVm.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492894);
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
        StatusBarUtil.setTranslucentStatus(this);
        if (bundle == null) {
            showFragment((Fragment) Router.build(Constants.TEXT_LOGIN_FRAG).getFragment(this), 2131296520);
        }
    }
}
