package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.recycler.SRecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class FragOrdersettleBindingImpl extends FragOrdersettleBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131297182, 1);
        sparseIntArray.put(2131297136, 2);
        sparseIntArray.put(2131296743, 3);
        sparseIntArray.put(2131296405, 4);
        sparseIntArray.put(2131297088, 5);
        sparseIntArray.put(2131297097, 6);
        sparseIntArray.put(2131297096, 7);
        sparseIntArray.put(2131297087, 8);
        sparseIntArray.put(2131297019, 9);
        sparseIntArray.put(2131296986, 10);
        sparseIntArray.put(2131296987, 11);
        sparseIntArray.put(2131297148, 12);
        sparseIntArray.put(2131297116, 13);
        sparseIntArray.put(2131297030, 14);
        sparseIntArray.put(2131296865, 15);
        sparseIntArray.put(2131297069, 16);
        sparseIntArray.put(2131296862, 17);
        sparseIntArray.put(2131296995, 18);
        sparseIntArray.put(2131297113, 19);
    }

    public FragOrdersettleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private FragOrdersettleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[4], (TextView) objArr[3], (SRecyclerView) objArr[17], (SRecyclerView) objArr[15], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[18], (TextView) objArr[9], (TextView) objArr[14], (TextView) objArr[16], (TextView) objArr[8], (TextView) objArr[5], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[19], (TextView) objArr[13], (TextView) objArr[2], (TextView) objArr[12], (View) objArr[1]);
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
