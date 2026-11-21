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
import com.collectpoint.constants.Constants;
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

    private class OrderAdapte extends SSimpleRecyclerAdapter<OrderDetailListItem> {
        public OrderAdapte(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493009;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, OrderDetailListItem orderDetailListItem) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297056);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131297061);
            TextView textView3 = (TextView) sRecyclerViewHolder.get(2131297075);
            TextView textView4 = (TextView) sRecyclerViewHolder.get(2131296996);
            LinearLayout linearLayout = (LinearLayout) sRecyclerViewHolder.get(2131296659);
            TextView textView5 = (TextView) sRecyclerViewHolder.get(2131297135);
            TextView textView6 = (TextView) sRecyclerViewHolder.get(2131297080);
            linearLayout.setBackground(BackgroundLibUtil.getDrawable(2131165896, 2131100212));
            SRecyclerView sRecyclerView = (SRecyclerView) sRecyclerViewHolder.get(2131296859);
            textView.setText(orderDetailListItem.getName());
            textView2.setText("");
            textView3.setText("¥" + orderDetailListItem.getTotal_price());
            textView4.setText("¥" + orderDetailListItem.getTotal_pay_price());
            textView5.setText(orderDetailListItem.getTip());
            textView5.setVisibility(EmptyUtils.isEmpty(orderDetailListItem.getTip()) ? 8 : 0);
            textView6.setVisibility(TextUtils.equals("1", orderDetailListItem.getIs_coupon()) ? 0 : 8);
            textView6.setBackground(BackgroundLibUtil.getWhiteAll(2131166007));
            OrderDetailAdapte orderDetailAdapte = OrderDetailListFrag.this.new OrderDetailAdapte(getActivity());
            sRecyclerView.setAdapter(orderDetailAdapte);
            if (EmptyUtils.isNotEmpty(orderDetailListItem.getCanpin_arr())) {
                orderDetailAdapte.setData(orderDetailListItem.getCanpin_arr());
            } else {
                orderDetailAdapte.setData(orderDetailListItem.getCanpin());
            }
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
            View view = sRecyclerViewHolder.get(2131297170);
            TextView textView5 = (TextView) sRecyclerViewHolder.get(2131297080);
            view.setVisibility(i == 0 ? 8 : 0);
            textView.setText(canpinRes.getProduct_name());
            textView2.setText("x" + canpinRes.getTotal_num());
            textView3.setText("¥" + canpinRes.getTotal_price());
            textView4.setText("¥" + canpinRes.getTotal_pay_price());
            textView5.setBackground(BackgroundLibUtil.getBlue(2131166007));
            textView5.setText("1".equals(canpinRes.getIs_promotion()) ? "促" : "赠");
            if (!"1".equals(canpinRes.getIs_gift()) && !"1".equals(canpinRes.getIs_promotion())) {
                textView5.setVisibility(8);
                return;
            }
            textView5.setVisibility(0);
            if (EmptyUtils.isNotEmpty(canpinRes.getProduct_name())) {
                if (canpinRes.getProduct_name().startsWith("赠") || canpinRes.getProduct_name().startsWith("促")) {
                    textView.setText(canpinRes.getProduct_name().substring(1));
                }
            }
        }
    }

    private void init() {
        this.orderInfoReq = (OrderInfoReq) getArguments().getParcelable(Constants.KEY_ITEM);
        this.order_id = getArguments().getString(Constants.KEY_CODE);
        this.mBinding.tvTitle.setText(getArguments().getString("name"));
        this.mBinding.tvTitle.setOnClickListener(this);
        this.mBinding.tvPrint.setOnClickListener(this);
        this.mBinding.srvOrder.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.adapter = new OrderAdapte(getActivity());
        this.mBinding.srvOrder.setAdapter(this.adapter);
    }

    public static OrderDetailListFrag newInstance(OrderInfoReq orderInfoReq, String str, String str2) {
        OrderDetailListFrag orderDetailListFrag = new OrderDetailListFrag();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.KEY_ITEM, orderInfoReq);
        bundle.putString(Constants.KEY_CODE, str);
        bundle.putString("name", str2);
        orderDetailListFrag.setArguments(bundle);
        return orderDetailListFrag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-OrderDetailListFrag, reason: not valid java name */
    /* synthetic */ void m203x4626bdd(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                this.mBinding.tvEmpty.setVisibility((EmptyUtils.isEmpty(resource.data) || EmptyUtils.isEmpty(((BaseListDataRes) resource.data).getList()) || EmptyUtils.isEmpty(((BaseDataRes) ((BaseListDataRes) resource.data).getList()).getData())) ? 0 : 8);
                try {
                    this.adapter.setData((List) ((BaseDataRes) ((BaseListDataRes) resource.data).getList()).getData());
                    break;
                } catch (Exception e) {
                    this.mBinding.tvEmpty.setVisibility(0);
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-OrderDetailListFrag, reason: not valid java name */
    /* synthetic */ void m204x919d1d5e(Resource resource) {
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
                ToastUtils.showLong("打印成功");
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131297077:
                if (this.orderInfoReq != null) {
                    ArrayList arrayList = new ArrayList();
                    List<CouponItem> settle = this.orderInfoReq.getSettle();
                    if (EmptyUtils.isNotEmpty(settle)) {
                        for (int i = 0; i < settle.size(); i++) {
                            arrayList.add(new CouponPayItem(settle.get(i).getSettle_id(), settle.get(i).getSettle_type(), settle.get(i).getSettle_money(), settle.get(i).getNum(), settle.get(i).getOut_trade_no()));
                        }
                    }
                    this.patrolVm.printOrder(new OrderInfo2Req(this.order_id, arrayList));
                    break;
                }
                break;
            case 2131297136:
                getActivity().finish();
                break;
        }
    }

    protected void onInit() {
        this.patrolVm.mOrderDetailList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailListFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m203x4626bdd((Resource) obj);
            }
        });
        this.patrolVm.mPrintOrder.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailListFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m204x919d1d5e((Resource) obj);
            }
        });
    }

    protected void onLazyLoadingData() {
        if (this.orderInfoReq != null) {
            ArrayList arrayList = new ArrayList();
            List<CouponItem> settle = this.orderInfoReq.getSettle();
            if (EmptyUtils.isNotEmpty(settle)) {
                for (int i = 0; i < settle.size(); i++) {
                    arrayList.add(new CouponPayItem(settle.get(i).getSettle_id(), settle.get(i).getSettle_type(), settle.get(i).getSettle_money(), settle.get(i).getNum(), settle.get(i).getOut_trade_no()));
                }
            }
            this.patrolVm.orderDetailList(new OrderInfo2Req(this.order_id, arrayList));
        }
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragOrderdetailListBinding fragOrderdetailListBinding = (FragOrderdetailListBinding) DataBindingUtil.inflate(layoutInflater, 2131492985, viewGroup, false);
        this.mBinding = fragOrderdetailListBinding;
        fragOrderdetailListBinding.setLifecycleOwner(this);
        this.patrolVm = ViewModelProviders.of(this, PatrolVmFactory.getInstance(MyApp.getInstance())).get(PatrolVm.class);
        init();
        return this.mBinding.getRoot();
    }
}
