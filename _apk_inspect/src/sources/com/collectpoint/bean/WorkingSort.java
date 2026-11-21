package com.collectpoint.bean;

import com.google.common.base.Objects;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class WorkingSort {
    public int color;
    public String more;
    public String name;

    public WorkingSort(String str) {
        this.color = 0;
        this.name = str;
    }

    public WorkingSort(String str, int i) {
        this.color = 0;
        this.name = str;
        this.color = i;
    }

    public WorkingSort(String str, int i, String str2) {
        this.color = 0;
        this.name = str;
        this.color = i;
        this.more = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equal(this.name, ((WorkingSort) obj).name);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.name});
    }
}
