package com.collectpoint.bean.res;

import com.collectpoint.bean.item.PatrolPersonnelReportListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class PatrolPersonnelReportListRes extends BaseResponse<Content> {

    public class Content {
        private List<PatrolPersonnelReportListItem> rows;
        private int total;

        public Content() {
        }

        public List<PatrolPersonnelReportListItem> getRows() {
            return this.rows;
        }

        public int getTotal() {
            return this.total;
        }

        public void setRows(List<PatrolPersonnelReportListItem> list) {
            this.rows = list;
        }

        public void setTotal(int i) {
            this.total = i;
        }
    }
}
