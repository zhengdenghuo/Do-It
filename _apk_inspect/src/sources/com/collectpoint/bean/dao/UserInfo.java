package com.collectpoint.bean.dao;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes15.dex */
public class UserInfo {
    Long id;
    private String password;
    private String phone;

    public UserInfo() {
    }

    public UserInfo(Long l, String str, String str2) {
        this.id = l;
        this.phone = str;
        this.password = str2;
    }

    public Long getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }
}
