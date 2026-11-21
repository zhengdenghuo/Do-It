package com.collectpoint.moudle.product;

import android.app.Activity;
import android.content.Intent;
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
import com.collectpoint.bean.res.HallCartlistRes;
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragHallcartlistBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.BitmapMemoryCache;
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
    private String is_print = BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO;
    private FragHallcartlistBinding mBinding;
    private NumWindow mapPopupWindow;
    private String order_id;
    private PatrolVm patrolVm;
    private List<HallCartlistRes.ProductListRes> productList;
    private String table_id;
    private String titleName;
    private String user_id;

    private class OrderAdapter extends SSimpleRecyclerAdapter<HallCartlistRes.ProductListRes> {
        public OrderAdapter(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493022;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, final HallCartlistRes.ProductListRes productListRes) throws NumberFormatException {
            String str;
            int i2;
            int i3;
            final ImageView imageView = (ImageView) sRecyclerViewHolder.get(2131296588);
            ImageView imageView2 = (ImageView) sRecyclerViewHolder.get(2131296622);
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297056);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131297075);
            final TextView textView3 = (TextView) sRecyclerViewHolder.get(2131297117);
            TextView textView4 = (TextView) sRecyclerViewHolder.get(2131296992);
            final TextView textView5 = (TextView) sRecyclerViewHolder.get(2131296497);
            ImageView imageView3 = (ImageView) sRecyclerViewHolder.get(2131296618);
            textView.setText(productListRes.getProduct().getProduct_name());
            String describe = EmptyUtils.isNotEmpty(productListRes.getDescribe()) ? productListRes.getDescribe() : "";
            if (EmptyUtils.isNotEmpty(productListRes.getFeed())) {
                str = describe + (EmptyUtils.isEmpty(describe) ? "" : ",") + productListRes.getFeed();
            } else {
                str = describe;
            }
            textView4.setText(str);
            textView4.setVisibility(EmptyUtils.isEmpty(str) ? 8 : 0);
            textView5.setText(productListRes.getProduct_num());
            TextView textView6 = (TextView) sRecyclerViewHolder.get(2131297091);
            TextView textView7 = (TextView) sRecyclerViewHolder.get(2131297086);
            textView.setText(productListRes.getProduct().getProduct_name());
            try {
                i2 = Integer.parseInt(productListRes.getProduct().getMin_buy());
            } catch (Exception e) {
                i2 = 1;
            }
            try {
                i3 = Integer.parseInt(productListRes.getProduct_num());
            } catch (Exception e2) {
                i3 = 1;
            }
            if (i2 <= 1 || i3 >= i2) {
                textView3.setVisibility(8);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
                textView3.setVisibility(0);
                textView3.setBackground(BackgroundLibUtil.getBlue(2131165623));
                textView3.setText(i2 + productListRes.getProduct().getProduct_unit() + "起点");
            }
            if (TextUtils.equals("1", productListRes.getProduct().getIs_promotion())) {
                textView2.setText("¥" + productListRes.getPay_price());
                textView6.setVisibility(0);
                textView6.setBackground(BackgroundLibUtil.get999999(2131165785));
                textView7.setText("¥" + productListRes.getProduct_price() + "/" + productListRes.getProduct().getProduct_unit());
                textView7.getPaint().setFlags(16);
            } else {
                textView2.setText("¥" + productListRes.getProduct_price());
                textView6.setVisibility(8);
                textView7.setText("");
            }
            try {
                ImgLoaderManager.get().loadDrawable(imageView3, productListRes.getProduct().getImage().get(0).getFile_path());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            final int i4 = i2;
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.HallCartListFrag.OrderAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) throws NumberFormatException {
                    int i5;
                    int i6 = 1;
                    try {
                        i6 = Integer.parseInt(textView5.getText().toString());
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    int i7 = i4;
                    if (i6 < i7) {
                        i5 = i7;
                        textView5.setText(String.valueOf(i7));
                    } else {
                        i5 = i6 + 1;
                        textView5.setText(String.valueOf(i5));
                    }
                    textView3.setVisibility(8);
                    imageView.setVisibility(0);
                    HallCartListFrag.this.patrolVm.hallCartSub(String.valueOf(i5), productListRes.getCart_id());
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.HallCartListFrag.OrderAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) throws NumberFormatException {
                    int i5 = 1;
                    try {
                        i5 = Integer.parseInt(textView5.getText().toString());
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    int i6 = i5 + 1;
                    textView5.setText(String.valueOf(i6 >= 1 ? i6 : 1));
                    HallCartListFrag.this.patrolVm.hallCartSub(String.valueOf(i6), productListRes.getCart_id());
                }
            });
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.HallCartListFrag.OrderAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) throws NumberFormatException {
                    int i5;
                    int i6 = 1;
                    try {
                        i6 = Integer.parseInt(textView5.getText().toString());
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    if (i6 > i4) {
                        i5 = i6 - 1;
                        textView5.setText(String.valueOf(i5));
                        textView3.setVisibility(8);
                        imageView.setVisibility(0);
                    } else {
                        i5 = 0;
                        textView5.setText(BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
                        if (i4 > 1) {
                            imageView.setVisibility(8);
                            textView3.setVisibility(0);
                            textView3.setBackground(BackgroundLibUtil.getBlue(2131165623));
                            textView3.setText(i4 + productListRes.getProduct().getProduct_unit() + "起点");
                        } else {
                            textView3.setVisibility(8);
                            imageView.setVisibility(0);
                        }
                    }
                    HallCartListFrag.this.patrolVm.hallCartSub(String.valueOf(i5), productListRes.getCart_id());
                }
            });
        }
    }

    private void init() {
        this.table_id = getArguments().getString(Constants.KEY_CODE);
        this.order_id = getArguments().getString(Constants.KEY_ROLE_CODE);
        this.titleName = getArguments().getString("name");
        this.isGift = getArguments().getBoolean(Constants.TYPE_CODE);
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

    public static HallCartListFrag newInstance(String str, String str2, String str3, boolean z) {
        HallCartListFrag hallCartListFrag = new HallCartListFrag();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_CODE, str);
        bundle.putBoolean(Constants.TYPE_CODE, z);
        bundle.putString(Constants.KEY_ROLE_CODE, str2);
        bundle.putString("name", str3);
        hallCartListFrag.setArguments(bundle);
        return hallCartListFrag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-HallCartListFrag, reason: not valid java name */
    /* synthetic */ void m189lambda$onInit$0$comcollectpointmoudleproductHallCartListFrag(Resource resource) {
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
                if (this.productList == null) {
                    this.productList = new ArrayList();
                }
                this.productList.clear();
                if (EmptyUtils.isNotEmpty(((HallCartlistRes) resource.data).getProductList())) {
                    this.productList.addAll(((HallCartlistRes) resource.data).getProductList());
                }
                this.adapter.setData(this.productList);
                if (EmptyUtils.isNotEmpty(((HallCartlistRes) resource.data).getProductList())) {
                    this.user_id = ((HallCartlistRes) resource.data).getProductList().get(0).getUser_id();
                }
                this.mBinding.tvNum.setText("数量" + ((HallCartlistRes) resource.data).getCartInfo().getCart_total_num() + "件，合计：");
                this.mBinding.tvSum.setText("¥" + ((HallCartlistRes) resource.data).getCartInfo().getTotal_pay_price());
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-HallCartListFrag, reason: not valid java name */
    /* synthetic */ void m190lambda$onInit$1$comcollectpointmoudleproductHallCartListFrag(Resource resource) {
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
                this.patrolVm.hallCartList(this.table_id);
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-HallCartListFrag, reason: not valid java name */
    /* synthetic */ void m191lambda$onInit$2$comcollectpointmoudleproductHallCartListFrag(Resource resource) {
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
                ToastUtils.showLong("清除成功");
                this.patrolVm.hallCartList(this.table_id);
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$3$com-collectpoint-moudle-product-HallCartListFrag, reason: not valid java name */
    /* synthetic */ void m192lambda$onInit$3$comcollectpointmoudleproductHallCartListFrag(Resource resource) {
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
                Intent intent = new Intent(getContext(), (Class<?>) OrderDetailAct.class);
                intent.putExtra(Constants.KEY_CODE, this.table_id);
                intent.putExtra("name", this.titleName);
                intent.addFlags(603979776);
                requireActivity().setResult(5, intent);
                startActivity(intent);
                getActivity().finish();
                postEvent(new FlashListEvent());
                postEvent(new FinishActtEvent(1));
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
            case 2131296757:
                this.is_print = "1".equals(this.is_print) ? BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO : "1";
                this.mBinding.rbNocd.setCompoundDrawablesRelativeWithIntrinsicBounds(getContext().getResources().getDrawable("1".equals(this.is_print) ? 2131230990 : 2131231173), (Drawable) null, (Drawable) null, (Drawable) null);
                break;
            case 2131296970:
                Confirm1Dialog confirm1Dialog = new Confirm1Dialog(requireActivity());
                confirm1Dialog.setData("提示", "确定清空购物车？", "");
                confirm1Dialog.setOnConfirmClickListener(new Confirm1Dialog.OnConfirmClickListener() { // from class: com.collectpoint.moudle.product.HallCartListFrag.1
                    @Override // com.collectpoint.widget.popupwindow.Confirm1Dialog.OnConfirmClickListener
                    public void onClick(View view2) {
                        HallCartListFrag.this.patrolVm.hallCartDelete(HallCartListFrag.this.table_id);
                    }
                });
                confirm1Dialog.show();
                break;
            case 2131297119:
                if (!EmptyUtils.isEmpty(this.order_id)) {
                    this.patrolVm.addMeal(this.table_id, this.mBinding.etRemark.getText().toString(), this.order_id, this.user_id, this.isGift, this.is_print);
                    break;
                } else {
                    NumWindow numWindow = new NumWindow(getActivity(), "桌号：" + this.titleName, new NumWindow.OnSiteClickListener() { // from class: com.collectpoint.moudle.product.HallCartListFrag.2
                        @Override // com.collectpoint.widget.popupwindow.NumWindow.OnSiteClickListener
                        public void onAttrSubmit(String str) {
                            HallCartListFrag.this.patrolVm.tableBuy(HallCartListFrag.this.table_id, HallCartListFrag.this.mBinding.etRemark.getText().toString(), str, HallCartListFrag.this.user_id, HallCartListFrag.this.isGift, HallCartListFrag.this.is_print);
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
                }
            case 2131297136:
                getActivity().finish();
                break;
        }
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(FinishActtEvent finishActtEvent) {
        if (finishActtEvent == null || finishActtEvent.getLayer() >= 2) {
            return;
        }
        getActivity().finish();
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(FlashListEvent flashListEvent) {
    }

    protected void onInit() {
        this.patrolVm.mHallCartList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.HallCartListFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m189lambda$onInit$0$comcollectpointmoudleproductHallCartListFrag((Resource) obj);
            }
        });
        this.patrolVm.mHallCartSub.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.HallCartListFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m190lambda$onInit$1$comcollectpointmoudleproductHallCartListFrag((Resource) obj);
            }
        });
        this.patrolVm.mHallCartDelete.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.HallCartListFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m191lambda$onInit$2$comcollectpointmoudleproductHallCartListFrag((Resource) obj);
            }
        });
        this.patrolVm.mAddMeal.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.HallCartListFrag$$ExternalSyntheticLambda3
            public final void onChanged(Object obj) {
                this.f$0.m192lambda$onInit$3$comcollectpointmoudleproductHallCartListFrag((Resource) obj);
            }
        });
    }

    protected void onLazyLoadingData() {
        this.patrolVm.hallCartList(this.table_id);
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragHallcartlistBinding fragHallcartlistBinding = (FragHallcartlistBinding) DataBindingUtil.inflate(layoutInflater, 2131492972, viewGroup, false);
        this.mBinding = fragHallcartlistBinding;
        fragHallcartlistBinding.setLifecycleOwner(this);
        this.patrolVm = ViewModelProviders.of(this, PatrolVmFactory.getInstance(MyApp.getInstance())).get(PatrolVm.class);
        init();
        return this.mBinding.getRoot();
    }

    protected boolean subscribeEvents() {
        return true;
    }
}
