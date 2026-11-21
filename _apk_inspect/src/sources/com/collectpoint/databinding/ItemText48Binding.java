package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemText48Binding extends ViewDataBinding {
    public final LinearLayout llContent;
    public final TextView tvContent;

    protected ItemText48Binding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.llContent = linearLayout;
        this.tvContent = textView;
    }

    public static ItemText48Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemText48Binding bind(View view, Object obj) {
        return (ItemText48Binding) bind(obj, view, 2131493044);
    }

    public static ItemText48Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemText48Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemText48Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemText48Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131493044, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemText48Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemText48Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131493044, (ViewGroup) null, false, obj);
    }
}
