package com.collectpoint.bean;

import com.google.common.base.Objects;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class EncryptionBean {
    private String data;

    public EncryptionBean(String str) {
        this.data = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equal(this.data, ((EncryptionBean) obj).data);
    }

    public String getData() {
        return this.data;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.data});
    }

    public EncryptionBean setData(String str) {
        this.data = str;
        return this;
    }

    public String toString() {
        return "EncryptionBean{data='" + this.data + "'}";
    }
}
