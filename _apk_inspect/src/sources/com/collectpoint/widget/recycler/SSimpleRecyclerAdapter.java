package com.collectpoint.widget.recycler;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes13.dex */
public abstract class SSimpleRecyclerAdapter<T> extends SRecyclerAdapter<T> {
    public SSimpleRecyclerAdapter(Activity activity) {
        super(activity);
    }

    public abstract int getLayoutId(ViewGroup viewGroup, int i);

    protected View initLayoutInflater(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(getActivity()).inflate(i, viewGroup, false);
    }

    @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
    public SRecyclerViewHolder onCreateVHolder(ViewGroup viewGroup, int i) {
        return new SRecyclerViewHolder(initLayoutInflater(getLayoutId(viewGroup, i), viewGroup));
    }
}
