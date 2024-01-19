package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ThreeDSecureAdditionalInformation implements Parcelable {
    public static final Creator<ThreeDSecureAdditionalInformation> CREATOR = new Creator<ThreeDSecureAdditionalInformation>() {
        public Object createFromParcel(Parcel parcel) {
            return new ThreeDSecureAdditionalInformation(parcel);
        }

        public Object[] newArray(int i) {
            return new ThreeDSecureAdditionalInformation[i];
        }
    };
    public String mAccountAgeIndicator;
    public String mAccountChangeDate;
    public String mAccountChangeIndicator;
    public String mAccountCreateDate;
    public String mAccountId;
    public String mAccountPurchases;
    public String mAccountPwdChangeDate;
    public String mAccountPwdChangeIndicator;
    public String mAddCardAttempts;
    public String mAddressMatch;
    public String mAuthenticationIndicator;
    public String mDeliveryEmail;
    public String mDeliveryTimeframe;
    public String mFraudActivity;
    public String mGiftCardAmount;
    public String mGiftCardCount;
    public String mGiftCardCurrencyCode;
    public String mInstallment;
    public String mIpAddress;
    public String mOrderDescription;
    public String mPaymentAccountAge;
    public String mPaymentAccountIndicator;
    public String mPreorderDate;
    public String mPreorderIndicator;
    public String mProductCode;
    public String mPurchaseDate;
    public String mRecurringEnd;
    public String mRecurringFrequency;
    public String mReorderIndicator;
    public String mSdkMaxTimeout;
    public ThreeDSecurePostalAddress mShippingAddress;
    public String mShippingAddressUsageDate;
    public String mShippingAddressUsageIndicator;
    public String mShippingMethodIndicator;
    public String mShippingNameIndicator;
    public String mTaxAmount;
    public String mTransactionCountDay;
    public String mTransactionCountYear;
    public String mUserAgent;
    public String mWorkPhoneNumber;

    public ThreeDSecureAdditionalInformation() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mShippingAddress, i);
        parcel.writeString(this.mShippingMethodIndicator);
        parcel.writeString(this.mProductCode);
        parcel.writeString(this.mDeliveryTimeframe);
        parcel.writeString(this.mDeliveryEmail);
        parcel.writeString(this.mReorderIndicator);
        parcel.writeString(this.mPreorderIndicator);
        parcel.writeString(this.mPreorderDate);
        parcel.writeString(this.mGiftCardAmount);
        parcel.writeString(this.mGiftCardCurrencyCode);
        parcel.writeString(this.mGiftCardCount);
        parcel.writeString(this.mAccountAgeIndicator);
        parcel.writeString(this.mAccountCreateDate);
        parcel.writeString(this.mAccountChangeIndicator);
        parcel.writeString(this.mAccountChangeDate);
        parcel.writeString(this.mAccountPwdChangeIndicator);
        parcel.writeString(this.mAccountPwdChangeDate);
        parcel.writeString(this.mShippingAddressUsageIndicator);
        parcel.writeString(this.mShippingAddressUsageDate);
        parcel.writeString(this.mTransactionCountDay);
        parcel.writeString(this.mTransactionCountYear);
        parcel.writeString(this.mAddCardAttempts);
        parcel.writeString(this.mAccountPurchases);
        parcel.writeString(this.mFraudActivity);
        parcel.writeString(this.mShippingNameIndicator);
        parcel.writeString(this.mPaymentAccountIndicator);
        parcel.writeString(this.mPaymentAccountAge);
        parcel.writeString(this.mAddressMatch);
        parcel.writeString(this.mAccountId);
        parcel.writeString(this.mIpAddress);
        parcel.writeString(this.mOrderDescription);
        parcel.writeString(this.mTaxAmount);
        parcel.writeString(this.mUserAgent);
        parcel.writeString(this.mAuthenticationIndicator);
        parcel.writeString(this.mInstallment);
        parcel.writeString(this.mPurchaseDate);
        parcel.writeString(this.mRecurringEnd);
        parcel.writeString(this.mRecurringFrequency);
        parcel.writeString(this.mSdkMaxTimeout);
        parcel.writeString(this.mWorkPhoneNumber);
    }

    public ThreeDSecureAdditionalInformation(Parcel parcel) {
        this.mShippingAddress = (ThreeDSecurePostalAddress) parcel.readParcelable(ThreeDSecurePostalAddress.class.getClassLoader());
        this.mShippingMethodIndicator = parcel.readString();
        this.mProductCode = parcel.readString();
        this.mDeliveryTimeframe = parcel.readString();
        this.mDeliveryEmail = parcel.readString();
        this.mReorderIndicator = parcel.readString();
        this.mPreorderIndicator = parcel.readString();
        this.mPreorderDate = parcel.readString();
        this.mGiftCardAmount = parcel.readString();
        this.mGiftCardCurrencyCode = parcel.readString();
        this.mGiftCardCount = parcel.readString();
        this.mAccountAgeIndicator = parcel.readString();
        this.mAccountCreateDate = parcel.readString();
        this.mAccountChangeIndicator = parcel.readString();
        this.mAccountChangeDate = parcel.readString();
        this.mAccountPwdChangeIndicator = parcel.readString();
        this.mAccountPwdChangeDate = parcel.readString();
        this.mShippingAddressUsageIndicator = parcel.readString();
        this.mShippingAddressUsageDate = parcel.readString();
        this.mTransactionCountDay = parcel.readString();
        this.mTransactionCountYear = parcel.readString();
        this.mAddCardAttempts = parcel.readString();
        this.mAccountPurchases = parcel.readString();
        this.mFraudActivity = parcel.readString();
        this.mShippingNameIndicator = parcel.readString();
        this.mPaymentAccountIndicator = parcel.readString();
        this.mPaymentAccountAge = parcel.readString();
        this.mAddressMatch = parcel.readString();
        this.mAccountId = parcel.readString();
        this.mIpAddress = parcel.readString();
        this.mOrderDescription = parcel.readString();
        this.mTaxAmount = parcel.readString();
        this.mUserAgent = parcel.readString();
        this.mAuthenticationIndicator = parcel.readString();
        this.mInstallment = parcel.readString();
        this.mPurchaseDate = parcel.readString();
        this.mRecurringEnd = parcel.readString();
        this.mRecurringFrequency = parcel.readString();
        this.mSdkMaxTimeout = parcel.readString();
        this.mWorkPhoneNumber = parcel.readString();
    }
}
