package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class SwipeMenuItemBinding extends ViewDataBinding {
    public final TextView tvLeft;

    protected SwipeMenuItemBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.tvLeft = textView;
    }

    public static SwipeMenuItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SwipeMenuItemBinding bind(View view, Object obj) {
        return (SwipeMenuItemBinding) bind(obj, view, 2131493102);
    }

    public static SwipeMenuItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static SwipeMenuItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SwipeMenuItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SwipeMenuItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493102, viewGroup, z, obj);
    }

    @Deprecated
    public static SwipeMenuItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SwipeMenuItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493102, (ViewGroup) null, false, obj);
    }
}
