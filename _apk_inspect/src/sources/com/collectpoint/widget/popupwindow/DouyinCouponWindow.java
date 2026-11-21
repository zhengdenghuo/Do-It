package com.collectpoint.widget.popupwindow;

import android.app.Activity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.bean.res.Coupon2Res;
import com.collectpoint.databinding.PopupDouyincouponBinding;
import com.collectpoint.utils.AlphaUtils;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.BitmapMemoryCache;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class DouyinCouponWindow extends PopupWindow implements View.OnClickListener {
    private Activity activity;
    private Coupon2Res datas;
    private PopupDouyincouponBinding mBinding;
    private View mContentView;
    private OnSiteClickListener mListener;
    private int maxbuy = 0;
    private String type;

    public interface OnSiteClickListener {
        void onAttrSubmit(Coupon2Res coupon2Res);
    }

    public DouyinCouponWindow(Activity activity, String str, Coupon2Res coupon2Res, OnSiteClickListener onSiteClickListener) {
        this.activity = activity;
        this.mListener = onSiteClickListener;
        this.datas = coupon2Res;
        this.type = str;
        View viewInflate = View.inflate(activity, 2131493082, null);
        this.mContentView = viewInflate;
        this.mBinding = PopupDouyincouponBinding.bind(viewInflate);
        init();
        setData();
        setPopupWindow();
    }

    private void init() {
        this.mBinding.tvTitle.setText("1".equals(this.type) ? "美团验券" : "抖音验券");
        this.mBinding.clContent.setBackground(BackgroundLibUtil.getWhiteStroke(2131165567));
        this.mBinding.clContent1.setBackground(BackgroundLibUtil.getWhiteStroke(2131165567));
        this.mBinding.tvConfirm.setOnClickListener(this);
        this.mBinding.tvCancel.setOnClickListener(this);
    }

    private void setData() {
        this.mBinding.clContent.setBackground(BackgroundLibUtil.getDrawable(2131165567, 2131100237, 2131099824, 2131165673));
        this.mBinding.clContent1.setBackground(BackgroundLibUtil.getWhiteStroke(2131165567));
        this.mBinding.tvCancel.setBackground(BackgroundLibUtil.get333333Stroke(2131165567));
        this.mBinding.tvConfirm.setBackground(BackgroundLibUtil.getBlueW(2131165567));
        this.mBinding.tvName.setText(this.datas.getTitle());
        this.mBinding.tvRule.setText(this.datas.getContent());
        this.mBinding.tvPrice.setText(this.datas.getCoupon_money());
        this.mBinding.tvRule.setMaxLines(2);
        this.mBinding.tvRule.setMovementMethod(new ScrollingMovementMethod());
        this.mBinding.tvHint.setText(Html.fromHtml("此券码中有 <font color='#FF0000'>" + this.datas.getNum() + "</font> 张未使用的券"));
        try {
            this.maxbuy = Integer.parseInt(this.datas.getNum());
        } catch (Exception e) {
            this.maxbuy = 0;
        }
        this.mBinding.ivSubUn.setVisibility(0);
        if (this.maxbuy > 0) {
            this.mBinding.etContent.setText("1");
            this.mBinding.ivAddUn.setVisibility(this.maxbuy != 1 ? 8 : 0);
        } else {
            this.mBinding.etContent.setText(BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
            this.mBinding.ivAddUn.setVisibility(0);
        }
        this.mBinding.ivAdd.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.widget.popupwindow.DouyinCouponWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws NumberFormatException {
                int i = 1;
                try {
                    i = Integer.parseInt(DouyinCouponWindow.this.mBinding.etContent.getText().toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                int i2 = i + 1;
                if (i2 >= DouyinCouponWindow.this.maxbuy) {
                    i2 = DouyinCouponWindow.this.maxbuy;
                    DouyinCouponWindow.this.mBinding.ivAddUn.setVisibility(0);
                } else {
                    DouyinCouponWindow.this.mBinding.ivAddUn.setVisibility(8);
                }
                DouyinCouponWindow.this.mBinding.ivSubUn.setVisibility(i2 > 1 ? 8 : 0);
                DouyinCouponWindow.this.mBinding.etContent.setText(String.valueOf(i2));
            }
        });
        this.mBinding.ivSub.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.widget.popupwindow.DouyinCouponWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws NumberFormatException {
                int i = 1;
                try {
                    i = Integer.parseInt(DouyinCouponWindow.this.mBinding.etContent.getText().toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                int i2 = i - 1;
                if (i2 <= 1) {
                    i2 = 1;
                    DouyinCouponWindow.this.mBinding.ivSubUn.setVisibility(0);
                } else {
                    DouyinCouponWindow.this.mBinding.ivSubUn.setVisibility(8);
                }
                DouyinCouponWindow.this.mBinding.ivAddUn.setVisibility(i2 < DouyinCouponWindow.this.maxbuy ? 8 : 0);
                DouyinCouponWindow.this.mBinding.etContent.setText(String.valueOf(i2));
            }
        });
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
        setTouchable(true);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        AlphaUtils.backgroundAlpha(this.activity, 1.0f);
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws NumberFormatException {
        switch (view.getId()) {
            case 2131296965:
                break;
            case 2131296981:
                int i = Integer.parseInt(this.mBinding.etContent.getText().toString());
                if (i >= 1) {
                    this.datas.setNum(i + "");
                    this.mListener.onAttrSubmit(this.datas);
                    break;
                } else {
                    ToastUtils.showLong("数量不能小于1");
                    return;
                }
            default:
                return;
        }
        dismiss();
    }

    public void show(View view) {
        if (isShowing()) {
            return;
        }
        AlphaUtils.backgroundAlpha(this.activity, 0.5f);
        showAtLocation(view, 17, 0, 0);
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }
}
