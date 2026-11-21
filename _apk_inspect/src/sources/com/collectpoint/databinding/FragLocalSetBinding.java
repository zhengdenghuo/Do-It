package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragLocalSetBinding extends ViewDataBinding {
    public final TextView tvGpsWd;
    public final TextView tvRtkWd;

    protected FragLocalSetBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvGpsWd = textView;
        this.tvRtkWd = textView2;
    }

    public static FragLocalSetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragLocalSetBinding bind(View view, Object obj) {
        return (FragLocalSetBinding) bind(obj, view, 2131492976);
    }

    public static FragLocalSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragLocalSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragLocalSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragLocalSetBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492976, viewGroup, z, obj);
    }

    @Deprecated
    public static FragLocalSetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragLocalSetBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492976, (ViewGroup) null, false, obj);
    }
}
