package com.paypal.android.sdk.onetouch.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.paypal.android.sdk.onetouch.core.enums.ResponseType;
import com.paypal.android.sdk.onetouch.core.enums.ResultType;
import org.json.JSONObject;

public final class Result implements Parcelable {
    public static final Creator<Result> CREATOR = new Creator<Result>() {
        public Object createFromParcel(Parcel parcel) {
            return new Result(parcel, null);
        }

        public Object[] newArray(int i) {
            return new Result[i];
        }
    };
    public static final String TAG = Result.class.getSimpleName();
    public final String mEnvironment;
    public final Throwable mError;
    public final JSONObject mResponse;
    public final ResponseType mResponseType;
    public final ResultType mResultType;
    public final String mUserEmail;

    public Result(String str, ResponseType responseType, JSONObject jSONObject, String str2) {
        this(ResultType.Success, str, responseType, jSONObject, str2, null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mEnvironment);
        parcel.writeSerializable(this.mResultType);
        parcel.writeSerializable(this.mResponseType);
        JSONObject jSONObject = this.mResponse;
        parcel.writeString(jSONObject == null ? null : jSONObject.toString());
        parcel.writeString(this.mUserEmail);
        parcel.writeSerializable(this.mError);
    }

    public Result(Throwable th) {
        this(ResultType.Error, null, null, null, null, th);
    }

    public Result() {
        this(ResultType.Cancel, null, null, null, null, null);
    }

    public Result(ResultType resultType, String str, ResponseType responseType, JSONObject jSONObject, String str2, Throwable th) {
        this.mEnvironment = str;
        this.mResultType = resultType;
        this.mResponseType = responseType;
        this.mResponse = jSONObject;
        this.mUserEmail = str2;
        this.mError = th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0025, code lost:
        r4 = new org.json.JSONObject(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Result(android.os.Parcel r3, com.paypal.android.sdk.onetouch.core.Result.AnonymousClass1 r4) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.String r4 = r3.readString()
            r2.mEnvironment = r4
            java.io.Serializable r4 = r3.readSerializable()
            com.paypal.android.sdk.onetouch.core.enums.ResultType r4 = (com.paypal.android.sdk.onetouch.core.enums.ResultType) r4
            r2.mResultType = r4
            java.io.Serializable r4 = r3.readSerializable()
            com.paypal.android.sdk.onetouch.core.enums.ResponseType r4 = (com.paypal.android.sdk.onetouch.core.enums.ResponseType) r4
            r2.mResponseType = r4
            r4 = 0
            java.lang.String r0 = r3.readString()     // Catch:{ JSONException -> 0x0026 }
            if (r0 == 0) goto L_0x0026
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0026 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x0026 }
            r4 = r1
        L_0x0026:
            r2.mResponse = r4
            java.lang.String r4 = r3.readString()
            r2.mUserEmail = r4
            java.io.Serializable r3 = r3.readSerializable()
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r2.mError = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.onetouch.core.Result.<init>(android.os.Parcel, com.paypal.android.sdk.onetouch.core.Result$1):void");
    }
}
