package com.mpl.payment.common.cardinput;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.request.MOKHttpPostRequest;
import com.mpl.network.modules.request.MOKHttpPostRequest.Builder;
import com.mpl.payment.common.AuthTokenProvider;
import com.mpl.payment.common.cardinput.models.CardInputReactPayload;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0002J\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0014\u0010\r\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006$"}, d2 = {"Lcom/mpl/payment/common/cardinput/MPLEndpointCardInputRouter;", "Lcom/mpl/payment/common/cardinput/CardInputRouter;", "routingUrl", "", "reactPayload", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "moshi", "Lcom/squareup/moshi/Moshi;", "authTokenProvider", "Lcom/mpl/payment/common/AuthTokenProvider;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/squareup/moshi/Moshi;Lcom/mpl/payment/common/AuthTokenProvider;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getAuthTokenProvider", "()Lcom/mpl/payment/common/AuthTokenProvider;", "getHeaders", "()Ljava/util/List;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getReactPayload", "getRoutingUrl", "getCardInputType", "Lcom/mpl/payment/common/cardinput/CardInputType;", "plugin", "processPostResponse", "", "postResponse", "routingListener", "Lcom/mpl/payment/common/cardinput/CardInputRoutingListener;", "processRoutingPayload", "payload", "Lorg/json/JSONObject;", "routeCardInput", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: MPLEndpointCardInputRouter.kt */
public final class MPLEndpointCardInputRouter implements CardInputRouter {
    public final String TAG = "MPLEndpointCardInputRouter";
    public final AuthTokenProvider authTokenProvider;
    public final List<MHeader> headers;
    public final Moshi moshi;
    public final String reactPayload;
    public final String routingUrl;

    public MPLEndpointCardInputRouter(String str, String str2, List<MHeader> list, Moshi moshi2, AuthTokenProvider authTokenProvider2) {
        Intrinsics.checkNotNullParameter(str, "routingUrl");
        Intrinsics.checkNotNullParameter(str2, "reactPayload");
        Intrinsics.checkNotNullParameter(list, Constant.HEADER);
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(authTokenProvider2, "authTokenProvider");
        this.routingUrl = str;
        this.reactPayload = str2;
        this.headers = list;
        this.moshi = moshi2;
        this.authTokenProvider = authTokenProvider2;
    }

    private final CardInputType getCardInputType(String str) {
        if (str.hashCode() == 1692482604 && str.equals("killbill-braintree")) {
            return CardInputType.BRAINTREE_HOSTED_FIELD;
        }
        return CardInputType.UNKNOWN;
    }

    /* access modifiers changed from: private */
    public final void processPostResponse(String str, CardInputRoutingListener cardInputRoutingListener) {
        if (str != null) {
            try {
                boolean z = true;
                if (str.length() > 0) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.has("status") || !jSONObject.optJSONObject("status").has("code")) {
                        cardInputRoutingListener.onRoutingFailed("status or code not found in " + str);
                        return;
                    } else if (jSONObject.optJSONObject("status").optInt("code") != 200) {
                        String optString = jSONObject.optJSONObject("status").optString("message");
                        if (optString != null) {
                            if (!CharsKt__CharKt.isBlank(optString)) {
                                z = false;
                            }
                        }
                        if (!z) {
                            cardInputRoutingListener.onRoutingFailed(optString);
                            return;
                        }
                        cardInputRoutingListener.onRoutingFailed("code not 200 in " + str);
                        return;
                    } else if (jSONObject.has("payload")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("payload");
                        if (optJSONObject == null) {
                            optJSONObject = new JSONObject();
                        }
                        processRoutingPayload(optJSONObject, cardInputRoutingListener);
                        return;
                    } else {
                        cardInputRoutingListener.onRoutingFailed("payload missing in " + str);
                        return;
                    }
                }
            } catch (Exception e2) {
                String message = e2.getMessage();
                if (message == null) {
                    message = GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " exception when processing fetch-client-sdk-init-params response");
                }
                cardInputRoutingListener.onRoutingFailed(message);
                return;
            }
        }
        cardInputRoutingListener.onRoutingFailed("Routing response was null or empty");
    }

    private final void processRoutingPayload(JSONObject jSONObject, CardInputRoutingListener cardInputRoutingListener) {
        if (jSONObject.has("plugin")) {
            String optString = jSONObject.optString("plugin");
            Intrinsics.checkNotNullExpressionValue(optString, "payload.optString(\"plugin\")");
            CardInputType cardInputType = getCardInputType(optString);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "payload.toString()");
            cardInputRoutingListener.onRoutingSuccess(cardInputType, jSONObject2);
            return;
        }
        cardInputRoutingListener.onRoutingFailed(this.TAG + " plugin not found in the routing payload");
    }

    public final AuthTokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public final List<MHeader> getHeaders() {
        return this.headers;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final String getReactPayload() {
        return this.reactPayload;
    }

    public final String getRoutingUrl() {
        return this.routingUrl;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public void routeCardInput(CardInputRoutingListener cardInputRoutingListener) {
        Intrinsics.checkNotNullParameter(cardInputRoutingListener, "routingListener");
        JsonAdapter<CardInputReactPayload> adapter = this.moshi.adapter(CardInputReactPayload.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(CardInputReactPayload::class.java)");
        String json = adapter.toJson((CardInputReactPayload) adapter.fromJson(this.reactPayload));
        Builder addHeader = new Builder().setUrl(this.routingUrl).setHeaders(ArraysKt___ArraysJvmKt.toMutableList((Collection<? extends T>) this.headers)).addHeader(this.authTokenProvider.getAuthHeader());
        if (json != null) {
            MOKHttpPostRequest build = addHeader.setPostJsonObject(json).setRetryOnConnectionFailure(true).setResponseListener(new MPLEndpointCardInputRouter$routeCardInput$serverRequest$1(this, cardInputRoutingListener)).build();
            Intrinsics.checkNotNullExpressionValue(build, "MOKHttpPostRequest.Build…\n                .build()");
            MClient.executeAsync(build);
            return;
        }
        throw new Exception("routing payload was null");
    }
}
