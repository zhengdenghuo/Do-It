package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ActivityMineBinding extends ViewDataBinding {
    public final FrameLayout flContainer;
    public final ImageView ivBack;

    protected ActivityMineBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView) {
        super(obj, view, i);
        this.flContainer = frameLayout;
        this.ivBack = imageView;
    }

    public static ActivityMineBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMineBinding bind(View view, Object obj) {
        return (ActivityMineBinding) bind(obj, view, 2131492900);
    }

    public static ActivityMineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityMineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMineBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492900, viewGroup, z, obj);
    }

    @Deprecated
    public static ActivityMineBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMineBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492900, (ViewGroup) null, false, obj);
    }
}
