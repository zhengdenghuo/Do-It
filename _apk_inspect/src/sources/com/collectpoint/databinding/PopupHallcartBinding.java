package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class PopupHallcartBinding extends ViewDataBinding {
    public final TextView etContent;
    public final ImageView imgClose;
    public final ImageView ivAdd;
    public final ImageView ivProduct;
    public final ImageView ivSub;
    public final RecyclerView rvDouble;
    public final RecyclerView rvFeed;
    public final RecyclerView rvRefreshable;
    public final RecyclerView rvSku;
    public final NestedScrollView scroll;
    public final TextView tvCancel;
    public final TextView tvChoice;
    public final TextView tvConfirm;
    public final TextView tvFeed;
    public final TextView tvGg;
    public final TextView tvName;
    public final TextView tvPrice;
    public final TextView tvSellingPoint;
    public final TextView tvStartNum;
    public final TextView tvTitle;

    protected PopupHallcartBinding(Object obj, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, RecyclerView recyclerView4, NestedScrollView nestedScrollView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        super(obj, view, i);
        this.etContent = textView;
        this.imgClose = imageView;
        this.ivAdd = imageView2;
        this.ivProduct = imageView3;
        this.ivSub = imageView4;
        this.rvDouble = recyclerView;
        this.rvFeed = recyclerView2;
        this.rvRefreshable = recyclerView3;
        this.rvSku = recyclerView4;
        this.scroll = nestedScrollView;
        this.tvCancel = textView2;
        this.tvChoice = textView3;
        this.tvConfirm = textView4;
        this.tvFeed = textView5;
        this.tvGg = textView6;
        this.tvName = textView7;
        this.tvPrice = textView8;
        this.tvSellingPoint = textView9;
        this.tvStartNum = textView10;
        this.tvTitle = textView11;
    }

    public static PopupHallcartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupHallcartBinding bind(View view, Object obj) {
        return (PopupHallcartBinding) bind(obj, view, 2131493083);
    }

    public static PopupHallcartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static PopupHallcartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupHallcartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupHallcartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493083, viewGroup, z, obj);
    }

    @Deprecated
    public static PopupHallcartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupHallcartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493083, (ViewGroup) null, false, obj);
    }
}
