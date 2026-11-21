package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.recycler.SRecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemProductBinding extends ViewDataBinding {
    public final SRecyclerView rvAttr;
    public final TextView tvName;

    protected ItemProductBinding(Object obj, View view, int i, SRecyclerView sRecyclerView, TextView textView) {
        super(obj, view, i);
        this.rvAttr = sRecyclerView;
        this.tvName = textView;
    }

    public static ItemProductBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductBinding bind(View view, Object obj) {
        return (ItemProductBinding) bind(obj, view, 2131493040);
    }

    public static ItemProductBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemProductBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493040, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemProductBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493040, (ViewGroup) null, false, obj);
    }
}
