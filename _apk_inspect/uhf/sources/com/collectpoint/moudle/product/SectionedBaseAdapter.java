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

    public abstract int getCountForSection(int section);

    public abstract Object getItem(int section, int position);

    public abstract long getItemId(int section, int position);

    public abstract View getItemView(int section, int position, View convertView, ViewGroup parent);

    public abstract int getSectionCount();

    public abstract View getSectionHeaderView(int section, View convertView, ViewGroup parent);

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

    @Override // android.widget.Adapter, com.collectpoint.moudle.product.PinnedHeaderListView.PinnedSectionedHeaderAdapter
    public final int getCount() {
        int i = this.mCount;
        if (i >= 0) {
            return i;
        }
        int count = 0;
        for (int i2 = 0; i2 < internalGetSectionCount(); i2++) {
            count = count + internalGetCountForSection(i2) + 1;
        }
        this.mCount = count;
        return count;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int position) {
        return getItem(getSectionForPosition(position), getPositionInSectionForPosition(position));
    }

    @Override // android.widget.Adapter
    public final long getItemId(int position) {
        return getItemId(getSectionForPosition(position), getPositionInSectionForPosition(position));
    }

    @Override // android.widget.Adapter
    public final View getView(int position, View convertView, ViewGroup parent) {
        if (isSectionHeader(position)) {
            return getSectionHeaderView(getSectionForPosition(position), convertView, parent);
        }
        return getItemView(getSectionForPosition(position), getPositionInSectionForPosition(position), convertView, parent);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int position) {
        if (isSectionHeader(position)) {
            return getItemViewTypeCount() + getSectionHeaderViewType(getSectionForPosition(position));
        }
        return getItemViewType(getSectionForPosition(position), getPositionInSectionForPosition(position));
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return getItemViewTypeCount() + getSectionHeaderViewTypeCount();
    }

    @Override // com.collectpoint.moudle.product.PinnedHeaderListView.PinnedSectionedHeaderAdapter
    public final int getSectionForPosition(int position) {
        Integer cachedSection = this.mSectionCache.get(position);
        if (cachedSection != null) {
            return cachedSection.intValue();
        }
        int sectionStart = 0;
        for (int i = 0; i < internalGetSectionCount(); i++) {
            int sectionCount = internalGetCountForSection(i);
            int sectionEnd = sectionStart + sectionCount + 1;
            if (position >= sectionStart && position < sectionEnd) {
                this.mSectionCache.put(position, Integer.valueOf(i));
                return i;
            }
            sectionStart = sectionEnd;
        }
        return 0;
    }

    public int getPositionInSectionForPosition(int position) {
        Integer cachedPosition = this.mSectionPositionCache.get(position);
        if (cachedPosition != null) {
            return cachedPosition.intValue();
        }
        int sectionStart = 0;
        for (int i = 0; i < internalGetSectionCount(); i++) {
            int sectionCount = internalGetCountForSection(i);
            int sectionEnd = sectionStart + sectionCount + 1;
            if (position >= sectionStart && position < sectionEnd) {
                int positionInSection = (position - sectionStart) - 1;
                this.mSectionPositionCache.put(position, Integer.valueOf(positionInSection));
                return positionInSection;
            }
            sectionStart = sectionEnd;
        }
        return 0;
    }

    @Override // com.collectpoint.moudle.product.PinnedHeaderListView.PinnedSectionedHeaderAdapter
    public final boolean isSectionHeader(int position) {
        int sectionStart = 0;
        for (int i = 0; i < internalGetSectionCount(); i++) {
            if (position == sectionStart) {
                return true;
            }
            if (position < sectionStart) {
                return false;
            }
            sectionStart += internalGetCountForSection(i) + 1;
        }
        return false;
    }

    public int getItemViewType(int section, int position) {
        return ITEM_VIEW_TYPE;
    }

    public int getItemViewTypeCount() {
        return 1;
    }

    @Override // com.collectpoint.moudle.product.PinnedHeaderListView.PinnedSectionedHeaderAdapter
    public int getSectionHeaderViewType(int section) {
        return HEADER_VIEW_TYPE;
    }

    public int getSectionHeaderViewTypeCount() {
        return 1;
    }

    private int internalGetCountForSection(int section) {
        Integer cachedSectionCount = this.mSectionCountCache.get(section);
        if (cachedSectionCount != null) {
            return cachedSectionCount.intValue();
        }
        int sectionCount = getCountForSection(section);
        this.mSectionCountCache.put(section, Integer.valueOf(sectionCount));
        return sectionCount;
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
}
