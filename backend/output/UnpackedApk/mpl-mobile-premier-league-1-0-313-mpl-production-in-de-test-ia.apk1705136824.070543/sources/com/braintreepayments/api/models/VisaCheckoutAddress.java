package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mpl.payment.routing.RoutingConstants;
import org.json.JSONObject;

public class VisaCheckoutAddress implements Parcelable {
    public static final Creator<VisaCheckoutAddress> CREATOR = new Creator<VisaCheckoutAddress>() {
        public Object createFromParcel(Parcel parcel) {
            return new VisaCheckoutAddress(parcel);
        }

        public Object[] newArray(int i) {
            return new VisaCheckoutAddress[i];
        }
    };
    public String mCountryCode;
    public String mExtendedAddress;
    public String mFirstName;
    public String mLastName;
    public String mLocality;
    public String mPhoneNumber;
    public String mPostalCode;
    public String mRegion;
    public String mStreetAddress;

    public VisaCheckoutAddress() {
    }

    public static VisaCheckoutAddress fromJson(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        VisaCheckoutAddress visaCheckoutAddress = new VisaCheckoutAddress();
        String str9 = "";
        if (jSONObject.isNull("firstName")) {
            str = str9;
        } else {
            str = jSONObject.optString("firstName", str9);
        }
        visaCheckoutAddress.mFirstName = str;
        if (jSONObject.isNull("lastName")) {
            str2 = str9;
        } else {
            str2 = jSONObject.optString("lastName", str9);
        }
        visaCheckoutAddress.mLastName = str2;
        if (jSONObject.isNull("streetAddress")) {
            str3 = str9;
        } else {
            str3 = jSONObject.optString("streetAddress", str9);
        }
        visaCheckoutAddress.mStreetAddress = str3;
        if (jSONObject.isNull("extendedAddress")) {
            str4 = str9;
        } else {
            str4 = jSONObject.optString("extendedAddress", str9);
        }
        visaCheckoutAddress.mExtendedAddress = str4;
        if (jSONObject.isNull("locality")) {
            str5 = str9;
        } else {
            str5 = jSONObject.optString("locality", str9);
        }
        visaCheckoutAddress.mLocality = str5;
        if (jSONObject.isNull("region")) {
            str6 = str9;
        } else {
            str6 = jSONObject.optString("region", str9);
        }
        visaCheckoutAddress.mRegion = str6;
        if (jSONObject.isNull(RoutingConstants.MI_REACT_POSTAL_CODE)) {
            str7 = str9;
        } else {
            str7 = jSONObject.optString(RoutingConstants.MI_REACT_POSTAL_CODE, str9);
        }
        visaCheckoutAddress.mPostalCode = str7;
        if (jSONObject.isNull("countryCode")) {
            str8 = str9;
        } else {
            str8 = jSONObject.optString("countryCode", str9);
        }
        visaCheckoutAddress.mCountryCode = str8;
        if (!jSONObject.isNull(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER)) {
            str9 = jSONObject.optString(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER, str9);
        }
        visaCheckoutAddress.mPhoneNumber = str9;
        return visaCheckoutAddress;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mFirstName);
        parcel.writeString(this.mLastName);
        parcel.writeString(this.mStreetAddress);
        parcel.writeString(this.mExtendedAddress);
        parcel.writeString(this.mLocality);
        parcel.writeString(this.mRegion);
        parcel.writeString(this.mPostalCode);
        parcel.writeString(this.mCountryCode);
        parcel.writeString(this.mPhoneNumber);
    }

    public VisaCheckoutAddress(Parcel parcel) {
        this.mFirstName = parcel.readString();
        this.mLastName = parcel.readString();
        this.mStreetAddress = parcel.readString();
        this.mExtendedAddress = parcel.readString();
        this.mLocality = parcel.readString();
        this.mRegion = parcel.readString();
        this.mPostalCode = parcel.readString();
        this.mCountryCode = parcel.readString();
        this.mPhoneNumber = parcel.readString();
    }
}
