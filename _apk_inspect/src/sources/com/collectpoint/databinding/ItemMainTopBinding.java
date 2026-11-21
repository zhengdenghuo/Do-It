package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemMainTopBinding extends ViewDataBinding {
    public final View ivIcon;
    public final ConstraintLayout tvTab;
    public final TextView tvTxt;
    public final View vLine;

    protected ItemMainTopBinding(Object obj, View view, int i, View view2, ConstraintLayout constraintLayout, TextView textView, View view3) {
        super(obj, view, i);
        this.ivIcon = view2;
        this.tvTab = constraintLayout;
        this.tvTxt = textView;
        this.vLine = view3;
    }

    public static ItemMainTopBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainTopBinding bind(View view, Object obj) {
        return (ItemMainTopBinding) bind(obj, view, 2131493027);
    }

    public static ItemMainTopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemMainTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMainTopBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493027, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemMainTopBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMainTopBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493027, (ViewGroup) null, false, obj);
    }
}
