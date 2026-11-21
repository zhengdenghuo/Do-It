package com.collectpoint.net.remote;

import com.collectpoint.bean.res.BaseResponse;
import com.collectpoint.bean.res.UploadRes;
import com.collectpoint.bean.res.UploadWxRes;
import com.collectpoint.constants.Constants;
import io.reactivex.Single;
import java.util.List;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes10.dex */
public interface IUploadFileApi {
    @POST(Constants.PATH_UPLOAD_FILE)
    @Multipart
    Single<BaseResponse> uploadFile(@Url String str, @Part List<MultipartBody.Part> list);

    @POST
    Single<BaseResponse<UploadRes>> uploadFile(@Url String str, @Body MultipartBody multipartBody);

    @POST
    Single<BaseResponse<UploadWxRes>> uploadWxFile(@Url String str, @Body MultipartBody multipartBody);
}
