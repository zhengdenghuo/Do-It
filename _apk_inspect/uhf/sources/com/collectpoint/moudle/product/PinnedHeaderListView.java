package com.collectpoint.moudle.product;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class PinnedHeaderListView extends ListView implements AbsListView.OnScrollListener {
    private PinnedSectionedHeaderAdapter mAdapter;
    private View mCurrentHeader;
    private int mCurrentHeaderViewType;
    private int mCurrentSection;
    private float mHeaderOffset;
    private int mHeightMode;
    private AbsListView.OnScrollListener mOnScrollListener;
    private boolean mShouldPin;
    private int mWidthMode;

    public interface PinnedSectionedHeaderAdapter {
        int getCount();

        int getSectionForPosition(int position);

        View getSectionHeaderView(int section, View convertView, ViewGroup parent);

        int getSectionHeaderViewType(int section);

        boolean isSectionHeader(int position);
    }

    public PinnedHeaderListView(Context context) {
        super(context);
        this.mCurrentHeaderViewType = 0;
        this.mShouldPin = true;
        this.mCurrentSection = 0;
        super.setOnScrollListener(this);
    }

    public PinnedHeaderListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCurrentHeaderViewType = 0;
        this.mShouldPin = true;
        this.mCurrentSection = 0;
        super.setOnScrollListener(this);
    }

    public PinnedHeaderListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mCurrentHeaderViewType = 0;
        this.mShouldPin = true;
        this.mCurrentSection = 0;
        super.setOnScrollListener(this);
    }

    public void setPinHeaders(boolean shouldPin) {
        this.mShouldPin = shouldPin;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter adapter) {
        this.mCurrentHeader = null;
        this.mAdapter = (PinnedSectionedHeaderAdapter) adapter;
        super.setAdapter(adapter);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
        PinnedSectionedHeaderAdapter pinnedSectionedHeaderAdapter = this.mAdapter;
        if (pinnedSectionedHeaderAdapter == null || pinnedSectionedHeaderAdapter.getCount() == 0 || !this.mShouldPin || firstVisibleItem < getHeaderViewsCount()) {
            this.mCurrentHeader = null;
            this.mHeaderOffset = 0.0f;
            for (int i = firstVisibleItem; i < firstVisibleItem + visibleItemCount; i++) {
                View header = getChildAt(i);
                if (header != null) {
                    header.setVisibility(0);
                }
            }
            return;
        }
        int firstVisibleItem2 = firstVisibleItem - getHeaderViewsCount();
        int section = this.mAdapter.getSectionForPosition(firstVisibleItem2);
        int viewType = this.mAdapter.getSectionHeaderViewType(section);
        View sectionHeaderView = getSectionHeaderView(section, this.mCurrentHeaderViewType == viewType ? this.mCurrentHeader : null);
        this.mCurrentHeader = sectionHeaderView;
        ensurePinnedHeaderLayout(sectionHeaderView);
        this.mCurrentHeaderViewType = viewType;
        this.mHeaderOffset = 0.0f;
        for (int i2 = firstVisibleItem2; i2 < firstVisibleItem2 + visibleItemCount; i2++) {
            if (this.mAdapter.isSectionHeader(i2)) {
                View header2 = getChildAt(i2 - firstVisibleItem2);
                float headerTop = header2.getTop();
                float pinnedHeaderHeight = this.mCurrentHeader.getMeasuredHeight();
                header2.setVisibility(0);
                if (pinnedHeaderHeight >= headerTop && headerTop > 0.0f) {
                    this.mHeaderOffset = headerTop - header2.getHeight();
                } else if (headerTop <= 0.0f) {
                    header2.setVisibility(4);
                }
            }
        }
        invalidate();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(view, scrollState);
        }
    }

    private View getSectionHeaderView(int section, View oldView) {
        boolean shouldLayout = section != this.mCurrentSection || oldView == null;
        View view = this.mAdapter.getSectionHeaderView(section, oldView, this);
        if (shouldLayout) {
            ensurePinnedHeaderLayout(view);
            this.mCurrentSection = section;
        }
        return view;
    }

    private void ensurePinnedHeaderLayout(View header) {
        int heightSpec;
        if (header.isLayoutRequested()) {
            int widthSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), this.mWidthMode);
            ViewGroup.LayoutParams layoutParams = header.getLayoutParams();
            if (layoutParams != null && layoutParams.height > 0) {
                heightSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                heightSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            header.measure(widthSpec, heightSpec);
            header.layout(0, 0, header.getMeasuredWidth(), header.getMeasuredHeight());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mAdapter == null || !this.mShouldPin || this.mCurrentHeader == null) {
            return;
        }
        int saveCount = canvas.save();
        canvas.translate(0.0f, this.mHeaderOffset);
        canvas.clipRect(0, 0, getWidth(), this.mCurrentHeader.getMeasuredHeight());
        this.mCurrentHeader.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener l) {
        this.mOnScrollListener = l;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mWidthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        this.mHeightMode = View.MeasureSpec.getMode(heightMeasureSpec);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        super.setOnItemClickListener((AdapterView.OnItemClickListener) listener);
    }

    public static abstract class OnItemClickListener implements AdapterView.OnItemClickListener {
        public abstract void onItemClick(AdapterView<?> adapterView, View view, int section, int position, long id);

        public abstract void onSectionClick(AdapterView<?> adapterView, View view, int section, long id);

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int rawPosition, long id) {
            SectionedBaseAdapter adapter;
            boolean isH = false;
            try {
                isH = adapterView.getAdapter().getClass().equals(HeaderViewListAdapter.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (isH) {
                HeaderViewListAdapter wrapperAdapter = (HeaderViewListAdapter) adapterView.getAdapter();
                adapter = (SectionedBaseAdapter) wrapperAdapter.getWrappedAdapter();
            } else {
                adapter = (SectionedBaseAdapter) adapterView.getAdapter();
            }
            int section = adapter.getSectionForPosition(rawPosition);
            int position = adapter.getPositionInSectionForPosition(rawPosition);
            if (position == -1) {
                onSectionClick(adapterView, view, section, id);
            } else {
                onItemClick(adapterView, view, section, position, id);
            }
        }
    }
}
