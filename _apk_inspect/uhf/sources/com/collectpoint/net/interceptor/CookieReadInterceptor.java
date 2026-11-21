package com.collectpoint.net.interceptor;

import com.blankj.utilcode.util.EncryptUtils;
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

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request reequest = chain.request();
        Request.Builder builder = reequest.newBuilder();
        String token = CacheUtils.getInstance().getToken();
        builder.addHeader("token", token);
        builder.addHeader("appid", "10001");
        String questUrl = reequest.url().toString();
        boolean isTrajectory = questUrl.contains("endHighwayPatrolTaskApi");
        boolean isPollingApi = (questUrl.contains("fileResource/upload/?folder=") || questUrl.contains("file/upload") || questUrl.contains("insertPatrolEventProcessByMySelf") || questUrl.contains("insertPatrolEvent") || questUrl.contains("insertBridgeInspectEvent")) ? true : $assertionsDisabled;
        if (isPollingApi || isTrajectory) {
            boolean isTimeOut = $assertionsDisabled;
            try {
                isTimeOut = rebuildPostRequest(reequest);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (isTimeOut || isTrajectory) {
                int timeout = 6;
                if (isTrajectory) {
                    timeout = 100;
                }
                System.out.println("______设置超时");
                return chain.withConnectTimeout(timeout, TimeUnit.SECONDS).withReadTimeout(timeout, TimeUnit.SECONDS).proceed(builder.build());
            }
        }
        return chain.proceed(builder.build());
    }

    private boolean rebuildPostRequest(Request request) {
        Charset UTF8 = Charset.forName("UTF-8");
        String str = "1";
        if (request.body() instanceof MultipartBody) {
            MultipartBody body = request.body();
            List<MultipartBody.Part> parts = body.parts();
            if (parts == null) {
                throw new AssertionError();
            }
            for (MultipartBody.Part part : parts) {
                if (part.headers().value(0).contains("timeLimete")) {
                    try {
                        RequestBody requestBody = part.body();
                        if (requestBody != null) {
                            Buffer buffer = new Buffer();
                            requestBody.writeTo(buffer);
                            Charset charset = UTF8;
                            MediaType contentType = requestBody.contentType();
                            if (contentType != null) {
                                charset = contentType.charset(UTF8);
                            }
                            String reqBody = buffer.readString(charset);
                            return str.equals(reqBody);
                        }
                        continue;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            RequestBody requestBody2 = request.body();
            String reqBody2 = null;
            if (requestBody2 != null) {
                Buffer buffer2 = new Buffer();
                try {
                    requestBody2.writeTo(buffer2);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                Charset charset2 = UTF8;
                MediaType contentType2 = requestBody2.contentType();
                if (contentType2 != null) {
                    charset2 = contentType2.charset(UTF8);
                }
                reqBody2 = buffer2.readString(charset2);
            }
            try {
                Gson gson = new GsonBuilder().create();
                EncryptionBean encryption = (EncryptionBean) gson.fromJson(reqBody2, EncryptionBean.class);
                String data = encryption.getData();
                byte[] key = "snowpa2020070101".getBytes(Charsets.UTF_8);
                byte[] decryptBytes = EncryptUtils.decryptHexStringAES(data, key, ENCRYPT_ALGORITHM, (byte[]) null);
                String data2 = new String(decryptBytes);
                TimeOutBean bean = (TimeOutBean) gson.fromJson(data2, TimeOutBean.class);
                return "1".equals(bean.getTimeLimete());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return $assertionsDisabled;
    }
}
