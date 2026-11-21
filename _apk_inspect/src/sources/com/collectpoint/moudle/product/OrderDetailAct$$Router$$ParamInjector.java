package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;
import com.collectpoint.constants.Constants;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderDetailAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        OrderDetailAct orderDetailAct = (OrderDetailAct) obj;
        Bundle extras = orderDetailAct.getIntent().getExtras();
        orderDetailAct.table_id = extras.getString(Constants.KEY_CODE, orderDetailAct.table_id);
        orderDetailAct.table_name = extras.getString("name", orderDetailAct.table_name);
    }
}
