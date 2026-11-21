package com.collectpoint.bean.res;

import com.collectpoint.bean.item.ToCompletedPatrolProblemListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class ToCompletedPatrolProblemListRes extends BaseResponse<Content> {

    public class Content {
        private List<ToCompletedPatrolProblemListItem> rows;
        private int total;

        public Content() {
        }

        public List<ToCompletedPatrolProblemListItem> getRows() {
            return this.rows;
        }

        public int getTotal() {
            return this.total;
        }

        public void setRows(List<ToCompletedPatrolProblemListItem> list) {
            this.rows = list;
        }

        public void setTotal(int i) {
            this.total = i;
        }
    }
}
