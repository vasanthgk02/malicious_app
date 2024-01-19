package com.paypal.android.sdk.onetouch.core;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.paypal.android.sdk.onetouch.core.Request;
import com.paypal.android.sdk.onetouch.core.config.OtcConfiguration;
import com.paypal.android.sdk.onetouch.core.config.Recipe;
import com.paypal.android.sdk.onetouch.core.enums.Protocol;
import com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint;

public abstract class Request<T extends Request<T>> implements Parcelable {
    public String mCancelUrl;
    public String mClientId;
    public String mClientMetadataId;
    public String mEnvironment;
    public String mSuccessUrl;

    public Request() {
    }

    public int describeContents() {
        return 0;
    }

    public abstract Recipe getRecipeToExecute(Context context, OtcConfiguration otcConfiguration);

    public abstract void trackFpti(Context context, TrackingPoint trackingPoint, Protocol protocol);

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mEnvironment);
        parcel.writeString(this.mClientId);
        parcel.writeString(this.mClientMetadataId);
        parcel.writeString(this.mCancelUrl);
        parcel.writeString(this.mSuccessUrl);
    }

    public Request(Parcel parcel) {
        this.mEnvironment = parcel.readString();
        this.mClientId = parcel.readString();
        this.mClientMetadataId = parcel.readString();
        this.mCancelUrl = parcel.readString();
        this.mSuccessUrl = parcel.readString();
    }
}
