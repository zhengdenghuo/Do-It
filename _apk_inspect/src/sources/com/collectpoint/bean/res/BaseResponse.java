package com.collectpoint.bean.res;

import com.google.common.base.Objects;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class BaseResponse<T> {
    private int code;
    T data;
    private String msg;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseResponse baseResponse = (BaseResponse) obj;
        return this.code == baseResponse.code && Objects.equal(this.msg, baseResponse.msg) && Objects.equal(this.data, baseResponse.data);
    }

    public String getMsg() {
        return this.msg;
    }

    public T getObject() {
        return this.data;
    }

    public int getResultCode() {
        return this.code;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.code), this.msg, this.data});
    }

    public boolean isOk() {
        return this.code == 1;
    }

    public BaseResponse<T> setMsg(String str) {
        this.msg = str;
        return this;
    }

    public BaseResponse<T> setObject(T t) {
        this.data = t;
        return this;
    }

    public BaseResponse<T> setResultCode(int i) {
        this.code = i;
        return this;
    }

    public String toString() {
        return "BaseResponse{code=" + this.code + ", msg='" + this.msg + "', data=" + this.data + '}';
    }
}
