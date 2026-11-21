package com.collectpoint.bean.req;

import com.collectpoint.bean.PersonnelItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class DecomposeSubReq {
    private String assignType;
    private String manageUnitCode;
    private String manageUnitName;
    private String opinion;
    private List<PersonnelItem> personnelList;
    private String problemCode;
    private String userCode;
    private String userName;

    public DecomposeSubReq(String str, String str2, String str3, String str4, String str5, String str6, String str7, List<PersonnelItem> list) {
        this.userCode = str;
        this.userName = str2;
        this.opinion = str6;
        this.problemCode = str7;
        this.manageUnitCode = str3;
        this.manageUnitName = str4;
        this.assignType = str5;
        this.personnelList = list;
    }
}
