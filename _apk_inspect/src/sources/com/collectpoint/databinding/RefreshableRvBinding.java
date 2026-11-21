package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class RefreshableRvBinding extends ViewDataBinding {
    public final ImageView imgNoData;
    public final RecyclerView rvRefreshable;
    public final SmartRefreshLayout srlCommon;
    public final View vLine;

    protected RefreshableRvBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, View view2) {
        super(obj, view, i);
        this.imgNoData = imageView;
        this.rvRefreshable = recyclerView;
        this.srlCommon = smartRefreshLayout;
        this.vLine = view2;
    }

    public static RefreshableRvBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RefreshableRvBinding bind(View view, Object obj) {
        return (RefreshableRvBinding) bind(obj, view, 2131493091);
    }

    public static RefreshableRvBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static RefreshableRvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RefreshableRvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (RefreshableRvBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493091, viewGroup, z, obj);
    }

    @Deprecated
    public static RefreshableRvBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RefreshableRvBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493091, (ViewGroup) null, false, obj);
    }
}
