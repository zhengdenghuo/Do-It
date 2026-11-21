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

@Route({Constants.COUPONLIST_ACT})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class CouponListAct extends BaseMyActivity {

    @InjectParam(key = Constants.KEY_REPORT_TYPE)
    boolean isPack;

    @InjectParam(key = Constants.KEY_ITEM)
    OrderInfoReq orderInfoReq;

    @InjectParam(key = Constants.KEY_CODE)
    String order_id;

    public static PatrolVm getViewModel(FragmentActivity fragmentActivity) {
        Preconditions.checkNotNull(fragmentActivity);
        return ViewModelProviders.of(fragmentActivity, PatrolVmFactory.getInstance(fragmentActivity.getApplication())).get(PatrolVm.class);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492894);
        Router.injectParams(this);
        if (bundle == null) {
            showFragment(CouponListFrag.newInstance(this.orderInfoReq, this.isPack, this.order_id), 2131296520);
        }
    }
}
