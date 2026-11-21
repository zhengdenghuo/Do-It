package com.collectpoint.bean.req;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class RepairProjectCheckRectificationReq {
    private String auditRemark;
    private String auditStatus;
    private String auditTime;
    private String checkCode;
    private String instructions;
    private String projectCode;
    private List<String> rectificationPhotoList;
    private String submitPersonnelCode;
    private String submitPersonnelName;
    private String submitTimeStr;

    public RepairProjectCheckRectificationReq(String str) {
        this.projectCode = str;
    }

    public RepairProjectCheckRectificationReq(String str, String str2, String str3, String str4, String str5) {
        this.checkCode = str;
        this.projectCode = str2;
        this.submitPersonnelCode = str3;
        this.submitPersonnelName = str4;
        this.instructions = str5;
    }

    public String getAuditRemark() {
        return this.auditRemark;
    }

    public String getAuditStatus() {
        return this.auditStatus;
    }

    public String getAuditTime() {
        return this.auditTime;
    }

    public String getCheckCode() {
        return this.checkCode;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public String getProjectCode() {
        return this.projectCode;
    }

    public List<String> getRectificationPhotoList() {
        return this.rectificationPhotoList;
    }

    public String getSubmitPersonnelCode() {
        return this.submitPersonnelCode;
    }

    public String getSubmitPersonnelName() {
        return this.submitPersonnelName;
    }

    public String getSubmitTime() {
        return this.submitTimeStr;
    }

    public void setAuditTime(String str) {
        this.auditTime = str;
    }

    public void setRectificationPhotoList(List<String> list) {
        this.rectificationPhotoList = list;
    }
}
