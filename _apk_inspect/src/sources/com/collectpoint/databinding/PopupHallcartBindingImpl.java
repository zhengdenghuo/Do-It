package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class PopupHallcartBindingImpl extends PopupHallcartBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131296568, 1);
        sparseIntArray.put(2131297136, 2);
        sparseIntArray.put(2131296618, 3);
        sparseIntArray.put(2131297056, 4);
        sparseIntArray.put(2131297075, 5);
        sparseIntArray.put(2131297117, 6);
        sparseIntArray.put(2131296588, 7);
        sparseIntArray.put(2131296622, 8);
        sparseIntArray.put(2131296497, 9);
        sparseIntArray.put(2131297110, 10);
        sparseIntArray.put(2131296790, 11);
        sparseIntArray.put(2131296777, 12);
        sparseIntArray.put(2131297028, 13);
        sparseIntArray.put(2131296781, 14);
        sparseIntArray.put(2131296780, 15);
        sparseIntArray.put(2131297006, 16);
        sparseIntArray.put(2131296778, 17);
        sparseIntArray.put(2131296969, 18);
        sparseIntArray.put(2131296965, 19);
        sparseIntArray.put(2131296981, 20);
    }

    public PopupHallcartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private PopupHallcartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[9], (ImageView) objArr[1], (ImageView) objArr[7], (ImageView) objArr[3], (ImageView) objArr[8], (RecyclerView) objArr[12], (RecyclerView) objArr[17], (RecyclerView) objArr[15], (RecyclerView) objArr[14], (NestedScrollView) objArr[11], (TextView) objArr[19], (TextView) objArr[18], (TextView) objArr[20], (TextView) objArr[16], (TextView) objArr[13], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[10], (TextView) objArr[6], (TextView) objArr[2]);
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
