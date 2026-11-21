package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.CircleImageView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class FragMineBindingImpl extends FragMineBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131297200, 1);
        sparseIntArray.put(2131296907, 2);
        sparseIntArray.put(2131297178, 3);
        sparseIntArray.put(2131296594, 4);
        sparseIntArray.put(2131297056, 5);
        sparseIntArray.put(2131297035, 6);
        sparseIntArray.put(2131296967, 7);
        sparseIntArray.put(2131296964, 8);
        sparseIntArray.put(2131297146, 9);
        sparseIntArray.put(2131297143, 10);
        sparseIntArray.put(2131296956, 11);
        sparseIntArray.put(2131296375, 12);
    }

    public FragMineBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private FragMineBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[12], (CircleImageView) objArr[4], (TextView) objArr[2], (TextView) objArr[11], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[10], (TextView) objArr[9], (View) objArr[3], (View) objArr[1]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag((Object) null);
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
