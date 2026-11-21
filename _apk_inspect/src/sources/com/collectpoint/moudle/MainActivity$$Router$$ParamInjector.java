package com.collectpoint.moudle;

import android.os.Bundle;
import com.chenenyu.router.template.ParamInjector;
import com.collectpoint.constants.Constants;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class MainActivity$$Router$$ParamInjector implements ParamInjector {
    public void inject(Object obj) {
        MainActivity mainActivity = (MainActivity) obj;
        Bundle extras = mainActivity.getIntent().getExtras();
        mainActivity.page = extras.getInt(Constants.KEY_PAGE, mainActivity.page);
        mainActivity.ismeeting = extras.getBoolean("meeting", mainActivity.ismeeting);
    }
}
