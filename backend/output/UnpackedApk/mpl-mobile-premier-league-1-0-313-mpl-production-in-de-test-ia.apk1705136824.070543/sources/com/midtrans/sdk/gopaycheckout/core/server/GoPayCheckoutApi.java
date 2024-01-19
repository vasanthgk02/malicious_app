package com.midtrans.sdk.gopaycheckout.core.server;

import com.midtrans.sdk.gopaycheckout.core.account.AccountResponse;
import com.midtrans.sdk.gopaycheckout.core.account.LinkAccountRequest;
import com.midtrans.sdk.gopaycheckout.core.transaction.SingleMetadata;
import com.midtrans.sdk.gopaycheckout.core.transaction.TransactionRequest;
import com.midtrans.sdk.gopaycheckout.core.transaction.TransactionResponse;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000eH'J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\bH'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0012H'¨\u0006\u0013"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/server/GoPayCheckoutApi;", "", "createIdempotencyTransaction", "Lretrofit2/Call;", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionResponse;", "request", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionRequest;", "idempotencyKey", "", "createTransaction", "disableAccount", "Lcom/midtrans/sdk/gopaycheckout/core/account/AccountResponse;", "accountId", "metadata", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/SingleMetadata;", "enquireAccount", "linkAccount", "linkAccountRequest", "Lcom/midtrans/sdk/gopaycheckout/core/account/LinkAccountRequest;", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public interface GoPayCheckoutApi {
    @POST("v2/charge")
    Call<TransactionResponse> createIdempotencyTransaction(@Body TransactionRequest transactionRequest, @Header("Idempotency-Key") String str);

    @POST("v2/charge")
    Call<TransactionResponse> createTransaction(@Body TransactionRequest transactionRequest);

    @POST("v2/pay/account/{account_id}/unbind")
    Call<AccountResponse> disableAccount(@Path("account_id") String str, @Body SingleMetadata singleMetadata);

    @GET("v2/pay/account/{account_id}")
    Call<AccountResponse> enquireAccount(@Path("account_id") String str);

    @POST("v2/pay/account")
    Call<AccountResponse> linkAccount(@Body LinkAccountRequest linkAccountRequest);
}
