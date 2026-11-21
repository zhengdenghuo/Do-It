package com.collectpoint.bean.res;

import com.collectpoint.bean.item.PatrolProblemIssueOpinionListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class PatrolProblemIssueOpinionListRes extends BaseResponse<Content> {

    public class Content {
        private List<PatrolProblemIssueOpinionListItem> rows;
        private int total;

        public Content() {
        }

        public List<PatrolProblemIssueOpinionListItem> getRows() {
            return this.rows;
        }

        public int getTotal() {
            return this.total;
        }

        public void setRows(List<PatrolProblemIssueOpinionListItem> list) {
            this.rows = list;
        }

        public void setTotal(int i) {
            this.total = i;
        }
    }
}
