package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;
import com.collectpoint.bean.req.OrderInfoReq;
import com.collectpoint.constants.Constants;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderDetailListAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        OrderDetailListAct orderDetailListAct = (OrderDetailListAct) obj;
        Bundle extras = orderDetailListAct.getIntent().getExtras();
        orderDetailListAct.orderInfoReq = (OrderInfoReq) extras.getParcelable(Constants.KEY_ITEM);
        orderDetailListAct.order_id = extras.getString(Constants.KEY_CODE, orderDetailListAct.order_id);
        orderDetailListAct.title = extras.getString("name", orderDetailListAct.title);
    }
}
