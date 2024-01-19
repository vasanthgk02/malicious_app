package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import org.json.JSONObject;

public class PayPalCreditFinancingAmount implements Parcelable {
    public static final Creator<PayPalCreditFinancingAmount> CREATOR = new Creator<PayPalCreditFinancingAmount>() {
        public Object createFromParcel(Parcel parcel) {
            return new PayPalCreditFinancingAmount(parcel, null);
        }

        public Object[] newArray(int i) {
            return new PayPalCreditFinancingAmount[i];
        }
    };
    public String mCurrency;
    public String mValue;

    public PayPalCreditFinancingAmount() {
    }

    public static PayPalCreditFinancingAmount fromJson(JSONObject jSONObject) {
        String str;
        PayPalCreditFinancingAmount payPalCreditFinancingAmount = new PayPalCreditFinancingAmount();
        if (jSONObject == null) {
            return payPalCreditFinancingAmount;
        }
        String str2 = null;
        if (jSONObject.isNull("currency")) {
            str = null;
        } else {
            str = jSONObject.optString("currency", null);
        }
        payPalCreditFinancingAmount.mCurrency = str;
        if (!jSONObject.isNull(HSLCriteriaBuilder.VALUE)) {
            str2 = jSONObject.optString(HSLCriteriaBuilder.VALUE, null);
        }
        payPalCreditFinancingAmount.mValue = str2;
        return payPalCreditFinancingAmount;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("%s %s", new Object[]{this.mValue, this.mCurrency});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCurrency);
        parcel.writeString(this.mValue);
    }

    public PayPalCreditFinancingAmount(Parcel parcel, AnonymousClass1 r2) {
        this.mCurrency = parcel.readString();
        this.mValue = parcel.readString();
    }
}
