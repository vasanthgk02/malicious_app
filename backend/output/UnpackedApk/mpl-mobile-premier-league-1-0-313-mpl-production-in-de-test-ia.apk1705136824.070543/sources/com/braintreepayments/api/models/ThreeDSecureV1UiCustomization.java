package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ThreeDSecureV1UiCustomization implements Parcelable {
    public static final Creator<ThreeDSecureV1UiCustomization> CREATOR = new Creator<ThreeDSecureV1UiCustomization>() {
        public Object createFromParcel(Parcel parcel) {
            return new ThreeDSecureV1UiCustomization(parcel, null);
        }

        public Object[] newArray(int i) {
            return new ThreeDSecureV1UiCustomization[i];
        }
    };
    public String mRedirectButtonText;
    public String mRedirectDescription;

    public ThreeDSecureV1UiCustomization() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mRedirectButtonText);
        parcel.writeString(this.mRedirectDescription);
    }

    public ThreeDSecureV1UiCustomization(Parcel parcel, AnonymousClass1 r2) {
        this.mRedirectButtonText = parcel.readString();
        this.mRedirectDescription = parcel.readString();
    }
}
