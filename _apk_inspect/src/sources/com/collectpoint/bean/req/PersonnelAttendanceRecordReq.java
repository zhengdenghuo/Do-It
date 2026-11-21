package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PersonnelAttendanceRecordReq {
    private String month;
    private String userCode;

    public PersonnelAttendanceRecordReq(String str, String str2) {
        this.userCode = str;
        this.month = str2;
    }

    public String getMonth() {
        return this.month;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setMonth(String str) {
        this.month = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
