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
import androidx.constraintlayout.widget.ConstraintLayout;
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
import com.collectpoint.databinding.FragHomeBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.EmptyUtils;
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

    public static SwitchTableFrag newInstance(String table_id, String order_id, String tableName, boolean isMerge) {
        Bundle args = new Bundle();
        SwitchTableFrag fragment = new SwitchTableFrag();
        args.putString("code", table_id);
        args.putString("KEY_ROLE_CODE", order_id);
        args.putString("name", tableName);
        args.putBoolean("page", isMerge);
        fragment.setArguments(args);
        return fragment;
    }

    protected View provideContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragHomeBinding fragHomeBindingInflate = DataBindingUtil.inflate(inflater, 2131492973, container, false);
        this.mBinding = fragHomeBindingInflate;
        fragHomeBindingInflate.setLifecycleOwner(this);
        PatrolVmFactory vmFactory = PatrolVmFactory.getInstance(MyApp.getInstance());
        this.patrolVm = ViewModelProviders.of(getActivity(), vmFactory).get(PatrolVm.class);
        init();
        if (this.isMerge) {
            this.patrolVm.tableList("");
        } else {
            this.patrolVm.tableArea("10");
        }
        return this.mBinding.getRoot();
    }

    protected void onInit() {
        this.patrolVm.mTableArea.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.SwitchTableFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m49lambda$onInit$0$comcollectpointmoudleproductSwitchTableFrag((Resource) obj);
            }
        });
        this.patrolVm.mTableList.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.SwitchTableFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m50lambda$onInit$1$comcollectpointmoudleproductSwitchTableFrag((Resource) obj);
            }
        });
        this.patrolVm.mChangeTable.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.SwitchTableFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m51lambda$onInit$2$comcollectpointmoudleproductSwitchTableFrag((Resource) obj);
            }
        });
    }

    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-SwitchTableFrag, reason: not valid java name */
    /* synthetic */ void m49lambda$onInit$0$comcollectpointmoudleproductSwitchTableFrag(Resource result) {
        int pos;
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case OrderSettleFrag.REQUEST_CODE /* 1 */:
                if (EmptyUtils.isNotEmpty(result.data) && EmptyUtils.isNotEmpty(((BaseListDataRes) result.data).getList())) {
                    try {
                        pos = this.assetTypeAdapter.getPos();
                    } catch (Exception e) {
                        e.printStackTrace();
                        pos = 0;
                    }
                    List<TableAreaItem> areaItems = new ArrayList<>();
                    if (EmptyUtils.isNotEmpty(((BaseListDataRes) result.data).getList())) {
                        areaItems.addAll((Collection) ((BaseListDataRes) result.data).getList());
                    }
                    this.assetTypeAdapter.setData(areaItems);
                    this.assetTypeAdapter.cleanAllSelected();
                    try {
                        areaItems.get(pos).setSelected(true);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.assetTypeAdapter.notifyDataSetChanged();
                    if (EmptyUtils.isNotEmpty(areaItems) && pos < areaItems.size() && EmptyUtils.isNotEmpty(areaItems.get(pos).getTypeList())) {
                        if (this.isMerge) {
                            this.patrolVm.tableList(this.mBinding.edtSearch.getText().toString());
                            break;
                        } else {
                            this.patrolVm.tableList(areaItems.get(pos).getArea_id(), "", "10", this.mBinding.edtSearch.getText().toString(), 1000, 1);
                            break;
                        }
                    } else {
                        this.adapter.clearData();
                        break;
                    }
                } else {
                    this.assetTypeAdapter.clearData();
                    break;
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-SwitchTableFrag, reason: not valid java name */
    /* synthetic */ void m50lambda$onInit$1$comcollectpointmoudleproductSwitchTableFrag(Resource result) {
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
                if (EmptyUtils.isNotEmpty(result.data)) {
                    this.adapter.setData((List) ((BaseListDataRes) result.data).getList());
                    break;
                } else {
                    this.adapter.clearData();
                    ToastUtils.showLong("暂无可转台的桌子");
                    break;
                }
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                    break;
                }
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-product-SwitchTableFrag, reason: not valid java name */
    /* synthetic */ void m51lambda$onInit$2$comcollectpointmoudleproductSwitchTableFrag(Resource result) {
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
                ToastUtils.showLong(this.isMerge ? "转台成功" : "换台成功");
                getActivity().finish();
                postEvent(new FlashListEvent());
                postEvent(new FinishActtEvent(0));
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                if (dialog.isVisible()) {
                    dialog.dismiss();
                }
                ToastUtils.showLong(result.message);
                break;
        }
    }

    private void initDialog() {
        CustomDialogFragCompat customDialogFragCompatFindFragmentByTag = requireFragmentManager().findFragmentByTag("TAG_LOADING_DIALOG");
        this.dialog = customDialogFragCompatFindFragmentByTag;
        if (customDialogFragCompatFindFragmentByTag == null) {
            this.dialog = CustomDialogFragCompat.newTransparentLoadingDialog((String) null);
        }
    }

    private void init() {
        this.table_id = getArguments().getString("code");
        this.order_id = getArguments().getString("KEY_ROLE_CODE");
        this.tableName = getArguments().getString("name");
        this.isMerge = getArguments().getBoolean("page");
        this.mBinding.vLeft.setVisibility(0);
        this.mBinding.vLeft.setOnClickListener(this);
        this.mBinding.tvProject.setOnClickListener(this);
        ConstraintLayout.LayoutParams params = this.mBinding.vBar.getLayoutParams();
        params.height = SystemUtil.getStatusBarHeight(getContext());
        String nameProject = "";
        try {
            nameProject = CacheUtils.getInstance().getUserBean().getUser_name();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mBinding.tvProject.setText(nameProject);
        GridLayoutManager layoutManager = new GridLayoutManager(requireActivity(), 3);
        this.mBinding.srvSeat.setLayoutManager(layoutManager);
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
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (SwitchTableFrag.this.isMerge) {
                    SwitchTableFrag.this.patrolVm.tableList(s.toString());
                } else {
                    SwitchTableFrag.this.patrolVm.tableList(SwitchTableFrag.this.assetTypeAdapter.getArea_id(), "", "10", s.toString(), 1000, 1);
                }
            }
        });
        this.mBinding.edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.collectpoint.moudle.product.SwitchTableFrag.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == 3 || actionId == 0) {
                    String searchName = SwitchTableFrag.this.mBinding.edtSearch.getText().toString().trim();
                    if (!TextUtils.isEmpty(searchName)) {
                        SwitchTableFrag.this.closeKeyboard();
                        if (SwitchTableFrag.this.isMerge) {
                            SwitchTableFrag.this.patrolVm.tableList(searchName);
                            return true;
                        }
                        SwitchTableFrag.this.patrolVm.tableList(SwitchTableFrag.this.assetTypeAdapter.getArea_id(), "", "10", searchName, 1000, 1);
                        return true;
                    }
                    ToastUtils.showShort("请输入搜索内容!");
                    return false;
                }
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296609:
                if (this.isMerge) {
                    this.patrolVm.tableList(this.mBinding.edtSearch.getText().toString());
                    break;
                } else {
                    this.patrolVm.tableList(this.assetTypeAdapter.getArea_id(), "", this.isMerge ? "" : "10", this.mBinding.edtSearch.getText().toString(), 1000, 1);
                    break;
                }
            case 2131297090:
            case 2131297181:
                getActivity().finish();
                break;
        }
    }

    private class HomeAdapter extends SSimpleRecyclerAdapter<TableAreaItem> implements Filterable {
        public HomeAdapter(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, int position, final TableAreaItem data) {
            TextView tv_name = (TextView) holder.get(2131297056);
            TextView tv_content = (TextView) holder.get(2131296983);
            TextView tv_num = (TextView) holder.get(2131297061);
            TextView tv_time = (TextView) holder.get(2131297132);
            View v_add = holder.get(2131297167);
            View cl_content = holder.get(2131296407);
            cl_content.setBackground(BackgroundLibUtil.getBlue(2131165785));
            tv_name.setText(data.getArea_name() + data.getTable_no());
            tv_content.setText(data.getTable_status_name());
            String statue = data.getTable_status();
            if (TextUtils.equals("10", statue)) {
                v_add.setVisibility(0);
                tv_time.setText("");
                tv_num.setText("");
                tv_content.setText(data.getMax_num() + "人桌");
                cl_content.setBackground(BackgroundLibUtil.getGreen(2131166007));
            } else {
                v_add.setVisibility(8);
                if (TextUtils.equals("30", statue) || TextUtils.equals("50", statue) || TextUtils.equals("40", statue)) {
                    tv_time.setText("");
                    tv_num.setText("");
                    cl_content.setBackground(BackgroundLibUtil.get999999(2131166007));
                } else {
                    tv_time.setText(data.getUse_time());
                    tv_num.setText(data.getMeal_num() + "/" + data.getMax_num());
                    if (TextUtils.equals("20", statue)) {
                        cl_content.setBackground(BackgroundLibUtil.getDrawable(2131166007, 2131100170));
                    } else {
                        cl_content.setBackground(BackgroundLibUtil.getDrawable(2131166007, 2131099769));
                    }
                }
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.SwitchTableFrag.HomeAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SwitchTableFrag.this.showConfirmDialog(true, "确定将" + SwitchTableFrag.this.tableName + (SwitchTableFrag.this.isMerge ? "当前的商品转到" : "当前的订单和状态转到") + data.getArea_name() + data.getTable_no() + "吗？", "确定", new DialogInterface.OnClickListener() { // from class: com.collectpoint.moudle.product.SwitchTableFrag.HomeAdapter.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (SwitchTableFrag.this.isMerge) {
                                SwitchTableFrag.this.patrolVm.mergeTable(data.getTable_id(), SwitchTableFrag.this.order_id);
                            } else {
                                SwitchTableFrag.this.patrolVm.changeTable(data.getTable_id(), SwitchTableFrag.this.order_id);
                            }
                        }
                    }, "取消", null);
                }
            });
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493043;
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            return null;
        }
    }

    private class AssetTypeAdapter extends SSelectedRecyclerAdapter<TableAreaItem> {
        public AssetTypeAdapter(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, final int position, final TableAreaItem data) {
            TextView tv_content = (TextView) holder.get(2131296983);
            tv_content.setText(data.getArea_name() + "(" + data.getTableNum() + ")");
            tv_content.setBackground(data.isSelected() ? BackgroundLibUtil.getBlueW(2131165623) : BackgroundLibUtil.get333333Stroke(2131165623));
            tv_content.setTextColor(ContextCompat.getColor(MyApp.getContext(), data.isSelected() ? 2131099738 : 2131099824));
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.SwitchTableFrag.AssetTypeAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AssetTypeAdapter.this.selectItem(position);
                    if (SwitchTableFrag.this.isMerge) {
                        SwitchTableFrag.this.patrolVm.tableList(SwitchTableFrag.this.mBinding.edtSearch.getText().toString());
                    } else {
                        SwitchTableFrag.this.patrolVm.tableList(data.getArea_id(), "", "10", SwitchTableFrag.this.mBinding.edtSearch.getText().toString(), 1000, 1);
                    }
                }
            });
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493044;
        }

        public String getArea_id() {
            if (EmptyUtils.isNotEmpty(SwitchTableFrag.this.assetTypeAdapter.getList())) {
                for (TableAreaItem model : SwitchTableFrag.this.assetTypeAdapter.getList()) {
                    if (model.isSelected()) {
                        return model.getArea_id();
                    }
                }
                return "";
            }
            return "";
        }

        public int getPos() {
            if (EmptyUtils.isNotEmpty(SwitchTableFrag.this.assetTypeAdapter.getList())) {
                for (int i = 0; i < SwitchTableFrag.this.assetTypeAdapter.getCount(); i++) {
                    if (((TableAreaItem) SwitchTableFrag.this.assetTypeAdapter.getList().get(i)).isSelected()) {
                        return i;
                    }
                }
                return 0;
            }
            return 0;
        }
    }
}
