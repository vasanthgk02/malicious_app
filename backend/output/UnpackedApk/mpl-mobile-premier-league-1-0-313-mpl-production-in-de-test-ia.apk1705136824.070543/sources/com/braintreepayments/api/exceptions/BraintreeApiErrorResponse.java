package com.braintreepayments.api.exceptions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import co.hyperverge.hypersnapsdk.c.k;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BraintreeApiErrorResponse extends Exception implements Parcelable {
    public static final Creator<BraintreeApiErrorResponse> CREATOR = new Creator<BraintreeApiErrorResponse>() {
        public Object createFromParcel(Parcel parcel) {
            return new BraintreeApiErrorResponse(parcel);
        }

        public Object[] newArray(int i) {
            return new BraintreeApiErrorResponse[i];
        }
    };
    public List<BraintreeApiError> mErrors;
    public String mMessage;
    public String mOriginalResponse;

    public BraintreeApiErrorResponse(String str) {
        this.mOriginalResponse = str;
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("error");
            this.mMessage = k.optString(jSONObject, "developer_message", "No message was returned");
            JSONArray optJSONArray = jSONObject.optJSONArray("details");
            optJSONArray = optJSONArray == null ? new JSONArray() : optJSONArray;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    arrayList.add(BraintreeApiError.fromJson(optJSONArray.getJSONObject(i)));
                } catch (JSONException unused) {
                }
            }
            this.mErrors = arrayList;
        } catch (JSONException unused2) {
            this.mMessage = "Parsing error response failed";
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mMessage);
        parcel.writeString(this.mOriginalResponse);
        parcel.writeTypedList(this.mErrors);
    }

    public BraintreeApiErrorResponse(Parcel parcel) {
        this.mMessage = parcel.readString();
        this.mOriginalResponse = parcel.readString();
        this.mErrors = parcel.createTypedArrayList(BraintreeApiError.CREATOR);
    }
}
