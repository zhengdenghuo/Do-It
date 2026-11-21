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
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragProductlistfragBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.BitmapMemoryCache;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.widget.popupwindow.HallCartWindow;
import com.collectpoint.widget.recycler.SSimpleRecyclerAdapter;
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

    private class GroupAdapter extends BaseAdapter implements StickyListHeadersAdapter {
        private LayoutInflater inflater;

        public GroupAdapter(Context context) {
            this.inflater = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ProductListFrag.this.datas.size();
        }

        public long getHeaderId(int i) {
            return ((HallCartItem) ProductListFrag.this.datas.get(i)).headId;
        }

        public View getHeaderView(int i, View view, ViewGroup viewGroup) {
            Head head = (Head) ProductListFrag.this.heads.get(((HallCartItem) ProductListFrag.this.datas.get(i)).headIndex);
            TextView textView = new TextView(MyApp.getContext());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, 100));
            textView.setText(head.info);
            textView.setGravity(16);
            textView.setTextColor(-16777216);
            textView.setBackgroundColor(Color.parseColor("#EBEDF0"));
            return textView;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ProductListFrag.this.datas.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
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

    class Head {
        int groupFirstIndex;
        String info;

        Head() {
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
        public Object getItem(int i) {
            return ProductListFrag.this.heads.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(MyApp.getContext());
            textView.setText(((Head) ProductListFrag.this.heads.get(i)).info);
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, 180));
            textView.setGravity(17);
            textView.setTextSize(15.0f);
            textView.setTextColor(-16777216);
            if (i == this.selectPosition) {
                textView.setBackgroundColor(-1);
            } else {
                textView.setBackgroundColor(Color.parseColor("#EBEDF0"));
            }
            return textView;
        }

        public void setSelectPosition(int i) {
            if (this.selectPosition == i) {
                return;
            }
            this.selectPosition = i;
            notifyDataSetChanged();
        }
    }

    private class ProductAdapter extends SSimpleRecyclerAdapter<HallCartItem> {
        public ProductAdapter(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493092;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x018d  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x01bd  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x01bf  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x01d2  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x01d5  */
        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
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
    }

    private void init() {
        this.table_id = getArguments().getString(Constants.KEY_CODE);
        this.tableName = getArguments().getString("name");
        this.order_id = getArguments().getString(Constants.KEY_ROLE_CODE);
        this.isGift = getArguments().getBoolean(Constants.TYPE_CODE);
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
            public void afterTextChanged(Editable editable) {
                ProductListFrag.this.onLazyLoadingData();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.mBinding.edtSearch.setBackground(BackgroundLibUtil.getf0f0f0Stroke(2131165735));
        this.mBinding.edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.collectpoint.moudle.product.ProductListFrag.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3 && i != 0) {
                    return false;
                }
                if (TextUtils.isEmpty(ProductListFrag.this.mBinding.edtSearch.getText().toString().trim())) {
                    ToastUtils.showShort("请输入搜索内容!");
                    return false;
                }
                ProductListFrag.this.closeKeyboard();
                ProductListFrag.this.onLazyLoadingData();
                return true;
            }
        });
    }

    public static ProductListFrag newInstance(String str, String str2, boolean z, String str3) {
        ProductListFrag productListFrag = new ProductListFrag();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_CODE, str);
        bundle.putString(Constants.KEY_ROLE_CODE, str2);
        bundle.putBoolean(Constants.TYPE_CODE, z);
        bundle.putString("name", str3);
        productListFrag.setArguments(bundle);
        return productListFrag;
    }

    private void setUI() {
        this.mBinding.tvProduceNum.setVisibility(this.num > 0 ? 0 : 8);
        this.mBinding.vProduceNum.setVisibility(this.num > 0 ? 0 : 8);
        this.mBinding.tvNum.setVisibility(this.num <= 0 ? 8 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-ProductListFrag, reason: not valid java name */
    /* synthetic */ void m222lambda$onInit$0$comcollectpointmoudleproductProductListFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                ArrayList<Head> arrayList = this.heads;
                if (arrayList == null) {
                    this.heads = new ArrayList<>();
                } else {
                    arrayList.clear();
                }
                if (EmptyUtils.isNotEmpty(((BaseListDataRes) resource.data).getList())) {
                    for (int i = 1; i < ((List) ((BaseListDataRes) resource.data).getList()).size(); i++) {
                        String name = ((CategoryItem) ((List) ((BaseListDataRes) resource.data).getList()).get(i)).getName();
                        Head head = new Head();
                        head.info = name;
                        this.heads.add(head);
                    }
                    this.headAdapter.notifyDataSetChanged();
                }
                this.patrolVm.productIndex(BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO, "1", "1000", this.mBinding.edtSearch.getText().toString());
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-ProductListFrag, reason: not valid java name */
    /* synthetic */ void m223lambda$onInit$1$comcollectpointmoudleproductProductListFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                ArrayList<HallCartItem> arrayList = this.datas;
                if (arrayList == null) {
                    this.datas = new ArrayList<>();
                } else {
                    arrayList.clear();
                }
                int i = 0;
                if (EmptyUtils.isNotEmpty(((HallCartRes) resource.data).getList().getData())) {
                    String name = "";
                    for (int i2 = 0; i2 < ((HallCartRes) resource.data).getList().getData().size(); i2++) {
                        HallCartItem hallCartItem = ((HallCartRes) resource.data).getList().getData().get(i2);
                        if (!TextUtils.equals(name, ((HallCartRes) resource.data).getList().getData().get(i2).getCategory().getName())) {
                            name = ((HallCartRes) resource.data).getList().getData().get(i2).getCategory().getName();
                            if (EmptyUtils.isNotEmpty(this.heads)) {
                                int i3 = i;
                                while (i3 < this.heads.size()) {
                                    if (TextUtils.equals(this.heads.get(i3).info, name)) {
                                        i = i3;
                                        this.heads.get(i3).groupFirstIndex = this.datas.size();
                                        i3 = 2147483646;
                                    }
                                    i3++;
                                }
                            }
                        }
                        hallCartItem.headId = i;
                        hallCartItem.headIndex = i;
                        this.datas.add(hallCartItem);
                    }
                    this.groupAdapter.notifyDataSetChanged();
                    break;
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-ProductListFrag, reason: not valid java name */
    /* synthetic */ void m224lambda$onInit$2$comcollectpointmoudleproductProductListFrag(Resource resource) {
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
    /* renamed from: lambda$onInit$3$com-collectpoint-moudle-product-ProductListFrag, reason: not valid java name */
    /* synthetic */ void m225lambda$onInit$3$comcollectpointmoudleproductProductListFrag(Resource resource) {
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
            case 2131297082:
                Router.build(Constants.HALLCARTLIST_ACT).with(Constants.KEY_CODE, this.table_id).with(Constants.KEY_ROLE_CODE, this.order_id).with(Constants.TYPE_CODE, Boolean.valueOf(this.isGift)).with("name", this.tableName).go(getActivity());
                break;
            case 2131297136:
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
        this.patrolVm.mCategoryIndex.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ProductListFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m222lambda$onInit$0$comcollectpointmoudleproductProductListFrag((Resource) obj);
            }
        });
        this.patrolVm.mProductIndex.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ProductListFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m223lambda$onInit$1$comcollectpointmoudleproductProductListFrag((Resource) obj);
            }
        });
        this.patrolVm.mHallCartAdd.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ProductListFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m224lambda$onInit$2$comcollectpointmoudleproductProductListFrag((Resource) obj);
            }
        });
        this.patrolVm.mHallCartList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ProductListFrag$$ExternalSyntheticLambda3
            public final void onChanged(Object obj) {
                this.f$0.m225lambda$onInit$3$comcollectpointmoudleproductProductListFrag((Resource) obj);
            }
        });
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.headAdapter.setSelectPosition(i);
        this.mBinding.shl.setSelection(this.heads.get(i).groupFirstIndex);
        this.isScroll = false;
    }

    protected void onLazyLoadingData() {
        this.patrolVm.hallCartList(this.table_id);
        this.patrolVm.categoryIndex();
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

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.isScroll) {
            HallCartItem hallCartItem = this.datas.get(i);
            this.headAdapter.setSelectPosition(hallCartItem.headIndex);
            int firstVisiblePosition = this.mBinding.lv.getFirstVisiblePosition();
            if (hallCartItem.headIndex >= this.mBinding.lv.getLastVisiblePosition() || hallCartItem.headIndex <= firstVisiblePosition) {
                this.mBinding.lv.setSelection(hallCartItem.headIndex);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.isScroll = true;
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragProductlistfragBinding fragProductlistfragBinding = (FragProductlistfragBinding) DataBindingUtil.inflate(layoutInflater, 2131492989, viewGroup, false);
        this.mBinding = fragProductlistfragBinding;
        fragProductlistfragBinding.setLifecycleOwner(this);
        this.patrolVm = ViewModelProviders.of(this, PatrolVmFactory.getInstance(MyApp.getInstance())).get(PatrolVm.class);
        init();
        return this.mBinding.getRoot();
    }

    protected boolean subscribeEvents() {
        return true;
    }
}
