package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PayPalProductAttributes implements Parcelable {
    public static final Creator<PayPalProductAttributes> CREATOR = new Creator<PayPalProductAttributes>() {
        public Object createFromParcel(Parcel parcel) {
            return new PayPalProductAttributes(parcel, null);
        }

        public Object[] newArray(int i) {
            return new PayPalProductAttributes[i];
        }
    };
    public String mChargePattern;
    public String mName;
    public String mProductCode;

    public PayPalProductAttributes() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mChargePattern);
        parcel.writeString(this.mName);
        parcel.writeString(this.mProductCode);
    }

    public PayPalProductAttributes(Parcel parcel, AnonymousClass1 r2) {
        this.mChargePattern = parcel.readString();
        this.mName = parcel.readString();
        this.mProductCode = parcel.readString();
    }
}
