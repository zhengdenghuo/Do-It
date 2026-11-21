package com.collectpoint.net.factory;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.collectpoint.net.remote.Injection;
import com.collectpoint.net.repo.MeetingRepo;
import com.collectpoint.net.repo.PatrolRepo;
import com.collectpoint.net.repo.UploadFileRepo;
import com.collectpoint.net.vm.MeetingVm;
import com.collectpoint.net.vm.PatrolVm;
import com.google.common.base.Preconditions;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class PatrolVmFactory extends ViewModelProvider.AndroidViewModelFactory {
    private static PatrolVmFactory sInstance;
    private Application mApp;
    private MeetingRepo mMeetingRepo;
    private PatrolRepo mPatrolRepo;
    private UploadFileRepo mUploadRepo;

    public PatrolVmFactory(Application application, PatrolRepo patrolRepo, MeetingRepo meetingRepo, UploadFileRepo uploadFileRepo) {
        super(application);
        this.mApp = (Application) Preconditions.checkNotNull(application);
        this.mPatrolRepo = (PatrolRepo) Preconditions.checkNotNull(patrolRepo);
        this.mMeetingRepo = (MeetingRepo) Preconditions.checkNotNull(meetingRepo);
        this.mUploadRepo = (UploadFileRepo) Preconditions.checkNotNull(uploadFileRepo);
    }

    public static PatrolVmFactory getInstance(Application application) {
        if (sInstance == null) {
            synchronized (PatrolVmFactory.class) {
                if (sInstance == null) {
                    sInstance = new PatrolVmFactory(application, Injection.providePatrolRepository(application), Injection.provideMeetingRepository(application), Injection.provideUploadFileRepository(application));
                }
            }
        }
        return sInstance;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        return cls.isAssignableFrom(PatrolVm.class) ? new PatrolVm(this.mApp, this.mPatrolRepo, this.mUploadRepo) : cls.isAssignableFrom(MeetingVm.class) ? new MeetingVm(this.mApp, this.mMeetingRepo, this.mUploadRepo) : (T) super.create(cls);
    }
}
