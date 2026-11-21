package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.NoScrollViewPager;
import com.google.android.material.tabs.TabLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragOrderBinding extends ViewDataBinding {
    public final EditText edtSearch;
    public final TabLayout tlMain;
    public final TextView tvProject;
    public final View vBar;
    public final View vTop;
    public final NoScrollViewPager vpMain;

    protected FragOrderBinding(Object obj, View view, int i, EditText editText, TabLayout tabLayout, TextView textView, View view2, View view3, NoScrollViewPager noScrollViewPager) {
        super(obj, view, i);
        this.edtSearch = editText;
        this.tlMain = tabLayout;
        this.tvProject = textView;
        this.vBar = view2;
        this.vTop = view3;
        this.vpMain = noScrollViewPager;
    }

    public static FragOrderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragOrderBinding bind(View view, Object obj) {
        return (FragOrderBinding) bind(obj, view, 2131492981);
    }

    public static FragOrderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragOrderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragOrderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragOrderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492981, viewGroup, z, obj);
    }

    @Deprecated
    public static FragOrderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragOrderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492981, (ViewGroup) null, false, obj);
    }
}
