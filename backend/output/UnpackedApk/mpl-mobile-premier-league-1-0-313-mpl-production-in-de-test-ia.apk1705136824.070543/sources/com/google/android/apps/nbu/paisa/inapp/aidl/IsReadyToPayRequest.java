package com.google.android.apps.nbu.paisa.inapp.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class IsReadyToPayRequest implements Parcelable {
    public static final Creator<IsReadyToPayRequest> CREATOR = new Creator<IsReadyToPayRequest>() {
        public Object createFromParcel(Parcel parcel) {
            return new IsReadyToPayRequest(parcel, null);
        }

        public Object[] newArray(int i) {
            return new IsReadyToPayRequest[i];
        }
    };
    public final String request;

    public IsReadyToPayRequest(Parcel parcel, AnonymousClass1 r2) {
        this.request = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.request);
    }

    public IsReadyToPayRequest(String str) {
        this.request = str;
    }
}
