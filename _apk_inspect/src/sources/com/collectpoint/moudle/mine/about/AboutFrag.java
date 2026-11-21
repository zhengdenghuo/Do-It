package com.collectpoint.moudle.mine.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.bean.res.AppDownloadQRCodeRes;
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragAboutBinding;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.vm.MineVm;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.SystemUtils;
import com.google.common.base.Preconditions;
import com.liuwq.base.fragment.BaseTitleFragment;
import com.liuwq.base.image.ImgLoaderManager;
import com.liuwq.base.widget.CustomDialogFragCompat;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class AboutFrag extends BaseTitleFragment {
    private FragAboutBinding mBinding;
    private MineVm mViewModel;

    private void init() {
        this.mBinding.tvVersion.setText(getString(2131821040, new Object[]{SystemUtils.getVersionName(requireContext())}));
    }

    public static AboutFrag newInstance() {
        Bundle bundle = new Bundle();
        AboutFrag aboutFrag = new AboutFrag();
        aboutFrag.setArguments(bundle);
        return aboutFrag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-mine-about-AboutFrag, reason: not valid java name */
    /* synthetic */ void m176lambda$onInit$0$comcollectpointmoudlemineaboutAboutFrag(Resource resource) {
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
                    ImgLoaderManager.get().loadDrawable(this.mBinding.imgPicture, CacheUtils.getInstance().getUserBean().getShowImgUrl() + ((AppDownloadQRCodeRes) resource.data).getImagePath());
                    this.mBinding.tvContent.setText(((AppDownloadQRCodeRes) resource.data).getTechnicalSupport());
                    this.mBinding.tvName.setText(((AppDownloadQRCodeRes) resource.data).getAppName());
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

    protected void onInit() {
        this.mViewModel.getAppDownloadQRCode();
        this.mViewModel.mAppDownloadQRCode.observe(this, new Observer() { // from class: com.collectpoint.moudle.mine.about.AboutFrag$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.m176lambda$onInit$0$comcollectpointmoudlemineaboutAboutFrag((Resource) obj);
            }
        });
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragAboutBinding fragAboutBinding = (FragAboutBinding) DataBindingUtil.inflate(layoutInflater, 2131492957, viewGroup, false);
        this.mBinding = fragAboutBinding;
        fragAboutBinding.setLifecycleOwner(this);
        this.mViewModel = AboutAct.getViewModel(requireActivity());
        showTitleIconLeft();
        showTitleTextCenter(getString(2131820571));
        init();
        return this.mBinding.getRoot();
    }
}
