package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragLayerBinding extends ViewDataBinding {
    public final TextView tvGdslt;
    public final TextView tvGdwxt;
    public final TextView tvSave;
    public final View vGdslt;
    public final View vGdwxt;

    protected FragLayerBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, View view2, View view3) {
        super(obj, view, i);
        this.tvGdslt = textView;
        this.tvGdwxt = textView2;
        this.tvSave = textView3;
        this.vGdslt = view2;
        this.vGdwxt = view3;
    }

    public static FragLayerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragLayerBinding bind(View view, Object obj) {
        return (FragLayerBinding) bind(obj, view, 2131492974);
    }

    public static FragLayerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragLayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragLayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragLayerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492974, viewGroup, z, obj);
    }

    @Deprecated
    public static FragLayerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragLayerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492974, (ViewGroup) null, false, obj);
    }
}
