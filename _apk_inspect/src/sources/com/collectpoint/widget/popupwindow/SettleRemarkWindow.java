package com.collectpoint.widget.popupwindow;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.PopupSettleremarkBinding;
import com.collectpoint.utils.AlphaUtils;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.EmptyUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class SettleRemarkWindow extends PopupWindow implements View.OnClickListener {
    private Activity activity;
    private LayoutInflater layoutInflater;
    private PopupSettleremarkBinding mBinding;
    private View mContentView;
    private OnSiteClickListener mListener;
    private List<String> tagList = new ArrayList();

    public interface OnSiteClickListener {
        void onAttrSubmit(String str);
    }

    public SettleRemarkWindow(Activity activity, OnSiteClickListener onSiteClickListener) {
        this.activity = activity;
        this.mListener = onSiteClickListener;
        View viewInflate = View.inflate(activity, 2131493089, null);
        this.mContentView = viewInflate;
        this.mBinding = PopupSettleremarkBinding.bind(viewInflate);
        init();
        setPopupWindow();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.collectpoint.widget.popupwindow.SettleRemarkWindow$1] */
    private void init() {
        this.layoutInflater = LayoutInflater.from(this.activity);
        this.mBinding.imgClose.setOnClickListener(this);
        this.mBinding.tvConfirm.setOnClickListener(this);
        this.mBinding.tvConfirm.setBackground(BackgroundLibUtil.getBlueW(2131165785));
        this.mBinding.etRemark.setBackground(BackgroundLibUtil.getDrawable(2131165785, 2131099765));
        this.tagList = (List) new Gson().fromJson(CacheUtils.getInstance().getCacheDoubleUtils().getString(Constants.KEY_TAG_SETTLE_LIST), new TypeToken<ArrayList<String>>() { // from class: com.collectpoint.widget.popupwindow.SettleRemarkWindow.1
        }.getType());
        this.mBinding.tag.setAdapter(new TagAdapter<String>(this.tagList) { // from class: com.collectpoint.widget.popupwindow.SettleRemarkWindow.2
            public View getView(FlowLayout flowLayout, int i, String str) {
                LinearLayout linearLayout = (LinearLayout) SettleRemarkWindow.this.layoutInflater.inflate(2131493044, (ViewGroup) SettleRemarkWindow.this.mBinding.tag, false);
                TextView textView = (TextView) linearLayout.findViewById(2131296983);
                textView.setTextColor(SettleRemarkWindow.this.activity.getResources().getColor(2131099725));
                textView.setBackground(BackgroundLibUtil.getf0f0f0Stroke(2131165623));
                textView.setText(str);
                return linearLayout;
            }
        });
        this.mBinding.tag.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() { // from class: com.collectpoint.widget.popupwindow.SettleRemarkWindow.3
            public boolean onTagClick(View view, int i, FlowLayout flowLayout) {
                if (!EmptyUtils.isNotEmpty(SettleRemarkWindow.this.tagList) || SettleRemarkWindow.this.tagList.size() <= i) {
                    return false;
                }
                SettleRemarkWindow.this.mBinding.etRemark.setText((CharSequence) SettleRemarkWindow.this.tagList.get(i));
                return false;
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
        setInputMethodMode(1);
        setSoftInputMode(16);
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

    public String getRemark() {
        return this.mBinding.etRemark.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296568:
            case 2131296965:
                dismiss();
                break;
            case 2131296981:
                String string = this.mBinding.etRemark.getText().toString();
                if (!EmptyUtils.isEmpty(string)) {
                    OnSiteClickListener onSiteClickListener = this.mListener;
                    if (onSiteClickListener != null) {
                        onSiteClickListener.onAttrSubmit(getRemark());
                    }
                    if (EmptyUtils.isNotEmpty(string)) {
                        if (this.tagList == null) {
                            this.tagList = new ArrayList();
                        }
                        boolean z = false;
                        if (EmptyUtils.isNotEmpty(this.tagList)) {
                            Iterator<String> it = this.tagList.iterator();
                            while (it.hasNext()) {
                                if (TextUtils.equals(it.next(), string)) {
                                    z = true;
                                }
                            }
                        }
                        if (!z) {
                            this.tagList.add(string);
                        }
                        CacheUtils.getInstance().getCacheDoubleUtils().put(Constants.KEY_TAG_SETTLE_LIST, new Gson().toJson(this.tagList));
                    }
                    dismiss();
                    break;
                } else {
                    ToastUtils.showLong("请输入备注");
                    break;
                }
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
