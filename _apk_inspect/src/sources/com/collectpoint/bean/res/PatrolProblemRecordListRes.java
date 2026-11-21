package com.collectpoint.bean.res;

import com.collectpoint.bean.item.PatrolProblemRecordListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class PatrolProblemRecordListRes extends BaseResponse<Content> {

    public class Content {
        private List<PatrolProblemRecordListItem> rows;
        private int total;

        public Content() {
        }

        public List<PatrolProblemRecordListItem> getRows() {
            return this.rows;
        }

        public int getTotal() {
            return this.total;
        }

        public void setRows(List<PatrolProblemRecordListItem> list) {
            this.rows = list;
        }

        public void setTotal(int i) {
            this.total = i;
        }
    }
}
