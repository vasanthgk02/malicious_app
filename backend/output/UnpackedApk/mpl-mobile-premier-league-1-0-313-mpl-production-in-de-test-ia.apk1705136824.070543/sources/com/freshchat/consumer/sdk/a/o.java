package com.freshchat.consumer.sdk.a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.freshchat.consumer.sdk.a.l.c;

public final class o implements Creator<c> {
    /* renamed from: Q */
    public c[] newArray(int i) {
        return new c[i];
    }

    /* renamed from: c */
    public c createFromParcel(Parcel parcel) {
        return new c(parcel);
    }
}
