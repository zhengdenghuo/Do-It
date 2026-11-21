package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ActMainBinding extends ViewDataBinding {
    public final View divider18;
    public final TabItem tiHomePage;
    public final TabItem tiMsg;
    public final TabLayout tlMain;
    public final ViewPager vpMain;

    protected ActMainBinding(Object obj, View view, int i, View view2, TabItem tabItem, TabItem tabItem2, TabLayout tabLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.divider18 = view2;
        this.tiHomePage = tabItem;
        this.tiMsg = tabItem2;
        this.tlMain = tabLayout;
        this.vpMain = viewPager;
    }

    public static ActMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActMainBinding bind(View view, Object obj) {
        return (ActMainBinding) bind(obj, view, 2131492893);
    }

    public static ActMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ActMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActMainBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492893, viewGroup, z, obj);
    }

    @Deprecated
    public static ActMainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActMainBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492893, (ViewGroup) null, false, obj);
    }
}
