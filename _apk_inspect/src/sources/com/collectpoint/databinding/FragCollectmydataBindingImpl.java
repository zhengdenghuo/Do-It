package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.amap.api.maps.MapView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class FragCollectmydataBindingImpl extends FragCollectmydataBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131296522, 1);
        sparseIntArray.put(2131296410, 2);
        sparseIntArray.put(2131296960, 3);
        sparseIntArray.put(2131297048, 4);
        sparseIntArray.put(2131297041, 5);
        sparseIntArray.put(2131297182, 6);
        sparseIntArray.put(2131297025, 7);
        sparseIntArray.put(2131296665, 8);
        sparseIntArray.put(2131297136, 9);
        sparseIntArray.put(2131296497, 10);
        sparseIntArray.put(2131296659, 11);
        sparseIntArray.put(2131297120, 12);
    }

    public FragCollectmydataBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private FragCollectmydataBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[2], (EditText) objArr[10], (MapView) objArr[1], (LinearLayout) objArr[11], (LinearLayout) objArr[8], (TextView) objArr[3], (TextView) objArr[7], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[12], (TextView) objArr[9], (View) objArr[6]);
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
