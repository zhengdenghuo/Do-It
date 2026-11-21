package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemPopupSiteBinding extends ViewDataBinding {
    public final TextView tvName;

    protected ItemPopupSiteBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.tvName = textView;
    }

    public static ItemPopupSiteBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPopupSiteBinding bind(View view, Object obj) {
        return (ItemPopupSiteBinding) bind(obj, view, 2131493039);
    }

    public static ItemPopupSiteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemPopupSiteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPopupSiteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPopupSiteBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493039, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemPopupSiteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPopupSiteBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493039, (ViewGroup) null, false, obj);
    }
}
