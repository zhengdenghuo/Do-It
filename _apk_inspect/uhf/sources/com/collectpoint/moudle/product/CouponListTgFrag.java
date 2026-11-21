package com.collectpoint.moudle.product;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.MyApp;
import com.collectpoint.bean.item.CouponItem;
import com.collectpoint.bean.item.GroupTypeItem;
import com.collectpoint.bean.req.AddOrderCouponReq;
import com.collectpoint.bean.req.OrderInfoReq;
import com.collectpoint.bean.res.BaseDataRes;
import com.collectpoint.bean.res.BaseListRes;
import com.collectpoint.bean.res.Coupon2Res;
import com.collectpoint.databinding.FragCouponlistTgBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.widget.popupwindow.DouyinCouponWindow;
import com.collectpoint.widget.recycler.SRecyclerViewHolder;
import com.collectpoint.widget.recycler.SSelectedRecyclerAdapter;
import com.collectpoint.widget.recycler.SSimpleRecyclerAdapter;
import com.example.barcodelib.ScanBarCodeLib;
import com.example.barcodelib.ScanCallback;
import com.google.common.base.Preconditions;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.recyclerview.GridSpacesItemDecoration;
import com.liuwq.base.widget.CustomDialogFragCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class CouponListTgFrag extends BaseFragment implements View.OnClickListener, ScanCallback, DouyinCouponWindow.OnSiteClickListener {
    private CouponAdapte adapter;
    private CouponDyAdapte adapterDy;
    private PayTypeAdapter adapterGroup;
    private DouyinCouponWindow cartWindow;
    private FragCouponlistTgBinding mBinding;
    private OrderInfoReq orderInfoReq;
    private String order_id;
    private PatrolVm patrolVm;
    private String type = "1";
    private List<CouponItem> choiceCoupon = new ArrayList();
    private ScanBarCodeLib scanBarCodeLib = new ScanBarCodeLib(this);

    public static CouponListTgFrag newInstance(OrderInfoReq orderInfoReq, String order_id) {
        CouponListTgFrag fragment = new CouponListTgFrag();
        Bundle args = new Bundle();
        args.putString("code", order_id);
        args.putParcelable("item", orderInfoReq);
        fragment.setArguments(args);
        return fragment;
    }

    protected View provideContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws NumberFormatException {
        FragCouponlistTgBinding fragCouponlistTgBindingInflate = DataBindingUtil.inflate(inflater, 2131492970, container, false);
        this.mBinding = fragCouponlistTgBindingInflate;
        fragCouponlistTgBindingInflate.setLifecycleOwner(this);
        PatrolVmFactory vmFactory = PatrolVmFactory.getInstance(MyApp.getInstance());
        this.patrolVm = ViewModelProviders.of(this, vmFactory).get(PatrolVm.class);
        this.scanBarCodeLib.initBarCode(getContext());
        init();
        this.patrolVm.getGroupTypeList();
        return this.mBinding.getRoot();
    }

    private void init() throws NumberFormatException {
        this.orderInfoReq = getArguments().getParcelable("item");
        this.order_id = getArguments().getString("code");
        List<CouponItem> choiceCouponCache = new ArrayList<>();
        if (EmptyUtils.isNotEmpty(this.orderInfoReq.getSettle())) {
            choiceCouponCache.addAll(this.orderInfoReq.getSettle());
        }
        if (EmptyUtils.isNotEmpty(this.orderInfoReq.getCoupon())) {
            choiceCouponCache.addAll(this.orderInfoReq.getCoupon());
        }
        if (EmptyUtils.isNotEmpty(choiceCouponCache)) {
            for (int i = 0; i < choiceCouponCache.size(); i++) {
                double settleId = 0.0d;
                try {
                    settleId = Double.parseDouble(choiceCouponCache.get(i).getSettle_id());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if ((TextUtils.equals("11", choiceCouponCache.get(i).getSettle_type()) || TextUtils.equals("12", choiceCouponCache.get(i).getSettle_type())) && settleId >= 1.0E8d) {
                    this.choiceCoupon.add(choiceCouponCache.get(i));
                }
            }
        }
        showDyMt(true);
        this.mBinding.tvTitle.setOnClickListener(this);
        this.mBinding.srvOrder.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        CouponAdapte couponAdapte = new CouponAdapte(getActivity());
        this.adapter = couponAdapte;
        couponAdapte.setMode(SSelectedRecyclerAdapter.SelectedMode.SINGLE);
        this.mBinding.srvOrder.setAdapter(this.adapter);
        this.mBinding.srvDy.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.adapterDy = new CouponDyAdapte(getActivity());
        this.mBinding.srvDy.setAdapter(this.adapterDy);
        this.mBinding.tvSubmint.setBackground(BackgroundLibUtil.getBlue(2131165785));
        this.mBinding.tvHeyan.setBackground(BackgroundLibUtil.getBlue(2131165785));
        this.mBinding.etDouyin.setBackground(BackgroundLibUtil.get333333Stroke(2131165785));
        this.mBinding.tvSubmint.setOnClickListener(this);
        this.mBinding.tvHeyan.setOnClickListener(this);
        this.mBinding.ivClose.setOnClickListener(this);
        GridLayoutManager layoutManager = new GridLayoutManager(requireActivity(), 3);
        this.mBinding.srvPayStyle.setLayoutManager(layoutManager);
        PayTypeAdapter payTypeAdapter = new PayTypeAdapter(getActivity());
        this.adapterGroup = payTypeAdapter;
        payTypeAdapter.setMode(SSelectedRecyclerAdapter.SelectedMode.SINGLE_MUST_ONE_SELECTED);
        this.mBinding.srvPayStyle.addItemDecoration(new GridSpacesItemDecoration(20));
        this.mBinding.srvPayStyle.setAdapter(this.adapterGroup);
        this.mBinding.etDouyin.addTextChangedListener(new TextWatcher() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i1, int i22) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i1, int i22) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String s = CouponListTgFrag.this.mBinding.etDouyin.getText().toString();
                if (EmptyUtils.isNotEmpty(s) && s.endsWith("\n")) {
                    EditText editText = CouponListTgFrag.this.mBinding.etDouyin;
                    String s2 = s.substring(0, s.length() - 1);
                    editText.setText(s2);
                    if ("1".equals(CouponListTgFrag.this.type)) {
                        CouponListTgFrag.this.patrolVm.getMeiTuanCouponInfo(s2, CouponListTgFrag.this.order_id);
                    } else {
                        CouponListTgFrag.this.patrolVm.getCouponInfo2(s2, CouponListTgFrag.this.order_id);
                    }
                }
            }
        });
    }

    protected void onLazyLoadingData() {
    }

    protected void onInit() {
        this.patrolVm.mGroupTypeList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListTgFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m4lambda$onInit$0$comcollectpointmoudleproductCouponListTgFrag((Resource) obj);
            }
        });
        this.patrolVm.mGroupCouponList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListTgFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m5lambda$onInit$1$comcollectpointmoudleproductCouponListTgFrag((Resource) obj);
            }
        });
        this.patrolVm.mVerifyCoupon.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListTgFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m6lambda$onInit$2$comcollectpointmoudleproductCouponListTgFrag((Resource) obj);
            }
        });
        this.patrolVm.mCouponListDyMt.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListTgFrag$$ExternalSyntheticLambda3
            public final void onChanged(Object obj) {
                this.f$0.m7lambda$onInit$3$comcollectpointmoudleproductCouponListTgFrag((Resource) obj);
            }
        });
        this.patrolVm.mCouponInfo2.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListTgFrag$$ExternalSyntheticLambda4
            public final void onChanged(Object obj) throws NumberFormatException {
                this.f$0.m8lambda$onInit$4$comcollectpointmoudleproductCouponListTgFrag((Resource) obj);
            }
        });
        this.patrolVm.mAddOrderCoupon.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListTgFrag$$ExternalSyntheticLambda5
            public final void onChanged(Object obj) {
                this.f$0.m9lambda$onInit$5$comcollectpointmoudleproductCouponListTgFrag((Resource) obj);
            }
        });
    }

    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-CouponListTgFrag, reason: not valid java name */
    /* synthetic */ void m4lambda$onInit$0$comcollectpointmoudleproductCouponListTgFrag(Resource result) {
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
                this.adapterGroup.setData(((BaseListRes) result.data).getData());
                if (EmptyUtils.isNotEmpty(((BaseListRes) result.data).getData())) {
                    if ("meituan".equals(((GroupTypeItem) ((BaseListRes) result.data).getData().get(0)).getType()) || "douyin".equals(((GroupTypeItem) ((BaseListRes) result.data).getData().get(0)).getType())) {
                        showDyMt(true);
                        String str = "meituan".equals(((GroupTypeItem) ((BaseListRes) result.data).getData().get(0)).getType()) ? "1" : "2";
                        this.type = str;
                        this.patrolVm.getCouponListDyMt(this.order_id, str);
                        break;
                    } else {
                        getDataList(((GroupTypeItem) ((BaseListRes) result.data).getData().get(0)).getPlat_source_id());
                        this.mBinding.srvDy.setVisibility(8);
                        showDyMt(false);
                        break;
                    }
                }
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                    break;
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-CouponListTgFrag, reason: not valid java name */
    /* synthetic */ void m5lambda$onInit$1$comcollectpointmoudleproductCouponListTgFrag(Resource result) {
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
                this.mBinding.tvEmpty.setVisibility((EmptyUtils.isEmpty(result.data) || EmptyUtils.isEmpty(((BaseDataRes) result.data).getData())) ? 0 : 8);
                int choiceNum = 0;
                if (EmptyUtils.isNotEmpty(((BaseDataRes) result.data).getData())) {
                    List<CouponItem> cCoupon = new ArrayList<>((Collection<? extends CouponItem>) ((BaseDataRes) result.data).getData());
                    if (EmptyUtils.isNotEmpty(this.choiceCoupon)) {
                        for (int j = 0; j < this.choiceCoupon.size(); j++) {
                            int i = 0;
                            while (i < cCoupon.size()) {
                                if (TextUtils.equals(this.choiceCoupon.get(j).getSettle_id(), cCoupon.get(i).getSettle_id())) {
                                    cCoupon.get(i).setMyNum(this.choiceCoupon.get(j).getNum());
                                    try {
                                        choiceNum += Integer.parseInt(this.choiceCoupon.get(j).getNum());
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                    }
                                    i = 10000;
                                }
                                i++;
                            }
                        }
                    }
                    this.adapter.setData(cCoupon);
                    break;
                } else {
                    this.adapter.clearData();
                    break;
                }
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                    break;
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-CouponListTgFrag, reason: not valid java name */
    /* synthetic */ void m6lambda$onInit$2$comcollectpointmoudleproductCouponListTgFrag(Resource result) {
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
                DouyinCouponWindow douyinCouponWindow = this.cartWindow;
                if (douyinCouponWindow != null && douyinCouponWindow.isShowing()) {
                    this.cartWindow.dismiss();
                }
                this.mBinding.etDouyin.setText("");
                this.patrolVm.getCouponListDyMt(this.order_id, this.type);
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$3$com-collectpoint-moudle-product-CouponListTgFrag, reason: not valid java name */
    /* synthetic */ void m7lambda$onInit$3$comcollectpointmoudleproductCouponListTgFrag(Resource result) {
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
                this.mBinding.srvDy.setVisibility(0);
                this.adapterDy.setData((List) ((BaseDataRes) result.data).getData());
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                    break;
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$4$com-collectpoint-moudle-product-CouponListTgFrag, reason: not valid java name */
    /* synthetic */ void m8lambda$onInit$4$comcollectpointmoudleproductCouponListTgFrag(Resource result) throws NumberFormatException {
        int maxbuy;
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
                Coupon2Res datas = (Coupon2Res) ((BaseDataRes) result.data).getData();
                datas.setIn_order_id(this.order_id);
                try {
                    maxbuy = Integer.parseInt(datas.getNum());
                } catch (Exception e) {
                    maxbuy = 0;
                }
                if (maxbuy == 1) {
                    if ("1".equals(this.type)) {
                        this.patrolVm.verifyMeituanCoupon(datas);
                        break;
                    } else {
                        this.patrolVm.verifyCoupon(datas);
                        break;
                    }
                } else {
                    DouyinCouponWindow douyinCouponWindow = this.cartWindow;
                    if (douyinCouponWindow != null && douyinCouponWindow.isShowing()) {
                        this.cartWindow.dismiss();
                    }
                    DouyinCouponWindow douyinCouponWindow2 = new DouyinCouponWindow(getActivity(), this.type, datas, this);
                    this.cartWindow = douyinCouponWindow2;
                    douyinCouponWindow2.show(this.mBinding.srvDy);
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

    /* renamed from: lambda$onInit$5$com-collectpoint-moudle-product-CouponListTgFrag, reason: not valid java name */
    /* synthetic */ void m9lambda$onInit$5$comcollectpointmoudleproductCouponListTgFrag(Resource result) {
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
                Intent data = new Intent();
                requireActivity().setResult(4, data);
                requireActivity().finish();
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    public void onAttrSubmit(Coupon2Res req) {
        if ("1".equals(this.type)) {
            this.patrolVm.verifyMeituanCoupon(req);
        } else {
            this.patrolVm.verifyCoupon(req);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296598:
                this.mBinding.etDouyin.setText("");
                break;
            case 2131297033:
                String code = this.mBinding.etDouyin.getText().toString();
                if (EmptyUtils.isNotEmpty(code) && code.endsWith("\n")) {
                    code = code.substring(0, code.length() - 1);
                }
                if (EmptyUtils.isNotEmpty(code)) {
                    if ("1".equals(this.type)) {
                        this.patrolVm.getMeiTuanCouponInfo(code, this.order_id);
                        break;
                    } else {
                        this.patrolVm.getCouponInfo2(code, this.order_id);
                        break;
                    }
                }
                break;
            case 2131297119:
                if (EmptyUtils.isNotEmpty(this.choiceCoupon)) {
                    for (int i = 0; i < this.choiceCoupon.size(); i++) {
                        this.choiceCoupon.get(i).setOrder_id(this.order_id);
                    }
                }
                AddOrderCouponReq req = new AddOrderCouponReq(this.choiceCoupon, this.order_id, "12");
                this.patrolVm.addOrderCoupon(req);
                break;
            case 2131297136:
                if (this.mBinding.etDouyin.getVisibility() == 0) {
                    Intent data = new Intent();
                    requireActivity().setResult(4, data);
                }
                requireActivity().finish();
                break;
        }
    }

    public void onScanBack(String s) {
        if (EmptyUtils.isNotEmpty(s)) {
            if (s.endsWith("\n")) {
                EditText editText = this.mBinding.etDouyin;
                String strSubstring = s.substring(0, s.length() - 1);
                s = strSubstring;
                editText.setText(strSubstring);
            } else {
                this.mBinding.etDouyin.setText(s);
            }
            if ("1".equals(this.type)) {
                this.patrolVm.getMeiTuanCouponInfo(s, this.order_id);
            } else {
                this.patrolVm.getCouponInfo2(s, this.order_id);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.scanBarCodeLib.deInitBarCode(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDyMt(boolean isShow) {
        if (isShow) {
            this.mBinding.etDouyin.requestFocus();
        }
        this.mBinding.etDouyin.setVisibility(isShow ? 0 : 8);
        this.mBinding.tvDyRed.setVisibility(isShow ? 0 : 8);
        this.mBinding.tvDytitle.setVisibility(isShow ? 0 : 8);
        this.mBinding.tvHeyan.setVisibility(isShow ? 0 : 8);
        this.mBinding.ivClose.setVisibility(isShow ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDataList(String plat_source_id) {
        this.patrolVm.getGroupCouponList(this.orderInfoReq.getTable_id(), this.orderInfoReq.getOrder_id(), this.orderInfoReq.getShop_supplier_id(), this.orderInfoReq.getUser_id(), plat_source_id, new ArrayList(), new ArrayList());
    }

    private class CouponAdapte extends SSelectedRecyclerAdapter<CouponItem> {
        public CouponAdapte(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, int position, final CouponItem data) {
            TextView tv_title = (TextView) holder.get(2131297136);
            TextView tv_time = (TextView) holder.get(2131297132);
            TextView tv_rightredBig = (TextView) holder.get(2131297100);
            TextView tv_rightred = (TextView) holder.get(2131297099);
            final TextView tv_describe = (TextView) holder.get(2131296993);
            TextView tv_manjian = (TextView) holder.get(2131297050);
            final TextView et_content = (TextView) holder.get(2131296497);
            ImageView iv_add = (ImageView) holder.get(2131296588);
            ImageView iv_sub = (ImageView) holder.get(2131296622);
            final TextView tv_expand = (TextView) holder.get(2131297004);
            final TextView tv_cloce = (TextView) holder.get(2131296971);
            et_content.setText(EmptyUtils.isEmpty(data.getMyNum()) ? "0" : data.getMyNum());
            tv_title.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131099824));
            tv_rightredBig.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131100169));
            tv_rightred.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131100169));
            tv_manjian.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131099824));
            if (TextUtils.equals("10", data.getCoupon_type().getValue())) {
                if (TextUtils.equals(data.getMin_price(), "0")) {
                    tv_manjian.setText("无门槛");
                } else {
                    tv_manjian.setText("满" + data.getMin_price() + "可用");
                }
                tv_rightredBig.setText(data.getReduce_price());
                tv_rightred.setText("元");
            } else if (TextUtils.equals("20", data.getCoupon_type().getValue())) {
                tv_rightredBig.setText(data.getDiscount());
                tv_rightred.setText("折");
            } else if (TextUtils.equals("30", data.getCoupon_type().getValue())) {
                tv_rightred.setText("元");
                tv_manjian.setText("");
                tv_rightredBig.setText(data.getCoupon_money());
            } else if (TextUtils.equals("40", data.getCoupon_type().getValue())) {
                tv_rightredBig.setText(data.getCoupon_money());
                tv_rightred.setText("元");
                if (TextUtils.equals(data.getMin_price(), "0")) {
                    tv_manjian.setText("无门槛");
                } else {
                    tv_manjian.setText("满" + data.getMin_price() + "可用");
                }
            }
            tv_title.setText(data.getName());
            String time = "";
            if (EmptyUtils.isNotEmpty(data.getStart_time().getText()) || EmptyUtils.isNotEmpty(data.getEnd_time().getText())) {
                time = EmptyUtils.isNotEmpty(data.getStart_time().getText()) ? "有效期：" + data.getStart_time().getText() : "有效期：";
                if (EmptyUtils.isNotEmpty(data.getEnd_time().getText())) {
                    time = time + "至" + data.getEnd_time().getText();
                }
            }
            tv_time.setText(time);
            tv_describe.setText(data.getContent());
            tv_expand.setVisibility((EmptyUtils.isEmpty(data.getContent()) || data.getContent().length() < 10) ? 8 : 0);
            iv_add.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.CouponAdapte.1
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) throws NumberFormatException {
                    int num = 1;
                    try {
                        num = Integer.parseInt(et_content.getText().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int num2 = num + 1;
                    et_content.setText(String.valueOf(num2 < 0 ? 0 : num2));
                    try {
                        num2 = Integer.parseInt(et_content.getText().toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    boolean thishasSelect = false;
                    int choiceNum = 0;
                    if (EmptyUtils.isNotEmpty(CouponListTgFrag.this.choiceCoupon)) {
                        for (int i = CouponListTgFrag.this.choiceCoupon.size() - 1; i >= 0; i--) {
                            if (TextUtils.equals(((CouponItem) CouponListTgFrag.this.choiceCoupon.get(i)).getSettle_id(), data.getSettle_id())) {
                                thishasSelect = true;
                                if (num2 < 1) {
                                    CouponListTgFrag.this.choiceCoupon.remove(i);
                                } else {
                                    ((CouponItem) CouponListTgFrag.this.choiceCoupon.get(i)).setNum(String.valueOf(num2));
                                    choiceNum += num2;
                                }
                            }
                        }
                    }
                    if (num2 > 0 && !thishasSelect) {
                        data.setNum(num2 + "");
                        data.setOrder_id(CouponListTgFrag.this.order_id);
                        CouponListTgFrag.this.choiceCoupon.add(data);
                        int i2 = choiceNum + num2;
                    }
                }
            });
            iv_sub.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.CouponAdapte.2
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) throws NumberFormatException {
                    int num = 1;
                    try {
                        num = Integer.parseInt(et_content.getText().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int num2 = num - 1;
                    et_content.setText(String.valueOf(num2 < 0 ? 0 : num2));
                    try {
                        num2 = Integer.parseInt(et_content.getText().toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    boolean thishasSelect = false;
                    int choiceNum = 0;
                    if (EmptyUtils.isNotEmpty(CouponListTgFrag.this.choiceCoupon)) {
                        for (int i = CouponListTgFrag.this.choiceCoupon.size() - 1; i >= 0; i--) {
                            if (TextUtils.equals(((CouponItem) CouponListTgFrag.this.choiceCoupon.get(i)).getSettle_id(), data.getSettle_id())) {
                                thishasSelect = true;
                                if (num2 < 1) {
                                    CouponListTgFrag.this.choiceCoupon.remove(i);
                                } else {
                                    ((CouponItem) CouponListTgFrag.this.choiceCoupon.get(i)).setNum(String.valueOf(num2));
                                    choiceNum += num2;
                                }
                            }
                        }
                    }
                    if (num2 > 0 && !thishasSelect) {
                        data.setNum(num2 + "");
                        data.setOrder_id(CouponListTgFrag.this.order_id);
                        CouponListTgFrag.this.choiceCoupon.add(data);
                        int i2 = choiceNum + num2;
                    }
                }
            });
            tv_expand.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.CouponAdapte.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    tv_describe.setMaxLines(1000);
                    tv_expand.setVisibility(8);
                    tv_cloce.setVisibility(0);
                }
            });
            tv_cloce.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.CouponAdapte.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    tv_describe.setMaxLines(2);
                    tv_expand.setVisibility(0);
                    tv_cloce.setVisibility(8);
                }
            });
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493018;
        }
    }

    private class CouponDyAdapte extends SSimpleRecyclerAdapter<CouponItem> {
        public void onBindData(SRecyclerViewHolder holder, int position, final CouponItem data) {
            TextView tv_title = (TextView) holder.get(2131297136);
            TextView tv_rightredBig = (TextView) holder.get(2131297100);
            final TextView tv_describe = (TextView) holder.get(2131296993);
            final TextView tv_expand = (TextView) holder.get(2131297004);
            final TextView tv_cloce = (TextView) holder.get(2131296971);
            TextView tv_num = (TextView) holder.get(2131297061);
            ImageView iv_dele = (ImageView) holder.get(2131296606);
            tv_title.setText(data.getName());
            tv_rightredBig.setText(data.getCoupon_money());
            tv_describe.setText(data.getContent());
            tv_num.setText("x" + data.getNum());
            tv_expand.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.CouponDyAdapte.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    tv_describe.setMaxLines(1000);
                    tv_expand.setVisibility(8);
                    tv_cloce.setVisibility(0);
                }
            });
            tv_cloce.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.CouponDyAdapte.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    tv_describe.setMaxLines(2);
                    tv_expand.setVisibility(0);
                    tv_cloce.setVisibility(8);
                }
            });
            iv_dele.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.CouponDyAdapte.3
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    if ("1".equals(CouponListTgFrag.this.type)) {
                        CouponListTgFrag.this.patrolVm.refundMeituanCoupon(data.getPay_method_id());
                    } else {
                        CouponListTgFrag.this.patrolVm.refundCoupon(data.getPay_method_id());
                    }
                }
            });
        }

        public CouponDyAdapte(Activity activity) {
            super(activity);
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493017;
        }
    }

    private class PayTypeAdapter extends SSelectedRecyclerAdapter<GroupTypeItem> {
        public PayTypeAdapter(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, final int position, final GroupTypeItem model) {
            TextView tv_mt = (TextView) holder.get(2131297054);
            tv_mt.setBackground(!model.isSelected() ? BackgroundLibUtil.get333333Stroke(2131166007) : BackgroundLibUtil.getBlueW(2131166007));
            tv_mt.setText(model.getName());
            tv_mt.setTextColor(ContextCompat.getColor(MyApp.getContext(), model.isSelected() ? 2131099745 : 2131099824));
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.PayTypeAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    PayTypeAdapter.this.selectItem(position);
                    if ("meituan".equals(model.getType()) || "douyin".equals(model.getType())) {
                        CouponListTgFrag.this.showDyMt(true);
                        CouponListTgFrag.this.type = "meituan".equals(model.getType()) ? "1" : "2";
                        CouponListTgFrag.this.patrolVm.getCouponListDyMt(CouponListTgFrag.this.order_id, CouponListTgFrag.this.type);
                        return;
                    }
                    CouponListTgFrag.this.getDataList(model.getPlat_source_id());
                    CouponListTgFrag.this.mBinding.srvDy.setVisibility(8);
                    CouponListTgFrag.this.showDyMt(false);
                }
            });
        }

        public GroupTypeItem getChoiceItem() {
            for (GroupTypeItem item : getList()) {
                if (item.isSelected()) {
                    return item;
                }
            }
            return null;
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493021;
        }
    }
}
