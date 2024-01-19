package com.midtrans.sdk.gopaycheckout.core;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/midtrans/sdk/gopaycheckout/core/GoPayCheckoutProcessor$createInternalCallback$1", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutProcessorCallback;", "onCompleted", "", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class GoPayCheckoutProcessor$createInternalCallback$1 implements GoPayCheckoutProcessorCallback {
    public final /* synthetic */ GoPayCheckoutProcessorCallback $callback;

    public GoPayCheckoutProcessor$createInternalCallback$1(GoPayCheckoutProcessorCallback goPayCheckoutProcessorCallback) {
        this.$callback = goPayCheckoutProcessorCallback;
    }

    public void onCompleted() {
        this.$callback.onCompleted();
        GoPayCheckoutState.INSTANCE.setExecutable(true);
    }
}
