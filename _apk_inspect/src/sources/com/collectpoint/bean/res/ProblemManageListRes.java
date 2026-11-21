package com.collectpoint.bean.res;

import com.collectpoint.bean.item.ProblemManageListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class ProblemManageListRes extends BaseResponse<Content> {

    public class Content {
        private List<ProblemManageListItem> rows;
        private int total;

        public Content() {
        }

        public List<ProblemManageListItem> getRows() {
            return this.rows;
        }

        public int getTotal() {
            return this.total;
        }

        public void setRows(List<ProblemManageListItem> list) {
            this.rows = list;
        }

        public void setTotal(int i) {
            this.total = i;
        }
    }
}
