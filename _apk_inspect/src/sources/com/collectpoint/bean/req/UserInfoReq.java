package com.collectpoint.bean.req;

import com.collectpoint.BuildConfig;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class UserInfoReq {
    private String nickName;
    private String password;
    private String projectOrgCode;
    private String systemCode = BuildConfig.SYSTEM_CODE;
    private String userCode;
    private String userImg;
    private String userName;
    private String userPhone;
    private String userRoleCode;
    private String userType;

    public UserInfoReq(String str, String str2, String str3) {
        this.userCode = str;
        this.projectOrgCode = str2;
        this.userRoleCode = str3;
    }
}
