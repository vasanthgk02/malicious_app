package com.mpl.payment.gopay;

import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutCallback;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutError;
import com.midtrans.sdk.gopaycheckout.core.transaction.TransactionResponse;
import com.mpl.payment.routing.PaymentResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/mpl/payment/gopay/GoPayPaymentProcessor$processPayment$goPayCallback$1", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutCallback;", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionResponse;", "onFailure", "", "error", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError;", "errorResponse", "onResponse", "response", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoPayPaymentProcessor.kt */
public final class GoPayPaymentProcessor$processPayment$goPayCallback$1 implements GoPayCheckoutCallback<TransactionResponse> {
    public final /* synthetic */ GoPayPaymentProcessor this$0;

    public GoPayPaymentProcessor$processPayment$goPayCallback$1(GoPayPaymentProcessor goPayPaymentProcessor) {
        this.this$0 = goPayPaymentProcessor;
    }

    public void onFailure(GoPayCheckoutError goPayCheckoutError, TransactionResponse transactionResponse) {
        Intrinsics.checkNotNullParameter(goPayCheckoutError, "error");
        try {
            String errorMessage = GoPayUtils.Companion.getErrorMessage(goPayCheckoutError, transactionResponse);
            PaymentResultListener listener = this.this$0.getListener();
            listener.onMoneyInFailed(this.this$0.getTAG() + " payment failed with error--> " + errorMessage);
        } catch (Exception e2) {
            PaymentResultListener listener2 = this.this$0.getListener();
            StringBuilder sb = new StringBuilder();
            sb.append(this.this$0.getTAG());
            sb.append(' ');
            String message = e2.getMessage();
            if (message == null) {
                message = "Exception when handling onFailure";
            }
            sb.append(message);
            listener2.onMoneyInFailed(sb.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
        if (r0.equals("PENDING") != false) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResponse(com.midtrans.sdk.gopaycheckout.core.transaction.TransactionResponse r4) {
        /*
            r3 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r4 = r4.getTransactionStatus()     // Catch:{ Exception -> 0x0076 }
            if (r4 == 0) goto L_0x0015
            java.lang.String r0 = r4.toUpperCase()     // Catch:{ Exception -> 0x0076 }
            java.lang.String r1 = "(this as java.lang.String).toUpperCase()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x0076 }
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 != 0) goto L_0x0039
            com.mpl.payment.gopay.GoPayPaymentProcessor r4 = r3.this$0     // Catch:{ Exception -> 0x0076 }
            com.mpl.payment.routing.PaymentResultListener r4 = r4.getListener()     // Catch:{ Exception -> 0x0076 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0076 }
            r0.<init>()     // Catch:{ Exception -> 0x0076 }
            com.mpl.payment.gopay.GoPayPaymentProcessor r1 = r3.this$0     // Catch:{ Exception -> 0x0076 }
            java.lang.String r1 = r1.getTAG()     // Catch:{ Exception -> 0x0076 }
            r0.append(r1)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r1 = " payment failed null status received"
            r0.append(r1)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0076 }
            r4.onMoneyInFailed(r0)     // Catch:{ Exception -> 0x0076 }
            goto L_0x00a3
        L_0x0039:
            int r1 = r0.hashCode()     // Catch:{ Exception -> 0x0076 }
            r2 = 35394935(0x21c1577, float:1.146723E-37)
            if (r1 == r2) goto L_0x0051
            r2 = 558921001(0x21507529, float:7.06282E-19)
            if (r1 == r2) goto L_0x0048
            goto L_0x005f
        L_0x0048:
            java.lang.String r1 = "SETTLEMENT"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0076 }
            if (r0 == 0) goto L_0x005f
            goto L_0x0059
        L_0x0051:
            java.lang.String r1 = "PENDING"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0076 }
            if (r0 == 0) goto L_0x005f
        L_0x0059:
            com.mpl.payment.gopay.GoPayPaymentProcessor r4 = r3.this$0     // Catch:{ Exception -> 0x0076 }
            r4.sendPending()     // Catch:{ Exception -> 0x0076 }
            goto L_0x00a3
        L_0x005f:
            com.mpl.payment.gopay.GoPayPaymentProcessor r0 = r3.this$0     // Catch:{ Exception -> 0x0076 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0076 }
            r1.<init>()     // Catch:{ Exception -> 0x0076 }
            java.lang.String r2 = "transaction status was "
            r1.append(r2)     // Catch:{ Exception -> 0x0076 }
            r1.append(r4)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x0076 }
            r0.sendFailed(r4)     // Catch:{ Exception -> 0x0076 }
            goto L_0x00a3
        L_0x0076:
            r4 = move-exception
            com.mpl.payment.gopay.GoPayPaymentProcessor r0 = r3.this$0
            com.mpl.payment.routing.PaymentResultListener r0 = r0.getListener()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.mpl.payment.gopay.GoPayPaymentProcessor r2 = r3.this$0
            java.lang.String r2 = r2.getTAG()
            r1.append(r2)
            r2 = 32
            r1.append(r2)
            java.lang.String r4 = r4.getMessage()
            if (r4 == 0) goto L_0x0097
            goto L_0x0099
        L_0x0097:
            java.lang.String r4 = "Exception when handling onResponse"
        L_0x0099:
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.onMoneyInFailed(r4)
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.gopay.GoPayPaymentProcessor$processPayment$goPayCallback$1.onResponse(com.midtrans.sdk.gopaycheckout.core.transaction.TransactionResponse):void");
    }
}
