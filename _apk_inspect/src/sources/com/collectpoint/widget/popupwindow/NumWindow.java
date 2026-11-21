package com.collectpoint.widget.popupwindow;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.MyApp;
import com.collectpoint.bean.item.NumItem;
import com.collectpoint.databinding.PopupNumBinding;
import com.collectpoint.utils.AlphaUtils;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.widget.recycler.SRecyclerViewHolder;
import com.collectpoint.widget.recycler.SSelectedRecyclerAdapter;
import java.util.ArrayList;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class NumWindow extends PopupWindow implements View.OnClickListener {
    private Activity activity;
    private OrderAdapte adapter;
    private boolean isClick = false;
    private PopupNumBinding mBinding;
    private View mContentView;
    private OnSiteClickListener mListener;
    private int meal_num;

    public interface OnSiteClickListener {
        void onAttrSubmit(String str);
    }

    private class OrderAdapte extends SSelectedRecyclerAdapter<NumItem> {
        public OrderAdapte(Activity activity) {
            super(activity);
        }

        @Override // com.collectpoint.widget.recycler.SSimpleRecyclerAdapter
        public int getLayoutId(ViewGroup viewGroup, int i) {
            return 2131493045;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int getSelectedPos() {
            if (getList() != null) {
                for (int i = 0; i < getCount(); i++) {
                    if (((NumItem) getItem(i)).isSelected()) {
                        return i;
                    }
                }
            }
            return -1;
        }

        @Override // com.collectpoint.widget.recycler.SRecyclerAdapter
        public void onBindData(SRecyclerViewHolder sRecyclerViewHolder, final int i, final NumItem numItem) {
            TextView textView = (TextView) sRecyclerViewHolder.get(2131296983);
            textView.setText(numItem.getData() + "人");
            textView.setBackground(numItem.isSelected() ? BackgroundLibUtil.getDrawable(2131166007, 2131100237, 2131099745, 2131165785) : BackgroundLibUtil.get333333Stroke(2131166007));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.widget.popupwindow.NumWindow.OrderAdapte.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OrderAdapte.this.selectItem(i);
                    if (numItem.isSelected()) {
                        NumWindow.this.mBinding.etContent.setBackground(BackgroundLibUtil.get333333Stroke(2131166007));
                    }
                }
            });
        }
    }

    public NumWindow(Activity activity, String str, OnSiteClickListener onSiteClickListener) {
        this.meal_num = 0;
        this.activity = activity;
        this.mListener = onSiteClickListener;
        View viewInflate = View.inflate(activity, 2131493085, null);
        this.mContentView = viewInflate;
        this.mBinding = PopupNumBinding.bind(viewInflate);
        int iIndexOf = str.indexOf("(");
        this.mBinding.tvNo.setText(str.substring(0, iIndexOf));
        if (str.length() > iIndexOf && iIndexOf + 1 < str.indexOf("/")) {
            try {
                this.meal_num = Integer.valueOf(str.substring(iIndexOf + 1, str.indexOf("/"))).intValue();
            } catch (Exception e) {
                this.meal_num = 0;
                e.printStackTrace();
            }
        }
        init();
        setPopupWindow();
    }

    private void init() {
        this.isClick = false;
        this.mBinding.srvContent.setLayoutManager(new GridLayoutManager(this.activity, 4));
        this.adapter = new OrderAdapte(this.activity);
        this.mBinding.srvContent.setAdapter(this.adapter);
        this.mBinding.srvContent.addGridSpacingItemDecoration(4, MyApp.getInstance().getResources().getDimensionPixelOffset(2131165567), false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NumItem("1"));
        arrayList.add(new NumItem("2"));
        arrayList.add(new NumItem("3"));
        arrayList.add(new NumItem("4"));
        arrayList.add(new NumItem("5"));
        arrayList.add(new NumItem("6"));
        arrayList.add(new NumItem("7"));
        arrayList.add(new NumItem("8"));
        arrayList.add(new NumItem("9"));
        arrayList.add(new NumItem("10"));
        int i = this.meal_num;
        if (i > 0 && i < 11) {
            ((NumItem) arrayList.get(i - 1)).setSelected(true);
        } else if (i > 0) {
            this.mBinding.etContent.setText(this.meal_num + "");
        }
        this.adapter.setData(arrayList);
        this.mBinding.etContent.setBackground(BackgroundLibUtil.get333333Stroke(2131166007));
        this.mBinding.tvOther.setBackground(BackgroundLibUtil.get333333Stroke(2131166007));
        this.mBinding.tvConfirm.setOnClickListener(this);
        this.mBinding.tvOther.setOnClickListener(this);
        this.mBinding.tvConfirm.setBackground(BackgroundLibUtil.getBlueW(2131166007));
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

    public String getPrice() {
        return this.mBinding.etContent.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIntValue;
        switch (view.getId()) {
            case 2131296981:
                int selectedPos = this.adapter.getSelectedPos();
                String string = selectedPos < 0 ? this.mBinding.etContent.getText().toString() : (selectedPos + 1) + "";
                try {
                    iIntValue = Integer.valueOf(string).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                    iIntValue = 0;
                }
                if ((iIntValue == 0 && !this.isClick) || iIntValue < 0) {
                    ToastUtils.showLong("请选择就餐人数");
                    break;
                } else {
                    OnSiteClickListener onSiteClickListener = this.mListener;
                    if (onSiteClickListener != null) {
                        onSiteClickListener.onAttrSubmit(string);
                    }
                    dismiss();
                    break;
                }
                break;
            case 2131297067:
                this.isClick = true;
                this.mBinding.etContent.setBackground(BackgroundLibUtil.getDrawable(2131166007, 2131100237, 2131099745, 2131165785));
                this.adapter.cleanAllSelected();
                this.mBinding.tvInputNum.setVisibility(0);
                this.mBinding.etContent.setVisibility(0);
                view.setVisibility(8);
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
