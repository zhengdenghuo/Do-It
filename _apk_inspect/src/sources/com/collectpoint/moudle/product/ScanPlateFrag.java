package com.collectpoint.moudle.product;

import android.app.Activity;
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
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragScanplateBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.SDHandlerManager;
import com.collectpoint.utils.TimeUtil;
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
                        for (byte[] bArr : this.epcList) {
                            this.rssiList.get(i).intValue();
                            i++;
                            if (bArr != null) {
                                String strBytes2HexString = Tools.Bytes2HexString(bArr, bArr.length);
                                ScanPlateFrag scanPlateFrag = ScanPlateFrag.this;
                                scanPlateFrag.addToList(scanPlateFrag.listEPC, strBytes2HexString);
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

    private class PlateAdapter extends SSimpleRecyclerAdapter<AddDeviceItem> {
        public PlateAdapter(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493042;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, int i, AddDeviceItem addDeviceItem) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131297081);
            TextView textView2 = (TextView) sRecyclerViewHolder.get(2131297070);
            TextView textView3 = (TextView) sRecyclerViewHolder.get(2131297061);
            TextView textView4 = (TextView) sRecyclerViewHolder.get(2131297075);
            textView.setText((i + 1) + "." + addDeviceItem.getProduct_name());
            textView2.setText("¥" + addDeviceItem.getProduct_price() + "/个");
            textView3.setText("x" + addDeviceItem.getProduct_num());
            textView4.setText("¥" + new BigDecimal(addDeviceItem.getProduct_price()).multiply(new BigDecimal(Double.toString(addDeviceItem.getProduct_num()))).doubleValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToList(final List<String> list, final String str) {
        getActivity().runOnUiThread(new Runnable() { // from class: com.collectpoint.moudle.product.ScanPlateFrag.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z = false;
                if (EmptyUtils.isNotEmpty(list)) {
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        }
                        if (str.equals(list.get(i))) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                }
                if (!z) {
                    list.add(str);
                }
                if (ScanPlateFrag.this.listMap == null) {
                    ScanPlateFrag.this.listMap = new ArrayList();
                } else {
                    ScanPlateFrag.this.listMap.clear();
                }
                double dDoubleValue = 0.0d;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (EmptyUtils.isNotEmpty(ScanPlateFrag.this.deviceCodeList)) {
                    for (int i2 = 0; i2 < ScanPlateFrag.this.deviceCodeList.size(); i2++) {
                        boolean z2 = false;
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            if (EmptyUtils.isNotEmpty(((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(i2)).getDevice_rule_no()) && EmptyUtils.isNotEmpty(list.get(i3)) && ((String) list.get(i3)).length() > 8 && TextUtils.equals(((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(i2)).getDevice_rule_no(), ((String) list.get(i3)).substring(4, 8))) {
                                dDoubleValue = new BigDecimal(((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(i2)).getProduct_price()).add(new BigDecimal(Double.toString(dDoubleValue))).doubleValue();
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add((String) list.get(i3));
                                z2 = true;
                                arrayList.add(new AddDeviceItem(((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(i2)).getProduct_id(), 1, ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(i2)).getProduct_sku_id(), ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(i2)).getProduct_price(), ScanPlateFrag.this.table_id, arrayList3, ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(i2)).getProduct_name(), ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(i2)).getIcon()));
                            }
                        }
                        if (!z2) {
                            arrayList.add(new AddDeviceItem(((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(i2)).getProduct_id(), 0, ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(i2)).getProduct_sku_id(), ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(i2)).getProduct_price(), ScanPlateFrag.this.table_id, null, ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(i2)).getProduct_name(), ((DeviceCodeItem) ScanPlateFrag.this.deviceCodeList.get(i2)).getIcon()));
                        }
                    }
                }
                if (EmptyUtils.isNotEmpty(arrayList)) {
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        boolean z3 = false;
                        int i5 = 0;
                        while (i5 < ScanPlateFrag.this.listMap.size()) {
                            boolean zEquals = TextUtils.equals(((AddDeviceItem) arrayList.get(i4)).getProduct_id(), ((AddDeviceItem) ScanPlateFrag.this.listMap.get(i5)).getProduct_id());
                            z3 = zEquals;
                            if (zEquals) {
                                ArrayList arrayList4 = new ArrayList();
                                if (EmptyUtils.isNotEmpty(((AddDeviceItem) ScanPlateFrag.this.listMap.get(i5)).getDevice_no())) {
                                    arrayList4.addAll(((AddDeviceItem) ScanPlateFrag.this.listMap.get(i5)).getDevice_no());
                                }
                                int product_num = ((AddDeviceItem) ScanPlateFrag.this.listMap.get(i5)).getProduct_num() + ((AddDeviceItem) arrayList.get(i4)).getProduct_num();
                                ((AddDeviceItem) ScanPlateFrag.this.listMap.get(i5)).setDevice_no(arrayList4);
                                ((AddDeviceItem) ScanPlateFrag.this.listMap.get(i5)).setProduct_num(product_num);
                                i5 = 2147483646;
                            }
                            i5++;
                        }
                        if (!z3) {
                            ScanPlateFrag.this.listMap.add((AddDeviceItem) arrayList.get(i4));
                        }
                    }
                }
                if (EmptyUtils.isNotEmpty(ScanPlateFrag.this.listMap)) {
                    for (int i6 = 0; i6 < ScanPlateFrag.this.listMap.size(); i6++) {
                        if (((AddDeviceItem) ScanPlateFrag.this.listMap.get(i6)).getProduct_num() > 0) {
                            arrayList2.add((AddDeviceItem) ScanPlateFrag.this.listMap.get(i6));
                        }
                    }
                }
                ScanPlateFrag.this.adapter.setData(arrayList2);
                ScanPlateFrag.this.mBinding.tvSum.setText("" + dDoubleValue);
            }
        });
    }

    private void init() throws InterruptedException {
        this.listEPC = new ArrayList<>();
        this.table_id = getArguments().getString(Constants.KEY_CODE);
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

    private void initReader() throws InterruptedException {
        this.readerDevice = UhfReaderDevice.getInstance();
        UhfReader.setPortPath(getActivity().getSharedPreferences("portPath", 0).getString("portPath", "/dev/ttyS1"));
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
        new InventoryThread().start();
        Util.initSoundPool(getContext());
        this.powerValue = getActivity().getSharedPreferences("power", 0).getInt("value", 2600);
        Util.play(1, 0);
    }

    public static ScanPlateFrag newInstance(String str, String str2) {
        ScanPlateFrag scanPlateFrag = new ScanPlateFrag();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_CODE, str);
        bundle.putString("name", str2);
        scanPlateFrag.setArguments(bundle);
        return scanPlateFrag;
    }

    private void setButtonClickable(TextView textView, boolean z) {
        textView.setClickable(z);
        if (z) {
            return;
        }
        textView.setTextColor(-16777216);
        textView.setBackground(BackgroundLibUtil.get999999(2131165735));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-product-ScanPlateFrag, reason: not valid java name */
    /* synthetic */ void m226lambda$onInit$0$comcollectpointmoudleproductScanPlateFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                if (this.deviceCodeList == null) {
                    this.deviceCodeList = new ArrayList();
                }
                if (EmptyUtils.isNotEmpty(((BaseListRes) resource.data).getData())) {
                    this.deviceCodeList.addAll(((BaseListRes) resource.data).getData());
                    ArrayList<AddDeviceItem> arrayList = this.listMap;
                    if (arrayList == null) {
                        this.listMap = new ArrayList<>();
                    } else {
                        arrayList.clear();
                    }
                    for (int i = 0; i < this.deviceCodeList.size(); i++) {
                        boolean z = false;
                        int i2 = 0;
                        while (i2 < this.listMap.size()) {
                            if (TextUtils.equals(this.deviceCodeList.get(i).getProduct_id(), this.listMap.get(i2).getProduct_id())) {
                                z = true;
                                i2 = 2147483646;
                            }
                            i2++;
                        }
                        if (!z) {
                            this.listMap.add(new AddDeviceItem(this.deviceCodeList.get(i).getProduct_id(), 0, this.deviceCodeList.get(i).getProduct_sku_id(), this.deviceCodeList.get(i).getProduct_price(), this.table_id, null, this.deviceCodeList.get(i).getProduct_name(), this.deviceCodeList.get(i).getIcon()));
                        }
                    }
                    break;
                }
                break;
            case 2:
                ToastUtils.showLong(resource.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-product-ScanPlateFrag, reason: not valid java name */
    /* synthetic */ void m227lambda$onInit$1$comcollectpointmoudleproductScanPlateFrag(Resource resource) {
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
                postEvent(new FlashListEvent());
                getActivity().finish();
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
            case 2131297107:
                if (System.currentTimeMillis() - this.lastClickTime > 1000) {
                    ArrayList arrayList = new ArrayList();
                    if (EmptyUtils.isNotEmpty(this.listMap)) {
                        for (int i = 0; i < this.listMap.size(); i++) {
                            if (this.listMap.get(i).getProduct_num() > 0) {
                                arrayList.add(this.listMap.get(i));
                            }
                        }
                    }
                    this.patrolVm.addDeviceOrder(arrayList);
                    this.lastClickTime = System.currentTimeMillis();
                    break;
                }
                break;
            case 2131297136:
                getActivity().finish();
                break;
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

    protected void onInit() {
        this.patrolVm.mDeviceCode.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ScanPlateFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m226lambda$onInit$0$comcollectpointmoudleproductScanPlateFrag((Resource) obj);
            }
        });
        this.patrolVm.mAddDeviceOrder.observe(this, new Observer() { // from class: com.collectpoint.moudle.product.ScanPlateFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m227lambda$onInit$1$comcollectpointmoudleproductScanPlateFrag((Resource) obj);
            }
        });
    }

    protected void onLazyLoadingData() {
        this.patrolVm.getDeviceCode(this.table_id);
        this.patrolVm.openScan(this.table_id);
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws InterruptedException {
        FragScanplateBinding fragScanplateBinding = (FragScanplateBinding) DataBindingUtil.inflate(layoutInflater, 2131492992, viewGroup, false);
        this.mBinding = fragScanplateBinding;
        fragScanplateBinding.setLifecycleOwner(this);
        this.patrolVm = ViewModelProviders.of(this, PatrolVmFactory.getInstance(MyApp.getInstance())).get(PatrolVm.class);
        init();
        setTimer(1);
        this.listEPC = new ArrayList<>();
        return this.mBinding.getRoot();
    }

    public void setTimer(int i) {
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
                            ScanPlateFrag.this.patrolVm.saveScanInfo(ScanPlateFrag.this.table_id, new Gson().toJson(ScanPlateFrag.this.listMap));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };
        this.countDownTask = timerTask2;
        this.timer.schedule(timerTask2, 0L, i * TimeUtil.MILLISECONDS_OF_ONE_SECOND);
    }

    public void stopTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer.purge();
            this.timer = null;
        }
    }
}
