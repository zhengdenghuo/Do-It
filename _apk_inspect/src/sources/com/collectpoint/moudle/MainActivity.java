package com.collectpoint.moudle;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import com.blankj.utilcode.util.ToastUtils;
import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.InjectParam;
import com.chenenyu.router.annotation.Route;
import com.collectpoint.bean.UserBean;
import com.collectpoint.bean.even.MsgEvent;
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.ActMainBinding;
import com.collectpoint.databinding.ItemMainTabBinding;
import com.collectpoint.net.factory.PatrolVmFactory;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.StatusBarUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.common.base.Preconditions;
import com.liuwq.base.MyActivityManager;
import com.liuwq.base.image.ImgLoaderManager;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

@Route({Constants.MAIN})
/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class MainActivity extends BaseMyActivity implements TabLayout.OnTabSelectedListener, EasyPermissions.PermissionCallbacks {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int STORAGE_PERMISSION = 99;

    @InjectParam(key = "meeting")
    boolean ismeeting;
    private ActMainBinding mBinding;
    private PatrolVm mViewModel;

    @InjectParam(key = Constants.KEY_PAGE)
    int page;
    private UserBean userBean;
    private long exitTime = 0;
    private int REQUEST_CODE = 17;

    private void initTabLayout() {
        int i;
        int i2;
        for (int i3 = 0; i3 < this.mBinding.tlMain.getTabCount(); i3++) {
            TabLayout.Tab tabAt = this.mBinding.tlMain.getTabAt(i3);
            switch (i3) {
                case 0:
                    i = 2131820775;
                    i2 = 2131231051;
                    break;
                default:
                    i = 2131820849;
                    i2 = 2131231082;
                    break;
            }
            if (tabAt == null) {
                throw new AssertionError();
            }
            tabAt.setCustomView(2131493026);
            View customView = tabAt.getCustomView();
            if (customView == null) {
                throw new AssertionError();
            }
            ItemMainTabBinding itemMainTabBinding = (ItemMainTabBinding) DataBindingUtil.bind(customView);
            if (itemMainTabBinding == null) {
                throw new AssertionError();
            }
            itemMainTabBinding.tvTxt.setText(i);
            if (i3 == 0) {
                itemMainTabBinding.tvTxt.setTextColor(ContextCompat.getColor(this.mContext, 2131099703));
            }
            ImgLoaderManager.get().loadDrawable(itemMainTabBinding.ivIcon, Integer.valueOf(i2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        this.mBinding = (ActMainBinding) DataBindingUtil.setContentView(this, 2131492893);
        Router.injectParams(this);
        this.mViewModel = ViewModelProviders.of(this, PatrolVmFactory.getInstance(((MainActivity) Preconditions.checkNotNull(this)).getApplication())).get(PatrolVm.class);
        StatusBarUtil.setRootViewFitsSystemWindows(this, $assertionsDisabled);
        StatusBarUtil.setTranslucentStatus(this);
        StatusBarUtil.setStatusBarLightMode(getWindow());
        EventBus.getDefault().register(this);
        this.userBean = CacheUtils.getInstance().getUserBean();
        this.mBinding.vpMain.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        this.mBinding.vpMain.setOffscreenPageLimit(4);
        this.mBinding.tlMain.setupWithViewPager(this.mBinding.vpMain);
        this.mBinding.tlMain.addOnTabSelectedListener(this);
        initTabLayout();
        this.mBinding.vpMain.setCurrentItem(this.page, true);
        requestStoragePermission();
    }

    @Override // com.collectpoint.moudle.BaseMyActivity
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MsgEvent msgEvent) {
        switch (msgEvent.getMsg()) {
            case Constants.RED_PAGE /* 6 */:
                this.mBinding.vpMain.setCurrentItem(1, true);
                break;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        if (System.currentTimeMillis() - this.exitTime > 2000) {
            ToastUtils.showShort("再按一次退出程序");
            this.exitTime = System.currentTimeMillis();
            return true;
        }
        MyActivityManager.destroyAllActivity();
        finish();
        System.exit(0);
        return true;
    }

    public void onPermissionsDenied(int i, List<String> list) {
    }

    public void onPermissionsGranted(int i, List<String> list) {
    }

    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void onTabSelected(TabLayout.Tab tab) {
        int i;
        switch (tab.getPosition()) {
            case 0:
                i = 2131231051;
                break;
            default:
                i = 2131231083;
                break;
        }
        View customView = tab.getCustomView();
        if (customView == null) {
            return;
        }
        ItemMainTabBinding itemMainTabBinding = (ItemMainTabBinding) DataBindingUtil.bind(customView);
        if (itemMainTabBinding == null) {
            throw new AssertionError();
        }
        ImgLoaderManager.get().loadDrawable(itemMainTabBinding.ivIcon, Integer.valueOf(i));
        itemMainTabBinding.tvTxt.setTextColor(ContextCompat.getColor(this.mContext, 2131099703));
    }

    public void onTabUnselected(TabLayout.Tab tab) {
        int i;
        switch (tab.getPosition()) {
            case 0:
                i = 2131231050;
                break;
            default:
                i = 2131231082;
                break;
        }
        View customView = tab.getCustomView();
        if (customView == null) {
            throw new AssertionError();
        }
        ItemMainTabBinding itemMainTabBinding = (ItemMainTabBinding) DataBindingUtil.bind(customView);
        if (itemMainTabBinding == null) {
            throw new AssertionError();
        }
        ImgLoaderManager.get().loadDrawable(itemMainTabBinding.ivIcon, Integer.valueOf(i));
        itemMainTabBinding.tvTxt.setTextColor(ContextCompat.getColor(this.mContext, 2131100223));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @AfterPermissionGranted(STORAGE_PERMISSION)
    public void requestStoragePermission() {
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        if (EasyPermissions.hasPermissions(this, strArr)) {
            return;
        }
        EasyPermissions.requestPermissions(this, "需要读写Sdk卡权限！", STORAGE_PERMISSION, strArr);
    }
}
