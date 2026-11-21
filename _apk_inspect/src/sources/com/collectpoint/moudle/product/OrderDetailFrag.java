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
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragOrderdetailBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.BitmapMemoryCache;
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

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493033;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, final ProductItem productItem) throws NumberFormatException {
            double d;
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297081);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131297079);
            TextView textView3 = (TextView) sRecyclerViewHolder.get(2131297061);
            TextView textView4 = (TextView) sRecyclerViewHolder.get(2131297075);
            TextView textView5 = (TextView) sRecyclerViewHolder.get(2131297078);
            TextView textView6 = (TextView) sRecyclerViewHolder.get(2131297083);
            TextView textView7 = (TextView) sRecyclerViewHolder.get(2131297080);
            TextView textView8 = (TextView) sRecyclerViewHolder.get(2131297084);
            TextView textView9 = (TextView) sRecyclerViewHolder.get(2131297135);
            TextView textView10 = (TextView) sRecyclerViewHolder.get(2131297044);
            LinearLayout linearLayout = (LinearLayout) sRecyclerViewHolder.get(2131296636);
            final SlidingDeleteView slidingDeleteView = (SlidingDeleteView) sRecyclerViewHolder.get(2131296837);
            slidingDeleteView.findViewById(2131296635).getLayoutParams().width = ScreenUtils.getScreenWidth();
            slidingDeleteView.setEnable(!TextUtils.equals("1", productItem.getIs_sweeing()));
            slidingDeleteView.setOnDeleteViewStateChangedListener(new SlidingDeleteView.OnDeleteViewStateChangedListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.OrderAdapter.1
                @Override // com.collectpoint.widget.SlidingDeleteView.OnDeleteViewStateChangedListener
                public void onDownOrMove() {
                }

                @Override // com.collectpoint.widget.SlidingDeleteView.OnDeleteViewStateChangedListener
                public void onGone() {
                    Log.i("TAG", "隐藏抽屉视图");
                }

                @Override // com.collectpoint.widget.SlidingDeleteView.OnDeleteViewStateChangedListener
                public void onVisibile() {
                    Log.i("TAG", "显示抽屉视图");
                }
            });
            textView8.setText((i + 1) + ".");
            textView.setText(productItem.getProduct_name());
            textView6.setText(productItem.getProduct_attr());
            textView3.setText("x" + productItem.getTotal_num());
            textView4.setText("¥" + productItem.getTotal_pay_price());
            textView2.setBackground(BackgroundLibUtil.getBlueW(2131165623));
            textView5.setBackground(BackgroundLibUtil.getBlueW(2131165623));
            if (EmptyUtils.isEmpty(productItem.getTip())) {
                textView9.setVisibility(8);
            } else {
                textView9.setText(productItem.getTip());
                textView9.setVisibility(0);
                textView9.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), "1".equals(productItem.getIs_gift()) ? 2131099759 : 2131099725));
            }
            textView7.setBackground(BackgroundLibUtil.getBlue(2131166007));
            textView7.setVisibility(("1".equals(productItem.getIs_gift()) || "1".equals(productItem.getIs_promotion())) ? 0 : 8);
            textView7.setText("1".equals(productItem.getIs_promotion()) ? "促" : "赠");
            textView2.setVisibility("1".equals(productItem.getIs_sweeing()) ? 8 : 0);
            textView5.setVisibility("1".equals(productItem.getIs_sweeing()) ? 8 : 0);
            textView6.setVisibility(EmptyUtils.isEmpty(productItem.getProduct_attr()) ? 8 : 0);
            try {
                d = Double.parseDouble(productItem.getPass_time());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                d = 0.0d;
            }
            if (d > 0.0d) {
                textView10.setText("撤销上菜");
                textView5.setVisibility(8);
                textView8.setPaintFlags(16);
                textView7.setPaintFlags(16);
                textView.setPaintFlags(16);
                textView3.setPaintFlags(16);
                textView4.setPaintFlags(16);
                textView8.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099725));
                textView7.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099725));
                textView.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099725));
                textView3.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099725));
            } else {
                textView5.setVisibility(0);
                textView10.setText("上菜");
                textView8.setPaintFlags(textView8.getPaintFlags() & (-17));
                textView7.setPaintFlags(textView7.getPaintFlags() & (-17));
                textView.setPaintFlags(textView.getPaintFlags() & (-17));
                textView3.setPaintFlags(textView3.getPaintFlags() & (-17));
                textView4.setPaintFlags(textView4.getPaintFlags() & (-17));
                textView8.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099824));
                textView7.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099824));
                textView.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099824));
                textView3.setTextColor(ContextCompat.getColor(OrderDetailFrag.this.getContext(), 2131099824));
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.OrderAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final NumFixDialog numFixDialog = new NumFixDialog(OrderDetailFrag.this.requireActivity());
                    numFixDialog.setNum(productItem.getTotal_num());
                    numFixDialog.setOnConfirmClickListener(new NumFixDialog.OnFixClickListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.OrderAdapter.2.1
                        @Override // com.collectpoint.widget.popupwindow.NumFixDialog.OnFixClickListener
                        public void onSiteSubmit(String str, String str2) {
                            numFixDialog.dismiss();
                            OrderDetailFrag.this.patrolVm.moveProduct(productItem.getOrder_product_id(), productItem.getOrder_id(), str, str2);
                        }
                    });
                    numFixDialog.show();
                }
            });
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.OrderAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OrderDetailFrag.this.patrolVm.urgedishes(productItem.getOrder_product_id(), productItem.getOrder_id());
                }
            });
            final double d2 = d;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.OrderAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    slidingDeleteView.setDeleteViewGone();
                    if (d2 > 0.0d) {
                        OrderDetailFrag.this.patrolVm.productPassRollback(productItem.getOrder_product_id());
                    } else {
                        OrderDetailFrag.this.patrolVm.productPass(productItem.getOrder_product_id());
                    }
                }
            });
        }
    }

    private void init() {
        this.table_id = getArguments().getString(Constants.KEY_CODE);
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
            @Override // com.collectpoint.widget.bottomscroll.ShortSlideListener
            public void onShortSlide(boolean z) {
                if (z) {
                    OrderDetailFrag.this.mBinding.tvLine2.setText("下拉收起");
                    OrderDetailFrag.this.mBinding.tvLine2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131231024, 0);
                } else {
                    OrderDetailFrag.this.mBinding.tvLine2.setText("上滑展开");
                    OrderDetailFrag.this.mBinding.tvLine2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131231177, 0);
                }
            }
        });
    }

    public static OrderDetailFrag newInstance(String str, String str2) {
        OrderDetailFrag orderDetailFrag = new OrderDetailFrag();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_CODE, str);
        bundle.putString("name", str2);
        orderDetailFrag.setArguments(bundle);
        return orderDetailFrag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-OrderDetailFrag, reason: not valid java name */
    /* synthetic */ void m195lambda$onInit$0$comcollectpointmoudleproductOrderDetailFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                if (!EmptyUtils.isNotEmpty(resource.data) || !EmptyUtils.isNotEmpty(((HallCartDetailRes) resource.data).getDetail()) || !EmptyUtils.isNotEmpty(((HallCartDetailRes) resource.data).getDetail().getProduct())) {
                    this.order_id = "";
                    this.adapter.clearData();
                    this.mBinding.tvSum.setText(BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
                    break;
                } else {
                    this.order_id = ((HallCartDetailRes) resource.data).getDetail().getOrder_id();
                    this.shop_supplier_id = ((HallCartDetailRes) resource.data).getDetail().getShop_supplier_id();
                    this.user_id = ((HallCartDetailRes) resource.data).getDetail().getUser_id();
                    this.adapter.setData(((HallCartDetailRes) resource.data).getDetail().getProduct());
                    this.mBinding.tvSum.setText(((HallCartDetailRes) resource.data).getDetail().getPay_price());
                    this.mBinding.tvNum.setText("已点" + ((HallCartDetailRes) resource.data).getDetail().getProduct_num() + "份");
                    this.mBinding.tvTitle.setText(this.tableName);
                    break;
                }
                break;
            case 2:
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-OrderDetailFrag, reason: not valid java name */
    /* synthetic */ void m196lambda$onInit$1$comcollectpointmoudleproductOrderDetailFrag(Resource resource) {
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
                ToastUtils.showLong(resource.message);
                getActivity().finish();
                postEvent(new FlashListEvent());
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-OrderDetailFrag, reason: not valid java name */
    /* synthetic */ void m197lambda$onInit$2$comcollectpointmoudleproductOrderDetailFrag(Resource resource) {
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
                ToastUtils.showLong("退菜成功");
                onEventMainThread(new FlashListEvent());
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$3$com-collectpoint-moudle-product-OrderDetailFrag, reason: not valid java name */
    /* synthetic */ void m198lambda$onInit$3$comcollectpointmoudleproductOrderDetailFrag(Resource resource) {
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
                ToastUtils.showLong("催菜成功");
                onEventMainThread(new FlashListEvent());
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$4$com-collectpoint-moudle-product-OrderDetailFrag, reason: not valid java name */
    /* synthetic */ void m199lambda$onInit$4$comcollectpointmoudleproductOrderDetailFrag(Resource resource) {
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

    /* renamed from: lambda$onInit$5$com-collectpoint-moudle-product-OrderDetailFrag, reason: not valid java name */
    /* synthetic */ void m200lambda$onInit$5$comcollectpointmoudleproductOrderDetailFrag(Resource resource) {
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
                ToastUtils.showLong("修改人数成功");
                onEventMainThread(new FlashListEvent());
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$6$com-collectpoint-moudle-product-OrderDetailFrag, reason: not valid java name */
    /* synthetic */ void m201lambda$onInit$6$comcollectpointmoudleproductOrderDetailFrag(Resource resource) {
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
                ToastUtils.showLong("操作成功");
                this.patrolVm.orderDetail(this.table_id);
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
            case 2131296959:
                Router.build(Constants.PRODUCTLIST_ACT).with(Constants.KEY_CODE, this.table_id).with("name", this.tableName).with(Constants.KEY_ROLE_CODE, this.order_id).go(getActivity());
                break;
            case 2131296968:
                Router.build(Constants.ORDERSETTLE_ACT).with(Constants.KEY_CODE, this.table_id).with("name", this.tableName).with(Constants.KEY_ID, this.user_id).with(Constants.KEY_ROLE_CODE, this.shop_supplier_id).with(Constants.KEY_VILLAGE_CODE, this.order_id).go(getActivity());
                break;
            case 2131297001:
                NumWindow numWindow = new NumWindow(getActivity(), "桌号：" + this.tableName, new NumWindow.OnSiteClickListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.3
                    @Override // com.collectpoint.widget.popupwindow.NumWindow.OnSiteClickListener
                    public void onAttrSubmit(String str) {
                        OrderDetailFrag.this.patrolVm.changeNum(OrderDetailFrag.this.order_id, str);
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
                Router.build(Constants.PRODUCTLIST_ACT).with(Constants.KEY_CODE, this.table_id).with("name", this.tableName).with(Constants.TYPE_CODE, true).with(Constants.KEY_ROLE_CODE, this.order_id).go(getActivity());
                break;
            case 2131297051:
                Router.build(Constants.SWITCHTABLE_ACT).with(Constants.KEY_CODE, this.table_id).with("name", this.tableName).with(Constants.KEY_ROLE_CODE, this.order_id).with(Constants.KEY_PAGE, true).go(getActivity());
                break;
            case 2131297115:
                Confirm1Dialog confirm1Dialog = new Confirm1Dialog(requireActivity());
                confirm1Dialog.setData("提示", Html.fromHtml("当前桌号为<font color='#FF0000'>" + this.tableName.substring(0, this.tableName.indexOf("(")) + "</font>，确定扫盘吗?"), "");
                confirm1Dialog.setOnConfirmClickListener(new Confirm1Dialog.OnConfirmClickListener() { // from class: com.collectpoint.moudle.product.OrderDetailFrag.2
                    @Override // com.collectpoint.widget.popupwindow.Confirm1Dialog.OnConfirmClickListener
                    public void onClick(View view2) {
                        Router.build(Constants.SCANPLATE_ACT).with(Constants.KEY_CODE, OrderDetailFrag.this.table_id).with("name", OrderDetailFrag.this.tableName).with(Constants.KEY_ROLE_CODE, OrderDetailFrag.this.order_id).go(OrderDetailFrag.this.getActivity());
                    }
                });
                confirm1Dialog.show();
                break;
            case 2131297123:
                Router.build(Constants.SWITCHTABLE_ACT).with(Constants.KEY_CODE, this.table_id).with("name", this.tableName).with(Constants.KEY_ROLE_CODE, this.order_id).go(getActivity());
                break;
            case 2131297136:
                getActivity().finish();
                break;
        }
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(FinishActtEvent finishActtEvent) {
        if (finishActtEvent == null || finishActtEvent.getLayer() >= 1) {
            return;
        }
        getActivity().finish();
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(FlashListEvent flashListEvent) {
        this.patrolVm.orderDetail(this.table_id);
    }

    protected void onInit() {
        this.patrolVm.mOrderDetail.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m195lambda$onInit$0$comcollectpointmoudleproductOrderDetailFrag((Resource) obj);
            }
        });
        this.patrolVm.mOrderCancel.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m196lambda$onInit$1$comcollectpointmoudleproductOrderDetailFrag((Resource) obj);
            }
        });
        this.patrolVm.mMoveProduct.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m197lambda$onInit$2$comcollectpointmoudleproductOrderDetailFrag((Resource) obj);
            }
        });
        this.patrolVm.mUrgedishes.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailFrag$$ExternalSyntheticLambda3
            public final void onChanged(Object obj) {
                this.f$0.m198lambda$onInit$3$comcollectpointmoudleproductOrderDetailFrag((Resource) obj);
            }
        });
        this.patrolVm.mIndexIndex.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailFrag$$ExternalSyntheticLambda4
            public final void onChanged(Object obj) {
                this.f$0.m199lambda$onInit$4$comcollectpointmoudleproductOrderDetailFrag((Resource) obj);
            }
        });
        this.patrolVm.mChangeNum.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailFrag$$ExternalSyntheticLambda5
            public final void onChanged(Object obj) {
                this.f$0.m200lambda$onInit$5$comcollectpointmoudleproductOrderDetailFrag((Resource) obj);
            }
        });
        this.patrolVm.mProductPassRollback.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.OrderDetailFrag$$ExternalSyntheticLambda6
            public final void onChanged(Object obj) {
                this.f$0.m201lambda$onInit$6$comcollectpointmoudleproductOrderDetailFrag((Resource) obj);
            }
        });
    }

    protected void onLazyLoadingData() {
        this.patrolVm.orderDetail(this.table_id);
    }

    public void onResume() {
        super.onResume();
        this.patrolVm.orderDetail(this.table_id);
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragOrderdetailBinding fragOrderdetailBinding = (FragOrderdetailBinding) DataBindingUtil.inflate(layoutInflater, 2131492983, viewGroup, false);
        this.mBinding = fragOrderdetailBinding;
        fragOrderdetailBinding.setLifecycleOwner(this);
        this.patrolVm = ViewModelProviders.of(this, PatrolVmFactory.getInstance(MyApp.getInstance())).get(PatrolVm.class);
        init();
        return this.mBinding.getRoot();
    }

    protected boolean subscribeEvents() {
        return true;
    }
}
