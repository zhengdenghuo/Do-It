package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class PopupPayBinding extends ViewDataBinding {
    public final EditText etContent;
    public final ImageView imgClose;
    public final EditText tvPayNum;
    public final TextView tvPrice;
    public final TextView tvPriceS;
    public final TextView tvStatue;
    public final TextView tvTitle;

    protected PopupPayBinding(Object obj, View view, int i, EditText editText, ImageView imageView, EditText editText2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.etContent = editText;
        this.imgClose = imageView;
        this.tvPayNum = editText2;
        this.tvPrice = textView;
        this.tvPriceS = textView2;
        this.tvStatue = textView3;
        this.tvTitle = textView4;
    }

    public static PopupPayBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupPayBinding bind(View view, Object obj) {
        return (PopupPayBinding) bind(obj, view, 2131493086);
    }

    public static PopupPayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static PopupPayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupPayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupPayBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493086, viewGroup, z, obj);
    }

    @Deprecated
    public static PopupPayBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupPayBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493086, (ViewGroup) null, false, obj);
    }
}
