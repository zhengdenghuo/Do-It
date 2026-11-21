package com.collectpoint.widget.popupwindow;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.collectpoint.utils.dialog.OptAnimationLoader;
import com.collectpoint.utils.dialog.ProgressHelper;
import com.collectpoint.utils.dialog.SuccessTickView;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class SweetAlertDialog extends Dialog implements View.OnClickListener {
    public static final int CUSTOM_IMAGE_TYPE = 4;
    public static final int ERROR_TYPE = 1;
    public static final int NORMAL_TYPE = 0;
    public static final int PROGRESS_TYPE = 5;
    public static final int SUCCESS_TYPE = 2;
    public static final int WARNING_TYPE = 3;
    DialogInterface.OnKeyListener keyListener;
    private int mAlertType;
    private Button mCancelButton;
    private OnSweetClickListener mCancelClickListener;
    private String mCancelText;
    private boolean mCloseFromCancel;
    private Button mConfirmButton;
    private OnSweetClickListener mConfirmClickListener;
    private String mConfirmText;
    private String mContentText;
    private TextView mContentTextView;
    private ImageView mCustomImage;
    private Drawable mCustomImgDrawable;
    private View mDialogView;
    private FrameLayout mErrorFrame;
    private Animation mErrorInAnim;
    private ImageView mErrorX;
    private AnimationSet mErrorXInAnim;
    private AnimationSet mModalInAnim;
    private AnimationSet mModalOutAnim;
    private Animation mOverlayOutAnim;
    private FrameLayout mProgressFrame;
    private ProgressHelper mProgressHelper;
    private boolean mShowCancel;
    private boolean mShowContent;
    private Animation mSuccessBowAnim;
    private FrameLayout mSuccessFrame;
    private AnimationSet mSuccessLayoutAnimSet;
    private View mSuccessLeftMask;
    private View mSuccessRightMask;
    private SuccessTickView mSuccessTick;
    private String mTitleText;
    private TextView mTitleTextView;
    private FrameLayout mWarningFrame;

    public interface OnSweetClickListener {
        void onClick(SweetAlertDialog sweetAlertDialog);
    }

    public SweetAlertDialog(Context context) {
        this(context, 0);
    }

    public SweetAlertDialog(Context context, int i) {
        super(context, 2131886642);
        DialogInterface.OnKeyListener onKeyListener = new DialogInterface.OnKeyListener() { // from class: com.collectpoint.widget.popupwindow.SweetAlertDialog.3
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                SweetAlertDialog.this.dismiss();
                return false;
            }
        };
        this.keyListener = onKeyListener;
        setOnKeyListener(onKeyListener);
        setCanceledOnTouchOutside(false);
        this.mProgressHelper = new ProgressHelper(context);
        this.mAlertType = i;
        this.mErrorInAnim = OptAnimationLoader.loadAnimation(getContext(), 2130772006);
        this.mErrorXInAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), 2130772007);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.mErrorXInAnim.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.mSuccessBowAnim = OptAnimationLoader.loadAnimation(getContext(), 2130772024);
        this.mSuccessLayoutAnimSet = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), 2130772025);
        this.mModalInAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), 2130772010);
        AnimationSet animationSet = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), 2130772011);
        this.mModalOutAnim = animationSet;
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.collectpoint.widget.popupwindow.SweetAlertDialog.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SweetAlertDialog.this.mDialogView.setVisibility(8);
                SweetAlertDialog.this.mDialogView.post(new Runnable() { // from class: com.collectpoint.widget.popupwindow.SweetAlertDialog.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SweetAlertDialog.this.mCloseFromCancel) {
                            SweetAlertDialog.super.cancel();
                        } else {
                            SweetAlertDialog.super.dismiss();
                        }
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        Animation animation = new Animation() { // from class: com.collectpoint.widget.popupwindow.SweetAlertDialog.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = SweetAlertDialog.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                SweetAlertDialog.this.getWindow().setAttributes(attributes);
            }
        };
        this.mOverlayOutAnim = animation;
        animation.setDuration(120L);
    }

    private void changeAlertType(int i, boolean z) {
        this.mAlertType = i;
        if (this.mDialogView != null) {
            if (!z) {
                restore();
            }
            switch (this.mAlertType) {
                case 1:
                    this.mErrorFrame.setVisibility(0);
                    break;
                case 2:
                    this.mSuccessFrame.setVisibility(0);
                    this.mSuccessLeftMask.startAnimation(this.mSuccessLayoutAnimSet.getAnimations().get(0));
                    this.mSuccessRightMask.startAnimation(this.mSuccessLayoutAnimSet.getAnimations().get(1));
                    break;
                case 3:
                    this.mConfirmButton.setBackgroundResource(2131231304);
                    this.mWarningFrame.setVisibility(0);
                    break;
                case 4:
                    setCustomImage(this.mCustomImgDrawable);
                    break;
                case 5:
                    this.mProgressFrame.setVisibility(0);
                    this.mConfirmButton.setVisibility(8);
                    break;
            }
            if (z) {
                return;
            }
            playAnimation();
        }
    }

    private void dismissWithAnimation(boolean z) {
        this.mCloseFromCancel = z;
        this.mConfirmButton.startAnimation(this.mOverlayOutAnim);
        this.mDialogView.startAnimation(this.mModalOutAnim);
    }

    private void playAnimation() {
        int i = this.mAlertType;
        if (i == 1) {
            this.mErrorFrame.startAnimation(this.mErrorInAnim);
            this.mErrorX.startAnimation(this.mErrorXInAnim);
        } else if (i == 2) {
            this.mSuccessTick.startTickAnim();
            this.mSuccessRightMask.startAnimation(this.mSuccessBowAnim);
        }
    }

    private void restore() {
        this.mCustomImage.setVisibility(8);
        this.mErrorFrame.setVisibility(8);
        this.mSuccessFrame.setVisibility(8);
        this.mWarningFrame.setVisibility(8);
        this.mProgressFrame.setVisibility(8);
        this.mConfirmButton.setVisibility(0);
        this.mConfirmButton.setBackgroundResource(2131230904);
        this.mErrorFrame.clearAnimation();
        this.mErrorX.clearAnimation();
        this.mSuccessTick.clearAnimation();
        this.mSuccessLeftMask.clearAnimation();
        this.mSuccessRightMask.clearAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        dismissWithAnimation(true);
    }

    public void changeAlertType(int i) {
        changeAlertType(i, false);
    }

    public void dismissWithAnimation() {
        dismissWithAnimation(false);
    }

    public int getAlerType() {
        return this.mAlertType;
    }

    public String getCancelText() {
        return this.mCancelText;
    }

    public String getConfirmText() {
        return this.mConfirmText;
    }

    public String getContentText() {
        return this.mContentText;
    }

    public ProgressHelper getProgressHelper() {
        return this.mProgressHelper;
    }

    public String getTitleText() {
        return this.mTitleText;
    }

    public boolean isShowCancelButton() {
        return this.mShowCancel;
    }

    public boolean isShowContentText() {
        return this.mShowContent;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == 2131296390) {
            OnSweetClickListener onSweetClickListener = this.mCancelClickListener;
            if (onSweetClickListener != null) {
                onSweetClickListener.onClick(this);
                return;
            } else {
                dismissWithAnimation();
                return;
            }
        }
        if (view.getId() == 2131296421) {
            OnSweetClickListener onSweetClickListener2 = this.mConfirmClickListener;
            if (onSweetClickListener2 != null) {
                onSweetClickListener2.onClick(this);
            } else {
                dismissWithAnimation();
            }
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492914);
        this.mDialogView = getWindow().getDecorView().findViewById(R.id.content);
        this.mTitleTextView = (TextView) findViewById(2131296925);
        this.mContentTextView = (TextView) findViewById(2131296428);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131296495);
        this.mErrorFrame = frameLayout;
        this.mErrorX = (ImageView) frameLayout.findViewById(2131296496);
        this.mSuccessFrame = (FrameLayout) findViewById(2131296884);
        this.mProgressFrame = (FrameLayout) findViewById(2131296748);
        this.mSuccessTick = this.mSuccessFrame.findViewById(2131296885);
        this.mSuccessLeftMask = this.mSuccessFrame.findViewById(2131296679);
        this.mSuccessRightMask = this.mSuccessFrame.findViewById(2131296680);
        this.mCustomImage = (ImageView) findViewById(2131296436);
        this.mWarningFrame = (FrameLayout) findViewById(2131297220);
        this.mConfirmButton = (Button) findViewById(2131296421);
        this.mCancelButton = (Button) findViewById(2131296390);
        this.mProgressHelper.setProgressWheel(findViewById(2131296745));
        this.mConfirmButton.setOnClickListener(this);
        this.mCancelButton.setOnClickListener(this);
        setTitleText(this.mTitleText);
        setContentText(this.mContentText);
        setCancelText(this.mCancelText);
        setConfirmText(this.mConfirmText);
        changeAlertType(this.mAlertType, true);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.mDialogView.startAnimation(this.mModalInAnim);
        playAnimation();
    }

    public SweetAlertDialog setCancelClickListener(OnSweetClickListener onSweetClickListener) {
        this.mCancelClickListener = onSweetClickListener;
        return this;
    }

    public SweetAlertDialog setCancelText(String str) {
        this.mCancelText = str;
        if (this.mCancelButton != null && str != null) {
            showCancelButton(true);
            this.mCancelButton.setText(this.mCancelText);
        }
        return this;
    }

    public SweetAlertDialog setConfirmClickListener(OnSweetClickListener onSweetClickListener) {
        this.mConfirmClickListener = onSweetClickListener;
        return this;
    }

    public SweetAlertDialog setConfirmText(String str) {
        this.mConfirmText = str;
        Button button = this.mConfirmButton;
        if (button != null && str != null) {
            button.setText(str);
        }
        return this;
    }

    public SweetAlertDialog setContentText(String str) {
        this.mContentText = str;
        if (this.mContentTextView != null && str != null) {
            showContentText(true);
            this.mContentTextView.setText(this.mContentText);
        }
        return this;
    }

    public SweetAlertDialog setCustomImage(int i) {
        return setCustomImage(getContext().getResources().getDrawable(i));
    }

    public SweetAlertDialog setCustomImage(Drawable drawable) {
        this.mCustomImgDrawable = drawable;
        ImageView imageView = this.mCustomImage;
        if (imageView != null && drawable != null) {
            imageView.setVisibility(0);
            this.mCustomImage.setImageDrawable(this.mCustomImgDrawable);
        }
        return this;
    }

    public SweetAlertDialog setTitleText(String str) {
        this.mTitleText = str;
        TextView textView = this.mTitleTextView;
        if (textView != null && str != null) {
            textView.setText(str);
        }
        return this;
    }

    public SweetAlertDialog showCancelButton(boolean z) {
        this.mShowCancel = z;
        Button button = this.mCancelButton;
        if (button != null) {
            button.setVisibility(z ? 0 : 8);
        }
        return this;
    }

    public SweetAlertDialog showContentText(boolean z) {
        this.mShowContent = z;
        TextView textView = this.mContentTextView;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
        return this;
    }
}
