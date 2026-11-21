package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemOrderCoupon2Binding extends ViewDataBinding {
    public final LinearLayout llContent;
    public final TextView tv1;
    public final TextView tv2;
    public final TextView tvContent;
    public final TextView tvPrice;

    protected ItemOrderCoupon2Binding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.llContent = linearLayout;
        this.tv1 = textView;
        this.tv2 = textView2;
        this.tvContent = textView3;
        this.tvPrice = textView4;
    }

    public static ItemOrderCoupon2Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOrderCoupon2Binding bind(View view, Object obj) {
        return (ItemOrderCoupon2Binding) bind(obj, view, 2131493031);
    }

    public static ItemOrderCoupon2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemOrderCoupon2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOrderCoupon2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemOrderCoupon2Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131493031, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemOrderCoupon2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemOrderCoupon2Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131493031, (ViewGroup) null, false, obj);
    }
}
