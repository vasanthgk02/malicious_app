package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.exceptions.InvalidArgumentException;

public abstract class Authorization implements Parcelable {
    public final String mRawValue;

    public Authorization(String str) {
        this.mRawValue = str;
    }

    public static Authorization fromString(String str) throws InvalidArgumentException {
        if (isTokenizationKey(str)) {
            return new TokenizationKey(str);
        }
        boolean z = true;
        if (!TextUtils.isEmpty(str) && str.matches("^[a-zA-Z0-9]+\\.[a-zA-Z0-9]+\\.[a-zA-Z0-9_-]+$")) {
            return new PayPalUAT(str);
        }
        if (TextUtils.isEmpty(str) || !str.matches("([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)")) {
            z = false;
        }
        if (z) {
            return new ClientToken(str);
        }
        throw new InvalidArgumentException(GeneratedOutlineSupport.outline50("Authorization provided is invalid: ", str));
    }

    @Deprecated
    public static boolean isTokenizationKey(String str) {
        return !TextUtils.isEmpty(str) && str.matches("^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9_]+$");
    }

    public abstract String getBearer();

    public abstract String getConfigUrl();

    public String toString() {
        return this.mRawValue;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mRawValue);
    }

    public Authorization(Parcel parcel) {
        this.mRawValue = parcel.readString();
    }
}
