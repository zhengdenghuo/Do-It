package com.collectpoint.widget.recycler;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes13.dex */
public class LinearSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private boolean includeEdge;
    private int lrSpacing;
    private int tbSpacing;

    public LinearSpacingItemDecoration(int i, int i2, boolean z) {
        this.tbSpacing = i;
        this.lrSpacing = i2;
        this.includeEdge = z;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager.getOrientation() == 1) {
                rect.left = this.lrSpacing;
                rect.right = this.lrSpacing;
                if (!this.includeEdge) {
                    if (childAdapterPosition != 0) {
                        rect.top = this.tbSpacing;
                        return;
                    }
                    return;
                } else {
                    rect.bottom = this.tbSpacing;
                    if (childAdapterPosition == 0) {
                        rect.top = this.tbSpacing;
                        return;
                    }
                    return;
                }
            }
            if (layoutManager.getOrientation() == 0) {
                rect.top = this.tbSpacing;
                rect.bottom = this.tbSpacing;
                if (!this.includeEdge) {
                    if (childAdapterPosition != 0) {
                        rect.left = this.lrSpacing;
                    }
                } else {
                    rect.right = this.lrSpacing;
                    if (childAdapterPosition == 0) {
                        rect.left = this.lrSpacing;
                    }
                }
            }
        }
    }
}
