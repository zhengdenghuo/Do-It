package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.SlidingDeleteView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class ItemOrderDetailBindingImpl extends ItemOrderDetailBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131296635, 1);
        sparseIntArray.put(2131297084, 2);
        sparseIntArray.put(2131297080, 3);
        sparseIntArray.put(2131297081, 4);
        sparseIntArray.put(2131297079, 5);
        sparseIntArray.put(2131297083, 6);
        sparseIntArray.put(2131297078, 7);
        sparseIntArray.put(2131297061, 8);
        sparseIntArray.put(2131297075, 9);
        sparseIntArray.put(2131297135, 10);
        sparseIntArray.put(2131297197, 11);
        sparseIntArray.put(2131296636, 12);
        sparseIntArray.put(2131297044, 13);
    }

    public ItemOrderDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private ItemOrderDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[1], (LinearLayout) objArr[12], (SlidingDeleteView) objArr[0], (TextView) objArr[13], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[7], (TextView) objArr[5], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[2], (TextView) objArr[10], (View) objArr[11]);
        this.mDirtyFlags = -1L;
        this.slidingview.setTag(null);
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
