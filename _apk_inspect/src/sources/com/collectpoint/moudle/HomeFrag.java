package com.collectpoint.moudle;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.allenliu.versionchecklib.callback.APKDownloadListener;
import com.allenliu.versionchecklib.v2.AllenVersionChecker;
import com.allenliu.versionchecklib.v2.builder.DownloadBuilder;
import com.allenliu.versionchecklib.v2.builder.NotificationBuilder;
import com.allenliu.versionchecklib.v2.builder.UIData;
import com.allenliu.versionchecklib.v2.callback.CustomVersionDialogListener;
import com.blankj.utilcode.util.ToastUtils;
import com.chenenyu.router.Router;
import com.collectpoint.BuildConfig;
import com.collectpoint.MyApp;
import com.collectpoint.bean.even.FlashListEvent;
import com.collectpoint.bean.item.TableAreaItem;
import com.collectpoint.bean.item.TableStatusItem;
import com.collectpoint.bean.req.TableStatusReq;
import com.collectpoint.bean.res.BaseDataRes;
import com.collectpoint.bean.res.BaseListDataRes;
import com.collectpoint.bean.res.IndexIndexRes;
import com.collectpoint.bean.res.VersionRes;
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragHomeBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.BitmapMemoryCache;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.dialog.ForceUpdateDialog;
import com.collectpoint.utils.dialog.UpdateDialog;
import com.collectpoint.widget.popupwindow.Confirm1Dialog;
import com.collectpoint.widget.recycler.SRecyclerViewHolder;
import com.collectpoint.widget.recycler.SSelectedRecyclerAdapter;
import com.collectpoint.widget.recycler.SSimpleRecyclerAdapter;
import com.google.common.base.Preconditions;
import com.liuwq.base.MyActivityManager;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.recyclerview.GridSpacesItemDecoration;
import com.liuwq.base.util.SystemUtil;
import com.liuwq.base.widget.CustomDialogFragCompat;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class HomeFrag extends BaseFragment implements View.OnClickListener, OnRefreshListener {
    private HomeAdapter adapter;
    private AssetTypeAdapter assetTypeAdapter;
    private CustomDialogFragCompat dialog;
    private ForceUpdateDialog forceUpdateDialog;
    private boolean isFlash;
    private FragHomeBinding mBinding;
    private float maxTextSize;
    private Confirm1Dialog myAlertInputDialog2;
    private String open_statue;
    private int page;
    private PatrolVm patrolVm;
    private TableStatusAdapter statusAdapter;

    private class AssetTypeAdapter extends SSelectedRecyclerAdapter<TableAreaItem> {
        public AssetTypeAdapter(Activity activity) {
            super(activity);
        }

        public String getArea_id() {
            if (!EmptyUtils.isNotEmpty(HomeFrag.this.assetTypeAdapter.getList())) {
                return "";
            }
            for (T t : HomeFrag.this.assetTypeAdapter.getList()) {
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
            if (!EmptyUtils.isNotEmpty(HomeFrag.this.assetTypeAdapter.getList())) {
                return 0;
            }
            for (int i = 0; i < HomeFrag.this.assetTypeAdapter.getCount(); i++) {
                if (((TableAreaItem) HomeFrag.this.assetTypeAdapter.getList().get(i)).isSelected()) {
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
            sRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.HomeFrag.AssetTypeAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AssetTypeAdapter.this.selectItem(i);
                    HomeFrag.this.page = 1;
                    HomeFrag.this.patrolVm.tableList(tableAreaItem.getArea_id(), "", HomeFrag.this.statusAdapter.getTableStatus(), HomeFrag.this.mBinding.edtSearch.getText().toString(), 30, HomeFrag.this.page);
                }
            });
        }
    }

    public class CreateUpdateDialog implements CustomVersionDialogListener {
        public CreateUpdateDialog() {
        }

        public Dialog getCustomVersionDialog(Context context, UIData uIData) {
            UpdateDialog updateDialog = new UpdateDialog((Activity) context);
            updateDialog.setData(uIData);
            return updateDialog;
        }
    }

    private class HomeAdapter extends SSimpleRecyclerAdapter<TableAreaItem> {
        public HomeAdapter(Activity activity) {
            super(activity);
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
            final String str = tableAreaItem.getArea_name() + tableAreaItem.getTable_no() + "(" + tableAreaItem.getMeal_num() + "/" + tableAreaItem.getMax_num() + ")";
            final String table_status = tableAreaItem.getTable_status();
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
            sRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.HomeFrag.HomeAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (TextUtils.equals("50", table_status) || TextUtils.equals("40", table_status)) {
                        return;
                    }
                    if (!TextUtils.equals("1", HomeFrag.this.open_statue)) {
                        ToastUtils.showLong("门店暂未开班，不可下单");
                        return;
                    }
                    if (!TextUtils.equals("10", table_status)) {
                        if (TextUtils.equals("70", table_status)) {
                            Router.build(Constants.PRODUCTLIST_ACT).with("name", str).with(Constants.KEY_CODE, tableAreaItem.getTable_id()).go(HomeAdapter.this.getActivity());
                            return;
                        } else {
                            Router.build(Constants.ORDERDETAIL_ACT).with(Constants.KEY_CODE, tableAreaItem.getTable_id()).with("name", str).go(HomeAdapter.this.getActivity());
                            return;
                        }
                    }
                    String str2 = "确定将<font color='#FF0000'>" + tableAreaItem.getArea_name() + tableAreaItem.getTable_no() + "</font>开台吗？";
                    if (HomeFrag.this.myAlertInputDialog2 == null) {
                        HomeFrag.this.myAlertInputDialog2 = new Confirm1Dialog(HomeFrag.this.requireActivity());
                    }
                    HomeFrag.this.myAlertInputDialog2.setData("提示", Html.fromHtml(str2), "");
                    HomeFrag.this.myAlertInputDialog2.setOnConfirmClickListener(new Confirm1Dialog.OnConfirmClickListener() { // from class: com.collectpoint.moudle.HomeFrag.HomeAdapter.1.1
                        @Override // com.collectpoint.widget.popupwindow.Confirm1Dialog.OnConfirmClickListener
                        public void onClick(View view4) {
                            HomeFrag.this.patrolVm.open(tableAreaItem.getTable_id());
                        }
                    });
                    HomeFrag.this.myAlertInputDialog2.show();
                }
            });
            sRecyclerViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.collectpoint.moudle.HomeFrag.HomeAdapter.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view3) {
                    if (!TextUtils.equals("1", HomeFrag.this.open_statue)) {
                        ToastUtils.showLong("门店暂未开班，不可操作");
                        return false;
                    }
                    if (TextUtils.equals("40", table_status) || TextUtils.equals("50", table_status) || TextUtils.equals("70", table_status)) {
                        String str2 = "确定将<font color='#FF0000'>" + tableAreaItem.getArea_name() + tableAreaItem.getTable_no() + "</font>关台吗？";
                        if (HomeFrag.this.myAlertInputDialog2 == null) {
                            HomeFrag.this.myAlertInputDialog2 = new Confirm1Dialog(HomeFrag.this.requireActivity());
                        }
                        HomeFrag.this.myAlertInputDialog2.setData("提示", Html.fromHtml(str2), "");
                        HomeFrag.this.myAlertInputDialog2.setOnConfirmClickListener(new Confirm1Dialog.OnConfirmClickListener() { // from class: com.collectpoint.moudle.HomeFrag.HomeAdapter.2.1
                            @Override // com.collectpoint.widget.popupwindow.Confirm1Dialog.OnConfirmClickListener
                            public void onClick(View view4) {
                                HomeFrag.this.patrolVm.hallCartCancel(tableAreaItem.getTable_id());
                            }
                        });
                        HomeFrag.this.myAlertInputDialog2.show();
                    }
                    return false;
                }
            });
        }
    }

    private class SeatNumAdapter extends SSelectedRecyclerAdapter<TableAreaItem> {
        public SeatNumAdapter(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493044;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, final int i, final TableAreaItem tableAreaItem) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131296983);
            textView.setText(tableAreaItem.getType_name());
            textView.setBackground(tableAreaItem.isSelected() ? BackgroundLibUtil.getBlueW(2131165623) : BackgroundLibUtil.get333333Stroke(2131165623));
            textView.setTextColor(ContextCompat.getColor(MyApp.getContext(), tableAreaItem.isSelected() ? 2131099738 : 2131099824));
            sRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.HomeFrag.SeatNumAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SeatNumAdapter.this.selectItem(i);
                    HomeFrag.this.page = 1;
                    HomeFrag.this.patrolVm.tableList(HomeFrag.this.assetTypeAdapter.getArea_id(), tableAreaItem.getType_id(), HomeFrag.this.statusAdapter.getTableStatus(), HomeFrag.this.mBinding.edtSearch.getText().toString(), 30, HomeFrag.this.page);
                }
            });
        }
    }

    private class TableStatusAdapter extends SSelectedRecyclerAdapter<TableStatusItem> {
        public TableStatusAdapter(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493027;
        }

        public String getTableStatus() {
            if (!EmptyUtils.isNotEmpty(HomeFrag.this.assetTypeAdapter.getList())) {
                return BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO;
            }
            for (T t : getList()) {
                if (t.isSelected()) {
                    return t.getStatus();
                }
            }
            return BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, final int i, TableStatusItem tableStatusItem) {
            View view = sRecyclerViewHolder.get(2131296612);
            View view2 = sRecyclerViewHolder.get(2131297182);
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297139);
            textView.setText(tableStatusItem.getDesc() + "(" + tableStatusItem.getNum() + ")");
            view2.setBackground(tableStatusItem.isSelected() ? BackgroundLibUtil.getBlue(2131165623) : BackgroundLibUtil.getWhiteAll8());
            textView.setTextColor(ContextCompat.getColor(MyApp.getContext(), tableStatusItem.isSelected() ? 2131099738 : 2131099824));
            if ("10".equals(tableStatusItem.getStatus())) {
                view.setBackgroundColor(HomeFrag.this.getResources().getColor(2131099734));
            } else if ("20".equals(tableStatusItem.getStatus())) {
                view.setBackgroundColor(HomeFrag.this.getResources().getColor(2131099769));
            } else if ("30".equals(tableStatusItem.getStatus())) {
                view.setBackgroundColor(HomeFrag.this.getResources().getColor(2131100170));
            } else {
                view.setBackgroundColor(-1);
            }
            sRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.HomeFrag.TableStatusAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    TableStatusAdapter.this.selectItem(i);
                    HomeFrag.this.patrolVm.tableArea(HomeFrag.this.statusAdapter.getTableStatus());
                }
            });
        }
    }

    private UIData crateUIData(String str, String str2) {
        UIData uIDataCreate = UIData.create();
        uIDataCreate.setTitle("");
        uIDataCreate.setDownloadUrl(str);
        uIDataCreate.setContent(str2);
        return uIDataCreate;
    }

    private NotificationBuilder createCustomNotification() {
        return NotificationBuilder.create().setRingtone(true).setIcon(2131231036).setContentTitle("正在下载中...");
    }

    private void init() {
        this.mBinding.vBar.getLayoutParams().height = SystemUtil.getStatusBarHeight(getContext());
        String user_name = "";
        try {
            user_name = CacheUtils.getInstance().getUserBean().getUser_name();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mBinding.srlCommon.setEnableLoadMore(false);
        this.mBinding.srlCommon.setOnRefreshListener(this);
        this.mBinding.tvProject.setText(user_name);
        this.maxTextSize = this.mBinding.tvN.getTextSize();
        TableStatusAdapter tableStatusAdapter = new TableStatusAdapter(getActivity());
        this.statusAdapter = tableStatusAdapter;
        tableStatusAdapter.setMode(SSelectedRecyclerAdapter.SelectedMode.SINGLE_MUST_ONE_SELECTED);
        this.mBinding.srvStatus.setLayoutManager(new GridLayoutManager(requireActivity(), 4));
        this.mBinding.srvStatus.setAdapter(this.statusAdapter);
        this.assetTypeAdapter = new AssetTypeAdapter(getActivity());
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(requireActivity(), 4);
        this.assetTypeAdapter.setMode(SSelectedRecyclerAdapter.SelectedMode.SINGLE_MUST_ONE_SELECTED);
        this.mBinding.srvView.setAdapter(this.assetTypeAdapter);
        this.mBinding.srvView.setLayoutManager(gridLayoutManager);
        this.mBinding.srvView.addItemDecoration(new GridSpacesItemDecoration(10));
        this.mBinding.srvSeat.setLayoutManager(new GridLayoutManager(requireActivity(), 3));
        this.adapter = new HomeAdapter(getActivity());
        this.mBinding.srvSeat.addItemDecoration(new GridSpacesItemDecoration(10));
        this.mBinding.srvSeat.setAdapter(this.adapter);
        initDialog();
        this.mBinding.ivFlash.setOnClickListener(this);
        this.mBinding.tvProject.setOnClickListener(this);
        this.mBinding.edtSearch.addTextChangedListener(new TextWatcher() { // from class: com.collectpoint.moudle.HomeFrag.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                HomeFrag.this.page = 1;
                HomeFrag.this.patrolVm.tableList(HomeFrag.this.assetTypeAdapter.getArea_id(), "", HomeFrag.this.statusAdapter.getTableStatus(), editable.toString(), 30, HomeFrag.this.page);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.mBinding.edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.collectpoint.moudle.HomeFrag.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3 && i != 0) {
                    return false;
                }
                String strTrim = HomeFrag.this.mBinding.edtSearch.getText().toString().trim();
                if (TextUtils.isEmpty(strTrim)) {
                    ToastUtils.showShort("请输入搜索内容!");
                    return false;
                }
                HomeFrag.this.closeKeyboard();
                HomeFrag.this.page = 1;
                HomeFrag.this.patrolVm.tableList(HomeFrag.this.assetTypeAdapter.getArea_id(), "", HomeFrag.this.statusAdapter.getTableStatus(), strTrim, 30, HomeFrag.this.page);
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

    public static HomeFrag newInstance() {
        Bundle bundle = new Bundle();
        HomeFrag homeFrag = new HomeFrag();
        homeFrag.setArguments(bundle);
        return homeFrag;
    }

    public int compareVersions(String str, String str2) {
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
        int i = 0;
        while (true) {
            if (i >= iMax) {
                return 0;
            }
            int i2 = i < strArrSplit.length ? Integer.parseInt(strArrSplit[i]) : 0;
            int i3 = i < strArrSplit2.length ? Integer.parseInt(strArrSplit2[i]) : 0;
            if (i2 > i3) {
                return 1;
            }
            if (i2 < i3) {
                return -1;
            }
            i++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-HomeFrag, reason: not valid java name */
    /* synthetic */ void m149lambda$onInit$0$comcollectpointmoudleHomeFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                ArrayList arrayList = new ArrayList();
                arrayList.add(((TableStatusReq) ((BaseDataRes) resource.data).getData()).getAll());
                arrayList.add(((TableStatusReq) ((BaseDataRes) resource.data).getData()).getEating());
                arrayList.add(((TableStatusReq) ((BaseDataRes) resource.data).getData()).getPaying());
                arrayList.add(((TableStatusReq) ((BaseDataRes) resource.data).getData()).getNoStart());
                String tableStatus = this.statusAdapter.getTableStatus();
                this.statusAdapter.setData(arrayList);
                this.statusAdapter.cleanAllSelected();
                boolean z = false;
                for (int i = 0; i < arrayList.size(); i++) {
                    if (TextUtils.equals(tableStatus, ((TableStatusItem) arrayList.get(i)).getStatus())) {
                        z = true;
                        ((TableStatusItem) arrayList.get(i)).setSelected(true);
                    }
                }
                if (!z) {
                    ((TableStatusItem) arrayList.get(0)).setSelected(true);
                }
                this.statusAdapter.notifyDataSetChanged();
                this.patrolVm.tableArea(this.statusAdapter.getTableStatus());
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-HomeFrag, reason: not valid java name */
    /* synthetic */ void m150lambda$onInit$1$comcollectpointmoudleHomeFrag(Resource resource) {
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
                    } else {
                        this.page = 1;
                        this.patrolVm.tableList(((TableAreaItem) arrayList.get(pos)).getArea_id(), "", this.statusAdapter.getTableStatus(), this.mBinding.edtSearch.getText().toString(), 30, this.page);
                        break;
                    }
                }
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-HomeFrag, reason: not valid java name */
    /* synthetic */ void m151lambda$onInit$2$comcollectpointmoudleHomeFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 0:
            default:
                return;
            case 1:
                if (this.mBinding.srlCommon.getState() == RefreshState.Refreshing || this.mBinding.srlCommon.getState() == RefreshState.None || this.mBinding.srlCommon.getState() == RefreshState.Loading) {
                    this.adapter.setData((List) ((BaseListDataRes) resource.data).getList(), this.page);
                }
                if (this.isFlash) {
                    this.isFlash = false;
                    ToastUtils.showLong("页面已刷新");
                    break;
                }
                break;
            case 2:
                break;
        }
        boolean z = resource.status == 1;
        if (this.mBinding.srlCommon.getState() == RefreshState.Refreshing) {
            this.mBinding.srlCommon.finishRefresh(z);
        } else if (this.mBinding.srlCommon.getState() == RefreshState.Loading) {
            this.mBinding.srlCommon.finishLoadMore(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$3$com-collectpoint-moudle-HomeFrag, reason: not valid java name */
    /* synthetic */ void m152lambda$onInit$3$comcollectpointmoudleHomeFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                this.open_statue = ((IndexIndexRes) resource.data).getDetail().getOpen_class_status();
                break;
        }
    }

    /* renamed from: lambda$onInit$4$com-collectpoint-moudle-HomeFrag, reason: not valid java name */
    /* synthetic */ void m153lambda$onInit$4$comcollectpointmoudleHomeFrag(Resource resource) {
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
                onEventMainThread(new FlashListEvent());
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
    /* renamed from: lambda$onInit$5$com-collectpoint-moudle-HomeFrag, reason: not valid java name */
    /* synthetic */ void m154lambda$onInit$5$comcollectpointmoudleHomeFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                if (1 == compareVersions(((VersionRes) ((BaseDataRes) resource.data).getData()).getVersion(), BuildConfig.VERSION_NAME)) {
                    DownloadBuilder apkDownloadListener = AllenVersionChecker.getInstance().downloadOnly(UIData.create().setDownloadUrl(((VersionRes) ((BaseDataRes) resource.data).getData()).getDownUrl()).setContent("").setTitle("")).setNewestVersionCode(16).setApkName(String.valueOf(((VersionRes) ((BaseDataRes) resource.data).getData()).getVersion())).setCustomVersionDialogListener(new CreateUpdateDialog()).setShowDownloadingDialog(true).setNotificationBuilder(createCustomNotification()).setApkDownloadListener(new APKDownloadListener() { // from class: com.collectpoint.moudle.HomeFrag.1
                        public void onDownloadFail() {
                        }

                        public void onDownloadSuccess(File file) {
                        }

                        public void onDownloading(int i) {
                            if (HomeFrag.this.forceUpdateDialog == null) {
                                HomeFrag.this.forceUpdateDialog = new ForceUpdateDialog(HomeFrag.this.requireActivity());
                                HomeFrag.this.forceUpdateDialog.setCancelable(false);
                                HomeFrag.this.forceUpdateDialog.show();
                            }
                        }
                    });
                    MyApp.getInstance();
                    apkDownloadListener.executeMission(MyApp.getContext());
                    break;
                }
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296609:
                this.isFlash = true;
                onEventMainThread(new FlashListEvent());
                break;
            case 2131297090:
                Confirm1Dialog confirm1Dialog = new Confirm1Dialog(requireActivity());
                confirm1Dialog.setData("提示", "确定退出" + this.mBinding.tvProject.getText().toString() + "账号的登录？", "");
                confirm1Dialog.setOnConfirmClickListener(new Confirm1Dialog.OnConfirmClickListener() { // from class: com.collectpoint.moudle.HomeFrag.4
                    @Override // com.collectpoint.widget.popupwindow.Confirm1Dialog.OnConfirmClickListener
                    public void onClick(View view2) {
                        Router.build(Constants.LOGIN).with(Constants.KEY_STATUS, true).go(HomeFrag.this.getContext());
                        HomeFrag.this.requireActivity().finish();
                        MyActivityManager.destroyAllActivity();
                    }
                });
                confirm1Dialog.show();
                break;
        }
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(FlashListEvent flashListEvent) {
        PatrolVm patrolVm = this.patrolVm;
        if (patrolVm == null) {
            return;
        }
        patrolVm.getTableStatusNum();
        this.patrolVm.indexIndex();
    }

    protected void onInit() {
        this.patrolVm.mTableStatusNum.observe(this, new Observer() { // from class: com.collectpoint.moudle.HomeFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m149lambda$onInit$0$comcollectpointmoudleHomeFrag((Resource) obj);
            }
        });
        this.patrolVm.mTableArea.observe(this, new Observer() { // from class: com.collectpoint.moudle.HomeFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m150lambda$onInit$1$comcollectpointmoudleHomeFrag((Resource) obj);
            }
        });
        this.patrolVm.mTableList.observe(this, new Observer() { // from class: com.collectpoint.moudle.HomeFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m151lambda$onInit$2$comcollectpointmoudleHomeFrag((Resource) obj);
            }
        });
        this.patrolVm.mIndexIndex.observe(this, new Observer() { // from class: com.collectpoint.moudle.HomeFrag$$ExternalSyntheticLambda3
            public final void onChanged(Object obj) {
                this.f$0.m152lambda$onInit$3$comcollectpointmoudleHomeFrag((Resource) obj);
            }
        });
        this.patrolVm.mOpen.observe(this, new Observer() { // from class: com.collectpoint.moudle.HomeFrag$$ExternalSyntheticLambda4
            public final void onChanged(Object obj) {
                this.f$0.m153lambda$onInit$4$comcollectpointmoudleHomeFrag((Resource) obj);
            }
        });
        this.patrolVm.mVensionInfo.observe(this, new Observer() { // from class: com.collectpoint.moudle.HomeFrag$$ExternalSyntheticLambda5
            public final void onChanged(Object obj) {
                this.f$0.m154lambda$onInit$5$comcollectpointmoudleHomeFrag((Resource) obj);
            }
        });
    }

    public void onRefresh(RefreshLayout refreshLayout) {
        this.page = 1;
        this.patrolVm.tableList(this.assetTypeAdapter.getArea_id(), "", this.statusAdapter.getTableStatus(), this.mBinding.edtSearch.getText().toString(), 30, this.page);
    }

    public void onResume() {
        super.onResume();
        onEventMainThread(new FlashListEvent());
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragHomeBinding fragHomeBinding = (FragHomeBinding) DataBindingUtil.inflate(layoutInflater, 2131492973, viewGroup, false);
        this.mBinding = fragHomeBinding;
        fragHomeBinding.setLifecycleOwner(this);
        this.patrolVm = ViewModelProviders.of(getActivity(), PatrolVmFactory.getInstance(MyApp.getInstance())).get(PatrolVm.class);
        init();
        this.patrolVm.getVensionInfo("cashier");
        return this.mBinding.getRoot();
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            onEventMainThread(new FlashListEvent());
        }
    }

    protected boolean subscribeEvents() {
        return true;
    }
}
