package com.braintreepayments.api.exceptions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ErrorWithResponse extends Exception implements Parcelable {
    public static final Creator<ErrorWithResponse> CREATOR = new Creator<ErrorWithResponse>() {
        public Object createFromParcel(Parcel parcel) {
            return new ErrorWithResponse(parcel);
        }

        public Object[] newArray(int i) {
            return new ErrorWithResponse[i];
        }
    };
    public List<BraintreeError> mFieldErrors;
    public String mMessage;
    public String mOriginalResponse;
    public int mStatusCode;

    public ErrorWithResponse(int i, String str) {
        this.mStatusCode = i;
        this.mOriginalResponse = str;
        try {
            parseJson(str);
        } catch (JSONException unused) {
            this.mMessage = "Parsing error response failed";
            this.mFieldErrors = new ArrayList();
        }
    }

    public int describeContents() {
        return 0;
    }

    public BraintreeError errorFor(String str) {
        List<BraintreeError> list = this.mFieldErrors;
        if (list != null) {
            for (BraintreeError next : list) {
                if (next.mField.equals(str)) {
                    return next;
                }
                if (next.mFieldErrors != null) {
                    BraintreeError errorFor = next.errorFor(str);
                    if (errorFor != null) {
                        return errorFor;
                    }
                }
            }
        }
        return null;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public final void parseJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        this.mMessage = jSONObject.getJSONObject("error").getString("message");
        this.mFieldErrors = BraintreeError.fromJsonArray(jSONObject.optJSONArray("fieldErrors"));
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ErrorWithResponse (");
        outline73.append(this.mStatusCode);
        outline73.append("): ");
        outline73.append(this.mMessage);
        outline73.append("\n");
        outline73.append(this.mFieldErrors.toString());
        return outline73.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mStatusCode);
        parcel.writeString(this.mMessage);
        parcel.writeString(this.mOriginalResponse);
        parcel.writeTypedList(this.mFieldErrors);
    }

    public ErrorWithResponse() {
    }

    public ErrorWithResponse(Parcel parcel) {
        this.mStatusCode = parcel.readInt();
        this.mMessage = parcel.readString();
        this.mOriginalResponse = parcel.readString();
        this.mFieldErrors = parcel.createTypedArrayList(BraintreeError.CREATOR);
    }
}
