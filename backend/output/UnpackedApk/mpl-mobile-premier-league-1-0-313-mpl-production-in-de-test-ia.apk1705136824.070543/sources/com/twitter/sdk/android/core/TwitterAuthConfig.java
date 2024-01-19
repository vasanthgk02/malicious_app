package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TwitterAuthConfig implements Parcelable {
    public static final Creator<TwitterAuthConfig> CREATOR = new Creator<TwitterAuthConfig>() {
        public Object createFromParcel(Parcel parcel) {
            return new TwitterAuthConfig(parcel, null);
        }

        public Object[] newArray(int i) {
            return new TwitterAuthConfig[i];
        }
    };
    public final String consumerKey;
    public final String consumerSecret;

    public TwitterAuthConfig(Parcel parcel, AnonymousClass1 r2) {
        this.consumerKey = parcel.readString();
        this.consumerSecret = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.consumerKey);
        parcel.writeString(this.consumerSecret);
    }
}
