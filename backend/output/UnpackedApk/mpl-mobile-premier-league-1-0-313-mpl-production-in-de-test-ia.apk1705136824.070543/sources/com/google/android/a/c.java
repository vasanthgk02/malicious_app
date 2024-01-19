package com.google.android.a;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Codecs */
public final class c {
    static {
        c.class.getClassLoader();
    }

    public static void a(Parcel parcel, Parcelable parcelable) {
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
