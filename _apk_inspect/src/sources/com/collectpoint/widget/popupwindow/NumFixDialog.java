package com.collectpoint.widget.popupwindow;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.MyApp;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.BitmapMemoryCache;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class NumFixDialog extends Dialog implements View.OnClickListener {
    private ConstraintLayout cl_content;
    private EditText et_num;
    private String is_print;
    private int maxNum;
    private OnCancelClickListener onCancelClickListener;
    private OnFixClickListener onConfirmClickListener;
    private TextView rb_nocd;
    private TextView tv_cancel;
    private TextView tv_save;
    private Window window;

    public interface OnCancelClickListener {
        void onClick(View view);
    }

    public interface OnFixClickListener {
        void onSiteSubmit(String str, String str2);
    }

    public NumFixDialog(Activity activity) {
        this(activity, 2131886642);
    }

    public NumFixDialog(Activity activity, int i) {
        super(activity, i);
        this.is_print = BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO;
        this.window = null;
        setOwnerActivity(activity);
        init();
    }

    private void init() {
        setContentView(2131492941);
        initView();
    }

    private void initView() {
        windowDeploy(0, 0);
        this.cl_content = findViewById(2131296407);
        this.tv_cancel = (TextView) findViewById(2131296965);
        this.rb_nocd = (TextView) findViewById(2131296757);
        this.et_num = (EditText) findViewById(2131296500);
        this.tv_save = (TextView) findViewById(2131297106);
        this.cl_content.setBackground(BackgroundLibUtil.getWhiteAll12());
        this.tv_save.setBackground(BackgroundLibUtil.getBlue(2131165578));
        this.tv_cancel.setBackground(BackgroundLibUtil.get333333Stroke(2131165578));
        this.et_num.setBackground(BackgroundLibUtil.get333333Stroke(2131165560));
        this.rb_nocd.setOnClickListener(this);
        this.tv_cancel.setOnClickListener(this);
        this.tv_save.setOnClickListener(this);
        setCanceledOnTouchOutside(false);
        MyApp.getInstance();
        paddingLeftAndRight(MyApp.getContext().getResources().getDimensionPixelOffset(2131165968));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws NumberFormatException {
        if (view.getId() == 2131296965) {
            OnCancelClickListener onCancelClickListener = this.onCancelClickListener;
            if (onCancelClickListener != null) {
                onCancelClickListener.onClick(view);
            }
            dismiss();
            return;
        }
        if (view.getId() == 2131296757) {
            this.is_print = "1".equals(this.is_print) ? BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO : "1";
            this.rb_nocd.setCompoundDrawablesRelativeWithIntrinsicBounds(getContext().getResources().getDrawable("1".equals(this.is_print) ? 2131230990 : 2131231173), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        if (view.getId() == 2131297106) {
            int i = 0;
            try {
                i = Integer.parseInt(this.et_num.getText().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i < 1) {
                ToastUtils.showLong("退菜数量不能小于1");
                return;
            }
            try {
                if (i > this.maxNum) {
                    ToastUtils.showLong("退菜数量不能大于商品数量");
                    return;
                }
                OnFixClickListener onFixClickListener = this.onConfirmClickListener;
                if (onFixClickListener != null) {
                    onFixClickListener.onSiteSubmit(String.valueOf(i), this.is_print);
                }
                dismiss();
            } catch (Exception e2) {
                ToastUtils.showLong("请输入正确数字");
            }
        }
    }

    public NumFixDialog paddingLeftAndRight(int i) {
        View decorView = getWindow().getDecorView();
        decorView.setPadding(i, decorView.getPaddingTop(), i, decorView.getPaddingBottom());
        return this;
    }

    public void setNum(String str) {
        this.maxNum = Integer.parseInt(str);
        this.et_num.setHint("退菜数量不能超过" + this.maxNum);
    }

    public void setOnCancelClickListener(OnCancelClickListener onCancelClickListener) {
        this.onCancelClickListener = onCancelClickListener;
    }

    public void setOnConfirmClickListener(OnFixClickListener onFixClickListener) {
        this.onConfirmClickListener = onFixClickListener;
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            if (getOwnerActivity() == null || getOwnerActivity().isFinishing()) {
                return;
            }
            super.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void windowDeploy(int i, int i2) {
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        this.window = window;
        window.setWindowAnimations(2131886646);
        this.window.setBackgroundDrawableResource(2131100232);
        WindowManager.LayoutParams attributes = this.window.getAttributes();
        attributes.width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        attributes.x = i;
        attributes.y = i2;
        this.window.setAttributes(attributes);
    }
}
