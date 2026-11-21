package com.collectpoint.bean;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class RoadMapBean {
    private boolean checked = false;
    private String endTime;
    private String id;
    private String name;
    private String startTime;
    private int type;

    public String getEndTime() {
        return this.endTime;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public int getType() {
        return this.type;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public RoadMapBean setId(String str) {
        this.id = str;
        return this;
    }

    public RoadMapBean setName(String str) {
        this.name = str;
        return this;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public RoadMapBean setType(int i) {
        this.type = i;
        return this;
    }
}
