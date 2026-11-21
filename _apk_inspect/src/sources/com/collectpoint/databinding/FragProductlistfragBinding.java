package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragProductlistfragBinding extends ViewDataBinding {
    public final EditText edtSearch;
    public final ListView lv;
    public final StickyListHeadersListView shl;
    public final TextView tvNum;
    public final TextView tvProduceNum;
    public final TextView tvTitle;
    public final View vLine;
    public final View vProduceNum;

    protected FragProductlistfragBinding(Object obj, View view, int i, EditText editText, ListView listView, StickyListHeadersListView stickyListHeadersListView, TextView textView, TextView textView2, TextView textView3, View view2, View view3) {
        super(obj, view, i);
        this.edtSearch = editText;
        this.lv = listView;
        this.shl = stickyListHeadersListView;
        this.tvNum = textView;
        this.tvProduceNum = textView2;
        this.tvTitle = textView3;
        this.vLine = view2;
        this.vProduceNum = view3;
    }

    public static FragProductlistfragBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragProductlistfragBinding bind(View view, Object obj) {
        return (FragProductlistfragBinding) bind(obj, view, 2131492989);
    }

    public static FragProductlistfragBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragProductlistfragBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragProductlistfragBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragProductlistfragBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492989, viewGroup, z, obj);
    }

    @Deprecated
    public static FragProductlistfragBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragProductlistfragBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492989, (ViewGroup) null, false, obj);
    }
}
