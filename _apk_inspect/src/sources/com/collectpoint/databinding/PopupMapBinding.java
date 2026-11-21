package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class PopupMapBinding extends ViewDataBinding {
    public final TextView tvBd;
    public final TextView tvGd;
    public final TextView tvTx;
    public final View v1;
    public final View v2;

    protected PopupMapBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, View view2, View view3) {
        super(obj, view, i);
        this.tvBd = textView;
        this.tvGd = textView2;
        this.tvTx = textView3;
        this.v1 = view2;
        this.v2 = view3;
    }

    public static PopupMapBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupMapBinding bind(View view, Object obj) {
        return (PopupMapBinding) bind(obj, view, 2131493084);
    }

    public static PopupMapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static PopupMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupMapBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493084, viewGroup, z, obj);
    }

    @Deprecated
    public static PopupMapBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupMapBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493084, (ViewGroup) null, false, obj);
    }
}
