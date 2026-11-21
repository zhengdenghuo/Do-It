package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.amap.api.maps.MapView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class FragPointCollectCoiledBindingImpl extends FragPointCollectCoiledBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131296522, 1);
        sparseIntArray.put(2131296616, 2);
        sparseIntArray.put(2131297187, 3);
        sparseIntArray.put(2131297136, 4);
        sparseIntArray.put(2131296979, 5);
        sparseIntArray.put(2131297003, 6);
        sparseIntArray.put(2131297105, 7);
        sparseIntArray.put(2131297074, 8);
        sparseIntArray.put(2131296660, 9);
        sparseIntArray.put(2131297104, 10);
        sparseIntArray.put(2131297042, 11);
        sparseIntArray.put(2131297112, 12);
        sparseIntArray.put(2131297130, 13);
        sparseIntArray.put(2131296989, 14);
        sparseIntArray.put(2131297108, 15);
        sparseIntArray.put(2131296982, 16);
        sparseIntArray.put(2131297043, 17);
        sparseIntArray.put(2131297008, 18);
        sparseIntArray.put(2131297049, 19);
        sparseIntArray.put(2131297114, 20);
    }

    public FragPointCollectCoiledBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private FragPointCollectCoiledBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MapView) objArr[1], (ImageView) objArr[2], (LinearLayout) objArr[9], (TextView) objArr[5], (View) objArr[16], (View) objArr[14], (TextView) objArr[6], (View) objArr[18], (TextView) objArr[11], (View) objArr[17], (View) objArr[19], (TextView) objArr[8], (TextView) objArr[10], (TextView) objArr[7], (View) objArr[15], (View) objArr[12], (View) objArr[20], (View) objArr[13], (TextView) objArr[4], (View) objArr[3]);
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
