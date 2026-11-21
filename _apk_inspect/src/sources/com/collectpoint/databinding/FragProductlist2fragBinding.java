package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.moudle.product.PinnedHeaderListView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragProductlist2fragBinding extends ViewDataBinding {
    public final EditText edtSearch;
    public final ListView leftListview;
    public final PinnedHeaderListView pinnedListView;
    public final TextView tvNum;
    public final TextView tvProduceNum;
    public final TextView tvTitle;
    public final View vLine;
    public final View vProduceNum;

    protected FragProductlist2fragBinding(Object obj, View view, int i, EditText editText, ListView listView, PinnedHeaderListView pinnedHeaderListView, TextView textView, TextView textView2, TextView textView3, View view2, View view3) {
        super(obj, view, i);
        this.edtSearch = editText;
        this.leftListview = listView;
        this.pinnedListView = pinnedHeaderListView;
        this.tvNum = textView;
        this.tvProduceNum = textView2;
        this.tvTitle = textView3;
        this.vLine = view2;
        this.vProduceNum = view3;
    }

    public static FragProductlist2fragBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragProductlist2fragBinding bind(View view, Object obj) {
        return (FragProductlist2fragBinding) bind(obj, view, 2131492989);
    }

    public static FragProductlist2fragBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragProductlist2fragBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragProductlist2fragBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragProductlist2fragBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492989, viewGroup, z, obj);
    }

    @Deprecated
    public static FragProductlist2fragBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragProductlist2fragBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492989, (ViewGroup) null, false, obj);
    }
}
