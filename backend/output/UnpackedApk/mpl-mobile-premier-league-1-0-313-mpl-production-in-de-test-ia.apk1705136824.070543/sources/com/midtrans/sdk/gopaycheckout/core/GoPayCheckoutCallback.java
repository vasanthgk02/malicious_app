package com.midtrans.sdk.gopaycheckout.core;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutCallback;", "T", "", "onFailure", "", "error", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError;", "errorResponse", "(Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError;Ljava/lang/Object;)V", "onResponse", "response", "(Ljava/lang/Object;)V", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public interface GoPayCheckoutCallback<T> {
    void onFailure(GoPayCheckoutError goPayCheckoutError, T t);

    void onResponse(T t);
}
