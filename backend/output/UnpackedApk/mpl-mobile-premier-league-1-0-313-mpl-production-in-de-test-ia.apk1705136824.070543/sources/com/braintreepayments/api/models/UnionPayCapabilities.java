package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UnionPayCapabilities implements Parcelable {
    public static final Creator<UnionPayCapabilities> CREATOR = new Creator<UnionPayCapabilities>() {
        public Object createFromParcel(Parcel parcel) {
            return new UnionPayCapabilities(parcel);
        }

        public Object[] newArray(int i) {
            return new UnionPayCapabilities[i];
        }
    };
    public boolean mIsDebit;
    public boolean mIsSupported;
    public boolean mIsUnionPay;
    public boolean mSupportsTwoStepAuthAndCapture;

    public UnionPayCapabilities() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.mIsUnionPay ? (byte) 1 : 0);
        parcel.writeByte(this.mIsDebit ? (byte) 1 : 0);
        parcel.writeByte(this.mSupportsTwoStepAuthAndCapture ? (byte) 1 : 0);
        parcel.writeByte(this.mIsSupported ? (byte) 1 : 0);
    }

    public UnionPayCapabilities(Parcel parcel) {
        boolean z = true;
        this.mIsUnionPay = parcel.readByte() > 0;
        this.mIsDebit = parcel.readByte() > 0;
        this.mSupportsTwoStepAuthAndCapture = parcel.readByte() > 0;
        this.mIsSupported = parcel.readByte() <= 0 ? false : z;
    }
}
