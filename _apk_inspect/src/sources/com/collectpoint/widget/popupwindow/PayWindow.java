package com.collectpoint.widget.popupwindow;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.BuildConfig;
import com.collectpoint.bean.item.HallCartItem;
import com.collectpoint.databinding.PopupPayBinding;
import com.collectpoint.utils.AlphaUtils;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.BitmapMemoryCache;
import com.collectpoint.utils.EmptyUtils;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class PayWindow extends PopupWindow implements View.OnClickListener {
    private Activity activity;
    private HallCartItem datas;
    private PopupPayBinding mBinding;
    private View mContentView;
    private OnSiteClickListener mListener;
    private String payprice = BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO;

    public interface OnSiteClickListener {
        void onAttrSubmit(String str, String str2);
    }

    public PayWindow(Activity activity, String str, OnSiteClickListener onSiteClickListener) {
        this.activity = activity;
        this.mListener = onSiteClickListener;
        View viewInflate = View.inflate(activity, 2131493086, null);
        this.mContentView = viewInflate;
        this.mBinding = PopupPayBinding.bind(viewInflate);
        init();
        setData(str);
        setPopupWindow();
    }

    private void init() {
        this.mBinding.imgClose.setOnClickListener(this);
        if (BuildConfig.DEBUG) {
            this.mBinding.tvStatue.setOnClickListener(this);
        }
        this.mBinding.tvPayNum.setBackground(BackgroundLibUtil.get333333Stroke(2131165785));
        this.mBinding.etContent.setBackground(BackgroundLibUtil.get333333Stroke(2131165785));
        this.mBinding.tvPayNum.addTextChangedListener(new TextWatcher() { // from class: com.collectpoint.widget.popupwindow.PayWindow.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String string = PayWindow.this.mBinding.tvPayNum.getText().toString();
                if (EmptyUtils.isNotEmpty(string) && string.length() >= 19 && string.endsWith("\n")) {
                    EditText editText = PayWindow.this.mBinding.tvPayNum;
                    String strSubstring = string.substring(0, string.length() - 1);
                    editText.setText(strSubstring);
                    if (PayWindow.this.mListener != null) {
                        double dDoubleValue = 0.0d;
                        try {
                            dDoubleValue = Double.valueOf(PayWindow.this.getPrice()).doubleValue();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (dDoubleValue <= 0.0d) {
                            ToastUtils.showLong("请输入大于0金额");
                            return;
                        }
                        double dDoubleValue2 = 0.0d;
                        try {
                            dDoubleValue2 = Double.valueOf(PayWindow.this.payprice).doubleValue();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (dDoubleValue > dDoubleValue2) {
                            ToastUtils.showLong("金额不能超过" + PayWindow.this.payprice);
                            return;
                        }
                        PayWindow.this.mListener.onAttrSubmit(PayWindow.this.getPrice(), strSubstring);
                        PayWindow.this.mBinding.etContent.setEnabled(false);
                        PayWindow.this.mBinding.tvPayNum.setText("");
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    private void setData(String str) {
        this.mBinding.tvPrice.setText("¥" + str);
        EditText editText = this.mBinding.etContent;
        this.payprice = str;
        editText.setText(str);
        this.mBinding.etContent.setEnabled(true);
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
    }

    public String getAuth_code() {
        String string = this.mBinding.tvPayNum.getText().toString();
        return (EmptyUtils.isNotEmpty(string) && string.length() >= 19 && string.endsWith("\n")) ? string.substring(0, string.length() - 1) : string;
    }

    public String getPrice() {
        return this.mBinding.etContent.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296568:
                dismiss();
                break;
            case 2131297118:
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
                            onSiteClickListener.onAttrSubmit(getPrice(), getAuth_code());
                            this.mBinding.etContent.setEnabled(false);
                            break;
                        }
                    } else {
                        ToastUtils.showLong("金额不能超过" + this.payprice);
                        break;
                    }
                } else {
                    ToastUtils.showLong("请输入大于0金额");
                    break;
                }
                break;
        }
    }

    public void setBarcode(String str) {
        this.mBinding.tvPayNum.setText(str);
    }

    public void setStatue(String str) {
        this.mBinding.tvStatue.setText(str);
    }

    public void show(View view) {
        if (isShowing()) {
            return;
        }
        AlphaUtils.backgroundAlpha(this.activity, 0.5f);
        showAtLocation(view, 17, 0, 0);
        this.mBinding.etContent.post(new Runnable() { // from class: com.collectpoint.widget.popupwindow.PayWindow.2
            @Override // java.lang.Runnable
            public void run() {
                PayWindow.this.mBinding.tvPayNum.requestFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) PayWindow.this.activity.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(PayWindow.this.activity.getWindow().getDecorView().getWindowToken(), 0);
                }
            }
        });
    }
}
