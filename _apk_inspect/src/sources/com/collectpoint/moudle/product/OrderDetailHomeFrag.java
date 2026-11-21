package com.collectpoint.moudle.product;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.MyApp;
import com.collectpoint.bean.item.OrderDetailListItem;
import com.collectpoint.bean.req.OrderInfoReq;
import com.collectpoint.bean.res.BaseDataRes;
import com.collectpoint.bean.res.OrderDetailRes;
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragOrderdetailHomeBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.BitmapMemoryCache;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.widget.recycler.SRecyclerView;
import com.collectpoint.widget.recycler.SRecyclerViewHolder;
import com.collectpoint.widget.recycler.SSimpleRecyclerAdapter;
import com.google.common.base.Preconditions;
import com.liuwq.base.fragment.BaseFragment;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderDetailHomeFrag extends BaseFragment implements View.OnClickListener {
    private OrderAdapter adapter;
    private Order2Adapter adapterPay;
    private FragOrderdetailHomeBinding mBinding;
    private OrderInfoReq orderInfoReq;
    private OrderTitleAdapte orderTitleAdapte;
    private String order_id;
    private PatrolVm patrolVm;

    private class Order2Adapter extends SSimpleRecyclerAdapter<OrderDetailRes.SettleListRes> {
        public Order2Adapter(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493031;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, OrderDetailRes.SettleListRes settleListRes) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131296983);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131297075);
            TextView textView3 = (TextView) sRecyclerViewHolder.get(2131296949);
            TextView textView4 = (TextView) sRecyclerViewHolder.get(2131296954);
            textView.setText(settleListRes.getName());
            textView3.setText((EmptyUtils.isEmpty(settleListRes.getNum()) || BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO.equals(settleListRes.getNum())) ? "" : "x" + settleListRes.getNum());
            String strReplace = settleListRes.getReal_money().replace("-", "");
            textView2.setText(EmptyUtils.isEmpty(strReplace) ? "" : "¥" + strReplace);
            String strReplace2 = settleListRes.getSettle_money().replace("-", "");
            textView4.setText(EmptyUtils.isEmpty(strReplace2) ? "" : "¥" + strReplace2);
        }
    }

    private class OrderAdapter extends SSimpleRecyclerAdapter<OrderDetailRes.DiscountListRes> {
        public OrderAdapter(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493032;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, OrderDetailRes.DiscountListRes discountListRes) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131296983);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131297075);
            textView.setText(discountListRes.getName());
            textView2.setText("-¥" + discountListRes.getDiscount_money());
        }
    }

    private class OrderDetailAdapte extends SSimpleRecyclerAdapter<OrderDetailListItem.CanpinRes> {
        public OrderDetailAdapte(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493010;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, OrderDetailListItem.CanpinRes canpinRes) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297056);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131297061);
            TextView textView3 = (TextView) sRecyclerViewHolder.get(2131297075);
            TextView textView4 = (TextView) sRecyclerViewHolder.get(2131296996);
            sRecyclerViewHolder.get(2131297170).setVisibility(i == 0 ? 8 : 0);
            textView.setText(canpinRes.getProduct_name());
            textView2.setText("x" + canpinRes.getTotal_num());
            textView3.setText("¥" + canpinRes.getTotal_price());
            textView4.setText("¥" + canpinRes.getTotal_pay_price());
        }
    }

    private class OrderTitleAdapte extends SSimpleRecyclerAdapter<OrderDetailListItem> {
        public OrderTitleAdapte(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493024;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, OrderDetailListItem orderDetailListItem) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297056);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131297061);
            TextView textView3 = (TextView) sRecyclerViewHolder.get(2131297075);
            TextView textView4 = (TextView) sRecyclerViewHolder.get(2131297096);
            TextView textView5 = (TextView) sRecyclerViewHolder.get(2131296996);
            sRecyclerViewHolder.get(2131296659).setBackground(BackgroundLibUtil.getDrawable(2131165896, 2131099830));
            SRecyclerView sRecyclerView = (SRecyclerView) sRecyclerViewHolder.get(2131296859);
            textView.setText(orderDetailListItem.getName());
            textView2.setText("x" + orderDetailListItem.getNum());
            textView3.setText("¥" + orderDetailListItem.getTotal_price());
            textView5.setText("¥" + orderDetailListItem.getTotal_pay_price());
            textView4.setText(orderDetailListItem.getTip());
            textView3.getPaint().setFlags(16);
            textView3.invalidate();
            OrderDetailAdapte orderDetailAdapte = OrderDetailHomeFrag.this.new OrderDetailAdapte(getActivity());
            sRecyclerView.setAdapter(orderDetailAdapte);
            if (EmptyUtils.isNotEmpty(orderDetailListItem.getCanpin_arr())) {
                orderDetailAdapte.setData(orderDetailListItem.getCanpin_arr());
            } else {
                orderDetailAdapte.setData(orderDetailListItem.getCanpin());
            }
        }
    }

    private void init() {
        this.orderInfoReq = (OrderInfoReq) getArguments().getParcelable(Constants.KEY_ITEM);
        this.order_id = getArguments().getString(Constants.KEY_CODE);
        String string = getArguments().getString("name");
        this.mBinding.tvLevel.setBackground(BackgroundLibUtil.getBlueW(2131166007));
        this.mBinding.llPayList.setBackground(BackgroundLibUtil.getDrawable(2131165578, 2131099825));
        this.mBinding.tvTitle.setText(string);
        this.mBinding.tvTitle.setOnClickListener(this);
        this.mBinding.tvPrint.setOnClickListener(this);
        this.mBinding.tvExpand.setOnClickListener(this);
        this.mBinding.tvExpandSs.setOnClickListener(this);
        this.mBinding.srvSettleDetail.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.adapter = new OrderAdapter(getActivity());
        this.mBinding.srvSettleDetail.setAdapter(this.adapter);
        this.mBinding.srvSettleDetail2.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.adapterPay = new Order2Adapter(getActivity());
        this.mBinding.srvSettleDetail2.setAdapter(this.adapterPay);
        this.mBinding.srvOrder.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.orderTitleAdapte = new OrderTitleAdapte(getActivity());
        this.mBinding.srvOrder.setAdapter(this.orderTitleAdapte);
    }

    static /* synthetic */ void lambda$onInit$1(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                ToastUtils.showLong("打印成功");
                break;
            case 2:
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    public static OrderDetailHomeFrag newInstance(OrderInfoReq orderInfoReq, String str, String str2) {
        OrderDetailHomeFrag orderDetailHomeFrag = new OrderDetailHomeFrag();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.KEY_ITEM, orderInfoReq);
        bundle.putString(Constants.KEY_CODE, str);
        bundle.putString("name", str2);
        orderDetailHomeFrag.setArguments(bundle);
        return orderDetailHomeFrag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-OrderDetailHomeFrag, reason: not valid java name */
    /* synthetic */ void m202x9732a79e(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                if (EmptyUtils.isEmpty(((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getUser_info())) {
                    this.mBinding.llBgTop.setVisibility(8);
                } else {
                    String mobile = ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getUser_info().getMobile();
                    if (EmptyUtils.isNotEmpty(mobile) && mobile.length() == 11) {
                        mobile = mobile.substring(0, 3) + "****" + mobile.substring(7);
                    }
                    this.mBinding.tvTele.setText(mobile);
                    this.mBinding.tvLevel.setText(((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getUser_info().getName());
                    this.mBinding.llBgTop.setVisibility(0);
                }
                this.mBinding.tvTableNo.setText("桌台号：" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getArea_name() + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getTable_no());
                this.mBinding.tvTableNum.setText("就餐人数：" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getMeal_num() + "人");
                this.orderTitleAdapte.setData(((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getProductList());
                this.adapter.setData(((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getDiscount_list());
                this.adapterPay.setData(((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getSettle_list());
                this.mBinding.tvProducePrice.setText(Html.fromHtml("商品总价<font color='#FF0000'><br>优惠</font><br>应收<font color='#FF0000'><br>退款</font><br>实收"));
                this.mBinding.tvPrice.setText(Html.fromHtml("¥" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getTotal_price() + "<font color='#FF0000'><br>-¥" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getDiscount_money() + "</font><br>¥" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getReceivable_money() + "<font color='#FF0000'><br>¥" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getRefund_money() + "</font><br>¥" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getReal_receivable_money()));
                this.mBinding.tvInfo.setText("订单信息\n订单号：" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getOrder_no() + "\n开台时间：" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getCreate_time() + "\n结账时间：" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getPay_time() + "\n收银员：" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getCashier_name());
                this.mBinding.tvRemark.setText("备注信息\n订单备注：" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getOrder_remark() + "\n赠送备注：" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getPresent_remark() + "\n结算备注：" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getSettle_remark() + "\n退款备注：" + ((OrderDetailRes) ((BaseDataRes) resource.data).getData()).getRefund_remark());
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131297004:
                this.mBinding.llPayList.setVisibility(0);
                this.mBinding.tvExpand.setVisibility(8);
                break;
            case 2131297005:
                this.mBinding.tvExpand.setVisibility(0);
                this.mBinding.llPayList.setVisibility(8);
                break;
            case 2131297077:
                this.patrolVm.PrintBill(this.order_id);
                break;
            case 2131297136:
                getActivity().finish();
                break;
        }
    }

    protected void onInit() {
        this.patrolVm.mOrderDetailHome.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailHomeFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m202x9732a79e((Resource) obj);
            }
        });
        this.patrolVm.mPrintBill.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailHomeFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                OrderDetailHomeFrag.lambda$onInit$1((Resource) obj);
            }
        });
    }

    protected void onLazyLoadingData() {
        this.patrolVm.OrderDetailHome(this.order_id);
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragOrderdetailHomeBinding fragOrderdetailHomeBinding = (FragOrderdetailHomeBinding) DataBindingUtil.inflate(layoutInflater, 2131492984, viewGroup, false);
        this.mBinding = fragOrderdetailHomeBinding;
        fragOrderdetailHomeBinding.setLifecycleOwner(this);
        this.patrolVm = ViewModelProviders.of(this, PatrolVmFactory.getInstance(MyApp.getInstance())).get(PatrolVm.class);
        init();
        return this.mBinding.getRoot();
    }
}
