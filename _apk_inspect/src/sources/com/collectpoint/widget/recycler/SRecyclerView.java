package com.collectpoint.widget.recycler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bumptech.glide.Glide;
import com.collectpoint.MyApp;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes13.dex */
public class SRecyclerView extends RecyclerView {
    private Context context;
    private boolean isScrollPauseLoadPic;
    private boolean isScrolling;

    public SRecyclerView(Context context) {
        super(context);
        this.isScrollPauseLoadPic = true;
        this.context = context;
        init();
    }

    public SRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrollPauseLoadPic = true;
        this.context = context;
        init();
    }

    public SRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrollPauseLoadPic = true;
        this.context = context;
        init();
    }

    private void addOnScrollListener() {
        addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.collectpoint.widget.recycler.SRecyclerView.1
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                try {
                    if (SRecyclerView.this.isScrollPauseLoadPic) {
                        if (i != 1 && i != 2) {
                            if (i == 0) {
                                if (SRecyclerView.this.isScrolling) {
                                    Glide.with(SRecyclerView.this.context).resumeRequests();
                                }
                                SRecyclerView.this.isScrolling = false;
                                return;
                            }
                            return;
                        }
                        SRecyclerView.this.isScrolling = true;
                        Glide.with(SRecyclerView.this.context).pauseRequests();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        });
    }

    private void init() {
        setLinearLayoutManager(1);
    }

    public void addDividerHorizontal(Drawable drawable) {
        MyApp.getInstance();
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(MyApp.getContext(), 0);
        dividerItemDecoration.setDrawable(drawable);
        addItemDecoration(dividerItemDecoration);
    }

    public void addGridSpacingItemDecoration(int i, int i2) {
        addGridSpacingItemDecoration(i, i2, true);
    }

    public void addGridSpacingItemDecoration(int i, int i2, boolean z) {
        addItemDecoration(new GridSpacingItemDecoration(i, i2, z));
    }

    public void addLinearSpacingItemDecoration(int i, int i2) {
        addItemDecoration(new LinearSpacingItemDecoration(i, i2, true));
    }

    public void addLinearSpacingItemDecoration(int i, int i2, boolean z) {
        addItemDecoration(new LinearSpacingItemDecoration(i, i2, z));
    }

    public GridLayoutManager getGridLayoutManager() {
        GridLayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return layoutManager;
        }
        return null;
    }

    public int getItemCount() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    public LinearLayoutManager getLinearLayoutManager() {
        LinearLayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return layoutManager;
        }
        return null;
    }

    public StaggeredGridLayoutManager getStaggeredGridLayoutManager() {
        StaggeredGridLayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return layoutManager;
        }
        return null;
    }

    public boolean isScrollPauseLoadPic() {
        return this.isScrollPauseLoadPic;
    }

    public void removeGridSpacingItemDecoration(int i, int i2) {
        removeGridSpacingItemDecoration(i, i2, true);
    }

    public void removeGridSpacingItemDecoration(int i, int i2, boolean z) {
        removeItemDecoration(new GridSpacingItemDecoration(i, i2, z));
    }

    public void removeLinearSpacingItemDecoration(int i, int i2) {
        removeItemDecoration(new LinearSpacingItemDecoration(i, i2, true));
    }

    public void removeLinearSpacingItemDecoration(int i, int i2, boolean z) {
        removeItemDecoration(new LinearSpacingItemDecoration(i, i2, z));
    }

    public void scrollToEnd() {
        int itemCount = getItemCount();
        if (itemCount > 0) {
            scrollToPosition(itemCount - 1);
        }
    }

    public void scrollToStart() {
        scrollToPosition(0);
    }

    public void setGridLayoutManager(int i, int i2) {
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException("orientation must be RecyclerView.VERTICAL or RecyclerView.HORIZONTAL");
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), i2);
        gridLayoutManager.setOrientation(i);
        setLayoutManager(gridLayoutManager);
    }

    public void setLinearLayoutManager(int i) {
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException("orientation must be RecyclerView.VERTICAL or RecyclerView.HORIZONTAL");
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(i);
        setLayoutManager(linearLayoutManager);
    }

    public void setScrollPauseLoadPic(boolean z) {
        this.isScrollPauseLoadPic = z;
    }

    public void setStaggeredGridLayoutManager(int i, int i2) {
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException("orientation must be RecyclerView.VERTICAL or RecyclerView.HORIZONTAL");
        }
        setLayoutManager(new StaggeredGridLayoutManager(i2, i));
    }
}
