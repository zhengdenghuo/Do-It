package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class CouponListAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        CouponListAct target = (CouponListAct) obj;
        Bundle extras = target.getIntent().getExtras();
        target.orderInfoReq = extras.getParcelable("item");
        target.isPack = extras.getBoolean("reportType", target.isPack);
        target.order_id = extras.getString("code", target.order_id);
    }
}
