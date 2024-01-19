package com.mpl.payment.juspayhypersdk.model;

import in.juspay.services.HyperServices;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/model/RequestDetails;", "", "requestPayload", "Lorg/json/JSONObject;", "requestId", "", "(Lorg/json/JSONObject;Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "getRequestPayload", "()Lorg/json/JSONObject;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: RequestDetails.kt */
public final class RequestDetails {
    public final String requestId;
    public final JSONObject requestPayload;

    public RequestDetails(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "requestPayload");
        Intrinsics.checkNotNullParameter(str, HyperServices.REQUEST_ID);
        this.requestPayload = jSONObject;
        this.requestId = str;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final JSONObject getRequestPayload() {
        return this.requestPayload;
    }
}
