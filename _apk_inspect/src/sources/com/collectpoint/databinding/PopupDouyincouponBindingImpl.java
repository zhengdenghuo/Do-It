package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class PopupDouyincouponBindingImpl extends PopupDouyincouponBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131297136, 1);
        sparseIntArray.put(2131296408, 2);
        sparseIntArray.put(2131297056, 3);
        sparseIntArray.put(2131297075, 4);
        sparseIntArray.put(2131297141, 5);
        sparseIntArray.put(2131297182, 6);
        sparseIntArray.put(2131296588, 7);
        sparseIntArray.put(2131296622, 8);
        sparseIntArray.put(2131296589, 9);
        sparseIntArray.put(2131296623, 10);
        sparseIntArray.put(2131296497, 11);
        sparseIntArray.put(2131297103, 12);
        sparseIntArray.put(2131297034, 13);
        sparseIntArray.put(2131296965, 14);
        sparseIntArray.put(2131296981, 15);
    }

    public PopupDouyincouponBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private PopupDouyincouponBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[0], (ConstraintLayout) objArr[2], (TextView) objArr[11], (ImageView) objArr[7], (ImageView) objArr[9], (ImageView) objArr[8], (ImageView) objArr[10], (TextView) objArr[14], (TextView) objArr[15], (TextView) objArr[13], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[12], (TextView) objArr[1], (TextView) objArr[5], (View) objArr[6]);
        this.mDirtyFlags = -1L;
        this.clContent.setTag((Object) null);
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
