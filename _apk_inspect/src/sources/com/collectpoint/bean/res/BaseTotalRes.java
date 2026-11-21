package com.collectpoint.bean.res;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class BaseTotalRes<T> {
    private int current_page;
    private T data;
    private int last_page;
    private int per_page;
    private int total;

    public int getCurrent_page() {
        return this.current_page;
    }

    public T getData() {
        return this.data;
    }

    public int getLast_page() {
        return this.last_page;
    }

    public int getPer_page() {
        return this.per_page;
    }

    public int getTotal() {
        return this.total;
    }
}
