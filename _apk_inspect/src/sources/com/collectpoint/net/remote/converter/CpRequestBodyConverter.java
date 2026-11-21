package com.collectpoint.net.remote.converter;

import com.collectpoint.BuildConfig;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes13.dex */
public class CpRequestBodyConverter<F> implements Converter<F, RequestBody> {
    public static final String ENCRYPT_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    private Gson mGson;
    private TypeAdapter<F> mTypeAdapter;

    public CpRequestBodyConverter(Gson gson, TypeAdapter<F> typeAdapter) {
        this.mGson = (Gson) Preconditions.checkNotNull(gson);
        this.mTypeAdapter = (TypeAdapter) Preconditions.checkNotNull(typeAdapter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object convert(Object obj) throws IOException {
        return m234convert((CpRequestBodyConverter<F>) obj);
    }

    /* renamed from: convert, reason: collision with other method in class */
    public RequestBody m234convert(F f) throws IOException {
        String json = this.mTypeAdapter.toJson(f);
        if (BuildConfig.DEBUG) {
            System.out.println("参数----->" + json);
        }
        return RequestBody.create(MEDIA_TYPE, json);
    }
}
