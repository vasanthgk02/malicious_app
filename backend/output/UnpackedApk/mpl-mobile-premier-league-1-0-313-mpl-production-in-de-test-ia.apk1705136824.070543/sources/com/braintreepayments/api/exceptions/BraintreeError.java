package com.braintreepayments.api.exceptions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amazon.apay.hardened.external.model.APayConstants.Error;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BraintreeError implements Parcelable {
    public static final Creator<BraintreeError> CREATOR = new Creator<BraintreeError>() {
        public Object createFromParcel(Parcel parcel) {
            return new BraintreeError(parcel);
        }

        public Object[] newArray(int i) {
            return new BraintreeError[i];
        }
    };
    public String mField;
    public List<BraintreeError> mFieldErrors;
    public String mMessage;

    public BraintreeError() {
    }

    public static void addGraphQLFieldError(List<String> list, JSONObject jSONObject, List<BraintreeError> list2) throws JSONException {
        String str = list.get(0);
        if (list.size() == 1) {
            BraintreeError braintreeError = new BraintreeError();
            braintreeError.mField = str;
            braintreeError.mMessage = jSONObject.getString("message");
            braintreeError.mFieldErrors = new ArrayList();
            list2.add(braintreeError);
            return;
        }
        BraintreeError braintreeError2 = null;
        List<String> subList = list.subList(1, list.size());
        for (BraintreeError next : list2) {
            if (next.mField.equals(str)) {
                braintreeError2 = next;
            }
        }
        if (braintreeError2 == null) {
            braintreeError2 = new BraintreeError();
            braintreeError2.mField = str;
            braintreeError2.mFieldErrors = new ArrayList();
            list2.add(braintreeError2);
        }
        addGraphQLFieldError(subList, jSONObject, braintreeError2.mFieldErrors);
    }

    public static List<BraintreeError> fromGraphQLJsonArray(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONObject optJSONObject = jSONObject.optJSONObject("extensions");
                if (optJSONObject != null) {
                    if ("user_error".equals(optJSONObject.optString(Error.ERROR_TYPE))) {
                        ArrayList arrayList2 = new ArrayList();
                        JSONArray jSONArray2 = optJSONObject.getJSONArray("inputPath");
                        for (int i2 = 1; i2 < jSONArray2.length(); i2++) {
                            arrayList2.add(jSONArray2.getString(i2));
                        }
                        addGraphQLFieldError(arrayList2, jSONObject, arrayList);
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    public static List<BraintreeError> fromJsonArray(JSONArray jSONArray) {
        String str;
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                BraintreeError braintreeError = new BraintreeError();
                String str2 = null;
                if (jSONObject.isNull(HSLCriteriaBuilder.FIELD)) {
                    str = null;
                } else {
                    str = jSONObject.optString(HSLCriteriaBuilder.FIELD, null);
                }
                braintreeError.mField = str;
                if (!jSONObject.isNull("message")) {
                    str2 = jSONObject.optString("message", null);
                }
                braintreeError.mMessage = str2;
                braintreeError.mFieldErrors = fromJsonArray(jSONObject.optJSONArray("fieldErrors"));
                arrayList.add(braintreeError);
            } catch (JSONException unused) {
            }
        }
        return arrayList;
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

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("BraintreeError for ");
        outline73.append(this.mField);
        outline73.append(": ");
        outline73.append(this.mMessage);
        outline73.append(" -> ");
        List<BraintreeError> list = this.mFieldErrors;
        outline73.append(list != null ? list.toString() : "");
        return outline73.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mField);
        parcel.writeString(this.mMessage);
        parcel.writeTypedList(this.mFieldErrors);
    }

    public BraintreeError(Parcel parcel) {
        this.mField = parcel.readString();
        this.mMessage = parcel.readString();
        this.mFieldErrors = parcel.createTypedArrayList(CREATOR);
    }
}
