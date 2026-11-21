package com.collectpoint.bean.item;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class CouponPayItem implements Parcelable {
    public static final Parcelable.Creator<CouponPayItem> CREATOR = new Parcelable.Creator<CouponPayItem>() { // from class: com.collectpoint.bean.item.CouponPayItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CouponPayItem createFromParcel(Parcel parcel) {
            return new CouponPayItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CouponPayItem[] newArray(int i) {
            return new CouponPayItem[i];
        }
    };
    private String num;
    private String out_trade_no;
    private String radio;
    private String settle_id;
    private String settle_money;
    private String settle_type;
    private String user_id;

    public static class CouponTypeRes implements Parcelable {
        public static final Parcelable.Creator<CouponTypeRes> CREATOR = new Parcelable.Creator<CouponTypeRes>() { // from class: com.collectpoint.bean.item.CouponPayItem.CouponTypeRes.1
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

    public CouponPayItem() {
    }

    protected CouponPayItem(Parcel parcel) {
        this.settle_id = parcel.readString();
        this.settle_type = (String) parcel.readValue(String.class.getClassLoader());
        this.num = parcel.readString();
        this.settle_money = parcel.readString();
        this.out_trade_no = parcel.readString();
        this.radio = parcel.readString();
    }

    public CouponPayItem(String str, String str2, String str3) {
        this.settle_type = str;
        this.settle_money = str2;
        this.out_trade_no = str3;
    }

    public CouponPayItem(String str, String str2, String str3, String str4, String str5) {
        this.settle_id = str;
        this.settle_type = str2;
        this.settle_money = str3;
        this.num = str4;
        this.out_trade_no = str5;
    }

    public CouponPayItem(String str, String str2, String str3, String str4, String str5, String str6) {
        this.settle_id = str;
        this.settle_type = str2;
        this.settle_money = str3;
        this.num = str4;
        this.radio = str5;
        this.user_id = str6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getNum() {
        return this.num;
    }

    public String getOut_trade_no() {
        return this.out_trade_no;
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

    public void readFromParcel(Parcel parcel) {
        this.settle_id = parcel.readString();
        this.settle_type = parcel.readString();
        this.num = parcel.readString();
        this.settle_money = parcel.readString();
        this.out_trade_no = parcel.readString();
        this.radio = parcel.readString();
    }

    public void setNum(String str) {
        this.num = str;
    }

    public void setOut_trade_no(String str) {
        this.out_trade_no = str;
    }

    public void setSettle_id(String str) {
        this.settle_id = str;
    }

    public void setSettle_money(String str) {
        this.settle_money = str;
    }

    public void setSettle_type(String str) {
        this.settle_type = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.settle_id);
        parcel.writeValue(this.settle_type);
        parcel.writeString(this.num);
        parcel.writeString(this.settle_money);
        parcel.writeString(this.out_trade_no);
        parcel.writeString(this.radio);
    }
}
