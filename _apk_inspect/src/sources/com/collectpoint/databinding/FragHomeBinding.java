package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.widget.recycler.SRecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragHomeBinding extends ViewDataBinding {
    public final ConstraintLayout clTop;
    public final EditText edtSearch;
    public final ImageView ivFlash;
    public final SmartRefreshLayout srlCommon;
    public final SRecyclerView srvSeat;
    public final SRecyclerView srvSeatNum;
    public final SRecyclerView srvStatus;
    public final SRecyclerView srvView;
    public final TextView tvN;
    public final TextView tvProject;
    public final View vBar;
    public final View vLeft;

    protected FragHomeBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, EditText editText, ImageView imageView, SmartRefreshLayout smartRefreshLayout, SRecyclerView sRecyclerView, SRecyclerView sRecyclerView2, SRecyclerView sRecyclerView3, SRecyclerView sRecyclerView4, TextView textView, TextView textView2, View view2, View view3) {
        super(obj, view, i);
        this.clTop = constraintLayout;
        this.edtSearch = editText;
        this.ivFlash = imageView;
        this.srlCommon = smartRefreshLayout;
        this.srvSeat = sRecyclerView;
        this.srvSeatNum = sRecyclerView2;
        this.srvStatus = sRecyclerView3;
        this.srvView = sRecyclerView4;
        this.tvN = textView;
        this.tvProject = textView2;
        this.vBar = view2;
        this.vLeft = view3;
    }

    public static FragHomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragHomeBinding bind(View view, Object obj) {
        return (FragHomeBinding) bind(obj, view, 2131492973);
    }

    public static FragHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492973, viewGroup, z, obj);
    }

    @Deprecated
    public static FragHomeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492973, (ViewGroup) null, false, obj);
    }
}
