package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.recycler.SRecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragOrderdetailHomeBinding extends ViewDataBinding {
    public final View ivPic;
    public final LinearLayout llBgTop;
    public final LinearLayout llPayList;
    public final SRecyclerView srvOrder;
    public final SRecyclerView srvSettleDetail;
    public final SRecyclerView srvSettleDetail2;
    public final TextView tv11;
    public final TextView tv12;
    public final TextView tv13;
    public final TextView tv14;
    public final TextView tvExpand;
    public final TextView tvExpandSs;
    public final TextView tvInfo;
    public final TextView tvLevel;
    public final TextView tvPrice;
    public final TextView tvPrint;
    public final TextView tvProducePrice;
    public final TextView tvRemark;
    public final TextView tvTableNo;
    public final TextView tvTableNum;
    public final TextView tvTele;
    public final TextView tvTitle;
    public final View vLine;

    protected FragOrderdetailHomeBinding(Object obj, View view, int i, View view2, LinearLayout linearLayout, LinearLayout linearLayout2, SRecyclerView sRecyclerView, SRecyclerView sRecyclerView2, SRecyclerView sRecyclerView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, View view3) {
        super(obj, view, i);
        this.ivPic = view2;
        this.llBgTop = linearLayout;
        this.llPayList = linearLayout2;
        this.srvOrder = sRecyclerView;
        this.srvSettleDetail = sRecyclerView2;
        this.srvSettleDetail2 = sRecyclerView3;
        this.tv11 = textView;
        this.tv12 = textView2;
        this.tv13 = textView3;
        this.tv14 = textView4;
        this.tvExpand = textView5;
        this.tvExpandSs = textView6;
        this.tvInfo = textView7;
        this.tvLevel = textView8;
        this.tvPrice = textView9;
        this.tvPrint = textView10;
        this.tvProducePrice = textView11;
        this.tvRemark = textView12;
        this.tvTableNo = textView13;
        this.tvTableNum = textView14;
        this.tvTele = textView15;
        this.tvTitle = textView16;
        this.vLine = view3;
    }

    public static FragOrderdetailHomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragOrderdetailHomeBinding bind(View view, Object obj) {
        return (FragOrderdetailHomeBinding) bind(obj, view, 2131492984);
    }

    public static FragOrderdetailHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragOrderdetailHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragOrderdetailHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragOrderdetailHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492984, viewGroup, z, obj);
    }

    @Deprecated
    public static FragOrderdetailHomeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragOrderdetailHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492984, (ViewGroup) null, false, obj);
    }
}
