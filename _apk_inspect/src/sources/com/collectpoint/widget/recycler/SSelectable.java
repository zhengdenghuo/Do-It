package com.collectpoint.widget.recycler;

import java.io.Serializable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes13.dex */
public class SSelectable implements Serializable {
    protected boolean selected;

    public SSelectable() {
    }

    public SSelectable(boolean z) {
        this.selected = z;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }
}
