package com.collectpoint.moudle.product;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.InjectParam;
import com.chenenyu.router.annotation.Route;
import com.collectpoint.constants.Constants;
import com.collectpoint.moudle.BaseMyActivity;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.StatusBarUtil;
import com.google.common.base.Preconditions;

@Route({Constants.SWITCHTABLE_ACT})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class SwitchTableAct extends BaseMyActivity {

    @InjectParam(key = Constants.KEY_PAGE)
    boolean isMerge;

    @InjectParam(key = Constants.KEY_ROLE_CODE)
    String order_id;

    @InjectParam(key = "name")
    String tableName;

    @InjectParam(key = Constants.KEY_CODE)
    String table_id;

    public static PatrolVm getViewModel(FragmentActivity fragmentActivity) {
        Preconditions.checkNotNull(fragmentActivity);
        return ViewModelProviders.of(fragmentActivity, PatrolVmFactory.getInstance(fragmentActivity.getApplication())).get(PatrolVm.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492894);
        Router.injectParams(this);
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
        if (bundle == null) {
            showFragment(SwitchTableFrag.newInstance(this.table_id, this.order_id, this.tableName, this.isMerge), 2131296520);
        }
    }
}
