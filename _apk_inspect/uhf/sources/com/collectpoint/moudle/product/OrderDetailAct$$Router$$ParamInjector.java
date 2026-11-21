package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderDetailAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        OrderDetailAct target = (OrderDetailAct) obj;
        Bundle extras = target.getIntent().getExtras();
        target.table_id = extras.getString("code", target.table_id);
        target.table_name = extras.getString("name", target.table_name);
    }
}
