package com.collectpoint.moudle.product.category.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.collectpoint.moudle.product.category.entity.GoodsListBean;
import com.eowise.recyclerview.stickyheaders.StickyHeadersAdapter;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class BigramHeaderAdapter implements StickyHeadersAdapter<ViewHolder> {
    private List<GoodsListBean.DataEntity.GoodscatrgoryEntity.GoodsitemEntity> dataList;
    private List<GoodsListBean.DataEntity.GoodscatrgoryEntity> goodscatrgoryEntities;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvGoodsItemTitle;

        public ViewHolder(View view) {
            super(view);
            this.tvGoodsItemTitle = (TextView) view.findViewById(2131296947);
        }
    }

    public BigramHeaderAdapter(Context context, List<GoodsListBean.DataEntity.GoodscatrgoryEntity.GoodsitemEntity> list, List<GoodsListBean.DataEntity.GoodscatrgoryEntity> list2) {
        this.mContext = context;
        this.dataList = list;
        this.goodscatrgoryEntities = list2;
    }

    public long getHeaderId(int i) {
        return this.dataList.get(i).getId();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvGoodsItemTitle.setText(this.goodscatrgoryEntities.get(this.dataList.get(i).getId()).getName());
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131493000, viewGroup, false));
    }
}
