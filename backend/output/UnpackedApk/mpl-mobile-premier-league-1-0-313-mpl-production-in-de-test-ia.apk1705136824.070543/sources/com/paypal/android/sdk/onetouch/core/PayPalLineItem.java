package com.paypal.android.sdk.onetouch.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PayPalLineItem implements Parcelable {
    public static final Creator<PayPalLineItem> CREATOR = new Creator<PayPalLineItem>() {
        public Object createFromParcel(Parcel parcel) {
            return new PayPalLineItem(parcel, null);
        }

        public Object[] newArray(int i) {
            return new PayPalLineItem[i];
        }
    };
    public String mDescription;
    public String mKind;
    public String mName;
    public String mProductCode;
    public String mQuantity;
    public String mUnitAmount;
    public String mUnitTaxAmount;
    public String mUrl;

    public PayPalLineItem(Parcel parcel, AnonymousClass1 r2) {
        this.mDescription = parcel.readString();
        this.mKind = parcel.readString();
        this.mName = parcel.readString();
        this.mProductCode = parcel.readString();
        this.mQuantity = parcel.readString();
        this.mUnitAmount = parcel.readString();
        this.mUnitTaxAmount = parcel.readString();
        this.mUrl = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mDescription);
        parcel.writeString(this.mKind);
        parcel.writeString(this.mName);
        parcel.writeString(this.mProductCode);
        parcel.writeString(this.mQuantity);
        parcel.writeString(this.mUnitAmount);
        parcel.writeString(this.mUnitTaxAmount);
        parcel.writeString(this.mUrl);
    }
}
