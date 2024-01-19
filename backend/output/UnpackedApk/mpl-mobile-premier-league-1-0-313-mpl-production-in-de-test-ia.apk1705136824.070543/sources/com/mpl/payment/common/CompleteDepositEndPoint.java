package com.mpl.payment.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.request.MOKHttpPostRequest;
import com.mpl.network.modules.request.MOKHttpPostRequest.Builder;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u0006\u0010\u0018\u001a\u00020\u0019R\u0014\u0010\r\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/mpl/payment/common/CompleteDepositEndPoint;", "", "completeDepositUrl", "", "endpointResultListener", "Lcom/mpl/payment/common/EndpointResultListener;", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "authTokenProvider", "Lcom/mpl/payment/common/AuthTokenProvider;", "payload", "(Ljava/lang/String;Lcom/mpl/payment/common/EndpointResultListener;Ljava/util/List;Lcom/mpl/payment/common/AuthTokenProvider;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getAuthTokenProvider", "()Lcom/mpl/payment/common/AuthTokenProvider;", "getCompleteDepositUrl", "getEndpointResultListener", "()Lcom/mpl/payment/common/EndpointResultListener;", "getHeaders", "()Ljava/util/List;", "getPayload", "completeDeposit", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CompleteDepositEndPoint.kt */
public final class CompleteDepositEndPoint {
    public final String TAG = "CompleteDepositEndPoint";
    public final AuthTokenProvider authTokenProvider;
    public final String completeDepositUrl;
    public final EndpointResultListener endpointResultListener;
    public final List<MHeader> headers;
    public final String payload;

    public CompleteDepositEndPoint(String str, EndpointResultListener endpointResultListener2, List<MHeader> list, AuthTokenProvider authTokenProvider2, String str2) {
        Intrinsics.checkNotNullParameter(str, "completeDepositUrl");
        Intrinsics.checkNotNullParameter(endpointResultListener2, "endpointResultListener");
        Intrinsics.checkNotNullParameter(list, Constant.HEADER);
        Intrinsics.checkNotNullParameter(authTokenProvider2, "authTokenProvider");
        Intrinsics.checkNotNullParameter(str2, "payload");
        this.completeDepositUrl = str;
        this.endpointResultListener = endpointResultListener2;
        this.headers = list;
        this.authTokenProvider = authTokenProvider2;
        this.payload = str2;
    }

    public final void completeDeposit() {
        try {
            MOKHttpPostRequest build = new Builder().setUrl(this.completeDepositUrl).setResponseListener(new CompleteDepositEndPoint$completeDeposit$serverRequest$1(this)).setHeaders(ArraysKt___ArraysJvmKt.toMutableList((Collection<? extends T>) this.headers)).addHeader(this.authTokenProvider.getAuthHeader()).setPostJsonObject(this.payload).setRetryOnConnectionFailure(true).build();
            Intrinsics.checkNotNullExpressionValue(build, "MOKHttpPostRequest.Build…                 .build()");
            MClient.executeAsync(build);
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception in complete deposit ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            outline73.append(message);
            this.endpointResultListener.onFail(outline73.toString());
        }
    }

    public final AuthTokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public final String getCompleteDepositUrl() {
        return this.completeDepositUrl;
    }

    public final EndpointResultListener getEndpointResultListener() {
        return this.endpointResultListener;
    }

    public final List<MHeader> getHeaders() {
        return this.headers;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final String getTAG() {
        return this.TAG;
    }
}
