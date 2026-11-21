package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.amap.api.maps.MapView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragPointCollectCoiledBinding extends ViewDataBinding {
    public final MapView flMapFrag;
    public final ImageView ivOperate;
    public final LinearLayout llInf0;
    public final TextView tvCollectStyle;
    public final View tvConnect;
    public final View tvData;
    public final TextView tvEnd;
    public final View tvFolow;
    public final TextView tvLatlon;
    public final View tvLayer;
    public final View tvMagnify;
    public final TextView tvPrecision;
    public final TextView tvSateStatue;
    public final TextView tvSatellite;
    public final View tvSearch;
    public final View tvSet;
    public final View tvShrink;
    public final View tvTestDis;
    public final TextView tvTitle;
    public final View vTop;

    protected FragPointCollectCoiledBinding(Object obj, View view, int i, MapView mapView, ImageView imageView, LinearLayout linearLayout, TextView textView, View view2, View view3, TextView textView2, View view4, TextView textView3, View view5, View view6, TextView textView4, TextView textView5, TextView textView6, View view7, View view8, View view9, View view10, TextView textView7, View view11) {
        super(obj, view, i);
        this.flMapFrag = mapView;
        this.ivOperate = imageView;
        this.llInf0 = linearLayout;
        this.tvCollectStyle = textView;
        this.tvConnect = view2;
        this.tvData = view3;
        this.tvEnd = textView2;
        this.tvFolow = view4;
        this.tvLatlon = textView3;
        this.tvLayer = view5;
        this.tvMagnify = view6;
        this.tvPrecision = textView4;
        this.tvSateStatue = textView5;
        this.tvSatellite = textView6;
        this.tvSearch = view7;
        this.tvSet = view8;
        this.tvShrink = view9;
        this.tvTestDis = view10;
        this.tvTitle = textView7;
        this.vTop = view11;
    }

    public static FragPointCollectCoiledBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragPointCollectCoiledBinding bind(View view, Object obj) {
        return (FragPointCollectCoiledBinding) bind(obj, view, 2131492988);
    }

    public static FragPointCollectCoiledBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragPointCollectCoiledBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragPointCollectCoiledBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragPointCollectCoiledBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492988, viewGroup, z, obj);
    }

    @Deprecated
    public static FragPointCollectCoiledBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragPointCollectCoiledBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492988, (ViewGroup) null, false, obj);
    }
}
