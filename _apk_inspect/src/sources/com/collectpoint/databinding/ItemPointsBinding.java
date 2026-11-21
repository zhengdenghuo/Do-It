package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemPointsBinding extends ViewDataBinding {
    public final LinearLayout llUser;
    public final TextView tvDele;
    public final TextView tvNavigation;
    public final TextView tvTitle;

    protected ItemPointsBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.llUser = linearLayout;
        this.tvDele = textView;
        this.tvNavigation = textView2;
        this.tvTitle = textView3;
    }

    public static ItemPointsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPointsBinding bind(View view, Object obj) {
        return (ItemPointsBinding) bind(obj, view, 2131493038);
    }

    public static ItemPointsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemPointsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPointsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPointsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493038, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemPointsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPointsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493038, (ViewGroup) null, false, obj);
    }
}
