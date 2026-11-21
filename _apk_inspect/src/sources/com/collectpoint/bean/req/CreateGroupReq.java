package com.collectpoint.bean.req;

import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class CreateGroupReq {
    private String patrolUserCode;
    private List<String> roadLineCodeList;
    private String taskGroupCode;
    private List<String> taskGroupCodeList;
    private String taskGroupName;

    public CreateGroupReq(String str, String str2, String str3, List<String> list) {
        this.taskGroupName = str2;
        this.taskGroupCode = str3;
        this.patrolUserCode = str;
        this.roadLineCodeList = list;
    }

    public CreateGroupReq(String str, String str2, List<String> list) {
        this.taskGroupName = str2;
        this.patrolUserCode = str;
        this.roadLineCodeList = list;
    }

    public CreateGroupReq(String str, List<String> list) {
        this.patrolUserCode = str;
        this.taskGroupCodeList = list;
    }
}
