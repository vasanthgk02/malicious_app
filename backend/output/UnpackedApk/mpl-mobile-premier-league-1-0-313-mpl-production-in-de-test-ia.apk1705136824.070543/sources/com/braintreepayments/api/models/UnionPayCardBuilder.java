package com.braintreepayments.api.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.paynimo.android.payment.UPIFragment;
import org.json.JSONException;
import org.json.JSONObject;

public class UnionPayCardBuilder extends BaseCardBuilder<UnionPayCardBuilder> implements Parcelable {
    public static final Creator<UnionPayCardBuilder> CREATOR = new Creator<UnionPayCardBuilder>() {
        public Object createFromParcel(Parcel parcel) {
            return new UnionPayCardBuilder(parcel);
        }

        public Object[] newArray(int i) {
            return new UnionPayCardBuilder[i];
        }
    };
    public String mEnrollmentId;
    public String mMobileCountryCode;
    public String mMobilePhoneNumber;
    public String mSmsCode;

    public UnionPayCardBuilder() {
    }

    public void build(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        super.build(jSONObject, jSONObject2);
        JSONObject optJSONObject = jSONObject2.optJSONObject("options");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            jSONObject2.put("options", optJSONObject);
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("smsCode", this.mSmsCode);
        jSONObject3.put("id", this.mEnrollmentId);
        optJSONObject.put("unionPayEnrollment", jSONObject3);
        jSONObject.put("creditCard", jSONObject2);
    }

    public JSONObject buildEnrollment() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(UPIFragment.CONFIG_TYPE_NUMBER, this.mCardnumber);
        jSONObject.put("expirationMonth", this.mExpirationMonth);
        jSONObject.put("expirationYear", this.mExpirationYear);
        jSONObject.put("mobileCountryCode", this.mMobileCountryCode);
        jSONObject.put("mobileNumber", this.mMobilePhoneNumber);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("unionPayEnrollment", jSONObject);
        return jSONObject2;
    }

    public void buildGraphQL(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mMobileCountryCode);
        parcel.writeString(this.mMobilePhoneNumber);
        parcel.writeString(this.mSmsCode);
        parcel.writeString(this.mEnrollmentId);
    }

    public UnionPayCardBuilder(Parcel parcel) {
        super(parcel);
        this.mMobileCountryCode = parcel.readString();
        this.mMobilePhoneNumber = parcel.readString();
        this.mSmsCode = parcel.readString();
        this.mEnrollmentId = parcel.readString();
    }
}
