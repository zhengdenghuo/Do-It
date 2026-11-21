package com.collectpoint.net.remote;

import com.google.common.base.Objects;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes10.dex */
public class Resource<T> {
    public final T data;
    public final String message;
    public final int status;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
        public static final int ERROR = 2;
        public static final int LOADING = 0;
        public static final int SUCCESS = 1;
    }

    public Resource(int i, T t, String str) {
        this.status = i;
        this.data = t;
        this.message = str;
    }

    public static <T> Resource<T> error(String str) {
        return error(str, null);
    }

    public static <T> Resource<T> error(String str, T t) {
        return new Resource<>(2, t, str);
    }

    public static <T> Resource<T> loading() {
        return loading(null);
    }

    public static <T> Resource<T> loading(T t) {
        return new Resource<>(0, t, null);
    }

    public static <T> Resource<T> success(T t) {
        return new Resource<>(1, t, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Resource resource = (Resource) obj;
        return this.status == resource.status && Objects.equal(this.message, resource.message) && Objects.equal(this.data, resource.data);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.status), this.message, this.data});
    }

    public String toString() {
        return "Resource{status=" + this.status + ", message='" + this.message + "', data=" + this.data + '}';
    }
}
