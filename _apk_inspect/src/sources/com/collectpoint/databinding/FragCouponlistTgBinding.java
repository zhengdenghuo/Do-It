package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.recycler.SRecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragCouponlistTgBinding extends ViewDataBinding {
    public final EditText etDouyin;
    public final ImageView ivClose;
    public final SRecyclerView srvDy;
    public final SRecyclerView srvOrder;
    public final SRecyclerView srvPayStyle;
    public final TextView tvDyRed;
    public final TextView tvDytitle;
    public final TextView tvEmpty;
    public final TextView tvHeyan;
    public final TextView tvSubmint;
    public final TextView tvT1;
    public final TextView tvT2;
    public final TextView tvTitle;
    public final View vLine;

    protected FragCouponlistTgBinding(Object obj, View view, int i, EditText editText, ImageView imageView, SRecyclerView sRecyclerView, SRecyclerView sRecyclerView2, SRecyclerView sRecyclerView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view2) {
        super(obj, view, i);
        this.etDouyin = editText;
        this.ivClose = imageView;
        this.srvDy = sRecyclerView;
        this.srvOrder = sRecyclerView2;
        this.srvPayStyle = sRecyclerView3;
        this.tvDyRed = textView;
        this.tvDytitle = textView2;
        this.tvEmpty = textView3;
        this.tvHeyan = textView4;
        this.tvSubmint = textView5;
        this.tvT1 = textView6;
        this.tvT2 = textView7;
        this.tvTitle = textView8;
        this.vLine = view2;
    }

    public static FragCouponlistTgBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCouponlistTgBinding bind(View view, Object obj) {
        return (FragCouponlistTgBinding) bind(obj, view, 2131492970);
    }

    public static FragCouponlistTgBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragCouponlistTgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCouponlistTgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragCouponlistTgBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492970, viewGroup, z, obj);
    }

    @Deprecated
    public static FragCouponlistTgBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragCouponlistTgBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492970, (ViewGroup) null, false, obj);
    }
}
