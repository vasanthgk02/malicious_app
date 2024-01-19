package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import co.hyperverge.hypersnapsdk.c.k;
import org.json.JSONException;
import org.json.JSONObject;

public class PayPalAccountNonce extends PaymentMethodNonce implements Parcelable {
    public static final Creator<PayPalAccountNonce> CREATOR = new Creator<PayPalAccountNonce>() {
        public Object createFromParcel(Parcel parcel) {
            return new PayPalAccountNonce(parcel, null);
        }

        public Object[] newArray(int i) {
            return new PayPalAccountNonce[i];
        }
    };
    public String mAuthenticateUrl;
    public PostalAddress mBillingAddress;
    public String mClientMetadataId;
    public PayPalCreditFinancing mCreditFinancing;
    public String mEmail;
    public String mFirstName;
    public String mLastName;
    public String mPayerId;
    public String mPhone;
    public PostalAddress mShippingAddress;

    public PayPalAccountNonce() {
    }

    public static PayPalAccountNonce fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        PayPalAccountNonce payPalAccountNonce = new PayPalAccountNonce();
        if (jSONObject.has("paypalAccounts")) {
            payPalAccountNonce.fromJson(jSONObject.getJSONArray("paypalAccounts").getJSONObject(0));
        } else if (jSONObject.has("paymentMethodData")) {
            payPalAccountNonce.fromJson(new JSONObject(new JSONObject(str).getJSONObject("paymentMethodData").getJSONObject("tokenizationData").getString("token")).getJSONArray("paypalAccounts").getJSONObject(0));
            JSONObject optJSONObject = jSONObject.optJSONObject("shippingAddress");
            if (optJSONObject != null) {
                payPalAccountNonce.mShippingAddress = k.fromJson(optJSONObject);
            }
        } else {
            throw new JSONException("Could not parse JSON for a payment method nonce");
        }
        return payPalAccountNonce;
    }

    public String getDescription() {
        if (!TextUtils.equals(this.mDescription, "PayPal") || TextUtils.isEmpty(this.mEmail)) {
            return this.mDescription;
        }
        return this.mEmail;
    }

    public String getTypeLabel() {
        return "PayPal";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mNonce);
        parcel.writeString(this.mDescription);
        parcel.writeByte(this.mDefault ? (byte) 1 : 0);
        parcel.writeString(this.mClientMetadataId);
        parcel.writeParcelable(this.mBillingAddress, i);
        parcel.writeParcelable(this.mShippingAddress, i);
        parcel.writeString(this.mFirstName);
        parcel.writeString(this.mLastName);
        parcel.writeString(this.mEmail);
        parcel.writeString(this.mPhone);
        parcel.writeString(this.mPayerId);
        parcel.writeParcelable(this.mCreditFinancing, i);
        parcel.writeString(this.mAuthenticateUrl);
    }

    public PayPalAccountNonce(Parcel parcel, AnonymousClass1 r2) {
        super(parcel);
        this.mClientMetadataId = parcel.readString();
        this.mBillingAddress = (PostalAddress) parcel.readParcelable(PostalAddress.class.getClassLoader());
        this.mShippingAddress = (PostalAddress) parcel.readParcelable(PostalAddress.class.getClassLoader());
        this.mFirstName = parcel.readString();
        this.mLastName = parcel.readString();
        this.mEmail = parcel.readString();
        this.mPhone = parcel.readString();
        this.mPayerId = parcel.readString();
        this.mCreditFinancing = (PayPalCreditFinancing) parcel.readParcelable(PayPalCreditFinancing.class.getClassLoader());
        this.mAuthenticateUrl = parcel.readString();
    }

    public void fromJson(JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        super.fromJson(jSONObject);
        String str6 = null;
        if (jSONObject.isNull("authenticateUrl")) {
            str = null;
        } else {
            str = jSONObject.optString("authenticateUrl", null);
        }
        this.mAuthenticateUrl = str;
        JSONObject jSONObject2 = jSONObject.getJSONObject("details");
        this.mEmail = k.optString(jSONObject2, "email", null);
        if (jSONObject2.isNull("correlationId")) {
            str2 = null;
        } else {
            str2 = jSONObject2.optString("correlationId", null);
        }
        this.mClientMetadataId = str2;
        try {
            if (jSONObject2.has("creditFinancingOffered")) {
                this.mCreditFinancing = PayPalCreditFinancing.fromJson(jSONObject2.getJSONObject("creditFinancingOffered"));
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("payerInfo");
            JSONObject optJSONObject = jSONObject3.optJSONObject("billingAddress");
            if (jSONObject3.has("accountAddress")) {
                optJSONObject = jSONObject3.optJSONObject("accountAddress");
            }
            this.mShippingAddress = k.fromJson(jSONObject3.optJSONObject("shippingAddress"));
            this.mBillingAddress = k.fromJson(optJSONObject);
            String str7 = "";
            if (jSONObject3.isNull("firstName")) {
                str3 = str7;
            } else {
                str3 = jSONObject3.optString("firstName", str7);
            }
            this.mFirstName = str3;
            if (jSONObject3.isNull("lastName")) {
                str4 = str7;
            } else {
                str4 = jSONObject3.optString("lastName", str7);
            }
            this.mLastName = str4;
            if (jSONObject3.isNull("phone")) {
                str5 = str7;
            } else {
                str5 = jSONObject3.optString("phone", str7);
            }
            this.mPhone = str5;
            if (!jSONObject3.isNull("payerId")) {
                str7 = jSONObject3.optString("payerId", str7);
            }
            this.mPayerId = str7;
            if (this.mEmail == null) {
                if (!jSONObject3.isNull("email")) {
                    str6 = jSONObject3.optString("email", null);
                }
                this.mEmail = str6;
            }
        } catch (JSONException unused) {
            this.mBillingAddress = new PostalAddress();
            this.mShippingAddress = new PostalAddress();
        }
    }
}
