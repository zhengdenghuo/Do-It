package com.collectpoint.moudle.product;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import com.collectpoint.databinding.FragOrderdetailHomeBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
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

    public static OrderDetailHomeFrag newInstance(OrderInfoReq orderInfoReq, String order_id, String title) {
        OrderDetailHomeFrag fragment = new OrderDetailHomeFrag();
        Bundle args = new Bundle();
        args.putParcelable("item", orderInfoReq);
        args.putString("code", order_id);
        args.putString("name", title);
        fragment.setArguments(args);
        return fragment;
    }

    protected View provideContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragOrderdetailHomeBinding fragOrderdetailHomeBindingInflate = DataBindingUtil.inflate(inflater, 2131492984, container, false);
        this.mBinding = fragOrderdetailHomeBindingInflate;
        fragOrderdetailHomeBindingInflate.setLifecycleOwner(this);
        PatrolVmFactory vmFactory = PatrolVmFactory.getInstance(MyApp.getInstance());
        this.patrolVm = ViewModelProviders.of(this, vmFactory).get(PatrolVm.class);
        init();
        return this.mBinding.getRoot();
    }

    private void init() {
        this.orderInfoReq = getArguments().getParcelable("item");
        this.order_id = getArguments().getString("code");
        String title = getArguments().getString("name");
        this.mBinding.tvLevel.setBackground(BackgroundLibUtil.getBlueW(2131166007));
        this.mBinding.llPayList.setBackground(BackgroundLibUtil.getDrawable(2131165578, 2131099825));
        this.mBinding.tvTitle.setText(title);
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

    protected void onLazyLoadingData() {
        this.patrolVm.OrderDetailHome(this.order_id);
    }

    protected void onInit() {
        this.patrolVm.mOrderDetailHome.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailHomeFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m23x9732a79e((Resource) obj);
            }
        });
        this.patrolVm.mPrintBill.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailHomeFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                OrderDetailHomeFrag.lambda$onInit$1((Resource) obj);
            }
        });
    }

    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-OrderDetailHomeFrag, reason: not valid java name */
    /* synthetic */ void m23x9732a79e(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case OrderSettleFrag.REQUEST_CODE /* 1 */:
                if (EmptyUtils.isEmpty(((OrderDetailRes) ((BaseDataRes) result.data).getData()).getUser_info())) {
                    this.mBinding.llBgTop.setVisibility(8);
                } else {
                    String tele = ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getUser_info().getMobile();
                    if (EmptyUtils.isNotEmpty(tele) && tele.length() == 11) {
                        tele = tele.substring(0, 3) + "****" + tele.substring(7);
                    }
                    this.mBinding.tvTele.setText(tele);
                    this.mBinding.tvLevel.setText(((OrderDetailRes) ((BaseDataRes) result.data).getData()).getUser_info().getName());
                    this.mBinding.llBgTop.setVisibility(0);
                }
                this.mBinding.tvTableNo.setText("桌台号：" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getArea_name() + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getTable_no());
                this.mBinding.tvTableNum.setText("就餐人数：" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getMeal_num() + "人");
                this.orderTitleAdapte.setData(((OrderDetailRes) ((BaseDataRes) result.data).getData()).getProductList());
                this.adapter.setData(((OrderDetailRes) ((BaseDataRes) result.data).getData()).getDiscount_list());
                this.adapterPay.setData(((OrderDetailRes) ((BaseDataRes) result.data).getData()).getSettle_list());
                this.mBinding.tvProducePrice.setText(Html.fromHtml("商品总价<font color='#FF0000'><br>优惠</font><br>应收<font color='#FF0000'><br>退款</font><br>实收"));
                String text = "¥" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getTotal_price() + "<font color='#FF0000'><br>-¥" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getDiscount_money() + "</font><br>¥" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getReceivable_money() + "<font color='#FF0000'><br>¥" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getRefund_money() + "</font><br>¥" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getReal_receivable_money();
                this.mBinding.tvPrice.setText(Html.fromHtml(text));
                this.mBinding.tvInfo.setText("订单信息\n订单号：" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getOrder_no() + "\n开台时间：" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getCreate_time() + "\n结账时间：" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getPay_time() + "\n收银员：" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getCashier_name());
                this.mBinding.tvRemark.setText("备注信息\n订单备注：" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getOrder_remark() + "\n赠送备注：" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getPresent_remark() + "\n结算备注：" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getSettle_remark() + "\n退款备注：" + ((OrderDetailRes) ((BaseDataRes) result.data).getData()).getRefund_remark());
                break;
        }
    }

    static /* synthetic */ void lambda$onInit$1(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case OrderSettleFrag.REQUEST_CODE /* 1 */:
                ToastUtils.showLong("打印成功");
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                ToastUtils.showLong(result.message);
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

    private class OrderAdapter extends SSimpleRecyclerAdapter<OrderDetailRes.DiscountListRes> {
        public OrderAdapter(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, int position, OrderDetailRes.DiscountListRes data) {
            TextView tv_content = (TextView) holder.get(2131296983);
            TextView tv_price = (TextView) holder.get(2131297075);
            tv_content.setText(data.getName());
            tv_price.setText("-¥" + data.getDiscount_money());
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493032;
        }
    }

    private class Order2Adapter extends SSimpleRecyclerAdapter<OrderDetailRes.SettleListRes> {
        public Order2Adapter(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, int position, OrderDetailRes.SettleListRes data) {
            TextView tv_content = (TextView) holder.get(2131296983);
            TextView tv_price = (TextView) holder.get(2131297075);
            TextView tv1 = (TextView) holder.get(2131296949);
            TextView tv2 = (TextView) holder.get(2131296954);
            tv_content.setText(data.getName());
            tv1.setText((EmptyUtils.isEmpty(data.getNum()) || "0".equals(data.getNum())) ? "" : "x" + data.getNum());
            String real_mone = data.getReal_money().replace("-", "");
            tv_price.setText(EmptyUtils.isEmpty(real_mone) ? "" : "¥" + real_mone);
            String settle_money = data.getSettle_money().replace("-", "");
            tv2.setText(EmptyUtils.isEmpty(settle_money) ? "" : "¥" + settle_money);
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493031;
        }
    }

    private class OrderTitleAdapte extends SSimpleRecyclerAdapter<OrderDetailListItem> {
        public OrderTitleAdapte(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, int position, OrderDetailListItem data) {
            TextView tv_name = (TextView) holder.get(2131297056);
            TextView tv_num = (TextView) holder.get(2131297061);
            TextView tv_price = (TextView) holder.get(2131297075);
            TextView tv_remark = (TextView) holder.get(2131297096);
            TextView tv_discount_price = (TextView) holder.get(2131296996);
            ConstraintLayout ll_content = holder.get(2131296659);
            ll_content.setBackground(BackgroundLibUtil.getDrawable(2131165896, 2131099830));
            SRecyclerView srv_coupom = holder.get(2131296859);
            tv_name.setText(data.getName());
            tv_num.setText("x" + data.getNum());
            tv_price.setText("¥" + data.getTotal_price());
            tv_discount_price.setText("¥" + data.getTotal_pay_price());
            tv_remark.setText(data.getTip());
            tv_price.getPaint().setFlags(16);
            tv_price.invalidate();
            OrderDetailAdapte cAdapter = OrderDetailHomeFrag.this.new OrderDetailAdapte(getActivity());
            srv_coupom.setAdapter(cAdapter);
            if (EmptyUtils.isNotEmpty(data.getCanpin_arr())) {
                cAdapter.setData(data.getCanpin_arr());
            } else {
                cAdapter.setData(data.getCanpin());
            }
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493024;
        }
    }

    private class OrderDetailAdapte extends SSimpleRecyclerAdapter<OrderDetailListItem.CanpinRes> {
        public OrderDetailAdapte(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, int position, OrderDetailListItem.CanpinRes data) {
            TextView tv_name = (TextView) holder.get(2131297056);
            TextView tv_num = (TextView) holder.get(2131297061);
            TextView tv_price = (TextView) holder.get(2131297075);
            TextView tv_discount_price = (TextView) holder.get(2131296996);
            View v_bottom = holder.get(2131297170);
            v_bottom.setVisibility(position == 0 ? 8 : 0);
            tv_name.setText(data.getProduct_name());
            tv_num.setText("x" + data.getTotal_num());
            tv_price.setText("¥" + data.getTotal_price());
            tv_discount_price.setText("¥" + data.getTotal_pay_price());
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493010;
        }
    }
}
