package com.collectpoint.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class FragChangePwdBindingImpl extends FragChangePwdBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131297162, 1);
        sparseIntArray.put(2131296482, 2);
        sparseIntArray.put(2131297163, 3);
        sparseIntArray.put(2131296481, 4);
        sparseIntArray.put(2131296569, 5);
        sparseIntArray.put(2131297166, 6);
        sparseIntArray.put(2131296484, 7);
        sparseIntArray.put(2131296382, 8);
        sparseIntArray.put(2131297164, 9);
        sparseIntArray.put(2131296483, 10);
        sparseIntArray.put(2131296573, 11);
        sparseIntArray.put(2131297165, 12);
        sparseIntArray.put(2131296480, 13);
        sparseIntArray.put(2131296570, 14);
        sparseIntArray.put(2131296381, 15);
    }

    public FragChangePwdBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private FragChangePwdBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[15], (Button) objArr[8], (EditText) objArr[13], (EditText) objArr[4], (EditText) objArr[2], (EditText) objArr[10], (EditText) objArr[7], (ImageView) objArr[5], (ImageView) objArr[14], (ImageView) objArr[11], (View) objArr[1], (View) objArr[3], (View) objArr[9], (View) objArr[12], (View) objArr[6]);
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
