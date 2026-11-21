package com.collectpoint.bean.even;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class InstructionsEvent {
    private String orgCode;
    private String type;
    private String typeCode;

    public InstructionsEvent(String str, String str2, String str3) {
        this.orgCode = str;
        this.typeCode = str2;
        this.type = str3;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public String getType() {
        return this.type;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public void setOrgCode(String str) {
        this.orgCode = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }
}
