package com.collectpoint.bean.req;

import android.os.Parcel;
import android.os.Parcelable;
import com.collectpoint.bean.item.CouponPayItem;
import com.collectpoint.utils.EmptyUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class OrderInfo2Req implements Parcelable {
    public static final Parcelable.Creator<OrderInfo2Req> CREATOR = new Parcelable.Creator<OrderInfo2Req>() { // from class: com.collectpoint.bean.req.OrderInfo2Req.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderInfo2Req createFromParcel(Parcel parcel) {
            return new OrderInfo2Req(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderInfo2Req[] newArray(int i) {
            return new OrderInfo2Req[i];
        }
    };
    private List<CouponPayItem> coupon;
    private String mobile;
    private String order_id;
    private String plat_source_id;
    private String quota_remark;
    private String remark;
    private List<CouponPayItem> settle;
    private String shop_supplier_id;
    private String table_id;
    private String user_id;

    protected OrderInfo2Req(Parcel parcel) {
        this.table_id = parcel.readString();
        this.shop_supplier_id = parcel.readString();
        this.user_id = parcel.readString();
        this.mobile = parcel.readString();
        this.quota_remark = parcel.readString();
        this.coupon = parcel.createTypedArrayList(CouponPayItem.CREATOR);
        this.settle = parcel.createTypedArrayList(CouponPayItem.CREATOR);
    }

    public OrderInfo2Req(String str, String str2, String str3) {
        this.order_id = str;
        this.shop_supplier_id = str2;
        this.user_id = str3;
        if (this.coupon == null) {
            this.coupon = new ArrayList();
        }
        this.coupon.clear();
        if (this.settle == null) {
            this.settle = new ArrayList();
        }
        this.settle.clear();
    }

    public OrderInfo2Req(String str, String str2, String str3, String str4, String str5, List<CouponPayItem> list, List<CouponPayItem> list2) {
        this.table_id = str;
        this.shop_supplier_id = str3;
        this.order_id = str2;
        this.user_id = str4;
        this.mobile = str5;
        this.coupon = list;
        this.settle = list2;
    }

    public OrderInfo2Req(String str, String str2, String str3, List<CouponPayItem> list, List<CouponPayItem> list2) {
        this.order_id = str;
        this.shop_supplier_id = str2;
        this.user_id = str3;
        this.coupon = list;
        this.settle = list2;
    }

    public OrderInfo2Req(String str, List<CouponPayItem> list) {
        this.order_id = str;
        this.settle = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<CouponPayItem> getCoupon() {
        return EmptyUtils.isEmpty(this.coupon) ? new ArrayList() : this.coupon;
    }

    public String getMobile() {
        return this.mobile;
    }

    public List<CouponPayItem> getSettle() {
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
        this.quota_remark = parcel.readString();
        this.coupon = parcel.createTypedArrayList(CouponPayItem.CREATOR);
        this.settle = parcel.createTypedArrayList(CouponPayItem.CREATOR);
    }

    public void setCoupon(List<CouponPayItem> list) {
        this.coupon = list;
    }

    public void setOrder_id(String str) {
        this.order_id = str;
    }

    public void setPlat_source_id(String str) {
        this.plat_source_id = str;
    }

    public void setQuota_remark(String str) {
        this.quota_remark = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setSettle(List<CouponPayItem> list) {
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
        parcel.writeString(this.quota_remark);
        parcel.writeTypedList(this.coupon);
        parcel.writeTypedList(this.settle);
    }
}
