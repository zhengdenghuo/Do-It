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
import com.collectpoint.constants.Constants;
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

    private class CollectAdapter extends BaseListAdapter<OrderListItem, ViewHolder> {

        class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ItemOrderlistBinding mBinding;

            public ViewHolder(ViewDataBinding viewDataBinding) {
                super(viewDataBinding.getRoot());
                ItemOrderlistBinding itemOrderlistBinding = (ItemOrderlistBinding) viewDataBinding;
                this.mBinding = itemOrderlistBinding;
                itemOrderlistBinding.clContent.setOnClickListener(this);
                this.mBinding.clContentTop.setBackground(BackgroundLibUtil.getDrawable(2131165361, 2131099830));
                this.mBinding.clContent.setBackground(BackgroundLibUtil.getWhiteAll8());
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = getAdapterPosition();
                if (-1 == adapterPosition) {
                    return;
                }
                OrderListItem orderListItem = (OrderListItem) CollectAdapter.this.getData(adapterPosition);
                if ("10".equals(orderListItem.getPay_status())) {
                    Router.build(Constants.ORDERSETTLE_ACT).with(Constants.KEY_CODE, orderListItem.getTable_id()).with("name", orderListItem.getType_name() + orderListItem.getArea_name() + orderListItem.getTable_no() + "(" + orderListItem.getMeal_num() + "/" + orderListItem.getMax_num() + ")").with(Constants.KEY_ID, orderListItem.getUser_id()).with(Constants.KEY_VILLAGE_CODE, orderListItem.getOrder_id()).with(Constants.KEY_ROLE_CODE, orderListItem.getShop_supplier_id()).go(OrderList2Frag.this.getActivity());
                } else {
                    Router.build(Constants.ORDERDETAILHOME_ACT).with(Constants.KEY_CODE, orderListItem.getOrder_id()).go(OrderList2Frag.this.requireActivity());
                }
            }
        }

        private CollectAdapter() {
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            OrderListItem orderListItem = (OrderListItem) getData(i);
            viewHolder.mBinding.tvTitle.setText(orderListItem.getOrder_no());
            viewHolder.mBinding.tvNo.setText(orderListItem.getArea_name() + orderListItem.getTable_no());
            viewHolder.mBinding.tvTime.setText(orderListItem.getCreate_time());
            viewHolder.mBinding.tvStatue.setText(orderListItem.getPay_status_name());
            viewHolder.mBinding.tvStatue.setTextColor(ContextCompat.getColor(MyApp.getContext(), "1".equals(orderListItem.getPay_status()) ? 2131099748 : 2131100170));
            viewHolder.mBinding.tvRealPrice.setText("¥" + orderListItem.getOrder_real_income());
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(DataBindingUtil.inflate(getLayoutInflater(), 2131493035, viewGroup, false));
        }
    }

    private void getData() {
        this.mSubscribe = this.mRepository.orderList(this.status, this.searchNo, "10", String.valueOf(this.page)).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer() { // from class: com.collectpoint.moudle.product.OrderList2Frag$$ExternalSyntheticLambda1
            public final void accept(Object obj) {
                System.out.println("开始操作");
            }
        }).subscribe(new BiConsumer() { // from class: com.collectpoint.moudle.product.OrderList2Frag$$ExternalSyntheticLambda0
            public final void accept(Object obj, Object obj2) throws Exception {
                this.f$0.m205lambda$getData$1$comcollectpointmoudleproductOrderList2Frag((BaseDataRes) obj, (Throwable) obj2);
            }
        });
    }

    private void init() {
        this.status = getArguments().getString(Constants.KEY_STATUS);
        initDialog();
        this.mBinding.srlCommon.setOnRefreshLoadMoreListener(this);
        this.mBinding.rvRefreshable.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.mAdapter = new CollectAdapter();
        this.mBinding.rvRefreshable.setAdapter(this.mAdapter);
        this.mBinding.rvRefreshable.addItemDecoration(new MyItemDecoration(requireActivity()));
    }

    private void initDialog() {
        CustomDialogFragCompat customDialogFragCompatFindFragmentByTag = requireFragmentManager().findFragmentByTag(Constants.TAG_LOADING_DIALOG);
        this.dialog = customDialogFragCompatFindFragmentByTag;
        if (customDialogFragCompatFindFragmentByTag == null) {
            this.dialog = CustomDialogFragCompat.newTransparentLoadingDialog((String) null);
        }
    }

    public static OrderList2Frag newInstance(String str) {
        OrderList2Frag orderList2Frag = new OrderList2Frag();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_STATUS, str);
        orderList2Frag.setArguments(bundle);
        return orderList2Frag;
    }

    /* renamed from: lambda$getData$1$com-collectpoint-moudle-product-OrderList2Frag, reason: not valid java name */
    /* synthetic */ void m205lambda$getData$1$comcollectpointmoudleproductOrderList2Frag(BaseDataRes baseDataRes, Throwable th) throws Exception {
        if (th != null) {
            this.mBinding.imgNoData.setVisibility(0);
            this.mAdapter.clear();
            this.mBinding.srlCommon.finishRefresh(false);
        } else {
            if (this.mBinding.srlCommon.getState() == RefreshState.Refreshing) {
                if (EmptyUtils.isEmpty(((BaseDataListRes) ((BaseListDataRes) baseDataRes.getData()).getList()).getData())) {
                    this.mBinding.imgNoData.setVisibility(0);
                    this.mAdapter.clear();
                } else {
                    this.mBinding.imgNoData.setVisibility(8);
                }
                this.mAdapter.setData(((BaseDataListRes) ((BaseListDataRes) baseDataRes.getData()).getList()).getData());
                this.mBinding.srlCommon.finishRefresh(true);
                return;
            }
            if (this.mBinding.srlCommon.getState() == RefreshState.Loading || this.mBinding.srlCommon.getState() == RefreshState.RefreshFinish) {
                this.mBinding.imgNoData.setVisibility(8);
                this.mAdapter.addData(((BaseDataListRes) ((BaseListDataRes) baseDataRes.getData()).getList()).getData());
                this.mBinding.srlCommon.finishLoadMore(true);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.mSubscribe;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.mSubscribe.dispose();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(FlashListEvent flashListEvent) {
        this.mBinding.srlCommon.autoRefresh();
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(SearchDataEvent searchDataEvent) {
        if (searchDataEvent != null) {
            this.searchNo = searchDataEvent.getSearch();
            this.mBinding.srlCommon.autoRefresh();
        }
    }

    protected void onInit() {
    }

    protected void onLazyLoadingData() {
        this.mBinding.srlCommon.autoRefresh();
    }

    public void onLoadMore(RefreshLayout refreshLayout) {
        this.page++;
        getData();
    }

    public void onRefresh(RefreshLayout refreshLayout) {
        this.page = 1;
        getData();
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RefreshableRvBinding refreshableRvBinding = (RefreshableRvBinding) DataBindingUtil.inflate(layoutInflater, 2131493091, viewGroup, false);
        this.mBinding = refreshableRvBinding;
        refreshableRvBinding.setLifecycleOwner(this);
        this.mLoginVm = ViewModelProviders.of(this, PatrolVmFactory.getInstance(MyApp.getInstance())).get(PatrolVm.class);
        this.mRepository = Injection.providePatrolRepository(MyApp.getInstance());
        init();
        return this.mBinding.getRoot();
    }

    protected boolean subscribeEvents() {
        return true;
    }
}
