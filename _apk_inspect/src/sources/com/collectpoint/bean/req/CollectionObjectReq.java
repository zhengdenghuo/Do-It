package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class CollectionObjectReq {
    private String collectionCode;
    private String collectionPointName;
    private String region;

    public CollectionObjectReq(String str) {
        this.collectionCode = str;
    }

    public CollectionObjectReq(String str, String str2, String str3) {
        this.region = str;
        this.collectionCode = str2;
        this.collectionPointName = str3;
    }
}
