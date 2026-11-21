package com.collectpoint.moudle.login;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.chenenyu.router.annotation.Route;
import com.collectpoint.constants.Constants;
import com.collectpoint.moudle.BaseMyActivity;
import com.collectpoint.net.factory.MainVmFactory;
import com.collectpoint.net.vm.LoginVm;
import com.google.common.base.Preconditions;

@Route({Constants.RESET_PWD_ACT})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes15.dex */
public class ResetPwdAct extends BaseMyActivity {
    public static LoginVm getViewModel(FragmentActivity fragmentActivity) {
        Preconditions.checkNotNull(fragmentActivity);
        return ViewModelProviders.of(fragmentActivity, MainVmFactory.getInstance(fragmentActivity.getApplication())).get(LoginVm.class);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492894);
        if (bundle == null) {
            showFragment(ResetPwdFrag.newInstance(), 2131296520);
        }
    }
}
