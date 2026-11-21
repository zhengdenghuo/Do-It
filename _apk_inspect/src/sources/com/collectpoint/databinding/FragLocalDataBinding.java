package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragLocalDataBinding extends ViewDataBinding {
    public final ImageView imgNoData;
    public final RecyclerView rvRefreshable;
    public final SmartRefreshLayout srlCommon;
    public final TextView tvCloud;
    public final View vLine;

    protected FragLocalDataBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView, View view2) {
        super(obj, view, i);
        this.imgNoData = imageView;
        this.rvRefreshable = recyclerView;
        this.srlCommon = smartRefreshLayout;
        this.tvCloud = textView;
        this.vLine = view2;
    }

    public static FragLocalDataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragLocalDataBinding bind(View view, Object obj) {
        return (FragLocalDataBinding) bind(obj, view, 2131492975);
    }

    public static FragLocalDataBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragLocalDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragLocalDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragLocalDataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492975, viewGroup, z, obj);
    }

    @Deprecated
    public static FragLocalDataBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragLocalDataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492975, (ViewGroup) null, false, obj);
    }
}
