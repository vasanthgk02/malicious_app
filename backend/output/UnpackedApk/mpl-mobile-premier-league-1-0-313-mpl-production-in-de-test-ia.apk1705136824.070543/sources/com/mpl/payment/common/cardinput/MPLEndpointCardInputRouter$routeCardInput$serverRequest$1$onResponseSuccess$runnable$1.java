package com.mpl.payment.common.cardinput;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: MPLEndpointCardInputRouter.kt */
public final class MPLEndpointCardInputRouter$routeCardInput$serverRequest$1$onResponseSuccess$runnable$1 implements Runnable {
    public final /* synthetic */ String $postResponse;
    public final /* synthetic */ MPLEndpointCardInputRouter$routeCardInput$serverRequest$1 this$0;

    public MPLEndpointCardInputRouter$routeCardInput$serverRequest$1$onResponseSuccess$runnable$1(MPLEndpointCardInputRouter$routeCardInput$serverRequest$1 mPLEndpointCardInputRouter$routeCardInput$serverRequest$1, String str) {
        this.this$0 = mPLEndpointCardInputRouter$routeCardInput$serverRequest$1;
        this.$postResponse = str;
    }

    public final void run() {
        try {
            this.this$0.this$0.processPostResponse(this.$postResponse, this.this$0.$routingListener);
        } catch (Exception e2) {
            CardInputRoutingListener cardInputRoutingListener = this.this$0.$routingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(this.this$0.this$0.getTAG());
            sb.append(' ');
            String message = e2.getMessage();
            if (message == null) {
                message = "Exception when processing card input routing response";
            }
            sb.append(message);
            cardInputRoutingListener.onRoutingFailed(sb.toString());
        }
    }
}
