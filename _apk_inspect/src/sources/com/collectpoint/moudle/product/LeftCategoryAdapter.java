package com.collectpoint.moudle.product;

import android.icu.util.ULocale;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class LeftCategoryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<ULocale.Category> categoryList;
    private OnCategoryClickListener listener;

    public interface OnCategoryClickListener {
        void onCategoryClick(int i);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;

        public ViewHolder(View view) {
            super(view);
            this.categoryName = (TextView) view.findViewById(2131296968);
        }
    }

    public LeftCategoryAdapter(List<ULocale.Category> list, OnCategoryClickListener onCategoryClickListener) {
        this.categoryList = list;
        this.listener = onCategoryClickListener;
    }

    public int getItemCount() {
        return this.categoryList.size();
    }

    /* renamed from: lambda$onBindViewHolder$0$com-collectpoint-moudle-product-LeftCategoryAdapter, reason: not valid java name */
    /* synthetic */ void m193x37d22176(int i, View view) {
        OnCategoryClickListener onCategoryClickListener = this.listener;
        if (onCategoryClickListener != null) {
            onCategoryClickListener.onCategoryClick(i);
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        this.categoryList.get(i);
        viewHolder.itemView.setBackgroundColor(-1);
        viewHolder.categoryName.setTextColor(-13421773);
        viewHolder.categoryName.setBackgroundColor(-657931);
        viewHolder.itemView.setBackgroundColor(-460552);
        viewHolder.categoryName.setTextColor(-10066330);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.LeftCategoryAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m193x37d22176(i, view);
            }
        });
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131493024, viewGroup, false));
    }

    public void setSelectedPosition(int i) {
        notifyDataSetChanged();
    }
}
