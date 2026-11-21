package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemCheckTableBinding extends ViewDataBinding {
    public final TextView tvContent;

    protected ItemCheckTableBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.tvContent = textView;
    }

    public static ItemCheckTableBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckTableBinding bind(View view, Object obj) {
        return (ItemCheckTableBinding) bind(obj, view, 2131493011);
    }

    public static ItemCheckTableBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemCheckTableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckTableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCheckTableBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493011, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemCheckTableBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCheckTableBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493011, (ViewGroup) null, false, obj);
    }
}
