package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.recycler.SRecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class PopupNumBinding extends ViewDataBinding {
    public final EditText etContent;
    public final SRecyclerView srvContent;
    public final TextView tvConfirm;
    public final TextView tvInputNum;
    public final TextView tvNo;
    public final TextView tvOther;
    public final TextView tvTitle;

    protected PopupNumBinding(Object obj, View view, int i, EditText editText, SRecyclerView sRecyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.etContent = editText;
        this.srvContent = sRecyclerView;
        this.tvConfirm = textView;
        this.tvInputNum = textView2;
        this.tvNo = textView3;
        this.tvOther = textView4;
        this.tvTitle = textView5;
    }

    public static PopupNumBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupNumBinding bind(View view, Object obj) {
        return (PopupNumBinding) bind(obj, view, 2131493085);
    }

    public static PopupNumBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static PopupNumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupNumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupNumBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493085, viewGroup, z, obj);
    }

    @Deprecated
    public static PopupNumBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupNumBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493085, (ViewGroup) null, false, obj);
    }
}
