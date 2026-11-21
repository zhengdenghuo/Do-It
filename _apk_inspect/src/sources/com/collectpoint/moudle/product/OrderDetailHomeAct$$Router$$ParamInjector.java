package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;
import com.collectpoint.bean.req.OrderInfoReq;
import com.collectpoint.constants.Constants;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderDetailHomeAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        OrderDetailHomeAct orderDetailHomeAct = (OrderDetailHomeAct) obj;
        Bundle extras = orderDetailHomeAct.getIntent().getExtras();
        orderDetailHomeAct.orderInfoReq = (OrderInfoReq) extras.getParcelable(Constants.KEY_ITEM);
        orderDetailHomeAct.order_id = extras.getString(Constants.KEY_CODE, orderDetailHomeAct.order_id);
        orderDetailHomeAct.title = extras.getString("name", orderDetailHomeAct.title);
    }
}
