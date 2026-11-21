package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.amap.api.maps.MapView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragCollectmydataFqBinding extends ViewDataBinding {
    public final ConstraintLayout clLatlon;
    public final EditText etContent;
    public final MapView flMapFrag;
    public final LinearLayout llContent;
    public final LinearLayout llName;
    public final TextView tvAddress;
    public final TextView tvEdit;
    public final TextView tvGetLol;
    public final TextView tvLat;
    public final TextView tvLon;
    public final TextView tvNavigation;
    public final TextView tvTitle;
    public final View vLine;

    protected FragCollectmydataFqBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, EditText editText, MapView mapView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, View view2) {
        super(obj, view, i);
        this.clLatlon = constraintLayout;
        this.etContent = editText;
        this.flMapFrag = mapView;
        this.llContent = linearLayout;
        this.llName = linearLayout2;
        this.tvAddress = textView;
        this.tvEdit = textView2;
        this.tvGetLol = textView3;
        this.tvLat = textView4;
        this.tvLon = textView5;
        this.tvNavigation = textView6;
        this.tvTitle = textView7;
        this.vLine = view2;
    }

    public static FragCollectmydataFqBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCollectmydataFqBinding bind(View view, Object obj) {
        return (FragCollectmydataFqBinding) bind(obj, view, 2131492967);
    }

    public static FragCollectmydataFqBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragCollectmydataFqBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCollectmydataFqBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragCollectmydataFqBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492967, viewGroup, z, obj);
    }

    @Deprecated
    public static FragCollectmydataFqBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragCollectmydataFqBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492967, (ViewGroup) null, false, obj);
    }
}
