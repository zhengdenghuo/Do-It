package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class HallCartListAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        HallCartListAct target = (HallCartListAct) obj;
        Bundle extras = target.getIntent().getExtras();
        target.table_id = extras.getString("code", target.table_id);
        target.order_id = extras.getString("KEY_ROLE_CODE", target.order_id);
        target.tableName = extras.getString("name", target.tableName);
        target.isGift = extras.getBoolean("typeCode", target.isGift);
    }
}
