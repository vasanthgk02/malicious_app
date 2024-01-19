package com.mpl.payment.common.cardinput;

import android.os.Handler;
import android.os.Looper;
import com.mpl.network.modules.listeners.IResponseListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/mpl/payment/common/cardinput/MPLEndpointCardInputRouter$routeCardInput$serverRequest$1", "Lcom/mpl/network/modules/listeners/IResponseListener;", "", "onResponseFail", "", "ex", "Ljava/lang/Exception;", "onResponseSuccess", "postResponse", "progressResponse", "bytesRead", "", "contentLength", "done", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: MPLEndpointCardInputRouter.kt */
public final class MPLEndpointCardInputRouter$routeCardInput$serverRequest$1 extends IResponseListener<String> {
    public final /* synthetic */ CardInputRoutingListener $routingListener;
    public final /* synthetic */ MPLEndpointCardInputRouter this$0;

    public MPLEndpointCardInputRouter$routeCardInput$serverRequest$1(MPLEndpointCardInputRouter mPLEndpointCardInputRouter, CardInputRoutingListener cardInputRoutingListener) {
        this.this$0 = mPLEndpointCardInputRouter;
        this.$routingListener = cardInputRoutingListener;
    }

    public void onResponseFail(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "ex");
        StringBuilder sb = new StringBuilder();
        sb.append("Exception when doing complete deposit ");
        String message = exc.getMessage();
        if (message == null) {
            message = "";
        }
        sb.append(message);
        this.$routingListener.onRoutingFailed(sb.toString());
    }

    public void progressResponse(long j, long j2, boolean z) {
    }

    public void onResponseSuccess(String str) {
        new Handler(Looper.getMainLooper()).post(new MPLEndpointCardInputRouter$routeCardInput$serverRequest$1$onResponseSuccess$runnable$1(this, str));
    }
}
