package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mpl.payment.routing.RoutingConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class CardNonce extends PaymentMethodNonce implements Parcelable {
    public static final Creator<CardNonce> CREATOR = new Creator<CardNonce>() {
        public Object createFromParcel(Parcel parcel) {
            return new CardNonce(parcel);
        }

        public Object[] newArray(int i) {
            return new CardNonce[i];
        }
    };
    public AuthenticationInsight mAuthenticationInsight;
    public BinData mBinData;
    public String mCardType;
    public String mCardholderName;
    public String mExpirationMonth;
    public String mExpirationYear;
    public String mLastFour;
    public String mLastTwo;
    public ThreeDSecureInfo mThreeDSecureInfo;

    public CardNonce() {
    }

    public void fromJson(JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        super.fromJson(jSONObject);
        JSONObject jSONObject2 = jSONObject.getJSONObject("details");
        this.mLastTwo = jSONObject2.getString("lastTwo");
        this.mLastFour = jSONObject2.getString("lastFour");
        this.mCardType = jSONObject2.getString(RoutingConstants.MI_REACT_SAVED_CARD_TYPE);
        this.mThreeDSecureInfo = ThreeDSecureInfo.fromJson(jSONObject.optJSONObject("threeDSecureInfo"));
        String str3 = "";
        if (!jSONObject2.isNull("bin")) {
            jSONObject2.optString("bin", str3);
        }
        this.mBinData = BinData.fromJson(jSONObject.optJSONObject("binData"));
        this.mAuthenticationInsight = AuthenticationInsight.fromJson(jSONObject.optJSONObject("authenticationInsight"));
        if (jSONObject2.isNull("expirationMonth")) {
            str = str3;
        } else {
            str = jSONObject2.optString("expirationMonth", str3);
        }
        this.mExpirationMonth = str;
        if (jSONObject2.isNull("expirationYear")) {
            str2 = str3;
        } else {
            str2 = jSONObject2.optString("expirationYear", str3);
        }
        this.mExpirationYear = str2;
        if (!jSONObject2.isNull("cardholderName")) {
            str3 = jSONObject2.optString("cardholderName", str3);
        }
        this.mCardholderName = str3;
    }

    public String getTypeLabel() {
        return this.mCardType;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mNonce);
        parcel.writeString(this.mDescription);
        parcel.writeByte(this.mDefault ? (byte) 1 : 0);
        parcel.writeString(this.mCardType);
        parcel.writeString(this.mLastTwo);
        parcel.writeString(this.mLastFour);
        parcel.writeParcelable(this.mBinData, i);
        parcel.writeParcelable(this.mThreeDSecureInfo, i);
        parcel.writeParcelable(this.mAuthenticationInsight, i);
        parcel.writeString(this.mExpirationMonth);
        parcel.writeString(this.mExpirationYear);
        parcel.writeString(this.mCardholderName);
    }

    public CardNonce(Parcel parcel) {
        super(parcel);
        this.mCardType = parcel.readString();
        this.mLastTwo = parcel.readString();
        this.mLastFour = parcel.readString();
        this.mBinData = (BinData) parcel.readParcelable(BinData.class.getClassLoader());
        this.mThreeDSecureInfo = (ThreeDSecureInfo) parcel.readParcelable(ThreeDSecureInfo.class.getClassLoader());
        this.mAuthenticationInsight = (AuthenticationInsight) parcel.readParcelable(AuthenticationInsight.class.getClassLoader());
        this.mExpirationMonth = parcel.readString();
        this.mExpirationYear = parcel.readString();
        this.mCardholderName = parcel.readString();
    }
}
