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

    @Override // com.collectpoint.moudle.product.SectionedBaseAdapter
    public View getItemView(int i, int i2, View view, ViewGroup viewGroup) {
        ConstraintLayout constraintLayout = view == null ? (ConstraintLayout) ((LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater")).inflate(2131493093, (ViewGroup) null) : (ConstraintLayout) view;
        ImageView imageView = (ImageView) constraintLayout.findViewById(2131296618);
        TextView textView = (TextView) constraintLayout.findViewById(2131297058);
        TextView textView2 = (TextView) constraintLayout.findViewById(2131297077);
        TextView textView3 = (TextView) constraintLayout.findViewById(2131297143);
        TextView textView4 = (TextView) constraintLayout.findViewById(2131297093);
        TextView textView5 = (TextView) constraintLayout.findViewById(2131297088);
        textView.setText(this.produces.get(i).get(i2).getProduct_name());
        if (TextUtils.equals("1", this.produces.get(i).get(i2).getIs_promotion())) {
            textView2.setText("¥" + this.produces.get(i).get(i2).getPay_price());
            textView4.setVisibility(0);
            textView4.setBackground(BackgroundLibUtil.getf0f0f0Stroke(2131165785));
            textView5.setText("¥" + this.produces.get(i).get(i2).getLine_price() + "/" + this.produces.get(i).get(i2).getProduct_unit());
            textView5.getPaint().setFlags(16);
        } else {
            textView2.setText("¥" + this.produces.get(i).get(i2).getLine_price());
            textView4.setVisibility(8);
            textView5.setText("");
        }
        textView3.setText("/" + this.produces.get(i).get(i2).getProduct_unit());
        try {
            ImgLoaderManager.get().loadDrawable(imageView, this.produces.get(i).get(i2).getImage().get(0).getFile_path());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return constraintLayout;
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
