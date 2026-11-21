package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragAboutBinding extends ViewDataBinding {
    public final ImageView imgPicture;
    public final TextView tvContent;
    public final TextView tvName;
    public final TextView tvVersion;

    protected FragAboutBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.imgPicture = imageView;
        this.tvContent = textView;
        this.tvName = textView2;
        this.tvVersion = textView3;
    }

    public static FragAboutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragAboutBinding bind(View view, Object obj) {
        return (FragAboutBinding) bind(obj, view, 2131492957);
    }

    public static FragAboutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragAboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragAboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragAboutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492957, viewGroup, z, obj);
    }

    @Deprecated
    public static FragAboutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragAboutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492957, (ViewGroup) null, false, obj);
    }
}
