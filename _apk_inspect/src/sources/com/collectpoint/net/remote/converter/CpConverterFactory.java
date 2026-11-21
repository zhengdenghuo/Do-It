package com.collectpoint.net.remote.converter;

import com.collectpoint.net.global.CpSerializeExclusion;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.liuwq.base.gson.BooleanTypeAdapter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes13.dex */
public class CpConverterFactory extends Converter.Factory {
    private Gson mGson;

    private CpConverterFactory(Gson gson) {
        this.mGson = (Gson) Preconditions.checkNotNull(gson);
    }

    public static CpConverterFactory create() {
        BooleanTypeAdapter booleanTypeAdapter = new BooleanTypeAdapter();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Boolean.class, booleanTypeAdapter);
        gsonBuilder.registerTypeAdapter(Boolean.TYPE, booleanTypeAdapter);
        DoubleTypeAdapter doubleTypeAdapter = new DoubleTypeAdapter();
        gsonBuilder.registerTypeAdapter(Double.class, doubleTypeAdapter);
        gsonBuilder.registerTypeAdapter(Double.TYPE, doubleTypeAdapter);
        gsonBuilder.addSerializationExclusionStrategy(new CpSerializeExclusion());
        return create(gsonBuilder.create());
    }

    public static CpConverterFactory create(Gson gson) {
        return new CpConverterFactory(gson);
    }

    @Nullable
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new CpRequestBodyConverter(this.mGson, this.mGson.getAdapter(TypeToken.get(type)));
    }

    @Nullable
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new CpResponseBodyConverter(this.mGson, this.mGson.getAdapter(TypeToken.get(type)));
    }
}
