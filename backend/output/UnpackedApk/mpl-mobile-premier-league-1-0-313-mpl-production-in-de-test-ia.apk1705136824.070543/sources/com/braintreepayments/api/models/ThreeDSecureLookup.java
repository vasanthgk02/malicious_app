package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class ThreeDSecureLookup implements Parcelable {
    public static final Creator<ThreeDSecureLookup> CREATOR = new Creator<ThreeDSecureLookup>() {
        public Object createFromParcel(Parcel parcel) {
            return new ThreeDSecureLookup(parcel, null);
        }

        public Object[] newArray(int i) {
            return new ThreeDSecureLookup[i];
        }
    };
    public String mAcsUrl;
    public CardNonce mCardNonce;
    public String mMd;
    public String mPareq;
    public String mTermUrl;
    public String mThreeDSecureVersion;
    public String mTransactionId;

    public ThreeDSecureLookup() {
    }

    public static ThreeDSecureLookup fromJson(String str) throws JSONException {
        String str2;
        JSONObject jSONObject = new JSONObject(str);
        ThreeDSecureLookup threeDSecureLookup = new ThreeDSecureLookup();
        CardNonce cardNonce = new CardNonce();
        cardNonce.fromJson(jSONObject.getJSONObject("paymentMethod"));
        threeDSecureLookup.mCardNonce = cardNonce;
        JSONObject jSONObject2 = jSONObject.getJSONObject("lookup");
        if (jSONObject2.isNull("acsUrl")) {
            threeDSecureLookup.mAcsUrl = null;
        } else {
            threeDSecureLookup.mAcsUrl = jSONObject2.getString("acsUrl");
        }
        threeDSecureLookup.mMd = jSONObject2.getString("md");
        threeDSecureLookup.mTermUrl = jSONObject2.getString("termUrl");
        threeDSecureLookup.mPareq = jSONObject2.getString("pareq");
        String str3 = "";
        if (jSONObject2.isNull("threeDSecureVersion")) {
            str2 = str3;
        } else {
            str2 = jSONObject2.optString("threeDSecureVersion", str3);
        }
        threeDSecureLookup.mThreeDSecureVersion = str2;
        if (!jSONObject2.isNull("transactionId")) {
            str3 = jSONObject2.optString("transactionId", str3);
        }
        threeDSecureLookup.mTransactionId = str3;
        return threeDSecureLookup;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mCardNonce, i);
        parcel.writeString(this.mAcsUrl);
        parcel.writeString(this.mMd);
        parcel.writeString(this.mTermUrl);
        parcel.writeString(this.mPareq);
        parcel.writeString(this.mThreeDSecureVersion);
        parcel.writeString(this.mTransactionId);
    }

    public ThreeDSecureLookup(Parcel parcel, AnonymousClass1 r2) {
        this.mCardNonce = (CardNonce) parcel.readParcelable(CardNonce.class.getClassLoader());
        this.mAcsUrl = parcel.readString();
        this.mMd = parcel.readString();
        this.mTermUrl = parcel.readString();
        this.mPareq = parcel.readString();
        this.mThreeDSecureVersion = parcel.readString();
        this.mTransactionId = parcel.readString();
    }
}
