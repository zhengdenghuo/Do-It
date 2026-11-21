package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.maps.MapView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragLocateAddBinding extends ViewDataBinding {
    public final EditText edtSearch;
    public final MapView flMapFrag;
    public final LinearLayout llSearch;
    public final SmartRefreshLayout refreshLayout;
    public final RecyclerView rvRefreshable;
    public final TextView tvAdd;

    protected FragLocateAddBinding(Object obj, View view, int i, EditText editText, MapView mapView, LinearLayout linearLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.edtSearch = editText;
        this.flMapFrag = mapView;
        this.llSearch = linearLayout;
        this.refreshLayout = smartRefreshLayout;
        this.rvRefreshable = recyclerView;
        this.tvAdd = textView;
    }

    public static FragLocateAddBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragLocateAddBinding bind(View view, Object obj) {
        return (FragLocateAddBinding) bind(obj, view, 2131492977);
    }

    public static FragLocateAddBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragLocateAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragLocateAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragLocateAddBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492977, viewGroup, z, obj);
    }

    @Deprecated
    public static FragLocateAddBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragLocateAddBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492977, (ViewGroup) null, false, obj);
    }
}
