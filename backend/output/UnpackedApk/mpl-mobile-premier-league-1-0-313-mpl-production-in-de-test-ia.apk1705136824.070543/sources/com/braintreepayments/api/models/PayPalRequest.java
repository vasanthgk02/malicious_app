package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.paypal.android.sdk.onetouch.core.PayPalLineItem;
import java.util.ArrayList;

public class PayPalRequest implements Parcelable {
    public static final Creator<PayPalRequest> CREATOR = new Creator<PayPalRequest>() {
        public Object createFromParcel(Parcel parcel) {
            return new PayPalRequest(parcel);
        }

        public Object[] newArray(int i) {
            return new PayPalRequest[i];
        }
    };
    public String mAmount;
    public String mBillingAgreementDescription;
    public String mCurrencyCode;
    public String mDisplayName;
    public String mIntent;
    public String mLandingPageType;
    public ArrayList<PayPalLineItem> mLineItems;
    public String mLocaleCode;
    public String mMerchantAccountId;
    public boolean mOfferCredit;
    public boolean mOfferPayLater;
    public PayPalProductAttributes mProductAttributes;
    public boolean mShippingAddressEditable;
    public PostalAddress mShippingAddressOverride;
    public boolean mShippingAddressRequired;
    public String mUserAction;

    public PayPalRequest(String str) {
        this.mShippingAddressEditable = false;
        this.mIntent = "authorize";
        this.mUserAction = "";
        this.mLineItems = new ArrayList<>();
        this.mAmount = str;
        this.mShippingAddressRequired = false;
        this.mOfferCredit = false;
        this.mOfferPayLater = false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAmount);
        parcel.writeString(this.mCurrencyCode);
        parcel.writeString(this.mLocaleCode);
        parcel.writeString(this.mBillingAgreementDescription);
        parcel.writeByte(this.mShippingAddressRequired ? (byte) 1 : 0);
        parcel.writeByte(this.mShippingAddressEditable ? (byte) 1 : 0);
        parcel.writeParcelable(this.mShippingAddressOverride, i);
        parcel.writeString(this.mIntent);
        parcel.writeString(this.mLandingPageType);
        parcel.writeString(this.mUserAction);
        parcel.writeString(this.mDisplayName);
        parcel.writeByte(this.mOfferCredit ? (byte) 1 : 0);
        parcel.writeByte(this.mOfferPayLater ? (byte) 1 : 0);
        parcel.writeString(this.mMerchantAccountId);
        parcel.writeList(this.mLineItems);
        parcel.writeParcelable(this.mProductAttributes, i);
    }

    public PayPalRequest() {
        this.mShippingAddressEditable = false;
        this.mIntent = "authorize";
        this.mUserAction = "";
        this.mLineItems = new ArrayList<>();
        this.mAmount = null;
        this.mShippingAddressRequired = false;
        this.mOfferCredit = false;
        this.mOfferPayLater = false;
    }

    public PayPalRequest(Parcel parcel) {
        boolean z = false;
        this.mShippingAddressEditable = false;
        this.mIntent = "authorize";
        this.mUserAction = "";
        this.mLineItems = new ArrayList<>();
        this.mAmount = parcel.readString();
        this.mCurrencyCode = parcel.readString();
        this.mLocaleCode = parcel.readString();
        this.mBillingAgreementDescription = parcel.readString();
        this.mShippingAddressRequired = parcel.readByte() > 0;
        this.mShippingAddressEditable = parcel.readByte() > 0;
        this.mShippingAddressOverride = (PostalAddress) parcel.readParcelable(PostalAddress.class.getClassLoader());
        this.mIntent = parcel.readString();
        this.mLandingPageType = parcel.readString();
        this.mUserAction = parcel.readString();
        this.mDisplayName = parcel.readString();
        this.mOfferCredit = parcel.readByte() > 0;
        this.mOfferPayLater = parcel.readByte() > 0 ? true : z;
        this.mMerchantAccountId = parcel.readString();
        this.mLineItems = parcel.readArrayList(PayPalLineItem.class.getClassLoader());
        this.mProductAttributes = (PayPalProductAttributes) parcel.readParcelable(PayPalProductAttributes.class.getClassLoader());
    }
}
