package com.collectpoint.net.remote.converter;

import com.collectpoint.BuildConfig;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes13.dex */
public class CpResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private Gson mGson;
    private TypeAdapter<T> mTypeAdapter;

    public CpResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.mGson = (Gson) Preconditions.checkNotNull(gson);
        this.mTypeAdapter = (TypeAdapter) Preconditions.checkNotNull(typeAdapter);
    }

    public T convert(ResponseBody responseBody) throws IOException {
        byte[] bArrBytes = responseBody.bytes();
        String str = null;
        if (0 == 0) {
            str = new String(bArrBytes);
        } else if (BuildConfig.DEBUG) {
            System.out.println("响应---->" + ((String) null));
        }
        try {
            return (T) this.mTypeAdapter.fromJson(str);
        } finally {
            responseBody.close();
        }
    }
}
