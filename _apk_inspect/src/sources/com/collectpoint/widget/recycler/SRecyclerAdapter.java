package com.collectpoint.widget.recycler;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ObjectUtils;
import com.collectpoint.widget.recycler.callback.OnItemClickListener;
import com.collectpoint.widget.recycler.callback.OnItemLongClickListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes13.dex */
public abstract class SRecyclerAdapter<T> extends RecyclerView.Adapter<SRecyclerViewHolder> {
    protected Activity activity;
    protected List<T> list;
    protected OnItemClickListener<T> onItemClickListener;
    protected OnItemLongClickListener<T> onItemLongClickListener;

    public SRecyclerAdapter(Activity activity) {
        this.activity = activity;
    }

    private void onBindViewData(SRecyclerViewHolder sRecyclerViewHolder, int i) {
        onBindData(sRecyclerViewHolder, i, getItem(i));
    }

    public void clearData() {
        List<T> list = this.list;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }

    public Activity getActivity() {
        return this.activity;
    }

    public int getCount() {
        List<T> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T getItem(int i) {
        List<T> list = this.list;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    public int getItemCount() {
        List<T> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<T> getList() {
        return this.list;
    }

    public abstract void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, T t);

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((SRecyclerViewHolder) viewHolder, i, (List<Object>) list);
    }

    public void onBindViewHolder(SRecyclerViewHolder sRecyclerViewHolder, int i) {
        onBindViewData(sRecyclerViewHolder, i);
    }

    public void onBindViewHolder(SRecyclerViewHolder sRecyclerViewHolder, int i, List<Object> list) {
        onBindViewData(sRecyclerViewHolder, i);
    }

    public abstract SRecyclerViewHolder onCreateVHolder(ViewGroup viewGroup, int i);

    public SRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateVHolder(viewGroup, i);
    }

    public void setData(List<T> list) {
        if (this.list == null) {
            this.list = new ArrayList();
        }
        this.list.clear();
        if (!ObjectUtils.isEmpty(list)) {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setData(List<T> list, int i) {
        if (this.list == null) {
            this.list = new ArrayList();
        }
        if (i == 1) {
            this.list.clear();
        }
        if (!ObjectUtils.isEmpty(list)) {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setDataWithSize(List<T> list, int i) {
        if (list == null) {
            list = new ArrayList();
        }
        List<T> list2 = this.list;
        if (list2 != null) {
            list2.clear();
        } else {
            this.list = new ArrayList();
        }
        if (list == null) {
            i = 0;
        } else if (i > list.size()) {
            i = list.size();
        }
        for (int i2 = 0; i2 < i; i2++) {
            this.list.add(list.get(i2));
        }
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener<T> onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
}
