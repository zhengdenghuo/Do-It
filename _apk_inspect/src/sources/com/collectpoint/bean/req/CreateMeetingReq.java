package com.collectpoint.bean.req;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class CreateMeetingReq {
    private List<Attendees> attendees;
    private String guestPwd;
    private boolean isGuestFreePwd;
    private String mediaTypes;
    private String subject;
    private String userCode;
    private String userName;

    public CreateMeetingReq(String str, String str2) {
        this.userCode = str;
        this.userName = str2;
    }

    public CreateMeetingReq(String str, String str2, String str3, String str4, String str5, boolean z) {
        this.userCode = str;
        this.userName = str2;
        this.subject = str3;
        this.mediaTypes = str4;
        this.guestPwd = str5;
        this.isGuestFreePwd = z;
    }

    public void setAttendees(List<Attendees> list) {
        this.attendees = list;
    }
}
