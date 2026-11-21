package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderSettleAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        OrderSettleAct target = (OrderSettleAct) obj;
        Bundle extras = target.getIntent().getExtras();
        target.table_id = extras.getString("code", target.table_id);
        target.shop_supplier_id = extras.getString("KEY_ROLE_CODE", target.shop_supplier_id);
        target.table_name = extras.getString("name", target.table_name);
        target.user_id = extras.getString("id", target.user_id);
        target.order_id = extras.getString("villageCode", target.order_id);
    }
}
