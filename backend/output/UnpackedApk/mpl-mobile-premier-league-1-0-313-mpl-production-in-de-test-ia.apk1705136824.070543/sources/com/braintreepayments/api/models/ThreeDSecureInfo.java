package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class ThreeDSecureInfo implements Parcelable {
    public static final Creator<ThreeDSecureInfo> CREATOR = new Creator<ThreeDSecureInfo>() {
        public Object createFromParcel(Parcel parcel) {
            return new ThreeDSecureInfo(parcel, null);
        }

        public Object[] newArray(int i) {
            return new ThreeDSecureInfo[i];
        }
    };
    public String mAuthenticationTransactionStatus;
    public String mAuthenticationTransactionStatusReason;
    public String mCavv;
    public String mDsTransactionId;
    public String mEciFlag;
    public String mEnrolled;
    public boolean mLiabilityShiftPossible;
    public boolean mLiabilityShifted;
    public String mLookupTransactionStatus;
    public String mLookupTransactionStatusReason;
    public String mStatus;
    public String mThreeDSecureAuthenticationId;
    public ThreeDSecureAuthenticationResponse mThreeDSecureAuthenticationResponse;
    public String mThreeDSecureVersion;
    public boolean mWasVerified;
    public String mXid;

    public ThreeDSecureInfo() {
    }

    public static ThreeDSecureInfo fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        ThreeDSecureInfo threeDSecureInfo = new ThreeDSecureInfo();
        threeDSecureInfo.mCavv = jSONObject.optString("cavv");
        threeDSecureInfo.mDsTransactionId = jSONObject.optString("dsTransactionId");
        threeDSecureInfo.mEciFlag = jSONObject.optString("eciFlag");
        threeDSecureInfo.mEnrolled = jSONObject.optString("enrolled");
        threeDSecureInfo.mLiabilityShifted = jSONObject.optBoolean("liabilityShifted");
        threeDSecureInfo.mLiabilityShiftPossible = jSONObject.optBoolean("liabilityShiftPossible");
        threeDSecureInfo.mStatus = jSONObject.optString("status");
        threeDSecureInfo.mThreeDSecureVersion = jSONObject.optString("threeDSecureVersion");
        threeDSecureInfo.mWasVerified = jSONObject.has("liabilityShifted") && jSONObject.has("liabilityShiftPossible");
        threeDSecureInfo.mXid = jSONObject.optString("xid");
        jSONObject.optString("acsTransactionId");
        threeDSecureInfo.mThreeDSecureAuthenticationId = jSONObject.optString("threeDSecureAuthenticationId");
        jSONObject.optString("threeDSecureServerTransactionId");
        jSONObject.optString("paresStatus");
        JSONObject optJSONObject = jSONObject.optJSONObject("authentication");
        if (optJSONObject != null) {
            threeDSecureInfo.mAuthenticationTransactionStatus = optJSONObject.optString("transStatus");
            threeDSecureInfo.mAuthenticationTransactionStatusReason = optJSONObject.optString("transStatusReason");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("lookup");
        if (optJSONObject2 != null) {
            threeDSecureInfo.mLookupTransactionStatus = optJSONObject2.optString("transStatus");
            threeDSecureInfo.mLookupTransactionStatusReason = optJSONObject2.optString("transStatusReason");
        }
        return threeDSecureInfo;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCavv);
        parcel.writeString(this.mDsTransactionId);
        parcel.writeString(this.mEciFlag);
        parcel.writeString(this.mEnrolled);
        parcel.writeByte(this.mLiabilityShifted ? (byte) 1 : 0);
        parcel.writeByte(this.mLiabilityShiftPossible ? (byte) 1 : 0);
        parcel.writeString(this.mStatus);
        parcel.writeString(this.mThreeDSecureVersion);
        parcel.writeByte(this.mWasVerified ? (byte) 1 : 0);
        parcel.writeString(this.mXid);
        parcel.writeString(this.mAuthenticationTransactionStatus);
        parcel.writeString(this.mAuthenticationTransactionStatusReason);
        parcel.writeString(this.mLookupTransactionStatus);
        parcel.writeString(this.mLookupTransactionStatusReason);
        parcel.writeString(this.mThreeDSecureAuthenticationId);
    }

    public ThreeDSecureInfo(Parcel parcel, AnonymousClass1 r4) {
        this.mCavv = parcel.readString();
        this.mDsTransactionId = parcel.readString();
        this.mEciFlag = parcel.readString();
        this.mEnrolled = parcel.readString();
        boolean z = false;
        this.mLiabilityShifted = parcel.readByte() != 0;
        this.mLiabilityShiftPossible = parcel.readByte() != 0;
        this.mStatus = parcel.readString();
        this.mThreeDSecureVersion = parcel.readString();
        this.mWasVerified = parcel.readByte() != 0 ? true : z;
        this.mXid = parcel.readString();
        this.mAuthenticationTransactionStatus = parcel.readString();
        this.mAuthenticationTransactionStatusReason = parcel.readString();
        this.mLookupTransactionStatus = parcel.readString();
        this.mLookupTransactionStatusReason = parcel.readString();
        this.mThreeDSecureAuthenticationId = parcel.readString();
    }
}
