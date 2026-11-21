package com.collectpoint.moudle.product;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.MyApp;
import com.collectpoint.bean.even.FinishActtEvent;
import com.collectpoint.bean.even.FlashListEvent;
import com.collectpoint.bean.item.TableAreaItem;
import com.collectpoint.bean.res.BaseListDataRes;
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragHomeBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.TimeUtil;
import com.collectpoint.widget.recycler.SRecyclerViewHolder;
import com.collectpoint.widget.recycler.SSelectedRecyclerAdapter;
import com.collectpoint.widget.recycler.SSimpleRecyclerAdapter;
import com.google.common.base.Preconditions;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.recyclerview.GridSpacesItemDecoration;
import com.liuwq.base.util.SystemUtil;
import com.liuwq.base.widget.CustomDialogFragCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class SwitchTableFrag extends BaseFragment implements View.OnClickListener {
    private HomeAdapter adapter;
    private AssetTypeAdapter assetTypeAdapter;
    private CustomDialogFragCompat dialog;
    private boolean isMerge;
    private FragHomeBinding mBinding;
    private String order_id;
    private PatrolVm patrolVm;
    private String tableName;
    private String table_id;

    private class AssetTypeAdapter extends SSelectedRecyclerAdapter<TableAreaItem> {
        public AssetTypeAdapter(Activity activity) {
            super(activity);
        }

        public String getArea_id() {
            if (!EmptyUtils.isNotEmpty(SwitchTableFrag.this.assetTypeAdapter.getList())) {
                return "";
            }
            for (T t : SwitchTableFrag.this.assetTypeAdapter.getList()) {
                if (t.isSelected()) {
                    return t.getArea_id();
                }
            }
            return "";
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493044;
        }

        public int getPos() {
            if (!EmptyUtils.isNotEmpty(SwitchTableFrag.this.assetTypeAdapter.getList())) {
                return 0;
            }
            for (int i = 0; i < SwitchTableFrag.this.assetTypeAdapter.getCount(); i++) {
                if (((TableAreaItem) SwitchTableFrag.this.assetTypeAdapter.getList().get(i)).isSelected()) {
                    return i;
                }
            }
            return 0;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, final int i, final TableAreaItem tableAreaItem) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131296983);
            textView.setText(tableAreaItem.getArea_name() + "(" + tableAreaItem.getTableNum() + ")");
            textView.setBackground(tableAreaItem.isSelected() ? BackgroundLibUtil.getBlueW(2131165623) : BackgroundLibUtil.get333333Stroke(2131165623));
            textView.setTextColor(ContextCompat.getColor(MyApp.getContext(), tableAreaItem.isSelected() ? 2131099738 : 2131099824));
            sRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.SwitchTableFrag.AssetTypeAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AssetTypeAdapter.this.selectItem(i);
                    if (SwitchTableFrag.this.isMerge) {
                        SwitchTableFrag.this.patrolVm.tableList(SwitchTableFrag.this.mBinding.edtSearch.getText().toString());
                    } else {
                        SwitchTableFrag.this.patrolVm.tableList(tableAreaItem.getArea_id(), "", "10", SwitchTableFrag.this.mBinding.edtSearch.getText().toString(), TimeUtil.MILLISECONDS_OF_ONE_SECOND, 1);
                    }
                }
            });
        }
    }

    private class HomeAdapter extends SSimpleRecyclerAdapter<TableAreaItem> implements Filterable {
        public HomeAdapter(Activity activity) {
            super(activity);
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            return null;
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493043;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, final TableAreaItem tableAreaItem) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297056);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131296983);
            TextView textView3 = (TextView) sRecyclerViewHolder.get(2131297061);
            TextView textView4 = (TextView) sRecyclerViewHolder.get(2131297132);
            View view = sRecyclerViewHolder.get(2131297167);
            View view2 = sRecyclerViewHolder.get(2131296407);
            view2.setBackground(BackgroundLibUtil.getBlue(2131165785));
            textView.setText(tableAreaItem.getArea_name() + tableAreaItem.getTable_no());
            textView2.setText(tableAreaItem.getTable_status_name());
            String table_status = tableAreaItem.getTable_status();
            if (TextUtils.equals("10", table_status)) {
                view.setVisibility(0);
                textView4.setText("");
                textView3.setText("");
                textView2.setText(tableAreaItem.getMax_num() + "人桌");
                view2.setBackground(BackgroundLibUtil.getGreen(2131166007));
            } else {
                view.setVisibility(8);
                if (TextUtils.equals("30", table_status) || TextUtils.equals("50", table_status) || TextUtils.equals("40", table_status)) {
                    textView4.setText("");
                    textView3.setText("");
                    view2.setBackground(BackgroundLibUtil.get999999(2131166007));
                } else {
                    textView4.setText(tableAreaItem.getUse_time());
                    textView3.setText(tableAreaItem.getMeal_num() + "/" + tableAreaItem.getMax_num());
                    if (TextUtils.equals("20", table_status)) {
                        view2.setBackground(BackgroundLibUtil.getDrawable(2131166007, 2131100170));
                    } else {
                        view2.setBackground(BackgroundLibUtil.getDrawable(2131166007, 2131099769));
                    }
                }
            }
            sRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.SwitchTableFrag.HomeAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    SwitchTableFrag.this.showConfirmDialog(true, "确定将" + SwitchTableFrag.this.tableName + (SwitchTableFrag.this.isMerge ? "当前的商品转到" : "当前的订单和状态转到") + tableAreaItem.getArea_name() + tableAreaItem.getTable_no() + "吗？", "确定", new DialogInterface.OnClickListener() { // from class: com.collectpoint.moudle.product.SwitchTableFrag.HomeAdapter.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            if (SwitchTableFrag.this.isMerge) {
                                SwitchTableFrag.this.patrolVm.mergeTable(tableAreaItem.getTable_id(), SwitchTableFrag.this.order_id);
                            } else {
                                SwitchTableFrag.this.patrolVm.changeTable(tableAreaItem.getTable_id(), SwitchTableFrag.this.order_id);
                            }
                        }
                    }, "取消", null);
                }
            });
        }
    }

    private void init() {
        this.table_id = getArguments().getString(Constants.KEY_CODE);
        this.order_id = getArguments().getString(Constants.KEY_ROLE_CODE);
        this.tableName = getArguments().getString("name");
        this.isMerge = getArguments().getBoolean(Constants.KEY_PAGE);
        this.mBinding.vLeft.setVisibility(0);
        this.mBinding.vLeft.setOnClickListener(this);
        this.mBinding.tvProject.setOnClickListener(this);
        this.mBinding.vBar.getLayoutParams().height = SystemUtil.getStatusBarHeight(getContext());
        String user_name = "";
        try {
            user_name = CacheUtils.getInstance().getUserBean().getUser_name();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mBinding.tvProject.setText(user_name);
        this.mBinding.srvSeat.setLayoutManager(new GridLayoutManager(requireActivity(), 3));
        this.adapter = new HomeAdapter(getActivity());
        this.mBinding.srvSeat.setAdapter(this.adapter);
        this.mBinding.srvSeat.addItemDecoration(new GridSpacesItemDecoration(10));
        AssetTypeAdapter assetTypeAdapter = new AssetTypeAdapter(getActivity());
        this.assetTypeAdapter = assetTypeAdapter;
        assetTypeAdapter.setMode(SSelectedRecyclerAdapter.SelectedMode.SINGLE_MUST_ONE_SELECTED);
        this.mBinding.srvView.setAdapter(this.assetTypeAdapter);
        this.mBinding.srvView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mBinding.srvView.addItemDecoration(new GridSpacesItemDecoration(10));
        this.mBinding.srvSeatNum.setVisibility(8);
        if (this.isMerge) {
            this.mBinding.srvView.setVisibility(8);
        }
        initDialog();
        this.mBinding.ivFlash.setOnClickListener(this);
        this.mBinding.edtSearch.addTextChangedListener(new TextWatcher() { // from class: com.collectpoint.moudle.product.SwitchTableFrag.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SwitchTableFrag.this.isMerge) {
                    SwitchTableFrag.this.patrolVm.tableList(editable.toString());
                } else {
                    SwitchTableFrag.this.patrolVm.tableList(SwitchTableFrag.this.assetTypeAdapter.getArea_id(), "", "10", editable.toString(), TimeUtil.MILLISECONDS_OF_ONE_SECOND, 1);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.mBinding.edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.collectpoint.moudle.product.SwitchTableFrag.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3 && i != 0) {
                    return false;
                }
                String strTrim = SwitchTableFrag.this.mBinding.edtSearch.getText().toString().trim();
                if (TextUtils.isEmpty(strTrim)) {
                    ToastUtils.showShort("请输入搜索内容!");
                    return false;
                }
                SwitchTableFrag.this.closeKeyboard();
                if (SwitchTableFrag.this.isMerge) {
                    SwitchTableFrag.this.patrolVm.tableList(strTrim);
                    return true;
                }
                SwitchTableFrag.this.patrolVm.tableList(SwitchTableFrag.this.assetTypeAdapter.getArea_id(), "", "10", strTrim, TimeUtil.MILLISECONDS_OF_ONE_SECOND, 1);
                return true;
            }
        });
    }

    private void initDialog() {
        CustomDialogFragCompat customDialogFragCompatFindFragmentByTag = requireFragmentManager().findFragmentByTag(Constants.TAG_LOADING_DIALOG);
        this.dialog = customDialogFragCompatFindFragmentByTag;
        if (customDialogFragCompatFindFragmentByTag == null) {
            this.dialog = CustomDialogFragCompat.newTransparentLoadingDialog((String) null);
        }
    }

    public static SwitchTableFrag newInstance(String str, String str2, String str3, boolean z) {
        Bundle bundle = new Bundle();
        SwitchTableFrag switchTableFrag = new SwitchTableFrag();
        bundle.putString(Constants.KEY_CODE, str);
        bundle.putString(Constants.KEY_ROLE_CODE, str2);
        bundle.putString("name", str3);
        bundle.putBoolean(Constants.KEY_PAGE, z);
        switchTableFrag.setArguments(bundle);
        return switchTableFrag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-SwitchTableFrag, reason: not valid java name */
    /* synthetic */ void m228lambda$onInit$0$comcollectpointmoudleproductSwitchTableFrag(Resource resource) {
        int pos;
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                if (!EmptyUtils.isNotEmpty(resource.data) || !EmptyUtils.isNotEmpty(((BaseListDataRes) resource.data).getList())) {
                    this.assetTypeAdapter.clearData();
                    break;
                } else {
                    try {
                        pos = this.assetTypeAdapter.getPos();
                    } catch (Exception e) {
                        e.printStackTrace();
                        pos = 0;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (EmptyUtils.isNotEmpty(((BaseListDataRes) resource.data).getList())) {
                        arrayList.addAll((Collection) ((BaseListDataRes) resource.data).getList());
                    }
                    this.assetTypeAdapter.setData(arrayList);
                    this.assetTypeAdapter.cleanAllSelected();
                    try {
                        ((TableAreaItem) arrayList.get(pos)).setSelected(true);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.assetTypeAdapter.notifyDataSetChanged();
                    if (!EmptyUtils.isNotEmpty(arrayList) || pos >= arrayList.size() || !EmptyUtils.isNotEmpty(((TableAreaItem) arrayList.get(pos)).getTypeList())) {
                        this.adapter.clearData();
                        break;
                    } else if (!this.isMerge) {
                        this.patrolVm.tableList(((TableAreaItem) arrayList.get(pos)).getArea_id(), "", "10", this.mBinding.edtSearch.getText().toString(), TimeUtil.MILLISECONDS_OF_ONE_SECOND, 1);
                        break;
                    } else {
                        this.patrolVm.tableList(this.mBinding.edtSearch.getText().toString());
                        break;
                    }
                }
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-SwitchTableFrag, reason: not valid java name */
    /* synthetic */ void m229lambda$onInit$1$comcollectpointmoudleproductSwitchTableFrag(Resource resource) {
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
                if (!EmptyUtils.isNotEmpty(resource.data)) {
                    this.adapter.clearData();
                    ToastUtils.showLong("暂无可转台的桌子");
                    break;
                } else {
                    this.adapter.setData((List) ((BaseListDataRes) resource.data).getList());
                    break;
                }
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                    break;
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-SwitchTableFrag, reason: not valid java name */
    /* synthetic */ void m230lambda$onInit$2$comcollectpointmoudleproductSwitchTableFrag(Resource resource) {
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
                ToastUtils.showLong(this.isMerge ? "转台成功" : "换台成功");
                getActivity().finish();
                postEvent(new FlashListEvent());
                postEvent(new FinishActtEvent(0));
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
            case 2131296609:
                if (!this.isMerge) {
                    this.patrolVm.tableList(this.assetTypeAdapter.getArea_id(), "", this.isMerge ? "" : "10", this.mBinding.edtSearch.getText().toString(), TimeUtil.MILLISECONDS_OF_ONE_SECOND, 1);
                    break;
                } else {
                    this.patrolVm.tableList(this.mBinding.edtSearch.getText().toString());
                    break;
                }
            case 2131297090:
            case 2131297181:
                getActivity().finish();
                break;
        }
    }

    protected void onInit() {
        this.patrolVm.mTableArea.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.SwitchTableFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m228lambda$onInit$0$comcollectpointmoudleproductSwitchTableFrag((Resource) obj);
            }
        });
        this.patrolVm.mTableList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.SwitchTableFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m229lambda$onInit$1$comcollectpointmoudleproductSwitchTableFrag((Resource) obj);
            }
        });
        this.patrolVm.mChangeTable.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.SwitchTableFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m230lambda$onInit$2$comcollectpointmoudleproductSwitchTableFrag((Resource) obj);
            }
        });
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragHomeBinding fragHomeBinding = (FragHomeBinding) DataBindingUtil.inflate(layoutInflater, 2131492973, viewGroup, false);
        this.mBinding = fragHomeBinding;
        fragHomeBinding.setLifecycleOwner(this);
        this.patrolVm = ViewModelProviders.of(getActivity(), PatrolVmFactory.getInstance(MyApp.getInstance())).get(PatrolVm.class);
        init();
        if (this.isMerge) {
            this.patrolVm.tableList("");
        } else {
            this.patrolVm.tableArea("10");
        }
        return this.mBinding.getRoot();
    }
}
