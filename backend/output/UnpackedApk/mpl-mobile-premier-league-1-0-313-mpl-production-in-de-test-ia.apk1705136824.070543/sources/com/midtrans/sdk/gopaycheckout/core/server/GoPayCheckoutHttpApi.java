package com.midtrans.sdk.gopaycheckout.core.server;

import com.midtrans.sdk.gopaycheckout.core.account.AccountResponse;
import com.midtrans.sdk.gopaycheckout.core.account.LinkAccountRequest;
import com.midtrans.sdk.gopaycheckout.core.transaction.SingleMetadata;
import com.midtrans.sdk.gopaycheckout.core.transaction.TransactionRequest;
import com.midtrans.sdk.gopaycheckout.core.transaction.TransactionResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Callback;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ2\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012J\u001c\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00100\fJ\u001c\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00100\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/server/GoPayCheckoutHttpApi;", "", "goPayCheckoutApi", "Lcom/midtrans/sdk/gopaycheckout/core/server/GoPayCheckoutApi;", "(Lcom/midtrans/sdk/gopaycheckout/core/server/GoPayCheckoutApi;)V", "createTransaction", "", "transactionRequest", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionRequest;", "idempotencyKey", "", "callback", "Lretrofit2/Callback;", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionResponse;", "disableAccount", "accountId", "Lcom/midtrans/sdk/gopaycheckout/core/account/AccountResponse;", "metadata", "", "enquireAccount", "linkAccount", "request", "Lcom/midtrans/sdk/gopaycheckout/core/account/LinkAccountRequest;", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class GoPayCheckoutHttpApi {
    public final GoPayCheckoutApi goPayCheckoutApi;

    public GoPayCheckoutHttpApi(GoPayCheckoutApi goPayCheckoutApi2) {
        Intrinsics.checkParameterIsNotNull(goPayCheckoutApi2, "goPayCheckoutApi");
        this.goPayCheckoutApi = goPayCheckoutApi2;
    }

    public static /* synthetic */ void createTransaction$default(GoPayCheckoutHttpApi goPayCheckoutHttpApi, TransactionRequest transactionRequest, String str, Callback callback, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        goPayCheckoutHttpApi.createTransaction(transactionRequest, str, callback);
    }

    public final void createTransaction(TransactionRequest transactionRequest, String str, Callback<TransactionResponse> callback) {
        Intrinsics.checkParameterIsNotNull(transactionRequest, "transactionRequest");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        (str == null || str.length() == 0 ? this.goPayCheckoutApi.createTransaction(transactionRequest) : this.goPayCheckoutApi.createIdempotencyTransaction(transactionRequest, str)).enqueue(callback);
    }

    public final void disableAccount(String str, Callback<AccountResponse> callback, Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "accountId");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.goPayCheckoutApi.disableAccount(str, new SingleMetadata(map)).enqueue(callback);
    }

    public final void enquireAccount(String str, Callback<AccountResponse> callback) {
        Intrinsics.checkParameterIsNotNull(str, "accountId");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.goPayCheckoutApi.enquireAccount(str).enqueue(callback);
    }

    public final void linkAccount(LinkAccountRequest linkAccountRequest, Callback<AccountResponse> callback) {
        Intrinsics.checkParameterIsNotNull(linkAccountRequest, "request");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.goPayCheckoutApi.linkAccount(linkAccountRequest).enqueue(callback);
    }
}
