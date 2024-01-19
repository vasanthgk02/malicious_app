package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VisaCheckoutUserData implements Parcelable {
    public static final Creator<VisaCheckoutUserData> CREATOR = new Creator<VisaCheckoutUserData>() {
        public Object createFromParcel(Parcel parcel) {
            return new VisaCheckoutUserData(parcel);
        }

        public Object[] newArray(int i) {
            return new VisaCheckoutUserData[i];
        }
    };
    public String mUserEmail;
    public String mUserFirstName;
    public String mUserFullName;
    public String mUserLastName;
    public String mUsername;

    public VisaCheckoutUserData() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mUserFirstName);
        parcel.writeString(this.mUserLastName);
        parcel.writeString(this.mUserFullName);
        parcel.writeString(this.mUsername);
        parcel.writeString(this.mUserEmail);
    }

    public VisaCheckoutUserData(Parcel parcel) {
        this.mUserFirstName = parcel.readString();
        this.mUserLastName = parcel.readString();
        this.mUserFullName = parcel.readString();
        this.mUsername = parcel.readString();
        this.mUserEmail = parcel.readString();
    }
}
