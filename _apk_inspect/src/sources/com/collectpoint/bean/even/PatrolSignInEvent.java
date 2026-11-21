package com.collectpoint.bean.even;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class PatrolSignInEvent {
    private String address;
    private double latitude;
    private double longitude;

    public PatrolSignInEvent(double d, double d2, String str) {
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        this.longitude = d;
        this.latitude = d2;
        this.address = str;
    }

    public String getAddress() {
        return this.address;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }
}
