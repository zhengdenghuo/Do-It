package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemCheckUiBinding extends ViewDataBinding {
    public final LinearLayout llUser;
    public final TextView tvName;
    public final View vChoice;

    protected ItemCheckUiBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, View view2) {
        super(obj, view, i);
        this.llUser = linearLayout;
        this.tvName = textView;
        this.vChoice = view2;
    }

    public static ItemCheckUiBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckUiBinding bind(View view, Object obj) {
        return (ItemCheckUiBinding) bind(obj, view, 2131493012);
    }

    public static ItemCheckUiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemCheckUiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckUiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCheckUiBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493012, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemCheckUiBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCheckUiBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493012, (ViewGroup) null, false, obj);
    }
}
