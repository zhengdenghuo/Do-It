package com.collectpoint.moudle.mine;

import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.blankj.utilcode.util.ToastUtils;
import com.chenenyu.router.Router;
import com.collectpoint.bean.UserBean;
import com.collectpoint.bean.res.SoftWareNewestVersionApiRes;
import com.collectpoint.bean.res.UpdateUserRoleCodeRes;
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragMineBinding;
import com.collectpoint.net.factory.MainVmFactory;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.remote.Injection;
import com.collectpoint.net.remote.Resource;
import com.collectpoint.net.repo.MeetingRepo;
import com.collectpoint.net.repo.PatrolRepo;
import com.collectpoint.net.vm.HomePageVm;
import com.collectpoint.net.vm.MineVm;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.SystemUtils;
import com.collectpoint.widget.popupwindow.UpdateVersionDialog;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.liuwq.base.MyActivityManager;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.util.SystemUtil;
import com.liuwq.base.widget.CustomDialogFragCompat;
import io.reactivex.disposables.Disposable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public class MineFrag extends BaseFragment implements View.OnClickListener, DialogInterface.OnClickListener {
    private CustomDialogFragCompat dialog;
    private FragMineBinding mBinding;
    private HomePageVm mHomePageVm;
    private PatrolVm mPatrolVm;
    private PatrolRepo mRepository;
    private Disposable mSubscribe;
    private MineVm mViewModel;
    private MeetingRepo meetingrepo;
    private UserBean user;

    private void getVersionsInfoSuccess(SoftWareNewestVersionApiRes softWareNewestVersionApiRes) {
        if (TextUtils.equals("Y", softWareNewestVersionApiRes.getIfUpdate())) {
            new UpdateVersionDialog(requireActivity(), this.user.getFileDownloadUrl() + softWareNewestVersionApiRes.getSoftPath(), softWareNewestVersionApiRes.getVersions(), softWareNewestVersionApiRes.getContent(), softWareNewestVersionApiRes.getIsForce(), 1, softWareNewestVersionApiRes.getId());
        } else {
            ToastUtils.showShort("已经是最新版本！");
        }
    }

    private void initDialog() {
        CustomDialogFragCompat customDialogFragCompatFindFragmentByTag = requireFragmentManager().findFragmentByTag(Constants.TAG_LOADING_DIALOG);
        this.dialog = customDialogFragCompatFindFragmentByTag;
        if (customDialogFragCompatFindFragmentByTag == null) {
            this.dialog = CustomDialogFragCompat.newTransparentLoadingDialog((String) null);
        }
    }

    public static MineFrag newInstance() {
        Bundle bundle = new Bundle();
        MineFrag mineFrag = new MineFrag();
        mineFrag.setArguments(bundle);
        return mineFrag;
    }

    private void setOnClickListener() {
        this.mBinding.tvChangePwd.setOnClickListener(this);
        this.mBinding.btnLogOut.setOnClickListener(this);
        this.mBinding.tvCache.setOnClickListener(this);
        this.mBinding.tvAbout.setOnClickListener(this);
    }

    /* renamed from: lambda$onInit$0$com-collectpoint-moudle-mine-MineFrag, reason: not valid java name */
    /* synthetic */ void m171lambda$onInit$0$comcollectpointmoudlemineMineFrag(Void r4) {
        Router.build(Constants.LOGIN).with(Constants.KEY_STATUS, true).go(getContext());
        MyActivityManager.destroyAllActivity();
        requireActivity().finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$1$com-collectpoint-moudle-mine-MineFrag, reason: not valid java name */
    /* synthetic */ void m172lambda$onInit$1$comcollectpointmoudlemineMineFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 1:
                this.user = (UserBean) Preconditions.checkNotNull((UserBean) resource.data);
                this.mBinding.tvName.setText(this.user.getNickName());
                this.mBinding.tvId.setText(this.user.getUserPhone());
                break;
        }
    }

    /* renamed from: lambda$onInit$2$com-collectpoint-moudle-mine-MineFrag, reason: not valid java name */
    /* synthetic */ void m173lambda$onInit$2$comcollectpointmoudlemineMineFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 0:
                if (!this.dialog.isAdded()) {
                    this.dialog.show(requireFragmentManager(), Constants.TAG_LOADING_DIALOG);
                    break;
                }
                break;
            case 1:
                this.dialog.dismiss();
                break;
            case 2:
                this.dialog.dismiss();
                ToastUtils.showShort(resource.message);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$3$com-collectpoint-moudle-mine-MineFrag, reason: not valid java name */
    /* synthetic */ void m174lambda$onInit$3$comcollectpointmoudlemineMineFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 0:
                if (!this.dialog.isAdded()) {
                    this.dialog.show(requireFragmentManager(), Constants.TAG_LOADING_DIALOG);
                    break;
                }
                break;
            case 1:
                this.dialog.dismiss();
                if (EmptyUtils.isNotEmpty(resource.data)) {
                    getVersionsInfoSuccess((SoftWareNewestVersionApiRes) resource.data);
                    break;
                }
                break;
            case 2:
                this.dialog.dismiss();
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onInit$4$com-collectpoint-moudle-mine-MineFrag, reason: not valid java name */
    /* synthetic */ void m175lambda$onInit$4$comcollectpointmoudlemineMineFrag(Resource resource) {
        Preconditions.checkNotNull(resource);
        switch (resource.status) {
            case 0:
                if (!this.dialog.isAdded()) {
                    this.dialog.show(requireFragmentManager(), Constants.TAG_LOADING_DIALOG);
                    break;
                }
                break;
            case 1:
                this.dialog.dismiss();
                if (EmptyUtils.isNotEmpty(resource.data)) {
                    CacheUtils.getInstance().getCacheDoubleUtils().put(Constants.KEY_PATROL_LIST, new Gson().toJson(((UpdateUserRoleCodeRes) resource.data).getPatrolList()));
                    break;
                }
                break;
            case 2:
                this.dialog.dismiss();
                break;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -1:
                CacheUtils.getInstance().getUserBean().getUserCode();
                CacheUtils.getInstance().getUserBean().getNickName();
                this.mViewModel.logout();
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = null;
        switch (view.getId()) {
            case 2131296375:
                showConfirmDialog(true, 2131820810, 2131820681, this, 2131820648, null, null);
                break;
            case 2131296956:
                str = Constants.ABOUT_ACT;
                break;
            case 2131296967:
                str = Constants.CHANGE_PWD_ACT;
                break;
            default:
                return;
        }
        Router.build(str).go(this);
    }

    protected void onInit() {
        if (!this.mViewModel.pLogoutEvent.hasObservers()) {
            this.mViewModel.pLogoutEvent.observe(this, new Observer() { // from class: com.collectpoint.moudle.mine.MineFrag$$ExternalSyntheticLambda4
                public final void onChanged(Object obj) {
                    this.f$0.m171lambda$onInit$0$comcollectpointmoudlemineMineFrag((Void) obj);
                }
            });
        }
        MutableLiveData<Resource<UserBean>> loggedInUser = this.mViewModel.getLoggedInUser();
        if (!loggedInUser.hasObservers()) {
            loggedInUser.observe(this, new Observer() { // from class: com.collectpoint.moudle.mine.MineFrag$$ExternalSyntheticLambda0
                public final void onChanged(Object obj) {
                    this.f$0.m172lambda$onInit$1$comcollectpointmoudlemineMineFrag((Resource) obj);
                }
            });
        }
        this.mViewModel.mUpdateUser.observe(this, new Observer() { // from class: com.collectpoint.moudle.mine.MineFrag$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.m173lambda$onInit$2$comcollectpointmoudlemineMineFrag((Resource) obj);
            }
        });
        this.mViewModel.mSoftWareNewestVersionApi.observe(this, new Observer() { // from class: com.collectpoint.moudle.mine.MineFrag$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.m174lambda$onInit$3$comcollectpointmoudlemineMineFrag((Resource) obj);
            }
        });
        this.mHomePageVm.mUpdateUserRoleCodeM.observe(this, new Observer() { // from class: com.collectpoint.moudle.mine.MineFrag$$ExternalSyntheticLambda3
            public final void onChanged(Object obj) {
                this.f$0.m175lambda$onInit$4$comcollectpointmoudlemineMineFrag((Resource) obj);
            }
        });
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragMineBinding fragMineBinding = (FragMineBinding) DataBindingUtil.inflate(layoutInflater, 2131492980, viewGroup, false);
        this.mBinding = fragMineBinding;
        fragMineBinding.setLifecycleOwner(this);
        Application application = requireActivity().getApplication();
        MainVmFactory mainVmFactory = MainVmFactory.getInstance(application);
        this.mViewModel = ViewModelProviders.of(getActivity(), mainVmFactory).get(MineVm.class);
        this.mHomePageVm = ViewModelProviders.of(getActivity(), mainVmFactory).get(HomePageVm.class);
        this.mPatrolVm = ViewModelProviders.of(getActivity(), PatrolVmFactory.getInstance(application)).get(PatrolVm.class);
        this.meetingrepo = Injection.provideMeetingRepository(application);
        this.mRepository = Injection.providePatrolRepository(application);
        String versionName = SystemUtils.getVersionName(requireActivity());
        String str = "";
        try {
            if (EmptyUtils.isNotEmpty("")) {
                str = "()";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mBinding.tvVersion.setText("当前版本V." + versionName + str);
        this.mBinding.vHeadPic.setBackground(BackgroundLibUtil.getDrawable(2131165561, 2131099747));
        initDialog();
        setStatusBar();
        setOnClickListener();
        return this.mBinding.getRoot();
    }

    public void setStatusBar() {
        this.mBinding.viewBar.getLayoutParams().height = SystemUtil.getStatusBarHeight(requireActivity());
    }
}
