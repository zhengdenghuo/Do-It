package com.collectpoint.moudle.mine.changepwd;

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
import com.collectpoint.databinding.FragChangePwdBinding;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.MineVm;
import com.collectpoint.utils.BitmapUtil;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.EmptyUtils;
import com.google.common.base.Preconditions;
import com.liuwq.base.MyActivityManager;
import com.liuwq.base.fragment.BaseTitleFragment;
import com.liuwq.base.widget.CustomDialogFragCompat;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class ChangePwdFrag extends BaseTitleFragment implements View.OnClickListener, TextWatcher {
    private static final int HANDLER_TIME = 3;
    private CountDownRunnable countDownRunnable;
    private GraphicCodeRes info;
    private FragChangePwdBinding mBinding;
    private MineVm mViewModel;
    private Timer timer = new Timer();
    private Handler mHandler = new Handler() { // from class: com.collectpoint.moudle.mine.changepwd.ChangePwdFrag.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 3) {
                int iIntValue = ((Integer) message.obj).intValue();
                if (iIntValue > 0) {
                    ChangePwdFrag.this.mBinding.btnSendCode.setText("重新获取" + iIntValue + "秒");
                    return;
                }
                if (iIntValue == 0) {
                    if (ChangePwdFrag.this.timer != null) {
                        ChangePwdFrag.this.timer.cancel();
                    }
                    ChangePwdFrag.this.mBinding.btnSendCode.setText("重新获取");
                    ChangePwdFrag.this.mBinding.btnSendCode.setEnabled(true);
                    ChangePwdFrag.this.mBinding.btnSendCode.setBackgroundResource(2131230895);
                    ChangePwdFrag.this.mBinding.btnSendCode.setTextColor(ChangePwdFrag.this.getResources().getColor(2131099827));
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
                ChangePwdFrag.this.mHandler.sendMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public static ChangePwdFrag newInstance() {
        Bundle bundle = new Bundle();
        ChangePwdFrag changePwdFrag = new ChangePwdFrag();
        changePwdFrag.setArguments(bundle);
        return changePwdFrag;
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
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-mine-changepwd-ChangePwdFrag, reason: not valid java name */
    /* synthetic */ void m177xe05902d9(Resource resource) {
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

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-mine-changepwd-ChangePwdFrag, reason: not valid java name */
    /* synthetic */ void m178xfa748178(Resource resource) {
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

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-mine-changepwd-ChangePwdFrag, reason: not valid java name */
    /* synthetic */ void m179x14900017(Resource resource) {
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
                CacheUtils.getInstance().getCacheDoubleUtils().put(Constants.KEY_PRE_PWD, this.mBinding.editNewPwd.getText().toString());
                CacheUtils.getInstance().getCacheDoubleUtils().put(Constants.KEY_PARCELABLE_LOGGED_IN_USER, (Parcelable) resource.data);
                if (!EmptyUtils.isNotEmpty(CacheUtils.getInstance().getUserBean())) {
                    ToastUtils.showShort("出错了，请重启app");
                    break;
                } else {
                    Router.build(Constants.MAIN).go(getContext());
                    MyActivityManager.destroyAllActivity();
                    requireActivity().finish();
                    break;
                }
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
        this.mViewModel.mGraphicCode.observe(this, new Observer() { // from class: com.collectpoint.moudle.mine.changepwd.ChangePwdFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m177xe05902d9((Resource) obj);
            }
        });
        this.mViewModel.mSendSms.observe(this, new Observer() { // from class: com.collectpoint.moudle.mine.changepwd.ChangePwdFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m178xfa748178((Resource) obj);
            }
        });
        this.mViewModel.mUpdateUserPwd.observe(this, new Observer() { // from class: com.collectpoint.moudle.mine.changepwd.ChangePwdFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m179x14900017((Resource) obj);
            }
        });
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragChangePwdBinding fragChangePwdBinding = (FragChangePwdBinding) DataBindingUtil.inflate(layoutInflater, 2131492959, viewGroup, false);
        this.mBinding = fragChangePwdBinding;
        fragChangePwdBinding.setLifecycleOwner(this);
        this.mViewModel = ChangePwdAct.getViewModel(requireActivity());
        showTitleIconLeft();
        showTitleTextCenter(getString(2131820652));
        setOnClickListener();
        return this.mBinding.getRoot();
    }
}
