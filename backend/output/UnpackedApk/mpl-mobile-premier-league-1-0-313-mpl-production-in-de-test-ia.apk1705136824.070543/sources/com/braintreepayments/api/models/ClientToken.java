package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.mpl.androidapp.react.RNConstant;
import org.json.JSONException;
import org.json.JSONObject;

public class ClientToken extends Authorization {
    public static final Creator<ClientToken> CREATOR = new Creator<ClientToken>() {
        public Object createFromParcel(Parcel parcel) {
            return new ClientToken(parcel);
        }

        public Object[] newArray(int i) {
            return new ClientToken[i];
        }
    };
    public String mAuthorizationFingerprint;
    public String mConfigUrl;

    public ClientToken(String str) throws InvalidArgumentException {
        super(str);
        try {
            JSONObject jSONObject = new JSONObject(new String(Base64.decode(str, 0)));
            this.mConfigUrl = jSONObject.getString(RNConstant.EXTRA_WEB_CONFIG_URL);
            this.mAuthorizationFingerprint = jSONObject.getString("authorizationFingerprint");
        } catch (NullPointerException | JSONException unused) {
            throw new InvalidArgumentException("Client token was invalid");
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getBearer() {
        return this.mAuthorizationFingerprint;
    }

    public String getConfigUrl() {
        return this.mConfigUrl;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mRawValue);
        parcel.writeString(this.mConfigUrl);
        parcel.writeString(this.mAuthorizationFingerprint);
    }

    public ClientToken(Parcel parcel) {
        super(parcel);
        this.mConfigUrl = parcel.readString();
        this.mAuthorizationFingerprint = parcel.readString();
    }
}
