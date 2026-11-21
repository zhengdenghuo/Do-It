package com.collectpoint.utils;

import android.app.Activity;
import android.view.WindowManager;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class AlphaUtils {
    public static void backgroundAlpha(Activity activity, float f) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.alpha = f;
        activity.getWindow().addFlags(2);
        activity.getWindow().setAttributes(attributes);
    }
}
