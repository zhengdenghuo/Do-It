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
public abstract class ItemTobedealBinding extends ViewDataBinding {
    public final ConstraintLayout clContent;
    public final ConstraintLayout clContentTop;
    public final TextView tv1;
    public final TextView tv2;
    public final TextView tv3;
    public final TextView tvCloud;
    public final TextView tvDis;
    public final TextView tvPerson;
    public final TextView tvReason;
    public final TextView tvRecollect;
    public final TextView tvRoadName;
    public final TextView tvTime;
    public final TextView tvTitle;
    public final ImageView vCloud;
    public final View vLine;

    protected ItemTobedealBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, ImageView imageView, View view2) {
        super(obj, view, i);
        this.clContent = constraintLayout;
        this.clContentTop = constraintLayout2;
        this.tv1 = textView;
        this.tv2 = textView2;
        this.tv3 = textView3;
        this.tvCloud = textView4;
        this.tvDis = textView5;
        this.tvPerson = textView6;
        this.tvReason = textView7;
        this.tvRecollect = textView8;
        this.tvRoadName = textView9;
        this.tvTime = textView10;
        this.tvTitle = textView11;
        this.vCloud = imageView;
        this.vLine = view2;
    }

    public static ItemTobedealBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTobedealBinding bind(View view, Object obj) {
        return (ItemTobedealBinding) bind(obj, view, 2131493046);
    }

    public static ItemTobedealBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemTobedealBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTobedealBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTobedealBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493046, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemTobedealBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTobedealBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493046, (ViewGroup) null, false, obj);
    }
}
