package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.recycler.SRecyclerView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragCollectdataBinding extends ViewDataBinding {
    public final ImageView ivEdit;
    public final SRecyclerView revList;
    public final TextView tvFrequency;
    public final TextView tvFrequencyC;
    public final TextView tvGetLatlon;
    public final TextView tvLatlon;
    public final TextView tvObjectFz;
    public final TextView tvObjectType;
    public final TextView tvSubmit;

    protected FragCollectdataBinding(Object obj, View view, int i, ImageView imageView, SRecyclerView sRecyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.ivEdit = imageView;
        this.revList = sRecyclerView;
        this.tvFrequency = textView;
        this.tvFrequencyC = textView2;
        this.tvGetLatlon = textView3;
        this.tvLatlon = textView4;
        this.tvObjectFz = textView5;
        this.tvObjectType = textView6;
        this.tvSubmit = textView7;
    }

    public static FragCollectdataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCollectdataBinding bind(View view, Object obj) {
        return (FragCollectdataBinding) bind(obj, view, 2131492965);
    }

    public static FragCollectdataBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragCollectdataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCollectdataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragCollectdataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492965, viewGroup, z, obj);
    }

    @Deprecated
    public static FragCollectdataBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragCollectdataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492965, (ViewGroup) null, false, obj);
    }
}
