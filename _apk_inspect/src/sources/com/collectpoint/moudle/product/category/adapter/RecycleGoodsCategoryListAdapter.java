package com.collectpoint.moudle.product.category.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.collectpoint.moudle.product.category.entity.GoodsListBean;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class RecycleGoodsCategoryListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<GoodsListBean.DataEntity.GoodscatrgoryEntity> dataList;
    public Context mContext;
    OnItemClickListener mOnItemClickListener;
    private int selectPosition;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView goodsCategoryName;
        public final View root;
        public final TextView shopCartNum;

        public ViewHolder(View view) {
            super(view);
            this.goodsCategoryName = (TextView) view.findViewById(2131296533);
            this.shopCartNum = (TextView) view.findViewById(2131296830);
            this.root = view;
        }
    }

    public RecycleGoodsCategoryListAdapter(List<GoodsListBean.DataEntity.GoodscatrgoryEntity> list, Context context) {
        this.dataList = list;
        this.mContext = context;
    }

    public void changeData(List<GoodsListBean.DataEntity.GoodscatrgoryEntity> list) {
        this.dataList = list;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.dataList.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.goodsCategoryName.setText(this.dataList.get(i).getName());
        viewHolder.shopCartNum.setText(String.valueOf(this.dataList.get(i).getBugNum()));
        if (this.dataList.get(i).getBugNum() > 0) {
            viewHolder.shopCartNum.setVisibility(0);
        } else {
            viewHolder.shopCartNum.setVisibility(8);
        }
        int i2 = this.selectPosition;
        if (i2 == -1) {
            viewHolder.root.setBackgroundResource(2131230948);
        } else if (i2 == i) {
            viewHolder.root.setBackgroundResource(2131230946);
        } else {
            viewHolder.root.setBackgroundResource(2131230947);
        }
        viewHolder.root.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.category.adapter.RecycleGoodsCategoryListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecycleGoodsCategoryListAdapter.this.mOnItemClickListener != null) {
                    RecycleGoodsCategoryListAdapter.this.mOnItemClickListener.onItemClick(view, i);
                }
            }
        });
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131493020, viewGroup, false));
    }

    public void setCheckPosition(int i) {
        this.selectPosition = i;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
