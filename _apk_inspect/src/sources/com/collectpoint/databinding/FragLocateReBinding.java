package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.maps.MapView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragLocateReBinding extends ViewDataBinding {
    public final EditText edtSearch;
    public final MapView flMapFrag;
    public final ImageView ivCopy;
    public final ConstraintLayout llLatlon;
    public final LinearLayout llSearch;
    public final SmartRefreshLayout refreshLayout;
    public final RecyclerView rvRefreshable;
    public final TextView tvCancel;
    public final TextView tvLat;
    public final TextView tvLon;
    public final TextView tvSubmit;

    protected FragLocateReBinding(Object obj, View view, int i, EditText editText, MapView mapView, ImageView imageView, ConstraintLayout constraintLayout, LinearLayout linearLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.edtSearch = editText;
        this.flMapFrag = mapView;
        this.ivCopy = imageView;
        this.llLatlon = constraintLayout;
        this.llSearch = linearLayout;
        this.refreshLayout = smartRefreshLayout;
        this.rvRefreshable = recyclerView;
        this.tvCancel = textView;
        this.tvLat = textView2;
        this.tvLon = textView3;
        this.tvSubmit = textView4;
    }

    public static FragLocateReBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragLocateReBinding bind(View view, Object obj) {
        return (FragLocateReBinding) bind(obj, view, 2131492978);
    }

    public static FragLocateReBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragLocateReBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragLocateReBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragLocateReBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492978, viewGroup, z, obj);
    }

    @Deprecated
    public static FragLocateReBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragLocateReBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492978, (ViewGroup) null, false, obj);
    }
}
