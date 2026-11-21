package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.recycler.SRecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class FragHomeBindingImpl extends FragHomeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131296412, 1);
        sparseIntArray.put(2131297169, 2);
        sparseIntArray.put(2131297181, 3);
        sparseIntArray.put(2131296487, 4);
        sparseIntArray.put(2131297090, 5);
        sparseIntArray.put(2131296609, 6);
        sparseIntArray.put(2131296867, 7);
        sparseIntArray.put(2131296868, 8);
        sparseIntArray.put(2131296864, 9);
        sparseIntArray.put(2131296857, 10);
        sparseIntArray.put(2131296863, 11);
        sparseIntArray.put(2131297055, 12);
    }

    public FragHomeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private FragHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[1], (EditText) objArr[4], (ImageView) objArr[6], (SmartRefreshLayout) objArr[10], (SRecyclerView) objArr[11], (SRecyclerView) objArr[9], (SRecyclerView) objArr[7], (SRecyclerView) objArr[8], (TextView) objArr[12], (TextView) objArr[5], (View) objArr[2], (View) objArr[3]);
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
