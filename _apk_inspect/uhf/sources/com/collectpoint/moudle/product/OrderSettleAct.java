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
import com.google.common.base.Preconditions;

@Route({"OrderSettleAct"})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderSettleAct extends BaseMyActivity {

    @InjectParam(key = "villageCode")
    String order_id;

    @InjectParam(key = "KEY_ROLE_CODE")
    String shop_supplier_id;

    @InjectParam(key = "code")
    String table_id;

    @InjectParam(key = "name")
    String table_name;

    @InjectParam(key = "id")
    String user_id;

    public static PatrolVm getViewModel(FragmentActivity activity) {
        Preconditions.checkNotNull(activity);
        PatrolVmFactory factory = PatrolVmFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(PatrolVm.class);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2131492894);
        Router.injectParams(this);
        if (savedInstanceState == null) {
            showFragment(OrderSettleFrag.newInstance(this.table_id, this.shop_supplier_id, this.table_name, this.user_id, this.order_id), 2131296520);
        }
    }
}
