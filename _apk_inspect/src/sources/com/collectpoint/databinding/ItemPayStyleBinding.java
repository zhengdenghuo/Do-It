package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemPayStyleBinding extends ViewDataBinding {
    public final ConstraintLayout clContent;
    public final TextView tvContent;
    public final TextView tvCouponNum;
    public final TextView tvDescribe;
    public final ImageView vAdd;

    protected ItemPayStyleBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView) {
        super(obj, view, i);
        this.clContent = constraintLayout;
        this.tvContent = textView;
        this.tvCouponNum = textView2;
        this.tvDescribe = textView3;
        this.vAdd = imageView;
    }

    public static ItemPayStyleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPayStyleBinding bind(View view, Object obj) {
        return (ItemPayStyleBinding) bind(obj, view, 2131493036);
    }

    public static ItemPayStyleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemPayStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPayStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPayStyleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493036, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemPayStyleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPayStyleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493036, (ViewGroup) null, false, obj);
    }
}
