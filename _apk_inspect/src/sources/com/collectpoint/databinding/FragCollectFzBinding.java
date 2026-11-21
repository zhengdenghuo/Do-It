package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragCollectFzBinding extends ViewDataBinding {
    public final EditText edtSearch;
    public final ImageView imgNoData;
    public final RecyclerView rvRefreshable;
    public final SmartRefreshLayout srlCommon;

    protected FragCollectFzBinding(Object obj, View view, int i, EditText editText, ImageView imageView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.edtSearch = editText;
        this.imgNoData = imageView;
        this.rvRefreshable = recyclerView;
        this.srlCommon = smartRefreshLayout;
    }

    public static FragCollectFzBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCollectFzBinding bind(View view, Object obj) {
        return (FragCollectFzBinding) bind(obj, view, 2131492962);
    }

    public static FragCollectFzBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragCollectFzBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragCollectFzBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragCollectFzBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492962, viewGroup, z, obj);
    }

    @Deprecated
    public static FragCollectFzBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragCollectFzBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492962, (ViewGroup) null, false, obj);
    }
}
