package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;
import com.collectpoint.constants.Constants;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderSettleAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        OrderSettleAct orderSettleAct = (OrderSettleAct) obj;
        Bundle extras = orderSettleAct.getIntent().getExtras();
        orderSettleAct.table_id = extras.getString(Constants.KEY_CODE, orderSettleAct.table_id);
        orderSettleAct.shop_supplier_id = extras.getString(Constants.KEY_ROLE_CODE, orderSettleAct.shop_supplier_id);
        orderSettleAct.table_name = extras.getString("name", orderSettleAct.table_name);
        orderSettleAct.user_id = extras.getString(Constants.KEY_ID, orderSettleAct.user_id);
        orderSettleAct.order_id = extras.getString(Constants.KEY_VILLAGE_CODE, orderSettleAct.order_id);
    }
}
