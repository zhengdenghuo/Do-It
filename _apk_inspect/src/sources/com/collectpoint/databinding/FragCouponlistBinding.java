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
public abstract class FragCouponlistBinding extends ViewDataBinding {
    public final EditText etSeachPhone;
    public final SRecyclerView srvOrder;
    public final TextView tvCancel;
    public final TextView tvEmpty;
    public final TextView tvHint;
    public final TextView tvSearch;
    public final TextView tvSubmint;
    public final TextView tvTitle;
    public final View vLine;

    protected FragCouponlistBinding(Object obj, View view, int i, EditText editText, SRecyclerView sRecyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view2) {
        super(obj, view, i);
        this.etSeachPhone = editText;
        this.srvOrder = sRecyclerView;
        this.tvCancel = textView;
        this.tvEmpty = textView2;
        this.tvHint = textView3;
        this.tvSearch = textView4;
        this.tvSubmint = textView5;
        this.tvTitle = textView6;
        this.vLine = view2;
    }

    public static FragCouponlistBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCouponlistBinding bind(View view, Object obj) {
        return (FragCouponlistBinding) bind(obj, view, 2131492969);
    }

    public static FragCouponlistBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragCouponlistBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCouponlistBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragCouponlistBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492969, viewGroup, z, obj);
    }

    @Deprecated
    public static FragCouponlistBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragCouponlistBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492969, (ViewGroup) null, false, obj);
    }
}
