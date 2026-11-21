package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemOrderCoupon3Binding extends ViewDataBinding {
    public final LinearLayout llContent;
    public final TextView tvContent;
    public final TextView tvPrice;

    protected ItemOrderCoupon3Binding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.llContent = linearLayout;
        this.tvContent = textView;
        this.tvPrice = textView2;
    }

    public static ItemOrderCoupon3Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOrderCoupon3Binding bind(View view, Object obj) {
        return (ItemOrderCoupon3Binding) bind(obj, view, 2131493032);
    }

    public static ItemOrderCoupon3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemOrderCoupon3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOrderCoupon3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemOrderCoupon3Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131493032, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemOrderCoupon3Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemOrderCoupon3Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131493032, (ViewGroup) null, false, obj);
    }
}
