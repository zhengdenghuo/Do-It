package com.collectpoint.net.interceptor;

import com.blankj.utilcode.util.EncryptUtils;
import com.collectpoint.BuildConfig;
import com.collectpoint.bean.EncryptionBean;
import com.collectpoint.bean.TimeOutBean;
import com.collectpoint.utils.CacheUtils;
import com.google.common.base.Charsets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class CookieReadInterceptor implements Interceptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String ENCRYPT_ALGORITHM = "AES/ECB/PKCS5Padding";

    private boolean rebuildPostRequest(Request request) {
        Charset charsetForName = Charset.forName("UTF-8");
        String str = "1";
        if (request.body() instanceof MultipartBody) {
            List<MultipartBody.Part> listParts = request.body().parts();
            if (listParts == null) {
                throw new AssertionError();
            }
            for (MultipartBody.Part part : listParts) {
                if (part.headers().value(0).contains("timeLimete")) {
                    try {
                        RequestBody requestBodyBody = part.body();
                        if (requestBodyBody != null) {
                            Buffer buffer = new Buffer();
                            requestBodyBody.writeTo(buffer);
                            Charset charset = charsetForName;
                            MediaType mediaTypeContentType = requestBodyBody.contentType();
                            if (mediaTypeContentType != null) {
                                charset = mediaTypeContentType.charset(charsetForName);
                            }
                            return str.equals(buffer.readString(charset));
                        }
                        continue;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            RequestBody requestBodyBody2 = request.body();
            String string = null;
            if (requestBodyBody2 != null) {
                Buffer buffer2 = new Buffer();
                try {
                    requestBodyBody2.writeTo(buffer2);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                Charset charset2 = charsetForName;
                MediaType mediaTypeContentType2 = requestBodyBody2.contentType();
                if (mediaTypeContentType2 != null) {
                    charset2 = mediaTypeContentType2.charset(charsetForName);
                }
                string = buffer2.readString(charset2);
            }
            try {
                Gson gsonCreate = new GsonBuilder().create();
                return "1".equals(((TimeOutBean) gsonCreate.fromJson(new String(EncryptUtils.decryptHexStringAES(((EncryptionBean) gsonCreate.fromJson(string, EncryptionBean.class)).getData(), BuildConfig.AES_KEY.getBytes(Charsets.UTF_8), "AES/ECB/PKCS5Padding", (byte[]) null)), TimeOutBean.class)).getTimeLimete());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return $assertionsDisabled;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        builderNewBuilder.addHeader("token", CacheUtils.getInstance().getToken());
        builderNewBuilder.addHeader("appid", "10001");
        String string = request.url().toString();
        boolean zContains = string.contains("endHighwayPatrolTaskApi");
        if (((string.contains("fileResource/upload/?folder=") || string.contains("file/upload") || string.contains("insertPatrolEventProcessByMySelf") || string.contains("insertPatrolEvent") || string.contains("insertBridgeInspectEvent")) ? true : $assertionsDisabled) || zContains) {
            boolean zRebuildPostRequest = $assertionsDisabled;
            try {
                zRebuildPostRequest = rebuildPostRequest(request);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (zRebuildPostRequest || zContains) {
                int i = zContains ? 100 : 6;
                System.out.println("______设置超时");
                return chain.withConnectTimeout(i, TimeUnit.SECONDS).withReadTimeout(i, TimeUnit.SECONDS).proceed(builderNewBuilder.build());
            }
        }
        return chain.proceed(builderNewBuilder.build());
    }
}
