package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragCollectTypeBinding extends ViewDataBinding {
    public final TextView tvGetFrenq;
    public final TextView tvGetFrenqC;
    public final TextView tvGetStyle;
    public final TextView tvGetStyleC;
    public final TextView tvObjectFz;
    public final TextView tvObjectFzC;
    public final TextView tvObjectType;
    public final TextView tvObjectTypeC;
    public final TextView tvSubmit;

    protected FragCollectTypeBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        super(obj, view, i);
        this.tvGetFrenq = textView;
        this.tvGetFrenqC = textView2;
        this.tvGetStyle = textView3;
        this.tvGetStyleC = textView4;
        this.tvObjectFz = textView5;
        this.tvObjectFzC = textView6;
        this.tvObjectType = textView7;
        this.tvObjectTypeC = textView8;
        this.tvSubmit = textView9;
    }

    public static FragCollectTypeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCollectTypeBinding bind(View view, Object obj) {
        return (FragCollectTypeBinding) bind(obj, view, 2131492964);
    }

    public static FragCollectTypeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragCollectTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCollectTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragCollectTypeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492964, viewGroup, z, obj);
    }

    @Deprecated
    public static FragCollectTypeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragCollectTypeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492964, (ViewGroup) null, false, obj);
    }
}
