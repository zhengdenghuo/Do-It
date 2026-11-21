package com.collectpoint.bean.req;

import android.os.Parcel;
import android.os.Parcelable;
import com.collectpoint.bean.item.CouponItem;
import com.collectpoint.utils.EmptyUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class OrderInfoReq implements Parcelable {
    public static final Parcelable.Creator<OrderInfoReq> CREATOR = new Parcelable.Creator<OrderInfoReq>() { // from class: com.collectpoint.bean.req.OrderInfoReq.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderInfoReq createFromParcel(Parcel parcel) {
            return new OrderInfoReq(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderInfoReq[] newArray(int i) {
            return new OrderInfoReq[i];
        }
    };
    private List<CouponItem> coupon;
    private String mobile;
    private String order_id;
    private List<CouponItem> settle;
    private String shop_supplier_id;
    private String table_id;
    private String user_id;

    protected OrderInfoReq(Parcel parcel) {
        this.table_id = parcel.readString();
        this.shop_supplier_id = parcel.readString();
        this.user_id = parcel.readString();
        this.mobile = parcel.readString();
        this.order_id = parcel.readString();
        this.coupon = parcel.createTypedArrayList(CouponItem.CREATOR);
        this.settle = parcel.createTypedArrayList(CouponItem.CREATOR);
    }

    public OrderInfoReq(String str, String str2, String str3, String str4, List<CouponItem> list, List<CouponItem> list2) {
        this.table_id = str;
        this.order_id = str2;
        this.shop_supplier_id = str3;
        this.user_id = str4;
        this.coupon = list;
        this.settle = list2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<CouponItem> getCoupon() {
        return EmptyUtils.isEmpty(this.coupon) ? new ArrayList() : this.coupon;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public List<CouponItem> getSettle() {
        return EmptyUtils.isEmpty(this.settle) ? new ArrayList() : this.settle;
    }

    public String getShop_supplier_id() {
        return this.shop_supplier_id;
    }

    public String getTable_id() {
        return this.table_id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void readFromParcel(Parcel parcel) {
        this.table_id = parcel.readString();
        this.shop_supplier_id = parcel.readString();
        this.user_id = parcel.readString();
        this.mobile = parcel.readString();
        this.order_id = parcel.readString();
        this.coupon = parcel.createTypedArrayList(CouponItem.CREATOR);
        this.settle = parcel.createTypedArrayList(CouponItem.CREATOR);
    }

    public void setCoupon(List<CouponItem> list) {
        this.coupon = list;
    }

    public void setOrder_id(String str) {
        this.order_id = str;
    }

    public void setSettle(List<CouponItem> list) {
        this.settle = list;
    }

    public void setShop_supplier_id(String str) {
        this.shop_supplier_id = str;
    }

    public void setTable_id(String str) {
        this.table_id = str;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.table_id);
        parcel.writeString(this.shop_supplier_id);
        parcel.writeString(this.user_id);
        parcel.writeString(this.mobile);
        parcel.writeString(this.order_id);
        parcel.writeTypedList(this.coupon);
        parcel.writeTypedList(this.settle);
    }
}
