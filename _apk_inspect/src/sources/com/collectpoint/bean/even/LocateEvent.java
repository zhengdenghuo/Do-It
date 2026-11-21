package com.collectpoint.bean.even;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class LocateEvent {
    private double latitude;
    private double longitude;

    public LocateEvent(double d, double d2) {
        this.longitude = d2;
        this.latitude = d;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }
}
