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
public abstract class ItemMainTabBinding extends ViewDataBinding {
    public final ImageView ivIcon;
    public final ConstraintLayout tvTab;
    public final TextView tvTxt;

    protected ItemMainTabBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.ivIcon = imageView;
        this.tvTab = constraintLayout;
        this.tvTxt = textView;
    }

    public static ItemMainTabBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainTabBinding bind(View view, Object obj) {
        return (ItemMainTabBinding) bind(obj, view, 2131493026);
    }

    public static ItemMainTabBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemMainTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMainTabBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493026, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemMainTabBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMainTabBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493026, (ViewGroup) null, false, obj);
    }
}
