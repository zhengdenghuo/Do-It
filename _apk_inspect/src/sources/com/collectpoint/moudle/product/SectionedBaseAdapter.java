package com.collectpoint.moudle.product;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.collectpoint.moudle.product.PinnedHeaderListView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public abstract class SectionedBaseAdapter extends BaseAdapter implements PinnedHeaderListView.PinnedSectionedHeaderAdapter {
    private static int HEADER_VIEW_TYPE = 0;
    private static int ITEM_VIEW_TYPE = 0;
    private SparseArray<Integer> mSectionCache = new SparseArray<>();
    private SparseArray<Integer> mSectionPositionCache = new SparseArray<>();
    private SparseArray<Integer> mSectionCountCache = new SparseArray<>();
    private int mCount = -1;
    private int mSectionCount = -1;

    private int internalGetCountForSection(int i) {
        Integer num = this.mSectionCountCache.get(i);
        if (num != null) {
            return num.intValue();
        }
        int countForSection = getCountForSection(i);
        this.mSectionCountCache.put(i, Integer.valueOf(countForSection));
        return countForSection;
    }

    private int internalGetSectionCount() {
        int i = this.mSectionCount;
        if (i >= 0) {
            return i;
        }
        int sectionCount = getSectionCount();
        this.mSectionCount = sectionCount;
        return sectionCount;
    }

    @Override // android.widget.Adapter, com.collectpoint.moudle.product.PinnedHeaderListView.PinnedSectionedHeaderAdapter
    public final int getCount() {
        int i = this.mCount;
        if (i >= 0) {
            return i;
        }
        int iInternalGetCountForSection = 0;
        for (int i2 = 0; i2 < internalGetSectionCount(); i2++) {
            iInternalGetCountForSection = iInternalGetCountForSection + internalGetCountForSection(i2) + 1;
        }
        this.mCount = iInternalGetCountForSection;
        return iInternalGetCountForSection;
    }

    public abstract int getCountForSection(int i);

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return getItem(getSectionForPosition(i), getPositionInSectionForPosition(i));
    }

    public abstract Object getItem(int i, int i2);

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return getItemId(getSectionForPosition(i), getPositionInSectionForPosition(i));
    }

    public abstract long getItemId(int i, int i2);

    public abstract View getItemView(int i, int i2, View view, ViewGroup viewGroup);

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        return isSectionHeader(i) ? getItemViewTypeCount() + getSectionHeaderViewType(getSectionForPosition(i)) : getItemViewType(getSectionForPosition(i), getPositionInSectionForPosition(i));
    }

    public int getItemViewType(int i, int i2) {
        return ITEM_VIEW_TYPE;
    }

    public int getItemViewTypeCount() {
        return 1;
    }

    public int getPositionInSectionForPosition(int i) {
        Integer num = this.mSectionPositionCache.get(i);
        if (num != null) {
            return num.intValue();
        }
        int i2 = 0;
        for (int i3 = 0; i3 < internalGetSectionCount(); i3++) {
            int iInternalGetCountForSection = i2 + internalGetCountForSection(i3) + 1;
            if (i >= i2 && i < iInternalGetCountForSection) {
                int i4 = (i - i2) - 1;
                this.mSectionPositionCache.put(i, Integer.valueOf(i4));
                return i4;
            }
            i2 = iInternalGetCountForSection;
        }
        return 0;
    }

    public abstract int getSectionCount();

    @Override // com.collectpoint.moudle.product.PinnedHeaderListView.PinnedSectionedHeaderAdapter
    public final int getSectionForPosition(int i) {
        Integer num = this.mSectionCache.get(i);
        if (num != null) {
            return num.intValue();
        }
        int i2 = 0;
        for (int i3 = 0; i3 < internalGetSectionCount(); i3++) {
            int iInternalGetCountForSection = i2 + internalGetCountForSection(i3) + 1;
            if (i >= i2 && i < iInternalGetCountForSection) {
                this.mSectionCache.put(i, Integer.valueOf(i3));
                return i3;
            }
            i2 = iInternalGetCountForSection;
        }
        return 0;
    }

    public abstract View getSectionHeaderView(int i, View view, ViewGroup viewGroup);

    @Override // com.collectpoint.moudle.product.PinnedHeaderListView.PinnedSectionedHeaderAdapter
    public int getSectionHeaderViewType(int i) {
        return HEADER_VIEW_TYPE;
    }

    public int getSectionHeaderViewTypeCount() {
        return 1;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        return isSectionHeader(i) ? getSectionHeaderView(getSectionForPosition(i), view, viewGroup) : getItemView(getSectionForPosition(i), getPositionInSectionForPosition(i), view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return getItemViewTypeCount() + getSectionHeaderViewTypeCount();
    }

    @Override // com.collectpoint.moudle.product.PinnedHeaderListView.PinnedSectionedHeaderAdapter
    public final boolean isSectionHeader(int i) {
        int iInternalGetCountForSection = 0;
        for (int i2 = 0; i2 < internalGetSectionCount(); i2++) {
            if (i == iInternalGetCountForSection) {
                return true;
            }
            if (i < iInternalGetCountForSection) {
                return false;
            }
            iInternalGetCountForSection += internalGetCountForSection(i2) + 1;
        }
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.mSectionCache.clear();
        this.mSectionPositionCache.clear();
        this.mSectionCountCache.clear();
        this.mCount = -1;
        this.mSectionCount = -1;
        super.notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        this.mSectionCache.clear();
        this.mSectionPositionCache.clear();
        this.mSectionCountCache.clear();
        this.mCount = -1;
        this.mSectionCount = -1;
        super.notifyDataSetInvalidated();
    }
}
