package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class AuthenticationInsight implements Parcelable {
    public static final Creator<AuthenticationInsight> CREATOR = new Creator<AuthenticationInsight>() {
        public Object createFromParcel(Parcel parcel) {
            return new AuthenticationInsight(parcel, null);
        }

        public Object[] newArray(int i) {
            return new AuthenticationInsight[i];
        }
    };
    public String mRegulationEnvironment;

    public AuthenticationInsight() {
    }

    public static AuthenticationInsight fromJson(JSONObject jSONObject) {
        String str = null;
        if (jSONObject == null) {
            return null;
        }
        AuthenticationInsight authenticationInsight = new AuthenticationInsight();
        if (jSONObject.has("customerAuthenticationRegulationEnvironment")) {
            if (!jSONObject.isNull("customerAuthenticationRegulationEnvironment")) {
                str = jSONObject.optString("customerAuthenticationRegulationEnvironment", null);
            }
        } else if (!jSONObject.isNull("regulationEnvironment")) {
            str = jSONObject.optString("regulationEnvironment", null);
        }
        if ("psdtwo".equalsIgnoreCase(str)) {
            str = "psd2";
        }
        if (str != null) {
            str = str.toLowerCase();
        }
        authenticationInsight.mRegulationEnvironment = str;
        return authenticationInsight;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mRegulationEnvironment);
    }

    public AuthenticationInsight(Parcel parcel, AnonymousClass1 r2) {
        this.mRegulationEnvironment = parcel.readString();
    }
}
