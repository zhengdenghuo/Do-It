package com.collectpoint.bean.res;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class CollectRecordListRes extends BaseResponse<Content> {

    public class Content {
        private List<CachedCollectObjectInfoRes> rows;
        private int total;

        public Content() {
        }

        public List<CachedCollectObjectInfoRes> getRows() {
            return this.rows;
        }

        public int getTotal() {
            return this.total;
        }

        public void setRows(List<CachedCollectObjectInfoRes> list) {
            this.rows = list;
        }

        public void setTotal(int i) {
            this.total = i;
        }
    }
}
