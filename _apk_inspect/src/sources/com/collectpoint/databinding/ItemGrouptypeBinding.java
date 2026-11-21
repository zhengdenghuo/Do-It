package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemGrouptypeBinding extends ViewDataBinding {
    public final TextView tvMt;

    protected ItemGrouptypeBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.tvMt = textView;
    }

    public static ItemGrouptypeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGrouptypeBinding bind(View view, Object obj) {
        return (ItemGrouptypeBinding) bind(obj, view, 2131493021);
    }

    public static ItemGrouptypeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemGrouptypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGrouptypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGrouptypeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493021, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemGrouptypeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGrouptypeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493021, (ViewGroup) null, false, obj);
    }
}
