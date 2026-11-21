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
        void onCategoryClick(int position);
    }

    public LeftCategoryAdapter(List<ULocale.Category> categoryList, OnCategoryClickListener listener) {
        this.categoryList = categoryList;
        this.listener = listener;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(2131493024, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, final int position) {
        this.categoryList.get(position);
        holder.itemView.setBackgroundColor(-1);
        holder.categoryName.setTextColor(-13421773);
        holder.categoryName.setBackgroundColor(-657931);
        holder.itemView.setBackgroundColor(-460552);
        holder.categoryName.setTextColor(-10066330);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.LeftCategoryAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m14x37d22176(position, view);
            }
        });
    }

    /* renamed from: lambda$onBindViewHolder$0$com-collectpoint-moudle-product-LeftCategoryAdapter, reason: not valid java name */
    /* synthetic */ void m14x37d22176(int position, View v) {
        OnCategoryClickListener onCategoryClickListener = this.listener;
        if (onCategoryClickListener != null) {
            onCategoryClickListener.onCategoryClick(position);
        }
    }

    public int getItemCount() {
        return this.categoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;

        public ViewHolder(View itemView) {
            super(itemView);
            this.categoryName = (TextView) itemView.findViewById(2131296968);
        }
    }

    public void setSelectedPosition(int position) {
        notifyDataSetChanged();
    }
}
