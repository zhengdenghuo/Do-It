package com.collectpoint.moudle.product;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;
import com.collectpoint.constants.Constants;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class ProductListAct$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        ProductListAct productListAct = (ProductListAct) obj;
        Bundle extras = productListAct.getIntent().getExtras();
        productListAct.table_id = extras.getString(Constants.KEY_CODE, productListAct.table_id);
        productListAct.order_id = extras.getString(Constants.KEY_ROLE_CODE, productListAct.order_id);
        productListAct.isGift = extras.getBoolean(Constants.TYPE_CODE, productListAct.isGift);
        productListAct.tableName = extras.getString("name", productListAct.tableName);
    }
}
