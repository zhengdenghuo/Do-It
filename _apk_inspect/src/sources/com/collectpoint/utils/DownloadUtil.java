package com.collectpoint.utils;

import android.os.Handler;
import android.os.Message;
import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class DownloadUtil {
    public static final int DOWNLOAD_FAIL = 0;
    public static final int DOWNLOAD_PROGRESS = 1;
    public static final int DOWNLOAD_SUCCESS = 2;
    private static DownloadUtil downloadUtil;
    OnDownloadListener listener;
    private Handler mHandler = new Handler() { // from class: com.collectpoint.utils.DownloadUtil.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    DownloadUtil.this.listener.onDownloadFailed();
                    break;
                case 1:
                    DownloadUtil.this.listener.onDownloading(((Integer) message.obj).intValue());
                    break;
                case 2:
                    DownloadUtil.this.listener.onDownloadSuccess(message.getData().getString("filePath"), message.getData().getString("fileName"));
                    break;
            }
        }
    };
    private final OkHttpClient okHttpClient = new OkHttpClient();

    public interface OnDownloadListener {
        void onDownloadFailed();

        void onDownloadSuccess(String str, String str2);

        void onDownloading(int i);
    }

    private DownloadUtil() {
    }

    public static DownloadUtil getInstance() {
        if (downloadUtil == null) {
            downloadUtil = new DownloadUtil();
        }
        return downloadUtil;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getNameFromUrl(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String isExistDir(String str) throws IOException {
        File file = new File(str);
        if (!file.mkdirs()) {
            file.createNewFile();
        }
        return file.getAbsolutePath();
    }

    public void download(final String str, final String str2, OnDownloadListener onDownloadListener) {
        this.listener = onDownloadListener;
        this.okHttpClient.newCall(new Request.Builder().url(str).build()).enqueue(new Callback() { // from class: com.collectpoint.utils.DownloadUtil.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            public void onFailure(Call call, IOException iOException) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 0;
                DownloadUtil.this.mHandler.sendMessage(messageObtain);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:19:0x00a8
                	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
                	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
                	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
                */
            public void onResponse(okhttp3.Call r17, okhttp3.Response r18) throws java.io.IOException {
                /*
                    Method dump skipped, instructions count: 230
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.collectpoint.utils.DownloadUtil.AnonymousClass1.onResponse(okhttp3.Call, okhttp3.Response):void");
            }
        });
    }
}
