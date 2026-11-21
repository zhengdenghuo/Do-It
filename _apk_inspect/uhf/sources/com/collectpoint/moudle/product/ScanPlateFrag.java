package com.collectpoint.moudle.product;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.MyApp;
import com.collectpoint.bean.even.FlashListEvent;
import com.collectpoint.bean.item.AddDeviceItem;
import com.collectpoint.bean.item.DeviceCodeItem;
import com.collectpoint.bean.res.BaseListRes;
import com.collectpoint.databinding.FragScanplateBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.SDHandlerManager;
import com.collectpoint.utils.UhfReaderDevice;
import com.collectpoint.utils.Util;
import com.collectpoint.widget.recycler.SRecyclerViewHolder;
import com.collectpoint.widget.recycler.SSimpleRecyclerAdapter;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.widget.CustomDialogFragCompat;
import com.magicrf.uhfreaderlib.reader.Tools;
import com.magicrf.uhfreaderlib.reader.UhfReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class ScanPlateFrag extends BaseFragment implements View.OnClickListener {
    private PlateAdapter adapter;
    private TimerTask countDownTask;
    private ArrayList<String> listEPC;
    private ArrayList<AddDeviceItem> listMap;
    private FragScanplateBinding mBinding;
    private String order_id;
    private PatrolVm patrolVm;
    private UhfReader reader;
    private UhfReaderDevice readerDevice;
    private String shop_supplier_id;
    private String tableName;
    private String table_id;
    private int powerValue = 2600;
    private boolean runFlag = true;
    private boolean startFlag = false;
    private List<DeviceCodeItem> deviceCodeList = new ArrayList();
    private long lastClickTime = 0;
    private String LOGTAG = "scan";
    private Timer timer = new Timer();

    public static ScanPlateFrag newInstance(String table_id, String table_name) {
        ScanPlateFrag fragment = new ScanPlateFrag();
        Bundle args = new Bundle();
        args.putString("code", table_id);
        args.putString("name", table_name);
        fragment.setArguments(args);
        return fragment;
    }

    protected View provideContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws InterruptedException {
        FragScanplateBinding fragScanplateBindingInflate = DataBindingUtil.inflate(inflater, 2131492992, container, false);
        this.mBinding = fragScanplateBindingInflate;
        fragScanplateBindingInflate.setLifecycleOwner(this);
        PatrolVmFactory vmFactory = PatrolVmFactory.getInstance(MyApp.getInstance());
        this.patrolVm = ViewModelProviders.of(this, vmFactory).get(PatrolVm.class);
        init();
        setTimer(1);
        this.listEPC = new ArrayList<>();
        return this.mBinding.getRoot();
    }

    protected void onLazyLoadingData() {
        this.patrolVm.getDeviceCode(this.table_id);
        this.patrolVm.openScan(this.table_id);
    }

    private void initReader() throws InterruptedException {
        this.readerDevice = UhfReaderDevice.getInstance();
        SharedPreferences sharedPortPath = getActivity().getSharedPreferences("portPath", 0);
        String serialPortPath = sharedPortPath.getString("portPath", "/dev/ttyS1");
        UhfReader.setPortPath(serialPortPath);
        UhfReader uhfReader = UhfReader.getInstance();
        this.reader = uhfReader;
        if (uhfReader == null) {
            this.mBinding.tvStatue.setText("serialport init fail");
            setButtonClickable(this.mBinding.tvScan, false);
            return;
        }
        if (this.readerDevice == null) {
            this.mBinding.tvStatue.setText("UHF reader power on failed");
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = new InventoryThread();
        thread.start();
        Util.initSoundPool(getContext());
        SharedPreferences shared = getActivity().getSharedPreferences("power", 0);
        this.powerValue = shared.getInt("value", 2600);
        Util.play(1, 0);
    }

    private void init() throws InterruptedException {
        this.listEPC = new ArrayList<>();
        this.table_id = getArguments().getString("code");
        this.tableName = getArguments().getString("name");
        this.mBinding.tvScan.setBackground(BackgroundLibUtil.getBlueW(2131165735));
        this.mBinding.tvTitle.setText(this.tableName);
        this.mBinding.tvTitle.setOnClickListener(this);
        this.mBinding.tvScan.setOnClickListener(this);
        this.mBinding.srvOrder.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.adapter = new PlateAdapter(getActivity());
        this.mBinding.srvOrder.setAdapter(this.adapter);
        initReader();
    }

    protected void onInit() {
        this.patrolVm.mDeviceCode.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ScanPlateFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m47lambda$onInit$0$comcollectpointmoudleproductScanPlateFrag((Resource) obj);
            }
        });
        this.patrolVm.mAddDeviceOrder.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ScanPlateFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m48lambda$onInit$1$comcollectpointmoudleproductScanPlateFrag((Resource) obj);
            }
        });
    }

    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-ScanPlateFrag, reason: not valid java name */
    /* synthetic */ void m47lambda$onInit$0$comcollectpointmoudleproductScanPlateFrag(Resource result) {
        Preconditions.checkNotNull(result);
        switch (result.status) {
            case OrderSettleFrag.REQUEST_CODE /* 1 */:
                if (this.deviceCodeList == null) {
                    this.deviceCodeList = new ArrayList();
                }
                if (EmptyUtils.isNotEmpty(((BaseListRes) result.data).getData())) {
                    this.deviceCodeList.addAll(((BaseListRes) result.data).getData());
                    ArrayList<AddDeviceItem> arrayList = this.listMap;
                    if (arrayList == null) {
                        this.listMap = new ArrayList<>();
                    } else {
                        arrayList.clear();
                    }
                    for (int i = 0; i < this.deviceCodeList.size(); i++) {
                        boolean hasSame = false;
                        int j = 0;
                        while (j < this.listMap.size()) {
                            if (TextUtils.equals(this.deviceCodeList.get(i).getProduct_id(), this.listMap.get(j).getProduct_id())) {
                                hasSame = true;
                                j = 2147483646;
                            }
                            j++;
                        }
                        if (!hasSame) {
                            this.listMap.add(new AddDeviceItem(this.deviceCodeList.get(i).getProduct_id(), 0, this.deviceCodeList.get(i).getProduct_sku_id(), this.deviceCodeList.get(i).getProduct_price(), this.table_id, (List) null, this.deviceCodeList.get(i).getProduct_name(), this.deviceCodeList.get(i).getIcon()));
                        }
                    }
                    break;
                }
                break;
            case OrderSettleFrag.REQUEST_OUT /* 2 */:
                ToastUtils.showLong(result.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-ScanPlateFrag, reason: not valid java name */
    /* synthetic */ void m48lambda$onInit$1$comcollectpointmoudleproductScanPlateFrag(Resource result) {
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
                postEvent(new FlashListEvent());
                getActivity().finish();
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
            case 2131297107:
                if (System.currentTimeMillis() - this.lastClickTime > 1000) {
                    ArrayList<AddDeviceItem> listMapTemp = new ArrayList<>();
                    if (EmptyUtils.isNotEmpty(this.listMap)) {
                        for (int i = 0; i < this.listMap.size(); i++) {
                            if (this.listMap.get(i).getProduct_num() > 0) {
                                listMapTemp.add(this.listMap.get(i));
                            }
                        }
                    }
                    this.patrolVm.addDeviceOrder(listMapTemp);
                    this.lastClickTime = System.currentTimeMillis();
                    break;
                }
                break;
            case 2131297136:
                getActivity().finish();
                break;
        }
    }

    public void setTimer(int timeS) {
        TimerTask timerTask = this.countDownTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.timer = new Timer();
        TimerTask timerTask2 = new TimerTask() { // from class: com.collectpoint.moudle.product.ScanPlateFrag.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SDHandlerManager.getMainHandler().post(new Runnable() { // from class: com.collectpoint.moudle.product.ScanPlateFrag.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String jsonS = new Gson().toJson(ScanPlateFrag.this.listMap);
                            ScanPlateFrag.this.patrolVm.saveScanInfo(ScanPlateFrag.this.table_id, jsonS);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };
        this.countDownTask = timerTask2;
        this.timer.schedule(timerTask2, 0L, timeS * 1000);
    }

    public void stopTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer.purge();
            this.timer = null;
        }
    }

    class InventoryThread extends Thread {
        private List<byte[]> epcList;
        private List<Integer> rssiList;

        InventoryThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            super.run();
            while (ScanPlateFrag.this.runFlag) {
                try {
                    if (ScanPlateFrag.this.reader != null) {
                        this.epcList = ScanPlateFrag.this.reader.inventoryRealTime();
                    }
                    Log.d(ScanPlateFrag.this.LOGTAG, "run: " + this.epcList.size());
                    if (ScanPlateFrag.this.reader != null) {
                        this.rssiList = ScanPlateFrag.this.reader.getRssiList();
                    }
                    if (EmptyUtils.isNotEmpty(this.epcList)) {
                        Util.play(1, 0);
                        int i = 0;
                        for (byte[] epc : this.epcList) {
                            this.rssiList.get(i).intValue();
                            i++;
                            if (epc != null) {
                                String epcStr = Tools.Bytes2HexString(epc, epc.length);
                                ScanPlateFrag scanPlateFrag = ScanPlateFrag.this;
                                scanPlateFrag.addToList(scanPlateFrag.listEPC, epcStr);
                            }
                        }
                    }
                    this.epcList = null;
                    try {
                        Thread.sleep(1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToList(final List<String> list, final String epc) {
        getActivity().runOnUiThread(new Runnable() { // from class: com.collectpoint.moudle.product.ScanPlateFrag.2
            @Override // java.lang.Runnable
            public void run() {
                boolean isHasSame = false;
                if (EmptyUtils.isNotEmpty(list)) {
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        }
                        if (!epc.equals(list.get(i))) {
                            i++;
                        } else {
                            isHasSame = true;
                            break;
                        }
                    }
                }
                if (!isHasSame) {
                    list.add(epc);
                }
                if (ScanPlateFrag.this.listMap != null) {
                    ScanPlateFrag.this.listMap.clear();
                } else {
                    ScanPlateFrag.this.listMap = new ArrayList();
                }
                double allPrice = 0.0d;
                ArrayList<AddDeviceItem> listMapTemp = new ArrayList<>();
                ArrayList<AddDeviceItem> listMapAdapter = new ArrayList<>();
                if (EmptyUtils.isNotEmpty(ScanPlateFrag.this.deviceCodeList)) {
                    for (int j = 0; j < ScanPlateFrag.this.deviceCodeList.size(); j++) {
                        boolean isadd = false;
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            if (EmptyUtils.isNotEmpty(((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(j)).getDevice_rule_no()) && EmptyUtils.isNotEmpty(list.get(i2)) && ((String) list.get(i2)).length() > 8 && TextUtils.equals(((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(j)).getDevice_rule_no(), ((String) list.get(i2)).substring(4, 8))) {
                                BigDecimal a = new BigDecimal(((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(j)).getProduct_price());
                                BigDecimal b = new BigDecimal(Double.toString(allPrice));
                                allPrice = a.add(b).doubleValue();
                                List<String> decices = new ArrayList<>();
                                decices.add((String) list.get(i2));
                                isadd = true;
                                listMapTemp.add(new AddDeviceItem(((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(j)).getProduct_id(), 1, ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(j)).getProduct_sku_id(), ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(j)).getProduct_price(), ScanPlateFrag.this.table_id, decices, ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(j)).getProduct_name(), ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(j)).getIcon()));
                            }
                        }
                        if (!isadd) {
                            listMapTemp.add(new AddDeviceItem(((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(j)).getProduct_id(), 0, ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(j)).getProduct_sku_id(), ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(j)).getProduct_price(), ScanPlateFrag.this.table_id, (List) null, ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(j)).getProduct_name(), ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(j)).getIcon()));
                        }
                    }
                }
                if (EmptyUtils.isNotEmpty(listMapTemp)) {
                    for (int i3 = 0; i3 < listMapTemp.size(); i3++) {
                        boolean hasSame = false;
                        int j2 = 0;
                        while (j2 < ScanPlateFrag.this.listMap.size()) {
                            boolean zEquals = TextUtils.equals(listMapTemp.get(i3).getProduct_id(), ((AddDeviceItem) ScanPlateFrag.this.listMap.get(j2)).getProduct_id());
                            hasSame = zEquals;
                            if (zEquals) {
                                List<String> decices2 = new ArrayList<>();
                                if (EmptyUtils.isNotEmpty(((AddDeviceItem) ScanPlateFrag.this.listMap.get(j2)).getDevice_no())) {
                                    decices2.addAll(((AddDeviceItem) ScanPlateFrag.this.listMap.get(j2)).getDevice_no());
                                }
                                int product_num = ((AddDeviceItem) ScanPlateFrag.this.listMap.get(j2)).getProduct_num() + listMapTemp.get(i3).getProduct_num();
                                ((AddDeviceItem) ScanPlateFrag.this.listMap.get(j2)).setDevice_no(decices2);
                                ((AddDeviceItem) ScanPlateFrag.this.listMap.get(j2)).setProduct_num(product_num);
                                j2 = 2147483646;
                            }
                            j2++;
                        }
                        if (!hasSame) {
                            ScanPlateFrag.this.listMap.add(listMapTemp.get(i3));
                        }
                    }
                }
                if (EmptyUtils.isNotEmpty(ScanPlateFrag.this.listMap)) {
                    for (int i4 = 0; i4 < ScanPlateFrag.this.listMap.size(); i4++) {
                        if (((AddDeviceItem) ScanPlateFrag.this.listMap.get(i4)).getProduct_num() > 0) {
                            listMapAdapter.add((AddDeviceItem) ScanPlateFrag.this.listMap.get(i4));
                        }
                    }
                }
                ScanPlateFrag.this.adapter.setData(listMapAdapter);
                ScanPlateFrag.this.mBinding.tvSum.setText("" + allPrice);
            }
        });
    }

    private void setButtonClickable(TextView button, boolean flag) {
        button.setClickable(flag);
        if (!flag) {
            button.setTextColor(-16777216);
            button.setBackground(BackgroundLibUtil.get999999(2131165735));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.runFlag = false;
        this.patrolVm.closeScan(this.table_id);
        UhfReader uhfReader = this.reader;
        if (uhfReader != null) {
            try {
                uhfReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        UhfReaderDevice uhfReaderDevice = this.readerDevice;
        if (uhfReaderDevice != null) {
            try {
                uhfReaderDevice.powerOff();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println("________release");
        stopTimer();
    }

    private class PlateAdapter extends SSimpleRecyclerAdapter<AddDeviceItem> {
        public PlateAdapter(Activity activity) {
            super(activity);
        }

        public void onBindData(SRecyclerViewHolder holder, int position, AddDeviceItem data) {
            TextView tv_produce_name = (TextView) holder.get(2131297081);
            TextView tv_per_price = (TextView) holder.get(2131297070);
            TextView tv_num = (TextView) holder.get(2131297061);
            TextView tv_price = (TextView) holder.get(2131297075);
            tv_produce_name.setText((position + 1) + "." + data.getProduct_name());
            tv_per_price.setText("¥" + data.getProduct_price() + "/个");
            tv_num.setText("x" + data.getProduct_num());
            BigDecimal a = new BigDecimal(data.getProduct_price());
            BigDecimal b = new BigDecimal(Double.toString(data.getProduct_num()));
            double d = a.multiply(b).doubleValue();
            tv_price.setText("¥" + d);
        }

        public int getLayoutId(ViewGroup parent, int viewType) {
            return 2131493042;
        }
    }
}
