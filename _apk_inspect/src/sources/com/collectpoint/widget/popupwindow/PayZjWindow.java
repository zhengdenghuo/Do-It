package com.collectpoint.widget.popupwindow;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.bean.item.HallCartItem;
import com.collectpoint.databinding.PopupPayXjBinding;
import com.collectpoint.utils.AlphaUtils;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.BitmapMemoryCache;
import com.collectpoint.utils.EmptyUtils;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class PayZjWindow extends PopupWindow implements View.OnClickListener {
    private Activity activity;
    private HallCartItem datas;
    private PopupPayXjBinding mBinding;
    private View mContentView;
    private OnSiteClickListener mListener;
    private String payprice = BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO;

    public interface OnSiteClickListener {
        void onAttrSubmit(String str);
    }

    public PayZjWindow(Activity activity, String str, String str2, OnSiteClickListener onSiteClickListener) {
        this.activity = activity;
        this.mListener = onSiteClickListener;
        View viewInflate = View.inflate(activity, 2131493088, null);
        this.mContentView = viewInflate;
        this.mBinding = PopupPayXjBinding.bind(viewInflate);
        init();
        this.mBinding.tvTitle.setText(str);
        setData(str2);
        setPopupWindow();
    }

    private void hideSoft() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    private void init() {
        this.mBinding.imgClose.setOnClickListener(this);
        this.mBinding.etContent.setBackground(BackgroundLibUtil.get333333Stroke(2131165785));
        this.mBinding.tvConfirm.setOnClickListener(this);
        this.mBinding.tvCancel.setOnClickListener(this);
        this.mBinding.tvConfirm.setBackground(BackgroundLibUtil.getBlueW(2131165785));
        this.mBinding.tvCancel.setBackground(BackgroundLibUtil.getBlueW(2131165785));
    }

    private void setData(String str) {
        TextView textView = this.mBinding.tvPrice;
        StringBuilder sbAppend = new StringBuilder().append("¥");
        this.payprice = str;
        textView.setText(sbAppend.append(str).toString());
        this.mBinding.etContent.setText(str);
    }

    private void setPopupWindow() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = (displayMetrics.widthPixels * 6) / 7;
        setHeight(-2);
        setWidth(i);
        setContentView(this.mContentView);
        setOutsideTouchable(false);
        setFocusable(true);
        setInputMethodMode(1);
        setSoftInputMode(16);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        AlphaUtils.backgroundAlpha(this.activity, 1.0f);
        hideSoft();
    }

    public String getPrice() {
        return this.mBinding.etContent.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296568:
            case 2131296965:
                dismiss();
                break;
            case 2131296981:
                hideSoft();
                if (!EmptyUtils.isNotEmpty(this.mBinding.tvTitle.getText().toString()) || !this.mBinding.tvTitle.getText().toString().contains("现金")) {
                    double dDoubleValue = 0.0d;
                    try {
                        dDoubleValue = Double.valueOf(getPrice()).doubleValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (dDoubleValue > 0.0d) {
                        double dDoubleValue2 = 0.0d;
                        try {
                            dDoubleValue2 = Double.valueOf(this.payprice).doubleValue();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (dDoubleValue <= dDoubleValue2) {
                            OnSiteClickListener onSiteClickListener = this.mListener;
                            if (onSiteClickListener != null) {
                                onSiteClickListener.onAttrSubmit(getPrice());
                            }
                            dismiss();
                            break;
                        } else {
                            ToastUtils.showLong("金额不能超过" + this.payprice);
                            break;
                        }
                    } else {
                        ToastUtils.showLong("请输入大于0金额");
                        break;
                    }
                } else {
                    OnSiteClickListener onSiteClickListener2 = this.mListener;
                    if (onSiteClickListener2 != null) {
                        onSiteClickListener2.onAttrSubmit(getPrice());
                    }
                    dismiss();
                    break;
                }
                break;
        }
    }

    public void show(View view) {
        if (isShowing()) {
            return;
        }
        AlphaUtils.backgroundAlpha(this.activity, 0.5f);
        showAtLocation(view, 17, 0, 0);
    }
}
