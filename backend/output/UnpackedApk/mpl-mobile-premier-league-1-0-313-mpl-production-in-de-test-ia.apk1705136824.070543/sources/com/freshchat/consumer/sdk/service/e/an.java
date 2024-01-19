package com.freshchat.consumer.sdk.service.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.freshchat.consumer.sdk.service.Status;

public class an extends ag {
    public static final Creator<an> CREATOR = new ao();
    public boolean success;

    public an() {
    }

    public an(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return this.success ? Status.SUCCESS : Status.ERROR;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
