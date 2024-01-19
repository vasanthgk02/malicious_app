package com.paynimo.android.payment.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum c implements Parcelable {
    TRANSACTION,
    TOKEN;
    
    public static final Creator<c> CREATOR = null;

    public static class a implements Creator<c> {
        public c createFromParcel(Parcel parcel) {
            return c.values()[parcel.readInt()];
        }

        public c[] newArray(int i) {
            return new c[i];
        }
    }

    /* access modifiers changed from: public */
    static {
        CREATOR = new a();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
