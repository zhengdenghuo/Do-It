package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class ItemTobedealBindingImpl extends ItemTobedealBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131296407, 1);
        sparseIntArray.put(2131297136, 2);
        sparseIntArray.put(2131297094, 3);
        sparseIntArray.put(2131296949, 4);
        sparseIntArray.put(2131297101, 5);
        sparseIntArray.put(2131296954, 6);
        sparseIntArray.put(2131297132, 7);
        sparseIntArray.put(2131297175, 8);
        sparseIntArray.put(2131296972, 9);
        sparseIntArray.put(2131296955, 10);
        sparseIntArray.put(2131296994, 11);
        sparseIntArray.put(2131297182, 12);
        sparseIntArray.put(2131297093, 13);
        sparseIntArray.put(2131297071, 14);
    }

    public ItemTobedealBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private ItemTobedealBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[0], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[10], (TextView) objArr[9], (TextView) objArr[11], (TextView) objArr[14], (TextView) objArr[13], (TextView) objArr[3], (TextView) objArr[5], (TextView) objArr[7], (TextView) objArr[2], (ImageView) objArr[8], (View) objArr[12]);
        this.mDirtyFlags = -1L;
        this.clContentTop.setTag((Object) null);
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
