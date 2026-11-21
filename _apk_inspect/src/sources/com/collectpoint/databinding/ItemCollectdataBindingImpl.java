package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class ItemCollectdataBindingImpl extends ItemCollectdataBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131297040, 1);
        sparseIntArray.put(2131297180, 2);
        sparseIntArray.put(2131296407, 3);
        sparseIntArray.put(2131297073, 4);
        sparseIntArray.put(2131297056, 5);
        sparseIntArray.put(2131297042, 6);
        sparseIntArray.put(2131297016, 7);
        sparseIntArray.put(2131296961, 8);
        sparseIntArray.put(2131297134, 9);
        sparseIntArray.put(2131296960, 10);
        sparseIntArray.put(2131297014, 11);
        sparseIntArray.put(2131297132, 12);
        sparseIntArray.put(2131297199, 13);
        sparseIntArray.put(2131296615, 14);
        sparseIntArray.put(2131296606, 15);
        sparseIntArray.put(2131296974, 16);
    }

    public ItemCollectdataBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private ItemCollectdataBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[3], (ImageView) objArr[15], (ImageView) objArr[14], (TextView) objArr[10], (TextView) objArr[8], (TextView) objArr[16], (TextView) objArr[11], (TextView) objArr[7], (TextView) objArr[1], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[12], (TextView) objArr[9], (View) objArr[2], (View) objArr[13]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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
