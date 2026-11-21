package com.collectpoint.net.remote;

import com.collectpoint.bean.res.TimeRes;
import io.reactivex.Observable;
import retrofit2.http.GET;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes10.dex */
public interface RetrofitApi {
    @GET("/api/ct.do")
    Observable<TimeRes> getTime();
}
