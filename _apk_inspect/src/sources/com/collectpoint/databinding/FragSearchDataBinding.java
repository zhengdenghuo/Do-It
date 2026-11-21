package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.NoScrollViewPager;
import com.google.android.material.tabs.TabLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragSearchDataBinding extends ViewDataBinding {
    public final EditText edtSearch;
    public final ImageView ivLeft;
    public final TabLayout tlMain;
    public final NoScrollViewPager vpMain;

    protected FragSearchDataBinding(Object obj, View view, int i, EditText editText, ImageView imageView, TabLayout tabLayout, NoScrollViewPager noScrollViewPager) {
        super(obj, view, i);
        this.edtSearch = editText;
        this.ivLeft = imageView;
        this.tlMain = tabLayout;
        this.vpMain = noScrollViewPager;
    }

    public static FragSearchDataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragSearchDataBinding bind(View view, Object obj) {
        return (FragSearchDataBinding) bind(obj, view, 2131492993);
    }

    public static FragSearchDataBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragSearchDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragSearchDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragSearchDataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492993, viewGroup, z, obj);
    }

    @Deprecated
    public static FragSearchDataBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragSearchDataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492993, (ViewGroup) null, false, obj);
    }
}
