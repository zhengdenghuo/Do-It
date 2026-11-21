package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.amap.api.maps.MapView;
import com.collectpoint.widget.MenuView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragPointCollectBinding extends ViewDataBinding {
    public final MenuView arcMenu;
    public final MapView flMapFrag;
    public final LinearLayout llInf0;
    public final TextView tvCollectStyle;
    public final View tvConnect;
    public final View tvData;
    public final View tvFolow;
    public final TextView tvLatlon;
    public final View tvLayer;
    public final View tvMagnify;
    public final TextView tvPrecision;
    public final TextView tvSateStatue;
    public final TextView tvSatellite;
    public final View tvSearch;
    public final View tvShrink;
    public final View tvTestDis;
    public final TextView tvTitle;
    public final View vMenu;
    public final View vTop;

    protected FragPointCollectBinding(Object obj, View view, int i, MenuView menuView, MapView mapView, LinearLayout linearLayout, TextView textView, View view2, View view3, View view4, TextView textView2, View view5, View view6, TextView textView3, TextView textView4, TextView textView5, View view7, View view8, View view9, TextView textView6, View view10, View view11) {
        super(obj, view, i);
        this.arcMenu = menuView;
        this.flMapFrag = mapView;
        this.llInf0 = linearLayout;
        this.tvCollectStyle = textView;
        this.tvConnect = view2;
        this.tvData = view3;
        this.tvFolow = view4;
        this.tvLatlon = textView2;
        this.tvLayer = view5;
        this.tvMagnify = view6;
        this.tvPrecision = textView3;
        this.tvSateStatue = textView4;
        this.tvSatellite = textView5;
        this.tvSearch = view7;
        this.tvShrink = view8;
        this.tvTestDis = view9;
        this.tvTitle = textView6;
        this.vMenu = view10;
        this.vTop = view11;
    }

    public static FragPointCollectBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragPointCollectBinding bind(View view, Object obj) {
        return (FragPointCollectBinding) bind(obj, view, 2131492987);
    }

    public static FragPointCollectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragPointCollectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragPointCollectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragPointCollectBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492987, viewGroup, z, obj);
    }

    @Deprecated
    public static FragPointCollectBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragPointCollectBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492987, (ViewGroup) null, false, obj);
    }
}
