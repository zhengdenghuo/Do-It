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
public abstract class PopupPayXjBinding extends ViewDataBinding {
    public final EditText etContent;
    public final ImageView imgClose;
    public final TextView tvCancel;
    public final TextView tvConfirm;
    public final TextView tvPrice;
    public final TextView tvPriceS;
    public final TextView tvTitle;

    protected PopupPayXjBinding(Object obj, View view, int i, EditText editText, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.etContent = editText;
        this.imgClose = imageView;
        this.tvCancel = textView;
        this.tvConfirm = textView2;
        this.tvPrice = textView3;
        this.tvPriceS = textView4;
        this.tvTitle = textView5;
    }

    public static PopupPayXjBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupPayXjBinding bind(View view, Object obj) {
        return (PopupPayXjBinding) bind(obj, view, 2131493088);
    }

    public static PopupPayXjBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static PopupPayXjBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupPayXjBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupPayXjBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493088, viewGroup, z, obj);
    }

    @Deprecated
    public static PopupPayXjBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupPayXjBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493088, (ViewGroup) null, false, obj);
    }
}
