package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.CircleImageView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragMineBinding extends ViewDataBinding {
    public final TextView btnLogOut;
    public final CircleImageView ivAvatar;
    public final TextView textView;
    public final TextView tvAbout;
    public final TextView tvCache;
    public final TextView tvChangePwd;
    public final TextView tvId;
    public final TextView tvName;
    public final TextView tvVersion;
    public final TextView tvVersionName;
    public final View vHeadPic;
    public final View viewBar;

    protected FragMineBinding(Object obj, View view, int i, TextView textView, CircleImageView circleImageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, View view2, View view3) {
        super(obj, view, i);
        this.btnLogOut = textView;
        this.ivAvatar = circleImageView;
        this.textView = textView2;
        this.tvAbout = textView3;
        this.tvCache = textView4;
        this.tvChangePwd = textView5;
        this.tvId = textView6;
        this.tvName = textView7;
        this.tvVersion = textView8;
        this.tvVersionName = textView9;
        this.vHeadPic = view2;
        this.viewBar = view3;
    }

    public static FragMineBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragMineBinding bind(View view, Object obj) {
        return (FragMineBinding) bind(obj, view, 2131492980);
    }

    public static FragMineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragMineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragMineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragMineBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492980, viewGroup, z, obj);
    }

    @Deprecated
    public static FragMineBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragMineBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492980, (ViewGroup) null, false, obj);
    }
}
