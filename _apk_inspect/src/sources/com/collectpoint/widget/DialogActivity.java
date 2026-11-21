package com.collectpoint.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.Route;
import com.collectpoint.constants.Constants;

@Route({Constants.DIALOG_ACT})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class DialogActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492896);
        findViewById(2131297036).setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.widget.DialogActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogActivity.this.finish();
                Router.build(Constants.LOGIN).go(DialogActivity.this);
            }
        });
    }
}
