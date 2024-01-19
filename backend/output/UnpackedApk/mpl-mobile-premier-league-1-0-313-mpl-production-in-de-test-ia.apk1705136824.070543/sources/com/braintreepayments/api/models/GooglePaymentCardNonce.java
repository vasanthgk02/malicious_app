package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.routing.RoutingConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class GooglePaymentCardNonce extends PaymentMethodNonce implements Parcelable {
    public static final Creator<GooglePaymentCardNonce> CREATOR = new Creator<GooglePaymentCardNonce>() {
        public Object createFromParcel(Parcel parcel) {
            return new GooglePaymentCardNonce(parcel, null);
        }

        public Object[] newArray(int i) {
            return new GooglePaymentCardNonce[i];
        }
    };
    public PostalAddress mBillingAddress;
    public BinData mBinData;
    public String mCardType;
    public String mEmail;
    public Boolean mIsNetworkTokenized;
    public String mLastFour;
    public String mLastTwo;
    public PostalAddress mShippingAddress;

    public GooglePaymentCardNonce() {
    }

    public static GooglePaymentCardNonce fromJson(String str) throws JSONException {
        GooglePaymentCardNonce googlePaymentCardNonce = new GooglePaymentCardNonce();
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject(k.extractPaymentMethodToken(jSONObject.toString()).getJSONArray("androidPayCards").get(0).toString());
        super.fromJson(jSONObject4);
        JSONObject jSONObject5 = jSONObject4.getJSONObject("details");
        JSONObject jSONObject6 = jSONObject.getJSONObject("paymentMethodData").getJSONObject("info");
        if (jSONObject6.has("billingAddress")) {
            jSONObject2 = jSONObject6.getJSONObject("billingAddress");
        }
        if (jSONObject.has("shippingAddress")) {
            jSONObject3 = jSONObject.getJSONObject("shippingAddress");
        }
        googlePaymentCardNonce.mDescription = jSONObject.getJSONObject("paymentMethodData").get("description").toString();
        String str2 = "";
        if (!jSONObject.isNull("email")) {
            str2 = jSONObject.optString("email", str2);
        }
        googlePaymentCardNonce.mEmail = str2;
        googlePaymentCardNonce.mBillingAddress = postalAddressFromJson(jSONObject2);
        googlePaymentCardNonce.mShippingAddress = postalAddressFromJson(jSONObject3);
        googlePaymentCardNonce.mBinData = BinData.fromJson(jSONObject.optJSONObject("binData"));
        googlePaymentCardNonce.mLastTwo = jSONObject5.getString("lastTwo");
        googlePaymentCardNonce.mLastFour = jSONObject5.getString("lastFour");
        googlePaymentCardNonce.mCardType = jSONObject5.getString(RoutingConstants.MI_REACT_SAVED_CARD_TYPE);
        googlePaymentCardNonce.mIsNetworkTokenized = Boolean.valueOf(jSONObject5.optBoolean("isNetworkTokenized", false));
        return googlePaymentCardNonce;
    }

    public static PostalAddress postalAddressFromJson(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        PostalAddress postalAddress = new PostalAddress();
        String str12 = "";
        if (jSONObject.isNull("name")) {
            str = str12;
        } else {
            str = jSONObject.optString("name", str12);
        }
        postalAddress.mRecipientName = str;
        if (jSONObject.isNull(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER)) {
            str2 = str12;
        } else {
            str2 = jSONObject.optString(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER, str12);
        }
        postalAddress.mPhoneNumber = str2;
        if (jSONObject.isNull("address1")) {
            str3 = str12;
        } else {
            str3 = jSONObject.optString("address1", str12);
        }
        postalAddress.mStreetAddress = str3;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(str12);
        if (jSONObject.isNull("address2")) {
            str4 = str12;
        } else {
            str4 = jSONObject.optString("address2", str12);
        }
        outline73.append(str4);
        outline73.append("\n");
        if (jSONObject.isNull("address3")) {
            str5 = str12;
        } else {
            str5 = jSONObject.optString("address3", str12);
        }
        outline73.append(str5);
        outline73.append("\n");
        if (jSONObject.isNull("address4")) {
            str6 = str12;
        } else {
            str6 = jSONObject.optString("address4", str12);
        }
        outline73.append(str6);
        outline73.append("\n");
        if (jSONObject.isNull("address5")) {
            str7 = str12;
        } else {
            str7 = jSONObject.optString("address5", str12);
        }
        outline73.append(str7);
        postalAddress.mExtendedAddress = outline73.toString().trim();
        if (jSONObject.isNull("locality")) {
            str8 = str12;
        } else {
            str8 = jSONObject.optString("locality", str12);
        }
        postalAddress.mLocality = str8;
        if (jSONObject.isNull("administrativeArea")) {
            str9 = str12;
        } else {
            str9 = jSONObject.optString("administrativeArea", str12);
        }
        postalAddress.mRegion = str9;
        if (jSONObject.isNull("countryCode")) {
            str10 = str12;
        } else {
            str10 = jSONObject.optString("countryCode", str12);
        }
        postalAddress.mCountryCodeAlpha2 = str10;
        if (jSONObject.isNull(RoutingConstants.MI_REACT_POSTAL_CODE)) {
            str11 = str12;
        } else {
            str11 = jSONObject.optString(RoutingConstants.MI_REACT_POSTAL_CODE, str12);
        }
        postalAddress.mPostalCode = str11;
        if (!jSONObject.isNull("sortingCode")) {
            str12 = jSONObject.optString("sortingCode", str12);
        }
        postalAddress.mSortingCode = str12;
        return postalAddress;
    }

    public String getTypeLabel() {
        return "Google Pay";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mNonce);
        parcel.writeString(this.mDescription);
        parcel.writeByte(this.mDefault ? (byte) 1 : 0);
        parcel.writeString(this.mCardType);
        parcel.writeString(this.mLastTwo);
        parcel.writeString(this.mLastFour);
        parcel.writeString(this.mEmail);
        parcel.writeParcelable(this.mBillingAddress, i);
        parcel.writeParcelable(this.mShippingAddress, i);
        parcel.writeParcelable(this.mBinData, i);
    }

    public GooglePaymentCardNonce(Parcel parcel, AnonymousClass1 r2) {
        super(parcel);
        this.mCardType = parcel.readString();
        this.mLastTwo = parcel.readString();
        this.mLastFour = parcel.readString();
        this.mEmail = parcel.readString();
        this.mBillingAddress = (PostalAddress) parcel.readParcelable(PostalAddress.class.getClassLoader());
        this.mShippingAddress = (PostalAddress) parcel.readParcelable(PostalAddress.class.getClassLoader());
        this.mBinData = (BinData) parcel.readParcelable(BinData.class.getClassLoader());
    }
}
