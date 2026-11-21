package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.maps.MapView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragCoiledPointBinding extends ViewDataBinding {
    public final MapView flMapFrag;
    public final RecyclerView rvRefreshable;

    protected FragCoiledPointBinding(Object obj, View view, int i, MapView mapView, RecyclerView recyclerView) {
        super(obj, view, i);
        this.flMapFrag = mapView;
        this.rvRefreshable = recyclerView;
    }

    public static FragCoiledPointBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCoiledPointBinding bind(View view, Object obj) {
        return (FragCoiledPointBinding) bind(obj, view, 2131492961);
    }

    public static FragCoiledPointBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragCoiledPointBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCoiledPointBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragCoiledPointBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492961, viewGroup, z, obj);
    }

    @Deprecated
    public static FragCoiledPointBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragCoiledPointBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492961, (ViewGroup) null, false, obj);
    }
}
