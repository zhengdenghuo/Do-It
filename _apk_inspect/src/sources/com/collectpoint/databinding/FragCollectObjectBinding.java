package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragCollectObjectBinding extends ViewDataBinding {
    public final TextView tvGetFrenq;
    public final TextView tvGetFrenqC;
    public final TextView tvGetStyle;
    public final TextView tvGetStyleC;
    public final TextView tvObjectFz;
    public final TextView tvObjectFzC;
    public final TextView tvObjectType;
    public final TextView tvObjectTypeC;
    public final TextView tvSubmit;

    protected FragCollectObjectBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
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

    public static FragCollectObjectBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCollectObjectBinding bind(View view, Object obj) {
        return (FragCollectObjectBinding) bind(obj, view, 2131492963);
    }

    public static FragCollectObjectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragCollectObjectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCollectObjectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragCollectObjectBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492963, viewGroup, z, obj);
    }

    @Deprecated
    public static FragCollectObjectBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragCollectObjectBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492963, (ViewGroup) null, false, obj);
    }
}
