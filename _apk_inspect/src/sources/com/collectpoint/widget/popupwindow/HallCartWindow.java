package com.collectpoint.widget.popupwindow;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.MyApp;
import com.collectpoint.bean.item.AttributeItem;
import com.collectpoint.bean.item.HallCartItem;
import com.collectpoint.databinding.PopupHallcartBinding;
import com.collectpoint.utils.AlphaUtils;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.BitmapMemoryCache;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.widget.recycler.SRecyclerView;
import com.collectpoint.widget.recycler.SRecyclerViewHolder;
import com.collectpoint.widget.recycler.SSelectedRecyclerAdapter;
import com.collectpoint.widget.recycler.SSimpleRecyclerAdapter;
import com.liuwq.base.image.ImgLoaderManager;
import com.liuwq.base.recyclerview.GridSpacesItemDecoration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class HallCartWindow extends PopupWindow implements View.OnClickListener {
    private Activity activity;
    private HallCartItem datas;
    private FeedAdapter feedAdapter;
    private ProduceAdapter mAdapter;
    private PopupHallcartBinding mBinding;
    private View mContentView;
    private OnSiteClickListener mListener;
    private ProduceDoubleAdapter produceDoubleAdapter;
    private SkuAdapter skuAdapter;
    private List<String> attr = new ArrayList();
    private List<String> describe = new ArrayList();

    private class AttrAdapter extends SSelectedRecyclerAdapter<AttributeItem> {
        private int postion1;

        public AttrAdapter(Activity activity) {
            super(activity);
        }

        public int getAttr() {
            if (getList() == null) {
                return 0;
            }
            for (int i = 0; i < getList().size(); i++) {
                if (((AttributeItem) getList().get(i)).isSelected()) {
                    return i;
                }
            }
            return 0;
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493044;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, final int i, final AttributeItem attributeItem) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131296983);
            textView.setText(attributeItem.getName());
            textView.setBackground(attributeItem.isSelected() ? BackgroundLibUtil.getBlue(2131165623) : BackgroundLibUtil.get333333Stroke(2131165623));
            textView.setTextColor(ContextCompat.getColor(MyApp.getContext(), attributeItem.isSelected() ? 2131100237 : 2131099824));
            sRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.widget.popupwindow.HallCartWindow.AttrAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AttrAdapter.this.selectItem(i);
                    HallCartWindow.this.describe.set(AttrAdapter.this.postion1, attributeItem.getName());
                    HallCartWindow.this.attr.set(AttrAdapter.this.postion1, String.valueOf(i));
                    HallCartWindow.this.choicetextShow();
                }
            });
        }

        public void setPostion(int i) {
            this.postion1 = i;
        }
    }

    private class FeedAdapter extends SSelectedRecyclerAdapter<HallCartItem.FeedRes> {
        public FeedAdapter(Activity activity) {
            super(activity);
        }

        public String getFeedDes() {
            String str = "";
            if (getList() != null) {
                for (int i = 0; i < getList().size(); i++) {
                    if (((HallCartItem.FeedRes) getList().get(i)).isSelected()) {
                        str = str + "," + ((HallCartItem.FeedRes) getList().get(i)).getFeed_name();
                    }
                }
            }
            return EmptyUtils.isNotEmpty(str) ? str.substring(1) : "";
        }

        public double getFeedPrice() {
            double dDoubleValue = 0.0d;
            if (getList() != null) {
                for (int i = 0; i < getList().size(); i++) {
                    if (((HallCartItem.FeedRes) getList().get(i)).isSelected() || ((HallCartItem.FeedRes) getList().get(i)).isSelected()) {
                        try {
                            dDoubleValue += Double.valueOf(((HallCartItem.FeedRes) getList().get(i)).getPrice()).doubleValue();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return dDoubleValue;
        }

        public String getFeedStr() {
            String str = "";
            if (getList() != null) {
                for (int i = 0; i < getList().size(); i++) {
                    if (((HallCartItem.FeedRes) getList().get(i)).isSelected()) {
                        str = str + "," + i;
                    }
                }
            }
            return EmptyUtils.isNotEmpty(str) ? str.substring(1) : "";
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493044;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, final int i, HallCartItem.FeedRes feedRes) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131296983);
            int iIntValue = 0;
            try {
                iIntValue = Integer.valueOf(feedRes.getStock_num()).intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
            textView.setText(feedRes.getFeed_name() + " ¥" + feedRes.getPrice());
            textView.setBackground(iIntValue < 1 ? BackgroundLibUtil.get999999(2131165623) : feedRes.isSelected() ? BackgroundLibUtil.getBlue(2131165623) : BackgroundLibUtil.get333333Stroke(2131165623));
            textView.setTextColor(ContextCompat.getColor(MyApp.getContext(), feedRes.isSelected() ? 2131100237 : 2131099824));
            final int i2 = iIntValue;
            sRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.widget.popupwindow.HallCartWindow.FeedAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i2 < 1) {
                        ToastUtils.showLong("已售罄");
                    } else {
                        FeedAdapter.this.selectItem(i);
                        HallCartWindow.this.choicetextShow();
                    }
                }
            });
        }
    }

    private class FeedDoubledapter extends SSelectedRecyclerAdapter<HallCartItem.FeedRes> {
        public FeedDoubledapter(Activity activity) {
            super(activity);
        }

        public String getFeedDes() {
            String str = "";
            if (getList() != null) {
                for (int i = 0; i < getList().size(); i++) {
                    if (((HallCartItem.FeedRes) getList().get(i)).isSelected() || TextUtils.equals("1", ((HallCartItem.FeedRes) getList().get(i)).getIs_select())) {
                        str = str + "," + ((HallCartItem.FeedRes) getList().get(i)).getFeed_name();
                    }
                }
            }
            return EmptyUtils.isNotEmpty(str) ? str.substring(1) : "";
        }

        public double getFeedPrice() {
            double dDoubleValue = 0.0d;
            if (getList() != null) {
                for (int i = 0; i < getList().size(); i++) {
                    if (((HallCartItem.FeedRes) getList().get(i)).isSelected() || TextUtils.equals("1", ((HallCartItem.FeedRes) getList().get(i)).getIs_select())) {
                        try {
                            dDoubleValue += Double.valueOf(((HallCartItem.FeedRes) getList().get(i)).getPrice()).doubleValue();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return dDoubleValue;
        }

        public String getFeedStr() {
            String str = "";
            if (getList() != null) {
                for (int i = 0; i < getList().size(); i++) {
                    if (((HallCartItem.FeedRes) getList().get(i)).isSelected() || TextUtils.equals("1", ((HallCartItem.FeedRes) getList().get(i)).getIs_select())) {
                        str = str + "," + i;
                    }
                }
            }
            return EmptyUtils.isNotEmpty(str) ? str.substring(1) : "";
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493044;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, final int i, HallCartItem.FeedRes feedRes) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131296983);
            textView.setText(feedRes.getFeed_name() + " ¥" + feedRes.getPrice());
            textView.setBackground((feedRes.isSelected() || TextUtils.equals("1", feedRes.getIs_select())) ? BackgroundLibUtil.getBlue(2131165623) : BackgroundLibUtil.get333333Stroke(2131165623));
            textView.setTextColor(ContextCompat.getColor(MyApp.getContext(), (feedRes.isSelected() || TextUtils.equals("1", feedRes.getIs_select())) ? 2131100237 : 2131099824));
            sRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.widget.popupwindow.HallCartWindow.FeedDoubledapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FeedDoubledapter.this.selectItem(i);
                    HallCartWindow.this.choicetextShow();
                }
            });
        }
    }

    public interface OnSiteClickListener {
        void onAttrSubmit(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    private class ProduceAdapter extends SSimpleRecyclerAdapter<HallCartItem.ProductAttrRes> {
        public ProduceAdapter(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493040;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, HallCartItem.ProductAttrRes productAttrRes) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297056);
            SRecyclerView sRecyclerView = (SRecyclerView) sRecyclerViewHolder.get(2131296775);
            textView.setText(productAttrRes.getAttribute_name());
            if (EmptyUtils.isNotEmpty(productAttrRes.getAttribute_value())) {
                AttrAdapter attrAdapter = HallCartWindow.this.new AttrAdapter(this.activity);
                attrAdapter.setPostion(i);
                attrAdapter.setMode(SSelectedRecyclerAdapter.SelectedMode.SINGLE_MUST_ONE_SELECTED);
                sRecyclerView.setAdapter(attrAdapter);
                sRecyclerView.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
                sRecyclerView.addItemDecoration(new GridSpacesItemDecoration(10));
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = productAttrRes.getAttribute_value().iterator();
                while (it.hasNext()) {
                    arrayList.add(new AttributeItem(it.next()));
                }
                attrAdapter.setDataClear(arrayList);
            }
        }
    }

    private class ProduceDoubleAdapter extends SSimpleRecyclerAdapter<HallCartItem.ProductFeedDoubleRes> {
        public ProduceDoubleAdapter(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493040;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, HallCartItem.ProductFeedDoubleRes productFeedDoubleRes) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297056);
            SRecyclerView sRecyclerView = (SRecyclerView) sRecyclerViewHolder.get(2131296775);
            textView.setText(productFeedDoubleRes.getName());
            if (EmptyUtils.isNotEmpty(productFeedDoubleRes.getChildren())) {
                FeedDoubledapter feedDoubledapter = HallCartWindow.this.new FeedDoubledapter(this.activity);
                feedDoubledapter.setMode(SSelectedRecyclerAdapter.SelectedMode.SINGLE);
                sRecyclerView.setAdapter(feedDoubledapter);
                sRecyclerView.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
                sRecyclerView.addItemDecoration(new GridSpacesItemDecoration(10));
                feedDoubledapter.setDataClear(productFeedDoubleRes.getChildren());
            }
        }
    }

    private class SkuAdapter extends SSelectedRecyclerAdapter<HallCartItem.SkuRes> {
        public SkuAdapter(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493044;
        }

        public int getSkuPostion() {
            if (getList() == null) {
                return 0;
            }
            for (int i = 0; i < getList().size(); i++) {
                if (((HallCartItem.SkuRes) getList().get(i)).isSelected()) {
                    return i;
                }
            }
            return 0;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, final int i, HallCartItem.SkuRes skuRes) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131296983);
            textView.setText(skuRes.getSpec_name() + " ¥" + skuRes.getProduct_price());
            int iIntValue = 0;
            try {
                iIntValue = Integer.valueOf(skuRes.getStock_num()).intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
            textView.setBackground(iIntValue < 1 ? BackgroundLibUtil.get999999(2131165623) : skuRes.isSelected() ? BackgroundLibUtil.getBlue(2131165623) : BackgroundLibUtil.get333333Stroke(2131165623));
            textView.setTextColor(ContextCompat.getColor(MyApp.getContext(), skuRes.isSelected() ? 2131100237 : 2131099824));
            final int i2 = iIntValue;
            sRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.widget.popupwindow.HallCartWindow.SkuAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i2 < 1) {
                        ToastUtils.showLong("已售罄");
                    } else {
                        SkuAdapter.this.selectItem(i);
                        HallCartWindow.this.choicetextShow();
                    }
                }
            });
        }
    }

    public HallCartWindow(Activity activity, HallCartItem hallCartItem, OnSiteClickListener onSiteClickListener) throws NumberFormatException {
        this.activity = activity;
        this.mListener = onSiteClickListener;
        this.datas = hallCartItem;
        View viewInflate = View.inflate(activity, 2131493083, null);
        this.mContentView = viewInflate;
        this.mBinding = PopupHallcartBinding.bind(viewInflate);
        init();
        setData();
        setPopupWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void choicetextShow() {
        String strSubstring = "已选:";
        if (TextUtils.equals("1", this.datas.getIs_double_portion()) && EmptyUtils.isNotEmpty(this.produceDoubleAdapter.getList())) {
            for (HallCartItem.ProductFeedDoubleRes productFeedDoubleRes : this.produceDoubleAdapter.getList()) {
                if (EmptyUtils.isNotEmpty(productFeedDoubleRes.getChildren())) {
                    for (HallCartItem.FeedRes feedRes : productFeedDoubleRes.getChildren()) {
                        if (TextUtils.equals("1", feedRes.getIs_select()) || feedRes.isSelected()) {
                            strSubstring = strSubstring + feedRes.getFeed_name() + ",";
                        }
                    }
                }
            }
        }
        if (EmptyUtils.isNotEmpty(this.datas.getSku())) {
            int iIntValue = 0;
            try {
                iIntValue = Integer.valueOf(this.datas.getSku().get(this.skuAdapter.getSkuPostion()).getStock_num()).intValue();
            } catch (Exception e) {
            }
            if (iIntValue > 0) {
                strSubstring = strSubstring + this.datas.getSku().get(this.skuAdapter.getSkuPostion()).getSpec_name() + ",";
            }
        }
        if (EmptyUtils.isNotEmpty(this.describe)) {
            Iterator<String> it = this.describe.iterator();
            while (it.hasNext()) {
                strSubstring = strSubstring + it.next() + ",";
            }
        }
        FeedAdapter feedAdapter = this.feedAdapter;
        if (feedAdapter != null && EmptyUtils.isNotEmpty(feedAdapter.getFeedDes())) {
            strSubstring = strSubstring + this.feedAdapter.getFeedDes() + ",";
        }
        if (EmptyUtils.isNotEmpty(this.attr)) {
            Iterator<String> it2 = this.attr.iterator();
            while (it2.hasNext()) {
                strSubstring = strSubstring + it2.next() + ",";
            }
        }
        if (strSubstring.endsWith(",")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        if (strSubstring.endsWith(",")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        this.mBinding.tvChoice.setText(strSubstring);
    }

    private void init() {
        this.mBinding.rvDouble.setLayoutManager(new LinearLayoutManager(this.activity, 1, false));
        this.produceDoubleAdapter = new ProduceDoubleAdapter(this.activity);
        this.mBinding.rvDouble.setAdapter(this.produceDoubleAdapter);
        this.mBinding.rvSku.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
        SkuAdapter skuAdapter = new SkuAdapter(this.activity);
        this.skuAdapter = skuAdapter;
        skuAdapter.setMode(SSelectedRecyclerAdapter.SelectedMode.SINGLE_MUST_ONE_SELECTED);
        this.mBinding.rvSku.setAdapter(this.skuAdapter);
        this.mBinding.rvSku.addItemDecoration(new GridSpacesItemDecoration(10));
        this.mBinding.rvRefreshable.setLayoutManager(new LinearLayoutManager(this.activity, 1, false));
        this.mAdapter = new ProduceAdapter(this.activity);
        this.mBinding.rvRefreshable.setAdapter(this.mAdapter);
        this.mBinding.rvFeed.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
        FeedAdapter feedAdapter = new FeedAdapter(this.activity);
        this.feedAdapter = feedAdapter;
        feedAdapter.setMode(SSelectedRecyclerAdapter.SelectedMode.MULTI);
        this.mBinding.rvFeed.setAdapter(this.feedAdapter);
        this.mBinding.rvFeed.addItemDecoration(new GridSpacesItemDecoration(10));
        this.mBinding.imgClose.setOnClickListener(this);
        this.mBinding.tvConfirm.setOnClickListener(this);
        this.mBinding.tvCancel.setOnClickListener(this);
    }

    private void setData() throws NumberFormatException {
        int i;
        this.mBinding.tvSellingPoint.setText(this.datas.getSelling_point());
        if (TextUtils.equals("1", this.datas.getIs_double_portion())) {
            this.produceDoubleAdapter.setData(this.datas.getProduct_feed_double());
        }
        this.mAdapter.setData(this.datas.getProduct_attr());
        this.mBinding.tvName.setText(this.datas.getProduct_name());
        this.mBinding.tvPrice.setText("单价:¥" + this.datas.getLine_price() + "单位" + this.datas.getProduct_unit());
        try {
            i = Integer.parseInt(this.datas.getMin_buy());
        } catch (Exception e) {
            i = 1;
        }
        if (i > 1) {
            this.mBinding.etContent.setText(BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
            this.mBinding.ivAdd.setVisibility(8);
            this.mBinding.tvStartNum.setVisibility(0);
            this.mBinding.tvStartNum.setBackground(BackgroundLibUtil.getBlue(2131165623));
            this.mBinding.tvStartNum.setText(i + this.datas.getProduct_unit() + "起点");
        } else {
            this.mBinding.etContent.setText("1");
            this.mBinding.tvStartNum.setVisibility(8);
            this.mBinding.ivAdd.setVisibility(0);
        }
        try {
            ImgLoaderManager.get().loadDrawable(this.mBinding.ivProduct, this.datas.getImage().get(0).getFile_path());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (EmptyUtils.isNotEmpty(this.datas.getSku()) && EmptyUtils.isNotEmpty(this.datas.getSku().get(0).getSpec_name())) {
            this.mBinding.tvGg.setVisibility(0);
            this.mBinding.rvSku.setVisibility(0);
            this.skuAdapter.setDataClear(this.datas.getSku());
        }
        if (EmptyUtils.isNotEmpty(this.datas.getProduct_attr())) {
            for (HallCartItem.ProductAttrRes productAttrRes : this.datas.getProduct_attr()) {
                this.attr.add(BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
                if (EmptyUtils.isNotEmpty(productAttrRes.getAttribute_value())) {
                    this.describe.add(productAttrRes.getAttribute_value().get(0));
                } else {
                    this.describe.add("");
                }
            }
        }
        if (EmptyUtils.isNotEmpty(this.datas.getProduct_attr())) {
            for (HallCartItem.ProductAttrRes productAttrRes2 : this.datas.getProduct_attr()) {
                this.attr.add(BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
                if (EmptyUtils.isNotEmpty(productAttrRes2.getAttribute_value())) {
                    this.describe.add(productAttrRes2.getAttribute_value().get(0));
                } else {
                    this.describe.add("");
                }
            }
        }
        if (EmptyUtils.isNotEmpty(this.datas.getProduct_feed()) && EmptyUtils.isNotEmpty(this.datas.getProduct_feed().get(0).getFeed_name())) {
            this.mBinding.tvFeed.setVisibility(0);
            this.mBinding.rvFeed.setVisibility(0);
            this.feedAdapter.setDataClear(this.datas.getProduct_feed());
        }
        final int i2 = i;
        this.mBinding.tvStartNum.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.widget.popupwindow.HallCartWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws NumberFormatException {
                int i3 = 1;
                try {
                    i3 = Integer.parseInt(HallCartWindow.this.mBinding.etContent.getText().toString());
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                if (i3 < i2) {
                    HallCartWindow.this.mBinding.etContent.setText(String.valueOf(i2));
                } else {
                    HallCartWindow.this.mBinding.etContent.setText(String.valueOf(i3 + 1));
                }
                HallCartWindow.this.mBinding.tvStartNum.setVisibility(8);
                HallCartWindow.this.mBinding.ivAdd.setVisibility(0);
            }
        });
        this.mBinding.ivAdd.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.widget.popupwindow.HallCartWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws NumberFormatException {
                int i3 = 1;
                try {
                    i3 = Integer.parseInt(HallCartWindow.this.mBinding.etContent.getText().toString());
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                int i4 = i3 + 1;
                HallCartWindow.this.mBinding.etContent.setText(String.valueOf(i4 >= 1 ? i4 : 1));
            }
        });
        this.mBinding.ivSub.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.widget.popupwindow.HallCartWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws NumberFormatException {
                int i3 = 1;
                try {
                    i3 = Integer.parseInt(HallCartWindow.this.mBinding.etContent.getText().toString());
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                if (i3 > i2) {
                    HallCartWindow.this.mBinding.etContent.setText(String.valueOf(i3 - 1));
                    HallCartWindow.this.mBinding.tvStartNum.setVisibility(8);
                    HallCartWindow.this.mBinding.ivAdd.setVisibility(0);
                    return;
                }
                HallCartWindow.this.mBinding.etContent.setText(BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
                if (i2 <= 1) {
                    HallCartWindow.this.mBinding.tvStartNum.setVisibility(8);
                    HallCartWindow.this.mBinding.ivAdd.setVisibility(0);
                } else {
                    HallCartWindow.this.mBinding.ivAdd.setVisibility(8);
                    HallCartWindow.this.mBinding.tvStartNum.setVisibility(0);
                    HallCartWindow.this.mBinding.tvStartNum.setBackground(BackgroundLibUtil.getBlue(2131165623));
                    HallCartWindow.this.mBinding.tvStartNum.setText(i2 + HallCartWindow.this.datas.getProduct_unit() + "起点");
                }
            }
        });
        choicetextShow();
    }

    private void setPopupWindow() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = (displayMetrics.widthPixels * 6) / 7;
        setHeight(-2);
        setWidth(i);
        setContentView(this.mContentView);
        setOutsideTouchable(false);
        setFocusable(true);
        setTouchable(true);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        AlphaUtils.backgroundAlpha(this.activity, 1.0f);
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0107  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r20) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.collectpoint.widget.popupwindow.HallCartWindow.onClick(android.view.View):void");
    }

    public void show(View view) {
        if (isShowing()) {
            return;
        }
        AlphaUtils.backgroundAlpha(this.activity, 0.5f);
        showAtLocation(view, 17, 0, 0);
        this.mBinding.etContent.requestFocus();
    }
}
