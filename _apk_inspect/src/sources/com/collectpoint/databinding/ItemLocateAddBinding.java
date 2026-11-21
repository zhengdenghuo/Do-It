package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemLocateAddBinding extends ViewDataBinding {
    public final ImageView imgPicture;
    public final TextView tvAddress;
    public final TextView tvTitle;

    protected ItemLocateAddBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.imgPicture = imageView;
        this.tvAddress = textView;
        this.tvTitle = textView2;
    }

    public static ItemLocateAddBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLocateAddBinding bind(View view, Object obj) {
        return (ItemLocateAddBinding) bind(obj, view, 2131493025);
    }

    public static ItemLocateAddBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemLocateAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLocateAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLocateAddBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493025, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemLocateAddBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLocateAddBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493025, (ViewGroup) null, false, obj);
    }
}
