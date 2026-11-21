package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragCollectstylesetBinding extends ViewDataBinding {
    public final ConstraintLayout clStore;
    public final EditText etTimePerod;
    public final TextView tvCollectMethod;
    public final TextView tvCollectMode;
    public final TextView tvSure;
    public final TextView tvTimePerod;

    protected FragCollectstylesetBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, EditText editText, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.clStore = constraintLayout;
        this.etTimePerod = editText;
        this.tvCollectMethod = textView;
        this.tvCollectMode = textView2;
        this.tvSure = textView3;
        this.tvTimePerod = textView4;
    }

    public static FragCollectstylesetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCollectstylesetBinding bind(View view, Object obj) {
        return (FragCollectstylesetBinding) bind(obj, view, 2131492968);
    }

    public static FragCollectstylesetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragCollectstylesetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCollectstylesetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragCollectstylesetBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492968, viewGroup, z, obj);
    }

    @Deprecated
    public static FragCollectstylesetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragCollectstylesetBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492968, (ViewGroup) null, false, obj);
    }
}
