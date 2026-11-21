package com.collectpoint.widget.recycler;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes13.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private boolean includeEdge;
    private int spacing;
    private int spanCount;

    public GridSpacingItemDecoration(int i, int i2, boolean z) {
        this.spanCount = i;
        this.spacing = i2;
        this.includeEdge = z;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.spanCount;
        int i2 = childAdapterPosition % i;
        if (!this.includeEdge) {
            rect.left = (this.spacing * i2) / i;
            int i3 = this.spacing;
            rect.right = i3 - (((i2 + 1) * i3) / this.spanCount);
            rect.bottom = this.spacing;
            return;
        }
        int i4 = this.spacing;
        rect.left = i4 - ((i2 * i4) / i);
        rect.right = ((i2 + 1) * this.spacing) / this.spanCount;
        if (childAdapterPosition < this.spanCount) {
            rect.top = this.spacing;
        }
        rect.bottom = this.spacing;
    }
}
