package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;
import com.collectpoint.bean.req.OrderInfoReq;
import com.collectpoint.constants.Constants;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class CouponListTgAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        CouponListTgAct couponListTgAct = (CouponListTgAct) obj;
        Bundle extras = couponListTgAct.getIntent().getExtras();
        couponListTgAct.orderInfoReq = (OrderInfoReq) extras.getParcelable(Constants.KEY_ITEM);
        couponListTgAct.order_id = extras.getString(Constants.KEY_CODE, couponListTgAct.order_id);
    }
}
