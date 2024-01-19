package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.mpl.payment.routing.RoutingConstants;
import com.paynimo.android.payment.UPIFragment;
import com.rudderstack.android.sdk.core.RudderTraits;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseCardBuilder<T> extends PaymentMethodBuilder<T> implements Parcelable {
    public String mCardholderName;
    public String mCardnumber;
    public String mCompany;
    public String mCountryCode;
    public String mCvv;
    public String mExpirationMonth;
    public String mExpirationYear;
    public String mExtendedAddress;
    public String mFirstName;
    public String mLastName;
    public String mLocality;
    public String mPostalCode;
    public String mRegion;
    public String mStreetAddress;

    public BaseCardBuilder() {
    }

    public void build(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        jSONObject2.put(UPIFragment.CONFIG_TYPE_NUMBER, this.mCardnumber);
        jSONObject2.put("cvv", this.mCvv);
        jSONObject2.put("expirationMonth", this.mExpirationMonth);
        jSONObject2.put("expirationYear", this.mExpirationYear);
        jSONObject2.put("cardholderName", this.mCardholderName);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("firstName", this.mFirstName);
        jSONObject3.put("lastName", this.mLastName);
        jSONObject3.put(RudderTraits.COMPANY_KEY, this.mCompany);
        jSONObject3.put("locality", this.mLocality);
        jSONObject3.put(RoutingConstants.MI_REACT_POSTAL_CODE, this.mPostalCode);
        jSONObject3.put("region", this.mRegion);
        jSONObject3.put("streetAddress", this.mStreetAddress);
        jSONObject3.put("extendedAddress", this.mExtendedAddress);
        String str = this.mCountryCode;
        if (str != null) {
            jSONObject3.put("countryCodeAlpha3", str);
        }
        if (jSONObject3.length() > 0) {
            jSONObject2.put("billingAddress", jSONObject3);
        }
        jSONObject.put("creditCard", jSONObject2);
    }

    public T cardNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mCardnumber = null;
        } else {
            this.mCardnumber = str;
        }
        return this;
    }

    public T cvv(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mCvv = null;
        } else {
            this.mCvv = str;
        }
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public T expirationMonth(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mExpirationMonth = null;
        } else {
            this.mExpirationMonth = str;
        }
        return this;
    }

    public T expirationYear(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mExpirationYear = null;
        } else {
            this.mExpirationYear = str;
        }
        return this;
    }

    public String getApiPath() {
        return "credit_cards";
    }

    public String getResponsePaymentMethodType() {
        return "CreditCard";
    }

    public T postalCode(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mPostalCode = null;
        } else {
            this.mPostalCode = str;
        }
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mIntegration);
        parcel.writeString(this.mSource);
        parcel.writeByte(this.mValidate ? (byte) 1 : 0);
        parcel.writeByte(this.mValidateSet ? (byte) 1 : 0);
        parcel.writeString(this.mSessionId);
        parcel.writeString(this.mCardnumber);
        parcel.writeString(this.mCvv);
        parcel.writeString(this.mExpirationMonth);
        parcel.writeString(this.mExpirationYear);
        parcel.writeString(this.mCardholderName);
        parcel.writeString(this.mFirstName);
        parcel.writeString(this.mLastName);
        parcel.writeString(this.mCompany);
        parcel.writeString(this.mCountryCode);
        parcel.writeString(this.mLocality);
        parcel.writeString(this.mPostalCode);
        parcel.writeString(this.mRegion);
        parcel.writeString(this.mStreetAddress);
        parcel.writeString(this.mExtendedAddress);
    }

    public BaseCardBuilder(Parcel parcel) {
        super(parcel);
        this.mCardnumber = parcel.readString();
        this.mCvv = parcel.readString();
        this.mExpirationMonth = parcel.readString();
        this.mExpirationYear = parcel.readString();
        this.mCardholderName = parcel.readString();
        this.mFirstName = parcel.readString();
        this.mLastName = parcel.readString();
        this.mCompany = parcel.readString();
        this.mCountryCode = parcel.readString();
        this.mLocality = parcel.readString();
        this.mPostalCode = parcel.readString();
        this.mRegion = parcel.readString();
        this.mStreetAddress = parcel.readString();
        this.mExtendedAddress = parcel.readString();
    }
}
