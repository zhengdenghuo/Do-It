package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemCollectRecordBinding extends ViewDataBinding {
    public final TextView tv1;
    public final TextView tv2;
    public final TextView tv3;
    public final TextView tvDis;
    public final TextView tvRoadName;
    public final TextView tvTime;

    protected ItemCollectRecordBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.tv1 = textView;
        this.tv2 = textView2;
        this.tv3 = textView3;
        this.tvDis = textView4;
        this.tvRoadName = textView5;
        this.tvTime = textView6;
    }

    public static ItemCollectRecordBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectRecordBinding bind(View view, Object obj) {
        return (ItemCollectRecordBinding) bind(obj, view, 2131493013);
    }

    public static ItemCollectRecordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemCollectRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCollectRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493013, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemCollectRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCollectRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493013, (ViewGroup) null, false, obj);
    }
}
