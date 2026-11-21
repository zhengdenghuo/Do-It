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
import com.collectpoint.databinding.PopupPayDeBinding;
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
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class PayDeWindow extends PopupWindow implements View.OnClickListener {
    private Activity activity;
    private LayoutInflater layoutInflater;
    private PopupPayDeBinding mBinding;
    private View mContentView;
    private OnSiteClickListener mListener;
    private List<String> tagList = new ArrayList();

    public interface OnSiteClickListener {
        void onAttrSubmit(String str, String str2);
    }

    public PayDeWindow(Activity activity, String str, String str2, OnSiteClickListener onSiteClickListener) {
        this.activity = activity;
        this.mListener = onSiteClickListener;
        View viewInflate = View.inflate(activity, 2131493087, null);
        this.mContentView = viewInflate;
        this.mBinding = PopupPayDeBinding.bind(viewInflate);
        init();
        this.mBinding.tvTitle.setText(str);
        setData(str2);
        setPopupWindow();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.collectpoint.widget.popupwindow.PayDeWindow$1] */
    private void init() {
        this.layoutInflater = LayoutInflater.from(this.activity);
        this.mBinding.imgClose.setOnClickListener(this);
        this.mBinding.etContent.setBackground(BackgroundLibUtil.get333333Stroke(2131165785));
        this.mBinding.tvConfirm.setOnClickListener(this);
        this.mBinding.tvConfirm.setBackground(BackgroundLibUtil.getBlueW(2131165785));
        this.mBinding.etRemark.setBackground(BackgroundLibUtil.getDrawable(2131165785, 2131099765));
        this.tagList = (List) new Gson().fromJson(CacheUtils.getInstance().getCacheDoubleUtils().getString(Constants.KEY_TAG_LIST), new TypeToken<ArrayList<String>>() { // from class: com.collectpoint.widget.popupwindow.PayDeWindow.1
        }.getType());
        this.mBinding.tag.setAdapter(new TagAdapter<String>(this.tagList) { // from class: com.collectpoint.widget.popupwindow.PayDeWindow.2
            public View getView(FlowLayout flowLayout, int i, String str) {
                LinearLayout linearLayout = (LinearLayout) PayDeWindow.this.layoutInflater.inflate(2131493044, (ViewGroup) PayDeWindow.this.mBinding.tag, false);
                TextView textView = (TextView) linearLayout.findViewById(2131296983);
                textView.setTextColor(PayDeWindow.this.activity.getResources().getColor(2131099725));
                textView.setBackground(BackgroundLibUtil.get333333Stroke(2131165623));
                textView.setText(str);
                return linearLayout;
            }
        });
        this.mBinding.tag.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() { // from class: com.collectpoint.widget.popupwindow.PayDeWindow.3
            public boolean onTagClick(View view, int i, FlowLayout flowLayout) {
                if (!EmptyUtils.isNotEmpty(PayDeWindow.this.tagList) || PayDeWindow.this.tagList.size() <= i) {
                    return false;
                }
                PayDeWindow.this.mBinding.etRemark.setText((CharSequence) PayDeWindow.this.tagList.get(i));
                return false;
            }
        });
    }

    private void setData(String str) {
        this.mBinding.tvPrice.setText("¥" + str);
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
            inputMethodManager.hideSoftInputFromWindow(this.mBinding.tag.getWindowToken(), 0);
        }
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
                String string = this.mBinding.etRemark.getText().toString();
                if (!EmptyUtils.isEmpty(string)) {
                    OnSiteClickListener onSiteClickListener = this.mListener;
                    if (onSiteClickListener != null) {
                        onSiteClickListener.onAttrSubmit(getPrice(), string);
                    }
                    if (EmptyUtils.isNotEmpty(string)) {
                        if (this.tagList == null) {
                            this.tagList = new ArrayList();
                        }
                        if (EmptyUtils.isNotEmpty(this.tagList)) {
                            int i = 0;
                            while (i < this.tagList.size()) {
                                if (TextUtils.equals(this.tagList.get(i), string)) {
                                    this.tagList.remove(i);
                                    i = 2147483646;
                                }
                                i++;
                            }
                        }
                        this.tagList.add(string);
                        CacheUtils.getInstance().getCacheDoubleUtils().put(Constants.KEY_TAG_LIST, new Gson().toJson(this.tagList.subList(Math.max(0, r4.size() - 5), this.tagList.size())));
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
