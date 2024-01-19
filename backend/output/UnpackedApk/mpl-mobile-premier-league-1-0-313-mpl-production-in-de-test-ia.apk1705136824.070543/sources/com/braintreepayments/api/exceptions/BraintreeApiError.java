package com.braintreepayments.api.exceptions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import org.json.JSONObject;

public class BraintreeApiError implements Parcelable {
    public static final Creator<BraintreeApiError> CREATOR = new Creator<BraintreeApiError>() {
        public Object createFromParcel(Parcel parcel) {
            return new BraintreeApiError(parcel);
        }

        public Object[] newArray(int i) {
            return new BraintreeApiError[i];
        }
    };
    public String mAt;
    public String mCode;
    public String mIn;
    public String mMessage;

    public BraintreeApiError() {
    }

    public static BraintreeApiError fromJson(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        BraintreeApiError braintreeApiError = new BraintreeApiError();
        String str4 = null;
        if (jSONObject.isNull("code")) {
            str = null;
        } else {
            str = jSONObject.optString("code", null);
        }
        braintreeApiError.mCode = str;
        if (jSONObject.isNull("developer_message")) {
            str2 = null;
        } else {
            str2 = jSONObject.optString("developer_message", null);
        }
        braintreeApiError.mMessage = str2;
        if (jSONObject.isNull("in")) {
            str3 = null;
        } else {
            str3 = jSONObject.optString("in", null);
        }
        braintreeApiError.mIn = str3;
        if (!jSONObject.isNull("at")) {
            str4 = jSONObject.optString("at", null);
        }
        braintreeApiError.mAt = str4;
        return braintreeApiError;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("BraintreeApiError ");
        outline73.append(this.mCode);
        outline73.append(" for ");
        outline73.append(this.mIn);
        outline73.append(": ");
        outline73.append(this.mMessage);
        return outline73.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCode);
        parcel.writeString(this.mMessage);
        parcel.writeString(this.mIn);
        parcel.writeString(this.mAt);
    }

    public BraintreeApiError(Parcel parcel) {
        this.mCode = parcel.readString();
        this.mMessage = parcel.readString();
        this.mIn = parcel.readString();
        this.mAt = parcel.readString();
    }
}
