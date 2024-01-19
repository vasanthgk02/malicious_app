package com.mpl.payment.gopay;

import com.mpl.payment.common.TransactionParamsCreator;
import com.mpl.payment.gopay.models.GoPayTransactionParams;
import com.mpl.payment.gopay.models.GopayTransacrionReactPayload;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/mpl/payment/gopay/GoPayTransactionParamsCreator;", "Lcom/mpl/payment/common/TransactionParamsCreator;", "reactPayloadString", "", "moshi", "Lcom/squareup/moshi/Moshi;", "orderId", "(Ljava/lang/String;Lcom/squareup/moshi/Moshi;Ljava/lang/String;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getOrderId", "()Ljava/lang/String;", "getReactPayloadString", "getTransactionParams", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoPayTransactionParamsCreator.kt */
public final class GoPayTransactionParamsCreator implements TransactionParamsCreator {
    public final Moshi moshi;
    public final String orderId;
    public final String reactPayloadString;

    public GoPayTransactionParamsCreator(String str, Moshi moshi2, String str2) {
        Intrinsics.checkNotNullParameter(str, "reactPayloadString");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(str2, "orderId");
        this.reactPayloadString = str;
        this.moshi = moshi2;
        this.orderId = str2;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getReactPayloadString() {
        return this.reactPayloadString;
    }

    public Object getTransactionParams() {
        JsonAdapter<GopayTransacrionReactPayload> adapter = this.moshi.adapter(GopayTransacrionReactPayload.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(GopayTrans…ReactPayload::class.java)");
        GopayTransacrionReactPayload gopayTransacrionReactPayload = (GopayTransacrionReactPayload) adapter.fromJson(this.reactPayloadString);
        if (gopayTransacrionReactPayload != null) {
            Intrinsics.checkNotNullExpressionValue(gopayTransacrionReactPayload, "transactionReactPayloadA…(\"adapter returned null\")");
            GoPayTransactionParams goPayTransactionParams = new GoPayTransactionParams(gopayTransacrionReactPayload.getMerchantId(), gopayTransacrionReactPayload.getCallBackUrl(), gopayTransacrionReactPayload.getMerchantServerUrl(), gopayTransacrionReactPayload.getSavedPaymentDetails().getAdditionalDetails().getAccountId(), gopayTransacrionReactPayload.getSavedPaymentDetails().getAdditionalDetails().getPaymentOptionToken(), Long.parseLong(gopayTransacrionReactPayload.getAmount()), gopayTransacrionReactPayload.getMobNumber(), gopayTransacrionReactPayload.getCurrency(), this.orderId);
            return goPayTransactionParams;
        }
        throw new Exception("adapter returned null");
    }
}
