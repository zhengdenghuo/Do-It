package com.collectpoint.moudle.product;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.MyApp;
import com.collectpoint.bean.item.CouponItem;
import com.collectpoint.bean.item.CouponPayItem;
import com.collectpoint.bean.item.OrderDetailListItem;
import com.collectpoint.bean.req.OrderInfo2Req;
import com.collectpoint.bean.req.OrderInfoReq;
import com.collectpoint.bean.res.BaseDataRes;
import com.collectpoint.bean.res.BaseListDataRes;
import com.collectpoint.databinding.FragOrderdetailListBinding;
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
import com.liuwq.base.widget.CustomDialogFragCompat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderDetailListFrag extends BaseFragment implements View.OnClickListener {
    private OrderAdapte adapter;
    private FragOrderdetailListBinding mBinding;
    private OrderInfoReq orderInfoReq;
    private String order_id;
    private PatrolVm patrolVm;

    public static OrderDetailListFrag newInstance(OrderInfoReq orderInfoReq, String order_id, String title) {
        OrderDetailListFrag fragment = new OrderDetailListFrag();
        Bundle args = new Bundle();
        args.putParcelable("item", orderInfoReq);
        args.putString("code", order_id);
        args.putString("name", title);
        fragment.setArguments(args);
        return fragment;
    }

    protected View provideContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragOrderdetailListBinding fragOrderdetailListBindingInflate = DataBindingUtil.inflate(inflater, 2131492985, container, false);
        this.mBinding = fragOrderdetailListBindingInflate;
        fragOrderdetailListBindingInflate.setLifecycleOwner(this);
        PatrolVmFactory vmFactory = PatrolVmFactory.getInstance(MyApp.getInstance());
        this.patrolVm = ViewModelProviders.of(this, vmFactory).get(PatrolVm.class);
        init();
        return this.mBinding.getRoot();
    }

    private void init() {
        this.orderInfoReq = getArguments().getParcelable("item");
        this.order_id = getArguments().getString("code");
        String title = getArguments().getString("name");
        this.mBinding.tvTitle.setText(title);
        this.mBinding.tvTitle.setOnClickListener(this);
        this.mBinding.tvPrint.setOnClickListener(this);
        this.mBinding.srvOrder.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.adapter = new OrderAdapte(getActivity());
        this.mBinding.srvOrder.setAdapter(this.adapter);
    }

    protected void onLazyLoadingData() {
        if (this.orderInfoReq != null) {
            List<CouponPayItem> settlepayItems = new ArrayList<>();
            List<CouponItem> settleItems = this.orderInfoReq.getSettle();
            if (EmptyUtils.isNotEmpty(settleItems)) {
                for (int i = 0; i < settleItems.size(); i++) {
                    settlepayItems.add(new CouponPayItem(settleItems.get(i).getSettle_id(), settleItems.get(i).getSettle_type(), settleItems.get(i).getSettle_money(), settleItems.get(i).getNum(), settleItems.get(i).getOut_trade_no()));
                }
            }
            OrderInfo2Req info2Req = new OrderInfo2Req(this.order_id, settlepayItems);
            this.patrolVm.orderDetailList(info2Req);
        }
    }

    protected void onInit() {
        this.patrolVm.mOrderDetailList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailListFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m24x4626bdd((Resource) obj);
            }
        });
        this.patrolVm.mPrintOrder.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailListFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m25x919d1d5e((Resource) obj);
            }
        });
    }

    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-OrderDetailListFrag, reason: not valid java name */
    /* synthetic */ void m24x4626bdd(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case OrderSettleFrag.REQUEST_CODE /* 1 */:
                this.mBinding.tvEmpty.setVisibility((EmptyUtils.isEmpty(result.data) || EmptyUtils.isEmpty(((BaseListDataRes) result.data).getList()) || EmptyUtils.isEmpty(((BaseDataRes) ((BaseListDataRes) result.data).getList()).getData())) ? 0 : 8);
                try {
                    this.adapter.setData((List) ((BaseDataRes) ((BaseListDataRes) result.data).getList()).getData());
                    break;
                } catch (Exception e) {
                    this.mBinding.tvEmpty.setVisibility(0);
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-OrderDetailListFrag, reason: not valid java name */
    /* synthetic */ void m25x919d1d5e(Resource result) {
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
                ToastUtils.showLong("打印成功");
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131297077:
                if (this.orderInfoReq != null) {
                    List<CouponPayItem> settlepayItems = new ArrayList<>();
                    List<CouponItem> settleItems = this.orderInfoReq.getSettle();
                    if (EmptyUtils.isNotEmpty(settleItems)) {
                        for (int i = 0; i < settleItems.size(); i++) {
                            settlepayItems.add(new CouponPayItem(settleItems.get(i).getSettle_id(), settleItems.get(i).getSettle_type(), settleItems.get(i).getSettle_money(), settleItems.get(i).getNum(), settleItems.get(i).getOut_trade_no()));
                        }
                    }
                    OrderInfo2Req info2Req = new OrderInfo2Req(this.order_id, settlepayItems);
                    this.patrolVm.printOrder(info2Req);
                    break;
                }
                break;
            case 2131297136:
                getActivity().finish();
                break;
        }
    }

    private class OrderAdapte extends SSimpleRecyclerAdapter<OrderDetailListItem> {
        public OrderAdapte(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, int position, OrderDetailListItem data) {
            TextView tv_name = (TextView) holder.get(2131297056);
            TextView tv_num = (TextView) holder.get(2131297061);
            TextView tv_price = (TextView) holder.get(2131297075);
            TextView tv_discount_price = (TextView) holder.get(2131296996);
            LinearLayout ll_content = (LinearLayout) holder.get(2131296659);
            TextView tv_tip = (TextView) holder.get(2131297135);
            TextView tv_produce_gift = (TextView) holder.get(2131297080);
            ll_content.setBackground(BackgroundLibUtil.getDrawable(2131165896, 2131100212));
            SRecyclerView srv_coupom = holder.get(2131296859);
            tv_name.setText(data.getName());
            tv_num.setText("");
            tv_price.setText("¥" + data.getTotal_price());
            tv_discount_price.setText("¥" + data.getTotal_pay_price());
            tv_tip.setText(data.getTip());
            tv_tip.setVisibility(EmptyUtils.isEmpty(data.getTip()) ? 8 : 0);
            tv_produce_gift.setVisibility(TextUtils.equals("1", data.getIs_coupon()) ? 0 : 8);
            tv_produce_gift.setBackground(BackgroundLibUtil.getWhiteAll(2131166007));
            OrderDetailAdapte cAdapter = OrderDetailListFrag.this.new OrderDetailAdapte(getActivity());
            srv_coupom.setAdapter(cAdapter);
            if (EmptyUtils.isNotEmpty(data.getCanpin_arr())) {
                cAdapter.setData(data.getCanpin_arr());
            } else {
                cAdapter.setData(data.getCanpin());
            }
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493009;
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
            TextView tv_produce_gift = (TextView) holder.get(2131297080);
            v_bottom.setVisibility(position == 0 ? 8 : 0);
            tv_name.setText(data.getProduct_name());
            tv_num.setText("x" + data.getTotal_num());
            tv_price.setText("¥" + data.getTotal_price());
            tv_discount_price.setText("¥" + data.getTotal_pay_price());
            tv_produce_gift.setBackground(BackgroundLibUtil.getBlue(2131166007));
            tv_produce_gift.setText("1".equals(data.getIs_promotion()) ? "促" : "赠");
            if ("1".equals(data.getIs_gift()) || "1".equals(data.getIs_promotion())) {
                tv_produce_gift.setVisibility(0);
                if (EmptyUtils.isNotEmpty(data.getProduct_name())) {
                    if (data.getProduct_name().startsWith("赠") || data.getProduct_name().startsWith("促")) {
                        tv_name.setText(data.getProduct_name().substring(1));
                        return;
                    }
                    return;
                }
                return;
            }
            tv_produce_gift.setVisibility(8);
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493010;
        }
    }
}
