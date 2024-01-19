package com.mpl.payment.common;

import com.mpl.network.modules.listeners.IResponseListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/mpl/payment/common/CompleteDepositEndPoint$completeDeposit$serverRequest$1", "Lcom/mpl/network/modules/listeners/IResponseListener;", "", "onResponseFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onResponseSuccess", "postResponse", "progressResponse", "bytesRead", "", "contentLength", "done", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CompleteDepositEndPoint.kt */
public final class CompleteDepositEndPoint$completeDeposit$serverRequest$1 extends IResponseListener<String> {
    public final /* synthetic */ CompleteDepositEndPoint this$0;

    public CompleteDepositEndPoint$completeDeposit$serverRequest$1(CompleteDepositEndPoint completeDepositEndPoint) {
        this.this$0 = completeDepositEndPoint;
    }

    public void onResponseFail(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "e");
        StringBuilder sb = new StringBuilder();
        sb.append("Exception when doing complete deposit ");
        String message = exc.getMessage();
        if (message == null) {
            message = "";
        }
        sb.append(message);
        this.this$0.getEndpointResultListener().onFail(sb.toString());
    }

    public void progressResponse(long j, long j2, boolean z) {
    }

    public void onResponseSuccess(String str) {
        if (str != null) {
            if (str.length() > 0) {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("status") || !jSONObject.optJSONObject("status").has("code")) {
                    EndpointResultListener endpointResultListener = this.this$0.getEndpointResultListener();
                    endpointResultListener.onFail("status or code not found in " + str);
                    return;
                } else if (jSONObject.optJSONObject("status").optInt("code") != 200) {
                    EndpointResultListener endpointResultListener2 = this.this$0.getEndpointResultListener();
                    endpointResultListener2.onFail("code not 200 in " + str);
                    return;
                } else if (jSONObject.has("payload")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("payload");
                    EndpointResultListener endpointResultListener3 = this.this$0.getEndpointResultListener();
                    Intrinsics.checkNotNullExpressionValue(optJSONObject, "payload");
                    endpointResultListener3.onSuccess(optJSONObject);
                    return;
                } else {
                    EndpointResultListener endpointResultListener4 = this.this$0.getEndpointResultListener();
                    endpointResultListener4.onFail("payload missing in " + str);
                    return;
                }
            }
        }
        this.this$0.getEndpointResultListener().onFail("complete deposit was either null or empty");
    }
}
