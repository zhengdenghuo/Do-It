package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import com.collectpoint.widget.bottomscroll.SlideBottomLayout;
import com.collectpoint.widget.recycler.SRecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class FragOrderdetailBindingImpl extends FragOrderdetailBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final DrawerLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131297182, 1);
        sparseIntArray.put(2131297136, 2);
        sparseIntArray.put(2131297001, 3);
        sparseIntArray.put(2131296861, 4);
        sparseIntArray.put(2131296836, 5);
        sparseIntArray.put(2131296711, 6);
        sparseIntArray.put(2131296959, 7);
        sparseIntArray.put(2131297051, 8);
        sparseIntArray.put(2131297115, 9);
        sparseIntArray.put(2131297123, 10);
        sparseIntArray.put(2131296968, 11);
        sparseIntArray.put(2131297029, 12);
        sparseIntArray.put(2131297121, 13);
        sparseIntArray.put(2131297061, 14);
        sparseIntArray.put(2131297046, 15);
    }

    public FragOrderdetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private FragOrderdetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[6], (SlideBottomLayout) objArr[5], (SRecyclerView) objArr[4], (TextView) objArr[7], (TextView) objArr[11], (TextView) objArr[3], (TextView) objArr[12], (TextView) objArr[15], (TextView) objArr[8], (TextView) objArr[14], (TextView) objArr[9], (TextView) objArr[13], (TextView) objArr[10], (TextView) objArr[2], (View) objArr[1]);
        this.mDirtyFlags = -1L;
        DrawerLayout drawerLayout = (DrawerLayout) objArr[0];
        this.mboundView0 = drawerLayout;
        drawerLayout.setTag((Object) null);
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
