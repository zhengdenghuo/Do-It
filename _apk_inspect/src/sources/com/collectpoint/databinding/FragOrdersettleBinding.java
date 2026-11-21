package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.recycler.SRecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragOrdersettleBinding extends ViewDataBinding {
    public final ConstraintLayout cl1;
    public final TextView printOrder;
    public final SRecyclerView srvPayStyle;
    public final SRecyclerView srvSettleDetail;
    public final TextView tvCoupon;
    public final TextView tvCouponNum;
    public final TextView tvDiscount;
    public final TextView tvGdprice;
    public final TextView tvGivechange;
    public final TextView tvPayStyle;
    public final TextView tvProdunceList;
    public final TextView tvProdunceNum;
    public final TextView tvRemark;
    public final TextView tvRemarkT;
    public final TextView tvSettlement;
    public final TextView tvSssum;
    public final TextView tvTitle;
    public final TextView tvYsprice;
    public final View vLine;

    protected FragOrdersettleBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, SRecyclerView sRecyclerView, SRecyclerView sRecyclerView2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, View view2) {
        super(obj, view, i);
        this.cl1 = constraintLayout;
        this.printOrder = textView;
        this.srvPayStyle = sRecyclerView;
        this.srvSettleDetail = sRecyclerView2;
        this.tvCoupon = textView2;
        this.tvCouponNum = textView3;
        this.tvDiscount = textView4;
        this.tvGdprice = textView5;
        this.tvGivechange = textView6;
        this.tvPayStyle = textView7;
        this.tvProdunceList = textView8;
        this.tvProdunceNum = textView9;
        this.tvRemark = textView10;
        this.tvRemarkT = textView11;
        this.tvSettlement = textView12;
        this.tvSssum = textView13;
        this.tvTitle = textView14;
        this.tvYsprice = textView15;
        this.vLine = view2;
    }

    public static FragOrdersettleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragOrdersettleBinding bind(View view, Object obj) {
        return (FragOrdersettleBinding) bind(obj, view, 2131492986);
    }

    public static FragOrdersettleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragOrdersettleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragOrdersettleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragOrdersettleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492986, viewGroup, z, obj);
    }

    @Deprecated
    public static FragOrdersettleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragOrdersettleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492986, (ViewGroup) null, false, obj);
    }
}
