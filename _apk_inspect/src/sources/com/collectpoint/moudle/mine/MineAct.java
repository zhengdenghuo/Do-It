package com.collectpoint.moudle.mine;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.chenenyu.router.annotation.Route;
import com.collectpoint.constants.Constants;
import com.collectpoint.moudle.BaseMyActivity;
import com.collectpoint.net.factory.MainVmFactory;
import com.collectpoint.net.vm.MineVm;
import com.google.common.base.Preconditions;

@Route({Constants.MINE_ACT})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class MineAct extends BaseMyActivity {
    public static MineVm getViewModel(FragmentActivity fragmentActivity) {
        Preconditions.checkNotNull(fragmentActivity);
        return ViewModelProviders.of(fragmentActivity, MainVmFactory.getInstance(fragmentActivity.getApplication())).get(MineVm.class);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492900);
        findViewById(2131296595).setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.mine.MineAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MineAct.this.finish();
            }
        });
        if (bundle == null) {
            showFragment(MineFrag.newInstance(), 2131296520);
        }
    }
}
