package com.collectpoint.moudle.product;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.InjectParam;
import com.chenenyu.router.annotation.Route;
import com.collectpoint.bean.req.OrderInfoReq;
import com.collectpoint.moudle.BaseMyActivity;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.vm.PatrolVm;
import com.google.common.base.Preconditions;

@Route({"CouponListTgAct"})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class CouponListTgAct extends BaseMyActivity {

    @InjectParam(key = "item")
    OrderInfoReq orderInfoReq;

    @InjectParam(key = "code")
    String order_id;

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
            showFragment(CouponListTgFrag.newInstance(this.orderInfoReq, this.order_id), 2131296520);
        }
    }
}
