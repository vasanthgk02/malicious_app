package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PaymentMethodNonce implements Parcelable {
    public boolean mDefault;
    public String mDescription;
    public String mNonce;

    public PaymentMethodNonce() {
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.braintreepayments.api.models.PaymentMethodNonce parsePaymentMethodNonces(org.json.JSONObject r7, java.lang.String r8) throws org.json.JSONException {
        /*
            int r0 = r8.hashCode()
            r1 = 2
            r2 = 0
            r3 = 1
            r4 = 3
            switch(r0) {
                case -1807185524: goto L_0x002a;
                case -650599305: goto L_0x0020;
                case 1212590010: goto L_0x0016;
                case 1428640201: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0034
        L_0x000c:
            java.lang.String r0 = "CreditCard"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0034
            r8 = 0
            goto L_0x0035
        L_0x0016:
            java.lang.String r0 = "PayPalAccount"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0034
            r8 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "VisaCheckoutCard"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0034
            r8 = 3
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "VenmoAccount"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0034
            r8 = 2
            goto L_0x0035
        L_0x0034:
            r8 = -1
        L_0x0035:
            r0 = 0
            if (r8 == 0) goto L_0x009e
            if (r8 == r3) goto L_0x0084
            if (r8 == r1) goto L_0x006a
            if (r8 == r4) goto L_0x003f
            return r0
        L_0x003f:
            java.lang.String r8 = "visaCheckoutCards"
            boolean r0 = r7.has(r8)
            if (r0 == 0) goto L_0x0061
            java.lang.String r7 = r7.toString()
            com.braintreepayments.api.models.VisaCheckoutNonce r0 = new com.braintreepayments.api.models.VisaCheckoutNonce
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>(r7)
            org.json.JSONArray r7 = r1.getJSONArray(r8)
            org.json.JSONObject r7 = r7.getJSONObject(r2)
            r0.fromJson(r7)
            return r0
        L_0x0061:
            com.braintreepayments.api.models.VisaCheckoutNonce r8 = new com.braintreepayments.api.models.VisaCheckoutNonce
            r8.<init>()
            r8.fromJson(r7)
            return r8
        L_0x006a:
            java.lang.String r8 = "venmoAccounts"
            boolean r8 = r7.has(r8)
            if (r8 == 0) goto L_0x007b
            java.lang.String r7 = r7.toString()
            com.braintreepayments.api.models.VenmoAccountNonce r7 = com.braintreepayments.api.models.VenmoAccountNonce.fromJson(r7)
            return r7
        L_0x007b:
            com.braintreepayments.api.models.VenmoAccountNonce r8 = new com.braintreepayments.api.models.VenmoAccountNonce
            r8.<init>()
            r8.fromJson(r7)
            return r8
        L_0x0084:
            java.lang.String r8 = "paypalAccounts"
            boolean r8 = r7.has(r8)
            if (r8 == 0) goto L_0x0095
            java.lang.String r7 = r7.toString()
            com.braintreepayments.api.models.PayPalAccountNonce r7 = com.braintreepayments.api.models.PayPalAccountNonce.fromJson(r7)
            return r7
        L_0x0095:
            com.braintreepayments.api.models.PayPalAccountNonce r8 = new com.braintreepayments.api.models.PayPalAccountNonce
            r8.<init>()
            r8.fromJson(r7)
            return r8
        L_0x009e:
            java.lang.String r8 = "creditCards"
            boolean r3 = r7.has(r8)
            java.lang.String r4 = "data"
            if (r3 != 0) goto L_0x00b8
            boolean r3 = r7.has(r4)
            if (r3 == 0) goto L_0x00af
            goto L_0x00b8
        L_0x00af:
            com.braintreepayments.api.models.CardNonce r8 = new com.braintreepayments.api.models.CardNonce
            r8.<init>()
            r8.fromJson(r7)
            return r8
        L_0x00b8:
            java.lang.String r7 = r7.toString()
            com.braintreepayments.api.models.CardNonce r3 = new com.braintreepayments.api.models.CardNonce
            r3.<init>()
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>(r7)
            boolean r7 = r5.has(r4)
            if (r7 == 0) goto L_0x0195
            org.json.JSONObject r7 = r5.getJSONObject(r4)
            java.lang.String r8 = "tokenizeCreditCard"
            boolean r4 = r7.has(r8)
            if (r4 == 0) goto L_0x018d
            org.json.JSONObject r7 = r7.getJSONObject(r8)
            java.lang.String r8 = "creditCard"
            org.json.JSONObject r8 = r7.getJSONObject(r8)
            java.lang.String r4 = ""
            java.lang.String r5 = "last4"
            java.lang.String r5 = co.hyperverge.hypersnapsdk.c.k.optString(r8, r5, r4)
            r3.mLastFour = r5
            int r5 = r5.length()
            r6 = 4
            if (r5 >= r6) goto L_0x00f5
            r1 = r4
            goto L_0x00fb
        L_0x00f5:
            java.lang.String r5 = r3.mLastFour
            java.lang.String r1 = r5.substring(r1)
        L_0x00fb:
            r3.mLastTwo = r1
            java.lang.String r1 = "brand"
            java.lang.String r5 = "Unknown"
            boolean r6 = r8.isNull(r1)
            if (r6 == 0) goto L_0x0108
            goto L_0x010c
        L_0x0108:
            java.lang.String r5 = r8.optString(r1, r5)
        L_0x010c:
            r3.mCardType = r5
            com.braintreepayments.api.models.ThreeDSecureInfo r0 = com.braintreepayments.api.models.ThreeDSecureInfo.fromJson(r0)
            r3.mThreeDSecureInfo = r0
            java.lang.String r0 = "bin"
            boolean r1 = r8.isNull(r0)
            if (r1 == 0) goto L_0x011d
            goto L_0x0120
        L_0x011d:
            r8.optString(r0, r4)
        L_0x0120:
            java.lang.String r0 = "binData"
            org.json.JSONObject r0 = r8.optJSONObject(r0)
            com.braintreepayments.api.models.BinData r0 = com.braintreepayments.api.models.BinData.fromJson(r0)
            r3.mBinData = r0
            java.lang.String r0 = "token"
            java.lang.String r0 = r7.getString(r0)
            r3.mNonce = r0
            java.lang.String r0 = r3.mLastTwo
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x013e
            r0 = r4
            goto L_0x014d
        L_0x013e:
            java.lang.String r0 = "ending in ••"
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = r3.mLastTwo
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x014d:
            r3.mDescription = r0
            r3.mDefault = r2
            java.lang.String r0 = "authenticationInsight"
            org.json.JSONObject r7 = r7.optJSONObject(r0)
            com.braintreepayments.api.models.AuthenticationInsight r7 = com.braintreepayments.api.models.AuthenticationInsight.fromJson(r7)
            r3.mAuthenticationInsight = r7
            java.lang.String r7 = "expirationMonth"
            boolean r0 = r8.isNull(r7)
            if (r0 == 0) goto L_0x0167
            r7 = r4
            goto L_0x016b
        L_0x0167:
            java.lang.String r7 = r8.optString(r7, r4)
        L_0x016b:
            r3.mExpirationMonth = r7
            java.lang.String r7 = "expirationYear"
            boolean r0 = r8.isNull(r7)
            if (r0 == 0) goto L_0x0177
            r7 = r4
            goto L_0x017b
        L_0x0177:
            java.lang.String r7 = r8.optString(r7, r4)
        L_0x017b:
            r3.mExpirationYear = r7
            java.lang.String r7 = "cardholderName"
            boolean r0 = r8.isNull(r7)
            if (r0 == 0) goto L_0x0186
            goto L_0x018a
        L_0x0186:
            java.lang.String r4 = r8.optString(r7, r4)
        L_0x018a:
            r3.mCardholderName = r4
            goto L_0x01a0
        L_0x018d:
            org.json.JSONException r7 = new org.json.JSONException
            java.lang.String r8 = "Failed to parse GraphQL response JSON"
            r7.<init>(r8)
            throw r7
        L_0x0195:
            org.json.JSONArray r7 = r5.getJSONArray(r8)
            org.json.JSONObject r7 = r7.getJSONObject(r2)
            r3.fromJson(r7)
        L_0x01a0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.models.PaymentMethodNonce.parsePaymentMethodNonces(org.json.JSONObject, java.lang.String):com.braintreepayments.api.models.PaymentMethodNonce");
    }

    public int describeContents() {
        return 0;
    }

    public void fromJson(JSONObject jSONObject) throws JSONException {
        this.mNonce = jSONObject.getString("nonce");
        this.mDescription = jSONObject.getString("description");
        this.mDefault = jSONObject.optBoolean("default", false);
    }

    public String getDescription() {
        return this.mDescription;
    }

    public abstract String getTypeLabel();

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mNonce);
        parcel.writeString(this.mDescription);
        parcel.writeByte(this.mDefault ? (byte) 1 : 0);
    }

    public PaymentMethodNonce(Parcel parcel) {
        this.mNonce = parcel.readString();
        this.mDescription = parcel.readString();
        this.mDefault = parcel.readByte() > 0;
    }
}
