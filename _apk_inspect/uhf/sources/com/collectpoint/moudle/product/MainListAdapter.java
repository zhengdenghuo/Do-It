package com.collectpoint.moudle.product;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.collectpoint.bean.item.CategoryItem;
import com.collectpoint.bean.item.HallCartItem;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.EmptyUtils;
import com.liuwq.base.image.ImgLoaderManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class MainListAdapter extends SectionedBaseAdapter {
    private Context mContext;
    private List<List<HallCartItem>> produces = new ArrayList();
    private List<CategoryItem> categoryItems = new ArrayList();

    public MainListAdapter(Context context) {
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

    @Override // com.collectpoint.moudle.product.SectionedBaseAdapter
    public View getItemView(final int section, final int position, View convertView, ViewGroup parent) {
        ConstraintLayout layout;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext().getSystemService("layout_inflater");
            ConstraintLayout layout2 = (ConstraintLayout) inflator.inflate(2131493093, (ViewGroup) null);
            layout = layout2;
        } else {
            ConstraintLayout layout3 = (ConstraintLayout) convertView;
            layout = layout3;
        }
        ImageView iv_product = (ImageView) layout.findViewById(2131296618);
        TextView tv_name = (TextView) layout.findViewById(2131297058);
        TextView tv_price = (TextView) layout.findViewById(2131297077);
        TextView tv_unit = (TextView) layout.findViewById(2131297143);
        TextView tv_promotion_lable = (TextView) layout.findViewById(2131297093);
        TextView tv_product_price = (TextView) layout.findViewById(2131297088);
        tv_name.setText(this.produces.get(section).get(position).getProduct_name());
        if (TextUtils.equals("1", this.produces.get(section).get(position).getIs_promotion())) {
            tv_price.setText("¥" + this.produces.get(section).get(position).getPay_price());
            tv_promotion_lable.setVisibility(0);
            tv_promotion_lable.setBackground(BackgroundLibUtil.getf0f0f0Stroke(2131165785));
            tv_product_price.setText("¥" + this.produces.get(section).get(position).getLine_price() + "/" + this.produces.get(section).get(position).getProduct_unit());
            tv_product_price.getPaint().setFlags(16);
        } else {
            tv_price.setText("¥" + this.produces.get(section).get(position).getLine_price());
            tv_promotion_lable.setVisibility(8);
            tv_product_price.setText("");
        }
        tv_unit.setText("/" + this.produces.get(section).get(position).getProduct_unit());
        try {
            ImgLoaderManager.get().loadDrawable(iv_product, ((HallCartItem.ImageRes) this.produces.get(section).get(position).getImage().get(0)).getFile_path());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return layout;
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
