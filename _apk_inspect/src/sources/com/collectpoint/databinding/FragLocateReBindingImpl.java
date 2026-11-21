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
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.maps.MapView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class FragLocateReBindingImpl extends FragLocateReBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131296662, 1);
        sparseIntArray.put(2131297048, 2);
        sparseIntArray.put(2131297041, 3);
        sparseIntArray.put(2131296604, 4);
        sparseIntArray.put(2131296668, 5);
        sparseIntArray.put(2131296487, 6);
        sparseIntArray.put(2131296965, 7);
        sparseIntArray.put(2131296522, 8);
        sparseIntArray.put(2131296761, 9);
        sparseIntArray.put(2131296780, 10);
        sparseIntArray.put(2131297120, 11);
    }

    public FragLocateReBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private FragLocateReBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EditText) objArr[6], (MapView) objArr[8], (ImageView) objArr[4], (ConstraintLayout) objArr[1], (LinearLayout) objArr[5], (SmartRefreshLayout) objArr[9], (RecyclerView) objArr[10], (TextView) objArr[7], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[11]);
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
