package com.collectpoint.widget.recycler;

import android.os.CountDownTimer;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.disposables.Disposable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes13.dex */
public class SRecyclerViewHolder extends RecyclerView.ViewHolder {
    public CountDownTimer countDownTimer;
    public Disposable disposable;
    private SparseArray<View> mArrayView;

    public SRecyclerViewHolder(View view) {
        super(view);
    }

    public final <V extends View> V get(int i) {
        if (this.mArrayView == null) {
            this.mArrayView = new SparseArray<>();
        }
        V v = (V) this.mArrayView.get(i);
        if (v == null && (v = (V) this.itemView.findViewById(i)) != null) {
            this.mArrayView.put(i, v);
        }
        return v;
    }
}
