package com.collectpoint.bean.res;

import com.collectpoint.bean.item.HallCartItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class HallCartRes {
    private HallCartListRes list;

    public static class HallCartListRes {
        private List<HallCartItem> data;

        public List<HallCartItem> getData() {
            return this.data;
        }
    }

    public HallCartListRes getList() {
        return this.list;
    }
}
