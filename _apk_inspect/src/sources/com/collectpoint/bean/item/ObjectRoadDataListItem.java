package com.collectpoint.bean.item;

import java.io.Serializable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class ObjectRoadDataListItem implements Serializable {
    private int dataSort;
    private String latitude;
    private String longitude;
    private String roadSegmentCode;
    private String status;

    public int getDataSort() {
        return this.dataSort;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getRoadSegmentCode() {
        return this.roadSegmentCode;
    }

    public String getStatus() {
        return this.status;
    }

    public void setDataSort(int i) {
        this.dataSort = i;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setRoadSegmentCode(String str) {
        this.roadSegmentCode = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
