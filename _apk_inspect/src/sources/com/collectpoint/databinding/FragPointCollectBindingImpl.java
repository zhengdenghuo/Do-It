package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.amap.api.maps.MapView;
import com.collectpoint.widget.MenuView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class FragPointCollectBindingImpl extends FragPointCollectBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131296522, 1);
        sparseIntArray.put(2131296341, 2);
        sparseIntArray.put(2131297183, 3);
        sparseIntArray.put(2131297187, 4);
        sparseIntArray.put(2131297136, 5);
        sparseIntArray.put(2131296979, 6);
        sparseIntArray.put(2131297105, 7);
        sparseIntArray.put(2131297074, 8);
        sparseIntArray.put(2131296660, 9);
        sparseIntArray.put(2131297104, 10);
        sparseIntArray.put(2131297042, 11);
        sparseIntArray.put(2131297130, 12);
        sparseIntArray.put(2131296989, 13);
        sparseIntArray.put(2131297108, 14);
        sparseIntArray.put(2131296982, 15);
        sparseIntArray.put(2131297043, 16);
        sparseIntArray.put(2131297008, 17);
        sparseIntArray.put(2131297049, 18);
        sparseIntArray.put(2131297114, 19);
    }

    public FragPointCollectBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private FragPointCollectBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MenuView) objArr[2], (MapView) objArr[1], (LinearLayout) objArr[9], (TextView) objArr[6], (View) objArr[15], (View) objArr[13], (View) objArr[17], (TextView) objArr[11], (View) objArr[16], (View) objArr[18], (TextView) objArr[8], (TextView) objArr[10], (TextView) objArr[7], (View) objArr[14], (View) objArr[19], (View) objArr[12], (TextView) objArr[5], (View) objArr[3], (View) objArr[4]);
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
