package com.collectpoint.widget.popupwindow;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.collectpoint.MyApp;
import com.collectpoint.utils.BackgroundLibUtil;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class Confirm1Dialog extends Dialog implements View.OnClickListener {
    private ConstraintLayout cl_content;
    private ImageView iv_close;
    private OnCancelClickListener onCancelClickListener;
    private OnConfirmClickListener onConfirmClickListener;
    private TextView tv_cancel;
    private TextView tv_first;
    private TextView tv_save;
    private TextView tv_second;
    private TextView tv_title;
    private Window window;

    public interface OnCancelClickListener {
        void onClick(View view);
    }

    public interface OnConfirmClickListener {
        void onClick(View view);
    }

    public Confirm1Dialog(Activity activity) {
        this(activity, 2131886642);
    }

    public Confirm1Dialog(Activity activity, int i) {
        super(activity, i);
        this.window = null;
        setOwnerActivity(activity);
        init();
    }

    private void init() {
        setContentView(2131492935);
        initView();
    }

    private void initView() {
        windowDeploy(0, 0);
        this.cl_content = findViewById(2131296407);
        this.tv_title = (TextView) findViewById(2131297136);
        this.iv_close = (ImageView) findViewById(2131296598);
        this.tv_first = (TextView) findViewById(2131297007);
        this.tv_second = (TextView) findViewById(2131297109);
        this.tv_cancel = (TextView) findViewById(2131296965);
        TextView textView = (TextView) findViewById(2131296981);
        this.tv_save = textView;
        textView.setOnClickListener(this);
        this.tv_cancel.setOnClickListener(this);
        this.cl_content.setBackground(BackgroundLibUtil.getWhiteAll12());
        this.tv_save.setBackground(BackgroundLibUtil.get333333Stroke(2131165785));
        this.tv_cancel.setBackground(BackgroundLibUtil.getBlueW(2131165785));
        this.iv_close.setOnClickListener(this);
        this.tv_save.setOnClickListener(this);
        this.tv_cancel.setOnClickListener(this);
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
    public void onClick(View view) {
        if (view.getId() == 2131296965) {
            OnCancelClickListener onCancelClickListener = this.onCancelClickListener;
            if (onCancelClickListener != null) {
                onCancelClickListener.onClick(view);
            }
            dismiss();
            return;
        }
        if (view.getId() == 2131296598) {
            dismiss();
        } else if (view.getId() == 2131296981) {
            OnConfirmClickListener onConfirmClickListener = this.onConfirmClickListener;
            if (onConfirmClickListener != null) {
                onConfirmClickListener.onClick(view);
            }
            dismiss();
        }
    }

    public Confirm1Dialog paddingLeftAndRight(int i) {
        View decorView = getWindow().getDecorView();
        decorView.setPadding(i, decorView.getPaddingTop(), i, decorView.getPaddingBottom());
        return this;
    }

    public void setButton(int i, int i2) {
        this.tv_save.setVisibility(i);
        this.tv_cancel.setVisibility(i2);
    }

    public void setData(String str, CharSequence charSequence, String str2) {
        this.tv_title.setText(str);
        this.tv_first.setText(charSequence);
        this.tv_second.setText(str2);
    }

    public void setData(String str, String str2) {
        this.tv_first.setText(str);
        this.tv_second.setText(str2);
    }

    public void setOnCancelClickListener(OnCancelClickListener onCancelClickListener) {
        this.onCancelClickListener = onCancelClickListener;
    }

    public void setOnConfirmClickListener(OnConfirmClickListener onConfirmClickListener) {
        this.onConfirmClickListener = onConfirmClickListener;
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
