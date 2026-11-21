package com.collectpoint.moudle.login;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ToastUtils;
import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.Route;
import com.collectpoint.bean.res.GraphicCodeRes;
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragTextLoginBinding;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.LoginVm;
import com.collectpoint.utils.BitmapUtil;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.SharedPreManager;
import com.google.common.base.Preconditions;
import com.liuwq.base.MyActivityManager;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.util.SystemUtil;
import com.liuwq.base.widget.CustomDialogFragCompat;
import java.util.Timer;
import java.util.TimerTask;

@Route({Constants.TEXT_LOGIN_FRAG})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes15.dex */
public class TextLoginFrag extends BaseFragment implements View.OnClickListener {
    private static final int HANDLER_TIME = 3;
    private CountDownRunnable countDownRunnable;
    private GraphicCodeRes info;
    private FragTextLoginBinding mBinding;
    private LoginVm mViewModel;
    private Timer timer = new Timer();
    private Handler mHandler = new Handler() { // from class: com.collectpoint.moudle.login.TextLoginFrag.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 3) {
                int iIntValue = ((Integer) message.obj).intValue();
                if (iIntValue > 0) {
                    TextLoginFrag.this.mBinding.btnSendCode.setText("重新获取" + iIntValue + "秒");
                    return;
                }
                if (iIntValue == 0) {
                    if (TextLoginFrag.this.timer != null) {
                        TextLoginFrag.this.timer.cancel();
                    }
                    TextLoginFrag.this.mBinding.btnSendCode.setText("重新获取");
                    TextLoginFrag.this.mBinding.btnSendCode.setEnabled(true);
                    TextLoginFrag.this.mBinding.btnSendCode.setBackgroundResource(2131230895);
                    TextLoginFrag.this.mBinding.btnSendCode.setTextColor(TextLoginFrag.this.getResources().getColor(2131099827));
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
                TextLoginFrag.this.mHandler.sendMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
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
        this.mBinding.viewBar.getLayoutParams().height = SystemUtil.getStatusBarHeight(requireContext());
        this.mBinding.btnLogin.setOnClickListener(this);
        this.mBinding.btnSendCode.setOnClickListener(this);
        this.mBinding.imgClose.setOnClickListener(this);
        this.mBinding.tvAccountPwd.setOnClickListener(this);
        this.mBinding.imgCode.setOnClickListener(this);
        this.mBinding.tv1.setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-login-TextLoginFrag, reason: not valid java name */
    /* synthetic */ void m168lambda$onInit$0$comcollectpointmoudleloginTextLoginFrag(Resource resource) {
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

    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-login-TextLoginFrag, reason: not valid java name */
    /* synthetic */ void m169lambda$onInit$1$comcollectpointmoudleloginTextLoginFrag(Resource resource) {
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

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-login-TextLoginFrag, reason: not valid java name */
    /* synthetic */ void m170lambda$onInit$2$comcollectpointmoudleloginTextLoginFrag(Resource resource) {
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
                SharedPreManager.getShared().setDay();
                ToastUtils.showShort((CharSequence) resource.data);
                Router.build(Constants.POINT_COLLECT_ACT).go(requireActivity());
                MyActivityManager.destroyAllActivity();
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
            case 2131296376:
                this.mViewModel.mobileLogin(this.mBinding.editMobile.getText().toString(), this.mBinding.editPhoneCode.getText().toString());
                break;
            case 2131296382:
                this.mViewModel.sendSms(this.mBinding.editMobile.getText().toString(), Constants.LOGIN, this.info.getKey(), this.mBinding.editImgCode.getText().toString());
                break;
            case 2131296568:
            case 2131296949:
                requireActivity().onBackPressed();
                break;
            case 2131296569:
                this.mViewModel.getGraphicCode();
                break;
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
        this.mViewModel.mGraphicCode.observe(this, new Observer() { // from class: com.collectpoint.moudle.login.TextLoginFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m168lambda$onInit$0$comcollectpointmoudleloginTextLoginFrag((Resource) obj);
            }
        });
        this.mViewModel.mSendSms.observe(this, new Observer() { // from class: com.collectpoint.moudle.login.TextLoginFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m169lambda$onInit$1$comcollectpointmoudleloginTextLoginFrag((Resource) obj);
            }
        });
        this.mViewModel.mMobileLogin.observe(this, new Observer() { // from class: com.collectpoint.moudle.login.TextLoginFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m170lambda$onInit$2$comcollectpointmoudleloginTextLoginFrag((Resource) obj);
            }
        });
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBinding = (FragTextLoginBinding) DataBindingUtil.inflate(layoutInflater, 2131492995, viewGroup, false);
        this.mViewModel = TextLoginAct.getViewModel(requireActivity());
        setOnClickListener();
        return this.mBinding.getRoot();
    }
}
