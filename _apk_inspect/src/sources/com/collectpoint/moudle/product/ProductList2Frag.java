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
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragProductlist2fragBinding;
import com.collectpoint.moudle.product.PinnedHeaderListView;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.BitmapMemoryCache;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.widget.popupwindow.HallCartWindow;
import com.google.common.base.Preconditions;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.widget.CustomDialogFragCompat;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.Iterator;
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

    private void init() {
        this.table_id = getArguments().getString(Constants.KEY_CODE);
        this.tableName = getArguments().getString("name");
        this.order_id = getArguments().getString(Constants.KEY_ROLE_CODE);
        this.isGift = getArguments().getBoolean(Constants.TYPE_CODE);
        this.mBinding.tvTitle.setText(this.tableName);
        this.mBinding.tvTitle.setOnClickListener(this);
        this.mBinding.tvProduceNum.setOnClickListener(this);
        this.mBinding.tvProduceNum.setBackground(BackgroundLibUtil.getDrawable(2131165560, 2131165735, 2131165560, 2131165735, 2131100237, 2131099725, 2131165785));
        this.mBinding.tvNum.setBackground(BackgroundLibUtil.getDrawable(2131165957, 2131100212));
        instantiation();
        this.mBinding.edtSearch.addTextChangedListener(new TextWatcher() { // from class: com.collectpoint.moudle.product.ProductList2Frag.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ProductList2Frag.this.onLazyLoadingData();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.mBinding.edtSearch.setBackground(BackgroundLibUtil.getf0f0f0Stroke(2131165735));
        this.mBinding.edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.collectpoint.moudle.product.ProductList2Frag.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3 && i != 0) {
                    return false;
                }
                if (TextUtils.isEmpty(ProductList2Frag.this.mBinding.edtSearch.getText().toString().trim())) {
                    ToastUtils.showShort("请输入搜索内容!");
                    return false;
                }
                ProductList2Frag.this.closeKeyboard();
                ProductList2Frag.this.onLazyLoadingData();
                return true;
            }
        });
    }

    private void instantiation() {
        this.sectionedAdapter = new MainRightAdapter(getActivity());
        this.mBinding.pinnedListView.setAdapter((ListAdapter) this.sectionedAdapter);
        this.mBinding.leftListview.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.collectpoint.moudle.product.ProductList2Frag.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ProductList2Frag.this.closeKeyboard();
                ProductList2Frag.this.isScroll = false;
                int i2 = 0;
                while (true) {
                    boolean z = true;
                    if (i2 >= ProductList2Frag.this.categoryItems.size()) {
                        break;
                    }
                    CategoryItem categoryItem = (CategoryItem) ProductList2Frag.this.categoryItems.get(i2);
                    if (i2 != i) {
                        z = false;
                    }
                    categoryItem.setIsflag(z);
                    i2++;
                }
                ProductList2Frag.this.adapter.notifyDataSetChanged();
                int countForSection = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    countForSection += ProductList2Frag.this.sectionedAdapter.getCountForSection(i3) + 1;
                }
                ProductList2Frag.this.mBinding.pinnedListView.setSelection(countForSection);
            }
        });
        this.mBinding.pinnedListView.setOnItemClickListener(new PinnedHeaderListView.OnItemClickListener() { // from class: com.collectpoint.moudle.product.ProductList2Frag.4
            @Override // com.collectpoint.moudle.product.PinnedHeaderListView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, int i2, long j) {
                ProductList2Frag.this.closeKeyboard();
                int iIntValue = 0;
                try {
                    iIntValue = ((Integer) view.getTag()).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (iIntValue < 1) {
                    return;
                }
                if (ProductList2Frag.this.cartWindow != null && ProductList2Frag.this.cartWindow.isShowing()) {
                    ProductList2Frag.this.cartWindow.dismiss();
                }
                ProductList2Frag.this.cartWindow = new HallCartWindow(ProductList2Frag.this.getActivity(), (HallCartItem) ((List) ProductList2Frag.this.produces.get(i)).get(i2), ProductList2Frag.this);
                ProductList2Frag.this.cartWindow.show(ProductList2Frag.this.mBinding.pinnedListView);
            }

            @Override // com.collectpoint.moudle.product.PinnedHeaderListView.OnItemClickListener
            public void onSectionClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.mBinding.pinnedListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.collectpoint.moudle.product.ProductList2Frag.5
            int y = 0;
            int x = 0;
            int z = 0;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!ProductList2Frag.this.isScroll) {
                    ProductList2Frag.this.isScroll = true;
                    return;
                }
                int i4 = 0;
                while (i4 < ProductList2Frag.this.produces.size()) {
                    ((CategoryItem) ProductList2Frag.this.categoryItems.get(i4)).setIsflag(i4 == ProductList2Frag.this.sectionedAdapter.getSectionForPosition(ProductList2Frag.this.mBinding.pinnedListView.getFirstVisiblePosition()));
                    i4++;
                }
                if (this.x != this.y) {
                    ProductList2Frag.this.adapter.notifyDataSetChanged();
                    int i5 = this.x;
                    this.y = i5;
                    if (i5 == ProductList2Frag.this.mBinding.leftListview.getLastVisiblePosition()) {
                        ProductList2Frag.this.mBinding.leftListview.setSelection(this.z);
                    }
                    if (this.x == ProductList2Frag.this.mBinding.leftListview.getFirstVisiblePosition()) {
                        ProductList2Frag.this.mBinding.leftListview.setSelection(this.z);
                    }
                    if (i + i2 == i3 - 1) {
                        ProductList2Frag.this.mBinding.leftListview.setSelection(130);
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
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
        });
    }

    public static ProductList2Frag newInstance(String str, String str2, boolean z, String str3) {
        ProductList2Frag productList2Frag = new ProductList2Frag();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_CODE, str);
        bundle.putString(Constants.KEY_ROLE_CODE, str2);
        bundle.putBoolean(Constants.TYPE_CODE, z);
        bundle.putString("name", str3);
        productList2Frag.setArguments(bundle);
        return productList2Frag;
    }

    private void setUI() {
        this.mBinding.tvProduceNum.setVisibility(this.num > 0 ? 0 : 8);
        this.mBinding.vProduceNum.setVisibility(this.num > 0 ? 0 : 8);
        this.mBinding.tvNum.setVisibility(this.num <= 0 ? 8 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-ProductList2Frag, reason: not valid java name */
    /* synthetic */ void m219lambda$onInit$0$comcollectpointmoudleproductProductList2Frag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                if (EmptyUtils.isNotEmpty(this.produces)) {
                    this.produces.clear();
                }
                if (EmptyUtils.isNotEmpty(((HallCartRes) resource.data).getList().getData())) {
                    if (EmptyUtils.isNotEmpty(this.categoryItems)) {
                        this.categoryItems.clear();
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(((HallCartRes) resource.data).getList().getData().get(0));
                    this.categoryItems.add(new CategoryItem(((HallCartRes) resource.data).getList().getData().get(0).getCategory().getName(), true));
                    for (int i = 1; i < ((HallCartRes) resource.data).getList().getData().size(); i++) {
                        if (!TextUtils.equals(((HallCartRes) resource.data).getList().getData().get(i - 1).getCategory().getName(), ((HallCartRes) resource.data).getList().getData().get(i).getCategory().getName())) {
                            this.categoryItems.add(new CategoryItem(((HallCartRes) resource.data).getList().getData().get(i).getCategory().getName(), true));
                            this.produces.add(new ArrayList(arrayList));
                            arrayList.clear();
                        }
                        arrayList.add(((HallCartRes) resource.data).getList().getData().get(i));
                    }
                    this.produces.add(arrayList);
                }
                this.sectionedAdapter.setData(this.produces, this.categoryItems);
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-ProductList2Frag, reason: not valid java name */
    /* synthetic */ void m220lambda$onInit$1$comcollectpointmoudleproductProductList2Frag(Resource resource) {
        Preconditions.checkNotNull(resource);
        CustomDialogFragCompat customDialogFragCompatFindFragmentByTag = requireFragmentManager().findFragmentByTag(Constants.TAG_LOADING_DIALOG);
        if (customDialogFragCompatFindFragmentByTag == null) {
            customDialogFragCompatFindFragmentByTag = CustomDialogFragCompat.newTransparentLoadingDialog((String) null);
        }
        switch (resource.status) {
            case 0:
                if (!customDialogFragCompatFindFragmentByTag.isAdded()) {
                    customDialogFragCompatFindFragmentByTag.show(requireFragmentManager(), Constants.TAG_LOADING_DIALOG);
                    break;
                }
                break;
            case 1:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                TextView textView = this.mBinding.tvNum;
                int i = this.num;
                textView.setText(i > 0 ? String.valueOf(i) : BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
                setUI();
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-ProductList2Frag, reason: not valid java name */
    /* synthetic */ void m221lambda$onInit$2$comcollectpointmoudleproductProductList2Frag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                this.num = 0;
                if (EmptyUtils.isNotEmpty(((HallCartlistRes) resource.data).getProductList())) {
                    Iterator<HallCartlistRes.ProductListRes> it = ((HallCartlistRes) resource.data).getProductList().iterator();
                    while (it.hasNext()) {
                        try {
                            this.num += Integer.valueOf(it.next().getProduct_num()).intValue();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                TextView textView = this.mBinding.tvNum;
                int i = this.num;
                textView.setText(i > 0 ? String.valueOf(i) : BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
                setUI();
                break;
            case 2:
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    @Override // com.collectpoint.widget.popupwindow.HallCartWindow.OnSiteClickListener
    public void onAttrSubmit(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        try {
            this.num += Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        this.patrolVm.hallCartAdd(str, str2, str3, str4, str5, str5, str6, this.table_id, str7, str8, this.isGift ? "1" : BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131297084:
                Router.build(Constants.HALLCARTLIST_ACT).with(Constants.KEY_CODE, this.table_id).with(Constants.KEY_ROLE_CODE, this.order_id).with(Constants.TYPE_CODE, Boolean.valueOf(this.isGift)).with("name", this.tableName).go(getActivity());
                break;
            case 2131297138:
                getActivity().finish();
                break;
        }
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(FinishActtEvent finishActtEvent) {
        if (finishActtEvent == null || finishActtEvent.getLayer() >= 2) {
            return;
        }
        getActivity().finish();
    }

    protected void onInit() {
        this.patrolVm.mProductIndex.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ProductList2Frag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m219lambda$onInit$0$comcollectpointmoudleproductProductList2Frag((Resource) obj);
            }
        });
        this.patrolVm.mHallCartAdd.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ProductList2Frag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m220lambda$onInit$1$comcollectpointmoudleproductProductList2Frag((Resource) obj);
            }
        });
        this.patrolVm.mHallCartList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ProductList2Frag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m221lambda$onInit$2$comcollectpointmoudleproductProductList2Frag((Resource) obj);
            }
        });
    }

    protected void onLazyLoadingData() {
        this.patrolVm.productIndex(BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO, "1", "1000", this.mBinding.edtSearch.getText().toString());
        this.patrolVm.hallCartList(this.table_id);
    }

    public void onRefresh(RefreshLayout refreshLayout) {
        PatrolVm patrolVm = this.patrolVm;
        String str = this.catoryID;
        int i = this.page;
        this.page = i + 1;
        patrolVm.productIndex(str, String.valueOf(i), "10", this.mBinding.edtSearch.getText().toString());
    }

    public void onResume() {
        super.onResume();
        this.patrolVm.hallCartList(this.table_id);
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragProductlist2fragBinding fragProductlist2fragBinding = (FragProductlist2fragBinding) DataBindingUtil.inflate(layoutInflater, 2131492989, viewGroup, false);
        this.mBinding = fragProductlist2fragBinding;
        fragProductlist2fragBinding.setLifecycleOwner(this);
        this.patrolVm = ViewModelProviders.of(this, PatrolVmFactory.getInstance(MyApp.getInstance())).get(PatrolVm.class);
        init();
        return this.mBinding.getRoot();
    }

    protected boolean subscribeEvents() {
        return true;
    }
}
