package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.recycler.SRecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class FragCouponlistTgBindingImpl extends FragCouponlistTgBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131297182, 1);
        sparseIntArray.put(2131297136, 2);
        sparseIntArray.put(2131297124, 3);
        sparseIntArray.put(2131296862, 4);
        sparseIntArray.put(2131296999, 5);
        sparseIntArray.put(2131296998, 6);
        sparseIntArray.put(2131297125, 7);
        sparseIntArray.put(2131296498, 8);
        sparseIntArray.put(2131296598, 9);
        sparseIntArray.put(2131297033, 10);
        sparseIntArray.put(2131296861, 11);
        sparseIntArray.put(2131297002, 12);
        sparseIntArray.put(2131296860, 13);
        sparseIntArray.put(2131297119, 14);
    }

    public FragCouponlistTgBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private FragCouponlistTgBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EditText) objArr[8], (ImageView) objArr[9], (SRecyclerView) objArr[13], (SRecyclerView) objArr[11], (SRecyclerView) objArr[4], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[12], (TextView) objArr[10], (TextView) objArr[14], (TextView) objArr[3], (TextView) objArr[7], (TextView) objArr[2], (View) objArr[1]);
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
