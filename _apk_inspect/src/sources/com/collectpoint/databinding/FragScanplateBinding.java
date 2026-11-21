package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.recycler.SRecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragScanplateBinding extends ViewDataBinding {
    public final SRecyclerView srvOrder;
    public final TextView tvScan;
    public final TextView tvStatue;
    public final TextView tvSum;
    public final TextView tvTitle;
    public final View vLine;

    protected FragScanplateBinding(Object obj, View view, int i, SRecyclerView sRecyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2) {
        super(obj, view, i);
        this.srvOrder = sRecyclerView;
        this.tvScan = textView;
        this.tvStatue = textView2;
        this.tvSum = textView3;
        this.tvTitle = textView4;
        this.vLine = view2;
    }

    public static FragScanplateBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragScanplateBinding bind(View view, Object obj) {
        return (FragScanplateBinding) bind(obj, view, 2131492992);
    }

    public static FragScanplateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragScanplateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragScanplateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragScanplateBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492992, viewGroup, z, obj);
    }

    @Deprecated
    public static FragScanplateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragScanplateBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492992, (ViewGroup) null, false, obj);
    }
}
