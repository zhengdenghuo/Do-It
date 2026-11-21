package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.recycler.SRecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class FragOrderdetailHomeBindingImpl extends FragOrderdetailHomeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131297182, 1);
        sparseIntArray.put(2131297077, 2);
        sparseIntArray.put(2131297136, 3);
        sparseIntArray.put(2131296658, 4);
        sparseIntArray.put(2131296617, 5);
        sparseIntArray.put(2131297129, 6);
        sparseIntArray.put(2131297045, 7);
        sparseIntArray.put(2131297127, 8);
        sparseIntArray.put(2131297128, 9);
        sparseIntArray.put(2131296861, 10);
        sparseIntArray.put(2131297085, 11);
        sparseIntArray.put(2131297075, 12);
        sparseIntArray.put(2131297004, 13);
        sparseIntArray.put(2131296666, 14);
        sparseIntArray.put(2131296865, 15);
        sparseIntArray.put(2131296950, 16);
        sparseIntArray.put(2131296951, 17);
        sparseIntArray.put(2131296952, 18);
        sparseIntArray.put(2131296953, 19);
        sparseIntArray.put(2131296866, 20);
        sparseIntArray.put(2131297005, 21);
        sparseIntArray.put(2131297037, 22);
        sparseIntArray.put(2131297096, 23);
    }

    public FragOrderdetailHomeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 24, sIncludes, sViewsWithIds));
    }

    private FragOrderdetailHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[5], (LinearLayout) objArr[4], (LinearLayout) objArr[14], (SRecyclerView) objArr[10], (SRecyclerView) objArr[15], (SRecyclerView) objArr[20], (TextView) objArr[16], (TextView) objArr[17], (TextView) objArr[18], (TextView) objArr[19], (TextView) objArr[13], (TextView) objArr[21], (TextView) objArr[22], (TextView) objArr[7], (TextView) objArr[12], (TextView) objArr[2], (TextView) objArr[11], (TextView) objArr[23], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[6], (TextView) objArr[3], (View) objArr[1]);
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
