package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.amap.api.maps.MapView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragLocationBinding extends ViewDataBinding {
    public final CardView cvSearch;
    public final View divider13;
    public final MapView flMapFrag;
    public final TextView tvSearch;

    protected FragLocationBinding(Object obj, View view, int i, CardView cardView, View view2, MapView mapView, TextView textView) {
        super(obj, view, i);
        this.cvSearch = cardView;
        this.divider13 = view2;
        this.flMapFrag = mapView;
        this.tvSearch = textView;
    }

    public static FragLocationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragLocationBinding bind(View view, Object obj) {
        return (FragLocationBinding) bind(obj, view, 2131492979);
    }

    public static FragLocationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragLocationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragLocationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragLocationBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492979, viewGroup, z, obj);
    }

    @Deprecated
    public static FragLocationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragLocationBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492979, (ViewGroup) null, false, obj);
    }
}
