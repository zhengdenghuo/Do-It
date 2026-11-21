package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.bottomscroll.SlideBottomLayout;
import com.collectpoint.widget.recycler.SRecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragOrderdetailBinding extends ViewDataBinding {
    public final ConstraintLayout nsvBo;
    public final SlideBottomLayout slideLayout;
    public final SRecyclerView srvOrder;
    public final TextView tvAddMenu;
    public final TextView tvCheckAcount;
    public final TextView tvEditMealNum;
    public final TextView tvGive;
    public final TextView tvLine2;
    public final TextView tvMerge;
    public final TextView tvNum;
    public final TextView tvSmartScan;
    public final TextView tvSum;
    public final TextView tvSwitchTask;
    public final TextView tvTitle;
    public final View vLine;

    protected FragOrderdetailBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, SlideBottomLayout slideBottomLayout, SRecyclerView sRecyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, View view2) {
        super(obj, view, i);
        this.nsvBo = constraintLayout;
        this.slideLayout = slideBottomLayout;
        this.srvOrder = sRecyclerView;
        this.tvAddMenu = textView;
        this.tvCheckAcount = textView2;
        this.tvEditMealNum = textView3;
        this.tvGive = textView4;
        this.tvLine2 = textView5;
        this.tvMerge = textView6;
        this.tvNum = textView7;
        this.tvSmartScan = textView8;
        this.tvSum = textView9;
        this.tvSwitchTask = textView10;
        this.tvTitle = textView11;
        this.vLine = view2;
    }

    public static FragOrderdetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragOrderdetailBinding bind(View view, Object obj) {
        return (FragOrderdetailBinding) bind(obj, view, 2131492983);
    }

    public static FragOrderdetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragOrderdetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragOrderdetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragOrderdetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492983, viewGroup, z, obj);
    }

    @Deprecated
    public static FragOrderdetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragOrderdetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492983, (ViewGroup) null, false, obj);
    }
}
