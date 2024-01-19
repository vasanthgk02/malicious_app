package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PostalAddress implements Parcelable {
    public static final Creator<PostalAddress> CREATOR = new Creator<PostalAddress>() {
        public Object createFromParcel(Parcel parcel) {
            return new PostalAddress(parcel, null);
        }

        public Object[] newArray(int i) {
            return new PostalAddress[i];
        }
    };
    public String mCountryCodeAlpha2;
    public String mExtendedAddress;
    public String mLocality;
    public String mPhoneNumber;
    public String mPostalCode;
    public String mRecipientName;
    public String mRegion;
    public String mSortingCode;
    public String mStreetAddress;

    public PostalAddress() {
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("%s\n%s\n%s\n%s, %s\n%s %s", new Object[]{this.mRecipientName, this.mStreetAddress, this.mExtendedAddress, this.mLocality, this.mRegion, this.mPostalCode, this.mCountryCodeAlpha2});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mStreetAddress);
        parcel.writeString(this.mExtendedAddress);
        parcel.writeString(this.mLocality);
        parcel.writeString(this.mRegion);
        parcel.writeString(this.mPostalCode);
        parcel.writeString(this.mCountryCodeAlpha2);
        parcel.writeString(this.mRecipientName);
        parcel.writeString(this.mPhoneNumber);
        parcel.writeString(this.mSortingCode);
    }

    public PostalAddress(Parcel parcel, AnonymousClass1 r2) {
        this.mStreetAddress = parcel.readString();
        this.mExtendedAddress = parcel.readString();
        this.mLocality = parcel.readString();
        this.mRegion = parcel.readString();
        this.mPostalCode = parcel.readString();
        this.mCountryCodeAlpha2 = parcel.readString();
        this.mRecipientName = parcel.readString();
        this.mPhoneNumber = parcel.readString();
        this.mSortingCode = parcel.readString();
    }
}
