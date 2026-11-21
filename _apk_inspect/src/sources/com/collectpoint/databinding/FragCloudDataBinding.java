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
public abstract class FragCloudDataBinding extends ViewDataBinding {
    public final ImageView imgNoData;
    public final RecyclerView rvRefreshable;
    public final SmartRefreshLayout srlCommon;
    public final TextView tvRegion;
    public final TextView tvType;
    public final View vLine;

    protected FragCloudDataBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.imgNoData = imageView;
        this.rvRefreshable = recyclerView;
        this.srlCommon = smartRefreshLayout;
        this.tvRegion = textView;
        this.tvType = textView2;
        this.vLine = view2;
    }

    public static FragCloudDataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCloudDataBinding bind(View view, Object obj) {
        return (FragCloudDataBinding) bind(obj, view, 2131492960);
    }

    public static FragCloudDataBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragCloudDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCloudDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragCloudDataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492960, viewGroup, z, obj);
    }

    @Deprecated
    public static FragCloudDataBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragCloudDataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492960, (ViewGroup) null, false, obj);
    }
}
