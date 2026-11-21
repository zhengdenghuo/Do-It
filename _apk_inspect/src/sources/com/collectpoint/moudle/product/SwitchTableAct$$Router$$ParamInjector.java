package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;
import com.collectpoint.constants.Constants;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class SwitchTableAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        SwitchTableAct switchTableAct = (SwitchTableAct) obj;
        Bundle extras = switchTableAct.getIntent().getExtras();
        switchTableAct.table_id = extras.getString(Constants.KEY_CODE, switchTableAct.table_id);
        switchTableAct.tableName = extras.getString("name", switchTableAct.tableName);
        switchTableAct.order_id = extras.getString(Constants.KEY_ROLE_CODE, switchTableAct.order_id);
        switchTableAct.isMerge = extras.getBoolean(Constants.KEY_PAGE, switchTableAct.isMerge);
    }
}
