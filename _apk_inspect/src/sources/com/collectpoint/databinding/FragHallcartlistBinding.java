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
public abstract class FragHallcartlistBinding extends ViewDataBinding {
    public final EditText etRemark;
    public final TextView rbNocd;
    public final SRecyclerView srvOrder;
    public final TextView tvClear;
    public final TextView tvNum;
    public final TextView tvSubmint;
    public final TextView tvSum;
    public final TextView tvTitle;
    public final View vLine;

    protected FragHallcartlistBinding(Object obj, View view, int i, EditText editText, TextView textView, SRecyclerView sRecyclerView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view2) {
        super(obj, view, i);
        this.etRemark = editText;
        this.rbNocd = textView;
        this.srvOrder = sRecyclerView;
        this.tvClear = textView2;
        this.tvNum = textView3;
        this.tvSubmint = textView4;
        this.tvSum = textView5;
        this.tvTitle = textView6;
        this.vLine = view2;
    }

    public static FragHallcartlistBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragHallcartlistBinding bind(View view, Object obj) {
        return (FragHallcartlistBinding) bind(obj, view, 2131492972);
    }

    public static FragHallcartlistBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragHallcartlistBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragHallcartlistBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragHallcartlistBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492972, viewGroup, z, obj);
    }

    @Deprecated
    public static FragHallcartlistBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragHallcartlistBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492972, (ViewGroup) null, false, obj);
    }
}
