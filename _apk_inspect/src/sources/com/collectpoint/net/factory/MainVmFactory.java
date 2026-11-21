package com.collectpoint.net.factory;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.collectpoint.net.remote.Injection;
import com.collectpoint.net.repo.UploadFileRepo;
import com.collectpoint.net.repo.UserRepo;
import com.collectpoint.net.vm.HomePageVm;
import com.collectpoint.net.vm.LoginVm;
import com.collectpoint.net.vm.MineVm;
import com.google.common.base.Preconditions;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class MainVmFactory extends ViewModelProvider.AndroidViewModelFactory {
    private static MainVmFactory sInstance;
    private Application mApp;
    private UploadFileRepo mUploadRepo;
    private UserRepo mUserRepo;

    private MainVmFactory(Application application, UserRepo userRepo, UploadFileRepo uploadFileRepo) {
        super(application);
        this.mApp = (Application) Preconditions.checkNotNull(application);
        this.mUserRepo = (UserRepo) Preconditions.checkNotNull(userRepo);
        this.mUploadRepo = (UploadFileRepo) Preconditions.checkNotNull(uploadFileRepo);
    }

    public static MainVmFactory getInstance(Application application) {
        if (sInstance == null) {
            synchronized (MainVmFactory.class) {
                if (sInstance == null) {
                    sInstance = new MainVmFactory(application, Injection.provideUserRepository(application), Injection.provideUploadFileRepository(application));
                }
            }
        }
        return sInstance;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        return cls.isAssignableFrom(LoginVm.class) ? new LoginVm(this.mApp, this.mUserRepo, this.mUploadRepo) : cls.isAssignableFrom(HomePageVm.class) ? new HomePageVm(this.mApp, this.mUserRepo, this.mUploadRepo) : cls.isAssignableFrom(MineVm.class) ? new MineVm(this.mApp, this.mUserRepo, this.mUploadRepo) : (T) super.create(cls);
    }
}
