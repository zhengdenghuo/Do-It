package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.SlidingDeleteView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemOrderDetailBinding extends ViewDataBinding {
    public final ConstraintLayout layContainer;
    public final LinearLayout laySliding;
    public final SlidingDeleteView slidingview;
    public final TextView tvLeft;
    public final TextView tvNum;
    public final TextView tvPrice;
    public final TextView tvProduceCc;
    public final TextView tvProduceFix;
    public final TextView tvProduceGift;
    public final TextView tvProduceName;
    public final TextView tvProduceOptions;
    public final TextView tvProducePost;
    public final TextView tvTip;
    public final View view;

    protected ItemOrderDetailBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, LinearLayout linearLayout, SlidingDeleteView slidingDeleteView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, View view2) {
        super(obj, view, i);
        this.layContainer = constraintLayout;
        this.laySliding = linearLayout;
        this.slidingview = slidingDeleteView;
        this.tvLeft = textView;
        this.tvNum = textView2;
        this.tvPrice = textView3;
        this.tvProduceCc = textView4;
        this.tvProduceFix = textView5;
        this.tvProduceGift = textView6;
        this.tvProduceName = textView7;
        this.tvProduceOptions = textView8;
        this.tvProducePost = textView9;
        this.tvTip = textView10;
        this.view = view2;
    }

    public static ItemOrderDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOrderDetailBinding bind(View view, Object obj) {
        return (ItemOrderDetailBinding) bind(obj, view, 2131493033);
    }

    public static ItemOrderDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemOrderDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOrderDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemOrderDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493033, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemOrderDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemOrderDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493033, (ViewGroup) null, false, obj);
    }
}
