package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.mpl.payment.routing.RoutingConstants;
import org.json.JSONObject;

public class BinData implements Parcelable {
    public static final Creator<BinData> CREATOR = new Creator<BinData>() {
        public Object createFromParcel(Parcel parcel) {
            return new BinData(parcel, null);
        }

        public Object[] newArray(int i) {
            return new BinData[i];
        }
    };
    public String mCommercial;
    public String mCountryOfIssuance;
    public String mDebit;
    public String mDurbinRegulated;
    public String mHealthcare;
    public String mIssuingBank;
    public String mPayroll;
    public String mPrepaid;
    public String mProductId;

    public BinData() {
    }

    public static String convertNullToUnknown(JSONObject jSONObject, String str) {
        if (jSONObject.has(str) && jSONObject.isNull(str)) {
            return Constants.DOWNLOAD_STATUS_UNKNOWN;
        }
        String str2 = "";
        if (!jSONObject.isNull(str)) {
            str2 = jSONObject.optString(str, str2);
        }
        return str2;
    }

    public static BinData fromJson(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        BinData binData = new BinData();
        boolean isNull = jSONObject.isNull("prepaid");
        String str6 = Constants.DOWNLOAD_STATUS_UNKNOWN;
        if (isNull) {
            str = str6;
        } else {
            str = jSONObject.optString("prepaid", str6);
        }
        binData.mPrepaid = str;
        if (jSONObject.isNull("healthcare")) {
            str2 = str6;
        } else {
            str2 = jSONObject.optString("healthcare", str6);
        }
        binData.mHealthcare = str2;
        if (jSONObject.isNull("debit")) {
            str3 = str6;
        } else {
            str3 = jSONObject.optString("debit", str6);
        }
        binData.mDebit = str3;
        if (jSONObject.isNull("durbinRegulated")) {
            str4 = str6;
        } else {
            str4 = jSONObject.optString("durbinRegulated", str6);
        }
        binData.mDurbinRegulated = str4;
        if (jSONObject.isNull("commercial")) {
            str5 = str6;
        } else {
            str5 = jSONObject.optString("commercial", str6);
        }
        binData.mCommercial = str5;
        if (!jSONObject.isNull("payroll")) {
            str6 = jSONObject.optString("payroll", str6);
        }
        binData.mPayroll = str6;
        binData.mIssuingBank = convertNullToUnknown(jSONObject, "issuingBank");
        binData.mCountryOfIssuance = convertNullToUnknown(jSONObject, "countryOfIssuance");
        binData.mProductId = convertNullToUnknown(jSONObject, RoutingConstants.KILLBILL_TPSL_PRODUCT_ID);
        return binData;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPrepaid);
        parcel.writeString(this.mHealthcare);
        parcel.writeString(this.mDebit);
        parcel.writeString(this.mDurbinRegulated);
        parcel.writeString(this.mCommercial);
        parcel.writeString(this.mPayroll);
        parcel.writeString(this.mIssuingBank);
        parcel.writeString(this.mCountryOfIssuance);
        parcel.writeString(this.mProductId);
    }

    public BinData(Parcel parcel, AnonymousClass1 r2) {
        this.mPrepaid = parcel.readString();
        this.mHealthcare = parcel.readString();
        this.mDebit = parcel.readString();
        this.mDurbinRegulated = parcel.readString();
        this.mCommercial = parcel.readString();
        this.mPayroll = parcel.readString();
        this.mIssuingBank = parcel.readString();
        this.mCountryOfIssuance = parcel.readString();
        this.mProductId = parcel.readString();
    }
}
