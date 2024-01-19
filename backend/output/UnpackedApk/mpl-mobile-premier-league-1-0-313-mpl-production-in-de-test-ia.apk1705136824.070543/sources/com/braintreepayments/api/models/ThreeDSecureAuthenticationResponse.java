package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import co.hyperverge.hypersnapsdk.c.k;
import org.json.JSONException;
import org.json.JSONObject;

public class ThreeDSecureAuthenticationResponse implements Parcelable {
    public static final Creator<ThreeDSecureAuthenticationResponse> CREATOR = new Creator<ThreeDSecureAuthenticationResponse>() {
        public Object createFromParcel(Parcel parcel) {
            return new ThreeDSecureAuthenticationResponse(parcel, null);
        }

        public Object[] newArray(int i) {
            return new ThreeDSecureAuthenticationResponse[i];
        }
    };
    public CardNonce mCardNonce;
    public String mErrors;
    public String mException;
    public boolean mSuccess;

    public ThreeDSecureAuthenticationResponse() {
    }

    public static ThreeDSecureAuthenticationResponse fromJson(String str) {
        ThreeDSecureAuthenticationResponse threeDSecureAuthenticationResponse = new ThreeDSecureAuthenticationResponse();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("paymentMethod");
            if (optJSONObject != null) {
                CardNonce cardNonce = new CardNonce();
                cardNonce.fromJson(optJSONObject);
                threeDSecureAuthenticationResponse.mCardNonce = cardNonce;
            }
            if (jSONObject.has("success")) {
                if (jSONObject.has("error")) {
                    threeDSecureAuthenticationResponse.mErrors = k.optString(jSONObject.getJSONObject("error"), "message", null);
                }
                threeDSecureAuthenticationResponse.mSuccess = jSONObject.getBoolean("success");
            } else {
                if (jSONObject.has("errors")) {
                    threeDSecureAuthenticationResponse.mErrors = k.optString(jSONObject.getJSONArray("errors").getJSONObject(0), "message", null);
                }
                threeDSecureAuthenticationResponse.mSuccess = threeDSecureAuthenticationResponse.mErrors == null;
            }
        } catch (JSONException unused) {
            threeDSecureAuthenticationResponse.mSuccess = false;
        }
        return threeDSecureAuthenticationResponse;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.mSuccess ? (byte) 1 : 0);
        parcel.writeParcelable(this.mCardNonce, i);
        parcel.writeString(this.mErrors);
        parcel.writeString(this.mException);
    }

    public ThreeDSecureAuthenticationResponse(Parcel parcel, AnonymousClass1 r2) {
        this.mSuccess = parcel.readByte() != 0;
        this.mCardNonce = (CardNonce) parcel.readParcelable(CardNonce.class.getClassLoader());
        this.mErrors = parcel.readString();
        this.mException = parcel.readString();
    }
}
