package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemOrderlistBinding extends ViewDataBinding {
    public final ConstraintLayout clContent;
    public final ConstraintLayout clContentTop;
    public final TextView tvNo;
    public final TextView tvRealPrice;
    public final TextView tvStatue;
    public final TextView tvTime;
    public final TextView tvTitle;

    protected ItemOrderlistBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.clContent = constraintLayout;
        this.clContentTop = constraintLayout2;
        this.tvNo = textView;
        this.tvRealPrice = textView2;
        this.tvStatue = textView3;
        this.tvTime = textView4;
        this.tvTitle = textView5;
    }

    public static ItemOrderlistBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOrderlistBinding bind(View view, Object obj) {
        return (ItemOrderlistBinding) bind(obj, view, 2131493035);
    }

    public static ItemOrderlistBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemOrderlistBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOrderlistBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemOrderlistBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493035, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemOrderlistBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemOrderlistBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493035, (ViewGroup) null, false, obj);
    }
}
