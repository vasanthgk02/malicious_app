package com.freshchat.consumer.sdk.service.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.freshchat.consumer.sdk.service.Status;

public abstract class ag implements Parcelable, k {
    public Status status;

    public ag() {
    }

    public ag(Parcel parcel) {
        this.status = Status.valueOf(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        Status status2 = this.status;
        return status2 == null ? Status.ERROR : status2;
    }

    @Deprecated
    public boolean isSuccess() {
        return false;
    }

    public void setStatus(Status status2) {
        this.status = status2;
    }

    @Deprecated
    public void setSuccess(boolean z) {
    }

    public void writeToParcel(Parcel parcel, int i) {
        Status status2 = this.status;
        if (status2 == null) {
            status2 = Status.ERROR;
        }
        parcel.writeString(status2.name());
    }
}
