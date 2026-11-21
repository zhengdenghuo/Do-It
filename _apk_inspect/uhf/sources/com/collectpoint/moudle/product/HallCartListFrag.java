package com.collectpoint.moudle.product;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.MyApp;
import com.collectpoint.bean.even.FinishActtEvent;
import com.collectpoint.bean.even.FlashListEvent;
import com.collectpoint.bean.item.HallCartItem;
import com.collectpoint.bean.res.HallCartlistRes;
import com.collectpoint.databinding.FragHallcartlistBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.SDHandlerManager;
import com.collectpoint.utils.decoration.MyItemDecoration1;
import com.collectpoint.widget.popupwindow.Confirm1Dialog;
import com.collectpoint.widget.popupwindow.NumWindow;
import com.collectpoint.widget.recycler.SRecyclerViewHolder;
import com.collectpoint.widget.recycler.SSimpleRecyclerAdapter;
import com.google.common.base.Preconditions;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.image.ImgLoaderManager;
import com.liuwq.base.widget.CustomDialogFragCompat;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class HallCartListFrag extends BaseFragment implements View.OnClickListener {
    private OrderAdapter adapter;
    private boolean isGift;
    private String is_print = "0";
    private FragHallcartlistBinding mBinding;
    private NumWindow mapPopupWindow;
    private String order_id;
    private PatrolVm patrolVm;
    private List<HallCartlistRes.ProductListRes> productList;
    private String table_id;
    private String titleName;
    private String user_id;

    public static HallCartListFrag newInstance(String table_id, String order_id, String titleName, boolean isGift) {
        HallCartListFrag fragment = new HallCartListFrag();
        Bundle args = new Bundle();
        args.putString("code", table_id);
        args.putBoolean("typeCode", isGift);
        args.putString("KEY_ROLE_CODE", order_id);
        args.putString("name", titleName);
        fragment.setArguments(args);
        return fragment;
    }

    protected View provideContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragHallcartlistBinding fragHallcartlistBindingInflate = DataBindingUtil.inflate(inflater, 2131492972, container, false);
        this.mBinding = fragHallcartlistBindingInflate;
        fragHallcartlistBindingInflate.setLifecycleOwner(this);
        PatrolVmFactory vmFactory = PatrolVmFactory.getInstance(MyApp.getInstance());
        this.patrolVm = ViewModelProviders.of(this, vmFactory).get(PatrolVm.class);
        init();
        return this.mBinding.getRoot();
    }

    private void init() {
        this.table_id = getArguments().getString("code");
        this.order_id = getArguments().getString("KEY_ROLE_CODE");
        this.titleName = getArguments().getString("name");
        this.isGift = getArguments().getBoolean("typeCode");
        this.mBinding.tvTitle.setText(this.titleName);
        this.mBinding.tvTitle.setOnClickListener(this);
        this.mBinding.srvOrder.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.adapter = new OrderAdapter(getActivity());
        this.mBinding.srvOrder.setAdapter(this.adapter);
        this.mBinding.srvOrder.addItemDecoration(new MyItemDecoration1(requireActivity()));
        this.mBinding.tvSubmint.setBackground(BackgroundLibUtil.getBlue(2131165785));
        this.mBinding.tvSubmint.setOnClickListener(this);
        this.mBinding.rbNocd.setOnClickListener(this);
        this.mBinding.tvClear.setOnClickListener(this);
    }

    protected void onLazyLoadingData() {
        this.patrolVm.hallCartList(this.table_id);
    }

    protected void onInit() {
        this.patrolVm.mHallCartList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.HallCartListFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m10lambda$onInit$0$comcollectpointmoudleproductHallCartListFrag((Resource) obj);
            }
        });
        this.patrolVm.mHallCartSub.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.HallCartListFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m11lambda$onInit$1$comcollectpointmoudleproductHallCartListFrag((Resource) obj);
            }
        });
        this.patrolVm.mHallCartDelete.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.HallCartListFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m12lambda$onInit$2$comcollectpointmoudleproductHallCartListFrag((Resource) obj);
            }
        });
        this.patrolVm.mAddMeal.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.HallCartListFrag$$ExternalSyntheticLambda3
            public final void onChanged(Object obj) {
                this.f$0.m13lambda$onInit$3$comcollectpointmoudleproductHallCartListFrag((Resource) obj);
            }
        });
    }

    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-HallCartListFrag, reason: not valid java name */
    /* synthetic */ void m10lambda$onInit$0$comcollectpointmoudleproductHallCartListFrag(Resource result) {
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
                if (this.productList == null) {
                    this.productList = new ArrayList();
                }
                this.productList.clear();
                if (EmptyUtils.isNotEmpty(((HallCartlistRes) result.data).getProductList())) {
                    this.productList.addAll(((HallCartlistRes) result.data).getProductList());
                }
                this.adapter.setData(this.productList);
                if (EmptyUtils.isNotEmpty(((HallCartlistRes) result.data).getProductList())) {
                    this.user_id = ((HallCartlistRes.ProductListRes) ((HallCartlistRes) result.data).getProductList().get(0)).getUser_id();
                }
                this.mBinding.tvNum.setText("数量" + ((HallCartlistRes) result.data).getCartInfo().getCart_total_num() + "件，合计：");
                this.mBinding.tvSum.setText("¥" + ((HallCartlistRes) result.data).getCartInfo().getTotal_pay_price());
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-HallCartListFrag, reason: not valid java name */
    /* synthetic */ void m11lambda$onInit$1$comcollectpointmoudleproductHallCartListFrag(Resource result) {
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
                this.patrolVm.hallCartList(this.table_id);
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-HallCartListFrag, reason: not valid java name */
    /* synthetic */ void m12lambda$onInit$2$comcollectpointmoudleproductHallCartListFrag(Resource result) {
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
                ToastUtils.showLong("清除成功");
                this.patrolVm.hallCartList(this.table_id);
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$3$com-collectpoint-moudle-product-HallCartListFrag, reason: not valid java name */
    /* synthetic */ void m13lambda$onInit$3$comcollectpointmoudleproductHallCartListFrag(Resource result) {
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
                Intent intent = new Intent(getContext(), (Class<?>) OrderDetailAct.class);
                intent.putExtra("code", this.table_id);
                intent.putExtra("name", this.titleName);
                intent.addFlags(603979776);
                requireActivity().setResult(5, intent);
                startActivity(intent);
                getActivity().finish();
                postEvent(new FlashListEvent());
                postEvent(new FinishActtEvent(1));
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
    public void onClick(View view) throws Resources.NotFoundException {
        switch (view.getId()) {
            case 2131296757:
                this.is_print = "1".equals(this.is_print) ? "0" : "1";
                Drawable drawable = getContext().getResources().getDrawable("1".equals(this.is_print) ? 2131230990 : 2131231173);
                this.mBinding.rbNocd.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                break;
            case 2131296970:
                Confirm1Dialog myAlertInputDialog1 = new Confirm1Dialog(requireActivity());
                myAlertInputDialog1.setData("提示", "确定清空购物车？", "");
                myAlertInputDialog1.setOnConfirmClickListener(new Confirm1Dialog.OnConfirmClickListener() { // from class: com.collectpoint.moudle.product.HallCartListFrag.1
                    public void onClick(View view2) {
                        HallCartListFrag.this.patrolVm.hallCartDelete(HallCartListFrag.this.table_id);
                    }
                });
                myAlertInputDialog1.show();
                break;
            case 2131297119:
                if (EmptyUtils.isEmpty(this.order_id)) {
                    NumWindow numWindow = new NumWindow(getActivity(), "桌号：" + this.titleName, new NumWindow.OnSiteClickListener() { // from class: com.collectpoint.moudle.product.HallCartListFrag.2
                        public void onAttrSubmit(String num) {
                            HallCartListFrag.this.patrolVm.tableBuy(HallCartListFrag.this.table_id, HallCartListFrag.this.mBinding.etRemark.getText().toString(), num, HallCartListFrag.this.user_id, HallCartListFrag.this.isGift, HallCartListFrag.this.is_print);
                        }
                    });
                    this.mapPopupWindow = numWindow;
                    numWindow.show(this.mBinding.tvNum);
                    this.mapPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.collectpoint.moudle.product.HallCartListFrag.3
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            SDHandlerManager.getMainHandler().postDelayed(new Runnable() { // from class: com.collectpoint.moudle.product.HallCartListFrag.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    HallCartListFrag.this.closeKeyboard();
                                }
                            }, 1000L);
                        }
                    });
                    break;
                } else {
                    this.patrolVm.addMeal(this.table_id, this.mBinding.etRemark.getText().toString(), this.order_id, this.user_id, this.isGift, this.is_print);
                    break;
                }
            case 2131297136:
                getActivity().finish();
                break;
        }
    }

    private class OrderAdapter extends SSimpleRecyclerAdapter<HallCartlistRes.ProductListRes> {
        public OrderAdapter(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, int position, final HallCartlistRes.ProductListRes data) throws NumberFormatException {
            String descrbes;
            int minbuy;
            int product_num;
            final ImageView iv_add = (ImageView) holder.get(2131296588);
            ImageView iv_sub = (ImageView) holder.get(2131296622);
            TextView tv_name = (TextView) holder.get(2131297056);
            TextView tv_price = (TextView) holder.get(2131297075);
            final TextView tv_start_num = (TextView) holder.get(2131297117);
            TextView tv_describ = (TextView) holder.get(2131296992);
            final TextView et_content = (TextView) holder.get(2131296497);
            ImageView iv_product = (ImageView) holder.get(2131296618);
            tv_name.setText(data.getProduct().getProduct_name());
            String descrbes2 = "";
            if (EmptyUtils.isNotEmpty(data.getDescribe())) {
                descrbes2 = data.getDescribe();
            }
            if (EmptyUtils.isNotEmpty(data.getFeed())) {
                descrbes = descrbes2 + (EmptyUtils.isEmpty(descrbes2) ? "" : ",") + data.getFeed();
            } else {
                descrbes = descrbes2;
            }
            tv_describ.setText(descrbes);
            tv_describ.setVisibility(EmptyUtils.isEmpty(descrbes) ? 8 : 0);
            et_content.setText(data.getProduct_num());
            TextView tv_promotion_lable = (TextView) holder.get(2131297091);
            TextView tv_product_price = (TextView) holder.get(2131297086);
            tv_name.setText(data.getProduct().getProduct_name());
            try {
                int minbuy2 = Integer.parseInt(data.getProduct().getMin_buy());
                minbuy = minbuy2;
            } catch (Exception e) {
                minbuy = 1;
            }
            try {
                int product_num2 = Integer.parseInt(data.getProduct_num());
                product_num = product_num2;
            } catch (Exception e2) {
                product_num = 1;
            }
            if (minbuy > 1 && product_num < minbuy) {
                iv_add.setVisibility(8);
                tv_start_num.setVisibility(0);
                tv_start_num.setBackground(BackgroundLibUtil.getBlue(2131165623));
                tv_start_num.setText(minbuy + data.getProduct().getProduct_unit() + "起点");
            } else {
                tv_start_num.setVisibility(8);
                iv_add.setVisibility(0);
            }
            if (TextUtils.equals("1", data.getProduct().getIs_promotion())) {
                tv_price.setText("¥" + data.getPay_price());
                tv_promotion_lable.setVisibility(0);
                tv_promotion_lable.setBackground(BackgroundLibUtil.get999999(2131165785));
                tv_product_price.setText("¥" + data.getProduct_price() + "/" + data.getProduct().getProduct_unit());
                tv_product_price.getPaint().setFlags(16);
            } else {
                tv_price.setText("¥" + data.getProduct_price());
                tv_promotion_lable.setVisibility(8);
                tv_product_price.setText("");
            }
            try {
                ImgLoaderManager.get().loadDrawable(iv_product, ((HallCartItem.ImageRes) data.getProduct().getImage().get(0)).getFile_path());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            final int finalMinbuy = minbuy;
            tv_start_num.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.HallCartListFrag.OrderAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) throws NumberFormatException {
                    int num;
                    int num2 = 1;
                    try {
                        num2 = Integer.parseInt(et_content.getText().toString());
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    int i = finalMinbuy;
                    if (num2 < i) {
                        num = i;
                        et_content.setText(String.valueOf(i));
                    } else {
                        num = num2 + 1;
                        et_content.setText(String.valueOf(num));
                    }
                    tv_start_num.setVisibility(8);
                    iv_add.setVisibility(0);
                    HallCartListFrag.this.patrolVm.hallCartSub(String.valueOf(num), data.getCart_id());
                }
            });
            iv_add.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.HallCartListFrag.OrderAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) throws NumberFormatException {
                    int num = 1;
                    try {
                        num = Integer.parseInt(et_content.getText().toString());
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    int num2 = num + 1;
                    et_content.setText(String.valueOf(num2 >= 1 ? num2 : 1));
                    HallCartListFrag.this.patrolVm.hallCartSub(String.valueOf(num2), data.getCart_id());
                }
            });
            iv_sub.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.HallCartListFrag.OrderAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) throws NumberFormatException {
                    int num;
                    int num2 = 1;
                    try {
                        num2 = Integer.parseInt(et_content.getText().toString());
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    if (num2 > finalMinbuy) {
                        num = num2 - 1;
                        et_content.setText(String.valueOf(num));
                        tv_start_num.setVisibility(8);
                        iv_add.setVisibility(0);
                    } else {
                        num = 0;
                        et_content.setText("0");
                        if (finalMinbuy > 1) {
                            iv_add.setVisibility(8);
                            tv_start_num.setVisibility(0);
                            tv_start_num.setBackground(BackgroundLibUtil.getBlue(2131165623));
                            tv_start_num.setText(finalMinbuy + data.getProduct().getProduct_unit() + "起点");
                        } else {
                            tv_start_num.setVisibility(8);
                            iv_add.setVisibility(0);
                        }
                    }
                    HallCartListFrag.this.patrolVm.hallCartSub(String.valueOf(num), data.getCart_id());
                }
            });
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493022;
        }
    }

    protected boolean subscribeEvents() {
        return true;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(FlashListEvent event) {
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(FinishActtEvent event) {
        if (event != null && event.getLayer() < 2) {
            getActivity().finish();
        }
    }
}
