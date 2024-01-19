package com.midtrans.sdk.gopaycheckout.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/midtrans/sdk/gopaycheckout/core/GoPayCheckoutClient$createInternalCallback$1", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutCallback;", "onFailure", "", "error", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError;", "errorResponse", "(Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError;Ljava/lang/Object;)V", "onResponse", "response", "(Ljava/lang/Object;)V", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class GoPayCheckoutClient$createInternalCallback$1 implements GoPayCheckoutCallback<T> {
    public final /* synthetic */ GoPayCheckoutCallback $callback;

    public GoPayCheckoutClient$createInternalCallback$1(GoPayCheckoutCallback goPayCheckoutCallback) {
        this.$callback = goPayCheckoutCallback;
    }

    public void onFailure(GoPayCheckoutError goPayCheckoutError, T t) {
        Intrinsics.checkParameterIsNotNull(goPayCheckoutError, "error");
        this.$callback.onFailure(goPayCheckoutError, t);
        GoPayCheckoutState.INSTANCE.setExecutable(true);
    }

    public void onResponse(T t) {
        this.$callback.onResponse(t);
        GoPayCheckoutState.INSTANCE.setExecutable(true);
    }
}
