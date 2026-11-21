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
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragCouponlistBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.BitmapMemoryCache;
import com.collectpoint.utils.DoubleUtil;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.TimeUtil;
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

    private class CouponAdapte extends SSelectedRecyclerAdapter<CouponItem> {
        private boolean isunuser;

        public CouponAdapte(Activity activity) {
            super(activity);
            this.isunuser = false;
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493016;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, final int i, final CouponItem couponItem) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297136);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131297132);
            TextView textView3 = (TextView) sRecyclerViewHolder.get(2131297100);
            TextView textView4 = (TextView) sRecyclerViewHolder.get(2131297099);
            final TextView textView5 = (TextView) sRecyclerViewHolder.get(2131296993);
            TextView textView6 = (TextView) sRecyclerViewHolder.get(2131297050);
            ImageView imageView = (ImageView) sRecyclerViewHolder.get(2131296597);
            final TextView textView7 = (TextView) sRecyclerViewHolder.get(2131297004);
            final TextView textView8 = (TextView) sRecyclerViewHolder.get(2131296971);
            if (this.isunuser) {
                textView.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131099748));
                textView3.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131100175));
                textView4.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131100175));
                textView6.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131099748));
                imageView.setImageResource(2131231096);
            } else {
                textView.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131099824));
                textView3.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131100169));
                textView4.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131100169));
                textView6.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131099824));
                imageView.setImageResource(couponItem.isSelected() ? 2131230989 : 2131231171);
            }
            if (TextUtils.equals("10", couponItem.getCoupon_type().getValue())) {
                if (TextUtils.equals(couponItem.getMin_price(), BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO)) {
                    textView6.setText("无门槛");
                } else {
                    textView6.setText("满" + couponItem.getMin_price() + "可用");
                }
                textView3.setText(couponItem.getReduce_price());
                textView4.setText("元");
            } else if (TextUtils.equals("20", couponItem.getCoupon_type().getValue())) {
                textView3.setText(couponItem.getDiscount());
                textView4.setText("折");
                textView6.setText("");
            } else if (TextUtils.equals("30", couponItem.getCoupon_type().getValue())) {
                textView4.setText("元");
                textView6.setText("");
                textView3.setText(couponItem.getCoupon_money());
            } else if (TextUtils.equals("40", couponItem.getCoupon_type().getValue())) {
                textView3.setText(couponItem.getCoupon_money());
                textView4.setText("元");
                if (TextUtils.equals(couponItem.getMin_price(), BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO)) {
                    textView6.setText("无门槛");
                } else {
                    textView6.setText("满" + couponItem.getMin_price() + "可用");
                }
            }
            textView.setText(couponItem.getName());
            String str = "";
            if (EmptyUtils.isNotEmpty(couponItem.getStart_time().getText()) || EmptyUtils.isNotEmpty(couponItem.getEnd_time().getText())) {
                str = EmptyUtils.isNotEmpty(couponItem.getStart_time().getText()) ? "有效期：" + couponItem.getStart_time().getText() : "有效期：";
                if (EmptyUtils.isNotEmpty(couponItem.getEnd_time().getText())) {
                    str = str + "至" + couponItem.getEnd_time().getText();
                }
            }
            textView2.setText(str);
            textView5.setText(couponItem.getContent());
            textView7.setVisibility((EmptyUtils.isEmpty(couponItem.getContent()) || couponItem.getContent().length() < 40) ? 8 : 0);
            textView7.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListFrag.CouponAdapte.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    textView5.setMaxLines(TimeUtil.MILLISECONDS_OF_ONE_SECOND);
                    textView7.setVisibility(8);
                    textView8.setVisibility(0);
                }
            });
            textView8.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListFrag.CouponAdapte.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    textView5.setMaxLines(2);
                    textView7.setVisibility(0);
                    textView8.setVisibility(8);
                }
            });
            sRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListFrag.CouponAdapte.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CouponAdapte.this.isunuser) {
                        return;
                    }
                    CouponAdapte.this.selectItem(i);
                    boolean zIsSelected = ((CouponItem) CouponAdapte.this.getItem(i)).isSelected();
                    boolean z = false;
                    if (EmptyUtils.isNotEmpty(CouponListFrag.this.choiceCoupon)) {
                        for (int size = CouponListFrag.this.choiceCoupon.size() - 1; size >= 0; size--) {
                            if (EmptyUtils.isNotEmpty(((CouponItem) CouponListFrag.this.choiceCoupon.get(size)).getSettle_id()) && TextUtils.equals(((CouponItem) CouponListFrag.this.choiceCoupon.get(size)).getSettle_id(), couponItem.getSettle_id())) {
                                z = true;
                                if (!zIsSelected) {
                                    CouponListFrag.this.choiceCoupon.remove(size);
                                }
                            }
                        }
                    }
                    if (zIsSelected && !z) {
                        if (!CouponListFrag.this.isPack && EmptyUtils.isNotEmpty(CouponListFrag.this.choiceCoupon)) {
                            int size2 = CouponListFrag.this.choiceCoupon.size();
                            while (true) {
                                size2--;
                                if (size2 <= -1) {
                                    break;
                                } else if ("3".equals(((CouponItem) CouponListFrag.this.choiceCoupon.get(size2)).getSettle_type())) {
                                    CouponListFrag.this.choiceCoupon.remove(size2);
                                }
                            }
                        }
                        couponItem.setOrder_id(CouponListFrag.this.order_id);
                        CouponListFrag.this.choiceCoupon.add(couponItem);
                    }
                    if (CouponListFrag.this.isPack) {
                        return;
                    }
                    CouponListFrag.this.clearChoiceData();
                }
            });
        }

        public void setIsunuser(boolean z) {
            this.isunuser = z;
        }
    }

    private class MemberrAdapte extends SSelectedRecyclerAdapter<CoupomRes> {
        public MemberrAdapte(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493028;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, final int i, final CoupomRes coupomRes) {
            SRecyclerView sRecyclerView;
            SRecyclerView sRecyclerView2;
            int i2;
            ImageView imageView = (ImageView) sRecyclerViewHolder.get(2131296597);
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297129);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131297045);
            TextView textView3 = (TextView) sRecyclerViewHolder.get(2131297099);
            TextView textView4 = (TextView) sRecyclerViewHolder.get(2131297142);
            TextView textView5 = (TextView) sRecyclerViewHolder.get(2131297039);
            final TextView textView6 = (TextView) sRecyclerViewHolder.get(2131297034);
            final View view = sRecyclerViewHolder.get(2131297179);
            final View view2 = sRecyclerViewHolder.get(2131297188);
            imageView.setVisibility(CouponListFrag.this.isPack ? 8 : 0);
            SRecyclerView sRecyclerView3 = (SRecyclerView) sRecyclerViewHolder.get(2131296859);
            textView.setText(CouponListFrag.this.setTele(coupomRes.getMobile()));
            textView2.setText(coupomRes.getName());
            textView2.setBackground(BackgroundLibUtil.getBlueW(2131166007));
            double d = 0.0d;
            try {
                d = Double.parseDouble(coupomRes.getEquity()) / 10.0d;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            textView3.setText(DoubleUtil.data2end(d) + "折");
            StringBuilder sbAppend = new StringBuilder().append("可用(");
            boolean zIsEmpty = EmptyUtils.isEmpty(coupomRes.getCoupon());
            Object objValueOf = BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO;
            textView4.setText(sbAppend.append(zIsEmpty ? BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO : Integer.valueOf(coupomRes.getCoupon().size())).append(")").toString());
            StringBuilder sbAppend2 = new StringBuilder().append("不可用(");
            if (!EmptyUtils.isEmpty(coupomRes.getNotUseCoupon())) {
                objValueOf = Integer.valueOf(coupomRes.getNotUseCoupon().size());
            }
            textView5.setText(sbAppend2.append(objValueOf).append(")").toString());
            imageView.setImageResource(coupomRes.isSelected() ? 2131230989 : 2131231171);
            view2.setVisibility(0);
            final CouponAdapte couponAdapte = CouponListFrag.this.new CouponAdapte(getActivity());
            couponAdapte.setMode(CouponListFrag.this.isPack ? SSelectedRecyclerAdapter.SelectedMode.MULTI : SSelectedRecyclerAdapter.SelectedMode.SINGLE);
            couponAdapte.setIsunuser(false);
            sRecyclerView3.setAdapter(couponAdapte);
            if (EmptyUtils.isEmpty(coupomRes.getCoupon())) {
                textView6.setVisibility(0);
                couponAdapte.clearData();
                sRecyclerView = sRecyclerView3;
            } else {
                textView6.setVisibility(8);
                int i3 = 0;
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(coupomRes.getCoupon());
                if (EmptyUtils.isNotEmpty(CouponListFrag.this.choiceCoupon)) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i3;
                        if (i4 >= arrayList.size()) {
                            break;
                        }
                        int i6 = 0;
                        while (true) {
                            sRecyclerView2 = sRecyclerView3;
                            if (i6 < CouponListFrag.this.choiceCoupon.size()) {
                                if (EmptyUtils.isNotEmpty(((CouponItem) CouponListFrag.this.choiceCoupon.get(i6)).getSettle_id()) && TextUtils.equals(((CouponItem) CouponListFrag.this.choiceCoupon.get(i6)).getSettle_id(), ((CouponItem) arrayList.get(i4)).getSettle_id())) {
                                    i5++;
                                    i2 = 1;
                                    ((CouponItem) arrayList.get(i4)).setSelected(true);
                                    i6 = 10000;
                                } else {
                                    i2 = 1;
                                }
                                i6 += i2;
                                sRecyclerView3 = sRecyclerView2;
                            }
                        }
                        i4++;
                        i3 = i5;
                        sRecyclerView3 = sRecyclerView2;
                    }
                    sRecyclerView = sRecyclerView3;
                } else {
                    sRecyclerView = sRecyclerView3;
                }
                couponAdapte.setData(arrayList);
            }
            view.setVisibility(8);
            if (!CouponListFrag.this.isPack) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListFrag.MemberrAdapte.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        MemberrAdapte.this.selectItem(i);
                        boolean zIsSelected = ((CoupomRes) MemberrAdapte.this.getItem(i)).isSelected();
                        if (EmptyUtils.isNotEmpty(CouponListFrag.this.choiceCoupon)) {
                            int size = CouponListFrag.this.choiceCoupon.size();
                            while (true) {
                                size--;
                                if (size <= -1) {
                                    break;
                                } else if ("2".equals(((CouponItem) CouponListFrag.this.choiceCoupon.get(size)).getSettle_type())) {
                                    CouponListFrag.this.choiceCoupon.remove(size);
                                }
                            }
                        }
                        if (zIsSelected) {
                            CouponItem couponItem = new CouponItem();
                            couponItem.setSettle_type("2");
                            couponItem.setUser_id(coupomRes.getUser_id());
                            couponItem.setRadio(coupomRes.getEquity());
                            CouponListFrag.this.choiceCoupon.add(couponItem);
                        }
                        CouponListFrag.this.clearChoiceData();
                    }
                });
            }
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListFrag.MemberrAdapte.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    view.setVisibility(8);
                    view2.setVisibility(0);
                    if (EmptyUtils.isEmpty(coupomRes.getCoupon())) {
                        textView6.setVisibility(0);
                        couponAdapte.clearData();
                        return;
                    }
                    textView6.setVisibility(8);
                    int i7 = 0;
                    ArrayList arrayList2 = new ArrayList(coupomRes.getCoupon());
                    if (EmptyUtils.isNotEmpty(CouponListFrag.this.choiceCoupon)) {
                        for (int i8 = 0; i8 < arrayList2.size(); i8++) {
                            int i9 = 0;
                            while (i9 < CouponListFrag.this.choiceCoupon.size()) {
                                if (EmptyUtils.isNotEmpty(((CouponItem) CouponListFrag.this.choiceCoupon.get(i9)).getSettle_id()) && TextUtils.equals(((CouponItem) CouponListFrag.this.choiceCoupon.get(i9)).getSettle_id(), ((CouponItem) arrayList2.get(i8)).getSettle_id())) {
                                    i7++;
                                    ((CouponItem) arrayList2.get(i8)).setSelected(true);
                                    i9 = 10000;
                                }
                                i9++;
                            }
                        }
                    }
                    couponAdapte.setIsunuser(false);
                    couponAdapte.setData(coupomRes.getCoupon());
                }
            });
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListFrag.MemberrAdapte.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    view.setVisibility(0);
                    view2.setVisibility(8);
                    if (EmptyUtils.isEmpty(coupomRes.getNotUseCoupon())) {
                        textView6.setVisibility(0);
                        couponAdapte.clearData();
                    } else {
                        textView6.setVisibility(8);
                        couponAdapte.setIsunuser(true);
                        couponAdapte.setData(coupomRes.getNotUseCoupon());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChoiceData() {
        if (this.isPack) {
            return;
        }
        Collection list = this.adapter.getList();
        ArrayList arrayList = new ArrayList();
        if (EmptyUtils.isNotEmpty(list)) {
            arrayList.addAll(list);
            for (int i = 0; i < arrayList.size(); i++) {
                ((CoupomRes) arrayList.get(i)).setSelected(false);
                List<CouponItem> coupon = ((CoupomRes) arrayList.get(i)).getCoupon();
                if (EmptyUtils.isNotEmpty(coupon)) {
                    for (int i2 = 0; i2 < coupon.size(); i2++) {
                        coupon.get(i2).setSelected(false);
                    }
                }
            }
            if (EmptyUtils.isNotEmpty(this.choiceCoupon)) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    for (int i4 = 0; i4 < this.choiceCoupon.size(); i4++) {
                        if (TextUtils.equals("2", this.choiceCoupon.get(i4).getSettle_type()) && EmptyUtils.isNotEmpty(((CoupomRes) arrayList.get(i3)).getUser_id()) && TextUtils.equals(((CoupomRes) arrayList.get(i3)).getUser_id(), this.choiceCoupon.get(i4).getUser_id())) {
                            ((CoupomRes) arrayList.get(i3)).setSelected(true);
                        }
                    }
                }
            }
        }
        this.adapter.setData(arrayList);
    }

    private void init() throws NumberFormatException {
        this.orderInfoReq = (OrderInfoReq) getArguments().getParcelable(Constants.KEY_ITEM);
        this.isPack = getArguments().getBoolean(Constants.KEY_REPORT_TYPE);
        this.order_id = getArguments().getString(Constants.KEY_CODE);
        if (this.orderInfoReq != null) {
            ArrayList arrayList = new ArrayList();
            if (EmptyUtils.isNotEmpty(this.orderInfoReq.getSettle())) {
                arrayList.addAll(this.orderInfoReq.getSettle());
            }
            if (EmptyUtils.isNotEmpty(this.orderInfoReq.getCoupon())) {
                arrayList.addAll(this.orderInfoReq.getCoupon());
            }
            if (EmptyUtils.isNotEmpty(arrayList)) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (this.isPack) {
                        double d = 0.0d;
                        try {
                            d = Double.parseDouble(((CouponItem) arrayList.get(i)).getSettle_id());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if ((TextUtils.equals("11", ((CouponItem) arrayList.get(i)).getSettle_type()) || TextUtils.equals("12", ((CouponItem) arrayList.get(i)).getSettle_type())) && d < 1.0E8d) {
                            this.choiceCoupon.add((CouponItem) arrayList.get(i));
                        }
                    } else if ("2".equals(((CouponItem) arrayList.get(i)).getSettle_type()) || "3".equals(((CouponItem) arrayList.get(i)).getSettle_type())) {
                        this.choiceCoupon.add((CouponItem) arrayList.get(i));
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
            public void afterTextChanged(Editable editable) {
                String string = CouponListFrag.this.mBinding.etSeachPhone.getText().toString();
                if (EmptyUtils.isNotEmpty(string) && string.length() == 11) {
                    CouponListFrag.this.mBinding.tvCancel.setVisibility(8);
                    CouponListFrag.this.mBinding.tvSearch.setVisibility(0);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.mBinding.etSeachPhone.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.collectpoint.moudle.product.CouponListFrag.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 3 && i2 != 0) {
                    return false;
                }
                CouponListFrag.this.searchData();
                return true;
            }
        });
    }

    public static CouponListFrag newInstance(OrderInfoReq orderInfoReq, boolean z, String str) {
        CouponListFrag couponListFrag = new CouponListFrag();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.KEY_ITEM, orderInfoReq);
        bundle.putBoolean(Constants.KEY_REPORT_TYPE, z);
        bundle.putString(Constants.KEY_CODE, str);
        couponListFrag.setArguments(bundle);
        return couponListFrag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchData() {
        String string = this.mBinding.etSeachPhone.getText().toString();
        if (EmptyUtils.isEmpty(string) || string.length() != 11) {
            ToastUtils.showLong("请输入正确的手机号");
            return;
        }
        closeKeyboard();
        this.mBinding.tvCancel.setVisibility(0);
        this.mBinding.tvSearch.setVisibility(8);
        onLazyLoadingData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String setTele(String str) {
        return (!EmptyUtils.isNotEmpty(str) || str.length() < 11 || str.contains("*")) ? str : str.substring(0, str.length() - 8) + "****" + str.substring(str.length() - 4, str.length());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-CouponListFrag, reason: not valid java name */
    /* synthetic */ void m180lambda$onInit$0$comcollectpointmoudleproductCouponListFrag(Resource resource) {
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
                this.mBinding.tvEmpty.setVisibility((EmptyUtils.isEmpty(resource.data) || EmptyUtils.isEmpty(((BaseDataRes) resource.data).getData())) ? 0 : 8);
                ArrayList arrayList = new ArrayList();
                if (EmptyUtils.isNotEmpty(((BaseDataRes) resource.data).getData())) {
                    arrayList.addAll((Collection) ((BaseDataRes) resource.data).getData());
                    if (EmptyUtils.isNotEmpty(this.choiceCoupon) && EmptyUtils.isNotEmpty(((CoupomRes) arrayList.get(0)).getCoupon())) {
                        for (int i = 0; i < ((CoupomRes) arrayList.get(0)).getCoupon().size(); i++) {
                            for (int i2 = 0; i2 < this.choiceCoupon.size(); i2++) {
                                if (EmptyUtils.isNotEmpty(this.choiceCoupon.get(i2).getSettle_id()) && TextUtils.equals(this.choiceCoupon.get(i2).getSettle_id(), ((CoupomRes) arrayList.get(0)).getCoupon().get(i).getSettle_id())) {
                                    ((CoupomRes) arrayList.get(0)).getCoupon().get(i).setSelected(true);
                                }
                            }
                        }
                    }
                }
                this.adapter.setData(arrayList);
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-CouponListFrag, reason: not valid java name */
    /* synthetic */ void m181lambda$onInit$1$comcollectpointmoudleproductCouponListFrag(Resource resource) {
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
                this.mBinding.tvEmpty.setVisibility((EmptyUtils.isEmpty(resource.data) || EmptyUtils.isEmpty(((BaseDataRes) resource.data).getData())) ? 0 : 8);
                ArrayList arrayList = new ArrayList();
                if (EmptyUtils.isNotEmpty(((BaseDataRes) resource.data).getData())) {
                    arrayList.addAll((Collection) ((BaseDataRes) resource.data).getData());
                    if (EmptyUtils.isNotEmpty(this.choiceCoupon) && EmptyUtils.isNotEmpty(((CoupomRes) arrayList.get(0)).getCoupon())) {
                        for (int i = 0; i < ((CoupomRes) arrayList.get(0)).getCoupon().size(); i++) {
                            for (int i2 = 0; i2 < this.choiceCoupon.size(); i2++) {
                                if (EmptyUtils.isNotEmpty(this.choiceCoupon.get(i2).getSettle_id()) && TextUtils.equals(this.choiceCoupon.get(i2).getSettle_id(), ((CoupomRes) arrayList.get(0)).getCoupon().get(i).getSettle_id())) {
                                    ((CoupomRes) arrayList.get(0)).getCoupon().get(i).setSelected(true);
                                }
                            }
                        }
                    }
                }
                this.adapter.setData(arrayList);
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                    break;
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-CouponListFrag, reason: not valid java name */
    /* synthetic */ void m182lambda$onInit$2$comcollectpointmoudleproductCouponListFrag(Resource resource) {
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
                requireActivity().setResult(4, new Intent());
                requireActivity().finish();
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
                String str = this.isPack ? "11" : "2";
                if (EmptyUtils.isNotEmpty(this.choiceCoupon)) {
                    for (int i = 0; i < this.choiceCoupon.size(); i++) {
                        this.choiceCoupon.get(i).setOrder_id(this.order_id);
                        if (!this.isPack && TextUtils.equals("3", this.choiceCoupon.get(i).getSettle_type())) {
                            str = "3";
                        }
                    }
                }
                this.patrolVm.addOrderCoupon(new AddOrderCouponReq(this.choiceCoupon, this.order_id, str));
                break;
            case 2131297136:
                getActivity().finish();
                break;
        }
    }

    protected void onInit() {
        this.patrolVm.mCouponList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m180lambda$onInit$0$comcollectpointmoudleproductCouponListFrag((Resource) obj);
            }
        });
        this.patrolVm.mPackCouponList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m181lambda$onInit$1$comcollectpointmoudleproductCouponListFrag((Resource) obj);
            }
        });
        this.patrolVm.mAddOrderCoupon.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m182lambda$onInit$2$comcollectpointmoudleproductCouponListFrag((Resource) obj);
            }
        });
    }

    protected void onLazyLoadingData() {
        if (this.isPack) {
            this.patrolVm.getPackCouponList(this.orderInfoReq.getTable_id(), this.orderInfoReq.getOrder_id(), this.orderInfoReq.getShop_supplier_id(), this.mBinding.etSeachPhone.getText().toString(), new ArrayList(), new ArrayList());
        } else {
            this.mBinding.tvHint.setVisibility(0);
            this.patrolVm.getCouponList(this.orderInfoReq.getTable_id(), this.orderInfoReq.getOrder_id(), this.orderInfoReq.getShop_supplier_id(), this.mBinding.etSeachPhone.getText().toString(), new ArrayList(), new ArrayList());
        }
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws NumberFormatException {
        FragCouponlistBinding fragCouponlistBinding = (FragCouponlistBinding) DataBindingUtil.inflate(layoutInflater, 2131492969, viewGroup, false);
        this.mBinding = fragCouponlistBinding;
        fragCouponlistBinding.setLifecycleOwner(this);
        this.patrolVm = ViewModelProviders.of(this, PatrolVmFactory.getInstance(MyApp.getInstance())).get(PatrolVm.class);
        init();
        return this.mBinding.getRoot();
    }
}
