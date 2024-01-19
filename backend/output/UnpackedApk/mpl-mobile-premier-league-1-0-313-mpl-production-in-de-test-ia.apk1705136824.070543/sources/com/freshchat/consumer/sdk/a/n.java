package com.freshchat.consumer.sdk.a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.freshchat.consumer.sdk.a.l.a;

public final class n implements Creator<a> {
    /* renamed from: P */
    public a[] newArray(int i) {
        return new a[i];
    }

    /* renamed from: a */
    public a createFromParcel(Parcel parcel) {
        return new a(parcel);
    }
}
