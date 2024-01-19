package com.braintreepayments.api.dropin;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.braintreepayments.api.models.GooglePaymentRequest;
import com.braintreepayments.api.models.PayPalRequest;
import com.braintreepayments.api.models.ThreeDSecureRequest;

public class DropInRequest implements Parcelable {
    public static final Creator<DropInRequest> CREATOR = new Creator<DropInRequest>() {
        public Object createFromParcel(Parcel parcel) {
            return new DropInRequest(parcel);
        }

        public Object[] newArray(int i) {
            return new DropInRequest[i];
        }
    };
    public String mAmount;
    public String mAuthorization;
    public boolean mCardEnabled = true;
    public int mCardholderNameStatus = 0;
    public boolean mCollectDeviceData;
    public boolean mDefaultVaultValue = true;
    public boolean mGooglePaymentEnabled = true;
    public GooglePaymentRequest mGooglePaymentRequest;
    public boolean mMaskCardNumber = false;
    public boolean mMaskSecurityCode = false;
    public boolean mPayPalEnabled = true;
    public PayPalRequest mPayPalRequest;
    public boolean mRequestThreeDSecureVerification;
    public boolean mShowCheckBoxToAllowVaultOverride = false;
    public ThreeDSecureRequest mThreeDSecureRequest;
    public boolean mVaultManagerEnabled = false;
    public boolean mVenmoEnabled = true;

    public DropInRequest() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAuthorization);
        parcel.writeString(this.mAmount);
        parcel.writeByte(this.mCollectDeviceData ? (byte) 1 : 0);
        parcel.writeParcelable(this.mGooglePaymentRequest, 0);
        parcel.writeByte(this.mGooglePaymentEnabled ? (byte) 1 : 0);
        parcel.writeParcelable(this.mPayPalRequest, 0);
        parcel.writeByte(this.mPayPalEnabled ? (byte) 1 : 0);
        parcel.writeByte(this.mVenmoEnabled ? (byte) 1 : 0);
        parcel.writeByte(this.mCardEnabled ? (byte) 1 : 0);
        parcel.writeByte(this.mRequestThreeDSecureVerification ? (byte) 1 : 0);
        parcel.writeParcelable(this.mThreeDSecureRequest, 0);
        parcel.writeByte(this.mMaskCardNumber ? (byte) 1 : 0);
        parcel.writeByte(this.mMaskSecurityCode ? (byte) 1 : 0);
        parcel.writeByte(this.mVaultManagerEnabled ? (byte) 1 : 0);
        parcel.writeInt(this.mCardholderNameStatus);
        parcel.writeByte(this.mDefaultVaultValue ? (byte) 1 : 0);
        parcel.writeByte(this.mShowCheckBoxToAllowVaultOverride ? (byte) 1 : 0);
    }

    public DropInRequest(Parcel parcel) {
        boolean z = true;
        this.mAuthorization = parcel.readString();
        this.mAmount = parcel.readString();
        this.mCollectDeviceData = parcel.readByte() != 0;
        this.mGooglePaymentRequest = (GooglePaymentRequest) parcel.readParcelable(GooglePaymentRequest.class.getClassLoader());
        this.mGooglePaymentEnabled = parcel.readByte() != 0;
        this.mPayPalRequest = (PayPalRequest) parcel.readParcelable(PayPalRequest.class.getClassLoader());
        this.mPayPalEnabled = parcel.readByte() != 0;
        this.mVenmoEnabled = parcel.readByte() != 0;
        this.mCardEnabled = parcel.readByte() != 0;
        this.mRequestThreeDSecureVerification = parcel.readByte() != 0;
        this.mThreeDSecureRequest = (ThreeDSecureRequest) parcel.readParcelable(ThreeDSecureRequest.class.getClassLoader());
        this.mMaskCardNumber = parcel.readByte() != 0;
        this.mMaskSecurityCode = parcel.readByte() != 0;
        this.mVaultManagerEnabled = parcel.readByte() != 0;
        this.mCardholderNameStatus = parcel.readInt();
        this.mDefaultVaultValue = parcel.readByte() != 0;
        this.mShowCheckBoxToAllowVaultOverride = parcel.readByte() == 0 ? false : z;
    }
}
