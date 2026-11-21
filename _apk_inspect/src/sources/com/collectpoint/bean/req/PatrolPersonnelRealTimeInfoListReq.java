package com.collectpoint.bean.req;

import com.collectpoint.bean.LongitudeLatitude;
import com.collectpoint.utils.EmptyUtils;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class PatrolPersonnelRealTimeInfoListReq {
    private double latitude;
    private double longitude;
    private String nickName;
    private String onlineStatus;
    private String projectOrgCode;
    private String userCode;

    public PatrolPersonnelRealTimeInfoListReq(String str, String str2, String str3) {
        this.userCode = str;
        this.projectOrgCode = str2;
        this.onlineStatus = str3;
    }

    public PatrolPersonnelRealTimeInfoListReq(String str, String str2, String str3, LongitudeLatitude longitudeLatitude) {
        this.userCode = str;
        this.nickName = str2;
        this.onlineStatus = str3;
        if (EmptyUtils.isNotEmpty(longitudeLatitude)) {
            if (EmptyUtils.isNotEmpty(Double.valueOf(longitudeLatitude.getLongitude()))) {
                this.longitude = longitudeLatitude.getLongitude();
            }
            if (EmptyUtils.isNotEmpty(Double.valueOf(longitudeLatitude.getLatitude()))) {
                this.latitude = longitudeLatitude.getLatitude();
            }
        }
    }

    public String getOnlineStatus() {
        return this.onlineStatus;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setOnlineStatus(String str) {
        this.onlineStatus = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }
}
