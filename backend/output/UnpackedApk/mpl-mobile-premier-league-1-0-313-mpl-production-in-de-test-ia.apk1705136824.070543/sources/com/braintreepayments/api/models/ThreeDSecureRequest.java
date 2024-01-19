package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;

public class ThreeDSecureRequest implements Parcelable {
    public static final Creator<ThreeDSecureRequest> CREATOR = new Creator<ThreeDSecureRequest>() {
        public Object createFromParcel(Parcel parcel) {
            return new ThreeDSecureRequest(parcel);
        }

        public Object[] newArray(int i) {
            return new ThreeDSecureRequest[i];
        }
    };
    public String mAccountType;
    public ThreeDSecureAdditionalInformation mAdditionalInformation;
    public String mAmount;
    public ThreeDSecurePostalAddress mBillingAddress;
    public boolean mChallengeRequested;
    public boolean mDataOnlyRequested;
    public String mEmail;
    public boolean mExemptionRequested;
    public String mMobilePhoneNumber;
    public String mNonce;
    public String mShippingMethod;
    public UiCustomization mUiCustomization;
    public ThreeDSecureV1UiCustomization mV1UiCustomization;
    public String mVersionRequested;

    public ThreeDSecureRequest() {
        this.mVersionRequested = "1";
        this.mChallengeRequested = false;
        this.mDataOnlyRequested = false;
        this.mExemptionRequested = false;
        this.mUiCustomization = new UiCustomization();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mNonce);
        parcel.writeString(this.mAmount);
        parcel.writeString(this.mMobilePhoneNumber);
        parcel.writeString(this.mEmail);
        parcel.writeString(this.mShippingMethod);
        parcel.writeParcelable(this.mBillingAddress, i);
        parcel.writeString(this.mVersionRequested);
        parcel.writeParcelable(this.mAdditionalInformation, i);
        parcel.writeByte(this.mChallengeRequested ? (byte) 1 : 0);
        parcel.writeByte(this.mDataOnlyRequested ? (byte) 1 : 0);
        parcel.writeByte(this.mExemptionRequested ? (byte) 1 : 0);
        parcel.writeSerializable(this.mUiCustomization);
        parcel.writeParcelable(this.mV1UiCustomization, i);
        parcel.writeString(this.mAccountType);
    }

    public ThreeDSecureRequest(Parcel parcel) {
        this.mVersionRequested = "1";
        boolean z = false;
        this.mChallengeRequested = false;
        this.mDataOnlyRequested = false;
        this.mExemptionRequested = false;
        this.mNonce = parcel.readString();
        this.mAmount = parcel.readString();
        this.mMobilePhoneNumber = parcel.readString();
        this.mEmail = parcel.readString();
        this.mShippingMethod = parcel.readString();
        this.mBillingAddress = (ThreeDSecurePostalAddress) parcel.readParcelable(ThreeDSecurePostalAddress.class.getClassLoader());
        this.mVersionRequested = parcel.readString();
        this.mAdditionalInformation = (ThreeDSecureAdditionalInformation) parcel.readParcelable(ThreeDSecureAdditionalInformation.class.getClassLoader());
        this.mChallengeRequested = parcel.readByte() > 0;
        this.mDataOnlyRequested = parcel.readByte() > 0;
        this.mExemptionRequested = parcel.readByte() > 0 ? true : z;
        this.mUiCustomization = (UiCustomization) parcel.readSerializable();
        this.mV1UiCustomization = (ThreeDSecureV1UiCustomization) parcel.readParcelable(ThreeDSecureV1UiCustomization.class.getClassLoader());
        this.mAccountType = parcel.readString();
    }
}
