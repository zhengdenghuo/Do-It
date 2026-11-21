package com.collectpoint.moudle.product;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chenenyu.router.Router;
import com.collectpoint.MyApp;
import com.collectpoint.bean.even.FinishActtEvent;
import com.collectpoint.bean.even.FlashListEvent;
import com.collectpoint.bean.item.ProductItem;
import com.collectpoint.bean.res.HallCartDetailRes;
import com.collectpoint.databinding.FragOrderdetailBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.SDHandlerManager;
import com.collectpoint.widget.SlidingDeleteView;
import com.collectpoint.widget.bottomscroll.ShortSlideListener;
import com.collectpoint.widget.popupwindow.Confirm1Dialog;
import com.collectpoint.widget.popupwindow.NumFixDialog;
import com.collectpoint.widget.popupwindow.NumWindow;
import com.collectpoint.widget.recycler.SRecyclerViewHolder;
import com.collectpoint.widget.recycler.SSimpleRecyclerAdapter;
import com.google.common.base.Preconditions;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.widget.CustomDialogFragCompat;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderDetailFrag extends BaseFragment implements View.OnClickListener {
    private OrderAdapter adapter;
    private FragOrderdetailBinding mBinding;
    private NumWindow mapPopupWindow;
    private String order_id;
    private PatrolVm patrolVm;
    private String shop_supplier_id;
    private String tableName;
    private String table_id;
    private String user_id;

    public static OrderDetailFrag newInstance(String table_id, String table_name) {
        OrderDetailFrag fragment = new OrderDetailFrag();
        Bundle args = new Bundle();
        args.putString("code", table_id);
        args.putString("name", table_name);
        fragment.setArguments(args);
        return fragment;
    }

    protected View provideContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragOrderdetailBinding fragOrderdetailBindingInflate = DataBindingUtil.inflate(inflater, 2131492983, container, false);
        this.mBinding = fragOrderdetailBindingInflate;
        fragOrderdetailBindingInflate.setLifecycleOwner(this);
        PatrolVmFactory vmFactory = PatrolVmFactory.getInstance(MyApp.getInstance());
        this.patrolVm = ViewModelProviders.of(this, vmFactory).get(PatrolVm.class);
        init();
        return this.mBinding.getRoot();
    }

    protected void onLazyLoadingData() {
        this.patrolVm.orderDetail(this.table_id);
    }

    private void init() {
        this.table_id = getArguments().getString("code");
        this.tableName = getArguments().getString("name");
        this.mBinding.tvTitle.setOnClickListener(this);
        this.mBinding.tvAddMenu.setOnClickListener(this);
        this.mBinding.tvGive.setOnClickListener(this);
        this.mBinding.tvSmartScan.setOnClickListener(this);
        this.mBinding.tvSwitchTask.setOnClickListener(this);
        this.mBinding.tvCheckAcount.setOnClickListener(this);
        this.mBinding.tvEditMealNum.setOnClickListener(this);
        this.mBinding.tvMerge.setOnClickListener(this);
        this.mBinding.srvOrder.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.adapter = new OrderAdapter(getActivity());
        this.mBinding.srvOrder.setAdapter(this.adapter);
        this.mBinding.slideLayout.setShortSlideListener(new ShortSlideListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.1
            public void onShortSlide(boolean istop) {
                if (istop) {
                    OrderDetailFrag.this.mBinding.tvLine2.setText("下拉收起");
                    OrderDetailFrag.this.mBinding.tvLine2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131231024, 0);
                } else {
                    OrderDetailFrag.this.mBinding.tvLine2.setText("上滑展开");
                    OrderDetailFrag.this.mBinding.tvLine2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131231177, 0);
                }
            }
        });
    }

    protected void onInit() {
        this.patrolVm.mOrderDetail.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m16lambda$onInit$0$comcollectpointmoudleproductOrderDetailFrag((Resource) obj);
            }
        });
        this.patrolVm.mOrderCancel.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m17lambda$onInit$1$comcollectpointmoudleproductOrderDetailFrag((Resource) obj);
            }
        });
        this.patrolVm.mMoveProduct.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m18lambda$onInit$2$comcollectpointmoudleproductOrderDetailFrag((Resource) obj);
            }
        });
        this.patrolVm.mUrgedishes.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailFrag$$ExternalSyntheticLambda3
            public final void onChanged(Object obj) {
                this.f$0.m19lambda$onInit$3$comcollectpointmoudleproductOrderDetailFrag((Resource) obj);
            }
        });
        this.patrolVm.mIndexIndex.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailFrag$$ExternalSyntheticLambda4
            public final void onChanged(Object obj) {
                this.f$0.m20lambda$onInit$4$comcollectpointmoudleproductOrderDetailFrag((Resource) obj);
            }
        });
        this.patrolVm.mChangeNum.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailFrag$$ExternalSyntheticLambda5
            public final void onChanged(Object obj) {
                this.f$0.m21lambda$onInit$5$comcollectpointmoudleproductOrderDetailFrag((Resource) obj);
            }
        });
        this.patrolVm.mProductPassRollback.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailFrag$$ExternalSyntheticLambda6
            public final void onChanged(Object obj) {
                this.f$0.m22lambda$onInit$6$comcollectpointmoudleproductOrderDetailFrag((Resource) obj);
            }
        });
    }

    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-OrderDetailFrag, reason: not valid java name */
    /* synthetic */ void m16lambda$onInit$0$comcollectpointmoudleproductOrderDetailFrag(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case OrderSettleFrag.REQUEST_CODE /* 1 */:
                if (EmptyUtils.isNotEmpty(result.data) && EmptyUtils.isNotEmpty(((HallCartDetailRes) result.data).getDetail()) && EmptyUtils.isNotEmpty(((HallCartDetailRes) result.data).getDetail().getProduct())) {
                    this.order_id = ((HallCartDetailRes) result.data).getDetail().getOrder_id();
                    this.shop_supplier_id = ((HallCartDetailRes) result.data).getDetail().getShop_supplier_id();
                    this.user_id = ((HallCartDetailRes) result.data).getDetail().getUser_id();
                    this.adapter.setData(((HallCartDetailRes) result.data).getDetail().getProduct());
                    this.mBinding.tvSum.setText(((HallCartDetailRes) result.data).getDetail().getPay_price());
                    this.mBinding.tvNum.setText("已点" + ((HallCartDetailRes) result.data).getDetail().getProduct_num() + "份");
                    this.mBinding.tvTitle.setText(this.tableName);
                    break;
                } else {
                    this.order_id = "";
                    this.adapter.clearData();
                    this.mBinding.tvSum.setText("0");
                    break;
                }
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-OrderDetailFrag, reason: not valid java name */
    /* synthetic */ void m17lambda$onInit$1$comcollectpointmoudleproductOrderDetailFrag(Resource result) {
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
                ToastUtils.showLong(result.message);
                getActivity().finish();
                postEvent(new FlashListEvent());
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-OrderDetailFrag, reason: not valid java name */
    /* synthetic */ void m18lambda$onInit$2$comcollectpointmoudleproductOrderDetailFrag(Resource result) {
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
                ToastUtils.showLong("退菜成功");
                onEventMainThread(new FlashListEvent());
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$3$com-collectpoint-moudle-product-OrderDetailFrag, reason: not valid java name */
    /* synthetic */ void m19lambda$onInit$3$comcollectpointmoudleproductOrderDetailFrag(Resource result) {
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
                ToastUtils.showLong("催菜成功");
                onEventMainThread(new FlashListEvent());
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$4$com-collectpoint-moudle-product-OrderDetailFrag, reason: not valid java name */
    /* synthetic */ void m20lambda$onInit$4$comcollectpointmoudleproductOrderDetailFrag(Resource result) {
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
                    break;
                }
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$5$com-collectpoint-moudle-product-OrderDetailFrag, reason: not valid java name */
    /* synthetic */ void m21lambda$onInit$5$comcollectpointmoudleproductOrderDetailFrag(Resource result) {
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
                ToastUtils.showLong("修改人数成功");
                onEventMainThread(new FlashListEvent());
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$6$com-collectpoint-moudle-product-OrderDetailFrag, reason: not valid java name */
    /* synthetic */ void m22lambda$onInit$6$comcollectpointmoudleproductOrderDetailFrag(Resource result) {
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
                ToastUtils.showLong("操作成功");
                this.patrolVm.orderDetail(this.table_id);
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
            case 2131296959:
                Router.build("ProductListAct").with("code", this.table_id).with("name", this.tableName).with("KEY_ROLE_CODE", this.order_id).go(getActivity());
                break;
            case 2131296968:
                Router.build("OrderSettleAct").with("code", this.table_id).with("name", this.tableName).with("id", this.user_id).with("KEY_ROLE_CODE", this.shop_supplier_id).with("villageCode", this.order_id).go(getActivity());
                break;
            case 2131297001:
                NumWindow numWindow = new NumWindow(getActivity(), "桌号：" + this.tableName, new NumWindow.OnSiteClickListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.3
                    public void onAttrSubmit(String num) {
                        OrderDetailFrag.this.patrolVm.changeNum(OrderDetailFrag.this.order_id, num);
                    }
                });
                this.mapPopupWindow = numWindow;
                numWindow.show(this.mBinding.tvAddMenu);
                this.mapPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.4
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        SDHandlerManager.getMainHandler().postDelayed(new Runnable() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                OrderDetailFrag.this.closeKeyboard();
                            }
                        }, 1000L);
                    }
                });
                break;
            case 2131297029:
                Router.build("ProductListAct").with("code", this.table_id).with("name", this.tableName).with("typeCode", true).with("KEY_ROLE_CODE", this.order_id).go(getActivity());
                break;
            case 2131297051:
                Router.build("SwitchTableAct").with("code", this.table_id).with("name", this.tableName).with("KEY_ROLE_CODE", this.order_id).with("page", true).go(getActivity());
                break;
            case 2131297115:
                Confirm1Dialog myAlertInputDialog1 = new Confirm1Dialog(requireActivity());
                int pos = this.tableName.indexOf("(");
                String text = "当前桌号为<font color='#FF0000'>" + this.tableName.substring(0, pos) + "</font>，确定扫盘吗?";
                myAlertInputDialog1.setData("提示", Html.fromHtml(text), "");
                myAlertInputDialog1.setOnConfirmClickListener(new Confirm1Dialog.OnConfirmClickListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.2
                    public void onClick(View view2) {
                        Router.build("ScanPlateAct").with("code", OrderDetailFrag.this.table_id).with("name", OrderDetailFrag.this.tableName).with("KEY_ROLE_CODE", OrderDetailFrag.this.order_id).go(OrderDetailFrag.this.getActivity());
                    }
                });
                myAlertInputDialog1.show();
                break;
            case 2131297123:
                Router.build("SwitchTableAct").with("code", this.table_id).with("name", this.tableName).with("KEY_ROLE_CODE", this.order_id).go(getActivity());
                break;
            case 2131297136:
                getActivity().finish();
                break;
        }
    }

    /* renamed from: com.collectpoint.moudle.product.OrderDetailFrag$5, reason: invalid class name */
    class AnonymousClass5 implements PopupWindow.OnDismissListener {
        AnonymousClass5() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            SDHandlerManager.getMainHandler().postDelayed(new Runnable() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.5.1
                @Override // java.lang.Runnable
                public void run() {
                    OrderDetailFrag.this.closeKeyboard();
                }
            }, 1000L);
        }
    }

    private class OrderAdapter extends SSimpleRecyclerAdapter<ProductItem> {
        public OrderAdapter(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, int position, final ProductItem data) throws NumberFormatException {
            double pass_time;
            TextView tv_produce_name = (TextView) holder.get(2131297081);
            TextView tv_produce_fix = (TextView) holder.get(2131297079);
            TextView tv_num = (TextView) holder.get(2131297061);
            TextView tv_price = (TextView) holder.get(2131297075);
            TextView tv_produce_cc = (TextView) holder.get(2131297078);
            TextView tv_produce_options = (TextView) holder.get(2131297083);
            TextView tv_produce_gift = (TextView) holder.get(2131297080);
            TextView tv_produce_post = (TextView) holder.get(2131297084);
            TextView tv_tip = (TextView) holder.get(2131297135);
            TextView tv_left = (TextView) holder.get(2131297044);
            LinearLayout lay_sliding = (LinearLayout) holder.get(2131296636);
            final SlidingDeleteView slidingDeleteView = holder.get(2131296837);
            ConstraintLayout containerView = slidingDeleteView.findViewById(2131296635);
            containerView.getLayoutParams().width = ScreenUtils.getScreenWidth();
            slidingDeleteView.setEnable(!TextUtils.equals("1", data.getIs_sweeing()));
            slidingDeleteView.setOnDeleteViewStateChangedListener(new SlidingDeleteView.OnDeleteViewStateChangedListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.OrderAdapter.1
                public void onVisibile() {
                    Log.i("TAG", "显示抽屉视图");
                }

                public void onGone() {
                    Log.i("TAG", "隐藏抽屉视图");
                }

                public void onDownOrMove() {
                }
            });
            tv_produce_post.setText((position + 1) + ".");
            tv_produce_name.setText(data.getProduct_name());
            tv_produce_options.setText(data.getProduct_attr());
            tv_num.setText("x" + data.getTotal_num());
            tv_price.setText("¥" + data.getTotal_pay_price());
            tv_produce_fix.setBackground(BackgroundLibUtil.getBlueW(2131165623));
            tv_produce_cc.setBackground(BackgroundLibUtil.getBlueW(2131165623));
            if (EmptyUtils.isEmpty(data.getTip())) {
                tv_tip.setVisibility(8);
            } else {
                tv_tip.setText(data.getTip());
                tv_tip.setVisibility(0);
                tv_tip.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), "1".equals(data.getIs_gift()) ? 2131099759 : 2131099725));
            }
            tv_produce_gift.setBackground(BackgroundLibUtil.getBlue(2131166007));
            tv_produce_gift.setVisibility(("1".equals(data.getIs_gift()) || "1".equals(data.getIs_promotion())) ? 0 : 8);
            tv_produce_gift.setText("1".equals(data.getIs_promotion()) ? "促" : "赠");
            tv_produce_fix.setVisibility("1".equals(data.getIs_sweeing()) ? 8 : 0);
            tv_produce_cc.setVisibility("1".equals(data.getIs_sweeing()) ? 8 : 0);
            tv_produce_options.setVisibility(EmptyUtils.isEmpty(data.getProduct_attr()) ? 8 : 0);
            try {
                pass_time = Double.parseDouble(data.getPass_time());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                pass_time = 0.0d;
            }
            if (pass_time > 0.0d) {
                tv_left.setText("撤销上菜");
                tv_produce_cc.setVisibility(8);
                tv_produce_post.setPaintFlags(16);
                tv_produce_gift.setPaintFlags(16);
                tv_produce_name.setPaintFlags(16);
                tv_num.setPaintFlags(16);
                tv_price.setPaintFlags(16);
                tv_produce_post.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099725));
                tv_produce_gift.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099725));
                tv_produce_name.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099725));
                tv_num.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099725));
            } else {
                tv_produce_cc.setVisibility(0);
                tv_left.setText("上菜");
                tv_produce_post.setPaintFlags(tv_produce_post.getPaintFlags() & (-17));
                tv_produce_gift.setPaintFlags(tv_produce_gift.getPaintFlags() & (-17));
                tv_produce_name.setPaintFlags(tv_produce_name.getPaintFlags() & (-17));
                tv_num.setPaintFlags(tv_num.getPaintFlags() & (-17));
                tv_price.setPaintFlags(tv_price.getPaintFlags() & (-17));
                tv_produce_post.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099824));
                tv_produce_gift.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099824));
                tv_produce_name.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099824));
                tv_num.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099824));
            }
            tv_produce_fix.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.OrderAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final NumFixDialog myAlertInputDialog1 = new NumFixDialog(OrderDetailFrag.this.requireActivity());
                    myAlertInputDialog1.setNum(data.getTotal_num());
                    myAlertInputDialog1.setOnConfirmClickListener(new NumFixDialog.OnFixClickListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.OrderAdapter.2.1
                        public void onSiteSubmit(String num, String is_print) {
                            myAlertInputDialog1.dismiss();
                            OrderDetailFrag.this.patrolVm.moveProduct(data.getOrder_product_id(), data.getOrder_id(), num, is_print);
                        }
                    });
                    myAlertInputDialog1.show();
                }
            });
            tv_produce_cc.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.OrderAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OrderDetailFrag.this.patrolVm.urgedishes(data.getOrder_product_id(), data.getOrder_id());
                }
            });
            final double finalPass_time = pass_time;
            lay_sliding.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.OrderAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    slidingDeleteView.setDeleteViewGone();
                    if (finalPass_time > 0.0d) {
                        OrderDetailFrag.this.patrolVm.productPassRollback(data.getOrder_product_id());
                    } else {
                        OrderDetailFrag.this.patrolVm.productPass(data.getOrder_product_id());
                    }
                }
            });
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493033;
        }
    }

    protected boolean subscribeEvents() {
        return true;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(FlashListEvent event) {
        this.patrolVm.orderDetail(this.table_id);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(FinishActtEvent event) {
        if (event != null && event.getLayer() < 1) {
            getActivity().finish();
        }
    }

    public void onResume() {
        super.onResume();
        this.patrolVm.orderDetail(this.table_id);
    }
}
