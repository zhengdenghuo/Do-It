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

    public void setData(List<List<HallCartItem>> categoryItems, List<CategoryItem> categorys) {
        if (EmptyUtils.isEmpty(this.produces)) {
            this.produces = new ArrayList();
        }
        this.produces.clear();
        if (EmptyUtils.isNotEmpty(categoryItems)) {
            this.produces.addAll(categoryItems);
        }
        if (EmptyUtils.isEmpty(this.categoryItems)) {
            this.categoryItems = new ArrayList();
        }
        this.categoryItems.clear();
        if (EmptyUtils.isNotEmpty(categorys)) {
            this.categoryItems.addAll(categorys);
        }
        notifyDataSetChanged();
    }

    @Override // com.collectpoint.moudle.product.SectionedBaseAdapter
    public Object getItem(int section, int position) {
        return this.produces.get(section).get(position);
    }

    @Override // com.collectpoint.moudle.product.SectionedBaseAdapter
    public long getItemId(int section, int position) {
        return position;
    }

    @Override // com.collectpoint.moudle.product.SectionedBaseAdapter
    public int getSectionCount() {
        return this.produces.size();
    }

    @Override // com.collectpoint.moudle.product.SectionedBaseAdapter
    public int getCountForSection(int section) {
        return this.produces.get(section).size();
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
    public android.view.View getItemView(final int r22, final int r23, android.view.View r24, android.view.ViewGroup r25) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 681
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.collectpoint.moudle.product.MainRightAdapter.getItemView(int, int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // com.collectpoint.moudle.product.SectionedBaseAdapter, com.collectpoint.moudle.product.PinnedHeaderListView.PinnedSectionedHeaderAdapter
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
        LinearLayout layout;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext().getSystemService("layout_inflater");
            layout = (LinearLayout) inflator.inflate(2131493001, (ViewGroup) null);
        } else {
            layout = (LinearLayout) convertView;
        }
        layout.setClickable(false);
        ((TextView) layout.findViewById(2131296905)).setText(this.categoryItems.get(section).getName());
        return layout;
    }
}
