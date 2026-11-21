package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemSeatBinding extends ViewDataBinding {
    public final ConstraintLayout clContent;
    public final TextView tvContent;
    public final TextView tvName;
    public final TextView tvNum;
    public final TextView tvTime;
    public final View vAdd;

    protected ItemSeatBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2) {
        super(obj, view, i);
        this.clContent = constraintLayout;
        this.tvContent = textView;
        this.tvName = textView2;
        this.tvNum = textView3;
        this.tvTime = textView4;
        this.vAdd = view2;
    }

    public static ItemSeatBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSeatBinding bind(View view, Object obj) {
        return (ItemSeatBinding) bind(obj, view, 2131493043);
    }

    public static ItemSeatBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemSeatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSeatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSeatBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493043, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemSeatBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSeatBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493043, (ViewGroup) null, false, obj);
    }
}
