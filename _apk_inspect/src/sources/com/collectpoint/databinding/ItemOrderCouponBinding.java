package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemOrderCouponBinding extends ViewDataBinding {
    public final ImageView ivDele;
    public final LinearLayout llContent;
    public final TextView tvContent;
    public final TextView tvPrice;

    protected ItemOrderCouponBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.ivDele = imageView;
        this.llContent = linearLayout;
        this.tvContent = textView;
        this.tvPrice = textView2;
    }

    public static ItemOrderCouponBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOrderCouponBinding bind(View view, Object obj) {
        return (ItemOrderCouponBinding) bind(obj, view, 2131493030);
    }

    public static ItemOrderCouponBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemOrderCouponBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOrderCouponBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemOrderCouponBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493030, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemOrderCouponBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemOrderCouponBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493030, (ViewGroup) null, false, obj);
    }
}
