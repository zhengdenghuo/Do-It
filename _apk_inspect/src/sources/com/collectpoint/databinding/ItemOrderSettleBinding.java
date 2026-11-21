package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemOrderSettleBinding extends ViewDataBinding {
    public final TextView tvNum;
    public final TextView tvPrice;
    public final TextView tvProduceName;
    public final TextView tvProduceOptions;

    protected ItemOrderSettleBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.tvNum = textView;
        this.tvPrice = textView2;
        this.tvProduceName = textView3;
        this.tvProduceOptions = textView4;
    }

    public static ItemOrderSettleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOrderSettleBinding bind(View view, Object obj) {
        return (ItemOrderSettleBinding) bind(obj, view, 2131493034);
    }

    public static ItemOrderSettleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemOrderSettleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOrderSettleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemOrderSettleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493034, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemOrderSettleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemOrderSettleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493034, (ViewGroup) null, false, obj);
    }
}
