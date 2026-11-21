package com.collectpoint.bean;

import com.collectpoint.bean.item.ContactsItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class DispatchGroupItem {
    private String createCode;
    private String createName;
    private String groupCode;
    private String groupDesc;
    private String groupName;
    private List<ContactsItem> memberList;
    private String memberNumber;
    private String projectOrgCode;
    private String projectOrgName;
    private String userCode;
    private String userName;
    private String userType;

    public DispatchGroupItem(String str, String str2, String str3, String str4) {
        this.groupCode = str;
        this.userCode = str2;
        this.userName = str3;
        this.userType = str4;
    }

    public DispatchGroupItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, List<ContactsItem> list) {
        this.groupName = str4;
        this.groupDesc = str5;
        this.projectOrgCode = str6;
        this.projectOrgName = str7;
        this.userCode = str;
        this.userName = str2;
        this.userType = str3;
        this.memberList = list;
    }

    public DispatchGroupItem(String str, String str2, String str3, String str4, String str5, String str6, List<ContactsItem> list) {
        this.groupCode = str4;
        this.groupName = str5;
        this.groupDesc = str6;
        this.userCode = str;
        this.userName = str2;
        this.userType = str3;
        this.memberList = list;
    }

    public String getCreateCode() {
        return this.createCode;
    }

    public String getCreateName() {
        return this.createName;
    }

    public String getGroupCode() {
        return this.groupCode;
    }

    public String getGroupDesc() {
        return this.groupDesc;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public List<ContactsItem> getMemberList() {
        return this.memberList;
    }

    public String getMemberNumber() {
        return this.memberNumber;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getProjectOrgName() {
        return this.projectOrgName;
    }

    public void setMemberList(List<ContactsItem> list) {
        this.memberList = list;
    }
}
