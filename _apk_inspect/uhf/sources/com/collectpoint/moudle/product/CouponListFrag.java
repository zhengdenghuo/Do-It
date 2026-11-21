package com.collectpoint.moudle.product;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.MyApp;
import com.collectpoint.bean.item.CouponItem;
import com.collectpoint.bean.req.AddOrderCouponReq;
import com.collectpoint.bean.req.OrderInfoReq;
import com.collectpoint.bean.res.BaseDataRes;
import com.collectpoint.bean.res.CoupomRes;
import com.collectpoint.databinding.FragCouponlistBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.DoubleUtil;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.widget.recycler.SRecyclerView;
import com.collectpoint.widget.recycler.SRecyclerViewHolder;
import com.collectpoint.widget.recycler.SSelectedRecyclerAdapter;
import com.google.common.base.Preconditions;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.widget.CustomDialogFragCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class CouponListFrag extends BaseFragment implements View.OnClickListener {
    private MemberrAdapte adapter;
    private List<CouponItem> choiceCoupon = new ArrayList();
    private boolean isPack;
    private FragCouponlistBinding mBinding;
    private OrderInfoReq orderInfoReq;
    private String order_id;
    private PatrolVm patrolVm;

    public static CouponListFrag newInstance(OrderInfoReq orderInfoReq, boolean isPack, String order_id) {
        CouponListFrag fragment = new CouponListFrag();
        Bundle args = new Bundle();
        args.putParcelable("item", orderInfoReq);
        args.putBoolean("reportType", isPack);
        args.putString("code", order_id);
        fragment.setArguments(args);
        return fragment;
    }

    protected View provideContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws NumberFormatException {
        FragCouponlistBinding fragCouponlistBindingInflate = DataBindingUtil.inflate(inflater, 2131492969, container, false);
        this.mBinding = fragCouponlistBindingInflate;
        fragCouponlistBindingInflate.setLifecycleOwner(this);
        PatrolVmFactory vmFactory = PatrolVmFactory.getInstance(MyApp.getInstance());
        this.patrolVm = ViewModelProviders.of(this, vmFactory).get(PatrolVm.class);
        init();
        return this.mBinding.getRoot();
    }

    private void init() throws NumberFormatException {
        this.orderInfoReq = getArguments().getParcelable("item");
        this.isPack = getArguments().getBoolean("reportType");
        this.order_id = getArguments().getString("code");
        if (this.orderInfoReq != null) {
            List<CouponItem> choiceCouponCache = new ArrayList<>();
            if (EmptyUtils.isNotEmpty(this.orderInfoReq.getSettle())) {
                choiceCouponCache.addAll(this.orderInfoReq.getSettle());
            }
            if (EmptyUtils.isNotEmpty(this.orderInfoReq.getCoupon())) {
                choiceCouponCache.addAll(this.orderInfoReq.getCoupon());
            }
            if (EmptyUtils.isNotEmpty(choiceCouponCache)) {
                for (int i = 0; i < choiceCouponCache.size(); i++) {
                    if (this.isPack) {
                        double settleId = 0.0d;
                        try {
                            settleId = Double.parseDouble(choiceCouponCache.get(i).getSettle_id());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if ((TextUtils.equals("11", choiceCouponCache.get(i).getSettle_type()) || TextUtils.equals("12", choiceCouponCache.get(i).getSettle_type())) && settleId < 1.0E8d) {
                            this.choiceCoupon.add(choiceCouponCache.get(i));
                        }
                    } else if ("2".equals(choiceCouponCache.get(i).getSettle_type()) || "3".equals(choiceCouponCache.get(i).getSettle_type())) {
                        this.choiceCoupon.add(choiceCouponCache.get(i));
                    }
                }
            }
        }
        this.mBinding.tvTitle.setOnClickListener(this);
        this.mBinding.srvOrder.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        MemberrAdapte memberrAdapte = new MemberrAdapte(getActivity());
        this.adapter = memberrAdapte;
        memberrAdapte.setMode(this.isPack ? SSelectedRecyclerAdapter.SelectedMode.MULTI : SSelectedRecyclerAdapter.SelectedMode.SINGLE);
        this.mBinding.srvOrder.setAdapter(this.adapter);
        this.mBinding.tvSubmint.setBackground(BackgroundLibUtil.getBlue(2131165785));
        this.mBinding.tvSubmint.setOnClickListener(this);
        this.mBinding.tvSearch.setOnClickListener(this);
        this.mBinding.tvCancel.setOnClickListener(this);
        this.mBinding.etSeachPhone.setBackground(BackgroundLibUtil.get333333Stroke(2131165735));
        this.mBinding.etSeachPhone.addTextChangedListener(new TextWatcher() { // from class: com.collectpoint.moudle.product.CouponListFrag.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String tele = CouponListFrag.this.mBinding.etSeachPhone.getText().toString();
                if (EmptyUtils.isNotEmpty(tele) && tele.length() == 11) {
                    CouponListFrag.this.mBinding.tvCancel.setVisibility(8);
                    CouponListFrag.this.mBinding.tvSearch.setVisibility(0);
                }
            }
        });
        this.mBinding.etSeachPhone.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.collectpoint.moudle.product.CouponListFrag.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == 3 || actionId == 0) {
                    CouponListFrag.this.searchData();
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchData() {
        String tele = this.mBinding.etSeachPhone.getText().toString();
        if (EmptyUtils.isEmpty(tele) || tele.length() != 11) {
            ToastUtils.showLong("请输入正确的手机号");
            return;
        }
        closeKeyboard();
        this.mBinding.tvCancel.setVisibility(0);
        this.mBinding.tvSearch.setVisibility(8);
        onLazyLoadingData();
    }

    protected void onLazyLoadingData() {
        if (this.isPack) {
            this.patrolVm.getPackCouponList(this.orderInfoReq.getTable_id(), this.orderInfoReq.getOrder_id(), this.orderInfoReq.getShop_supplier_id(), this.mBinding.etSeachPhone.getText().toString(), new ArrayList(), new ArrayList());
        } else {
            this.mBinding.tvHint.setVisibility(0);
            this.patrolVm.getCouponList(this.orderInfoReq.getTable_id(), this.orderInfoReq.getOrder_id(), this.orderInfoReq.getShop_supplier_id(), this.mBinding.etSeachPhone.getText().toString(), new ArrayList(), new ArrayList());
        }
    }

    protected void onInit() {
        this.patrolVm.mCouponList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m1lambda$onInit$0$comcollectpointmoudleproductCouponListFrag((Resource) obj);
            }
        });
        this.patrolVm.mPackCouponList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m2lambda$onInit$1$comcollectpointmoudleproductCouponListFrag((Resource) obj);
            }
        });
        this.patrolVm.mAddOrderCoupon.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m3lambda$onInit$2$comcollectpointmoudleproductCouponListFrag((Resource) obj);
            }
        });
    }

    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-CouponListFrag, reason: not valid java name */
    /* synthetic */ void m1lambda$onInit$0$comcollectpointmoudleproductCouponListFrag(Resource result) {
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
                List<CoupomRes> coupomRes = new ArrayList<>();
                if (EmptyUtils.isNotEmpty(((BaseDataRes) result.data).getData())) {
                    coupomRes.addAll((Collection) ((BaseDataRes) result.data).getData());
                    if (EmptyUtils.isNotEmpty(this.choiceCoupon) && EmptyUtils.isNotEmpty(coupomRes.get(0).getCoupon())) {
                        for (int i = 0; i < coupomRes.get(0).getCoupon().size(); i++) {
                            for (int j = 0; j < this.choiceCoupon.size(); j++) {
                                if (EmptyUtils.isNotEmpty(this.choiceCoupon.get(j).getSettle_id()) && TextUtils.equals(this.choiceCoupon.get(j).getSettle_id(), ((CouponItem) coupomRes.get(0).getCoupon().get(i)).getSettle_id())) {
                                    ((CouponItem) coupomRes.get(0).getCoupon().get(i)).setSelected(true);
                                }
                            }
                        }
                    }
                }
                this.adapter.setData(coupomRes);
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                    break;
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-CouponListFrag, reason: not valid java name */
    /* synthetic */ void m2lambda$onInit$1$comcollectpointmoudleproductCouponListFrag(Resource result) {
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
                List<CoupomRes> coupomRes = new ArrayList<>();
                if (EmptyUtils.isNotEmpty(((BaseDataRes) result.data).getData())) {
                    coupomRes.addAll((Collection) ((BaseDataRes) result.data).getData());
                    if (EmptyUtils.isNotEmpty(this.choiceCoupon) && EmptyUtils.isNotEmpty(coupomRes.get(0).getCoupon())) {
                        for (int i = 0; i < coupomRes.get(0).getCoupon().size(); i++) {
                            for (int j = 0; j < this.choiceCoupon.size(); j++) {
                                if (EmptyUtils.isNotEmpty(this.choiceCoupon.get(j).getSettle_id()) && TextUtils.equals(this.choiceCoupon.get(j).getSettle_id(), ((CouponItem) coupomRes.get(0).getCoupon().get(i)).getSettle_id())) {
                                    ((CouponItem) coupomRes.get(0).getCoupon().get(i)).setSelected(true);
                                }
                            }
                        }
                    }
                }
                this.adapter.setData(coupomRes);
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                    break;
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-CouponListFrag, reason: not valid java name */
    /* synthetic */ void m3lambda$onInit$2$comcollectpointmoudleproductCouponListFrag(Resource result) {
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296965:
                this.mBinding.etSeachPhone.setText("");
                onLazyLoadingData();
                this.mBinding.tvCancel.setVisibility(8);
                this.mBinding.tvSearch.setVisibility(0);
                break;
            case 2131297108:
                searchData();
                break;
            case 2131297119:
                String settle_value = this.isPack ? "11" : "2";
                if (EmptyUtils.isNotEmpty(this.choiceCoupon)) {
                    for (int i = 0; i < this.choiceCoupon.size(); i++) {
                        this.choiceCoupon.get(i).setOrder_id(this.order_id);
                        if (!this.isPack && TextUtils.equals("3", this.choiceCoupon.get(i).getSettle_type())) {
                            settle_value = "3";
                        }
                    }
                }
                AddOrderCouponReq req = new AddOrderCouponReq(this.choiceCoupon, this.order_id, settle_value);
                this.patrolVm.addOrderCoupon(req);
                break;
            case 2131297136:
                getActivity().finish();
                break;
        }
    }

    private class MemberrAdapte extends SSelectedRecyclerAdapter<CoupomRes> {
        public MemberrAdapte(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, final int position, final CoupomRes data) {
            SRecyclerView srv_coupom;
            SRecyclerView srv_coupom2;
            int i;
            ImageView iv_choice = (ImageView) holder.get(2131296597);
            TextView tv_tele = (TextView) holder.get(2131297129);
            TextView tv_level = (TextView) holder.get(2131297045);
            TextView tv_rightred = (TextView) holder.get(2131297099);
            TextView tv_userale = (TextView) holder.get(2131297142);
            TextView tv_inuserale = (TextView) holder.get(2131297039);
            final TextView tv_hint = (TextView) holder.get(2131297034);
            final View v_inuserale = holder.get(2131297179);
            final View v_userale = holder.get(2131297188);
            iv_choice.setVisibility(CouponListFrag.this.isPack ? 8 : 0);
            SRecyclerView srv_coupom3 = holder.get(2131296859);
            tv_tele.setText(CouponListFrag.this.setTele(data.getMobile()));
            tv_level.setText(data.getName());
            tv_level.setBackground(BackgroundLibUtil.getBlueW(2131166007));
            double equity = 0.0d;
            try {
                equity = Double.parseDouble(data.getEquity()) / 10.0d;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            tv_rightred.setText(DoubleUtil.data2end(equity) + "折");
            tv_userale.setText("可用(" + (EmptyUtils.isEmpty(data.getCoupon()) ? "0" : Integer.valueOf(data.getCoupon().size())) + ")");
            tv_inuserale.setText("不可用(" + (EmptyUtils.isEmpty(data.getNotUseCoupon()) ? "0" : Integer.valueOf(data.getNotUseCoupon().size())) + ")");
            iv_choice.setImageResource(data.isSelected() ? 2131230989 : 2131231171);
            v_userale.setVisibility(0);
            final CouponAdapte cAdapter = CouponListFrag.this.new CouponAdapte(getActivity());
            cAdapter.setMode(CouponListFrag.this.isPack ? SSelectedRecyclerAdapter.SelectedMode.MULTI : SSelectedRecyclerAdapter.SelectedMode.SINGLE);
            cAdapter.setIsunuser(false);
            srv_coupom3.setAdapter(cAdapter);
            if (EmptyUtils.isEmpty(data.getCoupon())) {
                tv_hint.setVisibility(0);
                cAdapter.clearData();
                srv_coupom = srv_coupom3;
            } else {
                tv_hint.setVisibility(8);
                int choiceNum = 0;
                List<CouponItem> cCoupon = new ArrayList<>();
                cCoupon.addAll(data.getCoupon());
                if (!EmptyUtils.isNotEmpty(CouponListFrag.this.choiceCoupon)) {
                    srv_coupom = srv_coupom3;
                } else {
                    int i2 = 0;
                    while (true) {
                        int choiceNum2 = choiceNum;
                        int choiceNum3 = cCoupon.size();
                        if (i2 >= choiceNum3) {
                            break;
                        }
                        int j = 0;
                        while (true) {
                            srv_coupom2 = srv_coupom3;
                            if (j < CouponListFrag.this.choiceCoupon.size()) {
                                if (!EmptyUtils.isNotEmpty(((CouponItem) CouponListFrag.this.choiceCoupon.get(j)).getSettle_id()) || !TextUtils.equals(((CouponItem) CouponListFrag.this.choiceCoupon.get(j)).getSettle_id(), cCoupon.get(i2).getSettle_id())) {
                                    i = 1;
                                } else {
                                    choiceNum2++;
                                    i = 1;
                                    cCoupon.get(i2).setSelected(true);
                                    j = 10000;
                                }
                                j += i;
                                srv_coupom3 = srv_coupom2;
                            }
                        }
                        i2++;
                        choiceNum = choiceNum2;
                        srv_coupom3 = srv_coupom2;
                    }
                    srv_coupom = srv_coupom3;
                }
                cAdapter.setData(cCoupon);
            }
            v_inuserale.setVisibility(8);
            if (!CouponListFrag.this.isPack) {
                iv_choice.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListFrag.MemberrAdapte.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        MemberrAdapte.this.selectItem(position);
                        boolean isChoice = ((CoupomRes) MemberrAdapte.this.getItem(position)).isSelected();
                        if (EmptyUtils.isNotEmpty(CouponListFrag.this.choiceCoupon)) {
                            int i3 = CouponListFrag.this.choiceCoupon.size();
                            while (true) {
                                i3--;
                                if (i3 <= -1) {
                                    break;
                                } else if ("2".equals(((CouponItem) CouponListFrag.this.choiceCoupon.get(i3)).getSettle_type())) {
                                    CouponListFrag.this.choiceCoupon.remove(i3);
                                }
                            }
                        }
                        if (isChoice) {
                            CouponItem item = new CouponItem();
                            item.setSettle_type("2");
                            item.setUser_id(data.getUser_id());
                            item.setRadio(data.getEquity());
                            CouponListFrag.this.choiceCoupon.add(item);
                        }
                        CouponListFrag.this.clearChoiceData();
                    }
                });
            }
            tv_userale.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListFrag.MemberrAdapte.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    v_inuserale.setVisibility(8);
                    v_userale.setVisibility(0);
                    if (EmptyUtils.isEmpty(data.getCoupon())) {
                        tv_hint.setVisibility(0);
                        cAdapter.clearData();
                        return;
                    }
                    tv_hint.setVisibility(8);
                    int choiceNum4 = 0;
                    List<CouponItem> cCoupon2 = new ArrayList<>(data.getCoupon());
                    if (EmptyUtils.isNotEmpty(CouponListFrag.this.choiceCoupon)) {
                        for (int i3 = 0; i3 < cCoupon2.size(); i3++) {
                            int j2 = 0;
                            while (j2 < CouponListFrag.this.choiceCoupon.size()) {
                                if (EmptyUtils.isNotEmpty(((CouponItem) CouponListFrag.this.choiceCoupon.get(j2)).getSettle_id()) && TextUtils.equals(((CouponItem) CouponListFrag.this.choiceCoupon.get(j2)).getSettle_id(), cCoupon2.get(i3).getSettle_id())) {
                                    choiceNum4++;
                                    cCoupon2.get(i3).setSelected(true);
                                    j2 = 10000;
                                }
                                j2++;
                            }
                        }
                    }
                    cAdapter.setIsunuser(false);
                    cAdapter.setData(data.getCoupon());
                }
            });
            tv_inuserale.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListFrag.MemberrAdapte.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    v_inuserale.setVisibility(0);
                    v_userale.setVisibility(8);
                    if (EmptyUtils.isEmpty(data.getNotUseCoupon())) {
                        tv_hint.setVisibility(0);
                        cAdapter.clearData();
                    } else {
                        tv_hint.setVisibility(8);
                        cAdapter.setIsunuser(true);
                        cAdapter.setData(data.getNotUseCoupon());
                    }
                }
            });
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493028;
        }
    }

    private class CouponAdapte extends SSelectedRecyclerAdapter<CouponItem> {
        private boolean isunuser;

        public CouponAdapte(Activity activity) {
            super(activity);
            this.isunuser = false;
        }

        public void setIsunuser(boolean isunuser) {
            this.isunuser = isunuser;
        }

        public void onBindData(SRecyclerViewHolder holder, final int position, final CouponItem data) {
            TextView tv_title = (TextView) holder.get(2131297136);
            TextView tv_time = (TextView) holder.get(2131297132);
            TextView tv_rightredBig = (TextView) holder.get(2131297100);
            TextView tv_rightred = (TextView) holder.get(2131297099);
            final TextView tv_describe = (TextView) holder.get(2131296993);
            TextView tv_manjian = (TextView) holder.get(2131297050);
            ImageView iv_choice = (ImageView) holder.get(2131296597);
            final TextView tv_expand = (TextView) holder.get(2131297004);
            final TextView tv_cloce = (TextView) holder.get(2131296971);
            if (this.isunuser) {
                tv_title.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131099748));
                tv_rightredBig.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131100175));
                tv_rightred.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131100175));
                tv_manjian.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131099748));
                iv_choice.setImageResource(2131231096);
            } else {
                tv_title.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131099824));
                tv_rightredBig.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131100169));
                tv_rightred.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131100169));
                tv_manjian.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131099824));
                iv_choice.setImageResource(data.isSelected() ? 2131230989 : 2131231171);
            }
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
                tv_manjian.setText("");
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
            tv_expand.setVisibility((EmptyUtils.isEmpty(data.getContent()) || data.getContent().length() < 40) ? 8 : 0);
            tv_expand.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListFrag.CouponAdapte.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    tv_describe.setMaxLines(1000);
                    tv_expand.setVisibility(8);
                    tv_cloce.setVisibility(0);
                }
            });
            tv_cloce.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListFrag.CouponAdapte.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    tv_describe.setMaxLines(2);
                    tv_expand.setVisibility(0);
                    tv_cloce.setVisibility(8);
                }
            });
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListFrag.CouponAdapte.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (CouponAdapte.this.isunuser) {
                        return;
                    }
                    CouponAdapte.this.selectItem(position);
                    boolean isChoice = ((CouponItem) CouponAdapte.this.getItem(position)).isSelected();
                    boolean thishasSelect = false;
                    if (EmptyUtils.isNotEmpty(CouponListFrag.this.choiceCoupon)) {
                        for (int i = CouponListFrag.this.choiceCoupon.size() - 1; i >= 0; i--) {
                            if (EmptyUtils.isNotEmpty(((CouponItem) CouponListFrag.this.choiceCoupon.get(i)).getSettle_id()) && TextUtils.equals(((CouponItem) CouponListFrag.this.choiceCoupon.get(i)).getSettle_id(), data.getSettle_id())) {
                                thishasSelect = true;
                                if (!isChoice) {
                                    CouponListFrag.this.choiceCoupon.remove(i);
                                }
                            }
                        }
                    }
                    if (isChoice && !thishasSelect) {
                        if (!CouponListFrag.this.isPack && EmptyUtils.isNotEmpty(CouponListFrag.this.choiceCoupon)) {
                            int i2 = CouponListFrag.this.choiceCoupon.size();
                            while (true) {
                                i2--;
                                if (i2 <= -1) {
                                    break;
                                } else if ("3".equals(((CouponItem) CouponListFrag.this.choiceCoupon.get(i2)).getSettle_type())) {
                                    CouponListFrag.this.choiceCoupon.remove(i2);
                                }
                            }
                        }
                        data.setOrder_id(CouponListFrag.this.order_id);
                        CouponListFrag.this.choiceCoupon.add(data);
                    }
                    if (!CouponListFrag.this.isPack) {
                        CouponListFrag.this.clearChoiceData();
                    }
                }
            });
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493016;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChoiceData() {
        if (this.isPack) {
            return;
        }
        Collection<? extends CoupomRes> coupomRes0 = this.adapter.getList();
        List<CoupomRes> coupomRes = new ArrayList<>();
        if (EmptyUtils.isNotEmpty(coupomRes0)) {
            coupomRes.addAll(coupomRes0);
            for (int i = 0; i < coupomRes.size(); i++) {
                coupomRes.get(i).setSelected(false);
                List<CouponItem> coupomResChild = coupomRes.get(i).getCoupon();
                if (EmptyUtils.isNotEmpty(coupomResChild)) {
                    for (int j = 0; j < coupomResChild.size(); j++) {
                        coupomResChild.get(j).setSelected(false);
                    }
                }
            }
            if (EmptyUtils.isNotEmpty(this.choiceCoupon)) {
                for (int i2 = 0; i2 < coupomRes.size(); i2++) {
                    for (int j2 = 0; j2 < this.choiceCoupon.size(); j2++) {
                        if (TextUtils.equals("2", this.choiceCoupon.get(j2).getSettle_type()) && EmptyUtils.isNotEmpty(coupomRes.get(i2).getUser_id()) && TextUtils.equals(coupomRes.get(i2).getUser_id(), this.choiceCoupon.get(j2).getUser_id())) {
                            coupomRes.get(i2).setSelected(true);
                        }
                    }
                }
            }
        }
        this.adapter.setData(coupomRes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String setTele(String tele) {
        if (EmptyUtils.isNotEmpty(tele) && tele.length() >= 11 && !tele.contains("*")) {
            return tele.substring(0, tele.length() - 8) + "****" + tele.substring(tele.length() - 4, tele.length());
        }
        return tele;
    }
}
