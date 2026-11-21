package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;
import com.collectpoint.constants.Constants;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class HallCartListAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        HallCartListAct hallCartListAct = (HallCartListAct) obj;
        Bundle extras = hallCartListAct.getIntent().getExtras();
        hallCartListAct.table_id = extras.getString(Constants.KEY_CODE, hallCartListAct.table_id);
        hallCartListAct.order_id = extras.getString(Constants.KEY_ROLE_CODE, hallCartListAct.order_id);
        hallCartListAct.tableName = extras.getString("name", hallCartListAct.tableName);
        hallCartListAct.isGift = extras.getBoolean(Constants.TYPE_CODE, hallCartListAct.isGift);
    }
}
