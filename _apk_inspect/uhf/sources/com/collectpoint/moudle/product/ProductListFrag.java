package com.collectpoint.moudle.product;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.blankj.utilcode.util.ToastUtils;
import com.chenenyu.router.Router;
import com.collectpoint.MyApp;
import com.collectpoint.bean.even.FinishActtEvent;
import com.collectpoint.bean.item.CategoryItem;
import com.collectpoint.bean.item.HallCartItem;
import com.collectpoint.bean.res.BaseListDataRes;
import com.collectpoint.bean.res.HallCartRes;
import com.collectpoint.bean.res.HallCartlistRes;
import com.collectpoint.databinding.FragProductlistfragBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.widget.popupwindow.HallCartWindow;
import com.collectpoint.widget.recycler.SSimpleRecyclerAdapter;
import com.google.common.base.Preconditions;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.widget.CustomDialogFragCompat;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class ProductListFrag extends BaseFragment implements OnRefreshListener, View.OnClickListener, HallCartWindow.OnSiteClickListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
    private HallCartWindow cartWindow;
    private GroupAdapter groupAdapter;
    private HeadAdapter headAdapter;
    private boolean isGift;
    private FragProductlistfragBinding mBinding;
    private String order_id;
    private PatrolVm patrolVm;
    private String tableName;
    private String table_id;
    private int num = 0;
    private int page = 1;
    private String catoryID = "";
    boolean isScroll = false;
    private ArrayList<Head> heads = new ArrayList<>();
    private ArrayList<HallCartItem> datas = new ArrayList<>();

    public static ProductListFrag newInstance(String table_id, String order_id, boolean isGift, String tableName) {
        ProductListFrag fragment = new ProductListFrag();
        Bundle args = new Bundle();
        args.putString("code", table_id);
        args.putString("KEY_ROLE_CODE", order_id);
        args.putBoolean("typeCode", isGift);
        args.putString("name", tableName);
        fragment.setArguments(args);
        return fragment;
    }

    protected View provideContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragProductlistfragBinding fragProductlistfragBindingInflate = DataBindingUtil.inflate(inflater, 2131492989, container, false);
        this.mBinding = fragProductlistfragBindingInflate;
        fragProductlistfragBindingInflate.setLifecycleOwner(this);
        PatrolVmFactory vmFactory = PatrolVmFactory.getInstance(MyApp.getInstance());
        this.patrolVm = ViewModelProviders.of(this, vmFactory).get(PatrolVm.class);
        init();
        return this.mBinding.getRoot();
    }

    private void init() {
        this.table_id = getArguments().getString("code");
        this.tableName = getArguments().getString("name");
        this.order_id = getArguments().getString("KEY_ROLE_CODE");
        this.isGift = getArguments().getBoolean("typeCode");
        this.headAdapter = new HeadAdapter();
        this.mBinding.lv.setAdapter((ListAdapter) this.headAdapter);
        this.groupAdapter = new GroupAdapter(getContext());
        this.mBinding.shl.setAdapter(this.groupAdapter);
        this.mBinding.lv.setOnItemClickListener(this);
        this.mBinding.shl.setOnScrollListener(this);
        this.mBinding.tvTitle.setText(this.tableName);
        this.mBinding.tvTitle.setOnClickListener(this);
        this.mBinding.tvProduceNum.setOnClickListener(this);
        this.mBinding.tvProduceNum.setBackground(BackgroundLibUtil.getDrawable(2131165560, 2131165735, 2131165560, 2131165735, 2131100237, 2131099725, 2131165785));
        this.mBinding.tvNum.setBackground(BackgroundLibUtil.getDrawable(2131165957, 2131100212));
        this.mBinding.edtSearch.addTextChangedListener(new TextWatcher() { // from class: com.collectpoint.moudle.product.ProductListFrag.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ProductListFrag.this.onLazyLoadingData();
            }
        });
        this.mBinding.edtSearch.setBackground(BackgroundLibUtil.getf0f0f0Stroke(2131165735));
        this.mBinding.edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.collectpoint.moudle.product.ProductListFrag.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == 3 || actionId == 0) {
                    String searchName = ProductListFrag.this.mBinding.edtSearch.getText().toString().trim();
                    if (!TextUtils.isEmpty(searchName)) {
                        ProductListFrag.this.closeKeyboard();
                        ProductListFrag.this.onLazyLoadingData();
                        return true;
                    }
                    ToastUtils.showShort("请输入搜索内容!");
                    return false;
                }
                return false;
            }
        });
    }

    private void setUI() {
        this.mBinding.tvProduceNum.setVisibility(this.num > 0 ? 0 : 8);
        this.mBinding.vProduceNum.setVisibility(this.num > 0 ? 0 : 8);
        this.mBinding.tvNum.setVisibility(this.num <= 0 ? 8 : 0);
    }

    protected void onLazyLoadingData() {
        this.patrolVm.hallCartList(this.table_id);
        this.patrolVm.categoryIndex();
    }

    public void onResume() {
        super.onResume();
        this.patrolVm.hallCartList(this.table_id);
    }

    protected void onInit() {
        this.patrolVm.mCategoryIndex.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ProductListFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m43lambda$onInit$0$comcollectpointmoudleproductProductListFrag((Resource) obj);
            }
        });
        this.patrolVm.mProductIndex.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ProductListFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m44lambda$onInit$1$comcollectpointmoudleproductProductListFrag((Resource) obj);
            }
        });
        this.patrolVm.mHallCartAdd.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ProductListFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m45lambda$onInit$2$comcollectpointmoudleproductProductListFrag((Resource) obj);
            }
        });
        this.patrolVm.mHallCartList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ProductListFrag$$ExternalSyntheticLambda3
            public final void onChanged(Object obj) {
                this.f$0.m46lambda$onInit$3$comcollectpointmoudleproductProductListFrag((Resource) obj);
            }
        });
    }

    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-ProductListFrag, reason: not valid java name */
    /* synthetic */ void m43lambda$onInit$0$comcollectpointmoudleproductProductListFrag(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case OrderSettleFrag.REQUEST_CODE /* 1 */:
                ArrayList<Head> arrayList = this.heads;
                if (arrayList == null) {
                    this.heads = new ArrayList<>();
                } else {
                    arrayList.clear();
                }
                if (EmptyUtils.isNotEmpty(((BaseListDataRes) result.data).getList())) {
                    for (int i = 1; i < ((List) ((BaseListDataRes) result.data).getList()).size(); i++) {
                        String namet = ((CategoryItem) ((List) ((BaseListDataRes) result.data).getList()).get(i)).getName();
                        Head item = new Head();
                        item.info = namet;
                        this.heads.add(item);
                    }
                    this.headAdapter.notifyDataSetChanged();
                }
                this.patrolVm.productIndex("0", "1", "1000", this.mBinding.edtSearch.getText().toString());
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-ProductListFrag, reason: not valid java name */
    /* synthetic */ void m44lambda$onInit$1$comcollectpointmoudleproductProductListFrag(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case OrderSettleFrag.REQUEST_CODE /* 1 */:
                ArrayList<HallCartItem> arrayList = this.datas;
                if (arrayList == null) {
                    this.datas = new ArrayList<>();
                } else {
                    arrayList.clear();
                }
                int index = 0;
                if (EmptyUtils.isNotEmpty(((HallCartRes) result.data).getList().getData())) {
                    String title = "";
                    for (int i = 0; i < ((HallCartRes) result.data).getList().getData().size(); i++) {
                        HallCartItem item = (HallCartItem) ((HallCartRes) result.data).getList().getData().get(i);
                        if (!TextUtils.equals(title, ((HallCartItem) ((HallCartRes) result.data).getList().getData().get(i)).getCategory().getName())) {
                            title = ((HallCartItem) ((HallCartRes) result.data).getList().getData().get(i)).getCategory().getName();
                            if (EmptyUtils.isNotEmpty(this.heads)) {
                                int j = index;
                                while (j < this.heads.size()) {
                                    if (TextUtils.equals(this.heads.get(j).info, title)) {
                                        index = j;
                                        this.heads.get(j).groupFirstIndex = this.datas.size();
                                        j = 2147483646;
                                    }
                                    j++;
                                }
                            }
                        }
                        item.headId = index;
                        item.headIndex = index;
                        this.datas.add(item);
                    }
                    this.groupAdapter.notifyDataSetChanged();
                    break;
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-ProductListFrag, reason: not valid java name */
    /* synthetic */ void m45lambda$onInit$2$comcollectpointmoudleproductProductListFrag(Resource result) {
        Preconditions.checkNotNull(result);
        CustomDialogFragCompat dialog = requireFragmentManager().findFragmentByTag("TAG_LOADING_DIALOG");
        if (dialog == null) {
            dialog = CustomDialogFragCompat.newTransparentLoadingDialog((String) null);
        }
        switch (result.status) {
            case 0:
                if (!dialog.isAdded()) {
                    dialog.show(requireFragmentManager(), "TAG_LOADING_DIALOG");
                    break;
                }
                break;
            case OrderSettleFrag.REQUEST_CODE /* 1 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                TextView textView = this.mBinding.tvNum;
                int i = this.num;
                textView.setText(i > 0 ? String.valueOf(i) : "0");
                setUI();
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$3$com-collectpoint-moudle-product-ProductListFrag, reason: not valid java name */
    /* synthetic */ void m46lambda$onInit$3$comcollectpointmoudleproductProductListFrag(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case OrderSettleFrag.REQUEST_CODE /* 1 */:
                this.num = 0;
                if (EmptyUtils.isNotEmpty(((HallCartlistRes) result.data).getProductList())) {
                    for (HallCartlistRes.ProductListRes listRes : ((HallCartlistRes) result.data).getProductList()) {
                        try {
                            this.num += Integer.valueOf(listRes.getProduct_num()).intValue();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                TextView textView = this.mBinding.tvNum;
                int i = this.num;
                textView.setText(i > 0 ? String.valueOf(i) : "0");
                setUI();
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                ToastUtils.showLong(result.message);
                break;
        }
    }

    public void onRefresh(RefreshLayout refreshLayout) {
        PatrolVm patrolVm = this.patrolVm;
        String str = this.catoryID;
        int i = this.page;
        this.page = i + 1;
        patrolVm.productIndex(str, String.valueOf(i), "10", this.mBinding.edtSearch.getText().toString());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        this.isScroll = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (this.isScroll) {
            HallCartItem data = this.datas.get(firstVisibleItem);
            this.headAdapter.setSelectPosition(data.headIndex);
            int firstVisiblePosition = this.mBinding.lv.getFirstVisiblePosition();
            int lastVisiblePosition = this.mBinding.lv.getLastVisiblePosition();
            if (data.headIndex >= lastVisiblePosition || data.headIndex <= firstVisiblePosition) {
                this.mBinding.lv.setSelection(data.headIndex);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.headAdapter.setSelectPosition(position);
        Head head = this.heads.get(position);
        this.mBinding.shl.setSelection(head.groupFirstIndex);
        this.isScroll = false;
    }

    private class ProductAdapter extends SSimpleRecyclerAdapter<HallCartItem> {
        public ProductAdapter(Activity activity) {
            super(activity);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x018d  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x01bd  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x01bf  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x01d2  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x01d5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindData(com.collectpoint.widget.recycler.SRecyclerViewHolder r20, int r21, final com.collectpoint.bean.item.HallCartItem r22) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 488
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.collectpoint.moudle.product.ProductListFrag.ProductAdapter.onBindData(com.collectpoint.widget.recycler.SRecyclerViewHolder, int, com.collectpoint.bean.item.HallCartItem):void");
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493092;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131297082:
                Router.build("HallCartListAct").with("code", this.table_id).with("KEY_ROLE_CODE", this.order_id).with("typeCode", Boolean.valueOf(this.isGift)).with("name", this.tableName).go(getActivity());
                break;
            case 2131297136:
                getActivity().finish();
                break;
        }
    }

    public void onAttrSubmit(String product_id, String product_num, String product_sku_id, String attr, String price, String bag_price, String feed, String describe) {
        try {
            this.num += Integer.valueOf(product_num).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        this.patrolVm.hallCartAdd(product_id, product_num, product_sku_id, attr, price, price, bag_price, this.table_id, feed, describe, this.isGift ? "1" : "0");
    }

    protected boolean subscribeEvents() {
        return true;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(FinishActtEvent event) {
        if (event != null && event.getLayer() < 2) {
            getActivity().finish();
        }
    }

    class Head {
        int groupFirstIndex;
        String info;

        Head() {
        }
    }

    private class GroupAdapter extends BaseAdapter implements StickyListHeadersAdapter {
        private LayoutInflater inflater;

        public GroupAdapter(Context context) {
            this.inflater = LayoutInflater.from(context);
        }

        public View getHeaderView(int position, View convertView, ViewGroup parent) {
            int headIndex = ((HallCartItem) ProductListFrag.this.datas.get(position)).headIndex;
            Head head = (Head) ProductListFrag.this.heads.get(headIndex);
            TextView textView = new TextView(MyApp.getContext());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, 100));
            textView.setText(head.info);
            textView.setGravity(16);
            textView.setTextColor(-16777216);
            textView.setBackgroundColor(Color.parseColor("#EBEDF0"));
            return textView;
        }

        public long getHeaderId(int position) {
            return ((HallCartItem) ProductListFrag.this.datas.get(position)).headId;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ProductListFrag.this.datas.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            return ProductListFrag.this.datas.get(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x01ce  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x01fe  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0200  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0213  */
        @Override // android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.view.View getView(int r23, android.view.View r24, android.view.ViewGroup r25) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 545
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.collectpoint.moudle.product.ProductListFrag.GroupAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }
    }

    private class HeadAdapter extends BaseAdapter {
        private int selectPosition;

        private HeadAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ProductListFrag.this.heads.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            return ProductListFrag.this.heads.get(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(MyApp.getContext());
            textView.setText(((Head) ProductListFrag.this.heads.get(position)).info);
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, 180));
            textView.setGravity(17);
            textView.setTextSize(15.0f);
            textView.setTextColor(-16777216);
            if (position == this.selectPosition) {
                textView.setBackgroundColor(-1);
            } else {
                textView.setBackgroundColor(Color.parseColor("#EBEDF0"));
            }
            return textView;
        }

        public void setSelectPosition(int selectPosition) {
            if (this.selectPosition == selectPosition) {
                return;
            }
            this.selectPosition = selectPosition;
            notifyDataSetChanged();
        }
    }
}
