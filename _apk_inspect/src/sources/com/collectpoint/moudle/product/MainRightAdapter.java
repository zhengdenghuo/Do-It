package com.collectpoint.moudle.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.collectpoint.bean.item.CategoryItem;
import com.collectpoint.bean.item.HallCartItem;
import com.collectpoint.utils.EmptyUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class MainRightAdapter extends SectionedBaseAdapter {
    private Context mContext;
    private List<List<HallCartItem>> produces = new ArrayList();
    private List<CategoryItem> categoryItems = new ArrayList();

    public MainRightAdapter(Context context) {
        this.mContext = context;
    }

    @Override // com.collectpoint.moudle.product.SectionedBaseAdapter
    public int getCountForSection(int i) {
        return this.produces.get(i).size();
    }

    @Override // com.collectpoint.moudle.product.SectionedBaseAdapter
    public Object getItem(int i, int i2) {
        return this.produces.get(i).get(i2);
    }

    @Override // com.collectpoint.moudle.product.SectionedBaseAdapter
    public long getItemId(int i, int i2) {
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02a2  */
    @Override // com.collectpoint.moudle.product.SectionedBaseAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getItemView(int r22, int r23, android.view.View r24, android.view.ViewGroup r25) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 681
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.collectpoint.moudle.product.MainRightAdapter.getItemView(int, int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // com.collectpoint.moudle.product.SectionedBaseAdapter
    public int getSectionCount() {
        return this.produces.size();
    }

    @Override // com.collectpoint.moudle.product.SectionedBaseAdapter, com.collectpoint.moudle.product.PinnedHeaderListView.PinnedSectionedHeaderAdapter
    public View getSectionHeaderView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout = view == null ? (LinearLayout) ((LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater")).inflate(2131493001, (ViewGroup) null) : (LinearLayout) view;
        linearLayout.setClickable(false);
        ((TextView) linearLayout.findViewById(2131296905)).setText(this.categoryItems.get(i).getName());
        return linearLayout;
    }

    public void setData(List<List<HallCartItem>> list, List<CategoryItem> list2) {
        if (EmptyUtils.isEmpty(this.produces)) {
            this.produces = new ArrayList();
        }
        this.produces.clear();
        if (EmptyUtils.isNotEmpty(list)) {
            this.produces.addAll(list);
        }
        if (EmptyUtils.isEmpty(this.categoryItems)) {
            this.categoryItems = new ArrayList();
        }
        this.categoryItems.clear();
        if (EmptyUtils.isNotEmpty(list2)) {
            this.categoryItems.addAll(list2);
        }
        notifyDataSetChanged();
    }
}
