package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ItemPictureBinding extends ViewDataBinding {
    public final ImageView imgType;
    public final ImageView ivAdd;
    public final ImageView ivAvatar;
    public final ImageView ivDelete;
    public final RelativeLayout rlContent;

    protected ItemPictureBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.imgType = imageView;
        this.ivAdd = imageView2;
        this.ivAvatar = imageView3;
        this.ivDelete = imageView4;
        this.rlContent = relativeLayout;
    }

    public static ItemPictureBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPictureBinding bind(View view, Object obj) {
        return (ItemPictureBinding) bind(obj, view, 2131493037);
    }

    public static ItemPictureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemPictureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPictureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPictureBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493037, viewGroup, z, obj);
    }

    @Deprecated
    public static ItemPictureBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPictureBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131493037, (ViewGroup) null, false, obj);
    }
}
