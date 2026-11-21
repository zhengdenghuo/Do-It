package com.collectpoint.bean.req;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class OrderCacheReq implements Parcelable {
    public static final Parcelable.Creator<OrderCacheReq> CREATOR = new Parcelable.Creator<OrderCacheReq>() { // from class: com.collectpoint.bean.req.OrderCacheReq.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderCacheReq createFromParcel(Parcel parcel) {
            return new OrderCacheReq(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderCacheReq[] newArray(int i) {
            return new OrderCacheReq[i];
        }
    };
    private String content;
    private String oeder_id;

    protected OrderCacheReq(Parcel parcel) {
        this.oeder_id = parcel.readString();
        this.content = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return this.content;
    }

    public String getOeder_id() {
        return this.oeder_id;
    }

    public void readFromParcel(Parcel parcel) {
        this.oeder_id = parcel.readString();
        this.content = parcel.readString();
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setOeder_id(String str) {
        this.oeder_id = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.oeder_id);
        parcel.writeString(this.content);
    }
}
