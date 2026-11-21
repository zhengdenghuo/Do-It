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
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragCouponlistTgBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.BitmapMemoryCache;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.TimeUtil;
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

    private class CouponAdapte extends SSelectedRecyclerAdapter<CouponItem> {
        public CouponAdapte(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493018;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, final CouponItem couponItem) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297136);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131297132);
            TextView textView3 = (TextView) sRecyclerViewHolder.get(2131297100);
            TextView textView4 = (TextView) sRecyclerViewHolder.get(2131297099);
            final TextView textView5 = (TextView) sRecyclerViewHolder.get(2131296993);
            TextView textView6 = (TextView) sRecyclerViewHolder.get(2131297050);
            final TextView textView7 = (TextView) sRecyclerViewHolder.get(2131296497);
            ImageView imageView = (ImageView) sRecyclerViewHolder.get(2131296588);
            ImageView imageView2 = (ImageView) sRecyclerViewHolder.get(2131296622);
            final TextView textView8 = (TextView) sRecyclerViewHolder.get(2131297004);
            final TextView textView9 = (TextView) sRecyclerViewHolder.get(2131296971);
            textView7.setText(EmptyUtils.isEmpty(couponItem.getMyNum()) ? BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO : couponItem.getMyNum());
            textView.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131099824));
            textView3.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131100169));
            textView4.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131100169));
            textView6.setTextColor(ContextCompat.getColor(MyApp.getContext(), 2131099824));
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
            textView8.setVisibility((EmptyUtils.isEmpty(couponItem.getContent()) || couponItem.getContent().length() < 10) ? 8 : 0);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.CouponAdapte.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) throws NumberFormatException {
                    int i2 = 1;
                    try {
                        i2 = Integer.parseInt(textView7.getText().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int i3 = i2 + 1;
                    textView7.setText(String.valueOf(i3 < 0 ? 0 : i3));
                    try {
                        i3 = Integer.parseInt(textView7.getText().toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    boolean z = false;
                    int i4 = 0;
                    if (EmptyUtils.isNotEmpty(CouponListTgFrag.this.choiceCoupon)) {
                        for (int size = CouponListTgFrag.this.choiceCoupon.size() - 1; size >= 0; size--) {
                            if (TextUtils.equals(((CouponItem) CouponListTgFrag.this.choiceCoupon.get(size)).getSettle_id(), couponItem.getSettle_id())) {
                                z = true;
                                if (i3 < 1) {
                                    CouponListTgFrag.this.choiceCoupon.remove(size);
                                } else {
                                    ((CouponItem) CouponListTgFrag.this.choiceCoupon.get(size)).setNum(String.valueOf(i3));
                                    i4 += i3;
                                }
                            }
                        }
                    }
                    if (i3 <= 0 || z) {
                        return;
                    }
                    couponItem.setNum(i3 + "");
                    couponItem.setOrder_id(CouponListTgFrag.this.order_id);
                    CouponListTgFrag.this.choiceCoupon.add(couponItem);
                    int i5 = i4 + i3;
                }
            });
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.CouponAdapte.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) throws NumberFormatException {
                    int i2 = 1;
                    try {
                        i2 = Integer.parseInt(textView7.getText().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int i3 = i2 - 1;
                    textView7.setText(String.valueOf(i3 < 0 ? 0 : i3));
                    try {
                        i3 = Integer.parseInt(textView7.getText().toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    boolean z = false;
                    int i4 = 0;
                    if (EmptyUtils.isNotEmpty(CouponListTgFrag.this.choiceCoupon)) {
                        for (int size = CouponListTgFrag.this.choiceCoupon.size() - 1; size >= 0; size--) {
                            if (TextUtils.equals(((CouponItem) CouponListTgFrag.this.choiceCoupon.get(size)).getSettle_id(), couponItem.getSettle_id())) {
                                z = true;
                                if (i3 < 1) {
                                    CouponListTgFrag.this.choiceCoupon.remove(size);
                                } else {
                                    ((CouponItem) CouponListTgFrag.this.choiceCoupon.get(size)).setNum(String.valueOf(i3));
                                    i4 += i3;
                                }
                            }
                        }
                    }
                    if (i3 <= 0 || z) {
                        return;
                    }
                    couponItem.setNum(i3 + "");
                    couponItem.setOrder_id(CouponListTgFrag.this.order_id);
                    CouponListTgFrag.this.choiceCoupon.add(couponItem);
                    int i5 = i4 + i3;
                }
            });
            textView8.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.CouponAdapte.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    textView5.setMaxLines(TimeUtil.MILLISECONDS_OF_ONE_SECOND);
                    textView8.setVisibility(8);
                    textView9.setVisibility(0);
                }
            });
            textView9.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.CouponAdapte.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    textView5.setMaxLines(2);
                    textView8.setVisibility(0);
                    textView9.setVisibility(8);
                }
            });
        }
    }

    private class CouponDyAdapte extends SSimpleRecyclerAdapter<CouponItem> {
        public CouponDyAdapte(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493017;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, final CouponItem couponItem) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297136);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131297100);
            final TextView textView3 = (TextView) sRecyclerViewHolder.get(2131296993);
            final TextView textView4 = (TextView) sRecyclerViewHolder.get(2131297004);
            final TextView textView5 = (TextView) sRecyclerViewHolder.get(2131296971);
            TextView textView6 = (TextView) sRecyclerViewHolder.get(2131297061);
            ImageView imageView = (ImageView) sRecyclerViewHolder.get(2131296606);
            textView.setText(couponItem.getName());
            textView2.setText(couponItem.getCoupon_money());
            textView3.setText(couponItem.getContent());
            textView6.setText("x" + couponItem.getNum());
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.CouponDyAdapte.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    textView3.setMaxLines(TimeUtil.MILLISECONDS_OF_ONE_SECOND);
                    textView4.setVisibility(8);
                    textView5.setVisibility(0);
                }
            });
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.CouponDyAdapte.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    textView3.setMaxLines(2);
                    textView4.setVisibility(0);
                    textView5.setVisibility(8);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.CouponDyAdapte.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if ("1".equals(CouponListTgFrag.this.type)) {
                        CouponListTgFrag.this.patrolVm.refundMeituanCoupon(couponItem.getPay_method_id());
                    } else {
                        CouponListTgFrag.this.patrolVm.refundCoupon(couponItem.getPay_method_id());
                    }
                }
            });
        }
    }

    private class PayTypeAdapter extends SSelectedRecyclerAdapter<GroupTypeItem> {
        public PayTypeAdapter(Activity activity) {
            super(activity);
        }

        public GroupTypeItem getChoiceItem() {
            for (T t : getList()) {
                if (t.isSelected()) {
                    return t;
                }
            }
            return null;
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493021;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, final int i, final GroupTypeItem groupTypeItem) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297054);
            textView.setBackground(!groupTypeItem.isSelected() ? BackgroundLibUtil.get333333Stroke(2131166007) : BackgroundLibUtil.getBlueW(2131166007));
            textView.setText(groupTypeItem.getName());
            textView.setTextColor(ContextCompat.getColor(MyApp.getContext(), groupTypeItem.isSelected() ? 2131099745 : 2131099824));
            sRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.PayTypeAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayTypeAdapter.this.selectItem(i);
                    if (!"meituan".equals(groupTypeItem.getType()) && !"douyin".equals(groupTypeItem.getType())) {
                        CouponListTgFrag.this.getDataList(groupTypeItem.getPlat_source_id());
                        CouponListTgFrag.this.mBinding.srvDy.setVisibility(8);
                        CouponListTgFrag.this.showDyMt(false);
                    } else {
                        CouponListTgFrag.this.showDyMt(true);
                        CouponListTgFrag.this.type = "meituan".equals(groupTypeItem.getType()) ? "1" : "2";
                        CouponListTgFrag.this.patrolVm.getCouponListDyMt(CouponListTgFrag.this.order_id, CouponListTgFrag.this.type);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDataList(String str) {
        this.patrolVm.getGroupCouponList(this.orderInfoReq.getTable_id(), this.orderInfoReq.getOrder_id(), this.orderInfoReq.getShop_supplier_id(), this.orderInfoReq.getUser_id(), str, new ArrayList(), new ArrayList());
    }

    private void init() throws NumberFormatException {
        this.orderInfoReq = (OrderInfoReq) getArguments().getParcelable(Constants.KEY_ITEM);
        this.order_id = getArguments().getString(Constants.KEY_CODE);
        ArrayList arrayList = new ArrayList();
        if (EmptyUtils.isNotEmpty(this.orderInfoReq.getSettle())) {
            arrayList.addAll(this.orderInfoReq.getSettle());
        }
        if (EmptyUtils.isNotEmpty(this.orderInfoReq.getCoupon())) {
            arrayList.addAll(this.orderInfoReq.getCoupon());
        }
        if (EmptyUtils.isNotEmpty(arrayList)) {
            for (int i = 0; i < arrayList.size(); i++) {
                double d = 0.0d;
                try {
                    d = Double.parseDouble(((CouponItem) arrayList.get(i)).getSettle_id());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if ((TextUtils.equals("11", ((CouponItem) arrayList.get(i)).getSettle_type()) || TextUtils.equals("12", ((CouponItem) arrayList.get(i)).getSettle_type())) && d >= 1.0E8d) {
                    this.choiceCoupon.add((CouponItem) arrayList.get(i));
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
        this.mBinding.srvPayStyle.setLayoutManager(new GridLayoutManager(requireActivity(), 3));
        PayTypeAdapter payTypeAdapter = new PayTypeAdapter(getActivity());
        this.adapterGroup = payTypeAdapter;
        payTypeAdapter.setMode(SSelectedRecyclerAdapter.SelectedMode.SINGLE_MUST_ONE_SELECTED);
        this.mBinding.srvPayStyle.addItemDecoration(new GridSpacesItemDecoration(20));
        this.mBinding.srvPayStyle.setAdapter(this.adapterGroup);
        this.mBinding.etDouyin.addTextChangedListener(new TextWatcher() { // from class: com.collectpoint.moudle.product.CouponListTgFrag.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String string = CouponListTgFrag.this.mBinding.etDouyin.getText().toString();
                if (EmptyUtils.isNotEmpty(string) && string.endsWith("\n")) {
                    EditText editText = CouponListTgFrag.this.mBinding.etDouyin;
                    String strSubstring = string.substring(0, string.length() - 1);
                    editText.setText(strSubstring);
                    if ("1".equals(CouponListTgFrag.this.type)) {
                        CouponListTgFrag.this.patrolVm.getMeiTuanCouponInfo(strSubstring, CouponListTgFrag.this.order_id);
                    } else {
                        CouponListTgFrag.this.patrolVm.getCouponInfo2(strSubstring, CouponListTgFrag.this.order_id);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
    }

    public static CouponListTgFrag newInstance(OrderInfoReq orderInfoReq, String str) {
        CouponListTgFrag couponListTgFrag = new CouponListTgFrag();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_CODE, str);
        bundle.putParcelable(Constants.KEY_ITEM, orderInfoReq);
        couponListTgFrag.setArguments(bundle);
        return couponListTgFrag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDyMt(boolean z) {
        if (z) {
            this.mBinding.etDouyin.requestFocus();
        }
        this.mBinding.etDouyin.setVisibility(z ? 0 : 8);
        this.mBinding.tvDyRed.setVisibility(z ? 0 : 8);
        this.mBinding.tvDytitle.setVisibility(z ? 0 : 8);
        this.mBinding.tvHeyan.setVisibility(z ? 0 : 8);
        this.mBinding.ivClose.setVisibility(z ? 0 : 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-CouponListTgFrag, reason: not valid java name */
    /* synthetic */ void m183lambda$onInit$0$comcollectpointmoudleproductCouponListTgFrag(Resource resource) {
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
                this.adapterGroup.setData(((BaseListRes) resource.data).getData());
                if (EmptyUtils.isNotEmpty(((BaseListRes) resource.data).getData())) {
                    if (!"meituan".equals(((GroupTypeItem) ((BaseListRes) resource.data).getData().get(0)).getType()) && !"douyin".equals(((GroupTypeItem) ((BaseListRes) resource.data).getData().get(0)).getType())) {
                        getDataList(((GroupTypeItem) ((BaseListRes) resource.data).getData().get(0)).getPlat_source_id());
                        this.mBinding.srvDy.setVisibility(8);
                        showDyMt(false);
                        break;
                    } else {
                        showDyMt(true);
                        String str = "meituan".equals(((GroupTypeItem) ((BaseListRes) resource.data).getData().get(0)).getType()) ? "1" : "2";
                        this.type = str;
                        this.patrolVm.getCouponListDyMt(this.order_id, str);
                        break;
                    }
                }
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
    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-CouponListTgFrag, reason: not valid java name */
    /* synthetic */ void m184lambda$onInit$1$comcollectpointmoudleproductCouponListTgFrag(Resource resource) {
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
                int i = 0;
                if (EmptyUtils.isNotEmpty(((BaseDataRes) resource.data).getData())) {
                    ArrayList arrayList = new ArrayList((Collection) ((BaseDataRes) resource.data).getData());
                    if (EmptyUtils.isNotEmpty(this.choiceCoupon)) {
                        for (int i2 = 0; i2 < this.choiceCoupon.size(); i2++) {
                            int i3 = 0;
                            while (i3 < arrayList.size()) {
                                if (TextUtils.equals(this.choiceCoupon.get(i2).getSettle_id(), ((CouponItem) arrayList.get(i3)).getSettle_id())) {
                                    ((CouponItem) arrayList.get(i3)).setMyNum(this.choiceCoupon.get(i2).getNum());
                                    try {
                                        i += Integer.parseInt(this.choiceCoupon.get(i2).getNum());
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                    }
                                    i3 = 10000;
                                }
                                i3++;
                            }
                        }
                    }
                    this.adapter.setData(arrayList);
                    break;
                } else {
                    this.adapter.clearData();
                    break;
                }
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                    break;
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-CouponListTgFrag, reason: not valid java name */
    /* synthetic */ void m185lambda$onInit$2$comcollectpointmoudleproductCouponListTgFrag(Resource resource) {
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
                DouyinCouponWindow douyinCouponWindow = this.cartWindow;
                if (douyinCouponWindow != null && douyinCouponWindow.isShowing()) {
                    this.cartWindow.dismiss();
                }
                this.mBinding.etDouyin.setText("");
                this.patrolVm.getCouponListDyMt(this.order_id, this.type);
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
    /* renamed from: lambda$onInit$3$com-collectpoint-moudle-product-CouponListTgFrag, reason: not valid java name */
    /* synthetic */ void m186lambda$onInit$3$comcollectpointmoudleproductCouponListTgFrag(Resource resource) {
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
                this.mBinding.srvDy.setVisibility(0);
                this.adapterDy.setData((List) ((BaseDataRes) resource.data).getData());
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
    /* renamed from: lambda$onInit$4$com-collectpoint-moudle-product-CouponListTgFrag, reason: not valid java name */
    /* synthetic */ void m187lambda$onInit$4$comcollectpointmoudleproductCouponListTgFrag(Resource resource) throws NumberFormatException {
        int i;
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
                Coupon2Res coupon2Res = (Coupon2Res) ((BaseDataRes) resource.data).getData();
                coupon2Res.setIn_order_id(this.order_id);
                try {
                    i = Integer.parseInt(coupon2Res.getNum());
                } catch (Exception e) {
                    i = 0;
                }
                if (i != 1) {
                    DouyinCouponWindow douyinCouponWindow = this.cartWindow;
                    if (douyinCouponWindow != null && douyinCouponWindow.isShowing()) {
                        this.cartWindow.dismiss();
                    }
                    DouyinCouponWindow douyinCouponWindow2 = new DouyinCouponWindow(getActivity(), this.type, coupon2Res, this);
                    this.cartWindow = douyinCouponWindow2;
                    douyinCouponWindow2.show(this.mBinding.srvDy);
                    break;
                } else if (!"1".equals(this.type)) {
                    this.patrolVm.verifyCoupon(coupon2Res);
                    break;
                } else {
                    this.patrolVm.verifyMeituanCoupon(coupon2Res);
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

    /* renamed from: lambda$onInit$5$com-collectpoint-moudle-product-CouponListTgFrag, reason: not valid java name */
    /* synthetic */ void m188lambda$onInit$5$comcollectpointmoudleproductCouponListTgFrag(Resource resource) {
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

    @Override // com.collectpoint.widget.popupwindow.DouyinCouponWindow.OnSiteClickListener
    public void onAttrSubmit(Coupon2Res coupon2Res) {
        if ("1".equals(this.type)) {
            this.patrolVm.verifyMeituanCoupon(coupon2Res);
        } else {
            this.patrolVm.verifyCoupon(coupon2Res);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296598:
                this.mBinding.etDouyin.setText("");
                break;
            case 2131297033:
                String string = this.mBinding.etDouyin.getText().toString();
                if (EmptyUtils.isNotEmpty(string) && string.endsWith("\n")) {
                    string = string.substring(0, string.length() - 1);
                }
                if (EmptyUtils.isNotEmpty(string)) {
                    if ("1".equals(this.type)) {
                        this.patrolVm.getMeiTuanCouponInfo(string, this.order_id);
                        break;
                    } else {
                        this.patrolVm.getCouponInfo2(string, this.order_id);
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
                this.patrolVm.addOrderCoupon(new AddOrderCouponReq(this.choiceCoupon, this.order_id, "12"));
                break;
            case 2131297136:
                if (this.mBinding.etDouyin.getVisibility() == 0) {
                    requireActivity().setResult(4, new Intent());
                }
                requireActivity().finish();
                break;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.scanBarCodeLib.deInitBarCode(getContext());
    }

    protected void onInit() {
        this.patrolVm.mGroupTypeList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListTgFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m183lambda$onInit$0$comcollectpointmoudleproductCouponListTgFrag((Resource) obj);
            }
        });
        this.patrolVm.mGroupCouponList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListTgFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m184lambda$onInit$1$comcollectpointmoudleproductCouponListTgFrag((Resource) obj);
            }
        });
        this.patrolVm.mVerifyCoupon.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListTgFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m185lambda$onInit$2$comcollectpointmoudleproductCouponListTgFrag((Resource) obj);
            }
        });
        this.patrolVm.mCouponListDyMt.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListTgFrag$$ExternalSyntheticLambda3
            public final void onChanged(Object obj) {
                this.f$0.m186lambda$onInit$3$comcollectpointmoudleproductCouponListTgFrag((Resource) obj);
            }
        });
        this.patrolVm.mCouponInfo2.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListTgFrag$$ExternalSyntheticLambda4
            public final void onChanged(Object obj) throws NumberFormatException {
                this.f$0.m187lambda$onInit$4$comcollectpointmoudleproductCouponListTgFrag((Resource) obj);
            }
        });
        this.patrolVm.mAddOrderCoupon.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.CouponListTgFrag$$ExternalSyntheticLambda5
            public final void onChanged(Object obj) {
                this.f$0.m188lambda$onInit$5$comcollectpointmoudleproductCouponListTgFrag((Resource) obj);
            }
        });
    }

    protected void onLazyLoadingData() {
    }

    public void onScanBack(String str) {
        if (EmptyUtils.isNotEmpty(str)) {
            if (str.endsWith("\n")) {
                EditText editText = this.mBinding.etDouyin;
                String strSubstring = str.substring(0, str.length() - 1);
                str = strSubstring;
                editText.setText(strSubstring);
            } else {
                this.mBinding.etDouyin.setText(str);
            }
            if ("1".equals(this.type)) {
                this.patrolVm.getMeiTuanCouponInfo(str, this.order_id);
            } else {
                this.patrolVm.getCouponInfo2(str, this.order_id);
            }
        }
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws NumberFormatException {
        FragCouponlistTgBinding fragCouponlistTgBinding = (FragCouponlistTgBinding) DataBindingUtil.inflate(layoutInflater, 2131492970, viewGroup, false);
        this.mBinding = fragCouponlistTgBinding;
        fragCouponlistTgBinding.setLifecycleOwner(this);
        this.patrolVm = ViewModelProviders.of(this, PatrolVmFactory.getInstance(MyApp.getInstance())).get(PatrolVm.class);
        this.scanBarCodeLib.initBarCode(getContext());
        init();
        this.patrolVm.getGroupTypeList();
        return this.mBinding.getRoot();
    }
}
