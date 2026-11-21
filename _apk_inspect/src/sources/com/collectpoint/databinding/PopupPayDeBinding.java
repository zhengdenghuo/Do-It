package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class PopupPayDeBinding extends ViewDataBinding {
    public final EditText etContent;
    public final EditText etRemark;
    public final ImageView imgClose;
    public final TagFlowLayout tag;
    public final TextView tvConfirm;
    public final TextView tvPrice;
    public final TextView tvPriceS;
    public final TextView tvRemark;
    public final TextView tvTitle;

    protected PopupPayDeBinding(Object obj, View view, int i, EditText editText, EditText editText2, ImageView imageView, TagFlowLayout tagFlowLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.etContent = editText;
        this.etRemark = editText2;
        this.imgClose = imageView;
        this.tag = tagFlowLayout;
        this.tvConfirm = textView;
        this.tvPrice = textView2;
        this.tvPriceS = textView3;
        this.tvRemark = textView4;
        this.tvTitle = textView5;
    }

    public static PopupPayDeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupPayDeBinding bind(View view, Object obj) {
        return (PopupPayDeBinding) bind(obj, view, 2131493087);
    }

    public static PopupPayDeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static PopupPayDeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupPayDeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupPayDeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493087, viewGroup, z, obj);
    }

    @Deprecated
    public static PopupPayDeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupPayDeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493087, (ViewGroup) null, false, obj);
    }
}
