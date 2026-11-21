package com.collectpoint.moudle.product;

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
import com.collectpoint.bean.res.HallCartRes;
import com.collectpoint.bean.res.HallCartlistRes;
import com.collectpoint.databinding.FragProductlist2fragBinding;
import com.collectpoint.moudle.product.PinnedHeaderListView;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.widget.popupwindow.HallCartWindow;
import com.google.common.base.Preconditions;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.widget.CustomDialogFragCompat;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class ProductList2Frag extends BaseFragment implements OnRefreshListener, View.OnClickListener, HallCartWindow.OnSiteClickListener {
    private LeftCategoryAdapter adapter;
    private HallCartWindow cartWindow;
    private boolean isGift;
    private FragProductlist2fragBinding mBinding;
    private String order_id;
    private PatrolVm patrolVm;
    private MainRightAdapter sectionedAdapter;
    private String tableName;
    private String table_id;
    private List<CategoryItem> categoryItems = new ArrayList();
    private List<List<HallCartItem>> produces = new ArrayList();
    private int num = 0;
    private boolean isScroll = true;
    private int page = 1;
    private String catoryID = "";

    public static ProductList2Frag newInstance(String table_id, String order_id, boolean isGift, String tableName) {
        ProductList2Frag fragment = new ProductList2Frag();
        Bundle args = new Bundle();
        args.putString("code", table_id);
        args.putString("KEY_ROLE_CODE", order_id);
        args.putBoolean("typeCode", isGift);
        args.putString("name", tableName);
        fragment.setArguments(args);
        return fragment;
    }

    protected View provideContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragProductlist2fragBinding fragProductlist2fragBindingInflate = DataBindingUtil.inflate(inflater, 2131492989, container, false);
        this.mBinding = fragProductlist2fragBindingInflate;
        fragProductlist2fragBindingInflate.setLifecycleOwner(this);
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
        this.mBinding.tvTitle.setText(this.tableName);
        this.mBinding.tvTitle.setOnClickListener(this);
        this.mBinding.tvProduceNum.setOnClickListener(this);
        this.mBinding.tvProduceNum.setBackground(BackgroundLibUtil.getDrawable(2131165560, 2131165735, 2131165560, 2131165735, 2131100237, 2131099725, 2131165785));
        this.mBinding.tvNum.setBackground(BackgroundLibUtil.getDrawable(2131165957, 2131100212));
        instantiation();
        this.mBinding.edtSearch.addTextChangedListener(new TextWatcher() { // from class: com.collectpoint.moudle.product.ProductList2Frag.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ProductList2Frag.this.onLazyLoadingData();
            }
        });
        this.mBinding.edtSearch.setBackground(BackgroundLibUtil.getf0f0f0Stroke(2131165735));
        this.mBinding.edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.collectpoint.moudle.product.ProductList2Frag.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == 3 || actionId == 0) {
                    String searchName = ProductList2Frag.this.mBinding.edtSearch.getText().toString().trim();
                    if (!TextUtils.isEmpty(searchName)) {
                        ProductList2Frag.this.closeKeyboard();
                        ProductList2Frag.this.onLazyLoadingData();
                        return true;
                    }
                    ToastUtils.showShort("请输入搜索内容!");
                    return false;
                }
                return false;
            }
        });
    }

    private void instantiation() {
        this.sectionedAdapter = new MainRightAdapter(getActivity());
        this.mBinding.pinnedListView.setAdapter((ListAdapter) this.sectionedAdapter);
        this.mBinding.leftListview.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.collectpoint.moudle.product.ProductList2Frag.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
                ProductList2Frag.this.closeKeyboard();
                ProductList2Frag.this.isScroll = false;
                int i = 0;
                while (true) {
                    boolean z = true;
                    if (i >= ProductList2Frag.this.categoryItems.size()) {
                        break;
                    }
                    CategoryItem categoryItem = (CategoryItem) ProductList2Frag.this.categoryItems.get(i);
                    if (i != position) {
                        z = false;
                    }
                    categoryItem.setIsflag(z);
                    i++;
                }
                ProductList2Frag.this.adapter.notifyDataSetChanged();
                int rightSection = 0;
                for (int i2 = 0; i2 < position; i2++) {
                    rightSection += ProductList2Frag.this.sectionedAdapter.getCountForSection(i2) + 1;
                }
                ProductList2Frag.this.mBinding.pinnedListView.setSelection(rightSection);
            }
        });
        this.mBinding.pinnedListView.setOnItemClickListener(new PinnedHeaderListView.OnItemClickListener() { // from class: com.collectpoint.moudle.product.ProductList2Frag.4
            @Override // com.collectpoint.moudle.product.PinnedHeaderListView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int section, int position, long id) {
                ProductList2Frag.this.closeKeyboard();
                int num = 0;
                try {
                    num = ((Integer) view.getTag()).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (num >= 1) {
                    if (ProductList2Frag.this.cartWindow != null && ProductList2Frag.this.cartWindow.isShowing()) {
                        ProductList2Frag.this.cartWindow.dismiss();
                    }
                    ProductList2Frag.this.cartWindow = new HallCartWindow(ProductList2Frag.this.getActivity(), (HallCartItem) ((List) ProductList2Frag.this.produces.get(section)).get(position), ProductList2Frag.this);
                    ProductList2Frag.this.cartWindow.show(ProductList2Frag.this.mBinding.pinnedListView);
                }
            }

            @Override // com.collectpoint.moudle.product.PinnedHeaderListView.OnItemClickListener
            public void onSectionClick(AdapterView<?> adapterView, View view, int section, long id) {
            }
        });
        this.mBinding.pinnedListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.collectpoint.moudle.product.ProductList2Frag.5
            int y = 0;
            int x = 0;
            int z = 0;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView arg0, int scrollState) {
                switch (scrollState) {
                    case 0:
                        if (ProductList2Frag.this.mBinding.pinnedListView.getLastVisiblePosition() == ProductList2Frag.this.mBinding.pinnedListView.getCount() - 1) {
                            ProductList2Frag.this.mBinding.leftListview.setSelection(130);
                        }
                        if (ProductList2Frag.this.mBinding.pinnedListView.getFirstVisiblePosition() == 0) {
                            ProductList2Frag.this.mBinding.leftListview.setSelection(0);
                            break;
                        }
                        break;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (!ProductList2Frag.this.isScroll) {
                    ProductList2Frag.this.isScroll = true;
                    return;
                }
                int i = 0;
                while (i < ProductList2Frag.this.produces.size()) {
                    ((CategoryItem) ProductList2Frag.this.categoryItems.get(i)).setIsflag(i == ProductList2Frag.this.sectionedAdapter.getSectionForPosition(ProductList2Frag.this.mBinding.pinnedListView.getFirstVisiblePosition()));
                    i++;
                }
                int i2 = this.x;
                if (i2 != this.y) {
                    ProductList2Frag.this.adapter.notifyDataSetChanged();
                    int i3 = this.x;
                    this.y = i3;
                    if (i3 == ProductList2Frag.this.mBinding.leftListview.getLastVisiblePosition()) {
                        ProductList2Frag.this.mBinding.leftListview.setSelection(this.z);
                    }
                    if (this.x == ProductList2Frag.this.mBinding.leftListview.getFirstVisiblePosition()) {
                        ProductList2Frag.this.mBinding.leftListview.setSelection(this.z);
                    }
                    if (firstVisibleItem + visibleItemCount == totalItemCount - 1) {
                        ProductList2Frag.this.mBinding.leftListview.setSelection(130);
                    }
                }
            }
        });
    }

    private void setUI() {
        this.mBinding.tvProduceNum.setVisibility(this.num > 0 ? 0 : 8);
        this.mBinding.vProduceNum.setVisibility(this.num > 0 ? 0 : 8);
        this.mBinding.tvNum.setVisibility(this.num <= 0 ? 8 : 0);
    }

    protected void onLazyLoadingData() {
        this.patrolVm.productIndex("0", "1", "1000", this.mBinding.edtSearch.getText().toString());
        this.patrolVm.hallCartList(this.table_id);
    }

    public void onResume() {
        super.onResume();
        this.patrolVm.hallCartList(this.table_id);
    }

    protected void onInit() {
        this.patrolVm.mProductIndex.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ProductList2Frag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m40lambda$onInit$0$comcollectpointmoudleproductProductList2Frag((Resource) obj);
            }
        });
        this.patrolVm.mHallCartAdd.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ProductList2Frag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m41lambda$onInit$1$comcollectpointmoudleproductProductList2Frag((Resource) obj);
            }
        });
        this.patrolVm.mHallCartList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ProductList2Frag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m42lambda$onInit$2$comcollectpointmoudleproductProductList2Frag((Resource) obj);
            }
        });
    }

    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-ProductList2Frag, reason: not valid java name */
    /* synthetic */ void m40lambda$onInit$0$comcollectpointmoudleproductProductList2Frag(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case OrderSettleFrag.REQUEST_CODE /* 1 */:
                if (EmptyUtils.isNotEmpty(this.produces)) {
                    this.produces.clear();
                }
                if (EmptyUtils.isNotEmpty(((HallCartRes) result.data).getList().getData())) {
                    if (EmptyUtils.isNotEmpty(this.categoryItems)) {
                        this.categoryItems.clear();
                    }
                    List<HallCartItem> cartItems = new ArrayList<>();
                    cartItems.add((HallCartItem) ((HallCartRes) result.data).getList().getData().get(0));
                    CategoryItem item = new CategoryItem(((HallCartItem) ((HallCartRes) result.data).getList().getData().get(0)).getCategory().getName(), true);
                    this.categoryItems.add(item);
                    for (int i = 1; i < ((HallCartRes) result.data).getList().getData().size(); i++) {
                        if (!TextUtils.equals(((HallCartItem) ((HallCartRes) result.data).getList().getData().get(i - 1)).getCategory().getName(), ((HallCartItem) ((HallCartRes) result.data).getList().getData().get(i)).getCategory().getName())) {
                            CategoryItem item1 = new CategoryItem(((HallCartItem) ((HallCartRes) result.data).getList().getData().get(i)).getCategory().getName(), true);
                            this.categoryItems.add(item1);
                            List<HallCartItem> cartItemsCopy = new ArrayList<>(cartItems);
                            this.produces.add(cartItemsCopy);
                            cartItems.clear();
                        }
                        cartItems.add((HallCartItem) ((HallCartRes) result.data).getList().getData().get(i));
                    }
                    this.produces.add(cartItems);
                }
                this.sectionedAdapter.setData(this.produces, this.categoryItems);
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-ProductList2Frag, reason: not valid java name */
    /* synthetic */ void m41lambda$onInit$1$comcollectpointmoudleproductProductList2Frag(Resource result) {
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

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-ProductList2Frag, reason: not valid java name */
    /* synthetic */ void m42lambda$onInit$2$comcollectpointmoudleproductProductList2Frag(Resource result) {
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131297084:
                Router.build("HallCartListAct").with("code", this.table_id).with("KEY_ROLE_CODE", this.order_id).with("typeCode", Boolean.valueOf(this.isGift)).with("name", this.tableName).go(getActivity());
                break;
            case 2131297138:
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
}
