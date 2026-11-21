package com.collectpoint.moudle.login;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ToastUtils;
import com.chenenyu.router.Router;
import com.collectpoint.bean.res.GraphicCodeRes;
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragResetPwdBinding;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.LoginVm;
import com.collectpoint.utils.BitmapUtil;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.EmptyUtils;
import com.google.common.base.Preconditions;
import com.liuwq.base.MyActivityManager;
import com.liuwq.base.fragment.BaseTitleFragment;
import com.liuwq.base.widget.CustomDialogFragCompat;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes15.dex */
public class ResetPwdFrag extends BaseTitleFragment implements View.OnClickListener, TextWatcher {
    private static final int HANDLER_TIME = 3;
    private CountDownRunnable countDownRunnable;
    private GraphicCodeRes info;
    private FragResetPwdBinding mBinding;
    private LoginVm mViewModel;
    private Timer timer = new Timer();
    private Handler mHandler = new Handler() { // from class: com.collectpoint.moudle.login.ResetPwdFrag.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 3) {
                int iIntValue = ((Integer) message.obj).intValue();
                if (iIntValue > 0) {
                    ResetPwdFrag.this.mBinding.btnSendCode.setText("重新获取" + iIntValue + "秒");
                    return;
                }
                if (iIntValue == 0) {
                    if (ResetPwdFrag.this.timer != null) {
                        ResetPwdFrag.this.timer.cancel();
                    }
                    ResetPwdFrag.this.mBinding.btnSendCode.setText("重新获取");
                    ResetPwdFrag.this.mBinding.btnSendCode.setEnabled(true);
                    ResetPwdFrag.this.mBinding.btnSendCode.setBackgroundResource(2131230895);
                    ResetPwdFrag.this.mBinding.btnSendCode.setTextColor(ResetPwdFrag.this.getResources().getColor(2131099827));
                }
            }
        }
    };

    private class CountDownRunnable extends TimerTask {
        private int time;

        public CountDownRunnable(int i) {
            this.time = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                this.time--;
                Message message = new Message();
                message.what = 3;
                message.obj = Integer.valueOf(this.time);
                ResetPwdFrag.this.mHandler.sendMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public static ResetPwdFrag newInstance() {
        Bundle bundle = new Bundle();
        ResetPwdFrag resetPwdFrag = new ResetPwdFrag();
        resetPwdFrag.setArguments(bundle);
        return resetPwdFrag;
    }

    private void refreshVCodeBtnTime() {
        this.mBinding.btnSendCode.setEnabled(false);
        this.mBinding.btnSendCode.setBackgroundResource(2131230897);
        this.mBinding.btnSendCode.setTextColor(getResources().getColor(2131099840));
        this.countDownRunnable = new CountDownRunnable(60);
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.timer = timer2;
        timer2.schedule(this.countDownRunnable, 0L, 1000L);
    }

    private void setOnClickListener() {
        this.mBinding.btnReset.setEnabled(false);
        this.mBinding.btnSendCode.setOnClickListener(this);
        this.mBinding.btnReset.setOnClickListener(this);
        this.mBinding.imgNewPwd.setOnClickListener(this);
        this.mBinding.imgConfirmPwd.setOnClickListener(this);
        this.mBinding.editMobile.addTextChangedListener(this);
        this.mBinding.editPhoneCode.addTextChangedListener(this);
        this.mBinding.editNewPwd.addTextChangedListener(this);
        this.mBinding.editConfirmPwd.addTextChangedListener(this);
        this.mBinding.imgCode.setOnClickListener(this);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(this.mBinding.editMobile.getText()) || TextUtils.isEmpty(this.mBinding.editPhoneCode.getText()) || TextUtils.isEmpty(this.mBinding.editNewPwd.getText()) || TextUtils.isEmpty(this.mBinding.editConfirmPwd.getText())) {
            this.mBinding.btnReset.setEnabled(false);
            this.mBinding.btnReset.setBackgroundResource(2131230839);
        } else {
            this.mBinding.btnReset.setEnabled(true);
            this.mBinding.btnReset.setBackgroundResource(2131230846);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-login-ResetPwdFrag, reason: not valid java name */
    /* synthetic */ void m164lambda$onInit$0$comcollectpointmoudleloginResetPwdFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        CustomDialogFragCompat customDialogFragCompatFindFragmentByTag = requireFragmentManager().findFragmentByTag(Constants.TAG_LOADING_DIALOG);
        if (customDialogFragCompatFindFragmentByTag == null) {
            customDialogFragCompatFindFragmentByTag = CustomDialogFragCompat.newTransparentLoadingDialog((String) null);
        }
        switch (resource.status) {
            case 0:
                if (!customDialogFragCompatFindFragmentByTag.isAdded()) {
                    customDialogFragCompatFindFragmentByTag.show(requireFragmentManager(), Constants.TAG_LOADING_DIALOG);
                    break;
                }
                break;
            case 1:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                if (EmptyUtils.isNotEmpty(resource.data)) {
                    this.info = (GraphicCodeRes) resource.data;
                    this.mBinding.imgCode.setImageBitmap(BitmapUtil.stringToBitmap(this.info.getCode()));
                    break;
                }
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showShort(resource.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-login-ResetPwdFrag, reason: not valid java name */
    /* synthetic */ void m165lambda$onInit$1$comcollectpointmoudleloginResetPwdFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        CustomDialogFragCompat customDialogFragCompatFindFragmentByTag = requireFragmentManager().findFragmentByTag(Constants.TAG_LOADING_DIALOG);
        if (customDialogFragCompatFindFragmentByTag == null) {
            customDialogFragCompatFindFragmentByTag = CustomDialogFragCompat.newTransparentLoadingDialog((String) null);
        }
        switch (resource.status) {
            case 0:
                if (!customDialogFragCompatFindFragmentByTag.isAdded()) {
                    customDialogFragCompatFindFragmentByTag.show(requireFragmentManager(), Constants.TAG_LOADING_DIALOG);
                    break;
                }
                break;
            case 1:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                if (EmptyUtils.isNotEmpty(resource.data)) {
                    ToastUtils.showShort((CharSequence) resource.data);
                }
                refreshVCodeBtnTime();
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showShort(resource.message);
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-login-ResetPwdFrag, reason: not valid java name */
    /* synthetic */ void m166lambda$onInit$2$comcollectpointmoudleloginResetPwdFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        CustomDialogFragCompat customDialogFragCompatFindFragmentByTag = requireFragmentManager().findFragmentByTag(Constants.TAG_LOADING_DIALOG);
        if (customDialogFragCompatFindFragmentByTag == null) {
            customDialogFragCompatFindFragmentByTag = CustomDialogFragCompat.newTransparentLoadingDialog((String) null);
        }
        switch (resource.status) {
            case 0:
                if (!customDialogFragCompatFindFragmentByTag.isAdded()) {
                    customDialogFragCompatFindFragmentByTag.show(requireFragmentManager(), Constants.TAG_LOADING_DIALOG);
                    break;
                }
                break;
            case 1:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                Router.build(Constants.POINT_COLLECT_ACT).go(requireActivity());
                MyActivityManager.destroyAllActivity();
                CacheUtils.getInstance().getCacheDoubleUtils().put(Constants.KEY_PRE_PWD, this.mBinding.editNewPwd.getText().toString());
                CacheUtils.getInstance().getCacheDoubleUtils().put(Constants.KEY_PARCELABLE_LOGGED_IN_USER, (Parcelable) resource.data);
                requireActivity().finish();
                break;
            case 2:
                if (customDialogFragCompatFindFragmentByTag.isVisible()) {
                    customDialogFragCompatFindFragmentByTag.dismiss();
                }
                ToastUtils.showShort(resource.message);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296381:
                this.mViewModel.updateUserPwd(this.mBinding.editMobile.getText().toString(), this.mBinding.editNewPwd.getText().toString(), this.mBinding.editConfirmPwd.getText().toString(), this.mBinding.editPhoneCode.getText().toString());
                break;
            case 2131296382:
                this.mViewModel.sendSms(this.mBinding.editMobile.getText().toString(), "updatePwd", this.info.getKey(), this.mBinding.editImgCode.getText().toString());
                break;
            case 2131296569:
                this.mViewModel.getGraphicCode();
                break;
            case 2131296570:
                if (!this.mBinding.imgConfirmPwd.getDrawable().getCurrent().getConstantState().equals(getResources().getDrawable(2131231048).getConstantState())) {
                    this.mBinding.editConfirmPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    this.mBinding.imgConfirmPwd.setImageResource(2131231048);
                    break;
                } else {
                    this.mBinding.editConfirmPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    this.mBinding.imgConfirmPwd.setImageResource(2131231020);
                    break;
                }
            case 2131296573:
                if (!this.mBinding.imgNewPwd.getDrawable().getCurrent().getConstantState().equals(getResources().getDrawable(2131231048).getConstantState())) {
                    this.mBinding.editNewPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    this.mBinding.imgNewPwd.setImageResource(2131231048);
                    break;
                } else {
                    this.mBinding.editNewPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    this.mBinding.imgNewPwd.setImageResource(2131231020);
                    break;
                }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
    }

    protected void onInit() {
        this.mViewModel.getGraphicCode();
        this.mViewModel.mGraphicCode.observe(this, new Observer() { // from class: com.collectpoint.moudle.login.ResetPwdFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m164lambda$onInit$0$comcollectpointmoudleloginResetPwdFrag((Resource) obj);
            }
        });
        this.mViewModel.mSendSms.observe(this, new Observer() { // from class: com.collectpoint.moudle.login.ResetPwdFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m165lambda$onInit$1$comcollectpointmoudleloginResetPwdFrag((Resource) obj);
            }
        });
        this.mViewModel.mUpdateUserPwd.observe(this, new Observer() { // from class: com.collectpoint.moudle.login.ResetPwdFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m166lambda$onInit$2$comcollectpointmoudleloginResetPwdFrag((Resource) obj);
            }
        });
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBinding = (FragResetPwdBinding) DataBindingUtil.inflate(layoutInflater, 2131492991, viewGroup, false);
        this.mViewModel = ResetPwdAct.getViewModel(requireActivity());
        setOnClickListener();
        showTitleIconLeft();
        showTitleTextCenter(getString(2131820936));
        return this.mBinding.getRoot();
    }
}
