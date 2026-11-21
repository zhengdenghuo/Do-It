package com.collectpoint.bean.item;

import com.collectpoint.widget.recycler.SSelectable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class CategoryItem extends SSelectable {
    private String category_id;
    private boolean isflag;
    private String name;

    public CategoryItem(String str, boolean z) {
        this.name = str;
        this.isflag = z;
    }

    public String getCategory_id() {
        return this.category_id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isIsflag() {
        return this.isflag;
    }

    public void setIsflag(boolean z) {
        this.isflag = z;
    }
}
