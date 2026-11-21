package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.recycler.SRecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragOrderdetailListBinding extends ViewDataBinding {
    public final SRecyclerView srvOrder;
    public final TextView tvEmpty;
    public final TextView tvPrint;
    public final TextView tvTitle;
    public final View vLine;

    protected FragOrderdetailListBinding(Object obj, View view, int i, SRecyclerView sRecyclerView, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i);
        this.srvOrder = sRecyclerView;
        this.tvEmpty = textView;
        this.tvPrint = textView2;
        this.tvTitle = textView3;
        this.vLine = view2;
    }

    public static FragOrderdetailListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragOrderdetailListBinding bind(View view, Object obj) {
        return (FragOrderdetailListBinding) bind(obj, view, 2131492985);
    }

    public static FragOrderdetailListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragOrderdetailListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragOrderdetailListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragOrderdetailListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492985, viewGroup, z, obj);
    }

    @Deprecated
    public static FragOrderdetailListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragOrderdetailListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492985, (ViewGroup) null, false, obj);
    }
}
