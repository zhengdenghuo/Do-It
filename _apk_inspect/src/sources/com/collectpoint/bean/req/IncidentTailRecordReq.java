package com.collectpoint.bean.req;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class IncidentTailRecordReq {
    private String createCode;
    private String createName;
    private String incidentCode;
    private String recordDetail;
    private List<String> recordPhotos;
    private String recordType;

    public IncidentTailRecordReq(String str, String str2, String str3, String str4, String str5) {
        this.incidentCode = str;
        this.createName = str2;
        this.recordType = str3;
        this.createCode = str4;
        this.recordDetail = str5;
    }

    public void setRecordPhotos(List<String> list) {
        this.recordPhotos = list;
    }
}
