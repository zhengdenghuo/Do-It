package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemScanPlateBinding extends ViewDataBinding {
    public final TextView tvNum;
    public final TextView tvPerPrice;
    public final TextView tvPrice;
    public final TextView tvProduceName;

    protected ItemScanPlateBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.tvNum = textView;
        this.tvPerPrice = textView2;
        this.tvPrice = textView3;
        this.tvProduceName = textView4;
    }

    public static ItemScanPlateBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemScanPlateBinding bind(View view, Object obj) {
        return (ItemScanPlateBinding) bind(obj, view, 2131493042);
    }

    public static ItemScanPlateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemScanPlateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemScanPlateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemScanPlateBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493042, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemScanPlateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemScanPlateBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493042, (ViewGroup) null, false, obj);
    }
}
