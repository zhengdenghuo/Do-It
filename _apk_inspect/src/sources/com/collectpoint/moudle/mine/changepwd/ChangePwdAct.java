package com.collectpoint.moudle.mine.changepwd;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.chenenyu.router.annotation.Route;
import com.collectpoint.constants.Constants;
import com.collectpoint.moudle.BaseMyActivity;
import com.collectpoint.net.factory.MainVmFactory;
import com.collectpoint.net.vm.MineVm;
import com.google.common.base.Preconditions;

@Route({Constants.CHANGE_PWD_ACT})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class ChangePwdAct extends BaseMyActivity {
    public static MineVm getViewModel(FragmentActivity fragmentActivity) {
        Preconditions.checkNotNull(fragmentActivity);
        return ViewModelProviders.of(fragmentActivity, MainVmFactory.getInstance(fragmentActivity.getApplication())).get(MineVm.class);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492894);
        if (bundle == null) {
            showFragment(ChangePwdFrag.newInstance(), 2131296520);
        }
    }
}
