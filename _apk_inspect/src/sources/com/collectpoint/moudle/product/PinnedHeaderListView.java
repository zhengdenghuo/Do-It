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

    public static abstract class OnItemClickListener implements AdapterView.OnItemClickListener {
        public abstract void onItemClick(AdapterView<?> adapterView, View view, int i, int i2, long j);

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            boolean zEquals = false;
            try {
                zEquals = adapterView.getAdapter().getClass().equals(HeaderViewListAdapter.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SectionedBaseAdapter sectionedBaseAdapter = zEquals ? (SectionedBaseAdapter) ((HeaderViewListAdapter) adapterView.getAdapter()).getWrappedAdapter() : (SectionedBaseAdapter) adapterView.getAdapter();
            int sectionForPosition = sectionedBaseAdapter.getSectionForPosition(i);
            int positionInSectionForPosition = sectionedBaseAdapter.getPositionInSectionForPosition(i);
            if (positionInSectionForPosition == -1) {
                onSectionClick(adapterView, view, sectionForPosition, j);
            } else {
                onItemClick(adapterView, view, sectionForPosition, positionInSectionForPosition, j);
            }
        }

        public abstract void onSectionClick(AdapterView<?> adapterView, View view, int i, long j);
    }

    public interface PinnedSectionedHeaderAdapter {
        int getCount();

        int getSectionForPosition(int i);

        View getSectionHeaderView(int i, View view, ViewGroup viewGroup);

        int getSectionHeaderViewType(int i);

        boolean isSectionHeader(int i);
    }

    public PinnedHeaderListView(Context context) {
        super(context);
        this.mCurrentHeaderViewType = 0;
        this.mShouldPin = true;
        this.mCurrentSection = 0;
        super.setOnScrollListener(this);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentHeaderViewType = 0;
        this.mShouldPin = true;
        this.mCurrentSection = 0;
        super.setOnScrollListener(this);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentHeaderViewType = 0;
        this.mShouldPin = true;
        this.mCurrentSection = 0;
        super.setOnScrollListener(this);
    }

    private void ensurePinnedHeaderLayout(View view) {
        if (view.isLayoutRequested()) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), this.mWidthMode);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            view.measure(iMakeMeasureSpec, (layoutParams == null || layoutParams.height <= 0) ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private View getSectionHeaderView(int i, View view) {
        boolean z = i != this.mCurrentSection || view == null;
        View sectionHeaderView = this.mAdapter.getSectionHeaderView(i, view, this);
        if (z) {
            ensurePinnedHeaderLayout(sectionHeaderView);
            this.mCurrentSection = i;
        }
        return sectionHeaderView;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mAdapter == null || !this.mShouldPin || this.mCurrentHeader == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(0.0f, this.mHeaderOffset);
        canvas.clipRect(0, 0, getWidth(), this.mCurrentHeader.getMeasuredHeight());
        this.mCurrentHeader.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidthMode = View.MeasureSpec.getMode(i);
        this.mHeightMode = View.MeasureSpec.getMode(i2);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
        PinnedSectionedHeaderAdapter pinnedSectionedHeaderAdapter = this.mAdapter;
        if (pinnedSectionedHeaderAdapter == null || pinnedSectionedHeaderAdapter.getCount() == 0 || !this.mShouldPin || i < getHeaderViewsCount()) {
            this.mCurrentHeader = null;
            this.mHeaderOffset = 0.0f;
            for (int i4 = i; i4 < i + i2; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != null) {
                    childAt.setVisibility(0);
                }
            }
            return;
        }
        int headerViewsCount = i - getHeaderViewsCount();
        int sectionForPosition = this.mAdapter.getSectionForPosition(headerViewsCount);
        int sectionHeaderViewType = this.mAdapter.getSectionHeaderViewType(sectionForPosition);
        View sectionHeaderView = getSectionHeaderView(sectionForPosition, this.mCurrentHeaderViewType == sectionHeaderViewType ? this.mCurrentHeader : null);
        this.mCurrentHeader = sectionHeaderView;
        ensurePinnedHeaderLayout(sectionHeaderView);
        this.mCurrentHeaderViewType = sectionHeaderViewType;
        this.mHeaderOffset = 0.0f;
        for (int i5 = headerViewsCount; i5 < headerViewsCount + i2; i5++) {
            if (this.mAdapter.isSectionHeader(i5)) {
                View childAt2 = getChildAt(i5 - headerViewsCount);
                float top = childAt2.getTop();
                float measuredHeight = this.mCurrentHeader.getMeasuredHeight();
                childAt2.setVisibility(0);
                if (measuredHeight >= top && top > 0.0f) {
                    this.mHeaderOffset = top - childAt2.getHeight();
                } else if (top <= 0.0f) {
                    childAt2.setVisibility(4);
                }
            }
        }
        invalidate();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        this.mCurrentHeader = null;
        this.mAdapter = (PinnedSectionedHeaderAdapter) listAdapter;
        super.setAdapter(listAdapter);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener((AdapterView.OnItemClickListener) onItemClickListener);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public void setPinHeaders(boolean z) {
        this.mShouldPin = z;
    }
}
