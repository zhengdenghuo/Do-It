package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderDetailListAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        OrderDetailListAct target = (OrderDetailListAct) obj;
        Bundle extras = target.getIntent().getExtras();
        target.orderInfoReq = extras.getParcelable("item");
        target.order_id = extras.getString("code", target.order_id);
        target.title = extras.getString("name", target.title);
    }
}
