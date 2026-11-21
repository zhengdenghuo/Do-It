package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;
import com.collectpoint.constants.Constants;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class ScanPlateAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        ScanPlateAct scanPlateAct = (ScanPlateAct) obj;
        Bundle extras = scanPlateAct.getIntent().getExtras();
        scanPlateAct.table_id = extras.getString(Constants.KEY_CODE, scanPlateAct.table_id);
        scanPlateAct.table_name = extras.getString("name", scanPlateAct.table_name);
    }
}
