package com.collectpoint.widget.popupwindow;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.PopupWindow;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.databinding.PopupMapBinding;
import com.collectpoint.utils.AlphaUtils;
import com.collectpoint.utils.MapUtil;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class MapPopupWindow extends PopupWindow implements View.OnClickListener {
    private Activity activity;
    private String address;
    private double latitude;
    private double longitude;
    private PopupMapBinding mBinding;
    private View mContentView;

    public MapPopupWindow(Activity activity, double d, double d2, String str) {
        this.activity = activity;
        this.latitude = d;
        this.longitude = d2;
        this.address = str;
        View viewInflate = View.inflate(activity, 2131493084, null);
        this.mContentView = viewInflate;
        PopupMapBinding popupMapBindingBind = PopupMapBinding.bind(viewInflate);
        this.mBinding = popupMapBindingBind;
        popupMapBindingBind.tvGd.setOnClickListener(this);
        this.mBinding.tvBd.setOnClickListener(this);
        this.mBinding.tvTx.setOnClickListener(this);
        setPopupWindow();
    }

    private void setPopupWindow() {
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        setHeight(-2);
        setWidth(-1);
        setContentView(this.mContentView);
        setOutsideTouchable(true);
        setFocusable(false);
        setTouchable(true);
        setSoftInputMode(16);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        AlphaUtils.backgroundAlpha(this.activity, 1.0f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296962:
                if (!MapUtil.isBaiduMapInstalled()) {
                    ToastUtils.showLong("尚未安装百度地图");
                    break;
                } else {
                    MapUtil.openBaiDuNavi(this.activity, 0.0d, 0.0d, null, this.latitude, this.longitude, this.address);
                    break;
                }
            case 2131297018:
                if (!MapUtil.isGdMapInstalled()) {
                    ToastUtils.showLong("尚未安装高德地图");
                    break;
                } else {
                    MapUtil.openGaoDeNavi(this.activity, 0.0d, 0.0d, null, this.latitude, this.longitude, this.address);
                    break;
                }
            case 2131297138:
                if (!MapUtil.isTencentMapInstalled()) {
                    ToastUtils.showLong("尚未安装腾讯地图");
                    break;
                } else {
                    MapUtil.openTencentMap(this.activity, 0.0d, 0.0d, null, this.latitude, this.longitude, this.address);
                    break;
                }
        }
        dismiss();
    }

    public void show(View view) {
        if (isShowing()) {
            return;
        }
        AlphaUtils.backgroundAlpha(this.activity, 0.5f);
        showAtLocation(view, 80, 0, 0);
    }
}
