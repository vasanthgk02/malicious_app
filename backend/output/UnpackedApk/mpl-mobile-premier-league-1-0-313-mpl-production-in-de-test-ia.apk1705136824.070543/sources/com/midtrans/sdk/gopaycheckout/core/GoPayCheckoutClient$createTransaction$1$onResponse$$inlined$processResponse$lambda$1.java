package com.midtrans.sdk.gopaycheckout.core;

import com.midtrans.sdk.gopaycheckout.core.transaction.TransactionResponse;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/midtrans/sdk/gopaycheckout/core/GoPayCheckoutClient$createTransaction$1$onResponse$1$1", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutProcessorCallback;", "onCompleted", "", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class GoPayCheckoutClient$createTransaction$1$onResponse$$inlined$processResponse$lambda$1 implements GoPayCheckoutProcessorCallback {
    public final /* synthetic */ TransactionResponse $it;
    public final /* synthetic */ GoPayCheckoutClient$createTransaction$1 this$0;

    public GoPayCheckoutClient$createTransaction$1$onResponse$$inlined$processResponse$lambda$1(TransactionResponse transactionResponse, GoPayCheckoutClient$createTransaction$1 goPayCheckoutClient$createTransaction$1) {
        this.$it = transactionResponse;
        this.this$0 = goPayCheckoutClient$createTransaction$1;
    }

    public void onCompleted() {
        this.this$0.$internalCallback.onResponse(this.$it);
    }
}
