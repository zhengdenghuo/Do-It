package com.collectpoint.bean.res;

import com.collectpoint.bean.item.CurrentDatePatrolPersonnelSignInTaskListItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class PatrolSignInPointRecordListRes extends BaseResponse<Content> {

    public class Content {
        private List<CurrentDatePatrolPersonnelSignInTaskListItem> rows;
        private int total;

        public Content() {
        }

        public List<CurrentDatePatrolPersonnelSignInTaskListItem> getRows() {
            return this.rows;
        }

        public int getTotal() {
            return this.total;
        }

        public void setRows(List<CurrentDatePatrolPersonnelSignInTaskListItem> list) {
            this.rows = list;
        }

        public void setTotal(int i) {
            this.total = i;
        }
    }
}
