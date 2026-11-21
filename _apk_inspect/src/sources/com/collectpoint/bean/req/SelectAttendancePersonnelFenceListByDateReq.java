package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class SelectAttendancePersonnelFenceListByDateReq {
    private String dateTime;
    private String userCode;

    public SelectAttendancePersonnelFenceListByDateReq(String str, String str2) {
        this.userCode = str;
        this.dateTime = str2;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setDateTime(String str) {
        this.dateTime = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
