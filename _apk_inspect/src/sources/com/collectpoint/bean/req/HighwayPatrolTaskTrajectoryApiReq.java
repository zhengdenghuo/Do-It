package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class HighwayPatrolTaskTrajectoryApiReq {
    private float accuracy;
    private String address;
    private long collectionTime;
    private double latitude;
    private double longitude;

    public HighwayPatrolTaskTrajectoryApiReq(double d, double d2, long j, String str, float f) {
        this.latitude = d;
        this.longitude = d2;
        this.collectionTime = j;
        this.address = str;
        this.accuracy = f;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public long getCollectionTime() {
        return this.collectionTime;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }
}
