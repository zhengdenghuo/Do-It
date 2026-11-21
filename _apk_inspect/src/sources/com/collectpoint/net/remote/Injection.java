package com.collectpoint.net.remote;

import android.app.Application;
import com.collectpoint.net.repo.MeetingRepo;
import com.collectpoint.net.repo.PatrolRepo;
import com.collectpoint.net.repo.UploadFileRepo;
import com.collectpoint.net.repo.UserRepo;
import com.google.common.base.Preconditions;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes10.dex */
public class Injection {
    private Injection() {
    }

    public static MeetingRepo provideMeetingRepository(Application application) {
        MeetingApi meetingApi = CpRetrofitClient.getMeetingApi();
        Preconditions.checkNotNull(application);
        return MeetingRepo.getInstance(meetingApi, application);
    }

    public static PatrolRepo providePatrolRepository(Application application) {
        PatrolApi patrolApi = CpRetrofitClient.getPatrolApi();
        Preconditions.checkNotNull(application);
        return PatrolRepo.getInstance(patrolApi, application);
    }

    public static UploadFileRepo provideUploadFileRepository(Application application) {
        IUploadFileApi uploadApi = CpRetrofitClient.getUploadApi();
        Preconditions.checkNotNull(application);
        return UploadFileRepo.getInstance(application, uploadApi);
    }

    public static UserRepo provideUserRepository(Application application) {
        IUserApi userApi = CpRetrofitClient.getUserApi();
        Preconditions.checkNotNull(application);
        return UserRepo.getInstance(userApi, application);
    }
}
