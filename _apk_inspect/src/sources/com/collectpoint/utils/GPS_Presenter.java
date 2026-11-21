package com.collectpoint.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class GPS_Presenter {
    private String MODE_CHANGED_ACTION = "android.location.MODE_CHANGED";
    private String PROVIDERS_CHANGED_ACTION = "android.location.PROVIDERS_CHANGED";
    private Context mContext;
    private GPS_Interface mInterface;
    private Receiver receiver;

    class Receiver extends BroadcastReceiver {
        Receiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, Intent intent) {
            if (EmptyUtils.isNotEmpty(intent.getAction())) {
                if ((intent.getAction().matches(GPS_Presenter.this.MODE_CHANGED_ACTION) || intent.getAction().matches(GPS_Presenter.this.PROVIDERS_CHANGED_ACTION)) && GPS_Presenter.this.mInterface != null) {
                    SDHandlerManager.getMainHandler().postDelayed(new Runnable() { // from class: com.collectpoint.utils.GPS_Presenter.Receiver.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GPS_Presenter.this.mInterface.gpsSwitchState(GPS_Presenter.this.gpsIsOpen(context));
                        }
                    }, 1500L);
                }
            }
        }
    }

    public GPS_Presenter(Context context, GPS_Interface gPS_Interface) {
        this.mContext = context;
        this.mInterface = gPS_Interface;
        observeWifiSwitch();
    }

    private void observeWifiSwitch() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(this.MODE_CHANGED_ACTION);
        intentFilter.addAction(this.PROVIDERS_CHANGED_ACTION);
        Receiver receiver = new Receiver();
        this.receiver = receiver;
        this.mContext.registerReceiver(receiver, intentFilter);
    }

    public boolean gpsIsOpen(Context context) {
        return ((LocationManager) context.getApplicationContext().getSystemService("location")).isProviderEnabled("gps");
    }

    public void onDestroy() {
        Receiver receiver = this.receiver;
        if (receiver != null) {
            this.mContext.unregisterReceiver(receiver);
        }
        if (this.mContext != null) {
            this.mContext = null;
        }
    }
}
