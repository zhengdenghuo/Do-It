package com.collectpoint.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.chenenyu.router.annotation.Route;
import com.collectpoint.constants.Constants;

@Route({Constants.DIALOG_GPS_ACT})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class DialogGpsActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492896);
        ((TextView) findViewById(2131296983)).setText("您当前定位服务已关闭，请确认开启。");
        findViewById(2131297036).setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.widget.DialogGpsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogGpsActivity.this.finish();
            }
        });
    }
}
