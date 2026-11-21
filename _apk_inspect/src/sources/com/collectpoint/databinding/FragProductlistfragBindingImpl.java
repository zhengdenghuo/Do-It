package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class FragProductlistfragBindingImpl extends FragProductlistfragBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131297182, 1);
        sparseIntArray.put(2131297136, 2);
        sparseIntArray.put(2131296487, 3);
        sparseIntArray.put(2131296676, 4);
        sparseIntArray.put(2131296825, 5);
        sparseIntArray.put(2131297082, 6);
        sparseIntArray.put(2131297185, 7);
        sparseIntArray.put(2131297061, 8);
    }

    public FragProductlistfragBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private FragProductlistfragBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EditText) objArr[3], (ListView) objArr[4], (StickyListHeadersListView) objArr[5], (TextView) objArr[8], (TextView) objArr[6], (TextView) objArr[2], (View) objArr[1], (View) objArr[7]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }
}
