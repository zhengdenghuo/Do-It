package com.collectpoint.bean.item;

import com.contrarywind.interfaces.IPickerViewData;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class ExamineQuarterListItem implements IPickerViewData {
    private String endTime;
    private String quarterCode;
    private String quarterName;
    private String startTime;

    public String getEndTime() {
        return this.endTime;
    }

    public String getPickerViewText() {
        return this.quarterName;
    }

    public String getQuarterCode() {
        return this.quarterCode;
    }

    public String getQuarterName() {
        return this.quarterName;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setQuarterCode(String str) {
        this.quarterCode = str;
    }

    public void setQuarterName(String str) {
        this.quarterName = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }
}
