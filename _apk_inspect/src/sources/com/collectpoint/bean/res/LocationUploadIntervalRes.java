package com.collectpoint.bean.res;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class LocationUploadIntervalRes extends BaseResponse<Content> {

    public class Content {
        private int uploadInterval;

        public Content() {
        }

        public int getUploadInterval() {
            return this.uploadInterval;
        }

        public Content setUploadInterval(int i) {
            this.uploadInterval = i;
            return this;
        }
    }
}
