package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemTodayCollectBinding extends ViewDataBinding {
    public final TextView tvCollect;
    public final TextView tvCollectManner;
    public final TextView tvCollectStatue;
    public final TextView tvObject;

    protected ItemTodayCollectBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.tvCollect = textView;
        this.tvCollectManner = textView2;
        this.tvCollectStatue = textView3;
        this.tvObject = textView4;
    }

    public static ItemTodayCollectBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTodayCollectBinding bind(View view, Object obj) {
        return (ItemTodayCollectBinding) bind(obj, view, 2131493047);
    }

    public static ItemTodayCollectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemTodayCollectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTodayCollectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTodayCollectBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493047, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemTodayCollectBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTodayCollectBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493047, (ViewGroup) null, false, obj);
    }
}
