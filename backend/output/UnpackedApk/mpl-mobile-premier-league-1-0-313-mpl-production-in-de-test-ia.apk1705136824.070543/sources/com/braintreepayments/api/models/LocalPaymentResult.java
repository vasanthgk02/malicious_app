package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import co.hyperverge.hypersnapsdk.c.k;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalPaymentResult extends PaymentMethodNonce implements Parcelable {
    public static final Creator<LocalPaymentResult> CREATOR = new Creator<LocalPaymentResult>() {
        public Object createFromParcel(Parcel parcel) {
            return new LocalPaymentResult(parcel, null);
        }

        public Object[] newArray(int i) {
            return new LocalPaymentResult[i];
        }
    };
    public PostalAddress mBillingAddress;
    public String mClientMetadataId;
    public String mEmail;
    public String mGivenName;
    public String mPayerId;
    public String mPhone;
    public PostalAddress mShippingAddress;
    public String mSurname;
    public String mType;

    public LocalPaymentResult() {
    }

    public static LocalPaymentResult fromJson(String str) throws JSONException {
        String str2;
        JSONObject jSONObject;
        String str3;
        String str4;
        String str5;
        LocalPaymentResult localPaymentResult = new LocalPaymentResult();
        JSONObject jSONObject2 = new JSONObject(str).getJSONArray("paypalAccounts").getJSONObject(0);
        super.fromJson(jSONObject2);
        JSONObject jSONObject3 = jSONObject2.getJSONObject("details");
        String str6 = null;
        localPaymentResult.mEmail = k.optString(jSONObject3, "email", null);
        if (jSONObject3.isNull("correlationId")) {
            str2 = null;
        } else {
            str2 = jSONObject3.optString("correlationId", null);
        }
        localPaymentResult.mClientMetadataId = str2;
        String str7 = "PayPalAccount";
        if (!jSONObject2.isNull("type")) {
            str7 = jSONObject2.optString("type", str7);
        }
        localPaymentResult.mType = str7;
        try {
            JSONObject jSONObject4 = jSONObject3.getJSONObject("payerInfo");
            if (jSONObject4.has("accountAddress")) {
                jSONObject = jSONObject4.optJSONObject("accountAddress");
            } else {
                jSONObject = jSONObject4.optJSONObject("billingAddress");
            }
            JSONObject optJSONObject = jSONObject4.optJSONObject("shippingAddress");
            localPaymentResult.mBillingAddress = k.fromJson(jSONObject);
            localPaymentResult.mShippingAddress = k.fromJson(optJSONObject);
            String str8 = "";
            if (jSONObject4.isNull("firstName")) {
                str3 = str8;
            } else {
                str3 = jSONObject4.optString("firstName", str8);
            }
            localPaymentResult.mGivenName = str3;
            if (jSONObject4.isNull("lastName")) {
                str4 = str8;
            } else {
                str4 = jSONObject4.optString("lastName", str8);
            }
            localPaymentResult.mSurname = str4;
            if (jSONObject4.isNull("phone")) {
                str5 = str8;
            } else {
                str5 = jSONObject4.optString("phone", str8);
            }
            localPaymentResult.mPhone = str5;
            if (!jSONObject4.isNull("payerId")) {
                str8 = jSONObject4.optString("payerId", str8);
            }
            localPaymentResult.mPayerId = str8;
            if (localPaymentResult.mEmail == null) {
                if (!jSONObject4.isNull("email")) {
                    str6 = jSONObject4.optString("email", null);
                }
                localPaymentResult.mEmail = str6;
            }
        } catch (JSONException unused) {
            localPaymentResult.mBillingAddress = new PostalAddress();
            localPaymentResult.mShippingAddress = new PostalAddress();
        }
        return localPaymentResult;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getTypeLabel() {
        return this.mType;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mNonce);
        parcel.writeString(this.mDescription);
        parcel.writeByte(this.mDefault ? (byte) 1 : 0);
        parcel.writeString(this.mClientMetadataId);
        parcel.writeParcelable(this.mBillingAddress, i);
        parcel.writeParcelable(this.mShippingAddress, i);
        parcel.writeString(this.mGivenName);
        parcel.writeString(this.mSurname);
        parcel.writeString(this.mEmail);
        parcel.writeString(this.mPhone);
        parcel.writeString(this.mPayerId);
        parcel.writeString(this.mType);
    }

    public LocalPaymentResult(Parcel parcel, AnonymousClass1 r2) {
        super(parcel);
        this.mClientMetadataId = parcel.readString();
        this.mBillingAddress = (PostalAddress) parcel.readParcelable(PostalAddress.class.getClassLoader());
        this.mShippingAddress = (PostalAddress) parcel.readParcelable(PostalAddress.class.getClassLoader());
        this.mGivenName = parcel.readString();
        this.mSurname = parcel.readString();
        this.mEmail = parcel.readString();
        this.mPhone = parcel.readString();
        this.mPayerId = parcel.readString();
        this.mType = parcel.readString();
    }
}
