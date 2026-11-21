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
public abstract class PopupDouyincouponBinding extends ViewDataBinding {
    public final ConstraintLayout clContent;
    public final ConstraintLayout clContent1;
    public final TextView etContent;
    public final ImageView ivAdd;
    public final ImageView ivAddUn;
    public final ImageView ivSub;
    public final ImageView ivSubUn;
    public final TextView tvCancel;
    public final TextView tvConfirm;
    public final TextView tvHint;
    public final TextView tvName;
    public final TextView tvPrice;
    public final TextView tvRule;
    public final TextView tvTitle;
    public final TextView tvUnit;
    public final View vLine;

    protected PopupDouyincouponBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, View view2) {
        super(obj, view, i);
        this.clContent = constraintLayout;
        this.clContent1 = constraintLayout2;
        this.etContent = textView;
        this.ivAdd = imageView;
        this.ivAddUn = imageView2;
        this.ivSub = imageView3;
        this.ivSubUn = imageView4;
        this.tvCancel = textView2;
        this.tvConfirm = textView3;
        this.tvHint = textView4;
        this.tvName = textView5;
        this.tvPrice = textView6;
        this.tvRule = textView7;
        this.tvTitle = textView8;
        this.tvUnit = textView9;
        this.vLine = view2;
    }

    public static PopupDouyincouponBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupDouyincouponBinding bind(View view, Object obj) {
        return (PopupDouyincouponBinding) bind(obj, view, 2131493082);
    }

    public static PopupDouyincouponBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static PopupDouyincouponBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupDouyincouponBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupDouyincouponBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493082, viewGroup, z, obj);
    }

    @Deprecated
    public static PopupDouyincouponBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupDouyincouponBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493082, (ViewGroup) null, false, obj);
    }
}
