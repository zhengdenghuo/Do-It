package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class PopupSiteBinding extends ViewDataBinding {
    public final ImageView imgClose;
    public final ImageView imgTop;
    public final RecyclerView rvRefreshable;
    public final TextView tvConfirm;
    public final TextView tvTitle;

    protected PopupSiteBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.imgClose = imageView;
        this.imgTop = imageView2;
        this.rvRefreshable = recyclerView;
        this.tvConfirm = textView;
        this.tvTitle = textView2;
    }

    public static PopupSiteBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupSiteBinding bind(View view, Object obj) {
        return (PopupSiteBinding) bind(obj, view, 2131493090);
    }

    public static PopupSiteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static PopupSiteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupSiteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupSiteBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493090, viewGroup, z, obj);
    }

    @Deprecated
    public static PopupSiteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupSiteBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493090, (ViewGroup) null, false, obj);
    }
}
