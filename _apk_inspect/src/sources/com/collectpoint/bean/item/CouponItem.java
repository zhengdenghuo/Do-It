package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.collectpoint.widget.recycler.SSelectable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class CouponItem extends SSelectable implements Parcelable {
    public static Parcelable.Creator<CouponItem> CREATOR = new Parcelable.Creator<CouponItem>() { // from class: com.collectpoint.bean.item.CouponItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CouponItem createFromParcel(Parcel parcel) {
            return new CouponItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CouponItem[] newArray(int i) {
            return new CouponItem[i];
        }
    };
    private String apply_name;
    private String apply_range;
    private String content;
    private String couponMoney;
    private String coupon_id;
    private String coupon_money;
    private String coupon_num;
    private CouponTypeRes coupon_type;
    private String deductionAmount;
    private String desc;
    private String discount;
    private String discount_money;
    private CouponTypeRes end_time;
    private String id;
    private String is_douyin;
    private String is_meituan;
    private String is_use;
    private String min_price;
    private String myNum;
    private String name;
    private String num;
    private String order_id;
    private String out_trade_no;
    private String pay_method_id;
    private String radio;
    private String realMoney;
    private String reduce_price;
    private String settle_id;
    private String settle_money;
    private String settle_type;
    private CouponTypeRes start_time;
    private SupplierRes supplier;
    private String type;
    private String user_id;

    public static class CouponTypeRes implements Parcelable {
        public static Parcelable.Creator<CouponTypeRes> CREATOR = new Parcelable.Creator<CouponTypeRes>() { // from class: com.collectpoint.bean.item.CouponItem.CouponTypeRes.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CouponTypeRes createFromParcel(Parcel parcel) {
                return new CouponTypeRes(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CouponTypeRes[] newArray(int i) {
                return new CouponTypeRes[i];
            }
        };
        private String text;
        private String value;

        protected CouponTypeRes(Parcel parcel) {
            this.text = parcel.readString();
            this.value = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getText() {
            return this.text;
        }

        public String getValue() {
            return this.value;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.text);
            parcel.writeString(this.value);
        }
    }

    public static class SupplierRes implements Parcelable {
        public static Parcelable.Creator<SupplierRes> CREATOR = new Parcelable.Creator<SupplierRes>() { // from class: com.collectpoint.bean.item.CouponItem.SupplierRes.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SupplierRes createFromParcel(Parcel parcel) {
                return new SupplierRes(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SupplierRes[] newArray(int i) {
                return new SupplierRes[i];
            }
        };
        private String name;
        private String shop_supplier_id;

        protected SupplierRes(Parcel parcel) {
            if (parcel.readByte() == 0) {
                this.shop_supplier_id = null;
            } else {
                this.shop_supplier_id = parcel.readString();
            }
            this.name = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getName() {
            return this.name;
        }

        public String getShop_supplier_id() {
            return this.shop_supplier_id;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (this.shop_supplier_id == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeString(this.shop_supplier_id);
            }
            parcel.writeString(this.name);
        }
    }

    public CouponItem() {
    }

    protected CouponItem(Parcel parcel) {
        this.name = parcel.readString();
        this.settle_id = parcel.readString();
        this.coupon_type = (CouponTypeRes) parcel.readParcelable(CouponTypeRes.class.getClassLoader());
        this.min_price = parcel.readString();
        this.start_time = (CouponTypeRes) parcel.readParcelable(CouponTypeRes.class.getClassLoader());
        this.end_time = (CouponTypeRes) parcel.readParcelable(CouponTypeRes.class.getClassLoader());
        this.reduce_price = parcel.readString();
        this.discount = parcel.readString();
        this.apply_range = parcel.readString();
        this.supplier = (SupplierRes) parcel.readParcelable(SupplierRes.class.getClassLoader());
        this.settle_type = (String) parcel.readValue(String.class.getClassLoader());
        this.radio = parcel.readString();
        this.num = parcel.readString();
        this.settle_money = parcel.readString();
        this.apply_name = parcel.readString();
        this.coupon_id = parcel.readString();
        this.coupon_num = parcel.readString();
        this.coupon_money = parcel.readString();
        this.deductionAmount = parcel.readString();
        this.couponMoney = parcel.readString();
        this.realMoney = parcel.readString();
        this.desc = parcel.readString();
        this.out_trade_no = parcel.readString();
        this.user_id = parcel.readString();
        this.pay_method_id = parcel.readString();
        this.is_douyin = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getApply_name() {
        return this.apply_name;
    }

    public String getApply_range() {
        return this.apply_range;
    }

    public String getContent() {
        return this.content;
    }

    public String getCouponMoney() {
        return this.couponMoney;
    }

    public String getCoupon_id() {
        return this.coupon_id;
    }

    public String getCoupon_money() {
        return this.coupon_money;
    }

    public String getCoupon_num() {
        return this.coupon_num;
    }

    public CouponTypeRes getCoupon_type() {
        return this.coupon_type;
    }

    public String getDeductionAmount() {
        return this.deductionAmount;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDiscount() {
        return this.discount;
    }

    public String getDiscount_money() {
        return this.discount_money;
    }

    public CouponTypeRes getEnd_time() {
        return this.end_time;
    }

    public String getId() {
        return this.id;
    }

    public String getIs_douyin() {
        return this.is_douyin;
    }

    public String getIs_meituan() {
        return this.is_meituan;
    }

    public String getIs_use() {
        return this.is_use;
    }

    public String getMin_price() {
        return this.min_price;
    }

    public String getMyNum() {
        return this.myNum;
    }

    public String getName() {
        return this.name;
    }

    public String getNum() {
        return this.num;
    }

    public String getOut_trade_no() {
        return this.out_trade_no;
    }

    public String getPay_method_id() {
        return this.pay_method_id;
    }

    public String getRadio() {
        return this.radio;
    }

    public String getRealMoney() {
        return this.realMoney;
    }

    public String getReduce_price() {
        return this.reduce_price;
    }

    public String getSettle_id() {
        return this.settle_id;
    }

    public String getSettle_money() {
        return this.settle_money;
    }

    public String getSettle_type() {
        return this.settle_type;
    }

    public CouponTypeRes getStart_time() {
        return this.start_time;
    }

    public SupplierRes getSupplier() {
        return this.supplier;
    }

    public String getType() {
        return this.type;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void readFromParcel(Parcel parcel) {
        this.name = parcel.readString();
        this.settle_id = parcel.readString();
        this.coupon_type = (CouponTypeRes) parcel.readParcelable(CouponTypeRes.class.getClassLoader());
        this.min_price = parcel.readString();
        this.start_time = (CouponTypeRes) parcel.readParcelable(CouponTypeRes.class.getClassLoader());
        this.end_time = (CouponTypeRes) parcel.readParcelable(CouponTypeRes.class.getClassLoader());
        this.reduce_price = parcel.readString();
        this.discount = parcel.readString();
        this.apply_range = parcel.readString();
        this.supplier = (SupplierRes) parcel.readParcelable(SupplierRes.class.getClassLoader());
        this.settle_type = (String) parcel.readValue(String.class.getClassLoader());
        this.radio = parcel.readString();
        this.num = parcel.readString();
        this.settle_money = parcel.readString();
        this.apply_name = parcel.readString();
        this.coupon_id = parcel.readString();
        this.coupon_num = parcel.readString();
        this.coupon_money = parcel.readString();
        this.deductionAmount = parcel.readString();
        this.couponMoney = parcel.readString();
        this.realMoney = parcel.readString();
        this.desc = parcel.readString();
        this.out_trade_no = parcel.readString();
        this.user_id = parcel.readString();
        this.pay_method_id = parcel.readString();
        this.is_douyin = parcel.readString();
    }

    public void setMyNum(String str) {
        this.myNum = str;
    }

    public void setNum(String str) {
        this.num = str;
    }

    public void setOrder_id(String str) {
        this.order_id = str;
    }

    public void setRadio(String str) {
        this.radio = str;
    }

    public void setSettle_money(String str) {
        this.settle_money = str;
    }

    public void setSettle_type(String str) {
        this.settle_type = str;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.settle_id);
        parcel.writeParcelable(this.coupon_type, i);
        parcel.writeString(this.min_price);
        parcel.writeParcelable(this.start_time, i);
        parcel.writeParcelable(this.end_time, i);
        parcel.writeString(this.reduce_price);
        parcel.writeString(this.discount);
        parcel.writeString(this.apply_range);
        parcel.writeParcelable(this.supplier, i);
        parcel.writeValue(this.settle_type);
        parcel.writeString(this.radio);
        parcel.writeString(this.num);
        parcel.writeString(this.settle_money);
        parcel.writeString(this.apply_name);
        parcel.writeString(this.coupon_id);
        parcel.writeString(this.coupon_num);
        parcel.writeString(this.coupon_money);
        parcel.writeString(this.deductionAmount);
        parcel.writeString(this.couponMoney);
        parcel.writeString(this.realMoney);
        parcel.writeString(this.desc);
        parcel.writeString(this.out_trade_no);
        parcel.writeString(this.user_id);
        parcel.writeString(this.pay_method_id);
        parcel.writeString(this.is_douyin);
    }
}
