package com.amazon.apay.hardened.external.model;

import android.content.Intent;
import com.amazon.apay.hardened.external.model.APayConstants.Error;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

public class APayError extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public ErrorType f3248a;

    /* renamed from: b  reason: collision with root package name */
    public String f3249b;

    public enum ErrorType {
        AUTH_ERROR,
        PAYMENT_ERROR,
        BROWSING_EXPERIENCE
    }

    public APayError(JSONObject jSONObject) throws JSONException {
        super(jSONObject.getString("message"));
        this.f3248a = ErrorType.valueOf(jSONObject.getString(Error.ERROR_TYPE));
        this.f3249b = jSONObject.getString("code");
    }

    public static APayError fromIntent(Intent intent) {
        if (!(intent == null || intent.getStringExtra("error") == null)) {
            String stringExtra = intent.getStringExtra("error");
            Timber.TREE_OF_SOULS.d("%s", stringExtra);
            try {
                return new APayError(new JSONObject(stringExtra));
            } catch (JSONException e2) {
                Timber.TREE_OF_SOULS.e(e2);
            }
        }
        return null;
    }

    public Intent getApayErrorIntent() {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Error.ERROR_TYPE, this.f3248a);
            jSONObject.put("code", this.f3249b);
            jSONObject.put("message", getMessage());
            intent.putExtra("error", jSONObject.toString());
            return intent;
        } catch (JSONException e2) {
            Timber.TREE_OF_SOULS.e(e2);
            return new Intent();
        }
    }

    public String getCode() {
        return this.f3249b;
    }

    public ErrorType getType() {
        return this.f3248a;
    }

    public APayError(ErrorType errorType, String str, String str2) {
        super(str2);
        this.f3248a = errorType;
        this.f3249b = str;
    }

    public APayError(ErrorType errorType, String str, String str2, Throwable th) {
        super(str2, th);
        this.f3248a = errorType;
        this.f3249b = str;
    }
}
