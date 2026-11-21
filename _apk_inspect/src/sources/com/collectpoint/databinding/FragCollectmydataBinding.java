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
public abstract class FragCollectmydataBinding extends ViewDataBinding {
    public final ConstraintLayout clLatlon;
    public final EditText etContent;
    public final MapView flMapFrag;
    public final LinearLayout llContent;
    public final LinearLayout llName;
    public final TextView tvAddress;
    public final TextView tvGetLol;
    public final TextView tvLat;
    public final TextView tvLon;
    public final TextView tvSubmit;
    public final TextView tvTitle;
    public final View vLine;

    protected FragCollectmydataBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, EditText editText, MapView mapView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view2) {
        super(obj, view, i);
        this.clLatlon = constraintLayout;
        this.etContent = editText;
        this.flMapFrag = mapView;
        this.llContent = linearLayout;
        this.llName = linearLayout2;
        this.tvAddress = textView;
        this.tvGetLol = textView2;
        this.tvLat = textView3;
        this.tvLon = textView4;
        this.tvSubmit = textView5;
        this.tvTitle = textView6;
        this.vLine = view2;
    }

    public static FragCollectmydataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCollectmydataBinding bind(View view, Object obj) {
        return (FragCollectmydataBinding) bind(obj, view, 2131492966);
    }

    public static FragCollectmydataBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragCollectmydataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCollectmydataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragCollectmydataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492966, viewGroup, z, obj);
    }

    @Deprecated
    public static FragCollectmydataBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragCollectmydataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492966, (ViewGroup) null, false, obj);
    }
}
