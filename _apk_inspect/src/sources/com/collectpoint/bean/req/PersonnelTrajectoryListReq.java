package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PersonnelTrajectoryListReq {
    private String endTime;
    private String startTime;
    private String userCode;

    public PersonnelTrajectoryListReq(String str, String str2, String str3) {
        this.userCode = str;
        this.startTime = str2;
        this.endTime = str3;
    }
}
