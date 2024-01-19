package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.appsflyer.AppsFlyerProperties;
import com.mpl.payment.routing.RoutingConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class VisaCheckoutNonce extends PaymentMethodNonce implements Parcelable {
    public static final Creator<VisaCheckoutNonce> CREATOR = new Creator<VisaCheckoutNonce>() {
        public Object createFromParcel(Parcel parcel) {
            return new VisaCheckoutNonce(parcel);
        }

        public Object[] newArray(int i) {
            return new VisaCheckoutNonce[i];
        }
    };
    public VisaCheckoutAddress mBillingAddress;
    public BinData mBinData;
    public String mCallId;
    public String mCardType;
    public String mLastTwo;
    public VisaCheckoutAddress mShippingAddress;
    public VisaCheckoutUserData mUserData;

    public VisaCheckoutNonce() {
    }

    public void fromJson(JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        super.fromJson(jSONObject);
        JSONObject jSONObject2 = jSONObject.getJSONObject("details");
        this.mLastTwo = jSONObject2.getString("lastTwo");
        this.mCardType = jSONObject2.getString(RoutingConstants.MI_REACT_SAVED_CARD_TYPE);
        this.mBillingAddress = VisaCheckoutAddress.fromJson(jSONObject.optJSONObject("billingAddress"));
        this.mShippingAddress = VisaCheckoutAddress.fromJson(jSONObject.optJSONObject("shippingAddress"));
        JSONObject optJSONObject = jSONObject.optJSONObject("userData");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        VisaCheckoutUserData visaCheckoutUserData = new VisaCheckoutUserData();
        String str6 = "";
        if (optJSONObject.isNull("userFirstName")) {
            str = str6;
        } else {
            str = optJSONObject.optString("userFirstName", str6);
        }
        visaCheckoutUserData.mUserFirstName = str;
        if (optJSONObject.isNull("userLastName")) {
            str2 = str6;
        } else {
            str2 = optJSONObject.optString("userLastName", str6);
        }
        visaCheckoutUserData.mUserLastName = str2;
        if (optJSONObject.isNull("userFullName")) {
            str3 = str6;
        } else {
            str3 = optJSONObject.optString("userFullName", str6);
        }
        visaCheckoutUserData.mUserFullName = str3;
        if (optJSONObject.isNull("userName")) {
            str4 = str6;
        } else {
            str4 = optJSONObject.optString("userName", str6);
        }
        visaCheckoutUserData.mUsername = str4;
        if (optJSONObject.isNull(AppsFlyerProperties.USER_EMAIL)) {
            str5 = str6;
        } else {
            str5 = optJSONObject.optString(AppsFlyerProperties.USER_EMAIL, str6);
        }
        visaCheckoutUserData.mUserEmail = str5;
        this.mUserData = visaCheckoutUserData;
        if (!jSONObject.isNull("callId")) {
            str6 = jSONObject.optString("callId", str6);
        }
        this.mCallId = str6;
        this.mBinData = BinData.fromJson(jSONObject.optJSONObject("binData"));
    }

    public String getTypeLabel() {
        return "Visa Checkout";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mNonce);
        parcel.writeString(this.mDescription);
        parcel.writeByte(this.mDefault ? (byte) 1 : 0);
        parcel.writeString(this.mLastTwo);
        parcel.writeString(this.mCardType);
        parcel.writeParcelable(this.mBillingAddress, i);
        parcel.writeParcelable(this.mShippingAddress, i);
        parcel.writeParcelable(this.mUserData, i);
        parcel.writeString(this.mCallId);
        parcel.writeParcelable(this.mBinData, i);
    }

    public VisaCheckoutNonce(Parcel parcel) {
        super(parcel);
        this.mLastTwo = parcel.readString();
        this.mCardType = parcel.readString();
        this.mBillingAddress = (VisaCheckoutAddress) parcel.readParcelable(VisaCheckoutAddress.class.getClassLoader());
        this.mShippingAddress = (VisaCheckoutAddress) parcel.readParcelable(VisaCheckoutAddress.class.getClassLoader());
        this.mUserData = (VisaCheckoutUserData) parcel.readParcelable(VisaCheckoutUserData.class.getClassLoader());
        this.mCallId = parcel.readString();
        this.mBinData = (BinData) parcel.readParcelable(BinData.class.getClassLoader());
    }
}
