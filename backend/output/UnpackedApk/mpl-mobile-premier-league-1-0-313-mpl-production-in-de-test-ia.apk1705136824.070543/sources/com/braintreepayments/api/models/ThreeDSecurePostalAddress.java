package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ThreeDSecurePostalAddress implements Parcelable {
    public static final Creator<ThreeDSecurePostalAddress> CREATOR = new Creator<ThreeDSecurePostalAddress>() {
        public Object createFromParcel(Parcel parcel) {
            return new ThreeDSecurePostalAddress(parcel);
        }

        public Object[] newArray(int i) {
            return new ThreeDSecurePostalAddress[i];
        }
    };
    public String mCountryCodeAlpha2;
    public String mExtendedAddress;
    public String mGivenName;
    public String mLine3;
    public String mLocality;
    public String mPhoneNumber;
    public String mPostalCode;
    public String mRegion;
    public String mStreetAddress;
    public String mSurname;

    public ThreeDSecurePostalAddress() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mGivenName);
        parcel.writeString(this.mSurname);
        parcel.writeString(this.mStreetAddress);
        parcel.writeString(this.mExtendedAddress);
        parcel.writeString(this.mLine3);
        parcel.writeString(this.mLocality);
        parcel.writeString(this.mRegion);
        parcel.writeString(this.mPostalCode);
        parcel.writeString(this.mCountryCodeAlpha2);
        parcel.writeString(this.mPhoneNumber);
    }

    public ThreeDSecurePostalAddress(Parcel parcel) {
        this.mGivenName = parcel.readString();
        this.mSurname = parcel.readString();
        this.mStreetAddress = parcel.readString();
        this.mExtendedAddress = parcel.readString();
        this.mLine3 = parcel.readString();
        this.mLocality = parcel.readString();
        this.mRegion = parcel.readString();
        this.mPostalCode = parcel.readString();
        this.mCountryCodeAlpha2 = parcel.readString();
        this.mPhoneNumber = parcel.readString();
    }
}
