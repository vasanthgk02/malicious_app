package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class PayPalCreditFinancing implements Parcelable {
    public static final Creator<PayPalCreditFinancing> CREATOR = new Creator<PayPalCreditFinancing>() {
        public Object createFromParcel(Parcel parcel) {
            return new PayPalCreditFinancing(parcel, null);
        }

        public Object[] newArray(int i) {
            return new PayPalCreditFinancing[i];
        }
    };
    public boolean mCardAmountImmutable;
    public PayPalCreditFinancingAmount mMonthlyPayment;
    public boolean mPayerAcceptance;
    public int mTerm;
    public PayPalCreditFinancingAmount mTotalCost;
    public PayPalCreditFinancingAmount mTotalInterest;

    public PayPalCreditFinancing() {
    }

    public static PayPalCreditFinancing fromJson(JSONObject jSONObject) throws JSONException {
        PayPalCreditFinancing payPalCreditFinancing = new PayPalCreditFinancing();
        if (jSONObject == null) {
            return payPalCreditFinancing;
        }
        payPalCreditFinancing.mCardAmountImmutable = jSONObject.optBoolean("cardAmountImmutable", false);
        payPalCreditFinancing.mMonthlyPayment = PayPalCreditFinancingAmount.fromJson(jSONObject.getJSONObject("monthlyPayment"));
        payPalCreditFinancing.mPayerAcceptance = jSONObject.optBoolean("payerAcceptance", false);
        payPalCreditFinancing.mTerm = jSONObject.optInt("term", 0);
        payPalCreditFinancing.mTotalCost = PayPalCreditFinancingAmount.fromJson(jSONObject.getJSONObject("totalCost"));
        payPalCreditFinancing.mTotalInterest = PayPalCreditFinancingAmount.fromJson(jSONObject.getJSONObject("totalInterest"));
        return payPalCreditFinancing;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.mCardAmountImmutable ? (byte) 1 : 0);
        parcel.writeParcelable(this.mMonthlyPayment, i);
        parcel.writeByte(this.mPayerAcceptance ? (byte) 1 : 0);
        parcel.writeInt(this.mTerm);
        parcel.writeParcelable(this.mTotalCost, i);
        parcel.writeParcelable(this.mTotalInterest, i);
    }

    public PayPalCreditFinancing(Parcel parcel, AnonymousClass1 r4) {
        boolean z = false;
        this.mCardAmountImmutable = parcel.readByte() != 0;
        this.mMonthlyPayment = (PayPalCreditFinancingAmount) parcel.readParcelable(PayPalCreditFinancingAmount.class.getClassLoader());
        this.mPayerAcceptance = parcel.readByte() != 0 ? true : z;
        this.mTerm = parcel.readInt();
        this.mTotalCost = (PayPalCreditFinancingAmount) parcel.readParcelable(PayPalCreditFinancingAmount.class.getClassLoader());
        this.mTotalInterest = (PayPalCreditFinancingAmount) parcel.readParcelable(PayPalCreditFinancingAmount.class.getClassLoader());
    }
}
