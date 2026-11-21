package com.collectpoint.bean.even;

import com.collectpoint.bean.AccountTreeItem;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class MemberEvent {
    private boolean isCom;
    private List<AccountTreeItem> list;
    private int num = 0;

    public MemberEvent(boolean z, List<AccountTreeItem> list) {
        this.isCom = z;
        this.list = list;
    }

    public List<AccountTreeItem> getList() {
        return this.list;
    }

    public int getNum() {
        return this.num;
    }

    public boolean isCom() {
        return this.isCom;
    }

    public void setList(List<AccountTreeItem> list) {
        this.list = list;
    }
}
