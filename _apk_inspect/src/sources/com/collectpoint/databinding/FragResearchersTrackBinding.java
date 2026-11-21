package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.NoScrollViewPager;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragResearchersTrackBinding extends ViewDataBinding {
    public final View divider18;
    public final TabItem tiLocation;
    public final TabItem tiSol;
    public final TabLayout tlMain;
    public final NoScrollViewPager vpMain;

    protected FragResearchersTrackBinding(Object obj, View view, int i, View view2, TabItem tabItem, TabItem tabItem2, TabLayout tabLayout, NoScrollViewPager noScrollViewPager) {
        super(obj, view, i);
        this.divider18 = view2;
        this.tiLocation = tabItem;
        this.tiSol = tabItem2;
        this.tlMain = tabLayout;
        this.vpMain = noScrollViewPager;
    }

    public static FragResearchersTrackBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragResearchersTrackBinding bind(View view, Object obj) {
        return (FragResearchersTrackBinding) bind(obj, view, 2131492990);
    }

    public static FragResearchersTrackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragResearchersTrackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragResearchersTrackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragResearchersTrackBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492990, viewGroup, z, obj);
    }

    @Deprecated
    public static FragResearchersTrackBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragResearchersTrackBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492990, (ViewGroup) null, false, obj);
    }
}
