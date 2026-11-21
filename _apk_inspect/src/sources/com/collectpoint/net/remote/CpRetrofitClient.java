package com.collectpoint.net.remote;

import com.collectpoint.BuildConfig;
import com.collectpoint.net.interceptor.CookieReadInterceptor;
import com.collectpoint.net.remote.converter.CpConverterFactory;
import com.google.gson.GsonBuilder;
import com.liuwq.base.http.RetrofitClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes10.dex */
public class CpRetrofitClient extends RetrofitClient {
    private static RetrofitApi retrofitApi;
    private static MeetingApi sMeetingApi;
    private static PatrolApi sPatrolApi;
    private static IUploadFileApi sUploadApi;
    private static IUserApi sUserApi;

    private CpRetrofitClient() {
    }

    public static MeetingApi getMeetingApi() {
        if (sMeetingApi == null) {
            synchronized (CpRetrofitClient.class) {
                if (sMeetingApi == null) {
                    sConverterFactory = CpConverterFactory.create();
                    sDefOkHttpBuilder = getDefOkHttpClientBuilder(BuildConfig.DEBUG);
                    sMeetingApi = (MeetingApi) new Retrofit.Builder().baseUrl(BuildConfig.MEETING_URL).client(sDefOkHttpBuilder.addInterceptor(new CookieReadInterceptor()).build()).addConverterFactory(sConverterFactory).addCallAdapterFactory(sCallAdapterFactory).build().create(MeetingApi.class);
                }
            }
        }
        return sMeetingApi;
    }

    public static PatrolApi getPatrolApi() {
        if (sPatrolApi == null) {
            synchronized (CpRetrofitClient.class) {
                if (sPatrolApi == null) {
                    sConverterFactory = CpConverterFactory.create();
                    sDefOkHttpBuilder = getDefOkHttpClientBuilder(BuildConfig.DEBUG);
                    sPatrolApi = (PatrolApi) new Retrofit.Builder().baseUrl("http://114.55.219.79/").client(sDefOkHttpBuilder.addInterceptor(new CookieReadInterceptor()).build()).addConverterFactory(sConverterFactory).addCallAdapterFactory(sCallAdapterFactory).build().create(PatrolApi.class);
                }
            }
        }
        return sPatrolApi;
    }

    public static RetrofitApi getRetrofitApi() {
        if (retrofitApi == null) {
            synchronized (CpRetrofitClient.class) {
                if (retrofitApi == null) {
                    sConverterFactory = CpConverterFactory.create(new GsonBuilder().create());
                    sDefOkHttpBuilder = getDefOkHttpClientBuilder(BuildConfig.DEBUG);
                    retrofitApi = (RetrofitApi) new Retrofit.Builder().baseUrl("https://f.m.suning.com").client(sDefOkHttpBuilder.build()).addConverterFactory(sConverterFactory).addCallAdapterFactory(sCallAdapterFactory).build().create(RetrofitApi.class);
                }
            }
        }
        return retrofitApi;
    }

    public static IUploadFileApi getUploadApi() {
        if (sUploadApi == null) {
            synchronized (CpRetrofitClient.class) {
                if (sUploadApi == null) {
                    sConverterFactory = GsonConverterFactory.create();
                    sDefOkHttpBuilder = getDefOkHttpClientBuilder(BuildConfig.DEBUG);
                    sUploadApi = (IUploadFileApi) new Retrofit.Builder().baseUrl("http://114.55.219.79/").client(sDefOkHttpBuilder.build()).addConverterFactory(sConverterFactory).addCallAdapterFactory(sCallAdapterFactory).build().create(IUploadFileApi.class);
                }
            }
        }
        return sUploadApi;
    }

    public static IUserApi getUserApi() {
        if (sUserApi == null) {
            synchronized (CpRetrofitClient.class) {
                if (sUserApi == null) {
                    sConverterFactory = CpConverterFactory.create();
                    sDefOkHttpBuilder = getDefOkHttpClientBuilder(BuildConfig.DEBUG);
                    sUserApi = (IUserApi) new Retrofit.Builder().baseUrl("http://114.55.219.79/").client(sDefOkHttpBuilder.addInterceptor(new CookieReadInterceptor()).build()).addConverterFactory(sConverterFactory).addCallAdapterFactory(sCallAdapterFactory).build().create(IUserApi.class);
                }
            }
        }
        return sUserApi;
    }
}
