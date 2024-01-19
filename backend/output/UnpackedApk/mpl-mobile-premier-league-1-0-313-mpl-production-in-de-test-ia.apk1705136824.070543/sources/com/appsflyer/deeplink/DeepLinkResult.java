package com.appsflyer.deeplink;

import org.json.JSONException;
import org.json.JSONObject;

public class DeepLinkResult {
    public final DeepLink deepLink;
    public final Error error;
    public final Status status;

    public enum Error {
        TIMEOUT,
        NETWORK,
        HTTP_STATUS_CODE,
        UNEXPECTED,
        DEVELOPER_ERROR
    }

    public enum Status {
        FOUND,
        NOT_FOUND,
        ERROR
    }

    public DeepLinkResult(DeepLink deepLink2, Error error2) {
        this.deepLink = deepLink2;
        this.error = error2;
        if (error2 != null) {
            this.status = Status.ERROR;
        } else if (deepLink2 != null) {
            this.status = Status.FOUND;
        } else {
            this.status = Status.NOT_FOUND;
        }
    }

    public DeepLink getDeepLink() {
        return this.deepLink;
    }

    public Error getError() {
        return this.error;
    }

    public Status getStatus() {
        return this.status;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deepLink", this.deepLink);
            jSONObject.put("error", this.error);
            jSONObject.put("status", this.status);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
