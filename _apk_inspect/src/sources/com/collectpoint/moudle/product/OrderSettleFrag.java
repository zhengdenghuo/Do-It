package com.collectpoint.moudle.product;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ToastUtils;
import com.chenenyu.router.Router;
import com.collectpoint.MyApp;
import com.collectpoint.bean.even.FinishActtEvent;
import com.collectpoint.bean.even.FlashListEvent;
import com.collectpoint.bean.item.CouponItem;
import com.collectpoint.bean.item.CouponPayItem;
import com.collectpoint.bean.item.PermissionItem;
import com.collectpoint.bean.req.AddOrderCouponReq;
import com.collectpoint.bean.req.OrderInfo2Req;
import com.collectpoint.bean.req.OrderInfoReq;
import com.collectpoint.bean.res.BaseDataRes;
import com.collectpoint.bean.res.BaseListRes;
import com.collectpoint.bean.res.BaseResuleRes;
import com.collectpoint.bean.res.CoupomRes;
import com.collectpoint.bean.res.OrderInfoRes;
import com.collectpoint.bean.res.ScanPayRes;
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragOrdersettleBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.SDHandlerManager;
import com.collectpoint.widget.popupwindow.Confirm1Dialog;
import com.collectpoint.widget.popupwindow.PayDeWindow;
import com.collectpoint.widget.popupwindow.PayWindow;
import com.collectpoint.widget.popupwindow.PayZjWindow;
import com.collectpoint.widget.popupwindow.SettleRemarkWindow;
import com.collectpoint.widget.recycler.SRecyclerViewHolder;
import com.collectpoint.widget.recycler.SSelectedRecyclerAdapter;
import com.collectpoint.widget.recycler.SSimpleRecyclerAdapter;
import com.example.barcodelib.ScanBarCodeLib;
import com.example.barcodelib.ScanCallback;
import com.google.common.base.Preconditions;
import com.liuwq.base.MyActivityManager;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.recyclerview.GridSpacesItemDecoration;
import com.liuwq.base.widget.CustomDialogFragCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderSettleFrag extends BaseFragment implements View.OnClickListener, ScanCallback {
    public static final int REQUEST_CODE = 1;
    public static final int REQUEST_OUT = 2;
    private PayTypeAdapter adapter;
    private TimerTask countDownTask;
    private FragOrdersettleBinding mBinding;
    private PayWindow mapPopupWindow;
    private OrderAdapter orderAdapter;
    private OrderInfoReq orderInfoReq;
    private String order_id;
    private String out_trade_no;
    private PatrolVm patrolVm;
    private PayDeWindow payDeWindow;
    private String pay_price;
    private String pay_type;
    private String scanPayPrice;
    private SettleRemarkWindow settleRemarkWindow;
    private String settle_id;
    private String shop_supplier_id;
    private String table_id;
    private String user_id;
    private double finalPrice = -1.0d;
    private double givechange = 0.0d;
    private int packCouponNum = 0;
    private Timer timer = new Timer();
    private ScanBarCodeLib scanBarCodeLib = new ScanBarCodeLib(this);

    private class OrderAdapter extends SSimpleRecyclerAdapter<CouponItem> {
        public OrderAdapter(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493030;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, final CouponItem couponItem) {
            LinearLayout linearLayout = (LinearLayout) sRecyclerViewHolder.get(2131296659);
            TextView textView = (TextView) sRecyclerViewHolder.get(2131296983);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131297075);
            ImageView imageView = (ImageView) sRecyclerViewHolder.get(2131296606);
            imageView.setVisibility(TextUtils.equals(couponItem.getSettle_type(), "9") ? 8 : 0);
            boolean z = TextUtils.equals(couponItem.getSettle_type(), "1") || TextUtils.equals(couponItem.getSettle_type(), "2") || TextUtils.equals(couponItem.getSettle_type(), "4") || TextUtils.equals(couponItem.getSettle_type(), "9") || TextUtils.equals(couponItem.getSettle_type(), "10") || TextUtils.equals(couponItem.getSettle_type(), "3");
            linearLayout.setBackground(BackgroundLibUtil.getDrawable(2131165785, z ? 2131100174 : 2131099836));
            textView.setText(couponItem.getName());
            textView2.setText((z ? "-¥" : "¥") + couponItem.getDiscount_money().replace("-", ""));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.OrderAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str = "";
                    String str2 = "";
                    if ("1".equals(couponItem.getIs_douyin()) || "1".equals(couponItem.getIs_meituan())) {
                        str = "确定撤销【" + couponItem.getName() + "】的使用吗？";
                    } else if (TextUtils.equals(couponItem.getSettle_type(), "1") || TextUtils.equals(couponItem.getSettle_type(), "4") || TextUtils.equals(couponItem.getSettle_type(), "13")) {
                        str = "确定取消【" + couponItem.getName() + "（-￥" + couponItem.getDiscount_money() + "）】吗？";
                    } else if (TextUtils.equals(couponItem.getSettle_type(), "14") || TextUtils.equals(couponItem.getSettle_type(), "15") || TextUtils.equals(couponItem.getSettle_type(), "16")) {
                        str = "确定取消" + couponItem.getName() + "的¥" + couponItem.getDiscount_money() + "吗？";
                        str2 = "取消后该笔支付将原路退回";
                    } else if (TextUtils.equals(couponItem.getSettle_type(), "3") || TextUtils.equals(couponItem.getSettle_type(), "2") || TextUtils.equals(couponItem.getSettle_type(), "17")) {
                        str = "确定取消使用【" + couponItem.getName() + "】吗？";
                        str2 = "";
                    } else if (TextUtils.equals(couponItem.getSettle_type(), "11") || TextUtils.equals(couponItem.getSettle_type(), "12")) {
                        str = "确定取消" + couponItem.getName() + "的¥" + couponItem.getDiscount_money() + "吗？";
                        str2 = "取消后请在对应的app撤销该券的核销状态";
                    } else if (TextUtils.equals(couponItem.getSettle_type(), "12")) {
                        str = "确定取消云闪付的 ￥" + couponItem.getDiscount_money() + " 吗？";
                        str2 = "取消后该笔支付将原路退回";
                    } else if (TextUtils.equals(couponItem.getSettle_type(), "10")) {
                        str = "当前页面无法撤销赠送优惠，可回到上一个页面【退菜】取消赠送菜品。";
                        str2 = "";
                    }
                    Confirm1Dialog confirm1Dialog = new Confirm1Dialog(OrderSettleFrag.this.requireActivity());
                    confirm1Dialog.setData(str, str2);
                    if (TextUtils.equals(couponItem.getSettle_type(), "10")) {
                        confirm1Dialog.setButton(8, 8);
                    }
                    confirm1Dialog.setOnConfirmClickListener(new Confirm1Dialog.OnConfirmClickListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.OrderAdapter.1.1
                        @Override // com.collectpoint.widget.popupwindow.Confirm1Dialog.OnConfirmClickListener
                        public void onClick(View view2) {
                            if ("1".equals(couponItem.getIs_meituan())) {
                                OrderSettleFrag.this.patrolVm.refundMeituanCoupon(couponItem.getId());
                                return;
                            }
                            if ("1".equals(couponItem.getIs_douyin())) {
                                OrderSettleFrag.this.patrolVm.refundCoupon(couponItem.getId());
                                return;
                            }
                            if (!TextUtils.equals(couponItem.getSettle_type(), "14") && !TextUtils.equals(couponItem.getSettle_type(), "15") && !TextUtils.equals(couponItem.getSettle_type(), "16")) {
                                OrderSettleFrag.this.patrolVm.refundOrderCoupon(couponItem.getId());
                                return;
                            }
                            OrderSettleFrag.this.settle_id = couponItem.getSettle_id();
                            OrderSettleFrag.this.patrolVm.microRefund(couponItem.getOut_trade_no());
                        }
                    });
                    confirm1Dialog.show();
                }
            });
        }
    }

    private class PayTypeAdapter extends SSelectedRecyclerAdapter<CouponItem> {

        /* renamed from: com.collectpoint.moudle.product.OrderSettleFrag$PayTypeAdapter$1, reason: invalid class name */
        class AnonymousClass1 implements View.OnClickListener {
            final /* synthetic */ CouponItem val$model;
            final /* synthetic */ int val$position;

            AnonymousClass1(int i, CouponItem couponItem) {
                this.val$position = i;
                this.val$model = couponItem;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OrderSettleFrag.this.finalPrice == 0.0d) {
                    ToastUtils.showLong("已足够支付了，无需再增加结算方式");
                    return;
                }
                PayTypeAdapter.this.selectItem(this.val$position);
                if (TextUtils.equals("inner", this.val$model.getType())) {
                    Router.build(Constants.COUPONLIST_ACT).requestCode(1).with(Constants.KEY_ITEM, OrderSettleFrag.this.orderInfoReq).with(Constants.KEY_CODE, OrderSettleFrag.this.order_id).with(Constants.KEY_REPORT_TYPE, true).go(OrderSettleFrag.this);
                    return;
                }
                if (TextUtils.equals("out", this.val$model.getType())) {
                    Router.build(Constants.COUPONLISTTG_ACT).requestCode(2).with(Constants.KEY_ITEM, OrderSettleFrag.this.orderInfoReq).with(Constants.KEY_CODE, OrderSettleFrag.this.order_id).with(Constants.KEY_REPORT_TYPE, true).go(OrderSettleFrag.this);
                    return;
                }
                if (TextUtils.equals("scan", this.val$model.getType())) {
                    OrderSettleFrag.this.mapPopupWindow = new PayWindow(PayTypeAdapter.this.getActivity(), OrderSettleFrag.this.pay_price, new PayWindow.OnSiteClickListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.PayTypeAdapter.1.1
                        @Override // com.collectpoint.widget.popupwindow.PayWindow.OnSiteClickListener
                        public void onAttrSubmit(String str, String str2) {
                            OrderSettleFrag.this.patrolVm.sscanPay(OrderSettleFrag.this.order_id, OrderSettleFrag.this.scanPayPrice = str, str2);
                            if (OrderSettleFrag.this.mapPopupWindow != null) {
                                OrderSettleFrag.this.mapPopupWindow.setStatue("交易进行中，请等待...");
                            }
                        }
                    });
                    OrderSettleFrag.this.mapPopupWindow.show(OrderSettleFrag.this.mBinding.tvCoupon);
                    OrderSettleFrag.this.mapPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.PayTypeAdapter.1.2
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            SDHandlerManager.getMainHandler().postDelayed(new Runnable() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.PayTypeAdapter.1.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    OrderSettleFrag.this.closeKeyboard();
                                }
                            }, 1000L);
                        }
                    });
                    return;
                }
                if (TextUtils.equals("cash", this.val$model.getType())) {
                    PayZjWindow payZjWindow = new PayZjWindow(PayTypeAdapter.this.getActivity(), this.val$model.getName(), OrderSettleFrag.this.pay_price, new PayZjWindow.OnSiteClickListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.PayTypeAdapter.1.3
                        @Override // com.collectpoint.widget.popupwindow.PayZjWindow.OnSiteClickListener
                        public void onAttrSubmit(String str) {
                            if (EmptyUtils.isNotEmpty(str) && str.startsWith("¥")) {
                                str = str.substring(1);
                            }
                            CouponItem couponItem = new CouponItem();
                            couponItem.setSettle_type(AnonymousClass1.this.val$model.getSettle_type());
                            couponItem.setSettle_money(str);
                            couponItem.setOrder_id(OrderSettleFrag.this.order_id);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(couponItem);
                            OrderSettleFrag.this.patrolVm.addOrderCoupon(new AddOrderCouponReq(arrayList, OrderSettleFrag.this.order_id, "13"));
                        }
                    });
                    payZjWindow.show(OrderSettleFrag.this.mBinding.tvCoupon);
                    payZjWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.PayTypeAdapter.1.4
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            SDHandlerManager.getMainHandler().postDelayed(new Runnable() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.PayTypeAdapter.1.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    OrderSettleFrag.this.closeKeyboard();
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        }

        public PayTypeAdapter(Activity activity) {
            super(activity);
        }

        public CouponItem getChoiceItem() {
            for (T t : getList()) {
                if (t.isSelected()) {
                    return t;
                }
            }
            return null;
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493036;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, CouponItem couponItem) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131296993);
            ImageView imageView = (ImageView) sRecyclerViewHolder.get(2131297167);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131296983);
            TextView textView3 = (TextView) sRecyclerViewHolder.get(2131296987);
            sRecyclerViewHolder.get(2131296407).setBackground(couponItem.isSelected() ? BackgroundLibUtil.getBlueWw(2131165785) : BackgroundLibUtil.get333333Stroke(2131165785));
            textView2.setText(couponItem.getName());
            textView.setText(couponItem.getDesc());
            textView3.setVisibility(8);
            if (TextUtils.equals("scan", couponItem.getType())) {
                imageView.setBackground(BackgroundLibUtil.getDrawable(2131166007, 2131099752));
                imageView.setImageResource(2131231123);
            } else if (TextUtils.equals("inner", couponItem.getType())) {
                textView3.setVisibility(0);
                textView3.setBackground(BackgroundLibUtil.getBlue(2131166007));
                textView3.setText(OrderSettleFrag.this.packCouponNum + "张可用");
                imageView.setBackground(BackgroundLibUtil.getDrawable(2131166007, 2131099746));
                imageView.setImageResource(2131231012);
            } else if (TextUtils.equals("out", couponItem.getType())) {
                imageView.setBackground(BackgroundLibUtil.getDrawable(2131166007, 2131099757));
                imageView.setImageResource(2131231104);
            } else if (TextUtils.equals("cash", couponItem.getType())) {
                imageView.setBackground(BackgroundLibUtil.getDrawable(2131166007, 2131099750));
                imageView.setImageResource(2131231189);
            }
            sRecyclerViewHolder.itemView.setOnClickListener(new AnonymousClass1(i, couponItem));
        }
    }

    private void init() {
        this.table_id = getArguments().getString(Constants.KEY_CODE);
        this.shop_supplier_id = getArguments().getString(Constants.KEY_ROLE_CODE);
        this.user_id = getArguments().getString(Constants.KEY_ID);
        this.order_id = getArguments().getString(Constants.KEY_VILLAGE_CODE);
        this.mBinding.tvTitle.setText(getArguments().getString("name"));
        this.mBinding.srvPayStyle.setLayoutManager(new GridLayoutManager(requireActivity(), 3));
        PayTypeAdapter payTypeAdapter = new PayTypeAdapter(getActivity());
        this.adapter = payTypeAdapter;
        payTypeAdapter.setMode(SSelectedRecyclerAdapter.SelectedMode.SINGLE_MUST_ONE_SELECTED);
        this.mBinding.srvPayStyle.addItemDecoration(new GridSpacesItemDecoration(10));
        this.mBinding.srvPayStyle.setAdapter(this.adapter);
        this.mBinding.srvSettleDetail.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.orderAdapter = new OrderAdapter(getActivity());
        this.mBinding.srvSettleDetail.setAdapter(this.orderAdapter);
        this.mBinding.tvDiscount.setBackground(BackgroundLibUtil.get333333Stroke(2131165735));
        this.mBinding.tvSettlement.setBackground(BackgroundLibUtil.getBlue(2131165735));
        this.mBinding.tvCouponNum.setBackground(BackgroundLibUtil.getBlue(2131166007));
        this.mBinding.tvDiscount.setOnClickListener(this);
        this.mBinding.tvSettlement.setOnClickListener(this);
        this.mBinding.tvCoupon.setOnClickListener(this);
        this.mBinding.tvTitle.setOnClickListener(this);
        this.mBinding.tvProdunceList.setOnClickListener(this);
        this.mBinding.printOrder.setOnClickListener(this);
        this.mBinding.tvRemark.setOnClickListener(this);
        this.patrolVm.getOrderInfo(this.order_id, this.shop_supplier_id, this.user_id);
        this.patrolVm.getPaymentMethod(this.table_id);
        this.patrolVm.permissionList();
        this.patrolVm.getCouponList(this.table_id, this.order_id, this.shop_supplier_id, "", new ArrayList(), new ArrayList());
        this.patrolVm.getPackCouponList(this.table_id, this.order_id, this.shop_supplier_id, "", new ArrayList(), new ArrayList());
    }

    public static OrderSettleFrag newInstance(String str, String str2, String str3, String str4, String str5) {
        OrderSettleFrag orderSettleFrag = new OrderSettleFrag();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_CODE, str);
        bundle.putString(Constants.KEY_ID, str4);
        bundle.putString(Constants.KEY_ROLE_CODE, str2);
        bundle.putString(Constants.KEY_VILLAGE_CODE, str5);
        bundle.putString("name", str3);
        orderSettleFrag.setArguments(bundle);
        return orderSettleFrag;
    }

    private void showTip(String str) {
        Confirm1Dialog confirm1Dialog = new Confirm1Dialog(requireActivity());
        confirm1Dialog.setData("优惠券冲突提示", str, "");
        confirm1Dialog.setOnConfirmClickListener(new Confirm1Dialog.OnConfirmClickListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.3
            @Override // com.collectpoint.widget.popupwindow.Confirm1Dialog.OnConfirmClickListener
            public void onClick(View view) {
                Router.build(Constants.LOGIN).with(Constants.KEY_STATUS, true).go(OrderSettleFrag.this.getContext());
                OrderSettleFrag.this.requireActivity().finish();
                MyActivityManager.destroyAllActivity();
            }
        });
        confirm1Dialog.setButton(8, 8);
        confirm1Dialog.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m207lambda$onInit$0$comcollectpointmoudleproductOrderSettleFrag(Resource resource) {
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
                this.orderInfoReq = new OrderInfoReq(this.table_id, this.order_id, this.shop_supplier_id, this.user_id, ((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getSettleInfo().getCoupon(), ((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getSettleInfo().getSettle());
                this.order_id = ((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getOrder_id();
                this.mBinding.tvGdprice.setText(((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getTotal_price());
                this.mBinding.tvCoupon.setText("-¥" + ((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getDiscount_money());
                this.mBinding.tvSssum.setText(((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getShould_pay_price());
                TextView textView = this.mBinding.tvSettlement;
                StringBuilder sbAppend = new StringBuilder().append("还需收款  ¥");
                String pay_price = ((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getPay_price();
                this.pay_price = pay_price;
                textView.setText(sbAppend.append(pay_price).toString());
                this.mBinding.tvGivechange.setText("¥" + ((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getGiveChange());
                try {
                    this.givechange = Double.valueOf(((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getGiveChange()).doubleValue();
                } catch (Exception e) {
                    this.givechange = 0.0d;
                    e.printStackTrace();
                }
                try {
                    this.finalPrice = Double.valueOf(this.pay_price).doubleValue();
                } catch (Exception e2) {
                    this.finalPrice = -1.0d;
                    e2.printStackTrace();
                }
                if (this.finalPrice == 0.0d) {
                    this.mBinding.tvSettlement.setText("清台");
                }
                this.mBinding.tvProdunceList.setText("共" + ((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getProduct_num() + "件");
                ArrayList arrayList = new ArrayList();
                if (EmptyUtils.isNotEmpty(((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getSettleInfo().getSettle())) {
                    arrayList.addAll(((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getSettleInfo().getSettle());
                }
                if (EmptyUtils.isNotEmpty(((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getSettleInfo().getCoupon())) {
                    arrayList.addAll(((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getSettleInfo().getCoupon());
                }
                this.orderAdapter.setData(arrayList);
                if (EmptyUtils.isNotEmpty(((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getTip())) {
                    showTip(((OrderInfoRes) ((BaseDataRes) resource.data).getData()).getTip());
                    break;
                }
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
    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m208lambda$onInit$1$comcollectpointmoudleproductOrderSettleFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                this.adapter.setData((List) ((BaseDataRes) resource.data).getData());
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$10$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m209lambda$onInit$10$comcollectpointmoudleproductOrderSettleFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                if (EmptyUtils.isEmpty(((BaseDataRes) resource.data).getData())) {
                    this.mBinding.tvCouponNum.setText("0张可用");
                    break;
                } else {
                    int size = 0;
                    for (int i = 0; i < ((List) ((BaseDataRes) resource.data).getData()).size(); i++) {
                        size += ((CoupomRes) ((List) ((BaseDataRes) resource.data).getData()).get(i)).getCoupon().size();
                    }
                    this.mBinding.tvCouponNum.setText(size + "张可用");
                    break;
                }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$11$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m210lambda$onInit$11$comcollectpointmoudleproductOrderSettleFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                if (EmptyUtils.isNotEmpty(((BaseDataRes) resource.data).getData())) {
                    for (int i = 0; i < ((List) ((BaseDataRes) resource.data).getData()).size(); i++) {
                        this.packCouponNum += ((CoupomRes) ((List) ((BaseDataRes) resource.data).getData()).get(i)).getCoupon().size();
                    }
                    this.adapter.notifyDataSetChanged();
                    break;
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m211lambda$onInit$2$comcollectpointmoudleproductOrderSettleFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                this.patrolVm.getOrderInfo(this.order_id, this.shop_supplier_id, this.user_id);
                break;
            case 2:
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$3$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m212lambda$onInit$3$comcollectpointmoudleproductOrderSettleFrag(Resource resource) {
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
                ToastUtils.showLong("支付成功");
                getActivity().finish();
                postEvent(new FlashListEvent());
                postEvent(new FinishActtEvent(0));
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showLong(resource.message);
                this.patrolVm.getOrderInfo(this.order_id, this.shop_supplier_id, this.user_id);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$4$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m213lambda$onInit$4$comcollectpointmoudleproductOrderSettleFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                this.out_trade_no = ((ScanPayRes) ((BaseDataRes) resource.data).getData()).getOut_trade_no();
                this.pay_type = ((ScanPayRes) ((BaseDataRes) resource.data).getData()).getPay_type();
                stopTimer();
                queryPay();
                break;
            case 2:
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$5$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m214lambda$onInit$5$comcollectpointmoudleproductOrderSettleFrag(Resource resource) {
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

    /* renamed from: lambda$onInit$6$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m215lambda$onInit$6$comcollectpointmoudleproductOrderSettleFrag(Resource resource) {
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
                this.patrolVm.getOrderInfo(this.order_id, this.shop_supplier_id, this.user_id);
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
    /* renamed from: lambda$onInit$7$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m216lambda$onInit$7$comcollectpointmoudleproductOrderSettleFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                if (!TextUtils.equals("1", ((ScanPayRes) ((BaseResuleRes) resource.data).getData()).getStatus()) && !TextUtils.equals("已支付", resource.message)) {
                    PayWindow payWindow = this.mapPopupWindow;
                    if (payWindow != null) {
                        payWindow.setStatue("交易进行中，请等待...");
                        break;
                    }
                } else {
                    stopTimer();
                    this.patrolVm.getOrderInfo(this.order_id, this.shop_supplier_id, this.user_id);
                    ToastUtils.showLong("支付成功");
                    PayWindow payWindow2 = this.mapPopupWindow;
                    if (payWindow2 != null) {
                        payWindow2.setStatue("支付成功！");
                        SDHandlerManager.getMainHandler().postDelayed(new Runnable() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.1
                            @Override // java.lang.Runnable
                            public void run() {
                                OrderSettleFrag.this.mapPopupWindow.dismiss();
                            }
                        }, 1500L);
                        break;
                    }
                }
                break;
            case 2:
                if (TextUtils.equals("已支付", resource.message)) {
                    stopTimer();
                    this.patrolVm.getOrderInfo(this.order_id, this.shop_supplier_id, this.user_id);
                    ToastUtils.showLong("支付成功");
                    PayWindow payWindow3 = this.mapPopupWindow;
                    if (payWindow3 != null) {
                        payWindow3.setStatue("支付成功！");
                        SDHandlerManager.getMainHandler().postDelayed(new Runnable() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.2
                            @Override // java.lang.Runnable
                            public void run() {
                                OrderSettleFrag.this.mapPopupWindow.dismiss();
                            }
                        }, 1500L);
                        break;
                    }
                }
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$8$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m217lambda$onInit$8$comcollectpointmoudleproductOrderSettleFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                if (EmptyUtils.isNotEmpty(((BaseListRes) resource.data).getData())) {
                    for (int i = 0; i < ((BaseListRes) resource.data).getData().size(); i++) {
                        if (TextUtils.equals("quota", ((PermissionItem) ((BaseListRes) resource.data).getData().get(i)).getType()) && TextUtils.equals("1", ((PermissionItem) ((BaseListRes) resource.data).getData().get(i)).getIs_permission())) {
                            this.mBinding.tvDiscount.setVisibility(0);
                            break;
                        }
                    }
                    break;
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$9$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m218lambda$onInit$9$comcollectpointmoudleproductOrderSettleFrag(Resource resource) {
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
                this.patrolVm.getOrderInfo(this.order_id, this.shop_supplier_id, this.user_id);
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 || i == 2) {
            this.patrolVm.getOrderInfo(this.order_id, this.shop_supplier_id, this.user_id);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296743:
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
            case 2131296986:
                Router.build(Constants.COUPONLIST_ACT).requestCode(1).with(Constants.KEY_CODE, this.order_id).with(Constants.KEY_ITEM, this.orderInfoReq).go(this);
                break;
            case 2131296995:
                PayDeWindow payDeWindow = new PayDeWindow(getActivity(), "手工定额", this.pay_price, new PayDeWindow.OnSiteClickListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.6
                    @Override // com.collectpoint.widget.popupwindow.PayDeWindow.OnSiteClickListener
                    public void onAttrSubmit(String str, String str2) {
                        OrderSettleFrag.this.mBinding.tvDiscount.setTag(str2);
                        CouponItem couponItem = new CouponItem();
                        couponItem.setSettle_type("1");
                        couponItem.setSettle_money(str);
                        couponItem.setNum("1");
                        couponItem.setOrder_id(OrderSettleFrag.this.order_id);
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(couponItem);
                        OrderSettleFrag.this.patrolVm.addOrderCoupon(new AddOrderCouponReq(arrayList2, OrderSettleFrag.this.order_id, "1"));
                    }
                });
                this.payDeWindow = payDeWindow;
                payDeWindow.show(this.mBinding.tvCoupon);
                this.payDeWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.7
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        SDHandlerManager.getMainHandler().postDelayed(new Runnable() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                OrderSettleFrag.this.closeKeyboard();
                            }
                        }, 1000L);
                    }
                });
                break;
            case 2131297087:
                Router.build(Constants.ORDERDETAILLIST_ACT).requestCode(1).with(Constants.KEY_ITEM, this.orderInfoReq).with(Constants.KEY_CODE, this.order_id).with("name", "订单明细(" + this.mBinding.tvProdunceList.getText().toString() + ")").go(this);
                break;
            case 2131297096:
                SettleRemarkWindow settleRemarkWindow = new SettleRemarkWindow(getActivity(), new SettleRemarkWindow.OnSiteClickListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.4
                    @Override // com.collectpoint.widget.popupwindow.SettleRemarkWindow.OnSiteClickListener
                    public void onAttrSubmit(String str) {
                        OrderSettleFrag.this.mBinding.tvRemark.setText(str);
                    }
                });
                this.settleRemarkWindow = settleRemarkWindow;
                settleRemarkWindow.show(this.mBinding.tvCoupon);
                this.settleRemarkWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.5
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        SDHandlerManager.getMainHandler().postDelayed(new Runnable() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                OrderSettleFrag.this.closeKeyboard();
                            }
                        }, 1000L);
                    }
                });
                break;
            case 2131297113:
                if ("清台".equals(this.mBinding.tvSettlement.getText().toString())) {
                    if (this.givechange > 0.0d) {
                        boolean z = false;
                        OrderAdapter orderAdapter = this.orderAdapter;
                        if (orderAdapter != null && orderAdapter.getCount() > 0) {
                            int i2 = 0;
                            while (i2 < this.orderAdapter.getCount()) {
                                if (TextUtils.equals("13", this.orderAdapter.getItem(i2).getSettle_type())) {
                                    boolean z2 = Double.parseDouble(this.orderAdapter.getItem(i2).getDiscount_money()) > 0.0d;
                                    z = z2;
                                    if (z2) {
                                        i2 = 2147483646;
                                    }
                                }
                                i2++;
                            }
                        }
                        if (!z) {
                            ToastUtils.showLong("存在非现金导致的找零，请检查订单后再清台");
                            break;
                        }
                    }
                    List<CouponItem> coupon = this.orderInfoReq.getCoupon();
                    ArrayList arrayList2 = new ArrayList();
                    if (EmptyUtils.isNotEmpty(coupon)) {
                        for (int i3 = 0; i3 < coupon.size(); i3++) {
                            arrayList2.add(new CouponPayItem(coupon.get(i3).getSettle_id(), coupon.get(i3).getSettle_type(), coupon.get(i3).getSettle_money(), coupon.get(i3).getNum(), coupon.get(i3).getRadio(), coupon.get(i3).getUser_id()));
                        }
                    }
                    List<CouponItem> settle2 = this.orderInfoReq.getSettle();
                    ArrayList arrayList3 = new ArrayList();
                    if (EmptyUtils.isNotEmpty(settle2)) {
                        for (int i4 = 0; i4 < settle2.size(); i4++) {
                            arrayList3.add(new CouponPayItem(settle2.get(i4).getSettle_id(), settle2.get(i4).getSettle_type(), settle2.get(i4).getSettle_money(), settle2.get(i4).getNum(), settle2.get(i4).getOut_trade_no()));
                        }
                    }
                    OrderInfo2Req orderInfo2Req = new OrderInfo2Req(this.order_id, this.orderInfoReq.getShop_supplier_id(), this.user_id, arrayList2, arrayList3);
                    orderInfo2Req.setTable_id(this.orderInfoReq.getTable_id());
                    orderInfo2Req.setRemark(this.mBinding.tvRemark.getText().toString());
                    String str = "";
                    try {
                        str = (String) this.mBinding.tvDiscount.getTag();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    orderInfo2Req.setQuota_remark(str);
                    this.patrolVm.newPay(orderInfo2Req);
                    break;
                }
                break;
            case 2131297136:
                getActivity().finish();
                break;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        stopTimer();
        this.scanBarCodeLib.deInitBarCode(getContext());
    }

    protected void onInit() {
        this.patrolVm.mOrderInfo.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m207lambda$onInit$0$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mPaymentMethod.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda3
            public final void onChanged(Object obj) {
                this.f$0.m208lambda$onInit$1$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mVerifyCoupon.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda6
            public final void onChanged(Object obj) {
                this.f$0.m211lambda$onInit$2$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mNewPay.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda7
            public final void onChanged(Object obj) {
                this.f$0.m212lambda$onInit$3$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mScanPay.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda8
            public final void onChanged(Object obj) {
                this.f$0.m213lambda$onInit$4$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mPrintOrder.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda9
            public final void onChanged(Object obj) {
                this.f$0.m214lambda$onInit$5$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mMicroRefund.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda10
            public final void onChanged(Object obj) {
                this.f$0.m215lambda$onInit$6$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mScanPayQuery.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda11
            public final void onChanged(Object obj) {
                this.f$0.m216lambda$onInit$7$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mPermissionList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m217lambda$onInit$8$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mAddOrderCoupon.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m218lambda$onInit$9$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mCouponList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda4
            public final void onChanged(Object obj) {
                this.f$0.m209lambda$onInit$10$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mPackCouponList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda5
            public final void onChanged(Object obj) {
                this.f$0.m210lambda$onInit$11$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
    }

    public void onScanBack(String str) {
        PayWindow payWindow = this.mapPopupWindow;
        if (payWindow == null || !payWindow.isShowing()) {
            return;
        }
        this.mapPopupWindow.setBarcode(str);
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragOrdersettleBinding fragOrdersettleBinding = (FragOrdersettleBinding) DataBindingUtil.inflate(layoutInflater, 2131492986, viewGroup, false);
        this.mBinding = fragOrdersettleBinding;
        fragOrdersettleBinding.setLifecycleOwner(this);
        this.patrolVm = ViewModelProviders.of(this, PatrolVmFactory.getInstance(MyApp.getInstance())).get(PatrolVm.class);
        this.scanBarCodeLib.initBarCode(getContext());
        init();
        return this.mBinding.getRoot();
    }

    public void queryPay() {
        TimerTask timerTask = this.countDownTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.timer = new Timer();
        TimerTask timerTask2 = new TimerTask() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.8
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SDHandlerManager.getMainHandler().post(new Runnable() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OrderSettleFrag.this.patrolVm.scanPayQuery(OrderSettleFrag.this.out_trade_no);
                    }
                });
            }
        };
        this.countDownTask = timerTask2;
        this.timer.schedule(timerTask2, 0L, 3000L);
    }

    public void stopTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer.purge();
            this.timer = null;
        }
    }
}
