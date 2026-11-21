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
public abstract class PopupSettleremarkBinding extends ViewDataBinding {
    public final EditText etRemark;
    public final ImageView imgClose;
    public final TagFlowLayout tag;
    public final TextView tvConfirm;
    public final TextView tvRemark;
    public final TextView tvTitle;

    protected PopupSettleremarkBinding(Object obj, View view, int i, EditText editText, ImageView imageView, TagFlowLayout tagFlowLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.etRemark = editText;
        this.imgClose = imageView;
        this.tag = tagFlowLayout;
        this.tvConfirm = textView;
        this.tvRemark = textView2;
        this.tvTitle = textView3;
    }

    public static PopupSettleremarkBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupSettleremarkBinding bind(View view, Object obj) {
        return (PopupSettleremarkBinding) bind(obj, view, 2131493089);
    }

    public static PopupSettleremarkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static PopupSettleremarkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupSettleremarkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupSettleremarkBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493089, viewGroup, z, obj);
    }

    @Deprecated
    public static PopupSettleremarkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupSettleremarkBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493089, (ViewGroup) null, false, obj);
    }
}
