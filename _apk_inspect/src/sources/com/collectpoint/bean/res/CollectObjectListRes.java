package com.collectpoint.bean.res;

import com.collectpoint.bean.item.CollectObjectTypeListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class CollectObjectListRes extends BaseResponse<Content> {

    public class Content {
        private List<CollectObjectTypeListItem> rows;
        private int total;

        public Content() {
        }

        public List<CollectObjectTypeListItem> getRows() {
            return this.rows;
        }

        public int getTotal() {
            return this.total;
        }

        public void setRows(List<CollectObjectTypeListItem> list) {
            this.rows = list;
        }

        public void setTotal(int i) {
            this.total = i;
        }
    }
}
