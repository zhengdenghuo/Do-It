package com.collectpoint.moudle.mine.about;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.chenenyu.router.annotation.Route;
import com.collectpoint.constants.Constants;
import com.collectpoint.moudle.BaseMyActivity;
import com.collectpoint.net.factory.MainVmFactory;
import com.collectpoint.net.vm.MineVm;
import com.google.common.base.Preconditions;

@Route({Constants.ABOUT_ACT})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class AboutAct extends BaseMyActivity {
    public static MineVm getViewModel(FragmentActivity fragmentActivity) {
        Preconditions.checkNotNull(fragmentActivity);
        return ViewModelProviders.of(fragmentActivity, MainVmFactory.getInstance(fragmentActivity.getApplication())).get(MineVm.class);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492894);
        if (bundle == null) {
            showFragment(AboutFrag.newInstance(), 2131296520);
        }
    }
}
