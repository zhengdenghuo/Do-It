package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;
import com.collectpoint.bean.req.OrderInfoReq;
import com.collectpoint.constants.Constants;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class CouponListAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        CouponListAct couponListAct = (CouponListAct) obj;
        Bundle extras = couponListAct.getIntent().getExtras();
        couponListAct.orderInfoReq = (OrderInfoReq) extras.getParcelable(Constants.KEY_ITEM);
        couponListAct.isPack = extras.getBoolean(Constants.KEY_REPORT_TYPE, couponListAct.isPack);
        couponListAct.order_id = extras.getString(Constants.KEY_CODE, couponListAct.order_id);
    }
}
