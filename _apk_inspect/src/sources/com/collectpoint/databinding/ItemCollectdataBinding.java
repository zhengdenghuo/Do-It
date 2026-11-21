package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemCollectdataBinding extends ViewDataBinding {
    public final ConstraintLayout clContent;
    public final ImageView ivDele;
    public final ImageView ivNav;
    public final TextView tvAddress;
    public final TextView tvAddressT;
    public final TextView tvCollectData;
    public final TextView tvFrequency;
    public final TextView tvFrequencyT;
    public final TextView tvJwd;
    public final TextView tvLatlon;
    public final TextView tvName;
    public final TextView tvPos;
    public final TextView tvTime;
    public final TextView tvTimeT;
    public final View vL;
    public final View view4;

    protected ItemCollectdataBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, View view2, View view3) {
        super(obj, view, i);
        this.clContent = constraintLayout;
        this.ivDele = imageView;
        this.ivNav = imageView2;
        this.tvAddress = textView;
        this.tvAddressT = textView2;
        this.tvCollectData = textView3;
        this.tvFrequency = textView4;
        this.tvFrequencyT = textView5;
        this.tvJwd = textView6;
        this.tvLatlon = textView7;
        this.tvName = textView8;
        this.tvPos = textView9;
        this.tvTime = textView10;
        this.tvTimeT = textView11;
        this.vL = view2;
        this.view4 = view3;
    }

    public static ItemCollectdataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectdataBinding bind(View view, Object obj) {
        return (ItemCollectdataBinding) bind(obj, view, 2131493014);
    }

    public static ItemCollectdataBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemCollectdataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectdataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCollectdataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493014, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemCollectdataBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCollectdataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493014, (ViewGroup) null, false, obj);
    }
}
