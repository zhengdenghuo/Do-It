package com.collectpoint.moudle.product;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.InjectParam;
import com.chenenyu.router.annotation.Route;
import com.collectpoint.moudle.BaseMyActivity;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.StatusBarUtil;
import com.google.common.base.Preconditions;

@Route({"SwitchTableAct"})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class SwitchTableAct extends BaseMyActivity {

    @InjectParam(key = "page")
    boolean isMerge;

    @InjectParam(key = "KEY_ROLE_CODE")
    String order_id;

    @InjectParam(key = "name")
    String tableName;

    @InjectParam(key = "code")
    String table_id;

    public static PatrolVm getViewModel(FragmentActivity activity) {
        Preconditions.checkNotNull(activity);
        PatrolVmFactory factory = PatrolVmFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(PatrolVm.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2131492894);
        Router.injectParams(this);
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
        if (savedInstanceState == null) {
            showFragment(SwitchTableFrag.newInstance(this.table_id, this.order_id, this.tableName, this.isMerge), 2131296520);
        }
    }
}
