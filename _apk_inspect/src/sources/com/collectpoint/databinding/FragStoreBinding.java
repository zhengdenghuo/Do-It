package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.NoScrollViewPager;
import com.google.android.material.tabs.TabLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragStoreBinding extends ViewDataBinding {
    public final ImageView ivSearch;
    public final TabLayout tlMain;
    public final View vBar;
    public final NoScrollViewPager vpMain;

    protected FragStoreBinding(Object obj, View view, int i, ImageView imageView, TabLayout tabLayout, View view2, NoScrollViewPager noScrollViewPager) {
        super(obj, view, i);
        this.ivSearch = imageView;
        this.tlMain = tabLayout;
        this.vBar = view2;
        this.vpMain = noScrollViewPager;
    }

    public static FragStoreBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragStoreBinding bind(View view, Object obj) {
        return (FragStoreBinding) bind(obj, view, 2131492994);
    }

    public static FragStoreBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragStoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragStoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragStoreBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492994, viewGroup, z, obj);
    }

    @Deprecated
    public static FragStoreBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragStoreBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492994, (ViewGroup) null, false, obj);
    }
}
