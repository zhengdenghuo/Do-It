package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class ClosePatrolEventReq {
    private String auditRemark;
    private String auditType;
    private String closeExplain;
    private String id;

    public ClosePatrolEventReq(String str) {
        this.id = str;
    }

    public ClosePatrolEventReq(String str, String str2) {
        this.id = str;
        this.closeExplain = str2;
    }

    public ClosePatrolEventReq(String str, String str2, String str3) {
        this.id = str;
        this.auditRemark = str2;
        this.auditType = str3;
    }
}
