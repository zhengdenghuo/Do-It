package com.collectpoint.moudle.product;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.InjectParam;
import com.chenenyu.router.annotation.Route;
import com.collectpoint.bean.req.OrderInfoReq;
import com.collectpoint.constants.Constants;
import com.collectpoint.moudle.BaseMyActivity;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.vm.PatrolVm;
import com.google.common.base.Preconditions;

@Route({Constants.ORDERDETAILLIST_ACT})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderDetailListAct extends BaseMyActivity {

    @InjectParam(key = Constants.KEY_ITEM)
    OrderInfoReq orderInfoReq;

    @InjectParam(key = Constants.KEY_CODE)
    String order_id;

    @InjectParam(key = "name")
    String title;

    public static PatrolVm getViewModel(FragmentActivity fragmentActivity) {
        Preconditions.checkNotNull(fragmentActivity);
        return ViewModelProviders.of(fragmentActivity, PatrolVmFactory.getInstance(fragmentActivity.getApplication())).get(PatrolVm.class);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492894);
        Router.injectParams(this);
        if (bundle == null) {
            showFragment(OrderDetailListFrag.newInstance(this.orderInfoReq, this.order_id, this.title), 2131296520);
        }
    }
}
