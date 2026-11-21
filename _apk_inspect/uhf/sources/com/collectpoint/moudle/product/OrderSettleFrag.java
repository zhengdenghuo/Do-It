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

    public static OrderSettleFrag newInstance(String table_id, String shop_supplier_id, String table_name, String user_id, String order_id) {
        OrderSettleFrag fragment = new OrderSettleFrag();
        Bundle args = new Bundle();
        args.putString("code", table_id);
        args.putString("id", user_id);
        args.putString("KEY_ROLE_CODE", shop_supplier_id);
        args.putString("villageCode", order_id);
        args.putString("name", table_name);
        fragment.setArguments(args);
        return fragment;
    }

    protected View provideContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragOrdersettleBinding fragOrdersettleBindingInflate = DataBindingUtil.inflate(inflater, 2131492986, container, false);
        this.mBinding = fragOrdersettleBindingInflate;
        fragOrdersettleBindingInflate.setLifecycleOwner(this);
        PatrolVmFactory vmFactory = PatrolVmFactory.getInstance(MyApp.getInstance());
        this.patrolVm = ViewModelProviders.of(this, vmFactory).get(PatrolVm.class);
        this.scanBarCodeLib.initBarCode(getContext());
        init();
        return this.mBinding.getRoot();
    }

    private void init() {
        this.table_id = getArguments().getString("code");
        this.shop_supplier_id = getArguments().getString("KEY_ROLE_CODE");
        this.user_id = getArguments().getString("id");
        this.order_id = getArguments().getString("villageCode");
        this.mBinding.tvTitle.setText(getArguments().getString("name"));
        GridLayoutManager layoutManager = new GridLayoutManager(requireActivity(), 3);
        this.mBinding.srvPayStyle.setLayoutManager(layoutManager);
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

    protected void onInit() {
        this.patrolVm.mOrderInfo.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m28lambda$onInit$0$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mPaymentMethod.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda3
            public final void onChanged(Object obj) {
                this.f$0.m29lambda$onInit$1$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mVerifyCoupon.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda6
            public final void onChanged(Object obj) {
                this.f$0.m32lambda$onInit$2$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mNewPay.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda7
            public final void onChanged(Object obj) {
                this.f$0.m33lambda$onInit$3$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mScanPay.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda8
            public final void onChanged(Object obj) {
                this.f$0.m34lambda$onInit$4$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mPrintOrder.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda9
            public final void onChanged(Object obj) {
                this.f$0.m35lambda$onInit$5$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mMicroRefund.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda10
            public final void onChanged(Object obj) {
                this.f$0.m36lambda$onInit$6$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mScanPayQuery.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda11
            public final void onChanged(Object obj) {
                this.f$0.m37lambda$onInit$7$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mPermissionList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m38lambda$onInit$8$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mAddOrderCoupon.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m39lambda$onInit$9$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mCouponList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda4
            public final void onChanged(Object obj) {
                this.f$0.m30lambda$onInit$10$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
        this.patrolVm.mPackCouponList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderSettleFrag$$ExternalSyntheticLambda5
            public final void onChanged(Object obj) {
                this.f$0.m31lambda$onInit$11$comcollectpointmoudleproductOrderSettleFrag((Resource) obj);
            }
        });
    }

    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m28lambda$onInit$0$comcollectpointmoudleproductOrderSettleFrag(Resource result) {
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
            case REQUEST_CODE /* 1 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                this.orderInfoReq = new OrderInfoReq(this.table_id, this.order_id, this.shop_supplier_id, this.user_id, ((OrderInfoRes) ((BaseDataRes) result.data).getData()).getSettleInfo().getCoupon(), ((OrderInfoRes) ((BaseDataRes) result.data).getData()).getSettleInfo().getSettle());
                this.order_id = ((OrderInfoRes) ((BaseDataRes) result.data).getData()).getOrder_id();
                this.mBinding.tvGdprice.setText(((OrderInfoRes) ((BaseDataRes) result.data).getData()).getTotal_price());
                this.mBinding.tvCoupon.setText("-¥" + ((OrderInfoRes) ((BaseDataRes) result.data).getData()).getDiscount_money());
                this.mBinding.tvSssum.setText(((OrderInfoRes) ((BaseDataRes) result.data).getData()).getShould_pay_price());
                TextView textView = this.mBinding.tvSettlement;
                StringBuilder sbAppend = new StringBuilder().append("还需收款  ¥");
                String pay_price = ((OrderInfoRes) ((BaseDataRes) result.data).getData()).getPay_price();
                this.pay_price = pay_price;
                textView.setText(sbAppend.append(pay_price).toString());
                this.mBinding.tvGivechange.setText("¥" + ((OrderInfoRes) ((BaseDataRes) result.data).getData()).getGiveChange());
                try {
                    this.givechange = Double.valueOf(((OrderInfoRes) ((BaseDataRes) result.data).getData()).getGiveChange()).doubleValue();
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
                this.mBinding.tvProdunceList.setText("共" + ((OrderInfoRes) ((BaseDataRes) result.data).getData()).getProduct_num() + "件");
                List<CouponItem> list = new ArrayList<>();
                if (EmptyUtils.isNotEmpty(((OrderInfoRes) ((BaseDataRes) result.data).getData()).getSettleInfo().getSettle())) {
                    list.addAll(((OrderInfoRes) ((BaseDataRes) result.data).getData()).getSettleInfo().getSettle());
                }
                if (EmptyUtils.isNotEmpty(((OrderInfoRes) ((BaseDataRes) result.data).getData()).getSettleInfo().getCoupon())) {
                    list.addAll(((OrderInfoRes) ((BaseDataRes) result.data).getData()).getSettleInfo().getCoupon());
                }
                this.orderAdapter.setData(list);
                if (EmptyUtils.isNotEmpty(((OrderInfoRes) ((BaseDataRes) result.data).getData()).getTip())) {
                    showTip(((OrderInfoRes) ((BaseDataRes) result.data).getData()).getTip());
                    break;
                }
                break;
            case REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m29lambda$onInit$1$comcollectpointmoudleproductOrderSettleFrag(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case REQUEST_CODE /* 1 */:
                this.adapter.setData((List) ((BaseDataRes) result.data).getData());
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m32lambda$onInit$2$comcollectpointmoudleproductOrderSettleFrag(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case REQUEST_CODE /* 1 */:
                this.patrolVm.getOrderInfo(this.order_id, this.shop_supplier_id, this.user_id);
                break;
            case REQUEST_OUT /* 2 */:
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$3$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m33lambda$onInit$3$comcollectpointmoudleproductOrderSettleFrag(Resource result) {
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
            case REQUEST_CODE /* 1 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong("支付成功");
                getActivity().finish();
                postEvent(new FlashListEvent());
                postEvent(new FinishActtEvent(0));
                break;
            case REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                this.patrolVm.getOrderInfo(this.order_id, this.shop_supplier_id, this.user_id);
                break;
        }
    }

    /* renamed from: lambda$onInit$4$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m34lambda$onInit$4$comcollectpointmoudleproductOrderSettleFrag(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case REQUEST_CODE /* 1 */:
                this.out_trade_no = ((ScanPayRes) ((BaseDataRes) result.data).getData()).getOut_trade_no();
                this.pay_type = ((ScanPayRes) ((BaseDataRes) result.data).getData()).getPay_type();
                stopTimer();
                queryPay();
                break;
            case REQUEST_OUT /* 2 */:
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$5$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m35lambda$onInit$5$comcollectpointmoudleproductOrderSettleFrag(Resource result) {
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
            case REQUEST_CODE /* 1 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong("打印成功");
                break;
            case REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$6$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m36lambda$onInit$6$comcollectpointmoudleproductOrderSettleFrag(Resource result) {
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
            case REQUEST_CODE /* 1 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                this.patrolVm.getOrderInfo(this.order_id, this.shop_supplier_id, this.user_id);
                break;
            case REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$7$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m37lambda$onInit$7$comcollectpointmoudleproductOrderSettleFrag(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case REQUEST_CODE /* 1 */:
                if (TextUtils.equals("1", ((ScanPayRes) ((BaseResuleRes) result.data).getData()).getStatus()) || TextUtils.equals("已支付", result.message)) {
                    stopTimer();
                    this.patrolVm.getOrderInfo(this.order_id, this.shop_supplier_id, this.user_id);
                    ToastUtils.showLong("支付成功");
                    PayWindow payWindow = this.mapPopupWindow;
                    if (payWindow != null) {
                        payWindow.setStatue("支付成功！");
                        SDHandlerManager.getMainHandler().postDelayed(new Runnable() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.1
                            @Override // java.lang.Runnable
                            public void run() {
                                OrderSettleFrag.this.mapPopupWindow.dismiss();
                            }
                        }, 1500L);
                        break;
                    }
                } else {
                    PayWindow payWindow2 = this.mapPopupWindow;
                    if (payWindow2 != null) {
                        payWindow2.setStatue("交易进行中，请等待...");
                        break;
                    }
                }
                break;
            case REQUEST_OUT /* 2 */:
                if (TextUtils.equals("已支付", result.message)) {
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

    /* renamed from: lambda$onInit$8$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m38lambda$onInit$8$comcollectpointmoudleproductOrderSettleFrag(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case REQUEST_CODE /* 1 */:
                if (EmptyUtils.isNotEmpty(((BaseListRes) result.data).getData())) {
                    for (int i = 0; i < ((BaseListRes) result.data).getData().size(); i++) {
                        if (TextUtils.equals("quota", ((PermissionItem) ((BaseListRes) result.data).getData().get(i)).getType()) && TextUtils.equals("1", ((PermissionItem) ((BaseListRes) result.data).getData().get(i)).getIs_permission())) {
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
    /* synthetic */ void m39lambda$onInit$9$comcollectpointmoudleproductOrderSettleFrag(Resource result) {
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
            case REQUEST_CODE /* 1 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                this.patrolVm.getOrderInfo(this.order_id, this.shop_supplier_id, this.user_id);
                break;
            case REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$10$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m30lambda$onInit$10$comcollectpointmoudleproductOrderSettleFrag(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case REQUEST_CODE /* 1 */:
                if (EmptyUtils.isEmpty(((BaseDataRes) result.data).getData())) {
                    this.mBinding.tvCouponNum.setText("0张可用");
                    break;
                } else {
                    int size = 0;
                    for (int i = 0; i < ((List) ((BaseDataRes) result.data).getData()).size(); i++) {
                        size += ((CoupomRes) ((List) ((BaseDataRes) result.data).getData()).get(i)).getCoupon().size();
                    }
                    this.mBinding.tvCouponNum.setText(size + "张可用");
                    break;
                }
        }
    }

    /* renamed from: lambda$onInit$11$com-collectpoint-moudle-product-OrderSettleFrag, reason: not valid java name */
    /* synthetic */ void m31lambda$onInit$11$comcollectpointmoudleproductOrderSettleFrag(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case REQUEST_CODE /* 1 */:
                if (EmptyUtils.isNotEmpty(((BaseDataRes) result.data).getData())) {
                    for (int i = 0; i < ((List) ((BaseDataRes) result.data).getData()).size(); i++) {
                        this.packCouponNum += ((CoupomRes) ((List) ((BaseDataRes) result.data).getData()).get(i)).getCoupon().size();
                    }
                    this.adapter.notifyDataSetChanged();
                    break;
                }
                break;
        }
    }

    private void showTip(String tip) {
        Confirm1Dialog myAlertInputDialog1 = new Confirm1Dialog(requireActivity());
        myAlertInputDialog1.setData("优惠券冲突提示", tip, "");
        myAlertInputDialog1.setOnConfirmClickListener(new Confirm1Dialog.OnConfirmClickListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.3
            public void onClick(View view) {
                Router.build("login").with("status", true).go(OrderSettleFrag.this.getContext());
                OrderSettleFrag.this.requireActivity().finish();
                MyActivityManager.destroyAllActivity();
            }
        });
        myAlertInputDialog1.setButton(8, 8);
        myAlertInputDialog1.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws NumberFormatException {
        switch (view.getId()) {
            case 2131296743:
                if (this.orderInfoReq != null) {
                    List<CouponPayItem> settlepayItems = new ArrayList<>();
                    List<CouponItem> settleItems = this.orderInfoReq.getSettle();
                    if (EmptyUtils.isNotEmpty(settleItems)) {
                        for (int i = 0; i < settleItems.size(); i++) {
                            settlepayItems.add(new CouponPayItem(settleItems.get(i).getSettle_id(), settleItems.get(i).getSettle_type(), settleItems.get(i).getSettle_money(), settleItems.get(i).getNum(), settleItems.get(i).getOut_trade_no()));
                        }
                    }
                    this.patrolVm.printOrder(new OrderInfo2Req(this.order_id, settlepayItems));
                    break;
                }
                break;
            case 2131296986:
                Router.build("CouponListAct").requestCode(1).with("code", this.order_id).with("item", this.orderInfoReq).go(this);
                break;
            case 2131296995:
                PayDeWindow payDeWindow = new PayDeWindow(getActivity(), "手工定额", this.pay_price, new PayDeWindow.OnSiteClickListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.6
                    public void onAttrSubmit(String price, String remark) {
                        OrderSettleFrag.this.mBinding.tvDiscount.setTag(remark);
                        CouponItem data = new CouponItem();
                        data.setSettle_type("1");
                        data.setSettle_money(price);
                        data.setNum("1");
                        data.setOrder_id(OrderSettleFrag.this.order_id);
                        List<CouponItem> list = new ArrayList<>();
                        list.add(data);
                        AddOrderCouponReq req = new AddOrderCouponReq(list, OrderSettleFrag.this.order_id, "1");
                        OrderSettleFrag.this.patrolVm.addOrderCoupon(req);
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
                Router.build("OrderDetailListAct").requestCode(1).with("item", this.orderInfoReq).with("code", this.order_id).with("name", "订单明细(" + this.mBinding.tvProdunceList.getText().toString() + ")").go(this);
                break;
            case 2131297096:
                SettleRemarkWindow settleRemarkWindow = new SettleRemarkWindow(getActivity(), new SettleRemarkWindow.OnSiteClickListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.4
                    public void onAttrSubmit(String remark) {
                        OrderSettleFrag.this.mBinding.tvRemark.setText(remark);
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
                        boolean hasCase = false;
                        OrderAdapter orderAdapter = this.orderAdapter;
                        if (orderAdapter != null && orderAdapter.getCount() > 0) {
                            int i2 = 0;
                            while (i2 < this.orderAdapter.getCount()) {
                                if (TextUtils.equals("13", ((CouponItem) this.orderAdapter.getItem(i2)).getSettle_type())) {
                                    double cases = Double.parseDouble(((CouponItem) this.orderAdapter.getItem(i2)).getDiscount_money());
                                    boolean z = cases > 0.0d;
                                    hasCase = z;
                                    if (z) {
                                        i2 = 2147483646;
                                    }
                                }
                                i2++;
                            }
                        }
                        if (!hasCase) {
                            ToastUtils.showLong("存在非现金导致的找零，请检查订单后再清台");
                            break;
                        }
                    }
                    List<CouponItem> couponItems = this.orderInfoReq.getCoupon();
                    List<CouponPayItem> couponpayItems = new ArrayList<>();
                    if (EmptyUtils.isNotEmpty(couponItems)) {
                        for (int i3 = 0; i3 < couponItems.size(); i3++) {
                            couponpayItems.add(new CouponPayItem(couponItems.get(i3).getSettle_id(), couponItems.get(i3).getSettle_type(), couponItems.get(i3).getSettle_money(), couponItems.get(i3).getNum(), couponItems.get(i3).getRadio(), couponItems.get(i3).getUser_id()));
                        }
                    }
                    List<CouponItem> settleItems2 = this.orderInfoReq.getSettle();
                    List<CouponPayItem> settlepayItems2 = new ArrayList<>();
                    if (EmptyUtils.isNotEmpty(settleItems2)) {
                        for (int i4 = 0; i4 < settleItems2.size(); i4++) {
                            settlepayItems2.add(new CouponPayItem(settleItems2.get(i4).getSettle_id(), settleItems2.get(i4).getSettle_type(), settleItems2.get(i4).getSettle_money(), settleItems2.get(i4).getNum(), settleItems2.get(i4).getOut_trade_no()));
                        }
                    }
                    OrderInfo2Req info2Req = new OrderInfo2Req(this.order_id, this.orderInfoReq.getShop_supplier_id(), this.user_id, couponpayItems, settlepayItems2);
                    info2Req.setTable_id(this.orderInfoReq.getTable_id());
                    info2Req.setRemark(this.mBinding.tvRemark.getText().toString());
                    String quota_remark = "";
                    try {
                        quota_remark = (String) this.mBinding.tvDiscount.getTag();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    info2Req.setQuota_remark(quota_remark);
                    this.patrolVm.newPay(info2Req);
                    break;
                }
                break;
            case 2131297136:
                getActivity().finish();
                break;
        }
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

    public void onDestroy() {
        super.onDestroy();
        stopTimer();
        this.scanBarCodeLib.deInitBarCode(getContext());
    }

    private class OrderAdapter extends SSimpleRecyclerAdapter<CouponItem> {
        public OrderAdapter(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, int position, final CouponItem data) {
            LinearLayout ll_content = (LinearLayout) holder.get(2131296659);
            TextView tv_content = (TextView) holder.get(2131296983);
            TextView tv_price = (TextView) holder.get(2131297075);
            ImageView iv_dele = (ImageView) holder.get(2131296606);
            iv_dele.setVisibility(TextUtils.equals(data.getSettle_type(), "9") ? 8 : 0);
            boolean isCounp = TextUtils.equals(data.getSettle_type(), "1") || TextUtils.equals(data.getSettle_type(), "2") || TextUtils.equals(data.getSettle_type(), "4") || TextUtils.equals(data.getSettle_type(), "9") || TextUtils.equals(data.getSettle_type(), "10") || TextUtils.equals(data.getSettle_type(), "3");
            ll_content.setBackground(BackgroundLibUtil.getDrawable(2131165785, isCounp ? 2131100174 : 2131099836));
            tv_content.setText(data.getName());
            String dismoney = data.getDiscount_money().replace("-", "");
            tv_price.setText((isCounp ? "-¥" : "¥") + dismoney);
            iv_dele.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.OrderAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String firHint = "";
                    String secondHint = "";
                    if ("1".equals(data.getIs_douyin()) || "1".equals(data.getIs_meituan())) {
                        firHint = "确定撤销【" + data.getName() + "】的使用吗？";
                    } else if (TextUtils.equals(data.getSettle_type(), "1") || TextUtils.equals(data.getSettle_type(), "4") || TextUtils.equals(data.getSettle_type(), "13")) {
                        firHint = "确定取消【" + data.getName() + "（-￥" + data.getDiscount_money() + "）】吗？";
                    } else if (TextUtils.equals(data.getSettle_type(), "14") || TextUtils.equals(data.getSettle_type(), "15") || TextUtils.equals(data.getSettle_type(), "16")) {
                        firHint = "确定取消" + data.getName() + "的¥" + data.getDiscount_money() + "吗？";
                        secondHint = "取消后该笔支付将原路退回";
                    } else if (TextUtils.equals(data.getSettle_type(), "3") || TextUtils.equals(data.getSettle_type(), "2") || TextUtils.equals(data.getSettle_type(), "17")) {
                        firHint = "确定取消使用【" + data.getName() + "】吗？";
                        secondHint = "";
                    } else if (TextUtils.equals(data.getSettle_type(), "11") || TextUtils.equals(data.getSettle_type(), "12")) {
                        firHint = "确定取消" + data.getName() + "的¥" + data.getDiscount_money() + "吗？";
                        secondHint = "取消后请在对应的app撤销该券的核销状态";
                    } else if (TextUtils.equals(data.getSettle_type(), "12")) {
                        firHint = "确定取消云闪付的 ￥" + data.getDiscount_money() + " 吗？";
                        secondHint = "取消后该笔支付将原路退回";
                    } else if (TextUtils.equals(data.getSettle_type(), "10")) {
                        firHint = "当前页面无法撤销赠送优惠，可回到上一个页面【退菜】取消赠送菜品。";
                        secondHint = "";
                    }
                    Confirm1Dialog myAlertInputDialog1 = new Confirm1Dialog(OrderSettleFrag.this.requireActivity());
                    myAlertInputDialog1.setData(firHint, secondHint);
                    if (TextUtils.equals(data.getSettle_type(), "10")) {
                        myAlertInputDialog1.setButton(8, 8);
                    }
                    myAlertInputDialog1.setOnConfirmClickListener(new Confirm1Dialog.OnConfirmClickListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.OrderAdapter.1.1
                        public void onClick(View view2) {
                            if ("1".equals(data.getIs_meituan())) {
                                OrderSettleFrag.this.patrolVm.refundMeituanCoupon(data.getId());
                                return;
                            }
                            if ("1".equals(data.getIs_douyin())) {
                                OrderSettleFrag.this.patrolVm.refundCoupon(data.getId());
                                return;
                            }
                            if (!TextUtils.equals(data.getSettle_type(), "14") && !TextUtils.equals(data.getSettle_type(), "15") && !TextUtils.equals(data.getSettle_type(), "16")) {
                                OrderSettleFrag.this.patrolVm.refundOrderCoupon(data.getId());
                                return;
                            }
                            OrderSettleFrag.this.settle_id = data.getSettle_id();
                            OrderSettleFrag.this.patrolVm.microRefund(data.getOut_trade_no());
                        }
                    });
                    myAlertInputDialog1.show();
                }
            });
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493030;
        }
    }

    private class PayTypeAdapter extends SSelectedRecyclerAdapter<CouponItem> {
        public PayTypeAdapter(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, int position, CouponItem model) {
            TextView tv_describe = (TextView) holder.get(2131296993);
            ImageView v_add = (ImageView) holder.get(2131297167);
            TextView tv_content = (TextView) holder.get(2131296983);
            TextView tv_coupon_num = (TextView) holder.get(2131296987);
            View cl_content = holder.get(2131296407);
            cl_content.setBackground(model.isSelected() ? BackgroundLibUtil.getBlueWw(2131165785) : BackgroundLibUtil.get333333Stroke(2131165785));
            tv_content.setText(model.getName());
            tv_describe.setText(model.getDesc());
            tv_coupon_num.setVisibility(8);
            if (TextUtils.equals("scan", model.getType())) {
                v_add.setBackground(BackgroundLibUtil.getDrawable(2131166007, 2131099752));
                v_add.setImageResource(2131231123);
            } else if (TextUtils.equals("inner", model.getType())) {
                tv_coupon_num.setVisibility(0);
                tv_coupon_num.setBackground(BackgroundLibUtil.getBlue(2131166007));
                tv_coupon_num.setText(OrderSettleFrag.this.packCouponNum + "张可用");
                v_add.setBackground(BackgroundLibUtil.getDrawable(2131166007, 2131099746));
                v_add.setImageResource(2131231012);
            } else if (TextUtils.equals("out", model.getType())) {
                v_add.setBackground(BackgroundLibUtil.getDrawable(2131166007, 2131099757));
                v_add.setImageResource(2131231104);
            } else if (TextUtils.equals("cash", model.getType())) {
                v_add.setBackground(BackgroundLibUtil.getDrawable(2131166007, 2131099750));
                v_add.setImageResource(2131231189);
            }
            holder.itemView.setOnClickListener(new AnonymousClass1(position, model));
        }

        /* renamed from: com.collectpoint.moudle.product.OrderSettleFrag$PayTypeAdapter$1, reason: invalid class name */
        class AnonymousClass1 implements View.OnClickListener {
            final /* synthetic */ CouponItem val$model;
            final /* synthetic */ int val$position;

            AnonymousClass1(final int val$position, final CouponItem val$model) {
                this.val$position = val$position;
                this.val$model = val$model;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (OrderSettleFrag.this.finalPrice == 0.0d) {
                    ToastUtils.showLong("已足够支付了，无需再增加结算方式");
                    return;
                }
                PayTypeAdapter.this.selectItem(this.val$position);
                if (TextUtils.equals("inner", this.val$model.getType())) {
                    Router.build("CouponListAct").requestCode(1).with("item", OrderSettleFrag.this.orderInfoReq).with("code", OrderSettleFrag.this.order_id).with("reportType", true).go(OrderSettleFrag.this);
                    return;
                }
                if (TextUtils.equals("out", this.val$model.getType())) {
                    Router.build("CouponListTgAct").requestCode(2).with("item", OrderSettleFrag.this.orderInfoReq).with("code", OrderSettleFrag.this.order_id).with("reportType", true).go(OrderSettleFrag.this);
                    return;
                }
                if (TextUtils.equals("scan", this.val$model.getType())) {
                    OrderSettleFrag.this.mapPopupWindow = new PayWindow(PayTypeAdapter.this.getActivity(), OrderSettleFrag.this.pay_price, new PayWindow.OnSiteClickListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.PayTypeAdapter.1.1
                        public void onAttrSubmit(String price, String auth_code) {
                            OrderSettleFrag.this.patrolVm.sscanPay(OrderSettleFrag.this.order_id, OrderSettleFrag.this.scanPayPrice = price, auth_code);
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
                    PayZjWindow zjWindow = new PayZjWindow(PayTypeAdapter.this.getActivity(), this.val$model.getName(), OrderSettleFrag.this.pay_price, new PayZjWindow.OnSiteClickListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.PayTypeAdapter.1.3
                        public void onAttrSubmit(String price) {
                            if (EmptyUtils.isNotEmpty(price) && price.startsWith("¥")) {
                                price = price.substring(1);
                            }
                            CouponItem data = new CouponItem();
                            data.setSettle_type(AnonymousClass1.this.val$model.getSettle_type());
                            data.setSettle_money(price);
                            data.setOrder_id(OrderSettleFrag.this.order_id);
                            List<CouponItem> list = new ArrayList<>();
                            list.add(data);
                            AddOrderCouponReq req = new AddOrderCouponReq(list, OrderSettleFrag.this.order_id, "13");
                            OrderSettleFrag.this.patrolVm.addOrderCoupon(req);
                        }
                    });
                    zjWindow.show(OrderSettleFrag.this.mBinding.tvCoupon);
                    zjWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.collectpoint.moudle.product.OrderSettleFrag.PayTypeAdapter.1.4
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

        public CouponItem getChoiceItem() {
            for (CouponItem item : getList()) {
                if (item.isSelected()) {
                    return item;
                }
            }
            return null;
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493036;
        }
    }

    public void onScanBack(String barcode) {
        PayWindow payWindow = this.mapPopupWindow;
        if (payWindow != null && payWindow.isShowing()) {
            this.mapPopupWindow.setBarcode(barcode);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 || requestCode == 2) {
            this.patrolVm.getOrderInfo(this.order_id, this.shop_supplier_id, this.user_id);
        }
    }
}
