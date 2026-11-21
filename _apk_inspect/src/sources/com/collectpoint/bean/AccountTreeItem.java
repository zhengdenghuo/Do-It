package com.collectpoint.bean;

import com.collectpoint.widget.recycler.SSelectable;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class AccountTreeItem extends SSelectable {
    private String appOnLineStatus;
    private String appOnLineStatusName;
    private List<AccountTreeItem> children;
    private String distance;
    private String id;
    private boolean isOpen;
    private int leave;
    private String nickName;
    private String orgCode;
    private String orgName;
    private String parentId;
    private String phone;
    private String projectOrgCode;
    private String title;
    private String userCode;
    private String webOnLineStatus;
    private String webOnLineStatusName;

    public String getAppOnLineStatus() {
        return this.appOnLineStatus;
    }

    public String getAppOnLineStatusName() {
        return this.appOnLineStatusName;
    }

    public List<AccountTreeItem> getChildren() {
        return this.children;
    }

    public String getDistance() {
        return this.distance;
    }

    public String getId() {
        return this.id;
    }

    public int getLeave() {
        return this.leave;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public String getOrgName() {
        return this.orgName;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getProjectOrgCode() {
        return this.projectOrgCode;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public String getWebOnLineStatus() {
        return this.webOnLineStatus;
    }

    public String getWebOnLineStatusName() {
        return this.webOnLineStatusName;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setAppOnLineStatus(String str) {
        this.appOnLineStatus = str;
    }

    public void setAppOnLineStatusName(String str) {
        this.appOnLineStatusName = str;
    }

    public void setChildren(List<AccountTreeItem> list) {
        this.children = list;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLeave(int i) {
        this.leave = i;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public void setOrgCode(String str) {
        this.orgCode = str;
    }

    public void setOrgName(String str) {
        this.orgName = str;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setProjectOrgCode(String str) {
        this.projectOrgCode = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public void setWebOnLineStatus(String str) {
        this.webOnLineStatus = str;
    }

    public void setWebOnLineStatusName(String str) {
        this.webOnLineStatusName = str;
    }
}
