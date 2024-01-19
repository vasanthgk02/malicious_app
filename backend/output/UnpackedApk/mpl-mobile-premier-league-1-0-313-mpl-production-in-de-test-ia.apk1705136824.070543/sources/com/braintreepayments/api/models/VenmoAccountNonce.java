package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.rudderstack.android.sdk.core.RudderTraits;
import org.json.JSONException;
import org.json.JSONObject;

public class VenmoAccountNonce extends PaymentMethodNonce implements Parcelable {
    public static final Creator<VenmoAccountNonce> CREATOR = new Creator<VenmoAccountNonce>() {
        public Object createFromParcel(Parcel parcel) {
            return new VenmoAccountNonce(parcel);
        }

        public Object[] newArray(int i) {
            return new VenmoAccountNonce[i];
        }
    };
    public String mUsername;

    public VenmoAccountNonce(String str, String str2, String str3) {
        this.mNonce = str;
        this.mDescription = str2;
        this.mUsername = str3;
    }

    public static VenmoAccountNonce fromJson(String str) throws JSONException {
        VenmoAccountNonce venmoAccountNonce = new VenmoAccountNonce();
        JSONObject jSONObject = new JSONObject(str).getJSONArray("venmoAccounts").getJSONObject(0);
        super.fromJson(jSONObject);
        String string = jSONObject.getJSONObject("details").getString(RudderTraits.USERNAME_KEY);
        venmoAccountNonce.mUsername = string;
        venmoAccountNonce.mDescription = string;
        return venmoAccountNonce;
    }

    public String getTypeLabel() {
        return "Venmo";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mNonce);
        parcel.writeString(this.mDescription);
        parcel.writeByte(this.mDefault ? (byte) 1 : 0);
        parcel.writeString(this.mUsername);
    }

    public VenmoAccountNonce() {
    }

    public VenmoAccountNonce(Parcel parcel) {
        super(parcel);
        this.mUsername = parcel.readString();
    }

    public void fromJson(JSONObject jSONObject) throws JSONException {
        super.fromJson(jSONObject);
        String string = jSONObject.getJSONObject("details").getString(RudderTraits.USERNAME_KEY);
        this.mUsername = string;
        this.mDescription = string;
    }
}
