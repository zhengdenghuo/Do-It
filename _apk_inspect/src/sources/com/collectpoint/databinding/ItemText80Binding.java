package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemText80Binding extends ViewDataBinding {
    public final LinearLayout llContent;
    public final TextView tvContent;

    protected ItemText80Binding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.llContent = linearLayout;
        this.tvContent = textView;
    }

    public static ItemText80Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemText80Binding bind(View view, Object obj) {
        return (ItemText80Binding) bind(obj, view, 2131493045);
    }

    public static ItemText80Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemText80Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemText80Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemText80Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131493045, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemText80Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemText80Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131493045, (ViewGroup) null, false, obj);
    }
}
