package com.collectpoint.moudle.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chenenyu.router.Router;
import com.collectpoint.MyApp;
import com.collectpoint.bean.even.FlashListEvent;
import com.collectpoint.bean.even.SearchDataEvent;
import com.collectpoint.bean.item.OrderListItem;
import com.collectpoint.bean.res.BaseDataListRes;
import com.collectpoint.bean.res.BaseDataRes;
import com.collectpoint.bean.res.BaseListDataRes;
import com.collectpoint.databinding.ItemOrderlistBinding;
import com.collectpoint.databinding.RefreshableRvBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Injection;
import com.collectpoint.net.repo.PatrolRepo;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.decoration.MyItemDecoration;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.recyclerview.BaseListAdapter;
import com.liuwq.base.widget.CustomDialogFragCompat;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderList2Frag extends BaseFragment implements OnRefreshLoadMoreListener {
    private CustomDialogFragCompat dialog;
    private CollectAdapter mAdapter;
    private RefreshableRvBinding mBinding;
    private PatrolVm mLoginVm;
    private PatrolRepo mRepository;
    private Disposable mSubscribe;
    private int page = 1;
    private String searchNo;
    private String status;

    public static OrderList2Frag newInstance(String status) {
        OrderList2Frag fragment = new OrderList2Frag();
        Bundle args = new Bundle();
        args.putString("status", status);
        fragment.setArguments(args);
        return fragment;
    }

    protected View provideContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RefreshableRvBinding refreshableRvBindingInflate = DataBindingUtil.inflate(inflater, 2131493091, container, false);
        this.mBinding = refreshableRvBindingInflate;
        refreshableRvBindingInflate.setLifecycleOwner(this);
        PatrolVmFactory vmFactory = PatrolVmFactory.getInstance(MyApp.getInstance());
        this.mLoginVm = ViewModelProviders.of(this, vmFactory).get(PatrolVm.class);
        this.mRepository = Injection.providePatrolRepository(MyApp.getInstance());
        init();
        return this.mBinding.getRoot();
    }

    private void init() {
        this.status = getArguments().getString("status");
        initDialog();
        this.mBinding.srlCommon.setOnRefreshLoadMoreListener(this);
        this.mBinding.rvRefreshable.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.mAdapter = new CollectAdapter();
        this.mBinding.rvRefreshable.setAdapter(this.mAdapter);
        this.mBinding.rvRefreshable.addItemDecoration(new MyItemDecoration(requireActivity()));
    }

    private void initDialog() {
        CustomDialogFragCompat customDialogFragCompatFindFragmentByTag = requireFragmentManager().findFragmentByTag("TAG_LOADING_DIALOG");
        this.dialog = customDialogFragCompatFindFragmentByTag;
        if (customDialogFragCompatFindFragmentByTag == null) {
            this.dialog = CustomDialogFragCompat.newTransparentLoadingDialog((String) null);
        }
    }

    protected void onLazyLoadingData() {
        this.mBinding.srlCommon.autoRefresh();
    }

    protected void onInit() {
    }

    public void onRefresh(RefreshLayout refreshLayout) {
        this.page = 1;
        getData();
    }

    public void onLoadMore(RefreshLayout refreshLayout) {
        this.page++;
        getData();
    }

    private void getData() {
        this.mSubscribe = this.mRepository.orderList(this.status, this.searchNo, "10", String.valueOf(this.page)).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.moudle.product.OrderList2Frag$$ExternalSyntheticLambda1
            public final void accept(Object obj) {
                System.out.println("开始操作");
            }
        }).subscribe(new BiConsumer() { // from class: com.collectpoint.moudle.product.OrderList2Frag$$ExternalSyntheticLambda0
            public final void accept(Object obj, Object obj2) throws Exception {
                this.f$0.m26lambda$getData$1$comcollectpointmoudleproductOrderList2Frag((BaseDataRes) obj, (Throwable) obj2);
            }
        });
    }

    /* renamed from: lambda$getData$1$com-collectpoint-moudle-product-OrderList2Frag, reason: not valid java name */
    /* synthetic */ void m26lambda$getData$1$comcollectpointmoudleproductOrderList2Frag(BaseDataRes datalist, Throwable throwable) throws Exception {
        if (throwable != null) {
            this.mBinding.imgNoData.setVisibility(0);
            this.mAdapter.clear();
            this.mBinding.srlCommon.finishRefresh(false);
        } else {
            if (this.mBinding.srlCommon.getState() == RefreshState.Refreshing) {
                if (EmptyUtils.isEmpty(((BaseDataListRes) ((BaseListDataRes) datalist.getData()).getList()).getData())) {
                    this.mBinding.imgNoData.setVisibility(0);
                    this.mAdapter.clear();
                } else {
                    this.mBinding.imgNoData.setVisibility(8);
                }
                this.mAdapter.setData(((BaseDataListRes) ((BaseListDataRes) datalist.getData()).getList()).getData());
                this.mBinding.srlCommon.finishRefresh(true);
                return;
            }
            if (this.mBinding.srlCommon.getState() == RefreshState.Loading || this.mBinding.srlCommon.getState() == RefreshState.RefreshFinish) {
                this.mBinding.imgNoData.setVisibility(8);
                this.mAdapter.addData(((BaseDataListRes) ((BaseListDataRes) datalist.getData()).getList()).getData());
                this.mBinding.srlCommon.finishLoadMore(true);
            }
        }
    }

    private class CollectAdapter extends BaseListAdapter<OrderListItem, ViewHolder> {
        private CollectAdapter() {
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewDataBinding binding = DataBindingUtil.inflate(getLayoutInflater(), 2131493035, parent, false);
            return new ViewHolder(binding);
        }

        public void onBindViewHolder(ViewHolder holder, int position) {
            OrderListItem data = (OrderListItem) getData(position);
            holder.mBinding.tvTitle.setText(data.getOrder_no());
            holder.mBinding.tvNo.setText(data.getArea_name() + data.getTable_no());
            holder.mBinding.tvTime.setText(data.getCreate_time());
            holder.mBinding.tvStatue.setText(data.getPay_status_name());
            holder.mBinding.tvStatue.setTextColor(ContextCompat.getColor(MyApp.getContext(), "1".equals(data.getPay_status()) ? 2131099748 : 2131100170));
            holder.mBinding.tvRealPrice.setText("¥" + data.getOrder_real_income());
        }

        class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ItemOrderlistBinding mBinding;

            public ViewHolder(ViewDataBinding view) {
                super(view.getRoot());
                ItemOrderlistBinding itemOrderlistBinding = (ItemOrderlistBinding) view;
                this.mBinding = itemOrderlistBinding;
                itemOrderlistBinding.clContent.setOnClickListener(this);
                this.mBinding.clContentTop.setBackground(BackgroundLibUtil.getDrawable(2131165361, 2131099830));
                this.mBinding.clContent.setBackground(BackgroundLibUtil.getWhiteAll8());
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int adapterPosition = getAdapterPosition();
                if (-1 == adapterPosition) {
                    return;
                }
                OrderListItem data = (OrderListItem) CollectAdapter.this.getData(adapterPosition);
                if ("10".equals(data.getPay_status())) {
                    Router.build("OrderSettleAct").with("code", data.getTable_id()).with("name", data.getType_name() + data.getArea_name() + data.getTable_no() + "(" + data.getMeal_num() + "/" + data.getMax_num() + ")").with("id", data.getUser_id()).with("villageCode", data.getOrder_id()).with("KEY_ROLE_CODE", data.getShop_supplier_id()).go(OrderList2Frag.this.getActivity());
                } else {
                    Router.build("OrderDetailHomeAct").with("code", data.getOrder_id()).go(OrderList2Frag.this.requireActivity());
                }
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.mSubscribe;
        if (disposable != null && !disposable.isDisposed()) {
            this.mSubscribe.dispose();
        }
    }

    protected boolean subscribeEvents() {
        return true;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(SearchDataEvent event) {
        if (event != null) {
            this.searchNo = event.getSearch();
            this.mBinding.srlCommon.autoRefresh();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(FlashListEvent GE) {
        this.mBinding.srlCommon.autoRefresh();
    }
}
