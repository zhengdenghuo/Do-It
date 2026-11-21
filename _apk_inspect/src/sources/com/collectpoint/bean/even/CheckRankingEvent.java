package com.collectpoint.bean.even;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class CheckRankingEvent {
    private int Msg = -89757;
    private String examineDate;
    private String examineTypeCode;
    private String projectOrgCode;

    public CheckRankingEvent(String str, String str2, String str3) {
        this.projectOrgCode = str;
        this.examineTypeCode = str2;
        this.examineDate = str3;
    }

    public String getExamineDate() {
        return this.examineDate;
    }

    public String getExamineTypeCode() {
        return this.examineTypeCode;
    }

    public int getMsg() {
        return this.Msg;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public void setExamineDate(String str) {
        this.examineDate = str;
    }

    public void setExamineTypeCode(String str) {
        this.examineTypeCode = str;
    }

    public void setMsg(int i) {
        this.Msg = i;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }
}
